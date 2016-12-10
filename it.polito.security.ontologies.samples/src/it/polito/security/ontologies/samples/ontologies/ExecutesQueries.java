/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import java.util.Collection;
import java.util.Map;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to execute some SPARQL-DL queries.
 * @author Daniele Canavese
 **/
public class ExecutesQueries extends Sample
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
		// Load an ontology.
		Ontology ontology = new Ontology(getFile("owl/in1.owl"), ReasonerType.HERMIT);

		// Perform an ASK query to check if something is true.
		System.out.println(ontology.executeAskQuery("PREFIX ex: <" + NAMESPACE
			+ "> ASK { DirectSubClassOf(ex:Bar, ex:Foo) }"));
		System.out.println(ontology.executeAskQuery("PREFIX ex: <" + NAMESPACE
			+ "> ASK { DirectSubClassOf(ex:Foo, ex:Bar) }"));

		// Perform a SELECT query to search for something.
		Collection<Map<String, Object>> r =
			ontology.executeSelectQuery("SELECT ?a ?b WHERE { DirectSubClassOf(?a, ?b) }");
		for (Map<String, Object> i : r)
			System.out.println(i.get("a") + " " + i.get("b"));

	}
}
