/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.util.ArrayList;
import java.util.Collection;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.reasoner.ClassExpressionNotInProfileException;
import org.semanticweb.owlapi.reasoner.FreshEntitiesException;
import org.semanticweb.owlapi.reasoner.InconsistentOntologyException;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.ReasonerInterruptedException;
import org.semanticweb.owlapi.reasoner.TimeOutException;

import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * An ontology data property.
 * @author Daniele Canavese, Luca Moretto
 **/
public class OntologyDataProperty extends AbstractOntologyEntity
{
	/**
	 * Creates an ontology data property.
	 * @param ontology
	 *            The ontology containing this data property.
	 * @param instance
	 *            The entity.
	 **/
	protected OntologyDataProperty(Ontology ontology, OWLDataProperty instance)
	{
		super(ontology, instance);
		this.ontology = ontology;
		this.instance = instance;
	}

	/**
	 * Adds a data property equivalence axiom.
	 * @param ontologyProperty
	 *            The other property equivalent to the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(OntologyDataProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLEquivalentDataPropertiesAxiom(instance, ontologyProperty.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the data properties equivalence axiom between \""
				+ getIRI() + "\" and \"" + ontologyProperty.getIRI() + "\"");
		}
	}

	/**
	 * Adds a data property equivalence axiom.
	 * @param propertyName
	 *            The name of the equivalent data property.
	 * @throws NoSuchEntityException
	 *             If the specified data property does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(String propertyName) throws NoSuchEntityException, OntologyChangeException
	{
		addEquivalence(getOntology().getDataProperty(propertyName));
	}

	/**
	 * Adds a sub-property axiom.
	 * @param ontologyProperty
	 *            The sub-property of the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addSubProperty(OntologyDataProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLSubDataPropertyOfAxiom(ontologyProperty.instance, instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to set \"" + getIRI() + "\" as a sub-property of \""
				+ ontologyProperty.getIRI() + "\"");
		}
	}

	/**
	 * Adds a sub-property axiom.
	 * @param propertyName
	 *            A property expression.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If the property cannot be found.
	 **/
	public void addSubProperty(String propertyName) throws OntologyChangeException, NoSuchEntityException
	{
		addSubProperty(getOntology().getDataProperty(propertyName));
	}

	/**
	 * Adds a super-property axiom.
	 * @param ontologyProperty
	 *            The super-property of the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addSuperProperty(OntologyDataProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLSubDataPropertyOfAxiom(instance, ontologyProperty.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to set \"" + getIRI() + "\" as a super-property of \""
				+ ontologyProperty.getIRI() + "\"");
		}
	}

	/**
	 * Adds a super-property axiom.
	 * @param propertyName
	 *            A property expression.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If the property cannot be found.
	 **/
	public void addSuperProperty(String propertyName) throws OntologyChangeException, NoSuchEntityException
	{
		addSuperProperty(getOntology().getDataProperty(propertyName));
	}

	/**
	 * Compares two entities.
	 * @param object
	 *            The second entity to compare.
	 * @return <code>true</code> if the two entities are the same, <code>false</code> otherwise.
	 **/
	@Override
	public boolean equals(Object object)
	{
		if (object instanceof OntologyDataProperty == true)
			try
		{
				if (((OntologyDataProperty) object).getIRI().equals(getIRI()) == true)
					return true;
				for (OWLDataPropertyExpression property : instance.getEquivalentProperties(getOntology().ontology))
					if (property instanceof OWLDataProperty)
						if (((OWLDataProperty) property).getIRI().toString()
							.equals(((OntologyDataProperty) object).getIRI()) == true)
							return true;
		}
		catch (Exception e)
		{
		}
		return false;
	}

	/**
	 * Retrieves the first property domain.
	 * @return The first property domain or <code>null</code> if it does not exist.
	 **/
	public OntologyClass getDomain()
	{
		return getDomains().iterator().next();
	}

	/**
	 * Retrieves the property domain.
	 * @return The property domain.
	 **/
	public Collection<OntologyClass> getDomains()
	{
		Collection<OntologyClass> classes = new ArrayList<>();
		for (OWLClassExpression i : instance.getDomains(ontology.ontology))
			classes.add(new OntologyClass(ontology, i));
		return classes;
	}

	/**
	 * Retrieves the named properties equivalent to the current one.
	 * @return The set of equivalent properties.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyDataProperty> getEquivalentProperties() throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyDataProperty> equivalentProperties = new ArrayList<>();

			for (OWLDataProperty property : getOntology().reasoner.getEquivalentDataProperties(instance).getEntities())
				equivalentProperties.add(new OntologyDataProperty(getOntology(), property));

			return equivalentProperties;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The property \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The property \"" + getIRI() + "\" does not exist");
		}
		catch (ReasonerInterruptedException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
		catch (TimeOutException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
	}

	/**
	 * Retrieves the first named property equivalent to the current one.
	 * @return The first equivalent property or <code>null</code> if there is not an equivalent property.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyDataProperty getEquivalentProperty() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		Collection<OntologyDataProperty> properties = getEquivalentProperties();
		if (properties.isEmpty() == true)
			return null;
		else
			return properties.iterator().next();
	}

	/**
	 * Retrieves the obvious named properties equivalent to the current one.
	 * @return The set of equivalent properties.
	 **/
	public Collection<OntologyDataProperty> getObviousEquivalentProperties()
	{
		Collection<OntologyDataProperty> equivalentProperties = new ArrayList<>();

		for (OWLEquivalentDataPropertiesAxiom x : getOntology().ontology.getEquivalentDataPropertiesAxioms(instance))
			for (OWLDataProperty p : x.getDataPropertiesInSignature())
				if (p.equals(instance) == false)
					equivalentProperties.add(new OntologyDataProperty(getOntology(), p));

		return equivalentProperties;
	}

