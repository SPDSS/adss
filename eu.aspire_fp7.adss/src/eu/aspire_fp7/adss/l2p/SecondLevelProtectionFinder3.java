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
package eu.aspire_fp7.adss.l2p;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.CodeBlock;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.SecondLevelMotivation;
import eu.aspire_fp7.adss.akb.SecondLevelMotivationType;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.akb.UseTarget;
import eu.aspire_fp7.adss.akb.UseType;
import eu.aspire_fp7.adss.optimizationAPI.CPlexOptimizer;
import eu.aspire_fp7.adss.optimizationAPI.Optimizer;
import eu.aspire_fp7.adss.optimizationAPI.OptimizerException;

/**
 * Finds the second level protections and their relative data.
 * @author Leonardo Regano
 **/

public class SecondLevelProtectionFinder3 {

	private final ADSS adss;
	private Solution firstLevelSolution;
	private Optimizer optimizer;
	private Double maxClientTimeOverhead;
	private Double maxServerTimeOverhead;
	private Double maxClientMemoryOverhead;
	private Double maxServerMemoryOverhead;
	private Double maxNetworkOverhead;
	private Map<Integer,List<Integer>> firstLevelProtectionInstantiations;
	private Map<Integer,ApplicationPart> iIndexes;
	private Set<Integer> iSkipped;
	private Set<ApplicationPart> appPartSkipped;
	private Map<ApplicationPart,Integer> appPartToiIndexes;
	private Map<Integer,ProtectionInstantiation> jIndexes;
	private Map<ProtectionInstantiation,Integer[]> protInstTojIndexes;
	private Map<Protection,Integer[]> protTojIndexes;
	private Map<Integer,Map<Integer,Object>> xVariables;
	private Map<Integer,Map<Integer,Boolean>> xVariablesValues;
	private Map<Integer,Map<Integer,Map<Integer,Object>>> pVariables;
	private Map<Integer,Map<Integer,Map<Integer,Boolean>>> pVariablesValues;
	private Map<Integer,Map<Integer,Map<Integer,Object>>> yVariables;
	private Map<Integer,Map<Integer,Map<Integer,Boolean>>> yVariablesValues;
	private Map<Integer,Map<Integer,Map<Integer,Object>>> gammaVariables;
	private Map<Integer,Map<Integer,Map<Integer,Boolean>>> gammaVariablesValues;
	private Map<Integer,Double> mergeBonusConstants;
	private Map<Integer,Map<Integer,Double>> efficiencyConstants;
	private Map<Integer,Map<Integer,Double>> precedenceConstants;
	private Map<Integer,Map<Integer,Double>> callGraphConstants;
	private Map<Integer,Map<Integer,Double>> clientTimeOverheads;
	private Map<Integer,Map<Integer,Double>> serverTimeOverheads;
	private Map<Integer,Map<Integer,Double>> clientMemoryOverheads;
	private Map<Integer,Map<Integer,Double>> serverMemoryOverheads;
	private Map<Integer,Map<Integer,Double>> networkOverheads;
	private Set<ApplicationPart> newApplicationParts;
	private Object objFun;
//	private int id;
	
	/**
	 * Creates the second level protection finder.
	 * @param adss The mythical ADSS.
	 * @throws Exception 
	 */
	public SecondLevelProtectionFinder3 (ADSS adss, Solution firstLevelSolution) throws Exception
	{
		this.adss=adss;
		this.firstLevelSolution=firstLevelSolution;
		this.optimizer = new CPlexOptimizer();
		firstLevelProtectionInstantiations = new HashMap<>();
		iIndexes = new HashMap<>();
		iSkipped = new HashSet<>();
		appPartSkipped = new HashSet<>();
		appPartToiIndexes = new HashMap<>();
		jIndexes = new HashMap<>();
		protInstTojIndexes = new HashMap<>();
		xVariables = new HashMap<>();
		yVariables = new HashMap<>();
		pVariables = new HashMap<>();
		protTojIndexes = new HashMap<>();
//		alfaVariables = new HashMap<>();
//		betaVariables = new HashMap<>();
		gammaVariables = new HashMap<>();
		xVariablesValues = new HashMap<>();
		yVariablesValues = new HashMap<>();
		pVariablesValues = new HashMap<>();
		gammaVariablesValues = new HashMap<>();
		mergeBonusConstants = new HashMap<>();
		efficiencyConstants = new HashMap<>();
		precedenceConstants = new HashMap<>();
		callGraphConstants = new HashMap<>();
		clientTimeOverheads = new HashMap<>();
		serverTimeOverheads = new HashMap<>();
		clientMemoryOverheads = new HashMap<>();
		serverMemoryOverheads = new HashMap<>();
		networkOverheads = new HashMap<>();
		newApplicationParts = new HashSet<>();
		maxClientTimeOverhead = 100.0;
		maxServerTimeOverhead = 100.0;
		maxClientMemoryOverhead = 100.0;
		maxServerMemoryOverhead = 100.0;
		maxNetworkOverhead = 100.0;
		objFun = optimizer.createObjectiveFunction(true);
//		id=0;
//		for(ApplicationPart part : adss.getModel().getAllApplicationParts())
//			if(id<=part.getId())
//				id=part.getId()+1;
	}
	
	public void checkSamePartsNested(ApplicationPart father)
	{
		for(ApplicationPart son : father.getApplicationParts())
			if(son.isCode())
			{	
				if(father.getStartLine()==son.getStartLine() && father.getEndLine()==son.getEndLine())
					log.severe(father.getName()+" "+father.hashCode()+" "+son.getName()+" "+son.hashCode());
				checkSamePartsNested(son);
			}
	}
	
	/**
	 * Generates the complete MIP model for finding the second level protection combination, solves it and creates the solution.
	 * @return The complete solution, with first and second level protections.
	 * @throws Exception 
	 */
	public void findSecondLevelProtectionWithCompleteModel() throws Exception
	{
		//generateModel();
//		for(ApplicationPart ap : adss.getModel().getAllApplicationParts())
//			if(ap.isCode() && (ap.getStartLine()==0 || ap.getEndLine() == 0))
//				log.fine(ap.getName()+" "+ap.getType()+" "+ap.getStartLine()+" "+ap.getEndLine());
//		for(ApplicationPart root : adss.getModel().getApplicationParts())
//			checkSamePartsNested(root);
//		File modelFile = new File("/home/leonardo/solution/model.sav");
//		if(!modelFile.exists())
//		{
			generateModel();
//			optimizer.exportModel("/home/leonardo/solution/model.sav");
//			optimizer.exportModel("/home/dani/model2.lp");
			//adss.saveBackup();
//			if(adss.getModel().getApplicationPartsCount()>0)
//				return;
//			PrintWriter writer = new PrintWriter(new File("/home/leonardo/solution/appPartToiIndexes.sav"));
//			for(ApplicationPart part : appPartToiIndexes.keySet())
//				writer.println(part.getId()+" "+appPartToiIndexes.get(part));
//			writer.flush();
//			writer.close();
//			writer = new PrintWriter(new File("/home/leonardo/solution/jIndexes.sav"));
//			for(Integer j : jIndexes.keySet())
//			{
//				ProtectionInstantiation pi = jIndexes.get(j);
//				writer.println(j+" "+pi.getName());
//			}
//			writer.flush();
//			writer.close();
//			writer = new PrintWriter(new File("/home/leonardo/solution/iIndexes.sav"));
//			for(Integer i : iIndexes.keySet())
//			{
//				ApplicationPart part = iIndexes.get(i);
//				writer.println(i+" "+part.getId()+" "+part.getName());
//			}
//			writer.flush();
//			writer.close();
//			writer = new PrintWriter(new File("/home/leonardo/solution/firstLevelProtectionInstantiations.sav"));
//			for(Integer i : firstLevelProtectionInstantiations.keySet())
//			{
//				writer.print(i);
//				for(Integer j : firstLevelProtectionInstantiations.get(i))
//					writer.print(" "+j);
//				writer.println();
//			}
//			writer.flush();
//			writer.close();
//			writer = new PrintWriter(new File("/home/leonardo/solution/callGraph.sav"));
//			for(Integer i1 : callGraphConstants.keySet())
//				for(Integer i2 : callGraphConstants.get(i1).keySet())
//					if(callGraphConstants.get(i1).get(i2)>0.0)
//						writer.println(i1+" "+i2);
//			writer.flush();
//			writer.close();
//			log.fine("Free memory before cleaning maps: "+Runtime.getRuntime().freeMemory()/(1024*1024));
//			for(List<Integer> element : firstLevelProtectionInstantiations.values())
//			{
//				for(Integer element2 : element)
//					element2 = null;
//				element=null;
//			}
//			firstLevelProtectionInstantiations = null;
//			iIndexes = null;
//			appPartToiIndexes = null;
//			jIndexes = null;
//			for(Integer[] element : protInstTojIndexes.values())
//			{
//				for(Integer element2 : element)
//					element2=null;
//				element=null;
//			}
//			protInstTojIndexes = null;
			//xVariables = null;
//			for(Map<Integer, Map<Integer, Object>> element : yVariables.values())
//			{
//				for(Map<Integer, Object> element2 : element.values())
//					element2=null;
//				element=null;
//			}
//			yVariables = null;
			//pVariables = null;
//			for(Integer[] element : protTojIndexes.values())
//			{
//				for(Integer element2: element)
//					element2=null;
//				element=null;
//			}
//			protTojIndexes = null;
			//gammaVariables = null;
//			mergeBonusConstants = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : efficiencyConstants.values())
				element = null;
			efficiencyConstants = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : precedenceConstants.values())
				element = null;
			precedenceConstants = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : callGraphConstants.values())
				element = null;
			callGraphConstants = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : clientTimeOverheads.values())
				element = null;
			clientTimeOverheads = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : serverTimeOverheads.values())
				element = null;
			serverTimeOverheads = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : clientMemoryOverheads.values())
				element = null;
			clientMemoryOverheads = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : serverMemoryOverheads.values())
				element = null;
			serverMemoryOverheads = null;
			for(@SuppressWarnings("unused") Map<Integer, Double> element : networkOverheads.values())
				element = null;
			networkOverheads = null;
			System.gc();
			log.fine("Free memory after cleaning maps: "+Runtime.getRuntime().freeMemory()/(1024*1024));
//		}
//		else
//			optimizer.importModel("/home/leonardo/solution/model.sav");
		
//		File xFile = new File("/home/leonardo/solution/xVariableValues.sav");
//		if(!xFile.exists())
//		{
//
			if(adss.getModel().getPreferences().getL2pSolutionLimit()>0)
				optimizer.setIntegerSolutionLimit(adss.getModel().getPreferences().getL2pSolutionLimit());
			if(adss.getModel().getPreferences().getL2pTimeLimit()>0)
				optimizer.setTimeLimit(adss.getModel().getPreferences().getL2pTimeLimit());
			if(adss.getModel().getPreferences().getL2pGapLimit()>0)
				optimizer.setGapLimit(adss.getModel().getPreferences().getL2pGapLimit());
			
			//optimizer.exportModel("/home/leonardo/solution/model.lp");
			optimizer.solve();
//			PrintWriter writer;
//			writer = new PrintWriter(xFile);
			for(int i : xVariables.keySet())
			{
				Map<Integer, Object> xVariables_i = xVariables.get(i); 
				Map<Integer, Boolean> map = xVariablesValues.get(i);
				if(map==null)
				{
					map = new HashMap<>();
					xVariablesValues.put(i, map);
				}
				for(int j : xVariables.get(i).keySet())
				{
					boolean value = (optimizer.getVariableValue(xVariables_i.get(j)) > 0.5);
					map.put(j, value);
//					if(value)
//						writer.println(i+" "+j+" "+1);
//					else
//						writer.println(i+" "+j+" "+0);
				}
			}
//			writer.flush();
//			writer.close();
//			File pFile = new File("/home/leonardo/solution/pVariableValues.sav");
//			writer = new PrintWriter(pFile);
			for(int i : pVariables.keySet())
			{
				Map<Integer, Map<Integer, Object>> pVariables_i = pVariables.get(i);
				Map<Integer, Map<Integer, Boolean>> map = pVariablesValues.get(i);
				if(map==null)
				{
					map = new HashMap<>();
					pVariablesValues.put(i, map);
				}
				for(int j1 : pVariables_i.keySet())
				{
					Map<Integer, Object> pVariables_i_j1 = pVariables_i.get(j1);
					Map<Integer, Boolean> map2 = map.get(j1);
					if(map2==null)
					{
						map2 = new HashMap<>();
						map.put(j1, map2);
					}
					for(int j2 : pVariables_i_j1.keySet())
					{
						boolean value = (optimizer.getVariableValue(pVariables_i_j1.get(j2)) > 0.5);
						map2.put(j2, value);
//						if(value)
//							writer.println(i+" "+j1+" "+j2+" "+1);
//						else
//							writer.println(i+" "+j1+" "+j2+" "+0);
					}
				}
			}
