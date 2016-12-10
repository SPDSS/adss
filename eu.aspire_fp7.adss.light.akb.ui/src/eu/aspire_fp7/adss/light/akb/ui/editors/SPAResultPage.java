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

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;

import eu.aspire_fp7.adss.akb.AttackPath;

import eu.aspire_fp7.adss.akb.Metric;

import eu.aspire_fp7.adss.akb.Solution;

import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;

import eu.aspire_fp7.adss.akb.ui.providers.NameLabelProvider;
import eu.aspire_fp7.adss.connectors.ACTCConnector;
import eu.aspire_fp7.adss.light.akb.ui.providers.AttackPathsContentProvider;
import eu.aspire_fp7.adss.light.akb.ui.providers.ProtectionSolutionContentProvider;


/**
 * The page to display the ADSS light version.
 * @author Gaofeng Zhang
 * 31/04/2016 at uel.
 **/
public class SPAResultPage extends FormPage implements ADSSEventListener
{
	
	private ADSS adss;
	
	private ADSSEventGenerator eventGenerator;
	
	//private AssessmentProcessBoth2 assessment;
	
	//private SPAUIPage spaUIPage;
	
	Text assessmentResultText;
	Text assessmentLogText;

	
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
	public SPAResultPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator) throws Exception
	{
		super(editor, "sparesultpage", "Protection Assessment Result");
		
		this.adss = adss;
		this.eventGenerator = eventGenerator;
		//spaUIPage = spaUIPagein;
		//assessment = spaUIPagein.getAssessment();		
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
			
			form.setText("Software Protection Assessment Results and Logs");

			form.getBody().setLayout(new GridLayout(2, false));
	
			assessmentResultSection(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	


	private void assessmentResultSection(final IManagedForm managedForm)
	{		
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

		//final Text assessmentResultText = new Text(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		assessmentResultText = new Text(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		
		assessmentResultText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true ,90 ,30));
		assessmentResultText.setEnabled(true);		
		
		managedForm.getToolkit().createLabel(assessmentResultComposite, "The Assessment Log is : ");

		//final Text assessmentLogText = new Text(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		assessmentLogText = new Text(assessmentResultComposite, SWT.LEFT|SWT.MULTI|SWT.READ_ONLY|SWT.V_SCROLL|SWT.H_SCROLL|SWT.BORDER);
		
		assessmentLogText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true ,90 ,70));
		assessmentLogText.setEnabled(true);
		
		//assessmentLogText.setText(assessment.getLogContent());	
				
		//assessmentLogText.setEnabled(true);
					
		//assessmentResultText.setText(spaUIPage.getResultContent());
		//assessment.loggingln(spaUIPage.getResultContent());				
		assessmentResultText.setEnabled(true);

	}

	@Override
	public void handleEvent(Event event) {
		
		/*assessmentLogText.setText(assessment.getLogContent());	
		assessmentLogText.update();
		assessmentLogText.redraw();
				
		assessmentResultText.setText(spaUIPage.getResultContent());
		assessmentResultText.redraw();*/
	}	
	
	public void setLogText(String login)
	{
		assessmentLogText.setText(login);			
		assessmentLogText.setEnabled(true);
	}
	
	public void setResultText(String resultin)
	{
		System.out.println("in resultpage, resultin is "+resultin);
		//System.out.println("in resultpage, assessmentResultText is "+assessmentResultText);
		assessmentResultText.setText(resultin);			
		assessmentResultText.setEnabled(true);
	}
}
