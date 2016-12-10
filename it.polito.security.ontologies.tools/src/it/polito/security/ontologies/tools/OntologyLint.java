/*******************************************************************************
 * Copyright (c) 2016 Politecnico di Torino.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Politecnico di Torino - initial API and implementation
 *******************************************************************************/
package it.polito.security.ontologies.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentSource;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.io.OWLOntologyDocumentSource;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLIndividualAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNaryBooleanClassExpression;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

import uk.ac.manchester.cs.owlapi.dlsyntax.DLSyntaxObjectRenderer;

/**
 * Perform a lint on an ontology
 * @author Daniele Canavese
 **/
public class OntologyLint
{
	/**
	 * Create the lint.
	 * @param file
	 *            The ontology file to load.
	 * @throws OWLOntologyCreationException
	 *             If something goes wrong.
	 **/
	public OntologyLint(final File file) throws OWLOntologyCreationException
	{
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntologyDocumentSource document = new FileDocumentSource(file);
		ontology = ontologyManager.loadOntologyFromOntologyDocument(document);
		renderer = new DLSyntaxObjectRenderer();
	}

	/**
	 * Analyze a single axiom.
	 * @param axiom
	 *            The axiom to analyze.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeAxiom(final OWLAxiom axiom, Collection<String> messages)
	{
		final ClassWalker onlyWalker = new ClassWalker()
		{
			@Override
			public boolean check(OWLClassExpression clazz)
			{
				return clazz instanceof OWLObjectAllValuesFrom;
			}
		};
		final ClassWalker someWalker = new ClassWalker()
		{
			@Override
			public boolean check(OWLClassExpression clazz)
			{
				return clazz instanceof OWLObjectSomeValuesFrom;
			}
		};
		final ClassWalker notSomeWalker = new ClassWalker()
		{
			@Override
			public boolean check(OWLClassExpression clazz)
			{
				return clazz instanceof OWLObjectComplementOf && containsSomething(clazz, someWalker);
			}
		};
		final ClassWalker cardinalityWalker = new ClassWalker()
		{
			@Override
			public boolean check(OWLClassExpression clazz)
			{
				if (clazz instanceof OWLObjectCardinalityRestriction)
					return ((OWLObjectCardinalityRestriction) clazz).getCardinality() > MAX_CARDINALITY;
					else
						return false;
			}
		};
		final ClassWalker disjunctionWalker = new ClassWalker()
		{
			@Override
			public boolean check(OWLClassExpression clazz)
			{
				if (clazz instanceof OWLObjectUnionOf)
					return ((OWLObjectUnionOf) clazz).getOperands().size() > MAX_DISJUNCTIONS;
					else
						return false;
			}
		};

		if (axiom instanceof OWLEquivalentClassesAxiom)
		{
			OWLEquivalentClassesAxiom x = (OWLEquivalentClassesAxiom) axiom;

			int count = 0;
			for (OWLClassExpression c : ((OWLEquivalentClassesAxiom) axiom).getClassExpressions())
				if (c.isAnonymous())
					++count;
			if (count >= 2)
				messages.add(doMessage("general concept inclusion", x,
					"slow-down due to a non-deterministic or produced during the axiom normalization",
					"reduce the number of such axioms"));

			for (OWLClassExpression c : ((OWLEquivalentClassesAxiom) axiom).getClassExpressions())
				if (containsSomething(c, onlyWalker))
				{
					messages.add(doMessage("named concept equivalent to an all values restriction", x,
						"tipycally unintended inferences", "change to a sub-class axiom"));
					break;
				}

			for (OWLClassExpression c : ((OWLEquivalentClassesAxiom) axiom).getClassExpressions())
				if (containsSomething(c, notSomeWalker))
				{
					messages.add(doMessage("named concept equivalent to some complement", x,
						"slow-down due to a general concept inclusion produced during the axiom normalization",
						"change to a sub-class axiom"));
					break;
				}

			for (OWLClassExpression c : ((OWLEquivalentClassesAxiom) axiom).getClassExpressions())
				if (c.isTopEntity())
				{
					messages.add(doMessage("concept equivalent to Thing", x,
						"slow-down due to a general concept inclusion produced during the axiom normalization",
						"remove the axiom"));
					break;
				}

			for (OWLClassExpression c : ((OWLEquivalentClassesAxiom) axiom).getClassExpressions())
				if (containsSomething(c, cardinalityWalker))
				{
					messages
					.add(doMessage("large cardinality usage", x,
						"slow-down due to a exponential grow of individuals",
						"reduce the number of cardinality axioms"));
					break;
				}

			for (OWLClassExpression c : ((OWLEquivalentClassesAxiom) axiom).getClassExpressions())
				if (containsSomething(c, disjunctionWalker))
				{
					messages.add(doMessage("large disjuncts usage", x, "slow-down due to a non-deterministic or",
						"reduce the number of disjuntion axioms"));
					break;
				}
		}
		else if (axiom instanceof OWLSubClassOfAxiom)
		{
			OWLSubClassOfAxiom x = (OWLSubClassOfAxiom) axiom;

			if (x.isGCI())
				messages.add(doMessage("general concept inclusion", x,
					"slow-down due to a non-deterministic or produced during the axiom normalization",
					"reduce the number of such axioms"));

			if (containsSomething(x.getSubClass(), notSomeWalker)
				|| containsSomething(x.getSuperClass(), notSomeWalker))
				messages.add(doMessage("named concept equivalent to some complement", x,
					"slow-down due to a general concept inclusion produced during the axiom normalization",
					"change to a sub-class axiom"));

			if (containsSomething(x.getSubClass(), cardinalityWalker)
				|| containsSomething(x.getSuperClass(), cardinalityWalker))
				messages.add(doMessage("large cardinality usage", x,
					"slow-down due to a exponential grow of individuals", "reduce the number of cardinality axioms"));

			if (containsSomething(x.getSubClass(), disjunctionWalker)
				|| containsSomething(x.getSuperClass(), disjunctionWalker))
				messages.add(doMessage("large disjuncts usage", x, "slow-down due to a non-deterministic or",
					"reduce the number of disjcuntion axioms"));
		}
	}

	/**
	 * Find the use of too many different individuals.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeDifferentIndividuals(Collection<String> messages)
	{
		for (OWLNamedIndividual i : ontology.getIndividualsInSignature(true))
		{
			Set<OWLAxiom> axioms = new HashSet<>();
			int count = 0;
			for (OWLIndividualAxiom axiom : ontology.getAxioms(i))
				if (axiom instanceof OWLDifferentIndividualsAxiom)
				{
					OWLDifferentIndividualsAxiom x = (OWLDifferentIndividualsAxiom) axiom;
					count += x.getIndividuals().size() - 1;
					axioms.add(x);
				}
			if (count > MAX_DIFFERENT_INDIVIDUALS)
				messages.add(doMessage("the individual " + renderer.render(i)
					+ " appears in too many different individuals axioms", axioms,
					"slow-down due to a quadratic memory consumption pattern",
					"reduce the number of different individuals axioms"));
		}
	}

	/**
	 * Find the classes which appears in an equivalent and sub-class axioms.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeEquivalentSubClassOf(Collection<String> messages)
	{
		for (OWLClass c : ontology.getClassesInSignature())
		{
			Set<OWLAxiom> equivalentAxioms = new HashSet<>();
			Set<OWLAxiom> subClassOfAxioms = new HashSet<>();
			for (OWLClassAxiom x : ontology.getAxioms(c))
				if (x instanceof OWLEquivalentClassesAxiom)
					equivalentAxioms.add(x);
				else if (x instanceof OWLSubClassOfAxiom)
					subClassOfAxioms.add(x);
			Set<OWLAxiom> axioms = new HashSet<>();
			axioms.addAll(equivalentAxioms);
			axioms.addAll(subClassOfAxioms);
			if (equivalentAxioms.isEmpty() == false && subClassOfAxioms.isEmpty() == false)
				messages.add(doMessage("the named concept " + renderer.render(c)
					+ " appears in an equivalent axiom and on the " + "left-side of a sub-class axiom", axioms,
					"slow-down due to a general concept inclusion produced during the axiom normalization",
					"change the equivalent axioms to a set of sub-class axioms"));
		}
	}

	/**
	 * Find the existential explosions.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeExistentialExplosion(Collection<String> messages)
	{
		Map<OWLClass, Long> map = new HashMap<>();

		for (OWLAxiom x : ontology.getAxioms())
		{
			Set<OWLAxiom> axioms = new HashSet<>();
			long count = countIndividuals(x, map, axioms);
			if (count > MAX_EXPLOSION)
				messages.add(doMessage("existential explosion (" + count + " estimated individuals)", axioms,
					"slow-down due to a large number of individuals",
					"reduce the total number of existential restrictions"));
		}
	}

	/**
	 * Find the impure trees.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeImpureTrees(Collection<String> messages)
	{
		for (OWLClass c : ontology.getClassesInSignature(true))
		{
			int parents = 0;
			for (OWLClassExpression x : c.getSuperClasses(ontology))
				parents += x.getClassesInSignature().size();
			if (parents > MAX_CLASS_PARENTS)
				messages.add(doMessage("the class " + renderer.render(c) + " has too many parents (" + parents + ")",
					ontology.getAxioms(c), "possible slow-down due to a high correlation between axioms",
					"reduce the number of parents"));
		}
	}

	/**
	 * Find the classes with a large subsumption hierarchy.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeTooDeepClasses(Collection<String> messages)
	{
		for (OWLClass c : ontology.getClassesInSignature(true))
		{
			int depth = countDepth(c);
			if (depth > MAX_CLASS_DEPTH)
				messages.add(doMessage("the class " + renderer.render(c) + " has a too big depth (" + depth + ")",
					ontology.getAxioms(c), "possible slow-down due to a high correlation between axioms",
					"reduce the class depth"));
		}
	}

	/**
	 * Find the use of too many axioms on a single class.
	 * @param messages
	 *            The report messages to fill.
	 **/
	private void analyzeTooDetailedClasses(Collection<String> messages)
	{
		for (OWLClass c : ontology.getClassesInSignature(true))
		{
			Set<OWLAxiom> axioms = new HashSet<>();
			for (OWLAxiom axiom : c.getReferencingAxioms(ontology, true))
				if (axiom instanceof OWLClassAxiom || axiom instanceof OWLPropertyAxiom)
					axioms.add(axiom);
			if (axioms.size() > MAX_CLASS_AXIOMS)
				messages.add(doMessage(
					"the class " + renderer.render(c) + " appears in too many axioms (" + axioms.size() + ")", axioms,
					"possible slow-down due to a high correlation between axioms",
					"reduce the number of axioms using this class"));
		}
	}

