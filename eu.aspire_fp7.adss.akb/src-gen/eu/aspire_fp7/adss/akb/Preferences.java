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
package eu.aspire_fp7.adss.akb;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The user preferences.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getWorkingDirectory <em>Working Directory</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getActcConfigurationFile <em>Actc Configuration File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getAdssPatchFile <em>Adss Patch File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getAdssJSONFile <em>Adss JSON File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isRemoteConnection <em>Remote Connection</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteUsername <em>Remote Username</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getRemotePassword <em>Remote Password</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteHost <em>Remote Host</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getRemotePort <em>Remote Port</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteFileSeparator <em>Remote File Separator</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getCommandACTC <em>Command ACTC</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getCommandPerl <em>Command Perl</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getCommandDot <em>Command Dot</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getMetricsFile <em>Metrics File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isParserHeaderParsing <em>Parser Header Parsing</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getAttacksTimeLimit <em>Attacks Time Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getNetworkOverhead <em>Network Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsCount <em>L1p Solutions Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isL1pPetriNetsPass <em>L1p Petri Nets Pass</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pTimeLimit <em>L1p Time Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pGapLimit <em>L1p Gap Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#isL1pMultiTree <em>L1p Multi Tree</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pInitialAlpha <em>L1p Initial Alpha</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pInitialBeta <em>L1p Initial Beta</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pResearchDelta <em>L1p Research Delta</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionsCount <em>L2p Solutions Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionLimit <em>L2p Solution Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pTimeLimit <em>L2p Time Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pGapLimit <em>L2p Gap Limit</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pUpperBound <em>L2p Upper Bound</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getSetPNDirectory <em>Set PN Directory</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Preferences#getSetPNFile <em>Set PN File</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#Preferences",
	name = "http://www.aspire-fp7.eu/akb#preferences",
	singleton = true,
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__WORKING_DIRECTORY, iri = "http://www.aspire-fp7.eu/akb#hasWorkingDirectory"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ACTC_CONFIGURATION_FILE, iri = "http://www.aspire-fp7.eu/akb#hasACTCConfigurationFile"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ADSS_PATCH_FILE, iri = "http://www.aspire-fp7.eu/akb#hasADSSPatchFile"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ADSS_JSON_FILE, iri = "http://www.aspire-fp7.eu/akb#hasADSSJSONFile"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ARCHITECTURE, iri = "http://www.aspire-fp7.eu/akb#hasArchitecture"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__REMOTE_CONNECTION, iri = "http://www.aspire-fp7.eu/akb#isRemoteConnection"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__REMOTE_USERNAME, iri = "http://www.aspire-fp7.eu/akb#hasRemoteUsername"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__REMOTE_PASSWORD, iri = "http://www.aspire-fp7.eu/akb#hasRemotePassword"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__REMOTE_HOST, iri = "http://www.aspire-fp7.eu/akb#hasRemoteHost"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__REMOTE_PORT, iri = "http://www.aspire-fp7.eu/akb#hasRemotePort"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR, iri = "http://www.aspire-fp7.eu/akb#hasRemoteFileSeparator"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__COMMAND_ACTC, iri = "http://www.aspire-fp7.eu/akb#hasCommandACTC"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__COMMAND_PERL, iri = "http://www.aspire-fp7.eu/akb#hasCommandPerl"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__COMMAND_DOT, iri = "http://www.aspire-fp7.eu/akb#hasCommandDot"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__METRICS_FILE, iri = "http://www.aspire-fp7.eu/akb#hasMetricsFile"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__PARSER_HEADER_PARSING, iri = "http://www.aspire-fp7.eu/akb#isParserHeaderParsing"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION, iri = "http://www.aspire-fp7.eu/akb#isParserSystemFilesIgnoration"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ATTACKS_TIME_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasAttacksTimeLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH, iri = "http://www.aspire-fp7.eu/akb#hasAttacksMaximumDepth"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL, iri = "http://www.aspire-fp7.eu/akb#isAttacksIncludedProtectionObjectivesRemoval"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasClientTimeOverhead"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__SERVER_TIME_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasServerTimeOverhead"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasClientMemoryOverhead"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasServerMemoryOverhead"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__NETWORK_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasNetworkOverhead"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT, iri = "http://www.aspire-fp7.eu/akb#hasL1PSolutionsCount"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_PETRI_NETS_PASS, iri = "http://www.aspire-fp7.eu/akb#isL1PPetriNetsPass"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_TIME_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasL1PTimeLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasL1PSolutionsLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_GAP_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasL1PGapLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE, iri = "http://www.aspire-fp7.eu/akb#hasL1PClientTimeOverheadPercentage"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE, iri = "http://www.aspire-fp7.eu/akb#hasL1PServerTimeOverheadPercentage"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE, iri = "http://www.aspire-fp7.eu/akb#hasL1PClientMemoryOverheadPercentage"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE, iri = "http://www.aspire-fp7.eu/akb#hasL1PServerMemoryOverheadPercentage"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE, iri = "http://www.aspire-fp7.eu/akb#hasL1PNetworkOverheadPercentage"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION, iri = "http://www.aspire-fp7.eu/akb#isL1PDiscouragedPrecedencesIgnoration"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING, iri = "http://www.aspire-fp7.eu/akb#isL1PEncouragedPrecedencesFocusing"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES, iri = "http://www.aspire-fp7.eu/akb#isUseL1PACTCPrecedences"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER, iri = "http://www.aspire-fp7.eu/akb#isL1PIgnoreApplicationPartOrder"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE, iri = "http://www.aspire-fp7.eu/akb#hasL1PMaximumInstantiationsPerProtectionObjective"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH, iri = "http://www.aspire-fp7.eu/akb#hasL1PMainSearchMaximumDepth"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_MULTI_TREE, iri = "http://www.aspire-fp7.eu/akb#isL1PMultiTree"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_INITIAL_ALPHA, iri = "http://www.aspire-fp7.eu/akb#hasL1PInitialAlpha"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_INITIAL_BETA, iri = "http://www.aspire-fp7.eu/akb#hasL1PInitialBeta"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_RESEARCH_DELTA, iri = "http://www.aspire-fp7.eu/akb#hasL1PResearchDelta"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE, iri = "http://www.aspire-fp7.eu/akb#hasL1PTranspositionTableMaximumSize"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT, iri = "http://www.aspire-fp7.eu/akb#hasL2PSolutionsCount"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_TIME_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasL2PTimeLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_SOLUTION_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasL2PSolutionLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_GAP_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasL2PGapLimit"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR, iri = "http://www.aspire-fp7.eu/akb#hasL2PFunctionSplittingCodeBlockLengthRandomizationDenominator"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL, iri = "http://www.aspire-fp7.eu/akb#hasL2PFunctionSplittingDepthLevel"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH, iri = "http://www.aspire-fp7.eu/akb#hasL2PFunctionSplittingMediumCodeBlockLength"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED, iri = "http://www.aspire-fp7.eu/akb#hasL2PFunctionSplittingSeed"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__L2P_UPPER_BOUND, iri = "http://www.aspire-fp7.eu/akb#hasL2PUpperBound"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__SET_PN_DIRECTORY, iri = "http://www.aspire-fp7.eu/akb#hasPNDirectory"),
		@MapsToDataProperty(id = AkbPackage.PREFERENCES__SET_PN_FILE, iri = "http://www.aspire-fp7.eu/akb#hasPNFile")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION, iri = "http://www.aspire-fp7.eu/akb#hasProtectionsMinimumAttackMitigation")
	}
)
public interface Preferences extends EObject
{
	/**
	 * Returns the value of the '<em><b>Working Directory</b></em>' attribute.
	 * The default value is <code>"/home/aspire/test"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The working directory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Working Directory</em>' attribute.
	 * @see #setWorkingDirectory(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_WorkingDirectory()
	 * @model default="/home/aspire/test" unique="false"
	 * @generated
	 */
	String getWorkingDirectory();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getWorkingDirectory <em>Working Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Working Directory</em>' attribute.
	 * @see #getWorkingDirectory()
	 * @generated
	 */
	void setWorkingDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Actc Configuration File</b></em>' attribute.
	 * The default value is <code>"test.json"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ACTC configuration file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actc Configuration File</em>' attribute.
	 * @see #setActcConfigurationFile(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ActcConfigurationFile()
	 * @model default="test.json" unique="false"
	 * @generated
	 */
	String getActcConfigurationFile();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getActcConfigurationFile <em>Actc Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actc Configuration File</em>' attribute.
	 * @see #getActcConfigurationFile()
	 * @generated
	 */
	void setActcConfigurationFile(String value);

