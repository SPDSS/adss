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
 * This example shows how to manage data properties.
 * @author Daniele Canavese
 **/
public class ManagesDataProperties extends Sample
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
		individual.addDataPropertyValue("hasBoolean", true);
		individual.addDataPropertyValue("hasDouble", 1.0);
		individual.addDataPropertyValue("hasFloat", 2.0f);
		individual.addDataPropertyValue("hasInteger", 3);
		individual.addDataPropertyValue("hasString", "value");
		ontology.flush();

		// Retrieve the assertions.
		System.out.println(individual.getDataPropertyValue("hasBoolean", Boolean.class));
		System.out.println(individual.getDataPropertyValue("hasDouble", Double.class));
		System.out.println(individual.getDataPropertyValue("hasFloat", Float.class));
		System.out.println(individual.getDataPropertyValue("hasInteger", Integer.class));
		System.out.println(individual.getDataPropertyValue("hasString", String.class));

		// Remove some assertions.
		individual.removeDataPropertyValues("hasBoolean");
		ontology.flush();
		System.out.println(individual.getDataPropertyValue("hasBoolean", Boolean.class));

	}
}
