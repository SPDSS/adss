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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
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
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Object;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNetDoc;
import org.pnml.tools.epnk.pnmlcoremodel.PnmlcoremodelFactory;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;
import org.uel.aspire.wp5.assessment.APIs.loadPetriNets;
import org.uel.aspire.wp5.assessment.model.convertOWL;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.ui.Activator;

import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;

import eu.aspire_fp7.adss.akb.ui.providers.NameLabelProvider;


import eu.aspire_fp7.adss.light.akb.ui.providers.AttackStepsContentProvider;

import eu.aspire_fp7.adss.util.Eclipse;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.OntologySaveException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

import org.uel.aspire.wp5.assessment.APIs.*;
/**
 * The pn overview page.
 * @author Gaofeng Zhang
 **/
public class PNOverviewPage extends FormPage
{
	/** The ADSS. **/
	private ADSS adss;	
	/** The list of transitions in PNML. **/
	private List<Transition> transitions;
	
	/** The PNML file path + filename. **/
	//only for light version, Gaofeng, 2016-6-02.
	private Text pnDirectoryText;
	private Text pnFileText;
	
	/* the relation between transition (the transition.getName().getText()) and attack steps AttackStep.getName()*/
	private HashMap<String, String> mapping;
	//////////////////////////
	
	private PetriNet pn;

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param adss
	 *            The ADSS.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public PNOverviewPage(FormEditor editor, ADSS adss) throws Exception
	{
		super(editor, "pnoverview", "PetriNetOverview");
		this.adss = adss;	
		mapping = new HashMap<String, String>();
		//transitions = new List<Transition>();
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
			form.setText("PetriNet Model Overview");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/all.png"));
			form.getBody().setLayout(new GridLayout(2, false));

			createPNGenerationSection(managedForm);
			
			createSourceDirectorySection(managedForm);
			
			createTransitionMapSection(managedForm);		
			createLogo(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void createPNGenerationSection(IManagedForm managedForm) throws Exception
	{
		SectionPart PNGenerationSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(PNGenerationSectionPart);
		
		PNGenerationSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		PNGenerationSectionPart.getSection().setText("Create PNML from AKB");
		
		Composite PNGenerationComposite = new Composite(PNGenerationSectionPart.getSection(), SWT.NONE);		
		managedForm.getToolkit().adapt(PNGenerationComposite);
		managedForm.getToolkit().paintBordersFor(PNGenerationComposite);
		PNGenerationSectionPart.getSection().setClient(PNGenerationComposite);
		PNGenerationComposite.setLayout(new GridLayout(3, false));
		
		////////////////
		managedForm.getToolkit().createLabel(PNGenerationComposite, "All ApplicationParts in this Use Case:");
		final Combo targetCombo1 = new Combo(PNGenerationComposite, SWT.READ_ONLY);		
		targetCombo1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//targetCombo1.add("All ApplicationParts in this use case");
				
		for(int i=0; i < adss.getModel().getApplicationParts().size(); i++ )
		{			
			targetCombo1.add(adss.getModel().getApplicationParts().get(i).getName());
		}	
		targetCombo1.select(0);
		
		Text blankText0 = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE|SWT.READ_ONLY);
		blankText0.setVisible(false);
		/*
		managedForm.getToolkit().createLabel(PNGenerationComposite, "All Propertys in this Use Case:");
		final Combo targetCombo2 = new Combo(PNGenerationComposite, SWT.READ_ONLY);		
		targetCombo2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//targetCombo2.add("All Propertys in this use case");
				
		for(int i=0; i < adss.getModel().getPropertys().size(); i++ )
		{		
			targetCombo2.add(adss.getModel().getPropertys().get(i).getName());
		}	
		targetCombo2.select(0);
		
		Text blankText00 = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE|SWT.READ_ONLY);
		blankText00.setVisible(false);*/
		////////////////
		
		Button pnGenerationButton = managedForm.getToolkit().createButton(PNGenerationComposite, "Create PNML Model", SWT.NONE);
		Text GenerationStatusText = managedForm.getToolkit().createText(PNGenerationComposite, "                                             "
				+ "                                       ",  SWT.FULL_SELECTION |SWT.HORIZONTAL| SWT.LEFT |  SWT.FILL |SWT.READ_ONLY);
		Text blankText1 = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE|SWT.READ_ONLY);
		blankText1.setVisible(false);
		Button pnSaveButton = managedForm.getToolkit().createButton(PNGenerationComposite, "Save PNML Model", SWT.NONE);
		Text saveStatusText = managedForm.getToolkit().createText(PNGenerationComposite, "                                    "
				+ "                                       ",  SWT.FULL_SELECTION |SWT.HORIZONTAL| SWT.LEFT |  SWT.FILL |SWT.READ_ONLY);
		//test
		Button pnAssessButton = managedForm.getToolkit().createButton(PNGenerationComposite, "Do Assessment on PNML", SWT.NONE);
		pnAssessButton.setVisible(false);
		//
		/*Text blankText2 = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE|SWT.READ_ONLY);
		blankText2.setVisible(false);*/
		/*Text blankText3 = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE|SWT.READ_ONLY);
		blankText3.setVisible(false);*/
		managedForm.getToolkit().createLabel(PNGenerationComposite, "PNML Directory : ");

		Text pnDirectoryText = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE);
		pnDirectoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		pnDirectoryText.setText("E:/eclipse mars for ADSS/workspace/org.pnml.tools.epnk.examples_1.0.0/");
		//pnDirectoryText.setText(adss.getModel().getPreferences().getSetPNDirectory());
		Button pnDirectoryButton = managedForm.getToolkit().createButton(PNGenerationComposite, "Browse...", SWT.NONE);
		