	/**
	 * Returns the value of the '<em><b>Adss Patch File</b></em>' attribute.
	 * The default value is <code>"adss.patch"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ADSS patch file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adss Patch File</em>' attribute.
	 * @see #setAdssPatchFile(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_AdssPatchFile()
	 * @model default="adss.patch" unique="false"
	 * @generated
	 */
	String getAdssPatchFile();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getAdssPatchFile <em>Adss Patch File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adss Patch File</em>' attribute.
	 * @see #getAdssPatchFile()
	 * @generated
	 */
	void setAdssPatchFile(String value);

	/**
	 * Returns the value of the '<em><b>Adss JSON File</b></em>' attribute.
	 * The default value is <code>"adss.json"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ADSS json file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Adss JSON File</em>' attribute.
	 * @see #setAdssJSONFile(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_AdssJSONFile()
	 * @model default="adss.json" unique="false"
	 * @generated
	 */
	String getAdssJSONFile();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getAdssJSONFile <em>Adss JSON File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adss JSON File</em>' attribute.
	 * @see #getAdssJSONFile()
	 * @generated
	 */
	void setAdssJSONFile(String value);

	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The architecture where the project is deployed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see #setArchitecture(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_Architecture()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getArchitecture();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see #getArchitecture()
	 * @generated
	 */
	void setArchitecture(String value);

