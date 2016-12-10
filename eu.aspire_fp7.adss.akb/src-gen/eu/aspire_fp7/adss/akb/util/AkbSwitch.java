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
package eu.aspire_fp7.adss.akb.util;

import eu.aspire_fp7.adss.akb.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage
 * @generated
 */
public class AkbSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AkbPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AkbSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = AkbPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case AkbPackage.MODEL:
			{
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.APPLICATION_PART:
			{
				ApplicationPart applicationPart = (ApplicationPart)theEObject;
				T result = caseApplicationPart(applicationPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.USE_TARGET:
			{
				UseTarget useTarget = (UseTarget)theEObject;
				T result = caseUseTarget(useTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACK_STEP:
			{
				AttackStep attackStep = (AttackStep)theEObject;
				T result = caseAttackStep(attackStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACK_STEP_TYPE:
			{
				AttackStepType attackStepType = (AttackStepType)theEObject;
				T result = caseAttackStepType(attackStepType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACK_PATH:
			{
				AttackPath attackPath = (AttackPath)theEObject;
				T result = caseAttackPath(attackPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACK_MITIGATION:
			{
				AttackMitigation attackMitigation = (AttackMitigation)theEObject;
				T result = caseAttackMitigation(attackMitigation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.PROTECTION:
			{
				Protection protection = (Protection)theEObject;
				T result = caseProtection(protection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.PROTECTION_INSTANTIATION:
			{
				ProtectionInstantiation protectionInstantiation = (ProtectionInstantiation)theEObject;
				T result = caseProtectionInstantiation(protectionInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACKER:
			{
				Attacker attacker = (Attacker)theEObject;
				T result = caseAttacker(attacker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACKER_TOOL:
			{
				AttackerTool attackerTool = (AttackerTool)theEObject;
				T result = caseAttackerTool(attackerTool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.ATTACKER_TOOL_TYPE:
			{
				AttackerToolType attackerToolType = (AttackerToolType)theEObject;
				T result = caseAttackerToolType(attackerToolType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.PREFERENCES:
			{
				Preferences preferences = (Preferences)theEObject;
				T result = casePreferences(preferences);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION:
			{
				AppliedProtectionInstantiation appliedProtectionInstantiation = (AppliedProtectionInstantiation)theEObject;
				T result = caseAppliedProtectionInstantiation(appliedProtectionInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.SECOND_LEVEL_MOTIVATION:
			{
				SecondLevelMotivation secondLevelMotivation = (SecondLevelMotivation)theEObject;
				T result = caseSecondLevelMotivation(secondLevelMotivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.SOLUTION_SEQUENCE:
			{
				SolutionSequence solutionSequence = (SolutionSequence)theEObject;
				T result = caseSolutionSequence(solutionSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.SOLUTION:
			{
				Solution solution = (Solution)theEObject;
				T result = caseSolution(solution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.APPLICATION_PART_METRIC_SET:
			{
				ApplicationPartMetricSet applicationPartMetricSet = (ApplicationPartMetricSet)theEObject;
				T result = caseApplicationPartMetricSet(applicationPartMetricSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.METRIC:
			{
				Metric metric = (Metric)theEObject;
				T result = caseMetric(metric);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.CODE_BLOCK:
			{
				CodeBlock codeBlock = (CodeBlock)theEObject;
				T result = caseCodeBlock(codeBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.RULE:
			{
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.FUNCTION_DECLARATION:
			{
				FunctionDeclaration functionDeclaration = (FunctionDeclaration)theEObject;
				T result = caseFunctionDeclaration(functionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.APPLICATION_PART_SET:
			{
				ApplicationPartSet applicationPartSet = (ApplicationPartSet)theEObject;
				T result = caseApplicationPartSet(applicationPartSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AkbPackage.PROTECTION_OBJECTIVE:
			{
				ProtectionObjective protectionObjective = (ProtectionObjective)theEObject;
				T result = caseProtectionObjective(protectionObjective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationPart(ApplicationPart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseTarget(UseTarget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackStep(AttackStep object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack Step Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack Step Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackStepType(AttackStepType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackPath(AttackPath object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack Mitigation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack Mitigation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackMitigation(AttackMitigation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtection(Protection object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protection Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protection Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtectionInstantiation(ProtectionInstantiation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attacker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attacker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttacker(Attacker object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attacker Tool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attacker Tool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackerTool(AttackerTool object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attacker Tool Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attacker Tool Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackerToolType(AttackerToolType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preferences</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preferences</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreferences(Preferences object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Applied Protection Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Applied Protection Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppliedProtectionInstantiation(AppliedProtectionInstantiation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Second Level Motivation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Second Level Motivation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecondLevelMotivation(SecondLevelMotivation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solution Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solution Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolutionSequence(SolutionSequence object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolution(Solution object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Part Metric Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Part Metric Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationPartMetricSet(ApplicationPartMetricSet object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metric</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metric</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetric(Metric object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeBlock(CodeBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDeclaration(FunctionDeclaration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Part Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Part Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationPartSet(ApplicationPartSet object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protection Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protection Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtectionObjective(ProtectionObjective object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //AkbSwitch
