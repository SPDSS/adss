/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
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
 * An ontology class.
 * @author Daniele Canavese, Luca Moretto
 **/
public class OntologyClass extends AbstractOntologyEntity
{
	/**
	 * Creates an ontology class.
	 * @param ontology
	 *            The ontology containing this class.
	 * @param instance
	 *            The entity instance.
	 **/
	protected OntologyClass(Ontology ontology, OWLClassExpression instance)
	{
		super(ontology, instance);
		this.instance = instance;
	}

	/**
	 * Adds a classes equivalence axiom.
	 * @param ontologyClass
	 *            The other class equivalent to the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addEquivalence(OntologyClass ontologyClass) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLEquivalentClassesAxiom(instance, ontologyClass.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the classes equivalence axiom between \"" + getIRI()
				+ "\" and \"" + ontologyClass.getIRI() + "\"");
		}
	}

	/**
	 * Adds a classes equivalence axiom.
	 * @param expression
	 *            A class or a Manchester syntax expression.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public void addEquivalence(String expression) throws OntologyChangeException, ParsingErrorException
	{
		try
		{
			OWLAxiom axiom =
				getOntology().dataFactory.getOWLEquivalentClassesAxiom(instance, getOntology().parse(expression));
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the classes equivalence axiom between \"" + getIRI()
				+ "\" and \"" + expression + "\"");
		}
	}

	/**
	 * Adds a subclass axiom.
	 * @param ontologyClass
	 *            The sub-class of the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addSubClass(OntologyClass ontologyClass) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLSubClassOfAxiom(ontologyClass.instance, instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to set \"" + getIRI() + "\" as a sub-class of \""
				+ ontologyClass.getIRI() + "\"");
		}
	}

	/**
	 * Adds a subclass axiom.
	 * @param expression
	 *            A class or a Manchester syntax expression.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public void addSubClass(String expression) throws OntologyChangeException, ParsingErrorException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLSubClassOfAxiom(getOntology().parse(expression), instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to set \"" + getIRI() + "\" as a sub-class of \"" + expression
				+ "\"");
		}
	}

	/**
	 * Adds a super-class axiom.
	 * @param ontologyClass
	 *            The super-class of the current one.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void addSuperClass(OntologyClass ontologyClass) throws OntologyChangeException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLSubClassOfAxiom(instance, ontologyClass.instance);
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to set \"" + getIRI() + "\" as a super-class of \""
				+ ontologyClass.getIRI() + "\"");
		}
	}

	/**
	 * Adds a super-class axiom.
	 * @param expression
	 *            A class or a Manchester syntax expression.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public void addSuperClass(String expression) throws OntologyChangeException, ParsingErrorException
	{
		try
		{
			OWLAxiom axiom = getOntology().dataFactory.getOWLSubClassOfAxiom(instance, getOntology().parse(expression));
			getOntology().ontologyManager.addAxiom(getOntology().ontology, axiom);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to set \"" + getIRI() + "\" as a super-class of \"" + expression
				+ "\"");
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
		if (object instanceof OntologyClass == true)
			try
		{
				if (((OntologyClass) object).getIRI().equals(getIRI()) == true)
					return true;
				for (OntologyClass clazz : getEquivalentClasses())
					if (clazz.getIRI().equals(((OntologyClass) object).getIRI()) == true)
						return true;
		}
		catch (Exception e)
		{
		}
		return false;
	}

	/**
	 * Retrieves the first named class equivalent to the current one.
	 * @return The first equivalent class or <code>null</code> if there is not an equivalent class.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyClass getEquivalentClass() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		Collection<OntologyClass> concepts = getEquivalentClasses();
		if (concepts.isEmpty() == true)
			return null;
		else
			return concepts.iterator().next();
	}

	/**
	 * Retrieves the named classes equivalent to the current one.
	 * @return The set of equivalent classes.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyClass> getEquivalentClasses() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyClass> equivalentClasses = new ArrayList<>();

			for (OWLClass concept : getOntology().reasoner.getEquivalentClasses(instance).getEntities())
				equivalentClasses.add(new OntologyClass(getOntology(), concept));

			return equivalentClasses;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
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
	 * Returns all the individuals of this class (and its subclasses).
	 * @param direct
	 *            Specifies if the method will retrieve only the direct individuals or the full hierarchy.
	 * @return All the instances of the class.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyIndividual> getIndividuals(boolean direct) throws InconsistencyException,
	ReasoningInterruptedException, NoSuchEntityException
	{
		try
		{
			Collection<OntologyIndividual> individuals = new ArrayList<>();
			for (Node<OWLNamedIndividual> node : getOntology().reasoner.getInstances(instance, direct))
				for (OWLNamedIndividual individual : node.getEntities())
					individuals.add(new OntologyIndividual(getOntology(), individual));

			return individuals;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
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
	 * Retrieves the first obvious named class equivalent to the current one.
	 * @return The first equivalent class or <code>null</code> if there is not an equivalent class.
	 **/
	public OntologyClass getObviousEquivalentClass()
	{
		Collection<OntologyClass> concepts = getObviousEquivalentClasses();
		if (concepts.isEmpty() == true)
			return null;
		else
			return concepts.iterator().next();
	}

