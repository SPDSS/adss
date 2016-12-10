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
package eu.aspire_fp7.adss.akb.ui.providers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;

/**
 * The golden solution content provider.
 * @author Daniele Canavese
 **/
public class SolutionContentProvider implements ILazyTreeContentProvider
{
	/** The viewer. **/
	private TreeViewer viewer;

	/** If also the second level solutions must be provided. **/
	private boolean provideL2P;
	
	public SolutionContentProvider(boolean provideL2P) {
		super();
		this.provideL2P = provideL2P;
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
		this.viewer = (TreeViewer) viewer;
	}

	/**
	 * Updates the n-th element.
	 * @param parent
	 *            The parent.
	 * @param THe
	 * @return The initial elements.
	 **/
	@Override
	public void updateElement(Object parent, int index)
	{
		if (parent instanceof Model)
		{
			List<Solution> solutions = new LinkedList<Solution>();
			if(!provideL2P)
				for(Solution solution : ((Model) parent).getSolutions())
				{
					if(solution.getFirstLevelSolution()==null)
						solutions.add(solution);
				}
			else
				solutions.addAll(((Model) parent).getSolutions());
			solutions.sort(new Comparator<Solution>() {

				@Override
				public int compare(Solution o1, Solution o2) {
					if(o2.getScore()-o1.getScore()!=0)
						return Double.compare(o2.getScore(), o1.getScore());
					else if (o1.getFirstLevelSolution()!=null)
						return 1;
					else return -1;
				}
			});
			Solution child = solutions.get(index);
			viewer.replace(parent, index, child);
			viewer.setChildCount(child, child.getSolutionSequences().size());
		}
		else if (parent instanceof Solution)
		{
			SolutionSequence child = ((Solution) parent).getSolutionSequences().get(index);
			viewer.replace(parent, index, child);
			viewer.setChildCount(child, child.getAppliedProtectionInstantiations().size());
		}
		else if (parent instanceof SolutionSequence)
		{
			AppliedProtectionInstantiation child = ((SolutionSequence) parent).getAppliedProtectionInstantiations().get(index);
			viewer.replace(parent, index, child);
			viewer.setChildCount(child, 0);
		}
	}

	/**
	 * Updates the children count of an element.
	 * @param element
	 *            The element.
	 * @param currentChildCount
	 *            The current children count.
	 * @return The children of the element.
	 **/
	@Override
	public void updateChildCount(Object element, int currentChildCount)
	{
		if (element instanceof Model)
		{
			Model model = (Model) element;
			if(provideL2P)
			{
				if (currentChildCount != model.getSolutions().size())
					viewer.setChildCount(element, model.getSolutions().size());
			}
			else
			{
				int totalL1P = 0;
				for(Solution solution : model.getSolutions())
					if(solution.getFirstLevelSolution()==null)
						totalL1P++;
				if (currentChildCount != totalL1P)
					viewer.setChildCount(element, totalL1P);
			}
		}
		else if (element instanceof SolutionSequence)
		{
			SolutionSequence solutionSequence = (SolutionSequence) element;
			if (currentChildCount != solutionSequence.getAppliedProtectionInstantiations().size())
				viewer.setChildCount(element, solutionSequence.getAppliedProtectionInstantiations().size());
		}
		else
			viewer.setChildCount(element, 0);
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
