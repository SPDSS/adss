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

import java.util.List;

/**
 * Standard mutation function. It can perform addition, deletion, permutation
 * and replacement.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class StandardMutation<T> extends MutationFunction<T>
{
	/** The genome map. **/
	private List<List<T>> genome;
	/** The probability to have a mutation. **/
	private double probability;

	/**
	 * Creates the mutation function.
	 * @param genome
	 *            The genome map.
	 * @param probability
	 *            The probability to have a mutation.
	 **/
	public StandardMutation(List<List<T>> genome, double probability)
	{
		this.genome = genome;
		this.probability = probability;
	}

	/**
	 * Mutate a chromosome.
	 * @param chromosome
	 *            The chromosome to mutate.
	 **/
	public void mutate(List<List<T>> chromosome)
	{
		int count = 0;
		for (List<T> i : chromosome)
		{
			int size = i.size();
			if (i.isEmpty())
			{
				if (geneticAlgorithm.random.nextDouble() < probability)
				{
					T gene = genome.get(count).get(geneticAlgorithm.random.nextInt(genome.get(count).size()));
					i.add(gene);
				}
			}
			else
				for (int j = 0; j < size; ++j)
					if (geneticAlgorithm.random.nextDouble() < probability)
					{
						int operation = geneticAlgorithm.random.nextInt(45);
						if (operation == 0)
						{
							// Alters the current gene.
							T replacement = genome.get(count)
									.get(geneticAlgorithm.random.nextInt(genome.get(count).size()));
							i.set(j, replacement);
						}
						else if (operation == 1)
						{
							// Swaps the current gene and another one.
							T current = i.get(j);
							int index = geneticAlgorithm.random.nextInt(i.size());
							i.set(j, i.get(index));
							i.set(index, current);
						}
						else if (operation == 2)
						{
							// Removes the current gene.
							i.remove(j);
							--size;
							--j;
						}
						else if (operation == 3)
						{
							// Adds a new gene before the current one.
							T gene = genome.get(count).get(geneticAlgorithm.random.nextInt(genome.get(count).size()));
							i.add(j, gene);
						}
						else if (operation == 4)
						{
							// Adds a new gene after the current one.
							T gene = genome.get(count).get(geneticAlgorithm.random.nextInt(genome.get(count).size()));
							i.add(j + 1, gene);
						}
					}
			++count;
		}
	}
}
