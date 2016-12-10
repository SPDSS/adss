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

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.dialogs.SolutionMultiSelectionDialog;
import eu.aspire_fp7.adss.akb.ui.dialogs.SolutionSelectionDialog;
import eu.aspire_fp7.adss.akb.ui.editors.Executable;
import eu.aspire_fp7.adss.akb.ui.editors.LabelType;
import eu.aspire_fp7.adss.akb.ui.editors.SummarySection;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The overview page.
 * @author Daniele Canavese
 **/
public class OverviewPage extends FormPage
{
	/** The ADSS. **/
	private ADSS adss;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;
	/** The build all hyperlink. **/
	private ImageHyperlink buildAllHyperlink;
	/** The analyze source code hyperlink. **/
	private ImageHyperlink analyzeSourceCodeHyperlink;
	/** The find attacks hyperlink. **/
	private ImageHyperlink findAttacksHyperlink;
	/** The find protections hyperlink. **/
	private ImageHyperlink findProtectionsHyperlink;
	/** The find first level protections hyperlink. **/
	private ImageHyperlink findFirstLevelProtectionsHyperlink;
	/** The find second level protections hyperlink. **/
	private ImageHyperlink findSecondLevelProtectionsHyperlink;
	/** The deploy solution. **/
	private ImageHyperlink deploySolutionghHyperlink;
	/** The source directory text. **/
	private Text workingDirectoryText;
	/** The ACTC configuration file text. **/
	private Text actcConfigurationFileText;
	/** The ADSS patch file text. **/
	private Text adssPatchFileText;
	/** The ADSS JSON file text. **/
	private Text adssJSONFileText;
	/** The compute metrics action. **/
	private Action computeMetricsAction;
	/** The compute metrics coefficients action. **/
	private Action computeCoefficientsAction;

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param adss
	 *            The ADSS.
	 * @param eventGenerator
	 *            The event generator.
	 * @param solverObserver
	 *            An optional solver observer to use.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public OverviewPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator) throws Exception
	{
		super(editor, "overview", "Overview");
		this.adss = adss;
		this.eventGenerator = eventGenerator;
	}

	/**
	 * Creates the form content.
	 * @param managedForm
	 *            The managed form.
	 **/
	@Override
	protected void createFormContent(IManagedForm managedForm)
	{
		try
		{
			ScrolledForm form = managedForm.getForm();
			managedForm.getToolkit().paintBordersFor(form);
			form.setText("ASPIRE Knowledge Base Overview");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/all.png"));
			form.getBody().setLayout(new GridLayout(2, false));

			form.getToolBarManager()
					.add(new Action("Export HTML report...", Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/report.png"))
					{
						@Override
						public void run()
						{
							SaveAsDialog dialog = new SaveAsDialog(Display.getDefault().getActiveShell());
							dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile().getProject().getFile("report.html"));
							dialog.open();
							IPath path = dialog.getResult();
							if (path != null)
							{
								ReportGenerator reportGenerator = new ReportGenerator(OverviewPage.this.adss);
								try
								{
									reportGenerator.generate(((IFileEditorInput) getEditorInput()).getFile().getProject().getName(),
											path.toOSString());
								}
								catch (FileNotFoundException e)
								{
									e.printStackTrace();
								}
							}
						}
					});
			computeMetricsAction = new Action("Compute the metrics", Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/metrics.png"))
			{
				@Override
				public void run()
				{
					SaveAsDialog dialog = new SaveAsDialog(Display.getDefault().getActiveShell());
					dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile().getProject().getFile("metrics.csv"));
					dialog.open();
					IPath path = dialog.getResult();
					Job job = new Job("Computing the metrics...")
					{
						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							try
							{
								if (path != null)
									adss.computeMetrics(ResourcesPlugin.getWorkspace().getRoot().getFile(path), monitor);
								return Status.OK_STATUS;
							}
							catch (Exception e)
							{
								e.printStackTrace();
								return Status.CANCEL_STATUS;
							}
						}
					};
					job.setUser(true);
					job.schedule();
				}
			};
			computeMetricsAction.setEnabled(false);
			form.getForm().getMenuManager().add(computeMetricsAction);
			computeCoefficientsAction = new Action("Compute the metrics estimation coefficients...",
					Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/coefficients.png"))
			{
				@Override
				public void run()
				{
					Collection<IFile> files = new ArrayList<>();
					ResourceSelectionDialog dialog = new ResourceSelectionDialog(Display.getDefault().getActiveShell(),
							ResourcesPlugin.getWorkspace().getRoot(), "Select the metrics file to use:");
					dialog.open();
					if (dialog.getResult() != null && dialog.getResult().length > 0)
					{
						for (Object i : dialog.getResult())
							if (i instanceof IFile)
								files.add((IFile) i);
					}
					if (!files.isEmpty())
					{
						SaveAsDialog dialog2 = new SaveAsDialog(Display.getDefault().getActiveShell());
						dialog2.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile().getProject().getFile("gammas.csv"));
						dialog2.open();
						IPath path = dialog2.getResult();
						Job job = new Job("Computing the metrics estimation coefficients...")
						{
							@Override
							protected IStatus run(IProgressMonitor monitor)
							{
								try
								{
									adss.computeMetricCoefficients(files, ResourcesPlugin.getWorkspace().getRoot().getFile(path), monitor);
									return Status.OK_STATUS;
								}
								catch (Exception e)
								{
									e.printStackTrace();
									return Status.CANCEL_STATUS;
								}
							}
						};
						job.setUser(true);
						job.schedule();
					}
				}
			};
			computeCoefficientsAction.setEnabled(false);
			form.getForm().getMenuManager().add(computeCoefficientsAction);
			form.getToolBarManager().update(true);

			SummarySection summarySection = new SummarySection(adss, managedForm, LabelType.ASSETS, LabelType.PROTECTIONS,
					LabelType.ATTACK_PATHS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createSourceDirectorySection(managedForm);
			createAutomaticBuildSection(managedForm);
			createStepByStepBuildSection(managedForm);
			createLogo(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the application parts section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createSourceDirectorySection(IManagedForm managedForm) throws Exception
	{
		SectionPart sourceDirectorySectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(sourceDirectorySectionPart);
		sourceDirectorySectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		sourceDirectorySectionPart.getSection().setText("Source Directory");

		Composite sourceDirectoryComposite = new Composite(sourceDirectorySectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(sourceDirectoryComposite);
		managedForm.getToolkit().paintBordersFor(sourceDirectoryComposite);
		sourceDirectorySectionPart.getSection().setClient(sourceDirectoryComposite);
		sourceDirectoryComposite.setLayout(new GridLayout(3, false));

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "Working directory:");

		workingDirectoryText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		workingDirectoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		workingDirectoryText.setText(adss.getModel().getPreferences().getWorkingDirectory());

		Button sourceDirectoryButton = managedForm.getToolkit().createButton(sourceDirectoryComposite, "Browse...", SWT.NONE);

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "ACTC configuration file:");

		actcConfigurationFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		actcConfigurationFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		actcConfigurationFileText.setText(adss.getModel().getPreferences().getActcConfigurationFile());

		Button actcConfigurationFileButton = managedForm.getToolkit().createButton(sourceDirectoryComposite, "Browse...", SWT.NONE);

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "ADSS patch file:");

		adssPatchFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		adssPatchFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		adssPatchFileText.setText(adss.getModel().getPreferences().getAdssPatchFile());

		new Label(sourceDirectoryComposite, SWT.NONE);

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "ADSS JSON file:");

		adssJSONFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		adssJSONFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		adssJSONFileText.setText(adss.getModel().getPreferences().getAdssJSONFile());

		new Label(sourceDirectoryComposite, SWT.NONE);

		workingDirectoryText.addModifyListener(new ModifyListener()
		{

			@Override
			public void modifyText(ModifyEvent e)
			{
				adss.getModel().getPreferences().setWorkingDirectory(workingDirectoryText.getText());
			}
		});

		actcConfigurationFileText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				adss.getModel().getPreferences().setActcConfigurationFile(actcConfigurationFileText.getText());
			}
		});

		adssPatchFileText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				adss.getModel().getPreferences().setAdssPatchFile(adssPatchFileText.getText());
			}
		});

		adssJSONFileText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				adss.getModel().getPreferences().setAdssJSONFile(adssJSONFileText.getText());
			}
		});

		sourceDirectoryButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getDefault().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						DirectoryDialog dialog = new DirectoryDialog(Display.getDefault().getActiveShell());
						String directory = dialog.open();
						if (directory != null)
						{
							adss.getModel().getPreferences().setWorkingDirectory(directory);
							workingDirectoryText.setText(adss.getModel().getPreferences().getWorkingDirectory());
						}
					}
				});
			}
		});

		actcConfigurationFileButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getDefault().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell());
						dialog.setFilterExtensions(new String[] { "*.json" });
						String file = dialog.open();
						if (file != null)
						{
							adss.getModel().getPreferences().setActcConfigurationFile(file);
							actcConfigurationFileText.setText(adss.getModel().getPreferences().getActcConfigurationFile());
						}
					}
				});
			}
		});
	}

	/**
	 * Creates the automatic build section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAutomaticBuildSection(IManagedForm managedForm) throws Exception
	{
		SectionPart automaticBuildSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR | Section.DESCRIPTION);
		managedForm.addPart(automaticBuildSectionPart);
		automaticBuildSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		automaticBuildSectionPart.getSection().setText("Automatic Build");
		automaticBuildSectionPart.getSection().setDescription("Perform all the protection steps at once");

		Composite automaticBuildComposite = new Composite(automaticBuildSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(automaticBuildComposite);
		managedForm.getToolkit().paintBordersFor(automaticBuildComposite);
		automaticBuildSectionPart.getSection().setClient(automaticBuildComposite);
		automaticBuildComposite.setLayout(new GridLayout(1, false));

		buildAllHyperlink = managedForm.getToolkit().createImageHyperlink(automaticBuildComposite, SWT.NONE);
		buildAllHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buildAllHyperlink.setText("Build All");
		buildAllHyperlink.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/all.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		buildAllHyperlink.addHyperlinkListener(createAdapter("Building everything!", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				try
				{
					adss.analyzeSourceCode();
					adss.close();
					eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED);
					adss.findAttacks();
					eventGenerator.fireEvents(Event.ATTACK_STEP_UPDATED, Event.ATTACK_PATH_UPDATED);
					adss.findProtections();
					eventGenerator.fireEvents(Event.PROTECTIONS_UPDATED);
					adss.findFirstLevelProtections();
					int secondLevelSolutionLimit = adss.getModel().getPreferences().getL2pSolutionsCount();
					if (secondLevelSolutionLimit > adss.getModel().getSolutions().size())
						secondLevelSolutionLimit = adss.getModel().getSolutions().size();
					for (int i = 0; i < secondLevelSolutionLimit; i++)
						adss.findSecondLevelProtections(adss.getModel().getSolutions().get(i));
					eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED, Event.SOLUTIONS_UPDATED);
					adss.deploySolution(adss.getModel().getSolutions().get(0));
					adss.close();
				}
				finally
				{
					Display.getDefault().syncExec(new Runnable()
					{
						@Override
						public void run()
						{
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "ADSS", "Solution deployment completed!");
						}
					});
				}
			}
		}));
	}

	/**
	 * Creates the step by step build section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createStepByStepBuildSection(IManagedForm managedForm) throws Exception
	{
		SectionPart stepByStepBuildSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR | Section.DESCRIPTION);
		managedForm.addPart(stepByStepBuildSectionPart);
		stepByStepBuildSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		stepByStepBuildSectionPart.getSection().setText("Step by Step Build");
		stepByStepBuildSectionPart.getSection().setDescription("Control each protection step individually");

		Composite stepByStepBuildComposite = new Composite(stepByStepBuildSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(stepByStepBuildComposite);
		managedForm.getToolkit().paintBordersFor(stepByStepBuildComposite);
		stepByStepBuildSectionPart.getSection().setClient(stepByStepBuildComposite);
		stepByStepBuildComposite.setLayout(new GridLayout(1, false));

		analyzeSourceCodeHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		analyzeSourceCodeHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		analyzeSourceCodeHyperlink.setText("Analyze the source code");
		analyzeSourceCodeHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/source.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findAttacksHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findAttacksHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findAttacksHyperlink.setText("Find the attacks");
		findAttacksHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackPath.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findProtectionsHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findProtectionsHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findProtectionsHyperlink.setText("Find the protections");
		findProtectionsHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/protection.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findFirstLevelProtectionsHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findFirstLevelProtectionsHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findFirstLevelProtectionsHyperlink.setText("Find the first level protections");
		findFirstLevelProtectionsHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findSecondLevelProtectionsHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findSecondLevelProtectionsHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findSecondLevelProtectionsHyperlink.setText("Find the second level protections");
		findSecondLevelProtectionsHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		deploySolutionghHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		deploySolutionghHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		deploySolutionghHyperlink.setText("Deploy a solution");
		deploySolutionghHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png", "icons/deploy.png", IDecoration.BOTTOM_LEFT));

		updateEnables();

		analyzeSourceCodeHyperlink.addHyperlinkListener(createAdapter("Analyzing the source code", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				adss.analyzeSourceCode();
				adss.close();
				eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED);
				updateEnables();
			}
		}));

		findAttacksHyperlink.addHyperlinkListener(createAdapter("Finding the attacks", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				adss.findAttacks();
				adss.close();
				eventGenerator.fireEvents(Event.ATTACK_STEP_UPDATED, Event.ATTACK_PATH_UPDATED);
				updateEnables();
			}
		}));
		findProtectionsHyperlink.addHyperlinkListener(createAdapter("Finding the protections", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				adss.findProtections();
				adss.close();
				eventGenerator.fireEvents(Event.PROTECTIONS_UPDATED);
				updateEnables();
			}
		}));
		findFirstLevelProtectionsHyperlink.addHyperlinkListener(createAdapter("Finding the first level protections", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				adss.findFirstLevelProtections();
				adss.close();
				eventGenerator.fireEvents(Event.SOLUTIONS_UPDATED);
				updateEnables();
			}
		}));
		findSecondLevelProtectionsHyperlink.addHyperlinkListener(createAdapter("Finding the second level protections", new Executable()
		{
			private Object[] solutions;

			@Override
			public void execute() throws Exception
			{
				disableAll();
				solutions = null;
				Display.getDefault().syncExec(new Runnable()
				{

					@Override
					public void run()
					{
						SolutionMultiSelectionDialog dialog = new SolutionMultiSelectionDialog(Display.getDefault().getActiveShell(),
								adss.getModel());
						dialog.setTitle("Solution Selection");
						dialog.setMessage("Select the solutions on which the second level protections must be evaluated:");
						if (dialog.open() == Window.OK)
							solutions = dialog.getResult();
					}
				});
				if (solutions != null)
					for (Object solution : solutions)
						adss.findSecondLevelProtections((Solution) solution);
				adss.close();
				eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED, Event.SOLUTIONS_UPDATED);
				updateEnables();
			}
		}));
		deploySolutionghHyperlink.addHyperlinkListener(createAdapter("Deploying the solution", new Executable()
		{
			private Solution solution;

			@Override
			public void execute() throws Exception
			{
				solution = null;
				disableAll();
				Display.getDefault().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						SolutionSelectionDialog dialog = new SolutionSelectionDialog(Display.getDefault().getActiveShell(),
								adss.getModel());
						dialog.setTitle("Solution Selection");
						dialog.setMessage("Select the solution to deploy:");
						if (dialog.open() == Window.OK)
							solution = (Solution) dialog.getResult()[0];
					}
				});
				if (solution != null)
				{
					try
					{
						adss.deploySolution(solution);
					}
					finally
					{
						Display.getDefault().syncExec(new Runnable()
						{
							@Override
							public void run()
							{
								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "ADSS",
										"Solution deployment completed!");
							}
						});
					}
				}
				updateEnables();
			}
		}));
	}

	/**
	 * Disables all the various hyper-links.
	 */
	private void disableAll()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				analyzeSourceCodeHyperlink.setEnabled(false);
				findAttacksHyperlink.setEnabled(false);
				findProtectionsHyperlink.setEnabled(false);
				findFirstLevelProtectionsHyperlink.setEnabled(false);
				findSecondLevelProtectionsHyperlink.setEnabled(false);
				deploySolutionghHyperlink.setEnabled(false);

				buildAllHyperlink.setEnabled(false);
			}
		});
	}

	/**
	 * Updates the enable state of the various hyper-links.
	 */
	private void updateEnables()
	{
		disableAll();

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				analyzeSourceCodeHyperlink.setEnabled(adss.getModel().getApplicationParts().isEmpty());
				buildAllHyperlink.setEnabled(analyzeSourceCodeHyperlink.isEnabled());
				if (analyzeSourceCodeHyperlink.isEnabled())
					return;

				findAttacksHyperlink.setEnabled(adss.getModel().getAttackPaths().isEmpty());
				if (findAttacksHyperlink.isEnabled())
					return;

				findProtectionsHyperlink.setEnabled(true);
				for (Protection i : adss.getModel().getAvailableProtections())
					for (AttackMitigation j : i.getMitigations())
						if (!j.getAttackPaths().isEmpty())
							findProtectionsHyperlink.setEnabled(false);
				if (findProtectionsHyperlink.isEnabled())
					return;

				computeMetricsAction.setEnabled(adss.getModel().getSolutions().isEmpty());
				computeCoefficientsAction.setEnabled(adss.getModel().getSolutions().isEmpty());
				findFirstLevelProtectionsHyperlink.setEnabled(adss.getModel().getSolutions().isEmpty());
				if (findFirstLevelProtectionsHyperlink.isEnabled())
					return;

				findSecondLevelProtectionsHyperlink.setEnabled(true);
				for (Solution sol : adss.getModel().getSolutions())
					if (sol.getFirstLevelSolution() != null)
					{
						findSecondLevelProtectionsHyperlink.setEnabled(false);
						break;
					}

				deploySolutionghHyperlink.setEnabled(true);
			}
		});
	}

	/**
	 * Creates an hyperlink adapter.
	 * @param name
	 *            The job name.
	 * @param executable
	 *            The executable.
	 * @return The hyperlink adapter.
	 **/
	private IHyperlinkListener createAdapter(final String name, final Executable executable)
	{
		return new HyperlinkAdapter()
		{
			@Override
			public void linkActivated(HyperlinkEvent e)
			{
				Job job = new Job(name)
				{
					@Override
					protected IStatus run(IProgressMonitor monitor)
					{
						try
						{
							executable.execute();
							return Status.OK_STATUS;
						}
						catch (Exception e)
						{
							e.printStackTrace();
							return Status.CANCEL_STATUS;
						}
					}
				};
				job.setUser(true);
				job.schedule();
			}
		};
	}

	/**
	 * Creates the ADSS logo.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createLogo(IManagedForm managedForm) throws Exception
	{
		Label logoImage = managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "");
		logoImage.setImage(Eclipse.getImage(eu.aspire_fp7.adss.full.akb.ui.Activator.PLUGIN_ID, "icons/logo.png"));
		logoImage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));
	}
}
