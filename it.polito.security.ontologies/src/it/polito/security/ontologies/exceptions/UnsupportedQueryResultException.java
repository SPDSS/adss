/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.exceptions;

/**
 * An exception signaling that a query result is not supported.
 * @author Luca Moretto, Daniele Canavese
 **/
public class UnsupportedQueryResultException extends Exception
{
	/** The class serial version UID. **/
	private static final long serialVersionUID = 2220129673168947995L;

	/**
	 * Create the exception with a message.
	 * @param message
	 *            The exception message.
	 **/
	public UnsupportedQueryResultException(String message)
	{
		super(message);
	}
}
