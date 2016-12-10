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
 * This example shows how to rename classes.
 * @author Daniele Canavese
 **/
public class ManagesClassNames extends Sample
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
		OntologyClass clazz = ontology.getClass("Foo");

		// Get and set the class IRI.
		System.out.println(clazz.getIRI());
		clazz.setIRI(NAMESPACE1 + "FOO");
		clazz = ontology.getClass("FOO"); // Search the new class since the old does not exists anymore.
		System.out.println(clazz.getIRI());

		// Get and set the class simple name.
		System.out.println(clazz.getIRI() + " " + clazz.getName());
		clazz.setName("Foo");
		clazz = ontology.getClass("Foo");
		System.out.println(clazz.getIRI() + " " + clazz.getName());

		// Get and set the class namespace.
		System.out.println(clazz.getIRI() + " " + clazz.getNamespace());
		clazz.setNamespace(NAMESPACE2);
		clazz = ontology.getClass(NAMESPACE2 + "Foo");
		System.out.println(clazz.getIRI() + " " + clazz.getNamespace());

	}
}
