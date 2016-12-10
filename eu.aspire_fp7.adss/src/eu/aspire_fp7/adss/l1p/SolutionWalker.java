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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.Preferences;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionFlag;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.util.Collections;

/**
 * Generates all the available solutions.
 * @author Daniele Canavese
 **/
public class SolutionWalker
{
	/** The ADSS. **/
	private final ADSS adss;
	/** The prefix tester. **/
	private PrefixTester<AppliedProtectionInstantiation> prefixTester;
	/** The enabled correlation set or a negative number if all are enabled. **/
	private int enabledCorrelationSet;

	/**
	 * Creates the walker.
	 * @param adss
	 *            The ADSS.
	 * @param solutionMap
	 *            The map where to write the next solution.
	 **/
	public SolutionWalker(ADSS adss, Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> solutionMap)
	{
		this.adss = adss;
		initialProtectionObjectives = new ArrayList<>();
		initialCodeCorrelationSets = new ArrayList<>();
		currentProtectionObjectives = new ArrayList<>();
		currentCodeCorrelationSets = new ArrayList<>();
		protectionObjectivesMap = new HashMap<>();
		initialAppliedProtectionInstantiations = new HashMap<>();
		currentAppliedProtectionInstantiations = new HashMap<>();
		functionMap = new HashMap<>();
		this.solutionMap = solutionMap;
		tupleWalker = null;
		tupleWalkers = null;
		combinationWalkers = null;
		permutationWalkers = null;
		cardinalities = null;
		singletonSelectors1 = null;
		singletonSelectors2 = null;
		instantiations = null;
		enabledCorrelationSet = -1;
		prefixTester = new PrefixTester<AppliedProtectionInstantiation>()
		{
			@Override
			public boolean isValid(List<AppliedProtectionInstantiation> vector, int size)
			{
				if (size > 1)
				{
					Preferences preferences = SolutionWalker.this.adss.getModel().getPreferences();

					// We only need to check the last one since the vector is built incrementally.
					AppliedProtectionInstantiation last = vector.get(size - 1);
					Protection lastProtection = last.getProtectionInstantiation().getProtection();
					ApplicationPart lastPart = last.getApplicationPart();

					for (int i = size - 2; i >= 0; --i)
					{
						AppliedProtectionInstantiation before = vector.get(i);
						Protection beforeProtection = before.getProtectionInstantiation().getProtection();
						ApplicationPart beforePart = before.getApplicationPart();

						if (preferences.isL1pUseACTCPrecedences() && !lastProtection.equals(beforeProtection)
								&& !lastProtection.getActcPrecedences().contains(beforeProtection))
							return false;
						if (preferences.isL1pIgnoreApplicationPartOrder() && lastProtection.equals(beforeProtection)
								&& lastPart.getId() < beforePart.getId())
							return false;
						if (lastPart.contains(beforePart))
						{
							// Order checks.
							if (lastProtection.getForbiddenPrecedences().contains(beforeProtection))
								return false;
							if (preferences.isL1pEncouragedPrecedencesFocusing()
									&& !lastProtection.getEncouragedPrecedences().contains(beforeProtection))
								return false;
							if (preferences.isL1pDiscouragedPrecedencesIgnoration()
									&& lastProtection.getDiscouragedPrecedences().contains(beforeProtection))
								return false;

							// Special checks.
							if (lastProtection == beforeProtection)
							{
								ApplicationPart lastFunction = functionMap.get(lastPart);
								ApplicationPart beforeFunction = functionMap.get(beforePart);
								if (lastFunction != null && beforeFunction != null && lastFunction == beforeFunction
										&& lastProtection.getFlags().contains(ProtectionFlag.ONE_PER_FUNCTION))
									return false;
							}
						}
					}
				}

				return true;
			}
		};
	}

