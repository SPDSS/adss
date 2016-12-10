/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.exceptions;

/**
 * An exception signaling that the ontology creation has failed.
 * @author Daniele Canavese
 **/
public class OntologyCreationException extends Exception
{
	/** The class serial version UID. **/
	private static final long serialVersionUID = -5203342599463587093L;

	/**
	 * Create the exception with a message.
	 * @param message
	 *            The exception message.
	 **/
	public OntologyCreationException(String message)
	{
		super(message);
	}
}
