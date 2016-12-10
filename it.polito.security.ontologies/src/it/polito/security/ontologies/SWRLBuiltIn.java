/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

/**
 * The code for a SWRL custom built-in.
 * @author Daniele Canavese
 **/
public abstract class SWRLBuiltIn
{
	/**
	 * Executes the built-in.
	 * @param ontology
	 *            The flat ontology.
	 * @param parameters
	 *            The parameters of the built-in.
	 * @return <code>true</code> if the function succeeded, <code>false</code> otherwise.
	 **/
	public abstract boolean execute(Ontology ontology, Object[] parameters);

	/**
	 * Detects if this built-in is applicable or not.
	 * @param boundPositions
	 *            An array containing determining if the variables are bounded or not.
	 * @return <code>true</code> if the built-in is applicable, <code>false</code> otherwise.
	 **/
	public abstract boolean isApplicable(boolean[] boundPositions);
}
