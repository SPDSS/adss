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

import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;

/**
 * The type of labels.
 * @author Daniele Canavese
 **/
public enum LabelType
{
	/** The applications count label. **/
	ASSETS("icons/applicationParts.png", Event.APPLICATION_PARTS_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Assets: " + model.getAssetsCount() + "/" + model.getApplicationPartsCount();
		}
	}),
	/** The applications count label. **/
	PROTECTIONS("icons/protection.png", Event.PROTECTIONS_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Protections: " + model.getAvailableProtectionsCount() + "/" + model.getProtectionsCount();
		}
	}),
	/** The attacker tools count label. **/
	ATTACKER_TOOLS("icons/attackerTool.png", Event.ATTACKER_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Attacker tools: " + model.getAvailableAttackerToolsCount() + "/" + model.getAttackerToolsCount();
		}
	}),
	/** The attack paths count label. **/
	ATTACK_PATHS("icons/attackPath.png", Event.ATTACK_PATH_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Attack paths: " + model.getAttackPathsCount();
		}
	});

	/** The icon file. **/
	private String icon;
	/** The feature. **/
	private final Getter getter;
	/** The event. **/
	private final Event event;

	/**
	 * Creates a new label type.
	 * @param icon
	 *            The icon file.
	 * @param event
	 *            The event.
	 * @param getter
	 *            The getter to use.
	 **/
	LabelType(String icon, Event event, Getter getter)
	{
		this.icon = icon;
		this.event = event;
		this.getter = getter;
	}

	/**
	 * Retrieve the label string.
	 * @param model
	 *            The model.
	 * @return The label string.
	 **/
	public String getString(Model model)
	{
		return getter.get(model);
	}

	/**
	 * Retrieve the icon file.
	 * @return The icon file.
	 **/
	public String getIcon()
	{
		return icon;
	}

	/**
	 * Retrieve the event.
	 * @return The event.
	 **/
	public Event getEvent()
	{
		return event;
	}
}
