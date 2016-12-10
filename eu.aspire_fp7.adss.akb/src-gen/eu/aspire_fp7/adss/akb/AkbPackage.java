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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='eu.aspire_fp7.adss'"
 * @generated
 */
public interface AkbPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "akb";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "eu.aspire_fp7.adss.akb";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "akb";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AkbPackage eINSTANCE = eu.aspire_fp7.adss.akb.impl.AkbPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ModelImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Ontology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ONTOLOGY = 0;

	/**
	 * The feature id for the '<em><b>Application Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__APPLICATION_PARTS = 1;

	/**
	 * The feature id for the '<em><b>Application Part Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__APPLICATION_PART_SETS = 2;

	/**
	 * The feature id for the '<em><b>Attack Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACK_PATHS = 3;

	/**
	 * The feature id for the '<em><b>Attack Step Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACK_STEP_TYPES = 4;

	/**
	 * The feature id for the '<em><b>Attack Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACK_STEPS = 5;

	/**
	 * The feature id for the '<em><b>Protections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PROTECTIONS = 6;

	/**
	 * The feature id for the '<em><b>Preferences</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PREFERENCES = 7;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__RULES = 8;

	/**
	 * The feature id for the '<em><b>Protection Objectives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PROTECTION_OBJECTIVES = 9;

	/**
	 * The feature id for the '<em><b>Applied Protection Instantiations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__APPLIED_PROTECTION_INSTANTIATIONS = 10;

	/**
	 * The feature id for the '<em><b>Available Protections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_PROTECTIONS = 11;

	/**
	 * The feature id for the '<em><b>Available Second Level Protections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_SECOND_LEVEL_PROTECTIONS = 12;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ASSETS = 13;

	/**
	 * The feature id for the '<em><b>Attacker</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACKER = 14;

	/**
	 * The feature id for the '<em><b>Attacker Tool Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACKER_TOOL_TYPES = 15;

	/**
	 * The feature id for the '<em><b>Attacker Tools</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACKER_TOOLS = 16;

	/**
	 * The feature id for the '<em><b>Vanilla Solution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__VANILLA_SOLUTION = 17;

	/**
	 * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SOLUTIONS = 18;

	/**
	 * The feature id for the '<em><b>Available Tools</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_TOOLS = 19;

	/**
	 * The feature id for the '<em><b>Application Parts Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__APPLICATION_PARTS_COUNT = 20;

	/**
	 * The feature id for the '<em><b>All Application Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ALL_APPLICATION_PARTS = 21;

	/**
	 * The feature id for the '<em><b>Assets Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ASSETS_COUNT = 22;

	/**
	 * The feature id for the '<em><b>Data Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DATA_COUNT = 23;

	/**
	 * The feature id for the '<em><b>Codes Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CODES_COUNT = 24;

	/**
	 * The feature id for the '<em><b>Protections Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PROTECTIONS_COUNT = 25;

	/**
	 * The feature id for the '<em><b>Attacker Tools Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACKER_TOOLS_COUNT = 26;

	/**
	 * The feature id for the '<em><b>Attacker Tool Types Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACKER_TOOL_TYPES_COUNT = 27;

	/**
	 * The feature id for the '<em><b>Available Attacker Tools Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_ATTACKER_TOOLS_COUNT = 28;

	/**
	 * The feature id for the '<em><b>Available Protections Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AVAILABLE_PROTECTIONS_COUNT = 29;

	/**
	 * The feature id for the '<em><b>Attack Paths Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACK_PATHS_COUNT = 30;

	/**
	 * The feature id for the '<em><b>Attack Steps Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACK_STEPS_COUNT = 31;

	/**
	 * The feature id for the '<em><b>Attack Step Types Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACK_STEP_TYPES_COUNT = 32;

	/**
	 * The feature id for the '<em><b>Protection Objectives Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PROTECTION_OBJECTIVES_COUNT = 33;

	/**
	 * The feature id for the '<em><b>Applied Protection Instantiations Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__APPLIED_PROTECTION_INSTANTIATIONS_COUNT = 34;

	/**
	 * The feature id for the '<em><b>Protection Instantiations Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PROTECTION_INSTANTIATIONS_COUNT = 35;

	/**
	 * The feature id for the '<em><b>Solutions Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SOLUTIONS_COUNT = 36;

	/**
	 * The feature id for the '<em><b>Key Attack Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__KEY_ATTACK_PATHS = 37;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 38;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl <em>Application Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPart()
	 * @generated
	 */
	int APPLICATION_PART = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__NAME = 1;

	/**
	 * The feature id for the '<em><b>Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__SETS = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__INDEX = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__SOURCE_FILE_PATH = 6;

	/**
	 * The feature id for the '<em><b>Declaring Code</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__DECLARING_CODE = 7;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__START_LINE = 8;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__END_LINE = 9;

	/**
	 * The feature id for the '<em><b>Datum Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__DATUM_SIZE = 10;

	/**
	 * The feature id for the '<em><b>In System File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__IN_SYSTEM_FILE = 11;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__GLOBAL = 12;

	/**
	 * The feature id for the '<em><b>Short Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__SHORT_LOCATION = 13;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__WEIGHT = 14;

	/**
	 * The feature id for the '<em><b>Security Properties</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__SECURITY_PROPERTIES = 15;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__PARAMETERS = 16;

	/**
	 * The feature id for the '<em><b>Asset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__ASSET = 17;

	/**
	 * The feature id for the '<em><b>Application Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__APPLICATION_PARTS = 18;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__USES = 19;

	/**
	 * The feature id for the '<em><b>Target Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__TARGET_OF = 20;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__BODY = 21;

	/**
	 * The feature id for the '<em><b>Application Parts Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__APPLICATION_PARTS_COUNT = 22;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART__ASSETS = 23;

	/**
	 * The number of structural features of the '<em>Application Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_FEATURE_COUNT = 24;

	/**
	 * The operation id for the '<em>Contains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___CONTAINS__APPLICATIONPART = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___HASH_CODE = 1;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___EQUALS__OBJECT = 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___TO_STRING = 3;

	/**
	 * The operation id for the '<em>Is Datum</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___IS_DATUM = 4;

	/**
	 * The operation id for the '<em>Is Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___IS_CODE = 5;

	/**
	 * The operation id for the '<em>Contains Asset</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART___CONTAINS_ASSET = 6;

	/**
	 * The number of operations of the '<em>Application Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_OPERATION_COUNT = 7;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl <em>Use Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.UseTargetImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getUseTarget()
	 * @generated
	 */
	int USE_TARGET = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Used By</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET__USED_BY = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET__LINE = 2;

	/**
	 * The feature id for the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET__SOURCE_FILE_PATH = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET__PARAMETERS = 5;

	/**
	 * The number of structural features of the '<em>Use Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Use Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_TARGET_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackStepImpl <em>Attack Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackStepImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackStep()
	 * @generated
	 */
	int ATTACK_STEP = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP__FORMULA = 2;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP__TRANSITION = 3;

	/**
	 * The number of structural features of the '<em>Attack Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Attack Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackStepTypeImpl <em>Attack Step Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackStepTypeImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackStepType()
	 * @generated
	 */
	int ATTACK_STEP_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE__REGEX = 1;

	/**
	 * The feature id for the '<em><b>Attacker Tools</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE__ATTACKER_TOOLS = 2;

	/**
	 * The number of structural features of the '<em>Attack Step Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Attack Step Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_STEP_TYPE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackPathImpl <em>Attack Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackPathImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackPath()
	 * @generated
	 */
	int ATTACK_PATH = 5;

	/**
	 * The feature id for the '<em><b>Attack Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__ATTACK_STEPS = 0;

	/**
	 * The feature id for the '<em><b>Protection Objectives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__PROTECTION_OBJECTIVES = 1;

	/**
	 * The feature id for the '<em><b>Attacker Tool Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__ATTACKER_TOOL_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__COST = 3;

	/**
	 * The feature id for the '<em><b>Applied Protection Instantiations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__KEY = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__ID = 6;

	/**
	 * The feature id for the '<em><b>Mitigations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__MITIGATIONS = 7;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH__LEVEL = 8;

	/**
	 * The number of structural features of the '<em>Attack Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH_FEATURE_COUNT = 9;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Attack Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_PATH_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl <em>Attack Mitigation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackMitigation()
	 * @generated
	 */
	int ATTACK_MITIGATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION__LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Attack Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION__ATTACK_PATHS = 3;

	/**
	 * The feature id for the '<em><b>Protection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION__PROTECTION = 4;

	/**
	 * The number of structural features of the '<em>Attack Mitigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Attack Mitigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_MITIGATION_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ProtectionImpl <em>Protection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ProtectionImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtection()
	 * @generated
	 */
	int PROTECTION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__ENABLED = 2;

	/**
	 * The feature id for the '<em><b>Automatically Deployable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__AUTOMATICALLY_DEPLOYABLE = 3;

	/**
	 * The feature id for the '<em><b>Second Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__SECOND_LEVEL = 4;

	/**
	 * The feature id for the '<em><b>Second Level Enlargment Usefulness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS = 5;

	/**
	 * The feature id for the '<em><b>Second Level Call Graph Enlargment Usefulness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS = 6;

	/**
	 * The feature id for the '<em><b>Second Level Repetition Usefulness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS = 7;

	/**
	 * The feature id for the '<em><b>Second Level Repetition Instantiation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION = 8;

	/**
	 * The feature id for the '<em><b>Application Part Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__APPLICATION_PART_TYPES = 9;

	/**
	 * The feature id for the '<em><b>Mitigations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__MITIGATIONS = 10;

	/**
	 * The feature id for the '<em><b>Enforced Security Requirements</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__ENFORCED_SECURITY_REQUIREMENTS = 11;

	/**
	 * The feature id for the '<em><b>Forbidden Precedences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__FORBIDDEN_PRECEDENCES = 12;

	/**
	 * The feature id for the '<em><b>Discouraged Precedences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__DISCOURAGED_PRECEDENCES = 13;

	/**
	 * The feature id for the '<em><b>Encouraged Precedences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__ENCOURAGED_PRECEDENCES = 14;

	/**
	 * The feature id for the '<em><b>Actc Precedences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__ACTC_PRECEDENCES = 15;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__SINGLETON = 16;

	/**
	 * The feature id for the '<em><b>Defeated Attacker Tool Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES = 17;

	/**
	 * The feature id for the '<em><b>Blocked Attacker Tool Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES = 18;

	/**
	 * The feature id for the '<em><b>Instantiations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__INSTANTIATIONS = 19;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__ACTIONS = 20;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__FLAGS = 21;

	/**
	 * The feature id for the '<em><b>Instantiations Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION__INSTANTIATIONS_COUNT = 22;

	/**
	 * The number of structural features of the '<em>Protection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_FEATURE_COUNT = 23;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Protection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl <em>Protection Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtectionInstantiation()
	 * @generated
	 */
	int PROTECTION_INSTANTIATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Protection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__PROTECTION = 1;

	/**
	 * The feature id for the '<em><b>Variable Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Code Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__CODE_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Verifier Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>Attestator Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION = 5;

	/**
	 * The feature id for the '<em><b>Client Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD = 6;

	/**
	 * The feature id for the '<em><b>Server Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD = 7;

	/**
	 * The feature id for the '<em><b>Client Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD = 8;

	/**
	 * The feature id for the '<em><b>Server Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD = 9;

	/**
	 * The feature id for the '<em><b>Network Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION__NETWORK_OVERHEAD = 10;

	/**
	 * The number of structural features of the '<em>Protection Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION_FEATURE_COUNT = 11;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Protection Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_INSTANTIATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackerImpl <em>Attacker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackerImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttacker()
	 * @generated
	 */
	int ATTACKER = 9;

	/**
	 * The feature id for the '<em><b>Expertise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER__EXPERTISE = 0;

	/**
	 * The feature id for the '<em><b>Budget Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER__BUDGET_LIMIT = 1;

	/**
	 * The number of structural features of the '<em>Attacker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Attacker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl <em>Attacker Tool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackerToolImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackerTool()
	 * @generated
	 */
	int ATTACKER_TOOL = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL__TYPES = 1;

	/**
	 * The feature id for the '<em><b>Expertise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL__EXPERTISE = 2;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL__COST = 3;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL__ENABLED = 4;

	/**
	 * The number of structural features of the '<em>Attacker Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Attacker Tool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AttackerToolTypeImpl <em>Attacker Tool Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AttackerToolTypeImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackerToolType()
	 * @generated
	 */
	int ATTACKER_TOOL_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Attacker Tool Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_TYPE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_TYPE___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_TYPE___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_TYPE___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Attacker Tool Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACKER_TOOL_TYPE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl <em>Preferences</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.PreferencesImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getPreferences()
	 * @generated
	 */
	int PREFERENCES = 12;

	/**
	 * The feature id for the '<em><b>Working Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__WORKING_DIRECTORY = 0;

	/**
	 * The feature id for the '<em><b>Actc Configuration File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ACTC_CONFIGURATION_FILE = 1;

	/**
	 * The feature id for the '<em><b>Adss Patch File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ADSS_PATCH_FILE = 2;

	/**
	 * The feature id for the '<em><b>Adss JSON File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ADSS_JSON_FILE = 3;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ARCHITECTURE = 4;

	/**
	 * The feature id for the '<em><b>Remote Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__REMOTE_CONNECTION = 5;

	/**
	 * The feature id for the '<em><b>Remote Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__REMOTE_USERNAME = 6;

	/**
	 * The feature id for the '<em><b>Remote Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__REMOTE_PASSWORD = 7;

	/**
	 * The feature id for the '<em><b>Remote Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__REMOTE_HOST = 8;

	/**
	 * The feature id for the '<em><b>Remote Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__REMOTE_PORT = 9;

	/**
	 * The feature id for the '<em><b>Remote File Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__REMOTE_FILE_SEPARATOR = 10;

	/**
	 * The feature id for the '<em><b>Command ACTC</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__COMMAND_ACTC = 11;

	/**
	 * The feature id for the '<em><b>Command Perl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__COMMAND_PERL = 12;

	/**
	 * The feature id for the '<em><b>Command Dot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__COMMAND_DOT = 13;

	/**
	 * The feature id for the '<em><b>Metrics File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__METRICS_FILE = 14;

	/**
	 * The feature id for the '<em><b>Parser Header Parsing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__PARSER_HEADER_PARSING = 15;

	/**
	 * The feature id for the '<em><b>Parser System Files Ignoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION = 16;

	/**
	 * The feature id for the '<em><b>Attacks Time Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ATTACKS_TIME_LIMIT = 17;

	/**
	 * The feature id for the '<em><b>Attacks Maximum Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ATTACKS_MAXIMUM_DEPTH = 18;

	/**
	 * The feature id for the '<em><b>Attacks Included Protection Objectives Removal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL = 19;

	/**
	 * The feature id for the '<em><b>Protections Minimum Attack Mitigation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION = 20;

	/**
	 * The feature id for the '<em><b>Client Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__CLIENT_TIME_OVERHEAD = 21;

	/**
	 * The feature id for the '<em><b>Server Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__SERVER_TIME_OVERHEAD = 22;

	/**
	 * The feature id for the '<em><b>Client Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__CLIENT_MEMORY_OVERHEAD = 23;

	/**
	 * The feature id for the '<em><b>Server Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__SERVER_MEMORY_OVERHEAD = 24;

	/**
	 * The feature id for the '<em><b>Network Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__NETWORK_OVERHEAD = 25;

	/**
	 * The feature id for the '<em><b>L1p Solutions Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_SOLUTIONS_COUNT = 26;

	/**
	 * The feature id for the '<em><b>L1p Petri Nets Pass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_PETRI_NETS_PASS = 27;

	/**
	 * The feature id for the '<em><b>L1p Time Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_TIME_LIMIT = 28;

	/**
	 * The feature id for the '<em><b>L1p Solutions Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_SOLUTIONS_LIMIT = 29;

	/**
	 * The feature id for the '<em><b>L1p Gap Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_GAP_LIMIT = 30;

	/**
	 * The feature id for the '<em><b>L1p Client Time Overhead Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE = 31;

	/**
	 * The feature id for the '<em><b>L1p Server Time Overhead Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE = 32;

	/**
	 * The feature id for the '<em><b>L1p Client Memory Overhead Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE = 33;

	/**
	 * The feature id for the '<em><b>L1p Server Memory Overhead Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE = 34;

	/**
	 * The feature id for the '<em><b>L1p Network Overhead Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE = 35;

	/**
	 * The feature id for the '<em><b>L1p Discouraged Precedences Ignoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION = 36;

	/**
	 * The feature id for the '<em><b>L1p Encouraged Precedences Focusing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING = 37;

	/**
	 * The feature id for the '<em><b>L1p Use ACTC Precedences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_USE_ACTC_PRECEDENCES = 38;

	/**
	 * The feature id for the '<em><b>L1p Ignore Application Part Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER = 39;

	/**
	 * The feature id for the '<em><b>L1p Maximum Instantiations Per Protection Objective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE = 40;

	/**
	 * The feature id for the '<em><b>L1p Main Search Maximum Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH = 41;

	/**
	 * The feature id for the '<em><b>L1p Multi Tree</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_MULTI_TREE = 42;

	/**
	 * The feature id for the '<em><b>L1p Initial Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_INITIAL_ALPHA = 43;

	/**
	 * The feature id for the '<em><b>L1p Initial Beta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_INITIAL_BETA = 44;

	/**
	 * The feature id for the '<em><b>L1p Research Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_RESEARCH_DELTA = 45;

	/**
	 * The feature id for the '<em><b>L1p Transposition Table Maximum Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE = 46;

	/**
	 * The feature id for the '<em><b>L2p Solutions Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_SOLUTIONS_COUNT = 47;

	/**
	 * The feature id for the '<em><b>L2p Function Splitting Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_FUNCTION_SPLITTING_SEED = 48;

	/**
	 * The feature id for the '<em><b>L2p Solution Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_SOLUTION_LIMIT = 49;

	/**
	 * The feature id for the '<em><b>L2p Time Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_TIME_LIMIT = 50;

	/**
	 * The feature id for the '<em><b>L2p Gap Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_GAP_LIMIT = 51;

	/**
	 * The feature id for the '<em><b>L2p Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_UPPER_BOUND = 52;

	/**
	 * The feature id for the '<em><b>L2p Function Splitting Medium Code Block Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH = 53;

	/**
	 * The feature id for the '<em><b>L2p Function Splitting Code Block Length Randomization Denominator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR = 54;

	/**
	 * The feature id for the '<em><b>L2p Function Splitting Depth Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL = 55;

	/**
	 * The feature id for the '<em><b>Set PN Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__SET_PN_DIRECTORY = 56;

	/**
	 * The feature id for the '<em><b>Set PN File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__SET_PN_FILE = 57;

	/**
	 * The number of structural features of the '<em>Preferences</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_FEATURE_COUNT = 58;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Preferences</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl <em>Applied Protection Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAppliedProtectionInstantiation()
	 * @generated
	 */
	int APPLIED_PROTECTION_INSTANTIATION = 13;

	/**
	 * The feature id for the '<em><b>Protection Instantiation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION = 0;

	/**
	 * The feature id for the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART = 1;

	/**
	 * The feature id for the '<em><b>Protection Objectives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES = 2;

	/**
	 * The feature id for the '<em><b>Attack Mitigations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS = 3;

	/**
	 * The feature id for the '<em><b>Second Level Motivation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION = 4;

	/**
	 * The number of structural features of the '<em>Applied Protection Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION___TO_STRING = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION___HASH_CODE = 1;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION___EQUALS__OBJECT = 2;

	/**
	 * The number of operations of the '<em>Applied Protection Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLIED_PROTECTION_INSTANTIATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.SecondLevelMotivationImpl <em>Second Level Motivation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.SecondLevelMotivationImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSecondLevelMotivation()
	 * @generated
	 */
	int SECOND_LEVEL_MOTIVATION = 14;

	/**
	 * The feature id for the '<em><b>Motivation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>First Level Applied Protection Instantiations</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS = 1;

	/**
	 * The number of structural features of the '<em>Second Level Motivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION___TO_STRING = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION___HASH_CODE = 1;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION___EQUALS__OBJECT = 2;

	/**
	 * The number of operations of the '<em>Second Level Motivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECOND_LEVEL_MOTIVATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.SolutionSequenceImpl <em>Solution Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.SolutionSequenceImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSolutionSequence()
	 * @generated
	 */
	int SOLUTION_SEQUENCE = 15;

	/**
	 * The feature id for the '<em><b>Applied Protection Instantiations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS = 0;

	/**
	 * The number of structural features of the '<em>Solution Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_SEQUENCE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_SEQUENCE___TO_STRING = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_SEQUENCE___HASH_CODE = 1;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_SEQUENCE___EQUALS__OBJECT = 2;

	/**
	 * The number of operations of the '<em>Solution Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_SEQUENCE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.SolutionImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 16;

	/**
	 * The feature id for the '<em><b>Solution Sequences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SOLUTION_SEQUENCES = 0;

	/**
	 * The feature id for the '<em><b>Application Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__APPLICATION_METRICS = 1;

	/**
	 * The feature id for the '<em><b>Application Part Metric Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__APPLICATION_PART_METRIC_SETS = 2;

	/**
	 * The feature id for the '<em><b>First Level Solution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__FIRST_LEVEL_SOLUTION = 3;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SCORE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ID = 5;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION___TO_STRING = 0;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION___HASH_CODE = 1;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION___EQUALS__OBJECT = 2;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartMetricSetImpl <em>Application Part Metric Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ApplicationPartMetricSetImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPartMetricSet()
	 * @generated
	 */
	int APPLICATION_PART_METRIC_SET = 17;

	/**
	 * The feature id for the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_METRIC_SET__APPLICATION_PART = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_METRIC_SET__METRICS = 1;

	/**
	 * The number of structural features of the '<em>Application Part Metric Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_METRIC_SET_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_METRIC_SET___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_METRIC_SET___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Application Part Metric Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_METRIC_SET_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.MetricImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl <em>Code Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.CodeBlockImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getCodeBlock()
	 * @generated
	 */
	int CODE_BLOCK = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Code Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__CODE_BLOCKS = 1;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__START_LINE = 2;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__END_LINE = 3;

	/**
	 * The feature id for the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK__SOURCE_FILE_PATH = 4;

	/**
	 * The number of structural features of the '<em>Code Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Code Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_BLOCK_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.RuleImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 20;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Function Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__FUNCTION_DECLARATIONS = 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.FunctionDeclarationImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getFunctionDeclaration()
	 * @generated
	 */
	int FUNCTION_DECLARATION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Function Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Function Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartSetImpl <em>Application Part Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ApplicationPartSetImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPartSet()
	 * @generated
	 */
	int APPLICATION_PART_SET = 22;

	/**
	 * The feature id for the '<em><b>Application Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_SET__APPLICATION_PARTS = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_SET__ACTION = 1;

	/**
	 * The number of structural features of the '<em>Application Part Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_SET_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_SET___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_SET___EQUALS__OBJECT = 1;

	/**
	 * The number of operations of the '<em>Application Part Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_PART_SET_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.impl.ProtectionObjectiveImpl <em>Protection Objective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.impl.ProtectionObjectiveImpl
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtectionObjective()
	 * @generated
	 */
	int PROTECTION_OBJECTIVE = 23;

	/**
	 * The feature id for the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE__APPLICATION_PART = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE__PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Protection Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE___EQUALS__OBJECT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE___TO_STRING = 2;

	/**
	 * The number of operations of the '<em>Protection Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTION_OBJECTIVE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.UseType <em>Use Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.UseType
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getUseType()
	 * @generated
	 */
	int USE_TYPE = 24;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.Property <em>Property</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.Property
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 25;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.ProtectionFlag <em>Protection Flag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.ProtectionFlag
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtectionFlag()
	 * @generated
	 */
	int PROTECTION_FLAG = 26;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.ApplicationPartType <em>Application Part Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartType
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPartType()
	 * @generated
	 */
	int APPLICATION_PART_TYPE = 27;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.Level <em>Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getLevel()
	 * @generated
	 */
	int LEVEL = 28;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.ExpertiseLevel <em>Expertise Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getExpertiseLevel()
	 * @generated
	 */
	int EXPERTISE_LEVEL = 29;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivationType <em>Second Level Motivation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivationType
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSecondLevelMotivationType()
	 * @generated
	 */
	int SECOND_LEVEL_MOTIVATION_TYPE = 30;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.CodeBlockType <em>Code Block Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.CodeBlockType
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getCodeBlockType()
	 * @generated
	 */
	int CODE_BLOCK_TYPE = 31;

	/**
	 * The meta object id for the '{@link eu.aspire_fp7.adss.akb.ActionType <em>Action Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.ActionType
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 32;

	/**
	 * The meta object id for the '<em>Ontology</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.polito.security.ontologies.Ontology
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getOntology()
	 * @generated
	 */
	int ONTOLOGY = 33;

	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 34;

	/**
	 * The meta object id for the '<em>Attack Step Type With Null</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.AttackStepType
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackStepTypeWithNull()
	 * @generated
	 */
	int ATTACK_STEP_TYPE_WITH_NULL = 35;

	/**
	 * The meta object id for the '<em>Level With Null</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getLevelWithNull()
	 * @generated
	 */
	int LEVEL_WITH_NULL = 36;


	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getOntology <em>Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ontology</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getOntology()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Ontology();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getApplicationParts <em>Application Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Parts</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getApplicationParts()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ApplicationParts();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getApplicationPartSets <em>Application Part Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Part Sets</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getApplicationPartSets()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ApplicationPartSets();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getAttackPaths <em>Attack Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attack Paths</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackPaths()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AttackPaths();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getAttackStepTypes <em>Attack Step Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attack Step Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackStepTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AttackStepTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getAttackSteps <em>Attack Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attack Steps</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackSteps()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AttackSteps();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getProtections <em>Protections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protections</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getProtections()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Protections();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aspire_fp7.adss.akb.Model#getPreferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Preferences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getPreferences()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Preferences();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getRules()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getProtectionObjectives <em>Protection Objectives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protection Objectives</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getProtectionObjectives()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ProtectionObjectives();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applied Protection Instantiations</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAppliedProtectionInstantiations()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AppliedProtectionInstantiations();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Model#getAvailableProtections <em>Available Protections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available Protections</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAvailableProtections()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableProtections();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Model#getAvailableSecondLevelProtections <em>Available Second Level Protections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available Second Level Protections</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAvailableSecondLevelProtections()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableSecondLevelProtections();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Model#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assets</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAssets()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Assets();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aspire_fp7.adss.akb.Model#getAttacker <em>Attacker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attacker</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttacker()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Attacker();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getAttackerToolTypes <em>Attacker Tool Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attacker Tool Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackerToolTypes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AttackerToolTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getAttackerTools <em>Attacker Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attacker Tools</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackerTools()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AttackerTools();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aspire_fp7.adss.akb.Model#getVanillaSolution <em>Vanilla Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vanilla Solution</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getVanillaSolution()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_VanillaSolution();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Model#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solutions</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getSolutions()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Solutions();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Model#getAvailableTools <em>Available Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available Tools</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAvailableTools()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AvailableTools();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getApplicationPartsCount <em>Application Parts Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Parts Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getApplicationPartsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ApplicationPartsCount();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Model#getAllApplicationParts <em>All Application Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Application Parts</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAllApplicationParts()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_AllApplicationParts();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAssetsCount <em>Assets Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assets Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAssetsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AssetsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getDataCount <em>Data Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getDataCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_DataCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getCodesCount <em>Codes Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codes Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getCodesCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_CodesCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getProtectionsCount <em>Protections Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protections Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getProtectionsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ProtectionsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAttackerToolsCount <em>Attacker Tools Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attacker Tools Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackerToolsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AttackerToolsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAttackerToolTypesCount <em>Attacker Tool Types Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attacker Tool Types Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackerToolTypesCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AttackerToolTypesCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAvailableAttackerToolsCount <em>Available Attacker Tools Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Attacker Tools Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAvailableAttackerToolsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AvailableAttackerToolsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAvailableProtectionsCount <em>Available Protections Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Protections Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAvailableProtectionsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AvailableProtectionsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAttackPathsCount <em>Attack Paths Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Paths Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackPathsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AttackPathsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAttackStepsCount <em>Attack Steps Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Steps Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackStepsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AttackStepsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAttackStepTypesCount <em>Attack Step Types Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Step Types Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAttackStepTypesCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AttackStepTypesCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getProtectionObjectivesCount <em>Protection Objectives Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protection Objectives Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getProtectionObjectivesCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ProtectionObjectivesCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getAppliedProtectionInstantiationsCount <em>Applied Protection Instantiations Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Applied Protection Instantiations Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getAppliedProtectionInstantiationsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_AppliedProtectionInstantiationsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getProtectionInstantiationsCount <em>Protection Instantiations Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protection Instantiations Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getProtectionInstantiationsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ProtectionInstantiationsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Model#getSolutionsCount <em>Solutions Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solutions Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getSolutionsCount()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_SolutionsCount();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Model#getKeyAttackPaths <em>Key Attack Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Key Attack Paths</em>'.
	 * @see eu.aspire_fp7.adss.akb.Model#getKeyAttackPaths()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_KeyAttackPaths();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.ApplicationPart <em>Application Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Part</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart
	 * @generated
	 */
	EClass getApplicationPart();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getId()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getName()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Name();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSets <em>Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sets</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getSets()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_Sets();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getType()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Type();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getIndex()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Index();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Properties</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getProperties()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Properties();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSourceFilePath <em>Source File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File Path</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getSourceFilePath()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_SourceFilePath();

	/**
	 * Returns the meta object for the container reference '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDeclaringCode <em>Declaring Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Code</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getDeclaringCode()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_DeclaringCode();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getStartLine()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getEndLine()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDatumSize <em>Datum Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Datum Size</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getDatumSize()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_DatumSize();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#isInSystemFile <em>In System File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In System File</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#isInSystemFile()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_InSystemFile();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#isGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#isGlobal()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Global();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getShortLocation <em>Short Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Location</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getShortLocation()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_ShortLocation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getWeight()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Weight();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSecurityProperties <em>Security Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Security Properties</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getSecurityProperties()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_SecurityProperties();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getParameters()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#isAsset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Asset</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#isAsset()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_Asset();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationParts <em>Application Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Application Parts</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationParts()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_ApplicationParts();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uses</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getUses()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_Uses();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getTargetOf <em>Target Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Of</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getTargetOf()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_TargetOf();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getBody()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_Body();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationPartsCount <em>Application Parts Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Parts Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationPartsCount()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EAttribute getApplicationPart_ApplicationPartsCount();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assets</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getAssets()
	 * @see #getApplicationPart()
	 * @generated
	 */
	EReference getApplicationPart_Assets();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#contains(eu.aspire_fp7.adss.akb.ApplicationPart) <em>Contains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contains</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#contains(eu.aspire_fp7.adss.akb.ApplicationPart)
	 * @generated
	 */
	EOperation getApplicationPart__Contains__ApplicationPart();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#hashCode()
	 * @generated
	 */
	EOperation getApplicationPart__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getApplicationPart__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#toString()
	 * @generated
	 */
	EOperation getApplicationPart__ToString();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#isDatum() <em>Is Datum</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Datum</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#isDatum()
	 * @generated
	 */
	EOperation getApplicationPart__IsDatum();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#isCode() <em>Is Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#isCode()
	 * @generated
	 */
	EOperation getApplicationPart__IsCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#containsAsset() <em>Contains Asset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Contains Asset</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#containsAsset()
	 * @generated
	 */
	EOperation getApplicationPart__ContainsAsset();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.UseTarget <em>Use Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Target</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget
	 * @generated
	 */
	EClass getUseTarget();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.UseTarget#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getTarget()
	 * @see #getUseTarget()
	 * @generated
	 */
	EReference getUseTarget_Target();

	/**
	 * Returns the meta object for the container reference '{@link eu.aspire_fp7.adss.akb.UseTarget#getUsedBy <em>Used By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Used By</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getUsedBy()
	 * @see #getUseTarget()
	 * @generated
	 */
	EReference getUseTarget_UsedBy();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.UseTarget#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getLine()
	 * @see #getUseTarget()
	 * @generated
	 */
	EAttribute getUseTarget_Line();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.UseTarget#getSourceFilePath <em>Source File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File Path</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getSourceFilePath()
	 * @see #getUseTarget()
	 * @generated
	 */
	EAttribute getUseTarget_SourceFilePath();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.UseTarget#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getType()
	 * @see #getUseTarget()
	 * @generated
	 */
	EAttribute getUseTarget_Type();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.UseTarget#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getParameters()
	 * @see #getUseTarget()
	 * @generated
	 */
	EReference getUseTarget_Parameters();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.UseTarget#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#hashCode()
	 * @generated
	 */
	EOperation getUseTarget__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.UseTarget#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.UseTarget#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getUseTarget__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AttackStep <em>Attack Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack Step</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStep
	 * @generated
	 */
	EClass getAttackStep();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackStep#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#getName()
	 * @see #getAttackStep()
	 * @generated
	 */
	EAttribute getAttackStep_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackStep#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#getType()
	 * @see #getAttackStep()
	 * @generated
	 */
	EAttribute getAttackStep_Type();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackStep#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formula</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#getFormula()
	 * @see #getAttackStep()
	 * @generated
	 */
	EAttribute getAttackStep_Formula();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackStep#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#getTransition()
	 * @see #getAttackStep()
	 * @generated
	 */
	EAttribute getAttackStep_Transition();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackStep#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#hashCode()
	 * @generated
	 */
	EOperation getAttackStep__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackStep#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttackStep__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackStep#toString()
	 * @generated
	 */
	EOperation getAttackStep__ToString();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AttackStepType <em>Attack Step Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack Step Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType
	 * @generated
	 */
	EClass getAttackStepType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackStepType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType#getName()
	 * @see #getAttackStepType()
	 * @generated
	 */
	EAttribute getAttackStepType_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackStepType#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType#getRegex()
	 * @see #getAttackStepType()
	 * @generated
	 */
	EAttribute getAttackStepType_Regex();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackStepType#getAttackerTools <em>Attacker Tools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attacker Tools</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType#getAttackerTools()
	 * @see #getAttackStepType()
	 * @generated
	 */
	EReference getAttackStepType_AttackerTools();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackStepType#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType#hashCode()
	 * @generated
	 */
	EOperation getAttackStepType__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackStepType#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttackStepType__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackStepType#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType#toString()
	 * @generated
	 */
	EOperation getAttackStepType__ToString();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AttackPath <em>Attack Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack Path</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath
	 * @generated
	 */
	EClass getAttackPath();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackPath#getAttackSteps <em>Attack Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attack Steps</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getAttackSteps()
	 * @see #getAttackPath()
	 * @generated
	 */
	EReference getAttackPath_AttackSteps();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackPath#getProtectionObjectives <em>Protection Objectives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protection Objectives</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getProtectionObjectives()
	 * @see #getAttackPath()
	 * @generated
	 */
	EReference getAttackPath_ProtectionObjectives();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackPath#getAttackerToolTypes <em>Attacker Tool Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attacker Tool Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getAttackerToolTypes()
	 * @see #getAttackPath()
	 * @generated
	 */
	EReference getAttackPath_AttackerToolTypes();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackPath#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getCost()
	 * @see #getAttackPath()
	 * @generated
	 */
	EAttribute getAttackPath_Cost();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackPath#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applied Protection Instantiations</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getAppliedProtectionInstantiations()
	 * @see #getAttackPath()
	 * @generated
	 */
	EReference getAttackPath_AppliedProtectionInstantiations();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackPath#isKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#isKey()
	 * @see #getAttackPath()
	 * @generated
	 */
	EAttribute getAttackPath_Key();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackPath#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getId()
	 * @see #getAttackPath()
	 * @generated
	 */
	EAttribute getAttackPath_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackPath#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mitigations</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getMitigations()
	 * @see #getAttackPath()
	 * @generated
	 */
	EAttribute getAttackPath_Mitigations();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackPath#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#getLevel()
	 * @see #getAttackPath()
	 * @generated
	 */
	EAttribute getAttackPath_Level();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackPath#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#hashCode()
	 * @generated
	 */
	EOperation getAttackPath__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackPath#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttackPath__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackPath#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackPath#toString()
	 * @generated
	 */
	EOperation getAttackPath__ToString();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AttackMitigation <em>Attack Mitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack Mitigation</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation
	 * @generated
	 */
	EClass getAttackMitigation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackMitigation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#getName()
	 * @see #getAttackMitigation()
	 * @generated
	 */
	EAttribute getAttackMitigation_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackMitigation#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#getLevel()
	 * @see #getAttackMitigation()
	 * @generated
	 */
	EAttribute getAttackMitigation_Level();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.AttackMitigation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#getType()
	 * @see #getAttackMitigation()
	 * @generated
	 */
	EReference getAttackMitigation_Type();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackMitigation#getAttackPaths <em>Attack Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attack Paths</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#getAttackPaths()
	 * @see #getAttackMitigation()
	 * @generated
	 */
	EReference getAttackMitigation_AttackPaths();

	/**
	 * Returns the meta object for the container reference '{@link eu.aspire_fp7.adss.akb.AttackMitigation#getProtection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Protection</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#getProtection()
	 * @see #getAttackMitigation()
	 * @generated
	 */
	EReference getAttackMitigation_Protection();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackMitigation#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#hashCode()
	 * @generated
	 */
	EOperation getAttackMitigation__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackMitigation#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttackMitigation__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Protection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protection</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection
	 * @generated
	 */
	EClass getProtection();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getId()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getName()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#isEnabled()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#isAutomaticallyDeployable <em>Automatically Deployable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Automatically Deployable</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#isAutomaticallyDeployable()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_AutomaticallyDeployable();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#isSecondLevel <em>Second Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Level</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#isSecondLevel()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_SecondLevel();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#getSecondLevelEnlargmentUsefulness <em>Second Level Enlargment Usefulness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Level Enlargment Usefulness</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getSecondLevelEnlargmentUsefulness()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_SecondLevelEnlargmentUsefulness();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#getSecondLevelCallGraphEnlargmentUsefulness <em>Second Level Call Graph Enlargment Usefulness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Level Call Graph Enlargment Usefulness</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getSecondLevelCallGraphEnlargmentUsefulness()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_SecondLevelCallGraphEnlargmentUsefulness();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#getSecondLevelRepetitionUsefulness <em>Second Level Repetition Usefulness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Level Repetition Usefulness</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getSecondLevelRepetitionUsefulness()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_SecondLevelRepetitionUsefulness();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Protection#getSecondLevelRepetitionInstantiation <em>Second Level Repetition Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Second Level Repetition Instantiation</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getSecondLevelRepetitionInstantiation()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_SecondLevelRepetitionInstantiation();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.Protection#getApplicationPartTypes <em>Application Part Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Application Part Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getApplicationPartTypes()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_ApplicationPartTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Protection#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mitigations</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getMitigations()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_Mitigations();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.Protection#getEnforcedSecurityRequirements <em>Enforced Security Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enforced Security Requirements</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getEnforcedSecurityRequirements()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_EnforcedSecurityRequirements();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Protection#getForbiddenPrecedences <em>Forbidden Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Forbidden Precedences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getForbiddenPrecedences()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_ForbiddenPrecedences();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Protection#getDiscouragedPrecedences <em>Discouraged Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Discouraged Precedences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getDiscouragedPrecedences()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_DiscouragedPrecedences();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Protection#getEncouragedPrecedences <em>Encouraged Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Encouraged Precedences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getEncouragedPrecedences()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_EncouragedPrecedences();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Protection#getActcPrecedences <em>Actc Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actc Precedences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getActcPrecedences()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_ActcPrecedences();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#isSingleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#isSingleton()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_Singleton();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Protection#getDefeatedAttackerToolTypes <em>Defeated Attacker Tool Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Defeated Attacker Tool Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getDefeatedAttackerToolTypes()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_DefeatedAttackerToolTypes();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Protection#getBlockedAttackerToolTypes <em>Blocked Attacker Tool Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Blocked Attacker Tool Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getBlockedAttackerToolTypes()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_BlockedAttackerToolTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.Protection#getInstantiations <em>Instantiations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instantiations</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getInstantiations()
	 * @see #getProtection()
	 * @generated
	 */
	EReference getProtection_Instantiations();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.Protection#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Actions</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getActions()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_Actions();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.Protection#getFlags <em>Flags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Flags</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getFlags()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_Flags();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Protection#getInstantiationsCount <em>Instantiations Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instantiations Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Protection#getInstantiationsCount()
	 * @see #getProtection()
	 * @generated
	 */
	EAttribute getProtection_InstantiationsCount();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Protection#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Protection#hashCode()
	 * @generated
	 */
	EOperation getProtection__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Protection#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Protection#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getProtection__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Protection#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Protection#toString()
	 * @generated
	 */
	EOperation getProtection__ToString();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation <em>Protection Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protection Instantiation</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation
	 * @generated
	 */
	EClass getProtectionInstantiation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getName()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_Name();

	/**
	 * Returns the meta object for the container reference '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getProtection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Protection</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getProtection()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EReference getProtectionInstantiation_Protection();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVariableAnnotation <em>Variable Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Annotation</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVariableAnnotation()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_VariableAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getCodeAnnotation <em>Code Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code Annotation</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getCodeAnnotation()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_CodeAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVerifierAnnotation <em>Verifier Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verifier Annotation</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVerifierAnnotation()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_VerifierAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getAttestatorAnnotation <em>Attestator Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attestator Annotation</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getAttestatorAnnotation()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_AttestatorAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientTimeOverhead <em>Client Time Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Time Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientTimeOverhead()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_ClientTimeOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerTimeOverhead <em>Server Time Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Time Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerTimeOverhead()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_ServerTimeOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientMemoryOverhead <em>Client Memory Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Memory Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientMemoryOverhead()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_ClientMemoryOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerMemoryOverhead <em>Server Memory Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Memory Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerMemoryOverhead()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_ServerMemoryOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getNetworkOverhead <em>Network Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Network Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#getNetworkOverhead()
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	EAttribute getProtectionInstantiation_NetworkOverhead();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#hashCode()
	 * @generated
	 */
	EOperation getProtectionInstantiation__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getProtectionInstantiation__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation#toString()
	 * @generated
	 */
	EOperation getProtectionInstantiation__ToString();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Attacker <em>Attacker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attacker</em>'.
	 * @see eu.aspire_fp7.adss.akb.Attacker
	 * @generated
	 */
	EClass getAttacker();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Attacker#getExpertise <em>Expertise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expertise</em>'.
	 * @see eu.aspire_fp7.adss.akb.Attacker#getExpertise()
	 * @see #getAttacker()
	 * @generated
	 */
	EAttribute getAttacker_Expertise();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Attacker#getBudgetLimit <em>Budget Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Budget Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Attacker#getBudgetLimit()
	 * @see #getAttacker()
	 * @generated
	 */
	EAttribute getAttacker_BudgetLimit();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Attacker#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Attacker#hashCode()
	 * @generated
	 */
	EOperation getAttacker__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Attacker#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Attacker#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttacker__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AttackerTool <em>Attacker Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attacker Tool</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool
	 * @generated
	 */
	EClass getAttackerTool();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackerTool#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#getName()
	 * @see #getAttackerTool()
	 * @generated
	 */
	EAttribute getAttackerTool_Name();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AttackerTool#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#getTypes()
	 * @see #getAttackerTool()
	 * @generated
	 */
	EReference getAttackerTool_Types();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackerTool#getExpertise <em>Expertise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expertise</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#getExpertise()
	 * @see #getAttackerTool()
	 * @generated
	 */
	EAttribute getAttackerTool_Expertise();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackerTool#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#getCost()
	 * @see #getAttackerTool()
	 * @generated
	 */
	EAttribute getAttackerTool_Cost();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackerTool#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#isEnabled()
	 * @see #getAttackerTool()
	 * @generated
	 */
	EAttribute getAttackerTool_Enabled();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackerTool#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#hashCode()
	 * @generated
	 */
	EOperation getAttackerTool__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackerTool#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttackerTool__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AttackerToolType <em>Attacker Tool Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attacker Tool Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerToolType
	 * @generated
	 */
	EClass getAttackerToolType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.AttackerToolType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackerToolType#getName()
	 * @see #getAttackerToolType()
	 * @generated
	 */
	EAttribute getAttackerToolType_Name();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackerToolType#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackerToolType#hashCode()
	 * @generated
	 */
	EOperation getAttackerToolType__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackerToolType#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackerToolType#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAttackerToolType__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AttackerToolType#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AttackerToolType#toString()
	 * @generated
	 */
	EOperation getAttackerToolType__ToString();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Preferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preferences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences
	 * @generated
	 */
	EClass getPreferences();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getWorkingDirectory <em>Working Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Working Directory</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getWorkingDirectory()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_WorkingDirectory();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getActcConfigurationFile <em>Actc Configuration File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actc Configuration File</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getActcConfigurationFile()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ActcConfigurationFile();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getAdssPatchFile <em>Adss Patch File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adss Patch File</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getAdssPatchFile()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_AdssPatchFile();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getAdssJSONFile <em>Adss JSON File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adss JSON File</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getAdssJSONFile()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_AdssJSONFile();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Architecture</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getArchitecture()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_Architecture();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isRemoteConnection <em>Remote Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Connection</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isRemoteConnection()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_RemoteConnection();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteUsername <em>Remote Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Username</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getRemoteUsername()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_RemoteUsername();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getRemotePassword <em>Remote Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Password</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getRemotePassword()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_RemotePassword();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteHost <em>Remote Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Host</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getRemoteHost()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_RemoteHost();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getRemotePort <em>Remote Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Port</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getRemotePort()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_RemotePort();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getRemoteFileSeparator <em>Remote File Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote File Separator</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getRemoteFileSeparator()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_RemoteFileSeparator();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getCommandACTC <em>Command ACTC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command ACTC</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getCommandACTC()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_CommandACTC();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getCommandPerl <em>Command Perl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Perl</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getCommandPerl()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_CommandPerl();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getCommandDot <em>Command Dot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Dot</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getCommandDot()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_CommandDot();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getMetricsFile <em>Metrics File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metrics File</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getMetricsFile()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_MetricsFile();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isParserHeaderParsing <em>Parser Header Parsing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parser Header Parsing</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isParserHeaderParsing()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ParserHeaderParsing();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isParserSystemFilesIgnoration <em>Parser System Files Ignoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parser System Files Ignoration</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isParserSystemFilesIgnoration()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ParserSystemFilesIgnoration();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getAttacksTimeLimit <em>Attacks Time Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attacks Time Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getAttacksTimeLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_AttacksTimeLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getAttacksMaximumDepth <em>Attacks Maximum Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attacks Maximum Depth</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getAttacksMaximumDepth()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_AttacksMaximumDepth();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isAttacksIncludedProtectionObjectivesRemoval <em>Attacks Included Protection Objectives Removal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attacks Included Protection Objectives Removal</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isAttacksIncludedProtectionObjectivesRemoval()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_AttacksIncludedProtectionObjectivesRemoval();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getProtectionsMinimumAttackMitigation <em>Protections Minimum Attack Mitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protections Minimum Attack Mitigation</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getProtectionsMinimumAttackMitigation()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ProtectionsMinimumAttackMitigation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getClientTimeOverhead <em>Client Time Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Time Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getClientTimeOverhead()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ClientTimeOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getServerTimeOverhead <em>Server Time Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Time Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getServerTimeOverhead()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ServerTimeOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getClientMemoryOverhead <em>Client Memory Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Memory Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getClientMemoryOverhead()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ClientMemoryOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getServerMemoryOverhead <em>Server Memory Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Memory Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getServerMemoryOverhead()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_ServerMemoryOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getNetworkOverhead <em>Network Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Network Overhead</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getNetworkOverhead()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_NetworkOverhead();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsCount <em>L1p Solutions Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Solutions Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsCount()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pSolutionsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pPetriNetsPass <em>L1p Petri Nets Pass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Petri Nets Pass</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isL1pPetriNetsPass()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pPetriNetsPass();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pTimeLimit <em>L1p Time Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Time Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pTimeLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pTimeLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsLimit <em>L1p Solutions Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Solutions Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pSolutionsLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pSolutionsLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pGapLimit <em>L1p Gap Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Gap Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pGapLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pGapLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pClientTimeOverheadPercentage <em>L1p Client Time Overhead Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Client Time Overhead Percentage</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pClientTimeOverheadPercentage()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pClientTimeOverheadPercentage();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pServerTimeOverheadPercentage <em>L1p Server Time Overhead Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Server Time Overhead Percentage</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pServerTimeOverheadPercentage()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pServerTimeOverheadPercentage();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pClientMemoryOverheadPercentage <em>L1p Client Memory Overhead Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Client Memory Overhead Percentage</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pClientMemoryOverheadPercentage()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pClientMemoryOverheadPercentage();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pServerMemoryOverheadPercentage <em>L1p Server Memory Overhead Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Server Memory Overhead Percentage</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pServerMemoryOverheadPercentage()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pServerMemoryOverheadPercentage();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pNetworkOverheadPercentage <em>L1p Network Overhead Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Network Overhead Percentage</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pNetworkOverheadPercentage()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pNetworkOverheadPercentage();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pDiscouragedPrecedencesIgnoration <em>L1p Discouraged Precedences Ignoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Discouraged Precedences Ignoration</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isL1pDiscouragedPrecedencesIgnoration()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pDiscouragedPrecedencesIgnoration();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pEncouragedPrecedencesFocusing <em>L1p Encouraged Precedences Focusing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Encouraged Precedences Focusing</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isL1pEncouragedPrecedencesFocusing()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pEncouragedPrecedencesFocusing();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pUseACTCPrecedences <em>L1p Use ACTC Precedences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Use ACTC Precedences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isL1pUseACTCPrecedences()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pUseACTCPrecedences();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pIgnoreApplicationPartOrder <em>L1p Ignore Application Part Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Ignore Application Part Order</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isL1pIgnoreApplicationPartOrder()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pIgnoreApplicationPartOrder();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pMaximumInstantiationsPerProtectionObjective <em>L1p Maximum Instantiations Per Protection Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Maximum Instantiations Per Protection Objective</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pMaximumInstantiationsPerProtectionObjective()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pMaximumInstantiationsPerProtectionObjective();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pMainSearchMaximumDepth <em>L1p Main Search Maximum Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Main Search Maximum Depth</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pMainSearchMaximumDepth()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pMainSearchMaximumDepth();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#isL1pMultiTree <em>L1p Multi Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Multi Tree</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#isL1pMultiTree()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pMultiTree();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pInitialAlpha <em>L1p Initial Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Initial Alpha</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pInitialAlpha()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pInitialAlpha();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pInitialBeta <em>L1p Initial Beta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Initial Beta</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pInitialBeta()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pInitialBeta();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pResearchDelta <em>L1p Research Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Research Delta</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pResearchDelta()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pResearchDelta();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL1pTranspositionTableMaximumSize <em>L1p Transposition Table Maximum Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L1p Transposition Table Maximum Size</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL1pTranspositionTableMaximumSize()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L1pTranspositionTableMaximumSize();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionsCount <em>L2p Solutions Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Solutions Count</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionsCount()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pSolutionsCount();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingSeed <em>L2p Function Splitting Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Function Splitting Seed</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingSeed()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pFunctionSplittingSeed();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionLimit <em>L2p Solution Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Solution Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pSolutionLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pSolutionLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pTimeLimit <em>L2p Time Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Time Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pTimeLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pTimeLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pGapLimit <em>L2p Gap Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Gap Limit</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pGapLimit()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pGapLimit();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pUpperBound <em>L2p Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Upper Bound</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pUpperBound()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pUpperBound();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingMediumCodeBlockLength <em>L2p Function Splitting Medium Code Block Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Function Splitting Medium Code Block Length</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingMediumCodeBlockLength()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pFunctionSplittingMediumCodeBlockLength();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator <em>L2p Function Splitting Code Block Length Randomization Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Function Splitting Code Block Length Randomization Denominator</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pFunctionSplittingCodeBlockLengthRandomizationDenominator();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingDepthLevel <em>L2p Function Splitting Depth Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2p Function Splitting Depth Level</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getL2pFunctionSplittingDepthLevel()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_L2pFunctionSplittingDepthLevel();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getSetPNDirectory <em>Set PN Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set PN Directory</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getSetPNDirectory()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_SetPNDirectory();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Preferences#getSetPNFile <em>Set PN File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set PN File</em>'.
	 * @see eu.aspire_fp7.adss.akb.Preferences#getSetPNFile()
	 * @see #getPreferences()
	 * @generated
	 */
	EAttribute getPreferences_SetPNFile();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Preferences#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Preferences#hashCode()
	 * @generated
	 */
	EOperation getPreferences__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Preferences#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Preferences#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getPreferences__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation <em>Applied Protection Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applied Protection Instantiation</em>'.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation
	 * @generated
	 */
	EClass getAppliedProtectionInstantiation();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionInstantiation <em>Protection Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Protection Instantiation</em>'.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionInstantiation()
	 * @see #getAppliedProtectionInstantiation()
	 * @generated
	 */
	EReference getAppliedProtectionInstantiation_ProtectionInstantiation();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getApplicationPart <em>Application Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Application Part</em>'.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getApplicationPart()
	 * @see #getAppliedProtectionInstantiation()
	 * @generated
	 */
	EReference getAppliedProtectionInstantiation_ApplicationPart();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionObjectives <em>Protection Objectives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protection Objectives</em>'.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionObjectives()
	 * @see #getAppliedProtectionInstantiation()
	 * @generated
	 */
	EReference getAppliedProtectionInstantiation_ProtectionObjectives();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getAttackMitigations <em>Attack Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attack Mitigations</em>'.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getAttackMitigations()
	 * @see #getAppliedProtectionInstantiation()
	 * @generated
	 */
	EReference getAppliedProtectionInstantiation_AttackMitigations();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getSecondLevelMotivation <em>Second Level Motivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Second Level Motivation</em>'.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getSecondLevelMotivation()
	 * @see #getAppliedProtectionInstantiation()
	 * @generated
	 */
	EReference getAppliedProtectionInstantiation_SecondLevelMotivation();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#toString()
	 * @generated
	 */
	EOperation getAppliedProtectionInstantiation__ToString();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#hashCode()
	 * @generated
	 */
	EOperation getAppliedProtectionInstantiation__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getAppliedProtectionInstantiation__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation <em>Second Level Motivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Second Level Motivation</em>'.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation
	 * @generated
	 */
	EClass getSecondLevelMotivation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation#getMotivationType <em>Motivation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Motivation Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation#getMotivationType()
	 * @see #getSecondLevelMotivation()
	 * @generated
	 */
	EAttribute getSecondLevelMotivation_MotivationType();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation#getFirstLevelAppliedProtectionInstantiations <em>First Level Applied Protection Instantiations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>First Level Applied Protection Instantiations</em>'.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation#getFirstLevelAppliedProtectionInstantiations()
	 * @see #getSecondLevelMotivation()
	 * @generated
	 */
	EReference getSecondLevelMotivation_FirstLevelAppliedProtectionInstantiations();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation#toString()
	 * @generated
	 */
	EOperation getSecondLevelMotivation__ToString();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation#hashCode()
	 * @generated
	 */
	EOperation getSecondLevelMotivation__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getSecondLevelMotivation__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.SolutionSequence <em>Solution Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution Sequence</em>'.
	 * @see eu.aspire_fp7.adss.akb.SolutionSequence
	 * @generated
	 */
	EClass getSolutionSequence();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.SolutionSequence#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applied Protection Instantiations</em>'.
	 * @see eu.aspire_fp7.adss.akb.SolutionSequence#getAppliedProtectionInstantiations()
	 * @see #getSolutionSequence()
	 * @generated
	 */
	EReference getSolutionSequence_AppliedProtectionInstantiations();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.SolutionSequence#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.SolutionSequence#toString()
	 * @generated
	 */
	EOperation getSolutionSequence__ToString();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.SolutionSequence#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.SolutionSequence#hashCode()
	 * @generated
	 */
	EOperation getSolutionSequence__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.SolutionSequence#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.SolutionSequence#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getSolutionSequence__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Solution#getSolutionSequences <em>Solution Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Solution Sequences</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution#getSolutionSequences()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_SolutionSequences();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Solution#getApplicationMetrics <em>Application Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Application Metrics</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution#getApplicationMetrics()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_ApplicationMetrics();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Solution#getApplicationPartMetricSets <em>Application Part Metric Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Application Part Metric Sets</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution#getApplicationPartMetricSets()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_ApplicationPartMetricSets();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.Solution#getFirstLevelSolution <em>First Level Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>First Level Solution</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution#getFirstLevelSolution()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_FirstLevelSolution();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Solution#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution#getScore()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_Score();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Solution#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aspire_fp7.adss.akb.Solution#getId()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_Id();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Solution#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Solution#toString()
	 * @generated
	 */
	EOperation getSolution__ToString();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Solution#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Solution#hashCode()
	 * @generated
	 */
	EOperation getSolution__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Solution#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Solution#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getSolution__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet <em>Application Part Metric Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Part Metric Set</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartMetricSet
	 * @generated
	 */
	EClass getApplicationPartMetricSet();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getApplicationPart <em>Application Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Application Part</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getApplicationPart()
	 * @see #getApplicationPartMetricSet()
	 * @generated
	 */
	EReference getApplicationPartMetricSet_ApplicationPart();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metrics</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getMetrics()
	 * @see #getApplicationPartMetricSet()
	 * @generated
	 */
	EReference getApplicationPartMetricSet_Metrics();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#hashCode()
	 * @generated
	 */
	EOperation getApplicationPartMetricSet__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getApplicationPartMetricSet__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see eu.aspire_fp7.adss.akb.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Metric#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aspire_fp7.adss.akb.Metric#getValue()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Value();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Metric#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Metric#hashCode()
	 * @generated
	 */
	EOperation getMetric__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Metric#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Metric#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getMetric__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.CodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Block</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock
	 * @generated
	 */
	EClass getCodeBlock();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.CodeBlock#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#getType()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aspire_fp7.adss.akb.CodeBlock#getCodeBlocks <em>Code Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Code Blocks</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#getCodeBlocks()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EReference getCodeBlock_CodeBlocks();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.CodeBlock#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#getStartLine()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.CodeBlock#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#getEndLine()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.CodeBlock#getSourceFilePath <em>Source File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File Path</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#getSourceFilePath()
	 * @see #getCodeBlock()
	 * @generated
	 */
	EAttribute getCodeBlock_SourceFilePath();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.CodeBlock#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#hashCode()
	 * @generated
	 */
	EOperation getCodeBlock__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.CodeBlock#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getCodeBlock__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see eu.aspire_fp7.adss.akb.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.Rule#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see eu.aspire_fp7.adss.akb.Rule#getAction()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Action();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.Rule#getFunctionDeclarations <em>Function Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Function Declarations</em>'.
	 * @see eu.aspire_fp7.adss.akb.Rule#getFunctionDeclarations()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_FunctionDeclarations();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Rule#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Rule#hashCode()
	 * @generated
	 */
	EOperation getRule__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.Rule#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.Rule#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getRule__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Declaration</em>'.
	 * @see eu.aspire_fp7.adss.akb.FunctionDeclaration
	 * @generated
	 */
	EClass getFunctionDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aspire_fp7.adss.akb.FunctionDeclaration#getName()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EAttribute getFunctionDeclaration_Name();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameters</em>'.
	 * @see eu.aspire_fp7.adss.akb.FunctionDeclaration#getParameters()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EAttribute getFunctionDeclaration_Parameters();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.FunctionDeclaration#hashCode()
	 * @generated
	 */
	EOperation getFunctionDeclaration__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.FunctionDeclaration#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getFunctionDeclaration__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet <em>Application Part Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Part Set</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet
	 * @generated
	 */
	EClass getApplicationPartSet();

	/**
	 * Returns the meta object for the reference list '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet#getApplicationParts <em>Application Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Application Parts</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet#getApplicationParts()
	 * @see #getApplicationPartSet()
	 * @generated
	 */
	EReference getApplicationPartSet_ApplicationParts();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet#getAction()
	 * @see #getApplicationPartSet()
	 * @generated
	 */
	EAttribute getApplicationPartSet_Action();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet#hashCode()
	 * @generated
	 */
	EOperation getApplicationPartSet__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getApplicationPartSet__Equals__Object();

	/**
	 * Returns the meta object for class '{@link eu.aspire_fp7.adss.akb.ProtectionObjective <em>Protection Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protection Objective</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective
	 * @generated
	 */
	EClass getProtectionObjective();

	/**
	 * Returns the meta object for the reference '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#getApplicationPart <em>Application Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Application Part</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective#getApplicationPart()
	 * @see #getProtectionObjective()
	 * @generated
	 */
	EReference getProtectionObjective_ApplicationPart();

	/**
	 * Returns the meta object for the attribute '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective#getProperty()
	 * @see #getProtectionObjective()
	 * @generated
	 */
	EAttribute getProtectionObjective_Property();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective#hashCode()
	 * @generated
	 */
	EOperation getProtectionObjective__HashCode();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#equals(java.lang.Object) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective#equals(java.lang.Object)
	 * @generated
	 */
	EOperation getProtectionObjective__Equals__Object();

	/**
	 * Returns the meta object for the '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective#toString()
	 * @generated
	 */
	EOperation getProtectionObjective__ToString();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.UseType <em>Use Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Use Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.UseType
	 * @generated
	 */
	EEnum getUseType();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property</em>'.
	 * @see eu.aspire_fp7.adss.akb.Property
	 * @generated
	 */
	EEnum getProperty();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.ProtectionFlag <em>Protection Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Protection Flag</em>'.
	 * @see eu.aspire_fp7.adss.akb.ProtectionFlag
	 * @generated
	 */
	EEnum getProtectionFlag();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.ApplicationPartType <em>Application Part Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Application Part Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartType
	 * @generated
	 */
	EEnum getApplicationPartType();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.Level <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Level</em>'.
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @generated
	 */
	EEnum getLevel();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.ExpertiseLevel <em>Expertise Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Expertise Level</em>'.
	 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
	 * @generated
	 */
	EEnum getExpertiseLevel();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivationType <em>Second Level Motivation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Second Level Motivation Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivationType
	 * @generated
	 */
	EEnum getSecondLevelMotivationType();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.CodeBlockType <em>Code Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Code Block Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.CodeBlockType
	 * @generated
	 */
	EEnum getCodeBlockType();

	/**
	 * Returns the meta object for enum '{@link eu.aspire_fp7.adss.akb.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Type</em>'.
	 * @see eu.aspire_fp7.adss.akb.ActionType
	 * @generated
	 */
	EEnum getActionType();

	/**
	 * Returns the meta object for data type '{@link it.polito.security.ontologies.Ontology <em>Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ontology</em>'.
	 * @see it.polito.security.ontologies.Ontology
	 * @model instanceClass="it.polito.security.ontologies.Ontology"
	 * @generated
	 */
	EDataType getOntology();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the meta object for data type '{@link eu.aspire_fp7.adss.akb.AttackStepType <em>Attack Step Type With Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Attack Step Type With Null</em>'.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType
	 * @model instanceClass="eu.aspire_fp7.adss.akb.AttackStepType"
	 * @generated
	 */
	EDataType getAttackStepTypeWithNull();

	/**
	 * Returns the meta object for data type '{@link eu.aspire_fp7.adss.akb.Level <em>Level With Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Level With Null</em>'.
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @model instanceClass="eu.aspire_fp7.adss.akb.Level"
	 * @generated
	 */
	EDataType getLevelWithNull();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AkbFactory getAkbFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ModelImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Ontology</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ONTOLOGY = eINSTANCE.getModel_Ontology();

		/**
		 * The meta object literal for the '<em><b>Application Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__APPLICATION_PARTS = eINSTANCE.getModel_ApplicationParts();

		/**
		 * The meta object literal for the '<em><b>Application Part Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__APPLICATION_PART_SETS = eINSTANCE.getModel_ApplicationPartSets();

		/**
		 * The meta object literal for the '<em><b>Attack Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTACK_PATHS = eINSTANCE.getModel_AttackPaths();

		/**
		 * The meta object literal for the '<em><b>Attack Step Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTACK_STEP_TYPES = eINSTANCE.getModel_AttackStepTypes();

		/**
		 * The meta object literal for the '<em><b>Attack Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTACK_STEPS = eINSTANCE.getModel_AttackSteps();

		/**
		 * The meta object literal for the '<em><b>Protections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PROTECTIONS = eINSTANCE.getModel_Protections();

		/**
		 * The meta object literal for the '<em><b>Preferences</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PREFERENCES = eINSTANCE.getModel_Preferences();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__RULES = eINSTANCE.getModel_Rules();

		/**
		 * The meta object literal for the '<em><b>Protection Objectives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PROTECTION_OBJECTIVES = eINSTANCE.getModel_ProtectionObjectives();

		/**
		 * The meta object literal for the '<em><b>Applied Protection Instantiations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__APPLIED_PROTECTION_INSTANTIATIONS = eINSTANCE.getModel_AppliedProtectionInstantiations();

		/**
		 * The meta object literal for the '<em><b>Available Protections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__AVAILABLE_PROTECTIONS = eINSTANCE.getModel_AvailableProtections();

		/**
		 * The meta object literal for the '<em><b>Available Second Level Protections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__AVAILABLE_SECOND_LEVEL_PROTECTIONS = eINSTANCE.getModel_AvailableSecondLevelProtections();

		/**
		 * The meta object literal for the '<em><b>Assets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ASSETS = eINSTANCE.getModel_Assets();

		/**
		 * The meta object literal for the '<em><b>Attacker</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTACKER = eINSTANCE.getModel_Attacker();

		/**
		 * The meta object literal for the '<em><b>Attacker Tool Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTACKER_TOOL_TYPES = eINSTANCE.getModel_AttackerToolTypes();

		/**
		 * The meta object literal for the '<em><b>Attacker Tools</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTACKER_TOOLS = eINSTANCE.getModel_AttackerTools();

		/**
		 * The meta object literal for the '<em><b>Vanilla Solution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__VANILLA_SOLUTION = eINSTANCE.getModel_VanillaSolution();

		/**
		 * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__SOLUTIONS = eINSTANCE.getModel_Solutions();

		/**
		 * The meta object literal for the '<em><b>Available Tools</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__AVAILABLE_TOOLS = eINSTANCE.getModel_AvailableTools();

		/**
		 * The meta object literal for the '<em><b>Application Parts Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__APPLICATION_PARTS_COUNT = eINSTANCE.getModel_ApplicationPartsCount();

		/**
		 * The meta object literal for the '<em><b>All Application Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ALL_APPLICATION_PARTS = eINSTANCE.getModel_AllApplicationParts();

		/**
		 * The meta object literal for the '<em><b>Assets Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ASSETS_COUNT = eINSTANCE.getModel_AssetsCount();

		/**
		 * The meta object literal for the '<em><b>Data Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__DATA_COUNT = eINSTANCE.getModel_DataCount();

		/**
		 * The meta object literal for the '<em><b>Codes Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__CODES_COUNT = eINSTANCE.getModel_CodesCount();

		/**
		 * The meta object literal for the '<em><b>Protections Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__PROTECTIONS_COUNT = eINSTANCE.getModel_ProtectionsCount();

		/**
		 * The meta object literal for the '<em><b>Attacker Tools Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ATTACKER_TOOLS_COUNT = eINSTANCE.getModel_AttackerToolsCount();

		/**
		 * The meta object literal for the '<em><b>Attacker Tool Types Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ATTACKER_TOOL_TYPES_COUNT = eINSTANCE.getModel_AttackerToolTypesCount();

		/**
		 * The meta object literal for the '<em><b>Available Attacker Tools Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__AVAILABLE_ATTACKER_TOOLS_COUNT = eINSTANCE.getModel_AvailableAttackerToolsCount();

		/**
		 * The meta object literal for the '<em><b>Available Protections Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__AVAILABLE_PROTECTIONS_COUNT = eINSTANCE.getModel_AvailableProtectionsCount();

		/**
		 * The meta object literal for the '<em><b>Attack Paths Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ATTACK_PATHS_COUNT = eINSTANCE.getModel_AttackPathsCount();

		/**
		 * The meta object literal for the '<em><b>Attack Steps Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ATTACK_STEPS_COUNT = eINSTANCE.getModel_AttackStepsCount();

		/**
		 * The meta object literal for the '<em><b>Attack Step Types Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ATTACK_STEP_TYPES_COUNT = eINSTANCE.getModel_AttackStepTypesCount();

		/**
		 * The meta object literal for the '<em><b>Protection Objectives Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__PROTECTION_OBJECTIVES_COUNT = eINSTANCE.getModel_ProtectionObjectivesCount();

		/**
		 * The meta object literal for the '<em><b>Applied Protection Instantiations Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__APPLIED_PROTECTION_INSTANTIATIONS_COUNT = eINSTANCE.getModel_AppliedProtectionInstantiationsCount();

		/**
		 * The meta object literal for the '<em><b>Protection Instantiations Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__PROTECTION_INSTANTIATIONS_COUNT = eINSTANCE.getModel_ProtectionInstantiationsCount();

		/**
		 * The meta object literal for the '<em><b>Solutions Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__SOLUTIONS_COUNT = eINSTANCE.getModel_SolutionsCount();

		/**
		 * The meta object literal for the '<em><b>Key Attack Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__KEY_ATTACK_PATHS = eINSTANCE.getModel_KeyAttackPaths();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl <em>Application Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPart()
		 * @generated
		 */
		EClass APPLICATION_PART = eINSTANCE.getApplicationPart();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__ID = eINSTANCE.getApplicationPart_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__NAME = eINSTANCE.getApplicationPart_Name();

		/**
		 * The meta object literal for the '<em><b>Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__SETS = eINSTANCE.getApplicationPart_Sets();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__TYPE = eINSTANCE.getApplicationPart_Type();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__INDEX = eINSTANCE.getApplicationPart_Index();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__PROPERTIES = eINSTANCE.getApplicationPart_Properties();

		/**
		 * The meta object literal for the '<em><b>Source File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__SOURCE_FILE_PATH = eINSTANCE.getApplicationPart_SourceFilePath();

		/**
		 * The meta object literal for the '<em><b>Declaring Code</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__DECLARING_CODE = eINSTANCE.getApplicationPart_DeclaringCode();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__START_LINE = eINSTANCE.getApplicationPart_StartLine();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__END_LINE = eINSTANCE.getApplicationPart_EndLine();

		/**
		 * The meta object literal for the '<em><b>Datum Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__DATUM_SIZE = eINSTANCE.getApplicationPart_DatumSize();

		/**
		 * The meta object literal for the '<em><b>In System File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__IN_SYSTEM_FILE = eINSTANCE.getApplicationPart_InSystemFile();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__GLOBAL = eINSTANCE.getApplicationPart_Global();

		/**
		 * The meta object literal for the '<em><b>Short Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__SHORT_LOCATION = eINSTANCE.getApplicationPart_ShortLocation();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__WEIGHT = eINSTANCE.getApplicationPart_Weight();

		/**
		 * The meta object literal for the '<em><b>Security Properties</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__SECURITY_PROPERTIES = eINSTANCE.getApplicationPart_SecurityProperties();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__PARAMETERS = eINSTANCE.getApplicationPart_Parameters();

		/**
		 * The meta object literal for the '<em><b>Asset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__ASSET = eINSTANCE.getApplicationPart_Asset();

		/**
		 * The meta object literal for the '<em><b>Application Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__APPLICATION_PARTS = eINSTANCE.getApplicationPart_ApplicationParts();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__USES = eINSTANCE.getApplicationPart_Uses();

		/**
		 * The meta object literal for the '<em><b>Target Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__TARGET_OF = eINSTANCE.getApplicationPart_TargetOf();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__BODY = eINSTANCE.getApplicationPart_Body();

		/**
		 * The meta object literal for the '<em><b>Application Parts Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART__APPLICATION_PARTS_COUNT = eINSTANCE.getApplicationPart_ApplicationPartsCount();

		/**
		 * The meta object literal for the '<em><b>Assets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART__ASSETS = eINSTANCE.getApplicationPart_Assets();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___CONTAINS__APPLICATIONPART = eINSTANCE.getApplicationPart__Contains__ApplicationPart();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___HASH_CODE = eINSTANCE.getApplicationPart__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___EQUALS__OBJECT = eINSTANCE.getApplicationPart__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___TO_STRING = eINSTANCE.getApplicationPart__ToString();

		/**
		 * The meta object literal for the '<em><b>Is Datum</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___IS_DATUM = eINSTANCE.getApplicationPart__IsDatum();

		/**
		 * The meta object literal for the '<em><b>Is Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___IS_CODE = eINSTANCE.getApplicationPart__IsCode();

		/**
		 * The meta object literal for the '<em><b>Contains Asset</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART___CONTAINS_ASSET = eINSTANCE.getApplicationPart__ContainsAsset();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl <em>Use Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.UseTargetImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getUseTarget()
		 * @generated
		 */
		EClass USE_TARGET = eINSTANCE.getUseTarget();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_TARGET__TARGET = eINSTANCE.getUseTarget_Target();

		/**
		 * The meta object literal for the '<em><b>Used By</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_TARGET__USED_BY = eINSTANCE.getUseTarget_UsedBy();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_TARGET__LINE = eINSTANCE.getUseTarget_Line();

		/**
		 * The meta object literal for the '<em><b>Source File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_TARGET__SOURCE_FILE_PATH = eINSTANCE.getUseTarget_SourceFilePath();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_TARGET__TYPE = eINSTANCE.getUseTarget_Type();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_TARGET__PARAMETERS = eINSTANCE.getUseTarget_Parameters();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USE_TARGET___HASH_CODE = eINSTANCE.getUseTarget__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation USE_TARGET___EQUALS__OBJECT = eINSTANCE.getUseTarget__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackStepImpl <em>Attack Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackStepImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackStep()
		 * @generated
		 */
		EClass ATTACK_STEP = eINSTANCE.getAttackStep();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_STEP__NAME = eINSTANCE.getAttackStep_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_STEP__TYPE = eINSTANCE.getAttackStep_Type();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_STEP__FORMULA = eINSTANCE.getAttackStep_Formula();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_STEP__TRANSITION = eINSTANCE.getAttackStep_Transition();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_STEP___HASH_CODE = eINSTANCE.getAttackStep__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_STEP___EQUALS__OBJECT = eINSTANCE.getAttackStep__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_STEP___TO_STRING = eINSTANCE.getAttackStep__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackStepTypeImpl <em>Attack Step Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackStepTypeImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackStepType()
		 * @generated
		 */
		EClass ATTACK_STEP_TYPE = eINSTANCE.getAttackStepType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_STEP_TYPE__NAME = eINSTANCE.getAttackStepType_Name();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_STEP_TYPE__REGEX = eINSTANCE.getAttackStepType_Regex();

		/**
		 * The meta object literal for the '<em><b>Attacker Tools</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_STEP_TYPE__ATTACKER_TOOLS = eINSTANCE.getAttackStepType_AttackerTools();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_STEP_TYPE___HASH_CODE = eINSTANCE.getAttackStepType__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_STEP_TYPE___EQUALS__OBJECT = eINSTANCE.getAttackStepType__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_STEP_TYPE___TO_STRING = eINSTANCE.getAttackStepType__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackPathImpl <em>Attack Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackPathImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackPath()
		 * @generated
		 */
		EClass ATTACK_PATH = eINSTANCE.getAttackPath();

		/**
		 * The meta object literal for the '<em><b>Attack Steps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_PATH__ATTACK_STEPS = eINSTANCE.getAttackPath_AttackSteps();

		/**
		 * The meta object literal for the '<em><b>Protection Objectives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_PATH__PROTECTION_OBJECTIVES = eINSTANCE.getAttackPath_ProtectionObjectives();

		/**
		 * The meta object literal for the '<em><b>Attacker Tool Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_PATH__ATTACKER_TOOL_TYPES = eINSTANCE.getAttackPath_AttackerToolTypes();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_PATH__COST = eINSTANCE.getAttackPath_Cost();

		/**
		 * The meta object literal for the '<em><b>Applied Protection Instantiations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS = eINSTANCE.getAttackPath_AppliedProtectionInstantiations();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_PATH__KEY = eINSTANCE.getAttackPath_Key();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_PATH__ID = eINSTANCE.getAttackPath_Id();

		/**
		 * The meta object literal for the '<em><b>Mitigations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_PATH__MITIGATIONS = eINSTANCE.getAttackPath_Mitigations();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_PATH__LEVEL = eINSTANCE.getAttackPath_Level();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_PATH___HASH_CODE = eINSTANCE.getAttackPath__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_PATH___EQUALS__OBJECT = eINSTANCE.getAttackPath__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_PATH___TO_STRING = eINSTANCE.getAttackPath__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl <em>Attack Mitigation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackMitigation()
		 * @generated
		 */
		EClass ATTACK_MITIGATION = eINSTANCE.getAttackMitigation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_MITIGATION__NAME = eINSTANCE.getAttackMitigation_Name();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_MITIGATION__LEVEL = eINSTANCE.getAttackMitigation_Level();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_MITIGATION__TYPE = eINSTANCE.getAttackMitigation_Type();

		/**
		 * The meta object literal for the '<em><b>Attack Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_MITIGATION__ATTACK_PATHS = eINSTANCE.getAttackMitigation_AttackPaths();

		/**
		 * The meta object literal for the '<em><b>Protection</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK_MITIGATION__PROTECTION = eINSTANCE.getAttackMitigation_Protection();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_MITIGATION___HASH_CODE = eINSTANCE.getAttackMitigation__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACK_MITIGATION___EQUALS__OBJECT = eINSTANCE.getAttackMitigation__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ProtectionImpl <em>Protection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ProtectionImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtection()
		 * @generated
		 */
		EClass PROTECTION = eINSTANCE.getProtection();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__ID = eINSTANCE.getProtection_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__NAME = eINSTANCE.getProtection_Name();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__ENABLED = eINSTANCE.getProtection_Enabled();

		/**
		 * The meta object literal for the '<em><b>Automatically Deployable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__AUTOMATICALLY_DEPLOYABLE = eINSTANCE.getProtection_AutomaticallyDeployable();

		/**
		 * The meta object literal for the '<em><b>Second Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__SECOND_LEVEL = eINSTANCE.getProtection_SecondLevel();

		/**
		 * The meta object literal for the '<em><b>Second Level Enlargment Usefulness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS = eINSTANCE.getProtection_SecondLevelEnlargmentUsefulness();

		/**
		 * The meta object literal for the '<em><b>Second Level Call Graph Enlargment Usefulness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS = eINSTANCE.getProtection_SecondLevelCallGraphEnlargmentUsefulness();

		/**
		 * The meta object literal for the '<em><b>Second Level Repetition Usefulness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS = eINSTANCE.getProtection_SecondLevelRepetitionUsefulness();

		/**
		 * The meta object literal for the '<em><b>Second Level Repetition Instantiation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION = eINSTANCE.getProtection_SecondLevelRepetitionInstantiation();

		/**
		 * The meta object literal for the '<em><b>Application Part Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__APPLICATION_PART_TYPES = eINSTANCE.getProtection_ApplicationPartTypes();

		/**
		 * The meta object literal for the '<em><b>Mitigations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__MITIGATIONS = eINSTANCE.getProtection_Mitigations();

		/**
		 * The meta object literal for the '<em><b>Enforced Security Requirements</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__ENFORCED_SECURITY_REQUIREMENTS = eINSTANCE.getProtection_EnforcedSecurityRequirements();

		/**
		 * The meta object literal for the '<em><b>Forbidden Precedences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__FORBIDDEN_PRECEDENCES = eINSTANCE.getProtection_ForbiddenPrecedences();

		/**
		 * The meta object literal for the '<em><b>Discouraged Precedences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__DISCOURAGED_PRECEDENCES = eINSTANCE.getProtection_DiscouragedPrecedences();

		/**
		 * The meta object literal for the '<em><b>Encouraged Precedences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__ENCOURAGED_PRECEDENCES = eINSTANCE.getProtection_EncouragedPrecedences();

		/**
		 * The meta object literal for the '<em><b>Actc Precedences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__ACTC_PRECEDENCES = eINSTANCE.getProtection_ActcPrecedences();

		/**
		 * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__SINGLETON = eINSTANCE.getProtection_Singleton();

		/**
		 * The meta object literal for the '<em><b>Defeated Attacker Tool Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES = eINSTANCE.getProtection_DefeatedAttackerToolTypes();

		/**
		 * The meta object literal for the '<em><b>Blocked Attacker Tool Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES = eINSTANCE.getProtection_BlockedAttackerToolTypes();

		/**
		 * The meta object literal for the '<em><b>Instantiations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION__INSTANTIATIONS = eINSTANCE.getProtection_Instantiations();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__ACTIONS = eINSTANCE.getProtection_Actions();

		/**
		 * The meta object literal for the '<em><b>Flags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__FLAGS = eINSTANCE.getProtection_Flags();

		/**
		 * The meta object literal for the '<em><b>Instantiations Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION__INSTANTIATIONS_COUNT = eINSTANCE.getProtection_InstantiationsCount();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION___HASH_CODE = eINSTANCE.getProtection__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION___EQUALS__OBJECT = eINSTANCE.getProtection__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION___TO_STRING = eINSTANCE.getProtection__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl <em>Protection Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtectionInstantiation()
		 * @generated
		 */
		EClass PROTECTION_INSTANTIATION = eINSTANCE.getProtectionInstantiation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__NAME = eINSTANCE.getProtectionInstantiation_Name();

		/**
		 * The meta object literal for the '<em><b>Protection</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION_INSTANTIATION__PROTECTION = eINSTANCE.getProtectionInstantiation_Protection();

		/**
		 * The meta object literal for the '<em><b>Variable Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION = eINSTANCE.getProtectionInstantiation_VariableAnnotation();

		/**
		 * The meta object literal for the '<em><b>Code Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__CODE_ANNOTATION = eINSTANCE.getProtectionInstantiation_CodeAnnotation();

		/**
		 * The meta object literal for the '<em><b>Verifier Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION = eINSTANCE.getProtectionInstantiation_VerifierAnnotation();

		/**
		 * The meta object literal for the '<em><b>Attestator Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION = eINSTANCE.getProtectionInstantiation_AttestatorAnnotation();

		/**
		 * The meta object literal for the '<em><b>Client Time Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD = eINSTANCE.getProtectionInstantiation_ClientTimeOverhead();

		/**
		 * The meta object literal for the '<em><b>Server Time Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD = eINSTANCE.getProtectionInstantiation_ServerTimeOverhead();

		/**
		 * The meta object literal for the '<em><b>Client Memory Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD = eINSTANCE.getProtectionInstantiation_ClientMemoryOverhead();

		/**
		 * The meta object literal for the '<em><b>Server Memory Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD = eINSTANCE.getProtectionInstantiation_ServerMemoryOverhead();

		/**
		 * The meta object literal for the '<em><b>Network Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_INSTANTIATION__NETWORK_OVERHEAD = eINSTANCE.getProtectionInstantiation_NetworkOverhead();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION_INSTANTIATION___HASH_CODE = eINSTANCE.getProtectionInstantiation__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION_INSTANTIATION___EQUALS__OBJECT = eINSTANCE.getProtectionInstantiation__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION_INSTANTIATION___TO_STRING = eINSTANCE.getProtectionInstantiation__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackerImpl <em>Attacker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackerImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttacker()
		 * @generated
		 */
		EClass ATTACKER = eINSTANCE.getAttacker();

		/**
		 * The meta object literal for the '<em><b>Expertise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER__EXPERTISE = eINSTANCE.getAttacker_Expertise();

		/**
		 * The meta object literal for the '<em><b>Budget Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER__BUDGET_LIMIT = eINSTANCE.getAttacker_BudgetLimit();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER___HASH_CODE = eINSTANCE.getAttacker__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER___EQUALS__OBJECT = eINSTANCE.getAttacker__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl <em>Attacker Tool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackerToolImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackerTool()
		 * @generated
		 */
		EClass ATTACKER_TOOL = eINSTANCE.getAttackerTool();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_TOOL__NAME = eINSTANCE.getAttackerTool_Name();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACKER_TOOL__TYPES = eINSTANCE.getAttackerTool_Types();

		/**
		 * The meta object literal for the '<em><b>Expertise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_TOOL__EXPERTISE = eINSTANCE.getAttackerTool_Expertise();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_TOOL__COST = eINSTANCE.getAttackerTool_Cost();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_TOOL__ENABLED = eINSTANCE.getAttackerTool_Enabled();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER_TOOL___HASH_CODE = eINSTANCE.getAttackerTool__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER_TOOL___EQUALS__OBJECT = eINSTANCE.getAttackerTool__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AttackerToolTypeImpl <em>Attacker Tool Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AttackerToolTypeImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackerToolType()
		 * @generated
		 */
		EClass ATTACKER_TOOL_TYPE = eINSTANCE.getAttackerToolType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACKER_TOOL_TYPE__NAME = eINSTANCE.getAttackerToolType_Name();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER_TOOL_TYPE___HASH_CODE = eINSTANCE.getAttackerToolType__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER_TOOL_TYPE___EQUALS__OBJECT = eINSTANCE.getAttackerToolType__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ATTACKER_TOOL_TYPE___TO_STRING = eINSTANCE.getAttackerToolType__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.PreferencesImpl <em>Preferences</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.PreferencesImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getPreferences()
		 * @generated
		 */
		EClass PREFERENCES = eINSTANCE.getPreferences();

		/**
		 * The meta object literal for the '<em><b>Working Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__WORKING_DIRECTORY = eINSTANCE.getPreferences_WorkingDirectory();

		/**
		 * The meta object literal for the '<em><b>Actc Configuration File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ACTC_CONFIGURATION_FILE = eINSTANCE.getPreferences_ActcConfigurationFile();

		/**
		 * The meta object literal for the '<em><b>Adss Patch File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ADSS_PATCH_FILE = eINSTANCE.getPreferences_AdssPatchFile();

		/**
		 * The meta object literal for the '<em><b>Adss JSON File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ADSS_JSON_FILE = eINSTANCE.getPreferences_AdssJSONFile();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ARCHITECTURE = eINSTANCE.getPreferences_Architecture();

		/**
		 * The meta object literal for the '<em><b>Remote Connection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__REMOTE_CONNECTION = eINSTANCE.getPreferences_RemoteConnection();

		/**
		 * The meta object literal for the '<em><b>Remote Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__REMOTE_USERNAME = eINSTANCE.getPreferences_RemoteUsername();

		/**
		 * The meta object literal for the '<em><b>Remote Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__REMOTE_PASSWORD = eINSTANCE.getPreferences_RemotePassword();

		/**
		 * The meta object literal for the '<em><b>Remote Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__REMOTE_HOST = eINSTANCE.getPreferences_RemoteHost();

		/**
		 * The meta object literal for the '<em><b>Remote Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__REMOTE_PORT = eINSTANCE.getPreferences_RemotePort();

		/**
		 * The meta object literal for the '<em><b>Remote File Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__REMOTE_FILE_SEPARATOR = eINSTANCE.getPreferences_RemoteFileSeparator();

		/**
		 * The meta object literal for the '<em><b>Command ACTC</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__COMMAND_ACTC = eINSTANCE.getPreferences_CommandACTC();

		/**
		 * The meta object literal for the '<em><b>Command Perl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__COMMAND_PERL = eINSTANCE.getPreferences_CommandPerl();

		/**
		 * The meta object literal for the '<em><b>Command Dot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__COMMAND_DOT = eINSTANCE.getPreferences_CommandDot();

		/**
		 * The meta object literal for the '<em><b>Metrics File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__METRICS_FILE = eINSTANCE.getPreferences_MetricsFile();

		/**
		 * The meta object literal for the '<em><b>Parser Header Parsing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__PARSER_HEADER_PARSING = eINSTANCE.getPreferences_ParserHeaderParsing();

		/**
		 * The meta object literal for the '<em><b>Parser System Files Ignoration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION = eINSTANCE.getPreferences_ParserSystemFilesIgnoration();

		/**
		 * The meta object literal for the '<em><b>Attacks Time Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ATTACKS_TIME_LIMIT = eINSTANCE.getPreferences_AttacksTimeLimit();

		/**
		 * The meta object literal for the '<em><b>Attacks Maximum Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ATTACKS_MAXIMUM_DEPTH = eINSTANCE.getPreferences_AttacksMaximumDepth();

		/**
		 * The meta object literal for the '<em><b>Attacks Included Protection Objectives Removal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL = eINSTANCE.getPreferences_AttacksIncludedProtectionObjectivesRemoval();

		/**
		 * The meta object literal for the '<em><b>Protections Minimum Attack Mitigation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION = eINSTANCE.getPreferences_ProtectionsMinimumAttackMitigation();

		/**
		 * The meta object literal for the '<em><b>Client Time Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__CLIENT_TIME_OVERHEAD = eINSTANCE.getPreferences_ClientTimeOverhead();

		/**
		 * The meta object literal for the '<em><b>Server Time Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__SERVER_TIME_OVERHEAD = eINSTANCE.getPreferences_ServerTimeOverhead();

		/**
		 * The meta object literal for the '<em><b>Client Memory Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__CLIENT_MEMORY_OVERHEAD = eINSTANCE.getPreferences_ClientMemoryOverhead();

		/**
		 * The meta object literal for the '<em><b>Server Memory Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__SERVER_MEMORY_OVERHEAD = eINSTANCE.getPreferences_ServerMemoryOverhead();

		/**
		 * The meta object literal for the '<em><b>Network Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__NETWORK_OVERHEAD = eINSTANCE.getPreferences_NetworkOverhead();

		/**
		 * The meta object literal for the '<em><b>L1p Solutions Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_SOLUTIONS_COUNT = eINSTANCE.getPreferences_L1pSolutionsCount();

		/**
		 * The meta object literal for the '<em><b>L1p Petri Nets Pass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_PETRI_NETS_PASS = eINSTANCE.getPreferences_L1pPetriNetsPass();

		/**
		 * The meta object literal for the '<em><b>L1p Time Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_TIME_LIMIT = eINSTANCE.getPreferences_L1pTimeLimit();

		/**
		 * The meta object literal for the '<em><b>L1p Solutions Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_SOLUTIONS_LIMIT = eINSTANCE.getPreferences_L1pSolutionsLimit();

		/**
		 * The meta object literal for the '<em><b>L1p Gap Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_GAP_LIMIT = eINSTANCE.getPreferences_L1pGapLimit();

		/**
		 * The meta object literal for the '<em><b>L1p Client Time Overhead Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE = eINSTANCE.getPreferences_L1pClientTimeOverheadPercentage();

		/**
		 * The meta object literal for the '<em><b>L1p Server Time Overhead Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE = eINSTANCE.getPreferences_L1pServerTimeOverheadPercentage();

		/**
		 * The meta object literal for the '<em><b>L1p Client Memory Overhead Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE = eINSTANCE.getPreferences_L1pClientMemoryOverheadPercentage();

		/**
		 * The meta object literal for the '<em><b>L1p Server Memory Overhead Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE = eINSTANCE.getPreferences_L1pServerMemoryOverheadPercentage();

		/**
		 * The meta object literal for the '<em><b>L1p Network Overhead Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE = eINSTANCE.getPreferences_L1pNetworkOverheadPercentage();

		/**
		 * The meta object literal for the '<em><b>L1p Discouraged Precedences Ignoration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION = eINSTANCE.getPreferences_L1pDiscouragedPrecedencesIgnoration();

		/**
		 * The meta object literal for the '<em><b>L1p Encouraged Precedences Focusing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING = eINSTANCE.getPreferences_L1pEncouragedPrecedencesFocusing();

		/**
		 * The meta object literal for the '<em><b>L1p Use ACTC Precedences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_USE_ACTC_PRECEDENCES = eINSTANCE.getPreferences_L1pUseACTCPrecedences();

		/**
		 * The meta object literal for the '<em><b>L1p Ignore Application Part Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER = eINSTANCE.getPreferences_L1pIgnoreApplicationPartOrder();

		/**
		 * The meta object literal for the '<em><b>L1p Maximum Instantiations Per Protection Objective</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE = eINSTANCE.getPreferences_L1pMaximumInstantiationsPerProtectionObjective();

		/**
		 * The meta object literal for the '<em><b>L1p Main Search Maximum Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH = eINSTANCE.getPreferences_L1pMainSearchMaximumDepth();

		/**
		 * The meta object literal for the '<em><b>L1p Multi Tree</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_MULTI_TREE = eINSTANCE.getPreferences_L1pMultiTree();

		/**
		 * The meta object literal for the '<em><b>L1p Initial Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_INITIAL_ALPHA = eINSTANCE.getPreferences_L1pInitialAlpha();

		/**
		 * The meta object literal for the '<em><b>L1p Initial Beta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_INITIAL_BETA = eINSTANCE.getPreferences_L1pInitialBeta();

		/**
		 * The meta object literal for the '<em><b>L1p Research Delta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_RESEARCH_DELTA = eINSTANCE.getPreferences_L1pResearchDelta();

		/**
		 * The meta object literal for the '<em><b>L1p Transposition Table Maximum Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE = eINSTANCE.getPreferences_L1pTranspositionTableMaximumSize();

		/**
		 * The meta object literal for the '<em><b>L2p Solutions Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_SOLUTIONS_COUNT = eINSTANCE.getPreferences_L2pSolutionsCount();

		/**
		 * The meta object literal for the '<em><b>L2p Function Splitting Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_FUNCTION_SPLITTING_SEED = eINSTANCE.getPreferences_L2pFunctionSplittingSeed();

		/**
		 * The meta object literal for the '<em><b>L2p Solution Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_SOLUTION_LIMIT = eINSTANCE.getPreferences_L2pSolutionLimit();

		/**
		 * The meta object literal for the '<em><b>L2p Time Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_TIME_LIMIT = eINSTANCE.getPreferences_L2pTimeLimit();

		/**
		 * The meta object literal for the '<em><b>L2p Gap Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_GAP_LIMIT = eINSTANCE.getPreferences_L2pGapLimit();

		/**
		 * The meta object literal for the '<em><b>L2p Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_UPPER_BOUND = eINSTANCE.getPreferences_L2pUpperBound();

		/**
		 * The meta object literal for the '<em><b>L2p Function Splitting Medium Code Block Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH = eINSTANCE.getPreferences_L2pFunctionSplittingMediumCodeBlockLength();

		/**
		 * The meta object literal for the '<em><b>L2p Function Splitting Code Block Length Randomization Denominator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR = eINSTANCE.getPreferences_L2pFunctionSplittingCodeBlockLengthRandomizationDenominator();

		/**
		 * The meta object literal for the '<em><b>L2p Function Splitting Depth Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL = eINSTANCE.getPreferences_L2pFunctionSplittingDepthLevel();

		/**
		 * The meta object literal for the '<em><b>Set PN Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__SET_PN_DIRECTORY = eINSTANCE.getPreferences_SetPNDirectory();

		/**
		 * The meta object literal for the '<em><b>Set PN File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCES__SET_PN_FILE = eINSTANCE.getPreferences_SetPNFile();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PREFERENCES___HASH_CODE = eINSTANCE.getPreferences__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PREFERENCES___EQUALS__OBJECT = eINSTANCE.getPreferences__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl <em>Applied Protection Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAppliedProtectionInstantiation()
		 * @generated
		 */
		EClass APPLIED_PROTECTION_INSTANTIATION = eINSTANCE.getAppliedProtectionInstantiation();

		/**
		 * The meta object literal for the '<em><b>Protection Instantiation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION = eINSTANCE.getAppliedProtectionInstantiation_ProtectionInstantiation();

		/**
		 * The meta object literal for the '<em><b>Application Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART = eINSTANCE.getAppliedProtectionInstantiation_ApplicationPart();

		/**
		 * The meta object literal for the '<em><b>Protection Objectives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES = eINSTANCE.getAppliedProtectionInstantiation_ProtectionObjectives();

		/**
		 * The meta object literal for the '<em><b>Attack Mitigations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS = eINSTANCE.getAppliedProtectionInstantiation_AttackMitigations();

		/**
		 * The meta object literal for the '<em><b>Second Level Motivation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION = eINSTANCE.getAppliedProtectionInstantiation_SecondLevelMotivation();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLIED_PROTECTION_INSTANTIATION___TO_STRING = eINSTANCE.getAppliedProtectionInstantiation__ToString();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLIED_PROTECTION_INSTANTIATION___HASH_CODE = eINSTANCE.getAppliedProtectionInstantiation__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLIED_PROTECTION_INSTANTIATION___EQUALS__OBJECT = eINSTANCE.getAppliedProtectionInstantiation__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.SecondLevelMotivationImpl <em>Second Level Motivation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.SecondLevelMotivationImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSecondLevelMotivation()
		 * @generated
		 */
		EClass SECOND_LEVEL_MOTIVATION = eINSTANCE.getSecondLevelMotivation();

		/**
		 * The meta object literal for the '<em><b>Motivation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE = eINSTANCE.getSecondLevelMotivation_MotivationType();

		/**
		 * The meta object literal for the '<em><b>First Level Applied Protection Instantiations</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS = eINSTANCE.getSecondLevelMotivation_FirstLevelAppliedProtectionInstantiations();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SECOND_LEVEL_MOTIVATION___TO_STRING = eINSTANCE.getSecondLevelMotivation__ToString();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SECOND_LEVEL_MOTIVATION___HASH_CODE = eINSTANCE.getSecondLevelMotivation__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SECOND_LEVEL_MOTIVATION___EQUALS__OBJECT = eINSTANCE.getSecondLevelMotivation__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.SolutionSequenceImpl <em>Solution Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.SolutionSequenceImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSolutionSequence()
		 * @generated
		 */
		EClass SOLUTION_SEQUENCE = eINSTANCE.getSolutionSequence();

		/**
		 * The meta object literal for the '<em><b>Applied Protection Instantiations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS = eINSTANCE.getSolutionSequence_AppliedProtectionInstantiations();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOLUTION_SEQUENCE___TO_STRING = eINSTANCE.getSolutionSequence__ToString();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOLUTION_SEQUENCE___HASH_CODE = eINSTANCE.getSolutionSequence__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOLUTION_SEQUENCE___EQUALS__OBJECT = eINSTANCE.getSolutionSequence__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.SolutionImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>Solution Sequences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__SOLUTION_SEQUENCES = eINSTANCE.getSolution_SolutionSequences();

		/**
		 * The meta object literal for the '<em><b>Application Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__APPLICATION_METRICS = eINSTANCE.getSolution_ApplicationMetrics();

		/**
		 * The meta object literal for the '<em><b>Application Part Metric Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__APPLICATION_PART_METRIC_SETS = eINSTANCE.getSolution_ApplicationPartMetricSets();

		/**
		 * The meta object literal for the '<em><b>First Level Solution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__FIRST_LEVEL_SOLUTION = eINSTANCE.getSolution_FirstLevelSolution();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__SCORE = eINSTANCE.getSolution_Score();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__ID = eINSTANCE.getSolution_Id();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOLUTION___TO_STRING = eINSTANCE.getSolution__ToString();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOLUTION___HASH_CODE = eINSTANCE.getSolution__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SOLUTION___EQUALS__OBJECT = eINSTANCE.getSolution__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartMetricSetImpl <em>Application Part Metric Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ApplicationPartMetricSetImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPartMetricSet()
		 * @generated
		 */
		EClass APPLICATION_PART_METRIC_SET = eINSTANCE.getApplicationPartMetricSet();

		/**
		 * The meta object literal for the '<em><b>Application Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART_METRIC_SET__APPLICATION_PART = eINSTANCE.getApplicationPartMetricSet_ApplicationPart();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART_METRIC_SET__METRICS = eINSTANCE.getApplicationPartMetricSet_Metrics();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART_METRIC_SET___HASH_CODE = eINSTANCE.getApplicationPartMetricSet__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART_METRIC_SET___EQUALS__OBJECT = eINSTANCE.getApplicationPartMetricSet__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.MetricImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__VALUE = eINSTANCE.getMetric_Value();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation METRIC___HASH_CODE = eINSTANCE.getMetric__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation METRIC___EQUALS__OBJECT = eINSTANCE.getMetric__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl <em>Code Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.CodeBlockImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getCodeBlock()
		 * @generated
		 */
		EClass CODE_BLOCK = eINSTANCE.getCodeBlock();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__TYPE = eINSTANCE.getCodeBlock_Type();

		/**
		 * The meta object literal for the '<em><b>Code Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_BLOCK__CODE_BLOCKS = eINSTANCE.getCodeBlock_CodeBlocks();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__START_LINE = eINSTANCE.getCodeBlock_StartLine();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__END_LINE = eINSTANCE.getCodeBlock_EndLine();

		/**
		 * The meta object literal for the '<em><b>Source File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_BLOCK__SOURCE_FILE_PATH = eINSTANCE.getCodeBlock_SourceFilePath();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODE_BLOCK___HASH_CODE = eINSTANCE.getCodeBlock__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODE_BLOCK___EQUALS__OBJECT = eINSTANCE.getCodeBlock__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.RuleImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__ACTION = eINSTANCE.getRule_Action();

		/**
		 * The meta object literal for the '<em><b>Function Declarations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__FUNCTION_DECLARATIONS = eINSTANCE.getRule_FunctionDeclarations();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RULE___HASH_CODE = eINSTANCE.getRule__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RULE___EQUALS__OBJECT = eINSTANCE.getRule__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.FunctionDeclarationImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getFunctionDeclaration()
		 * @generated
		 */
		EClass FUNCTION_DECLARATION = eINSTANCE.getFunctionDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_DECLARATION__NAME = eINSTANCE.getFunctionDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_DECLARATION__PARAMETERS = eINSTANCE.getFunctionDeclaration_Parameters();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_DECLARATION___HASH_CODE = eINSTANCE.getFunctionDeclaration__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION_DECLARATION___EQUALS__OBJECT = eINSTANCE.getFunctionDeclaration__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartSetImpl <em>Application Part Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ApplicationPartSetImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPartSet()
		 * @generated
		 */
		EClass APPLICATION_PART_SET = eINSTANCE.getApplicationPartSet();

		/**
		 * The meta object literal for the '<em><b>Application Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_PART_SET__APPLICATION_PARTS = eINSTANCE.getApplicationPartSet_ApplicationParts();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_PART_SET__ACTION = eINSTANCE.getApplicationPartSet_Action();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART_SET___HASH_CODE = eINSTANCE.getApplicationPartSet__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation APPLICATION_PART_SET___EQUALS__OBJECT = eINSTANCE.getApplicationPartSet__Equals__Object();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.impl.ProtectionObjectiveImpl <em>Protection Objective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.impl.ProtectionObjectiveImpl
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtectionObjective()
		 * @generated
		 */
		EClass PROTECTION_OBJECTIVE = eINSTANCE.getProtectionObjective();

		/**
		 * The meta object literal for the '<em><b>Application Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTION_OBJECTIVE__APPLICATION_PART = eINSTANCE.getProtectionObjective_ApplicationPart();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTION_OBJECTIVE__PROPERTY = eINSTANCE.getProtectionObjective_Property();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION_OBJECTIVE___HASH_CODE = eINSTANCE.getProtectionObjective__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION_OBJECTIVE___EQUALS__OBJECT = eINSTANCE.getProtectionObjective__Equals__Object();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTION_OBJECTIVE___TO_STRING = eINSTANCE.getProtectionObjective__ToString();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.UseType <em>Use Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.UseType
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getUseType()
		 * @generated
		 */
		EEnum USE_TYPE = eINSTANCE.getUseType();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.Property <em>Property</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.Property
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProperty()
		 * @generated
		 */
		EEnum PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.ProtectionFlag <em>Protection Flag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.ProtectionFlag
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getProtectionFlag()
		 * @generated
		 */
		EEnum PROTECTION_FLAG = eINSTANCE.getProtectionFlag();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.ApplicationPartType <em>Application Part Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.ApplicationPartType
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getApplicationPartType()
		 * @generated
		 */
		EEnum APPLICATION_PART_TYPE = eINSTANCE.getApplicationPartType();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.Level <em>Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.Level
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getLevel()
		 * @generated
		 */
		EEnum LEVEL = eINSTANCE.getLevel();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.ExpertiseLevel <em>Expertise Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getExpertiseLevel()
		 * @generated
		 */
		EEnum EXPERTISE_LEVEL = eINSTANCE.getExpertiseLevel();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivationType <em>Second Level Motivation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivationType
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getSecondLevelMotivationType()
		 * @generated
		 */
		EEnum SECOND_LEVEL_MOTIVATION_TYPE = eINSTANCE.getSecondLevelMotivationType();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.CodeBlockType <em>Code Block Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.CodeBlockType
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getCodeBlockType()
		 * @generated
		 */
		EEnum CODE_BLOCK_TYPE = eINSTANCE.getCodeBlockType();

		/**
		 * The meta object literal for the '{@link eu.aspire_fp7.adss.akb.ActionType <em>Action Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.ActionType
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getActionType()
		 * @generated
		 */
		EEnum ACTION_TYPE = eINSTANCE.getActionType();

		/**
		 * The meta object literal for the '<em>Ontology</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.polito.security.ontologies.Ontology
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getOntology()
		 * @generated
		 */
		EDataType ONTOLOGY = eINSTANCE.getOntology();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em>Attack Step Type With Null</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.AttackStepType
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getAttackStepTypeWithNull()
		 * @generated
		 */
		EDataType ATTACK_STEP_TYPE_WITH_NULL = eINSTANCE.getAttackStepTypeWithNull();

		/**
		 * The meta object literal for the '<em>Level With Null</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aspire_fp7.adss.akb.Level
		 * @see eu.aspire_fp7.adss.akb.impl.AkbPackageImpl#getLevelWithNull()
		 * @generated
		 */
		EDataType LEVEL_WITH_NULL = eINSTANCE.getLevelWithNull();

	}

} //AkbPackage
