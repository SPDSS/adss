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

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;



import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
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
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.uel.aspire.wp4.assessment.APIs.AssessmentProcessBoth2;
import org.uel.aspire.wp4.comparetoolchains.AssessSimulation2;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;

import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.Metric;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.Solution;

import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;

import eu.aspire_fp7.adss.akb.ui.providers.NameLabelProvider;
import eu.aspire_fp7.adss.connectors.ACTCConnector;
import eu.aspire_fp7.adss.light.akb.ui.providers.AttackPathsContentProvider;
import eu.aspire_fp7.adss.light.akb.ui.providers.ProtectionSolutionContentProvider;


/**
 * The page to do the ADSS light version.
 * @author Gaofeng Zhang
 * 31/04/2016 at uel.
 **/
public class SPAUIPage extends FormPage implements ADSSEventListener
{
	
	private ADSS adss;
	
	private ADSSEventGenerator eventGenerator;
	
	private AssessmentProcessBoth2 assessment;
	
	private SPAResultPage resultPage;
	

	private ArrayList<Boolean> psAssessed;// this protection solution has been assessed?
	private int curps = -1;
	private int curap = -1;
	private ArrayList<Boolean> apAssessed; // this attack path/model has been assessed? 
	//private ArrayList<ArrayList<Double> > bestPS; // first integer is the number of attack path/model, the second integer is the best PS of this model/path
	
