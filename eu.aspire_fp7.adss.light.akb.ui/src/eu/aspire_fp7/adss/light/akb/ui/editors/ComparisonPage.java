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
package eu.aspire_fp7.adss.light.akb.ui.editors;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The comparison page.
 * @author Daniele Canavese
 **/
public class ComparisonPage extends FormPage
{
	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 **/
	public ComparisonPage(FormEditor editor)
	{
		super(editor, "comparison", "Comparison");
	}

	/**
	 * Creates the form content.
	 * @param managedForm
	 *            The managed form.
	 **/
	@Override
	protected void createFormContent(IManagedForm managedForm)
	{
		try
		{
			ScrolledForm form = managedForm.getForm();
			managedForm.getToolkit().paintBordersFor(form);
			form.setText("Solution Comparison");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png"));
			form.getBody().setLayout(new GridLayout(2, false));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
