/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to manage the ontology inclusions.
 * @author Daniele Canavese
 **/
public class ManagesInclusions extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Loads an ontology ignoring all the missing imports, that is the default behavior.
		new Ontology(getFile("owl/in3.owl"), ReasonerType.HERMIT);

		// If we want to handle the inclusions, we must create the mappings for the imports and then load the ontology.
		Map<String, File> mappings = new HashMap<String, File>();
		mappings.put("http://security.polito.it/ontologies/samples/in1.owl", getFile("owl/in1.owl"));
		mappings.put("http://security.polito.it/ontologies/samples/in2.owl", getFile("owl/in2.owl"));
		new Ontology(getFile("owl/in3.owl"), ReasonerType.HERMIT, mappings);

	}
}
