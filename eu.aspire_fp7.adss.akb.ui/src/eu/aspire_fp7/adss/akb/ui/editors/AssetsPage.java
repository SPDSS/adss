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
import java.util.List;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDoubleDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.DataValidator;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommand;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.LayerUtil;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.NoteWidget;
import eu.aspire_fp7.adss.akb.ui.dialogs.KeyValueDialog;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.akb.ui.nattables.ADSSNatTable;
import eu.aspire_fp7.adss.akb.ui.nattables.ApplicationPartExpansionModel;
import eu.aspire_fp7.adss.akb.ui.nattables.ApplicationPartFormat;
import eu.aspire_fp7.adss.akb.ui.nattables.ApplicationPartUpdateDataCommandHandler;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The assets page.
 * @author Daniele Canavese
 **/
public class AssetsPage extends FormPage implements ADSSEventListener
{
	/** The ADSS. **/
	private ADSS adss;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;
	/** The application parts nattable. **/
	private ADSSNatTable<ApplicationPart> partsTreeNatTable;
	/** The form. **/
	private ScrolledForm form;
	/** The column showing the weight of the assets. **/
	TreeViewerColumn weightViewerColumn;

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
	public AssetsPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator) throws Exception
	{
		super(editor, "assets", "Assets");
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
			form.setText("Assets");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/applicationParts.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(adss, managedForm, LabelType.ASSETS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createApplicationPartsSection(managedForm);

			eventGenerator.addListener(this);
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
	private void createApplicationPartsSection(IManagedForm managedForm) throws Exception
	{
		SectionPart applicationPartsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(applicationPartsSectionPart);
		applicationPartsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		applicationPartsSectionPart.getSection().setText("Application Parts");

		Composite applicationPartsComposite = new Composite(applicationPartsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(applicationPartsComposite);
		managedForm.getToolkit().paintBordersFor(applicationPartsComposite);
		applicationPartsSectionPart.getSection().setClient(applicationPartsComposite);
		applicationPartsComposite.setLayout(new GridLayout());

		NoteWidget noteWidget = new NoteWidget(applicationPartsComposite, "Double click an item for more information:");
		noteWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		String[] propertyNames = new String[] { "name", "type", "shortLocation", "properties", "weight" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("name", "Name");
		propertyToLabelMap.put("type", "Type");
		propertyToLabelMap.put("shortLocation", "Source File : Line");
		propertyToLabelMap.put("properties", "Properties");
		propertyToLabelMap.put("weight", "Weight");

		partsTreeNatTable = new ADSSNatTable<>(applicationPartsComposite, adss.getModel().getAllApplicationParts(), propertyNames,
				propertyToLabelMap, new ApplicationPartFormat(), new ApplicationPartExpansionModel());

		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 30);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 20);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 30);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(3, 10);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(4, 10);

		partsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				ApplicationPart part = partsTreeNatTable.getBodyDataProvider().getRowObject(rowPosition);
				int depth = 0;
				ApplicationPart parent = part.getDeclaringCode();
				while (parent != null)
				{
					++depth;
					parent = parent.getDeclaringCode();
				}

				if (part.isAsset())
					configLabels.addLabel("asset");
				if (part.isAsset() && columnPosition == 0)
					configLabels.addLabel("assetBadge");
				if (part.isCode() && columnPosition == 0)
					configLabels.addLabel("code");
				else if (part.isDatum() && columnPosition == 0)
					configLabels.addLabel("datum");
				else if (columnPosition == 0)
					configLabels.addLabel("reference");
				configLabels.addLabel("depth:" + depth);
				if (columnPosition == 3)
					configLabels.addLabel("properties");
				else if (columnPosition == 4)
					configLabels.addLabel("weight");
			}
		});

		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE,
				IEditableRule.ALWAYS_EDITABLE, DisplayMode.EDIT, "weight");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new TextCellEditor(),
				DisplayMode.EDIT, "weight");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER,
				new DefaultDoubleDisplayConverter(), DisplayMode.EDIT, "weight");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.DATA_VALIDATOR, new DataValidator()
		{
			@Override
			public boolean validate(int columnIndex, int rowIndex, Object newValue)
			{
				if (newValue instanceof Double && ((Double) newValue) >= 0)
					return true;
				else
					return false;
			}
		}, DisplayMode.EDIT, "weight");

		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE, new IEditableRule()
		{
			@Override
			public boolean isEditable(int columnIndex, int rowIndex)
			{

				return columnIndex == 3;
			}

			@Override
			public boolean isEditable(ILayerCell cell, IConfigRegistry configRegistry)
			{
				ListDataProvider<ApplicationPart> dataProvider = (ListDataProvider<ApplicationPart>) partsTreeNatTable
						.getBodyDataProvider();
				ApplicationPart part = dataProvider.getRowObject(cell.getRowIndex());

				return part.getType() != ApplicationPartType.FUNCTION;
			}
		}, DisplayMode.EDIT, "properties");
		List<String> securityProperties = new ArrayList<>();
		securityProperties.add("(no properties)");
		securityProperties.add("confidentiality");
		securityProperties.add("hard confidentiality");
		securityProperties.add("privacy");
		securityProperties.add("integrity");
		securityProperties.add("confidentiality, integrity");
		securityProperties.add("hard confidentiality, integrity");
		securityProperties.add("privacy, integrity");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR,
				new ComboBoxCellEditor(securityProperties, securityProperties.size()), DisplayMode.EDIT, "properties");

		partsTreeNatTable.getBodyDataLayer().unregisterCommandHandler(UpdateDataCommand.class);
		partsTreeNatTable.getBodyDataLayer().registerCommandHandler(
				new ApplicationPartUpdateDataCommandHandler(adss, eventGenerator, partsTreeNatTable.getBodyDataLayer()));

		GridDataFactory.fillDefaults().grab(true, true).applyTo(partsTreeNatTable);

		partsTreeNatTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
				int rowPos = partsTreeNatTable.getRowPositionByY(e.y);
				if (rowPos > 1)
				{
					int bodyRowPos = LayerUtil.convertRowPosition(partsTreeNatTable, rowPos, partsTreeNatTable.getBodyDataLayer());
					ApplicationPart part = partsTreeNatTable.getBodyDataProvider().getRowObject(bodyRowPos);
					Map<Object, Object> map = new HashMap<>();
					map.put("Name", part.getName());
					map.put("Contained parts", part.getApplicationParts());
					map.put("Contained assets", part.getAssets());
					map.put("Size", part.getDatumSize());
					map.put("Declaring code", part.getDeclaringCode());
					map.put("End line", part.getEndLine());
					map.put("ID", part.getId());
					map.put("Index", part.getIndex());
					map.put("Sets", part.getSets());
					map.put("Targets", part.getTargetOf());
					map.put("Parameters", part.getParameters());
					map.put("Properties", part.getProperties());
					map.put("Source file", part.getSourceFilePath());
					map.put("Start line", part.getStartLine());
					map.put("Body", part.getBody());
					map.put("Type", part.getType());
					map.put("Uses", part.getUses());
					map.put("Weight", part.getWeight());
					map.put("In system file", part.isInSystemFile());
					KeyValueDialog dialog = new KeyValueDialog(partsTreeNatTable.getShell(), "Application part: " + part.getName(), map);
					dialog.open();
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
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if (event == Event.APPLICATION_PARTS_UPDATED)
					partsTreeNatTable.update(adss.getModel().getAllApplicationParts());
			}
		});
	}
}
