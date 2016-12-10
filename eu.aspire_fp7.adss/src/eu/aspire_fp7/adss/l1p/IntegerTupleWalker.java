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

import java.util.ArrayList;
import java.util.List;

/**
 * An integer tuple walker class. This class makes use of the algorithm H (Loopless reflected mixed-radix Gray generation) described in The
 * Art of Computer Programming volume 4A, section 7.2.1.1.
 * @author Daniele Canavese
 **/
public class IntegerTupleWalker
{
	/** The output vector containing the tuples. **/
	private List<Integer> vector;
	/** The vector containing the maximum values for the vector elements. **/
	private List<Integer> values;
	/** The vector containing the indexes > 1. **/
	private List<Integer> indexes;
	/** The f array. **/
	private List<Integer> f;
	/** The o array. **/
	private List<Integer> o;
	/** The n variable. **/
	private int n;
	/** The j variable. **/
	private int j;
	/** The current state. **/
	private State state;

	/**
	 * The states.
	 **/
	private enum State
	{
		/** The state H2. **/
		H2,
		/** The states H3, H4 and H5. **/
		H3_H4_H5
	}

	/**
	 * Creates the walker.
	 * @param values
	 *            The maximum values for the tuple elements.
	 * @param vector
	 *            The vector that will store the tuple.
	 **/
	public IntegerTupleWalker(List<Integer> values, List<Integer> vector)
	{
		this.values = values;
		this.vector = vector;
		
		reset();
	}

	/**
	 * Resets the walker.
	 **/
	public void reset()
	{
		n = 0;

		indexes = new ArrayList<>();

		vector.clear();

		for (int i = 0; i < values.size(); ++i)
		{
			vector.add(1);
			if (values.get(i) > 1)
			{
				indexes.add(i);
				++n;
			}
		}

		f = new ArrayList<>();
		o = new ArrayList<>();

		for (int i = 0; i < n; ++i)
		{
			f.add(i);
			o.add(1);
		}
		f.add(n);
		state = State.H2;
	}

	/**
	 * Computes the next tuple. Note that the ranges starts always from 1.
	 * @return <code>true</code> if a combination was found, <code>false</code> otherwise.
	 **/
	public boolean computeNext()
	{
		while (true)
			if (state == State.H2)
			{
				state = State.H3_H4_H5;
				return true;
			}
			else if (state == State.H3_H4_H5)
			{
				j = f.get(0);
				f.set(0, 0);
				if (j == n)
					return false;
				vector.set(indexes.get(j), vector.get(indexes.get(j)) + o.get(j));
				if (vector.get(indexes.get(j)) == 1 || vector.get(indexes.get(j)) == values.get(indexes.get(j)))
				{
					o.set(j, -o.get(j));
					f.set(j, f.get(j + 1));
					f.set(j + 1, j + 1);
				}
				state = State.H2;
			}
	}

	/**
	 * Estimates the number of tuples.
	 * @return The estimate.
	 **/
	public double estimate()
	{
		double r = 1;

		for (int i : values)
			r *= i;

		return r;
	}
}
