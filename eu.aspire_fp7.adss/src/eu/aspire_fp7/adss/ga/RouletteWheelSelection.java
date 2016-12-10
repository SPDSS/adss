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
import java.util.List;

/**
 * The roulette wheel selection method with replacement.<br/>
 * The probability of a chromosome to be selected is proportional to its fitness.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class RouletteWheelSelection<T> extends SelectionFunction<T>
{
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

		double[] c = new double[geneticAlgorithm.population.size()];
		c[0] = geneticAlgorithm.fitnessValues.get(geneticAlgorithm.population.get(0));
		for (int i = 1; i < geneticAlgorithm.population.size(); i++)
		{
			double fitness = geneticAlgorithm.fitnessValues.get(geneticAlgorithm.population.get(i));
			c[i] = c[i - 1] + fitness;
		}

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
