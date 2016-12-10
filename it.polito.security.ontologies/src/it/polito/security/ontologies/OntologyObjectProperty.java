/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;
import org.semanticweb.owlapi.expression.ParserException;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
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
 * An ontology object property.
 * @author Daniele Canavese, Luca Moretto
 **/
public class OntologyObjectProperty extends AbstractOntologyEntity
{
	/**
	 * Creates an ontology object property.
	 * @param ontology
	 *            The ontology containing this object property.
	 * @param instance
	 *            The entity.
	 **/
	protected OntologyObjectProperty(Ontology ontology, OWLObjectProperty instance)
	{
		super(ontology, instance);
		this.ontology = ontology;
		this.instance = instance;
	}

	/**
	 * Adds an object property equivalence axiom.
	 * @param ontologyProperty
	 *            The other property equivalent to the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(OntologyObjectProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLEquivalentObjectPropertiesAxiom(instance, ontologyProperty.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the object properties equivalence axiom between \""
				+ getIRI() + "\" and \"" + ontologyProperty.getIRI() + "\"");
		}
	}

	/**
	 * Adds an object property equivalence axiom.
	 * @param propertyName
	 *            The name of the equivalent object property.
	 * @throws NoSuchEntityException
	 *             If the specified object property does not exist.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(String propertyName) throws NoSuchEntityException, OntologyChangeException
	{
		addEquivalence(getOntology().getObjectProperty(propertyName));
	}

	/**
	 * Adds an inverse object property axiom.
	 * @param ontologyProperty
	 *            The inverse object property.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addInverseProperty(OntologyObjectProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLInverseObjectPropertiesAxiom(instance, ontologyProperty.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the object property inverseOf axiom between \"" + getIRI()
				+ "\" and \"" + ontologyProperty.getIRI() + "\"");
		}
	}

	/**
	 * Adds an inverse object property axiom.
	 * @param propertyName
	 *            The name of the inverse object property.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If the inverse object property does not exist.
	 **/
	public void addInverseProperty(String propertyName) throws OntologyChangeException, NoSuchEntityException
	{
		addInverseProperty(getOntology().getObjectProperty(propertyName));
	}

