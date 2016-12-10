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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommand;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommandHandler;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.event.CellVisualChangeEvent;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventGenerator;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;

/**
 * The application part data command handler.
 * @author Daniele Canavese
 **/
public class ApplicationPartUpdateDataCommandHandler extends UpdateDataCommandHandler
{
	/** The data layer. **/
	private DataLayer dataLayer;
	/** The ADSS. **/
	private ADSS adss;
	/** The event generator. **/
	private ADSSEventGenerator eventGenerator;

	/**
	 * Creates the command handler.
	 * @param adss
	 *            The ADSS.
	 * @param eventGenerator
	 *            The event generator.
	 * @param dataLayer
	 *            The data layer.
	 **/
	public ApplicationPartUpdateDataCommandHandler(ADSS adss, ADSSEventGenerator eventGenerator, DataLayer dataLayer)
	{
		super(dataLayer);
		this.adss = adss;
		this.eventGenerator = eventGenerator;
		this.dataLayer = dataLayer;
	}

	/**
	 * Executes a command.
	 * @param command
	 *            The command to run.
	 **/
	@SuppressWarnings("unchecked")
	@Override
	protected boolean doCommand(UpdateDataCommand command)
	{
		try
		{
			int columnPosition = command.getColumnPosition();
			int rowPosition = command.getRowPosition();

			Object currentValue = dataLayer.getDataValueByPosition(columnPosition, rowPosition);

			if (currentValue == null || command.getNewValue() == null || !currentValue.equals(command.getNewValue()))
			{
				if (columnPosition == 3)
				{
					ListDataProvider<ApplicationPart> dataProvider = (ListDataProvider<ApplicationPart>) dataLayer.getDataProvider();
					ApplicationPart part = dataProvider.getRowObject(dataLayer.getRowIndexByPosition(rowPosition));
					String value = command.getNewValue().toString();

					Collection<Property> properties = new ArrayList<>();
					if (value.contains("hard confidentiality"))
						properties.add(Property.HARDCONFIDENTIALITY);
					else if (value.contains("confidentiality"))
						properties.add(Property.CONFIDENTIALITY);
					else if (value.contains("privacy"))
						properties.add(Property.PRIVACY);
					if (value.contains("integrity"))
						properties.add(Property.INTEGRITY);

					boolean hardcoded = part.getProperties().contains(Property.HARDCODED);
					part.getProperties().clear();
					part.getProperties().addAll(properties);
					if (hardcoded)
						part.getProperties().add(Property.HARDCODED);
					adss.updateAssets();
					eventGenerator.fireEvent(Event.APPLICATION_PARTS_UPDATED);
				}
				else
					dataLayer.setDataValueByPosition(columnPosition, rowPosition, command.getNewValue());
				dataLayer.fireLayerEvent(new CellVisualChangeEvent(this.dataLayer, columnPosition, rowPosition));
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