//			writer.flush();
//			writer.close();
//			File gFile = new File("/home/leonardo/solution/gVariableValues.sav");
//			writer = new PrintWriter(gFile);
			for(int i : gammaVariables.keySet())
			{
				Map<Integer, Map<Integer, Object>> gammaVariables_i = gammaVariables.get(i);
				Map<Integer, Map<Integer, Boolean>> map = gammaVariablesValues.get(i);
				if(map==null)
				{
					map = new HashMap<>();
					gammaVariablesValues.put(i, map);
				}
				for(int j1 : gammaVariables_i.keySet())
				{
					Map<Integer, Object> gammaVariables_i_j1 = gammaVariables_i.get(j1);
					Map<Integer, Boolean> map2 = map.get(j1);
					if(map2==null)
					{
						map2 = new HashMap<>();
						map.put(j1, map2);
					}
					for(int j2 : gammaVariables_i_j1.keySet())
					{
						boolean value = (optimizer.getVariableValue(gammaVariables_i_j1.get(j2)) > 0.5);
						map2.put(j2, value);
//						if(value)
//							writer.println(i+" "+j1+" "+j2+" "+1);
//						else
//							writer.println(i+" "+j1+" "+j2+" "+0);
					}
				}
			}
//			writer.flush();
//			writer.close();
//			File yFile = new File("/home/leonardo/solution/yVariableValues.sav");
//			writer = new PrintWriter(yFile);
			for(int i : yVariables.keySet())
			{
				Map<Integer, Map<Integer, Object>> yVariables_i = yVariables.get(i);
				Map<Integer, Map<Integer, Boolean>> map = yVariablesValues.get(i);
				if(map==null)
				{
					map = new HashMap<>();
					yVariablesValues.put(i, map);
				}
				for(int j1 : yVariables_i.keySet())
				{
					Map<Integer, Object> yVariables_i_j1 = yVariables_i.get(j1);
					Map<Integer, Boolean> map2 = map.get(j1);
					if(map2==null)
					{
						map2 = new HashMap<>();
						map.put(j1, map2);
					}
					for(int j2 : yVariables_i_j1.keySet())
					{
						boolean value = (optimizer.getVariableValue(yVariables_i_j1.get(j2)) > 0.5);
						map2.put(j2, value);
//						if(value)
//							writer.println(i+" "+j1+" "+j2+" "+1);
//						else
//							writer.println(i+" "+j1+" "+j2+" "+0);
					}
				}
			}
