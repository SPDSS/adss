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
package eu.aspire_fp7.adss.connectors;

//import org.uel.aspire.wp4.assessment.APIs.AssessmentProcessBoth;
//import org.uel.aspire.wp4.assessment.APIs.AttackModel;
//import org.uel.aspire.wp4.assessment.APIs.Formula;
//import org.uel.aspire.wp4.assessment.APIs.SPA;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.l1p.AttackEvaluator;
import eu.aspire_fp7.adss.l1p.State;

/**
 * Manages the communications between the metrics framework and the Petri Nets
 * framework.
 * 
 * @author Daniele Canavese
 **/
public class PetriNetsConnector extends AttackEvaluator
{
	/** The true Petri nets framework. **/
//	private SPA spa;

	/**
	 * Creates the connector.
	 * @param adss
	 *            The ADSS.
	 **/
	public PetriNetsConnector(ADSS adss)
	{
		super(adss);
//		spa = new AssessmentProcessBoth();
//		attackPathsMap = new HashMap<>();
	}

	/**
	 * Initializes the connector.
	 **/
	public void initialize()
	{
//		Map<eu.aspire_fp7.adss.akb.AttackStep, org.uel.aspire.wp4.assessment.APIs.AttackStep> map = new HashMap<>();
//		ArrayList<org.uel.aspire.wp4.assessment.APIs.AttackStep> attackSteps = new ArrayList<>();
//		for (eu.aspire_fp7.adss.akb.AttackStep i : adss.getModel().getAttackSteps())
//		{
//			org.uel.aspire.wp4.assessment.APIs.AttackStep step = new org.uel.aspire.wp4.assessment.APIs.AttackStep();
//			step.setID(i.getName());
//			ArrayList<Formula> formulas = new ArrayList<Formula>();
//			Formula formula = new Formula();
//			formula.setFormula("9:0.2*SDFC+0.1*DDFC");
//			formulas.add(formula);
//			step.setFormulas(formulas);
//
//			attackSteps.add(step);
//			map.put(i, step);
//		}
//
//		ArrayList<org.uel.aspire.wp4.assessment.APIs.AttackPath> attackPaths = new ArrayList<>();
//		for (eu.aspire_fp7.adss.akb.AttackPath i : adss.getModel().getAttackPaths())
//		{
//			org.uel.aspire.wp4.assessment.APIs.AttackPath path = new org.uel.aspire.wp4.assessment.APIs.AttackPath();
//			path.setID(i.toString());
//			ArrayList<org.uel.aspire.wp4.assessment.APIs.AttackStep> steps = new ArrayList<>();
//			for (eu.aspire_fp7.adss.akb.AttackStep j : i.getAttackSteps())
//				steps.add(map.get(j));
//			path.setAttackSteps(steps);
//			attackPaths.add(path);
//			attackPathsMap.put(i, path);
//		}
//
//		AttackModel am = new AttackModel();
//		am.setID("attackModel");
//		am.setAttackSteps(attackSteps);
//		am.setAttackPaths(attackPaths);
//
//		spa.initModel(am, false);
//		spa.initCodeBase(adss.getModel().getPreferences().get, timestamp)
	}

	/**
	 * Retrieves the effort for an attack path.
	 * @param state
	 *            The state.
	 * @param attackPath
	 *            The attack path.
	 * @return The attack path effort.
	 **/
	public double getEffort(State state, AttackPath attackPath)
	{
		return 0.0;
	}

	/**
	 * Retrieves the effort for an entire state.
	 * @param state
	 *            The state.
	 * @param attackPath
	 *            The attack path.
	 * @return The attack path effort.
	 **/
	public double getEffort(State state)
	{
		return 0.0;
	}

	/** The attack path map. **/
//	private Map<AttackPath, org.uel.aspire.wp4.assessment.APIs.AttackPath> attackPathsMap;
}
