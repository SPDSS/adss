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
package eu.aspire_fp7.adss.light.akb.ui.wizards;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The remote connection wizard page.
 * @author Daniele Canavese
 **/
public class RemoteConnectionPage extends WizardPage
{
	/**
	 * Creates the page.
	 **/
	protected RemoteConnectionPage()
	{
		super("Create an ADSS Light Software Protection Project");
		setTitle("Create an ADSS Light Software Protection Project");
		setDescription("Specify the ADSS connection.");
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
		composite.setLayout(new GridLayout(2, false));

		remoteConnectionButton = new Button(composite, SWT.CHECK);
		remoteConnectionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		remoteConnectionButton.setText("Remote connection");
		remoteConnectionButton.setSelection(true);

		Label labelRemoteHost = new Label(composite, SWT.NONE);
		labelRemoteHost.setText("Remote host:");

		textRemoteHost = new Text(composite, SWT.BORDER);
		textRemoteHost.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRemoteHost.setText("127.0.1.1");

		Label labelRemotePort = new Label(composite, SWT.NONE);
		labelRemotePort.setText("Remote port:");

		textRemotePort = new Text(composite, SWT.BORDER);
		textRemotePort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRemotePort.setText("3022");

		Label labelRemoteUsername = new Label(composite, SWT.NONE);
		labelRemoteUsername.setText("Remote username:");

		textRemoteUsername = new Text(composite, SWT.BORDER);
		textRemoteUsername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRemoteUsername.setText("aspire");

		Label labelRemotePassword = new Label(composite, SWT.NONE);
		labelRemotePassword.setText("Remote password:");

		textRemotePassword = new Text(composite, SWT.BORDER);
		textRemotePassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textRemotePassword.setText("aspire");

		Label labelServerFileSeparator = new Label(composite, SWT.NONE);
		labelServerFileSeparator.setText("Remote server file separator:");

		textServerFileSeparator = new Text(composite, SWT.BORDER);
		textServerFileSeparator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textServerFileSeparator.setText("/");
		
		remoteConnectionButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				textRemoteHost.setEnabled(remoteConnectionButton.getSelection());
				textRemotePort.setEnabled(remoteConnectionButton.getSelection());
				textRemoteUsername.setEnabled(remoteConnectionButton.getSelection());
				textRemotePassword.setEnabled(remoteConnectionButton.getSelection());
				textServerFileSeparator.setEnabled(remoteConnectionButton.getSelection());
			}
		});
		
		ModifyListener completiontLister = new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (textRemoteHost.getText().isEmpty())
					setPageComplete(false);
				else if (textRemotePort.getText().isEmpty())
					setPageComplete(false);
				else if (textRemoteUsername.getText().isEmpty())
					setPageComplete(false);
				else if (textRemotePassword.getText().isEmpty())
					setPageComplete(false);
				else if (textServerFileSeparator.getText().isEmpty())
					setPageComplete(false);
				else
					setPageComplete(true);
			}
		};
		textRemoteHost.addModifyListener(completiontLister);
		textRemotePort.addModifyListener(completiontLister);
		textRemoteUsername.addModifyListener(completiontLister);
		textRemotePassword.addModifyListener(completiontLister);
		textServerFileSeparator.addModifyListener(completiontLister);
	}

	/** The remote connection button. **/
	private Button remoteConnectionButton;
	/** The remote host text. **/
	private Text textRemoteHost;
	/** The remote port text. **/
	private Text textRemotePort;
	/** The remote username text. **/
	private Text textRemoteUsername;
	/** The remote password text. **/
	private Text textRemotePassword;
	/** The remote server file separator text. **/
	private Text textServerFileSeparator;

	/**
	 * Retrieves the remote connection status.
	 * @return <code>true</code> if the remote connection is on, <code>false</code> otherwise.
	 **/
	public boolean isRemoteConnection()
	{
		return remoteConnectionButton.getSelection();
	}

	/**
	 * Retrieves the remote host.
	 * @return The remote host.
	 **/
	public String getRemoteHost()
	{
		return textRemoteHost.getText();
	}

	/**
	 * Retrieves the remote port.
	 * @return The remote port.
	 **/
	public String getRemotePort()
	{
		return textRemotePort.getText();
	}

	/**
	 * Retrieves the remote username.
	 * @return The remote username.
	 **/
	public String getRemoteUsername()
	{
		return textRemoteUsername.getText();
	}

	/**
	 * Retrieves the remote password.
	 * @return The remote password.
	 **/
	public String getRemotePassword()
	{
		return textRemotePassword.getText();
	}

	/**
	 * Retrieves the remote server file separator.
	 * @return The remote server file separator.
	 **/
	public String getRemoteServerFileSeparator()
	{
		return textServerFileSeparator.getText();
	}
}
