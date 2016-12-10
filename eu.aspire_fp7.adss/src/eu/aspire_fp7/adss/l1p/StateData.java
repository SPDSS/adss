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
 * The score data.
 * @author Daniele Canavese
 **/
public class StateData
{
	/** The state value. **/
	private double value;
	/** The state ply. **/
	private int ply;
	/** The state type. **/
	private StateType type;

	/**
	 * Creates a new state data.
	 * @param value
	 *            The state value.
	 * @param ply
	 *            The state ply.
	 * @param type
	 *            The state type.
	 **/
	public StateData(double value, int ply, StateType type)
	{
		this.value = value;
		this.ply = ply;
		this.type = type;
	}

	/**
	 * Retrieve the state value.
	 * @return The state value.
	 **/
	public double getValue()
	{
		return value;
	}

	/**
	 * Sets the state value.
	 * @param value
	 *            The state value.
	 **/
	public void setValue(double value)
	{
		this.value = value;
	}

	/**
	 * Retrieve the state ply.
	 * @return The state ply.
	 **/
	public int getPly()
	{
		return ply;
	}

	/**
	 * Retrieve the state type.
	 * @return The state type.
	 **/
	public StateType getType()
	{
		return type;
	}

	/**
	 * Sets the state type.
	 * @param type
	 *            The state type.
	 **/
	public void setType(StateType type)
	{
		this.type = type;
	}
}
