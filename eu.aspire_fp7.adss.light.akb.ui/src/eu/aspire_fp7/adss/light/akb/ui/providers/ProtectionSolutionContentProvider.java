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
package eu.aspire_fp7.adss.light.akb.ui.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.aspire_fp7.adss.akb.AttackTarget;

import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;

/**
 * The ONE protection solution content provider.
 * @author Gaofeng ZHANG
 **/
public class ProtectionSolutionContentProvider implements ITreeContentProvider
{
	/**
	 * Detects if an element has some children.
	 * @param element
	 *            The element.
	 * @return <code>true</code> if the element has at least one children, <code>false</code> otherwise.
	 **/
	@Override
	public boolean hasChildren(Object element)
	{
		Object[] children = getChildren(element);
		return children != null && children.length > 0;
	}

	/**
	 * Disposes the provider.
	 **/
	@Override
	public void dispose()
	{
	}

	/**
	 * Signals an input change.
	 * @param viewer
	 *            The viewer.
	 * @param oldInput
	 *            The old input.
	 * @param newInput
	 *            The new input.
	 **/
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
	}

	/**
	 * Retrieves the initial elements.
	 * @param inputElement
	 *            The input element.
	 * @return The initial elements.
	 **/
	@Override
	public Object[] getElements(Object inputElement)
	{
		if (inputElement instanceof Solution)
		{
			Solution solution = ((Solution) inputElement);
			return solution.getSolutionSequences().toArray();
		}
		else if (inputElement instanceof SolutionSequence)
		{
			SolutionSequence solutionSequence = ((SolutionSequence) inputElement);
			return solutionSequence.getAppliedProtectionInstantiations().toArray();
		}
		else
			return null;
	}

	/**
	 * Retrieves the children of an element.
	 * @param parentElement
	 *            The element.
	 * @return The children of the element.
	 **/
	@Override
	public Object[] getChildren(Object parentElement)
	{
		if (parentElement instanceof Solution)
		{
			Solution solution = ((Solution) parentElement);
			return solution.getSolutionSequences().toArray();
		}
		else if (parentElement instanceof SolutionSequence)
		{
			SolutionSequence solutionSequence = ((SolutionSequence) parentElement);
			return solutionSequence.getAppliedProtectionInstantiations().toArray();
		}
		else
			return null;
	}

	/**
	 * Retrieves the parent of an element.
	 * @param element
	 *            The element.
	 * @return The parent of the element.
	 **/
	@Override
	public Object getParent(Object element)
	{
		return null;
	}
}
