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
package eu.aspire_fp7.adss.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

/**
 * Eclipse utilities.
 * @author Daniele Canavese
 **/
public class Eclipse
{
	/**
	 * Retrieves the elements in an extension point.
	 * @param extensionPoint
	 *            The extension point.
	 * @return The elements registered in the extension point.
	 **/
	public static IConfigurationElement[] getExtensions(String extensionPoint)
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		return registry.getConfigurationElementsFor(extensionPoint);
	}

	/**
	 * Creates an image descriptor from a plugin.
	 * @param plugin
	 *            The plugin identifier.
	 * @param path
	 *            The image path.
	 * @return The image.
	 * @throws MalformedURLException
	 *             If the URL is invalid.
	 **/
	public static ImageDescriptor getImageDescriptor(String plugin, String path) throws MalformedURLException
	{
		return ImageDescriptor.createFromURL(new URL("platform:/plugin/" + plugin + "/" + path));
	}

	/**
	 * Creates an image from a plugin.
	 * @param plugin
	 *            The plugin identifier.
	 * @param path
	 *            The image path.
	 * @return The image.
	 * @throws MalformedURLException
	 *             If the URL is invalid.
	 **/
	public static Image getImage(String plugin, String path) throws MalformedURLException
	{
		return getImageDescriptor(plugin, path).createImage();
	}

	/**
	 * Creates a decorated image from a plugin.
	 * @param plugin
	 *            The plugin identifier.
	 * @param path
	 *            The image path.
	 * @param decorator
	 *            The decorator image path.
	 * @param position
	 *            The decorator position.
	 * @return The image.
	 * @throws MalformedURLException
	 *             If the URL is invalid.
	 **/
	public static Image getImage(String plugin, String path, String decorator, int position) throws MalformedURLException
	{
		Image background = ImageDescriptor.createFromURL(new URL("platform:/plugin/" + plugin + "/" + path)).createImage();
		ImageDescriptor foreground = ImageDescriptor.createFromURL(new URL("platform:/plugin/" + plugin + "/" + decorator));

		return new DecorationOverlayIcon(background, foreground, position).createImage();
	}

	/**
	 * Retrieves the absolute path of a file from an URL.
	 * @param pluginId
	 *            The plug-in containing the file.
	 * @param path
	 *            The path of the file in the plug-in.
	 * @return The absolute path of the file.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws URISyntaxException
	 *             If the path is invalid.
	 **/
	public static String getPath(String pluginId, String path) throws URISyntaxException, IOException
	{
		Bundle bundle = Platform.getBundle(pluginId);
		URL fileURL = bundle.getEntry(path);
		URL rawFileURL = FileLocator.resolve(fileURL);
		File file = new File(rawFileURL.getFile());
		return file.getAbsolutePath();
	}

	/**
	 * Creates a new file, overwriting the old one, if needed.
	 * @param container
	 *            The container where create the file.
	 * @param name
	 *            The file name.
	 * @param content
	 *            The file content.
	 * @throws CoreException
	 *             If the file cannot be created.
	 **/
	public static void createFile(IContainer container, String name, String content) throws CoreException
	{
		IFile file = container.getFile(Path.fromPortableString(name));
		if (file.exists())
			file.setContents(new ByteArrayInputStream(content.getBytes()), IFile.DERIVED, null);
		else
			file.create(new ByteArrayInputStream(content.getBytes()), IFile.DERIVED, null);
	}

	/**
	 * Creates an RGB color.
	 * @param r
	 *            The R component.
	 * @param g
	 *            The G component.
	 * @param b
	 *            The B component.
	 * @return The color.
	 **/
	public static Color CreateColor(int r, int g, int b)
	{
		return new Color(Display.getDefault(), r, g, b);
	}

	/**
	 * Private constructor.
	 **/
	private Eclipse()
	{
	}
}
