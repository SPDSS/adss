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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage
 * @generated
 */
public class AkbAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AkbPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AkbAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = AkbPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AkbSwitch<Adapter> modelSwitch =
		new AkbSwitch<Adapter>()
		{
			@Override
			public Adapter caseModel(Model object)
			{
				return createModelAdapter();
			}
			@Override
			public Adapter caseApplicationPart(ApplicationPart object)
			{
				return createApplicationPartAdapter();
			}
			@Override
			public Adapter caseUseTarget(UseTarget object)
			{
				return createUseTargetAdapter();
			}
			@Override
			public Adapter caseAttackStep(AttackStep object)
			{
				return createAttackStepAdapter();
			}
			@Override
			public Adapter caseAttackStepType(AttackStepType object)
			{
				return createAttackStepTypeAdapter();
			}
			@Override
			public Adapter caseAttackPath(AttackPath object)
			{
				return createAttackPathAdapter();
			}
			@Override
			public Adapter caseAttackMitigation(AttackMitigation object)
			{
				return createAttackMitigationAdapter();
			}
			@Override
			public Adapter caseProtection(Protection object)
			{
				return createProtectionAdapter();
			}
			@Override
			public Adapter caseProtectionInstantiation(ProtectionInstantiation object)
			{
				return createProtectionInstantiationAdapter();
			}
			@Override
			public Adapter caseAttacker(Attacker object)
			{
				return createAttackerAdapter();
			}
			@Override
			public Adapter caseAttackerTool(AttackerTool object)
			{
				return createAttackerToolAdapter();
			}
			@Override
			public Adapter caseAttackerToolType(AttackerToolType object)
			{
				return createAttackerToolTypeAdapter();
			}
			@Override
			public Adapter casePreferences(Preferences object)
			{
				return createPreferencesAdapter();
			}
			@Override
			public Adapter caseAppliedProtectionInstantiation(AppliedProtectionInstantiation object)
			{
				return createAppliedProtectionInstantiationAdapter();
			}
			@Override
			public Adapter caseSecondLevelMotivation(SecondLevelMotivation object)
			{
				return createSecondLevelMotivationAdapter();
			}
			@Override
			public Adapter caseSolutionSequence(SolutionSequence object)
			{
				return createSolutionSequenceAdapter();
			}
			@Override
			public Adapter caseSolution(Solution object)
			{
				return createSolutionAdapter();
			}
			@Override
			public Adapter caseApplicationPartMetricSet(ApplicationPartMetricSet object)
			{
				return createApplicationPartMetricSetAdapter();
			}
			@Override
			public Adapter caseMetric(Metric object)
			{
				return createMetricAdapter();
			}
			@Override
			public Adapter caseCodeBlock(CodeBlock object)
			{
				return createCodeBlockAdapter();
			}
			@Override
			public Adapter caseRule(Rule object)
			{
				return createRuleAdapter();
			}
			@Override
			public Adapter caseFunctionDeclaration(FunctionDeclaration object)
			{
				return createFunctionDeclarationAdapter();
			}
			@Override
			public Adapter caseApplicationPartSet(ApplicationPartSet object)
			{
				return createApplicationPartSetAdapter();
			}
			@Override
			public Adapter caseProtectionObjective(ProtectionObjective object)
			{
				return createProtectionObjectiveAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Model
	 * @generated
	 */
	public Adapter createModelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.ApplicationPart <em>Application Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart
	 * @generated
	 */
	public Adapter createApplicationPartAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.UseTarget <em>Use Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.UseTarget
	 * @generated
	 */
	public Adapter createUseTargetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AttackStep <em>Attack Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AttackStep
	 * @generated
	 */
	public Adapter createAttackStepAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AttackStepType <em>Attack Step Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AttackStepType
	 * @generated
	 */
	public Adapter createAttackStepTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AttackPath <em>Attack Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AttackPath
	 * @generated
	 */
	public Adapter createAttackPathAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AttackMitigation <em>Attack Mitigation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AttackMitigation
	 * @generated
	 */
	public Adapter createAttackMitigationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Protection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Protection
	 * @generated
	 */
	public Adapter createProtectionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation <em>Protection Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.ProtectionInstantiation
	 * @generated
	 */
	public Adapter createProtectionInstantiationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Attacker <em>Attacker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Attacker
	 * @generated
	 */
	public Adapter createAttackerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AttackerTool <em>Attacker Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AttackerTool
	 * @generated
	 */
	public Adapter createAttackerToolAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AttackerToolType <em>Attacker Tool Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AttackerToolType
	 * @generated
	 */
	public Adapter createAttackerToolTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Preferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Preferences
	 * @generated
	 */
	public Adapter createPreferencesAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation <em>Applied Protection Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation
	 * @generated
	 */
	public Adapter createAppliedProtectionInstantiationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.SecondLevelMotivation <em>Second Level Motivation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.SecondLevelMotivation
	 * @generated
	 */
	public Adapter createSecondLevelMotivationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.SolutionSequence <em>Solution Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.SolutionSequence
	 * @generated
	 */
	public Adapter createSolutionSequenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Solution
	 * @generated
	 */
	public Adapter createSolutionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet <em>Application Part Metric Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartMetricSet
	 * @generated
	 */
	public Adapter createApplicationPartMetricSetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.CodeBlock <em>Code Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.CodeBlock
	 * @generated
	 */
	public Adapter createCodeBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.FunctionDeclaration
	 * @generated
	 */
	public Adapter createFunctionDeclarationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet <em>Application Part Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet
	 * @generated
	 */
	public Adapter createApplicationPartSetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aspire_fp7.adss.akb.ProtectionObjective <em>Protection Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aspire_fp7.adss.akb.ProtectionObjective
	 * @generated
	 */
	public Adapter createProtectionObjectiveAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //AkbAdapterFactory