	/**
	 * Returns the value of the '<em><b>Remote Connection</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The use of a remote connection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Connection</em>' attribute.
	 * @see #setRemoteConnection(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_RemoteConnection()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isRemoteConnection();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isRemoteConnection <em>Remote Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Connection</em>' attribute.
	 * @see #isRemoteConnection()
	 * @generated
	 */
	void setRemoteConnection(boolean value);

	/**
	 * Returns the value of the '<em><b>Remote Username</b></em>' attribute.
	 * The default value is <code>"aspire"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The username for the remote server.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Username</em>' attribute.
	 * @see #setRemoteUsername(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_RemoteUsername()
	 * @model default="aspire" unique="false"
	 * @generated
	 */
	String getRemoteUsername();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteUsername <em>Remote Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Username</em>' attribute.
	 * @see #getRemoteUsername()
	 * @generated
	 */
	void setRemoteUsername(String value);

	/**
	 * Returns the value of the '<em><b>Remote Password</b></em>' attribute.
	 * The default value is <code>"aspire"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The password for the remote server.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Password</em>' attribute.
	 * @see #setRemotePassword(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_RemotePassword()
	 * @model default="aspire" unique="false"
	 * @generated
	 */
	String getRemotePassword();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getRemotePassword <em>Remote Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Password</em>' attribute.
	 * @see #getRemotePassword()
	 * @generated
	 */
	void setRemotePassword(String value);

	/**
	 * Returns the value of the '<em><b>Remote Host</b></em>' attribute.
	 * The default value is <code>"127.0.1.1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The remote host to use.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Host</em>' attribute.
	 * @see #setRemoteHost(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_RemoteHost()
	 * @model default="127.0.1.1" unique="false"
	 * @generated
	 */
	String getRemoteHost();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteHost <em>Remote Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Host</em>' attribute.
	 * @see #getRemoteHost()
	 * @generated
	 */
	void setRemoteHost(String value);

	/**
	 * Returns the value of the '<em><b>Remote Port</b></em>' attribute.
	 * The default value is <code>"3022"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The remote port to use.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote Port</em>' attribute.
	 * @see #setRemotePort(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_RemotePort()
	 * @model default="3022" unique="false"
	 * @generated
	 */
	int getRemotePort();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getRemotePort <em>Remote Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Port</em>' attribute.
	 * @see #getRemotePort()
	 * @generated
	 */
	void setRemotePort(int value);

	/**
	 * Returns the value of the '<em><b>Remote File Separator</b></em>' attribute.
	 * The default value is <code>"/"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The remote server file separator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Remote File Separator</em>' attribute.
	 * @see #setRemoteFileSeparator(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_RemoteFileSeparator()
	 * @model default="/" unique="false"
	 * @generated
	 */
	String getRemoteFileSeparator();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteFileSeparator <em>Remote File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote File Separator</em>' attribute.
	 * @see #getRemoteFileSeparator()
	 * @generated
	 */
	void setRemoteFileSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Command ACTC</b></em>' attribute.
	 * The default value is <code>"/opt/ACTC/actc.py"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ACTC command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command ACTC</em>' attribute.
	 * @see #setCommandACTC(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_CommandACTC()
	 * @model default="/opt/ACTC/actc.py" unique="false"
	 * @generated
	 */
	String getCommandACTC();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getCommandACTC <em>Command ACTC</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command ACTC</em>' attribute.
	 * @see #getCommandACTC()
	 * @generated
	 */
	void setCommandACTC(String value);

	/**
	 * Returns the value of the '<em><b>Command Perl</b></em>' attribute.
	 * The default value is <code>"/usr/bin/perl"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Perl interpreter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command Perl</em>' attribute.
	 * @see #setCommandPerl(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_CommandPerl()
	 * @model default="/usr/bin/perl" unique="false"
	 * @generated
	 */
	String getCommandPerl();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getCommandPerl <em>Command Perl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Perl</em>' attribute.
	 * @see #getCommandPerl()
	 * @generated
	 */
	void setCommandPerl(String value);

