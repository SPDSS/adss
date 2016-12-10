/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.dataProperties;

import java.net.InetAddress;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.OntologyDataProperty;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to use the (de)serialization in a data property.
 * @author Daniele Canavese
 **/
public class HandlesSerialization extends Sample
{
	/** The first namespace. **/
	static final String NAMESPACE = "http://security.polito.it/ontologies/samples/test.owl#";

	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Creates an empty ontology.
		Ontology ontology = new Ontology(ReasonerType.HERMIT);

		// Adds some entities.
		OntologyClass clazz = ontology.addClass(NAMESPACE + "Class1");
		OntologyDataProperty property1 = ontology.addDataProperty(NAMESPACE + "dataProperty1");
		OntologyIndividual individual = ontology.addIndividual(NAMESPACE + "individual1", clazz);

		// Adds a Java object as a data property value.
		InetAddress address = InetAddress.getByName("1.2.3.4");
		individual.addDataPropertyValue(property1, address);
		ontology.flush();

		// Retrieves the object.
		for (InetAddress i : individual.getDataPropertyValues(property1, InetAddress.class))
			System.out.println(i);
	}
}
