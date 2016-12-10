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
package eu.aspire_fp7.adss.ui;

import eu.aspire_fp7.adss.akb.Model;

/**
 * An ADSS dirty listener.
 * @author Daniele Canavese
 **/
public interface ADSSDirtyListener
{
	/**
	 * Signals that the dirty state of a model has changed.
	 * @param model
	 *            The model.
	 * @param dirty
	 *            The new dirty state of the model.
	 **/
	public void dirtyStateChanged(Model model, boolean dirty);
}
