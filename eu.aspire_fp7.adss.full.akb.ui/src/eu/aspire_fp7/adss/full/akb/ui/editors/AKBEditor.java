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
package eu.aspire_fp7.adss.full.akb.ui.editors;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

import com.google.inject.Injector;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ActionType;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.FunctionDeclaration;
import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Rule;
import eu.aspire_fp7.adss.akb.ui.editors.AssetsPage;
import eu.aspire_fp7.adss.akb.ui.editors.AttackerPage;
import eu.aspire_fp7.adss.akb.ui.editors.AttacksPage;
import eu.aspire_fp7.adss.akb.ui.editors.LogsPage;
import eu.aspire_fp7.adss.akb.ui.editors.PreferencesPage;
import eu.aspire_fp7.adss.akb.ui.editors.ProtectionsPage;
import eu.aspire_fp7.adss.akb.ui.editors.SolutionsPage;
import eu.aspire_fp7.adss.akb.ui.editors.TextEditorPage;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.rules.ui.internal.RulesActivator;
import eu.aspire_fp7.adss.rulesLanguage.Action;
import eu.aspire_fp7.adss.rulesLanguage.Condition;
import eu.aspire_fp7.adss.rulesLanguage.ParameterType;
import eu.aspire_fp7.adss.ui.ADSSDirtyListener;
import eu.aspire_fp7.adss.ui.ADSSService;
import eu.aspire_fp7.adss.util.Strings;

/**
 * The AKB editor.
 **/
