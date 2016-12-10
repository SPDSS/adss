/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.serialization;

import java.util.Collection;

import it.polito.security.ontologies.samples.SamplesPackage;

import it.polito.security.ontologies.samples.Class2;

import it.polito.security.ontologies.samples.Class1;

import it.polito.security.ontologies.samples.SamplesFactory;

import it.polito.security.ontologies.OntologyIndividual;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to serialize/deserialize a Java object into/from an ontology.
 * @author Daniele Canavese
 **/
public class SerializesObjects extends Sample
{
	/** The namespace of the ontology. **/
	public static final String NAMESPACE = "http://security.polito.it/ontologies/samples/test.owl#";

	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Create an empty ontology.
		Ontology ontology = new Ontology(ReasonerType.HERMIT);

		// Add some entities.
		ontology.addClass(NAMESPACE + "Class1");
		ontology.addClass(NAMESPACE + "Class2");
		ontology.addDataProperty(NAMESPACE + "hasSomething");
		ontology.addObjectProperty(NAMESPACE + "hasClasses");

		// Commit the results.
		ontology.flush();

		// Serialize something.
		Class1 object1 = SamplesFactory.eINSTANCE.createClass1();	
		Class2 object2 = SamplesFactory.eINSTANCE.createClass2();
		object1.setSomething("something");
		object1.getClasses().add(object2);
		
		ontology.serialize(object1);
		ontology.flush();

		// Prints the ontology content.
		for (OntologyIndividual i : ontology.getClass(NAMESPACE + "Class1").getIndividuals(false))
		{
			System.out.println("Class1 " + i);
			System.out.println("  hasSomething = " + i.getDataPropertyValue(NAMESPACE + "hasSomething", String.class));
			System.out.println("  hasClasses = " + i.getObjectPropertyValue(NAMESPACE + "hasClasses"));
		}
		for (OntologyIndividual i : ontology.getClass(NAMESPACE + "Class2").getIndividuals(false))
			System.out.println("Class2 " + i);
		
		// Deserializes the objects from the ontology.
		Collection<Object> deserialized = ontology.deserialize(SamplesPackage.Literals.CLASS1, SamplesFactory.eINSTANCE);
		
		// Prints the Java objects.
		for (Object i : deserialized)
		{
			System.out.println("Object " + i);
			System.out.println("  hasSomething = " + ((Class1) i).getSomething());
			System.out.println("  hasClasses = " + ((Class1) i).getClasses());
		}
	}
}
