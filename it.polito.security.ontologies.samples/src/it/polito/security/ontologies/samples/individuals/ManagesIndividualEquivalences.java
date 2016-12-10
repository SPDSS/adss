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
 * This example shows how to manage equivalent individuals.
 * @author Daniele Canavese
 **/
public class ManagesIndividualEquivalences extends Sample
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

		// Add some equivalences.
		OntologyIndividual individual1 = ontology.getIndividual("a");
		OntologyIndividual individual2 = ontology.addIndividual(NAMESPACE + "A", ontology.getThing());
		individual1.addEquivalence(individual2);
		individual1.addEquivalence("b");
		ontology.flush();

		// Retrieve the named equivalences of an individual.
		for (OntologyIndividual i : individual1.getEquivalentIndividuals())
			System.out.println(i);

	}
}
