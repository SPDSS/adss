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
 * The measure types.
 * @author Daniele Canavese
 **/
public enum MeasureType
{
	/** The confusion related to an asset. **/
	UNCERTAINTY,
	/** The number of instructions moved to a safe server. **/
	REMOTE_INSTRUCTIONS,
	/** The ability to detect an unwanted modification. **/
	ALTERATION_DETECTION,
	/** The ability to negate an unwanted modification. **/
	ALTERATION_AVOIDANCE
}
