/*******************************************************************************
 * Copyright (c) 2016 Politecnico di Torino.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Politecnico di Torino - initial API and implementation
 *******************************************************************************/
package eu.aspire_fp7.adss.connectors;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.Preferences;
import eu.aspire_fp7.adss.util.Strings;

/**
 * Magic connector that allows to work with commands and files both on the current platform and on a remote one.
 * @author Daniele Canavese
 **/
public class Runner
{
	/** The ADSS. **/
	private final ADSS adss;
	/** The session object. **/
	private Session session;

	/**
	 * Creates the runner.
	 * @param adss
	 *            The ADSS.
	 */
	public Runner(ADSS adss)
	{
		this.adss = adss;
		session = null;
	}

	/**
	 * Open a session, if needed.
	 * @throws IOException
	 *             If an I/O error occurs.
	 **/
	private void open() throws IOException
	{
		Preferences preferences = adss.getModel().getPreferences();

		if (preferences.isRemoteConnection() && (session == null || !session.isConnected()))
			try
			{
				JSch.setConfig("StrictHostKeyChecking", "no");
				JSch jsch = new JSch();
				session = jsch.getSession(preferences.getRemoteUsername(), preferences.getRemoteHost(), preferences.getRemotePort());
				session.setPassword(preferences.getRemotePassword());
				session.setServerAliveInterval(5000);
				// session.setTimeout(20000);
				session.connect();
			}
			catch (Exception e)
			{
				throw new IOException(e);
			}
	}

	/**
	 * Close a session, if needed.
	 **/
	public void close()
	{
		if (session != null)
		{
			session.disconnect();
			session = null;
		}
	}

	/**
	 * Retrieves the file separator.
	 * @return The file separator.
	 */
	public String getSeparator()
	{
		if (adss.getModel().getPreferences().isRemoteConnection())
			return adss.getModel().getPreferences().getRemoteFileSeparator();
		else
			return File.separator;
	}

