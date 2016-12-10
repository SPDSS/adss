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
package eu.aspire_fp7.adss.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A sample metric point.
 * @author Daniele Canavese
 **/
public class Sample
{
	/** The x values. **/
	private Map<String, Double> x;
	/** The y value. **/
	private Double y;

	/**
	 * Creates the sample.
	 * @param x
	 *            The x values.
	 * @param y
	 *            The y value.
	 **/
	public Sample(Map<String, Double> x, Double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Retrieves the x values. Only the interesting metrics are returned and the missing ones are set to zero.
	 * @return The x values.
	 **/
	public List<Double> getX()
	{
		List<Double> list = new ArrayList<>();

		for (String i : MetricsFramework.METRICS)
			if (x.containsKey(i))
				list.add(x.get(i));
			else
				list.add(0.0);

		return list;
	}

	/**
	 * Retrieves the y value.
	 * @return The y value.
	 **/
	public Double getY()
	{
		return y;
	}

	/**
	 * Computes the object hashcode.
	 * @return The object hashcode.
	 **/
	@Override
	public int hashCode()
	{
		return Objects.hash(x, y);
	}

	/**
	 * Compares another object with the this one.
	 * @param object
	 *            The object for the comparison.
	 * @return <code>true</code> if the two objects are the same, <code>false</code> otherwise.
	 **/
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
			return false;
		else if (object instanceof Sample)
		{
			Sample sample = (Sample) object;
			return x.equals(sample.x) && y.equals(sample.y);
		}
		else
			return false;
	}

	/**
	 * Converts the object to a string.
	 * @return A string representation of the object.
	 **/
	@Override
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
}
