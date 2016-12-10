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
 * A permutation walker class. This class makes use of the algorithm X (Lexicographic permutations with restricted
 * prefixes) described in The Art of Computer Programming volume 4A, section 7.2.1.2.
 * @author Daniele Canavese
 * @param <T>
 *            The type of the permutation elements.
 **/
public class PermutationWalker<T>
{
	/** The internal integer array. **/
	private List<Integer> array;
	/** The link array. **/
	private List<Integer> l;
	/** The auxiliary array. **/
	private List<Integer> auxiliary;
	/** The k variable! **/
	private int k;
	/** The p variable! **/
	private int p;
	/** The q variable! **/
	private int q;
	/** The state. **/
	private State state;
	/** The array map for the symbols and the integers. **/
	private List<T> map;
	/** The prefix tester. **/
	private final PrefixTester<T> tester;
	/** The output vector containing the permutations. **/
	private List<T> vector;
	/** The n variable. **/
	private int n;
	/** The symbols. **/
	private final Collection<T> symbols;

	/**
	 * The state values.
	 **/
	private enum State
	{
		/** The state X2. **/
		X2,
		/** The states X3 and X4. **/
		X3_X4,
		/** The state X5. **/
		X5,
		/** The state X6. **/
		X6
	}

	/**
	 * Creates the walker.
	 * @param symbols
	 *            The symbols to use.
	 * @param tester
	 *            The prefix tester object.
	 * @param vector
	 *            The vector that will store the permutations. Only its first @a t elements will be used. Note that only
	 *            the walker is allowed to modify it.
	 **/
	public PermutationWalker(Collection<T> symbols, PrefixTester<T> tester, List<T> vector)
	{
		this.symbols = symbols;
		n = symbols.size();
		this.tester = tester;
		this.vector = vector;
		array = new ArrayList<>();
		l = new ArrayList<>();
		auxiliary = new ArrayList<>();
		map = new ArrayList<>();

		reset();
	}

	/**
	 * Resets the walker.
	 **/
	public void reset()
	{
		vector.clear();
		map.clear();
		array.clear();
		auxiliary.clear();
		l.clear();

		k = 0;
		p = 0;
		q = 0;
		for (T i : symbols)
		{
			vector.add(null);
			map.add(i);
			array.add(0);
			auxiliary.add(0);
		}

		for (int i = 0; i < n; ++i)
			l.add(i + 1);
		l.add(0);
		k = 1;
		state = State.X2;
	}

	/**
	 * Computes the next valid permutation.
	 * @return <code>true</code> if a permutation was found, <code>false</code> otherwise.
	 **/
	public boolean computeNext()
	{
		while (true)
			if (state == State.X2)
			{
				p = 0;
				q = l.get(0);
				state = State.X3_X4;
			}
			else if (state == State.X3_X4)
			{
				array.set(k - 1, q);
				vector.set(k - 1, map.get(array.get(k - 1) - 1));
				if (!tester.isValid(vector, k))
					state = State.X5;
				else if (k == n)
				{
					state = State.X6;
					return true;
				}
				else
				{
					auxiliary.set(k, p);
					l.set(p, l.get(q));
					++k;
					state = State.X2;
				}
			}
			else if (state == State.X5)
			{
				p = q;
				q = l.get(p);
				if (q != 0)
					state = State.X3_X4;
				else
					state = State.X6;
			}
			else if (state == State.X6)
			{
				--k;
				if (k <= 0)
					return false;
				else
				{
					p = auxiliary.get(k);
					q = array.get(k - 1);
					l.set(p, q);
					state = State.X5;
				}
			}
	}

	/**
	 * Estimates the number of permutations. It does not take into account the prefixes pruning.
	 * @return The estimate.
	 **/
	public double estimate()
	{
		return Math.pow(n / Math.E, n) * Math.sqrt(2 * Math.PI * n);
	}
}