	/**
	 * // * Detects if a class expression contains something or not.
	 * @param clazz
	 *            The class to check.
	 * @param walker
	 *            The walker to use.
	 * @return <code>true</code> if the class contains "that" something or <code>false</code> otherwise.
	 **/
	private boolean containsSomething(OWLClassExpression clazz, ClassWalker walker)
	{
		if (walker.check(clazz))
			return true;
		else if (clazz instanceof OWLObjectCardinalityRestriction)
			return containsSomething(((OWLObjectCardinalityRestriction) clazz).getFiller(), walker);
		else if (clazz instanceof OWLNaryBooleanClassExpression)
		{
			for (OWLClassExpression c : ((OWLNaryBooleanClassExpression) clazz).getOperands())
				if (containsSomething(c, walker))
					return true;
			return false;
		}
		else if (clazz instanceof OWLObjectComplementOf)
			return containsSomething(((OWLObjectComplementOf) clazz).getOperand(), walker);
		else
			return false;
	}

	/**
	 * Find the maximum depth of a class.
	 * @param clazz
	 *            The class to analyze.
	 * @return The maximum depth.
	 **/
	private int countDepth(OWLClassExpression clazz)
	{
		if (clazz instanceof OWLClass)
		{
			int count = 0;
			for (OWLClassExpression c : ((OWLClass) clazz).getSuperClasses(ontology))
			{
				int d = countDepth(c) + 1;
				if (d > count)
					count = d;
			}
			return count;
		}
		else if (clazz instanceof OWLNaryBooleanClassExpression)
		{
			int count = 0;
			for (OWLClassExpression c : ((OWLNaryBooleanClassExpression) clazz).getOperands())
			{
				int d = countDepth(c);
				if (d > count)
					count = d;
			}
			return count;
		}
		else if (clazz instanceof OWLObjectComplementOf)
			return countDepth(((OWLObjectComplementOf) clazz).getOperand());
		else
			return 0;
	}

