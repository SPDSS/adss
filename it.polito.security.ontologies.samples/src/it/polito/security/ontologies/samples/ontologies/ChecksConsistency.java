/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import java.util.Set;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to checks the consistency of an ontology.
 * @author Daniele Canavese
 **/
public class ChecksConsistency extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Load an ontology.
		Ontology ontology = new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);

		// Perform a consistency check.
		System.out.println(ontology.isConsistent());

		// Add a contradiction and perform another consistency check.
		ontology.getIndividual("a").addToClass("Baz");
		ontology.flush();
		System.out.println(ontology.isConsistent());

		// Ask the reasoner for the contradictory axioms.
		Set<Set<String>> explanation = ontology.getInconsistencyExplanation();
		for (Set<String> i : explanation)
		{
			for (String j : i)
				System.out.println(j);
			System.out.println();
		}

	}
}