	/**
	 * Initializes the walker.
	 **/
	public void initialize1()
	{
		// Clears some stuff.
		initialProtectionObjectives.clear();
		initialCodeCorrelationSets.clear();
		initialAppliedProtectionInstantiations.clear();
		protectionObjectivesMap.clear();

		// Computes the protection objectives.
		Map<ApplicationPart, Set<ProtectionObjective>> pos = new HashMap<>();
		for (ProtectionObjective i : adss.getModel().getProtectionObjectives())
		{
			Set<ProtectionObjective> set;
			if (!pos.containsKey(i.getApplicationPart()))
			{
				set = new HashSet<>();
				pos.put(i.getApplicationPart(), set);
			}
			else
				set = pos.get(i.getApplicationPart());
			set.add(i);
			pos.put(i.getApplicationPart(), set);
		}
		initialProtectionObjectives.addAll(adss.getModel().getProtectionObjectives());

		// Computes the correlation sets.
		CorrelationSplitter splitter = new CorrelationSplitter(adss);
		List<List<ApplicationPart>> sets = splitter.getCorrelationSets();
		for (List<ApplicationPart> i : sets)
		{
			ArrayList<ProtectionObjective> x = new ArrayList<>();
			for (ProtectionObjective j : adss.getModel().getProtectionObjectives())
				if (i.contains(j.getApplicationPart()))
					Collections.addUnique(x, j);
			initialCodeCorrelationSets.add(x);
		}
		for (List<ProtectionObjective> i : initialCodeCorrelationSets)
			for (ProtectionObjective j : i)
				protectionObjectivesMap.put(j, i);

		// Computes the applied protection instantiations.
		for (AppliedProtectionInstantiation i : adss.getModel().getAppliedProtectionInstantiations())
			for (ProtectionObjective j : i.getProtectionObjectives())
			{
				Set<AppliedProtectionInstantiation> set;
				if (!initialAppliedProtectionInstantiations.containsKey(j))
				{
					set = new HashSet<>();
					initialAppliedProtectionInstantiations.put(j, set);
				}
				else
					set = initialAppliedProtectionInstantiations.get(j);
				set.add(EcoreUtil.copy(i));
			}

		// Removes and warns about the unprotectable POs.
		Set<ProtectionObjective> unprotectables = new HashSet<>();
		Iterator<ProtectionObjective> iterator1 = initialProtectionObjectives.iterator();
		while (iterator1.hasNext())
		{
			ProtectionObjective po = iterator1.next();
			if (!initialAppliedProtectionInstantiations.containsKey(po))
			{
				initialAppliedProtectionInstantiations.remove(po);
				iterator1.remove();
				for (List<ProtectionObjective> i : initialCodeCorrelationSets)
					i.remove(po);
				unprotectables.add(po);
			}
		}
		if (!unprotectables.isEmpty())
			log.warning("Unprotectable POs = " + unprotectables.size() + " " + unprotectables);

		// Removes the POs with no applied PIs.
		Iterator<List<ProtectionObjective>> iterator2 = initialCodeCorrelationSets.iterator();
		while (iterator2.hasNext())
		{
			List<ProtectionObjective> set = iterator2.next();
			if (set.isEmpty())
				iterator2.remove();
		}

		// Computes the function map.
		for (ApplicationPart i : adss.getModel().getAllApplicationParts())
			functionMap.put(i, getFunction(i));
	}

	/**
	 * Retrieves the function containing an application part or <code>null</code> if the application part is a global variable.
	 * @param applicationPart
	 *            The application part.
	 * @return The function containing an application part or <code>null</code> if the application part is a global variable.
	 **/
	private ApplicationPart getFunction(ApplicationPart applicationPart)
	{
		if (applicationPart.getType() == ApplicationPartType.FUNCTION)
			return applicationPart;
		else if (applicationPart.getDeclaringCode() != null)
			return getFunction(applicationPart.getDeclaringCode());
		else
			return null;
	}