	/**
	 * Performs a connection test.
	 * @return A value stating if the test was successful or not.
	 */
	public boolean test()
	{
		Preferences preferences = adss.getModel().getPreferences();
		if (!preferences.isRemoteConnection())
			return false;

		try
		{
			open();
			close();

			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Runs a command.
	 * @param command
	 *            The command to run.
	 * @return The command exit value.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public int run(List<String> command) throws IOException
	{
		return run(command, new StringBuilder());
	}

	/**
	 * Runs a command.
	 * @param command
	 *            The command to run.
	 * @param sb
	 *            The string builder that will store the program stdout or <code>null</code> to not use it.
	 * @return The command exit value.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public int run(List<String> command, StringBuilder sb) throws IOException
	{
		Exception last = null;
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelExec channel = (ChannelExec) session.openChannel("exec");
					StringBuilder c = new StringBuilder();
					for (String j : command)
						if (j.contains(" "))
							c.append(" \"" + j + "\"");
						else
							c.append(" " + j);

					channel.setCommand(c.toString().trim());
					channel.connect();

					BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
					String line;
					while ((line = reader.readLine()) != null)
						sb.append(line + "\n");
					reader.close();

					channel.disconnect();

					return channel.getExitStatus();
				}
				else
				{
					ProcessBuilder processBuilder = new ProcessBuilder(command);
					processBuilder.redirectErrorStream(true);
					processBuilder.inheritIO();

					Process process = processBuilder.start();
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line;
					while ((line = reader.readLine()) != null)
						sb.append(line);
					reader.close();

					return process.waitFor();
				}
			}
			catch (Exception e)
			{
				last = e;
				close();
			}

		throw new IOException(last);
	}

	/**
	 * Reads a file.
	 * @param path
	 *            The file path.
	 * @return The file content.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public String readFile(String path) throws IOException
	{
		Exception last = null;
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
					channel.connect();

					StringBuilder sb = new StringBuilder();
					int c;
					InputStreamReader reader = new InputStreamReader(channel.get(path));
					while ((c = reader.read()) >= 0)
						sb.append((char) c);
					channel.disconnect();
					reader.close();

					return sb.toString();
				}
				else
				{
					List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

					return Strings.join(lines, "");
				}
			}
			catch (Exception e)
			{
				last = e;
				close();
			}

		throw new IOException(last);
	}

	/**
	 * Copies a file.
	 * @param source
	 *            The source file path. It is always a local file.
	 * @param destination
	 *            The destination file path. It might be a local or remote file.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public void copyFile(String source, String destination) throws IOException
	{
		Exception last = null;
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
					channel.connect();

					channel.put(source, destination);

					channel.disconnect();
				}
				else
					Files.copy(Paths.get(source), Paths.get(destination));
				return;
			}
			catch (Exception e)
			{
				last = e;
				close();
			}

		throw new IOException(last);
	}

	/**
	 * Creates a file.
	 * @param destination
	 *            The destination file path. It might be a local or remote file.
	 * @param content
	 *            The file content.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public void createFile(String path, InputStream content) throws IOException
	{
		Exception last = null;
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
					channel.connect();

					channel.put(content, path);

					channel.disconnect();
				}
				else
					Files.copy(content, Paths.get(path));
				return;
			}
			catch (Exception e)
			{
				last = e;
				close();
			}

		throw new IOException(last);
	}

	/**
	 * List the first file in a directory with a certain extension. This method is not recursive.
	 * @param directory
	 *            The directory to scan.
	 * @param extension
	 *            The file extension.
	 * @return The first file with a certain extension or <code>null</code> if no such files exist.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public String listFirstFile(String directory, String extension) throws IOException
	{
		Set<String> files = listFile(directory, extension);
		if (files.isEmpty())
			return null;
		else
			return files.iterator().next();
	}

	/**
	 * Lists all the files in a directory with a certain extension. This method is not recursive.
	 * @param directory
	 *            The directory to scan.
	 * @param extension
	 *            The file extension.
	 * @return The list of files in a directory.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public Set<String> listFile(String directory, String extension) throws IOException
	{
		Set<String> files = new HashSet<>();

		Exception last = null;
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
					channel.connect();

					for (Object j : channel.ls(directory))
						if (j instanceof LsEntry)
						{
							String filename = ((LsEntry) j).getFilename();
							if (filename.endsWith(extension))
								files.add(directory + getSeparator() + filename);
						}

					channel.disconnect();
				}
				else
					for (File j : new File(directory).listFiles())
						if (j.isFile())
						{
							String filename = j.getName();
							if (filename.endsWith(extension))
								files.add(directory + getSeparator() + filename);
						}
				return files;
			}
			catch (Exception e)
			{
				last = e;
				close();
			}

		throw new IOException(last);
	}

	/**
	 * Deletes a file.
	 * @param path
	 *            The file path.
	 */
	public void deleteFile(String path)
	{
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
					channel.connect();

					channel.rm(path);

					channel.disconnect();
				}
				else
					Files.delete(Paths.get(path));
			}
			catch (Exception e)
			{
				close();
			}
	}

	/**
	 * Deletes a directory.
	 * @param path
	 *            The directory path.
	 */
	public void deleteDirectory(String path)
	{
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				open();
				Preferences preferences = adss.getModel().getPreferences();
				if (preferences.isRemoteConnection())
				{
					ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
					channel.connect();

					delete(channel, path);

					channel.disconnect();
				}
				else
					delete(new File(path));
			}
			catch (Exception e)
			{
				close();
			}
	}

	/**
	 * Recursively delete a remote directory.
	 * @param channel
	 *            The channel
	 * @param path
	 *            The directory path.
	 * @throws SftpException
	 *             If something goes wrong.
	 **/
	private void delete(ChannelSftp channel, String path) throws SftpException
	{
		if (channel.stat(path).isDir())
		{
			channel.cd(path);
			@SuppressWarnings("unchecked")
			Vector<LsEntry> entries = channel.ls(".");
			for (LsEntry i : entries)
				if (!i.getFilename().equals(".") && !i.getFilename().equals(".."))
					delete(channel, i.getFilename());
			channel.cd("..");
			channel.rmdir(path);
		}
		else
			channel.rm(path);
	}

	/**
	 * Recursively delete a local directory.
	 * @param file
	 *            The file.
	 **/
	private void delete(File file) throws SftpException
	{
		if (file.isDirectory())
			for (File i : file.listFiles())
				delete(i);
	}

	/** The number of channel tries to perform before giving up. **/
	private static final int MAX_TRIES = 10;
}
