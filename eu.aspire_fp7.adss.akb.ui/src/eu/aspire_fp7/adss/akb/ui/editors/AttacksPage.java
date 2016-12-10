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

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.LayerUtil;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
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
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.DotWriter;
import eu.aspire_fp7.adss.akb.ui.NoteWidget;
import eu.aspire_fp7.adss.akb.ui.dialogs.ImageDialog;
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
public class AttacksPage extends FormPage implements ADSSEventListener
{
	/** The ADSS. **/
	private ADSS adss;
	/** The attack paths nattable. **/
	private ADSSNatTable<AttackPath> pathsTreeNatTable;
	/** The attack steps nattable. **/
	private ADSSNatTable<AttackStep> stepsTreeNatTable;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;
	/** The form. **/
	private ScrolledForm form;
	/** Indicates if this page is for the ADSS full or not. **/
	private boolean full;

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
	public AttacksPage(FormEditor editor, ADSS adss, ADSSEventGenerator eventGenerator, boolean full) throws Exception
	{
		super(editor, "attacks", "Attacks");
		this.adss = adss;
		this.eventGenerator = eventGenerator;
		this.full = full;
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
			form.setText("Attacks");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackPath.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(adss, managedForm, LabelType.ATTACK_PATHS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createAttackPathsSection(managedForm);
			createAttackStepsSection(managedForm);

			form.getToolBarManager()
					.add(new Action("View the attack graph...", Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/view.png"))
					{
						@Override
						public void run()
						{
							final Image image = getAttackGraph();
							Display.getDefault().syncExec(new Runnable()
							{
								@Override
								public void run()
								{
									ImageDialog dialog = new ImageDialog(Display.getDefault().getActiveShell(), image);
									dialog.open();
								}
							});
						}
					});
			form.getToolBarManager().update(true);

			eventGenerator.addListener(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the attack steps section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAttackStepsSection(final IManagedForm managedForm) throws Exception
	{
		SectionPart attackStepsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(attackStepsSectionPart);
		attackStepsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		attackStepsSectionPart.getSection().setText("Attack Steps");

		Composite attackStepsComposite = new Composite(attackStepsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(attackStepsComposite);
		managedForm.getToolkit().paintBordersFor(attackStepsComposite);
		attackStepsSectionPart.getSection().setClient(attackStepsComposite);
		attackStepsComposite.setLayout(new GridLayout());

		String[] propertyNames;
		if (full)
			propertyNames = new String[] { "name", "type" };
		else
			propertyNames = new String[] { "name", "type", "formula" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("name", "Name");
		propertyToLabelMap.put("type", "Type");
		propertyToLabelMap.put("formula", "Formula");

		stepsTreeNatTable = new ADSSNatTable<>(attackStepsComposite, adss.getModel().getAttackSteps(), propertyNames, propertyToLabelMap,
				new ListFormat<AttackStep>(), new AllExpansionModel<AttackStep>(false));

		if (full)
		{
			stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 70);
			stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 30);
		}
		else
		{
			stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 50);
			stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 25);
			stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 25);
		}

		stepsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				if (columnPosition == 0)
					configLabels.addLabel("attackStep");
				else if (columnPosition == 2)
					configLabels.addLabel("formula");
			}
		});

		stepsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE,
				IEditableRule.ALWAYS_EDITABLE, DisplayMode.EDIT, "formula");
		stepsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new TextCellEditor(),
				DisplayMode.EDIT, "formula");
		stepsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultDisplayConverter()
		{
			@Override
			public Object displayToCanonicalValue(Object destinationValue)
			{
				if (destinationValue == null || destinationValue.toString().isEmpty())
					return "";
				else
					return super.displayToCanonicalValue(destinationValue);
			}
		}, DisplayMode.EDIT, "formula");

		GridDataFactory.fillDefaults().grab(true, true).applyTo(stepsTreeNatTable);
	}

	/**
	 * Creates the attack paths section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAttackPathsSection(final IManagedForm managedForm) throws Exception
	{
		final SectionPart attackPathsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(attackPathsSectionPart);
		attackPathsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		attackPathsSectionPart.getSection().setText("Attack Paths");

		Composite attackPathsComposite = new Composite(attackPathsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(attackPathsComposite);
		managedForm.getToolkit().paintBordersFor(attackPathsComposite);
		attackPathsSectionPart.getSection().setClient(attackPathsComposite);
		attackPathsComposite.setLayout(new GridLayout());

		NoteWidget noteWidget = new NoteWidget(attackPathsComposite, "Double click an item for more information.");
		noteWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		String[] propertyNames = new String[] { "id", "attackSteps", "protectionObjectives", "level", "mitigations" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("id", "ID");
		propertyToLabelMap.put("attackSteps", "Attack steps");
		propertyToLabelMap.put("protectionObjectives", "Targets");
		propertyToLabelMap.put("level", "Maximum Mitigation");
		propertyToLabelMap.put("mitigations", "Protections");

		pathsTreeNatTable = new ADSSNatTable<>(attackPathsComposite, adss.getModel().getAttackPaths(), propertyNames, propertyToLabelMap,
				new ListFormat<AttackPath>(), new AllExpansionModel<AttackPath>(false));

		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 10);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 45);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 20);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(3, 5);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(4, 20);

		pathsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				AttackPath path = pathsTreeNatTable.getBodyDataProvider().getRowObject(rowPosition);

				if (columnPosition == 0)
					configLabels.addLabel("attackPath");
				if (columnPosition == 4)
					configLabels.addLabel("mitigationsBadges");

				if (path.getLevel() == Level.NONE)
					configLabels.addLabel("dangerLevel");
				else if (path.getLevel() == Level.LOW)
					configLabels.addLabel("lowLevel");
				else if (path.getLevel() == Level.MEDIUM)
					configLabels.addLabel("mediumLevel");
				else if (path.getLevel() == Level.HIGH)
					configLabels.addLabel("highLevel");
			}
		});

		GridDataFactory.fillDefaults().grab(true, true).applyTo(pathsTreeNatTable);

		pathsTreeNatTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
				int rowPos = pathsTreeNatTable.getRowPositionByY(e.y);
				if (rowPos > 1)
				{
					int bodyRowPos = LayerUtil.convertRowPosition(pathsTreeNatTable, rowPos, pathsTreeNatTable.getBodyDataLayer());
					AttackPath path = pathsTreeNatTable.getBodyDataProvider().getRowObject(bodyRowPos);

					final Image image = getMitigationExplanationGraph(path);
					Display.getDefault().syncExec(new Runnable()
					{
						@Override
						public void run()
						{
							ImageDialog dialog = new ImageDialog(Display.getDefault().getActiveShell(), image);
							dialog.open();
						}
					});
				}
			}
		});
	}

	/**
	 * Computes the mitigation graph for an attack path.
	 * @param attackPath
	 *            The attack path.
	 * @return The image.
	 **/
	private Image getMitigationExplanationGraph(AttackPath attackPath)
	{
		Collection<Object> vertexes = new HashSet<>();
		vertexes.addAll(attackPath.getAttackSteps());
		vertexes.addAll(attackPath.getAppliedProtectionInstantiations());

		Map<Entry<Object, Object>, String> edges = new HashMap<>();
		AttackStep lastStep = null;
		for (AttackStep i : attackPath.getAttackSteps())
			if (lastStep == null)
				lastStep = i;
			else
			{
				edges.put(new AbstractMap.SimpleEntry<Object, Object>(lastStep, i), null);
				lastStep = i;
			}
		for (AppliedProtectionInstantiation i : attackPath.getAppliedProtectionInstantiations())
			for (AttackMitigation j : i.getAttackMitigations())
				for (AttackStep k : attackPath.getAttackSteps())
					if (k.getType() == j.getType())
						edges.put(new AbstractMap.SimpleEntry<Object, Object>(i, k), j.getLevel().toString());

		DotWriter<Object> dotWriter = new DotWriter<>(adss, vertexes, edges);
		Image image = dotWriter.toImage();

		return image;
	}

	/**
	 * Computes the attack graph.
	 * @return The image.
	 **/
	private Image getAttackGraph()
	{
		Map<Entry<AttackStep, AttackStep>, String> edges = new HashMap<>();

		for (AttackPath i : adss.getModel().getAttackPaths())
		{
			AttackStep lastStep = null;
			for (AttackStep j : i.getAttackSteps())
				if (lastStep == null)
					lastStep = j;
				else
				{
					edges.put(new AbstractMap.SimpleEntry<AttackStep, AttackStep>(lastStep, j), null);
					lastStep = j;
				}
		}

		DotWriter<AttackStep> dotWriter = new DotWriter<>(adss, adss.getModel().getAttackSteps(), edges);
		Image image = dotWriter.toImage();

		return image;
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
				if (event == Event.ATTACK_PATH_UPDATED || event == Event.PROTECTIONS_UPDATED)
					pathsTreeNatTable.update(adss.getModel().getAttackPaths());
				else if (event == Event.ATTACK_STEP_UPDATED)
					stepsTreeNatTable.update(adss.getModel().getAttackSteps());
			}
		});
	}
}
