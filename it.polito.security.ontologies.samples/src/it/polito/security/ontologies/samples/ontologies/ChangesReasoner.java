/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to change the reasoner.
 * @author Daniele Canavese
 **/
public class ChangesReasoner extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Loads an ontology and set-up Hermit.
		Ontology ontology = new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);

		// Change the reasoner to Pellet and perform a consistency check.
		ontology.setReasoner(ReasonerType.PELLET);
		System.out.println(ontology.isConsistent());

		// Change the reasoner to FaCT++ and perform a consistency check.
		ontology.setReasoner(ReasonerType.FACTPLUSPLUS);
		System.out.println(ontology.isConsistent());

	}
}
