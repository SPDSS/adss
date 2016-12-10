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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * The image dialog.
 * @author Daniele Canavese
 **/
public class ImageDialog extends Dialog
{
	/** The image. **/
	private Image image;

	/**
	 * Creates the dialog.
	 * @param parent
	 *            The parent shell.
	 * @param image
	 *            The image to use.
	 **/
	public ImageDialog(Shell parent, Image image)
	{
		super(parent);
		this.image = image;
	}

	/**
	 * Creates the dialog area.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	protected Control createDialogArea(Composite parent)
	{
		getShell().setText("Image");

		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout());

		ScrolledComposite box = new ScrolledComposite(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		box.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(box, SWT.NONE);
		label.setImage(image);
		label.setSize(label.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		box.setContent(label);

		return composite;
	}

	/**
	 * Creates the buttons.
	 * @param parent
	 *            The parent container.
	 **/
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		Button saveButton = createButton(parent, IDialogConstants.CLIENT_ID, "Save image...", false);
		saveButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell());
				dialog.setText("Export image");
				dialog.setFilterExtensions(new String[] { "*.png" });
				dialog.setFileName("image.png");
				String file = dialog.open();
				if (file != null)
				{
					ImageLoader imageLoader = new ImageLoader();
					imageLoader.data = new ImageData[] { image.getImageData() };
					imageLoader.save(file, SWT.IMAGE_PNG);
				}
			}
		});
	}
}
