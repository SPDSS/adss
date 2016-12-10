/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.mindswap.pellet.Individual;
import org.mindswap.pellet.Literal;
import org.mindswap.pellet.Node;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLIndividual;

import com.clarkparsia.pellet.rules.BindingHelper;
import com.clarkparsia.pellet.rules.VariableBinding;
import com.clarkparsia.pellet.rules.VariableUtils;
import com.clarkparsia.pellet.rules.model.AtomDConstant;
import com.clarkparsia.pellet.rules.model.AtomDObject;
import com.clarkparsia.pellet.rules.model.AtomDVariable;
import com.clarkparsia.pellet.rules.model.AtomIObject;
import com.clarkparsia.pellet.rules.model.AtomIVariable;
import com.clarkparsia.pellet.rules.model.AtomVariable;
import com.clarkparsia.pellet.rules.model.BuiltInAtom;

import aterm.ATermAppl;

/**
 * A SWRL binding helper. Code inspired by the work of Martin Kuba.
 * @author Daniele Canavese
 **/
class SWRLHelper implements BindingHelper
{

	/**
	 * Creates the helper.
	 * @param atom
	 *            The atom to analyze.
	 * @param builtin
	 *            The custom built-in.
	 */
	public SWRLHelper(BuiltInAtom atom, SWRLBuiltIn builtin)
	{
		this.atom = atom;
		this.builtin = builtin;
	}

	/**
	 * Executes the custom built-in.
	 * @param binding
	 *            The variable binding.
	 * @param arguments
	 *            The built-in arguments.
	 * @return <code>true</code> if the built-in succeeded, <code>false</code> otherwise.
	 **/
	private boolean apply(VariableBinding binding, Node[] arguments)
	{
		Ontology ontology = Ontology.getOntologyMapping(binding.getABox().getKB());

		List<Object> parameters = new ArrayList<>();
		for (Node n : arguments)
			if (n.isLiteral())
			{
				Literal literal = (Literal) n;
				parameters.add(literal.getValue());
			}
			else if (n.isIndividual())
			{
				Individual individual = (Individual) n;
				OWLIndividual i;
				if (n.isBnode())
					i =
					ontology.dataFactory.getOWLAnonymousIndividual(((ATermAppl) n.getTerm().getArgument(0))
						.getName());
				else
				{
					IRI iri = IRI.create(individual.getTerm().getName());
					i = ontology.dataFactory.getOWLNamedIndividual(iri);
				}

				parameters.add(new OntologyIndividual(ontology, i));
			}
		return builtin.execute(ontology, parameters.toArray());
	}

	/**
	 * Converts an atom data variable to an atom instance variable.
	 * @param atomDVariable
	 *            The atom data variable to convert.
	 * @return The equivalent atom instance variable.
	 **/
	private AtomIVariable d2i(AtomDVariable atomDVariable)
	{
		return new AtomIVariable((atomDVariable.getName()));
	}

	/**
	 * Returns a set of variables which this binding helper can additionally bind if the variables in the argument are
	 * already bound.
	 * @param bound
	 *            variables that are bound to values
	 * @return variables from the atom that the build would additionally bind
	 */
	@Override
	public Collection<? extends AtomVariable> getBindableVars(Collection<AtomVariable> bound)
	{
		if (isApplicable(bound) == false)
			return Collections.emptySet();
		Collection<AtomVariable> vars = VariableUtils.getVars(atom);
		vars.removeAll(bound);

		return vars;
	}

	/**
	 * Returns a set of variables which must be bound before this helper can generate bindings. Please note that
	 * constants are taken as bound arguments so they are not reported.
	 * @param bound
	 *            variables that are bound to values
	 * @return variables that must be also bound before the built-in can be invoked.
	 */
	@Override
	public Collection<? extends AtomVariable> getPrerequisiteVars(Collection<AtomVariable> bound)
	{
		Collection<AtomVariable> vars = VariableUtils.getVars(atom);
		vars.removeAll(getBindableVars(bound));

		return vars;
	}

