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
import eu.aspire_fp7.adss.akb.AttackPath;

/**
 * Evaluates an attack path.
 * 
 * @author Daniele Canavese
 **/
public class SimpleAttackEvaluator extends AttackEvaluator
{
	/**
	 * Creates the evaluator.
	 * @param adss
	 *            The ADSS.
	 **/
	public SimpleAttackEvaluator(ADSS adss)
	{
		super(adss);
	}

	/**
	 * Retrieves the effort for an attack path.
	 * @param state
	 *            The state.
	 * @param attackPath
	 *            The attack path.
	 * @return The attack path effort.
	 **/
	public double getEffort(State state, AttackPath attackPath)
	{
		return 0.0f;
//		return attackPath.getCost();
	}
}
