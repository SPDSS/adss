/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import com.clarkparsia.pellet.rules.BindingHelper;
import com.clarkparsia.pellet.rules.builtins.BuiltIn;
import com.clarkparsia.pellet.rules.model.BuiltInAtom;

/**
 * A SWRL built-in runner.
 * @author Daniele Canavese
 **/
class SWRLBuiltInRunner implements BuiltIn
{
	/**
	 * Creates the runner.
	 * @param builtin
	 *            The built-in to launch.
	 **/
	public SWRLBuiltInRunner(SWRLBuiltIn builtin)
	{
		this.builtin = builtin;
	}

	/**
	 * Bind the custom built-in to an atom.
	 * @param atom
	 *            The involved atom.
	 **/
	@Override
	public BindingHelper createHelper(BuiltInAtom atom)
	{
		return new SWRLHelper(atom, builtin);
	}

	/** The built-in. **/
	private SWRLBuiltIn builtin;
}
