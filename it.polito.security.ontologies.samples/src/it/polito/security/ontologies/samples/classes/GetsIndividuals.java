/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.classes;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to get the individuals in a class.
 * @author Daniele Canavese
 **/
public class GetsIndividuals extends Sample
{
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

		// Retrieve the direct individuals of a class.
		for (OntologyIndividual i : ontology.getClass("Foo").getIndividuals(true))
			System.out.println(i);
		System.out.println();

		// Retrieve the indirect individuals of a class.
		for (OntologyIndividual i : ontology.getClass("Foo").getIndividuals(false))
			System.out.println(i);

	}
}