	/**
	 * Prepares the walker for walking! It must called after @a initialize1.
	 * @param index
	 *            The code correlation set to enable or a negative value to enable all the sets.
	 * @return The total number of applied protection instantiations.
	 **/
	public int initialize2(int index)
	{
		enabledCorrelationSet = index;

		// Clears some stuff.
		currentProtectionObjectives.clear();
		currentCodeCorrelationSets.clear();
		currentAppliedProtectionInstantiations.clear();
		solutionMap.clear();
		tupleWalker = null;
		combinationWalkers = null;
		permutationWalkers = null;
		cardinalities = null;
		instantiations = null;

		if (enabledCorrelationSet < 0)
		{
			currentProtectionObjectives.addAll(initialProtectionObjectives);
			currentCodeCorrelationSets.addAll(initialCodeCorrelationSets);
		}
		else
		{
			List<ProtectionObjective> set = new ArrayList<>();
			set.addAll(initialCodeCorrelationSets.get(enabledCorrelationSet));
			currentProtectionObjectives.addAll(set);
			currentCodeCorrelationSets.add(set);
		}

		// Computes the applied PIs.
		for (Entry<ProtectionObjective, Set<AppliedProtectionInstantiation>> i : initialAppliedProtectionInstantiations.entrySet())
			if (currentProtectionObjectives.contains(i.getKey()))
			{
				Set<AppliedProtectionInstantiation> value = new HashSet<>();
				value.addAll(i.getValue());
				currentAppliedProtectionInstantiations.put(i.getKey(), value);
			}

		// Computes the singleton stuff.
		for (Set<AppliedProtectionInstantiation> i : currentAppliedProtectionInstantiations.values())
		{
			Set<Protection> set = new HashSet<>();
			Iterator<AppliedProtectionInstantiation> iterator = i.iterator();
			while (iterator.hasNext())
			{
				AppliedProtectionInstantiation pi = iterator.next();
				if (pi.getProtectionInstantiation().getProtection().isSingleton())
				{
					if (set.contains(pi.getProtectionInstantiation().getProtection()))
						iterator.remove();
					else
						set.add(pi.getProtectionInstantiation().getProtection());
				}
			}
		}
		int piCount = 0;
		for (Set<AppliedProtectionInstantiation> i : currentAppliedProtectionInstantiations.values())
			piCount += i.size();

		// Initializes the tuple walkers.
		List<Integer> values = new ArrayList<>();
		for (ProtectionObjective i : currentProtectionObjectives)
		{
			Set<Protection> protections = new HashSet<>();
			int count = 0;
			for (AppliedProtectionInstantiation j : currentAppliedProtectionInstantiations.get(i))
				if (j.getProtectionInstantiation().getProtection().isSingleton()
						&& !protections.contains(j.getProtectionInstantiation().getProtection()))
				{
					protections.add(j.getProtectionInstantiation().getProtection());
					++count;
				}
				else if (!j.getProtectionInstantiation().getProtection().isSingleton())
					++count;
			values.add(count);
		}
		cardinalities = new ArrayList<>();
		tupleWalker = new IntegerTupleWalker(values, cardinalities);
		log.finest("Tuple walker initialized");

		instantiations = new HashMap<>();
		for (ProtectionObjective i : currentProtectionObjectives)
			instantiations.put(i, new ArrayList<AppliedProtectionInstantiation>());
		combinationWalkers = new HashMap<>();
		log.finest("Combination walkers initialized");

		for (int i = 0; i < currentCodeCorrelationSets.size(); ++i)
			solutionMap.put(currentCodeCorrelationSets.get(i), new ArrayList<AppliedProtectionInstantiation>());
		permutationWalkers = new HashMap<>();

		tupleWalkers = new HashMap<>();
		singletonSelectors1 = new ArrayList<>();
		singletonSelectors2 = new ArrayList<>();

		state = State.CHOOSE_CARDINALITIES;
		log.finest("Protection combination walker initialized");

		return piCount;
	}

	/**
	 * Chooses the solution cardinalities.
	 * @return <code>true</code> if all the solutions have been explored, <code>false</code> otherwise.
	 **/
	public boolean chooseCardinalities()
	{
		if (!tupleWalker.computeNext())
			return true;

		Integer max = adss.getModel().getPreferences().getL1pMaximumInstantiationsPerProtectionObjective();

		for (int i = 0; i < currentProtectionObjectives.size(); ++i)
		{
			ProtectionObjective po = currentProtectionObjectives.get(i);
			Set<AppliedProtectionInstantiation> symbols = currentAppliedProtectionInstantiations.get(po);
			List<AppliedProtectionInstantiation> vector = instantiations.get(po);
			int t = cardinalities.get(i);
			if (max != null && t > max)
				continue;
			CombinationWalker<AppliedProtectionInstantiation> walker = new CombinationWalker<>(symbols, vector, t);
			if (i > 0 && !walker.computeNext())
				log.info("Internal error");
			combinationWalkers.put(po, walker);
		}
		state = State.CHOOSE_INSTANTIATIONS;

		return false;
	}

