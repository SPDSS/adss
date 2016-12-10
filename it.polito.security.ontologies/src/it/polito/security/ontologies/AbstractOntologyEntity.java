/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.util.List;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyChange;

/**
 * A generic ontology entity (i.e. classes, properties and individuals).
 * @author Luca Moretto, Daniele Canavese
 **/
abstract class AbstractOntologyEntity
{
	/**
	 * Creates an ontology entity.
	 * @param ontology
	 *            The ontology containing this entity.
	 * @param object
	 *            The object instance.
	 **/
	public AbstractOntologyEntity(final Ontology ontology, final OWLObject object)
	{
		this.ontology = ontology;
		this.object = object;
		if (object instanceof OWLEntity)
			iri = ((OWLEntity) object).getIRI().toString();
		else
			iri = null;
	}

	/**
	 * Compares two entities.
	 * @param object
	 *            The second entity to compare.
	 * @return <code>true</code> if the two entities are the same, <code>false</code> otherwise.
	 **/
	@Override
	public abstract boolean equals(Object object);

	/**
	 * Retrieves the entity IRI.
	 * @return The entity IRI or <code>null</code> if the entity is anonymous.
	 **/
	public String getIRI()
	{
		return iri;
	}

	/**
	 * Retrieves the entity simple name, that is the name without its namespace.
	 * @return The entity simple name or <code>null</code> if the entity is anonymous.
	 **/
	public String getName()
	{
		int position = iri != null ? iri.lastIndexOf("#") : -1;
		if (position < 0)
			return iri;
		else
			return iri.substring(position + 1);
	}

	/**
	 * Returns the entity namespace.
	 * @return The entity namespace, <code>null</code> if the entity is anonymous or an empty string if it has no
	 *         namespace.
	 **/
	public String getNamespace()
	{
		int position = iri != null ? iri.lastIndexOf("#") : -1;
		if (iri == null)
			return null;
		else if (position < 0)
			return "";
		else
			return iri.substring(0, position + 1);
	}

	/**
	 * Retrieve the OWL object.
	 * @return The OWL object.
	 **/
	protected OWLObject getObject()
	{
		return object;
	}

	/**
	 * Retrieve the ontology.
	 * @return The ontology.
	 **/
	protected Ontology getOntology()
	{
		return ontology;
	}

	/**
	 * Retrieves an ontology entity hash code.
	 * @return The entity hash code.
	 **/
	@Override
	public int hashCode()
	{
		return iri.hashCode();
	}

	/**
	 * Removes this entity from the ontology.
	 **/
	public void remove()
	{
		if (object instanceof OWLEntity)
		{
			((OWLEntity) object).accept(ontology.remover);
			ontology.ontologyManager.applyChanges(ontology.remover.getChanges());
			ontology.remover.reset();
		}
	}

	/**
	 * Sets the entity IRI.
	 * @param iri
	 *            The new IRI.
	 **/
	public void setIRI(final String iri)
	{
		if (object instanceof OWLEntity)
		{
			List<OWLOntologyChange> changes = ontology.renamer.changeIRI((OWLEntity) object, IRI.create(iri));
			ontology.ontologyManager.applyChanges(changes);
		}
	}

	/**
	 * Sets the entity simple name.
	 * @param name
	 *            The new simple name.
	 **/
	public void setName(final String name)
	{
		if (iri != null && object instanceof OWLEntity)
			setIRI(getNamespace() + name);
	}

	/**
	 * Sets the entity namespace.
	 * @param namespace
	 *            The new namespace.
	 **/
	public void setNamespace(final String namespace)
	{
		if (iri != null && object instanceof OWLEntity)
			setIRI(namespace + getName());
	}

	/**
	 * Converts this entity to a string (its qualified name).
	 * @return The qualified name of the entity.
	 **/
	@Override
	public String toString()
	{
		return getIRI();
	}

	/** The entity IRI. **/
	private String iri;
	/** The OWL object. **/
	private OWLObject object;
	/** The ontology containing this individual. **/
	private Ontology ontology;
}