	private HashMap<String,ArrayList<Double> > bestPS; // the key is the hashcodes of each attack paths(hashcode1 + hashcode2 + ......), the value is the list of results on different PS 
	private ArrayList<AttackPath> apsSelected; // the attack paths have been selected for assessment
	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param adss
	 *            The ADSS.
	 * @param eventGenerator
	 *            The event generator.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public SPAUIPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator, SPAResultPage resultPage) throws Exception
	{
		super(editor, "spauipage", "Protection Assessment");
		
		this.adss = adss;
		this.eventGenerator = eventGenerator;
		this.resultPage = resultPage;
		assessment = new AssessmentProcessBoth2(adss);
		ArrayList<String>  measureList = new ArrayList<String>();// = adss.getModel().getMetrics().keySet().toArray()[9];
		ArrayList<Metric> ms = new ArrayList<Metric>();
		for (int i=0;i<adss.getModel().getVanillaSolution().getApplicationMetrics().size();i++)
		{
			String temp= adss.getModel().getVanillaSolution().getApplicationMetrics().get(i).getName();
			measureList.add(temp);
			ms.add(adss.getModel().getVanillaSolution().getApplicationMetrics().get(i));
		}
		assessment.initMeasureList(measureList);
		
		psAssessed = new ArrayList<Boolean>();
		apAssessed = new ArrayList<Boolean>();
		
		apsSelected = new ArrayList<AttackPath>();
		
		bestPS = new HashMap<String,ArrayList<Double> >(); 
		for(int i=0; i < adss.getModel().getAttackPathsCount()+1;i++)
		{
			apAssessed.add(false);
			//apsSelected.add(false);
			/*ArrayList<Double> temp = new ArrayList<Double>();
			for(int j=0;j < adss.getModel().getSolutions().size();j++)
			{
				temp.add(Double.MAX_VALUE);
			}
			bestPS.add(temp);*/
			psAssessed.add(false);
		}
		
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
			
			form.setText("Software Protection Assessment");
//			form.setText("ADSS Light Version");
//			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/all.png"));
			form.getBody().setLayout(new GridLayout(2, false));
	
			createAssessmentConfigurationSection(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	


	private void createAssessmentConfigurationSection(final IManagedForm managedForm)
	{
		SectionPart attackPathSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(attackPathSectionPart);
		attackPathSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		attackPathSectionPart.getSection().setText("Attack Paths");

		Composite attackPathComposite = new Composite(attackPathSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(attackPathComposite);
		managedForm.getToolkit().paintBordersFor(attackPathComposite);
		attackPathSectionPart.getSection().setClient(attackPathComposite);
		attackPathComposite.setLayout(new GridLayout(1, true));
		
		Group attackModelGroup = new Group(attackPathComposite, SWT.NONE);
		attackModelGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		attackModelGroup.setText("Attack Paths from AKB");
		attackModelGroup.setLayout(new GridLayout(2, false));
		managedForm.getToolkit().paintBordersFor(attackModelGroup);
		
		
		//this is the combo way to select attack paths. by gaofeng 26/05/2016
		/*
		managedForm.getToolkit().createLabel(attackModelGroup, "Attack paths:");		
		final Combo attackpathCombo = new Combo(attackModelGroup, SWT.READ_ONLY);
		attackpathCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		int pathsize = adss.getModel().getAttackPathsCount();
		attackpathCombo.add("ALL Attack Paths in This Use Case");
		for(int i=0;i<pathsize;i++)
		{			
			attackpathCombo.add(adss.getModel().getAttackPaths().get(i).toString());
		}
		
		attackpathCombo.select(0);*/
		
		//////////////////////display attack paths graphically tree , by gaofeng @uel, 04/05/2016
		//managedForm.getToolkit().createLabel(assessmentConfigurationComposite, "Protection Solution Selected:");
		PatternFilter filterap = new PatternFilter();
		filterap.setIncludeLeadingWildcard(true);
		FilteredTree apFilteredTree = new FilteredTree(attackPathComposite, SWT.BORDER | SWT.VIRTUAL | SWT.CHECK, filterap, true);
		TreeViewer apTreeViewer = apFilteredTree.getViewer();
		//TreeViewer psTreeViewer = new TreeViewer(assessmentConfigurationComposite, SWT.BORDER | SWT.VIRTUAL);
		apTreeViewer.setAutoExpandLevel(1);
		TreeColumnLayout columnLayout = new TreeColumnLayout();
		apTreeViewer.getControl().getParent().setLayout(columnLayout);
		
		Tree apTree = apTreeViewer.getTree();
		apTree.setHeaderVisible(true);
		apTree.setLinesVisible(true);
		managedForm.getToolkit().paintBordersFor(apFilteredTree);

		TreeViewerColumn nameViewerColumn = new TreeViewerColumn(apTreeViewer, SWT.NONE);
		TreeColumn nameColumn = nameViewerColumn.getColumn();		
		columnLayout.setColumnData(nameColumn, new ColumnWeightData(4));

		nameViewerColumn.setLabelProvider(new NameLabelProvider(false));
		

		apTreeViewer.setContentProvider(new AttackPathsContentProvider());
		apTreeViewer.setInput(adss.getModel());
		
		//the initial attack paths include all paths
		for (int i=0;i< adss.getModel().getAttackPathsCount();i++)
		{
			apsSelected.add(adss.getModel().getAttackPaths().get(i));
			apTreeViewer.getTree().getItem(i).setChecked(true);			
		}
		//
		apTreeViewer.getTree().addListener(SWT.Selection, new Listener()
		{
			@Override
			public void handleEvent(org.eclipse.swt.widgets.Event event)
			{
				ITreeSelection selection = (ITreeSelection) apTreeViewer.getSelection();
				if (event.detail == SWT.CHECK && selection.getFirstElement() instanceof AttackPath)
				{
					//adss.getModel().getAttackPaths().indexOf((AttackPath)selection.getFirstElement());
					if(apTreeViewer.getTree().getSelection()[0].getChecked())
					{
						apsSelected.add((AttackPath)selection.getFirstElement());
					}
					else
					{
						apsSelected.remove((AttackPath)selection.getFirstElement());
					}
					//apSelected.set(adss.getModel().getAttackPaths().indexOf((AttackPath)selection.getFirstElement()), apTreeViewer.getTree().getSelection()[0].getChecked());
					//Protection protection = (Protection) selection.getFirstElement();
					//protection.setEnabled(protectionsTreeViewer.getTree().getSelection()[0].getChecked());
					//eventGenerator.fireEvent(Event.PROTECTIONS_UPDATED);
				}
			}
		});
		/*if(attackpathCombo.getSelectionIndex() == 0 )
		{
			apTreeViewer.setInput(adss.getModel());
		}
		else
		{
			apTreeViewer.setInput(adss.getModel().getAttackPaths().get(attackpathCombo.getSelectionIndex()-1));
		}
		//////////////////////
		
		attackpathCombo.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				ArrayList<AttackPath> aps = new ArrayList<AttackPath>();
				if(attackpathCombo.getSelectionIndex() == 0)
				{
					int size = adss.getModel().getAttackPaths().size();
					for(int i=0;i<size;i++)
					{
						aps.add(adss.getModel().getAttackPaths().get(i));
					}
					//aps = (ArrayList<AttackPath>) adss.getModel().getAttackPaths();
					assessment.initModel(aps, true);
				}
				else
				{
					aps.add(adss.getModel().getAttackPaths().get(attackpathCombo.getSelectionIndex()-1));
					assessment.initModel(aps, true);
				}
				curap = attackpathCombo.getSelectionIndex();
				
				if(attackpathCombo.getSelectionIndex() == 0 )
				{
					apTreeViewer.setInput(adss.getModel());
				}
				else
				{
					apTreeViewer.setInput(adss.getModel().getAttackPaths().get(attackpathCombo.getSelectionIndex()-1));
				}
				
			}
		});*/
		////////////////////////////////////////////////////////

		SectionPart solutionSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(solutionSectionPart);
		solutionSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		solutionSectionPart.getSection().setText("Protection Solution");

		Composite solutionComposite = new Composite(solutionSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(solutionComposite);
		managedForm.getToolkit().paintBordersFor(solutionComposite);
		solutionSectionPart.getSection().setClient(solutionComposite);
		solutionComposite.setLayout(new GridLayout(1, true));
		
		Group solutionGroup = new Group(solutionComposite, SWT.NONE);
		solutionGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		solutionGroup.setText("Protection Solutions from AKB");
		solutionGroup.setLayout(new GridLayout(2, false));
		managedForm.getToolkit().paintBordersFor(solutionGroup);
		managedForm.getToolkit().createLabel(solutionGroup, "Protection Solution:");
		
		final Combo protectionConfigurationCombo1 = new Combo(solutionGroup, SWT.READ_ONLY);
		
		protectionConfigurationCombo1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	
		int protectionsize = adss.getModel().getSolutionsCount();
		for(int i=0;i<protectionsize;i++)
		{			
			protectionConfigurationCombo1.add(Integer.toString(adss.getModel().getSolutions().get(i).hashCode()));
		}
		protectionConfigurationCombo1.select(0);		

		
		//////////////////////display solution graphically tree , by gaofeng @uel, 04/05/2016
		//managedForm.getToolkit().createLabel(assessmentConfigurationComposite, "Protection Solution Selected:");
		
		PatternFilter filter = new PatternFilter();
		filter.setIncludeLeadingWildcard(true);
		FilteredTree psFilteredTree = new FilteredTree(solutionComposite, SWT.BORDER | SWT.VIRTUAL, filter, true);
		TreeViewer psTreeViewer = psFilteredTree.getViewer();
		//TreeViewer psTreeViewer = new TreeViewer(assessmentConfigurationComposite, SWT.BORDER | SWT.VIRTUAL);
		psTreeViewer.setAutoExpandLevel(3);
		TreeColumnLayout pscolumnLayout = new TreeColumnLayout();
		psTreeViewer.getControl().getParent().setLayout(columnLayout);
		
		Tree psTree = psTreeViewer.getTree();
		psTree.setHeaderVisible(true);
		psTree.setLinesVisible(true);
		managedForm.getToolkit().paintBordersFor(psFilteredTree);

		TreeViewerColumn psnameViewerColumn = new TreeViewerColumn(psTreeViewer, SWT.NONE);
		TreeColumn psnameColumn = psnameViewerColumn.getColumn();
	
		pscolumnLayout.setColumnData(psnameColumn, new ColumnWeightData(4));			

		psnameViewerColumn.setLabelProvider(new NameLabelProvider(false));	

		psTreeViewer.setContentProvider(new ProtectionSolutionContentProvider());
		
		if(adss.getModel().getSolutionsCount()<=0)
		{
			psTreeViewer.setInput(null);
		}
		else
		{
			psTreeViewer.setInput(adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()));
		}
		//System.out.println("adss.getModel().getVanillaSolution().getApplicationMetrics()"+ adss.getModel().getVanillaSolution().getApplicationMetrics());
		//////////////////////
		
		protectionConfigurationCombo1.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				Solution pi = adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex());
				assessment.initProtectionSolution(pi);
				curps = protectionConfigurationCombo1.getSelectionIndex();
				
				if(adss.getModel().getProtectionsCount()<=0)
				{
					psTreeViewer.setInput(null);
				}
				else
				{
					psTreeViewer.setInput(adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()));
				}
			}
		});
		
		///////////////////////////
		SectionPart filePathSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(filePathSectionPart);
		filePathSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		filePathSectionPart.getSection().setText("Files Paths");

		Composite filePathComposite = new Composite(filePathSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(filePathComposite);
		managedForm.getToolkit().paintBordersFor(filePathComposite);
		filePathSectionPart.getSection().setClient(filePathComposite);
		filePathComposite.setLayout(new GridLayout(1, true));
		
		Group localConfigurationGroup = new Group(filePathComposite, SWT.NONE);
		localConfigurationGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		localConfigurationGroup.setText("Result Files Configuration");
		localConfigurationGroup.setLayout(new GridLayout(2, false));
		managedForm.getToolkit().paintBordersFor(localConfigurationGroup);

		managedForm.getToolkit().createLabel(localConfigurationGroup, "Assessment result files path:");
		final Text resultFilePath = managedForm.getToolkit().createText(localConfigurationGroup, "");
		resultFilePath.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		resultFilePath.setText("E:/eclipse mars for ADSS/workspace/org.uel.aspire.wp4.assessment/result/");
		resultFilePath.setEditable(true);
		managedForm.getToolkit().createLabel(localConfigurationGroup, "Assessment log files path:");
		final Text logFilePath = managedForm.getToolkit().createText(localConfigurationGroup, "");
		logFilePath.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		logFilePath.setText("E:/eclipse mars for ADSS/workspace/org.uel.aspire.wp4.assessment/log/");
		logFilePath.setEnabled(true);

		Group metricsFileGroup = new Group(filePathComposite, SWT.NONE);
		metricsFileGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		metricsFileGroup.setText("Metrics Files Sources");
		metricsFileGroup.setLayout(new GridLayout(2, false));
		managedForm.getToolkit().paintBordersFor(metricsFileGroup);
		
		final Button loadMetricFileButton = managedForm.getToolkit().createButton(metricsFileGroup, "Load from Local Metrics File",
				SWT.CHECK);
		loadMetricFileButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		managedForm.getToolkit().createLabel(metricsFileGroup, "Local Metrics File Full Path: ");
		final Text filePathText = managedForm.getToolkit().createText(metricsFileGroup, "");
		filePathText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		filePathText.setText("E:/eclipse mars for ADSS/workspace/NAGRA-use-case-metrics/");
		
		//filePathText.setEnabled(true);

		loadMetricFileButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				filePathText.setEnabled(loadMetricFileButton.getSelection());
			}
		});
		
		///////////////////////////
		SectionPart doSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(doSectionPart);
		doSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		doSectionPart.getSection().setText("Assessment Option");

		Composite doComposite = new Composite(doSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(doComposite);
		managedForm.getToolkit().paintBordersFor(doComposite);
		doSectionPart.getSection().setClient(doComposite);
		doComposite.setLayout(new GridLayout(1, true));

		final Button fitnessButton = managedForm.getToolkit().createButton(doComposite, "Do Fitness Function...", SWT.NONE);
		fitnessButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));
		
		//simulation function 
		
		final Button simulationButton = managedForm.getToolkit().createButton(doComposite, "Do Fitness Simulation...", SWT.NONE);
		simulationButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));
		
		if(checkTransition())
		{
			simulationButton.setEnabled(false);
			fitnessButton.setEnabled(true);
		}
		else
		{
			simulationButton.setEnabled(true);
			fitnessButton.setEnabled(false);
		}
		//
		
		SectionPart assessmentResultSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(assessmentResultSectionPart);
		assessmentResultSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		assessmentResultSectionPart.getSection().setText("Assessment Results");
		Composite assessmentResultComposite = new Composite(assessmentResultSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(assessmentResultComposite);
		managedForm.getToolkit().paintBordersFor(assessmentResultComposite);
		assessmentResultSectionPart.getSection().setClient(assessmentResultComposite);
		assessmentResultComposite.setLayout(new GridLayout(1, true));
		
		managedForm.getToolkit().createLabel(assessmentResultComposite, "The Assessment Result is : ");

		final Text assessmentResultText = new Text(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		assessmentResultText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true ,90 ,30));
		assessmentResultText.setEnabled(true);		
		
		//managedForm.getToolkit().createLabel(assessmentResultComposite, "The Assessment Log is : ");		
		//final Text assessmentLogText = new Text(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		//assessmentLogText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true ,90 ,70));
		//assessmentLogText.setEnabled(true);
		
		final Button displayResultPNButton = new Button(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		displayResultPNButton.setText(" Displaying Assessment Results on PetriNet Model ");
		
		displayResultPNButton.setEnabled(false);
		
		fitnessButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				/*ArrayList<AttackPath> aps = new ArrayList<AttackPath>();
				for (int i=0;i<apSelected.size();i++)
				{
					if(apSelected.get(i))
					{
						aps.add(adss.getModel().getAttackPaths().get(i));
					}
				}*/
				
				assessment.initModel(apsSelected, true);
				
				if(apsSelected == null) assessment.initModel(adss.getModel().getAttackPaths(), true);
					
				if (assessment.enableProtectionSolution()==false) 
					{assessment.initProtectionSolution(adss.getModel().getSolutions().get(0));curps = 0;}
				if (assessment.enableAttackModel()==false) 
				{
					assessment.initModel(adss.getModel().getAttackPaths(), true);
					//curap = 0;
				}
				if (loadMetricFileButton.getSelection())
				{
					assessment.setMetricFile(filePathText.getText());					
					try{
						ArrayList<Metric> metricsafter = new ArrayList<Metric>();
						ArrayList<Metric> metricsbefore = new ArrayList<Metric>();
						
						metricsafter = parseMetrics(filePathText.getText());
						metricsbefore = parseMetricsBefore(filePathText.getText());
						assessment.initMetrics( metricsafter, metricsbefore);//System.out.println(metrics);
						assessment.loggingln("Now, the assessment session is in the local mode!");						
					}
					catch(Exception ei)
					{
						System.out.println("Errors in the process of local parsing metrics!");
						System.out.println(ei.fillInStackTrace());
					}					
				}
				//to fetch the metrics data from VM
				else
				{
					ACTCConnector ac = new ACTCConnector(adss);
					try{
						//ac.parseMetrics(assessment.getSolution());
						//System.out.println( adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()).getApplicationMetrics() ) ;
						//System.out.println(adss.getModel().getVanillaSolution().getApplicationMetrics());
						//System.out.println("************");
						assessment.initMetrics( metricsNameMap(adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()).getApplicationMetrics()), metricsNameMap(adss.getModel().getVanillaSolution().getApplicationMetrics()));
						//System.out.println("************");
						//System.out.println( adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()).getApplicationMetrics() ) ;
						assessment.loggingln("Now, the assessment session is in the remote mode!");
						//System.out.println("************");
					}
					catch(Exception ei)
					{
						System.out.println("Errors in the process of remote parsing metrics!");
						System.out.println(ei);
					}
				}
				double result = assessment.runProtectionFitness();					
				
				psAssessed.add(curps, true);			
				//apAssessed.set(curap, true);		
				//bestPS.get(curap).set(curps, result);
				addOneResult(bestPS, apsSelected, curps, result);
				
				MessageBox resultbox = new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_WORKING);
				resultbox.setText("Assessment Result");
				
					resultbox.setMessage("The Assessment result of this protection configuration is : " + result + ".  This value means that this protection configuration "
							+ "can improve the protection level by this value.");			
				resultbox.open();				

				//assessmentLogText.setText(assessment.getLogContent());				
				//assessmentLogText.setEnabled(true);				
				
				String resulttext  = "";				
				resulttext = getResultContent();	
				
				System.out.println("resulttext is " + resulttext);	
				
				assessmentResultText.setText(resulttext);
				assessment.loggingln(resulttext);				
				assessmentResultText.setEnabled(true);
				
				//System.out.println("resulttext is " + resulttext);
				resultPage.setResultText(resulttext);
				resultPage.setLogText(assessment.getLogContent());	
				displayResultPNButton.setEnabled(true);
				
			}
		});	
		
		simulationButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{	
				assessment.initModel(apsSelected, true);
				
				if(apsSelected == null) assessment.initModel(adss.getModel().getAttackPaths(), true);
					
				if (assessment.enableProtectionSolution()==false) 
					{assessment.initProtectionSolution(adss.getModel().getSolutions().get(0));curps = 0;}
				if (assessment.enableAttackModel()==false) 
				{
					assessment.initModel(adss.getModel().getAttackPaths(), true);
					//curap = 0;
				}
				if (loadMetricFileButton.getSelection())
				{
					assessment.setMetricFile(filePathText.getText());					
					try{
						ArrayList<Metric> metricsafter = new ArrayList<Metric>();
						ArrayList<Metric> metricsbefore = new ArrayList<Metric>();
						
						metricsafter = parseMetrics(filePathText.getText());
						metricsbefore = parseMetricsBefore(filePathText.getText());
						assessment.initMetrics( metricsafter, metricsbefore);//System.out.println(metrics);
						assessment.loggingln("Now, the assessment session is in the local mode!");						
					}
					catch(Exception ei)
					{
						System.out.println("Errors in the process of local parsing metrics!");
						System.out.println(ei.fillInStackTrace());
					}					
				}
				//to fetch the metrics data from VM
				else
				{
					ACTCConnector ac = new ACTCConnector(adss);
					try{

						assessment.initMetrics( metricsNameMap(adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()).getApplicationMetrics()), metricsNameMap(adss.getModel().getVanillaSolution().getApplicationMetrics()));
						//System.out.println("************");
						//System.out.println( adss.getModel().getSolutions().get(protectionConfigurationCombo1.getSelectionIndex()).getApplicationMetrics() ) ;
						assessment.loggingln("Now, the assessment session is in the remote mode!");
						//System.out.println("************");
					}
					catch(Exception ei)
					{
						System.out.println("Errors in the process of remote parsing metrics!");
						System.out.println(ei);
					}
				}
				assessment.initPNSimulatorM();
				double result = assessment.runPNSimulatorM();					
				
				psAssessed.add(curps, true);			
				//apAssessed.set(curap, true);		
				//bestPS.get(curap).set(curps, result);
				addOneResult(bestPS, apsSelected, curps, result);
				
				MessageBox resultbox = new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_WORKING);
				resultbox.setText("Assessment Result");
				
					resultbox.setMessage("The Assessment result of this protection configuration is : " + result + ".  This value means that this protection configuration "
							+ "can improve the protection level by this value.");			
				resultbox.open();				

				//assessmentLogText.setText(assessment.getLogContent());				
				//assessmentLogText.setEnabled(true);				
				
				String resulttext  = "";				
				resulttext = getResultContent();	
				
				System.out.println("resulttext is " + resulttext);	
				
				assessmentResultText.setText(resulttext);
				assessment.loggingln(resulttext);				
				assessmentResultText.setEnabled(true);
				
				//System.out.println("resulttext is " + resulttext);
				resultPage.setResultText(resulttext);
				resultPage.setLogText(assessment.getLogContent());	
				displayResultPNButton.setEnabled(true);

			}
		});
		
		displayResultPNButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{	
				//TODO
				AttackPath keyPath = assessment.getKeyPath();				
				//adss.setKeyPath(keyPath);
			}
		});
	}

	protected void addOneResult(HashMap<String, ArrayList<Double>> bestPS2, ArrayList<AttackPath> apsSelected2, int curps, double result2) 
	{
		String nameofApsSelected = "";
		for(int i = 0 ; i <apsSelected2.size();i++)
		{
			if(i==0)
			{
				nameofApsSelected = nameofApsSelected + "( " + ((Integer)apsSelected2.get(i).hashCode()).toString();
			}
			else
			{
				nameofApsSelected = nameofApsSelected + " + ";
				nameofApsSelected = nameofApsSelected + ((Integer)apsSelected2.get(i).hashCode()).toString();
			}
		}
		nameofApsSelected = nameofApsSelected + " )";
		
		if(bestPS2==null || (bestPS.get(nameofApsSelected) == null))
		{
			ArrayList<Double> temp = new ArrayList<Double>();
			for(int i=0;i<psAssessed.size();i++)
			{
				if(i==curps)
				{
					temp.add(result2);
				}
				else
				{
					temp.add(Double.MAX_VALUE);
				}
			}
			bestPS2.put(nameofApsSelected, temp);
		}
		else
		{
			ArrayList<Double> temp = bestPS.get(nameofApsSelected);
			temp.set(curps, result2);
			bestPS.put(nameofApsSelected, temp);			
		}
		
	}

	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
	}
	

	static HashMap<String,String> metricMap = new HashMap<String,String>();
	static {
		metricMap.put("nr_ins_static","INS");
		metricMap.put("#region_idx","region_id");
		metricMap.put("nr_src_oper_static","SRC");
		metricMap.put("nr_dst_oper_static","SPS");
		metricMap.put("halstead_program_size_static","DPS");		
		metricMap.put("nr_edges_static","EDG");
		metricMap.put("nr_indirect_edges_CFIM_static","DPL");		
		metricMap.put("cyclomatic_complexity_static","CC");
		

	}
	
	private EList<Metric> metricsNameMap(EList<Metric> metin)	
	{
		int size = metin.size();
		EList<Metric> met = metin;
		for(int i=0;i<size;i++)
		{
			String newName = metricMap.get(met.get(i).getName());
			met.get(i).setName(newName);
		}
		return met;
	}
	
	private ArrayList<Metric> parseMetrics(String file) throws IOException 

	{
		ArrayList<Metric> mets  = new ArrayList<Metric>();
		//String content1 = null;
		String filename = file + "libnvdrmplugin.so.stat_complexity_info"; ///
	
		
		BufferedReader reader1 = new BufferedReader(new FileReader(filename));
		String line1 = reader1.readLine();
		//System.out.println("line1 is :"+line1);
		
		String line2 = reader1.readLine();
		//System.out.println("line2 is :"+line2);
		String[] parts1 = line1.split(",");
		String[] parts2 = line2.split(",");
		
		//System.out.println("parts1 length is :"+parts1.length);
		//System.out.println("parts2 length is :"+parts2.length);
		
		//initMetricMap();
		for (int i=0; i<parts1.length; i++) 
		{
			//System.out.println(parts1[i] + " : " + parts2[i]);
			Metric metric = AkbFactory.eINSTANCE.createMetric();
			metric.setName(metricMap.get(parts1[i].trim()));
			metric.setValue(Double.parseDouble(parts2[i].trim()));
			mets.add(metric);
		}
		reader1.close();		
		if (mets.isEmpty()) {System.out.println("IMPORTANT: lOCAL FILES READING HAVE PROBLEMS to load metrics!");}
		if (parts1.length!=parts2.length) System.out.println("Mismatch: different metrics name from values"); 
		//TODO ask daniele what if more names than metrics? we put zero or some special char? 
		return mets;
	}
	
	private ArrayList<Metric> parseMetricsBefore(String file) throws IOException 

	{
		ArrayList<Metric> mets  = new ArrayList<Metric>();
		//String content1 = null;
		String filename = file + "libnvdrmplugin.so.stat_complexity_info_before"; ///
	
		
		BufferedReader reader1 = new BufferedReader(new FileReader(filename));
		String line1 = reader1.readLine();
		//System.out.println("line1 is :"+line1);
		
		String line2 = reader1.readLine();
		//System.out.println("line2 is :"+line2);
		String[] parts1 = line1.split(",");
		String[] parts2 = line2.split(",");
		
		//System.out.println("parts1 length is :"+parts1.length);
		//System.out.println("parts2 length is :"+parts2.length);
		
		//initMetricMap();
		for (int i=0; i<parts1.length; i++) 
		{
			//System.out.println(parts1[i] + " : " + parts2[i]);
			Metric metric = AkbFactory.eINSTANCE.createMetric();
			metric.setName(metricMap.get(parts1[i].trim()));
			metric.setValue(Double.parseDouble(parts2[i].trim())); 
			mets.add(metric);
		}
		reader1.close();		
		if (mets.isEmpty()) {System.out.println("IMPORTANT: lOCAL FILES READING HAVE PROBLEMS to load metrics!");}
		if (parts1.length!=parts2.length) System.out.println("Mismatch: different metrics name from values"); 
		
		return mets;
	}
	
	public AssessmentProcessBoth2 getAssessment()
	{
		return assessment;
	}

	public String getResultContent() {
		String resulttext  = "";
		
		for(int i = 0 ; i < bestPS.size();i++)
		{
			int psindex = -1;
			int assessed = 0;
			String pslist = "";
			double psresult = Double.MAX_VALUE;
			
			for(int j = 0 ; j < bestPS.get(bestPS.keySet().toArray()[i]).size();j++)
			{
				if(bestPS.get(bestPS.keySet().toArray()[i]).get( j ) != Double.MAX_VALUE)
				{
					assessed++;
					pslist += adss.getModel().getSolutions().get(j).hashCode() + "; ";
				}
				if(psresult >= bestPS.get(bestPS.keySet().toArray()[i]).get( j ) )
				{
					psresult = bestPS.get(bestPS.keySet().toArray()[i]).get( j );
					psindex = j;
				}
			}
				resulttext+="For the attack paths: " + bestPS.keySet().toArray()[i] + " in this use case, " + System.getProperty("line.separator")
						+ assessed + " solutions have been assessed: " + pslist + System.getProperty("line.separator")
						+ "the best Solution is : " + adss.getModel().getSolutions().get(psindex).hashCode()
						+ " with the assessment results of " + psresult + ". " + System.getProperty("line.separator");	
				resulttext += System.getProperty("line.separator");	
			
			
			/*if (apAssessed.get(i) == true )
			{
				int psindex = -1;
				int assessed = 0;
				String pslist = "";
				double psresult = Double.MAX_VALUE;
				if(i==0)
				{
					for(int j = 0 ; j < bestPS.get(i).size();j++)
					{
						if(bestPS.get(i).get( j ) != Double.MAX_VALUE)
						{
							assessed++;
							pslist += adss.getModel().getSolutions().get(j).hashCode() + "; ";
						}
						if(psresult >= bestPS.get(i).get( j ) )
						{
							psresult = bestPS.get(i).get( j );
							psindex = j;
						}
					}
					resulttext += "For all attack paths in this use case, "+ System.getProperty("line.separator")
							+ assessed + " solutions have been assessed: " + pslist + System.getProperty("line.separator")
							+ "the best Solution is : " + adss.getModel().getSolutions().get(psindex).hashCode()
							+ " with the assessment results of " + psresult + ". " + System.getProperty("line.separator");
					resulttext += System.getProperty("line.separator");
				}
				else
				{						
					for(int j = 0 ; j < bestPS.get(i).size();j++)
					{
						if(bestPS.get(i).get( j ) != Double.MAX_VALUE)
						{
							assessed++;
							pslist += adss.getModel().getSolutions().get(j).hashCode() + "; ";
						}
						if(psresult >= bestPS.get(i).get( j ) )
						{
							psresult = bestPS.get(i).get( j );
							psindex = j;
						}
					}
					resulttext+="For the attack path: " + adss.getModel().getAttackPaths().get(i-1).toString() + " in this use case, " + System.getProperty("line.separator")
							+ assessed + " solutions have been assessed: " + pslist + System.getProperty("line.separator")
							+ "the best Solution is : " + adss.getModel().getSolutions().get(psindex).hashCode()
							+ " with the assessment results of " + psresult + ". " + System.getProperty("line.separator");	
					resulttext += System.getProperty("line.separator");	
				}
			}*/
		
		}
		return resulttext;
	}
	
	//this method is to check all transition existing or not, if not run simulation, otherwise run assessment. 
	boolean checkTransition()
	{
		boolean full = true;
		for(int i=0;i<adss.getModel().getAttackStepsCount();i++)
		{
			if (adss.getModel().getAttackSteps().get(i).getTransition().lastIndexOf('[') != -1)
			{
				full = false;
				break;
			}
		}		
		return full;
	}
	
}
