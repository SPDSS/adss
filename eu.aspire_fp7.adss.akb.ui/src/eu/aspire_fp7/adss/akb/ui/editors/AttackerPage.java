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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AttackerTool;
import eu.aspire_fp7.adss.akb.ExpertiseLevel;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.akb.ui.nattables.ADSSNatTable;
import eu.aspire_fp7.adss.akb.ui.nattables.AllExpansionModel;
import eu.aspire_fp7.adss.akb.ui.nattables.ListFormat;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The attacks page.
 * @author Daniele Canavese
 **/
public class AttackerPage extends FormPage implements ADSSEventListener
{
	/** The ADSS. **/
	private ADSS adss;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;
	/** The form. **/
	private ScrolledForm form;
	/** The amateur radio button. **/
	private Button amateurRadio;
	/** The geek radio button. **/
	private Button geekRadio;
	/** The expert radio button. **/
	private Button expertRadio;
	/** The guru radio button. **/
	private Button guruRadio;
	/** The budget limit check. **/
	private Button budgetLimitCheck;
	/** The budget limit spinner. **/
	private Spinner budgetLimitSpinner;
	/** The attacker tools nattable. **/
	private ADSSNatTable<AttackerTool> toolsTreeNatTable;

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
	public AttackerPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator) throws Exception
	{
		super(editor, "attacker", "Attacker");
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
			form.setText("Attacker");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/attacker.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(adss, managedForm, LabelType.ATTACKER_TOOLS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createExpertiseLevelSection(managedForm);
			createBudgetSection(managedForm);
			createToolsSection(managedForm);

			eventGenerator.addListener(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the expertise level section.
	 * @param managedForm
	 *            The managed form.
	 **/
	private void createExpertiseLevelSection(final IManagedForm managedForm)
	{
		SectionPart expertiseLevelSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(expertiseLevelSectionPart);
		expertiseLevelSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		expertiseLevelSectionPart.getSection().setText("Expertise Level");

		Composite expertiseLevelComposite = new Composite(expertiseLevelSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(expertiseLevelComposite);
		managedForm.getToolkit().paintBordersFor(expertiseLevelComposite);
		expertiseLevelSectionPart.getSection().setClient(expertiseLevelComposite);
		expertiseLevelComposite.setLayout(new GridLayout(4, false));

		amateurRadio = new Button(expertiseLevelComposite, SWT.RADIO);
		amateurRadio.setText("Amateur");
		geekRadio = new Button(expertiseLevelComposite, SWT.RADIO);
		geekRadio.setText("Geek");
		expertRadio = new Button(expertiseLevelComposite, SWT.RADIO);
		expertRadio.setText("Expert");
		guruRadio = new Button(expertiseLevelComposite, SWT.RADIO);
		guruRadio.setText("Guru");

		amateurRadio.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				adss.getModel().getAttacker().setExpertise(ExpertiseLevel.AMATEUR);
				eventGenerator.fireEvent(Event.ATTACKER_UPDATED);
			}
		});
		geekRadio.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				adss.getModel().getAttacker().setExpertise(ExpertiseLevel.GEEK);
				eventGenerator.fireEvent(Event.ATTACKER_UPDATED);
			}
		});
		expertRadio.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				adss.getModel().getAttacker().setExpertise(ExpertiseLevel.EXPERT);
				eventGenerator.fireEvent(Event.ATTACKER_UPDATED);
			}
		});
		guruRadio.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				adss.getModel().getAttacker().setExpertise(ExpertiseLevel.GURU);
				eventGenerator.fireEvent(Event.ATTACKER_UPDATED);
			}
		});
	}

	/**
	 * Creates the budget section.
	 * @param managedForm
	 *            The managed form.
	 **/
	private void createBudgetSection(final IManagedForm managedForm)
	{
		SectionPart budgetSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(budgetSectionPart);
		budgetSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		budgetSectionPart.getSection().setText("Budget");

		Composite budgetComposite = new Composite(budgetSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(budgetComposite);
		managedForm.getToolkit().paintBordersFor(budgetComposite);
		budgetSectionPart.getSection().setClient(budgetComposite);
		budgetComposite.setLayout(new GridLayout(3, false));

		budgetLimitCheck = new Button(budgetComposite, SWT.CHECK);
		budgetLimitCheck.setText("Budget limit:");
		budgetLimitSpinner = new Spinner(budgetComposite, SWT.NONE);
		budgetLimitSpinner.setMinimum(0);
		Label euroLabel = new Label(budgetComposite, SWT.NONE);
		euroLabel.setText("\u20AC");

		budgetLimitCheck.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				budgetLimitSpinner.setEnabled(budgetLimitCheck.getSelection());
				if (budgetLimitCheck.getSelection())
					adss.getModel().getAttacker().setBudgetLimit(budgetLimitSpinner.getSelection());
				else
					adss.getModel().getAttacker().setBudgetLimit(null);
				eventGenerator.fireEvent(Event.ATTACKER_UPDATED);
			}
		});
		budgetLimitSpinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (budgetLimitCheck.getSelection())
					adss.getModel().getAttacker().setBudgetLimit(budgetLimitSpinner.getSelection());
				else
					adss.getModel().getAttacker().setBudgetLimit(null);
				eventGenerator.fireEvent(Event.ATTACKER_UPDATED);
			}
		});
	}

	/**
	 * Creates the tools section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createToolsSection(final IManagedForm managedForm) throws Exception
	{
		SectionPart toolsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(toolsSectionPart);
		toolsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		toolsSectionPart.getSection().setText("Tools");

		Composite toolsComposite = new Composite(toolsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(toolsComposite);
		managedForm.getToolkit().paintBordersFor(toolsComposite);
		toolsSectionPart.getSection().setClient(toolsComposite);
		toolsComposite.setLayout(new GridLayout(1, false));

		String[] propertyNames = new String[] { "name", "types", "expertise", "cost" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("name", "Name");
		propertyToLabelMap.put("types", "Types");
		propertyToLabelMap.put("expertise", "Expertise");
		propertyToLabelMap.put("cost", "Cost");

		toolsTreeNatTable = new ADSSNatTable<>(toolsComposite, adss.getModel().getAttackerTools(), propertyNames, propertyToLabelMap,
				new ListFormat<AttackerTool>(), new AllExpansionModel<AttackerTool>(false));

		toolsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 40);
		toolsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 40);
		toolsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 10);
		toolsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(3, 10);

		toolsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				AttackerTool tool = toolsTreeNatTable.getBodyDataProvider().getRowObject(rowPosition);

				if (columnPosition == 0)
					configLabels.addLabel("attackerTool");
				else if (columnPosition == 3)
					configLabels.addLabel("cost");
				if (!adss.getModel().getAvailableTools().contains(tool))
					configLabels.addLabel("disabled");
			}
		});

		GridDataFactory.fillDefaults().grab(true, true).applyTo(toolsTreeNatTable);
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
				if (event == Event.ATTACKER_UPDATED)
				{
					ExpertiseLevel expertise = adss.getModel().getAttacker().getExpertise();
					if (expertise == ExpertiseLevel.AMATEUR)
						amateurRadio.setSelection(true);
					else if (expertise == ExpertiseLevel.GEEK)
						geekRadio.setSelection(true);
					else if (expertise == ExpertiseLevel.EXPERT)
						expertRadio.setSelection(true);
					else if (expertise == ExpertiseLevel.GURU)
						guruRadio.setSelection(true);

					Integer budgetLimit = adss.getModel().getAttacker().getBudgetLimit();
					if (budgetLimit == null)
					{
						budgetLimitCheck.setSelection(false);
						budgetLimitSpinner.setSelection(0);
						budgetLimitSpinner.setEnabled(false);
					}
					else
					{
						budgetLimitCheck.setSelection(true);
						budgetLimitSpinner.setSelection(budgetLimit);
						budgetLimitSpinner.setEnabled(true);
					}

					toolsTreeNatTable.update(adss.getModel().getAttackerTools());
				}
			}
		});
	}
}