	/**
	 * Adds a sub-property axiom.
	 * @param ontologyProperty
	 *            The sub-property of the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addSubProperty(OntologyObjectProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLSubObjectPropertyOfAxiom(ontologyProperty.instance, instance);
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
		addSubProperty(getOntology().getObjectProperty(propertyName));
	}

	/**
	 * Adds a property chain as a sub property of this one.
	 * @param properties
	 *            The ordered list of properties.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 */
	public void addSubPropertyChain(List<OntologyObjectProperty> properties) throws OntologyChangeException
	{
		try
		{
			List<OWLObjectPropertyExpression> chain = new ArrayList<>();
			for (OntologyObjectProperty property : properties)
				chain.add(property.instance);

			OWLSubPropertyChainOfAxiom axiom = getOntology().dataFactory.getOWLSubPropertyChainOfAxiom(chain, instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			StringBuilder join = new StringBuilder();
			for (OntologyObjectProperty property : properties)
			{
				if (join.length() > 0)
					join.append(" o ");
				join.append(property.toString());
			}
			throw new OntologyChangeException("Unable to add the object property chain axiom for \"" + join.toString()
				+ "\"");
		}
	}

	/**
	 * Adds a property chain as a sub property of this one.
	 * @param expression
	 *            A property chain expression in the form <obj_prop1> o <obj_prop2> o <obj_prop3>...
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is wrong.
	 */
	public void addSubPropertyChain(String expression) throws OntologyChangeException, ParsingErrorException
	{
		try
		{
			ManchesterOWLSyntaxEditorParser manParser =
				new ManchesterOWLSyntaxEditorParser(getOntology().dataFactory, expression);
			manParser.setOWLEntityChecker(getOntology().entityChecker);
			List<OWLObjectPropertyExpression> chain = manParser.parseObjectPropertyChain();

			OWLSubPropertyChainOfAxiom axiom = getOntology().dataFactory.getOWLSubPropertyChainOfAxiom(chain, instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (ParserException e)
		{
			throw new ParsingErrorException("Wrong syntax for property chain expression '" + expression + "'");
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the object property chain axiom for \"" + expression
				+ "\"");
		}
	}

	/**
	 * Adds a super-property axiom.
	 * @param ontologyProperty
	 *            The super-property of the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addSuperProperty(OntologyObjectProperty ontologyProperty) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLSubObjectPropertyOfAxiom(instance, ontologyProperty.instance);
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
		addSuperProperty(getOntology().getObjectProperty(propertyName));
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
		if (object instanceof OntologyObjectProperty == true)
			try
		{
				if (((OntologyObjectProperty) object).getIRI().equals(getIRI()) == true)
					return true;
				for (OWLObjectPropertyExpression property : instance.getEquivalentProperties(getOntology().ontology))
					if (property instanceof OWLObjectProperty)
						if (((OWLObjectProperty) property).getIRI().toString()
							.equals(((OntologyObjectProperty) object).getIRI()) == true)
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
	 * Retrieves the property domains.
	 * @return The property domains.
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
	public Collection<OntologyObjectProperty> getEquivalentProperties() throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyObjectProperty> equivalentProperties = new ArrayList<>();

			for (OWLObjectPropertyExpression property : getOntology().reasoner.getEquivalentObjectProperties(instance)
				.getEntities())
				equivalentProperties.add(new OntologyObjectProperty(getOntology(), property.asOWLObjectProperty()));

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
	public OntologyObjectProperty getEquivalentProperty() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		Collection<OntologyObjectProperty> properties = getEquivalentProperties();
		if (properties.isEmpty() == true)
			return null;
		else
			return properties.iterator().next();
	}

	/**
	 * Retrieves the named inverse properties of the current one.
	 * @return The set of inverse properties.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyObjectProperty> getInverseProperties() throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyObjectProperty> inverseProperties = new ArrayList<>();

			for (OWLObjectPropertyExpression property : getOntology().reasoner.getInverseObjectProperties(instance)
				.getEntities())
				if (property.isAnonymous() == false)
					inverseProperties.add(new OntologyObjectProperty(getOntology(), property.asOWLObjectProperty()));

			return inverseProperties;
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
	 * Retrieves the first named inverse property of the current one.
	 * @return The first inverse property.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyObjectProperty getInverseProperty() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		return getInverseProperties().iterator().next();
	}

	/**
	 * Retrieves the obvious named properties equivalent to the current one.
	 * @return The set of equivalent properties.
	 **/
	public Collection<OntologyObjectProperty> getObviousEquivalentProperties()
	{
		Collection<OntologyObjectProperty> equivalentProperties = new ArrayList<>();

		for (OWLEquivalentObjectPropertiesAxiom x : getOntology().ontology
			.getEquivalentObjectPropertiesAxioms(instance))
			for (OWLObjectProperty p : x.getObjectPropertiesInSignature())
				if (p.equals(instance) == false)
					equivalentProperties.add(new OntologyObjectProperty(getOntology(), p));

		return equivalentProperties;
	}

	/**
	 * Retrieves the first obvious named property equivalent to the current one.
	 * @return The first equivalent property or <code>null</code> if there is not an equivalent property.
	 **/
	public OntologyObjectProperty getObviousEquivalentProperty()
	{
		Collection<OntologyObjectProperty> properties = getObviousEquivalentProperties();
		if (properties.isEmpty() == true)
			return null;
		else
			return properties.iterator().next();
	}

	/**
	 * Retrieves the obvious inverse properties of the current one.
	 * @return The set of inverse properties.
	 **/
	public Collection<OntologyObjectProperty> getObviousInverseProperties()
	{
		Collection<OntologyObjectProperty> equivalentProperties = new ArrayList<>();

		for (OWLInverseObjectPropertiesAxiom x : getOntology().ontology.getInverseObjectPropertyAxioms(instance))
			for (OWLObjectProperty p : x.getObjectPropertiesInSignature())
				if (p.equals(instance) == false)
					equivalentProperties.add(new OntologyObjectProperty(getOntology(), p));

		return equivalentProperties;
	}

	/**
	 * Retrieves the first obvious inverse property of the current one.
	 * @return The first inverse property or <code>null</code> if there is not an inverse property.
	 **/
	public OntologyObjectProperty getObviousInverseProperty()
	{
		Collection<OntologyObjectProperty> properties = getObviousInverseProperties();
		if (properties.isEmpty() == true)
			return null;
		else
			return properties.iterator().next();
	}

	/**
	 * Retrieves the named obvious sub-properties of the current one.
	 * @return The set of sub-properties.
	 **/
	public Collection<OntologyObjectProperty> getObviousSubProperties()
	{
		Collection<OntologyObjectProperty> subProperties = new ArrayList<>();

		for (OWLSubObjectPropertyOfAxiom x : getOntology().ontology
			.getObjectSubPropertyAxiomsForSuperProperty(instance))
			if (x.getSubProperty() instanceof OWLObjectProperty)
				subProperties.add(new OntologyObjectProperty(getOntology(), (OWLObjectProperty) x.getSubProperty()));

		return subProperties;
	}

	/**
	 * Retrieves the first obvious direct named sub-property of the current one.
	 * @return The first sub-property.
	 **/
	public OntologyObjectProperty getObviousSubProperty()
	{
		return getObviousSubProperties().iterator().next();
	}

	/**
	 * Retrieves the named obvious super-properties of the current one.
	 * @return The set of super-properties.
	 **/
	public Collection<OntologyObjectProperty> getObviousSuperProperties()
	{
		Collection<OntologyObjectProperty> subProperties = new ArrayList<>();

		for (OWLSubObjectPropertyOfAxiom x : getOntology().ontology.getObjectSubPropertyAxiomsForSubProperty(instance))
			if (x.getSuperProperty() instanceof OWLObjectProperty)
				subProperties.add(new OntologyObjectProperty(getOntology(), (OWLObjectProperty) x.getSuperProperty()));

		return subProperties;
	}

	/**
	 * Retrieves the first obvious direct named super-property of the current one.
	 * @return The first super-property.
	 **/
	public OntologyObjectProperty getObviousSuperProperty()
	{
		return getObviousSuperProperties().iterator().next();
	}

	/**
	 * Retrieves the first property range.
	 * @return The first property range or <code>null</code> if it does not exist.
	 **/
	public OntologyClass getRange()
	{
		return getRanges().iterator().next();
	}

	/**
	 * Retrieves the property ranges.
	 * @return The property ranges.
	 **/
	public Collection<OntologyClass> getRanges()
	{
		Collection<OntologyClass> classes = new ArrayList<>();
		for (OWLClassExpression i : instance.getRanges(ontology.ontology))
			classes.add(new OntologyClass(ontology, i));
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
	public Collection<OntologyObjectProperty> getSubProperties(boolean direct) throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyObjectProperty> subProperties = new ArrayList<>();

			for (Node<OWLObjectPropertyExpression> node : getOntology().reasoner.getSubObjectProperties(instance,
				direct).getNodes())
				for (OWLObjectPropertyExpression property : node.getEntities())
					subProperties.add(new OntologyObjectProperty(getOntology(), property.asOWLObjectProperty()));

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
	public OntologyObjectProperty getSubProperty() throws InconsistencyException, NoSuchEntityException,
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
	public Collection<OntologyObjectProperty> getSuperProperties(boolean direct) throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyObjectProperty> superProperties = new ArrayList<>();

			for (Node<OWLObjectPropertyExpression> node : getOntology().reasoner.getSuperObjectProperties(instance,
				direct).getNodes())
				for (OWLObjectPropertyExpression property : node.getEntities())
					superProperties.add(new OntologyObjectProperty(getOntology(), property.asOWLObjectProperty()));

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
	public OntologyObjectProperty getSuperProperty() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		return getSuperProperties(true).iterator().next();
	}

	/**
	 * Retrieves the asymmetric characteristic of the property.
	 * @return <code>true</code> if the property is functional, <code>false</code> otherwise.
	 **/
	public boolean isAsymmetric()
	{
		return instance.isAsymmetric(ontology.ontology);
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
	 * Retrieves the inverse functional characteristic of the property.
	 * @return <code>true</code> if the property is inverse functional, <code>false</code> otherwise.
	 **/
	public boolean isInverseFunctional()
	{
		return instance.isInverseFunctional(ontology.ontology);
	}

	/**
	 * Retrieves the irreflexive characteristic of the property.
	 * @return <code>true</code> if the property is functional, <code>false</code> otherwise.
	 **/
	public boolean isIrreflexive()
	{
		return instance.isIrreflexive(ontology.ontology);
	}

	/**
	 * Retrieves the reflexive characteristic of the property.
	 * @return <code>true</code> if the property is functional, <code>false</code> otherwise.
	 **/
	public boolean isReflexive()
	{
		return instance.isReflexive(ontology.ontology);
	}

	/**
	 * Retrieves the symmetric characteristic of the property.
	 * @return <code>true</code> if the property is functional, <code>false</code> otherwise.
	 **/
	public boolean isSymmetric()
	{
		return instance.isSymmetric(ontology.ontology);
	}

	/**
	 * Retrieves the transitive characteristic of the property.
	 * @return <code>true</code> if the property is functional, <code>false</code> otherwise.
	 **/
	public boolean isTransitive()
	{
		return instance.isTransitive(ontology.ontology);
	}

	/**
	 * Sets the asymmetric characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setAsymmetric(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLAsymmetricObjectPropertyAxiom(instance);
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
			OWLAxiom axiom = ontology.dataFactory.getOWLFunctionalObjectPropertyAxiom(instance);
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

	/**
	 * Sets the inverse functional characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setInverseFunctional(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLInverseFunctionalObjectPropertyAxiom(instance);
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

	/**
	 * Sets the irreflexive characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setIrreflexive(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLIrreflexiveObjectPropertyAxiom(instance);
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

	/**
	 * Sets the reflexive characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setReflexive(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLReflexiveObjectPropertyAxiom(instance);
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

	/**
	 * Sets the symmetric characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setSymmetric(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLSymmetricObjectPropertyAxiom(instance);
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

	/**
	 * Sets the transitive characteristic of the property.
	 * @param value
	 *            The boolean value of the characteristic.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void setTransitive(boolean value) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = ontology.dataFactory.getOWLTransitiveObjectPropertyAxiom(instance);
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
	protected OWLObjectProperty instance;
	/** The ontology. **/
	private Ontology ontology;
}
