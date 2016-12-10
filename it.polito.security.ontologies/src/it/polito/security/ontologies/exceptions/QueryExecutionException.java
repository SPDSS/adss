/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.exceptions;

/**
 * An exception signaling that a query execution has failed.
 * @author Luca Moretto, Daniele Canavese
 **/
public class QueryExecutionException extends Exception
{
	/** The class serial version UID. **/
	private static final long serialVersionUID = -6367956933483311034L;

	/**
	 * Create the exception with a message.
	 * @param message
	 *            The exception message.
	 **/
	public QueryExecutionException(String message)
	{
		super(message);
	}
}
