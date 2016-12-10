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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ActionType;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartSet;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.util.Strings;

/**
 * The legendary annotation rewriter.
 * @author Daniele Canavese
 **/
public class AnnotationRewriter
{
	/** The ADSS. **/
	private ADSS adss;

	/**
	 * Creates the rewriter.
	 * @param adss
	 *            The ADSS:
	 **/
	public AnnotationRewriter(ADSS adss)
	{
		this.adss = adss;
	}

	/**
	 * Deploys the patch file content for preparing the source files.
	 * @throws IOException
	 *             If a source file cannot be read.
	 */
	public void deployPatch() throws IOException
	{
		StringBuilder sb = new StringBuilder();

		for (String i : getSourceFiles())
		{
			List<ApplicationPart> parts = getPartsToUpdate(i);
			if (!parts.isEmpty())
			{
				String[] content = adss.getRunner().readFile(i).split("\n");

				Path p = Paths.get(adss.getModel().getPreferences().getWorkingDirectory()).relativize(Paths.get(i));
				sb.append("--- " + p.toString() + "\n");
				sb.append("+++ " + p.toString() + ".adss\n");

				Collections.sort(parts, new Comparator<ApplicationPart>()
				{
					@Override
					public int compare(ApplicationPart o1, ApplicationPart o2)
					{
						return o1.getStartLine() - o2.getStartLine();
					}
				});

				for (ApplicationPart j : parts)
				{
					String startLine = content[j.getStartLine() - 1];
					String endLine = content[j.getEndLine() - 1];
					if (startLine.matches(".*requirement\\(.*?\\).*"))
					{
						sb.append("@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",1 @@\n");
						sb.append("-" + startLine + "\n");
						startLine = startLine.replaceFirst("(weight\\(.*?\\)\\s*,\\s*)?requirement\\(.*?\\)(\\s*,\\s*weight\\(.*?\\))?",
								"protection(placeHolder, id(" + j.getId() + "))");
						sb.append("+" + startLine + "\n");
					}
					else if (j.isDatum())
					{
						Pattern pattern = Pattern.compile("(.*\\s+" + j.getName() + "\\s*(\\[.*\\])?)(.*)");
						Matcher matcher = pattern.matcher(startLine);
						if (matcher.matches())
						{
							sb.append("@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",1 @@\n");
							sb.append("-" + startLine + "\n");
							startLine = matcher.group(1) + " __attribute__((ASPIRE(\"protection(placeHolder, id(" + j.getId() + "))\")))"
									+ matcher.group(3);
							sb.append("+" + startLine + "\n");
						}
					}
					else if (j.isCode())
					{
						sb.append("@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",2 @@\n");
						sb.append("-" + startLine + "\n");
						startLine = "_Pragma(\"ASPIRE begin protection(placeHolder, id(" + j.getId() + "))\")\n+" + startLine;
						sb.append("+" + startLine + "\n");

						sb.append("@@ -" + j.getEndLine() + ",1 +" + j.getEndLine() + ",2 @@\n");
						sb.append("-" + endLine + "\n");
						endLine = endLine + "\n+_Pragma(\"ASPIRE end\")";
						sb.append("+" + endLine + "\n");
					}
				}
			}
		}

		adss.getRunner().createFile(adss.getModel().getPreferences().getWorkingDirectory() + adss.getRunner().getSeparator()
				+ adss.getModel().getPreferences().getAdssPatchFile(), new ByteArrayInputStream(sb.toString().getBytes()));

		log.fine(adss.getModel().getPreferences().getAdssPatchFile() + " deployed");
	}

	/**
	 * Deploys the JSON file content for rewriting the source files.
	 * @throws IOException
	 *             If a source file cannot be read.
	 */
	public void deployJSON(Solution solution) throws IOException
	{
		StringBuilder sb = new StringBuilder();

		List<AppliedProtectionInstantiation> appliedProtectionInstantiations = new ArrayList<>();

		for (SolutionSequence i : solution.getSolutionSequences())
			appliedProtectionInstantiations.addAll(i.getAppliedProtectionInstantiations());

		final Map<ApplicationPart, List<ProtectionInstantiation>> map = new HashMap<>();
		List<ApplicationPart> parts = new ArrayList<>();
		for (AppliedProtectionInstantiation i : appliedProtectionInstantiations)
		{
			List<ProtectionInstantiation> protectionInstantiations;
			Collection<ApplicationPart> set = new HashSet<>();
			set.add(i.getApplicationPart());
			for (ApplicationPartSet j : i.getApplicationPart().getSets())
				if (i.getProtectionInstantiation().getProtection().getActions().contains(j.getAction()))
					set.addAll(j.getApplicationParts());
			for (ApplicationPart k : set)
			{
				if (map.containsKey(k))
					protectionInstantiations = map.get(k);
				else
				{
					protectionInstantiations = new ArrayList<>();
					map.put(k, protectionInstantiations);
				}

				protectionInstantiations.add(i.getProtectionInstantiation());
				if (!parts.contains(k))
					parts.add(k);
			}
		}

		Collections.sort(parts, new Comparator<ApplicationPart>()
		{
			@Override
			public int compare(ApplicationPart o1, ApplicationPart o2)
			{
				if (!o1.getSourceFilePath().equals(o2.getSourceFilePath()))
					return o1.getSourceFilePath().compareTo(o2.getSourceFilePath());
				else
					return map.get(o1).hashCode() - map.get(o2).hashCode();
			}
		});

		sb.append("[\n");

		boolean first = true;
		for (ApplicationPart i : parts)
		{
			List<ProtectionInstantiation> protectionInstantiations = map.get(i);

			List<String> annotationContent = new ArrayList<>();
			for (ProtectionInstantiation j : protectionInstantiations)
				annotationContent.add("protection(" + expand(i, j) + ")");

			if (first)
				first = false;
			else
				sb.append(",\n");
			sb.append("\t{\n");
			String path = i.getSourceFilePath();
			path = path.substring(path.lastIndexOf(adss.getRunner().getSeparator()) + 1);
			sb.append("\t\t\"file name\": \"" + path + "\",\n");
			sb.append("\t\t\"id\": \"" + i.getId() + "\",\n");
			sb.append("\t\t\"annotation content\": \"" + Strings.join(annotationContent, ", ") + "\"\n");
			sb.append("\t}");
		}

		sb.append("\n]\n");

		adss.getRunner().createFile(adss.getModel().getPreferences().getWorkingDirectory() + adss.getRunner().getSeparator()
				+ adss.getModel().getPreferences().getAdssJSONFile(), new ByteArrayInputStream(sb.toString().getBytes()));

		log.fine(adss.getModel().getPreferences().getAdssJSONFile() + " deployed");
	}

	/**
	 * Expands all the keywords in an annotation.
	 * @param applicationPart
	 *            The related application part.
	 * @param protectionInstantiation
	 *            The protection instantiation to use.
	 * @return The annotation with all the expanded keywords.
	 **/
	private String expand(ApplicationPart applicationPart, ProtectionInstantiation protectionInstantiation)
	{
		String expansion = "";

		if (applicationPart.isCode())
			expansion = protectionInstantiation.getCodeAnnotation();
		else if (applicationPart.isDatum())
			expansion = protectionInstantiation.getVariableAnnotation();

		if (applicationPart.getType() == ApplicationPartType.CRYPTOGRAPHIC_KEY)
			expansion = expansion.replaceAll("#role#", "key");
		else if (applicationPart.getType() == ApplicationPartType.INITIALIZATION_VECTOR)
			expansion = expansion.replaceAll("#role#", "iv");
		else if (applicationPart.getType() == ApplicationPartType.PLAINTEXT)
		{
			for (ApplicationPartSet i : applicationPart.getSets())
				if (i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "input");
				else if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "output");
		}
		else if (applicationPart.getType() == ApplicationPartType.CIPHERTEXT)
		{
			for (ApplicationPartSet i : applicationPart.getSets())
				if (i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "output");
				else if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "input");
		}

		if (applicationPart.isDatum())
		{
			int size = applicationPart.getDatumSize();
			if (applicationPart.getType() == ApplicationPartType.CRYPTOGRAPHIC_KEY)
			{
				for (ApplicationPartSet i : applicationPart.getSets())
					if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB
							|| i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
						size = 16;
			}
			else if (applicationPart.getType() == ApplicationPartType.INITIALIZATION_VECTOR)
			{
				for (ApplicationPartSet i : applicationPart.getSets())
					if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB
							|| i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
						size = 16;
			}
			else if (applicationPart.getType() == ApplicationPartType.PLAINTEXT
					|| applicationPart.getType() == ApplicationPartType.CIPHERTEXT)
			{
				for (ApplicationPartSet i : applicationPart.getSets())
					if (i.getAction() == ActionType.DECRYPT_AES128_ECB || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
						size = 16;
			}
			expansion = expansion.replaceAll("#size#", String.valueOf(size));
		}

		if (!applicationPart.getSets().isEmpty())
			expansion = expansion.replaceAll("#label#", "label." + applicationPart.getSets().get(0).hashCode());

		if (applicationPart.isCode())
		{
			for (ApplicationPartSet i : applicationPart.getSets())
				if (i.getAction() == ActionType.DECRYPT_AES128_CBC)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "CBC");
					expansion = expansion.replaceAll("#operation#", "decrypt");
				}
				else if (i.getAction() == ActionType.DECRYPT_AES128_ECB)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "ECB");
					expansion = expansion.replaceAll("#operation#", "decrypt");
				}
				else if (i.getAction() == ActionType.ENCRYPT_AES128_CBC)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "CBC");
					expansion = expansion.replaceAll("#operation#", "encrypt");
				}
				else if (i.getAction() == ActionType.ENCRYPT_AES128_ECB)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "ECB");
					expansion = expansion.replaceAll("#operation#", "encrypt");
				}
		}

		return expansion;
	}

	// private int[] primeNumbers = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
	// 103,
	// 107, 109, 113, 127, 131, 137, 139, 149 };
	//
	// /**
	// * Returns from the passed applied protection instantiation the annotations with evaluated annotation variables.
	// * @param pi
	// * The applied protection instantiation containing the annotations that must be evaluated.
	// * @return A list of entries, where the key is the type of annotation, and the value is the annotation with the variables evaluated.
	// */
	// List<SimpleEntry<String, String>> getRealAnnotations(ProtectionInstantiation pi, ApplicationPart part)
	// {
	// switch (pi.getProtection().getName())
	// {
	// case "dataObfuscation":
	// return getRealAnnotationsDataObfuscation(pi, part);
	// // case "antiDebugging" :
	// // case "binaryCodeControlFlowObfuscation" :
	// // case "callStackChecks" :
	// // case "softVM" :
	// }
	// return new LinkedList<SimpleEntry<String, String>>();
	// }
	//
	// public String getOverheadDiabloMetrics(ProtectionInstantiation pi, ApplicationPart part, Solution solution)
	// {
	// // String[] instVars = pi.getClientMemoryOverhead().split("#", -1);
	// String[] instVars = "1 + (10 * max(0, (#nr_bbls_dynamic_size# / #nr_bbls_static_size# - 10)/100) * #nr_bbls_dynamic_size#) /
	// #nr_ins_dynamic_size# "
	// .split("#", -1);
	// int i = 1;
	// // if the string starts with a #var#, then the vars are at even indexes of instVars, otherwise are odd indexes
	// // if(pi.getClientMemoryOverhead().indexOf('#')==0) i=0;
	// for (; i < instVars.length; i += 2)
	// {
	// String metricToFound = instVars[i];
	// if (instVars[i].equals("nr_bbls_dynamic_size"))
	// metricToFound = "nr_ins_dynamic";
	// else if (instVars[i].equals("nr_bbls_static_size"))
	// metricToFound = "nr_ins_static";
	// for (ApplicationPartMetricSet apms : solution.getApplicationPartMetricSets())
	// {
	// if (apms.getApplicationPart() != part)
	// continue;
	// for (Metric metric : apms.getMetrics())
	// {
	// if (!metric.getName().equals(metricToFound))
	// continue;
	// if (instVars[i].equals("nr_bbls_dynamic_size") || instVars[i].equals("nr_bbls_static_size"))
	// instVars[i] = ((Double) (metric.getValue() / 8.0)).toString();
	// else
	// instVars[i] = metric.getValue().toString();
	// break;
	// }
	// break;
	// }
	// }
	// String acc = "";
	// for (String instVar : instVars)
	// acc += instVar;
	// try
	// {
	// final Evaluator evaluator = new Evaluator();
	// final String expression = "1 + (10 * max(-1000, (3 / 1.0 - 10)/100) * 2) / 1.0 ";
	// return evaluator.evaluate(expression).toString();
	// }
	// catch (EvaluationException e)
	// {
	// return e.getMessage();
	// }
	// }
	//
	// List<SimpleEntry<String, String>> getRealAnnotationsDataObfuscation(ProtectionInstantiation pi, ApplicationPart variable)
	// {
	// String[] instVars = pi.getVariableAnnotation().split("#", -1);
	// int i = 1;
	// // if the string starts with a #var#, then the vars are at even indexes of instVars, otherwise are odd indexes
	// if (pi.getVariableAnnotation().indexOf('#') == 0)
	// i = 0;
	// String[] randomPair = { "", "" };
	// String[] minMaxPair = { "", "" };
	// for (; i < instVars.length; i += 2)
	// {
	// switch (instVars[i])
	// {
	// case "random":
	// {
	// Random random = new Random();
	// instVars[i] = String.valueOf(Math.pow(2, (random.nextInt(8 * variable.getDatumSize()))) - 1);
	// break;
	// }
	// case "vars":
	// instVars[i] = "4";
	// break;
	// case "nbits":
	// instVars[i] = String.valueOf(8 * variable.getDatumSize());
	// break;
	// case "random_1":
	// if (randomPair[0].isEmpty())
	// randomPair = generateCoupleOfRandomNumbers(variable);
	// instVars[i] = randomPair[0];
	// randomPair[0] = "";
	// break;
	// case "random_2":
	// if (randomPair[1].isEmpty())
	// randomPair = generateCoupleOfRandomNumbers(variable);
	// instVars[i] = randomPair[1];
	// randomPair[1] = "";
	// break;
	// case "min":
	// if (minMaxPair[0].isEmpty())
	// minMaxPair = generateMinMax(variable);
	// instVars[i] = minMaxPair[0];
	// minMaxPair[0] = "";
	// break;
	// case "max":
	// if (minMaxPair[1].isEmpty())
	// minMaxPair = generateMinMax(variable);
	// instVars[i] = minMaxPair[1];
	// minMaxPair[1] = "";
	// break;
	// }
	// }
	// String acc = "";
	// for (String instVar : instVars)
	// acc += instVar;
	// List<SimpleEntry<String, String>> retValue = new LinkedList<SimpleEntry<String, String>>();
	// retValue.add(0, new SimpleEntry<String, String>("variableAnnotation", acc));
	// return retValue;
	// }
	//
	// private String[] generateMinMax(ApplicationPart variable)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// String[] generateCoupleOfRandomNumbers(ApplicationPart variable)
	// {
	// Random random = new Random();
	// Long range = (long) (Math.pow(2, (8 * variable.getDatumSize())) - 1);
	// Long mult = (long) 1;
	// Long var1 = (long) 1;
	// Long var2 = (long) 1;
	// Set<Long> var1primes = new HashSet<>();
	// Set<Long> var2primes = new HashSet<>();
	// while (true)
	// {
	// /*
	// * TODO: maybe create an hardcoded set of prime numbers less than range generate and cache prime numbers until the half of the
	// * variable range, starting from already generate numbers
	// */
	// Long randomPrime = (long) primeNumbers[random.nextInt(34)];
	// // stop if the multiplication random1*random2 would be higher than the variable range, or globally with a 10% of probability
	// if (mult * randomPrime >= range || random.nextInt(10) == 1)
	// break;
	// if (var1primes.contains(randomPrime))
	// var2primes.add(randomPrime);
	// else if (var2primes.contains(randomPrime))
	// var1primes.add(randomPrime);
	// else if (random.nextBoolean())
	// var1primes.add(randomPrime);
	// else
	// var2primes.add(randomPrime);
	// mult = mult * randomPrime;
	// }
	// for (Long var1prime : var1primes)
	// var1 = var1 * var1prime;
	// for (Long var2prime : var1primes)
	// var2 = var2 * var2prime;
	// String[] retValue = new String[2];
	// retValue[0] = var1.toString();
	// retValue[1] = var2.toString();
	// return retValue;
	// }
	//
	/**
	 * Retrieves all the parts to update in a source file.
	 * @param file
	 *            The source file.
	 * @return The list of the parts to update in a file.
	 */
	private List<ApplicationPart> getPartsToUpdate(String file)
	{
		List<ApplicationPart> parts = getPartsToUpdate();

		Iterator<ApplicationPart> i = parts.iterator();
		while (i.hasNext())
		{
			ApplicationPart part = i.next();
			if (!part.getSourceFilePath().equals(file))
				i.remove();
		}

		return parts;
	}

	/**
	 * Retrieves all the parts to update.
	 * @return The list of the parts to update in a file.
	 */
	private List<ApplicationPart> getPartsToUpdate()
	{
		List<ApplicationPart> parts = new ArrayList<>();
		for (ApplicationPart i : adss.getModel().getAllApplicationParts())
			if (i.isAsset() || i.getType() == ApplicationPartType.CODE_REGION)
				parts.add(i);
		for (ApplicationPart i : adss.getModel().getAssets())
			for (ApplicationPartSet j : i.getSets())
				parts.addAll(j.getApplicationParts());
		return parts;
	}

	/**
	 * Retrieves all the source files.
	 * @return The list of source files.
	 */
	private Collection<String> getSourceFiles()
	{
		HashSet<String> files = new HashSet<>();

		for (ApplicationPart i : adss.getModel().getApplicationParts())
			files.add(i.getSourceFilePath());

		return files;
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(AnnotationRewriter.class.getName());
}
