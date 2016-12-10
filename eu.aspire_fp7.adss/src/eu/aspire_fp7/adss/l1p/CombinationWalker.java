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
import java.util.Collection;
import java.util.List;

/**
 * A combination walker class. This class makes use of the algorithm C (Chase's sequence) described in The Art of Computer Programming
 * volume 4A, section 7.2.1.3.
 * @author Daniele Canavese
 * @param <T>
 *            The type of the set elements.
 **/
public class CombinationWalker<T>
{
	/** The a array. **/
	private List<Integer> a;
	/** The w array. **/
	private List<Integer> w;
	/** The array containing the numbers of the combination. **/
	private List<Integer> numbers;
	/** The positions array. **/
	private List<Integer> positions;
	/** The array map for the symbols and the integers. **/
	private List<T> map;
	/** The output vector containing the combinations. **/
	private List<T> vector;
	/** The r variable. **/
	private int r;
	/** The n variable. **/
	private int n;
	/** The s variable. **/
	private int s;
	/** The t variable. **/
	private int t;
	/** The current state. **/
	private State state;
	/** The symbols. **/
	private final Collection<T> symbols;

	/**
	 * The states.
	 * @author Daniele Canavese
	 **/
	private enum State
	{
		/** The state C2. **/
		C2,
		/** The state C3, C4, C5, C6 and C7. **/
		C3_C4_C5_C6_C7,
	}

	/**
	 * Creates the walker.
	 * @param symbols
	 *            The symbols to use.
	 * @param vector
	 *            The vector that will store the combinations. Only its first @a t elements will be used. Note that only the walker is
	 *            allowed to modify it.
	 * @param t
	 *            The size of the combinations.
	 **/
	public CombinationWalker(Collection<T> symbols, List<T> vector, int t)
	{
		this.symbols = symbols;
		this.t = t;
		this.vector = vector;
		n = symbols.size();
		s = symbols.size() - t;
		a = new ArrayList<>();
		w = new ArrayList<>();
		numbers = new ArrayList<>();
		positions = new ArrayList<>();
		map = new ArrayList<>();

		reset();
	}

	/**
	 * Resets the combination walker.
	 **/
	public void reset()
	{
		a.clear();
		w.clear();
		numbers.clear();
		positions.clear();
		map.clear();
		vector.clear();

		for (int i = 0; i < t; ++i)
			numbers.add(0);
		for (int i = 0; i < n; ++i)
			positions.add(0);

		for (int i = 0; i < s; ++i)
			a.add(0);
		for (int i = s; i < n; ++i)
			a.add(1);
		for (int i = 0; i <= n; ++i)
			w.add(1);
		if (s > 0)
			r = s;
		else
			r = t;
		int j = 0;
		for (int i = 0; i < n; ++i)
			if (a.get(i) == 1)
			{
				numbers.set(j, i);
				positions.set(i, j++);
			}
		for (T i : symbols)
			map.add(i);
		for (int i = 0; i < t; ++i)
			vector.add(map.get(symbols.size() - t + i));
		state = State.C2;
	}

	/**
	 * Computes the next combination.
	 * @return <code>true</code> if a combination was found, <code>false</code> otherwise.
	 **/
	public boolean computeNext()
	{
		while (true)
			if (state == State.C2)
			{
				state = State.C3_C4_C5_C6_C7;

				return true;
			}
			else if (state == State.C3_C4_C5_C6_C7)
			{
				int j = r;
				while (w.get(j) == 0)
				{
					w.set(j, 1);
					++j;
				}
				if (j == n)
					return false;

				w.set(j, 0);
				if (a.get(j) != 0 && ((j & 1) == 1 || a.get(j - 2) != 0))
				{
					a.set(j - 1, 1);
					a.set(j, 0);
					numbers.set(positions.get(j), j - 1);
					vector.set(positions.get(j), map.get(j - 1));
					positions.set(j - 1, positions.get(j));
					if (r == j && r > 1)
						r = j - 1;
					else if (r == j - 1)
						r = j;
				}
				else if ((j & 1) == 0 && a.get(j) != 0)
				{
					a.set(j - 2, 1);
					a.set(j, 0);
					numbers.set(positions.get(j), j - 2);
					vector.set(positions.get(j), map.get(j - 2));
					positions.set(j - 2, positions.get(j));
					if (r == j)
						r = Math.max(j - 2, 1);
					else if (r == j - 2)
						r = j - 1;
				}
				else if (a.get(j) == 0 && ((j & 1) == 0 || a.get(j - 1) != 0))
				{
					a.set(j, 1);
					a.set(j - 1, 0);
					numbers.set(positions.get(j - 1), j);
					vector.set(positions.get(j - 1), map.get(j));
					positions.set(j, positions.get(j - 1));
					if (r == j && r > 1)
						r = j - 1;
					else if (r == j - 1)
						r = j;
				}
				else if ((j & 1) == 1 && a.get(j) == 0)
				{
					a.set(j, 1);
					a.set(j - 2, 0);
					numbers.set(positions.get(j - 2), j);
					vector.set(positions.get(j - 2), map.get(j));
					positions.set(j, positions.get(j - 2));
					if (r == j - 2)
						r = j;
					else if (r == j - 1)
						r = j - 2;
				}
				state = State.C2;
			}
	}

	/**
	 * Estimates the number of combinations.
	 * @return The estimate.
	 **/
	public double estimate()
	{
		return estimate(n) / (estimate(t) * estimate(n - t));
	}

	/**
	 * Estimates the factorial of a number using the Stirling formula.
	 * @param n
	 *            The value.
	 * @return The approximate value of n!.
	 **/
	private double estimate(int n)
	{
		return Math.pow(n / Math.E, n) * Math.sqrt(2 * Math.PI * n);
	}
}