	/**
	 * Returns the value of the '<em><b>Command Dot</b></em>' attribute.
	 * The default value is <code>"/usr/bin/dot"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The dot command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Command Dot</em>' attribute.
	 * @see #setCommandDot(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_CommandDot()
	 * @model default="/usr/bin/dot" unique="false"
	 * @generated
	 */
	String getCommandDot();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getCommandDot <em>Command Dot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Dot</em>' attribute.
	 * @see #getCommandDot()
	 * @generated
	 */
	void setCommandDot(String value);

	/**
	 * Returns the value of the '<em><b>Metrics File</b></em>' attribute.
	 * The default value is <code>"gammas.db"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metrics coefficients file name or null to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics File</em>' attribute.
	 * @see #setMetricsFile(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_MetricsFile()
	 * @model default="gammas.db" unique="false"
	 * @generated
	 */
	String getMetricsFile();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getMetricsFile <em>Metrics File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics File</em>' attribute.
	 * @see #getMetricsFile()
	 * @generated
	 */
	void setMetricsFile(String value);

	/**
	 * Returns the value of the '<em><b>Parser Header Parsing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parses the header files.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parser Header Parsing</em>' attribute.
	 * @see #setParserHeaderParsing(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ParserHeaderParsing()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isParserHeaderParsing();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isParserHeaderParsing <em>Parser Header Parsing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parser Header Parsing</em>' attribute.
	 * @see #isParserHeaderParsing()
	 * @generated
	 */
	void setParserHeaderParsing(boolean value);

	/**
	 * Returns the value of the '<em><b>Parser System Files Ignoration</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ignores the system files.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parser System Files Ignoration</em>' attribute.
	 * @see #setParserSystemFilesIgnoration(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ParserSystemFilesIgnoration()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isParserSystemFilesIgnoration();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parser System Files Ignoration</em>' attribute.
	 * @see #isParserSystemFilesIgnoration()
	 * @generated
	 */
	void setParserSystemFilesIgnoration(boolean value);

	/**
	 * Returns the value of the '<em><b>Attacks Time Limit</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack finder time limit in seconds or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacks Time Limit</em>' attribute.
	 * @see #setAttacksTimeLimit(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_AttacksTimeLimit()
	 * @model default="60" unique="false"
	 * @generated
	 */
	int getAttacksTimeLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getAttacksTimeLimit <em>Attacks Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacks Time Limit</em>' attribute.
	 * @see #getAttacksTimeLimit()
	 * @generated
	 */
	void setAttacksTimeLimit(int value);

	/**
	 * Returns the value of the '<em><b>Attacks Maximum Depth</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack finder maximum search depth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacks Maximum Depth</em>' attribute.
	 * @see #setAttacksMaximumDepth(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_AttacksMaximumDepth()
	 * @model default="4" unique="false"
	 * @generated
	 */
	int getAttacksMaximumDepth();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacks Maximum Depth</em>' attribute.
	 * @see #getAttacksMaximumDepth()
	 * @generated
	 */
	void setAttacksMaximumDepth(int value);

	/**
	 * Returns the value of the '<em><b>Attacks Included Protection Objectives Removal</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Removes the included protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacks Included Protection Objectives Removal</em>' attribute.
	 * @see #setAttacksIncludedProtectionObjectivesRemoval(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_AttacksIncludedProtectionObjectivesRemoval()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isAttacksIncludedProtectionObjectivesRemoval();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacks Included Protection Objectives Removal</em>' attribute.
	 * @see #isAttacksIncludedProtectionObjectivesRemoval()
	 * @generated
	 */
	void setAttacksIncludedProtectionObjectivesRemoval(boolean value);

	/**
	 * Returns the value of the '<em><b>Protections Minimum Attack Mitigation</b></em>' attribute.
	 * The default value is <code>"medium"</code>.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum allowed mitigation level for a protection to be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protections Minimum Attack Mitigation</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @see #setProtectionsMinimumAttackMitigation(Level)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ProtectionsMinimumAttackMitigation()
	 * @model default="medium" unique="false"
	 * @generated
	 */
	Level getProtectionsMinimumAttackMitigation();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protections Minimum Attack Mitigation</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @see #getProtectionsMinimumAttackMitigation()
	 * @generated
	 */
	void setProtectionsMinimumAttackMitigation(Level value);

