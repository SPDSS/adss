/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.individuals;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to delete individuals.
 * @author Daniele Canavese
 **/
public class DeletesIndividuals extends Sample
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

		// Print all the individuals in the ontology.
		for (OntologyIndividual i : ontology.getThing().getIndividuals(false))
			System.out.println(i);
		System.out.println();

		// Delete an individual.
		OntologyIndividual individual = ontology.getIndividual("a");
		individual.remove();
		ontology.flush();

		// Print all the individuals in the ontology again.
		for (OntologyIndividual i : ontology.getThing().getIndividuals(false))
			System.out.println(i);

	}
}