//			writer.flush();
//			writer.close();
//		}
//		else
//		{
//			BufferedReader reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/xVariableValues.sav")));
//			String line = null;
//			while((line = reader.readLine())!=null)
//			{
//				String[] parts = line.split(" ");
//				int i = Integer.parseInt(parts[0]);
//				int j = Integer.parseInt(parts[1]);
//				boolean value = (Integer.parseInt(parts[2]) == 1);
//				Map<Integer, Boolean> map = xVariablesValues.get(i);
//				if(map==null)
//				{
//					map = new HashMap<>();
//					xVariablesValues.put(i, map);
//				}
//				map.put(j, value);
//			}
//			reader.close();
//			reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/pVariableValues.sav")));
//			while((line = reader.readLine())!=null)
//			{
//				String[] parts = line.split(" ");
//				int i = Integer.parseInt(parts[0]);
//				int j1 = Integer.parseInt(parts[1]);
//				int j2 = Integer.parseInt(parts[2]);
//				boolean value = (Integer.parseInt(parts[3]) == 1);
//				Map<Integer, Map<Integer, Boolean>> map = pVariablesValues.get(i);
//				if(map==null)
//				{
//					map = new HashMap<>();
//					pVariablesValues.put(i, map);
//				}
//				Map<Integer, Boolean> map2 = map.get(j1);
//				if(map2==null)
//				{
//					map2 = new HashMap<>();
//					map.put(j1, map2);
//				}
//				map2.put(j2, value);
//			}
//			reader.close();
//			reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/gVariableValues.sav")));
//			while((line = reader.readLine())!=null)
//			{
//				String[] parts = line.split(" ");
//				int i = Integer.parseInt(parts[0]);
//				int j1 = Integer.parseInt(parts[1]);
//				int j2 = Integer.parseInt(parts[2]);
//				boolean value = (Integer.parseInt(parts[3]) == 1);
//				Map<Integer, Map<Integer, Boolean>> map = gammaVariablesValues.get(i);
//				if(map==null)
//				{
//					map = new HashMap<>();
//					gammaVariablesValues.put(i, map);
//				}
//				Map<Integer, Boolean> map2 = map.get(j1);
//				if(map2==null)
//				{
//					map2 = new HashMap<>();
//					map.put(j1, map2);
//				}
//				map2.put(j2, value);
//			}
//			reader.close();
//			
			for(ApplicationPart part : adss.getModel().getAllApplicationParts())
				ECollections.sort(part.getApplicationParts(), new java.util.Comparator<ApplicationPart>() {
						 @Override
				         public int compare(ApplicationPart ap1, ApplicationPart ap2) {
							 if(ap1.isCode() && ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
								return ap1.getStartLine()-ap2.getStartLine();
							 else if(!ap1.isCode() && ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
							 	return -1;
							 else if(ap1.isCode() && !ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
							 	return +1;
							 else
								return 0;
		//					 return ap2.getStartLine()-ap1.getStartLine();
						 }
					});
//		}
		
//		firstLevelProtectionInstantiations = new HashMap<>();
//		iIndexes = new HashMap<>();
//		appPartToiIndexes = new HashMap<>();
//		jIndexes = new HashMap<>();
//		
//		BufferedReader reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/appPartToiIndexes.sav")));
//		String line = null;
//		HashMap<Integer,ApplicationPart> partIds = new HashMap<>();
//		for(ApplicationPart part : adss.getModel().getAllApplicationParts())
//			partIds.put(part.getId(), part);
//		while((line = reader.readLine())!=null)
//		{
//			String[] parts = line.split(" ");
//			int id = Integer.parseInt(parts[0]);
//			int i  = Integer.parseInt(parts[1]);
//			appPartToiIndexes.put(partIds.get(id), i);
//		}
//		reader.close();
//		reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/jIndexes.sav")));
//		while((line = reader.readLine())!=null)
//		{
//			String[] parts = line.split(" ");
//			int j = Integer.parseInt(parts[0]);
//			String piName = parts[1];
//			for(int c=2; c<parts.length; c++)
//				piName += " " + parts[c];
//			ProtectionInstantiation pi = null;
//			for(Protection p : adss.getModel().getProtections())
//				for(ProtectionInstantiation pi2 : p.getInstantiations())
//					if(pi2.getName().equals(piName))
//					{
//						pi=pi2;
//						break;
//					}
//			jIndexes.put(j, pi);
//		}
//		reader.close();
//		reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/iIndexes.sav")));
//		while((line = reader.readLine())!=null)
//		{
//			String[] parts = line.split(" ");
//			int i = Integer.parseInt(parts[0]);
//			int id = Integer.parseInt(parts[1]);
//			iIndexes.put(i, partIds.get(id));
//		}
//		reader.close();
//		reader = new BufferedReader(new FileReader(new File("/home/leonardo/solution/firstLevelProtectionInstantiations.sav")));
//		while((line = reader.readLine())!=null)
//		{
//			String[] parts = line.split(" ");
//			int i = Integer.parseInt(parts[0]);
//			List<Integer> pis = new LinkedList<>();
//			for(int c = 1; c < parts.length; c++)
//			{
//				int j = Integer.parseInt(parts[c]);
//				pis.add(j);
//			}
//			firstLevelProtectionInstantiations.put(i, pis);
//		}
//		reader.close();
		
		log.fine("Inferring solution");
		Solution solution = AkbFactory.eINSTANCE.createSolution();
		solution.setFirstLevelSolution(firstLevelSolution);
		solution.setScore(firstLevelSolution.getScore());
		SolutionSequence secondLevelSolutionSequence = AkbFactory.eINSTANCE.createSolutionSequence();
		solution.getSolutionSequences().add(secondLevelSolutionSequence);
		
		Map<ApplicationPart,List<AppliedProtectionInstantiation>> functionsToApis = new HashMap<>();
		
		for(ApplicationPart function : adss.getModel().getApplicationParts())
			if(!function.isInSystemFile())
			{
				List<AppliedProtectionInstantiation> apis = new LinkedList<>();
				if(!function.isCode()) continue;
				log.fine("Launching explore node on function "+function.getName());
				exploreNode(apis,null,function,false);
				functionsToApis.put(function, apis);
			}
		
		for(SolutionSequence firstLevelSolutionSequence : firstLevelSolution.getSolutionSequences())
		{
			for(AppliedProtectionInstantiation firstLevelApi : firstLevelSolutionSequence.getAppliedProtectionInstantiations())
			{
				if(!firstLevelApi.getProtectionInstantiation().getProtection().isSecondLevel())
				{
					AppliedProtectionInstantiation secondLevelApi = EcoreUtil.copy(firstLevelApi);
					SecondLevelMotivation motivation = AkbFactory.eINSTANCE.createSecondLevelMotivation();
					motivation.setMotivationType(SecondLevelMotivationType.KEPT);
					secondLevelApi.getSecondLevelMotivation().add(motivation);
					secondLevelSolutionSequence.getAppliedProtectionInstantiations().add(secondLevelApi);
//					log.fine(firstLevelApi + " --> " + secondLevelApi);
				}
			}
		}
		
//		log.fine("\n\n\n");
		
		for(ApplicationPart function : functionsToApis.keySet())
			for(AppliedProtectionInstantiation api : functionsToApis.get(function))
			{
//				log.fine(functionsToApis.get(function).toString());
				SecondLevelMotivation motivation = AkbFactory.eINSTANCE.createSecondLevelMotivation();
				if(api.getApplicationPart().getName().contains("fromLine") && api.getApplicationPart().getName().contains("toLine"))
					motivation.setMotivationType(SecondLevelMotivationType.REPEATED);
				else
					motivation.setMotivationType(SecondLevelMotivationType.KEPT);
				AppliedProtectionInstantiation secondLevelApi = EcoreUtil.copy(api);
				secondLevelApi.getSecondLevelMotivation().add(motivation);
				secondLevelSolutionSequence.getAppliedProtectionInstantiations().add(secondLevelApi);
//				log.fine("new " + secondLevelApi);
//				log.fine(functionsToApis.get(function).toString());
			}
//		log.fine("\n\n\n");
//		
//		Set<ApplicationPart> evaluatedFunctions = new HashSet<>(); 
//		for(SolutionSequence firstLevelSolutionSequence : firstLevelSolution.getSolutionSequences())
//		{
//			Set<ApplicationPart> functions = new HashSet<>(); 
//			for(AppliedProtectionInstantiation firstLevelApi : firstLevelSolutionSequence.getAppliedProtectionInstantiations())
//			{
//				ApplicationPart function = null;
//				for(ApplicationPart function2 : functionsToApis.keySet())
//					if(functionContainsApplicationPart(function2, firstLevelApi.getApplicationPart()))
//					{
//						function = function2;
//						break;
//					}
//				if(function == null || !firstLevelApi.getProtectionInstantiation().getProtection().isSecondLevel())
//				{
//					SecondLevelMotivation motivation = AkbFactory.eINSTANCE.createSecondLevelMotivation();
//					motivation.setMotivationType(SecondLevelMotivationType.KEPT);
//					AppliedProtectionInstantiation secondLevelApi = EcoreUtil.copy(firstLevelApi);
//					secondLevelApi.getSecondLevelMotivation().add(motivation);
//					secondLevelSolutionSequence.getAppliedProtectionInstantiations().add(secondLevelApi);
//				}
//				else
//				{
//					//TODO implementare ritrovamento automatico motivazione dai bonus
//					functions.add(function);
//				}
//			}
//			for(ApplicationPart function : functions)
//			{
//				EList<AppliedProtectionInstantiation> apis = functionsToApis.get(function);
//				for(AppliedProtectionInstantiation api : apis)
//				{
//					SecondLevelMotivation motivation = AkbFactory.eINSTANCE.createSecondLevelMotivation();
//					AppliedProtectionInstantiation secondLevelApi = EcoreUtil.copy(api);
//					if(api.getApplicationPart().getName().contains("fromLine") && api.getApplicationPart().getName().contains("toLine"))
//						motivation.setMotivationType(SecondLevelMotivationType.REPEATED);
//					else
//						motivation.setMotivationType(SecondLevelMotivationType.KEPT);
//					secondLevelApi.getSecondLevelMotivation().add(motivation);
//					secondLevelSolutionSequence.getAppliedProtectionInstantiations().add(secondLevelApi);
//				}
//			}
//		}
//		for(ApplicationPart function : functionsToApis.keySet())
//			if(!evaluatedFunctions.contains(function))
//				for(AppliedProtectionInstantiation api : functionsToApis.get(function))
//				{
//					SecondLevelMotivation motivation = AkbFactory.eINSTANCE.createSecondLevelMotivation();
//					motivation.setMotivationType(SecondLevelMotivationType.REPEATED);
//					AppliedProtectionInstantiation secondLevelApi = EcoreUtil.copy(api);
//					secondLevelApi.getSecondLevelMotivation().add(motivation);
//					secondLevelSolutionSequence.getAppliedProtectionInstantiations().add(secondLevelApi);
//				}
		adss.getModel().getSolutions().add(solution);
		
//		for(AppliedProtectionInstantiation api : apis)
//			//log.fine("Applied protection instantiation "+api.getProtectionInstantiation().getName()+" on application part "+api.getApplicationPart().getName());
//			log.fine(api.getProtectionInstantiation().getName()+" @ "+api.getApplicationPart().getName());
		
		log.fine("Solution found, score: "+optimizer.getObjectiveValue());
		
//		printReport(apis);
		
		
//		log.fine(objFun.getExpr().toString());
		
		
//		for(ApplicationPart part : adss.getModel().getApplicationParts())
//			log.fine(part.getType()+" "+part.getName());
	}

	private boolean functionContainsApplicationPart(ApplicationPart function, ApplicationPart part)
	{
		for(ApplicationPart part2 : function.getApplicationParts())
			if(part2.equals(part)) return true;
		boolean found = false;
		for(ApplicationPart part2 : function.getApplicationParts())
			if(functionContainsApplicationPart(part2,part))
				return true;
		return false;
	}
	
	//Generate the HTML report file part
	private void printReport(EList<AppliedProtectionInstantiation> apis)
	{
		for(AppliedProtectionInstantiation api : apis)
		{
			if(newApplicationParts.contains(api.getApplicationPart()))
				System.out.println(api.getProtectionInstantiation().getName()+" @ "+api.getApplicationPart().getName()+" [replicated]<br/>");
			else
				System.out.println(api.getProtectionInstantiation().getName()+" @ "+api.getApplicationPart().getName()+" [kept]<br/>");
		}
	}
	
	/**
	 * Adds to the list the protection instantiations relative to the passed application part, and calls itself recursively to apply the pis to the children application parts.   
	 * @param apis
	 * @param alreadyAppliedProtInst
	 * @param root
	 * @throws OptimizerException 
	 * @throws UnknownObjectException 
	 */
	public void exploreNode(List<AppliedProtectionInstantiation> apis, Set<Integer> alreadyAppliedProtInst, ApplicationPart root, boolean isNewApplicationPart) throws OptimizerException
	{
		if(!root.isCode()) return;
		if(appPartSkipped.contains(root)) return;
		List<AppliedProtectionInstantiation> thisApis = new LinkedList<>();
		Set<Integer> thisAlreadyAppliedProtInst = new HashSet<>();
		if(alreadyAppliedProtInst!=null)
			thisAlreadyAppliedProtInst.addAll(alreadyAppliedProtInst);
		
		if(!isNewApplicationPart && root.getType().equals(ApplicationPartType.CODE_REGION))
		{
			int i = appPartToiIndexes.get(root);
			int n_i = 0;
			Map<Integer, Boolean> xVariablesValues_i = xVariablesValues.get(i);
			Map<Integer, Map<Integer, Boolean>> pVariablesValues_i = pVariablesValues.get(i);
			for(int j : xVariablesValues_i.keySet())
				if(xVariablesValues_i.get(j))
					n_i++;
			
			Integer[] pis = new Integer[n_i];
			
			for(int j1 : xVariablesValues_i.keySet())
			{
				Map<Integer, Boolean> pVariablesValues_i_j1 = pVariablesValues_i.get(j1);
				if(xVariablesValues_i.get(j1))
				{
					int sum_p_i_j1_j2 = 0;
					for(int j2 : pVariablesValues_i_j1.keySet())
						if(j1!=j2 && pVariablesValues_i_j1.get(j2))
							sum_p_i_j1_j2++;
					pis[n_i-sum_p_i_j1_j2-1]=j1;
				}
			}
			
			for(int j : pis)
			{
				if(thisAlreadyAppliedProtInst.contains(j)) break;
				AppliedProtectionInstantiation api = null;
				boolean stop = false;
				List<Integer> firstLevelProtectionInstantiations_i = firstLevelProtectionInstantiations.get(i);
				if(firstLevelProtectionInstantiations_i!=null && firstLevelProtectionInstantiations_i.contains(j))
				{
					for(SolutionSequence solSeq : firstLevelSolution.getSolutionSequences())
					{
						for(AppliedProtectionInstantiation firstLevelApi : solSeq.getAppliedProtectionInstantiations())
						{
							if(firstLevelApi.getApplicationPart().equals(root) && firstLevelApi.getProtectionInstantiation().equals(jIndexes.get(j)))
							{
								api = firstLevelApi;
								stop=true;
								break;
							}
							if(stop) break;
						}
						if(stop) break;
					}
				}
				else
					api = AkbFactory.eINSTANCE.createAppliedProtectionInstantiation();
				api.setApplicationPart(root);
				api.setProtectionInstantiation(jIndexes.get(j));
				thisApis.add(api);
				thisAlreadyAppliedProtInst.add(j);
				adss.getModel().getAppliedProtectionInstantiations().add(api);
			}
		}
		
		//list of contiguous code regions --> list of applied protection instantiations
		List<Entry<List<Integer>,List<Integer>>> mergedProt = new LinkedList<>();
		Set<ApplicationPart> newApplicationPart = new HashSet<>();
		ApplicationPart children1 = null;
		
		for(ApplicationPart children2 : root.getApplicationParts())
		{
			if(!children2.isCode() || !children2.isInSystemFile()) continue;
			if(appPartSkipped.contains(children2)) continue;
			if(children1==null)
			{
				children1=children2;
				continue;
			}
			
			int iChildren1 = appPartToiIndexes.get(children1);
			int iChildren2 = appPartToiIndexes.get(children2);
			
			List<Integer> mergedProtInst = new LinkedList<>();
			List<Integer> contiguousAppPart = null;
			for(Entry<List<Integer>,List<Integer>> entry : mergedProt)
			{
				List<Integer> list = entry.getKey();
				if(list.contains(iChildren1))
				{
					mergedProtInst = entry.getValue();
					contiguousAppPart = list;
					break;
				}
			}
			
			Map<Integer, Boolean> gammaVariablesValues_iChildren1_iChildren2 = gammaVariablesValues.get(iChildren1).get(iChildren2);
			
			if(mergedProtInst.isEmpty())
			{
				//if(gammaVariablesValues_iChildren1_iChildren2 == null) continue;
				for(int j : gammaVariablesValues_iChildren1_iChildren2.keySet())
					if(gammaVariablesValues_iChildren1_iChildren2.get(j) && !thisAlreadyAppliedProtInst.contains(j))
					{
						int index = 0;
//						if(mergedProtInst.isEmpty())
//							mergedProtInst.add(j);
//						else
						for(Integer j2 : mergedProtInst)
						{
							boolean p_iChildren1_j_j2 = pVariablesValues.get(iChildren1).get(j).get(j2);
							if(!p_iChildren1_j_j2)
								index++;
						}
						mergedProtInst.add(index,j);
					}
				if(!mergedProtInst.isEmpty())
				{
					List<Integer> codeRegions = new LinkedList<>();
					codeRegions.add(iChildren1);
					codeRegions.add(iChildren2);
					//mergedProtInst = new LinkedList<>();
					mergedProt.add(new SimpleEntry<List<Integer>, List<Integer>>(codeRegions, mergedProtInst));
				}
			}
			else
			{
				int commonProtections = 0;
				for(int index = mergedProtInst.size()-1; index>-1; index--)
				{
					int j = mergedProtInst.get(index);
					if(gammaVariablesValues_iChildren1_iChildren2.get(j))
						commonProtections++;
					else
						break;
				}
				if(commonProtections>0)
				{
					contiguousAppPart.add(iChildren2);
					int size = mergedProtInst.size();
					for(int counter = 0; counter < size-commonProtections; counter++)
						mergedProtInst.remove(0);
				}
			}
			children1=children2;
		}
		
//		if(mergedProt.size()==1)
//		{
//			for(Entry<List<Integer>,List<Integer>> entry : mergedProt)	
//			{
//				List<Integer> contiguousCodeRegions = entry.getKey();
//				if(contiguousCodeRegions.size()==root.getApplicationParts().size())
//					if(root.getApplicationParts().get(0).getStartLine()==root.getStartLine() && root.getApplicationParts().get(root.getApplicationParts().size()-1).getEndLine()==root.getEndLine()) 
//					{
//						List<AppliedProtectionInstantiation> localApis = new LinkedList<>();
//						for(int j : entry.getValue())
//						{
//							AppliedProtectionInstantiation api = AkbFactory.eINSTANCE.createAppliedProtectionInstantiation();
//							api.setApplicationPart(root);
//							api.setProtectionInstantiation(jIndexes.get(j));
//							localApis.add(api);
//							thisAlreadyAppliedProtInst.add(j);
//						}
//						thisApis.addAll(0, localApis);
//					}
//			}
//		}
//		else
//		{
			for(Entry<List<Integer>,List<Integer>> entry : mergedProt)	
			{
				List<Integer> contiguousCodeRegions = entry.getKey();
				ApplicationPart newPart = AkbFactory.eINSTANCE.createApplicationPart();
//				newPart.setId(id);
//				id+=1;
				newPart.setStartLine(iIndexes.get(contiguousCodeRegions.get(0)).getStartLine());
				newPart.setEndLine(iIndexes.get(contiguousCodeRegions.get(contiguousCodeRegions.size()-1)).getEndLine());
				newPart.setSourceFilePath(iIndexes.get(contiguousCodeRegions.get(0)).getSourceFilePath());
				newPart.setName(root.getName()+"-fromLine"+newPart.getStartLine()+"toLine"+newPart.getEndLine());
				newPart.setType(ApplicationPartType.CODE_REGION);
				newPart.setWeight(1.0);
				log.fine("New code region: "+newPart.getName());
				adss.updateAssets();
				Set<Integer> changedHash = new HashSet<Integer>();
				for(Integer contiguousCodeRegion : contiguousCodeRegions)
				{
					ApplicationPart part = iIndexes.get(contiguousCodeRegion);
					changedHash = addToChangedHash(part,changedHash);
					appPartToiIndexes.remove(part);
					root.getApplicationParts().remove(part);
					int index = 0;
					for(ApplicationPart part2 : newPart.getApplicationParts())
					{
						if(part.getStartLine()>part2.getStartLine())
							index++;
						else
							break;
					}
					newPart.getApplicationParts().add(index, part);
					//appPartToiIndexes.put(part, contiguousCodeRegion);
				}
				root.getApplicationParts().add(newPart);
				ECollections.sort(root.getApplicationParts(), new java.util.Comparator<ApplicationPart>() {
						 @Override
				         public int compare(ApplicationPart ap1, ApplicationPart ap2) {
							 if(ap1.isCode() && ap2.isCode())
								return ap1.getStartLine()-ap2.getStartLine();
							 else if(!ap1.isCode() && ap2.isCode())
							 	return -1;
							 else if(ap1.isCode() && !ap2.isCode())
							 	return +1;
							 else
								return 0;
						 }
					});
				List<AppliedProtectionInstantiation> localApis = new LinkedList<>();
				for(int j : entry.getValue())
				{
					AppliedProtectionInstantiation api = AkbFactory.eINSTANCE.createAppliedProtectionInstantiation();
					api.setApplicationPart(newPart);
					api.setProtectionInstantiation(jIndexes.get(j));
					localApis.add(api);
					thisAlreadyAppliedProtInst.add(j);
					adss.getModel().getAppliedProtectionInstantiations().add(api);
				}
				thisApis.addAll(0, localApis);
				newApplicationPart.add(newPart);
				
				for(Integer contiguousCodeRegion : changedHash)
				{
					ApplicationPart part = iIndexes.get(contiguousCodeRegion);
					appPartToiIndexes.put(part, contiguousCodeRegion);
				}
			}
//		}
		
		apis.addAll(0, thisApis);
		
		newApplicationParts.addAll(newApplicationPart);
		
		for(ApplicationPart part : root.getApplicationParts())
			exploreNode(apis, thisAlreadyAppliedProtInst, part, newApplicationPart.contains(part));
	}
	
	private Set<Integer> addToChangedHash(ApplicationPart part, Set<Integer> changedHash) {
		changedHash.add(appPartToiIndexes.get(part));
		for(ApplicationPart part2 : part.getApplicationParts())
			changedHash = addToChangedHash(part2, changedHash);
		return changedHash;
	}

	/**
	 * Generates the complete MIP model for finding the second level protection combination.  
	 * @throws Exception 
	 */
	public void generateModel() throws Exception
	{
		log.fine("Starting generation of the complete lp model");
		long start = System.currentTimeMillis();
		long stop = 0L;
		boolean codeRegionsAlreadyGenerated = false;
		for(ApplicationPart part : adss.getModel().getAllApplicationParts())
			if(part.getName().contains("fromLine"))
			{
				codeRegionsAlreadyGenerated = true;
				break;
			}
		if(!codeRegionsAlreadyGenerated)
		{
			findCodeRegions(2);
			stop = System.currentTimeMillis();
			log.fine("Time = " + (stop - start) + " ms");
			log.fine("Code regions found");
		}
		generateIindexes(null,0);
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("I indexes generated");
		generateJindexes();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("J indexes generated");
		generateFirstLevelSolutionMap(firstLevelSolution);
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("First level solution map generated");
//		generateProtectionMap();
//		stop = System.currentTimeMillis();
//		log.fine("Time = " + (stop - start) + " ms");
//		log.fine("Protection map generated");
		generatePrecedenceBonusConstants();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Precedence bonus constants generated");
//		generateEfficiencyBonusConstants();
//		stop = System.currentTimeMillis();
//		log.fine("Time = " + (stop - start) + " ms");
//		log.fine("Efficiency bonus constants generated");
		generateMergeBonusConstants();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Merge bonus constants generated");
		generateXvariables();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("X variables generated");
		generateOverheadConstants();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Overhead constants generated");
		generatePvariables();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("P variables generated");
		generateGammaVariables(null);
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Gamma variables generated");
		generateCallGraphEnlargment();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Call graph enlargment generated");
		generateOverheadConstraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Overhead constraints generated");
		generatePrecedencesConstraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Precedences constraints generated");
		generatePrecedencesAntiCycleConstraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Precedences Anti Cycle constraints generated");
		generateMergeConstraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Merge constraints generated");
		generateContainmentContraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Containment constraints generated");
		generateContainmentPrecedenceConstraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Containment Precedence constraints generated");
		generateSameProtectionInstantiationJindexesContraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Same Protection Instantiation J indexes constraints generated");
		generateYvariablesContraints();
		stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
		log.fine("Y variables constraints generated");
//		generateObjectiveFunction();
//		stop = System.currentTimeMillis();
//		log.fine("Time = " + (stop - start) + " ms");
//		log.fine("Objective function generated");
	}
	
//	/**
//	 * Generates the objective function.
//	 * @throws OptimizerException 
//	 */
//	public void generateObjectiveFunction() throws OptimizerException
//	{
////		log.fine("Adding x variables efficiency to objective function");
////		for(int i : xVariables.keySet())
////			for(int j : xVariables.get(i).keySet())
////				optimizer.addToExpression(objFun, optimizer.prod(efficiencyConstants.get(i).get(j), xVariables.get(i).get(j)));	
//		
////		log.fine("Adding precedence bonuses to objective function");
////		for(int i : pVariables.keySet())
////		{
////			for(int j1 : pVariables.get(i).keySet())
////				for(int j2 : pVariables.get(i).get(j1).keySet())
////					optimizer.addToExpression(objFun, optimizer.prod(precedenceConstants.get(j1).get(j2), pVariables.get(i).get(j1).get(j2)));
////			log.fine("Added precedence bonuses for i index"+i);
////		}
//		
////		log.fine("Adding merge bonuses to objective function");
////		for(int i1 : gammaVariables.keySet())
////			for(int i2 : gammaVariables.get(i1).keySet())
////				for(int j : gammaVariables.get(i1).get(i2).keySet())
////					optimizer.addToExpression(objFun, optimizer.prod(mergeBonusConstants.get(j), gammaVariables.get(i1).get(i2).get(j)));
//		
////		log.fine("Adding call graph enlargment bonuses to objective function");
////		for(int i1 : yVariables.keySet())
////			for(int i2 : yVariables.get(i1).keySet())
////				for(int j : yVariables.get(i1).get(i2).keySet())
////					optimizer.addToExpression(objFun, optimizer.prod(callGraphConstants.get(i1).get(i2), yVariables.get(i1).get(i2).get(j)));
//		
//		log.fine("Objective function generated");
//	}
	
	/**
	 * Generates the overhead constraints.
	 * @throws OptimizerException 
	 */
	public void generateOverheadConstraints() throws OptimizerException
	{
		Object clientTimeOverhead = optimizer.addLeConstraint(optimizer.generateExpression(),maxClientTimeOverhead,"Client time overhead");
		Object serverTimeOverhead = optimizer.addLeConstraint(optimizer.generateExpression(),maxServerTimeOverhead,"Server time overhead");
		Object clientMemoryOverhead = optimizer.addLeConstraint(optimizer.generateExpression(),maxClientMemoryOverhead,"Client memory overhead");
		Object serverMemoryOverhead = optimizer.addLeConstraint(optimizer.generateExpression(),maxServerMemoryOverhead,"Server memory overhead");;
		Object networkOverhead = optimizer.addLeConstraint(optimizer.generateExpression(),maxNetworkOverhead,"Network overhead");
		
		Vector<Object> cTOParts = new Vector<>();
		Vector<Object> sTOParts = new Vector<>();
		Vector<Object> cMOParts = new Vector<>();
		Vector<Object> sMOParts = new Vector<>();
		Vector<Object> neOParts = new Vector<>();
		
		for(int i : xVariables.keySet())
		{
			Map<Integer, Object> xVariablesI = xVariables.get(i);
			Map<Integer, Double> clientTimeOverheadsI = clientTimeOverheads.get(i);
			Map<Integer, Double> serverTimeOverheadsI = clientTimeOverheads.get(i);
			Map<Integer, Double> clientMemoryOverheadsI = clientTimeOverheads.get(i);
			Map<Integer, Double> serverMemoryOverheadsI = clientTimeOverheads.get(i);
			Map<Integer, Double> networkOverheadsI = clientTimeOverheads.get(i);
			for(int j : xVariables.get(i).keySet())
			{
				cTOParts.addElement(optimizer.prod(clientTimeOverheadsI.get(j), xVariablesI.get(j)));
				sTOParts.addElement(optimizer.prod(serverTimeOverheadsI.get(j), xVariablesI.get(j)));
				cMOParts.addElement(optimizer.prod(clientMemoryOverheadsI.get(j), xVariablesI.get(j)));
				sMOParts.addElement(optimizer.prod(serverMemoryOverheadsI.get(j), xVariablesI.get(j)));
				neOParts.addElement(optimizer.prod(networkOverheadsI.get(j), xVariablesI.get(j)));
				//log.fine("Overhead constraints for indexes i-j +"+i+"-"+j+" generated");
			}
			//if(i%10 == 0) log.fine("Overhead constraints for code region "+i+" generated");
		}
		
		Object[] cTOPartsArray = new Object[cTOParts.size()];
		cTOPartsArray = cTOParts.toArray(cTOPartsArray);
		Object[] sTOPartsArray = new Object[sTOParts.size()];
		sTOPartsArray = cTOParts.toArray(sTOPartsArray);
		Object[] cMOPartsArray = new Object[cMOParts.size()];
		cMOPartsArray = cTOParts.toArray(cMOPartsArray);
		Object[] sMOPartsArray = new Object[sMOParts.size()];
		sMOPartsArray = cTOParts.toArray(sMOPartsArray);
		Object[] neOPartsArray = new Object[neOParts.size()];
		neOPartsArray = cTOParts.toArray(neOPartsArray);
		log.fine("Overhead constraints arrays generated");
		optimizer.addToExpression(clientTimeOverhead, optimizer.sum(cTOPartsArray));
		optimizer.addToExpression(serverTimeOverhead, optimizer.sum(sTOPartsArray));
		optimizer.addToExpression(clientMemoryOverhead, optimizer.sum(cMOPartsArray));
		optimizer.addToExpression(serverMemoryOverhead, optimizer.sum(sMOPartsArray));
		optimizer.addToExpression(networkOverhead, optimizer.sum(neOPartsArray));
	}
	
	/**
	 * Generates the constraints to ensure that the chosen precedences are relative to chosen protections.
	 * @throws OptimizerException 
	 */
	public void generatePrecedencesConstraints() throws OptimizerException
	{
		Vector<Object> constraints = new Vector<>();
		for(int i : pVariables.keySet())
		{
			Map<Integer, Map<Integer, Object>> pVariables_i = pVariables.get(i);
			Map<Integer, Object> xVariables_i = xVariables.get(i);
			for(int j1 : pVariables.get(i).keySet())
			{
				Map<Integer, Object> pVariables_i_j1 = pVariables_i.get(j1);
				Object xVariables_i_j1 = xVariables_i.get(j1);
				for(int j2: pVariables.get(i).get(j1).keySet())
					if(j1<j2) //Avoids to generate the same constraint for the inverse order j2-j1
					{
						int[] coeff = { -2, -2, 1 , 1 };
						Object[] vars = new Object[4];
						vars[0] = pVariables_i_j1.get(j2);
						vars[1] = pVariables_i.get(j2).get(j1);
						vars[2] = xVariables_i_j1;
						vars[3] = xVariables_i.get(j2);
						constraints.add(optimizer.createRangeConstraint(0.0, optimizer.scalProd(coeff, vars),	1.0, ""));
					}
//						constraints.add(
//									optimizer.addRangeConstraint(	0,
//										optimizer.sum(
//											optimizer.prod	(	-2,
//															optimizer.sum(	pVariables_i_j1.get(j2),
//																		pVariables_i.get(j2).get(j1))
//														),
//											xVariables_i_j1,
//											xVariables_i.get(j2)
//												)
//										, 1
//										, "Precedence constraint i="+i+" j1="+j1+" j2="+j2));
			//if(i%10 == 0) log.finer("Precedences contraints generated for code region "+i);
			}
		}
		Object[] constraintsArray = new Object[constraints.size()];
		constraintsArray = constraints.toArray(constraintsArray);
		optimizer.addConstraints(constraintsArray);
	}
	
	/**
	 * Generates the constraints to avoid cyclic precedences.
	 * @throws OptimizerException 
	 */
	public void generatePrecedencesAntiCycleConstraints() throws OptimizerException
	{
		//Vector<Object> constraints = new Vector<>();
		for(int i : pVariables.keySet())
		{
			Map<Integer, Map<Integer, Object>> pVariablesI = pVariables.get(i);
			for(int j1 : pVariables.get(i).keySet())
			{
				Map<Integer, Object> pVariablesIj1 = pVariablesI.get(j1);
				for(int j3: pVariablesIj1.keySet())
				{
					Object p_i_j1_j3 = pVariablesIj1.get(j3);
					for(int j2 : jIndexes.keySet())
					{
						Object p_i_j1_j2 = pVariablesIj1.get(j2);
						Object p_i_j2_j3 = pVariablesI.get(j2).get(j3);
						if(p_i_j2_j3==null || p_i_j1_j2==null) continue;
						//constraints.add(optimizer.createGeConstraint(optimizer.diff(p_i_j1_j3, optimizer.sum(p_i_j1_j2,p_i_j2_j3)), -1, "Precedences anti-cycle constraint i="+i+" j1="+j1+" j2="+j2+" j3="+j3));
						optimizer.addGeConstraint(optimizer.diff(p_i_j1_j3, optimizer.sum(p_i_j1_j2,p_i_j2_j3)), -1.0, "Precedences anti-cycle constraint i="+i+" j1="+j1+" j2="+j2+" j3="+j3);
					}
				}
			}
//			if(Runtime.getRuntime().freeMemory() < (1073741824*2))
//			{
//				Object[] constraintsArray = new Object[constraints.size()];
//				constraintsArray = constraints.toArray(constraintsArray);
//				constraints = new Vector<>();
//				optimizer.addConstraints(constraintsArray);
//				constraintsArray = null;
//				//System.gc();
//			}
			//if(i%10 == 0) log.finer("Precedences anti-cycle constraints generated for code region "+i);
		}
//		if(constraints.size()>0)
//		{
//			Object[] constraintsArray = new Object[constraints.size()];
//			constraintsArray = constraints.toArray(constraintsArray);
//			constraints = null;
//			optimizer.addConstraints(constraintsArray);
//			constraintsArray = null;
//		}
	}
	
	/**
	 * Generates the constraints for ensuring correct merges.
	 * @throws OptimizerException 
	 */
	public void generateMergeConstraints() throws OptimizerException
	{
		//int c = 0;
		log.fine("Generating merge constraints for "+gammaVariables.keySet().size()+" i variables");
		Vector<Object> constraints = new Vector<>();
		for(int i1 : gammaVariables.keySet())
		{
			for(int i2 : gammaVariables.get(i1).keySet())
				for(int j: gammaVariables.get(i1).get(i2).keySet())
				{	
					optimizer.addLeConstraint(gammaVariables.get(i1).get(i2).get(j), optimizer.sum(optimizer.prod(0.5, xVariables.get(i1).get(j)),optimizer.prod(0.5, xVariables.get(i2).get(j))),
							"Merge first constraint i1="+i1+" i2="+i2+" j="+j);
					for(int j2 : jIndexes.keySet())
					{
						try
						{
							Object cause = optimizer.and(optimizer.createEqConstraint(gammaVariables.get(i1).get(i2).get(j),1.0,""),
															optimizer.createEqConstraint(pVariables.get(i1).get(j).get(j2),1.0,""),"");
							Object effect = optimizer.and(optimizer.createEqConstraint(gammaVariables.get(i1).get(i2).get(j2),1.0,""),
															 optimizer.createEqConstraint(pVariables.get(i2).get(j).get(j2),1.0,""),"");
							Object ifThen = optimizer.ifThen(cause, effect, "Merge second constraint i1="+i1+" i2="+i2+" j="+j+" j2="+j2);
							constraints.add(ifThen);
						}
						catch(NullPointerException e)
						{
							continue;
						}
					}
				}
			//if(c%10 == 0) log.finer("Merge contraints generated for code region "+c);
			//c++;
		}
		Object[] constraintsArray = new Object[constraints.size()];
		constraintsArray = constraints.toArray(constraintsArray);
		optimizer.addConstraints(constraintsArray);
	}
	
	/**
	 * Generates the constraints for ensuring the respect of the containment relationships between application parts.
	 */
	public void generateContainmentContraints() throws OptimizerException
	{
		Vector<Object> constraints = new Vector<>();
		for(int i : xVariables.keySet())
		{
			if(!iIndexes.get(i).getApplicationParts().isEmpty())
				for(int j : xVariables.get(i).keySet())
				{
//					Object expr = optimizer.generateExpression();
					LinkedList<Object> gammas = new LinkedList<>();
					int counter = 0;
					int extContainedPart = -1;
					try
					{	
						for(ApplicationPart containedPart : iIndexes.get(i).getApplicationParts())
							if(containedPart.getType().equals(ApplicationPartType.CODE_REGION) && !appPartSkipped.contains(containedPart))
							{
								counter++;
								int i1 = appPartToiIndexes.get(containedPart);
								if(extContainedPart==-1) extContainedPart=i1;
								if(gammaVariables.get(i1)==null) continue;
								for(int i2 : gammaVariables.get(i1).keySet())
									gammas.add(gammaVariables.get(i1).get(i2).get(j));
//								{
//										Object temp = optimizer.sum(expr, gammaVariables.get(i1).get(i2).get(j));
//										expr = temp;
//										counter++;
//								}
							}
					}
					catch(NullPointerException e)
					{
						continue; //if the prot inst j can't be applied to all the contained parts, it can't be applied to the father part
					}
					if(counter==0) continue; //if the father part contains only data
					else if(counter==1)
						constraints.add(optimizer.createLeConstraint(xVariables.get(i).get(j), xVariables.get(extContainedPart).get(j), "Containment constraint i="+i+" j="+j));
					else
					{
						Object[] gammasVector = new Object[gammas.size()];
						gammasVector = gammas.toArray(gammasVector);
						Object gammasSum = optimizer.sum(gammasVector);
						constraints.add(optimizer.createLeConstraint(optimizer.prod(gammasVector.length, xVariables.get(i).get(j)), gammasSum, "Containment constraint i="+i+" j="+j));
					}
				}
			//if(i%10 == 0) log.finer("Containment contraints generated for code region "+i);
		}
		Object[] constraintsArray = new Object[constraints.size()];
		constraintsArray = constraints.toArray(constraintsArray);
		optimizer.addConstraints(constraintsArray);
	}
	
	/**
	 * Generates the contraints for ensuring that the precedences between prot insts are the same in the father part and in the contained ones. 
	 */
	public void generateContainmentPrecedenceConstraints() throws OptimizerException
	{
		Vector<Object> constraints = new Vector<>();
		for(int i1 : pVariables.keySet())
		{
			if(!iIndexes.get(i1).getApplicationParts().isEmpty())
			{
				//Find the first code part contained in i1
				ApplicationPart containedPart = null;
				for(ApplicationPart containedPart2 : iIndexes.get(i1).getApplicationParts())
					if(containedPart2.getType().equals(ApplicationPartType.CODE_REGION))
					{
						containedPart=containedPart2;
						break;
					}
				if(containedPart==null) continue;
				if(appPartSkipped.contains(containedPart)) continue;
				int i2 = appPartToiIndexes.get(containedPart);
				
				for(int j1 : pVariables.get(i1).keySet())
					for(int j2: pVariables.get(i1).get(j1).keySet())
					{
						try
						{
							Object p_i1_j1_j2 = pVariables.get(i1).get(j1).get(j2);
							Object p_i2_j1_j2 = pVariables.get(i2).get(j1).get(j2);
							if(p_i2_j1_j2!=null)
							{
								constraints.add(optimizer.createLeConstraint(p_i1_j1_j2, p_i2_j1_j2, "Containment precedence constraint i1="+i1+" i2="+i2+" j1="+j1+" j2="+j2));
							}
						}
						catch(NullPointerException e)
						{
							//Do nothing
						}
					}
			}
			//if(i1%10 == 0) log.finer("Containment precedence contraints generated for code region "+i1);
		}
		Object[] constraintsArray = new Object[constraints.size()];
		constraintsArray = constraints.toArray(constraintsArray);
		optimizer.addConstraints(constraintsArray);
	}
	
	/**
	 * Generates the contraints to ensure that the j indexes relative to the same prot inst are used in ascending order.
	 * @throws OptimizerException
	 */
	public void generateSameProtectionInstantiationJindexesContraints() throws OptimizerException
	{
		Vector<Object> constraints = new Vector<>();
		for(ProtectionInstantiation pi : protInstTojIndexes.keySet())
			//if(protInstTojIndexes.keySet().size() > 1)
				for(int j1 : protInstTojIndexes.get(pi))
				{
					for(int j2 : protInstTojIndexes.get(pi))
						if(j1<j2)
							for(int i : xVariables.keySet())
							{
								try
								{
									constraints.add(optimizer.createLeConstraint(xVariables.get(i).get(j2), xVariables.get(i).get(j1), "Same protection instantiation j indexes le constraint i="+i+" j1="+j1+" j2="+j2));
									constraints.add(optimizer.createEqConstraint(pVariables.get(i).get(j2).get(j1), 0.0, "Same protection instantiation j indexes eq constraint i="+i+" j1="+j1+" j2="+j2));
								}
								catch(NullPointerException e)
								{
									//Do nothing
								}
							}
					//if(j1%10 == 0) log.finer("Same protection instantiation j indexes contraints generated for code region "+j1);
				}
		Object[] constraintsArray = new Object[constraints.size()];
		constraintsArray = constraints.toArray(constraintsArray);
		optimizer.addConstraints(constraintsArray);
	}
	
	//Generates the contraints ensuring that the y variables are active if and only if both the relative x variables are active.
	public void generateYvariablesContraints() throws OptimizerException
	{
		Vector<Object> constraints = new Vector<>();
		for(int i1 : yVariables.keySet())
		{
			for(int i2 : yVariables.get(i1).keySet())
				for(int j : yVariables.get(i1).get(i2).keySet())
					constraints.add(
							optimizer.createRangeConstraint(0.0,
										optimizer.sum(
													optimizer.prod(-2, yVariables.get(i1).get(i2).get(j)),
													optimizer.sum(xVariables.get(i1).get(j),
														xVariables.get(i2).get(j))),
										1.0,
										"Y variable constraint i1="+i1+" i2="+i2+" j="+j));
			//if(i1%10 == 0) log.finer("Y variables contraints generated for code region "+i1);
		}
		Object[] constraintsArray = new Object[constraints.size()];
		constraintsArray = constraints.toArray(constraintsArray);
		optimizer.addConstraints(constraintsArray);
	}
	
	/**
	 * Generates variables and bonus costants for the enlargment of l1p protections through the call graph.
	 * @throws Exception 
	 */
	public void generateCallGraphEnlargment() throws Exception
	{
		Vector<Object> objFunParts = new Vector<>();
		
		//Generate the application part caller-callee map
		Map<Integer,Integer> callsIindex = new HashMap<>();
		for(ApplicationPart caller : adss.getModel().getAllApplicationParts())
			if(caller.getType().equals(ApplicationPartType.CODE_REGION) && caller.isInSystemFile())
			{
				for(UseTarget target : caller.getUses())
				{
					if(target.getType().equals(UseType.CALLS) && target.getTarget().getType().equals(ApplicationPartType.CODE_REGION) && !target.getTarget().isInSystemFile())
					{
						ApplicationPart callee = target.getTarget();
						callsIindex.put(appPartToiIndexes.get(caller), appPartToiIndexes.get(callee));
					}
				}
			}
		
//		for(String file : calls.keySet())
//		{
//			for(Integer row: calls.get(file).keySet())
//				for(Map.Entry<String,ApplicationPart> entry : calls.get(file).get(row))
//					if(entry.getKey().equals("calls"))
//					{
//						ApplicationPart callee = entry.getValue();
//						ApplicationPart caller = null;
//						for(ApplicationPart part: adss.getModel().getAllApplicationParts())
//							if(part.isCode())
//							{
//								if(part.getSourceFilePath().equals(file) && part.getStartLine()<=row && part.getEndLine()>=row)
//								{
//									if(caller==null)
//									{
//										caller=part;
//										break;
//									}
//									else
//									{
//										int callerLength = caller.getEndLine()-caller.getStartLine()+1;
//										int partLength = part.getEndLine()-part.getStartLine()+1;
//										if(partLength<callerLength)
//										{
//											caller=part;
//											break;
//										}
//									}
//								}
//							}
//						if(caller==null) throw new Exception("Error during generation of call graph enlargment: cannot find caller application part for "+file+"@"+row+" call to function "+callee.getName()+"@"+callee.getSourceFilePath());
//						callsIindex.put(appPartToiIndexes.get(caller), appPartToiIndexes.get(callee));
//					}
//		}
		
		for(int caller : callsIindex.keySet())
		{
			int callee = callsIindex.get(caller);
			Map<Integer, Map<Integer, Object>> map = yVariables.get(caller);
			if(map==null)
			{
				map = new HashMap<>();
				yVariables.put(caller, map);
			}
			Map<Integer, Object> map2 = map.get(callee);
			if(map2==null)
			{
				map2 = new HashMap<>();
				map.put(callee, map2);
			}
			
			Map<Integer,Double> map3 = callGraphConstants.get(caller);
			if(map3==null)
			{
				map3 = new HashMap<>();
				callGraphConstants.put(caller, map3);
			}
			//TODO decide the call graph enlargment bonus constants (e.g. only for l1p protections?)
			//TODO cambaire mappa constanti call graph, aggiungere prot inst, magari solo quelle > 0 così non si creano y variable inutili
			//TODO enlargment call stack solo per l1p, bonus decrescente fino a un max di nodi nel call graph fissato come parametro
//			String piName = jIndexes.get(j).getName();
//			String protName = jIndexes.get(j).getProtection().getName();
//			
//			Double bonus = 0.0;
////			if(protName.equals("binary code control flow obfuscation"))
////				bonus = 1.0;
////			else if(protName.equals("call stack checks"))
////				bonus = 1.0;
////			else if(protName.equals("anti-debugging"))
////				bonus = 1.0;
////			else if(protName.equals("soft VM"))
////				bonus = 0.5;
			map3.put(callee, 0.0);
			
			//Generate the y(i1.i2.j) variables, that state that the protection instantiation j has been applied both to application parts i1 and i2, where i1 contains a call site to i2
			for(int j : jIndexes.keySet())
				if(xVariables.get(caller).get(j)!=null && xVariables.get(callee).get(j)!=null)
				{
					Object yVariable = optimizer.generateBooleanVariable("y("+caller+"."+callee+"."+j+")");
					objFunParts.add(optimizer.prod(callGraphConstants.get(caller).get(callee), yVariable));
					map2.put(j, yVariable);
				}
		}
		Object[] objFunPartsArray = new Object[objFunParts.size()];
		objFunPartsArray = objFunParts.toArray(objFunPartsArray);
		optimizer.addToExpression(objFun, optimizer.sum(objFunPartsArray));
	}
	
	/**
	 * Generates merge bonus constants, different for every protection instantiation.
	 */
	public void generateMergeBonusConstants()
	{
		for(int j : jIndexes.keySet())
		{
			Double bonus = 0.0;
			//String piName = jIndexes.get(j).getName();
			String protName = jIndexes.get(j).getProtection().getName();
			
			if(protName.equals("binary code control flow obfuscation"))
				bonus = 1.0;
			else if(protName.equals("call stack checks"))
				bonus = 1.0;
			else if(protName.equals("anti-debugging"))
				bonus = 1.0;
			else if(protName.equals("soft VM"))
				bonus = 0.5;
			
			mergeBonusConstants.put(j, bonus);
			//TODO ask protection owners merge bonus constants
		}
	}
	
	/**
	 * Generates the efficiency bonus for every x variable.
	 */
	
	/**
	 * Generates the efficiency bonus for the selected x variable.
	 * @param i the i index.
	 * @param j the j index.
	 * @return the efficency bonus.
	 */
	public Double generateEfficiencyBonusConstants(int i, int j)
	{
		//TODO ask protection owners efficiency formulas
		Double efficiency = 1.0;
		//if(i==323) efficiency = 1000.0;
		String piName = jIndexes.get(j).getName();
		String protName = jIndexes.get(j).getProtection().getName();
		
		if(protName.equals("binary code control flow obfuscation"))
		{
			if(piName.contains("low overhead")) efficiency = 1.0;
			else efficiency = 0.0;
		}
		else if(protName.equals("call stack checks"))
			efficiency = 1.0;
		else if(protName.equals("anti-debugging"))
			efficiency = 1.0;
		else if(protName.equals("soft VM"))
			efficiency = 2.0;
		else efficiency = 0.0;
		
		Map<Integer,Double> map = efficiencyConstants.get(i);
		if(map==null)
		{
			map = new HashMap<>();
			efficiencyConstants.put(i, map);
		}
		map.put(j, efficiency);
		
		return efficiency;
	}
	
	/**
	 * Generates precedence bonus constants for every pair of j indexes.
	 */
	public void generatePrecedenceBonusConstants()
	{
		for(int j1 : jIndexes.keySet())
		{
			Map<Integer,Double> map = new HashMap<>();
			precedenceConstants.put(j1, map);
			for(int j2 : jIndexes.keySet())
			{
				Protection p1 = jIndexes.get(j1).getProtection();
				Protection p2 = jIndexes.get(j2).getProtection();
				if(p2.getDiscouragedPrecedences().contains(p1))
					map.put(j2, -1.0);
				else if(p2.getEncouragedPrecedences().contains(p1))
					map.put(j2, 1.0);
				else map.put(j2, 0.0);
			}
		}
	}
	
	/**
	 * Generates overhead constants for every x variable; for x variables relating to "external" code regions, the overhead is set to 0, in order to not count multiple time the overheads.
	 */
	public void generateOverheadConstants()
	{
		for(Integer i : iIndexes.keySet())
//			if(part.getType().equals(ApplicationPartType.CODE_REGION))
			{
//				int i = appPartToiIndexes.get(part);
				Map<Integer,Double> ctMap = new HashMap<>();
				Map<Integer,Double> cmMap = new HashMap<>();
				Map<Integer,Double> stMap = new HashMap<>();
				Map<Integer,Double> smMap = new HashMap<>();
				Map<Integer,Double> neMap = new HashMap<>();
				clientTimeOverheads.put(i, ctMap);
				serverTimeOverheads.put(i, cmMap);
				clientMemoryOverheads.put(i, stMap);
				serverMemoryOverheads.put(i, smMap);
				networkOverheads.put(i, neMap);
				for(int j : xVariables.get(i).keySet())
				{
					boolean containsCode = false;
					ApplicationPart part = iIndexes.get(i);
					for(ApplicationPart innerPart : part.getApplicationParts())
						if(innerPart.getType().equals(ApplicationPartType.CODE_REGION) && !iSkipped.contains(appPartToiIndexes.get(innerPart)))
						{
							containsCode = true;
							break;
						}
					
					if(containsCode)
					{
						ctMap.put(j,0.0);
						stMap.put(j,0.0);
						cmMap.put(j,0.0);
						smMap.put(j,0.0);
						neMap.put(j,0.0);
					}
					else
					{
						ctMap.put(j,1.0);
						stMap.put(j,1.0);
						cmMap.put(j,1.0);
						smMap.put(j,1.0);
						neMap.put(j,1.0);
						//TODO calcolare i veri overhead con le formule delle pi
						//TODO si può provare a iniettare le formule in cplex al posto di calcolare le costanti
					}
				}
			}
	}
	
	
	/**
	 * Generate the gamma variables, for merging protection instantiations applied to contiguous regions.
	 * @param root Present for recursion purposes, pass null for complete generation.
	 * @throws OptimizerException 
	 */
	public void generateGammaVariables(ApplicationPart root) throws OptimizerException
	{
		ApplicationPart previousPart = null;
		List<ApplicationPart> list = null;
		if(root==null) list = adss.getModel().getApplicationParts();
		else list = root.getApplicationParts();
		Vector<Object> objFunParts = new Vector<>();
		for(ApplicationPart part : list)
		{
			if(!part.isCode() || !part.isInSystemFile()) continue;
			if(appPartSkipped.contains(part)) return;
			//At the first level of the application parts tree there are the function application parts, and merge is applied only for contiguous parts in the same function.
			generateGammaVariables(part);
			if(root!=null)
			{	
				if(previousPart==null)
				{
					previousPart=part;
					continue;
				}
				int i1 = appPartToiIndexes.get(previousPart);
				int i2 = appPartToiIndexes.get(part);
				Map<Integer, Map<Integer, Object>> gammaMap = gammaVariables.get(i1);
				if(gammaMap==null)
				{
					gammaMap = new HashMap<Integer, Map<Integer, Object>>();
					gammaVariables.put(i1, gammaMap);
				}
				Map<Integer, Object> gammaMap2 = gammaVariables.get(i1).get(i2);
				if(gammaMap2==null)
				{
					gammaMap2 = new HashMap<Integer, Object>();
					gammaMap.put(i2, gammaMap2);
				}
				for(Integer j : jIndexes.keySet())
					if(xVariables.get(i1).keySet().contains(j) && xVariables.get(i2).keySet().contains(j))
					{
						Object gamma = optimizer.generateBooleanVariable("gamma("+i1+"."+i2+"."+j+")");
						gammaMap2.put(j, gamma);
						Double mergeBonusConstant = mergeBonusConstants.get(j);
						objFunParts.add(optimizer.prod(mergeBonusConstant, gamma));
					}
			}
			previousPart=part;
		}
		Object[] objFunPartsVector = new Object[objFunParts.size()];
		objFunPartsVector = objFunParts.toArray(objFunPartsVector);
		Object objFunPartsSum = optimizer.sum(objFunPartsVector);
		optimizer.addToExpression(objFun, objFunPartsSum);
	}
	
	/**
	 * Generates the p(i.j1.j2) variables, which state the precedence in the application of the protection instantiations j1 and j2 on
	 * the i application part. If p(i.j1.j2)=1, j1 is applied before j2, and p(i.j2.j1)=0. If both p(i.j1.j2) and p(i.j2.j1) are =0, at least
	 * one of the two protection instantiations are not applied to the application part i.
	 * For the annotated code regions, all the protection instantiations that are added by the second level protection finder must be
	 * subsequent of the first level protections, so the p variables are set accordingly.
	 * @throws OptimizerException 
	 */
	public void generatePvariables() throws OptimizerException
	{
		Vector<Object> constraints = new Vector<>();
		Vector<Object> objFunParts = new Vector<>();
		
		for(Integer i : xVariables.keySet())
		{
			//If needed, create the sub-map for the j indexes couples relative to the i index
			Map<Integer,Map<Integer,Object>> map = pVariables.get(i);
			if(map==null)
			{
				map = new HashMap<>();
				pVariables.put(i, map);
			}
			
			//Create the p variables
			for(Integer j1 : xVariables.get(i).keySet())
			{
				Map<Integer,Object> map2 = pVariables.get(i).get(j1);
				if(map2==null)
				{
					map2 = new HashMap<>();
					map.put(j1, map2);
				}
				Protection pj1 = jIndexes.get(j1).getProtection();
				Map<Integer, Double> j1_precedenceConstants = precedenceConstants.get(j1);
				for(Integer j2 : xVariables.get(i).keySet())
				{
					if(j1==j2) continue; //Check that the two indexes are different
					Object p = optimizer.generateBooleanVariable("p("+i+"."+j1+"."+j2+")");
					map2.put(j2, p);
					
					//If the p variable corresponds to an impossible order (forbidden precedences), fix it to 0
					Protection pj2 = jIndexes.get(j2).getProtection();
					EList<Protection> pj2_forbiddenPrecedences = pj2.getForbiddenPrecedences();
					if(pj2_forbiddenPrecedences.contains(pj1))
						constraints.add(optimizer.createEqConstraint(p,0.0, "P=0 first constraint i="+i+" j1="+j1+" j2="+j2));
					
					objFunParts.add(optimizer.prod(j1_precedenceConstants.get(j2), p));
				}
			}
			
			//Set the p variables according to the first level solution
			int index = 0;
			if(firstLevelProtectionInstantiations.get(i)!=null)
				for(Integer l1p : firstLevelProtectionInstantiations.get(i))
				{
					List<Integer> nextL1protections = firstLevelProtectionInstantiations.get(i).subList(++index, firstLevelProtectionInstantiations.get(i).size());
					//Set the precedences between first level protections, according to the first level solution
					for(Integer nextl1p : nextL1protections)
					{
						constraints.add(optimizer.createEqConstraint(map.get(l1p).get(nextl1p),1.0, "P=1 constraint i="+i+" j1="+l1p+" j2="+nextl1p));
						constraints.add(optimizer.createEqConstraint(map.get(nextl1p).get(l1p),0.0, "P=0 second constraint i="+i+" j1="+l1p+" j2="+nextl1p));
					}
					//Set the precedences so that second level protections must came after first level one
					Set<Integer> l2protections = xVariables.get(i).keySet();
					for(Integer l2p : l2protections)
						if(!firstLevelProtectionInstantiations.get(i).contains(l2p))
							constraints.add(optimizer.createEqConstraint(map.get(l2p).get(l1p),0.0, "P=0 third constraint i="+i+" j1="+l2p+" j2="+l1p));
				}
		}
		log.fine("P variables and constraints generated");
		Object[] contraintsArray = new Object[constraints.size()];
		contraintsArray = (Object[]) constraints.toArray(contraintsArray);
		log.fine("P variables and constraints array generated");
		optimizer.addConstraints(contraintsArray);
		log.fine("P variables and constraints added to model");
		Object[] objFunPartsArray = new Object[objFunParts.size()];
		objFunPartsArray = objFunParts.toArray(objFunPartsArray);
		log.fine("P variables objective function parts array generated");
		optimizer.addToExpression(objFun, optimizer.sum(objFunPartsArray));
		log.fine("P variables objective function parts added to objective function");
		
		//TODO if ACTC fixed order enabled, fix the p variables accordingly
	}
	
	/**
	 * Generates the x(i.j) variables, which state how many times the protection instantiation j must be applied to the application part i.
	 * The x variables regarding the code regions protected by first level protection are fixed with the corresponding value;
	 * also they are only generated for j indexes corresponding to protections that are not in the forbidden precedences of 
	 * the first level protection instantiations applied to the application part.
	 * For singleton protections, for every couple application part - protection is generated a SOS1 so that only 
	 * one protection instantiation of the same singleton protection can be applied to an application part. 
	 * @throws OptimizerException if something goes wrong with the invocation of optimizer.
	 */
	public void generateXvariables() throws OptimizerException
	{
		for(Integer i : iIndexes.keySet())
		{
			//If needed, create the sub-map for the j indexes relative to the i index
			Map<Integer,Object> map2 = xVariables.get(i);
			if(map2==null)
			{
				map2 = new HashMap<>();
				xVariables.put(i, map2);
			}
			
			//Find the forbidden precedences of the first level protection instantiation applied to this application part
			Set<ProtectionInstantiation> forbiddenPrecedences = new HashSet<>();
			if(firstLevelProtectionInstantiations.get(i)!=null)
				for(Integer j : firstLevelProtectionInstantiations.get(i))
				{
					ProtectionInstantiation pi = jIndexes.get(j);
					for(Protection p : pi.getProtection().getForbiddenPrecedences())
						forbiddenPrecedences.addAll(p.getInstantiations());
				}
			
			//Create x variables
			for(Integer j : jIndexes.keySet())
			{
				Object x = null;
				if(firstLevelProtectionInstantiations.get(i)!=null && firstLevelProtectionInstantiations.get(i).contains(j))
				{
					//Create and fix to 1 the variables relative to the first level protection instantiations
					x = optimizer.generateBooleanVariable("x("+i+"."+j+")");
					map2.put(j, x);
					optimizer.addEqConstraint(x, 1.0, "X=1 constraint i="+i+" j="+j);
					continue;
				}
				else if(!forbiddenPrecedences.contains(protInstTojIndexes.get(j)))
				{
					//Create the other variables, unless they are relative to a first level protection forbidden precedence
					x = optimizer.generateBooleanVariable("x("+i+"."+j+")");
					map2.put(j, x);
				}
				
				if(x!=null)
				{
					Double efficiency = null;
					Map<Integer, Double> map = efficiencyConstants.get(i);
					if(map!=null)
						efficiency = map.get(j);
					if(efficiency == null) efficiency = generateEfficiencyBonusConstants(i, j);
					optimizer.addToExpression(objFun, optimizer.prod(efficiency, x));
				}
			}
			
			//Create the SOS1 for the singleton protections
			for(Protection p : protTojIndexes.keySet())
				if(p.isSingleton())
				{
					List<Object> xVars = new LinkedList<>();
					for(Integer pi : protTojIndexes.get(p))
					{
						Object xVariable = xVariables.get(i).get(pi);
						if(xVariable!=null)
							xVars.add(xVariable);
					}
					if(xVars.size()>1)
					{
						Object[] xVars2 = new Object[xVars.size()];
						double[] weights = new double[xVars.size()];
						int c=0;
						//TODO vedere se i pesi hanno qualche effetto sulla f.o.
						double weight = 0;
						for(Object xVar : xVars)
						{
							xVars2[c] = xVar;
							weight+=0.01;
							weights[c++] = weight;
						}
						optimizer.addSOS1(xVars2, weights, "SOS1 for protection "+p.getName());
					}
				}
		}
	}
	
	public Set<Integer> findiIndexOfContainedParts(int father)
	{
		Set<Integer> set = new HashSet<>();
		set.add(father);
		ApplicationPart fatherPart = iIndexes.get(father);
		for(ApplicationPart sonPart : fatherPart.getApplicationParts())
		{
			if(sonPart.isCode())
			{
				Integer son = appPartToiIndexes.get(sonPart);
				set.add(appPartToiIndexes.get(sonPart));
				set.addAll(findiIndexOfContainedParts(son));
			}
		}
		return set;
	}
	
	
	/**
	 * Creates an intermediate representation of the first level solution used for inserting the latter in the lp model.
	 * @throws Exception 
	 */
	public void generateFirstLevelSolutionMap(Solution solution) throws Exception
	{
		HashSet<ProtectionInstantiation> firstLevelJindex = new HashSet<>();
		
		for(SolutionSequence solutionSequence : solution.getSolutionSequences())
		{
			for(AppliedProtectionInstantiation api : solutionSequence.getAppliedProtectionInstantiations())
			{
				if(!api.getProtectionInstantiation().getProtection().getApplicationPartTypes().contains(ApplicationPartType.CODE_REGION))
					continue;
				firstLevelJindex.add(api.getProtectionInstantiation());
				//Find the i index relative to the application part to which the protection instantiation is applied
//				Integer iIndex = appPartToiIndexes.get(api.getApplicationPart());
				Integer iIndex = -1;
				for(Entry<Integer, ApplicationPart> e : iIndexes.entrySet())
				{
					if(e.getValue().equals(api.getApplicationPart()))
					{
						iIndex = e.getKey();
						break;
					}
				}
				if(iIndex==-1) throw new Exception("Error in the generation of the first level solution map: unknown application part "+api.getApplicationPart().getName()+" in compilation unit "+api.getApplicationPart().getSourceFilePath());
				
				//Find the list of j indexes relative to the protection instantiations applied to the i index relative application part, if not found create and insert it in the map
//				for(Integer i : findiIndexOfContainedParts(iIndex))
//				{
					List<Integer> protectionInstantiations = firstLevelProtectionInstantiations.get(iIndex);
					if(protectionInstantiations==null)
					{
						protectionInstantiations = new LinkedList<Integer>();
						firstLevelProtectionInstantiations.put(iIndex,protectionInstantiations);
					}
//				}
				
				//Find the j indexes relative to the protection instantiation, and insert the first non used j index in the list
				int jIndex = -1;
				Integer[] jIndexes = protInstTojIndexes.get(api.getProtectionInstantiation());
				if(jIndexes==null) throw new Exception("Error in the generation of the first level solution map: unknown protection instantiation "+api.getProtectionInstantiation().getName());
				for(Integer j : jIndexes)
					if(!protectionInstantiations.contains(j))
					{
						jIndex=j;
						break;
					}
				if(jIndex==-1) throw new Exception("Error in the generation of the first level solution map: the protection instantiation "+api.getProtectionInstantiation().getName()+" has been applied too many times to the application part "+api.getApplicationPart().getName()+" in compilation unit "+api.getApplicationPart().getSourceFilePath()+"; try to use an higher upper bound.");
				protectionInstantiations.add(jIndex);
			}
		}
		
		boolean firstLevelHasBinaryObfuscation=false;
		for(ProtectionInstantiation pi : jIndexes.values())
		{
			String protectionName = pi.getProtection().getName();
			if(protectionName.equals("binary code control flow obfuscation"))
			{
				firstLevelHasBinaryObfuscation=true;
				break;
			}
		}
		
		HashSet<Integer> jIndexesToRemove = new HashSet<>();
		HashSet<ProtectionInstantiation> piToRemove = new HashSet<>();
		for(int j : jIndexes.keySet())
			if(!firstLevelJindex.contains(jIndexes.get(j)))
			{
				if(firstLevelHasBinaryObfuscation &&
					jIndexes.get(j).getProtection().getName().equals("binary code control flow obfuscation") &&
					jIndexes.get(j).getName().contains("low overhead"))
						continue;
				jIndexesToRemove.add(j);
				piToRemove.add(jIndexes.get(j));
			}
		for(int j : jIndexesToRemove)
			jIndexes.remove(j);
		for( ProtectionInstantiation pi : piToRemove)
			protInstTojIndexes.remove(pi);
		
		//Skip applied protection instantiations on code regions contained in l1p protected father code regions
//		Set<Integer> iToBeRemoved = new HashSet<>();
		for(Integer fatherI : firstLevelProtectionInstantiations.keySet())
		{
			for(Integer sonI : firstLevelProtectionInstantiations.keySet())
			{
				ApplicationPart father = iIndexes.get(fatherI);
				Set<Integer> childs = findiIndexOfContainedParts(fatherI);
				childs.remove(father);
				if(fatherI!=sonI)
				{
					ApplicationPart son = iIndexes.get(sonI);
					if(childs.contains(sonI))
					{
						iSkipped.add(sonI);
						appPartSkipped.add(son);
					}
				}
			}
		}
		
		for(int i : iSkipped)
		{
			firstLevelProtectionInstantiations.remove(i);
			iIndexes.remove(i);
		}
		for(ApplicationPart part : appPartSkipped)
			appPartToiIndexes.remove(part);
	}
	
	/**
	 * Generates the mapping between the i indexes of the lp model and the application parts.
	 */
	public int generateIindexes(ApplicationPart root, Integer i)
	{
		/** The mapping between the x value and the relative application parts. **/
		List<ApplicationPart> list = null;
		if(root==null) list=adss.getModel().getApplicationParts();
		else
		{	
			list=root.getApplicationParts();
			ECollections.sort(root.getApplicationParts(), new Comparator<ApplicationPart>() {
	
				@Override
		         public int compare(ApplicationPart ap1, ApplicationPart ap2) {
					 if(ap1.isCode() && ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
						return ap1.getStartLine()-ap2.getStartLine();
					 else if(!ap1.isCode() && ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
					 	return -1;
					 else if(ap1.isCode() && !ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
					 	return +1;
					 else
						return 0;
	//					 return ap2.getStartLine()-ap1.getStartLine();
				 }
			});
		}
		
		for(ApplicationPart part : list)
			if(part.isCode() && !part.isInSystemFile())
			{
				if(part.getType().equals(ApplicationPartType.CODE_REGION))
				{
					appPartToiIndexes.put(part, i);
					iIndexes.put(i++, part);
				}
				i = generateIindexes(part, i);
			}
		return i;
	}
	
	/**
	 * Generates the mapping between the j indexes of the lp model and the protection instantiation.
	 */
	public void generateJindexes()
	{
		int j=0;
		for(Protection protection : adss.getModel().getProtections())
		{
			List<Integer> bigList = new LinkedList<>();
			for(ProtectionInstantiation protInst : protection.getInstantiations())
			{
				int newUpperBound = adss.getModel().getPreferences().getL2pUpperBound();
				if(protection.isSingleton()) newUpperBound=1;
				Integer[] list = new Integer[newUpperBound];
				for(int k=0; k<newUpperBound; k++)
				{
					jIndexes.put(j, protInst);
					bigList.add(j);
					list[k]=j++;
				}
				protInstTojIndexes.put(protInst, list);
			}
			Integer[] bigArray = new Integer[1]; 
			bigArray = bigList.toArray(bigArray);
			protTojIndexes.put(protection,bigArray);
		}
	}
	
//	/**
//	 * Generates the mapping between protections and the j indexes of the relative protection instantiations.
//	 */
//	public void generateProtectionMap()
//	{
//		for(Protection p : adss.getModel().getProtections())
//		{
//			Integer protInsts[] = new Integer[p.getInstantiations().size()*upperBound];
//			protTojIndexes.put(p,protInsts);
//			int i=0;
//			for(ProtectionInstantiation pi : p.getInstantiations())
//				for(Integer j : protInstTojIndexes.get(pi))
//					protInsts[i++]=j;
//		}
//	}
	
	/** 
	 * Finds the code regions for which the second level protections will be inferred, and add them into the internal model as application parts.
	 * @param depthLevel
	 * 				The maximum level of nested code blocks to analyze, -1 for no limit.
	 * @return The code regions.
	 * 
	 **/
	public List<ApplicationPart> findCodeRegions(Integer depthLevel)
	{
		List<ApplicationPart> retValue = new LinkedList<ApplicationPart>();
		
//		//Find all compilation units
//		Set<String> files = new HashSet<String>();
//		for(ApplicationPart part : adss.getModel().getApplicationParts())
//			files.add(part.getSourceFilePath());
//		
//		Random seedRandom = new Random();
//		long seed = seedRandom.nextLong();
		
		//Find code blocks in every compilation unit
		for(ApplicationPart function : adss.getModel().getApplicationParts())
			if(function.isCode() && !function.isInSystemFile())
				analyzeCodeBlock(function.getBody(), function, 0);
		
//		CDTConnector connector = new CDTConnector(adss);
//		for(String file : files)
//		{
//			Map<String, CodeBlock> codeBlocks = new HashMap<>();
//			try {
//				codeBlocks.putAll(connector.parseCodeBlocks(file));
//			} catch (CoreException e) {
//				log.severe("Eclipse Core exception during code blocks parsing: "+e.getLocalizedMessage());
//				return null;
//			} catch (IOException e) {
//				log.severe("IO exception during code blocks parsing (probably communication with VM failed): "+e.getLocalizedMessage());
//				return null;
//			}
//			
//			//For every function bind the root code block to the corresponding application part. 
//			for(String functionName : codeBlocks.keySet())
//			{
//				CodeBlock functionBlock = codeBlocks.get(functionName);
//				ApplicationPart functionPart = null;
//				
//				for(ApplicationPart part : adss.getModel().getApplicationParts())
//					if((part.getName().equals(functionName) || ("android::"+functionName).equals(part.getName()) )&& part.getSourceFilePath().equals(file))
//					{
//						functionPart = part;
//						break;
//					}
//				
//				if(functionPart == null)
//				{
//					log.severe("Unable to find the application part corresponding to the function "+functionName+" in the compilation unit "+file);
//					continue;
//				}
//				
//				analyzeCodeBlock(functionBlock,2,2, functionPart,0,depthLevel,1106103861608060926L);
//				
//				//log.finer("Code blocks for function "+functionName+" generated");
//			}
//		}
		for(ApplicationPart part : adss.getModel().getAllApplicationParts())
			ECollections.sort(part.getApplicationParts(), new java.util.Comparator<ApplicationPart>() {
					 @Override
			         public int compare(ApplicationPart ap1, ApplicationPart ap2) {
						 if(ap1.isCode() && ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
							return ap1.getStartLine()-ap2.getStartLine();
						 else if(!ap1.isCode() && ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
						 	return -1;
						 else if(ap1.isCode() && !ap2.isCode() && !ap1.isInSystemFile() && !ap2.isInSystemFile())
						 	return +1;
						 else
							return 0;
	//					 return ap2.getStartLine()-ap1.getStartLine();
					 }
				});
		return retValue;
	}
	
	/**
	 * Adds to the internal model the application parts corresponding to the nested blocks of the passed block, calling itself recursively until the desidered depthLevel is found;
	 * @param analyzedCodeBlock
	 * 				The code block that must be analyzed.
	 * @param analyzedCodePart
	 * 				The application part corresponding to codeBlock.
	 * @param actualDepthLevel
	 * 				The reached depth level, if is less than the desired depth level the function calls itself recursively on all the nested code blocks of codeBlock, with actualDepthLevel incremented by 1.
	 **/
	private void analyzeCodeBlock(CodeBlock analyzedCodeBlock, ApplicationPart analyzedCodePart, int actualDepthLevel)
	{
		//Get splitting preferences
		int mediumCodeBlockLength = adss.getModel().getPreferences().getL2pFunctionSplittingMediumCodeBlockLength();
		float codeBlockLengthRandomizationDenominator = adss.getModel().getPreferences().getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator();
		Integer depthLevel = adss.getModel().getPreferences().getL2pFunctionSplittingDepthLevel();
		long seed = adss.getModel().getPreferences().getL2pFunctionSplittingSeed();
		
		//log.finer("Analyzing code block "+analyzedCodePart.getSourceFilePath()+" "+analyzedCodePart.getName()+" "+analyzedCodeBlock.getStartLine()+" "+analyzedCodeBlock.getEndLine());
		//Check if the code block to analyze has the minimum requested length and has nested code blocks
		if(analyzedCodeBlock.getEndLine() - analyzedCodeBlock.getStartLine() + 1 < mediumCodeBlockLength || analyzedCodeBlock.getCodeBlocks().isEmpty()) return;
		
		//Create application parts with the desired length by joining or splitting the nested code blocks
		
		int randomizationLength = 0;
		if(codeBlockLengthRandomizationDenominator > 0)
			randomizationLength = (int) Math.floor(mediumCodeBlockLength/codeBlockLengthRandomizationDenominator);
		
		Set<ApplicationPart> addedParts = new HashSet<>();
		int blocksStartLine = 0;
		int blocksEndLine = 0;
		int blocksLength = 0;
		
		//Order the codeblocks by start/end line
		ECollections.sort(analyzedCodeBlock.getCodeBlocks(), new java.util.Comparator<CodeBlock>() {

			@Override
			public int compare(CodeBlock o1, CodeBlock o2) {
				return o1.getStartLine()-o2.getStartLine();
			}
			
		});
		
		for(CodeBlock codeBlock : analyzedCodeBlock.getCodeBlocks())
		{
			//Ensure that the block is not contained in and does not correspond to a pragma region
			boolean exit = false;
			for(ApplicationPart pragmaPart : analyzedCodePart.getApplicationParts())
				if(pragmaPart.getType().equals(ApplicationPartType.CODE_REGION) && pragmaPart.getStartLine()<=codeBlock.getStartLine() && pragmaPart.getEndLine()>=codeBlock.getEndLine() && (!(addedParts.contains(pragmaPart)))) //The last condition is for ensuring that is an actual pragma app part and not a part added by this function
				{
					exit = true;
					break;
				}
			if(exit)
			{
				//Create the application part of the last set
				if(blocksStartLine>0 && blocksLength >0)
				{
					if(analyzedCodePart.getStartLine()==blocksStartLine && analyzedCodePart.getEndLine()==blocksEndLine) return;
					ApplicationPart part = AkbFactory.eINSTANCE.createApplicationPart();
//					part.setId(id);
//					id+=1;
					part.setName(analyzedCodePart.getName()+"-fromLine"+blocksStartLine+"ToLine"+blocksEndLine);
					part.setSourceFilePath(analyzedCodePart.getSourceFilePath());
					part.setStartLine(blocksStartLine);
					part.setEndLine(blocksEndLine);
//					part.setStatic(analyzedCodePart.isStatic());
					part.setType(ApplicationPartType.CODE_REGION);
					part.setWeight(1.0);
					adss.updateAssets();
					addedParts.add(part);
					//Check if the block contains one or more pragma regions, in case move them into the new part
					List<ApplicationPart> pragmaParts = new LinkedList<>();
					for(ApplicationPart part2 : analyzedCodePart.getApplicationParts())
						if(part2.getType().equals(ApplicationPartType.CODE_REGION) && part2.getStartLine()>=part.getStartLine() && part2.getEndLine()<=part.getEndLine())
							pragmaParts.add(part2);
					
					for(ApplicationPart part2 : pragmaParts)
					{
						analyzedCodePart.getApplicationParts().remove(part2);
						part.getApplicationParts().add(part2);
					}
					
					analyzedCodePart.getApplicationParts().add(part);
					blocksStartLine = 0;
					blocksEndLine = 0;
					blocksLength = 0;
				}
				continue;
			}
			
			int codeBlockLength = codeBlock.getEndLine() - codeBlock.getStartLine() + 1;
			if( (mediumCodeBlockLength <= 0) || (codeBlockLength >= mediumCodeBlockLength + randomizationLength) )
			{
				//Create the application part of the last set
				if(blocksStartLine>0 && blocksLength>0 && blocksEndLine>0)
				{
					if(analyzedCodePart.getStartLine()==blocksStartLine && analyzedCodePart.getEndLine()==blocksEndLine) return;
					ApplicationPart part = AkbFactory.eINSTANCE.createApplicationPart();
//					part.setId(id);
//					id+=1;
					part.setName(analyzedCodePart.getName()+"-fromLine"+blocksStartLine+"toLine"+blocksEndLine);
					part.setSourceFilePath(analyzedCodePart.getSourceFilePath());
					part.setStartLine(blocksStartLine);
					part.setEndLine(blocksEndLine);
//					part.setStatic(analyzedCodePart.isStatic());
					part.setType(ApplicationPartType.CODE_REGION);
					part.setWeight(1.0);
					adss.updateAssets();
					addedParts.add(part);
					//Check if the block contains one or more pragma regions, in case move them into the new part
					List<ApplicationPart> pragmaParts = new LinkedList<>();
					for(ApplicationPart part2 : analyzedCodePart.getApplicationParts())
						if(part2.getType().equals(ApplicationPartType.CODE_REGION) && part2.getStartLine()>=part.getStartLine() && part2.getEndLine()<=part.getEndLine())
							pragmaParts.add(part2);
					
					for(ApplicationPart part2 : pragmaParts)
					{
						analyzedCodePart.getApplicationParts().remove(part2);
						part.getApplicationParts().add(part2);
					}
					
					analyzedCodePart.getApplicationParts().add(part);
					blocksStartLine = 0;
					blocksEndLine = 0;
					blocksLength = 0;
				}
				
				//Create the new application part
				if(analyzedCodePart.getStartLine()==codeBlock.getStartLine() && analyzedCodePart.getEndLine()==codeBlock.getEndLine()) return;
				ApplicationPart part = AkbFactory.eINSTANCE.createApplicationPart();
//				part.setId(id);
//				id+=1;
				adss.updateAssets();
				part.setName(analyzedCodePart.getName()+"-fromLine"+codeBlock.getStartLine()+"toLine"+codeBlock.getEndLine());
				part.setSourceFilePath(analyzedCodePart.getSourceFilePath());
				part.setStartLine(codeBlock.getStartLine());
				part.setEndLine(codeBlock.getEndLine());
//				part.setStatic(analyzedCodePart.isStatic());
				part.setType(ApplicationPartType.CODE_REGION);
				part.setWeight(1.0);
				addedParts.add(part);
				
				//Check if the block contains one or more pragma regions, in case move them into the new part
				List<ApplicationPart> pragmaParts = new LinkedList<>();
				for(ApplicationPart part2 : analyzedCodePart.getApplicationParts())
					if(part2.getType().equals(ApplicationPartType.CODE_REGION) && part2.getStartLine()>=part.getStartLine() && part2.getEndLine()<=part.getEndLine())
						pragmaParts.add(part2);
				
				for(ApplicationPart part2 : pragmaParts)
				{
					analyzedCodePart.getApplicationParts().remove(part2);
					part.getApplicationParts().add(part2);
				}
				
				analyzedCodePart.getApplicationParts().add(part);
				//TODO decide if generated app parts must have a weight, i.e. the father weight multiplied by (code length / father length)
//				part.setWeight(0);
				if(depthLevel<0 || actualDepthLevel+1<depthLevel)
					analyzeCodeBlock(codeBlock, part, actualDepthLevel+1);
			}
			else
			{
				//Check if adding this block may get a global length bigger than mediumCodeBlockLength+randomizationLength
				//If not, check if the minimum code block length has been reached, in this case decide to stop adding blocks with a probability proportional to how much near to the medium length will be the block   
				//In this case create the part with the blocks in the set and reset the set :)
				boolean stop = false;
				if(blocksLength + codeBlockLength <= mediumCodeBlockLength + randomizationLength)
				{
					int oldDistance = Math.abs(mediumCodeBlockLength - blocksLength);
					int newDistance = Math.abs(mediumCodeBlockLength - blocksLength - codeBlockLength);
					double probabilityOfStopping = 0.5 + ((newDistance - oldDistance) / ((float) mediumCodeBlockLength));
					//Random random = new Random(0xF0CACC1A);
					Random random = new Random();
					random.setSeed(seed);
					//log.fine("Seed= "+seed);
					//TODO inserire seme per random
					double value = random.nextFloat();
					stop = value < probabilityOfStopping;
				}
				
				boolean firstBlock = false;
				//Add the first block to the set
				if(blocksStartLine==0)
				{
					blocksStartLine = codeBlock.getStartLine();
					blocksEndLine = codeBlock.getEndLine();
					blocksLength += codeBlock.getEndLine() - codeBlock.getStartLine() + 1;
					firstBlock = true;
				}
				
				//If the actual code block must not be added to the set, create from the set the application part, and create a new set starting from the codeblock
				if(stop || (firstBlock && blocksLength > mediumCodeBlockLength + randomizationLength) || (!firstBlock && blocksLength + codeBlockLength > mediumCodeBlockLength + randomizationLength))
				{
					if(analyzedCodePart.getStartLine()==blocksStartLine && analyzedCodePart.getEndLine()==blocksEndLine) return;
					ApplicationPart part = AkbFactory.eINSTANCE.createApplicationPart();
//					part.setId(id);
//					id+=1;
					part.setName(analyzedCodePart.getName()+"-fromLine"+blocksStartLine+"toLine"+blocksEndLine);
					part.setSourceFilePath(analyzedCodePart.getSourceFilePath());
					part.setStartLine(blocksStartLine);
					part.setEndLine(blocksEndLine);
//					part.setStatic(analyzedCodePart.isStatic());
					part.setType(ApplicationPartType.CODE_REGION);
					part.setWeight(1.0);
					adss.updateAssets();
					addedParts.add(part);
					//Check if the block contains one or more pragma regions, in case move them into the new part
					List<ApplicationPart> pragmaParts = new LinkedList<>();
					for(ApplicationPart part2 : analyzedCodePart.getApplicationParts())
						if(part2.getType().equals(ApplicationPartType.CODE_REGION) && part2.getStartLine()>=part.getStartLine() && part2.getEndLine()<=part.getEndLine())
							pragmaParts.add(part2);
					
					for(ApplicationPart part2 : pragmaParts)
					{
						analyzedCodePart.getApplicationParts().remove(part2);
						part.getApplicationParts().add(part2);
					}
					
					analyzedCodePart.getApplicationParts().add(part);
					
					//if(blocksStartLine==codeBlock.getStartLine() && blocksEndLine==codeBlock.getEndLine()) continue;
					
					if(!firstBlock)
					{
						blocksStartLine = codeBlock.getStartLine();
						blocksEndLine = codeBlock.getEndLine();
						blocksLength = codeBlock.getEndLine() - codeBlock.getStartLine() + 1;
						firstBlock = true;
					}
					else
					{
						//If the application part has been composed with only a block, create a new set
						blocksStartLine = 0;
						blocksEndLine = 0;
						blocksLength = 0;
					}
				}
				
				//Add the block (if is not the first) to the set
				if(!firstBlock)
				{
					blocksEndLine = codeBlock.getEndLine();
					blocksLength += codeBlock.getEndLine() - codeBlock.getStartLine() + 1;
				}
			}
		}
		//Create the application part of the last set
		if(blocksStartLine>0 && blocksLength >0)
		{
			if(analyzedCodePart.getStartLine()==blocksStartLine && analyzedCodePart.getEndLine()==blocksEndLine) return;
			ApplicationPart part = AkbFactory.eINSTANCE.createApplicationPart();
//			part.setId(id);
//			id+=1;
			part.setName(analyzedCodePart.getName()+"-fromLine"+blocksStartLine+"toLine"+blocksEndLine);
			part.setSourceFilePath(analyzedCodePart.getSourceFilePath());
			part.setStartLine(blocksStartLine);
			part.setEndLine(blocksEndLine);
//			part.setStatic(analyzedCodePart.isStatic());
			part.setType(ApplicationPartType.CODE_REGION);
			part.setWeight(1.0);
			addedParts.add(part);
			adss.updateAssets();
			//Check if the block contains one or more pragma regions, in case move them into the new part
			List<ApplicationPart> pragmaParts = new LinkedList<>();
			for(ApplicationPart part2 : analyzedCodePart.getApplicationParts())
				if(part2.getType().equals(ApplicationPartType.CODE_REGION) && part2.getStartLine()>=part.getStartLine() && part2.getEndLine()<=part.getEndLine())
					pragmaParts.add(part2);
			
			for(ApplicationPart part2 : pragmaParts)
			{
				analyzedCodePart.getApplicationParts().remove(part2);
				part.getApplicationParts().add(part2);
			}
			
			analyzedCodePart.getApplicationParts().add(part);
			blocksStartLine = 0;
			blocksEndLine = 0;
			blocksLength = 0;
		}
		
		newApplicationParts.addAll(addedParts);
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(SecondLevelProtectionFinder3.class.getName());
}
