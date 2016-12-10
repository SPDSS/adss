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

/**
 * A non-hierarchical event.
 * @author Daniele Canavese
 **/
public enum Event
{
	/** One or more application part has been updated. **/
	APPLICATION_PARTS_UPDATED,
	/** The attacker has been updated. **/
	ATTACKER_UPDATED,
	/** One or more attack path has been updated. **/
	ATTACK_PATH_UPDATED,
	/** One or more attack step has been updated. **/
	ATTACK_STEP_UPDATED,
	/** One or more protection has been updated. **/
	PROTECTIONS_UPDATED,
	/** The solutions have been updated. **/
	SOLUTIONS_UPDATED
}
