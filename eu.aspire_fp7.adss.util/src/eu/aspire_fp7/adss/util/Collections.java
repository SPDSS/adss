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
package eu.aspire_fp7.adss.util;

import java.util.Collection;

/**
 * Collections utilities.
 * @author Daniele Canavese
 **/
public class Collections
{
	/**
	 * Private constructor.
	 **/
	private Collections()
	{
	}

	/**
	 * Adds an element to a collection iff another equivalent one is not already present.
	 * @param <T>
	 *            The collection base type.
	 * @param collection
	 *            The collection to modify.
	 * @param element
	 *            The element to add.
	 * @return <code>true</code> if the element was added, <code>false</code> otherwise.
	 **/
	static public <T> boolean addUnique(Collection<T> collection, T element)
	{
		for (T i : collection)
			if (i.equals(element))
				return false;

		collection.add(element);
		return true;
	}

	/**
	 * Checks if two collections have at least one element in common.
	 * @param collection1
	 *            The first collection.
	 * @param collection2
	 *            The second collection.
	 * @return <code>true</code> if the collections are not disjoint, <code>false</code> otherwise.
	 **/
	static public <T> boolean containsAny(Collection<T> collection1, Collection<T> collection2)
	{
		for (T i : collection1)
			for (T j : collection2)
				if (i.equals(j))
					return true;
		return false;
	}
}
