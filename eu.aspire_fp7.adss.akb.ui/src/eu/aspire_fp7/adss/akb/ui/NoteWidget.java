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
package eu.aspire_fp7.adss.akb.ui;

import java.net.MalformedURLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import eu.aspire_fp7.adss.util.Eclipse;

/**
 * A note widget.
 * @author Daniele Canavese
 **/
public class NoteWidget extends Composite
{
	/**
	 * Creates the widget.
	 * @param composite
	 *            The parent composite.
	 * @param text
	 *            The message text.
	 */
	public NoteWidget(Composite composite, String text)
	{
		super(composite, SWT.NONE);
		setLayout(new GridLayout());

		CLabel noteLabel = new CLabel(this, SWT.NONE);
		noteLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		noteLabel.setText(text);
		noteLabel.setForeground(Eclipse.CreateColor(63, 63, 63));
		noteLabel.setBackground(new Color[] { Eclipse.CreateColor(255, 255, 255), Eclipse.CreateColor(255, 220, 100) }, new int[] { 100 },
				true);
		try
		{
			noteLabel.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/noteBadge.png"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}
}
