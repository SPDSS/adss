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
package eu.aspire_fp7.adss.light.akb.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.FileEditorInput;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.editors.AssetsPage;
import eu.aspire_fp7.adss.akb.ui.editors.AttackerPage;
import eu.aspire_fp7.adss.akb.ui.editors.AttacksPage;
import eu.aspire_fp7.adss.akb.ui.editors.LogsPage;
import eu.aspire_fp7.adss.akb.ui.editors.PreferencesPage;
import eu.aspire_fp7.adss.akb.ui.editors.ProtectionsPage;
import eu.aspire_fp7.adss.akb.ui.editors.SolutionsPage;
import eu.aspire_fp7.adss.akb.ui.editors.TextEditorPage;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.ADSS;

/**
 * The AKB editor.
 **/
public class AKBEditor extends FormEditor implements IResourceChangeListener, ADSSEventListener
{
	/**
	 * Creates the editor.
	 */
	public AKBEditor()
	{
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		adss = null;
		eventGenerator = new ADSSEventGenerator();
		eventGenerator.addListener(this);
		dirty = false;
	}

	/**
	 * Adds the pages.
	 **/
	@Override
	protected void addPages()
	{
		try
		{
			//LogsPage logsPage = new LogsPage(this);
			adss = new ADSS(file);
			//AssetsPage assetsPage = new AssetsPage(this, adss, eventGenerator);
			//AttackerPage attackerPage = new AttackerPage(this, adss, eventGenerator);
			AttacksPage attacksPage = new AttacksPage(this, adss, eventGenerator);
			ProtectionsPage protectionsPage = new ProtectionsPage(this, adss, eventGenerator);
			PreferencesPage preferencesPage = new PreferencesPage(this, adss, false);
			SolutionsPage solutionsPage = new SolutionsPage(this, adss, eventGenerator, false);
			//ComparisonPage comparisonPage = new ComparisonPage(this);
			OverviewPage overviewPage = new OverviewPage(this, adss, eventGenerator, solutionsPage);
			PNOverviewPage pnoverviewPage = new PNOverviewPage(this, adss);
			
			SPAResultPage sparesultPage = new SPAResultPage(this, adss, eventGenerator);
			SPAUIPage spauiPage = new SPAUIPage(this, adss, eventGenerator, sparesultPage);
			

			//spauiPage.createPartControl(parent);
			addPage(overviewPage);
			
			addPage(pnoverviewPage);
			
			addPage(spauiPage);
			addPage(sparesultPage);
			
			//addPage(assetsPage);
			//addPage(attackerPage);
			addPage(attacksPage);
			addPage(protectionsPage);
			addPage(solutionsPage);
			//addPage(comparisonPage);
			addPage(preferencesPage);
			//addPage(logsPage);
			
			

			setPageText(addPage(new TextEditorPage(), getEditorInput()), "akb-light.owl");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Disposes the editor.
	 */
	@Override
	public void dispose()
	{
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}

	/**
	 * Saves the editor's document.
	 * @param monitor
	 *            the monitor.
	 **/
	@Override
	public void doSave(IProgressMonitor monitor)
	{
		try
		{
			adss.save();
			dirty = false;
			firePropertyChange(PROP_DIRTY);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		monitor.done();
	}

	/**
	 * Saves the editor's document as another file.
	 **/
	@Override
	public void doSaveAs()
	{
	}

	/**
	 * Initializes the editor.
	 * @param site
	 *            The editor site.
	 * @param editorInput
	 *            The editor input.
	 **/
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException
	{
		super.init(site, editorInput);
		if (editorInput instanceof IFileEditorInput)
			try
			{
				file = ((IFileEditorInput) editorInput).getFile();
				setPartName(file.getProject().getName());
				dirty = false;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

	/**
	 * Retrieves the dirty state of the editor.
	 **/
	@Override
	public boolean isDirty()
	{
		return dirty;
	}

	/**
	 * Checks if a save is allowed.
	 * @return <code>true</code> if saving is allowed, <code>false</code> otherwise.
	 **/
	@Override
	public boolean isSaveAsAllowed()
	{
		return false;
	}

	/**
	 * Reacts to the resource change.
	 * @param event
	 *            The resource change event.
	 **/
	@Override
	public void resourceChanged(final IResourceChangeEvent event)
	{
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE)
			Display.getDefault().asyncExec(new Runnable()
			{
				@Override
				public void run()
				{
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (IWorkbenchPage page : pages)
						if (((FileEditorInput) editor.getEditorInput()).getFile().getProject().equals(event.getResource()))
						{
							IEditorPart editorPart = page.findEditor(editor.getEditorInput());
							page.closeEditor(editorPart, true);
						}
				}
			});
	}

	/**
	 * Handles an event.
	 * @param event
	 *            The event.
	 **/
	@Override
	public void handleEvent(final Event event)
	{
		if (!dirty && adss != null)
			Display.getDefault().asyncExec(new Runnable()
			{
				@Override
				public void run()
				{
					dirty = true;
					firePropertyChange(PROP_DIRTY);
				}
			});
	}

	/** The ADSS. **/
	private ADSS adss;
	/** The dirty state of the editor. **/
	private boolean dirty;
	/** The text editor used in page 0. */
	private TextEditor editor;
	/** The event generator. */
	private ADSSEventGenerator eventGenerator;
	/** The file. **/
	private IFile file;
	
	/**
	 * return the adss we have not.

	 **/
	public ADSS getADSS()
	{
		return adss;
	}
}
