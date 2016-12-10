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
package eu.aspire_fp7.adss.akb.ui.dialogs;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * A simple key-value view dialog.
 * @author Leonardo Regano, Daniele Canavese
 **/
public class KeyValueDialog extends Dialog
{
	/** The map to show. **/
	private Map<Object, Object> map;
	/** A description. **/
	private String description;

	/**
	 * Creates the dialog.
	 * @param parent
	 *            The parent shell.
	 * @param description
	 *            A description.
	 * @param model
	 *            The AKB model to use.
	 **/
	public KeyValueDialog(Shell parent, String description, Map<Object, Object> map)
	{
		super(parent);
		this.description = description;
		this.map = map;
	}

	/**
	 * Retrieves a value stating if the dialog is resizable.
	 * @return Always <code>true</code>.
	 **/
	@Override
	protected boolean isResizable()
	{
		return true;
	}

	/**
	 * Configures the shell.
	 * @param newShell
	 *            The shell to configure.
	 **/
	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("ADSS");
	}

	/**
	 * Creates a button.
	 * @param parent
	 *            The parent composite.
	 * @param id
	 *            The button id.
	 * @param label
	 *            The button label.
	 * @param defaultButton
	 *            A value stating if the button is the default one or not.
	 * @return The button or <code>null</code> if no button was created.
	 **/
	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton)
	{
		if (id == IDialogConstants.CANCEL_ID)
			return null;
		else
			return super.createButton(parent, id, label, defaultButton);
	}

	/**
	 * Creates the dialog area.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite composite = (Composite) super.createDialogArea(parent);

		Label label = new Label(composite, SWT.NONE);
		label.setText(description);

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = 500;

		Table table = new Table(composite, SWT.NONE);
		table.setLayoutData(gridData);
		TableLayout layout = new TableLayout();
		table.setLayout(layout);

		new TableColumn(table, SWT.NONE);
		ColumnWeightData keyColumnLayoutData = new ColumnWeightData(1);
		keyColumnLayoutData.minimumWidth = 250;
		layout.addColumnData(keyColumnLayoutData);
		new TableColumn(table, SWT.NONE);
		ColumnWeightData valueColumnLayoutData = new ColumnWeightData(1);
		valueColumnLayoutData.minimumWidth = 250;
		layout.addColumnData(valueColumnLayoutData);

		for (Entry<Object, Object> i : map.entrySet())
		{
			TableItem item = new TableItem(table, SWT.NONE);
			Object key = i.getKey();
			if (key == null)
				key = "<null>";
			item.setText(0, key.toString());
			Object value = i.getValue();
			if (value == null)
				value = "<null>";
			item.setText(1, value.toString());
		}

		return composite;
	}
}
