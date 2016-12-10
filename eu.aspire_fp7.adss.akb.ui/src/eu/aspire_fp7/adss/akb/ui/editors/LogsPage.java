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

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.ScrolledFormText;

import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The assets page.
 * @author Daniele Canavese
 **/
public class LogsPage extends FormPage
{
	/** The form. **/
	private ScrolledForm form;
	/** The logs so far. **/
	private StringBuilder logs;
	/** The logs text. **/
	private ScrolledFormText logsText;
	/** The default logger. **/
	private static final Logger logger = Logger.getLogger("");

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param container
	 *            The container where to save the log file.
	 * @param eventGenerator
	 *            The event generator.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public LogsPage(FormEditor editor, IContainer container) throws Exception
	{
		super(editor, "logs", "Logs");
		logs = new StringBuilder();
		logsText = null;

		Handler[] handlers = logger.getHandlers();
		for (Handler i : handlers)
			logger.removeHandler(i);

		handlers = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).getHandlers();
		for (Handler i : handlers)
			logger.removeHandler(i);

		final IFile logFile = container.getFile(Path.fromOSString("adss.log"));

		logger.addHandler(new Handler()
		{
			@Override
			public void publish(LogRecord record)
			{
				if (record.getLoggerName().startsWith("eu.aspire_fp7") || record.getLoggerName().startsWith("it.polito")
						|| record.getLoggerName().startsWith("org.uel"))
					try
					{
						logs.append("<p>");
						logs.append("<span color=\"");
						if (record.getLevel() == Level.FINEST || record.getLevel() == Level.FINER || record.getLevel() == Level.FINE)
							logs.append("fine");
						else if (record.getLevel() == Level.CONFIG || record.getLevel() == Level.INFO)
							logs.append("info");
						else
							logs.append("error");
						logs.append("\">");
						logs.append("[" + new Date() + "] " + record.getMessage().replaceAll("&", "&amp;"));
						logs.append("</span>");
						logs.append("</p>");

						String log = record.getLevel() + ": " + record.getMessage() + "\n";
						System.err.print(log);
						if (logFile.exists())
							logFile.appendContents(new ByteArrayInputStream(log.getBytes()), IFile.FORCE, null);
						else
							logFile.create(new ByteArrayInputStream(log.getBytes()), IFile.FORCE, null);

						if (logsText != null && !logsText.isDisposed())
							Display.getDefault().asyncExec(new Runnable()
							{
								@Override
								public void run()
								{
									logsText.setText(logs.toString());
								}
							});
					}
					catch (CoreException e)
					{
						e.printStackTrace();
					}
			}

			@Override
			public void flush()
			{
			}

			@Override
			public void close() throws SecurityException
			{
			}
		});

		logger.setLevel(Level.FINER);
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
			form = managedForm.getForm();
			managedForm.getToolkit().paintBordersFor(form);
			form.setText("Logs");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/logs.png"));
			form.getBody().setLayout(new GridLayout());

			createVerbositySection(managedForm);
			createLogsSection(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the verbosity section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createVerbositySection(IManagedForm managedForm)
	{
		SectionPart verbositySectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(verbositySectionPart);
		verbositySectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		verbositySectionPart.getSection().setText("Verbosity");

		Composite versobityComposite = new Composite(verbositySectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(versobityComposite);
		managedForm.getToolkit().paintBordersFor(versobityComposite);
		verbositySectionPart.getSection().setClient(versobityComposite);
		versobityComposite.setLayout(new GridLayout(8, false));

		Button finestButton = managedForm.getToolkit().createButton(versobityComposite, "finest", SWT.RADIO);
		finestButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.FINEST);
			}
		});
		Button finerButton = managedForm.getToolkit().createButton(versobityComposite, "finer", SWT.RADIO);
		finerButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.FINER);
			}
		});
		finerButton.setSelection(true);
		Button fineButton = managedForm.getToolkit().createButton(versobityComposite, "fine", SWT.RADIO);
		fineButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.FINE);
			}
		});
		Button configButton = managedForm.getToolkit().createButton(versobityComposite, "config", SWT.RADIO);
		configButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.CONFIG);
			}
		});
		Button infoButton = managedForm.getToolkit().createButton(versobityComposite, "info", SWT.RADIO);
		infoButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.INFO);
			}
		});
		Button warningButton = managedForm.getToolkit().createButton(versobityComposite, "warning", SWT.RADIO);
		warningButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.WARNING);
			}
		});
		Button severeButton = managedForm.getToolkit().createButton(versobityComposite, "severe", SWT.RADIO);
		severeButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.SEVERE);
			}
		});
		Button offButton = managedForm.getToolkit().createButton(versobityComposite, "off", SWT.RADIO);
		offButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.setLevel(Level.OFF);
			}
		});
	}

	/**
	 * Creates the logs section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createLogsSection(IManagedForm managedForm) throws Exception
	{
		SectionPart logsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(logsSectionPart);
		logsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		logsSectionPart.getSection().setText("Logs");

		Composite logsComposite = new Composite(logsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(logsComposite);
		managedForm.getToolkit().paintBordersFor(logsComposite);
		logsSectionPart.getSection().setClient(logsComposite);
		logsComposite.setLayout(new GridLayout());

		logsText = new ScrolledFormText(logsComposite, true);
		managedForm.getToolkit().paintBordersFor(logsText);
		logsText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		logsText.setText(logs.toString());
		logsText.getFormText().setColor("fine", new Color(Display.getDefault(), 0, 0, 0));
		logsText.getFormText().setColor("info", new Color(Display.getDefault(), 0, 0, 255));
		logsText.getFormText().setColor("error", new Color(Display.getDefault(), 255, 0, 0));
		Font font = JFaceResources.getTextFont();
		font.getFontData()[0].setHeight(5);
		logsText.setFont(font);
	}
}
