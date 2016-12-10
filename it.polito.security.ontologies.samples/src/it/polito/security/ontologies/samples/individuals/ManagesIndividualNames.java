/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.individuals;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to rename individuals.
 * @author Daniele Canavese
 **/
public class ManagesIndividualNames extends Sample
{
	/** The first namespace. **/
	static final String NAMESPACE1 = "http://security.polito.it/ontologies/samples/test.owl#";

	/** The second namespace. **/
	static final String NAMESPACE2 = "http://security.polito.it/ontologies/samples/in1.owl#";

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

		// Search a class.
		OntologyIndividual individual = ontology.getIndividual("a");

		// Get and set the individual IRI.
		System.out.println(individual.getIRI());
		individual.setIRI(NAMESPACE1 + "A");
		individual = ontology.getIndividual("A"); // Search the new individual since the old does not exists anymore.
		System.out.println(individual.getIRI());

		// Get and set the individual simple name.
		System.out.println(individual.getIRI() + " " + individual.getName());
		individual.setName("a");
		individual = ontology.getIndividual("a");
		System.out.println(individual.getIRI() + " " + individual.getName());

		// Get and set the individual namespace.
		System.out.println(individual.getIRI() + " " + individual.getNamespace());
		individual.setNamespace(NAMESPACE2);
		individual = ontology.getIndividual(NAMESPACE2 + "a");
		System.out.println(individual.getIRI() + " " + individual.getNamespace());

	}
}
