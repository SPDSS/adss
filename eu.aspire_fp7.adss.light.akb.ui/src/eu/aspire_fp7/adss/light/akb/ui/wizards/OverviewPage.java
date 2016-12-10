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
package eu.aspire_fp7.adss.light.akb.ui.wizards;

import java.util.UUID;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The project overview wizard page.
 * @author Daniele Canavese
 **/
public class OverviewPage extends WizardPage
{
	/**
	 * Creates the page.
	 **/
	protected OverviewPage()
	{
		super("Create an ADSS Light Software Protection Project");
		setTitle("Create an ADSS Light Software Protection Project");
		setDescription("Create an ADSS Light project in the workspace or in an external location.");
		setPageComplete(false);
		projectName = UUID.randomUUID().toString();
	}

	/**
	 * Fills the page.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));

		Label labelProjectName = new Label(composite, SWT.NONE);
		labelProjectName.setText("Project name:");

		Text textProjectName = new Text(composite, SWT.BORDER);
		textProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textProjectName.setFocus();

		Group groupLocation = new Group(container, SWT.NONE);
		groupLocation.setText("Location");
		groupLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		groupLocation.setLayout(new GridLayout(3, false));

		Button buttonUseDefaultLocation = new Button(groupLocation, SWT.CHECK);
		buttonUseDefaultLocation.setSelection(true);
		buttonUseDefaultLocation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		buttonUseDefaultLocation.setText("Use default location");

		Label labelLocation = new Label(groupLocation, SWT.NONE);
		labelLocation.setText("Location:");

		final Text textLocation = new Text(groupLocation, SWT.BORDER);
		textLocation.setEnabled(false);
		textLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textLocation.setText(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

		final Button buttonBrowse = new Button(groupLocation, SWT.NONE);
		buttonBrowse.setEnabled(false);
		buttonBrowse.setText("Browse...");

		Group groupSourceCode = new Group(container, SWT.NONE);
		groupSourceCode.setText("Source code");
		groupSourceCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		groupSourceCode.setLayout(new GridLayout(3, false));

		Label labelWorkingDirectory = new Label(groupSourceCode, SWT.NONE);
		labelWorkingDirectory.setText("Working directory:");

		textWorkingDirectory = new Text(groupSourceCode, SWT.BORDER);
		textWorkingDirectory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textWorkingDirectory.setText("/home/aspire/test");

		final Button buttonSourceCodeBrowse = new Button(groupSourceCode, SWT.NONE);
		buttonSourceCodeBrowse.setText("Browse...");

		Label labelACTCConfigurationFile = new Label(groupSourceCode, SWT.NONE);
		labelACTCConfigurationFile.setText("ACTC configuration file:");

		textACTCConfigurationFile = new Text(groupSourceCode, SWT.BORDER);
		textACTCConfigurationFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textACTCConfigurationFile.setText("test.json");

		final Button buttonACTCConfigurationFile = new Button(groupSourceCode, SWT.NONE);
		buttonACTCConfigurationFile.setText("Browse...");

		Label labelADSSPatchFile = new Label(groupSourceCode, SWT.NONE);
		labelADSSPatchFile.setText("ADSS patch file:");

		textADSSPatchFile = new Text(groupSourceCode, SWT.BORDER);
		textADSSPatchFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textADSSPatchFile.setText("adss.patch");

		new Label(groupSourceCode, SWT.NONE);

		Label labelADSSJSONFile = new Label(groupSourceCode, SWT.NONE);
		labelADSSJSONFile.setText("ADSS JSON file:");

		textADSSJSONFile = new Text(groupSourceCode, SWT.BORDER);
		textADSSJSONFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textADSSJSONFile.setText("adss.json");

		new Label(groupSourceCode, SWT.NONE);

		textProjectName.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				projectName = ((Text) e.getSource()).getText();
				if (!projectName.isEmpty())
				{
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IProject project = root.getProject(projectName);
					if (project.exists())
						setErrorMessage(" A project with this name already exists.");
					else
						setErrorMessage(null);
				}
			}
		});
		buttonUseDefaultLocation.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				boolean custom = !((Button) e.widget).getSelection();
				textLocation.setEnabled(custom);
				buttonBrowse.setEnabled(custom);
				if (custom)
					textLocation.setText("");
				else
					textLocation.setText(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
			}
		});
		buttonBrowse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell());
						dialog.setMessage("Choose a directory for the project contents");
						dialog.setText("Project Location");
						String folder = dialog.open();
						if (folder != null)
							textLocation.setText(folder);
					}
				});
			}
		});
		buttonSourceCodeBrowse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell());
						dialog.setMessage("Choose a directory containing the application to protect");
						dialog.setText("Source Code Location");
						String folder = dialog.open();
						if (folder != null)
							textWorkingDirectory.setText(folder);
					}
				});
			}
		});
		buttonACTCConfigurationFile.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell());
						dialog.setText("ACTC Configuration File");
						dialog.setFilterExtensions(new String[] { "*.json" });
						String file = dialog.open();
						if (file != null)
							textACTCConfigurationFile.setText(file);
					}
				});
			}
		});
		ModifyListener completiontLister = new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (textLocation.getText().isEmpty())
					setPageComplete(false);
				else if (textACTCConfigurationFile.getText().isEmpty())
					setPageComplete(false);
				else if (textWorkingDirectory.getText().isEmpty())
					setPageComplete(false);
				else if (textADSSPatchFile.getText().isEmpty())
					setPageComplete(false);
				else if (textADSSJSONFile.getText().isEmpty())
					setPageComplete(false);
				else
					setPageComplete(true);
			}
		};
		textProjectName.addModifyListener(completiontLister);
		textLocation.addModifyListener(completiontLister);
		textACTCConfigurationFile.addModifyListener(completiontLister);
		textWorkingDirectory.addModifyListener(completiontLister);
		completiontLister.modifyText(null);
	}

	/**
	 * Retrieves the project name.
	 * @return The project name.
	 **/
	public String getProjectName()
	{
		return projectName;
	}

	/**
	 * Retrieves the working directory.
	 * @return The working directory.
	 **/
	public String getWorkingDirectory()
	{
		return textWorkingDirectory.getText();
	}

	/**
	 * Retrieves the ACTC configuration file.
	 * @return The ACTC configuration file.
	 **/
	public String getACTCConfigurationFile()
	{
		return textACTCConfigurationFile.getText();
	}

	/**
	 * Retrieves the ADSS patch file.
	 * @return The ADSS patch file.
	 **/
	public String getADSSPatchFile()
	{
		return textADSSPatchFile.getText();
	}

	/**
	 * Retrieves the ADSS JSON file.
	 * @return The ADSS JSON file.
	 **/
	public String getADSSJSONFile()
	{
		return textADSSJSONFile.getText();
	}
	
	/** The project name. **/
	private String projectName;
	/** The working directory text. **/
	private Text textWorkingDirectory;
	/** The ACTC configuration file text. **/
	private Text textACTCConfigurationFile;
	/** The ADSS patch file text. **/
	private Text textADSSPatchFile;
	/** The ADSS JSON file text. **/
	private Text textADSSJSONFile;
}
