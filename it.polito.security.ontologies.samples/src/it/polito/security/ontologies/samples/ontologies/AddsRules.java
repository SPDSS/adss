/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to add new SWRL rules to an ontology.
 * @author Daniele Canavese
 **/
public class AddsRules extends Sample
{
	/** The namespace of the ontology. **/
	static final String NAMESPACE = "http://security.polito.it/ontologies/samples/test.owl#";

	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Create an empty ontology.
		Ontology ontology = new Ontology(ReasonerType.PELLET);

		// Add some classes.
		OntologyClass class1 = ontology.addClass(NAMESPACE + "Class1");
		OntologyClass class2 = ontology.addClass(NAMESPACE + "Class2");

		// And some individuals.
		ontology.addIndividual(NAMESPACE + "individual1", class1);
		ontology.addIndividual(NAMESPACE + "individual2", class1);

		// Commit the results (needed for using the classes).
		ontology.flush();

		// Add a new rule.
		ontology.addRule("Class1(?x) -> Class2(?x)");

		// Commit the results again.
		ontology.flush();

		// Print the individuals in Class2.
		for (OntologyIndividual i : class2.getIndividuals(false))
			System.out.println(i);

	}
}
