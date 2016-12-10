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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;

import eu.aspire_fp7.adss.akb.AKBUtil;
import eu.aspire_fp7.adss.akb.Model;

/**
 * The ADSS service.
 * @author Daniele Canavese
 **/
public class ADSSService
{
	/** The IFile ADSS map. **/
	private Map<IFile, Model> map;
	/** The reference counter map. **/
	private Map<Model, Integer> counters;
	/** The dirty states map. **/
	private Map<Model, Boolean> dirties;
	/** The listeners. **/
	private Map<Model, List<ADSSDirtyListener>> listeners;

	/**
	 * The private constructor.
	 **/
	ADSSService()
	{
		map = new HashMap<>();
		counters = new HashMap<>();
		dirties = new HashMap<>();
		listeners = new HashMap<>();
	}

	/**
	 * Retrieves the model related to an IFile object.
	 * @param file
	 *            The file.
	 * @return The related model object.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public Model getModel(IFile file) throws Exception
	{
		Model model;

		if (map.containsKey(file))
		{
			model = map.get(file);
			counters.put(model, counters.get(model) + 1);
		}
		else
		{
			model = AKBUtil.loadFromOntology(file);
			map.put(file, model);
			counters.put(model, 1);
			dirties.put(model, false);
		}

		return model;
}

	/**
	 * Checks the dirty state of a model.
	 * @param model
	 *            The model.
	 * @return The model dirty state.
	 **/
	public boolean isDirty(Model model)
	{
		if (dirties.containsKey(model))
			return dirties.get(model);
		else
			return false;
	}

	/**
	 * Changes the dirty state of a model.
	 * @param model
	 *            The model.
	 * @param value
	 *            The dirty state.
	 **/
	public void setDirty(Model model, boolean value)
	{
		boolean dirty = dirties.get(model);

		if (value != dirty)
		{
			dirties.put(model, value);
			for (ADSSDirtyListener i : listeners.get(model))
				i.dirtyStateChanged(model, value);
		}
	}

	/**
	 * Disposes a model (it is remove from the internal cache).
	 * @param model
	 *            The model to dispose.
	 * @return The dirty state of the model.
	 **/
	public boolean dispose(Model model)
	{
		int counter = counters.get(model);
		boolean dirty = dirties.get(model);

		if (counter <= 1)
		{
			map.values().remove(model);
			counters.remove(model);
			dirties.remove(model);
		}
		else
			counters.put(model, counter - 1);

		return dirty;
	}

	/**
	 * Adds a new dirty state listener.
	 * @param listener
	 *            The listener to add.
	 * @param adss
	 *            The model to listen to.
	 */
	public void addListener(ADSSDirtyListener listener, Model model)
	{
		List<ADSSDirtyListener> list;

		if (listeners.containsKey(model))
			list = listeners.get(model);
		else
		{
			list = new ArrayList<>();
			listeners.put(model, list);
		}

		list.add(listener);
	}

	/**
	 * Removes a dirty state listener.
	 * @param listener
	 *            The listener to remove.
	 * @param adss
	 *            The model to listen to.
	 */
	public void removeListener(ADSSDirtyListener listener, Model model)
	{
		if (listeners.containsKey(model))
		{
			List<ADSSDirtyListener> list = listeners.get(model);
			list.remove(listener);
			if (list.isEmpty())
				listeners.remove(model);
		}
	}
}