public class AKBEditor extends FormEditor implements IResourceChangeListener, ADSSDirtyListener
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
		adssService = null;
	}

	/**
	 * Adds the pages.
	 **/
	@Override
	protected void addPages()
	{
		try
		{
			adssService = (ADSSService) getSite().getService(ADSSService.class);

			LogsPage logsPage = new LogsPage(this, file.getParent());
			adss = new ADSS(file, adssService.getModel(file));
			adssService.addListener(this, adss.getModel());
			AssetsPage assetsPage = new AssetsPage(this, adss, eventGenerator);
			AttackerPage attackerPage = new AttackerPage(this, adss, eventGenerator);
			AttacksPage attacksPage = new AttacksPage(this, adss, eventGenerator, true);
			ProtectionsPage protectionsPage = new ProtectionsPage(this, adss, eventGenerator);
			PreferencesPage preferencesPage = new PreferencesPage(this, adss, true);
			SolutionsPage solutionsPage = new SolutionsPage(this, adss, eventGenerator, true);
			OverviewPage overviewPage = new OverviewPage(this, adss, eventGenerator);

			addPage(overviewPage);
			addPage(attackerPage);
			addPage(preferencesPage);

			addRulesPage();

			addPage(assetsPage);
			addPage(attacksPage);
			addPage(protectionsPage);
			addPage(solutionsPage);
			addPage(logsPage);

			setPageText(addPage(new TextEditorPage(), getEditorInput()), "akb-full.owl");

			adss.getModel().eAdapters().add(new EContentAdapter()
			{
				@Override
				public void notifyChanged(Notification msg)
				{
					adssService.setDirty(adss.getModel(), true);
				}
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Adds the rules page.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void addRulesPage() throws Exception
	{
		RulesActivator activator = RulesActivator.getInstance();
		final Injector injector = activator.getInjector("eu.aspire_fp7.adss.RulesLanguage");
		XtextEditor xtextEditor = injector.getInstance(XtextEditor.class);

		IFile rulesFile = file.getProject().getFile("adss.rules");
		if (!rulesFile.exists())
			rulesFile.create(new ByteArrayInputStream(getRules().getBytes()), IFile.HIDDEN | IFile.FORCE, null);
		else
			rulesFile.setContents(new ByteArrayInputStream(getRules().getBytes()), IFile.HIDDEN | IFile.FORCE, null);
		FileEditorInput fileEditorInput = new FileEditorInput(rulesFile);

		int index = addPage(xtextEditor, fileEditorInput);
		setPageText(index, "Rules");

		xtextEditor.getDocument().addModelListener(new IXtextModelListener()
		{
			private boolean first = true;

			@Override
			public void modelChanged(XtextResource resource)
			{
				if (first)
					first = false;
				else if (!resource.getParseResult().hasSyntaxErrors())
				{
					adss.getModel().getRules().clear();
					for (EObject i : resource.getContents())
						if (i instanceof eu.aspire_fp7.adss.rulesLanguage.Model)
							analyze((eu.aspire_fp7.adss.rulesLanguage.Model) i);
				}
			}
		});
	}

	/**
	 * Analyzes a DSL model.
	 * @param model
	 *            The model to analyze.
	 **/
	private void analyze(eu.aspire_fp7.adss.rulesLanguage.Model model)
	{
		for (eu.aspire_fp7.adss.rulesLanguage.Rule i : model.getRules())
			analyze(i);
	}

	/**
	 * Analyzes a DSL rule.
	 * @param rule
	 *            The rule to analyze.
	 **/
	private void analyze(eu.aspire_fp7.adss.rulesLanguage.Rule rule)
	{
		Rule r = AkbFactory.eINSTANCE.createRule();

		for (Condition i : rule.getConditions())
			if (i instanceof eu.aspire_fp7.adss.rulesLanguage.FunctionDeclaration)
			{
				eu.aspire_fp7.adss.rulesLanguage.FunctionDeclaration declaration = (eu.aspire_fp7.adss.rulesLanguage.FunctionDeclaration) i;
				FunctionDeclaration f = AkbFactory.eINSTANCE.createFunctionDeclaration();

				f.setName(declaration.getName());
				for (ParameterType j : declaration.getParameters())
					if (j == ParameterType.CRYPTOGRAPHIC_KEY)
						f.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
					else if (j == ParameterType.INITIALIZATION_VECTOR)
						f.getParameters().add(ApplicationPartType.INITIALIZATION_VECTOR);
					else if (j == ParameterType.PLAINTEXT)
						f.getParameters().add(ApplicationPartType.PLAINTEXT);
					else if (j == ParameterType.CIPHERTEXT)
						f.getParameters().add(ApplicationPartType.CIPHERTEXT);
					else if (j == ParameterType.IGNORE)
						f.getParameters().add(ApplicationPartType.IGNORE);

				r.getFunctionDeclarations().add(f);
			}

		if (rule.getAction() == Action.DECRYPT_AES128_CBC)
			r.setAction(ActionType.DECRYPT_AES128_CBC);
		else if (rule.getAction() == Action.DECRYPT_AES128_ECB)
			r.setAction(ActionType.DECRYPT_AES128_ECB);
		else if (rule.getAction() == Action.ENCRYPT_AES128_CBC)
			r.setAction(ActionType.ENCRYPT_AES128_CBC);
		else if (rule.getAction() == Action.ENCRYPT_AES128_ECB)
			r.setAction(ActionType.ENCRYPT_AES128_ECB);

		adss.getModel().getRules().add(r);
	}

	/**
	 * Retrieves the rules in the AKB.
	 * @return The rules
	 **/
	private String getRules()
	{
		StringBuilder sb = new StringBuilder();

		for (Rule i : adss.getModel().getRules())
		{
			List<String> functions = new ArrayList<>();
			for (FunctionDeclaration j : i.getFunctionDeclarations())
			{
				List<String> parameters = new ArrayList<>();
				for (ApplicationPartType k : j.getParameters())
					if (k == ApplicationPartType.CIPHERTEXT)
						parameters.add("ciphertext");
					else if (k == ApplicationPartType.INITIALIZATION_VECTOR)
						parameters.add("initializationVector");
					else if (k == ApplicationPartType.PLAINTEXT)
						parameters.add("plaintext");
					else if (k == ApplicationPartType.CRYPTOGRAPHIC_KEY)
						parameters.add("cryptographicKey");
					else if (k == ApplicationPartType.IGNORE)
						parameters.add("_");
				functions.add(j.getName() + "(" + Strings.join(parameters, ", ") + ")");
			}
			String action = "<unknown>";
			if (i.getAction() == ActionType.DECRYPT_AES128_CBC)
				action = "decrypt:AES128-CBC";
			else if (i.getAction() == ActionType.DECRYPT_AES128_ECB)
				action = "decrypt:AES128-ECB";
			else if (i.getAction() == ActionType.ENCRYPT_AES128_CBC)
				action = "encrypt:AES128-CBC";
			else if (i.getAction() == ActionType.ENCRYPT_AES128_ECB)
				action = "encrypt:AES128-ECB";

			sb.append("if " + Strings.join(functions, ", ") + " then\n\t" + action + "\n");
		}

		return sb.toString();
	}

	/**
	 * Disposes the editor.
	 */
	@Override
	public void dispose()
	{
		adssService.removeListener(this, adss.getModel());
		adssService.dispose(adss.getModel());
		adss.close();

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
			adssService.setDirty(adss.getModel(), false);
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
		return adssService.isDirty(adss.getModel());
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
	 * Signals that the dirty state of model has changed.
	 * @param model
	 *            The model.
	 * @param dirty
	 *            The new dirty state of the model.
	 **/
	@Override
	public void dirtyStateChanged(Model model, boolean dirty)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				firePropertyChange(PROP_DIRTY);
			}
		});
	}

	/** The ADSS. **/
	private ADSS adss;
	/** The text editor used in page 0. */
	private TextEditor editor;
	/** The event generator. */
	private ADSSEventGenerator eventGenerator;
	/** The file. **/
	private IFile file;
	/** The ADSS service. **/
	private ADSSService adssService;
}
