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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionObjective;

/**
 * The state evaluator.
 * @author Daniele Canavese
 **/
public class StateEvaluator
{
	/** The state solutions map. **/
	private double solutionScore;
	/** The state attacks map. **/
	private Map<AttackPath, Double> attacksMap;
	/** The solutions map. **/
	private Map<Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>>, Double> solutionsMap;
	/** The protection map. **/
	private Map<Protection, Double> protectionMap;
	/** The ADSS. **/
	private ADSS adss;

	/**
	 * Creates the evaluator.
	 * @param adss
	 *            The ADSS.
	 **/
	public StateEvaluator(ADSS adss)
	{
		this.adss = adss;
		Random random = new Random(1);
		attacksMap = new HashMap<>();
		solutionsMap = new HashMap<>();
		for (AttackPath i : adss.getModel().getAttackPaths())
			attacksMap.put(i, random.nextDouble());
		protectionMap = new HashMap<>();
		for (Protection i : adss.getModel().getAvailableProtections())
			if (i.getId().equals("softVM"))
				protectionMap.put(i, 0.45);
			else if (i.getId().equals("staticRemoteAttestation"))
				protectionMap.put(i, 0.6);
			else if (i.getId().equals("codeMobility"))
				protectionMap.put(i, 0.5);
			else
				protectionMap.put(i, random.nextDouble());
	}

	/**
	 * Evaluates a state's solution.
	 * @param state
	 *            The state to analyze.
	 **/
	public void evaluateSolution(State state)
	{
		if (solutionsMap.containsKey(state.getSolutionMap()))
			solutionScore = solutionsMap.get(state.getSolutionMap());
		else
		{
			double max = 0.0;
			solutionScore = 0.0;
			for (Entry<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> i : state.getSolutionMap().entrySet())
				for (AppliedProtectionInstantiation j : i.getValue())
				{
					double v = 0.0;
					for (AttackMitigation k : j.getAttackMitigations())
						if (k.getLevel() == Level.HIGH)
							v += 1.0;
						else if (k.getLevel() == Level.MEDIUM)
							v += 0.5;
						else
							v += 0.1;
					double protectionWeight = protectionMap.get(j.getProtectionInstantiation().getProtection());

					if (j.getProtectionInstantiation().getProtection().getId().equals("antiDebugging")
							&& containsOnly(j.getProtectionObjectives(), Property.CONFIDENTIALITY))
						protectionWeight *= 0.5;

					solutionScore += j.getApplicationPart().getWeight() * protectionWeight;
					max += j.getApplicationPart().getWeight();
				}
			solutionScore = solutionScore / max * 5.0;

			solutionsMap.put(state.getSolutionMap(), solutionScore);
		}
	}

	/**
	 * Checks if a set of protection objectives contains only a property.
	 * @param protectionObjectives
	 *            The protection objectives.
	 * @param property
	 *            The property.
	 * @return <code>true</code> if a pro
	 */
	private boolean containsOnly(EList<ProtectionObjective> protectionObjectives, Property property)
	{
		for (ProtectionObjective i : protectionObjectives)
			if (i.getProperty() != property)
				return false;

		return true;
	}

	/**
	 * Evaluates a state.
	 * @param state
	 *            The state to analyze.
	 * @return The state score.
	 **/
	public double evaluate(State state)
	{
		double score = solutionScore;

		for (AttackPath i : state.getAttackPaths())
			score -= attacksMap.get(i);

		return score;
	}
}
