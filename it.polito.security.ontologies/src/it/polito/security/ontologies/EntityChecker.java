/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * A simple entity checker.
 * @author Daniele Canavese
 **/
class EntityChecker implements OWLEntityChecker
{
	/**
	 * Creates the entity checker.
	 * @param ontology
	 *            The ontology.
	 **/
	public EntityChecker(final Ontology ontology)
	{
		this.ontology = ontology;
	}

	/**
	 * Retrieves an annotation.
	 * @param name
	 *            The entity name.
	 * @return Always <code>null</code>.
	 **/
	@Override
	public OWLAnnotationProperty getOWLAnnotationProperty(final String name)
	{
		return null;
	}

	/**
	 * Retrieves a class.
	 * @param name
	 *            The entity name.
	 * @return The OWL entity.
	 **/
	@Override
	public OWLClass getOWLClass(final String name)
	{
		return ontology.dataFactory.getOWLClass(IRI.create(name));
	}

	/**
	 * Retrieves a data property.
	 * @param name
	 *            The entity name.
	 * @return The OWL entity.
	 **/
	@Override
	public OWLDataProperty getOWLDataProperty(final String name)
	{
		return ontology.dataFactory.getOWLDataProperty(IRI.create(name));
	}

	/**
	 * Retrieves a data type.
	 * @param name
	 *            The entity name.
	 * @return The OWL entity.
	 **/
	@Override
	public OWLDatatype getOWLDatatype(final String name)
	{
		return ontology.dataFactory.getOWLDatatype(IRI.create(name));
	}

	/**
	 * Retrieves an individual.
	 * @param name
	 *            The entity name.
	 * @return The OWL entity.
	 **/
	@Override
	public OWLNamedIndividual getOWLIndividual(final String name)
	{
		return ontology.dataFactory.getOWLNamedIndividual(IRI.create(name));
	}

	/**
	 * Retrieves an object property.
	 * @param name
	 *            The entity name.
	 * @return The OWL entity.
	 **/
	@Override
	public OWLObjectProperty getOWLObjectProperty(final String name)
	{
		return ontology.dataFactory.getOWLObjectProperty(IRI.create(name));
	}

	/** The ontology. **/
	private Ontology ontology;
}
