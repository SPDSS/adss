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
import eu.aspire_fp7.adss.akb.ApplicationPart;

/**
 * The application part expansion model.
 * @author Daniele Canavese
 **/
public class ApplicationPartExpansionModel implements TreeList.ExpansionModel<ApplicationPart>
{
	/**
	 * Checks if an application part is expanded or not.
	 * @param element
	 *            The element.
	 * @param path
	 *            The element's path.
	 * @return <code>true</code> if the children should be visible, <code>false</code> otherwise.
	 **/
	@Override
	public boolean isExpanded(ApplicationPart element, List<ApplicationPart> path)
	{
		return element.containsAsset();
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
	public void setExpanded(ApplicationPart element, List<ApplicationPart> path, boolean expanded)
	{
	}
}