	/**
	 * Retrieves a value from a variable binding.
	 * @param key
	 *            The key.
	 * @param binding
	 *            The binding.
	 * @return The value or <code>null</code> if something goes wrong.
	 **/
	private Node getValueFromVariableBinding(AtomDObject key, VariableBinding binding)
	{
		if (key instanceof AtomDVariable)
		{
			AtomDVariable atomDVariable = (AtomDVariable) key;
			Literal literal = binding.get(atomDVariable);
			return (literal != null) ? literal : binding.get(d2i(atomDVariable));
		}
		else if (key instanceof AtomDConstant)
			return binding.get(key);
		else
			return null;
	}

	/**
	 * Detects if the atom arguments are bounded or not and call the custom built-in to see if it is supported.
	 * @param bound
	 *            The binding of variables to values.
	 * @return <code>true</code> if the built-in can be invoked, <code>false</code> otherwise.
	 */
	private boolean isApplicable(Collection<AtomVariable> bound)
	{
		boolean[] boundPositions = new boolean[atom.getAllArguments().size()];
		for (int i = 0; i < boundPositions.length; i++)
		{
			AtomDObject atomDObject = atom.getAllArguments().get(i);
			if (atomDObject instanceof AtomDVariable)
			{
				AtomDVariable atomDVariable = (AtomDVariable) atomDObject;
				boolean b = bound.contains(atomDVariable);
				if (b == false)
					b = bound.contains(d2i(atomDVariable));
				boundPositions[i] = b;
			}
			else if (atomDObject instanceof AtomDConstant)
				boundPositions[i] = true;
		}

		return builtin.isApplicable(boundPositions);
	}

	/**
	 * Sets the incoming binding for this helper.
	 * @param newBinding
	 *            The Binding map.
	 */
	@Override
	public void rebind(VariableBinding newBinding)
	{
		List<AtomDObject> atomArguments = atom.getAllArguments();
		Node[] arguments = new Node[atomArguments.size()];
		for (int i = 0; i < arguments.length; i++)
			arguments[i] = getValueFromVariableBinding(atomArguments.get(i), newBinding);
		if (apply(newBinding, arguments))
		{
			VariableBinding newPartial = new VariableBinding(newBinding.getABox());
			for (int i = 0; i < arguments.length; i++)
			{
				AtomDObject arg = atomArguments.get(i);
				Node result = arguments[i];
				Node current = getValueFromVariableBinding(arg, newBinding);
				if (current == null)
				{
					if (result.isLiteral())
						newBinding.set(arg, (Literal) result);
					else if (result.isIndividual())
						newBinding.set(d2i((AtomDVariable) arg), (Individual) result);
				}
			}
			used = false;
			partial = newPartial;
		}
	}

	/**
	 * Selects the next binding.
	 * @return <code>true</code> if a binding was available for this pattern, <code>false</code> otherwise.
	 **/
	@Override
	public boolean selectNextBinding()
	{
		if (partial != null && used == false)
		{
			used = true;
			return true;
		}
		else
			return false;
	}

	/**
	 * Sets the variables this pattern uses in the given map.
	 * @param currentBinding
	 *            The current binding.
	 */
	@Override
	public void setCurrentBinding(VariableBinding currentBinding)
	{
		for (Map.Entry<? extends AtomVariable, ? extends Node> entry : partial.entrySet())
		{
			AtomVariable atomVariable = entry.getKey();
			Node node = entry.getValue();
			if (atomVariable instanceof AtomIObject && node.isIndividual())
				currentBinding.set((AtomIObject) atomVariable, (Individual) node);
			else if (atomVariable instanceof AtomDObject && node.isLiteral())
				currentBinding.set((AtomDObject) atomVariable, (Literal) node);
		}
	}

	/** The atom to analyze. **/
	private BuiltInAtom atom;

	/** The built-in. **/
	private SWRLBuiltIn builtin;

	/** The partial variable binding. **/
	private VariableBinding partial;

	/** The usage of this binding. **/
	private boolean used;
}