	/**
	 * Returns the value of the '<em><b>Client Time Overhead</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client time overhead in percentage w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #setClientTimeOverhead(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ClientTimeOverhead()
	 * @model default="10" unique="false"
	 * @generated
	 */
	double getClientTimeOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getClientTimeOverhead <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #getClientTimeOverhead()
	 * @generated
	 */
	void setClientTimeOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Server Time Overhead</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server time overhead in percentage w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #setServerTimeOverhead(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ServerTimeOverhead()
	 * @model default="10" unique="false"
	 * @generated
	 */
	double getServerTimeOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getServerTimeOverhead <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #getServerTimeOverhead()
	 * @generated
	 */
	void setServerTimeOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Client Memory Overhead</b></em>' attribute.
	 * The default value is <code>"1024"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client memory overhead in bytes w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #setClientMemoryOverhead(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ClientMemoryOverhead()
	 * @model default="1024" unique="false"
	 * @generated
	 */
	int getClientMemoryOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getClientMemoryOverhead <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #getClientMemoryOverhead()
	 * @generated
	 */
	void setClientMemoryOverhead(int value);

	/**
	 * Returns the value of the '<em><b>Server Memory Overhead</b></em>' attribute.
	 * The default value is <code>"1024"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server memory overhead in bytes w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #setServerMemoryOverhead(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_ServerMemoryOverhead()
	 * @model default="1024" unique="false"
	 * @generated
	 */
	int getServerMemoryOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getServerMemoryOverhead <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #getServerMemoryOverhead()
	 * @generated
	 */
	void setServerMemoryOverhead(int value);

	/**
	 * Returns the value of the '<em><b>Network Overhead</b></em>' attribute.
	 * The default value is <code>"1024"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The network overhead in bytes per second w.r.t. to the vanilla application.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Network Overhead</em>' attribute.
	 * @see #setNetworkOverhead(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_NetworkOverhead()
	 * @model default="1024" unique="false"
	 * @generated
	 */
	int getNetworkOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getNetworkOverhead <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network Overhead</em>' attribute.
	 * @see #getNetworkOverhead()
	 * @generated
	 */
	void setNetworkOverhead(int value);

	/**
	 * Returns the value of the '<em><b>L1p Solutions Count</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of solutions to find.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Solutions Count</em>' attribute.
	 * @see #setL1pSolutionsCount(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pSolutionsCount()
	 * @model default="10" unique="false"
	 * @generated
	 */
	int getL1pSolutionsCount();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsCount <em>L1p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Solutions Count</em>' attribute.
	 * @see #getL1pSolutionsCount()
	 * @generated
	 */
	void setL1pSolutionsCount(int value);

