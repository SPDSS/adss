/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.classes;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to compare classes.
 * @author Daniele Canavese
 **/
public class ComparesClasses extends Sample
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
		OntologyClass clazz1 = ontology.getClass("Foo");
		OntologyClass clazz2 = ontology.addClass(NAMESPACE + "FOO");
		ontology.addClass(NAMESPACE + "foo");
		clazz1.addEquivalence(clazz2);
		ontology.flush();

		// Perform some comparisons.
		OntologyClass clazz3 = ontology.addClass("Bar");
		System.out.println(clazz1.equals(clazz2));
		System.out.println(clazz1.equals(clazz3));
	}
}
