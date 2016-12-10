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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.ProtectionObjective;

/**
 * A search state.
 * @author Daniele Canavese
 **/
public class State
{
	/**
	 * Creates an empty state.
	 **/
	public State()
	{
		solutionMap = new HashMap<>();
		attackPaths = new ArrayDeque<>();
		predictedAttackPaths = new ArrayList<>();
	}

	/** The solution. **/
	private Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> solutionMap;
	/** The attack paths. **/
	private Deque<AttackPath> attackPaths;
	/** The predicted attack paths. **/
	private List<AttackPath> predictedAttackPaths;

	/**
	 * Converts the object into a string.
	 * @return The string representation of the object.
	 **/
	@Override
	public String toString()
	{
		return solutionMap + " & " + attackPaths;
	}

	/**
	 * Retrieve the solution map.
	 * @return The solution map.
	 **/
	public Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> getSolutionMap()
	{
		return solutionMap;
	}

	/**
	 * Retrieve the attack paths.
	 * @return The attack paths.
	 **/
	public Deque<AttackPath> getAttackPaths()
	{
		return attackPaths;
	}

	/**
	 * Retrieve the predicted attack paths.
	 * @return The predicted attack paths.
	 **/
	public List<AttackPath> getPredictedAttackPaths()
	{
		return predictedAttackPaths;
	}
}