	/**
	 * Returns the value of the '<em><b>L1p Petri Nets Pass</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Performs an additional Petri Nets pass on the found solutions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Petri Nets Pass</em>' attribute.
	 * @see #setL1pPetriNetsPass(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pPetriNetsPass()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isL1pPetriNetsPass();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pPetriNetsPass <em>L1p Petri Nets Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Petri Nets Pass</em>' attribute.
	 * @see #isL1pPetriNetsPass()
	 * @generated
	 */
	void setL1pPetriNetsPass(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Time Limit</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tim limit in seconds or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Time Limit</em>' attribute.
	 * @see #setL1pTimeLimit(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pTimeLimit()
	 * @model default="60" unique="false"
	 * @generated
	 */
	int getL1pTimeLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pTimeLimit <em>L1p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Time Limit</em>' attribute.
	 * @see #getL1pTimeLimit()
	 * @generated
	 */
	void setL1pTimeLimit(int value);

	/**
	 * Returns the value of the '<em><b>L1p Solutions Limit</b></em>' attribute.
	 * The default value is <code>"-10000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of solutions to explore or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Solutions Limit</em>' attribute.
	 * @see #setL1pSolutionsLimit(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pSolutionsLimit()
	 * @model default="-10000" unique="false"
	 * @generated
	 */
	int getL1pSolutionsLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Solutions Limit</em>' attribute.
	 * @see #getL1pSolutionsLimit()
	 * @generated
	 */
	void setL1pSolutionsLimit(int value);

	/**
	 * Returns the value of the '<em><b>L1p Gap Limit</b></em>' attribute.
	 * The default value is <code>"-10.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The gap limit or a non-positive value to disable it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Gap Limit</em>' attribute.
	 * @see #setL1pGapLimit(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pGapLimit()
	 * @model default="-10.0" unique="false"
	 * @generated
	 */
	double getL1pGapLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pGapLimit <em>L1p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Gap Limit</em>' attribute.
	 * @see #getL1pGapLimit()
	 * @generated
	 */
	void setL1pGapLimit(double value);

	/**
	 * Returns the value of the '<em><b>L1p Client Time Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the client time overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Client Time Overhead Percentage</em>' attribute.
	 * @see #setL1pClientTimeOverheadPercentage(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pClientTimeOverheadPercentage()
	 * @model default="50" unique="false"
	 * @generated
	 */
	double getL1pClientTimeOverheadPercentage();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Client Time Overhead Percentage</em>' attribute.
	 * @see #getL1pClientTimeOverheadPercentage()
	 * @generated
	 */
	void setL1pClientTimeOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Server Time Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the server time overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Server Time Overhead Percentage</em>' attribute.
	 * @see #setL1pServerTimeOverheadPercentage(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pServerTimeOverheadPercentage()
	 * @model default="50" unique="false"
	 * @generated
	 */
	double getL1pServerTimeOverheadPercentage();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Server Time Overhead Percentage</em>' attribute.
	 * @see #getL1pServerTimeOverheadPercentage()
	 * @generated
	 */
	void setL1pServerTimeOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Client Memory Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the client memory overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Client Memory Overhead Percentage</em>' attribute.
	 * @see #setL1pClientMemoryOverheadPercentage(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pClientMemoryOverheadPercentage()
	 * @model default="50" unique="false"
	 * @generated
	 */
	double getL1pClientMemoryOverheadPercentage();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Client Memory Overhead Percentage</em>' attribute.
	 * @see #getL1pClientMemoryOverheadPercentage()
	 * @generated
	 */
	void setL1pClientMemoryOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Server Memory Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the server memory overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Server Memory Overhead Percentage</em>' attribute.
	 * @see #setL1pServerMemoryOverheadPercentage(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pServerMemoryOverheadPercentage()
	 * @model default="50" unique="false"
	 * @generated
	 */
	double getL1pServerMemoryOverheadPercentage();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Server Memory Overhead Percentage</em>' attribute.
	 * @see #getL1pServerMemoryOverheadPercentage()
	 * @generated
	 */
	void setL1pServerMemoryOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Network Overhead Percentage</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage of the network overhead to use or a non-positive value to ignore the overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Network Overhead Percentage</em>' attribute.
	 * @see #setL1pNetworkOverheadPercentage(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pNetworkOverheadPercentage()
	 * @model default="50" unique="false"
	 * @generated
	 */
	double getL1pNetworkOverheadPercentage();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Network Overhead Percentage</em>' attribute.
	 * @see #getL1pNetworkOverheadPercentage()
	 * @generated
	 */
	void setL1pNetworkOverheadPercentage(double value);

	/**
	 * Returns the value of the '<em><b>L1p Discouraged Precedences Ignoration</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ignores the discouraged precedences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Discouraged Precedences Ignoration</em>' attribute.
	 * @see #setL1pDiscouragedPrecedencesIgnoration(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pDiscouragedPrecedencesIgnoration()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pDiscouragedPrecedencesIgnoration();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Discouraged Precedences Ignoration</em>' attribute.
	 * @see #isL1pDiscouragedPrecedencesIgnoration()
	 * @generated
	 */
	void setL1pDiscouragedPrecedencesIgnoration(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Encouraged Precedences Focusing</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Focuses only on the encouraged precedences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Encouraged Precedences Focusing</em>' attribute.
	 * @see #setL1pEncouragedPrecedencesFocusing(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pEncouragedPrecedencesFocusing()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pEncouragedPrecedencesFocusing();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Encouraged Precedences Focusing</em>' attribute.
	 * @see #isL1pEncouragedPrecedencesFocusing()
	 * @generated
	 */
	void setL1pEncouragedPrecedencesFocusing(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Use ACTC Precedences</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Uses the ACTC precedences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Use ACTC Precedences</em>' attribute.
	 * @see #setL1pUseACTCPrecedences(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pUseACTCPrecedences()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pUseACTCPrecedences();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Use ACTC Precedences</em>' attribute.
	 * @see #isL1pUseACTCPrecedences()
	 * @generated
	 */
	void setL1pUseACTCPrecedences(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Ignore Application Part Order</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Ignores the application part order.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Ignore Application Part Order</em>' attribute.
	 * @see #setL1pIgnoreApplicationPartOrder(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pIgnoreApplicationPartOrder()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pIgnoreApplicationPartOrder();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Ignore Application Part Order</em>' attribute.
	 * @see #isL1pIgnoreApplicationPartOrder()
	 * @generated
	 */
	void setL1pIgnoreApplicationPartOrder(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Maximum Instantiations Per Protection Objective</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number o1 instantiations per protection objective or <code>null</code> for infinity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Maximum Instantiations Per Protection Objective</em>' attribute.
	 * @see #setL1pMaximumInstantiationsPerProtectionObjective(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pMaximumInstantiationsPerProtectionObjective()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getL1pMaximumInstantiationsPerProtectionObjective();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Maximum Instantiations Per Protection Objective</em>' attribute.
	 * @see #getL1pMaximumInstantiationsPerProtectionObjective()
	 * @generated
	 */
	void setL1pMaximumInstantiationsPerProtectionObjective(int value);

	/**
	 * Returns the value of the '<em><b>L1p Main Search Maximum Depth</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The main search maximum depth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Main Search Maximum Depth</em>' attribute.
	 * @see #setL1pMainSearchMaximumDepth(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pMainSearchMaximumDepth()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getL1pMainSearchMaximumDepth();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Main Search Maximum Depth</em>' attribute.
	 * @see #getL1pMainSearchMaximumDepth()
	 * @generated
	 */
	void setL1pMainSearchMaximumDepth(int value);

	/**
	 * Returns the value of the '<em><b>L1p Multi Tree</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Uses a minimax tree for each code correlation set.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Multi Tree</em>' attribute.
	 * @see #setL1pMultiTree(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pMultiTree()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isL1pMultiTree();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pMultiTree <em>L1p Multi Tree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Multi Tree</em>' attribute.
	 * @see #isL1pMultiTree()
	 * @generated
	 */
	void setL1pMultiTree(boolean value);

	/**
	 * Returns the value of the '<em><b>L1p Initial Alpha</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The initial alpha value or <code>NaN</code> for infinity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Initial Alpha</em>' attribute.
	 * @see #setL1pInitialAlpha(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pInitialAlpha()
	 * @model default="0" unique="false"
	 * @generated
	 */
	double getL1pInitialAlpha();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pInitialAlpha <em>L1p Initial Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Initial Alpha</em>' attribute.
	 * @see #getL1pInitialAlpha()
	 * @generated
	 */
	void setL1pInitialAlpha(double value);

	/**
	 * Returns the value of the '<em><b>L1p Initial Beta</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The initial beta value or <code>NaN</code> for infinity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Initial Beta</em>' attribute.
	 * @see #setL1pInitialBeta(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pInitialBeta()
	 * @model default="5" unique="false"
	 * @generated
	 */
	double getL1pInitialBeta();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pInitialBeta <em>L1p Initial Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Initial Beta</em>' attribute.
	 * @see #getL1pInitialBeta()
	 * @generated
	 */
	void setL1pInitialBeta(double value);

	/**
	 * Returns the value of the '<em><b>L1p Research Delta</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The research base delta.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Research Delta</em>' attribute.
	 * @see #setL1pResearchDelta(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pResearchDelta()
	 * @model default="1.0" unique="false"
	 * @generated
	 */
	double getL1pResearchDelta();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pResearchDelta <em>L1p Research Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Research Delta</em>' attribute.
	 * @see #getL1pResearchDelta()
	 * @generated
	 */
	void setL1pResearchDelta(double value);

	/**
	 * Returns the value of the '<em><b>L1p Transposition Table Maximum Size</b></em>' attribute.
	 * The default value is <code>"1000000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The transposition table maximum size or a non-positive value to disable them.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Transposition Table Maximum Size</em>' attribute.
	 * @see #setL1pTranspositionTableMaximumSize(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L1pTranspositionTableMaximumSize()
	 * @model default="1000000" unique="false"
	 * @generated
	 */
	int getL1pTranspositionTableMaximumSize();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Transposition Table Maximum Size</em>' attribute.
	 * @see #getL1pTranspositionTableMaximumSize()
	 * @generated
	 */
	void setL1pTranspositionTableMaximumSize(int value);

	/**
	 * Returns the value of the '<em><b>L2p Solutions Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of the best first level solution on which the second level solution is inferred with the automatic build
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Solutions Count</em>' attribute.
	 * @see #setL2pSolutionsCount(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pSolutionsCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getL2pSolutionsCount();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionsCount <em>L2p Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Solutions Count</em>' attribute.
	 * @see #getL2pSolutionsCount()
	 * @generated
	 */
	void setL2pSolutionsCount(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Seed</b></em>' attribute.
	 * The default value is <code>"1106103861"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The seed to generate random function splitting, <=0 for casual seed
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Seed</em>' attribute.
	 * @see #setL2pFunctionSplittingSeed(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pFunctionSplittingSeed()
	 * @model default="1106103861" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingSeed();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Seed</em>' attribute.
	 * @see #getL2pFunctionSplittingSeed()
	 * @generated
	 */
	void setL2pFunctionSplittingSeed(int value);

	/**
	 * Returns the value of the '<em><b>L2p Solution Limit</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of solutions of the second level solution MIP model to be found, <=0 for no solution limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Solution Limit</em>' attribute.
	 * @see #setL2pSolutionLimit(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pSolutionLimit()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getL2pSolutionLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionLimit <em>L2p Solution Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Solution Limit</em>' attribute.
	 * @see #getL2pSolutionLimit()
	 * @generated
	 */
	void setL2pSolutionLimit(int value);

	/**
	 * Returns the value of the '<em><b>L2p Time Limit</b></em>' attribute.
	 * The default value is <code>"60"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The time limit to solve the second level solution MIP model, <=0 for no time limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Time Limit</em>' attribute.
	 * @see #setL2pTimeLimit(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pTimeLimit()
	 * @model default="60" unique="false"
	 * @generated
	 */
	int getL2pTimeLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pTimeLimit <em>L2p Time Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Time Limit</em>' attribute.
	 * @see #getL2pTimeLimit()
	 * @generated
	 */
	void setL2pTimeLimit(int value);

	/**
	 * Returns the value of the '<em><b>L2p Gap Limit</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The gap (relative distance between the actual solution and the possible best solution) limit to solve the second level solution MIP model, <=0 for no gap limit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Gap Limit</em>' attribute.
	 * @see #setL2pGapLimit(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pGapLimit()
	 * @model default="0" unique="false"
	 * @generated
	 */
	double getL2pGapLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pGapLimit <em>L2p Gap Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Gap Limit</em>' attribute.
	 * @see #getL2pGapLimit()
	 * @generated
	 */
	void setL2pGapLimit(double value);

	/**
	 * Returns the value of the '<em><b>L2p Upper Bound</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The maximum number of time a non singleton protection instantiation can be applied to an application part
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Upper Bound</em>' attribute.
	 * @see #setL2pUpperBound(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pUpperBound()
	 * @model default="2" unique="false"
	 * @generated
	 */
	int getL2pUpperBound();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pUpperBound <em>L2p Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Upper Bound</em>' attribute.
	 * @see #getL2pUpperBound()
	 * @generated
	 */
	void setL2pUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Medium Code Block Length</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum length that a code block must have in order to be further splitted, <= 0 in order to generate an application part for every code block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Medium Code Block Length</em>' attribute.
	 * @see #setL2pFunctionSplittingMediumCodeBlockLength(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pFunctionSplittingMediumCodeBlockLength()
	 * @model default="2" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingMediumCodeBlockLength();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Medium Code Block Length</em>' attribute.
	 * @see #getL2pFunctionSplittingMediumCodeBlockLength()
	 * @generated
	 */
	void setL2pFunctionSplittingMediumCodeBlockLength(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Code Block Length Randomization Denominator</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a value > 0 is passed, the length of the generated blocks will be random between (minimumCodeBlockLength-+inf(minimumCodeBlockLength/codeBlockLengthRandomizationDenominator)), otherwise all the generated blocks will be long at most minimumCodeBlockLength lines; in any case the last block generated may be less long than the specified interval.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Code Block Length Randomization Denominator</em>' attribute.
	 * @see #setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @model default="2" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Code Block Length Randomization Denominator</em>' attribute.
	 * @see #getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @generated
	 */
	void setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(int value);

	/**
	 * Returns the value of the '<em><b>L2p Function Splitting Depth Level</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The desired function splitting depth level, <=0 for no limit on depth level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Function Splitting Depth Level</em>' attribute.
	 * @see #setL2pFunctionSplittingDepthLevel(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_L2pFunctionSplittingDepthLevel()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getL2pFunctionSplittingDepthLevel();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Function Splitting Depth Level</em>' attribute.
	 * @see #getL2pFunctionSplittingDepthLevel()
	 * @generated
	 */
	void setL2pFunctionSplittingDepthLevel(int value);

	/**
	 * Returns the value of the '<em><b>Set PN Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Petri nets directory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Set PN Directory</em>' attribute.
	 * @see #setSetPNDirectory(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_SetPNDirectory()
	 * @model unique="false"
	 * @generated
	 */
	String getSetPNDirectory();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getSetPNDirectory <em>Set PN Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set PN Directory</em>' attribute.
	 * @see #getSetPNDirectory()
	 * @generated
	 */
	void setSetPNDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Set PN File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Petri nets file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Set PN File</em>' attribute.
	 * @see #setSetPNFile(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getPreferences_SetPNFile()
	 * @model unique="false"
	 * @generated
	 */
	String getSetPNFile();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Preferences#getSetPNFile <em>Set PN File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set PN File</em>' attribute.
	 * @see #getSetPNFile()
	 * @generated
	 */
	void setSetPNFile(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\nint _hashCode = \"preferences\".hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.Preferences%>))\n\t{\n\t\treturn (this == object);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // Preferences
