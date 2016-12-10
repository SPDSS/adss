/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to merge some ontologies.
 * @author Daniele Canavese
 **/
public class MergesOntologies extends Sample
{
	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Create a merged ontology.
		Collection<File> files = new HashSet<File>();
		files.add(getFile("owl/in1.owl"));
		files.add(getFile("owl/in2.owl"));
		new Ontology("http://security.polito.it/ontologies/samples/merged.owl", files, ReasonerType.HERMIT);

	}
}
