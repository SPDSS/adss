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
package eu.aspire_fp7.adss.ga;

import java.util.Comparator;
import java.util.List;

/**
 * Standard clearing function.<br/>
 * Basically the population is divided in sub-populations, then the fitness of
 * all but some best individuals for each sub-population is set to negative
 * infinity.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class StandardClearing<T> extends ClearingFunction<T>
{
	/** The comparator. **/
	private Comparator<List<List<T>>> comparator;
	/** The clearing radius. **/
	private double delta;
	/** The sub-populations size. **/
	private int capacity;

	/**
	 * Create the clearing function.
	 * @param delta
	 *            The clearing radius.
	 * @param capacity
	 *            The sub-populations size.
	 **/
	public StandardClearing(double delta, int capacity)
	{
		this.delta = delta;
		this.capacity = capacity;
		comparator = new Comparator<List<List<T>>>()
		{
			@Override
			public int compare(List<List<T>> o1, List<List<T>> o2)
			{
				double delta = geneticAlgorithm.fitnessValues.get(o1) - geneticAlgorithm.fitnessValues.get(o2);
				if (delta < 0)
					return 1;
				else if (delta > 0)
					return -1;
				else
					return 0;
			}
		};
	}

	/**
	 * Clears the population.
	 **/
	public void clear()
	{
		geneticAlgorithm.population.sort(comparator);

		for (int i = 0; i < geneticAlgorithm.population.size(); ++i)
		{
			double f1 = geneticAlgorithm.fitnessValues.get(geneticAlgorithm.population.get(i));
			if (f1 != Double.NEGATIVE_INFINITY)
			{
				int n = 1;
				for (int j = i + 1; j < geneticAlgorithm.population.size(); ++j)
				{
					double f2 = geneticAlgorithm.fitnessValues.get(geneticAlgorithm.population.get(j));
					if (f2 != Double.NEGATIVE_INFINITY && Math.abs(f1 - f2) < delta)
					{
						if (n < capacity)
							++n;
						else
							geneticAlgorithm.fitnessValues.put(geneticAlgorithm.population.get(j), Double.NEGATIVE_INFINITY);
					}
				}
			}
		}
	}
}