	/**
	 * Count the number of individuals in an axiom.
	 * @param axiom
	 *            The axiom to analyze.
	 * @param map
	 *            The count map.
	 * @param axioms
	 *            The involved axioms.
	 * @return The estimated number of individuals of the axiom.
	 **/
	private long countIndividuals(OWLAxiom axiom, Map<OWLClass, Long> map, Set<OWLAxiom> axioms)
	{
		long count = 0;

		axioms.add(axiom);

		if (axiom instanceof OWLSubClassOfAxiom)
		{
			OWLSubClassOfAxiom x = (OWLSubClassOfAxiom) axiom;
			count = countIndividuals(x.getSuperClass(), map, axioms);
		}
		else if (axiom instanceof OWLEquivalentClassesAxiom)
		{
			OWLEquivalentClassesAxiom x = (OWLEquivalentClassesAxiom) axiom;
			for (OWLClassExpression c : x.getClassExpressions())
			{
				long i = countIndividuals(c, map, axioms);
				if (i > count)
					count = i;
			}
		}

		return count;
	}

	/**
	 * Count the number of individuals in an class.
	 * @param clazz
	 *            The class to analyze.
	 * @param map
	 *            The count map.
	 * @param axioms
	 *            The involved axioms.
	 * @return The estimated number of individuals of the class.
	 **/
	private long countIndividuals(OWLClassExpression clazz, Map<OWLClass, Long> map, Set<OWLAxiom> axioms)
	{
		long count = 1;

		if (clazz instanceof OWLClass)
		{
			OWLClass c = (OWLClass) clazz;
			if (map.containsKey(c))
				count = map.get(c);
			else
			{
				map.put(c, count);
				for (OWLClassAxiom x : ontology.getAxioms(c))
					if (x instanceof OWLEquivalentClassesAxiom)
					{
						axioms.add(x);
						for (OWLClassExpression d : ((OWLEquivalentClassesAxiom) x).getClassExpressions())
							if (d.equals(c) == false)
							{
								long i;
								if (map.containsKey(d))
									i = map.get(d);
								else
									i = countIndividuals(d, map, axioms);
								if (i > count)
									count = i;
							}
					}
					else if (x instanceof OWLSubClassOfAxiom)
					{
						axioms.add(x);
						OWLClassExpression d = ((OWLSubClassOfAxiom) x).getSuperClass();
						if (d.equals(c) == false)
						{
							long i;
							if (map.containsKey(d))
								i = map.get(d);
							else
								i = countIndividuals(d, map, axioms);
							count *= i;
						}
					}
			}
			map.put(c, count);
		}
		else if (clazz instanceof OWLObjectSomeValuesFrom)
		{
			OWLObjectSomeValuesFrom c = (OWLObjectSomeValuesFrom) clazz;
			count = countIndividuals(c.getFiller(), map, axioms);
		}
		else if (clazz instanceof OWLObjectMinCardinality)
		{
			OWLObjectMinCardinality c = (OWLObjectMinCardinality) clazz;
			count = c.getCardinality();
		}
		else if (clazz instanceof OWLObjectExactCardinality)
		{
			OWLObjectExactCardinality c = (OWLObjectExactCardinality) clazz;
			count = c.getCardinality();
		}
		else if (clazz instanceof OWLObjectIntersectionOf)
		{
			OWLObjectIntersectionOf c = (OWLObjectIntersectionOf) clazz;
			for (OWLClassExpression d : c.getOperands())
			{
				long i = countIndividuals(d, map, axioms);
				if (i > count)
					count = i;
			}
		}
		else if (clazz instanceof OWLObjectUnionOf)
		{
			OWLObjectUnionOf c = (OWLObjectUnionOf) clazz;
			for (OWLClassExpression d : c.getOperands())
				count += countIndividuals(d, map, axioms);
		}

		return count;
	}

