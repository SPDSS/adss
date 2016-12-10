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
/**
 */
package eu.aspire_fp7.adss.akb.impl;

import com.google.common.base.Objects;

import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Preferences;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getWorkingDirectory <em>Working Directory</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getActcConfigurationFile <em>Actc Configuration File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getAdssPatchFile <em>Adss Patch File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getAdssJSONFile <em>Adss JSON File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isRemoteConnection <em>Remote Connection</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getRemoteUsername <em>Remote Username</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getRemotePassword <em>Remote Password</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getRemoteHost <em>Remote Host</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getRemotePort <em>Remote Port</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getRemoteFileSeparator <em>Remote File Separator</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getCommandACTC <em>Command ACTC</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getCommandPerl <em>Command Perl</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getCommandDot <em>Command Dot</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getMetricsFile <em>Metrics File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isParserHeaderParsing <em>Parser Header Parsing</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getAttacksTimeLimit <em>Attacks Time Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getNetworkOverhead <em>Network Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pSolutionsCount <em>L1p Solutions Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isL1pPetriNetsPass <em>L1p Petri Nets Pass</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pTimeLimit <em>L1p Time Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pGapLimit <em>L1p Gap Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#isL1pMultiTree <em>L1p Multi Tree</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pInitialAlpha <em>L1p Initial Alpha</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pInitialBeta <em>L1p Initial Beta</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pResearchDelta <em>L1p Research Delta</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pSolutionsCount <em>L2p Solutions Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pSolutionLimit <em>L2p Solution Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pTimeLimit <em>L2p Time Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pGapLimit <em>L2p Gap Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pUpperBound <em>L2p Upper Bound</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getSetPNDirectory <em>Set PN Directory</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl#getSetPNFile <em>Set PN File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreferencesImpl extends MinimalEObjectImpl.Container implements Preferences
{
	/**
	 * The default value of the '{@link #getWorkingDirectory() <em>Working Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKING_DIRECTORY_EDEFAULT = "/home/aspire/test";

	/**
	 * The cached value of the '{@link #getWorkingDirectory() <em>Working Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingDirectory()
	 * @generated
	 * @ordered
	 */
	protected String workingDirectory = WORKING_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getActcConfigurationFile() <em>Actc Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActcConfigurationFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTC_CONFIGURATION_FILE_EDEFAULT = "test.json";

	/**
	 * The cached value of the '{@link #getActcConfigurationFile() <em>Actc Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActcConfigurationFile()
	 * @generated
	 * @ordered
	 */
	protected String actcConfigurationFile = ACTC_CONFIGURATION_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdssPatchFile() <em>Adss Patch File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdssPatchFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ADSS_PATCH_FILE_EDEFAULT = "adss.patch";

	/**
	 * The cached value of the '{@link #getAdssPatchFile() <em>Adss Patch File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdssPatchFile()
	 * @generated
	 * @ordered
	 */
	protected String adssPatchFile = ADSS_PATCH_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdssJSONFile() <em>Adss JSON File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdssJSONFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ADSS_JSON_FILE_EDEFAULT = "adss.json";

	/**
	 * The cached value of the '{@link #getAdssJSONFile() <em>Adss JSON File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdssJSONFile()
	 * @generated
	 * @ordered
	 */
	protected String adssJSONFile = ADSS_JSON_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String ARCHITECTURE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected String architecture = ARCHITECTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoteConnection() <em>Remote Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoteConnection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOTE_CONNECTION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRemoteConnection() <em>Remote Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoteConnection()
	 * @generated
	 * @ordered
	 */
	protected boolean remoteConnection = REMOTE_CONNECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteUsername() <em>Remote Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_USERNAME_EDEFAULT = "aspire";

	/**
	 * The cached value of the '{@link #getRemoteUsername() <em>Remote Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteUsername()
	 * @generated
	 * @ordered
	 */
	protected String remoteUsername = REMOTE_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemotePassword() <em>Remote Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePassword()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_PASSWORD_EDEFAULT = "aspire";

	/**
	 * The cached value of the '{@link #getRemotePassword() <em>Remote Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePassword()
	 * @generated
	 * @ordered
	 */
	protected String remotePassword = REMOTE_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteHost() <em>Remote Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteHost()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_HOST_EDEFAULT = "127.0.1.1";

	/**
	 * The cached value of the '{@link #getRemoteHost() <em>Remote Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteHost()
	 * @generated
	 * @ordered
	 */
	protected String remoteHost = REMOTE_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemotePort() <em>Remote Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePort()
	 * @generated
	 * @ordered
	 */
	protected static final int REMOTE_PORT_EDEFAULT = 3022;

	/**
	 * The cached value of the '{@link #getRemotePort() <em>Remote Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemotePort()
	 * @generated
	 * @ordered
	 */
	protected int remotePort = REMOTE_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteFileSeparator() <em>Remote File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteFileSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_FILE_SEPARATOR_EDEFAULT = "/";

	/**
	 * The cached value of the '{@link #getRemoteFileSeparator() <em>Remote File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteFileSeparator()
	 * @generated
	 * @ordered
	 */
	protected String remoteFileSeparator = REMOTE_FILE_SEPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandACTC() <em>Command ACTC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandACTC()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_ACTC_EDEFAULT = "/opt/ACTC/actc.py";

	/**
	 * The cached value of the '{@link #getCommandACTC() <em>Command ACTC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandACTC()
	 * @generated
	 * @ordered
	 */
	protected String commandACTC = COMMAND_ACTC_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandPerl() <em>Command Perl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandPerl()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_PERL_EDEFAULT = "/usr/bin/perl";

	/**
	 * The cached value of the '{@link #getCommandPerl() <em>Command Perl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandPerl()
	 * @generated
	 * @ordered
	 */
	protected String commandPerl = COMMAND_PERL_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandDot() <em>Command Dot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandDot()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_DOT_EDEFAULT = "/usr/bin/dot";

	/**
	 * The cached value of the '{@link #getCommandDot() <em>Command Dot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandDot()
	 * @generated
	 * @ordered
	 */
	protected String commandDot = COMMAND_DOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetricsFile() <em>Metrics File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsFile()
	 * @generated
	 * @ordered
	 */
	protected static final String METRICS_FILE_EDEFAULT = "gammas.db";

	/**
	 * The cached value of the '{@link #getMetricsFile() <em>Metrics File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricsFile()
	 * @generated
	 * @ordered
	 */
	protected String metricsFile = METRICS_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isParserHeaderParsing() <em>Parser Header Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserHeaderParsing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARSER_HEADER_PARSING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isParserHeaderParsing() <em>Parser Header Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserHeaderParsing()
	 * @generated
	 * @ordered
	 */
	protected boolean parserHeaderParsing = PARSER_HEADER_PARSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isParserSystemFilesIgnoration() <em>Parser System Files Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserSystemFilesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isParserSystemFilesIgnoration() <em>Parser System Files Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isParserSystemFilesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected boolean parserSystemFilesIgnoration = PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttacksTimeLimit() <em>Attacks Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACKS_TIME_LIMIT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getAttacksTimeLimit() <em>Attacks Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected int attacksTimeLimit = ATTACKS_TIME_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttacksMaximumDepth() <em>Attacks Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACKS_MAXIMUM_DEPTH_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getAttacksMaximumDepth() <em>Attacks Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacksMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected int attacksMaximumDepth = ATTACKS_MAXIMUM_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isAttacksIncludedProtectionObjectivesRemoval() <em>Attacks Included Protection Objectives Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttacksIncludedProtectionObjectivesRemoval()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAttacksIncludedProtectionObjectivesRemoval() <em>Attacks Included Protection Objectives Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttacksIncludedProtectionObjectivesRemoval()
	 * @generated
	 * @ordered
	 */
	protected boolean attacksIncludedProtectionObjectivesRemoval = ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtectionsMinimumAttackMitigation() <em>Protections Minimum Attack Mitigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionsMinimumAttackMitigation()
	 * @generated
	 * @ordered
	 */
	protected static final Level PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT = Level.MEDIUM;

	/**
	 * The cached value of the '{@link #getProtectionsMinimumAttackMitigation() <em>Protections Minimum Attack Mitigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionsMinimumAttackMitigation()
	 * @generated
	 * @ordered
	 */
	protected Level protectionsMinimumAttackMitigation = PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double CLIENT_TIME_OVERHEAD_EDEFAULT = 10.0;

	/**
	 * The cached value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected double clientTimeOverhead = CLIENT_TIME_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerTimeOverhead() <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double SERVER_TIME_OVERHEAD_EDEFAULT = 10.0;

	/**
	 * The cached value of the '{@link #getServerTimeOverhead() <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected double serverTimeOverhead = SERVER_TIME_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final int CLIENT_MEMORY_OVERHEAD_EDEFAULT = 1024;

	/**
	 * The cached value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected int clientMemoryOverhead = CLIENT_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVER_MEMORY_OVERHEAD_EDEFAULT = 1024;

	/**
	 * The cached value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected int serverMemoryOverhead = SERVER_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final int NETWORK_OVERHEAD_EDEFAULT = 1024;

	/**
	 * The cached value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected int networkOverhead = NETWORK_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pSolutionsCount() <em>L1p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_SOLUTIONS_COUNT_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getL1pSolutionsCount() <em>L1p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected int l1pSolutionsCount = L1P_SOLUTIONS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pPetriNetsPass() <em>L1p Petri Nets Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pPetriNetsPass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_PETRI_NETS_PASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isL1pPetriNetsPass() <em>L1p Petri Nets Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pPetriNetsPass()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pPetriNetsPass = L1P_PETRI_NETS_PASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pTimeLimit() <em>L1p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_TIME_LIMIT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getL1pTimeLimit() <em>L1p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected int l1pTimeLimit = L1P_TIME_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pSolutionsLimit() <em>L1p Solutions Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_SOLUTIONS_LIMIT_EDEFAULT = -10000;

	/**
	 * The cached value of the '{@link #getL1pSolutionsLimit() <em>L1p Solutions Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pSolutionsLimit()
	 * @generated
	 * @ordered
	 */
	protected int l1pSolutionsLimit = L1P_SOLUTIONS_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pGapLimit() <em>L1p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_GAP_LIMIT_EDEFAULT = -10.0;

	/**
	 * The cached value of the '{@link #getL1pGapLimit() <em>L1p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected double l1pGapLimit = L1P_GAP_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pClientTimeOverheadPercentage() <em>L1p Client Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT = 50.0;

	/**
	 * The cached value of the '{@link #getL1pClientTimeOverheadPercentage() <em>L1p Client Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pClientTimeOverheadPercentage = L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pServerTimeOverheadPercentage() <em>L1p Server Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT = 50.0;

	/**
	 * The cached value of the '{@link #getL1pServerTimeOverheadPercentage() <em>L1p Server Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerTimeOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pServerTimeOverheadPercentage = L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pClientMemoryOverheadPercentage() <em>L1p Client Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT = 50.0;

	/**
	 * The cached value of the '{@link #getL1pClientMemoryOverheadPercentage() <em>L1p Client Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pClientMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pClientMemoryOverheadPercentage = L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pServerMemoryOverheadPercentage() <em>L1p Server Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT = 50.0;

	/**
	 * The cached value of the '{@link #getL1pServerMemoryOverheadPercentage() <em>L1p Server Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pServerMemoryOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pServerMemoryOverheadPercentage = L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pNetworkOverheadPercentage() <em>L1p Network Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pNetworkOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT = 50.0;

	/**
	 * The cached value of the '{@link #getL1pNetworkOverheadPercentage() <em>L1p Network Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pNetworkOverheadPercentage()
	 * @generated
	 * @ordered
	 */
	protected double l1pNetworkOverheadPercentage = L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pDiscouragedPrecedencesIgnoration() <em>L1p Discouraged Precedences Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pDiscouragedPrecedencesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pDiscouragedPrecedencesIgnoration() <em>L1p Discouraged Precedences Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pDiscouragedPrecedencesIgnoration()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pDiscouragedPrecedencesIgnoration = L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pEncouragedPrecedencesFocusing() <em>L1p Encouraged Precedences Focusing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pEncouragedPrecedencesFocusing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pEncouragedPrecedencesFocusing() <em>L1p Encouraged Precedences Focusing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pEncouragedPrecedencesFocusing()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pEncouragedPrecedencesFocusing = L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pUseACTCPrecedences() <em>L1p Use ACTC Precedences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pUseACTCPrecedences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_USE_ACTC_PRECEDENCES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pUseACTCPrecedences() <em>L1p Use ACTC Precedences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pUseACTCPrecedences()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pUseACTCPrecedences = L1P_USE_ACTC_PRECEDENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pIgnoreApplicationPartOrder() <em>L1p Ignore Application Part Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pIgnoreApplicationPartOrder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pIgnoreApplicationPartOrder() <em>L1p Ignore Application Part Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pIgnoreApplicationPartOrder()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pIgnoreApplicationPartOrder = L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pMaximumInstantiationsPerProtectionObjective() <em>L1p Maximum Instantiations Per Protection Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMaximumInstantiationsPerProtectionObjective()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getL1pMaximumInstantiationsPerProtectionObjective() <em>L1p Maximum Instantiations Per Protection Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMaximumInstantiationsPerProtectionObjective()
	 * @generated
	 * @ordered
	 */
	protected int l1pMaximumInstantiationsPerProtectionObjective = L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pMainSearchMaximumDepth() <em>L1p Main Search Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMainSearchMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getL1pMainSearchMaximumDepth() <em>L1p Main Search Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pMainSearchMaximumDepth()
	 * @generated
	 * @ordered
	 */
	protected int l1pMainSearchMaximumDepth = L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isL1pMultiTree() <em>L1p Multi Tree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pMultiTree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean L1P_MULTI_TREE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isL1pMultiTree() <em>L1p Multi Tree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isL1pMultiTree()
	 * @generated
	 * @ordered
	 */
	protected boolean l1pMultiTree = L1P_MULTI_TREE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pInitialAlpha() <em>L1p Initial Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_INITIAL_ALPHA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL1pInitialAlpha() <em>L1p Initial Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialAlpha()
	 * @generated
	 * @ordered
	 */
	protected double l1pInitialAlpha = L1P_INITIAL_ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pInitialBeta() <em>L1p Initial Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialBeta()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_INITIAL_BETA_EDEFAULT = 5.0;

	/**
	 * The cached value of the '{@link #getL1pInitialBeta() <em>L1p Initial Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pInitialBeta()
	 * @generated
	 * @ordered
	 */
	protected double l1pInitialBeta = L1P_INITIAL_BETA_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pResearchDelta() <em>L1p Research Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pResearchDelta()
	 * @generated
	 * @ordered
	 */
	protected static final double L1P_RESEARCH_DELTA_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getL1pResearchDelta() <em>L1p Research Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pResearchDelta()
	 * @generated
	 * @ordered
	 */
	protected double l1pResearchDelta = L1P_RESEARCH_DELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getL1pTranspositionTableMaximumSize() <em>L1p Transposition Table Maximum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTranspositionTableMaximumSize()
	 * @generated
	 * @ordered
	 */
	protected static final int L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT = 1000000;

	/**
	 * The cached value of the '{@link #getL1pTranspositionTableMaximumSize() <em>L1p Transposition Table Maximum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL1pTranspositionTableMaximumSize()
	 * @generated
	 * @ordered
	 */
	protected int l1pTranspositionTableMaximumSize = L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pSolutionsCount() <em>L2p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_SOLUTIONS_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getL2pSolutionsCount() <em>L2p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected int l2pSolutionsCount = L2P_SOLUTIONS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingSeed() <em>L2p Function Splitting Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingSeed()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_SEED_EDEFAULT = 1106103861;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingSeed() <em>L2p Function Splitting Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingSeed()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingSeed = L2P_FUNCTION_SPLITTING_SEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pSolutionLimit() <em>L2p Solution Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_SOLUTION_LIMIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getL2pSolutionLimit() <em>L2p Solution Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pSolutionLimit()
	 * @generated
	 * @ordered
	 */
	protected int l2pSolutionLimit = L2P_SOLUTION_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pTimeLimit() <em>L2p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_TIME_LIMIT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getL2pTimeLimit() <em>L2p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pTimeLimit()
	 * @generated
	 * @ordered
	 */
	protected int l2pTimeLimit = L2P_TIME_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pGapLimit() <em>L2p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected static final double L2P_GAP_LIMIT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getL2pGapLimit() <em>L2p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pGapLimit()
	 * @generated
	 * @ordered
	 */
	protected double l2pGapLimit = L2P_GAP_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pUpperBound() <em>L2p Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_UPPER_BOUND_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getL2pUpperBound() <em>L2p Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int l2pUpperBound = L2P_UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingMediumCodeBlockLength() <em>L2p Function Splitting Medium Code Block Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingMediumCodeBlockLength()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingMediumCodeBlockLength() <em>L2p Function Splitting Medium Code Block Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingMediumCodeBlockLength()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingMediumCodeBlockLength = L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator() <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator() <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingCodeBlockLengthRandomizationDenominator = L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getL2pFunctionSplittingDepthLevel() <em>L2p Function Splitting Depth Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingDepthLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getL2pFunctionSplittingDepthLevel() <em>L2p Function Splitting Depth Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2pFunctionSplittingDepthLevel()
	 * @generated
	 * @ordered
	 */
	protected int l2pFunctionSplittingDepthLevel = L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSetPNDirectory() <em>Set PN Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetPNDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String SET_PN_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSetPNDirectory() <em>Set PN Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetPNDirectory()
	 * @generated
	 * @ordered
	 */
	protected String setPNDirectory = SET_PN_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSetPNFile() <em>Set PN File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetPNFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SET_PN_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSetPNFile() <em>Set PN File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetPNFile()
	 * @generated
	 * @ordered
	 */
	protected String setPNFile = SET_PN_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferencesImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return AkbPackage.Literals.PREFERENCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkingDirectory()
	{
		return workingDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkingDirectory(String newWorkingDirectory)
	{
		String oldWorkingDirectory = workingDirectory;
		workingDirectory = newWorkingDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__WORKING_DIRECTORY, oldWorkingDirectory, workingDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActcConfigurationFile()
	{
		return actcConfigurationFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActcConfigurationFile(String newActcConfigurationFile)
	{
		String oldActcConfigurationFile = actcConfigurationFile;
		actcConfigurationFile = newActcConfigurationFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE, oldActcConfigurationFile, actcConfigurationFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdssPatchFile()
	{
		return adssPatchFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdssPatchFile(String newAdssPatchFile)
	{
		String oldAdssPatchFile = adssPatchFile;
		adssPatchFile = newAdssPatchFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ADSS_PATCH_FILE, oldAdssPatchFile, adssPatchFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdssJSONFile()
	{
		return adssJSONFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdssJSONFile(String newAdssJSONFile)
	{
		String oldAdssJSONFile = adssJSONFile;
		adssJSONFile = newAdssJSONFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ADSS_JSON_FILE, oldAdssJSONFile, adssJSONFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArchitecture()
	{
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchitecture(String newArchitecture)
	{
		String oldArchitecture = architecture;
		architecture = newArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ARCHITECTURE, oldArchitecture, architecture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoteConnection()
	{
		return remoteConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteConnection(boolean newRemoteConnection)
	{
		boolean oldRemoteConnection = remoteConnection;
		remoteConnection = newRemoteConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__REMOTE_CONNECTION, oldRemoteConnection, remoteConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteUsername()
	{
		return remoteUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteUsername(String newRemoteUsername)
	{
		String oldRemoteUsername = remoteUsername;
		remoteUsername = newRemoteUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__REMOTE_USERNAME, oldRemoteUsername, remoteUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemotePassword()
	{
		return remotePassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemotePassword(String newRemotePassword)
	{
		String oldRemotePassword = remotePassword;
		remotePassword = newRemotePassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__REMOTE_PASSWORD, oldRemotePassword, remotePassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteHost()
	{
		return remoteHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteHost(String newRemoteHost)
	{
		String oldRemoteHost = remoteHost;
		remoteHost = newRemoteHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__REMOTE_HOST, oldRemoteHost, remoteHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRemotePort()
	{
		return remotePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemotePort(int newRemotePort)
	{
		int oldRemotePort = remotePort;
		remotePort = newRemotePort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__REMOTE_PORT, oldRemotePort, remotePort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteFileSeparator()
	{
		return remoteFileSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteFileSeparator(String newRemoteFileSeparator)
	{
		String oldRemoteFileSeparator = remoteFileSeparator;
		remoteFileSeparator = newRemoteFileSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR, oldRemoteFileSeparator, remoteFileSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandACTC()
	{
		return commandACTC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandACTC(String newCommandACTC)
	{
		String oldCommandACTC = commandACTC;
		commandACTC = newCommandACTC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__COMMAND_ACTC, oldCommandACTC, commandACTC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandPerl()
	{
		return commandPerl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandPerl(String newCommandPerl)
	{
		String oldCommandPerl = commandPerl;
		commandPerl = newCommandPerl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__COMMAND_PERL, oldCommandPerl, commandPerl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandDot()
	{
		return commandDot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandDot(String newCommandDot)
	{
		String oldCommandDot = commandDot;
		commandDot = newCommandDot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__COMMAND_DOT, oldCommandDot, commandDot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetricsFile()
	{
		return metricsFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricsFile(String newMetricsFile)
	{
		String oldMetricsFile = metricsFile;
		metricsFile = newMetricsFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__METRICS_FILE, oldMetricsFile, metricsFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParserHeaderParsing()
	{
		return parserHeaderParsing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParserHeaderParsing(boolean newParserHeaderParsing)
	{
		boolean oldParserHeaderParsing = parserHeaderParsing;
		parserHeaderParsing = newParserHeaderParsing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__PARSER_HEADER_PARSING, oldParserHeaderParsing, parserHeaderParsing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParserSystemFilesIgnoration()
	{
		return parserSystemFilesIgnoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParserSystemFilesIgnoration(boolean newParserSystemFilesIgnoration)
	{
		boolean oldParserSystemFilesIgnoration = parserSystemFilesIgnoration;
		parserSystemFilesIgnoration = newParserSystemFilesIgnoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION, oldParserSystemFilesIgnoration, parserSystemFilesIgnoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttacksTimeLimit()
	{
		return attacksTimeLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttacksTimeLimit(int newAttacksTimeLimit)
	{
		int oldAttacksTimeLimit = attacksTimeLimit;
		attacksTimeLimit = newAttacksTimeLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT, oldAttacksTimeLimit, attacksTimeLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttacksMaximumDepth()
	{
		return attacksMaximumDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttacksMaximumDepth(int newAttacksMaximumDepth)
	{
		int oldAttacksMaximumDepth = attacksMaximumDepth;
		attacksMaximumDepth = newAttacksMaximumDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH, oldAttacksMaximumDepth, attacksMaximumDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttacksIncludedProtectionObjectivesRemoval()
	{
		return attacksIncludedProtectionObjectivesRemoval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttacksIncludedProtectionObjectivesRemoval(boolean newAttacksIncludedProtectionObjectivesRemoval)
	{
		boolean oldAttacksIncludedProtectionObjectivesRemoval = attacksIncludedProtectionObjectivesRemoval;
		attacksIncludedProtectionObjectivesRemoval = newAttacksIncludedProtectionObjectivesRemoval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL, oldAttacksIncludedProtectionObjectivesRemoval, attacksIncludedProtectionObjectivesRemoval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getProtectionsMinimumAttackMitigation()
	{
		return protectionsMinimumAttackMitigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectionsMinimumAttackMitigation(Level newProtectionsMinimumAttackMitigation)
	{
		Level oldProtectionsMinimumAttackMitigation = protectionsMinimumAttackMitigation;
		protectionsMinimumAttackMitigation = newProtectionsMinimumAttackMitigation == null ? PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT : newProtectionsMinimumAttackMitigation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION, oldProtectionsMinimumAttackMitigation, protectionsMinimumAttackMitigation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getClientTimeOverhead()
	{
		return clientTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientTimeOverhead(double newClientTimeOverhead)
	{
		double oldClientTimeOverhead = clientTimeOverhead;
		clientTimeOverhead = newClientTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD, oldClientTimeOverhead, clientTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getServerTimeOverhead()
	{
		return serverTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerTimeOverhead(double newServerTimeOverhead)
	{
		double oldServerTimeOverhead = serverTimeOverhead;
		serverTimeOverhead = newServerTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD, oldServerTimeOverhead, serverTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getClientMemoryOverhead()
	{
		return clientMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientMemoryOverhead(int newClientMemoryOverhead)
	{
		int oldClientMemoryOverhead = clientMemoryOverhead;
		clientMemoryOverhead = newClientMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD, oldClientMemoryOverhead, clientMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getServerMemoryOverhead()
	{
		return serverMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerMemoryOverhead(int newServerMemoryOverhead)
	{
		int oldServerMemoryOverhead = serverMemoryOverhead;
		serverMemoryOverhead = newServerMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD, oldServerMemoryOverhead, serverMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNetworkOverhead()
	{
		return networkOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetworkOverhead(int newNetworkOverhead)
	{
		int oldNetworkOverhead = networkOverhead;
		networkOverhead = newNetworkOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__NETWORK_OVERHEAD, oldNetworkOverhead, networkOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL1pSolutionsCount()
	{
		return l1pSolutionsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pSolutionsCount(int newL1pSolutionsCount)
	{
		int oldL1pSolutionsCount = l1pSolutionsCount;
		l1pSolutionsCount = newL1pSolutionsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT, oldL1pSolutionsCount, l1pSolutionsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isL1pPetriNetsPass()
	{
		return l1pPetriNetsPass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pPetriNetsPass(boolean newL1pPetriNetsPass)
	{
		boolean oldL1pPetriNetsPass = l1pPetriNetsPass;
		l1pPetriNetsPass = newL1pPetriNetsPass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS, oldL1pPetriNetsPass, l1pPetriNetsPass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL1pTimeLimit()
	{
		return l1pTimeLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pTimeLimit(int newL1pTimeLimit)
	{
		int oldL1pTimeLimit = l1pTimeLimit;
		l1pTimeLimit = newL1pTimeLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_TIME_LIMIT, oldL1pTimeLimit, l1pTimeLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL1pSolutionsLimit()
	{
		return l1pSolutionsLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pSolutionsLimit(int newL1pSolutionsLimit)
	{
		int oldL1pSolutionsLimit = l1pSolutionsLimit;
		l1pSolutionsLimit = newL1pSolutionsLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT, oldL1pSolutionsLimit, l1pSolutionsLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pGapLimit()
	{
		return l1pGapLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pGapLimit(double newL1pGapLimit)
	{
		double oldL1pGapLimit = l1pGapLimit;
		l1pGapLimit = newL1pGapLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_GAP_LIMIT, oldL1pGapLimit, l1pGapLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pClientTimeOverheadPercentage()
	{
		return l1pClientTimeOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pClientTimeOverheadPercentage(double newL1pClientTimeOverheadPercentage)
	{
		double oldL1pClientTimeOverheadPercentage = l1pClientTimeOverheadPercentage;
		l1pClientTimeOverheadPercentage = newL1pClientTimeOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE, oldL1pClientTimeOverheadPercentage, l1pClientTimeOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pServerTimeOverheadPercentage()
	{
		return l1pServerTimeOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pServerTimeOverheadPercentage(double newL1pServerTimeOverheadPercentage)
	{
		double oldL1pServerTimeOverheadPercentage = l1pServerTimeOverheadPercentage;
		l1pServerTimeOverheadPercentage = newL1pServerTimeOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE, oldL1pServerTimeOverheadPercentage, l1pServerTimeOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pClientMemoryOverheadPercentage()
	{
		return l1pClientMemoryOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pClientMemoryOverheadPercentage(double newL1pClientMemoryOverheadPercentage)
	{
		double oldL1pClientMemoryOverheadPercentage = l1pClientMemoryOverheadPercentage;
		l1pClientMemoryOverheadPercentage = newL1pClientMemoryOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE, oldL1pClientMemoryOverheadPercentage, l1pClientMemoryOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pServerMemoryOverheadPercentage()
	{
		return l1pServerMemoryOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pServerMemoryOverheadPercentage(double newL1pServerMemoryOverheadPercentage)
	{
		double oldL1pServerMemoryOverheadPercentage = l1pServerMemoryOverheadPercentage;
		l1pServerMemoryOverheadPercentage = newL1pServerMemoryOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE, oldL1pServerMemoryOverheadPercentage, l1pServerMemoryOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pNetworkOverheadPercentage()
	{
		return l1pNetworkOverheadPercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pNetworkOverheadPercentage(double newL1pNetworkOverheadPercentage)
	{
		double oldL1pNetworkOverheadPercentage = l1pNetworkOverheadPercentage;
		l1pNetworkOverheadPercentage = newL1pNetworkOverheadPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE, oldL1pNetworkOverheadPercentage, l1pNetworkOverheadPercentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isL1pDiscouragedPrecedencesIgnoration()
	{
		return l1pDiscouragedPrecedencesIgnoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pDiscouragedPrecedencesIgnoration(boolean newL1pDiscouragedPrecedencesIgnoration)
	{
		boolean oldL1pDiscouragedPrecedencesIgnoration = l1pDiscouragedPrecedencesIgnoration;
		l1pDiscouragedPrecedencesIgnoration = newL1pDiscouragedPrecedencesIgnoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION, oldL1pDiscouragedPrecedencesIgnoration, l1pDiscouragedPrecedencesIgnoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isL1pEncouragedPrecedencesFocusing()
	{
		return l1pEncouragedPrecedencesFocusing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pEncouragedPrecedencesFocusing(boolean newL1pEncouragedPrecedencesFocusing)
	{
		boolean oldL1pEncouragedPrecedencesFocusing = l1pEncouragedPrecedencesFocusing;
		l1pEncouragedPrecedencesFocusing = newL1pEncouragedPrecedencesFocusing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING, oldL1pEncouragedPrecedencesFocusing, l1pEncouragedPrecedencesFocusing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isL1pUseACTCPrecedences()
	{
		return l1pUseACTCPrecedences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pUseACTCPrecedences(boolean newL1pUseACTCPrecedences)
	{
		boolean oldL1pUseACTCPrecedences = l1pUseACTCPrecedences;
		l1pUseACTCPrecedences = newL1pUseACTCPrecedences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES, oldL1pUseACTCPrecedences, l1pUseACTCPrecedences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isL1pIgnoreApplicationPartOrder()
	{
		return l1pIgnoreApplicationPartOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pIgnoreApplicationPartOrder(boolean newL1pIgnoreApplicationPartOrder)
	{
		boolean oldL1pIgnoreApplicationPartOrder = l1pIgnoreApplicationPartOrder;
		l1pIgnoreApplicationPartOrder = newL1pIgnoreApplicationPartOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER, oldL1pIgnoreApplicationPartOrder, l1pIgnoreApplicationPartOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL1pMaximumInstantiationsPerProtectionObjective()
	{
		return l1pMaximumInstantiationsPerProtectionObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pMaximumInstantiationsPerProtectionObjective(int newL1pMaximumInstantiationsPerProtectionObjective)
	{
		int oldL1pMaximumInstantiationsPerProtectionObjective = l1pMaximumInstantiationsPerProtectionObjective;
		l1pMaximumInstantiationsPerProtectionObjective = newL1pMaximumInstantiationsPerProtectionObjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE, oldL1pMaximumInstantiationsPerProtectionObjective, l1pMaximumInstantiationsPerProtectionObjective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL1pMainSearchMaximumDepth()
	{
		return l1pMainSearchMaximumDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pMainSearchMaximumDepth(int newL1pMainSearchMaximumDepth)
	{
		int oldL1pMainSearchMaximumDepth = l1pMainSearchMaximumDepth;
		l1pMainSearchMaximumDepth = newL1pMainSearchMaximumDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH, oldL1pMainSearchMaximumDepth, l1pMainSearchMaximumDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isL1pMultiTree()
	{
		return l1pMultiTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pMultiTree(boolean newL1pMultiTree)
	{
		boolean oldL1pMultiTree = l1pMultiTree;
		l1pMultiTree = newL1pMultiTree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_MULTI_TREE, oldL1pMultiTree, l1pMultiTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pInitialAlpha()
	{
		return l1pInitialAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pInitialAlpha(double newL1pInitialAlpha)
	{
		double oldL1pInitialAlpha = l1pInitialAlpha;
		l1pInitialAlpha = newL1pInitialAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA, oldL1pInitialAlpha, l1pInitialAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pInitialBeta()
	{
		return l1pInitialBeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pInitialBeta(double newL1pInitialBeta)
	{
		double oldL1pInitialBeta = l1pInitialBeta;
		l1pInitialBeta = newL1pInitialBeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_INITIAL_BETA, oldL1pInitialBeta, l1pInitialBeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL1pResearchDelta()
	{
		return l1pResearchDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pResearchDelta(double newL1pResearchDelta)
	{
		double oldL1pResearchDelta = l1pResearchDelta;
		l1pResearchDelta = newL1pResearchDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA, oldL1pResearchDelta, l1pResearchDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL1pTranspositionTableMaximumSize()
	{
		return l1pTranspositionTableMaximumSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL1pTranspositionTableMaximumSize(int newL1pTranspositionTableMaximumSize)
	{
		int oldL1pTranspositionTableMaximumSize = l1pTranspositionTableMaximumSize;
		l1pTranspositionTableMaximumSize = newL1pTranspositionTableMaximumSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE, oldL1pTranspositionTableMaximumSize, l1pTranspositionTableMaximumSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pSolutionsCount()
	{
		return l2pSolutionsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pSolutionsCount(int newL2pSolutionsCount)
	{
		int oldL2pSolutionsCount = l2pSolutionsCount;
		l2pSolutionsCount = newL2pSolutionsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT, oldL2pSolutionsCount, l2pSolutionsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pFunctionSplittingSeed()
	{
		return l2pFunctionSplittingSeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pFunctionSplittingSeed(int newL2pFunctionSplittingSeed)
	{
		int oldL2pFunctionSplittingSeed = l2pFunctionSplittingSeed;
		l2pFunctionSplittingSeed = newL2pFunctionSplittingSeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED, oldL2pFunctionSplittingSeed, l2pFunctionSplittingSeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pSolutionLimit()
	{
		return l2pSolutionLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pSolutionLimit(int newL2pSolutionLimit)
	{
		int oldL2pSolutionLimit = l2pSolutionLimit;
		l2pSolutionLimit = newL2pSolutionLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT, oldL2pSolutionLimit, l2pSolutionLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pTimeLimit()
	{
		return l2pTimeLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pTimeLimit(int newL2pTimeLimit)
	{
		int oldL2pTimeLimit = l2pTimeLimit;
		l2pTimeLimit = newL2pTimeLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_TIME_LIMIT, oldL2pTimeLimit, l2pTimeLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getL2pGapLimit()
	{
		return l2pGapLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pGapLimit(double newL2pGapLimit)
	{
		double oldL2pGapLimit = l2pGapLimit;
		l2pGapLimit = newL2pGapLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_GAP_LIMIT, oldL2pGapLimit, l2pGapLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pUpperBound()
	{
		return l2pUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pUpperBound(int newL2pUpperBound)
	{
		int oldL2pUpperBound = l2pUpperBound;
		l2pUpperBound = newL2pUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_UPPER_BOUND, oldL2pUpperBound, l2pUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pFunctionSplittingMediumCodeBlockLength()
	{
		return l2pFunctionSplittingMediumCodeBlockLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pFunctionSplittingMediumCodeBlockLength(int newL2pFunctionSplittingMediumCodeBlockLength)
	{
		int oldL2pFunctionSplittingMediumCodeBlockLength = l2pFunctionSplittingMediumCodeBlockLength;
		l2pFunctionSplittingMediumCodeBlockLength = newL2pFunctionSplittingMediumCodeBlockLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH, oldL2pFunctionSplittingMediumCodeBlockLength, l2pFunctionSplittingMediumCodeBlockLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	{
		return l2pFunctionSplittingCodeBlockLengthRandomizationDenominator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(int newL2pFunctionSplittingCodeBlockLengthRandomizationDenominator)
	{
		int oldL2pFunctionSplittingCodeBlockLengthRandomizationDenominator = l2pFunctionSplittingCodeBlockLengthRandomizationDenominator;
		l2pFunctionSplittingCodeBlockLengthRandomizationDenominator = newL2pFunctionSplittingCodeBlockLengthRandomizationDenominator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR, oldL2pFunctionSplittingCodeBlockLengthRandomizationDenominator, l2pFunctionSplittingCodeBlockLengthRandomizationDenominator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getL2pFunctionSplittingDepthLevel()
	{
		return l2pFunctionSplittingDepthLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2pFunctionSplittingDepthLevel(int newL2pFunctionSplittingDepthLevel)
	{
		int oldL2pFunctionSplittingDepthLevel = l2pFunctionSplittingDepthLevel;
		l2pFunctionSplittingDepthLevel = newL2pFunctionSplittingDepthLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL, oldL2pFunctionSplittingDepthLevel, l2pFunctionSplittingDepthLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSetPNDirectory()
	{
		return setPNDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetPNDirectory(String newSetPNDirectory)
	{
		String oldSetPNDirectory = setPNDirectory;
		setPNDirectory = newSetPNDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__SET_PN_DIRECTORY, oldSetPNDirectory, setPNDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSetPNFile()
	{
		return setPNFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetPNFile(String newSetPNFile)
	{
		String oldSetPNFile = setPNFile;
		setPNFile = newSetPNFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PREFERENCES__SET_PN_FILE, oldSetPNFile, setPNFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = "preferences".hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equals(final Object object)
	{
		boolean _equals = Objects.equal(object, null);
		if (_equals)
		{
			return false;
		}
		else
		{
			if ((object instanceof Preferences))
			{
				return (this == object);
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case AkbPackage.PREFERENCES__WORKING_DIRECTORY:
				return getWorkingDirectory();
			case AkbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				return getActcConfigurationFile();
			case AkbPackage.PREFERENCES__ADSS_PATCH_FILE:
				return getAdssPatchFile();
			case AkbPackage.PREFERENCES__ADSS_JSON_FILE:
				return getAdssJSONFile();
			case AkbPackage.PREFERENCES__ARCHITECTURE:
				return getArchitecture();
			case AkbPackage.PREFERENCES__REMOTE_CONNECTION:
				return isRemoteConnection();
			case AkbPackage.PREFERENCES__REMOTE_USERNAME:
				return getRemoteUsername();
			case AkbPackage.PREFERENCES__REMOTE_PASSWORD:
				return getRemotePassword();
			case AkbPackage.PREFERENCES__REMOTE_HOST:
				return getRemoteHost();
			case AkbPackage.PREFERENCES__REMOTE_PORT:
				return getRemotePort();
			case AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				return getRemoteFileSeparator();
			case AkbPackage.PREFERENCES__COMMAND_ACTC:
				return getCommandACTC();
			case AkbPackage.PREFERENCES__COMMAND_PERL:
				return getCommandPerl();
			case AkbPackage.PREFERENCES__COMMAND_DOT:
				return getCommandDot();
			case AkbPackage.PREFERENCES__METRICS_FILE:
				return getMetricsFile();
			case AkbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				return isParserHeaderParsing();
			case AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				return isParserSystemFilesIgnoration();
			case AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				return getAttacksTimeLimit();
			case AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				return getAttacksMaximumDepth();
			case AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				return isAttacksIncludedProtectionObjectivesRemoval();
			case AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				return getProtectionsMinimumAttackMitigation();
			case AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				return getClientTimeOverhead();
			case AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				return getServerTimeOverhead();
			case AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				return getClientMemoryOverhead();
			case AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				return getServerMemoryOverhead();
			case AkbPackage.PREFERENCES__NETWORK_OVERHEAD:
				return getNetworkOverhead();
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				return getL1pSolutionsCount();
			case AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS:
				return isL1pPetriNetsPass();
			case AkbPackage.PREFERENCES__L1P_TIME_LIMIT:
				return getL1pTimeLimit();
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				return getL1pSolutionsLimit();
			case AkbPackage.PREFERENCES__L1P_GAP_LIMIT:
				return getL1pGapLimit();
			case AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				return getL1pClientTimeOverheadPercentage();
			case AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				return getL1pServerTimeOverheadPercentage();
			case AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				return getL1pClientMemoryOverheadPercentage();
			case AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				return getL1pServerMemoryOverheadPercentage();
			case AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				return getL1pNetworkOverheadPercentage();
			case AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				return isL1pDiscouragedPrecedencesIgnoration();
			case AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				return isL1pEncouragedPrecedencesFocusing();
			case AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				return isL1pUseACTCPrecedences();
			case AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				return isL1pIgnoreApplicationPartOrder();
			case AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				return getL1pMaximumInstantiationsPerProtectionObjective();
			case AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				return getL1pMainSearchMaximumDepth();
			case AkbPackage.PREFERENCES__L1P_MULTI_TREE:
				return isL1pMultiTree();
			case AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				return getL1pInitialAlpha();
			case AkbPackage.PREFERENCES__L1P_INITIAL_BETA:
				return getL1pInitialBeta();
			case AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				return getL1pResearchDelta();
			case AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				return getL1pTranspositionTableMaximumSize();
			case AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				return getL2pSolutionsCount();
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				return getL2pFunctionSplittingSeed();
			case AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				return getL2pSolutionLimit();
			case AkbPackage.PREFERENCES__L2P_TIME_LIMIT:
				return getL2pTimeLimit();
			case AkbPackage.PREFERENCES__L2P_GAP_LIMIT:
				return getL2pGapLimit();
			case AkbPackage.PREFERENCES__L2P_UPPER_BOUND:
				return getL2pUpperBound();
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				return getL2pFunctionSplittingMediumCodeBlockLength();
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				return getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator();
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				return getL2pFunctionSplittingDepthLevel();
			case AkbPackage.PREFERENCES__SET_PN_DIRECTORY:
				return getSetPNDirectory();
			case AkbPackage.PREFERENCES__SET_PN_FILE:
				return getSetPNFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case AkbPackage.PREFERENCES__WORKING_DIRECTORY:
				setWorkingDirectory((String)newValue);
				return;
			case AkbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				setActcConfigurationFile((String)newValue);
				return;
			case AkbPackage.PREFERENCES__ADSS_PATCH_FILE:
				setAdssPatchFile((String)newValue);
				return;
			case AkbPackage.PREFERENCES__ADSS_JSON_FILE:
				setAdssJSONFile((String)newValue);
				return;
			case AkbPackage.PREFERENCES__ARCHITECTURE:
				setArchitecture((String)newValue);
				return;
			case AkbPackage.PREFERENCES__REMOTE_CONNECTION:
				setRemoteConnection((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__REMOTE_USERNAME:
				setRemoteUsername((String)newValue);
				return;
			case AkbPackage.PREFERENCES__REMOTE_PASSWORD:
				setRemotePassword((String)newValue);
				return;
			case AkbPackage.PREFERENCES__REMOTE_HOST:
				setRemoteHost((String)newValue);
				return;
			case AkbPackage.PREFERENCES__REMOTE_PORT:
				setRemotePort((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				setRemoteFileSeparator((String)newValue);
				return;
			case AkbPackage.PREFERENCES__COMMAND_ACTC:
				setCommandACTC((String)newValue);
				return;
			case AkbPackage.PREFERENCES__COMMAND_PERL:
				setCommandPerl((String)newValue);
				return;
			case AkbPackage.PREFERENCES__COMMAND_DOT:
				setCommandDot((String)newValue);
				return;
			case AkbPackage.PREFERENCES__METRICS_FILE:
				setMetricsFile((String)newValue);
				return;
			case AkbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				setParserHeaderParsing((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				setParserSystemFilesIgnoration((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				setAttacksTimeLimit((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				setAttacksMaximumDepth((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				setAttacksIncludedProtectionObjectivesRemoval((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				setProtectionsMinimumAttackMitigation((Level)newValue);
				return;
			case AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__NETWORK_OVERHEAD:
				setNetworkOverhead((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				setL1pSolutionsCount((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS:
				setL1pPetriNetsPass((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_TIME_LIMIT:
				setL1pTimeLimit((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				setL1pSolutionsLimit((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_GAP_LIMIT:
				setL1pGapLimit((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				setL1pClientTimeOverheadPercentage((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				setL1pServerTimeOverheadPercentage((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pClientMemoryOverheadPercentage((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pServerMemoryOverheadPercentage((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				setL1pNetworkOverheadPercentage((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				setL1pDiscouragedPrecedencesIgnoration((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				setL1pEncouragedPrecedencesFocusing((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				setL1pUseACTCPrecedences((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				setL1pIgnoreApplicationPartOrder((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				setL1pMaximumInstantiationsPerProtectionObjective((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				setL1pMainSearchMaximumDepth((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_MULTI_TREE:
				setL1pMultiTree((Boolean)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				setL1pInitialAlpha((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_INITIAL_BETA:
				setL1pInitialBeta((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				setL1pResearchDelta((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				setL1pTranspositionTableMaximumSize((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				setL2pSolutionsCount((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				setL2pFunctionSplittingSeed((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				setL2pSolutionLimit((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_TIME_LIMIT:
				setL2pTimeLimit((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_GAP_LIMIT:
				setL2pGapLimit((Double)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_UPPER_BOUND:
				setL2pUpperBound((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				setL2pFunctionSplittingMediumCodeBlockLength((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				setL2pFunctionSplittingDepthLevel((Integer)newValue);
				return;
			case AkbPackage.PREFERENCES__SET_PN_DIRECTORY:
				setSetPNDirectory((String)newValue);
				return;
			case AkbPackage.PREFERENCES__SET_PN_FILE:
				setSetPNFile((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case AkbPackage.PREFERENCES__WORKING_DIRECTORY:
				setWorkingDirectory(WORKING_DIRECTORY_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				setActcConfigurationFile(ACTC_CONFIGURATION_FILE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ADSS_PATCH_FILE:
				setAdssPatchFile(ADSS_PATCH_FILE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ADSS_JSON_FILE:
				setAdssJSONFile(ADSS_JSON_FILE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ARCHITECTURE:
				setArchitecture(ARCHITECTURE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__REMOTE_CONNECTION:
				setRemoteConnection(REMOTE_CONNECTION_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__REMOTE_USERNAME:
				setRemoteUsername(REMOTE_USERNAME_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__REMOTE_PASSWORD:
				setRemotePassword(REMOTE_PASSWORD_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__REMOTE_HOST:
				setRemoteHost(REMOTE_HOST_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__REMOTE_PORT:
				setRemotePort(REMOTE_PORT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				setRemoteFileSeparator(REMOTE_FILE_SEPARATOR_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__COMMAND_ACTC:
				setCommandACTC(COMMAND_ACTC_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__COMMAND_PERL:
				setCommandPerl(COMMAND_PERL_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__COMMAND_DOT:
				setCommandDot(COMMAND_DOT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__METRICS_FILE:
				setMetricsFile(METRICS_FILE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				setParserHeaderParsing(PARSER_HEADER_PARSING_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				setParserSystemFilesIgnoration(PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				setAttacksTimeLimit(ATTACKS_TIME_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				setAttacksMaximumDepth(ATTACKS_MAXIMUM_DEPTH_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				setAttacksIncludedProtectionObjectivesRemoval(ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				setProtectionsMinimumAttackMitigation(PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead(CLIENT_TIME_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead(SERVER_TIME_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead(CLIENT_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead(SERVER_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__NETWORK_OVERHEAD:
				setNetworkOverhead(NETWORK_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				setL1pSolutionsCount(L1P_SOLUTIONS_COUNT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS:
				setL1pPetriNetsPass(L1P_PETRI_NETS_PASS_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_TIME_LIMIT:
				setL1pTimeLimit(L1P_TIME_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				setL1pSolutionsLimit(L1P_SOLUTIONS_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_GAP_LIMIT:
				setL1pGapLimit(L1P_GAP_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				setL1pClientTimeOverheadPercentage(L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				setL1pServerTimeOverheadPercentage(L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pClientMemoryOverheadPercentage(L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				setL1pServerMemoryOverheadPercentage(L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				setL1pNetworkOverheadPercentage(L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				setL1pDiscouragedPrecedencesIgnoration(L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				setL1pEncouragedPrecedencesFocusing(L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				setL1pUseACTCPrecedences(L1P_USE_ACTC_PRECEDENCES_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				setL1pIgnoreApplicationPartOrder(L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				setL1pMaximumInstantiationsPerProtectionObjective(L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				setL1pMainSearchMaximumDepth(L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_MULTI_TREE:
				setL1pMultiTree(L1P_MULTI_TREE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				setL1pInitialAlpha(L1P_INITIAL_ALPHA_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_INITIAL_BETA:
				setL1pInitialBeta(L1P_INITIAL_BETA_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				setL1pResearchDelta(L1P_RESEARCH_DELTA_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				setL1pTranspositionTableMaximumSize(L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				setL2pSolutionsCount(L2P_SOLUTIONS_COUNT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				setL2pFunctionSplittingSeed(L2P_FUNCTION_SPLITTING_SEED_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				setL2pSolutionLimit(L2P_SOLUTION_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_TIME_LIMIT:
				setL2pTimeLimit(L2P_TIME_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_GAP_LIMIT:
				setL2pGapLimit(L2P_GAP_LIMIT_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_UPPER_BOUND:
				setL2pUpperBound(L2P_UPPER_BOUND_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				setL2pFunctionSplittingMediumCodeBlockLength(L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				setL2pFunctionSplittingDepthLevel(L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__SET_PN_DIRECTORY:
				setSetPNDirectory(SET_PN_DIRECTORY_EDEFAULT);
				return;
			case AkbPackage.PREFERENCES__SET_PN_FILE:
				setSetPNFile(SET_PN_FILE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case AkbPackage.PREFERENCES__WORKING_DIRECTORY:
				return WORKING_DIRECTORY_EDEFAULT == null ? workingDirectory != null : !WORKING_DIRECTORY_EDEFAULT.equals(workingDirectory);
			case AkbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE:
				return ACTC_CONFIGURATION_FILE_EDEFAULT == null ? actcConfigurationFile != null : !ACTC_CONFIGURATION_FILE_EDEFAULT.equals(actcConfigurationFile);
			case AkbPackage.PREFERENCES__ADSS_PATCH_FILE:
				return ADSS_PATCH_FILE_EDEFAULT == null ? adssPatchFile != null : !ADSS_PATCH_FILE_EDEFAULT.equals(adssPatchFile);
			case AkbPackage.PREFERENCES__ADSS_JSON_FILE:
				return ADSS_JSON_FILE_EDEFAULT == null ? adssJSONFile != null : !ADSS_JSON_FILE_EDEFAULT.equals(adssJSONFile);
			case AkbPackage.PREFERENCES__ARCHITECTURE:
				return ARCHITECTURE_EDEFAULT == null ? architecture != null : !ARCHITECTURE_EDEFAULT.equals(architecture);
			case AkbPackage.PREFERENCES__REMOTE_CONNECTION:
				return remoteConnection != REMOTE_CONNECTION_EDEFAULT;
			case AkbPackage.PREFERENCES__REMOTE_USERNAME:
				return REMOTE_USERNAME_EDEFAULT == null ? remoteUsername != null : !REMOTE_USERNAME_EDEFAULT.equals(remoteUsername);
			case AkbPackage.PREFERENCES__REMOTE_PASSWORD:
				return REMOTE_PASSWORD_EDEFAULT == null ? remotePassword != null : !REMOTE_PASSWORD_EDEFAULT.equals(remotePassword);
			case AkbPackage.PREFERENCES__REMOTE_HOST:
				return REMOTE_HOST_EDEFAULT == null ? remoteHost != null : !REMOTE_HOST_EDEFAULT.equals(remoteHost);
			case AkbPackage.PREFERENCES__REMOTE_PORT:
				return remotePort != REMOTE_PORT_EDEFAULT;
			case AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR:
				return REMOTE_FILE_SEPARATOR_EDEFAULT == null ? remoteFileSeparator != null : !REMOTE_FILE_SEPARATOR_EDEFAULT.equals(remoteFileSeparator);
			case AkbPackage.PREFERENCES__COMMAND_ACTC:
				return COMMAND_ACTC_EDEFAULT == null ? commandACTC != null : !COMMAND_ACTC_EDEFAULT.equals(commandACTC);
			case AkbPackage.PREFERENCES__COMMAND_PERL:
				return COMMAND_PERL_EDEFAULT == null ? commandPerl != null : !COMMAND_PERL_EDEFAULT.equals(commandPerl);
			case AkbPackage.PREFERENCES__COMMAND_DOT:
				return COMMAND_DOT_EDEFAULT == null ? commandDot != null : !COMMAND_DOT_EDEFAULT.equals(commandDot);
			case AkbPackage.PREFERENCES__METRICS_FILE:
				return METRICS_FILE_EDEFAULT == null ? metricsFile != null : !METRICS_FILE_EDEFAULT.equals(metricsFile);
			case AkbPackage.PREFERENCES__PARSER_HEADER_PARSING:
				return parserHeaderParsing != PARSER_HEADER_PARSING_EDEFAULT;
			case AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION:
				return parserSystemFilesIgnoration != PARSER_SYSTEM_FILES_IGNORATION_EDEFAULT;
			case AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT:
				return attacksTimeLimit != ATTACKS_TIME_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH:
				return attacksMaximumDepth != ATTACKS_MAXIMUM_DEPTH_EDEFAULT;
			case AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL:
				return attacksIncludedProtectionObjectivesRemoval != ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL_EDEFAULT;
			case AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION:
				return protectionsMinimumAttackMitigation != PROTECTIONS_MINIMUM_ATTACK_MITIGATION_EDEFAULT;
			case AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD:
				return clientTimeOverhead != CLIENT_TIME_OVERHEAD_EDEFAULT;
			case AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD:
				return serverTimeOverhead != SERVER_TIME_OVERHEAD_EDEFAULT;
			case AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD:
				return clientMemoryOverhead != CLIENT_MEMORY_OVERHEAD_EDEFAULT;
			case AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD:
				return serverMemoryOverhead != SERVER_MEMORY_OVERHEAD_EDEFAULT;
			case AkbPackage.PREFERENCES__NETWORK_OVERHEAD:
				return networkOverhead != NETWORK_OVERHEAD_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT:
				return l1pSolutionsCount != L1P_SOLUTIONS_COUNT_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS:
				return l1pPetriNetsPass != L1P_PETRI_NETS_PASS_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_TIME_LIMIT:
				return l1pTimeLimit != L1P_TIME_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT:
				return l1pSolutionsLimit != L1P_SOLUTIONS_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_GAP_LIMIT:
				return l1pGapLimit != L1P_GAP_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE:
				return l1pClientTimeOverheadPercentage != L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE:
				return l1pServerTimeOverheadPercentage != L1P_SERVER_TIME_OVERHEAD_PERCENTAGE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE:
				return l1pClientMemoryOverheadPercentage != L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE:
				return l1pServerMemoryOverheadPercentage != L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE:
				return l1pNetworkOverheadPercentage != L1P_NETWORK_OVERHEAD_PERCENTAGE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION:
				return l1pDiscouragedPrecedencesIgnoration != L1P_DISCOURAGED_PRECEDENCES_IGNORATION_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING:
				return l1pEncouragedPrecedencesFocusing != L1P_ENCOURAGED_PRECEDENCES_FOCUSING_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES:
				return l1pUseACTCPrecedences != L1P_USE_ACTC_PRECEDENCES_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER:
				return l1pIgnoreApplicationPartOrder != L1P_IGNORE_APPLICATION_PART_ORDER_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE:
				return l1pMaximumInstantiationsPerProtectionObjective != L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH:
				return l1pMainSearchMaximumDepth != L1P_MAIN_SEARCH_MAXIMUM_DEPTH_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_MULTI_TREE:
				return l1pMultiTree != L1P_MULTI_TREE_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA:
				return l1pInitialAlpha != L1P_INITIAL_ALPHA_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_INITIAL_BETA:
				return l1pInitialBeta != L1P_INITIAL_BETA_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA:
				return l1pResearchDelta != L1P_RESEARCH_DELTA_EDEFAULT;
			case AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE:
				return l1pTranspositionTableMaximumSize != L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT:
				return l2pSolutionsCount != L2P_SOLUTIONS_COUNT_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED:
				return l2pFunctionSplittingSeed != L2P_FUNCTION_SPLITTING_SEED_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT:
				return l2pSolutionLimit != L2P_SOLUTION_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_TIME_LIMIT:
				return l2pTimeLimit != L2P_TIME_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_GAP_LIMIT:
				return l2pGapLimit != L2P_GAP_LIMIT_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_UPPER_BOUND:
				return l2pUpperBound != L2P_UPPER_BOUND_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH:
				return l2pFunctionSplittingMediumCodeBlockLength != L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR:
				return l2pFunctionSplittingCodeBlockLengthRandomizationDenominator != L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR_EDEFAULT;
			case AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL:
				return l2pFunctionSplittingDepthLevel != L2P_FUNCTION_SPLITTING_DEPTH_LEVEL_EDEFAULT;
			case AkbPackage.PREFERENCES__SET_PN_DIRECTORY:
				return SET_PN_DIRECTORY_EDEFAULT == null ? setPNDirectory != null : !SET_PN_DIRECTORY_EDEFAULT.equals(setPNDirectory);
			case AkbPackage.PREFERENCES__SET_PN_FILE:
				return SET_PN_FILE_EDEFAULT == null ? setPNFile != null : !SET_PN_FILE_EDEFAULT.equals(setPNFile);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case AkbPackage.PREFERENCES___HASH_CODE:
				return hashCode();
			case AkbPackage.PREFERENCES___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (workingDirectory: ");
		result.append(workingDirectory);
		result.append(", actcConfigurationFile: ");
		result.append(actcConfigurationFile);
		result.append(", adssPatchFile: ");
		result.append(adssPatchFile);
		result.append(", adssJSONFile: ");
		result.append(adssJSONFile);
		result.append(", architecture: ");
		result.append(architecture);
		result.append(", remoteConnection: ");
		result.append(remoteConnection);
		result.append(", remoteUsername: ");
		result.append(remoteUsername);
		result.append(", remotePassword: ");
		result.append(remotePassword);
		result.append(", remoteHost: ");
		result.append(remoteHost);
		result.append(", remotePort: ");
		result.append(remotePort);
		result.append(", remoteFileSeparator: ");
		result.append(remoteFileSeparator);
		result.append(", commandACTC: ");
		result.append(commandACTC);
		result.append(", commandPerl: ");
		result.append(commandPerl);
		result.append(", commandDot: ");
		result.append(commandDot);
		result.append(", metricsFile: ");
		result.append(metricsFile);
		result.append(", parserHeaderParsing: ");
		result.append(parserHeaderParsing);
		result.append(", parserSystemFilesIgnoration: ");
		result.append(parserSystemFilesIgnoration);
		result.append(", attacksTimeLimit: ");
		result.append(attacksTimeLimit);
		result.append(", attacksMaximumDepth: ");
		result.append(attacksMaximumDepth);
		result.append(", attacksIncludedProtectionObjectivesRemoval: ");
		result.append(attacksIncludedProtectionObjectivesRemoval);
		result.append(", protectionsMinimumAttackMitigation: ");
		result.append(protectionsMinimumAttackMitigation);
		result.append(", clientTimeOverhead: ");
		result.append(clientTimeOverhead);
		result.append(", serverTimeOverhead: ");
		result.append(serverTimeOverhead);
		result.append(", clientMemoryOverhead: ");
		result.append(clientMemoryOverhead);
		result.append(", serverMemoryOverhead: ");
		result.append(serverMemoryOverhead);
		result.append(", networkOverhead: ");
		result.append(networkOverhead);
		result.append(", l1pSolutionsCount: ");
		result.append(l1pSolutionsCount);
		result.append(", l1pPetriNetsPass: ");
		result.append(l1pPetriNetsPass);
		result.append(", l1pTimeLimit: ");
		result.append(l1pTimeLimit);
		result.append(", l1pSolutionsLimit: ");
		result.append(l1pSolutionsLimit);
		result.append(", l1pGapLimit: ");
		result.append(l1pGapLimit);
		result.append(", l1pClientTimeOverheadPercentage: ");
		result.append(l1pClientTimeOverheadPercentage);
		result.append(", l1pServerTimeOverheadPercentage: ");
		result.append(l1pServerTimeOverheadPercentage);
		result.append(", l1pClientMemoryOverheadPercentage: ");
		result.append(l1pClientMemoryOverheadPercentage);
		result.append(", l1pServerMemoryOverheadPercentage: ");
		result.append(l1pServerMemoryOverheadPercentage);
		result.append(", l1pNetworkOverheadPercentage: ");
		result.append(l1pNetworkOverheadPercentage);
		result.append(", l1pDiscouragedPrecedencesIgnoration: ");
		result.append(l1pDiscouragedPrecedencesIgnoration);
		result.append(", l1pEncouragedPrecedencesFocusing: ");
		result.append(l1pEncouragedPrecedencesFocusing);
		result.append(", l1pUseACTCPrecedences: ");
		result.append(l1pUseACTCPrecedences);
		result.append(", l1pIgnoreApplicationPartOrder: ");
		result.append(l1pIgnoreApplicationPartOrder);
		result.append(", l1pMaximumInstantiationsPerProtectionObjective: ");
		result.append(l1pMaximumInstantiationsPerProtectionObjective);
		result.append(", l1pMainSearchMaximumDepth: ");
		result.append(l1pMainSearchMaximumDepth);
		result.append(", l1pMultiTree: ");
		result.append(l1pMultiTree);
		result.append(", l1pInitialAlpha: ");
		result.append(l1pInitialAlpha);
		result.append(", l1pInitialBeta: ");
		result.append(l1pInitialBeta);
		result.append(", l1pResearchDelta: ");
		result.append(l1pResearchDelta);
		result.append(", l1pTranspositionTableMaximumSize: ");
		result.append(l1pTranspositionTableMaximumSize);
		result.append(", l2pSolutionsCount: ");
		result.append(l2pSolutionsCount);
		result.append(", l2pFunctionSplittingSeed: ");
		result.append(l2pFunctionSplittingSeed);
		result.append(", l2pSolutionLimit: ");
		result.append(l2pSolutionLimit);
		result.append(", l2pTimeLimit: ");
		result.append(l2pTimeLimit);
		result.append(", l2pGapLimit: ");
		result.append(l2pGapLimit);
		result.append(", l2pUpperBound: ");
		result.append(l2pUpperBound);
		result.append(", l2pFunctionSplittingMediumCodeBlockLength: ");
		result.append(l2pFunctionSplittingMediumCodeBlockLength);
		result.append(", l2pFunctionSplittingCodeBlockLengthRandomizationDenominator: ");
		result.append(l2pFunctionSplittingCodeBlockLengthRandomizationDenominator);
		result.append(", l2pFunctionSplittingDepthLevel: ");
		result.append(l2pFunctionSplittingDepthLevel);
		result.append(", setPNDirectory: ");
		result.append(setPNDirectory);
		result.append(", setPNFile: ");
		result.append(setPNFile);
		result.append(')');
		return result.toString();
	}

} //PreferencesImpl
