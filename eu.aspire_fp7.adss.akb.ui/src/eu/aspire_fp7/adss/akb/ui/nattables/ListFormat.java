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

import java.util.Comparator;
import java.util.List;

import ca.odell.glazedlists.TreeList;

/**
 * The format that shows a simple list.
 * @param <T>
 *            The list base type.
 * @author Daniele Canavese
 **/
public class ListFormat<T> implements TreeList.Format<T>
{
	/**
	 * Checks if an element can have children.
	 * @param element
	 *            The element.
	 * @return <code>true</code> if the element can have children, <code>false</code> otherwise.
	 **/
	@Override
	public boolean allowsChildren(T element)
	{
		return false;
	}

	/**
	 * Retrieves the path of an element.
	 * @param element
	 *            The element.
	 * @param path
	 *            The list where to write the path.
	 **/
	@Override
	public void getPath(List<T> path, T element)
	{
		path.clear();
		path.add(element);
	}

	/**
	 * Returns the element comparator.
	 * @param depth
	 *            The elements depth.
	 * @return The comparator or <code>null</code> if no comparator is needed.
	 */
	@Override
	public Comparator<T> getComparator(int depth)
	{
		return null;
	}

}
