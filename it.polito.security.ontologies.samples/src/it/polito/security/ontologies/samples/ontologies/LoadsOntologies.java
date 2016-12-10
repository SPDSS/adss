/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import java.io.FileInputStream;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to load some ontologies from an OWL file and an input stream.
 * @author Daniele Canavese
 **/
public class LoadsOntologies extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Loads an ontology from a file and set-up the Hermit reasoner.
		new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);

		// Loads an ontology from an input stream and set-up the Pellet reasoner.
		try (FileInputStream inputStream = new FileInputStream(getFile("owl/in2.owl")))
		{
			new Ontology(inputStream, ReasonerType.PELLET);
		}
	}
}
