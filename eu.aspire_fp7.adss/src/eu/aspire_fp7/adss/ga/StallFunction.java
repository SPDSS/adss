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
 * A termination criteria based on the stall of the fitness values.<br/>
 * This function terminates the evolution when the delta of the last best
 * fitness values has not increased enough.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class StallFunction<T> extends TerminationFunction<T>
{
	/** The delta value. **/
	private double delta;
	/** The number of generations. **/
	private int generations;
	/** The last best fitness values. **/
	private List<Double> bests;

	/**
	 * Creates the termination function.
	 * @param generations
	 *            The number of generations to check.
	 * @param delta
	 *            The maximum difference value allowed.
	 **/
	public StallFunction(int generations, double delta)
	{
		this.generations = generations;
		this.delta = delta;
		bests = new ArrayList<>();
	}

	/**
	 * Checks if the evolution should stop or not.
	 * @return <code>true</code> if the genetic algorithm should stop,
	 *         <code>false</code> otherwise.
	 **/
	public boolean check()
	{
		double best = Double.NEGATIVE_INFINITY;

		for (double i : geneticAlgorithm.fitnessValues.values())
			if (i > best)
				best = i;

		bests.add(0, best);
		if (bests.size() > generations)
			bests.remove(bests.size() - 1);

		if (bests.size() < generations)
			return false;
		else
		{
			double d = 0;
			for (int i = 0; i < bests.size() - 1; ++i)
				d += Math.abs(bests.get(i) - bests.get(i + 1));

			return d <= delta;
		}
	}
}
