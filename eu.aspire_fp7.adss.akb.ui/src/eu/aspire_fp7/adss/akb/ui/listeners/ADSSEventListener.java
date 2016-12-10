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

import java.util.EventListener;

/**
 * An ADSS event listener.
 * @author Daniele Canavese
 **/
public interface ADSSEventListener extends EventListener
{
	/**
	 * Handles an event.
	 * @param event
	 *            The event.
	 **/
	void handleEvent(Event event);
}
