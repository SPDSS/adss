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
 * This example shows how to get the Thing, Nothing, topDataProperty and topObjectProperty entities.
 * @author Daniele Canavese
 **/
public class UsesDefaultEntities extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Loads an ontology.
		Ontology ontology = new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);

		// Get the Thing class.
		System.out.println(ontology.getThing());

		// Get the Nothing class.
		System.out.println(ontology.getNothing());

		// Get the topDataProperty property.
		System.out.println(ontology.getTopDataProperty());

		// Get the topObjectProperty property.
		System.out.println(ontology.getTopObjectProperty());

		// Get the bottomDataProperty property.
		System.out.println(ontology.getBottomDataProperty());

		// Get the bottomObjectProperty property.
		System.out.println(ontology.getBottomObjectProperty());
	}
}
