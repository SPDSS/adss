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
package eu.aspire_fp7.adss.akb.ui.nattables;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultIntegerDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.config.DefaultEditBindings;
import org.eclipse.nebula.widgets.nattable.edit.config.DefaultEditConfiguration;
import org.eclipse.nebula.widgets.nattable.edit.config.RenderErrorHandling;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.DetailGlazedListsEventLayer;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.GlazedListsSortModel;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.filterrow.DefaultGlazedListsFilterStrategy;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.tree.GlazedListTreeData;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.tree.GlazedListTreeRowModel;
import org.eclipse.nebula.widgets.nattable.filterrow.FilterRowHeaderComposite;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.DefaultColumnHeaderDataLayer;
import org.eclipse.nebula.widgets.nattable.hideshow.ColumnHideShowLayer;
import org.eclipse.nebula.widgets.nattable.hideshow.RowHideShowLayer;
import org.eclipse.nebula.widgets.nattable.layer.CompositeLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ColumnOverrideLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.NatTableBorderOverlayPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ImagePainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.CellPainterDecorator;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.PaddingDecorator;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.sort.ISortModel;
import org.eclipse.nebula.widgets.nattable.sort.SortHeaderLayer;
import org.eclipse.nebula.widgets.nattable.sort.config.SingleClickSortConfiguration;
import org.eclipse.nebula.widgets.nattable.style.CellStyleAttributes;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.Style;
import org.eclipse.nebula.widgets.nattable.style.theme.ModernNatTableThemeConfiguration;
import org.eclipse.nebula.widgets.nattable.tree.TreeLayer;
import org.eclipse.nebula.widgets.nattable.tree.config.DefaultTreeLayerConfiguration;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TreeList;
import ca.odell.glazedlists.TreeList.ExpansionModel;
import ca.odell.glazedlists.TreeList.Format;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The ADSS standard table.
 * @author Daniele Canavese
 *
 * @param <T>
 *            The table content class.
 */
public class ADSSNatTable<T> extends NatTable
{
	/** The event list. **/
	private EventList<T> eventList;
	/** The body data layer. **/
	private DataLayer bodyDataLayer;
	/** The body data provider. **/
	private ListDataProvider<T> bodyDataProvider;
	/** The label accumulator. **/
	private ColumnOverrideLabelAccumulator labelAccumulator;

	/**
	 * Creates the table.
	 * @param parent
	 *            The parent composite.
	 * @param content
	 *            The table content.
	 * @param propertyNames
	 *            The property to use in the objects.
	 * @param propertyToLabelMap
	 *            The property to label map.
	 * @param format
	 *            The format class.
	 * @param expansionModel
	 *            The expansion model.
	 * @throws MalformedURLException
	 *             If some image cannot be loaded.
	 **/
	public ADSSNatTable(Composite parent, Collection<T> content, String[] propertyNames, Map<String, String> propertyToLabelMap,
			Format<T> format, ExpansionModel<T> expansionModel) throws MalformedURLException
	{
		super(parent, false);

		ConfigRegistry configRegistry = new ConfigRegistry();

		eventList = GlazedLists.eventList(content);
		SortedList<T> sortedList = new SortedList<>(eventList, null);
		FilterList<T> filterList = new FilterList<T>(sortedList);

		IColumnPropertyAccessor<T> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<>(propertyNames);

		IDataProvider columnHeaderDataProvider = new DefaultColumnHeaderDataProvider(propertyNames, propertyToLabelMap);
		DataLayer columnHeaderDataLayer = new DefaultColumnHeaderDataLayer(columnHeaderDataProvider);

		ISortModel sortModel = new GlazedListsSortModel<T>(sortedList, columnPropertyAccessor, configRegistry, columnHeaderDataLayer);

		TreeList<T> treeList = new TreeList<>(filterList, format, expansionModel);
		GlazedListTreeData<T> treeData = new GlazedListTreeData<>(treeList);

		bodyDataProvider = new ListDataProvider<>(treeList, columnPropertyAccessor);
		bodyDataLayer = new DataLayer(bodyDataProvider);

		DetailGlazedListsEventLayer<T> glazedListsEventLayer = new DetailGlazedListsEventLayer<>(bodyDataLayer, treeList);

		ColumnReorderLayer columnReorderLayer = new ColumnReorderLayer(glazedListsEventLayer);
		ColumnHideShowLayer columnHideShowLayer = new ColumnHideShowLayer(columnReorderLayer);

		RowHideShowLayer rowHideShowLayer = new RowHideShowLayer(columnHideShowLayer);

		TreeLayer treeLayer = new TreeLayer(rowHideShowLayer, new GlazedListTreeRowModel<T>(treeData), false)
		{
			@Override
			public ICellPainter getCellPainter(int columnPosition, int rowPosition, ILayerCell cell, IConfigRegistry configRegistry)
			{
				ICellPainter cellPainter = super.getCellPainter(columnPosition, rowPosition, cell, configRegistry);
				if (columnPosition == TREE_COLUMN_NUMBER)
					cellPainter = new PaddingDecorator(cellPainter, 0, 0, 0, 20 * getDepth(cell));
				return cellPainter;
			}

			protected int getDepth(ILayerCell cell)
			{
				int depth = 0;

				for (String configLabel : cell.getConfigLabels().getLabels())
				{
					if (configLabel.startsWith("depth:"))
					{
						String[] tokens = configLabel.split(":");
						depth = Integer.valueOf(tokens[tokens.length - 1]).intValue();
					}
				}

				return depth;
			}
		};

		SelectionLayer selectionLayer = new SelectionLayer(treeLayer);

		ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);
		viewportLayer.addConfiguration(new DefaultEditConfiguration());
		viewportLayer.addConfiguration(new DefaultEditBindings());