	/**
	 * Retrieves the obvious named classes equivalent to the current one.
	 * @return The set of equivalent classes.
	 **/
	public Collection<OntologyClass> getObviousEquivalentClasses()
	{
		if (instance instanceof OWLClass)
		{
			Collection<OntologyClass> equivalentClasses = new ArrayList<>();

			for (OWLEquivalentClassesAxiom x : getOntology().ontology.getEquivalentClassesAxioms((OWLClass) instance))
				for (OWLClass c : x.getClassesInSignature())
					if (c.equals(instance) == false)
						equivalentClasses.add(new OntologyClass(getOntology(), c));

			return equivalentClasses;

		}
		else
			return Collections.emptySet();
	}

	/**
	 * Returns all the obvious individuals of this class.
	 * @return All the instances of the class.
	 **/
	public Collection<OntologyIndividual> getObviousIndividuals()
	{
		if (instance instanceof OWLClass)
		{
			Collection<OntologyIndividual> individuals = new ArrayList<>();

			for (OWLClassAssertionAxiom x : getOntology().ontology.getClassAssertionAxioms(instance))
				individuals.add(new OntologyIndividual(getOntology(), x.getIndividual()));

			return individuals;

		}
		else
			return Collections.emptySet();
	}

	/**
	 * Retrieves the first obvious named sub-class of the current one.
	 * @return The first sub-class.
	 **/
	public OntologyClass getObviousSubClass()
	{
		return getObviousSubClasses().iterator().next();
	}

	/**
	 * Retrieves the obvious named sub-classes of the current one.
	 * @return The set of sub-classes.
	 **/
	public Collection<OntologyClass> getObviousSubClasses()
	{
		if (instance instanceof OWLClass)
		{
			Collection<OntologyClass> subClasses = new ArrayList<>();

			for (OWLSubClassOfAxiom x : getOntology().ontology.getSubClassAxiomsForSuperClass((OWLClass) instance))
				subClasses.add(new OntologyClass(getOntology(), x.getSubClass()));

			return subClasses;

		}
		else
			return Collections.emptySet();
	}

	/**
	 * Retrieves the first obvious named super-class of the current one.
	 * @return The first super-class.
	 **/
	public OntologyClass getObviousSuperClass()
	{
		return getObviousSuperClasses().iterator().next();
	}

	/**
	 * Retrieves the obvious named super-classes of the current one.
	 * @return The set of sub-classes.
	 **/
	public Collection<OntologyClass> getObviousSuperClasses()
	{
		if (instance instanceof OWLClass)
		{
			Collection<OntologyClass> superClasses = new ArrayList<>();

			for (OWLSubClassOfAxiom x : getOntology().ontology.getSubClassAxiomsForSubClass((OWLClass) instance))
				superClasses.add(new OntologyClass(getOntology(), x.getSuperClass()));

			return superClasses;

		}
		else
			return Collections.emptySet();
	}

	/**
	 * Retrieves the first direct named sub-class of the current one.
	 * @return The first sub-class.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyClass getSubClass() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		return getSubClasses(true).iterator().next();
	}

	/**
	 * Retrieves the named sub-classes of the current one.
	 * @param direct
	 *            Specifies if the method will retrieve only the direct classes or the full hierarchy.
	 * @return The set of sub-classes.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyClass> getSubClasses(boolean direct) throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyClass> subClasses = new ArrayList<>();

			for (Node<OWLClass> node : getOntology().reasoner.getSubClasses(instance, direct).getNodes())
				for (OWLClass concept : node.getEntities())
					subClasses.add(new OntologyClass(getOntology(), concept));

			return subClasses;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
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
	 * Retrieves the first direct named super class of the current one.
	 * @return The first super class.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public OntologyClass getSuperClass() throws InconsistencyException, NoSuchEntityException,
	ReasoningInterruptedException
	{
		return getSuperClasses(true).iterator().next();
	}

	/**
	 * Retrieves the named super classes of the current one.
	 * @param direct
	 *            Specifies if the method will retrieve only the direct classes or the full hierarchy.
	 * @return The set of super classes.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exists.
	 **/
	public Collection<OntologyClass> getSuperClasses(boolean direct) throws InconsistencyException,
	NoSuchEntityException, ReasoningInterruptedException
	{
		try
		{
			Collection<OntologyClass> superClasses = new ArrayList<>();

			for (Node<OWLClass> node : getOntology().reasoner.getSuperClasses(instance, direct).getNodes())
				for (OWLClass concept : node.getEntities())
					superClasses.add(new OntologyClass(getOntology(), concept));

			return superClasses;
		}
		catch (InconsistentOntologyException e)
		{
			throw new InconsistencyException("The ontology is inconsistent");
		}
		catch (ClassExpressionNotInProfileException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
		}
		catch (FreshEntitiesException e)
		{
			throw new NoSuchEntityException("The class \"" + getIRI() + "\" does not exist");
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
	 * Checks if this class is Nothing.
	 * @return <code>true</code> if this class is Nothing, <code>false</code> otherwise.
	 **/
	public boolean isNothing()
	{
		return equals(getOntology().getNothing());
	}

	/**
	 * Checks if this class is Thing.
	 * @return <code>true</code> if this class is Thing, <code>false</code> otherwise.
	 **/
	public boolean isThing()
	{
		return equals(getOntology().getThing());
	}

	/** This class in the OWL ontology. **/
	protected OWLClassExpression instance;
}
