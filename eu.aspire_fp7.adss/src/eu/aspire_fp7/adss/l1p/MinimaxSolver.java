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
package eu.aspire_fp7.adss.l1p;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;

/**
 * Finds the golden solution using a mini-max algorithm.
 * @author Daniele Canavese
 **/
public class MinimaxSolver extends SolutionSolver
{
	/** The number of millisecond that will trigger a log. **/
	private static final int LOG_TRIGGER = 5000;
	/** The number of solutions. **/
	private long solutionsCount;
	/** The number of states. **/
	private long statesCount;
	/** The transposition table. **/
	private TranspositionTable transpositionTable;
	/** The state evaluator. **/
	private StateEvaluator stateEvaluator;
	/** The GA framework. **/
	// private GeneticAlgorithm<AppliedProtectionInstantiation> ga;

	/**
	 * Creates the solver.
	 * 
	 * @param adss
	 *            The ADSS.
	 * @param attackEvaluator
	 *            The attack evaluator.
	 * @param protectionEvaluator
	 *            The protection evaluator.
	 **/
	public MinimaxSolver(ADSS adss, AttackEvaluator attackEvaluator, ProtectionEvaluator protectionEvaluator)
	{
		super(adss, attackEvaluator, protectionEvaluator);
		transpositionTable = new TranspositionTable(adss);
		stateEvaluator = new StateEvaluator(adss);
		// ga = new GeneticAlgorithm<>();
	}

	/**
	 * Finds the golden solution.
	 **/
	public void run()
	{
		int timeout = adss.getModel().getPreferences().getL1pTimeLimit() * 1000;
		transpositionTable.initialize();
		solutionWalker.initialize1();

		int trees;
		if (adss.getModel().getPreferences().isL1pMultiTree())
			trees = solutionWalker.getCodeCorrelationSets().size();
		else
			trees = 1;

		// Creates the trees.
		List<List<Solution>> partials = new ArrayList<>();
		long trueStart = System.currentTimeMillis();
		statesCount = 0;
		for (int i = 0; i < trees; ++i)
		{
			long start = System.currentTimeMillis();
			double score = Double.NEGATIVE_INFINITY;
			List<Solution> s = new ArrayList<>();
			double alpha = Double.NEGATIVE_INFINITY;
			double beta = Double.POSITIVE_INFINITY;

			if (adss.getModel().getPreferences().getL1pInitialAlpha() != Double.NaN)
				alpha = adss.getModel().getPreferences().getL1pInitialAlpha();
			if (adss.getModel().getPreferences().getL1pInitialBeta() != Double.NaN)
				beta = adss.getModel().getPreferences().getL1pInitialBeta();

			// boolean notFirst = false;
			for (int j = 1; j <= adss.getModel().getPreferences().getL1pMainSearchMaximumDepth(); ++j)
			{
				solutionsCount = 0;
				int size;
				if (adss.getModel().getPreferences().isL1pMultiTree())
					size = solutionWalker.initialize2(i);
				else
					size = solutionWalker.initialize2(-1);

				if (j == 1)
				{
					if (adss.getModel().getPreferences().isL1pMultiTree())
						log.fine("Searching for partial solution with order " + size + " = "
								+ solutionWalker.getCodeCorrelationSets().get(i));
					else
						log.fine("Searching for global solution with order " + size + " = " + solutionWalker.getCodeCorrelationSets());
					log.fine(String.format("%1s  %9s  %9s  %9s  %9s  %9s  %9s", "", "Depth", "BestScore", "Alpha", "Beta", "Solutions",
							"Time"));
				}

				if (size == 0)
					continue;

				long delta = System.currentTimeMillis() - start;
				log.fine(String.format("%1s  %9d  % 9.3f  % 9.3f  % 9.3f  % 9d  % 9.3f", "", j, score, alpha, beta, solutionsCount,
						delta / 1000.0f));
				getSolutions().clear();
				// notFirst = true;

				double currentScore;
				// int threshold = adss.getModel().getPreferences().getGaThreshold();
				// if (threshold >= 0 && size >= threshold)
				// currentScore = evolve(alpha, beta, start);
				// else
				currentScore = findMax(alpha, beta, j, start);

				if (currentScore == Double.NEGATIVE_INFINITY)
				{
					log.severe("No suitable solutions found");
					break;
				}

				if (currentScore <= alpha)
				{
					log.fine(String.format("%1s  %9d  % 9.3f  %9.3f  %9.3f  % 9d  % 9.3f", "<", j, currentScore, alpha, beta,
							solutionsCount, delta / 1000.0f));
					alpha -= adss.getModel().getPreferences().getL1pResearchDelta();
					--j;
				}
				else if (currentScore >= beta)
				{
					log.fine(String.format("%1s  %9d  % 9.3f  %9.3f  %9.3f  % 9d  % 9.3f", ">", j, currentScore, alpha, beta,
							solutionsCount, delta / 1000.0f));
					beta += adss.getModel().getPreferences().getL1pResearchDelta();
					--j;
				}
				else
				{
					log.fine(String.format("%1s  %9d  % 9.3f  %9.3f  %9.3f  % 9d  % 9.3f", "*", j, currentScore, alpha, beta,
							solutionsCount, delta / 1000.0f));

					score = currentScore;
					alpha = score - adss.getModel().getPreferences().getL1pResearchDelta();
					beta = score + adss.getModel().getPreferences().getL1pResearchDelta();
				}

				if (timeout > 0 && System.currentTimeMillis() - start > timeout)
				{
					log.info("Timeout reached");
					if (j == 1)
					{
						s.clear();
						s.addAll(getSolutions());
						log.warning("Iteration 1 result");
					}
					break;
				}
				s.clear();
				s.addAll(getSolutions());
			}

			getSolutions().clear();
			getSolutions().addAll(s);
			if (getSolutions().isEmpty())
			{
				if (adss.getModel().getPreferences().isL1pMultiTree())
					log.severe("Unable to find the partial golden solution");
				else
					log.severe("Unable to find the golden solution");
			}
			else
			{
				if (trees == 1)
					log.fine("Golden solution = " + score + " for " + getSolutions().get(0));
				else
					log.fine("Partial golden solution = " + score + " for " + getSolutions().get(0));
			}
			partials.add(s);
		}
		long stop = System.currentTimeMillis();

		// Merges the partial solutions together, if needed.
		if (adss.getModel().getPreferences().isL1pMultiTree() && trees > 1)
			mergeSolutions(partials);
		if (trees > 1)
		{
			log.fine("Golden solution = " + getSolutions().get(0));
			log.fine("Golden solution score = " + getSolutions().get(0).getScore());
		}
		// Adjusts the applied PIs.
		adjustSolutions();
		log.info(String.format("L1P inferred = %d states, %d/%d table hit/miss, %.3f s", statesCount, transpositionTable.getHitCount(),
				transpositionTable.getMissCount(), (stop - trueStart) / 1000.0f));
	}

