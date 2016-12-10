/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

/** The reasoner type. **/
public enum ReasonerType
{
	/** The FaCT++ reasoner. **/
	FACTPLUSPLUS,
	/** The HermiT reasoner. **/
	HERMIT,
	/** The Pellet reasoner. **/
	PELLET;

	/**
	 * Convert the item to a string.
	 * @return The string representation of the enumeration item.
	 **/
	@Override
	public String toString()
	{
		if (this == FACTPLUSPLUS)
			return "FaCT++";
		else if (this == HERMIT)
			return "HermiT";
		else if (this == PELLET)
			return "Pellet";
		else
			return null;
	}
}