	/**
	 * Retrieves the first obvious named property equivalent to the current one.
	 * @return The first equivalent property or <code>null</code> if there is not an equivalent property.
	 **/
	public OntologyDataProperty getObviousEquivalentProperty()
	{
		Collection<OntologyDataProperty> properties = getObviousEquivalentProperties();
		if (properties.isEmpty() == true)
			return null;
		else
			return properties.iterator().next();
	}

	/**
	 * Retrieves the named obvious sub-properties of the current one.
	 * @return The set of sub-properties.
	 **/
	public Collection<OntologyDataProperty> getObviousSubProperties()
	{
		Collection<OntologyDataProperty> subProperties = new ArrayList<>();

		for (OWLSubDataPropertyOfAxiom x : getOntology().ontology.getDataSubPropertyAxiomsForSuperProperty(instance))
			if (x.getSubProperty() instanceof OWLDataProperty)
				subProperties.add(new OntologyDataProperty(getOntology(), (OWLDataProperty) x.getSubProperty()));

		return subProperties;
	}

	/**
	 * Retrieves the first obvious direct named sub-property of the current one.
	 * @return The first sub-property.
	 **/
	public OntologyDataProperty getObviousSubProperty()
	{
		return getObviousSubProperties().iterator().next();
	}

	/**
	 * Retrieves the named obvious super-properties of the current one.
	 * @return The set of super-properties.
	 **/
	public Collection<OntologyDataProperty> getObviousSuperProperties()
	{
		Collection<OntologyDataProperty> subProperties = new ArrayList<>();

		for (OWLSubDataPropertyOfAxiom x : getOntology().ontology.getDataSubPropertyAxiomsForSubProperty(instance))
			if (x.getSuperProperty() instanceof OWLDataProperty)
				subProperties.add(new OntologyDataProperty(getOntology(), (OWLDataProperty) x.getSuperProperty()));

		return subProperties;
	}

	/**
	 * Retrieves the first obvious direct named super-property of the current one.
	 * @return The first super-property.
	 **/
	public OntologyDataProperty getObviousSuperProperty()
	{
		return getObviousSuperProperties().iterator().next();
	}

	/**
	 * Retrieves the first property range.
	 * @return The first property range or <code>null</code> if it does not exist.
	 **/
	public Class<?> getRange()
	{
		return getRanges().iterator().next();
	}

	/**
	 * Retrieves the property range.
	 * @return The property range.
	 **/
	public Collection<Class<?>> getRanges()
	{
		Collection<Class<?>> classes = new ArrayList<>();
		for (OWLDataRange i : instance.getRanges(ontology.ontology))
			if (i.asOWLDatatype().isBoolean())
				classes.add(Boolean.class);
			else if (i.asOWLDatatype().isDouble())
				classes.add(Double.class);
			else if (i.asOWLDatatype().isFloat())
				classes.add(Float.class);
			else if (i.asOWLDatatype().isInteger())
				classes.add(Integer.class);
			else if (i.asOWLDatatype().isString())
				classes.add(String.class);
		return classes;
	}

	/**
	 * Retrieves the named sub-properties of the current one.
	 * @param direct
	 *            Specifies if the method will retrieve only the direct properties or the full hierarchy.
	 * @return The set of sub-properties.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyDataProperty> getSubProperties(boolean direct) throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyDataProperty> subProperties = new ArrayList<>();

			for (Node<OWLDataProperty> node : getOntology().reasoner.getSubDataProperties(instance, direct).getNodes())
				for (OWLDataProperty property : node.getEntities())
					subProperties.add(new OntologyDataProperty(getOntology(), property));

			return subProperties;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The property \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The property \"" + getIRI() + "\" does not exist");
		}
		catch (ReasonerInterruptedException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
		catch (TimeOutException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
	}

	/**
	 * Retrieves the first direct named sub-property of the current one.
	 * @return The first sub-property.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyDataProperty getSubProperty() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		return getSubProperties(true).iterator().next();
	}

	/**
	 * Retrieves the named super-properties of the current one.
	 * @param direct
	 *            Specifies if the method will retrieve only the direct properties or the full hierarchy.
	 * @return The set of super-properties.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyDataProperty> getSuperProperties(boolean direct) throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyDataProperty> superProperties = new ArrayList<>();

			for (Node<OWLDataProperty> node : getOntology().reasoner.getSuperDataProperties(instance, direct)
				.getNodes())
				for (OWLDataProperty property : node.getEntities())
					superProperties.add(new OntologyDataProperty(getOntology(), property));

			return superProperties;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The property \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The property \"" + getIRI() + "\" does not exist");
		}
		catch (ReasonerInterruptedException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
		catch (TimeOutException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
	}

	/**
	 * Retrieves the first direct named super-property of the current one.
	 * @return The first super-property.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyDataProperty getSuperProperty() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		return getSuperProperties(true).iterator().next();
	}

	/**
	 * Retrieves the functional characteristic of the property.
	 * @return <code>true</code> if the property is functional, <code>false</code> otherwise.
	 **/
	public boolean isFunctional()
	{
		return instance.isFunctional(ontology.ontology);
	}

	/**
	 * Sets the functional characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setFunctional(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLFunctionalDataPropertyAxiom(instance);
			if (value)
				ontology.ontologyManager.addAxiom(ontology.ontology, axiom);
			else
				ontology.ontologyManager.removeAxiom(ontology.ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the characteristic axiom for \"" + getName() + "\"");
		}
	}

	/** This property in the OWL ontology. **/
	protected OWLDataProperty instance;

	/** The ontology. **/
	private Ontology ontology;
}
