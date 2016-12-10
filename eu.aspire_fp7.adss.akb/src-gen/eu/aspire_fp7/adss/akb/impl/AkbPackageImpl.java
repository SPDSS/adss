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

import eu.aspire_fp7.adss.akb.ActionType;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartMetricSet;
import eu.aspire_fp7.adss.akb.ApplicationPartSet;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.AttackStepType;
import eu.aspire_fp7.adss.akb.Attacker;
import eu.aspire_fp7.adss.akb.AttackerTool;
import eu.aspire_fp7.adss.akb.AttackerToolType;
import eu.aspire_fp7.adss.akb.CodeBlock;
import eu.aspire_fp7.adss.akb.CodeBlockType;
import eu.aspire_fp7.adss.akb.ExpertiseLevel;
import eu.aspire_fp7.adss.akb.FunctionDeclaration;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Metric;
import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Preferences;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionFlag;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.akb.Rule;
import eu.aspire_fp7.adss.akb.SecondLevelMotivation;
import eu.aspire_fp7.adss.akb.SecondLevelMotivationType;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.akb.UseTarget;
import eu.aspire_fp7.adss.akb.UseType;

import it.polito.security.ontologies.Ontology;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AkbPackageImpl extends EPackageImpl implements AkbPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackStepTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackMitigationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protectionInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackerToolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackerToolTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferencesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appliedProtectionInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass secondLevelMotivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationPartMetricSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationPartSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protectionObjectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum useTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum protectionFlagEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum applicationPartTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum levelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum expertiseLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum secondLevelMotivationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum codeBlockTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ontologyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType attackStepTypeWithNullEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType levelWithNullEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AkbPackageImpl()
	{
		super(eNS_URI, AkbFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AkbPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AkbPackage init()
	{
		if (isInited) return (AkbPackage)EPackage.Registry.INSTANCE.getEPackage(AkbPackage.eNS_URI);

		// Obtain or create and register package
		AkbPackageImpl theAkbPackage = (AkbPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AkbPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AkbPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAkbPackage.createPackageContents();

		// Initialize created meta-data
		theAkbPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAkbPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AkbPackage.eNS_URI, theAkbPackage);
		return theAkbPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel()
	{
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Ontology()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_ApplicationParts()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_ApplicationPartSets()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AttackPaths()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AttackStepTypes()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AttackSteps()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Protections()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Preferences()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Rules()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_ProtectionObjectives()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AppliedProtectionInstantiations()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AvailableProtections()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AvailableSecondLevelProtections()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Assets()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Attacker()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AttackerToolTypes()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AttackerTools()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_VanillaSolution()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Solutions()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AvailableTools()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_ApplicationPartsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_AllApplicationParts()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AssetsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_DataCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_CodesCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_ProtectionsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AttackerToolsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AttackerToolTypesCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AvailableAttackerToolsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AvailableProtectionsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AttackPathsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AttackStepsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AttackStepTypesCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_ProtectionObjectivesCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_AppliedProtectionInstantiationsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_ProtectionInstantiationsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_SolutionsCount()
	{
		return (EAttribute)modelEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_KeyAttackPaths()
	{
		return (EReference)modelEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationPart()
	{
		return applicationPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Id()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Name()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_Sets()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Type()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Index()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Properties()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_SourceFilePath()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_DeclaringCode()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_StartLine()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_EndLine()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_DatumSize()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_InSystemFile()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Global()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_ShortLocation()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Weight()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_SecurityProperties()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_Parameters()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_Asset()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_ApplicationParts()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_Uses()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_TargetOf()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_Body()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPart_ApplicationPartsCount()
	{
		return (EAttribute)applicationPartEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPart_Assets()
	{
		return (EReference)applicationPartEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__Contains__ApplicationPart()
	{
		return applicationPartEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__HashCode()
	{
		return applicationPartEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__Equals__Object()
	{
		return applicationPartEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__ToString()
	{
		return applicationPartEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__IsDatum()
	{
		return applicationPartEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__IsCode()
	{
		return applicationPartEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPart__ContainsAsset()
	{
		return applicationPartEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseTarget()
	{
		return useTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseTarget_Target()
	{
		return (EReference)useTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseTarget_UsedBy()
	{
		return (EReference)useTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseTarget_Line()
	{
		return (EAttribute)useTargetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseTarget_SourceFilePath()
	{
		return (EAttribute)useTargetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseTarget_Type()
	{
		return (EAttribute)useTargetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseTarget_Parameters()
	{
		return (EReference)useTargetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUseTarget__HashCode()
	{
		return useTargetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUseTarget__Equals__Object()
	{
		return useTargetEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackStep()
	{
		return attackStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackStep_Name()
	{
		return (EAttribute)attackStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackStep_Type()
	{
		return (EAttribute)attackStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackStep_Formula()
	{
		return (EAttribute)attackStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackStep_Transition()
	{
		return (EAttribute)attackStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackStep__HashCode()
	{
		return attackStepEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackStep__Equals__Object()
	{
		return attackStepEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackStep__ToString()
	{
		return attackStepEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackStepType()
	{
		return attackStepTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackStepType_Name()
	{
		return (EAttribute)attackStepTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackStepType_Regex()
	{
		return (EAttribute)attackStepTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackStepType_AttackerTools()
	{
		return (EReference)attackStepTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackStepType__HashCode()
	{
		return attackStepTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackStepType__Equals__Object()
	{
		return attackStepTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackStepType__ToString()
	{
		return attackStepTypeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackPath()
	{
		return attackPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackPath_AttackSteps()
	{
		return (EReference)attackPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackPath_ProtectionObjectives()
	{
		return (EReference)attackPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackPath_AttackerToolTypes()
	{
		return (EReference)attackPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackPath_Cost()
	{
		return (EAttribute)attackPathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackPath_AppliedProtectionInstantiations()
	{
		return (EReference)attackPathEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackPath_Key()
	{
		return (EAttribute)attackPathEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackPath_Id()
	{
		return (EAttribute)attackPathEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackPath_Mitigations()
	{
		return (EAttribute)attackPathEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackPath_Level()
	{
		return (EAttribute)attackPathEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackPath__HashCode()
	{
		return attackPathEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackPath__Equals__Object()
	{
		return attackPathEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackPath__ToString()
	{
		return attackPathEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackMitigation()
	{
		return attackMitigationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackMitigation_Name()
	{
		return (EAttribute)attackMitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackMitigation_Level()
	{
		return (EAttribute)attackMitigationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackMitigation_Type()
	{
		return (EReference)attackMitigationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackMitigation_AttackPaths()
	{
		return (EReference)attackMitigationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackMitigation_Protection()
	{
		return (EReference)attackMitigationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackMitigation__HashCode()
	{
		return attackMitigationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackMitigation__Equals__Object()
	{
		return attackMitigationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtection()
	{
		return protectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_Id()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_Name()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_Enabled()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_AutomaticallyDeployable()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_SecondLevel()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_SecondLevelEnlargmentUsefulness()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_SecondLevelCallGraphEnlargmentUsefulness()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_SecondLevelRepetitionUsefulness()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_SecondLevelRepetitionInstantiation()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_ApplicationPartTypes()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_Mitigations()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_EnforcedSecurityRequirements()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_ForbiddenPrecedences()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_DiscouragedPrecedences()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_EncouragedPrecedences()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_ActcPrecedences()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_Singleton()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_DefeatedAttackerToolTypes()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_BlockedAttackerToolTypes()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtection_Instantiations()
	{
		return (EReference)protectionEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_Actions()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_Flags()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtection_InstantiationsCount()
	{
		return (EAttribute)protectionEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtection__HashCode()
	{
		return protectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtection__Equals__Object()
	{
		return protectionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtection__ToString()
	{
		return protectionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtectionInstantiation()
	{
		return protectionInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_Name()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtectionInstantiation_Protection()
	{
		return (EReference)protectionInstantiationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_VariableAnnotation()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_CodeAnnotation()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_VerifierAnnotation()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_AttestatorAnnotation()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_ClientTimeOverhead()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_ServerTimeOverhead()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_ClientMemoryOverhead()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_ServerMemoryOverhead()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionInstantiation_NetworkOverhead()
	{
		return (EAttribute)protectionInstantiationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionInstantiation__HashCode()
	{
		return protectionInstantiationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionInstantiation__Equals__Object()
	{
		return protectionInstantiationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionInstantiation__ToString()
	{
		return protectionInstantiationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttacker()
	{
		return attackerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttacker_Expertise()
	{
		return (EAttribute)attackerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttacker_BudgetLimit()
	{
		return (EAttribute)attackerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttacker__HashCode()
	{
		return attackerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttacker__Equals__Object()
	{
		return attackerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackerTool()
	{
		return attackerToolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackerTool_Name()
	{
		return (EAttribute)attackerToolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttackerTool_Types()
	{
		return (EReference)attackerToolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackerTool_Expertise()
	{
		return (EAttribute)attackerToolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackerTool_Cost()
	{
		return (EAttribute)attackerToolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackerTool_Enabled()
	{
		return (EAttribute)attackerToolEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackerTool__HashCode()
	{
		return attackerToolEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackerTool__Equals__Object()
	{
		return attackerToolEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackerToolType()
	{
		return attackerToolTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackerToolType_Name()
	{
		return (EAttribute)attackerToolTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackerToolType__HashCode()
	{
		return attackerToolTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackerToolType__Equals__Object()
	{
		return attackerToolTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttackerToolType__ToString()
	{
		return attackerToolTypeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreferences()
	{
		return preferencesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_WorkingDirectory()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ActcConfigurationFile()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_AdssPatchFile()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_AdssJSONFile()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_Architecture()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_RemoteConnection()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_RemoteUsername()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_RemotePassword()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_RemoteHost()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_RemotePort()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_RemoteFileSeparator()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_CommandACTC()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_CommandPerl()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_CommandDot()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_MetricsFile()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ParserHeaderParsing()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ParserSystemFilesIgnoration()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_AttacksTimeLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_AttacksMaximumDepth()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_AttacksIncludedProtectionObjectivesRemoval()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ProtectionsMinimumAttackMitigation()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ClientTimeOverhead()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ServerTimeOverhead()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ClientMemoryOverhead()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_ServerMemoryOverhead()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_NetworkOverhead()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pSolutionsCount()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pPetriNetsPass()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pTimeLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pSolutionsLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pGapLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pClientTimeOverheadPercentage()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pServerTimeOverheadPercentage()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pClientMemoryOverheadPercentage()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pServerMemoryOverheadPercentage()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pNetworkOverheadPercentage()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pDiscouragedPrecedencesIgnoration()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pEncouragedPrecedencesFocusing()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pUseACTCPrecedences()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pIgnoreApplicationPartOrder()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pMaximumInstantiationsPerProtectionObjective()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pMainSearchMaximumDepth()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pMultiTree()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pInitialAlpha()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pInitialBeta()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pResearchDelta()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L1pTranspositionTableMaximumSize()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pSolutionsCount()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pFunctionSplittingSeed()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pSolutionLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pTimeLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pGapLimit()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pUpperBound()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pFunctionSplittingMediumCodeBlockLength()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pFunctionSplittingCodeBlockLengthRandomizationDenominator()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_L2pFunctionSplittingDepthLevel()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_SetPNDirectory()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferences_SetPNFile()
	{
		return (EAttribute)preferencesEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPreferences__HashCode()
	{
		return preferencesEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPreferences__Equals__Object()
	{
		return preferencesEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppliedProtectionInstantiation()
	{
		return appliedProtectionInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppliedProtectionInstantiation_ProtectionInstantiation()
	{
		return (EReference)appliedProtectionInstantiationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppliedProtectionInstantiation_ApplicationPart()
	{
		return (EReference)appliedProtectionInstantiationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppliedProtectionInstantiation_ProtectionObjectives()
	{
		return (EReference)appliedProtectionInstantiationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppliedProtectionInstantiation_AttackMitigations()
	{
		return (EReference)appliedProtectionInstantiationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppliedProtectionInstantiation_SecondLevelMotivation()
	{
		return (EReference)appliedProtectionInstantiationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAppliedProtectionInstantiation__ToString()
	{
		return appliedProtectionInstantiationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAppliedProtectionInstantiation__HashCode()
	{
		return appliedProtectionInstantiationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAppliedProtectionInstantiation__Equals__Object()
	{
		return appliedProtectionInstantiationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecondLevelMotivation()
	{
		return secondLevelMotivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecondLevelMotivation_MotivationType()
	{
		return (EAttribute)secondLevelMotivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecondLevelMotivation_FirstLevelAppliedProtectionInstantiations()
	{
		return (EReference)secondLevelMotivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSecondLevelMotivation__ToString()
	{
		return secondLevelMotivationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSecondLevelMotivation__HashCode()
	{
		return secondLevelMotivationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSecondLevelMotivation__Equals__Object()
	{
		return secondLevelMotivationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolutionSequence()
	{
		return solutionSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolutionSequence_AppliedProtectionInstantiations()
	{
		return (EReference)solutionSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSolutionSequence__ToString()
	{
		return solutionSequenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSolutionSequence__HashCode()
	{
		return solutionSequenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSolutionSequence__Equals__Object()
	{
		return solutionSequenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolution()
	{
		return solutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolution_SolutionSequences()
	{
		return (EReference)solutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolution_ApplicationMetrics()
	{
		return (EReference)solutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolution_ApplicationPartMetricSets()
	{
		return (EReference)solutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolution_FirstLevelSolution()
	{
		return (EReference)solutionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolution_Score()
	{
		return (EAttribute)solutionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolution_Id()
	{
		return (EAttribute)solutionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSolution__ToString()
	{
		return solutionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSolution__HashCode()
	{
		return solutionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSolution__Equals__Object()
	{
		return solutionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationPartMetricSet()
	{
		return applicationPartMetricSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPartMetricSet_ApplicationPart()
	{
		return (EReference)applicationPartMetricSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPartMetricSet_Metrics()
	{
		return (EReference)applicationPartMetricSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPartMetricSet__HashCode()
	{
		return applicationPartMetricSetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPartMetricSet__Equals__Object()
	{
		return applicationPartMetricSetEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric()
	{
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Name()
	{
		return (EAttribute)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Value()
	{
		return (EAttribute)metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetric__HashCode()
	{
		return metricEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetric__Equals__Object()
	{
		return metricEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeBlock()
	{
		return codeBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_Type()
	{
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_CodeBlocks()
	{
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_StartLine()
	{
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_EndLine()
	{
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeBlock_SourceFilePath()
	{
		return (EAttribute)codeBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCodeBlock__HashCode()
	{
		return codeBlockEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCodeBlock__Equals__Object()
	{
		return codeBlockEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule()
	{
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRule_Action()
	{
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_FunctionDeclarations()
	{
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRule__HashCode()
	{
		return ruleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRule__Equals__Object()
	{
		return ruleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionDeclaration()
	{
		return functionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionDeclaration_Name()
	{
		return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionDeclaration_Parameters()
	{
		return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunctionDeclaration__HashCode()
	{
		return functionDeclarationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunctionDeclaration__Equals__Object()
	{
		return functionDeclarationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationPartSet()
	{
		return applicationPartSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationPartSet_ApplicationParts()
	{
		return (EReference)applicationPartSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationPartSet_Action()
	{
		return (EAttribute)applicationPartSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPartSet__HashCode()
	{
		return applicationPartSetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getApplicationPartSet__Equals__Object()
	{
		return applicationPartSetEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtectionObjective()
	{
		return protectionObjectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtectionObjective_ApplicationPart()
	{
		return (EReference)protectionObjectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtectionObjective_Property()
	{
		return (EAttribute)protectionObjectiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionObjective__HashCode()
	{
		return protectionObjectiveEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionObjective__Equals__Object()
	{
		return protectionObjectiveEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionObjective__ToString()
	{
		return protectionObjectiveEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUseType()
	{
		return useTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProperty()
	{
		return propertyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProtectionFlag()
	{
		return protectionFlagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getApplicationPartType()
	{
		return applicationPartTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLevel()
	{
		return levelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExpertiseLevel()
	{
		return expertiseLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSecondLevelMotivationType()
	{
		return secondLevelMotivationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCodeBlockType()
	{
		return codeBlockTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionType()
	{
		return actionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOntology()
	{
		return ontologyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger()
	{
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAttackStepTypeWithNull()
	{
		return attackStepTypeWithNullEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLevelWithNull()
	{
		return levelWithNullEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AkbFactory getAkbFactory()
	{
		return (AkbFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelEClass = createEClass(MODEL);
		createEAttribute(modelEClass, MODEL__ONTOLOGY);
		createEReference(modelEClass, MODEL__APPLICATION_PARTS);
		createEReference(modelEClass, MODEL__APPLICATION_PART_SETS);
		createEReference(modelEClass, MODEL__ATTACK_PATHS);
		createEReference(modelEClass, MODEL__ATTACK_STEP_TYPES);
		createEReference(modelEClass, MODEL__ATTACK_STEPS);
		createEReference(modelEClass, MODEL__PROTECTIONS);
		createEReference(modelEClass, MODEL__PREFERENCES);
		createEReference(modelEClass, MODEL__RULES);
		createEReference(modelEClass, MODEL__PROTECTION_OBJECTIVES);
		createEReference(modelEClass, MODEL__APPLIED_PROTECTION_INSTANTIATIONS);
		createEReference(modelEClass, MODEL__AVAILABLE_PROTECTIONS);
		createEReference(modelEClass, MODEL__AVAILABLE_SECOND_LEVEL_PROTECTIONS);
		createEReference(modelEClass, MODEL__ASSETS);
		createEReference(modelEClass, MODEL__ATTACKER);
		createEReference(modelEClass, MODEL__ATTACKER_TOOL_TYPES);
		createEReference(modelEClass, MODEL__ATTACKER_TOOLS);
		createEReference(modelEClass, MODEL__VANILLA_SOLUTION);
		createEReference(modelEClass, MODEL__SOLUTIONS);
		createEReference(modelEClass, MODEL__AVAILABLE_TOOLS);
		createEAttribute(modelEClass, MODEL__APPLICATION_PARTS_COUNT);
		createEReference(modelEClass, MODEL__ALL_APPLICATION_PARTS);
		createEAttribute(modelEClass, MODEL__ASSETS_COUNT);
		createEAttribute(modelEClass, MODEL__DATA_COUNT);
		createEAttribute(modelEClass, MODEL__CODES_COUNT);
		createEAttribute(modelEClass, MODEL__PROTECTIONS_COUNT);
		createEAttribute(modelEClass, MODEL__ATTACKER_TOOLS_COUNT);
		createEAttribute(modelEClass, MODEL__ATTACKER_TOOL_TYPES_COUNT);
		createEAttribute(modelEClass, MODEL__AVAILABLE_ATTACKER_TOOLS_COUNT);
		createEAttribute(modelEClass, MODEL__AVAILABLE_PROTECTIONS_COUNT);
		createEAttribute(modelEClass, MODEL__ATTACK_PATHS_COUNT);
		createEAttribute(modelEClass, MODEL__ATTACK_STEPS_COUNT);
		createEAttribute(modelEClass, MODEL__ATTACK_STEP_TYPES_COUNT);
		createEAttribute(modelEClass, MODEL__PROTECTION_OBJECTIVES_COUNT);
		createEAttribute(modelEClass, MODEL__APPLIED_PROTECTION_INSTANTIATIONS_COUNT);
		createEAttribute(modelEClass, MODEL__PROTECTION_INSTANTIATIONS_COUNT);
		createEAttribute(modelEClass, MODEL__SOLUTIONS_COUNT);
		createEReference(modelEClass, MODEL__KEY_ATTACK_PATHS);

		applicationPartEClass = createEClass(APPLICATION_PART);
		createEAttribute(applicationPartEClass, APPLICATION_PART__ID);
		createEAttribute(applicationPartEClass, APPLICATION_PART__NAME);
		createEReference(applicationPartEClass, APPLICATION_PART__SETS);
		createEAttribute(applicationPartEClass, APPLICATION_PART__TYPE);
		createEAttribute(applicationPartEClass, APPLICATION_PART__INDEX);
		createEAttribute(applicationPartEClass, APPLICATION_PART__PROPERTIES);
		createEAttribute(applicationPartEClass, APPLICATION_PART__SOURCE_FILE_PATH);
		createEReference(applicationPartEClass, APPLICATION_PART__DECLARING_CODE);
		createEAttribute(applicationPartEClass, APPLICATION_PART__START_LINE);
		createEAttribute(applicationPartEClass, APPLICATION_PART__END_LINE);
		createEAttribute(applicationPartEClass, APPLICATION_PART__DATUM_SIZE);
		createEAttribute(applicationPartEClass, APPLICATION_PART__IN_SYSTEM_FILE);
		createEAttribute(applicationPartEClass, APPLICATION_PART__GLOBAL);
		createEAttribute(applicationPartEClass, APPLICATION_PART__SHORT_LOCATION);
		createEAttribute(applicationPartEClass, APPLICATION_PART__WEIGHT);
		createEAttribute(applicationPartEClass, APPLICATION_PART__SECURITY_PROPERTIES);
		createEReference(applicationPartEClass, APPLICATION_PART__PARAMETERS);
		createEAttribute(applicationPartEClass, APPLICATION_PART__ASSET);
		createEReference(applicationPartEClass, APPLICATION_PART__APPLICATION_PARTS);
		createEReference(applicationPartEClass, APPLICATION_PART__USES);
		createEReference(applicationPartEClass, APPLICATION_PART__TARGET_OF);
		createEReference(applicationPartEClass, APPLICATION_PART__BODY);
		createEAttribute(applicationPartEClass, APPLICATION_PART__APPLICATION_PARTS_COUNT);
		createEReference(applicationPartEClass, APPLICATION_PART__ASSETS);
		createEOperation(applicationPartEClass, APPLICATION_PART___CONTAINS__APPLICATIONPART);
		createEOperation(applicationPartEClass, APPLICATION_PART___HASH_CODE);
		createEOperation(applicationPartEClass, APPLICATION_PART___EQUALS__OBJECT);
		createEOperation(applicationPartEClass, APPLICATION_PART___TO_STRING);
		createEOperation(applicationPartEClass, APPLICATION_PART___IS_DATUM);
		createEOperation(applicationPartEClass, APPLICATION_PART___IS_CODE);
		createEOperation(applicationPartEClass, APPLICATION_PART___CONTAINS_ASSET);

		useTargetEClass = createEClass(USE_TARGET);
		createEReference(useTargetEClass, USE_TARGET__TARGET);
		createEReference(useTargetEClass, USE_TARGET__USED_BY);
		createEAttribute(useTargetEClass, USE_TARGET__LINE);
		createEAttribute(useTargetEClass, USE_TARGET__SOURCE_FILE_PATH);
		createEAttribute(useTargetEClass, USE_TARGET__TYPE);
		createEReference(useTargetEClass, USE_TARGET__PARAMETERS);
		createEOperation(useTargetEClass, USE_TARGET___HASH_CODE);
		createEOperation(useTargetEClass, USE_TARGET___EQUALS__OBJECT);

		attackStepEClass = createEClass(ATTACK_STEP);
		createEAttribute(attackStepEClass, ATTACK_STEP__NAME);
		createEAttribute(attackStepEClass, ATTACK_STEP__TYPE);
		createEAttribute(attackStepEClass, ATTACK_STEP__FORMULA);
		createEAttribute(attackStepEClass, ATTACK_STEP__TRANSITION);
		createEOperation(attackStepEClass, ATTACK_STEP___HASH_CODE);
		createEOperation(attackStepEClass, ATTACK_STEP___EQUALS__OBJECT);
		createEOperation(attackStepEClass, ATTACK_STEP___TO_STRING);

		attackStepTypeEClass = createEClass(ATTACK_STEP_TYPE);
		createEAttribute(attackStepTypeEClass, ATTACK_STEP_TYPE__NAME);
		createEAttribute(attackStepTypeEClass, ATTACK_STEP_TYPE__REGEX);
		createEReference(attackStepTypeEClass, ATTACK_STEP_TYPE__ATTACKER_TOOLS);
		createEOperation(attackStepTypeEClass, ATTACK_STEP_TYPE___HASH_CODE);
		createEOperation(attackStepTypeEClass, ATTACK_STEP_TYPE___EQUALS__OBJECT);
		createEOperation(attackStepTypeEClass, ATTACK_STEP_TYPE___TO_STRING);

		attackPathEClass = createEClass(ATTACK_PATH);
		createEReference(attackPathEClass, ATTACK_PATH__ATTACK_STEPS);
		createEReference(attackPathEClass, ATTACK_PATH__PROTECTION_OBJECTIVES);
		createEReference(attackPathEClass, ATTACK_PATH__ATTACKER_TOOL_TYPES);
		createEAttribute(attackPathEClass, ATTACK_PATH__COST);
		createEReference(attackPathEClass, ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS);
		createEAttribute(attackPathEClass, ATTACK_PATH__KEY);
		createEAttribute(attackPathEClass, ATTACK_PATH__ID);
		createEAttribute(attackPathEClass, ATTACK_PATH__MITIGATIONS);
		createEAttribute(attackPathEClass, ATTACK_PATH__LEVEL);
		createEOperation(attackPathEClass, ATTACK_PATH___HASH_CODE);
		createEOperation(attackPathEClass, ATTACK_PATH___EQUALS__OBJECT);
		createEOperation(attackPathEClass, ATTACK_PATH___TO_STRING);

		attackMitigationEClass = createEClass(ATTACK_MITIGATION);
		createEAttribute(attackMitigationEClass, ATTACK_MITIGATION__NAME);
		createEAttribute(attackMitigationEClass, ATTACK_MITIGATION__LEVEL);
		createEReference(attackMitigationEClass, ATTACK_MITIGATION__TYPE);
		createEReference(attackMitigationEClass, ATTACK_MITIGATION__ATTACK_PATHS);
		createEReference(attackMitigationEClass, ATTACK_MITIGATION__PROTECTION);
		createEOperation(attackMitigationEClass, ATTACK_MITIGATION___HASH_CODE);
		createEOperation(attackMitigationEClass, ATTACK_MITIGATION___EQUALS__OBJECT);

		protectionEClass = createEClass(PROTECTION);
		createEAttribute(protectionEClass, PROTECTION__ID);
		createEAttribute(protectionEClass, PROTECTION__NAME);
		createEAttribute(protectionEClass, PROTECTION__ENABLED);
		createEAttribute(protectionEClass, PROTECTION__AUTOMATICALLY_DEPLOYABLE);
		createEAttribute(protectionEClass, PROTECTION__SECOND_LEVEL);
		createEAttribute(protectionEClass, PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS);
		createEAttribute(protectionEClass, PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS);
		createEAttribute(protectionEClass, PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS);
		createEReference(protectionEClass, PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION);
		createEAttribute(protectionEClass, PROTECTION__APPLICATION_PART_TYPES);
		createEReference(protectionEClass, PROTECTION__MITIGATIONS);
		createEAttribute(protectionEClass, PROTECTION__ENFORCED_SECURITY_REQUIREMENTS);
		createEReference(protectionEClass, PROTECTION__FORBIDDEN_PRECEDENCES);
		createEReference(protectionEClass, PROTECTION__DISCOURAGED_PRECEDENCES);
		createEReference(protectionEClass, PROTECTION__ENCOURAGED_PRECEDENCES);
		createEReference(protectionEClass, PROTECTION__ACTC_PRECEDENCES);
		createEAttribute(protectionEClass, PROTECTION__SINGLETON);
		createEReference(protectionEClass, PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES);
		createEReference(protectionEClass, PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES);
		createEReference(protectionEClass, PROTECTION__INSTANTIATIONS);
		createEAttribute(protectionEClass, PROTECTION__ACTIONS);
		createEAttribute(protectionEClass, PROTECTION__FLAGS);
		createEAttribute(protectionEClass, PROTECTION__INSTANTIATIONS_COUNT);
		createEOperation(protectionEClass, PROTECTION___HASH_CODE);
		createEOperation(protectionEClass, PROTECTION___EQUALS__OBJECT);
		createEOperation(protectionEClass, PROTECTION___TO_STRING);

		protectionInstantiationEClass = createEClass(PROTECTION_INSTANTIATION);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__NAME);
		createEReference(protectionInstantiationEClass, PROTECTION_INSTANTIATION__PROTECTION);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__CODE_ANNOTATION);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD);
		createEAttribute(protectionInstantiationEClass, PROTECTION_INSTANTIATION__NETWORK_OVERHEAD);
		createEOperation(protectionInstantiationEClass, PROTECTION_INSTANTIATION___HASH_CODE);
		createEOperation(protectionInstantiationEClass, PROTECTION_INSTANTIATION___EQUALS__OBJECT);
		createEOperation(protectionInstantiationEClass, PROTECTION_INSTANTIATION___TO_STRING);

		attackerEClass = createEClass(ATTACKER);
		createEAttribute(attackerEClass, ATTACKER__EXPERTISE);
		createEAttribute(attackerEClass, ATTACKER__BUDGET_LIMIT);
		createEOperation(attackerEClass, ATTACKER___HASH_CODE);
		createEOperation(attackerEClass, ATTACKER___EQUALS__OBJECT);

		attackerToolEClass = createEClass(ATTACKER_TOOL);
		createEAttribute(attackerToolEClass, ATTACKER_TOOL__NAME);
		createEReference(attackerToolEClass, ATTACKER_TOOL__TYPES);
		createEAttribute(attackerToolEClass, ATTACKER_TOOL__EXPERTISE);
		createEAttribute(attackerToolEClass, ATTACKER_TOOL__COST);
		createEAttribute(attackerToolEClass, ATTACKER_TOOL__ENABLED);
		createEOperation(attackerToolEClass, ATTACKER_TOOL___HASH_CODE);
		createEOperation(attackerToolEClass, ATTACKER_TOOL___EQUALS__OBJECT);

		attackerToolTypeEClass = createEClass(ATTACKER_TOOL_TYPE);
		createEAttribute(attackerToolTypeEClass, ATTACKER_TOOL_TYPE__NAME);
		createEOperation(attackerToolTypeEClass, ATTACKER_TOOL_TYPE___HASH_CODE);
		createEOperation(attackerToolTypeEClass, ATTACKER_TOOL_TYPE___EQUALS__OBJECT);
		createEOperation(attackerToolTypeEClass, ATTACKER_TOOL_TYPE___TO_STRING);

		preferencesEClass = createEClass(PREFERENCES);
		createEAttribute(preferencesEClass, PREFERENCES__WORKING_DIRECTORY);
		createEAttribute(preferencesEClass, PREFERENCES__ACTC_CONFIGURATION_FILE);
		createEAttribute(preferencesEClass, PREFERENCES__ADSS_PATCH_FILE);
		createEAttribute(preferencesEClass, PREFERENCES__ADSS_JSON_FILE);
		createEAttribute(preferencesEClass, PREFERENCES__ARCHITECTURE);
		createEAttribute(preferencesEClass, PREFERENCES__REMOTE_CONNECTION);
		createEAttribute(preferencesEClass, PREFERENCES__REMOTE_USERNAME);
		createEAttribute(preferencesEClass, PREFERENCES__REMOTE_PASSWORD);
		createEAttribute(preferencesEClass, PREFERENCES__REMOTE_HOST);
		createEAttribute(preferencesEClass, PREFERENCES__REMOTE_PORT);
		createEAttribute(preferencesEClass, PREFERENCES__REMOTE_FILE_SEPARATOR);
		createEAttribute(preferencesEClass, PREFERENCES__COMMAND_ACTC);
		createEAttribute(preferencesEClass, PREFERENCES__COMMAND_PERL);
		createEAttribute(preferencesEClass, PREFERENCES__COMMAND_DOT);
		createEAttribute(preferencesEClass, PREFERENCES__METRICS_FILE);
		createEAttribute(preferencesEClass, PREFERENCES__PARSER_HEADER_PARSING);
		createEAttribute(preferencesEClass, PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION);
		createEAttribute(preferencesEClass, PREFERENCES__ATTACKS_TIME_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__ATTACKS_MAXIMUM_DEPTH);
		createEAttribute(preferencesEClass, PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL);
		createEAttribute(preferencesEClass, PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION);
		createEAttribute(preferencesEClass, PREFERENCES__CLIENT_TIME_OVERHEAD);
		createEAttribute(preferencesEClass, PREFERENCES__SERVER_TIME_OVERHEAD);
		createEAttribute(preferencesEClass, PREFERENCES__CLIENT_MEMORY_OVERHEAD);
		createEAttribute(preferencesEClass, PREFERENCES__SERVER_MEMORY_OVERHEAD);
		createEAttribute(preferencesEClass, PREFERENCES__NETWORK_OVERHEAD);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_SOLUTIONS_COUNT);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_PETRI_NETS_PASS);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_TIME_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_SOLUTIONS_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_GAP_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_USE_ACTC_PRECEDENCES);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_MULTI_TREE);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_INITIAL_ALPHA);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_INITIAL_BETA);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_RESEARCH_DELTA);
		createEAttribute(preferencesEClass, PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_SOLUTIONS_COUNT);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_FUNCTION_SPLITTING_SEED);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_SOLUTION_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_TIME_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_GAP_LIMIT);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_UPPER_BOUND);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR);
		createEAttribute(preferencesEClass, PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL);
		createEAttribute(preferencesEClass, PREFERENCES__SET_PN_DIRECTORY);
		createEAttribute(preferencesEClass, PREFERENCES__SET_PN_FILE);
		createEOperation(preferencesEClass, PREFERENCES___HASH_CODE);
		createEOperation(preferencesEClass, PREFERENCES___EQUALS__OBJECT);

		appliedProtectionInstantiationEClass = createEClass(APPLIED_PROTECTION_INSTANTIATION);
		createEReference(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION);
		createEReference(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART);
		createEReference(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES);
		createEReference(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS);
		createEReference(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION);
		createEOperation(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION___TO_STRING);
		createEOperation(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION___HASH_CODE);
		createEOperation(appliedProtectionInstantiationEClass, APPLIED_PROTECTION_INSTANTIATION___EQUALS__OBJECT);

		secondLevelMotivationEClass = createEClass(SECOND_LEVEL_MOTIVATION);
		createEAttribute(secondLevelMotivationEClass, SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE);
		createEReference(secondLevelMotivationEClass, SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS);
		createEOperation(secondLevelMotivationEClass, SECOND_LEVEL_MOTIVATION___TO_STRING);
		createEOperation(secondLevelMotivationEClass, SECOND_LEVEL_MOTIVATION___HASH_CODE);
		createEOperation(secondLevelMotivationEClass, SECOND_LEVEL_MOTIVATION___EQUALS__OBJECT);

		solutionSequenceEClass = createEClass(SOLUTION_SEQUENCE);
		createEReference(solutionSequenceEClass, SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS);
		createEOperation(solutionSequenceEClass, SOLUTION_SEQUENCE___TO_STRING);
		createEOperation(solutionSequenceEClass, SOLUTION_SEQUENCE___HASH_CODE);
		createEOperation(solutionSequenceEClass, SOLUTION_SEQUENCE___EQUALS__OBJECT);

		solutionEClass = createEClass(SOLUTION);
		createEReference(solutionEClass, SOLUTION__SOLUTION_SEQUENCES);
		createEReference(solutionEClass, SOLUTION__APPLICATION_METRICS);
		createEReference(solutionEClass, SOLUTION__APPLICATION_PART_METRIC_SETS);
		createEReference(solutionEClass, SOLUTION__FIRST_LEVEL_SOLUTION);
		createEAttribute(solutionEClass, SOLUTION__SCORE);
		createEAttribute(solutionEClass, SOLUTION__ID);
		createEOperation(solutionEClass, SOLUTION___TO_STRING);
		createEOperation(solutionEClass, SOLUTION___HASH_CODE);
		createEOperation(solutionEClass, SOLUTION___EQUALS__OBJECT);

		applicationPartMetricSetEClass = createEClass(APPLICATION_PART_METRIC_SET);
		createEReference(applicationPartMetricSetEClass, APPLICATION_PART_METRIC_SET__APPLICATION_PART);
		createEReference(applicationPartMetricSetEClass, APPLICATION_PART_METRIC_SET__METRICS);
		createEOperation(applicationPartMetricSetEClass, APPLICATION_PART_METRIC_SET___HASH_CODE);
		createEOperation(applicationPartMetricSetEClass, APPLICATION_PART_METRIC_SET___EQUALS__OBJECT);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__NAME);
		createEAttribute(metricEClass, METRIC__VALUE);
		createEOperation(metricEClass, METRIC___HASH_CODE);
		createEOperation(metricEClass, METRIC___EQUALS__OBJECT);

		codeBlockEClass = createEClass(CODE_BLOCK);
		createEAttribute(codeBlockEClass, CODE_BLOCK__TYPE);
		createEReference(codeBlockEClass, CODE_BLOCK__CODE_BLOCKS);
		createEAttribute(codeBlockEClass, CODE_BLOCK__START_LINE);
		createEAttribute(codeBlockEClass, CODE_BLOCK__END_LINE);
		createEAttribute(codeBlockEClass, CODE_BLOCK__SOURCE_FILE_PATH);
		createEOperation(codeBlockEClass, CODE_BLOCK___HASH_CODE);
		createEOperation(codeBlockEClass, CODE_BLOCK___EQUALS__OBJECT);

		ruleEClass = createEClass(RULE);
		createEAttribute(ruleEClass, RULE__ACTION);
		createEReference(ruleEClass, RULE__FUNCTION_DECLARATIONS);
		createEOperation(ruleEClass, RULE___HASH_CODE);
		createEOperation(ruleEClass, RULE___EQUALS__OBJECT);

		functionDeclarationEClass = createEClass(FUNCTION_DECLARATION);
		createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__NAME);
		createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__PARAMETERS);
		createEOperation(functionDeclarationEClass, FUNCTION_DECLARATION___HASH_CODE);
		createEOperation(functionDeclarationEClass, FUNCTION_DECLARATION___EQUALS__OBJECT);

		applicationPartSetEClass = createEClass(APPLICATION_PART_SET);
		createEReference(applicationPartSetEClass, APPLICATION_PART_SET__APPLICATION_PARTS);
		createEAttribute(applicationPartSetEClass, APPLICATION_PART_SET__ACTION);
		createEOperation(applicationPartSetEClass, APPLICATION_PART_SET___HASH_CODE);
		createEOperation(applicationPartSetEClass, APPLICATION_PART_SET___EQUALS__OBJECT);

		protectionObjectiveEClass = createEClass(PROTECTION_OBJECTIVE);
		createEReference(protectionObjectiveEClass, PROTECTION_OBJECTIVE__APPLICATION_PART);
		createEAttribute(protectionObjectiveEClass, PROTECTION_OBJECTIVE__PROPERTY);
		createEOperation(protectionObjectiveEClass, PROTECTION_OBJECTIVE___HASH_CODE);
		createEOperation(protectionObjectiveEClass, PROTECTION_OBJECTIVE___EQUALS__OBJECT);
		createEOperation(protectionObjectiveEClass, PROTECTION_OBJECTIVE___TO_STRING);

		// Create enums
		useTypeEEnum = createEEnum(USE_TYPE);
		propertyEEnum = createEEnum(PROPERTY);
		protectionFlagEEnum = createEEnum(PROTECTION_FLAG);
		applicationPartTypeEEnum = createEEnum(APPLICATION_PART_TYPE);
		levelEEnum = createEEnum(LEVEL);
		expertiseLevelEEnum = createEEnum(EXPERTISE_LEVEL);
		secondLevelMotivationTypeEEnum = createEEnum(SECOND_LEVEL_MOTIVATION_TYPE);
		codeBlockTypeEEnum = createEEnum(CODE_BLOCK_TYPE);
		actionTypeEEnum = createEEnum(ACTION_TYPE);

		// Create data types
		ontologyEDataType = createEDataType(ONTOLOGY);
		integerEDataType = createEDataType(INTEGER);
		attackStepTypeWithNullEDataType = createEDataType(ATTACK_STEP_TYPE_WITH_NULL);
		levelWithNullEDataType = createEDataType(LEVEL_WITH_NULL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModel_Ontology(), this.getOntology(), "ontology", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_ApplicationParts(), this.getApplicationPart(), null, "applicationParts", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_ApplicationPartSets(), this.getApplicationPartSet(), null, "applicationPartSets", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AttackPaths(), this.getAttackPath(), null, "attackPaths", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AttackStepTypes(), this.getAttackStepType(), null, "attackStepTypes", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AttackSteps(), this.getAttackStep(), null, "attackSteps", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Protections(), this.getProtection(), null, "protections", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Preferences(), this.getPreferences(), null, "preferences", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Rules(), this.getRule(), null, "rules", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_ProtectionObjectives(), this.getProtectionObjective(), null, "protectionObjectives", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AppliedProtectionInstantiations(), this.getAppliedProtectionInstantiation(), null, "appliedProtectionInstantiations", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AvailableProtections(), this.getProtection(), null, "availableProtections", null, 0, -1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AvailableSecondLevelProtections(), this.getProtection(), null, "availableSecondLevelProtections", null, 0, -1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Assets(), this.getApplicationPart(), null, "assets", null, 0, -1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Attacker(), this.getAttacker(), null, "attacker", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AttackerToolTypes(), this.getAttackerToolType(), null, "attackerToolTypes", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AttackerTools(), this.getAttackerTool(), null, "attackerTools", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_VanillaSolution(), this.getSolution(), null, "vanillaSolution", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Solutions(), this.getSolution(), null, "Solutions", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AvailableTools(), this.getAttackerTool(), null, "availableTools", null, 0, -1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_ApplicationPartsCount(), theEcorePackage.getEInt(), "applicationPartsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModel_AllApplicationParts(), this.getApplicationPart(), null, "allApplicationParts", null, 0, -1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AssetsCount(), theEcorePackage.getEInt(), "assetsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_DataCount(), theEcorePackage.getEInt(), "dataCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_CodesCount(), theEcorePackage.getEInt(), "codesCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_ProtectionsCount(), theEcorePackage.getEInt(), "protectionsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AttackerToolsCount(), theEcorePackage.getEInt(), "attackerToolsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AttackerToolTypesCount(), theEcorePackage.getEInt(), "attackerToolTypesCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AvailableAttackerToolsCount(), theEcorePackage.getEInt(), "availableAttackerToolsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AvailableProtectionsCount(), theEcorePackage.getEInt(), "availableProtectionsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AttackPathsCount(), theEcorePackage.getEInt(), "attackPathsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AttackStepsCount(), theEcorePackage.getEInt(), "attackStepsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AttackStepTypesCount(), theEcorePackage.getEInt(), "attackStepTypesCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_ProtectionObjectivesCount(), theEcorePackage.getEInt(), "protectionObjectivesCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_AppliedProtectionInstantiationsCount(), theEcorePackage.getEInt(), "appliedProtectionInstantiationsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_ProtectionInstantiationsCount(), theEcorePackage.getEInt(), "protectionInstantiationsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_SolutionsCount(), theEcorePackage.getEInt(), "solutionsCount", null, 0, 1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModel_KeyAttackPaths(), this.getAttackPath(), null, "keyAttackPaths", null, 0, -1, Model.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(applicationPartEClass, ApplicationPart.class, "ApplicationPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplicationPart_Id(), theEcorePackage.getEInt(), "id", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_Sets(), this.getApplicationPartSet(), this.getApplicationPartSet_ApplicationParts(), "sets", null, 0, -1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Type(), this.getApplicationPartType(), "type", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Index(), theEcorePackage.getEInt(), "index", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Properties(), this.getProperty(), "properties", null, 0, -1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_SourceFilePath(), theEcorePackage.getEString(), "sourceFilePath", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_DeclaringCode(), this.getApplicationPart(), this.getApplicationPart_ApplicationParts(), "declaringCode", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_StartLine(), theEcorePackage.getEInt(), "startLine", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_EndLine(), theEcorePackage.getEInt(), "endLine", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_DatumSize(), theEcorePackage.getEInt(), "datumSize", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_InSystemFile(), theEcorePackage.getEBoolean(), "inSystemFile", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Global(), theEcorePackage.getEBoolean(), "global", null, 0, 1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_ShortLocation(), theEcorePackage.getEString(), "shortLocation", null, 0, 1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Weight(), theEcorePackage.getEDouble(), "weight", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_SecurityProperties(), this.getProperty(), "securityProperties", null, 0, -1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_Parameters(), this.getApplicationPart(), null, "parameters", null, 0, -1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_Asset(), theEcorePackage.getEBoolean(), "asset", null, 0, 1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_ApplicationParts(), this.getApplicationPart(), this.getApplicationPart_DeclaringCode(), "applicationParts", null, 0, -1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_Uses(), this.getUseTarget(), this.getUseTarget_UsedBy(), "uses", null, 0, -1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_TargetOf(), this.getUseTarget(), this.getUseTarget_Target(), "targetOf", null, 0, -1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_Body(), this.getCodeBlock(), null, "body", null, 0, 1, ApplicationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPart_ApplicationPartsCount(), theEcorePackage.getEInt(), "applicationPartsCount", null, 0, 1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPart_Assets(), this.getApplicationPart(), null, "assets", null, 0, -1, ApplicationPart.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getApplicationPart__Contains__ApplicationPart(), theEcorePackage.getEBoolean(), "contains", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getApplicationPart(), "part", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getApplicationPart__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getApplicationPart__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getApplicationPart__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getApplicationPart__IsDatum(), theEcorePackage.getEBoolean(), "isDatum", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getApplicationPart__IsCode(), theEcorePackage.getEBoolean(), "isCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getApplicationPart__ContainsAsset(), theEcorePackage.getEBoolean(), "containsAsset", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(useTargetEClass, UseTarget.class, "UseTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseTarget_Target(), this.getApplicationPart(), this.getApplicationPart_TargetOf(), "target", null, 0, 1, UseTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseTarget_UsedBy(), this.getApplicationPart(), this.getApplicationPart_Uses(), "usedBy", null, 0, 1, UseTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseTarget_Line(), theEcorePackage.getEInt(), "line", null, 0, 1, UseTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseTarget_SourceFilePath(), theEcorePackage.getEString(), "sourceFilePath", null, 0, 1, UseTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseTarget_Type(), this.getUseType(), "type", null, 0, 1, UseTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseTarget_Parameters(), this.getApplicationPart(), null, "parameters", null, 0, -1, UseTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getUseTarget__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUseTarget__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackStepEClass, AttackStep.class, "AttackStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttackStep_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AttackStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackStep_Type(), this.getAttackStepTypeWithNull(), "type", null, 0, 1, AttackStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackStep_Formula(), theEcorePackage.getEString(), "formula", null, 0, 1, AttackStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackStep_Transition(), theEcorePackage.getEString(), "transition", null, 0, 1, AttackStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttackStep__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttackStep__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttackStep__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackStepTypeEClass, AttackStepType.class, "AttackStepType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttackStepType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AttackStepType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackStepType_Regex(), theEcorePackage.getEString(), "regex", null, 0, 1, AttackStepType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackStepType_AttackerTools(), this.getAttackerToolType(), null, "attackerTools", null, 0, -1, AttackStepType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttackStepType__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttackStepType__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttackStepType__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackPathEClass, AttackPath.class, "AttackPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttackPath_AttackSteps(), this.getAttackStep(), null, "attackSteps", null, 0, -1, AttackPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackPath_ProtectionObjectives(), this.getProtectionObjective(), null, "protectionObjectives", null, 0, -1, AttackPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackPath_AttackerToolTypes(), this.getAttackerToolType(), null, "attackerToolTypes", null, 0, -1, AttackPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackPath_Cost(), theEcorePackage.getEDouble(), "cost", null, 0, 1, AttackPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackPath_AppliedProtectionInstantiations(), this.getAppliedProtectionInstantiation(), null, "appliedProtectionInstantiations", null, 0, -1, AttackPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackPath_Key(), theEcorePackage.getEBoolean(), "key", null, 0, 1, AttackPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackPath_Id(), theEcorePackage.getELong(), "id", null, 0, 1, AttackPath.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackPath_Mitigations(), theEcorePackage.getEString(), "mitigations", null, 0, 1, AttackPath.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackPath_Level(), this.getLevel(), "level", null, 0, 1, AttackPath.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getAttackPath__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttackPath__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttackPath__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackMitigationEClass, AttackMitigation.class, "AttackMitigation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttackMitigation_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AttackMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackMitigation_Level(), this.getLevel(), "level", null, 0, 1, AttackMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackMitigation_Type(), this.getAttackStepType(), null, "type", null, 0, 1, AttackMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackMitigation_AttackPaths(), this.getAttackPath(), null, "attackPaths", null, 0, -1, AttackMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackMitigation_Protection(), this.getProtection(), this.getProtection_Mitigations(), "protection", null, 0, 1, AttackMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttackMitigation__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttackMitigation__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(protectionEClass, Protection.class, "Protection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProtection_Id(), theEcorePackage.getEString(), "id", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_Enabled(), theEcorePackage.getEBoolean(), "enabled", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_AutomaticallyDeployable(), theEcorePackage.getEBoolean(), "automaticallyDeployable", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_SecondLevel(), theEcorePackage.getEBoolean(), "secondLevel", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_SecondLevelEnlargmentUsefulness(), this.getLevel(), "secondLevelEnlargmentUsefulness", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_SecondLevelCallGraphEnlargmentUsefulness(), this.getLevel(), "secondLevelCallGraphEnlargmentUsefulness", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_SecondLevelRepetitionUsefulness(), this.getLevel(), "secondLevelRepetitionUsefulness", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_SecondLevelRepetitionInstantiation(), this.getProtectionInstantiation(), null, "secondLevelRepetitionInstantiation", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_ApplicationPartTypes(), this.getApplicationPartType(), "applicationPartTypes", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_Mitigations(), this.getAttackMitigation(), this.getAttackMitigation_Protection(), "mitigations", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_EnforcedSecurityRequirements(), this.getProperty(), "enforcedSecurityRequirements", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_ForbiddenPrecedences(), this.getProtection(), null, "forbiddenPrecedences", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_DiscouragedPrecedences(), this.getProtection(), null, "discouragedPrecedences", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_EncouragedPrecedences(), this.getProtection(), null, "encouragedPrecedences", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_ActcPrecedences(), this.getProtection(), null, "actcPrecedences", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_Singleton(), theEcorePackage.getEBoolean(), "singleton", null, 0, 1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_DefeatedAttackerToolTypes(), this.getAttackerToolType(), null, "defeatedAttackerToolTypes", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_BlockedAttackerToolTypes(), this.getAttackerToolType(), null, "blockedAttackerToolTypes", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtection_Instantiations(), this.getProtectionInstantiation(), this.getProtectionInstantiation_Protection(), "instantiations", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_Actions(), this.getActionType(), "actions", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_Flags(), this.getProtectionFlag(), "flags", null, 0, -1, Protection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtection_InstantiationsCount(), theEcorePackage.getEInt(), "instantiationsCount", null, 0, 1, Protection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getProtection__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProtection__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getProtection__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(protectionInstantiationEClass, ProtectionInstantiation.class, "ProtectionInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProtectionInstantiation_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtectionInstantiation_Protection(), this.getProtection(), this.getProtection_Instantiations(), "protection", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_VariableAnnotation(), theEcorePackage.getEString(), "variableAnnotation", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_CodeAnnotation(), theEcorePackage.getEString(), "codeAnnotation", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_VerifierAnnotation(), theEcorePackage.getEString(), "verifierAnnotation", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_AttestatorAnnotation(), theEcorePackage.getEString(), "attestatorAnnotation", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_ClientTimeOverhead(), theEcorePackage.getEString(), "clientTimeOverhead", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_ServerTimeOverhead(), theEcorePackage.getEString(), "serverTimeOverhead", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_ClientMemoryOverhead(), theEcorePackage.getEString(), "clientMemoryOverhead", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_ServerMemoryOverhead(), theEcorePackage.getEString(), "serverMemoryOverhead", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionInstantiation_NetworkOverhead(), theEcorePackage.getEString(), "networkOverhead", null, 0, 1, ProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getProtectionInstantiation__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProtectionInstantiation__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getProtectionInstantiation__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackerEClass, Attacker.class, "Attacker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttacker_Expertise(), this.getExpertiseLevel(), "expertise", null, 0, 1, Attacker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttacker_BudgetLimit(), this.getInteger(), "budgetLimit", null, 0, 1, Attacker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttacker__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttacker__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackerToolEClass, AttackerTool.class, "AttackerTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttackerTool_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AttackerTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttackerTool_Types(), this.getAttackerToolType(), null, "types", null, 0, -1, AttackerTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackerTool_Expertise(), this.getExpertiseLevel(), "expertise", null, 0, 1, AttackerTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackerTool_Cost(), theEcorePackage.getEInt(), "cost", null, 0, 1, AttackerTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackerTool_Enabled(), theEcorePackage.getEBoolean(), "enabled", null, 0, 1, AttackerTool.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getAttackerTool__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttackerTool__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attackerToolTypeEClass, AttackerToolType.class, "AttackerToolType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttackerToolType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AttackerToolType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttackerToolType__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttackerToolType__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttackerToolType__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(preferencesEClass, Preferences.class, "Preferences", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreferences_WorkingDirectory(), theEcorePackage.getEString(), "workingDirectory", "/home/aspire/test", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ActcConfigurationFile(), theEcorePackage.getEString(), "actcConfigurationFile", "test.json", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_AdssPatchFile(), theEcorePackage.getEString(), "adssPatchFile", "adss.patch", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_AdssJSONFile(), theEcorePackage.getEString(), "adssJSONFile", "adss.json", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_Architecture(), theEcorePackage.getEString(), "architecture", "", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_RemoteConnection(), theEcorePackage.getEBoolean(), "remoteConnection", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_RemoteUsername(), theEcorePackage.getEString(), "remoteUsername", "aspire", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_RemotePassword(), theEcorePackage.getEString(), "remotePassword", "aspire", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_RemoteHost(), theEcorePackage.getEString(), "remoteHost", "127.0.1.1", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_RemotePort(), theEcorePackage.getEInt(), "remotePort", "3022", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_RemoteFileSeparator(), theEcorePackage.getEString(), "remoteFileSeparator", "/", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_CommandACTC(), theEcorePackage.getEString(), "commandACTC", "/opt/ACTC/actc.py", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_CommandPerl(), theEcorePackage.getEString(), "commandPerl", "/usr/bin/perl", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_CommandDot(), theEcorePackage.getEString(), "commandDot", "/usr/bin/dot", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_MetricsFile(), theEcorePackage.getEString(), "metricsFile", "gammas.db", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ParserHeaderParsing(), theEcorePackage.getEBoolean(), "parserHeaderParsing", "false", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ParserSystemFilesIgnoration(), theEcorePackage.getEBoolean(), "parserSystemFilesIgnoration", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_AttacksTimeLimit(), theEcorePackage.getEInt(), "attacksTimeLimit", "60", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_AttacksMaximumDepth(), theEcorePackage.getEInt(), "attacksMaximumDepth", "4", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_AttacksIncludedProtectionObjectivesRemoval(), theEcorePackage.getEBoolean(), "attacksIncludedProtectionObjectivesRemoval", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ProtectionsMinimumAttackMitigation(), this.getLevel(), "protectionsMinimumAttackMitigation", "medium", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ClientTimeOverhead(), theEcorePackage.getEDouble(), "clientTimeOverhead", "10", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ServerTimeOverhead(), theEcorePackage.getEDouble(), "serverTimeOverhead", "10", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ClientMemoryOverhead(), theEcorePackage.getEInt(), "clientMemoryOverhead", "1024", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_ServerMemoryOverhead(), theEcorePackage.getEInt(), "serverMemoryOverhead", "1024", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_NetworkOverhead(), theEcorePackage.getEInt(), "networkOverhead", "1024", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pSolutionsCount(), theEcorePackage.getEInt(), "l1pSolutionsCount", "10", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pPetriNetsPass(), theEcorePackage.getEBoolean(), "l1pPetriNetsPass", "false", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pTimeLimit(), theEcorePackage.getEInt(), "l1pTimeLimit", "60", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pSolutionsLimit(), theEcorePackage.getEInt(), "l1pSolutionsLimit", "-10000", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pGapLimit(), theEcorePackage.getEDouble(), "l1pGapLimit", "-10.0", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pClientTimeOverheadPercentage(), theEcorePackage.getEDouble(), "l1pClientTimeOverheadPercentage", "50", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pServerTimeOverheadPercentage(), theEcorePackage.getEDouble(), "l1pServerTimeOverheadPercentage", "50", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pClientMemoryOverheadPercentage(), theEcorePackage.getEDouble(), "l1pClientMemoryOverheadPercentage", "50", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pServerMemoryOverheadPercentage(), theEcorePackage.getEDouble(), "l1pServerMemoryOverheadPercentage", "50", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pNetworkOverheadPercentage(), theEcorePackage.getEDouble(), "l1pNetworkOverheadPercentage", "50", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pDiscouragedPrecedencesIgnoration(), theEcorePackage.getEBoolean(), "l1pDiscouragedPrecedencesIgnoration", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pEncouragedPrecedencesFocusing(), theEcorePackage.getEBoolean(), "l1pEncouragedPrecedencesFocusing", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pUseACTCPrecedences(), theEcorePackage.getEBoolean(), "l1pUseACTCPrecedences", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pIgnoreApplicationPartOrder(), theEcorePackage.getEBoolean(), "l1pIgnoreApplicationPartOrder", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pMaximumInstantiationsPerProtectionObjective(), theEcorePackage.getEInt(), "l1pMaximumInstantiationsPerProtectionObjective", "3", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pMainSearchMaximumDepth(), theEcorePackage.getEInt(), "l1pMainSearchMaximumDepth", "3", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pMultiTree(), theEcorePackage.getEBoolean(), "l1pMultiTree", "true", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pInitialAlpha(), theEcorePackage.getEDouble(), "l1pInitialAlpha", "0", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pInitialBeta(), theEcorePackage.getEDouble(), "l1pInitialBeta", "5", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pResearchDelta(), theEcorePackage.getEDouble(), "l1pResearchDelta", "1.0", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L1pTranspositionTableMaximumSize(), theEcorePackage.getEInt(), "l1pTranspositionTableMaximumSize", "1000000", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pSolutionsCount(), theEcorePackage.getEInt(), "l2pSolutionsCount", "1", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pFunctionSplittingSeed(), theEcorePackage.getEInt(), "l2pFunctionSplittingSeed", "1106103861", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pSolutionLimit(), theEcorePackage.getEInt(), "l2pSolutionLimit", "0", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pTimeLimit(), theEcorePackage.getEInt(), "l2pTimeLimit", "60", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pGapLimit(), theEcorePackage.getEDouble(), "l2pGapLimit", "0", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pUpperBound(), theEcorePackage.getEInt(), "l2pUpperBound", "2", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pFunctionSplittingMediumCodeBlockLength(), theEcorePackage.getEInt(), "l2pFunctionSplittingMediumCodeBlockLength", "2", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pFunctionSplittingCodeBlockLengthRandomizationDenominator(), theEcorePackage.getEInt(), "l2pFunctionSplittingCodeBlockLengthRandomizationDenominator", "2", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_L2pFunctionSplittingDepthLevel(), theEcorePackage.getEInt(), "l2pFunctionSplittingDepthLevel", "0", 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_SetPNDirectory(), theEcorePackage.getEString(), "setPNDirectory", null, 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferences_SetPNFile(), theEcorePackage.getEString(), "setPNFile", null, 0, 1, Preferences.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPreferences__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPreferences__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(appliedProtectionInstantiationEClass, AppliedProtectionInstantiation.class, "AppliedProtectionInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppliedProtectionInstantiation_ProtectionInstantiation(), this.getProtectionInstantiation(), null, "protectionInstantiation", null, 0, 1, AppliedProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppliedProtectionInstantiation_ApplicationPart(), this.getApplicationPart(), null, "applicationPart", null, 0, 1, AppliedProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppliedProtectionInstantiation_ProtectionObjectives(), this.getProtectionObjective(), null, "protectionObjectives", null, 0, -1, AppliedProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppliedProtectionInstantiation_AttackMitigations(), this.getAttackMitigation(), null, "attackMitigations", null, 0, -1, AppliedProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppliedProtectionInstantiation_SecondLevelMotivation(), this.getSecondLevelMotivation(), null, "secondLevelMotivation", null, 0, -1, AppliedProtectionInstantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAppliedProtectionInstantiation__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAppliedProtectionInstantiation__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAppliedProtectionInstantiation__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(secondLevelMotivationEClass, SecondLevelMotivation.class, "SecondLevelMotivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecondLevelMotivation_MotivationType(), this.getSecondLevelMotivationType(), "motivationType", null, 0, 1, SecondLevelMotivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecondLevelMotivation_FirstLevelAppliedProtectionInstantiations(), this.getAppliedProtectionInstantiation(), null, "firstLevelAppliedProtectionInstantiations", null, 0, 1, SecondLevelMotivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSecondLevelMotivation__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSecondLevelMotivation__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSecondLevelMotivation__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(solutionSequenceEClass, SolutionSequence.class, "SolutionSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolutionSequence_AppliedProtectionInstantiations(), this.getAppliedProtectionInstantiation(), null, "appliedProtectionInstantiations", null, 0, -1, SolutionSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSolutionSequence__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSolutionSequence__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSolutionSequence__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolution_SolutionSequences(), this.getSolutionSequence(), null, "solutionSequences", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolution_ApplicationMetrics(), this.getMetric(), null, "applicationMetrics", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolution_ApplicationPartMetricSets(), this.getApplicationPartMetricSet(), null, "applicationPartMetricSets", null, 0, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolution_FirstLevelSolution(), this.getSolution(), null, "firstLevelSolution", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolution_Score(), theEcorePackage.getEDouble(), "score", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolution_Id(), theEcorePackage.getEString(), "id", null, 0, 1, Solution.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getSolution__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSolution__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSolution__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(applicationPartMetricSetEClass, ApplicationPartMetricSet.class, "ApplicationPartMetricSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationPartMetricSet_ApplicationPart(), this.getApplicationPart(), null, "applicationPart", null, 0, 1, ApplicationPartMetricSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationPartMetricSet_Metrics(), this.getMetric(), null, "metrics", null, 0, -1, ApplicationPartMetricSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getApplicationPartMetricSet__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getApplicationPartMetricSet__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Value(), theEcorePackage.getEDoubleObject(), "value", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMetric__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMetric__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(codeBlockEClass, CodeBlock.class, "CodeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeBlock_Type(), this.getCodeBlockType(), "type", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeBlock_CodeBlocks(), this.getCodeBlock(), null, "codeBlocks", null, 0, -1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeBlock_StartLine(), theEcorePackage.getEInt(), "startLine", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeBlock_EndLine(), theEcorePackage.getEInt(), "endLine", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeBlock_SourceFilePath(), theEcorePackage.getEString(), "sourceFilePath", null, 0, 1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getCodeBlock__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCodeBlock__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRule_Action(), this.getActionType(), "action", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_FunctionDeclarations(), this.getFunctionDeclaration(), null, "functionDeclarations", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRule__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRule__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(functionDeclarationEClass, FunctionDeclaration.class, "FunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionDeclaration_Name(), theEcorePackage.getEString(), "name", null, 0, 1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionDeclaration_Parameters(), this.getApplicationPartType(), "parameters", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getFunctionDeclaration__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFunctionDeclaration__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(applicationPartSetEClass, ApplicationPartSet.class, "ApplicationPartSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationPartSet_ApplicationParts(), this.getApplicationPart(), this.getApplicationPart_Sets(), "applicationParts", null, 0, -1, ApplicationPartSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationPartSet_Action(), this.getActionType(), "action", null, 0, 1, ApplicationPartSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getApplicationPartSet__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getApplicationPartSet__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(protectionObjectiveEClass, ProtectionObjective.class, "ProtectionObjective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtectionObjective_ApplicationPart(), this.getApplicationPart(), null, "applicationPart", null, 0, 1, ProtectionObjective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtectionObjective_Property(), this.getProperty(), "property", null, 0, 1, ProtectionObjective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getProtectionObjective__HashCode(), theEcorePackage.getEInt(), "hashCode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProtectionObjective__Equals__Object(), theEcorePackage.getEBoolean(), "equals", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEJavaObject(), "object", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getProtectionObjective__ToString(), theEcorePackage.getEString(), "toString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(useTypeEEnum, UseType.class, "UseType");
		addEEnumLiteral(useTypeEEnum, UseType.ACCESSES);
		addEEnumLiteral(useTypeEEnum, UseType.CALLS);
		addEEnumLiteral(useTypeEEnum, UseType.INITIALIZES);
		addEEnumLiteral(useTypeEEnum, UseType.DECRYPTS);
		addEEnumLiteral(useTypeEEnum, UseType.ENCRYPTS);
		addEEnumLiteral(useTypeEEnum, UseType.RECEIVES_AS_CIPHERTEXT);
		addEEnumLiteral(useTypeEEnum, UseType.RECEIVES_AS_PLAINTEXT);
		addEEnumLiteral(useTypeEEnum, UseType.ENFORCES_EXECUTION_ONCE_AFTER_INSTALL);
		addEEnumLiteral(useTypeEEnum, UseType.ENABLES);

		initEEnum(propertyEEnum, Property.class, "Property");
		addEEnumLiteral(propertyEEnum, Property.PRIVACY);
		addEEnumLiteral(propertyEEnum, Property.INTEGRITY);
		addEEnumLiteral(propertyEEnum, Property.CONFIDENTIALITY);
		addEEnumLiteral(propertyEEnum, Property.HARDCONFIDENTIALITY);
		addEEnumLiteral(propertyEEnum, Property.HARDCODED);

		initEEnum(protectionFlagEEnum, ProtectionFlag.class, "ProtectionFlag");
		addEEnumLiteral(protectionFlagEEnum, ProtectionFlag.WHOLE_FUNCTION);
		addEEnumLiteral(protectionFlagEEnum, ProtectionFlag.ONE_PER_FUNCTION);

		initEEnum(applicationPartTypeEEnum, ApplicationPartType.class, "ApplicationPartType");
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.CODE_REGION);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.FUNCTION);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.CRYPTOGRAPHIC_KEY);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.INITIALIZATION_VECTOR);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.PLAINTEXT);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.CIPHERTEXT);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.GENERIC_VARIABLE);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.INTEGER_DATUM);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.INTEGER_ARRAY_DATUM);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.PARAMETER);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.REFERENCE);
		addEEnumLiteral(applicationPartTypeEEnum, ApplicationPartType.IGNORE);

		initEEnum(levelEEnum, Level.class, "Level");
		addEEnumLiteral(levelEEnum, Level.HIGH);
		addEEnumLiteral(levelEEnum, Level.MEDIUM);
		addEEnumLiteral(levelEEnum, Level.LOW);
		addEEnumLiteral(levelEEnum, Level.NONE);

		initEEnum(expertiseLevelEEnum, ExpertiseLevel.class, "ExpertiseLevel");
		addEEnumLiteral(expertiseLevelEEnum, ExpertiseLevel.AMATEUR);
		addEEnumLiteral(expertiseLevelEEnum, ExpertiseLevel.GEEK);
		addEEnumLiteral(expertiseLevelEEnum, ExpertiseLevel.EXPERT);
		addEEnumLiteral(expertiseLevelEEnum, ExpertiseLevel.GURU);

		initEEnum(secondLevelMotivationTypeEEnum, SecondLevelMotivationType.class, "SecondLevelMotivationType");
		addEEnumLiteral(secondLevelMotivationTypeEEnum, SecondLevelMotivationType.KEPT);
		addEEnumLiteral(secondLevelMotivationTypeEEnum, SecondLevelMotivationType.ENLARGED);
		addEEnumLiteral(secondLevelMotivationTypeEEnum, SecondLevelMotivationType.CALL_GRAPH_ENLARGED);
		addEEnumLiteral(secondLevelMotivationTypeEEnum, SecondLevelMotivationType.REPEATED);

		initEEnum(codeBlockTypeEEnum, CodeBlockType.class, "CodeBlockType");
		addEEnumLiteral(codeBlockTypeEEnum, CodeBlockType.FOR);
		addEEnumLiteral(codeBlockTypeEEnum, CodeBlockType.WHILE);
		addEEnumLiteral(codeBlockTypeEEnum, CodeBlockType.DO_WHILE);
		addEEnumLiteral(codeBlockTypeEEnum, CodeBlockType.IF);
		addEEnumLiteral(codeBlockTypeEEnum, CodeBlockType.SWITCH);
		addEEnumLiteral(codeBlockTypeEEnum, CodeBlockType.OTHER);

		initEEnum(actionTypeEEnum, ActionType.class, "ActionType");
		addEEnumLiteral(actionTypeEEnum, ActionType.DECRYPT_AES128_CBC);
		addEEnumLiteral(actionTypeEEnum, ActionType.DECRYPT_AES128_ECB);
		addEEnumLiteral(actionTypeEEnum, ActionType.ENCRYPT_AES128_CBC);
		addEEnumLiteral(actionTypeEEnum, ActionType.ENCRYPT_AES128_ECB);

		// Initialize data types
		initEDataType(ontologyEDataType, Ontology.class, "Ontology", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, Integer.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(attackStepTypeWithNullEDataType, AttackStepType.class, "AttackStepTypeWithNull", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(levelWithNullEDataType, Level.class, "LevelWithNull", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AkbPackageImpl
