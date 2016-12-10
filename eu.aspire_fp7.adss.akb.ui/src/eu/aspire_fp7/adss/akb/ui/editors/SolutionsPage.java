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
package eu.aspire_fp7.adss.akb.ui.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.akb.ui.nattables.ADSSNatTable;
import eu.aspire_fp7.adss.akb.ui.nattables.AllExpansionModel;
import eu.aspire_fp7.adss.akb.ui.nattables.ListFormat;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The solutions page.
 * @author Daniele Canavese
 **/
public class SolutionsPage extends FormPage implements ADSSEventListener
{
	/** The ADSS. **/
	private ADSS adss;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;
	/** The form. **/
	private ScrolledForm form;
	/** The solutions nattable. **/
	private ADSSNatTable<Solution> solutionsTreeNatTable;

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param adss
	 *            The ADSS.
	 * @param eventGenerator
	 *            The event generator.
	 * @param full
	 *            Indicates if this page is for the ADSS full or not.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public SolutionsPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator, boolean full) throws Exception
	{
		super(editor, "solutions", "Solutions");
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
			form = managedForm.getForm();
			managedForm.getToolkit().paintBordersFor(form);
			form.setText("Solutions");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(adss, managedForm, LabelType.ASSETS, LabelType.PROTECTIONS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createSolutionSection(managedForm);

			eventGenerator.addListener(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the solutions section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createSolutionSection(final IManagedForm managedForm) throws Exception
	{
		SectionPart solutionsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(solutionsSectionPart);
		solutionsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		solutionsSectionPart.getSection().setText("Solutions");

		Composite solutionsComposite = new Composite(solutionsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(solutionsComposite);
		managedForm.getToolkit().paintBordersFor(solutionsComposite);
		solutionsSectionPart.getSection().setClient(solutionsComposite);
		solutionsComposite.setLayout(new GridLayout());

		String[] propertyNames = new String[] { "id", "solutionSequences", "score" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("id", "ID");
		propertyToLabelMap.put("solutionSequences", "Sequences");
		propertyToLabelMap.put("score", "Protection Index");

		solutionsTreeNatTable = new ADSSNatTable<>(solutionsComposite, adss.getModel().getSolutions(), propertyNames, propertyToLabelMap,
				new ListFormat<Solution>(), new AllExpansionModel<Solution>(false));

		solutionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 15);
		solutionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 75);
		solutionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 10);

		solutionsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				if (columnPosition == 0)
					configLabels.addLabel("solution");
			}
		});

		GridDataFactory.fillDefaults().grab(true, true).applyTo(solutionsTreeNatTable);
	}

	/**
	 * Handles an event.
	 * @param event
	 *            The event.
	 **/
	@Override
	public void handleEvent(final Event event)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if (event == Event.SOLUTIONS_UPDATED)
					solutionsTreeNatTable.update(adss.getModel().getSolutions());
			}
		});
	}
}
