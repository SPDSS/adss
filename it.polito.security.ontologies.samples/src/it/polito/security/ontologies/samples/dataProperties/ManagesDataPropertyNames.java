/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.dataProperties;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyDataProperty;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to rename properties.
 * @author Daniele Canavese
 **/
public class ManagesDataPropertyNames extends Sample
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
		OntologyDataProperty property = ontology.getDataProperty("hasBoolean");

		// Get and set the class IRI.
		System.out.println(property.getIRI());
		property.setIRI(NAMESPACE1 + "hasBOOLEAN");
		property = ontology.getDataProperty("hasBOOLEAN"); // Search the new class since the old does not exists
		// anymore.
		System.out.println(property.getIRI());

		// Get and set the class simple name.
		System.out.println(property.getIRI() + " " + property.getName());
		property.setName("hasBoolean");
		property = ontology.getDataProperty("hasBoolean");
		System.out.println(property.getIRI() + " " + property.getName());

		// Get and set the class namespace.
		System.out.println(property.getIRI() + " " + property.getNamespace());
		property.setNamespace(NAMESPACE2);
		property = ontology.getDataProperty(NAMESPACE2 + "hasBoolean");
		System.out.println(property.getIRI() + " " + property.getNamespace());

	}
}
