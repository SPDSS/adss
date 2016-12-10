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
package it.polito.security.ontologies.tools;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.OntologyDataProperty;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.OntologyObjectProperty;
import it.polito.security.ontologies.ReasonerType;

/**
 * The ontology tools view.
 * @author Daniele Canavese
 **/
public class View extends ViewPart
{
	/**
	 * Creates the view.
	 **/
	public View()
	{
		display = Display.getCurrent();
	}

	/**
	 * Creates the part content.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	public void createPartControl(Composite parent)
	{
		parent.setLayout(new GridLayout(5, false));

		text = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		Group group = new Group(parent, SWT.NONE);
		group.setLayout(new GridLayout(2, false));

		deepAnalysisCheck = new Button(group, SWT.CHECK);
		deepAnalysisCheck.setText("Deep analysis");

		lintButton = new Button(group, SWT.NONE);
		lintButton.setText("Lint...");
		lintButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				display.syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(display.getActiveShell());
						dialog.setFilterExtensions(new String[] { "*.owl" });
						dialog.setFilterNames(new String[] { "OWL ontologies" });
						final String fileName = dialog.open();
						final boolean deepAnalysis = deepAnalysisCheck.getSelection();
						if (fileName != null)
						{
							Job job = new Job("Ontology linting")
							{
								@Override
								protected IStatus run(IProgressMonitor monitor)
								{
									try
									{
										final StringBuilder sb = new StringBuilder();
										sb.append("Lint for " + fileName + "\n\n");
										OntologyLint lint = new OntologyLint(new File(fileName));
										Collection<String> messages = lint.shallowAnalysis();
										if (deepAnalysis)
											messages.addAll(lint.deepAnalysis());
										for (String m : messages)
											sb.append(m + "\n");
										sb.append(messages.size() + " warnings detected.\n");
										display.asyncExec(new Runnable()
										{
											@Override
											public void run()
											{
												text.setText(sb.toString());
											}
										});
										return Status.OK_STATUS;
									}
									catch (Exception e)
									{
										e.printStackTrace();
										return Status.CANCEL_STATUS;
									}
								}
							};
							job.setUser(true);
							job.schedule();
						}
					}
				});
			}
		});

		testsButton = new Button(parent, SWT.NONE);
		testsButton.setText("Tests...");
		testsButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				FileDialog dialog = new FileDialog(display.getActiveShell());
				dialog.setFilterExtensions(new String[] { "*.owl" });
				dialog.setFilterNames(new String[] { "OWL ontologies" });
				final String fileName = dialog.open();
				if (fileName != null)
				{
					Job job = new Job("Ontology testing")
					{
						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							try
							{
								final StringBuilder html = new StringBuilder();
								Bundle bundle = Platform.getBundle("it.polito.security.ontologies.tools");
								URL cssURL = bundle.getEntry("html/style.css");
								html.append("<html><head><link rel=\"stylesheet\" href=\""
									+ FileLocator.resolve(cssURL).getPath() + "\"></head>");
								html.append("<body><h1>Tests report</h1>");
								OntologyPerformances performances = new OntologyPerformances(new File(fileName));
								html.append("<table cellspacing=\"10px\">");
								html.append("<tr>");
								html.append("<th>Reasoner</th>");
								html.append("<th>Consistency checking</th>");
								html.append("<th>Inferences computation</th>");
								html.append("<th>Query answering</th>");
								html.append("</tr>");
								for (ReasonerType r : ReasonerType.values())
									if (monitor.isCanceled() == false)
									{
										monitor.beginTask("Testing " + r.toString(), IProgressMonitor.UNKNOWN);
										html.append(performances.test(r));
									}
								html.append("</table>");
								html.append("</body></html>");
								display.asyncExec(new Runnable()
								{
									@Override
									public void run()
									{
										text.setText(html.toString());
									}
								});
								return Status.OK_STATUS;
							}
							catch (Exception e)
							{
								e.printStackTrace();
								return Status.CANCEL_STATUS;
							}
						}
					};
					job.setUser(true);
					job.schedule();
				}
			}
		});

		namespacesButton = new Button(parent, SWT.NONE);
		namespacesButton.setText("Namespaces...");
		namespacesButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				FileDialog dialog = new FileDialog(display.getActiveShell(), SWT.MULTI);
				dialog.setFilterExtensions(new String[] { "*.owl" });
				dialog.setFilterNames(new String[] { "OWL ontologies" });
				if (dialog.open() != null)
				{
					final String[] filenames = dialog.getFileNames();
					final String path = dialog.getFilterPath();
					Job job = new Job("Ontologies namespaces listing")
					{
						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							try
							{
								final StringBuilder sb = new StringBuilder();
								display.asyncExec(new Runnable()
								{
									@Override
									public void run()
									{
										for (String i : filenames)
											try
											{
												Ontology ontology =
													new Ontology(new File(path, i), ReasonerType.PELLET);
												Set<String> set = new HashSet<>();
												sb.append("Namespaces for " + i + ":\n");
												for (OntologyClass j : ontology.getThing().getSubClasses(false))
													set.add(j.getNamespace());
												for (OntologyIndividual j : ontology.getThing().getIndividuals(false))
													set.add(j.getNamespace());
												for (OntologyObjectProperty j : ontology.getTopObjectProperty()
													.getSubProperties(false))
													set.add(j.getNamespace());
												for (OntologyDataProperty j : ontology.getTopDataProperty()
													.getSubProperties(false))
													set.add(j.getNamespace());
												for (String j : set)
													sb.append(" » " + j + "\n");
												sb.append("\n");
											}
											catch (Exception e)
											{
												e.printStackTrace();
											}
										text.setText(sb.toString());
									}
								});
								return Status.OK_STATUS;
							}
							catch (Exception e)
							{
								e.printStackTrace();
								return Status.CANCEL_STATUS;
							}
						}
					};
					job.setUser(true);
					job.schedule();
				}
			}
		});

		intersectionButton = new Button(parent, SWT.NONE);
		intersectionButton.setText("Intersections...");
		intersectionButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				FileDialog dialog = new FileDialog(display.getActiveShell(), SWT.MULTI);
				dialog.setFilterExtensions(new String[] { "*.owl" });
				dialog.setFilterNames(new String[] { "OWL ontologies" });
				if (dialog.open() != null)
				{
					final String[] filenames = dialog.getFileNames();
					final String path = dialog.getFilterPath();
					Job job = new Job("Ontologies intersections computations")
					{
						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							try
							{
								final StringBuilder sb = new StringBuilder();
								display.asyncExec(new Runnable()
								{
									@Override
									public void run()
									{
										try
										{
											for (int i = 0; i < filenames.length - 1; ++i)
											{
												Ontology ontology1 =
													new Ontology(new File(path, filenames[i]), ReasonerType.PELLET);
												Set<Object> s1 = new HashSet<>();
												for (OntologyClass j : ontology1.getThing().getSubClasses(false))
													s1.add(j);
												for (OntologyIndividual j : ontology1.getThing().getIndividuals(false))
													s1.add(j);
												for (OntologyObjectProperty j : ontology1.getTopObjectProperty()
													.getSubProperties(false))
													s1.add(j);
												for (OntologyDataProperty j : ontology1.getTopDataProperty()
													.getSubProperties(false))
													s1.add(j);
												s1.remove(ontology1.getThing());
												s1.remove(ontology1.getNothing());
												s1.remove(ontology1.getTopObjectProperty());
												s1.remove(ontology1.getTopDataProperty());
												s1.remove(ontology1.getBottomObjectProperty());
												s1.remove(ontology1.getBottomDataProperty());

												for (int j = i + 1; j < filenames.length; ++j)
												{
													Ontology ontology2 =
														new Ontology(new File(path, filenames[j]), ReasonerType.PELLET);

													Set<Object> s2 = new HashSet<>();
													for (OntologyClass k : ontology2.getThing().getSubClasses(false))
														s2.add(k);
													for (OntologyIndividual k : ontology2.getThing().getIndividuals(
														false))
														s2.add(k);
													for (OntologyObjectProperty k : ontology2.getTopObjectProperty()
														.getSubProperties(false))
														s2.add(k);
													for (OntologyDataProperty k : ontology2.getTopDataProperty()
														.getSubProperties(false))
														s2.add(k);

													s2.retainAll(s1);

													sb.append("Intersection between " + filenames[i] + " and "
														+ filenames[j] + ":\n");
													for (Object k : s2)
														sb.append(" » " + k + "\n");
													sb.append("\n");
												}
											}
										}
										catch (Exception e)
										{
											e.printStackTrace();
										}
										text.setText(sb.toString());
									}
								});
								return Status.OK_STATUS;
							}
							catch (Exception e)
							{
								e.printStackTrace();
								return Status.CANCEL_STATUS;
							}
						}
					};
					job.setUser(true);
					job.schedule();
				}
			}
		});

		statsButton = new Button(parent, SWT.NONE);
		statsButton.setText("Stats...");
		statsButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				display.syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(display.getActiveShell());
						dialog.setFilterExtensions(new String[] { "*.owl" });
						dialog.setFilterNames(new String[] { "OWL ontologies" });
						final String fileName = dialog.open();
						if (fileName != null)
						{
							Job job = new Job("Ontology stats")
							{
								@Override
								protected IStatus run(IProgressMonitor monitor)
								{
									try
									{
										final StringBuilder sb = new StringBuilder();
										Ontology ontology = new Ontology(new File(fileName), ReasonerType.PELLET);
										sb.append("Stats for " + fileName + "\n\n");
										sb.append("Consistent: " + ontology.isConsistent() + "\n");
										sb.append("Number of classes: "
											+ ontology.getThing().getSubClasses(false).size() + "\n");
										sb.append("Number of object properties: "
											+ ontology.getTopObjectProperty().getSubProperties(false).size() + "\n");
										sb.append("Number of data properties: "
											+ ontology.getTopDataProperty().getSubProperties(false).size() + "\n");
										sb.append("Number of individuals: "
											+ ontology.getThing().getIndividuals(false).size() + "\n");
										sb.append("EL: " + ontology.isEL() + "\n");
										sb.append("Expressivity: " + ontology.getExpressivity() + "\n");
										display.asyncExec(new Runnable()
										{
											@Override
											public void run()
											{
												text.setText(sb.toString());
											}
										});
										return Status.OK_STATUS;
									}
									catch (Exception e)
									{
										e.printStackTrace();
										return Status.CANCEL_STATUS;
									}
								}
							};
							job.setUser(true);
							job.schedule();
						}
					}
				});
			}
		});
	}

	/**
	 * Sets the focus.
	 **/
	@Override
	public void setFocus()
	{
		text.setFocus();
	}

	/** The deep analysis check. **/
	private Button deepAnalysisCheck;
	/** The current display. **/
	private Display display;
	/** The intersection button. **/
	private Button intersectionButton;
	/** The lint button. **/
	private Button lintButton;
	/** The namespaces button. **/
	private Button namespacesButton;
	/** The stats button. **/
	private Button statsButton;
	/** The tests button. **/
	private Button testsButton;
	/** The report text. **/
	private Text text;
}
