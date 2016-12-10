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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.ui.providers.NameLabelProvider;
import eu.aspire_fp7.adss.akb.ui.providers.SolutionContentProvider;

/**
 * The solution selection dialog.
 * @author Daniele Canavese
 **/
public class SolutionSelectionDialog extends SelectionStatusDialog
{
	/** The model. **/
	private Model model;
	/** The tree viewer. **/
	private TreeViewer treeViewer;

	/**
	 * Creates the dialog.
	 * @param parent
	 *            The parent shell.
	 * @param model
	 *            The AKB model to use.
	 **/
	public SolutionSelectionDialog(Shell parent, Model model)
	{
		super(parent);
		this.model = model;
	}

	/**
	 * Computes the final results.
	 **/
	@Override
	protected void computeResult()
	{
		if (treeViewer.getSelection() instanceof IStructuredSelection)
		{
			List<Object> list = new ArrayList<>();
			list.add(((IStructuredSelection) treeViewer.getSelection()).getFirstElement());
			setResult(list);
		}
		else
			setResult(null);
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
		label.setText(getMessage());

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gridData.widthHint = 150;
		treeViewer = new TreeViewer(parent, SWT.VIRTUAL);
		treeViewer.setUseHashlookup(true);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(gridData);
		tree.setHeaderVisible(false);
		tree.setLinesVisible(true);

		treeViewer.setContentProvider(new SolutionContentProvider(true));
		treeViewer.setLabelProvider(new NameLabelProvider(false));
		tree.setItemCount(model.getSolutions().size());
		treeViewer.setInput(model);

		final ISelectionStatusValidator validator = new ISelectionStatusValidator()
		{
			@Override
			public IStatus validate(Object[] selection)
			{
				if (selection.length == 1 && selection[0] instanceof Solution)
					return Status.OK_STATUS;
				else
					return Status.CANCEL_STATUS;
			}
		};

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				if (treeViewer.getSelection() instanceof IStructuredSelection)
				{
					IStatus status = validator.validate(((IStructuredSelection) treeViewer.getSelection()).toArray());
					getButton(IDialogConstants.OK_ID).setEnabled(status == Status.OK_STATUS);
				}
			}
		});

		return composite;
	}
}
