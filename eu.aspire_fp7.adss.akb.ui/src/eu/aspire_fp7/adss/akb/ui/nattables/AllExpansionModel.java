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
package eu.aspire_fp7.adss.akb.ui.nattables;

import java.util.List;

import ca.odell.glazedlists.TreeList;

/**
 * The expansion model that expands everything or nothing.
 * @param <T>
 *            The list base type.
 * @author Daniele Canavese
 **/
public class AllExpansionModel<T> implements TreeList.ExpansionModel<T>
{
	/** The default expansion value. **/
	private boolean allExpanded;

	/**
	 * Creates the expansion model.
	 * @param allExpanded
	 *            <code>true</code> if everything should be expanded or <code>false</code> if nothing should be expanded.
	 */
	public AllExpansionModel(boolean allExpanded)
	{
		this.allExpanded = allExpanded;
	}

	/**
	 * Checks if an element part is expanded or not.
	 * @param element
	 *            The element.
	 * @param path
	 *            The element's path.
	 * @return <code>true</code> if the children should be visible, <code>false</code> otherwise.
	 **/
	@Override
	public boolean isExpanded(T element, List<T> path)
	{
		return allExpanded;
	}

	/**
	 * Sets an element as expanded or not.
	 * @param element
	 *            The element.
	 * @param path
	 *            The element's path.
	 * @param expanded
	 *            The element's expanded state.
	 **/
	@Override
	public void setExpanded(T element, List<T> path, boolean expanded)
	{
	}
}
