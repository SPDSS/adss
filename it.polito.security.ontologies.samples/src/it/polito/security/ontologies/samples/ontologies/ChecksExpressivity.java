/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyObjectProperty;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to checks the expressivity of an ontology.
 * @author Daniele Canavese
 **/
public class ChecksExpressivity extends Sample
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
		// Create an ontology.
		Ontology ontology = new Ontology(ReasonerType.HERMIT);

		// Check the expressivity.
		System.out.println(ontology.getExpressivity());
		System.out.println(ontology.isEL());

		// Add an inverse object property.
		OntologyObjectProperty property1 = ontology.addObjectProperty(NAMESPACE + "property1");
		OntologyObjectProperty property2 = ontology.addObjectProperty(NAMESPACE + "property2");
		property1.addInverseProperty(property2);
		ontology.flush();

		// Check again the expressivity.
		System.out.println(ontology.getExpressivity());
		System.out.println(ontology.isEL());
	}
}
