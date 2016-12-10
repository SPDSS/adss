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
 * This example shows how to manage the property characteristics.
 * @author Daniele Canavese
 **/
public class ManagesDataPropertyCharacteristics extends Sample
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

		// Add some sub-properties and sets its functionality.
		OntologyDataProperty property = ontology.getDataProperty("hasBoolean");
		property.setFunctional(true);
		ontology.flush();

		// Retrieve the property characteristics.
		System.out.println("Functional: " + property.isFunctional());
		System.out.println();

		// Remove the functionality
		property.setFunctional(false);
		ontology.flush();

		// Retrieve the property characteristics.
		System.out.println("Functional: " + property.isFunctional());
		System.out.println();
	}
}
