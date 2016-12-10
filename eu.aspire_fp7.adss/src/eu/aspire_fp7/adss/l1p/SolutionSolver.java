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
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;

/**
 * Finds the golden solution.
 * @author Daniele Canavese
 **/
public abstract class SolutionSolver
{
	/** The solution walker. **/
	protected SolutionWalker solutionWalker;
	/** The ADSS. **/
	protected final ADSS adss;
	/** The current state. **/
	protected State state;
	/** The attack evaluator. **/
	protected AttackEvaluator attackEvaluator;
	/** The protection evaluator. **/
	protected ProtectionEvaluator protectionEvaluator;
	/** The solutions. **/
	private List<Solution> solutions;

	/**
	 * Creates the solver.
	 * @param adss
	 *            The ADSS.
	 * @param attackEvaluator
	 *            The attack evaluator.
	 * @param protectionEvaluator
	 *            The protection evaluator.
	 **/
	public SolutionSolver(ADSS adss, AttackEvaluator attackEvaluator, ProtectionEvaluator protectionEvaluator)
	{
		this.adss = adss;
		this.attackEvaluator = attackEvaluator;
		this.protectionEvaluator = protectionEvaluator;
		state = new State();
		solutionWalker = new SolutionWalker(adss, state.getSolutionMap());
		solutions = new ArrayList<>();
	}

	/**
	 * Finds the golden solution.
	 **/
	public abstract void run();

	/**
	 * Adds a new solution to the best ones.
	 * @param state
	 *            The state to add.
	 * @param score
	 *            The score of the actual solution.
	 **/
	protected void addSolution(State state, double score)
	{
		Solution solution = AkbFactory.eINSTANCE.createSolution();
		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
		{
			SolutionSequence solutionSequence = AkbFactory.eINSTANCE.createSolutionSequence();
			for (AppliedProtectionInstantiation j : i)
				solutionSequence.getAppliedProtectionInstantiations().add(EcoreUtil.copy(j));
			solution.getSolutionSequences().add(solutionSequence);
		}
		solution.setScore(score);
		solutions.add(0, solution);

		if (solutions.size() > adss.getModel().getPreferences().getL1pSolutionsCount())
			solutions.remove(solutions.size() - 1);
	}

	/**
	 * Retrieves the solutions.
	 * @return The solutions.
	 **/
	public List<Solution> getSolutions()
	{
		return solutions;
	}
}
