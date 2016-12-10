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
 * The truncation selection method with replacement.<br/>
 * The highest fitness chromosomes are selected and copied several times until
 * the mating pool is full.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class TruncationSelection<T> extends SelectionFunction<T>
{
	/** The cut-off value. **/
	private int cutoff;
	/** The comparator. **/
	private Comparator<List<List<T>>> comparator;

	/**
	 * Create the selection function.
	 * @param cutoff
	 *            The cut-off value.
	 **/
	public TruncationSelection(int cutoff)
	{
		this.cutoff = cutoff;
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

		int k = Math.min(cutoff, geneticAlgorithm.population.size());
		geneticAlgorithm.population.sort(comparator);
		for (int i = 0; i < quantity; ++i)
			selection.add(geneticAlgorithm.population.get(i % k));
	}
}
