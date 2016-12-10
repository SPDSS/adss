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
package eu.aspire_fp7.adss.l1p;

import java.util.List;

/**
 * A permutation prefix checker.
 * @author Daniele Canavese
 * @param <T>
 *            The type of the array elements.
 **/
public interface PrefixTester<T>
{
	/**
	 * Checks if a vector prefix is valid. This method must check if the first @a size elements of @a vector are valid.
	 * @param vector
	 *            The vector to check.
	 * @param size
	 *            The number of elements to check.
	 * @return <code>true</code> if the prefix is valid, <code>false</code> otherwise.
	 **/
	public boolean isValid(List<T> vector, int size);
}
