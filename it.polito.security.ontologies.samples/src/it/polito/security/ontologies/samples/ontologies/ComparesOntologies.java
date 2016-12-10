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
 * This example shows how to compare two ontologies.
 * @author Daniele Canavese
 **/
public class ComparesOntologies extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Loads some ontologies.
		Ontology ontology1 = new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);
		Ontology ontology2 = new Ontology(getFile("owl/in2.owl"), ReasonerType.HERMIT);
		Ontology ontology3 = new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);

		// Check if the ontologies are equal.
		System.out.println(ontology1.equals(ontology2));
		System.out.println(ontology1.equals(ontology3));

	}
}
