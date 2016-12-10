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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.odell.glazedlists.TreeList;
import eu.aspire_fp7.adss.akb.ApplicationPart;

/**
 * The application part format.
 * @author Daniele Canavese
 **/
public class ApplicationPartFormat implements TreeList.Format<ApplicationPart>
{
	/**
	 * Checks if an element can have children.
	 * @param element
	 *            The element.
	 * @return <code>true</code> if the element can have children, <code>false</code> otherwise.
	 **/
	@Override
	public boolean allowsChildren(ApplicationPart element)
	{
		return !element.getApplicationParts().isEmpty();
	}

	/**
	 * Retrieves the path of an element.
	 * @param element
	 *            The element.
	 * @param path
	 *            The list where to write the path.
	 **/
	@Override
	public void getPath(List<ApplicationPart> path, ApplicationPart element)
	{
		path.clear();
		path.add(element);
		ApplicationPart parent = element.getDeclaringCode();
		while (parent != null)
		{
			path.add(parent);
			parent = parent.getDeclaringCode();
		}
		Collections.reverse(path);
	}

	/**
	 * Returns the element comparator.
	 * @param depth
	 *            The elements depth.
	 * @return The comparator or <code>null</code> if no comparator is needed.
	 */
	@Override
	public Comparator<? super ApplicationPart> getComparator(int depth)
	{
		return null;
	}

}
