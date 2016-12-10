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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultBooleanDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.CheckBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.painter.cell.CheckBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.CellPainterDecorator;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
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
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.akb.ui.nattables.ADSSNatTable;
import eu.aspire_fp7.adss.akb.ui.nattables.AllExpansionModel;
import eu.aspire_fp7.adss.akb.ui.nattables.ListFormat;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The protections page.
 * @author Daniele Canavese
 **/
public class ProtectionsPage extends FormPage implements ADSSEventListener
{
	/** The ADSS. **/
	private ADSS adss;
	/** The protections nattable. **/
	private ADSSNatTable<Protection> protectionsTreeNatTable;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;
	/** The form. **/
	private ScrolledForm form;

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
	public ProtectionsPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator) throws Exception
	{
		super(editor, "protections", "Protections");
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
			form.setText("Protections");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/protection.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(adss, managedForm, LabelType.PROTECTIONS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createProtectionsSection(managedForm);

			eventGenerator.addListener(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the protections section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createProtectionsSection(IManagedForm managedForm) throws Exception
	{
		SectionPart protectionsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(protectionsSectionPart);
		protectionsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		protectionsSectionPart.getSection().setText("Protections");

		Composite protectionsComposite = new Composite(protectionsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(protectionsComposite);
		managedForm.getToolkit().paintBordersFor(protectionsComposite);
		protectionsSectionPart.getSection().setClient(protectionsComposite);
		protectionsComposite.setLayout(new GridLayout());

		String[] propertyNames = new String[] { "name", "instantiationsCount", "enabled" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("name", "Name");
		propertyToLabelMap.put("instantiationsCount", "PI count");
		propertyToLabelMap.put("enabled", "Enabled");

		protectionsTreeNatTable = new ADSSNatTable<>(protectionsComposite, new ArrayList<Protection>(adss.getModel().getProtections()),
				propertyNames, propertyToLabelMap, new ListFormat<Protection>(), new AllExpansionModel<Protection>(false));

		protectionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 80);
		protectionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 10);
		protectionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 10);

		protectionsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				Protection protection = protectionsTreeNatTable.getBodyDataProvider().getRowObject(rowPosition);
				
				if (columnPosition == 0)
					configLabels.addLabel("protection");
				else if (columnPosition == 2)
					configLabels.addLabel("enabled");
				if (protection.getInstantiationsCount() == 0)
					configLabels.addLabel("disabled");
			}
		});

		// final ColumnHeaderCheckBoxPainter columnHeaderCheckBoxPainter = new ColumnHeaderCheckBoxPainter(
		// protectionsTreeNatTable.getBodyDataLayer());
		// final ICellPainter enabledHeaderPainter = new CellPainterDecorator(new TextPainter(), CellEdgeEnum.RIGHT,
		// columnHeaderCheckBoxPainter);

		 ICellPainter checkBoxCellPainter = new CellPainterDecorator(new CheckBoxPainter(), CellEdgeEnum.RIGHT, new TextPainter());
		// final CheckBoxCellEditor checkBoxCellEditor = new CheckBoxCellEditor();
		// protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, checkBoxCellPainter,
		// DisplayMode.NORMAL, "enabled");
		// protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, checkBoxCellPainter,
		// DisplayMode.EDIT, "enabled");
		//
		protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE,
				IEditableRule.ALWAYS_EDITABLE, DisplayMode.EDIT, "enabled");
		// protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, checkBoxCellEditor,
		// DisplayMode.EDIT, "enabled");

		protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new CheckBoxCellEditor(),
				DisplayMode.EDIT, "enabled");
		protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, checkBoxCellPainter,
				DisplayMode.NORMAL, "enabled");
		protectionsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER,
				new DefaultBooleanDisplayConverter(), DisplayMode.NORMAL, "enabled");

		// protectionsTreeNatTable.configure();

		GridDataFactory.fillDefaults().grab(true, true).applyTo(protectionsTreeNatTable);
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
				if (event == Event.PROTECTIONS_UPDATED)
					protectionsTreeNatTable.update(adss.getModel().getProtections());
			}
		});
	}
}
