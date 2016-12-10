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

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator.
 * @author Daniele Canavese
 **/
public class Activator extends AbstractUIPlugin
{
	/**
	 * Retrieves the activator instance.
	 * @return The activator instance.
	 **/
	public static Activator getInstance()
	{
		return INSTANCE;
	}

	/** This instance. **/
	private static Activator INSTANCE;

	/** The plug-in id. **/
	public static final String PLUGIN_ID = "eu.aspire_fp7.adss.ui";

	/**
	 * The actions to performs when the plug-in is started.
	 * @param context
	 *            The context.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void start(BundleContext context) throws Exception
	{
		super.start(context);
		INSTANCE = this;
	}

	/**
	 * The actions to performs when the plug-in is stopped.
	 * @param context
	 *            The context.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void stop(BundleContext context) throws Exception
	{
		INSTANCE = null;
		super.stop(context);
	}
}
