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

import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

import eu.aspire_fp7.adss.light.akb.ui.Activator;

/**
 * The new project wizard.
 * @author Daniele Canavese
 **/
public class NewWizard extends Wizard implements INewWizard, IExecutableExtension
{
	/**
	 * Adds the pages.
	 **/
	@Override
	public void addPages()
	{
		page1 = new OverviewPage();
		page2 = new RemoteConnectionPage();
		page3 = new CommandsPage();
		addPage(page1);
		addPage(page2);
		addPage(page3);
	}

	/**
	 * Initializes the wizard.
	 * @param workbench
	 *            The workbench.
	 * @param selection
	 *            The initial selection.
	 **/
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection)
	{
		setWindowTitle("New ADSS Light Software Protection Project");
		setNeedsProgressMonitor(true);
		try
		{
			setDefaultPageImageDescriptor(
					ImageDescriptor.createFromURL(new URL("platform:/plugin/" + Activator.PLUGIN_ID + "/icons/newProjectWizard.png")));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Terminates the wizard.
	 * @return <code>true</code> if everything went ok, <code>false</code> otherwise.
	 **/
	@Override
	public boolean performFinish()
	{
		try
		{
			// Creates the project.
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(page1.getProjectName());
			project.create(null);

			// Opens it.
			project.open(null);

			// Sets property given by the user.
			project.setSessionProperty(new QualifiedName("ADSS", "workingDirectory"), page1.getWorkingDirectory());
			project.setSessionProperty(new QualifiedName("ADSS", "actcConfigFile"), page1.getACTCConfigurationFile());
			project.setSessionProperty(new QualifiedName("ADSS", "adssPatchFile"), page1.getADSSPatchFile());
			project.setSessionProperty(new QualifiedName("ADSS", "adssJSONFile"), page1.getADSSJSONFile());
			project.setSessionProperty(new QualifiedName("ADSS", "remoteConnectionEnabled"), page2.isRemoteConnection());
			project.setSessionProperty(new QualifiedName("ADSS", "remoteHost"), page2.getRemoteHost());
			project.setSessionProperty(new QualifiedName("ADSS", "remotePort"), page2.getRemotePort());
			project.setSessionProperty(new QualifiedName("ADSS", "remoteUsername"), page2.getRemoteUsername());
			project.setSessionProperty(new QualifiedName("ADSS", "remotePassword"), page2.getRemotePassword());
			project.setSessionProperty(new QualifiedName("ADSS", "remoteFileSep"), page2.getRemoteServerFileSeparator());			
			project.setSessionProperty(new QualifiedName("ADSS", "actcCommand"), page3.getACTCCommand());
			project.setSessionProperty(new QualifiedName("ADSS", "codeSurferCommand"), page3.getCodeSurferCommand());
			project.setSessionProperty(new QualifiedName("ADSS", "compilationCommand"), page3.getCompilationCommand());

			// Sets the nature.
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = Nature.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);

			// Opens the right perspective.
			BasicNewProjectResourceWizard.updatePerspective(config);
		}
		catch (CoreException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Initializes the wizard.
	 * @param config
	 *            The configuration element.
	 * @param propertyName
	 *            The property name.
	 * @param data
	 *            The property value.
	 **/
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException
	{
		this.config = config;
	}

	/** The configuration element. **/
	private IConfigurationElement config;
	/** The overview page. **/
	private OverviewPage page1;
	/** The source directory page. **/
	private RemoteConnectionPage page2;
	/** The remote connection page. **/
	private CommandsPage page3;
}
