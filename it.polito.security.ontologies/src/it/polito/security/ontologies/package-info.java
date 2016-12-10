/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
/**
 * <p>
 * This package contains all the classes and exceptions needed to handle an ontology with ease. It is effectively a
 * wrapper for other APIs, in particular OWL API, the Hermit and Pellet reasoners API and SPARQL-DL API.
 * </p>
 * <p>
 * Note that the {@link it.polito.security.ontologies.Ontology} class manipulates the ontology-wide axioms while
 * {@link it.polito.security.ontologies.OntologyIndividual} handle the individual axioms, so if you want to add a
 * property assertion over an individual you must use the latter class.
 * </p>
 * <p>
 * Also note that the APIs use a buffering reasoner, meaning that every ontology changes is not performed until the
 * method {@link it.polito.security.ontologies.Ontology#flush} is called.
 * </p>
 * <p>
 * The {@link it.polito.security.ontologies.Ontology} class supports the following operations:
 * </p>
 * <ul>
 * <li>Loads an ontology from an OWL file or an input stream.</li>
 * <li>Adds the IRI mapping for managing included ontologies.</li>
 * <li>Duplicates an ontology.</li>
 * <li>Creates an anonymous empty ontology.</li>
 * <li>Adds new classes, data/object properties and individuals.</li>
 * <li>Check if the ontology contains a class, a data/object property or an individual.</li>
 * <li>Check if two ontologies are equivalent.</li>
 * <li>Execute SPARQL-DL ASK and SELECT queries.</li>
 * <li>Search a class/property/individual by its full name, its simple name or using the Manchester syntax.</li>
 * <li>Get and set the ontology IRI.</li>
 * <li>Perform a consistency check and retrieve the set of inconsistent axioms.</li>
 * <li>Retrieve the Nothing, Thing, topDataProperty and topObjectProperty entities.</li>
 * <li>Check if an ontology is in the OWL 2 EL domain, its expressivity and the axiom count.</li>
 * <li>Merging a set of ontologies from a collection of files.</li>
 * <li>Asking the reasoner to precompute all the inferences.</li>
 * <li>Save an ontology to a file/output stream.</li>
 * <li>Serialize an ontology to a string.</li>
 * <li>Change the reasoner on-the-fly.</li>
 * <li>Add SWRL rules.</li>
 * <li>Add custom SWRL built-ins.</li>
 * </ul>
 * <p>
 * The {@link it.polito.security.ontologies.OntologyClass} class supports the following operations:
 * </p>
 * <ul>
 * <li>Get and set the IRI, the simple name and the namespace.</li>
 * <li>Delete a class and all its related axioms.</li>
 * <li>Set and get equivalent classes.</li>
 * <li>Compare two classes for their equivalence.</li>
 * <li>Detect it a class is equivalent to Nothing or Thing.</li>
 * <li>Set and get the super-classes.</li>
 * <li>Set and get the sub-classes.</li>
 * <li>Retrieve all the direct or indirect individuals in a class.</li>
 * </ul>
 * <p>
 * The {@link it.polito.security.ontologies.OntologyDataProperty} class supports the following operations:
 * </p>
 * <ul>
 * <li>Get and set the IRI, the simple name and the namespace.</li>
 * <li>Delete the property and all its related axioms.</li>
 * <li>Set and get equivalent properties.</li>
 * <li>Compare two properties for their equivalence.</li>
 * <li>Set and get the super-properties.</li>
 * <li>Set and get the sub-properties.</li>
 * <li>Serialization and deserialization of custom Java objects.</li>
 * </ul>
 * <p>
 * The {@link it.polito.security.ontologies.OntologyObjectProperty} class supports the following operations:
 * </p>
 * <ul>
 * <li>Get and set the IRI, the simple name and the namespace.</li>
 * <li>Delete the property and all its related axioms.</li>
 * <li>Set and get equivalent properties.</li>
 * <li>Compare two properties for their equivalence.</li>
 * <li>Set and get the super-properties.</li>
 * <li>Set and get the sub-properties.</li>
 * <li>Set and get the inverse properties.</li>
 * <li>Add a sub-property chain.</li>
 * </ul>
 * <p>
 * The {@link it.polito.security.ontologies.OntologyIndividual} class supports the following operations:
 * </p>
 * <ul>
 * <li>Get and set the IRI, the simple name and the namespace.</li>
 * <li>Delete the individual and all its related axioms.</li>
 * <li>Set and get equivalent individuals.</li>
 * <li>Compare two individuals for their equivalence.</li>
 * <li>Set, get and remove boolean/float/double/integer/string data property assertions.</li>
 * <li>Set, get and remove object property assertions.</li>
 * <li>Add, check and retrieve the individual containing classes.</li>
 * </ul>
 **/
package it.polito.security.ontologies;