	/**
	 * Perform a slow analysis of the ontology.
	 * @return The analysis report messages.
	 **/
	public Collection<String> deepAnalysis()
	{
		Collection<String> messages = new ArrayList<>();

		analyzeEquivalentSubClassOf(messages);
		analyzeExistentialExplosion(messages);
		analyzeDifferentIndividuals(messages);
		analyzeTooDetailedClasses(messages);
		analyzeTooDeepClasses(messages);
		analyzeImpureTrees(messages);

		return messages;
	}

	/**
	 * Generate a message.
	 * @param type
	 *            The type of the message.
	 * @param axioms
	 *            The involved axioms.
	 * @param effect
	 *            The effect of the problem.
	 * @param fix
	 *            How to fix the problem.
	 * @return The message.
	 **/
	private String doMessage(String type, Collection<?> axioms, String effect, String fix)
	{
		StringBuilder sb = new StringBuilder();
		Bundle bundle = Platform.getBundle("it.polito.security.ontologies.tools");
		bundle.getEntry("icons/warning.gif");
		bundle.getEntry("icons/effect.gif");
		bundle.getEntry("icons/fix.gif");

		sb.append("Type: " + type + "\n");
		sb.append("Axioms:\n");
		for (Object x : axioms)
			if (x instanceof OWLAxiom)
				sb.append(" → " + renderer.render((OWLAxiom) x) + "\n");
		sb.append("Effect: " + effect + "\n");
		sb.append("Fix: " + fix + "\n");

		return sb.toString();
	}

