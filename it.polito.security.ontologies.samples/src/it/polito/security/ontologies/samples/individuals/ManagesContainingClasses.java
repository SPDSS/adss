/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.individuals;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to manage the containing classes.
 * @author Daniele Canavese
 **/
public class ManagesContainingClasses extends Sample
{
	/** The namespace of the ontology. **/
	static final String NAMESPACE = "http://security.polito.it/ontologies/samples/in1.owl#";

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

		// Add an individual to a class.
		OntologyIndividual individual = ontology.addIndividual("c", ontology.getThing());
		individual.addToClass("Foo");
		individual.addToClass("Bar");
		ontology.flush();

		// Check if the individual is in a class.
		System.out.println(individual.isContainedInClass("Bar"));
		System.out.println(individual.isContainedInClass("Baz"));

		// Retrieve the direct containing classes.
		for (OntologyClass i : individual.getContainingClasses(true))
			System.out.println(i);

		// Retrieve the indirect containing classes.
		for (OntologyClass i : individual.getContainingClasses(false))
			System.out.println(i);

	}
}
