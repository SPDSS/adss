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
package it.polito.security.ontologies.samples;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * A sample test.
 * @author Daniele Canavese
 **/
public abstract class Sample
{
	/**
	 * Find a file in the bundle.
	 * @param path
	 *            The path of the file.
	 * @return The file or <code>null</code> if something goes wrong.
	 **/
	protected File getFile(String path)
	{
		Bundle bundle = Platform.getBundle("it.polito.security.ontologies.samples");
		URL fileURL = bundle.getEntry(path);
		try
		{
			return new File(FileLocator.resolve(fileURL).toURI());
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public abstract void run() throws Exception;
}
