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
 * This example shows how to delete properties.
 * @author Daniele Canavese
 **/
public class DeletesDataProperties extends Sample
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

		// Print all the data properties in the ontology.
		for (OntologyDataProperty i : ontology.getTopDataProperty().getSubProperties(false))
			System.out.println(i);
		System.out.println();

		// Delete a property.
		OntologyDataProperty property = ontology.getDataProperty("hasBoolean");
		property.remove();
		ontology.flush();

		// Print all the data properties in the ontology again.
		for (OntologyDataProperty i : ontology.getTopDataProperty().getSubProperties(false))
			System.out.println(i);
	}
}