	/**
	 * Chooses the solution instantiations.
	 **/
	private void chooseInstantiations()
	{
		for (int i = 0; i < currentProtectionObjectives.size(); ++i)
		{
			ProtectionObjective po = currentProtectionObjectives.get(i);
			CombinationWalker<AppliedProtectionInstantiation> walker = combinationWalkers.get(po);
			if (walker.computeNext())
			{
				// First, we clear all the applied instantiations per code correlation sets
				for (List<AppliedProtectionInstantiation> j : solutionMap.values())
					j.clear();
				// Second, we create the applied instantiations sets.
				Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> symbols = new HashMap<>();
				for (int j = 0; j < currentProtectionObjectives.size(); ++j)
				{
					ProtectionObjective p = currentProtectionObjectives.get(j);
					List<ProtectionObjective> s = protectionObjectivesMap.get(p);
					List<AppliedProtectionInstantiation> m;
					Set<AppliedProtectionInstantiation> h = new HashSet<>();
					if (symbols.containsKey(s))
						m = symbols.get(s);
					else
					{
						m = new ArrayList<>();
						symbols.put(s, m);
					}
					h.addAll(m);
					for (AppliedProtectionInstantiation k : instantiations.get(p))
						if (!h.contains(k))
						{
							m.add(k);
							h.add(k);
						}
				}
				// Third, create the permutation walkers.
				boolean valid = true;
				for (int j = 0; j < currentCodeCorrelationSets.size(); ++j)
				{
					List<ProtectionObjective> s = currentCodeCorrelationSets.get(j);
					List<AppliedProtectionInstantiation> y = symbols.get(s);
					List<AppliedProtectionInstantiation> m = solutionMap.get(s);
					PermutationWalker<AppliedProtectionInstantiation> w1 = new PermutationWalker<>(y, prefixTester, m);
					if (j > 0 && !w1.computeNext())
					{
						valid = false;
						break;
					}
					permutationWalkers.put(s, w1);
				}
				if (valid)
					state = State.CHOOSE_ORDER;
				else
					state = State.CHOOSE_INSTANTIATIONS;
				break;
			}
			else if (i < combinationWalkers.size() - 1)
			{
				walker.reset();
				if (!walker.computeNext())
					state = State.CHOOSE_INSTANTIATIONS;
			}
			else
				state = State.CHOOSE_CARDINALITIES;
		}
	}

	/**
	 * Chooses the solution order.
	 */
	private void chooseOrder()
	{
		for (int i = 0; i < currentCodeCorrelationSets.size(); ++i)
		{
			List<ProtectionObjective> set = currentCodeCorrelationSets.get(i);
			PermutationWalker<AppliedProtectionInstantiation> walker = permutationWalkers.get(set);
			if (walker.computeNext())
			{
				boolean valid = true;
				singletonSelectors1.clear();
				singletonSelectors2.clear();
				for (int j = 0; j < currentCodeCorrelationSets.size(); ++j)
				{
					List<ProtectionObjective> s = currentCodeCorrelationSets.get(j);
					List<AppliedProtectionInstantiation> y = solutionMap.get(s);
					List<Integer> values = new ArrayList<>();
					List<AppliedProtectionInstantiation> vector2 = new ArrayList<>();
					for (AppliedProtectionInstantiation k : y)
					{
						vector2.add(k);
						if (k.getProtectionInstantiation().getProtection().isSingleton())
							values.add(k.getProtectionInstantiation().getProtection().getInstantiations().size());
						else
							values.add(1);
					}
					List<Integer> vector1 = new ArrayList<>();
					singletonSelectors1.add(vector1);
					singletonSelectors2.add(vector2);
					IntegerTupleWalker w = new IntegerTupleWalker(values, vector1);
					if (j > 0 && !w.computeNext())
					{
						valid = false;
						break;
					}
					tupleWalkers.put(s, w);
				}

				if (valid)
					state = State.CHOOSE_SINGLETONS;
				else
					state = State.CHOOSE_INSTANTIATIONS;
				break;
			}
			else if (i < permutationWalkers.size() - 1)
			{
				walker.reset();
				if (!walker.computeNext())
				{
					state = State.CHOOSE_INSTANTIATIONS;
					break;
				}
			}
			else
				state = State.CHOOSE_INSTANTIATIONS;
		}
	}

	/**
	 * Chooses the solution instantiations only for the singletons.
	 * @return <code>true</code> if a valid solution has been found, <code>false</code> otherwise.
	 **/
	private boolean chooseSingletons()
	{
		for (int i = 0; i < currentCodeCorrelationSets.size(); ++i)
		{
			List<ProtectionObjective> s = currentCodeCorrelationSets.get(i);
			IntegerTupleWalker walker = tupleWalkers.get(s);
			if (walker.computeNext())
			{
				List<Integer> values1 = singletonSelectors1.get(i);
				List<AppliedProtectionInstantiation> values2 = singletonSelectors2.get(i);
				for (int j = 0; j < values2.size(); ++j)
				{
					AppliedProtectionInstantiation pi = values2.get(j);
					Protection protection = pi.getProtectionInstantiation().getProtection();
					pi.setProtectionInstantiation(protection.getInstantiations().get(values1.get(j) - 1));
				}

				return true;
			}
			else if (i < tupleWalkers.size() - 1)
			{
				walker.reset();
				if (!walker.computeNext())
				{
					state = State.CHOOSE_ORDER;
					break;
				}
				else
				{
					List<Integer> values1 = singletonSelectors1.get(i);
					List<AppliedProtectionInstantiation> values2 = singletonSelectors2.get(i);
					for (int j = 0; j < values2.size(); ++j)
					{
						Protection protection = values2.get(j).getProtectionInstantiation().getProtection();
						values2.get(j).setProtectionInstantiation(protection.getInstantiations().get(values1.get(j) - 1));
					}
				}
			}
			else
				state = State.CHOOSE_ORDER;
		}

		return false;
	}

