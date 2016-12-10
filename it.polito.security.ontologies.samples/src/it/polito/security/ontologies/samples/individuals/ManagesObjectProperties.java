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
 * This example shows how to manage object properties.
 * @author Daniele Canavese
 **/
public class ManagesObjectProperties extends Sample
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

		// Add some assertions.
		OntologyIndividual individual = ontology.getIndividual("b");
		individual.addObjectPropertyValue("hasObject", "a");
		individual.addObjectPropertyValue("hasObject", "b");
		ontology.flush();

		// Retrieve the assertions.
		for (OntologyIndividual i : individual.getObjectPropertyValues("hasObject"))
			System.out.println(i);

		// Remove some assertions.
		individual.removeObjectPropertyValues("hasObject");
		ontology.flush();
		System.out.println(individual.getObjectPropertyValue("hasObject"));

	}
}
