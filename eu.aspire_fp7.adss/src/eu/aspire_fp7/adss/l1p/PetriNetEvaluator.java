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

import org.uel.aspire.wp5.assessment.APIs.AssessmentFunction;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.Solution;

/**
 * Evaluates a set of protections using the Petri Nets.
 * 
 * @author Daniele Canavese
 **/
public class PetriNetEvaluator
{
	/** The ADSS. **/
	private ADSS adss;

	/**
	 * Creates the evaluator.
	 * @param adss
	 *            The ADSS.
	 **/
	public PetriNetEvaluator(ADSS adss)
	{
		this.adss = adss;
	}

	/**
	 * Evaluates the scores of the solutions.
	 **/
	public void evaluate()
	{
		ArrayList<AttackPath> attacks = new ArrayList<>(adss.getModel().getAttackPaths());
		ArrayList<Solution> solutions = new ArrayList<>(adss.getModel().getSolutions());

		AssessmentFunction assessmentFunction = new AssessmentFunction(adss.getModel(), attacks, solutions);

		ArrayList<Double> scores = assessmentFunction.runAssessment();

		for (int i = 0; i < scores.size(); ++i)
			solutions.get(i).setScore(scores.get(i));
	}
}
