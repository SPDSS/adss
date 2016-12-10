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
package it.polito.security.ontologies.tools;

import java.io.File;
import java.util.Formatter;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;

/**
 * Performs a performance test on an ontology.
 * @author Daniele Canavese
 **/
public class OntologyPerformances
{
	/**
	 * Create the ontology tester.
	 * @param file
	 *            The ontology file to load.
	 * @throws OWLOntologyCreationException
	 *             If something goes wrong.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public OntologyPerformances(final File file) throws Exception
	{
		ontology = new Ontology(file, ReasonerType.HERMIT);
	}

	/**
	 * Perform the test.
	 * @param reasoner
	 *            The reasoner to use.
	 * @return The test report message.
	 **/
	public String test(ReasonerType reasoner)
	{
		StringBuilder html = new StringBuilder();
		long start;
		long stop;

		try (Formatter f = new Formatter(html))
		{
			f.format("<tr>");

			ontology.setReasoner(reasoner);
			f.format("<td>%s</td>", reasoner.toString());

			start = System.currentTimeMillis();
			boolean consistent = ontology.isConsistent();
			stop = System.currentTimeMillis();
			f.format("<td>%d ms (%s)</td>", (stop - start), consistent);

			start = System.currentTimeMillis();
			ontology.precomputeInferences();
			stop = System.currentTimeMillis();
			f.format("<td>%d ms</td>", (stop - start));

			start = System.currentTimeMillis();
			ontology.executeSelectQuery("SELECT ?a ?b WHERE { DirectSubClassOf(?a, ?b) }");
			stop = System.currentTimeMillis();
			f.format("<td>%d ms</td>", (stop - start));

			f.format("</tr>");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return html.toString();
	}

	/** The ontology to analyze. **/
	private Ontology ontology;
}
