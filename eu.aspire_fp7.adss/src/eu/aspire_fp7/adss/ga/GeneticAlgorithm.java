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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A genetic algorithm implementation.<br/>
 * In a nutshell:
 * <ul>
 * <li><code>T</code> is a gene;</li>
 * <li><code>List&lt;T&gt;</code> is a gene list;</li>
 * <li><code>List&lt;List&lt;T&gt;&gt;</code> is a chromosome.</li>
 * </ul>
 * In a chromosome the gene lists are separated from each other, so that a gene in a list cannot be placed in another list.
 * @see <a href="http://www.it-weise.de/projects/book.pdf">http://www.it-weise. de/projects/book.pdf</a>
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class GeneticAlgorithm<T>
{
	/** The random number generator. **/
	protected Random random;
	/** The population. **/
	protected List<List<List<T>>> population;
	/** The mating pool. **/
	protected List<List<List<T>>> matingPool;
	/** The fitness values. **/
	protected Map<List<List<T>>, Double> fitnessValues;
	/** The clearing function. **/
	private ClearingFunction<T> clearingFunction;
	/** The selection function. **/
	private SelectionFunction<T> selectionFunction;
	/** The crossover function. **/
	private CrossoverFunction<T> crossoverFunction;
	/** The mutation function. **/
	private MutationFunction<T> mutationFunction;
	/** The fitness function. **/
	private FitnessFunction<T> fitnessFunction;
	/** The mating pool size. **/
	private int matingPoolSize;
	/** The elitism size. **/
	private int elitismSize;

	/**
	 * Creates the genetic algorithm.
	 */
	public GeneticAlgorithm()
	{
		random = new Random();
		population = null;
		matingPool = new ArrayList<>();
		fitnessValues = new HashMap<>();
	}

	/**
	 * Initializes the genetic algorithm.
	 * @param population
	 *            The initial population.
	 * @param clearingFunction
	 *            The clearing function or<code>null</code> if not wanted.
	 * @param selectionFunction
	 *            The selection function.
	 * @param crossoverFunction
	 *            The crossover function.
	 * @param mutationFunction
	 *            The mutation function.
	 * @param fitnessFunction
	 *            The fitness function.
	 * @param matingPoolSize
	 *            The mating pool size.
	 * @param elitismSize
	 *            The size for the elitism technique.
	 * @param seed
	 *            The seed for the random number generator.
	 **/
	public void initialize(List<List<List<T>>> population, ClearingFunction<T> clearingFunction, SelectionFunction<T> selectionFunction,
			CrossoverFunction<T> crossoverFunction, MutationFunction<T> mutationFunction, FitnessFunction<T> fitnessFunction,
			int matingPoolSize, int elitismSize, long seed)
	{
		this.population = population;
		matingPool.clear();
		this.clearingFunction = clearingFunction;
		this.selectionFunction = selectionFunction;
		this.crossoverFunction = crossoverFunction;
		this.mutationFunction = mutationFunction;
		this.fitnessFunction = fitnessFunction;
		if (clearingFunction != null)
			clearingFunction.setGeneticAlgorithm(this);
		selectionFunction.setGeneticAlgorithm(this);
		crossoverFunction.setGeneticAlgorithm(this);
		mutationFunction.setGeneticAlgorithm(this);
		this.matingPoolSize = matingPoolSize;
		this.elitismSize = elitismSize;
		random.setSeed(seed);
	}

	/**
	 * Performs a single evolution step.
	 **/
	private void evolve()
	{
		List<List<List<T>>> newPopulation = new ArrayList<>();

		// 1. Finds the best chromosomes.
		List<List<List<T>>> bests = new ArrayList<>();
		double bestFitness = Double.NEGATIVE_INFINITY;
		for (List<List<T>> i : population)
		{
			double f = fitnessValues.get(i);
			if (f > bestFitness)
				bests.add(0, i);
			if (bests.size() > elitismSize)
				bests.remove(bests.size() - 1);
		}

		// 2. Elitism in action!
		newPopulation.addAll(bests);

		// 2. Clearing.
		if (clearingFunction != null)
			clearingFunction.clear();

		// 3. Populates the mating pool.
		matingPool.clear();
		selectionFunction.select(matingPoolSize, matingPool);

		// 4. Crossover and mutation.
		while (newPopulation.size() < population.size())
		{
			List<List<T>> parent1 = matingPool.get(random.nextInt(matingPoolSize));
			List<List<T>> parent2 = matingPool.get(random.nextInt(matingPoolSize));
			List<List<T>> children = crossoverFunction.crossover(parent1, parent2);
			mutationFunction.mutate(children);
			newPopulation.add(children);
		}

		// 5. Updates the population and the fitness values.
		population.clear();
		population.addAll(newPopulation);

		fitnessValues.clear();
		for (List<List<T>> i : population)
			fitnessValues.put(i, fitnessFunction.evaluate(i));
	}

	/**
	 * Evolves a population until a termination condition is met.
	 * @param timeout
	 *            The timeout in milliseconds or <code>null</code> if none.
	 * @param generationLimit
	 *            The generation limit or <code>null</code> if none.
	 * @param terminationFunction
	 *            A termination function or <code>null</code> if none.
	 * @return The number of generations evolved.
	 **/
	public int evolve(Integer timeout, Integer generationLimit, TerminationFunction<T> terminationFunction)
	{
		int generations = 0;
		if (terminationFunction != null)
			terminationFunction.setGeneticAlgorithm(this);
		long start = System.currentTimeMillis();

		fitnessValues.clear();
		for (List<List<T>> i : population)
			fitnessValues.put(i, fitnessFunction.evaluate(i));

		boolean exit = false;
		while (!exit)
		{
			if (generationLimit != null && generations > generationLimit)
				exit = true;
			else if (timeout != null && System.currentTimeMillis() - start > timeout)
				exit = true;
			else if (terminationFunction != null && terminationFunction.check())
				exit = true;
			evolve();
			++generations;
		}

		return generations;
	}
}
