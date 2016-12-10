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

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The rank selection method with replacement.<br/>
 * The probability of a chromosome to be selected is proportional to its rank.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class RankSelection<T> extends SelectionFunction<T>
{
	/** The comparator. **/
	private Comparator<List<List<T>>> comparator;

	/**
	 * Create the selection function.
	 **/
	public RankSelection()
	{
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
	 * Selects some interesting chromosomes from a population.
	 * @param quantity
	 *            The number of chromosomes to select.
	 * @param selection
	 *            The selection.
	 **/
	public void select(int quantity, List<List<List<T>>> selection)
	{
		selection.clear();

		geneticAlgorithm.population.sort(comparator);

		Map<List<List<T>>, Integer> ranks = new HashMap<>();
		for (int i = 0; i < geneticAlgorithm.population.size(); ++i)
			ranks.put(geneticAlgorithm.population.get(i), geneticAlgorithm.population.size() - i);

		double[] c = new double[geneticAlgorithm.population.size()];
		c[0] = ranks.get(geneticAlgorithm.population.get(0));
		for (int i = 1; i < geneticAlgorithm.population.size(); i++)
			c[i] = c[i - 1] + ranks.get(geneticAlgorithm.population.get(i));

		for (int i = 0; i < quantity; i++)
		{
			double randomFitness = geneticAlgorithm.random.nextDouble() * c[c.length - 1];
			int index = Arrays.binarySearch(c, randomFitness);
			if (index < 0)
				index = Math.abs(index + 1);
			if (index == geneticAlgorithm.population.size())
				--index;
			selection.add(geneticAlgorithm.population.get(index));
		}
	}
}
