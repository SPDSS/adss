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

/**
 * The state type in a transposition table.
 * @author Daniele Canavese
 **/
public enum StateType
{
	/** A node with an exact score. **/
	EXACT_NODE,
	/** A node with an upper bound value. **/
	UPPER_NODE,
	/** A node with a lower bound value. **/
	LOWER_NODE,
	/** A node with an invalid value. **/
	INVALID_NODE
}
