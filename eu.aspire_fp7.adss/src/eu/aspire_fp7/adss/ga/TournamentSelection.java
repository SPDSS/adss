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
 * The tournament selection method with replacement.<br/>
 * We pick a sub-set of the population and the chromosome in here are selected
 * according to their fitness.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class TournamentSelection<T> extends SelectionFunction<T>
{
	/** The comparator. **/
	private Comparator<List<List<T>>> comparator;
	/** The tournament size. **/
	private int tournamentSize;

	/**
	 * Create the selection function.
	 * @param tournamentSize
	 *            The tournament size.
	 **/
	public TournamentSelection(int tournamentSize)
	{
		this.tournamentSize = tournamentSize;
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

		for (int i = 0; i < quantity; ++i)
		{
			int index = geneticAlgorithm.random.nextInt(geneticAlgorithm.population.size());
			for (int j = 1; j < tournamentSize; ++j)
				index = Math.min(index, geneticAlgorithm.random.nextInt(geneticAlgorithm.population.size()));
			selection.add(geneticAlgorithm.population.get(index));
		}
	}
}
