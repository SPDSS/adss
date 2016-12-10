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
package eu.aspire_fp7.adss.l1p;

import eu.aspire_fp7.adss.ADSS;

/**
 * Evaluates a protection.
 * 
 * @author Daniele Canavese
 **/
public abstract class ProtectionEvaluator
{
	/** The ADSS. **/
	protected ADSS adss;

	/**
	 * Creates the evaluator.
	 * @param adss
	 *            The ADSS.
	 **/
	public ProtectionEvaluator(ADSS adss)
	{
		this.adss = adss;
	}

	/**
	 * Initializes the connector.
	 **/
	public void initialize()
	{
	}

	/**
	 * Retrieves the strength for a set of protections.
	 * @param state
	 *            The state.
	 * @return The protection strength.
	 **/
	public abstract double getStrength(State state);
}
