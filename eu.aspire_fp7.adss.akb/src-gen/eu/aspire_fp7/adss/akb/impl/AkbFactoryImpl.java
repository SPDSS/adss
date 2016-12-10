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

import eu.aspire_fp7.adss.akb.*;

import it.polito.security.ontologies.Ontology;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AkbFactoryImpl extends EFactoryImpl implements AkbFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AkbFactory init()
	{
		try
		{
			AkbFactory theAkbFactory = (AkbFactory)EPackage.Registry.INSTANCE.getEFactory(AkbPackage.eNS_URI);
			if (theAkbFactory != null)
			{
				return theAkbFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AkbFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AkbFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case AkbPackage.MODEL: return createModel();
			case AkbPackage.APPLICATION_PART: return createApplicationPart();
			case AkbPackage.USE_TARGET: return createUseTarget();
			case AkbPackage.ATTACK_STEP: return createAttackStep();
			case AkbPackage.ATTACK_STEP_TYPE: return createAttackStepType();
			case AkbPackage.ATTACK_PATH: return createAttackPath();
			case AkbPackage.ATTACK_MITIGATION: return createAttackMitigation();
			case AkbPackage.PROTECTION: return createProtection();
			case AkbPackage.PROTECTION_INSTANTIATION: return createProtectionInstantiation();
			case AkbPackage.ATTACKER: return createAttacker();
			case AkbPackage.ATTACKER_TOOL: return createAttackerTool();
			case AkbPackage.ATTACKER_TOOL_TYPE: return createAttackerToolType();
			case AkbPackage.PREFERENCES: return createPreferences();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION: return createAppliedProtectionInstantiation();
			case AkbPackage.SECOND_LEVEL_MOTIVATION: return createSecondLevelMotivation();
			case AkbPackage.SOLUTION_SEQUENCE: return createSolutionSequence();
			case AkbPackage.SOLUTION: return createSolution();
			case AkbPackage.APPLICATION_PART_METRIC_SET: return createApplicationPartMetricSet();
			case AkbPackage.METRIC: return createMetric();
			case AkbPackage.CODE_BLOCK: return createCodeBlock();
			case AkbPackage.RULE: return createRule();
			case AkbPackage.FUNCTION_DECLARATION: return createFunctionDeclaration();
			case AkbPackage.APPLICATION_PART_SET: return createApplicationPartSet();
			case AkbPackage.PROTECTION_OBJECTIVE: return createProtectionObjective();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case AkbPackage.USE_TYPE:
				return createUseTypeFromString(eDataType, initialValue);
			case AkbPackage.PROPERTY:
				return createPropertyFromString(eDataType, initialValue);
			case AkbPackage.PROTECTION_FLAG:
				return createProtectionFlagFromString(eDataType, initialValue);
			case AkbPackage.APPLICATION_PART_TYPE:
				return createApplicationPartTypeFromString(eDataType, initialValue);
			case AkbPackage.LEVEL:
				return createLevelFromString(eDataType, initialValue);
			case AkbPackage.EXPERTISE_LEVEL:
				return createExpertiseLevelFromString(eDataType, initialValue);
			case AkbPackage.SECOND_LEVEL_MOTIVATION_TYPE:
				return createSecondLevelMotivationTypeFromString(eDataType, initialValue);
			case AkbPackage.CODE_BLOCK_TYPE:
				return createCodeBlockTypeFromString(eDataType, initialValue);
			case AkbPackage.ACTION_TYPE:
				return createActionTypeFromString(eDataType, initialValue);
			case AkbPackage.ONTOLOGY:
				return createOntologyFromString(eDataType, initialValue);
			case AkbPackage.INTEGER:
				return createIntegerFromString(eDataType, initialValue);
			case AkbPackage.ATTACK_STEP_TYPE_WITH_NULL:
				return createAttackStepTypeWithNullFromString(eDataType, initialValue);
			case AkbPackage.LEVEL_WITH_NULL:
				return createLevelWithNullFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case AkbPackage.USE_TYPE:
				return convertUseTypeToString(eDataType, instanceValue);
			case AkbPackage.PROPERTY:
				return convertPropertyToString(eDataType, instanceValue);
			case AkbPackage.PROTECTION_FLAG:
				return convertProtectionFlagToString(eDataType, instanceValue);
			case AkbPackage.APPLICATION_PART_TYPE:
				return convertApplicationPartTypeToString(eDataType, instanceValue);
			case AkbPackage.LEVEL:
				return convertLevelToString(eDataType, instanceValue);
			case AkbPackage.EXPERTISE_LEVEL:
				return convertExpertiseLevelToString(eDataType, instanceValue);
			case AkbPackage.SECOND_LEVEL_MOTIVATION_TYPE:
				return convertSecondLevelMotivationTypeToString(eDataType, instanceValue);
			case AkbPackage.CODE_BLOCK_TYPE:
				return convertCodeBlockTypeToString(eDataType, instanceValue);
			case AkbPackage.ACTION_TYPE:
				return convertActionTypeToString(eDataType, instanceValue);
			case AkbPackage.ONTOLOGY:
				return convertOntologyToString(eDataType, instanceValue);
			case AkbPackage.INTEGER:
				return convertIntegerToString(eDataType, instanceValue);
			case AkbPackage.ATTACK_STEP_TYPE_WITH_NULL:
				return convertAttackStepTypeWithNullToString(eDataType, instanceValue);
			case AkbPackage.LEVEL_WITH_NULL:
				return convertLevelWithNullToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel()
	{
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart createApplicationPart()
	{
		ApplicationPartImpl applicationPart = new ApplicationPartImpl();
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseTarget createUseTarget()
	{
		UseTargetImpl useTarget = new UseTargetImpl();
		return useTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStep createAttackStep()
	{
		AttackStepImpl attackStep = new AttackStepImpl();
		return attackStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType createAttackStepType()
	{
		AttackStepTypeImpl attackStepType = new AttackStepTypeImpl();
		return attackStepType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackPath createAttackPath()
	{
		AttackPathImpl attackPath = new AttackPathImpl();
		return attackPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackMitigation createAttackMitigation()
	{
		AttackMitigationImpl attackMitigation = new AttackMitigationImpl();
		return attackMitigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection createProtection()
	{
		ProtectionImpl protection = new ProtectionImpl();
		return protection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectionInstantiation createProtectionInstantiation()
	{
		ProtectionInstantiationImpl protectionInstantiation = new ProtectionInstantiationImpl();
		return protectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attacker createAttacker()
	{
		AttackerImpl attacker = new AttackerImpl();
		return attacker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackerTool createAttackerTool()
	{
		AttackerToolImpl attackerTool = new AttackerToolImpl();
		return attackerTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackerToolType createAttackerToolType()
	{
		AttackerToolTypeImpl attackerToolType = new AttackerToolTypeImpl();
		return attackerToolType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preferences createPreferences()
	{
		PreferencesImpl preferences = new PreferencesImpl();
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedProtectionInstantiation createAppliedProtectionInstantiation()
	{
		AppliedProtectionInstantiationImpl appliedProtectionInstantiation = new AppliedProtectionInstantiationImpl();
		return appliedProtectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondLevelMotivation createSecondLevelMotivation()
	{
		SecondLevelMotivationImpl secondLevelMotivation = new SecondLevelMotivationImpl();
		return secondLevelMotivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionSequence createSolutionSequence()
	{
		SolutionSequenceImpl solutionSequence = new SolutionSequenceImpl();
		return solutionSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution createSolution()
	{
		SolutionImpl solution = new SolutionImpl();
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPartMetricSet createApplicationPartMetricSet()
	{
		ApplicationPartMetricSetImpl applicationPartMetricSet = new ApplicationPartMetricSetImpl();
		return applicationPartMetricSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric createMetric()
	{
		MetricImpl metric = new MetricImpl();
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock createCodeBlock()
	{
		CodeBlockImpl codeBlock = new CodeBlockImpl();
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule()
	{
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration createFunctionDeclaration()
	{
		FunctionDeclarationImpl functionDeclaration = new FunctionDeclarationImpl();
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPartSet createApplicationPartSet()
	{
		ApplicationPartSetImpl applicationPartSet = new ApplicationPartSetImpl();
		return applicationPartSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectionObjective createProtectionObjective()
	{
		ProtectionObjectiveImpl protectionObjective = new ProtectionObjectiveImpl();
		return protectionObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseType createUseTypeFromString(EDataType eDataType, String initialValue)
	{
		UseType result = UseType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUseTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createPropertyFromString(EDataType eDataType, String initialValue)
	{
		Property result = Property.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectionFlag createProtectionFlagFromString(EDataType eDataType, String initialValue)
	{
		ProtectionFlag result = ProtectionFlag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProtectionFlagToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPartType createApplicationPartTypeFromString(EDataType eDataType, String initialValue)
	{
		ApplicationPartType result = ApplicationPartType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertApplicationPartTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level createLevelFromString(EDataType eDataType, String initialValue)
	{
		Level result = Level.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpertiseLevel createExpertiseLevelFromString(EDataType eDataType, String initialValue)
	{
		ExpertiseLevel result = ExpertiseLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpertiseLevelToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondLevelMotivationType createSecondLevelMotivationTypeFromString(EDataType eDataType, String initialValue)
	{
		SecondLevelMotivationType result = SecondLevelMotivationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSecondLevelMotivationTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockType createCodeBlockTypeFromString(EDataType eDataType, String initialValue)
	{
		CodeBlockType result = CodeBlockType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCodeBlockTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType createActionTypeFromString(EDataType eDataType, String initialValue)
	{
		ActionType result = ActionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ontology createOntologyFromString(EDataType eDataType, String initialValue)
	{
		return (Ontology)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOntologyToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createIntegerFromString(EDataType eDataType, String initialValue)
	{
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType createAttackStepTypeWithNullFromString(EDataType eDataType, String initialValue)
	{
		return (AttackStepType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttackStepTypeWithNullToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level createLevelWithNullFromString(EDataType eDataType, String initialValue)
	{
		return (Level)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelWithNullToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AkbPackage getAkbPackage()
	{
		return (AkbPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AkbPackage getPackage()
	{
		return AkbPackage.eINSTANCE;
	}

} //AkbFactoryImpl
