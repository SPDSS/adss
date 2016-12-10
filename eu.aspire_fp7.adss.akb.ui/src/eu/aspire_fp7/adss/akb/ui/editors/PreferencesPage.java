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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Preferences;
import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.connectors.Runner;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The preferences page.
 * @author Daniele Canavese
 **/
public class PreferencesPage extends FormPage
{
	/** The ADSS. **/
	private ADSS adss;
	/** Specifies if this is a preference page for the ADSS full or not. **/
	private boolean full;

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param adss
	 *            The ADSS.
	 * @param eventGenerator
	 *            The event generator.
	 * @param full
	 *            Indicates if this page is for the ADSS full or not.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public PreferencesPage(FormEditor editor, ADSS adss, boolean full) throws Exception
	{
		super(editor, "preferences", "Preferences");
		this.adss = adss;
		this.full = full;
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
			form.setText("Preferences");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/preferences.png"));
			form.getBody().setLayout(new GridLayout(2, false));

			createRemoteConnectionSection(managedForm);
			createCommandsSection(managedForm);
			createMetricsSection(managedForm);
			createParsingSection(managedForm);
			createAttackFinderSection(managedForm);
			createProtectionFinderSection(managedForm);
			if (full)
			{
				createOverheadsSection(managedForm);
				createFirstLevelProtectionsSection(managedForm);
				createSecondLevelProtectionsSection(managedForm);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the remote connection section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createRemoteConnectionSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Remote connection");

		createCheckField(composite, "Remote connection",
				"Enables the remote connection if the whole ASPIRE tool-chain is available on another machine.",
				AkbPackage.PREFERENCES__REMOTE_CONNECTION);
		createTextField(composite, "Remote host:", "Specifies the host IP address", AkbPackage.PREFERENCES__REMOTE_HOST);
		createIntegerField(composite, 1, 65535, "Remote port:", "Specifies the host port number.", AkbPackage.PREFERENCES__REMOTE_PORT);
		createTextField(composite, "Remote username:", "Specifies the username used for the remote connection.",
				AkbPackage.PREFERENCES__REMOTE_USERNAME);
		createTextField(composite, "Remote password:", "Specifies the password used for the remote connection.",
				AkbPackage.PREFERENCES__REMOTE_PASSWORD);
		createTextField(composite, "Remote server file separator:",
				"Specifies the file separator of the remote server.\nUsually \\ for Windows and / for UNIX.",
				AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR);

		final Button testButton = managedForm.getToolkit().createButton(composite, "Connection test...", SWT.NONE);
		testButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		testButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Job job = new Job("Connection test")
				{

					@Override
					protected IStatus run(IProgressMonitor monitor)
					{
						try
						{
							Runner r = new Runner(adss);
							final boolean ok = r.test();
							Display.getDefault().syncExec(new Runnable()
							{
								@Override
								public void run()
								{
									MessageBox box = new MessageBox(Display.getDefault().getActiveShell(),
											ok ? SWT.ICON_WORKING : SWT.ICON_ERROR);
									box.setText("ADSS");
									if (ok)
										box.setMessage("Congratulations! Your remote connection seems working.");
									else
										box.setMessage("Oops! Something is not working.");
									box.open();
								}
							});
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}

						return Status.OK_STATUS;
					}
				};
				job.schedule();
			}
		});
	}

	/**
	 * Creates the commands section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createCommandsSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Commands");

		createTextField(composite, "ACTC command:", "Specifies the ACTC command.", AkbPackage.PREFERENCES__COMMAND_ACTC);
		createTextField(composite, "Perl interpreter:", "Specifies the Perl interpreter.", AkbPackage.PREFERENCES__COMMAND_PERL);
		createTextField(composite, "Local dot utility:", "Specifies the Dot utility.", AkbPackage.PREFERENCES__COMMAND_DOT);
	}

	/**
	 * Creates the metrics section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createMetricsSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Metrics");

		createCheckTextField(composite, "Coefficients file:", "Specifies the file containing the metrics estimantion coefficents.",
				AkbPackage.PREFERENCES__METRICS_FILE);
	}

	/**
	 * Creates the protection finder section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createProtectionFinderSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Protection Finder");

		Map<String, Level> levelMap = new LinkedHashMap<>();
		levelMap.put("Low", Level.LOW);
		levelMap.put("Medium", Level.MEDIUM);
		levelMap.put("High", Level.HIGH);
		createComboField(composite, levelMap, "Minimum allowed protection mitigation level:",
				"Unsound. Higher values increase the performance and decrease the accuracy.\n"
						+ "The ADSS will use only the protections that have a high enough attack mitigation level.",
				AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION);
	}

	/**
	 * Creates the attack finder section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAttackFinderSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Attack Finder");

		createCheckIntegerField(composite, 1, Integer.MAX_VALUE, "Time limit [seconds]:",
				"Unsound.\n" + "Specifies a time limit in seconds.\n"
						+ "Note that this is not a hard limit since the timeout is checked only once in a while during the computation.",
				AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT);
		createIntegerField(composite, 0, Integer.MAX_VALUE, "Maximum search depth:",
				"Unsound.\n" + "Specifies the maximum search depth for the calll graph.", AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH);
		createCheckField(composite, "Remove the included protection objectives",
				"Sound. Can increase the performance.\n"
						+ "Removes the protection objectives completely included in other protection objectives.",
				AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL);
	}

	/**
	 * Creates the parsing section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createParsingSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Parsing");

		createCheckField(composite, "Parse headers",
				"Indicates if the ADSS should also take into account the headers when analyzing the code.",
				AkbPackage.PREFERENCES__PARSER_HEADER_PARSING);
		createCheckField(composite, "Ignore system files",
				"Indicates if the ADSS should ignore the system files (e.g. stdio.h) when analyzing the code.",
				AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION);
	}

	/**
	 * Creates the overheads section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createOverheadsSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Overheads");

		createDoubleField(composite, 0.1, Double.MAX_VALUE, "Client time overhead [percentage]:",
				"Specifies the maximum allowed client time overhead in percentage w.r.t. the vanilla application.",
				AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD);
		createDoubleField(composite, 0.1, Double.MAX_VALUE, "Server time overhead [percentage]:",
				"Specifies the maximum allowed server time overhead in percentage w.r.t. the vanilla application.",
				AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD);
		createIntegerField(composite, 1, Integer.MAX_VALUE, "Client memory overhead [bytes]:",
				"Specifies the maximum allowed client memory overhead in bytes w.r.t. the vanilla application.",
				AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD);
		createIntegerField(composite, 1, Integer.MAX_VALUE, "Server memory overhead [bytes]:",
				"Specifies the maximum allowed server memory overhead in bytes w.r.t. the vanilla application.",
				AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD);
		createIntegerField(composite, 1, Integer.MAX_VALUE, "Network overhead [bytes per second]:",
				"Specifies the maximum allowed network overhead in bytes per second w.r.t. the vanilla application.",
				AkbPackage.PREFERENCES__NETWORK_OVERHEAD);
	}

	/**
	 * Creates the first level protections section.
	 * @param managedForm
	 *            The managed form.
	 **/
	private void createFirstLevelProtectionsSection(final IManagedForm managedForm)
	{
		Composite composite = createComposite(managedForm, "First Level Protections");

		createIntegerField(composite, 1, Integer.MAX_VALUE, "Number of solutions to find:",
				"Sound.\n" + "Specifies the number of solutions to find.\n"
						+ "Note that, according to the pruning techniques, the number of extracted solutions may be less than this value.",
				AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT);
		createCheckField(composite, "Perform an additional Petri net assessment on the solutions",
				"Sound.\n"
						+ "Specifies if performing or not an addition pass with Petri net based models to compute an additional security score.",
				AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS);

		Composite terminationGroup = createGroup(managedForm, composite, "Termination");
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Time limit [seconds]:",
				"Unsound.\n" + "Specifies a time limit in seconds.\n"
						+ "Note that this is not a hard limit since the timeout is checked only once in a while during the computation.",
				AkbPackage.PREFERENCES__L1P_TIME_LIMIT);
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Solutions limit:",
				"Unsound.\n" + "Specifies the maximum number of solutions to explore.\n"
						+ "Note that, according to the pruning techniques, the number of explorable solutions may be less than this value.",
				AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT);
		createCheckDoubleField(terminationGroup, 0.1, 100, "Gap limit [percentage]:",
				"Unsound.\n" + "Specifies the maximum gap limit.\n"
						+ "The gap is the relative distance between the scores of the current solution score and the best one.",
				AkbPackage.PREFERENCES__L1P_GAP_LIMIT);

		Composite constraintsGroup = createGroup(managedForm, composite, "Constraints");
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum client time overhead [percentage]:",
				"Specifies the maximum allowed percentage of the client time overhead.",
				AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum server time overhead [percentage]:",
				"Specifies the maximum allowed percentage of the server time overhead.",
				AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum client memory overhead [percentage]:",
				"Specifies the maximum allowed percentage of the client memory overhead.",
				AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum server memory overhead [percentage]:",
				"Specifies the maximum allowed percentage of the server memory overhead.",
				AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum network overhead [percentage]:",
				"Specifies the maximum allowed percentage of the server memory overhead.",
				AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE);
		createCheckField(constraintsGroup, "Ignore the solutions with some discouraged protection precedences",
				"Unsound. Can increase the performance.\n"
						+ "The ADSS will skip the solutions with at least one discouraged protection precedence.",
				AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION);
		createCheckField(constraintsGroup, "Focus on the solutions with only encouraged protection precedences",
				"Unsound. Can increase the performance.\n"
						+ "The ADSS will take into account only the solutions containing only encouraged protection precedences.",
				AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING);
		createCheckField(constraintsGroup, "Use the protection precedences of the ACTC",
				"Unsound. Can increase the performance.\n"
						+ "The ADSS will ignore all the solutions containing protection permutations undeployable by the ACTC.",
				AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES);
		createCheckField(constraintsGroup, "Ignore the application part order",
				"Unsound. Can increase the performance.\n"
						+ "The ADSS will ignore all the solutions containing application part permutations undeployable by the ACTC.",
				AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER);
		createIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Maximum number of protection instantiations per protection objective:",
				"Unsound. Lower values increase the performance and decrease the accuracy.\n"
						+ "The ADSS will use a maximum number of protection instantiations per protection objective.",
				AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE);
		createIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Main search maximum depth:",
				"Unsound. Lower values increase the performance and decrease the accuracy.\n"
						+ "The minimax main search tree will be explored until this depth is reached. It is a hard limit.",
				AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH);

		Composite algorithmGroup = createGroup(managedForm, composite, "Algorithm");
		createCheckField(algorithmGroup, "Use a separate tree for each code correlation set",
				"Unsound. Can significantly increase the performance at the cost of some accuracy.\n"
						+ "The ADSS will independently perform a search on each code correlation set instead of a global one.",
				AkbPackage.PREFERENCES__L1P_MULTI_TREE);
		createCheckIntegerField(algorithmGroup, 1, Integer.MAX_VALUE, "Transposition table size",
				"Mostly sound. Higher values can increase the performance and the accuracy.\n"
						+ "The transposition table maximum size. Disable it to turn off the use of transposition tables.",
				AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE);
		createCheckNaNDoubleField(algorithmGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Initial alpha value",
				"Sound.\n" + "The initial value for the alpha (lower) bound. Disable for negative infinity.",
				AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA);
		createCheckNaNDoubleField(algorithmGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Initial beta value",
				"Sound.\n" + "The initial value for the beta (upper) bound. Disable for positive infinity.",
				AkbPackage.PREFERENCES__L1P_INITIAL_BETA);
		createDoubleField(algorithmGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Research delta value",
				"Sound.\n" + "The value used to increase/decrease an alpha/beta bound if a search fails.",
				AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA);
	}

	/**
	 * Creates the second level protections section.
	 * @param managedForm
	 *            The managed form.
	 **/
	private void createSecondLevelProtectionsSection(final IManagedForm managedForm)
	{
		Composite composite = createComposite(managedForm, "Second Level Protections");

		createIntegerField(composite, 1, Integer.MAX_VALUE, "Number of solutions to find:",
				"Sound.\n" + "Specifies the number of solutions to find for each level 1 solution.\n"
						+ "Note that, according to the pruning techniques, the number of extracted solutions may be less than this value.",
				AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT);
		createCheckIntegerField(composite, 1, Integer.MAX_VALUE, "Seed:",
				"Specifies a seed for the function splitting. Disable to use a random value.",
				AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED);

		Composite terminationGroup = createGroup(managedForm, composite, "Termination");
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Time limit [seconds]:",
				"Unsound.\n" + "Specifies a time limit in seconds.\n"
						+ "Note that this is not a hard limit since the timeout is checked only once in a while during the computation.",
				AkbPackage.PREFERENCES__L2P_TIME_LIMIT);
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Solutions limit:",
				"Unsound.\n" + "Specifies the maximum number of solutions to explore.\n"
						+ "Note that, according to the pruning techniques, the number of explorable solutions may be less than this value.",
				AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT);
		createCheckDoubleField(terminationGroup, 0.1, 100, "Gap limit [percentage]:",
				"Unsound.\n" + "Specifies the maximum gap limit.\n"
						+ "The gap is the relative distance between the scores of the current solution score and the best one.",
				AkbPackage.PREFERENCES__L2P_GAP_LIMIT);

		Composite constraintsGroup = createGroup(managedForm, composite, "Constraints");
		createIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Maximum number of protection instantiations per application part:",

				"The ADSS will use a maximum number of protection instantiations per application part.",
				AkbPackage.PREFERENCES__L2P_UPPER_BOUND);
		createCheckIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Minimum code block length for splitting:",
				"The minimum length that a code block must have in order to be splitted. Disable to generate an application part for each block.",
				AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH);
		createCheckIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Splitting randomization denominator:",
				"Specifies the length of the new code regions, which will be a random value in minimumCodeBlockLength ± minimumCodeBlockLength/codeBlockLengthRandomizationDenominator. Disable to generate all the blocks with minimumCodeBlockLength lines.",
				AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR);
		createCheckIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Splitting depth level:",
				"Specifies the function splitting depth level. Disable for no limit.",
				AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL);
	}

	/**
	 * Creates a composite for hosting the fields.
	 * @param managedForm
	 *            The managed form.
	 * @param title
	 *            The section title.
	 * @return
	 */
	private Composite createComposite(IManagedForm managedForm, String title)
	{
		SectionPart part = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(), ExpandableComposite.TITLE_BAR);
		managedForm.addPart(part);
		part.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		part.getSection().setText(title);

		Composite composite = new Composite(part.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		part.getSection().setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		return composite;
	}

	/**
	 * Creates a group for hosting the fields.
	 * @param managedForm
	 *            The managed form.
	 * @param parent
	 *            The parent composite.
	 * @param title
	 *            The section title.
	 * @return
	 */
	private Composite createGroup(IManagedForm managedForm, Composite parent, String title)
	{
		SectionPart part = new SectionPart(parent, managedForm.getToolkit(), ExpandableComposite.SHORT_TITLE_BAR);
		managedForm.addPart(part);
		part.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		part.getSection().setText(title);

		Composite composite = new Composite(part.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		part.getSection().setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		return composite;
	}

	/**
	 * Creates a check field.
	 * @param composite
	 *            The parent composite.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckField(Composite composite, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		boolean value = (boolean) preferences.eGet(feature);
		button.setSelection(value);

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				preferences.eSet(feature, button.getSelection());
			}
		});
	}

	/**
	 * Creates a text field.
	 * @param composite
	 *            The parent composite.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createTextField(Composite composite, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Text text = new Text(composite, SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		String value = (String) preferences.eGet(feature);
		text.setText(value);

		text.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, text.getText());
			}
		});
	}

	/**
	 * Creates a text field that can be enabled or disabled. If the control is disabled, the internal value is set to the empty string.
	 * @param composite
	 *            The parent composite.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckTextField(Composite composite, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Text text = new Text(composite, SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		String value = (String) preferences.eGet(feature);
		button.setSelection(!value.isEmpty());
		text.setEnabled(button.getSelection());
		text.setText(value);

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				text.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, text.getText());
				else
					preferences.eSet(feature, "");
			}
		});
		text.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, text.getText());
			}
		});
	}

	/**
	 * Creates an integer field.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createIntegerField(Composite composite, int min, int max, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Integer value = (Integer) preferences.eGet(feature);
		spinner.setSelection(value);

		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, spinner.getSelection());
			}
		});
	}

	/**
	 * Creates an integer field that can be enabled or disabled. If the control is disabled, the internal value is set to a non-positive
	 * value.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckIntegerField(Composite composite, int min, int max, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Integer value = (Integer) preferences.eGet(feature);
		button.setSelection(value > 0);
		spinner.setEnabled(button.getSelection());
		spinner.setSelection(Math.abs(value));

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				spinner.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, spinner.getSelection());
				else
					preferences.eSet(feature, -spinner.getSelection());
			}
		});
		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, spinner.getSelection());
			}
		});
	}

	/**
	 * Creates a combo field.
	 * @param <T>
	 *            The enum to use.
	 * @param composite
	 *            The parent composite.
	 * @param names
	 *            The combo-box names.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param values
	 *            The value enum.
	 * @param featureId
	 *            The related feature ID.
	 */
	private <T> void createComboField(Composite composite, final Map<String, T> values, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Combo combo = new Combo(composite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combo.setItems(values.keySet().toArray(new String[] {}));
		combo.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		@SuppressWarnings("unchecked")
		T value = (T) preferences.eGet(feature);
		for (Entry<String, T> i : values.entrySet())
			if (i.getValue() == value)
				combo.setText(i.getKey());

		combo.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, values.get(combo.getText()));
			}
		});
	}

	/**
	 * Creates a double field that can be enabled or disabled. If the control is disabled, the internal value is set to a non-positive.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000));
		spinner.setMaximum((int) (max * 1000));
		spinner.setDigits(3);
		spinner.setIncrement(100);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		button.setSelection(value > 0);
		spinner.setEnabled(button.getSelection());
		spinner.setSelection(Math.abs((int) (value * 1000)));

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				spinner.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, ((double) spinner.getSelection()) / 1000);
				else
					preferences.eSet(feature, -((double) spinner.getSelection()) / 1000);
			}
		});
		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000);
			}
		});
	}

	/**
	 * Creates a double field that can be enabled or disabled. If the control is disabled, the internal value is set to NaN.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckNaNDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000));
		spinner.setMaximum((int) (max * 1000));
		spinner.setDigits(3);
		spinner.setIncrement(100);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		button.setSelection(!Double.isNaN(value));
		spinner.setEnabled(button.getSelection());
		if (button.getSelection())
			spinner.setSelection((int) (value * 1000));
		else
			spinner.setSelection(0);

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				spinner.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, ((double) spinner.getSelection()) / 1000.0);
				else
					preferences.eSet(feature, Double.NaN);
			}
		});
		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000.0);
			}
		});
	}

	/**
	 * Creates a double field.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.CHECK);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000));
		spinner.setMaximum((int) (max * 1000));
		spinner.setDigits(3);
		spinner.setIncrement(100);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = adss.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		spinner.setSelection((int) (value * 1000));

		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000);
			}
		});
	}
}
