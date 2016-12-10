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
 * This example shows how to check if some entities exists.
 * @author Daniele Canavese
 **/
public class ChecksEntities extends Sample
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

		// Check if some classes exists.
		System.out.println(ontology.containsClass(NAMESPACE + "Foo"));
		System.out.println(ontology.containsClass(NAMESPACE + "FOO"));

		// Check if some data properties exists.
		System.out.println(ontology.containsDataProperty(NAMESPACE + "hasBoolean"));
		System.out.println(ontology.containsDataProperty(NAMESPACE + "hasBOOLEAN"));

		// Check if some object properties exists.
		System.out.println(ontology.containsObjectProperty(NAMESPACE + "hasObject"));
		System.out.println(ontology.containsObjectProperty(NAMESPACE + "hasOBJECT"));

		// Check if some individuals exists.
		System.out.println(ontology.containsIndividual(NAMESPACE + "a"));
		System.out.println(ontology.containsIndividual(NAMESPACE + "A"));

	}
}
