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
package it.polito.security.ontologies.tools;

import org.semanticweb.owlapi.model.OWLClassExpression;

/**
 * A class expression walker.
 * @author Daniele Canavese
 **/
interface ClassWalker
{
	/**
	 * Check a class expression.
	 * @param clazz
	 *            The expression to check.
	 * @return <code>true</code> if the expression is ok, <code>false</code> otherwise.
	 **/
	public boolean check(OWLClassExpression clazz);
}