		managedForm.getToolkit().createLabel(PNGenerationComposite, "PNML File : ");
		Text pnFileText = managedForm.getToolkit().createText(PNGenerationComposite, "", SWT.NONE);
		pnFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		pnFileText.setText("WBC Attack - AKB.pnml");
		Button pnFileButton = managedForm.getToolkit().createButton(PNGenerationComposite, "Browse...", SWT.NONE);
		//pnFileText.setText(adss.getModel().getPreferences().getSetPNFile());
		

		
		pnGenerationButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				try{
					//System.out.println(adss.getModel().getAttackPathsCount());
					convertOWL pnGeneration;
					//if(targetCombo.getSelectionIndex() == 0)
					//{
						//System.out.println("000");
					//	pnGeneration = new convertOWL(adss);
					//}
					//else
					//{
						//System.out.println("001");
						//ApplicationPart ap = adss.getModel().getApplicationParts().get(targetCombo.getSelectionIndex()-1);
					ApplicationPart ap = adss.getModel().getApplicationParts().get(targetCombo1.getSelectionIndex());
					//Property pr = adss.getModel().getPropertys().get(targetCombo2.getSelectionIndex());
						ArrayList<AttackPath> apsSelected = new ArrayList<AttackPath>();
						//for(int i=0;i<adss.getModel().getAttackPathsCount();i++)
						//{
							//System.out.print(i + "  ");
							//System.out.println(adss.getModel().getAttackPaths().get(i).getTargets().get(0).getApplicationPart());
						//	if (adss.getModel().getAttackPaths().get(i).getTargets().get(0).getApplicationPart().hashCode() == ap.hashCode() )
						//		apsSelected.add(adss.getModel().getAttackPaths().get(i));
						//}
						for(int i=0; i< adss.getModel().getAttackPathsCount();i++)
						{
							for(int j=0; j < adss.getModel().getAttackPaths().get(i).getTargets().size();j++)
							{
								if( (adss.getModel().getAttackPaths().get(i).getTargets().get(j).getApplicationPart().hashCode() ==
										ap.hashCode()))
										//&& (adss.getModel().getAttackPaths().get(i).getTargets().get(j).getProperty().hashCode() ==
										//pr.hashCode() ))
								{
									apsSelected.add(adss.getModel().getAttackPaths().get(i));
									break;
								}
							}
						}
						//System.out.println("ap is " + ap);
						//System.out.println("apsSelected.size() is " + apsSelected.size());
						
						pnGeneration = new convertOWL(adss.getModel(), apsSelected);						
						
					//}
					//System.out.println("111");			
					pn = pnGeneration.getPN();
					
					
					if(pn ==null) {GenerationStatusText.setText("There is no AttackPath selected, so the PetriNet model is empty!");return;}
					//System.out.println("222");
					GenerationStatusText.setText("The PetriNet model generated SUCESSFULLY!");
				}
				catch(Exception ee)
				{
					System.out.println("ERROR! The PetriNet model is generated UNSUCCESSFUL!");
					System.out.println(ee);
				}
			}
		});
		pnSaveButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent ee)
			{
				if (pn!= null)
				{
					String file = pnDirectoryText.getText() + pnFileText.getText();
					
					//System.out.println("file is " + file);
					//System.out.println();
					
					PetriNetDoc doc = PnmlcoremodelFactory.eINSTANCE.createPetriNetDoc();
					doc.getNet().add(pn);
					ResourceSet resourceSet = new ResourceSetImpl();
					final URI uri = URI.createFileURI(file);
					//System.out.println(uri);
					final Resource resource = resourceSet.createResource(uri);
					//System.out.println("111");
					EList<EObject> contents = resource.getContents();
					//System.out.println("222");
					contents.add(doc);		
					
					//System.out.println("contents.size() is " + contents.size() );
					//System.out.println();
					
						try {
							//resource.save(new HashMap<String,Object>());
							resource.save(null);
							saveStatusText.setText("PNML file saved SUCESSFULLY!");
						} catch (IOException e1) {							
							e1.printStackTrace();
							saveStatusText.setText("PNML file saved UNSUCESSFULLY!");
						}							
				}
				else
				{
					System.out.println("PNML model has not been generated!");
				}
			}
		});

		pnDirectoryText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				//TODO				
			}
		});
		pnFileText.addModifyListener(new ModifyListener()
		{

			@Override
			public void modifyText(ModifyEvent e)
			{
				//TODO				
			}
		});
		pnDirectoryButton.addSelectionListener(new SelectionAdapter()
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
							//adss.getModel().getPreferences().setSetPNDirectory(directory);
							pnDirectoryText.setText(directory);
						}
					}
				});
			}
		});
		pnFileButton.addSelectionListener(new SelectionAdapter()
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
						dialog.setFilterExtensions(new String[] { "*.pnml" });
						String file = dialog.open();
						if (file != null)
						{								
							//adss.getModel().getPreferences().setSetPNFile(file);
							pnFileText.setText(file);
						}
					}
				});
			}
		});		
		
		targetCombo1.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{	
				//TODO
			}
		}
		);
		
		
		//test
		pnAssessButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent ee)
			{
					/*for(int i=0;i< adss.getModel().getSolutions().get(0).getApplicationMetrics().size();i++)
					{
						System.out.println(adss.getModel().getSolutions().get(0).getApplicationMetrics().get(i).getName());
					}*/
					AssessmentFunction af = new AssessmentFunction(adss.getModel(), adss.getModel().getApplicationParts().get(targetCombo1.getSelectionIndex()), adss.getModel().getSolutions()); 
					System.out.println( adss.getModel().getVanillaSolution().getApplicationMetrics() );
					System.out.println( adss.getModel().getSolutions().get(0).getApplicationMetrics() );
					System.out.println( adss.getModel().getSolutions().get(2).getApplicationMetrics() );
					System.out.println( af.runAssessment() );
					System.out.println( af.getKeyPath());	
			}
		});
		
	}

	private void createSourceDirectorySection(IManagedForm managedForm) throws Exception
	{
		SectionPart sourceDirectorySectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(sourceDirectorySectionPart);
		sourceDirectorySectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		sourceDirectorySectionPart.getSection().setText("PNML File Directory");

		Composite sourceDirectoryComposite = new Composite(sourceDirectorySectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(sourceDirectoryComposite);
		managedForm.getToolkit().paintBordersFor(sourceDirectoryComposite);
		sourceDirectorySectionPart.getSection().setClient(sourceDirectoryComposite);
		sourceDirectoryComposite.setLayout(new GridLayout(3, false));	

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "PNML Directory : ");

		pnDirectoryText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		pnDirectoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		pnDirectoryText.setText("E:/eclipse mars for ADSS/workspace/org.pnml.tools.epnk.examples_1.0.0/");
		//pnDirectoryText.setText(adss.getModel().getPreferences().getSetPNDirectory());
		Button pnDirectoryButton = managedForm.getToolkit().createButton(sourceDirectoryComposite, "Browse...", SWT.NONE);
		
		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "PNML File : ");
		pnFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		pnFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		pnFileText.setText("WBC Attack - AKB.pnml");
		//pnFileText.setText(adss.getModel().getPreferences().getSetPNFile());

		Button pnFileButton = managedForm.getToolkit().createButton(sourceDirectoryComposite, "Browse...", SWT.NONE);	
		
		pnDirectoryText.addModifyListener(new ModifyListener()
		{

			@Override
			public void modifyText(ModifyEvent e)
			{
				
				adss.getModel().getPreferences().setSetPNDirectory(pnDirectoryText.getText());
			}
		});
		pnFileText.addModifyListener(new ModifyListener()
		{

			@Override
			public void modifyText(ModifyEvent e)
			{
				
				adss.getModel().getPreferences().setSetPNFile(pnFileText.getText());
			}
		});
		pnDirectoryButton.addSelectionListener(new SelectionAdapter()
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
							
							adss.getModel().getPreferences().setSetPNDirectory(directory);
							pnDirectoryText.setText(adss.getModel().getPreferences().getSetPNDirectory());
						}
					}
				});
			}
		});
		pnFileButton.addSelectionListener(new SelectionAdapter()
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
						dialog.setFilterExtensions(new String[] { "*.pnml" });
						String file = dialog.open();
						if (file != null)
						{							
							adss.getModel().getPreferences().setSetPNFile(file);
							pnFileText.setText(adss.getModel().getPreferences().getSetPNFile());
						}
					}
				});
			}
		});			
		
	}

	/**
	 * Creates the section to map the attack steps and transitions.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createTransitionMapSection(IManagedForm managedForm) throws Exception
	{
		SectionPart transitionMapSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR | Section.DESCRIPTION);
		managedForm.addPart(transitionMapSectionPart);
		transitionMapSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		transitionMapSectionPart.getSection().setText("Transition Mapping");
		transitionMapSectionPart.getSection().setDescription("Link Transitions from PetriNet and Attack Steps from AKB");

		Composite transitionMapComposite = new Composite(transitionMapSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(transitionMapComposite);
		managedForm.getToolkit().paintBordersFor(transitionMapComposite);
		transitionMapSectionPart.getSection().setClient(transitionMapComposite);
		transitionMapComposite.setLayout(new GridLayout(1, false));
		
		final Button loadButton = managedForm.getToolkit().createButton(transitionMapComposite, "Load PNML Model", SWT.NONE);
		loadButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));	
		
		Group mappingGroup = new Group(transitionMapComposite, SWT.NONE);
		mappingGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		mappingGroup.setText("Transitions from PNML");
		mappingGroup.setLayout(new GridLayout(1, false));
		managedForm.getToolkit().paintBordersFor(mappingGroup);
		managedForm.getToolkit().createLabel(mappingGroup, "Transitions : ");
		
		final Combo transitionCombo = new Combo(mappingGroup, SWT.READ_ONLY);		
		transitionCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));	
	
		PatternFilter filter = new PatternFilter();
		filter.setIncludeLeadingWildcard(true);
		FilteredTree asFilteredTree = new FilteredTree(transitionMapComposite, SWT.BORDER | SWT.VIRTUAL | SWT.CHECK, filter, true);
		TreeViewer asTreeViewer = asFilteredTree.getViewer();	
		
		TreeViewerColumn asnameViewerColumn = new TreeViewerColumn(asTreeViewer, SWT.NONE);
		TreeColumn asnameColumn = asnameViewerColumn.getColumn();
		TreeColumnLayout ascolumnLayout = new TreeColumnLayout();
		ascolumnLayout.setColumnData(asnameColumn, new ColumnWeightData(4));	
		asTreeViewer.getControl().getParent().setLayout(ascolumnLayout);		
		Tree asTree = asTreeViewer.getTree();
		asTree.setHeaderVisible(true);
		asTree.setLinesVisible(true);
		asTree.setItemCount(adss.getModel().getAttackStepsCount());
		managedForm.getToolkit().paintBordersFor(asFilteredTree);		
		asnameViewerColumn.setLabelProvider(new NameLabelProvider(true));	
		asTreeViewer.setContentProvider(new AttackStepsContentProvider());			
			
		asTreeViewer.setInput(adss.getModel());
		asTreeViewer.getTree().setVisible(false);
		
		loadButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{						
				loadPetriNets lpn  = new loadPetriNets(pnDirectoryText.getText(),pnFileText.getText());
				FlatAccess flat = new FlatAccess(lpn.getPN().get(0));		
				transitions = flat.getTransitions();
				try{
					mapping = obtainMapping(transitions,  adss.getModel().getAttackSteps());	
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				if(transitions!= null)
				{
					for(int i=0;i<transitions.size();i++)
					{			
						transitionCombo.add(transitions.get(i).getName().getText());
					}
					transitionCombo.select(0);	
				}
				if(transitions==null)
				{
					asTreeViewer.setInput(null);
				}
				else
				{
					asTreeViewer.getTree().setVisible(true);
					asTreeViewer.setInput(adss.getModel());	
					int stepSelected = -1;
					String tranname = transitions.get(transitionCombo.getSelectionIndex()).getName().getText();
					String stepname = mapping.get(tranname);
					for(int j = 0;j<adss.getModel().getAttackStepsCount();j++)
					{
						if(stepname == adss.getModel().getAttackSteps().get(j).getName())
						{
							stepSelected = j;
							break;
						}						 
					}					
					for(int i=0;i<adss.getModel().getAttackStepsCount();i++)
					{
						if (i == stepSelected)
						{
							asTreeViewer.getTree().getItems()[i].setChecked(true);
						}
						else
						{
							asTreeViewer.getTree().getItems()[i].setChecked(false);
						}
					}					
				}
				
				//set a random initial for the mapping between transitions and attack steps 
				for(int i=0; i < adss.getModel().getAttackStepsCount();i++)
				{
					Random ra = new Random();
					int index =  ra.nextInt(transitions.size()); 
					adss.getModel().getAttackSteps().get(i).setTransition( transitions.get(index).getName().getText() );
					//asTreeViewer.getTree().getItemCount()
				}
			}
		});	
		
		///test
		/*for (int i=0; i<8; i++) {
			Button button = managedForm.getToolkit().createButton(transitionMapComposite, "Load PNML Model", SWT.RADIO);
			button.setText ("B" + i);
			if (i == 0) button.setSelection (true);
		}*/
		//button.this.
		/*Button button = new Button (shell, SWT.PUSH);
		button.setText ("Set Selection to B4");
		button.addListener (SWT.Selection, event -> {
			Control [] children = shell.getChildren ();
			Button newButton = (Button) children [4];
			for (int i=0; i<children.length; i++) {
				Control child = children [i];
				if (child instanceof Button && (child.getStyle () & SWT.RADIO) != 0) {
					((Button) child).setSelection (false);
				}
			}
			newButton.setSelection (true);
		});	*/
		///
		
		transitionCombo.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{	
				try {
					adss.save();
				} catch (OntologySaveException ex) {
				
					ex.printStackTrace();
				} catch (CoreException ex) {
					
					ex.printStackTrace();
				} catch (OntologyChangeException ex) {
					
					ex.printStackTrace();
				} catch (ParsingErrorException ex) {
					
					ex.printStackTrace();
				} catch (NoSuchEntityException ex) {
					
					ex.printStackTrace();
				} catch (IOException ex) {
					
					ex.printStackTrace();
				} catch (InconsistencyException ex) {
					
					ex.printStackTrace();
				} catch (ReasoningInterruptedException ex) {
					
					ex.printStackTrace();
				}	
				
				if(transitions==null)
				{
					asTreeViewer.setInput(null);
				}
				else
				{					
					asTreeViewer.getTree().setVisible(true);
					asTreeViewer.setInput(adss.getModel());	
					int stepSelected = -1;
					String tranname = transitions.get(transitionCombo.getSelectionIndex()).getName().getText();
					
					try {
						mapping = obtainMapping(transitions, adss.getModel().getAttackSteps());
					} catch (Exception e1) {						
						e1.printStackTrace();
					}	
					String stepname = mapping.get(tranname);
					for(int j = 0;j<adss.getModel().getAttackStepsCount();j++)
					{
						if(stepname == adss.getModel().getAttackSteps().get(j).getName())
						{
							stepSelected = j;
							break;
						}						 
					}					
					for(int i=0;i<adss.getModel().getAttackStepsCount();i++)
					{
						if (i == stepSelected)
						{
							asTreeViewer.getTree().getItems()[i].setChecked(true);
							//System.out.println("+");
						}
						else
						{
							asTreeViewer.getTree().getItems()[i].setChecked(false);
							//System.out.println(i);
						}
					}					
				}	
			}
		});
		
		//asTreeViewer.getTree().addListener(SWT.CHECK|SWT.Selection, new Listener()
		asTreeViewer.getTree().addListener(SWT.Selection, new Listener()
		{
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event)
			{
				ITreeSelection selection = (ITreeSelection) asTreeViewer.getSelection();
				//System.out.println("++++++++++++" );
				if (event.detail == SWT.CHECK && selection.getFirstElement() instanceof AttackStep)
				//if (event.detail == SWT.CHECK )
				{	
										
					//System.out.println("**************"  + ((AttackStep)selection.getFirstElement()).getName());
					/*int checked = -1;
					for(int i=0;i<asTreeViewer.getTree().getItemCount();i++)
					{
						if (asTreeViewer.getTree().getItems()[i].getChecked() ) {checked = i; continue;}
					}
					adss.getModel().getAttackSteps().get(checked).setTransition( transitions.get(transitionCombo.getSelectionIndex()).getName().getText() );
					*/
					if( asTreeViewer.getTree().getSelection()[0].getChecked() )
					{
						//System.out.println("/////////////////" );
						adss.getModel().getAttackSteps().get( adss.getModel().getAttackSteps().indexOf((AttackStep)selection.getFirstElement()) ).setTransition( transitions.get(transitionCombo.getSelectionIndex()).getName().getText() );
						for(int i=0;i<adss.getModel().getAttackStepsCount();i++)
						{
							if (adss.getModel().getAttackSteps().get(i).hashCode() != selection.getFirstElement().hashCode() )
							{	
								if(adss.getModel().getAttackSteps().get(i).getTransition() == transitions.get(transitionCombo.getSelectionIndex()).getName().getText())
								{
									if (adss.getModel().getAttackSteps().get(i).getTransition() != "") 
									{
										adss.getModel().getAttackSteps().get(i).setTransition("") ;									
									}
								}
							}
						}
						for(int i=0;i<asTreeViewer.getTree().getItemCount();i++)
						{
							if ( asTreeViewer.getTree().getItems()[i].hashCode() != asTreeViewer.getTree().getSelection()[0].hashCode() )
							{
								asTreeViewer.getTree().getItems()[i].setChecked(false);
							}
							else
							{
								asTreeViewer.getTree().getItems()[i].setChecked(true);
							}
						}
					}
					else
					{		//System.out.println("***********" );				
						adss.getModel().getAttackSteps().get( adss.getModel().getAttackSteps().indexOf((AttackStep)selection.getFirstElement()) ).setTransition( "" );						
					}

				}
				
				try {
					adss.save();
				} catch (OntologySaveException e) {
				
					e.printStackTrace();
				} catch (CoreException e) {
					
					e.printStackTrace();
				} catch (OntologyChangeException e) {
					
					e.printStackTrace();
				} catch (ParsingErrorException e) {
					
					e.printStackTrace();
				} catch (NoSuchEntityException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (InconsistencyException e) {
					
					e.printStackTrace();
				} catch (ReasoningInterruptedException e) {
					
					e.printStackTrace();
				}	
	
			}	
			
			
		});
					for(int i=0;i<adss.getModel().getAttackStepsCount();i++)
				{
					//if ( adss.getModel().getAttackSteps().get(i).getTransition() =="") continue;
					//System.out.println(adss.getModel().getAttackSteps().get(i).getTransition() );
				//	System.out.println(adss.getModel().getSolutions().get(i).getApplicationMetrics() );
				//	System.out.println(adss.getModel().getSolutions().get(i).getApplicationPartMetricSets() );
				}
		final Button saveButton = managedForm.getToolkit().createButton(transitionMapComposite, "Save the Mapping Relations", SWT.NONE);
		saveButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));		
		saveButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent ee)
			{
				
				//here is the code to save mapping relations to AKB or some other files
				//AKB file has been saved in previous listener method. 
				try {
					adss.save();
				} catch (OntologySaveException e) {
				
					e.printStackTrace();
				} catch (CoreException e) {
					
					e.printStackTrace();
				} catch (OntologyChangeException e) {
					
					e.printStackTrace();
				} catch (ParsingErrorException e) {
					
					e.printStackTrace();
				} catch (NoSuchEntityException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (InconsistencyException e) {
					
					e.printStackTrace();
				} catch (ReasoningInterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});	

		for(int i=0;i<adss.getModel().getAttackStepsCount();i++)
		{
			//System.out.println(adss.getModel().getAttackSteps().get(i).getTransition() );
			//System.out.println(adss.getModel().getSolutions().get(i).getApplicationMetrics() );
			//System.out.println(adss.getModel().getSolutions().get(i).getApplicationPartMetricSets() );
		}
		
	}
	
	/**
	 * Creates the hashmap between transitions and attack steps.
	 * @param List<Transition> transitions, EList<AttackStep> attackSteps.
	 * @throws Exception
	 *             If something goes wrong.
	 **/

	protected HashMap<String, String> obtainMapping(List<Transition> transitions, EList<AttackStep> attackSteps) throws Exception
	{		
		for(int i=0;i<attackSteps.size();i++)
		{
			String sname = attackSteps.get(i).getName();
			
			String tname = "";
			tname = attackSteps.get(i).getTransition();
			if(tname == null || tname == "")
			{
				continue;
			}
			else
			{
				for(int j=0; j<transitions.size();j++)
				{
					if(tname == transitions.get(j).getName().getText())
					{
						mapping.put(tname, sname);
						break;
					}
				}
				
			}			
		}		
		return mapping;
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
		logoImage.setImage(Eclipse.getImage(eu.aspire_fp7.adss.light.akb.ui.Activator.PLUGIN_ID, "icons/logo.png"));
		logoImage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));
	}
}