	/**
	 * Computes the next valid solution.
	 * @return <code>true</code> if a solution was found, <code>false</code> otherwise.
	 **/
	public boolean computeNext()
	{
		while (true)
			if (state == State.CHOOSE_CARDINALITIES)
			{
				if (chooseCardinalities())
					return false;
			}
			else if (state == State.CHOOSE_INSTANTIATIONS)
				chooseInstantiations();
			else if (state == State.CHOOSE_ORDER)
				chooseOrder();
			else if (state == State.CHOOSE_SINGLETONS)
			{
				if (chooseSingletons())
					return true;
			}
	}

	/**
	 * Retrieves the code correlation sets.
	 * @return The code correlation sets.
	 **/
	public List<List<ProtectionObjective>> getCodeCorrelationSets()
	{
		return initialCodeCorrelationSets;
	}

	/**
	 * The states.
	 **/
	private enum State
	{
		/** The state that chooses the instantiation cardinalities. **/
		CHOOSE_CARDINALITIES,
		/** The state that chooses the instantiations. **/
		CHOOSE_INSTANTIATIONS,
		/** The state that chooses the instantiation orders. **/
		CHOOSE_ORDER,
		/** The state that chooses the singletons. **/
		CHOOSE_SINGLETONS
	}

	/**
	 * Retrieves the applied protection instantiations map.
	 * @return The applied protection instantiations map.
	 **/
	public Map<ProtectionObjective, Set<AppliedProtectionInstantiation>> getAppliedProtectionInstantiations()
	{
		return initialAppliedProtectionInstantiations;
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(SolutionWalker.class.getName());
	/** The initial code correlation sets. **/
	private List<List<ProtectionObjective>> initialCodeCorrelationSets;
	/** The current code correlation sets. **/
	private List<List<ProtectionObjective>> currentCodeCorrelationSets;
	/** The initial applied protection instantiations. **/
	private Map<ProtectionObjective, Set<AppliedProtectionInstantiation>> initialAppliedProtectionInstantiations;
	/** The initial applied protection instantiations. **/
	private Map<ProtectionObjective, Set<AppliedProtectionInstantiation>> currentAppliedProtectionInstantiations;
	/** The cardinality tuple walker. **/
	private IntegerTupleWalker tupleWalker;
	/** The singletons tuple walkers. **/
	private Map<List<ProtectionObjective>, IntegerTupleWalker> tupleWalkers;
	/** The combination walkers. **/
	private Map<ProtectionObjective, CombinationWalker<AppliedProtectionInstantiation>> combinationWalkers;
	/** The permutation walkers. **/
	private Map<List<ProtectionObjective>, PermutationWalker<AppliedProtectionInstantiation>> permutationWalkers;
	/** The cardinalities. **/
	private List<Integer> cardinalities;
	/** The singleton selectors, integer values. **/
	private List<List<Integer>> singletonSelectors1;
	/** The singleton selectors, applied protection instantiations. **/
	private List<List<AppliedProtectionInstantiation>> singletonSelectors2;
	/** The applied instantiations to use. **/
	private Map<ProtectionObjective, List<AppliedProtectionInstantiation>> instantiations;
	/** The map between protection objectives and code correlation sets. **/
	private Map<ProtectionObjective, List<ProtectionObjective>> protectionObjectivesMap;
	/** The current solution. **/
	private Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> solutionMap;
	/** The current state. **/
	private State state;
	/** The initial protection objectives. **/
	private List<ProtectionObjective> initialProtectionObjectives;
	/** The current protection objectives. **/
	private List<ProtectionObjective> currentProtectionObjectives;
	/** The function map. **/
	private Map<ApplicationPart, ApplicationPart> functionMap;
}
