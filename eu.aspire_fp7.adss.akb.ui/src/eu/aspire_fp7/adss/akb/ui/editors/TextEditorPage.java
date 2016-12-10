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
package eu.aspire_fp7.adss.akb.ui.editors;

import org.eclipse.ui.editors.text.TextEditor;

/**
 * The text editor page.
 * @author Daniele Canavese
 **/
public class TextEditorPage extends TextEditor
{
	/**
	 * Retrieves the dirty state of the editor.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isDirty()
	{
		return false;
	}

	/**
	 * Retrieves the editable status of the editor.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isEditable()
	{
		return false;
	}

	/**
	 * Checks if the input is modifiable.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isEditorInputModifiable()
	{
		return false;
	}

	/**
	 * Checks if the input is read-only.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isEditorInputReadOnly()
	{
		return true;
	}
}
