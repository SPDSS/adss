/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.OntologyDataProperty;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to tests an ontology with some SWRL rules.
 * @author Daniele Canavese
 **/
public class TestsSWRLPerformances extends Sample
{
	/** The namespace of the ontology. **/
	static final String NAMESPACE = "http://security.polito.it/ontologies/samples/test.owl#";

	/**
	 * Creates an initial ontology.
	 * @return The ontology.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private Ontology createOntology() throws Exception
	{
		// Create an empty ontology.
		Ontology ontology = new Ontology(ReasonerType.PELLET);

		// Add some entities.
		OntologyClass class1 = ontology.addClass(NAMESPACE + "Class1");
		ontology.addClass(NAMESPACE + "Class2");
		OntologyDataProperty property = ontology.addDataProperty(NAMESPACE + "property");

		// Add a lot of individuals.
		for (int i = 0; i < 1000; ++i)
		{
			OntologyIndividual individual = ontology.addIndividual(NAMESPACE + i, class1);
			individual.addDataPropertyValue(property, i);
		}

		return ontology;
	}

	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Create two similar ontologies.
		Ontology ontology1 = createOntology();
		ontology1.getClass("Class2").addEquivalence("Class1 and property some integer[<= 100]");
		ontology1.flush();

		Ontology ontology2 = createOntology();
		ontology2.addRule("Class1(?x), property(?x, ?v), lessThanOrEqual(?v, 100) -> Class2(?x)");
		ontology2.flush();

		// Execute a speed test.
		long start1 = System.currentTimeMillis();
		ontology1.precomputeInferences();
		long stop1 = System.currentTimeMillis();

		long start2 = System.currentTimeMillis();
		ontology2.precomputeInferences();
		long stop2 = System.currentTimeMillis();

		// Prints some stats.
		System.out.println("Ontology 1 individuals: " + ontology1.getClass("Class2").getIndividuals(false).size());
		System.out.println("Ontology 2 individuals: " + ontology2.getClass("Class2").getIndividuals(false).size());
		System.out.println("Ontology 1 time: " + (stop1 - start1) + " ms");
		System.out.println("Ontology 2 time: " + (stop2 - start2) + " ms");
	}
}