	/**
	 * Adjusts the solutions.
	 **/
	private void adjustSolutions()
	{
		for (Solution i : getSolutions())
			for (SolutionSequence j : i.getSolutionSequences())
				for (int k = 0; k < j.getAppliedProtectionInstantiations().size(); ++k)
				{
					// We replace the applied PIs in the sequence with the applied PIs in the model, just for coherence.
					AppliedProtectionInstantiation pi = j.getAppliedProtectionInstantiations().get(k);
					for (AppliedProtectionInstantiation l : adss.getModel().getAppliedProtectionInstantiations())
						if (pi.equals(l))
						{
							j.getAppliedProtectionInstantiations().set(k, l);
							break;
						}
				}
	}

	/**
	 * Merges the partial solutions into the final ones.
	 * @param partials
	 *            The partial solutions.
	 **/
	private void mergeSolutions(List<List<Solution>> partials)
	{
		getSolutions().clear();
		List<Integer> values = new ArrayList<>();
		for (List<Solution> i : partials)
			values.add(i.size());
		List<Integer> vector = new ArrayList<>();
		IntegerTupleWalker w = new IntegerTupleWalker(values, vector);

		int count = 0;
		while (w.computeNext())
		{
			Solution s = AkbFactory.eINSTANCE.createSolution();
			s.setScore(0);
			for (int i = 0; i < partials.size(); ++i)
			{
				List<Solution> partial = partials.get(i);
				if (!partial.isEmpty())
				{
					Solution local = partial.get(vector.get(i) - 1);
					s.getSolutionSequences().add(local.getSolutionSequences().get(0));
					s.setScore(s.getScore() + local.getScore());
				}
			}
			getSolutions().add(s);
			if (++count >= adss.getModel().getPreferences().getL1pSolutionsCount())
				break;
		}
	}

	/**
	 * Retrieves the score of a max node (a protection solution node) using a genetic algorithm.
	 * @param size
	 *            The number of applied PIs.
	 * @param alpha
	 *            The alpha bound.
	 * @param beta
	 *            The beta bound.
	 * @param searchStart
	 *            The search start time.
	 * @return The score of a max node.
	 **/
	// private double evolve(double alpha, double beta, long searchStart)
	// {
	// List<List<List<AppliedProtectionInstantiation>>> population = smartInitialize();
	// ClearingFunction<AppliedProtectionInstantiation> clearingFunction = null;
	// SelectionFunction<AppliedProtectionInstantiation> selectionFunction = null;
	// CrossoverFunction<AppliedProtectionInstantiation> crossoverFunction = null;
	// MutationFunction<AppliedProtectionInstantiation> mutationFunction = null;
	// FitnessFunction<AppliedProtectionInstantiation> fitnessFunction = null;
	// int matingPoolSize = 1;
	// int elitismSize = 1;
	// long seed = 1;
	// ga.initialize(population, clearingFunction, selectionFunction, crossoverFunction, mutationFunction, fitnessFunction,
	// matingPoolSize,
	// elitismSize, seed);
	//
	// Integer timeout=null;
	// Integer generationLimit=null;
	// TerminationFunction<AppliedProtectionInstantiation> terminationFunction=null;
	// ga.evolve(timeout, generationLimit, terminationFunction);

	// return 0;
	// }

