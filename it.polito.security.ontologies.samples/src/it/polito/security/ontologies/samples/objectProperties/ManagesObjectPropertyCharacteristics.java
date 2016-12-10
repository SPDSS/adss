/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.objectProperties;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyObjectProperty;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to manage the property characteristics.
 * @author Daniele Canavese
 **/
public class ManagesObjectPropertyCharacteristics extends Sample
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

		// Add some sub-properties and sets some characteristics.
		OntologyObjectProperty property = ontology.getObjectProperty("hasObject");
		property.setTransitive(true);
		property.setSymmetric(true);
		property.setReflexive(true);
		ontology.flush();

		// Retrieve the property characteristics.
		System.out.println("Functional: " + property.isFunctional());
		System.out.println("Inverse functional: " + property.isInverseFunctional());
		System.out.println("Transitive: " + property.isTransitive());
		System.out.println("Symmetric: " + property.isSymmetric());
		System.out.println("Asymmetric: " + property.isAsymmetric());
		System.out.println("Reflexive: " + property.isReflexive());
		System.out.println("Irreflexive: " + property.isIrreflexive());
		System.out.println();

		// Removes some characteristics and sets the other ones.
		property.setFunctional(true);
		property.setInverseFunctional(true);
		property.setTransitive(false);
		property.setSymmetric(false);
		property.setAsymmetric(true);
		property.setReflexive(false);
		property.setIrreflexive(true);
		ontology.flush();

		// Retrieve the property characteristics.
		System.out.println("Functional: " + property.isFunctional());
		System.out.println("Inverse functional: " + property.isInverseFunctional());
		System.out.println("Transitive: " + property.isTransitive());
		System.out.println("Symmetric: " + property.isSymmetric());
		System.out.println("Asymmetric: " + property.isAsymmetric());
		System.out.println("Reflexive: " + property.isReflexive());
		System.out.println("Irreflexive: " + property.isIrreflexive());
		System.out.println();
	}
}
