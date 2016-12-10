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
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.ADSS;

/**
 * A transposition table with a LRU replacement politic.
 * @author Daniele Canavese
 **/
public class TranspositionTable
{
	/** The map. **/
	private Map<Long, StateData> map;
	/** The deque of the hashes. **/
	private Deque<Long> deque;
	/** The hit count. **/
	private long hitCount;
	/** The miss count. **/
	private long missCount;
	/** The ADSS. **/
	private final ADSS adss;
	/** The attack path hash codes. **/
	private Map<AttackPath, Long> attackPathHashCodes;
	/** The asset hash codes. **/
	private Map<ApplicationPart, Long> assetHashCodes;
	/** The protection instantiation hash codes. **/
	private Map<ProtectionInstantiation, Long> protectionInstantiationHashCodes;
	/** The random number generator. **/
	private Random random;

	/**
	 * Creates an empty transposition table.
	 * @param adss
	 *            The ADSS.
	 **/
	public TranspositionTable(ADSS adss)
	{
		this.adss = adss;
		map = new HashMap<>();
		deque = new ArrayDeque<>();
		attackPathHashCodes = new HashMap<>();
		assetHashCodes = new HashMap<>();
		protectionInstantiationHashCodes = new HashMap<>();
	}

	/**
	 * Clears the table.
	 **/
	public void clear()
	{
		map.clear();
	}

	/**
	 * Puts a state into the table.
	 * @param state
	 *            The state.
	 * @param value
	 *            The state value.
	 * @param ply
	 *            The state ply.
	 * @param type
	 *            The state type.
	 * @return The state data or <code>null</code> if the insertion cannot be performed.
	 **/
	public StateData put(State state, double value, int ply, StateType type)
	{
		StateData stateData = null;
		if (adss.getModel().getPreferences().getL1pTranspositionTableMaximumSize() > 0)
		{
			// Updates the table only if this data has a bigger ply then the stored one.
			boolean insert = false;
			long hashCode = getHashCode(state);
			if (map.containsKey(hashCode))
			{
				stateData = map.get(hashCode);
				insert = ply >= stateData.getPly();
			}
			else
				insert = true;
			if (insert)
			{
				if (map.size() > adss.getModel().getPreferences().getL1pTranspositionTableMaximumSize())
					map.remove(deque.poll());
				stateData = new StateData(value, ply, type);
				map.put(hashCode, stateData);
				deque.add(hashCode);
			}
		}

		return stateData;
	}

	/**
	 * Retrieves a state data.
	 * @param state
	 *            The state.
	 * @param ply
	 *            The state ply.
	 * @return The state data or null if no such state exists in the table.
	 **/
	public StateData getData(State state, int ply)
	{
		if (adss.getModel().getPreferences().getL1pTranspositionTableMaximumSize() > 0)
		{
			Long hashCode = getHashCode(state);
			if (map.containsKey(hashCode))
			{
				// Retrieves the data only if the store state ply is equal to or less than the current one.
				StateData stateData = map.get(hashCode);
				if (stateData.getPly() <= ply)
				{
					hitCount++;
					return stateData;
				}
				else
				{
					missCount++;
					return null;
				}
			}
			else
			{
				missCount++;
				return null;
			}
		}
		else
			return null;
	}

	/**
	 * Computes the hashcode of a state
	 * @param state
	 *            The state.
	 * @return The state hashcode.
	 **/
	private Long getHashCode(State state)
	{
		long hashCode = 0;

		int count = 1;
		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
			for (AppliedProtectionInstantiation j : i)
				hashCode ^= (assetHashCodes.get(j.getApplicationPart())
						^ protectionInstantiationHashCodes.get(j.getProtectionInstantiation())) * ++count;

		for (AttackPath i : state.getAttackPaths())
			hashCode ^= attackPathHashCodes.get(i);

		return hashCode;
	}

	/**
	 * Retrieve the hit count.
	 * @return The hit count.
	 **/
	public long getHitCount()
	{
		return hitCount;
	}

	/**
	 * Retrieve the miss count.
	 * @return The miss count.
	 **/
	public long getMissCount()
	{
		return missCount;
	}

	/**
	 * Initializes the transposition table.
	 **/
	public void initialize()
	{
		random = new Random(0);

		for (ApplicationPart j : adss.getModel().getAssets())
			assetHashCodes.put(j, random.nextLong());
		for (Protection j : adss.getModel().getProtections())
			for (ProtectionInstantiation k : j.getInstantiations())
				protectionInstantiationHashCodes.put(k, random.nextLong());
		for (AttackPath j : adss.getModel().getAttackPaths())
			attackPathHashCodes.put(j, random.nextLong());

		hitCount = 0;
		missCount = 0;
	}
}
