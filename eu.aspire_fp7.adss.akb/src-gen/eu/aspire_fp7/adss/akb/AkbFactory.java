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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage
 * @generated
 */
public interface AkbFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AkbFactory eINSTANCE = eu.aspire_fp7.adss.akb.impl.AkbFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Application Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Part</em>'.
	 * @generated
	 */
	ApplicationPart createApplicationPart();

	/**
	 * Returns a new object of class '<em>Use Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Target</em>'.
	 * @generated
	 */
	UseTarget createUseTarget();

	/**
	 * Returns a new object of class '<em>Attack Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attack Step</em>'.
	 * @generated
	 */
	AttackStep createAttackStep();

	/**
	 * Returns a new object of class '<em>Attack Step Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attack Step Type</em>'.
	 * @generated
	 */
	AttackStepType createAttackStepType();

	/**
	 * Returns a new object of class '<em>Attack Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attack Path</em>'.
	 * @generated
	 */
	AttackPath createAttackPath();

	/**
	 * Returns a new object of class '<em>Attack Mitigation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attack Mitigation</em>'.
	 * @generated
	 */
	AttackMitigation createAttackMitigation();

	/**
	 * Returns a new object of class '<em>Protection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protection</em>'.
	 * @generated
	 */
	Protection createProtection();

	/**
	 * Returns a new object of class '<em>Protection Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protection Instantiation</em>'.
	 * @generated
	 */
	ProtectionInstantiation createProtectionInstantiation();

	/**
	 * Returns a new object of class '<em>Attacker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attacker</em>'.
	 * @generated
	 */
	Attacker createAttacker();

	/**
	 * Returns a new object of class '<em>Attacker Tool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attacker Tool</em>'.
	 * @generated
	 */
	AttackerTool createAttackerTool();

	/**
	 * Returns a new object of class '<em>Attacker Tool Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attacker Tool Type</em>'.
	 * @generated
	 */
	AttackerToolType createAttackerToolType();

	/**
	 * Returns a new object of class '<em>Preferences</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preferences</em>'.
	 * @generated
	 */
	Preferences createPreferences();

	/**
	 * Returns a new object of class '<em>Applied Protection Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Applied Protection Instantiation</em>'.
	 * @generated
	 */
	AppliedProtectionInstantiation createAppliedProtectionInstantiation();

	/**
	 * Returns a new object of class '<em>Second Level Motivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Second Level Motivation</em>'.
	 * @generated
	 */
	SecondLevelMotivation createSecondLevelMotivation();

	/**
	 * Returns a new object of class '<em>Solution Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution Sequence</em>'.
	 * @generated
	 */
	SolutionSequence createSolutionSequence();

	/**
	 * Returns a new object of class '<em>Solution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solution</em>'.
	 * @generated
	 */
	Solution createSolution();

	/**
	 * Returns a new object of class '<em>Application Part Metric Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Part Metric Set</em>'.
	 * @generated
	 */
	ApplicationPartMetricSet createApplicationPartMetricSet();

	/**
	 * Returns a new object of class '<em>Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metric</em>'.
	 * @generated
	 */
	Metric createMetric();

	/**
	 * Returns a new object of class '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Block</em>'.
	 * @generated
	 */
	CodeBlock createCodeBlock();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Declaration</em>'.
	 * @generated
	 */
	FunctionDeclaration createFunctionDeclaration();

	/**
	 * Returns a new object of class '<em>Application Part Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Part Set</em>'.
	 * @generated
	 */
	ApplicationPartSet createApplicationPartSet();

	/**
	 * Returns a new object of class '<em>Protection Objective</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protection Objective</em>'.
	 * @generated
	 */
	ProtectionObjective createProtectionObjective();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AkbPackage getAkbPackage();

} //AkbFactory