	/**
	 * Generate a message.
	 * @param type
	 *            The type of the message.
	 * @param axiom
	 *            The involved axiom.
	 * @param effect
	 *            The effect of the problem.
	 * @param fix
	 *            How to fix the problem.
	 * @return The message.
	 **/
	private String doMessage(String type, OWLAxiom axiom, String effect, String fix)
	{
		return doMessage(type, Collections.singleton(axiom), effect, fix);
	}

	/**
	 * Perform a fast analysis of the ontology.
	 * @return The analysis report messages.
	 **/
	public Collection<String> shallowAnalysis()
	{
		Collection<String> messages = new ArrayList<>();

		for (OWLAxiom axiom : ontology.getAxioms())
			analyzeAxiom(axiom, messages);

		return messages;
	}

	/** The maximum allowed cardinality. **/
	public int MAX_CARDINALITY = 10;

	/** The maximum allowed number of axioms over a single class. **/
	public int MAX_CLASS_AXIOMS = 10;

	/** The maximum allowed depth of a single class. **/
	public int MAX_CLASS_DEPTH = 5;

	/** The maximum allowed number of parents of a class. **/
	public int MAX_CLASS_PARENTS = 2;

	/** The maximum allowed number of different individuals axioms over a single individual. **/
	public int MAX_DIFFERENT_INDIVIDUALS = 8;

	/** The maximum allowed disjunctions. **/
	public int MAX_DISJUNCTIONS = 10;

	/** The maximum allowed number of individuals for an existential explosion. **/
	public int MAX_EXPLOSION = 10000;

	/** The ontology to analyze. **/
	private OWLOntology ontology;

	/** The ontology renderer. **/
	private OWLObjectRenderer renderer;
}
