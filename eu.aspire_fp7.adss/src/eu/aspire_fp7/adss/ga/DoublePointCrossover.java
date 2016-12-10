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
 * Double-point crossover function.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class DoublePointCrossover<T> extends CrossoverFunction<T>
{
	/** The probability to have a crossover. **/
	private double probability;

	/**
	 * Creates the crossover function.
	 * @param probability
	 *            The probability to have a crossover.
	 **/
	public DoublePointCrossover(double probability)
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

				int p1a = geneticAlgorithm.random.nextInt(list1.size());
				int p1b = geneticAlgorithm.random.nextInt(list1.size());
				if (p1b < p1a)
				{
					int t = p1a;
					p1a = p1b;
					p1b = t;
				}
				int p2a = geneticAlgorithm.random.nextInt(list2.size());
				int p2b = geneticAlgorithm.random.nextInt(list2.size());
				if (p2b < p2a)
				{
					int t = p2a;
					p2a = p2b;
					p2b = t;
				}

				for (int j = 0; j < p1a; ++j)
					list.add(list1.get(j));

				for (int j = p2a; j < p2b; ++j)
					list.add(list2.get(j));

				for (int j = p1b; j < list1.size(); ++j)
					list.add(list1.get(j));
			}

			return children;
		}
		else
			return chromosome1;
	}
}
