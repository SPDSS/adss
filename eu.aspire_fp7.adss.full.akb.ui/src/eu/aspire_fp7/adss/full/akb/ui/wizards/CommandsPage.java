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
package eu.aspire_fp7.adss.full.akb.ui.wizards;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The commands wizard page.
 * @author Daniele Canavese
 **/
public class CommandsPage extends WizardPage
{
	/**
	 * Creates the page.
	 **/
	protected CommandsPage()
	{
		super("Create an ADSS Full Software Protection Project");
		setTitle("Create an ADSS Full Software Protection Project");
		setDescription("Select the external commands to use.");
		setPageComplete(true);
	}

	/**
	 * Fills the page.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(3, false));

		Label labelACTCCommand = new Label(composite, SWT.NONE);
		labelACTCCommand.setText("ACTC command:");

		textACTCCommand = new Text(composite, SWT.BORDER);
		textACTCCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textACTCCommand.setText("/opt/ACTC/actc.py");

		final Button buttonACTCCommand = new Button(composite, SWT.NONE);
		buttonACTCCommand.setText("Browse...");

		Label labelCodeSurferCommand = new Label(composite, SWT.NONE);
		labelCodeSurferCommand.setText("Perl interpreter:");

		textPerlCommand = new Text(composite, SWT.BORDER);
		textPerlCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textPerlCommand.setText("/usr/bin/perl");

		final Button buttonCodeSurferCommand = new Button(composite, SWT.NONE);
		buttonCodeSurferCommand.setText("Browse...");

		Label labelCompilationCommand = new Label(composite, SWT.NONE);
		labelCompilationCommand.setText("Local dot utility:");

		textDotCommand = new Text(composite, SWT.BORDER);
		textDotCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (Platform.getOS().equals(Platform.OS_WIN32))
			textDotCommand.setText("C:\\Program Files\\Graphviz\\bin\\dot.exe");
		else
			textDotCommand.setText("/usr/bin/dot");

		final Button buttonCompilationCommand = new Button(composite, SWT.NONE);
		buttonCompilationCommand.setText("Browse...");

		buttonACTCCommand.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell());
						dialog.setText("ACTC command");
						String file = dialog.open();
						if (file != null)
							textACTCCommand.setText(file);
					}
				});
			}
		});
		buttonCodeSurferCommand.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell());
						dialog.setText("CodeSurfer command");
						String file = dialog.open();
						if (file != null)
							textPerlCommand.setText(file);
					}
				});
			}
		});
		buttonCompilationCommand.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell());
						dialog.setText("Compilation command");
						String file = dialog.open();
						if (file != null)
							textDotCommand.setText(file);
					}
				});
			}
		});

		ModifyListener completiontLister = new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (textACTCCommand.getText().isEmpty())
					setPageComplete(false);
				else if (textPerlCommand.getText().isEmpty())
					setPageComplete(false);
				else if (textDotCommand.getText().isEmpty())
					setPageComplete(false);
				else
					setPageComplete(true);
			}
		};
		textACTCCommand.addModifyListener(completiontLister);
		textPerlCommand.addModifyListener(completiontLister);
		textDotCommand.addModifyListener(completiontLister);
	}

	/** The ACTC command text. **/
	private Text textACTCCommand;
	/** The Perl interpreter text. **/
	private Text textPerlCommand;
	/** The Dot utility text. **/
	private Text textDotCommand;

	/**
	 * Retrieves the ACTC command.
	 * @return The ACTC command.
	 **/
	public String getACTCCommand()
	{
		return textACTCCommand.getText();
	}

	/**
	 * Retrieves the Perl interpreter.
	 * @return The Perl interpreter.
	 **/
	public String getPerlCommand()
	{
		return textPerlCommand.getText();
	}

	/**
	 * Retrieves the Dot utility.
	 * @return The Dot utility.
	 **/
	public String getDotCommand()
	{
		return textDotCommand.getText();
	}
}
