/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.axiom.om.util.Base64;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.reasoner.ClassExpressionNotInProfileException;
import org.semanticweb.owlapi.reasoner.FreshEntitiesException;
import org.semanticweb.owlapi.reasoner.InconsistentOntologyException;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.ReasonerInterruptedException;
import org.semanticweb.owlapi.reasoner.TimeOutException;

import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * An ontology individual.
 * @author Daniele Canavese, Luca Moretto
 **/
public class OntologyIndividual extends AbstractOntologyEntity
{
	/**
	 * Creates an ontology individual.
	 * @param ontology
	 *            The ontology containing this individual.
	 * @param i
	 *            The entity.
	 **/
	protected OntologyIndividual(Ontology ontology, OWLIndividual i)
	{
		super(ontology, i);
		this.instance = i;
	}

	/**
	 * Adds a data property assertion axiom over this individual.
	 * @param <T>
	 *            The data type.
	 * @param ontologyProperty
	 *            The property.
	 * @param value
	 *            The target value.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 **/
	public <T> void addDataPropertyValue(OntologyDataProperty ontologyProperty, T value)
		throws OntologyChangeException, IOException
	{
		try
		{
			OWLDataPropertyAssertionAxiom axiom =
				getOntology().dataFactory.getOWLDataPropertyAssertionAxiom(ontologyProperty.instance, instance,
					encodeLiteral(value));
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the boolean data property assertion axiom for \""
				+ getIRI() + "\"");
		}
	}

	/**
	 * Adds a data property assertion axiom over this individual.
	 * @param <T>
	 *            The data type.
	 * @param ontologyProperty
	 *            The property name.
	 * @param value
	 *            The target value.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 **/
	public <T> void addDataPropertyValue(String ontologyProperty, T value) throws OntologyChangeException,
		NoSuchEntityException, IOException
	{
		addDataPropertyValue(getOntology().getDataProperty(ontologyProperty), value);
	}

	/**
	 * Adds an individual equivalence axiom.
	 * @param ontologyIndividual
	 *            The other individual equivalent to the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(OntologyIndividual ontologyIndividual) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLSameIndividualAxiom(instance, ontologyIndividual.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the individual equivalence axiom between \"" + getIRI()
				+ "\" and \"" + ontologyIndividual.getIRI() + "\"");
		}
	}

	/**
	 * Adds an individual equivalence axiom.
	 * @param individualName
	 *            The name of the equivalent individual.
	 * @throws NoSuchEntityException
	 *             If the specified object property does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(String individualName) throws NoSuchEntityException, OntologyChangeException
	{
		addEquivalence(getOntology().getIndividual(individualName));
	}

	/**
	 * Adds an object property over this individual and another one.
	 * @param ontologyProperty
	 *            The property.
	 * @param ontologyIndividual
	 *            The target individual.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addObjectPropertyValue(OntologyObjectProperty ontologyProperty, OntologyIndividual ontologyIndividual)
		throws OntologyChangeException
	{
		try
		{
			OWLObjectPropertyAssertionAxiom axiom =
				getOntology().dataFactory.getOWLObjectPropertyAssertionAxiom(
					ontologyProperty.instance.asOWLObjectProperty(), instance, ontologyIndividual.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the object property assertion axiom for \"" + getIRI()
				+ "\"");
		}
	}

	/**
	 * Adds an object property over this individual and another one.
	 * @param ontologyProperty
	 *            The property.
	 * @param individualName
	 *            The full qualified name of the target individual.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addObjectPropertyValue(OntologyObjectProperty ontologyProperty, String individualName)
		throws NoSuchEntityException, OntologyChangeException
	{
		addObjectPropertyValue(ontologyProperty, getOntology().getIndividual(individualName));
	}

	/**
	 * Adds an object property over this individual and another one.
	 * @param propertyName
	 *            The full qualified name of the property.
	 * @param ontologyIndividual
	 *            The target individual.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addObjectPropertyValue(String propertyName, OntologyIndividual ontologyIndividual)
		throws NoSuchEntityException, OntologyChangeException
	{
		addObjectPropertyValue(getOntology().getObjectProperty(propertyName), ontologyIndividual);
	}

	/**
	 * Adds an object property over this individual and another one.
	 * @param propertyName
	 *            The full qualified name of the property.
	 * @param individualName
	 *            The full qualified name of the target individual.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addObjectPropertyValue(String propertyName, String individualName) throws NoSuchEntityException,
		OntologyChangeException
	{
		addObjectPropertyValue(getOntology().getObjectProperty(propertyName),
			getOntology().getIndividual(individualName));
	}

	/**
	 * Adds this individual to a class.
	 * @param ontologyClass
	 *            The class.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addToClass(OntologyClass ontologyClass) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLClassAssertionAxiom(ontologyClass.instance, instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the class assertion axiom for \"" + getIRI() + "\"");
		}
	}

	/**
	 * Adds this individual to a class.
	 * @param className
	 *            The full qualified name of the class.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public void addToClass(String className) throws OntologyChangeException, ParsingErrorException
	{
		addToClass(getOntology().getClass(className));
	}

	/**
	 * Decodes an OWL literal into a specific type.
	 * @param <T>
	 *            The data type.
	 * @param literal
	 *            The literal to parse.
	 * @param clazz
	 *            The desired type.
	 * @return The corresponding Java object to the literal.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	private <T> Object decodeLiteral(OWLLiteral literal, Class<T> clazz) throws ClassNotFoundException, IOException
	{
		if ((clazz.equals(Boolean.class) || clazz.equals(boolean.class)) && literal.getDatatype().isBoolean())
			return literal.parseBoolean();
		else if ((clazz.equals(Double.class) || clazz.equals(double.class)) && literal.getDatatype().isDouble())
			return literal.parseDouble();
		else if ((clazz.equals(Float.class) || clazz.equals(float.class)) && literal.getDatatype().isFloat())
			return literal.parseFloat();
		else if ((clazz.equals(Integer.class) || clazz.equals(int.class)) && literal.getDatatype().isInteger())
			return literal.parseInteger();
		else if (clazz.equals(String.class))
			return literal.getLiteral();
		else
			try (ByteArrayInputStream in = new ByteArrayInputStream(Base64.decode(literal.getLiteral()));
				ObjectInputStream i = new ObjectInputStream(in))
			{
				return i.readObject();
			}
	}

	/**
	 * Encodes a value into an OWL literal.
	 * @param <T>
	 *            The data type.
	 * @param value
	 *            The value to convert.
	 * @return The corresponding OWL literal.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 **/
	private <T> OWLLiteral encodeLiteral(T value) throws IOException
	{
		if (value instanceof Boolean)
			return getOntology().dataFactory.getOWLLiteral((Boolean) value);
		else if (value instanceof Double)
			return getOntology().dataFactory.getOWLLiteral((Double) value);
		else if (value instanceof Float)
			return getOntology().dataFactory.getOWLLiteral((Float) value);
		else if (value instanceof Integer)
			return getOntology().dataFactory.getOWLLiteral((Integer) value);
		else if (value instanceof String)
			return getOntology().dataFactory.getOWLLiteral((String) value);
		else
			try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				ObjectOutputStream o = new ObjectOutputStream(out))
			{
				o.writeObject(value);
				return getOntology().dataFactory.getOWLLiteral(Base64.encode(out.toByteArray()));
			}
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
		if (object instanceof OntologyIndividual == true)
			try
			{
				if (((OntologyIndividual) object).getIRI().equals(getIRI()) == true)
					return true;
				for (OWLIndividual individual : instance.getSameIndividuals(getOntology().ontology))
					if (individual instanceof OWLNamedIndividual)
						if (((OWLNamedIndividual) individual).getIRI().toString()
							.equals(((OntologyIndividual) object).getIRI()) == true)
							return true;
			}
			catch (Exception e)
			{
			}
		return false;
	}

	/**
	 * Retrieves the first direct class containing this individual. This is a useful method if the individual is
	 * contained only in one class.
	 * @return The first class containing this individual.
	 **/
	public OntologyClass getContainingClass()
	{
		return getContainingClasses(true).iterator().next();
	}

	/**
	 * Retrieves the classes containing this individual.
	 * @param direct
	 *            Specifies if the method will retrieve only the direct classes or the full hierarchy.
	 * @return The collection of classes containing this individual.
	 **/
	public Collection<OntologyClass> getContainingClasses(boolean direct)
	{
		ArrayList<OntologyClass> classes = new ArrayList<>();

		if (instance instanceof OWLNamedIndividual)
			for (Node<OWLClass> node : getOntology().reasoner.getTypes((OWLNamedIndividual) instance, direct)
				.getNodes())
				for (OWLClass concept : node.getEntities())
					classes.add(new OntologyClass(getOntology(), concept));

		return classes;
	}

	/**
	 * Return the first data property value having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property.
	 * @param type
	 *            The base type of the data property.
	 * @return The first value of the property or <code>null</code> if this property is not used.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	public <T> T getDataPropertyValue(OntologyDataProperty ontologyProperty, Class<T> type)
		throws NoSuchEntityException, InconsistencyException, ReasoningInterruptedException, ClassNotFoundException,
		IOException
	{
		Collection<T> values = getDataPropertyValues(ontologyProperty, type);
		if (values.isEmpty() == true)
			return null;
		else
			return values.iterator().next();
	}

	/**
	 * Return the first data property value having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property name.
	 * @param type
	 *            The base type of the data property.
	 * @return The first value of the property or <code>null</code> if this property is not used.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	public <T> T getDataPropertyValue(String ontologyProperty, Class<T> type) throws NoSuchEntityException,
		InconsistencyException, ReasoningInterruptedException, ClassNotFoundException, IOException
	{
		return getDataPropertyValue(getOntology().getDataProperty(ontologyProperty), type);
	}

	/**
	 * Returns a data property values having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property.
	 * @param type
	 *            The base type of the data property.
	 * @return The list of the values of the property.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	@SuppressWarnings("unchecked")
	public <T> Collection<T> getDataPropertyValues(OntologyDataProperty ontologyProperty, Class<T> type)
		throws InconsistencyException, NoSuchEntityException, ReasoningInterruptedException, ClassNotFoundException,
		IOException
	{
		try
		{
			Collection<T> values = new HashSet<>();
			if (instance instanceof OWLNamedIndividual)
			{
				Set<OWLLiteral> literals =
					getOntology().reasoner.getDataPropertyValues((OWLNamedIndividual) instance,
						ontologyProperty.instance);
				for (OWLLiteral literal : literals)
					values.add((T) decodeLiteral(literal, type));
			}

			return values;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The data property \"" + ontologyProperty.getIRI() + "\" does not exist");
		}
		catch (TimeOutException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
	}

	/**
	 * Returns a data property values having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property name.
	 * @param type
	 *            The base type of the data property.
	 * @return The list of the values of the property.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	public <T> Collection<T> getDataPropertyValues(String ontologyProperty, Class<T> type)
		throws InconsistencyException, NoSuchEntityException, ReasoningInterruptedException, ClassNotFoundException,
		IOException
	{
		return getDataPropertyValues(getOntology().getDataProperty(ontologyProperty), type);
	}

	/**
	 * Retrieves the first named individual equivalent to the current one.
	 * @return The first equivalent individual or <code>null</code> if there is not an equivalent individual.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyIndividual getEquivalentIndividual() throws InconsistencyException, NoSuchEntityException,
		ReasoningInterruptedException
	{
		Collection<OntologyIndividual> individuals = getEquivalentIndividuals();
		if (individuals.isEmpty() == true)
			return null;
		else
			return individuals.iterator().next();
	}

	/**
	 * Retrieves the named individuals equivalent to the current one.
	 * @return The set of equivalent individuals.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyIndividual> getEquivalentIndividuals() throws InconsistencyException,
		NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyIndividual> equivalentIndividuals = new ArrayList<>();

			if (instance instanceof OWLNamedIndividual)
				for (OWLNamedIndividual individual : getOntology().reasoner.getSameIndividuals(
					(OWLNamedIndividual) instance).getEntities())
					equivalentIndividuals.add(new OntologyIndividual(getOntology(), individual));

			return equivalentIndividuals;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The individual \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The individual \"" + getIRI() + "\" does not exist");
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
	 * Return the first object property value having this individual as a subject.
	 * @param ontologyProperty
	 *            The data property.
	 * @return The first value of the property or <code>null</code> if this property is not defined.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If the entity does not exist.
	 **/
	public OntologyIndividual getObjectPropertyValue(OntologyObjectProperty ontologyProperty)
		throws InconsistencyException, ReasoningInterruptedException, NoSuchEntityException
	{
		Collection<OntologyIndividual> values = getObjectPropertyValues(ontologyProperty);
		if (values.isEmpty() == true)
			return null;
		else
			return values.iterator().next();
	}

	/**
	 * Returns the first object property value having this individual as a subject.
	 * @param propertyName
	 *            The full qualified name of the property.
	 * @return The first value of the property or <code>null</code> if this property is not defined.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 **/
	public OntologyIndividual getObjectPropertyValue(String propertyName) throws InconsistencyException,
		NoSuchEntityException, ReasoningInterruptedException
	{
		return getObjectPropertyValue(getOntology().getObjectProperty(propertyName));
	}

	/**
	 * Returns the object property values having this individual as a subject.
	 * @param ontologyProperty
	 *            The data property.
	 * @return The list of the object individuals of the property.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If the entity does not exist.
	 **/
	public Collection<OntologyIndividual> getObjectPropertyValues(OntologyObjectProperty ontologyProperty)
		throws InconsistencyException, ReasoningInterruptedException, NoSuchEntityException
	{
		try
		{
			ArrayList<OntologyIndividual> individuals = new ArrayList<>();

			OWLNamedIndividual subject = getOntology().dataFactory.getOWLNamedIndividual(IRI.create(getIRI()));
			for (Node<OWLNamedIndividual> instance : getOntology().reasoner.getObjectPropertyValues(subject,
				ontologyProperty.instance))
			{
				OntologyIndividual individual =
					new OntologyIndividual(getOntology(), instance.getRepresentativeElement());
				individuals.add(individual);
			}

			return individuals;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The object property \"" + ontologyProperty.getIRI() + "\" does not exist");
		}
		catch (TimeOutException e)
		{
			throw new ReasoningInterruptedException("Reasoning interrupted");
		}
	}

	/**
	 * Returns the object property values having this individual as a subject.
	 * @param propertyName
	 *            The full qualified name of the property.
	 * @return The list of the object individuals of the property.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 **/
	public Collection<OntologyIndividual> getObjectPropertyValues(String propertyName) throws InconsistencyException,
		NoSuchEntityException, ReasoningInterruptedException
	{
		return getObjectPropertyValues(getOntology().getObjectProperty(propertyName));
	}

	/**
	 * Retrieves the first obvious direct class containing this individual.
	 * @return The first class containing this individual.
	 **/
	public OntologyClass getObviousContainingClass()
	{
		return getObviousContainingClasses().iterator().next();
	}

	/**
	 * Retrieves the classes obviously containing this individual.
	 * @return The collection of classes containing this individual.
	 **/
	public Collection<OntologyClass> getObviousContainingClasses()
	{
		ArrayList<OntologyClass> classes = new ArrayList<>();

		if (instance instanceof OWLNamedIndividual)
			for (OWLClassAssertionAxiom x : getOntology().ontology.getClassAssertionAxioms(instance))
				for (OWLClass c : x.getClassesInSignature())
					if (c.equals(instance) == false)
						classes.add(new OntologyClass(getOntology(), c));

		return classes;
	}

	/**
	 * Return the first obvious data property value having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property.
	 * @param type
	 *            The base type of the data property.
	 * @return The first value of the property or <code>null</code> if this property is not used.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	public <T> T getObviousDataPropertyValue(OntologyDataProperty ontologyProperty, Class<T> type)
		throws ClassNotFoundException, IOException
	{
		return getObviousDataPropertyValues(ontologyProperty, type).iterator().next();
	}

	/**
	 * Return the first obvious data property value having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property name.
	 * @param type
	 *            The base type of the data property.
	 * @return The first value of the property or <code>null</code> if this property is not used.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	public <T> T getObviousDataPropertyValue(String ontologyProperty, Class<T> type) throws NoSuchEntityException,
		ClassNotFoundException, IOException
	{
		return getObviousDataPropertyValue(getOntology().getDataProperty(ontologyProperty), type);
	}

	/**
	 * Returns a obvious data property values having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property.
	 * @param type
	 *            The base type of the data property.
	 * @return The list of the values of the property.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	@SuppressWarnings("unchecked")
	public <T> Collection<T> getObviousDataPropertyValues(OntologyDataProperty ontologyProperty, Class<T> type)
		throws ClassNotFoundException, IOException
	{
		ArrayList<T> values = new ArrayList<>();

		if (instance instanceof OWLNamedIndividual)
			for (OWLLiteral x : instance.getDataPropertyValues(ontologyProperty.instance, getOntology().ontology))
				values.add((T) decodeLiteral(x, type));

		return values;
	}

	/**
	 * Returns a obvious data property values having this individual as a subject.
	 * @param <T>
	 *            The property data type.
	 * @param ontologyProperty
	 *            The data property name.
	 * @param type
	 *            The base type of the data property.
	 * @return The list of the values of the property.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 **/
	public <T> Collection<T> getObviousDataPropertyValues(String ontologyProperty, Class<T> type)
		throws NoSuchEntityException, ClassNotFoundException, IOException
	{
		return getObviousDataPropertyValues(getOntology().getDataProperty(ontologyProperty), type);
	}

	/**
	 * Retrieves the first obvious named individual equivalent to the current one.
	 * @return The first equivalent individual or <code>null</code> if there is not an equivalent individual.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyIndividual getObviousEquivalentIndividual() throws InconsistencyException, NoSuchEntityException,
		ReasoningInterruptedException
	{
		return getObviousEquivalentIndividuals().iterator().next();
	}

	/**
	 * Retrieves the obvious named individuals equivalent to the current one.
	 * @return The set of equivalent individuals.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyIndividual> getObviousEquivalentIndividuals() throws InconsistencyException,
		NoSuchEntityException, ReasoningInterruptedException
	{
		ArrayList<OntologyIndividual> individuals = new ArrayList<>();

		if (instance instanceof OWLNamedIndividual)
			for (OWLSameIndividualAxiom x : getOntology().ontology.getSameIndividualAxioms(instance))
				for (OWLNamedIndividual i : x.getIndividualsInSignature())
					if (i.equals(instance) == false)
						individuals.add(new OntologyIndividual(getOntology(), i));

		return individuals;
	}

	/**
	 * Return the first obvious object property value having this individual as a subject.
	 * @param ontologyProperty
	 *            The data property.
	 * @return The first value of the property or <code>null</code> if this property is not used.
	 **/
	public OntologyIndividual getObviousObjectPropertyValue(OntologyObjectProperty ontologyProperty)
	{
		return getObviousObjectPropertyValues(ontologyProperty).iterator().next();
	}

	/**
	 * Return the first obvious object property value having this individual as a subject.
	 * @param ontologyProperty
	 *            The data property name.
	 * @return The first value of the property or <code>null</code> if this property is not used.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 **/
	public OntologyIndividual getObviousObjectPropertyValue(String ontologyProperty) throws NoSuchEntityException
	{
		return getObviousObjectPropertyValue(getOntology().getObjectProperty(ontologyProperty));
	}

	/**
	 * Returns a obvious object property values having this individual as a subject.
	 * @param ontologyProperty
	 *            The data property.
	 * @return The list of the values of the property.
	 **/
	public Collection<OntologyIndividual> getObviousObjectPropertyValues(OntologyObjectProperty ontologyProperty)
	{
		ArrayList<OntologyIndividual> values = new ArrayList<>();

		if (instance instanceof OWLNamedIndividual)
			for (OWLIndividual x : instance.getObjectPropertyValues(ontologyProperty.instance, getOntology().ontology))
				values.add(new OntologyIndividual(getOntology(), x));

		return values;
	}

	/**
	 * Returns a obvious object property values having this individual as a subject.
	 * @param ontologyProperty
	 *            The data property name.
	 * @return The list of the values of the property.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 **/
	public Collection<OntologyIndividual> getObviousObjectPropertyValues(String ontologyProperty)
		throws NoSuchEntityException
	{
		return getObviousObjectPropertyValues(getOntology().getObjectProperty(ontologyProperty));
	}

	/**
	 * Checks if the current individual in contained in a class.
	 * @param ontologyClass
	 *            The class to check.
	 * @return <code>true</code> if the class contains this individual, <code>false</code> otherwise.
	 **/
	public boolean isContainedInClass(OntologyClass ontologyClass)
	{
		return getContainingClasses(false).contains(ontologyClass);
	}

	/**
	 * Checks if the current individual in contained in a class.
	 * @param className
	 *            The name of the class to check.
	 * @return <code>true</code> if the class contains this individual, <code>false</code> otherwise.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public boolean isContainedInClass(String className) throws ParsingErrorException
	{
		return isContainedInClass(getOntology().getClass(className));
	}

	/**
	 * Deletes all the data property assertion axioms over this individual.
	 * @param ontologyProperty
	 *            The property.
	 * @throws OntologyChangeException
	 *             If the axioms cannot be removed.
	 */
	public void removeDataPropertyValues(OntologyDataProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			for (OWLLiteral i : instance.getDataPropertyValues(ontologyProperty.instance, getOntology().ontology))
			{
				OWLDataPropertyAssertionAxiom axiom =
					getOntology().dataFactory.getOWLDataPropertyAssertionAxiom(ontologyProperty.instance, instance, i);
				getOntology().ontologyManager.removeAxiom(getOntology().ontology, axiom);
			}
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to remove all the \"" + ontologyProperty.getIRI()
				+ "\" assertions over \"" + getIRI() + "\"");
		}
	}

	/**
	 * Deletes all the data property assertion axioms over this individual.
	 * @param propertyName
	 *            The name of the data property.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws OntologyChangeException
	 *             If the axioms cannot be removed.
	 **/
	public void removeDataPropertyValues(String propertyName) throws OntologyChangeException, NoSuchEntityException
	{
		removeDataPropertyValues(getOntology().getDataProperty(propertyName));
	}

	/**
	 * Removes an object property over this individual and another one.
	 * @param ontologyProperty
	 *            The property.
	 * @param ontologyIndividual
	 *            The target individual.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be removed.
	 **/
	public void
		removeObjectPropertyValue(OntologyObjectProperty ontologyProperty, OntologyIndividual ontologyIndividual)
			throws OntologyChangeException
	{
		try
		{
			OWLObjectPropertyAssertionAxiom axiom =
				getOntology().dataFactory.getOWLObjectPropertyAssertionAxiom(ontologyProperty.instance, instance,
					ontologyIndividual.instance);
			getOntology().ontologyManager.removeAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to remove the object property assertion axiom for \"" + getIRI()
				+ "\"");
		}
	}

	/**
	 * Removes an object property over this individual and another one.
	 * @param ontologyProperty
	 *            The property.
	 * @param individualName
	 *            The full qualified name of the target individual.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be removed.
	 **/
	public void removeObjectPropertyValue(OntologyObjectProperty ontologyProperty, String individualName)
		throws NoSuchEntityException, OntologyChangeException
	{
		removeObjectPropertyValue(ontologyProperty, getOntology().getIndividual(individualName));
	}

	/**
	 * Removes an object property over this individual and another one.
	 * @param propertyName
	 *            The full qualified name of the property.
	 * @param ontologyIndividual
	 *            The target individual.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be removed.
	 **/
	public void removeObjectPropertyValue(String propertyName, OntologyIndividual ontologyIndividual)
		throws NoSuchEntityException, OntologyChangeException
	{
		removeObjectPropertyValue(getOntology().getObjectProperty(propertyName), ontologyIndividual);
	}

	/**
	 * Removes an object property over this individual and another one.
	 * @param propertyName
	 *            The full qualified name of the property.
	 * @param individualName
	 *            The full qualified name of the target individual.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be removed.
	 **/
	public void removeObjectPropertyValue(String propertyName, String individualName) throws NoSuchEntityException,
		OntologyChangeException
	{
		removeObjectPropertyValue(getOntology().getObjectProperty(propertyName),
			getOntology().getIndividual(individualName));
	}

	/**
	 * Deletes all the object property assertion axioms over this individual.
	 * @param ontologyProperty
	 *            The property.
	 * @throws OntologyChangeException
	 *             If the axioms cannot be removed.
	 **/
	public void removeObjectPropertyValues(OntologyObjectProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			for (OWLIndividual i : instance.getObjectPropertyValues(ontologyProperty.instance, getOntology().ontology))
			{
				OWLObjectPropertyAssertionAxiom axiom =
					getOntology().dataFactory
						.getOWLObjectPropertyAssertionAxiom(ontologyProperty.instance, instance, i);
				getOntology().ontologyManager.removeAxiom(getOntology().ontology, axiom);
			}
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to remove all the \"" + ontologyProperty.getIRI()
				+ "\" assertions over \"" + getIRI() + "\"");
		}
	}

	/**
	 * Deletes all the object property assertion axioms over this individual.
	 * @param propertyName
	 *            The name of the data property.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist.
	 * @throws OntologyChangeException
	 *             If the axioms cannot be removed.
	 **/
	public void removeObjectPropertyValues(String propertyName) throws OntologyChangeException, NoSuchEntityException
	{
		removeObjectPropertyValues(getOntology().getObjectProperty(propertyName));
	}

	/** This individual in the OWL ontology. **/
	protected OWLIndividual instance;
}