		ColumnHeaderLayer columnHeaderLayer = new ColumnHeaderLayer(columnHeaderDataLayer, viewportLayer, selectionLayer);
		FilterRowHeaderComposite<T> filterRowHeaderComposite = new FilterRowHeaderComposite<T>(
				new DefaultGlazedListsFilterStrategy<T>(filterList, columnPropertyAccessor, configRegistry), columnHeaderLayer,
				columnHeaderDataProvider, configRegistry);

		labelAccumulator = new ColumnOverrideLabelAccumulator(columnHeaderDataLayer);
		columnHeaderDataLayer.setConfigLabelAccumulator(labelAccumulator);

		SortHeaderLayer<ApplicationPart> sortHeaderLayer = new SortHeaderLayer<>(filterRowHeaderComposite, sortModel, false);

		CompositeLayer compositeLayer = new CompositeLayer(1, 2);
		compositeLayer.setChildLayer(GridRegion.COLUMN_HEADER, sortHeaderLayer, 0, 0);
		compositeLayer.setChildLayer(GridRegion.BODY, viewportLayer, 0, 1);
		setLayer(compositeLayer);

		setConfigRegistry(configRegistry);
		bodyDataLayer.setColumnPercentageSizing(true);

		bodyDataLayer.setDefaultRowHeight(GUIHelper.DEFAULT_FONT.getFontData()[0].getHeight() + 10);
		columnHeaderDataLayer.setDefaultRowHeight(GUIHelper.DEFAULT_FONT.getFontData()[0].getHeight() + 10);
		addConfiguration(new ModernNatTableThemeConfiguration());
		addConfiguration(new DefaultTreeLayerConfiguration(treeLayer));
		addConfiguration(new SingleClickSortConfiguration());

		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new ADSSDisplayConverter());
		configRegistry.registerConfigAttribute(EditConfigAttributes.VALIDATION_ERROR_HANDLER, new RenderErrorHandling(), DisplayMode.EDIT);

		CellPainterDecorator cellPainter = new CellPainterDecorator(new ADSSPainter(), CellEdgeEnum.LEFT, new ImagePainter());
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, cellPainter, DisplayMode.NORMAL, GridRegion.BODY);

		Style assetStyle = new Style();
		assetStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, new Color(Display.getDefault(), 244, 244, 255));
		assetStyle.setAttributeValue(CellStyleAttributes.FOREGROUND_COLOR, new Color(Display.getDefault(), 70, 130, 180));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, assetStyle, DisplayMode.NORMAL, "asset");

		Style codeStyle = new Style();
		codeStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/code.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, codeStyle, DisplayMode.NORMAL, "code");

		Style datumStyle = new Style();
		datumStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/datum.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, datumStyle, DisplayMode.NORMAL, "datum");

		Style referenceStyle = new Style();
		referenceStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/reference.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, referenceStyle, DisplayMode.NORMAL, "reference");

		Style attackerToolStyle = new Style();
		attackerToolStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackerTool.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, attackerToolStyle, DisplayMode.NORMAL, "attackerTool");
		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultIntegerDisplayConverter()
		{
			@Override
			public Object canonicalToDisplayValue(Object canonicalValue)
			{
				return "€ " + super.canonicalToDisplayValue(canonicalValue);
			}
		}, DisplayMode.NORMAL, "cost");

		Style disabledStyle = new Style();
		disabledStyle.setAttributeValue(CellStyleAttributes.FOREGROUND_COLOR, new Color(Display.getDefault(), 100, 100, 100));
		disabledStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, new Color(Display.getDefault(), 222, 222, 222));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, disabledStyle, DisplayMode.NORMAL, "disabled");

		Style attackPathStyle = new Style();
		attackPathStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackPath.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, attackPathStyle, DisplayMode.NORMAL, "attackPath");

		Style attackStepStyle = new Style();
		attackStepStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackStep.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, attackStepStyle, DisplayMode.NORMAL, "attackStep");

		Style dangerLevelStyle = new Style();
		dangerLevelStyle.setAttributeValue(CellStyleAttributes.FOREGROUND_COLOR, new Color(Display.getDefault(), 255, 255, 255));
		dangerLevelStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, new Color(Display.getDefault(), 127, 127, 127));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, dangerLevelStyle, DisplayMode.NORMAL, "dangerLevel");

		Style lowLevelStyle = new Style();
		lowLevelStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, new Color(Display.getDefault(), 255, 222, 222));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, lowLevelStyle, DisplayMode.NORMAL, "lowLevel");

		Style mediumLevelStyle = new Style();
		mediumLevelStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, new Color(Display.getDefault(), 255, 255, 222));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, mediumLevelStyle, DisplayMode.NORMAL, "mediumLevel");

		Style highLevelStyle = new Style();
		highLevelStyle.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, new Color(Display.getDefault(), 222, 255, 222));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, highLevelStyle, DisplayMode.NORMAL, "highLevel");

		Style protectionStyle = new Style();
		protectionStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/protection.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, protectionStyle, DisplayMode.NORMAL, "protection");

		Style solutionStyle = new Style();
		solutionStyle.setAttributeValue(CellStyleAttributes.IMAGE, Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png"));
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_STYLE, solutionStyle, DisplayMode.NORMAL, "solution");

		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultIntegerDisplayConverter()
		{
			@Override
			public Object canonicalToDisplayValue(Object canonicalValue)
			{
				return super.canonicalToDisplayValue(canonicalValue) + " <asset/>";
			}
		}, DisplayMode.NORMAL, "assetBadge");
		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultIntegerDisplayConverter()
		{
			@Override
			public Object canonicalToDisplayValue(Object canonicalValue)
			{
				String value = super.canonicalToDisplayValue(canonicalValue).toString();
				value = value.replaceAll("\\(low\\)", "<low/>");
				value = value.replaceAll("\\(medium\\)", "<medium/>");
				value = value.replaceAll("\\(high\\)", "<high/>");
				return value;
			}
		}, DisplayMode.NORMAL, "mitigationsBadges");

		addOverlayPainter(new NatTableBorderOverlayPainter(configRegistry));

		configure();
	}

	/**
	 * Updates the table content.
	 * @param content
	 *            The new content.
	 **/
	public void update(Collection<T> content)
	{
		eventList.clear();
		eventList.addAll(content);
		refresh();
	}

	/**
	 * Retrieves the body data layer.
	 * @return The body data layer.
	 **/
	public DataLayer getBodyDataLayer()
	{
		return bodyDataLayer;
	}

	/**
	 * Retrieves the body data provider.
	 * @return The body data provider.
	 **/
	public ListDataProvider<T> getBodyDataProvider()
	{
		return bodyDataProvider;
	}

	/**
	 * Retrieves the label accumulator.
	 * @return The label accumulator.
	 **/
	public ColumnOverrideLabelAccumulator getLabelAccumulator()
	{
		return labelAccumulator;
	}
}
