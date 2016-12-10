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
package eu.aspire_fp7.adss.ui;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

/**
 * The ADSS service factor.
 * @author Daniele Canavese
 **/
public class ADSSServiceFactory extends AbstractServiceFactory
{
	/** The ADSS service instance. **/
	private static ADSSService instance = null;
	
	/**
	 * Creates a new ADSS service object.
	 **/
	@SuppressWarnings("rawtypes")
	@Override
	public Object create(Class serviceInterface, IServiceLocator parentLocator, IServiceLocator locator)
	{
		if (serviceInterface.equals(ADSSService.class))
		{
			if (instance == null)
				instance = new ADSSService();
			
			return instance;
		}

		return null;
	}
}
