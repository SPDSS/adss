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
package eu.aspire_fp7.adss.akb.ui.listeners;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Generates the ADSS events.
 * @author Daniele Canavese
 **/
public class ADSSEventGenerator
{
	/**
	 * Creates the event generator.
	 **/
	public ADSSEventGenerator()
	{
		listeners = new ArrayList<>();
	}

	/**
	 * Signals an event.
	 * @param event
	 *            The event.
	 **/
	public void fireEvent(Event event)
	{
		for (ADSSEventListener i : listeners)
			i.handleEvent(event);
	}

	/**
	 * Signals a list of events.
	 * @param events
	 *            The events.
	 **/
	public void fireEvents(Event... events)
	{
		for (Event i : events)
			fireEvent(i);
	}

	/**
	 * Signals all the events at once.
	 **/
	public void fireAllEvents()
	{
		for (Event i : Event.values())
			fireEvent(i);
	}

	/**
	 * Adds a new listener.
	 * @param listener
	 *            The listener to add.
	 **/
	public void addListener(ADSSEventListener listener)
	{
		listeners.add(listener);
		for (Event i : Event.values())
			listener.handleEvent(i);
	}

	/** The listeners. **/
	private Collection<ADSSEventListener> listeners;
}
