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

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.akb.ui.listeners.ADSSEventListener;
import eu.aspire_fp7.adss.akb.ui.listeners.Event;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * A summary section.
 * @author Daniele Canavese
 **/
public class SummarySection extends SectionPart implements ADSSEventListener
{
	/** The labels mapping. **/
	private final Map<LabelType, CLabel> map;
	/** The ADSS. **/
	private final ADSS adss;

	/**
	 * Creates the section.
	 * @param adss
	 *            The ADSS.
	 * @param form
	 *            The form.
	 * @param labels
	 *            The labels.
	 **/
	public SummarySection(ADSS adss, IManagedForm form, LabelType... labels)
	{
		super(form.getForm().getBody(), form.getToolkit(), ExpandableComposite.TITLE_BAR);

		this.adss = adss;
		map = new HashMap<>();

		getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
		getSection().setText("Summary");

		Composite summaryComposite = new Composite(getSection(), SWT.NONE);
		form.getToolkit().adapt(summaryComposite);
		form.getToolkit().paintBordersFor(summaryComposite);
		getSection().setClient(summaryComposite);
		summaryComposite.setLayout(new ColumnLayout());

		for (LabelType i : labels)
			try
			{
				CLabel label = new CLabel(summaryComposite, SWT.NONE);
				label.setLayoutData(new ColumnLayoutData(ColumnLayoutData.FILL));
				label.setText(i.getString(adss.getModel()));
				label.setImage(Eclipse.getImage(Activator.PLUGIN_ID, i.getIcon()));
				map.put(i, label);
			}
			catch (MalformedURLException e)
			{
			}
	}


	/**
	 * Handles an event.
	 * @param event
	 *            The event.
	 **/
	@Override
	public void handleEvent(final Event event)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				for (LabelType i : map.keySet())
					if (event == i.getEvent())
						map.get(i).setText(i.getString(adss.getModel()));
			}
		});
	}
}
