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
 * This example shows how to manage super-classes.
 * @author Daniele Canavese
 **/
public class ManagesSuperClasses extends Sample
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

		// Add some super-classes.
		OntologyClass clazz1 = ontology.getClass("Foo");
		OntologyClass clazz2 = ontology.addClass(NAMESPACE + "FOO");
		ontology.addClass(NAMESPACE + "foo");
		clazz1.addSuperClass(clazz2);
		clazz1.addSuperClass("foo");
		clazz1.addSuperClass("FOO and foo");
		ontology.flush();

		// Retrieve the named direct super-classes of a class.
		for (OntologyClass i : clazz1.getSuperClasses(true))
			System.out.println(i);
		System.out.println();

		// Retrieve the named indirect super-classes of a class.
		for (OntologyClass i : clazz1.getSuperClasses(false))
			System.out.println(i);

	}
}
