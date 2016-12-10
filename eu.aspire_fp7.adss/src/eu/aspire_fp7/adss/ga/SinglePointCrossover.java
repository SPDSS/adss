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

import java.util.ArrayList;
import java.util.List;

/**
 * Single-point crossover function.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class SinglePointCrossover<T> extends CrossoverFunction<T>
{
	/** The probability to have a crossover. **/
	private double probability;

	/**
	 * Creates the crossover function.
	 * @param probability
	 *            The probability to have a crossover.
	 **/
	public SinglePointCrossover(double probability)
	{
		this.probability = probability;
	}

	/**
	 * Generates a child chromosome.
	 * @param chromosome1
	 *            The first parent chromosome.
	 * @param chromosome2
	 *            The second parent chromosome.
	 * @return The child chromosome.
	 **/
	public List<List<T>> crossover(List<List<T>> chromosome1, List<List<T>> chromosome2)
	{
		if (geneticAlgorithm.random.nextDouble() < probability)
		{
			List<List<T>> children = new ArrayList<>();

			for (int i = 0; i < chromosome1.size(); ++i)
			{
				List<T> list = new ArrayList<>();
				children.add(list);

				List<T> list1 = chromosome1.get(i);
				List<T> list2 = chromosome2.get(i);
				
				if (list1.isEmpty() || list2.isEmpty())
					continue;

				int p1 = geneticAlgorithm.random.nextInt(list1.size());
				int p2 = geneticAlgorithm.random.nextInt(list2.size());

				for (int j = 0; j < p1; ++j)
					list.add(list1.get(j));

				for (int j = p2; j < list2.size(); ++j)
					list.add(list2.get(j));
			}

			return children;
		}
		else
			return chromosome1;
	}
}
