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
package eu.aspire_fp7.adss.full.akb.ui.editors;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.util.Strings;

/**
 * Generates an HTML for the ADSS.
 * @author Daniele Canavese
 **/
public class ReportGenerator
{
	private ADSS adss;

	/**
	 * Creates the generator.
	 * @param adss
	 *            The ADSS:
	 **/
	public ReportGenerator(ADSS adss)
	{
		this.adss = adss;
		panelCount = 0;
	}

	/**
	 * Generates the HTML report.
	 * @param projectName
	 *            The project name.
	 * @param file
	 *            The file that will contain the report.
	 * @throws FileNotFoundException
	 *             If the file cannot be created.
	 **/
	public void generate(String projectName, String file) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(file);
		writer.println("<html>");
		writer.println("\t<head>");
		Date now = new Date();
		writer.println("\t\t<title>ADSS Full report: " + projectName + "</title>");
		writer.println("\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
		writer.println("\t\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		writer.println("\t\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		writer.println(
				"\t\t<link href=\"https://cdn.datatables.net/plug-ins/1.10.12/integration/bootstrap/3/dataTables.bootstrap.css\" rel=\"stylesheet\"/>");
		writer.println("\t\t<script src=\"https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js\"></script>");
		writer.println(
				"\t\t<script src=\"https://cdn.datatables.net/plug-ins/1.10.12/integration/bootstrap/3/dataTables.bootstrap.js\"></script>");
		writer.println("\t\t<script src=\"https://cdn.datatables.net/plug-ins/1.10.12/sorting/enum.js\"></script>");
		writer.println("\t\t<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css\">");
		writer.println("\t\t<script>");
		writer.println("\t\t\t$(document).ready(function() {");
		writer.println(
				"\t\t\t\t$('#assetsTable').dataTable({ \"order\": [[ 5, \"desc\" ]], \"aLengthMenu\": [[25, 50, 100, 200, -1], [25, 50, 100, 200, \"All\"]], \"iDisplayLength\": 25 });");
		writer.println(
				"\t\t\t\t$('#applicationPartsTable').dataTable({ \"order\": [[ 0, \"asc\" ]], \"aLengthMenu\": [[25, 50, 100, 200, -1], [25, 50, 100, 200, \"All\"]], \"iDisplayLength\": 25 });");
		writer.println("\t\t\t\t$.fn.dataTable.enum( [ 'high', 'medium', 'low', 'unblockable' ] );");
		writer.println("\t\t\t\t$('#enum-example').DataTable();");
		writer.println(
				"\t\t\t\t$('#attacksTable').dataTable({ \"order\": [[ 4, \"desc\" ]], \"aLengthMenu\": [[25, 50, 100, 200, -1], [25, 50, 100, 200, \"All\"]], \"iDisplayLength\": 25 });");
		writer.println(
				"\t\t\t\t$('#l1pTable').dataTable({ \"order\": [[ 2, \"desc\" ]], \"aLengthMenu\": [[1, 5, 10, 25, 50, 100, 200, -1], [1, 10, 25, 50, 100, 200, \"All\"]], \"iDisplayLength\": 1 });");
		writer.println(
				"\t\t\t\t$('#l2pTable').dataTable({ \"order\": [[ 2, \"desc\" ]], \"aLengthMenu\": [[1, 5, 10, 25, 50, 100, 200, -1], [1, 10, 25, 50, 100, 200, \"All\"]], \"iDisplayLength\": 1 });");
		writer.println("\t\t\t});");
		writer.println("\t\t</script>");
		writer.println("\t\t<style>");
		writer.println("\t\t\t.anchor { padding-top: 50px; }");
		writer.println("\t\t\t.panel .dl-horizontal dt { white-space: normal; }");
		writer.println("\t\t</style>");
		writer.println("\t</head>");
		writer.println("\t<body>");

		writer.println("\t\t<nav class=\"navbar navbar-inverse navbar-fixed-top\">");
		writer.println("\t\t\t<div class=\"container-fluid\">");
		writer.println("\t\t\t\t<div class=\"navbar-header\">");
		writer.println(
				"\t\t\t\t\t<a class=\"navbar-brand\" href=\"#\"><img src=\"https://aspire-fp7.eu/sites/default/files/aspire-small.png\" style=\"height: 20px; width: auto;\"></a>");
		writer.println("\t\t\t\t</div>");
		writer.println("\t\t\t\t<ul class=\"nav navbar-nav\">");
		writer.println("\t\t\t\t\t<li><a href=\"#top\">Top</a></li>");
		writer.println("\t\t\t\t\t<li><a href=\"#assets\">Assets</a></li>");
		writer.println("\t\t\t\t\t<li><a href=\"#applicationParts\">Application Parts</a></li>");
		writer.println("\t\t\t\t\t<li><a href=\"#attacks\">Attacks</a></li>");
		writer.println("\t\t\t\t\t<li><a href=\"#l1Protections\">Level 1 Protections</a></li>");
		writer.println("\t\t\t\t\t<li><a href=\"#l2Protections\">Level 2 Protections</a></li>");
		writer.println("\t\t\t\t</ul>");
		writer.println("\t\t\t</div>");
		writer.println("\t\t</nav>");

		writer.println("\t\t<a class=\"anchor\" name=\"top\"></a>");
		writer.println("\t\t<div class=\"page-header\">");
		writer.println("\t\t\t<div class=\"container\">");
		writer.println("\t\t\t\t<h1>ADSS Full Report: " + projectName + "</h1>");
		writer.println("\t\t\t</div>");
		writer.println("\t\t</div>");
		LinkedHashMap<String, Object> elements = new LinkedHashMap<>();
		elements.put("Date", now);
		elements.put("Assets", adss.getModel().getAssetsCount());
		elements.put("Attack paths", adss.getModel().getAttackPathsCount());
		elements.put("Solutions", adss.getModel().getSolutionsCount());
		generatePanel(null, elements, writer);

		generateApplicationParts(writer);
		generateAttacks(writer);
		generateL1Protections(writer);
		generateL2Protections(writer);

		writer.println("\t</body>");
		writer.println("</html>");
		writer.close();
	}

	/**
	 * Generates the L1P section.
	 * @param writer
	 *            The writer to use.
	 **/
	private void generateL1Protections(PrintWriter writer)
	{
		writer.println("\t\t<h2><a class=\"anchor\" name=\"l1Protections\"></a>Asset Protections &mdash; Level 1 Protections</h2>");

		LinkedHashMap<String, Object> baseParameters = new LinkedHashMap<>();
		baseParameters.put("Solutions", "10");
		baseParameters.put("Client time overehead", "no limit");
		baseParameters.put("Server time overehead", "no limit");
		baseParameters.put("Client memory overehead", "no limit");
		baseParameters.put("Server memory overehead", "no limit");
		baseParameters.put("Network overehead", "no limit");
		baseParameters.put("Timeout", adss.getModel().getPreferences().getL1pTimeLimit() <= 0 ? "no limit"
				: adss.getModel().getPreferences().getL1pTimeLimit() + " s");
		generatePanel(null, baseParameters, writer);

		// LinkedHashMap<String, Object> advancedParameters = new LinkedHashMap<>();
		// generatePanel("Configuration", advancedParameters, writer);

		writer.println(
				"\t\t<div class=\"alert alert-warning\"><strong>Note:</strong> the ADSS Protection Index is an absolute value computed taking into account various factors as the protection mitigations, their synergies and the attacks probabilities.</div>");

		writer.println("\t\t<table id=\"l1pTable\" class=\"table table-condensed table-hover\">");
		writer.println("\t\t\t<thead>");
		writer.println("\t\t\t\t<tr>");
		writer.println("\t\t\t\t\t<th>ID</th>");
		writer.println("\t\t\t\t\t<th>Protection @ Application Parts</th>");
		writer.println("\t\t\t\t\t<th>ADSS Protection Index</th>");
		writer.println("\t\t\t\t</tr>");
		writer.println("\t\t\t</thead>");
		writer.println("\t\t\t<tbody>");
		generateSolutions(writer, 1);
		writer.println("\t\t\t</tbody>");
		writer.println("\t\t</table>");
	}

	/**
	 * Generates the solutions table.
	 * @param writer
	 *            The writer to use.
	 * @param level
	 *            A value stating the level protections to show. It must be 1 or 2.
	 */
	private void generateSolutions(PrintWriter writer, int level)
	{
		Solution goldenSolution = null;
		for (Solution i : adss.getModel().getSolutions())
			if (goldenSolution == null || i.getScore() > goldenSolution.getScore())
				goldenSolution = i;
		for (Solution i : adss.getModel().getSolutions())
			if (level == 1 && i.getFirstLevelSolution() == null)
			{
				writer.println("\t\t\t\t<tr>");
				if (i == goldenSolution)
					writer.println("\t\t\t\t\t<td>" + i.getId() + " <span class=\"label label-info\">best</span></td>");
				else
					writer.println("\t\t\t\t\t<td>" + i.getId() + "</td>");
				String s = "";
				for (SolutionSequence j : i.getSolutionSequences())
					for (AppliedProtectionInstantiation k : j.getAppliedProtectionInstantiations())
						s = s + k + "<br/>";
				writer.println("\t\t\t\t\t<td>" + s + "</td>");
				writer.println("\t\t\t\t\t<td>" + String.format("%.3f", i.getScore()) + "</td>");
				writer.println("\t\t\t\t</tr>");
			}
			else if (level == 2 && i.getFirstLevelSolution() != null)
			{
				writer.println("\t\t\t\t<tr>");
				writer.println("\t\t\t\t\t<td>" + i.getId() + "</td>");
				String s = "";
				for (SolutionSequence j : i.getSolutionSequences())
					for (AppliedProtectionInstantiation k : j.getAppliedProtectionInstantiations())
						s = s + k + "<br/>";
				writer.println("\t\t\t\t\t<td>" + s + "</td>");
				writer.println("\t\t\t\t\t<td>" + String.format("%.3f", i.getScore()) + "</td>");
				writer.println("\t\t\t\t</tr>");
			}
	}

	/**
	 * Generates the L2P section.
	 * @param writer
	 *            The writer to use.
	 **/
	private void generateL2Protections(PrintWriter writer)
	{
		writer.println("\t\t<a class=\"anchor\" name=\"l2Protections\"></a><h2>Asset Protections &mdash; Level 2 Protections</h2>");

		LinkedHashMap<String, Object> elements = new LinkedHashMap<>();
		elements.put("Solutions", "1");
		elements.put("Client time overehead", "50");
		elements.put("Server time overehead", "50");
		elements.put("Client memory overehead", "50");
		elements.put("Server memory overehead", "50");
		elements.put("Network overehead", "50");
		elements.put("Timeout", adss.getModel().getPreferences().getL2pTimeLimit() + " s");
		generatePanel(null, elements, writer);

		writer.println(
				"\t\t<div class=\"alert alert-warning\"><strong>Note:</strong> the explanation field gives a motivation of the ADSS choice w.r.t. the level 1 protections. [kept] means that a protection was left unchanged, [enlarged] that a protected code region was made bigger and [replicated] that a random code region was added to increase the confusion level.</div>");

		writer.println("\t\t<table id=\"l2pTable\" class=\"table table-condensed table-hover\">");
		writer.println("\t\t\t<thead>");
		writer.println("\t\t\t\t<tr>");
		writer.println("\t\t\t\t\t<th>ID (L1P ID)</th>");
		writer.println("\t\t\t\t\t<th>Protection @ Application Parts \"Explanation\"</th>");
		writer.println("\t\t\t\t\t<th>Score</th>");
		writer.println("\t\t\t\t</tr>");
		writer.println("\t\t\t</thead>");
		writer.println("\t\t\t<tbody>");
		generateSolutions(writer, 2);
		writer.println("\t\t\t</tbody>");
		writer.println("\t\t</table>");
	}

	/**
	 * Generates the attacks section.
	 * @param writer
	 *            The writer to use.
	 **/
	private void generateAttacks(PrintWriter writer)
	{
		Map<AttackPath, List<Protection>> map = new HashMap<>();
		for (Protection i : adss.getModel().getProtections())
			for (AttackMitigation j : i.getMitigations())
				for (AttackPath k : j.getAttackPaths())
				{
					List<Protection> l;
					if (map.containsKey(k))
						l = map.get(k);
					else
					{
						l = new ArrayList<>();
						map.put(k, l);
					}
					l.add(i);
				}

		writer.println("\t\t<a class=\"anchor\" name=\"attacks\"></a><h2>Attacks and Protections</h2>");

		LinkedHashMap<String, Object> elements = new LinkedHashMap<>();
		elements.put("Attack paths", adss.getModel().getAttackPathsCount());
		elements.put("Attack steps", adss.getModel().getAttackStepsCount());
		elements.put("Protections", adss.getModel().getProtectionsCount());
		generatePanel(null, elements, writer);

		writer.println("\t\t<div class=\"alert alert-warning\">");
		writer.println(
				"\t\t\t<strong>Note 1:</strong> the attacker benefit is computed as the sum of the threatened assets' weights.");
		writer.println("\t\t</div>");
		writer.println("\t\t<div class=\"alert alert-warning\">");
		writer.println(
				"\t\t\t<strong>Note 2:</strong> the Expected Maximum Mitigation is the maximum achievable protection level if only the best protection is applied to the asset.");
		writer.println("\t\t</div>");
		writer.println("\t\t<table id=\"attacksTable\" class=\"table table-condensed table-hover\">");
		writer.println("\t\t\t<thead>");
		writer.println("\t\t\t\t<tr>");
		writer.println("\t\t\t\t\t<th>ID</th>");
		writer.println("\t\t\t\t\t<th>Attack Path</th>");
		writer.println("\t\t\t\t\t<th>Targets</th>");
		writer.println("\t\t\t\t\t<th>Attacker Benefit</th>");
		writer.println("\t\t\t\t\t<th data-sorter=\"mitigationSorter\">Expected Maximum Mitigation</th>");
		writer.println("\t\t\t\t\t<th>Suggested Protections @ Application Parts</th>");
		writer.println("\t\t\t\t</tr>");
		writer.println("\t\t\t</thead>");
		writer.println("\t\t\t<tbody>");
		for (AttackPath i : adss.getModel().getAttackPaths())
		{
			if (i.getLevel() == Level.HIGH)
				writer.println("\t\t\t\t<tr class=\"success\">");
			else if (i.getLevel() == Level.MEDIUM)
				writer.println("\t\t\t\t<tr class=\"warning\">");
			else if (i.getLevel() == Level.LOW)
				writer.println("\t\t\t\t<tr class=\"danger\">");
			else
				writer.println("\t\t\t\t<tr class=\"info\">");
			writer.println("\t\t\t\t\t<td>" + i.getId() + "</td>");
			writer.println("\t\t\t\t\t<td>" + Strings.join(i.getAttackSteps(), "<br/>") + "</td>");
			writer.println("\t\t\t\t\t<td>" + Strings.join(i.getProtectionObjectives(), ", ") + "</td>");
			writer.println("\t\t\t\t\t<td>" + i.getCost() + "</td>");
			if (i.getLevel() == Level.HIGH)
				writer.println("\t\t\t\t\t<td>high</td>");
			else if (i.getLevel() == Level.MEDIUM)
				writer.println("\t\t\t\t\t<td>medium</td>");
			else if (i.getLevel() == Level.LOW)
				writer.println("\t\t\t\t\t<td>low</td>");
			else
				writer.println("\t\t\t\t\t<td>unblockable</td>");
			String mitigations = i.getMitigations();
			mitigations = mitigations.replaceAll("\n", "<br/>");
			mitigations = mitigations.replaceAll("\\(high\\)", "<span class=\"label label-success\">high</span>");
			mitigations = mitigations.replaceAll("\\(medium\\)", "<span class=\"label label-warning\">medium</span>");
			mitigations = mitigations.replaceAll("\\(low\\)", "<span class=\"label label-danger\">low</span>");
			writer.println("\t\t\t\t\t<td>" + mitigations + "</td>");
			writer.println("\t\t\t\t</tr>");
		}
		writer.println("\t\t\t</tbody>");
		writer.println("\t\t</table>");
	}

	/**
	 * Generates the application parts sections.
	 * @param writer
	 *            The writer to use.
	 **/
	private void generateApplicationParts(PrintWriter writer)
	{
		writer.println("\t\t<a class=\"anchor\" name=\"assets\"></a><h2>Assets</h2>");

		LinkedHashMap<String, Object> elements = new LinkedHashMap<>();
		elements.put("Assets", adss.getModel().getAssetsCount());
		elements.put("Application parts", adss.getModel().getApplicationPartsCount());
		generatePanel(null, elements, writer);

		generateApplicationPartsTable(adss.getModel().getAssets(), "assetsTable", false, writer);

		writer.println("\t\t<a class=\"anchor\" name=\"applicationParts\"></a><h2>All the Application Parts</h2>");

		writer.println(
				"\t\t<div class=\"alert alert-warning\"><strong>Note:</strong> we name application part all the entities in the application that may deserve to be protected, including variables, functions, external references, relevant code regions and assets.</div>");

		generatePanel(null, elements, writer);

		generateApplicationPartsTable(adss.getModel().getAllApplicationParts(), "applicationPartsTable", true, writer);
	}

	/**
	 * Generates an application parts table.
	 * @param applicationParts
	 *            The application parts of the table.
	 * @param id
	 *            The table id.
	 * @param emphasizeAssets
	 *            A boolean stating if the table should visually emphasize the assets or not.
	 * @param writer
	 *            The writer to use.
	 **/
	private void generateApplicationPartsTable(Collection<ApplicationPart> applicationParts, String id, boolean emphasizeAssets,
			PrintWriter writer)
	{
		writer.println("\t\t<table id=\"" + id + "\" class=\"table table-condensed table-hover\">");
		writer.println("\t\t\t<thead>");
		writer.println("\t\t\t\t<tr>");
		writer.println("\t\t\t\t\t<th>Name</th>");
		writer.println("\t\t\t\t\t<th>Parent</th>");
		writer.println("\t\t\t\t\t<th>Type</th>");
		writer.println("\t\t\t\t\t<th>Source File : Line</th>");
		writer.println("\t\t\t\t\t<th>Properties</th>");
		writer.println("\t\t\t\t\t<th>Weight</th>");
		writer.println("\t\t\t\t</tr>");
		writer.println("\t\t\t</thead>");
		writer.println("\t\t\t<tbody>");
		for (ApplicationPart i : applicationParts)
		{
			writer.println("\t\t\t\t<tr>");
			if (emphasizeAssets && i.isAsset())
				writer.println("\t\t\t\t\t<td>" + i.getName() + " <span class=\"label label-info\">asset</span></td>");
			else
				writer.println("\t\t\t\t\t<td>" + i.getName() + "</td>");
			if (i.getDeclaringCode() != null)
				writer.println("\t\t\t\t\t<td>" + i.getDeclaringCode().getName() + "</td>");
			else
				writer.println("\t\t\t\t\t<td>&nbsp;</td>");
			if (i.getType() == ApplicationPartType.CIPHERTEXT)
				writer.println("\t\t\t\t\t<td>ciphertext</td>");
			else if (i.getType() == ApplicationPartType.CODE_REGION)
				writer.println("\t\t\t\t\t<td>code region</td>");
			else if (i.getType() == ApplicationPartType.CRYPTOGRAPHIC_KEY)
				writer.println("\t\t\t\t\t<td>cryptographic key</td>");
			else if (i.getType() == ApplicationPartType.FUNCTION)
				writer.println("\t\t\t\t\t<td>function</td>");
			else if (i.getType() == ApplicationPartType.REFERENCE)
				writer.println("\t\t\t\t\t<td>reference</td>");
			else if (i.getType() == ApplicationPartType.GENERIC_VARIABLE)
				writer.println("\t\t\t\t\t<td>other data type</td>");
			else if (i.getType() == ApplicationPartType.INITIALIZATION_VECTOR)
				writer.println("\t\t\t\t\t<td>initialization vector</td>");
			else if (i.getType() == ApplicationPartType.INTEGER_ARRAY_DATUM)
				writer.println("\t\t\t\t\t<td>integer array</td>");
			else if (i.getType() == ApplicationPartType.INTEGER_DATUM)
				writer.println("\t\t\t\t\t<td>integer</td>");
			else if (i.getType() == ApplicationPartType.PARAMETER)
				writer.println("\t\t\t\t\t<td>parameter</td>");
			else if (i.getType() == ApplicationPartType.PLAINTEXT)
				writer.println("\t\t\t\t\t<td>plaintext</td>");
			else if (i.getType() == ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM)
				writer.println("\t\t\t\t\t<td>static integer array</td>");
			writer.println("\t\t\t\t\t<td>" + i.getShortLocation() + "</td>");
			writer.println("\t\t\t\t\t<td>" + Strings.join(i.getProperties(), ", ") + "</td>");
			writer.println("\t\t\t\t\t<td>" + i.getWeight() + "</td>");
			writer.println("\t\t\t\t</tr>");
		}
		writer.println("\t\t\t</tbody>");
		writer.println("\t\t</table>");
	}

	/**
	 * Generates a panel with some elements.
	 * @param title
	 *            The panel title.
	 * @param elements
	 *            The list of elements.
	 * @param writer
	 *            The writer to use.
	 **/
	private void generatePanel(String title, LinkedHashMap<String, Object> elements, PrintWriter writer)
	{
		writer.println("\t\t<div class=\"panel-group\">");
		writer.println("\t\t\t<div class=\"panel panel-info\">");
		if (title != null)
		{

			writer.println("\t\t\t\t<div class=\"panel-heading\">");
			writer.println("\t\t\t\t\t<h4 class=\"panel-title\">");
			writer.println("\t\t\t\t\t\t<a data-toggle=\"collapse\" href=\"#collapse" + panelCount + "\">" + title + "</a>");
			writer.println("\t\t\t\t\t</h4>");
			writer.println("\t\t\t\t</div>");
			writer.println("\t\t\t\t\t<div id=\"collapse" + panelCount++ + "\" class=\"panel-collapse collapse\">");
		}
		else
			writer.println("\t\t\t\t\t<div id=\"collapse" + panelCount++ + "\">");
		writer.println("\t\t\t\t\t<div class=\"panel-body\">");
		writer.println("\t\t\t\t\t\t\t<dl class=\"dl-horizontal\">");
		for (Entry<String, Object> i : elements.entrySet())
		{
			writer.println("\t\t\t\t\t\t\t\t<dt>" + i.getKey() + "</dt>");
			writer.println("\t\t\t\t\t\t\t\t<dd>" + i.getValue().toString() + "</dd>");
		}
		writer.println("\t\t\t\t\t\t\t</dl>");
		writer.println("\t\t\t\t\t\t</div>");
		writer.println("\t\t\t\t\t</div>");
		writer.println("\t\t\t\t</div>");
		writer.println("\t\t\t</div>");
	}

	/** The number of panels created so far. **/
	private int panelCount;
}
