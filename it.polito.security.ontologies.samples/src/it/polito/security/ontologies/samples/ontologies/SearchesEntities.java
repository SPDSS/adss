/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to search some entities.
 * @author Daniele Canavese
 **/
public class SearchesEntities extends Sample
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

		// Search some classes.
		System.out.println(ontology.getClass(NAMESPACE + "Bar"));
		System.out.println(ontology.getClass("Bar"));
		System.out.println(ontology.getClass("Foo or Bar")); // Manchester syntax: it is an anonymous class.

		// Search some data properties.
		System.out.println(ontology.getDataProperty(NAMESPACE + "hasBoolean"));
		System.out.println(ontology.getDataProperty("hasBoolean"));

		// Search some object properties.
		System.out.println(ontology.getObjectProperty(NAMESPACE + "hasObject"));
		System.out.println(ontology.getObjectProperty("hasObject"));

		// Search some individuals.
		System.out.println(ontology.getIndividual(NAMESPACE + "a"));
		System.out.println(ontology.getIndividual("a"));

	}
}
