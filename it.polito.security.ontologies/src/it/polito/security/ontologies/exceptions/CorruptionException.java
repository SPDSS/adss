/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.exceptions;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * An exception signaling that an ontology is corrupted.
 * @author Daniele Canavese
 **/
public class CorruptionException extends Exception
{
	/** The class serial version UID. **/
	private static final long serialVersionUID = -4168611125086971912L;
	/** The corruption map. **/
	private Map<EObject, String> map;

	/**
	 * Create the exception with a message.
	 * @param message
	 *            The exception message.
	 * @param The
	 *            corruption map.
	 * @param map
	 **/
	public CorruptionException(String message, Map<EObject, String> map)
	{
		super(message);
		this.map = map;
	}

	/**
	 * Retrieves the corruption map.
	 * @return The corruption map.
	 **/
	public Map<EObject, String> getMap()
	{
		return map;
	}
}