	/**
	 * Creates the initial population for the GA. This method <b>must</b> be deterministic.
	 * @return The initial GA population.
	 **/
	// private List<List<List<AppliedProtectionInstantiation>>> smartInitialize()
	// {
	// List<List<List<AppliedProtectionInstantiation>>> population = new ArrayList<>();
	//
	// // First, we select the best solution (or a very good one, hopefully).
	// population.add(getBestChromosome());
	// // Then, we generate all the other chromosomes with a very strong mutation.
	//
	// return population;
	// }

	/**
	 * Retrieves a possible best chromosome.
	 * @return A candidate best chromosome.
	 **/
	// private List<List<AppliedProtectionInstantiation>> getBestChromosome()
	// {
	// List<List<AppliedProtectionInstantiation>> best = new ArrayList<>();
	//
	// return best;
	// }

	/**
	 * Retrieves the score of a max node (a protection solution node) using the alpha-beta search.
	 * @param alpha
	 *            The alpha bound.
	 * @param beta
	 *            The beta bound.
	 * @param ply
	 *            The current search ply.
	 * @param searchStart
	 *            The search start time.
	 * @return The score of a max node.
	 **/
	private double findMax(double alpha, double beta, int ply, long searchStart)
	{
		int timeLimit = adss.getModel().getPreferences().getL1pTimeLimit() * 1000 / solutionWalker.getCodeCorrelationSets().size();
		int solutionsLimit = adss.getModel().getPreferences().getL1pSolutionsLimit();
		long start = System.currentTimeMillis();
		++statesCount;

		double a = alpha;

		log.finest("Searching the max for " + state);

		Double g = Double.NEGATIVE_INFINITY;
		long lastLogTime = start;
		while (g < beta && solutionWalker.computeNext())
		{
			long now = System.currentTimeMillis();
			long delta = now - start;
			++solutionsCount;

			stateEvaluator.evaluateSolution(state);
			double c = findMin(a, beta, ply - 1);
			if (c > g)
			{
				addSolution(state, c);
				g = c;
			}
			a = Math.max(a, g);

			if (now - lastLogTime >= LOG_TRIGGER)
			{
				log.fine(String.format("%1s  %9d  % 9.3f  % 9.3f  % 9.3f  % 9d  % 9.3f", "", ply, g, alpha, beta, solutionsCount,
						delta / 1000.0f));
				lastLogTime = now;
			}
			if (timeLimit > 0 && delta > timeLimit)
				break;
			if (solutionsLimit > 0 && solutionsCount > solutionsLimit)
				break;
		}

		return g;
	}

	/**
	 * Retrieves the score of a min node (an attacker node) using the alpha-beta search.
	 * @param alpha
	 *            The alpha bound.
	 * @param beta
	 *            The beta bound.
	 * @param ply
	 *            The current search ply.
	 * @return The score of a min node.
	 **/
	private double findMin(double alpha, double beta, int ply)
	{
		++statesCount;

		StateData data = transpositionTable.getData(state, ply);
		if (data != null)
		{
			if (data.getType() == StateType.EXACT_NODE)
				return data.getValue();
			else if (data.getType() == StateType.LOWER_NODE)
			{
				if (data.getValue() >= beta)
					return data.getValue();
				else
					beta = Math.min(beta, data.getValue());
			}
			else if (data.getType() == StateType.UPPER_NODE)
			{
				if (data.getValue() >= alpha)
					return data.getValue();
				else
					alpha = Math.max(alpha, data.getValue());
			}
		}
		else
			data = transpositionTable.put(state, 0, ply, StateType.INVALID_NODE);
		double b = beta;

		if (ply == 0)
			return evaluate();

		log.finest("Searching the min for " + state);

		Double g = Double.POSITIVE_INFINITY;
		Iterator<AttackPath> iterator = adss.getModel().getAttackPaths().iterator();
		while (g > alpha && iterator.hasNext())
		{
			AttackPath i = iterator.next();
			state.getAttackPaths().push(i);
			Double oldg = g;
			g = Math.min(g, findMin(alpha, b, ply - 1));
			b = Math.min(b, g);
			state.getAttackPaths().pop();
			if (g != oldg)
			{
				int index = state.getAttackPaths().size();
				if (state.getPredictedAttackPaths().size() > index)
					state.getPredictedAttackPaths().set(index, i);
				else
					state.getPredictedAttackPaths().add(i);
			}
		}

		if (data != null)
		{
			if (g <= alpha)
			{
				data.setValue(g);
				data.setType(StateType.UPPER_NODE);
			}
			else if (g > alpha && g < beta)
			{
				data.setValue(g);
				data.setType(StateType.EXACT_NODE);
			}
			else if (g >= beta)
			{
				data.setValue(g);
				data.setType(StateType.LOWER_NODE);
			}
		}

		return g;
	}

	/**
	 * Retrieves the score of a leaf.
	 * @return The leaf score.
	 **/
	private double evaluate()
	{
		double score = stateEvaluator.evaluate(state);

		log.finest("Score for " + state + " = " + score);

		return score;
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(MinimaxSolver.class.getName());
}
