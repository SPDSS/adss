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

import com.google.common.collect.Iterables;

import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartSet;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.AttackStepType;
import eu.aspire_fp7.adss.akb.Attacker;
import eu.aspire_fp7.adss.akb.AttackerTool;
import eu.aspire_fp7.adss.akb.AttackerToolType;
import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Preferences;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.akb.Rule;
import eu.aspire_fp7.adss.akb.Solution;

import it.polito.security.ontologies.Ontology;

import java.util.Collection;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getOntology <em>Ontology</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getApplicationPartSets <em>Application Part Sets</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackStepTypes <em>Attack Step Types</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackSteps <em>Attack Steps</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getProtections <em>Protections</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAvailableProtections <em>Available Protections</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAvailableSecondLevelProtections <em>Available Second Level Protections</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAssets <em>Assets</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttacker <em>Attacker</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackerToolTypes <em>Attacker Tool Types</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackerTools <em>Attacker Tools</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getVanillaSolution <em>Vanilla Solution</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAvailableTools <em>Available Tools</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getApplicationPartsCount <em>Application Parts Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAllApplicationParts <em>All Application Parts</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAssetsCount <em>Assets Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getDataCount <em>Data Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getCodesCount <em>Codes Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getProtectionsCount <em>Protections Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackerToolsCount <em>Attacker Tools Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackerToolTypesCount <em>Attacker Tool Types Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAvailableAttackerToolsCount <em>Available Attacker Tools Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAvailableProtectionsCount <em>Available Protections Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackPathsCount <em>Attack Paths Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackStepsCount <em>Attack Steps Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAttackStepTypesCount <em>Attack Step Types Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getProtectionObjectivesCount <em>Protection Objectives Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getAppliedProtectionInstantiationsCount <em>Applied Protection Instantiations Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getProtectionInstantiationsCount <em>Protection Instantiations Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getSolutionsCount <em>Solutions Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ModelImpl#getKeyAttackPaths <em>Key Attack Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
	/**
	 * The default value of the '{@link #getOntology() <em>Ontology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntology()
	 * @generated
	 * @ordered
	 */
	protected static final Ontology ONTOLOGY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOntology() <em>Ontology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntology()
	 * @generated
	 * @ordered
	 */
	protected Ontology ontology = ONTOLOGY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getApplicationParts() <em>Application Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPart> applicationParts;

	/**
	 * The cached value of the '{@link #getApplicationPartSets() <em>Application Part Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPartSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPartSet> applicationPartSets;

	/**
	 * The cached value of the '{@link #getAttackPaths() <em>Attack Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackPath> attackPaths;

	/**
	 * The cached value of the '{@link #getAttackStepTypes() <em>Attack Step Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackStepTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackStepType> attackStepTypes;

	/**
	 * The cached value of the '{@link #getAttackSteps() <em>Attack Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackStep> attackSteps;

	/**
	 * The cached value of the '{@link #getProtections() <em>Protections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtections()
	 * @generated
	 * @ordered
	 */
	protected EList<Protection> protections;

	/**
	 * The cached value of the '{@link #getPreferences() <em>Preferences</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferences()
	 * @generated
	 * @ordered
	 */
	protected Preferences preferences;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * The cached value of the '{@link #getProtectionObjectives() <em>Protection Objectives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionObjectives()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtectionObjective> protectionObjectives;

	/**
	 * The cached value of the '{@link #getAppliedProtectionInstantiations() <em>Applied Protection Instantiations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedProtectionInstantiations()
	 * @generated
	 * @ordered
	 */
	protected EList<AppliedProtectionInstantiation> appliedProtectionInstantiations;

	/**
	 * The cached value of the '{@link #getAttacker() <em>Attacker</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttacker()
	 * @generated
	 * @ordered
	 */
	protected Attacker attacker;

	/**
	 * The cached value of the '{@link #getAttackerToolTypes() <em>Attacker Tool Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerToolTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerToolType> attackerToolTypes;

	/**
	 * The cached value of the '{@link #getAttackerTools() <em>Attacker Tools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerTools()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerTool> attackerTools;

	/**
	 * The cached value of the '{@link #getVanillaSolution() <em>Vanilla Solution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVanillaSolution()
	 * @generated
	 * @ordered
	 */
	protected Solution vanillaSolution;

	/**
	 * The cached value of the '{@link #getSolutions() <em>Solutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutions()
	 * @generated
	 * @ordered
	 */
	protected EList<Solution> solutions;

	/**
	 * The default value of the '{@link #getApplicationPartsCount() <em>Application Parts Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPartsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int APPLICATION_PARTS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAssetsCount() <em>Assets Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ASSETS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getDataCount() <em>Data Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DATA_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getCodesCount() <em>Codes Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int CODES_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getProtectionsCount() <em>Protections Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PROTECTIONS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAttackerToolsCount() <em>Attacker Tools Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerToolsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACKER_TOOLS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAttackerToolTypesCount() <em>Attacker Tool Types Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerToolTypesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACKER_TOOL_TYPES_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAvailableAttackerToolsCount() <em>Available Attacker Tools Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableAttackerToolsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int AVAILABLE_ATTACKER_TOOLS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAvailableProtectionsCount() <em>Available Protections Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableProtectionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int AVAILABLE_PROTECTIONS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAttackPathsCount() <em>Attack Paths Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackPathsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACK_PATHS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAttackStepsCount() <em>Attack Steps Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackStepsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACK_STEPS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAttackStepTypesCount() <em>Attack Step Types Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackStepTypesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTACK_STEP_TYPES_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getProtectionObjectivesCount() <em>Protection Objectives Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionObjectivesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PROTECTION_OBJECTIVES_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAppliedProtectionInstantiationsCount() <em>Applied Protection Instantiations Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedProtectionInstantiationsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int APPLIED_PROTECTION_INSTANTIATIONS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getProtectionInstantiationsCount() <em>Protection Instantiations Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionInstantiationsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PROTECTION_INSTANTIATIONS_COUNT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getSolutionsCount() <em>Solutions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int SOLUTIONS_COUNT_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl()
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
		return AkbPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ontology getOntology()
	{
		return ontology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOntology(Ontology newOntology)
	{
		Ontology oldOntology = ontology;
		ontology = newOntology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__ONTOLOGY, oldOntology, ontology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getApplicationParts()
	{
		if (applicationParts == null)
		{
			applicationParts = new EObjectContainmentEList<ApplicationPart>(ApplicationPart.class, this, AkbPackage.MODEL__APPLICATION_PARTS);
		}
		return applicationParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPartSet> getApplicationPartSets()
	{
		if (applicationPartSets == null)
		{
			applicationPartSets = new EObjectContainmentEList<ApplicationPartSet>(ApplicationPartSet.class, this, AkbPackage.MODEL__APPLICATION_PART_SETS);
		}
		return applicationPartSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackPath> getAttackPaths()
	{
		if (attackPaths == null)
		{
			attackPaths = new EObjectContainmentEList<AttackPath>(AttackPath.class, this, AkbPackage.MODEL__ATTACK_PATHS);
		}
		return attackPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackStepType> getAttackStepTypes()
	{
		if (attackStepTypes == null)
		{
			attackStepTypes = new EObjectContainmentEList<AttackStepType>(AttackStepType.class, this, AkbPackage.MODEL__ATTACK_STEP_TYPES);
		}
		return attackStepTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackStep> getAttackSteps()
	{
		if (attackSteps == null)
		{
			attackSteps = new EObjectContainmentEList<AttackStep>(AttackStep.class, this, AkbPackage.MODEL__ATTACK_STEPS);
		}
		return attackSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getProtections()
	{
		if (protections == null)
		{
			protections = new EObjectContainmentEList<Protection>(Protection.class, this, AkbPackage.MODEL__PROTECTIONS);
		}
		return protections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preferences getPreferences()
	{
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreferences(Preferences newPreferences, NotificationChain msgs)
	{
		Preferences oldPreferences = preferences;
		preferences = newPreferences;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__PREFERENCES, oldPreferences, newPreferences);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferences(Preferences newPreferences)
	{
		if (newPreferences != preferences)
		{
			NotificationChain msgs = null;
			if (preferences != null)
				msgs = ((InternalEObject)preferences).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AkbPackage.MODEL__PREFERENCES, null, msgs);
			if (newPreferences != null)
				msgs = ((InternalEObject)newPreferences).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AkbPackage.MODEL__PREFERENCES, null, msgs);
			msgs = basicSetPreferences(newPreferences, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__PREFERENCES, newPreferences, newPreferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules()
	{
		if (rules == null)
		{
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, AkbPackage.MODEL__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProtectionObjective> getProtectionObjectives()
	{
		if (protectionObjectives == null)
		{
			protectionObjectives = new EObjectContainmentEList<ProtectionObjective>(ProtectionObjective.class, this, AkbPackage.MODEL__PROTECTION_OBJECTIVES);
		}
		return protectionObjectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations()
	{
		if (appliedProtectionInstantiations == null)
		{
			appliedProtectionInstantiations = new EObjectContainmentEList<AppliedProtectionInstantiation>(AppliedProtectionInstantiation.class, this, AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS);
		}
		return appliedProtectionInstantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getAvailableProtections()
	{
		BasicEList<Protection> availableProtections = new BasicEList<Protection>();
		EList<Protection> _protections = this.getProtections();
		for (final Protection i : _protections)
		{
			boolean _isEnabled = i.isEnabled();
			if (_isEnabled)
			{
				availableProtections.add(i);
			}
		}
		return availableProtections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getAvailableSecondLevelProtections()
	{
		BasicEList<Protection> availableSecondLevelProtections = new BasicEList<Protection>();
		EList<Protection> _protections = this.getProtections();
		for (final Protection i : _protections)
		{
			if ((i.isEnabled() && i.isSecondLevel()))
			{
				availableSecondLevelProtections.add(i);
			}
		}
		return availableSecondLevelProtections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getAssets()
	{
		BasicEList<ApplicationPart> assets = new BasicEList<ApplicationPart>();
		Stack<ApplicationPart> parts = new Stack<ApplicationPart>();
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		Iterables.<ApplicationPart>addAll(parts, _applicationParts);
		while ((!parts.isEmpty()))
		{
			{
				ApplicationPart i = parts.pop();
				boolean _isAsset = i.isAsset();
				if (_isAsset)
				{
					assets.add(i);
				}
				EList<ApplicationPart> _applicationParts_1 = i.getApplicationParts();
				Iterables.<ApplicationPart>addAll(parts, _applicationParts_1);
			}
		}
		return assets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attacker getAttacker()
	{
		return attacker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttacker(Attacker newAttacker, NotificationChain msgs)
	{
		Attacker oldAttacker = attacker;
		attacker = newAttacker;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__ATTACKER, oldAttacker, newAttacker);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttacker(Attacker newAttacker)
	{
		if (newAttacker != attacker)
		{
			NotificationChain msgs = null;
			if (attacker != null)
				msgs = ((InternalEObject)attacker).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AkbPackage.MODEL__ATTACKER, null, msgs);
			if (newAttacker != null)
				msgs = ((InternalEObject)newAttacker).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AkbPackage.MODEL__ATTACKER, null, msgs);
			msgs = basicSetAttacker(newAttacker, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__ATTACKER, newAttacker, newAttacker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerToolType> getAttackerToolTypes()
	{
		if (attackerToolTypes == null)
		{
			attackerToolTypes = new EObjectContainmentEList<AttackerToolType>(AttackerToolType.class, this, AkbPackage.MODEL__ATTACKER_TOOL_TYPES);
		}
		return attackerToolTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerTool> getAttackerTools()
	{
		if (attackerTools == null)
		{
			attackerTools = new EObjectContainmentEList<AttackerTool>(AttackerTool.class, this, AkbPackage.MODEL__ATTACKER_TOOLS);
		}
		return attackerTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution getVanillaSolution()
	{
		return vanillaSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVanillaSolution(Solution newVanillaSolution, NotificationChain msgs)
	{
		Solution oldVanillaSolution = vanillaSolution;
		vanillaSolution = newVanillaSolution;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__VANILLA_SOLUTION, oldVanillaSolution, newVanillaSolution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVanillaSolution(Solution newVanillaSolution)
	{
		if (newVanillaSolution != vanillaSolution)
		{
			NotificationChain msgs = null;
			if (vanillaSolution != null)
				msgs = ((InternalEObject)vanillaSolution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AkbPackage.MODEL__VANILLA_SOLUTION, null, msgs);
			if (newVanillaSolution != null)
				msgs = ((InternalEObject)newVanillaSolution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AkbPackage.MODEL__VANILLA_SOLUTION, null, msgs);
			msgs = basicSetVanillaSolution(newVanillaSolution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.MODEL__VANILLA_SOLUTION, newVanillaSolution, newVanillaSolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Solution> getSolutions()
	{
		if (solutions == null)
		{
			solutions = new EObjectContainmentEList<Solution>(Solution.class, this, AkbPackage.MODEL__SOLUTIONS);
		}
		return solutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerTool> getAvailableTools()
	{
		BasicEList<AttackerTool> tools = new BasicEList<AttackerTool>();
		EList<AttackerTool> _attackerTools = this.getAttackerTools();
		for (final AttackerTool i : _attackerTools)
		{
			boolean _isEnabled = i.isEnabled();
			if (_isEnabled)
			{
				tools.add(i);
			}
		}
		return tools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getApplicationPartsCount()
	{
		EList<ApplicationPart> _allApplicationParts = this.getAllApplicationParts();
		return _allApplicationParts.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getAllApplicationParts()
	{
		BasicEList<ApplicationPart> parts = new BasicEList<ApplicationPart>();
		BasicEList<ApplicationPart> aux = new BasicEList<ApplicationPart>();
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		aux.addAll(_applicationParts);
		while ((!aux.isEmpty()))
		{
			{
				ApplicationPart p = aux.get(0);
				aux.remove(0);
				EList<ApplicationPart> _applicationParts_1 = p.getApplicationParts();
				for (final ApplicationPart j : _applicationParts_1)
				{
					aux.add(0, j);
				}
				parts.add(p);
			}
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAssetsCount()
	{
		EList<ApplicationPart> _assets = this.getAssets();
		return _assets.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDataCount()
	{
		int c = 0;
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			boolean _isDatum = i.isDatum();
			if (_isDatum)
			{
				c = (c + 1);
			}
		}
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCodesCount()
	{
		int c = 0;
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			boolean _isCode = i.isCode();
			if (_isCode)
			{
				c = (c + 1);
			}
		}
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProtectionsCount()
	{
		EList<Protection> _protections = this.getProtections();
		return _protections.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttackerToolsCount()
	{
		EList<AttackerTool> _attackerTools = this.getAttackerTools();
		return _attackerTools.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttackerToolTypesCount()
	{
		EList<AttackerToolType> _attackerToolTypes = this.getAttackerToolTypes();
		return _attackerToolTypes.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAvailableAttackerToolsCount()
	{
		EList<AttackerTool> _availableTools = this.getAvailableTools();
		return _availableTools.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAvailableProtectionsCount()
	{
		EList<Protection> _availableProtections = this.getAvailableProtections();
		return _availableProtections.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttackPathsCount()
	{
		EList<AttackPath> _attackPaths = this.getAttackPaths();
		return _attackPaths.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttackStepsCount()
	{
		EList<AttackStep> _attackSteps = this.getAttackSteps();
		return _attackSteps.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttackStepTypesCount()
	{
		EList<AttackStepType> _attackStepTypes = this.getAttackStepTypes();
		return _attackStepTypes.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProtectionObjectivesCount()
	{
		EList<ProtectionObjective> _protectionObjectives = this.getProtectionObjectives();
		return _protectionObjectives.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAppliedProtectionInstantiationsCount()
	{
		EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();
		return _appliedProtectionInstantiations.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProtectionInstantiationsCount()
	{
		int c = 0;
		EList<Protection> _protections = this.getProtections();
		for (final Protection i : _protections)
		{
			EList<ProtectionInstantiation> _instantiations = i.getInstantiations();
			int _size = _instantiations.size();
			int _plus = (c + _size);
			c = _plus;
		}
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSolutionsCount()
	{
		EList<Solution> _solutions = this.getSolutions();
		return _solutions.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackPath> getKeyAttackPaths()
	{
		BasicEList<AttackPath> attacks = new BasicEList<AttackPath>();
		EList<AttackPath> _attackPaths = this.getAttackPaths();
		for (final AttackPath i : _attackPaths)
		{
			boolean _isKey = i.isKey();
			if (_isKey)
			{
				attacks.add(i);
			}
		}
		return attacks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case AkbPackage.MODEL__APPLICATION_PARTS:
				return ((InternalEList<?>)getApplicationParts()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__APPLICATION_PART_SETS:
				return ((InternalEList<?>)getApplicationPartSets()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__ATTACK_PATHS:
				return ((InternalEList<?>)getAttackPaths()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__ATTACK_STEP_TYPES:
				return ((InternalEList<?>)getAttackStepTypes()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__ATTACK_STEPS:
				return ((InternalEList<?>)getAttackSteps()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__PROTECTIONS:
				return ((InternalEList<?>)getProtections()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__PREFERENCES:
				return basicSetPreferences(null, msgs);
			case AkbPackage.MODEL__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES:
				return ((InternalEList<?>)getProtectionObjectives()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS:
				return ((InternalEList<?>)getAppliedProtectionInstantiations()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__ATTACKER:
				return basicSetAttacker(null, msgs);
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES:
				return ((InternalEList<?>)getAttackerToolTypes()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__ATTACKER_TOOLS:
				return ((InternalEList<?>)getAttackerTools()).basicRemove(otherEnd, msgs);
			case AkbPackage.MODEL__VANILLA_SOLUTION:
				return basicSetVanillaSolution(null, msgs);
			case AkbPackage.MODEL__SOLUTIONS:
				return ((InternalEList<?>)getSolutions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case AkbPackage.MODEL__ONTOLOGY:
				return getOntology();
			case AkbPackage.MODEL__APPLICATION_PARTS:
				return getApplicationParts();
			case AkbPackage.MODEL__APPLICATION_PART_SETS:
				return getApplicationPartSets();
			case AkbPackage.MODEL__ATTACK_PATHS:
				return getAttackPaths();
			case AkbPackage.MODEL__ATTACK_STEP_TYPES:
				return getAttackStepTypes();
			case AkbPackage.MODEL__ATTACK_STEPS:
				return getAttackSteps();
			case AkbPackage.MODEL__PROTECTIONS:
				return getProtections();
			case AkbPackage.MODEL__PREFERENCES:
				return getPreferences();
			case AkbPackage.MODEL__RULES:
				return getRules();
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES:
				return getProtectionObjectives();
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS:
				return getAppliedProtectionInstantiations();
			case AkbPackage.MODEL__AVAILABLE_PROTECTIONS:
				return getAvailableProtections();
			case AkbPackage.MODEL__AVAILABLE_SECOND_LEVEL_PROTECTIONS:
				return getAvailableSecondLevelProtections();
			case AkbPackage.MODEL__ASSETS:
				return getAssets();
			case AkbPackage.MODEL__ATTACKER:
				return getAttacker();
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES:
				return getAttackerToolTypes();
			case AkbPackage.MODEL__ATTACKER_TOOLS:
				return getAttackerTools();
			case AkbPackage.MODEL__VANILLA_SOLUTION:
				return getVanillaSolution();
			case AkbPackage.MODEL__SOLUTIONS:
				return getSolutions();
			case AkbPackage.MODEL__AVAILABLE_TOOLS:
				return getAvailableTools();
			case AkbPackage.MODEL__APPLICATION_PARTS_COUNT:
				return getApplicationPartsCount();
			case AkbPackage.MODEL__ALL_APPLICATION_PARTS:
				return getAllApplicationParts();
			case AkbPackage.MODEL__ASSETS_COUNT:
				return getAssetsCount();
			case AkbPackage.MODEL__DATA_COUNT:
				return getDataCount();
			case AkbPackage.MODEL__CODES_COUNT:
				return getCodesCount();
			case AkbPackage.MODEL__PROTECTIONS_COUNT:
				return getProtectionsCount();
			case AkbPackage.MODEL__ATTACKER_TOOLS_COUNT:
				return getAttackerToolsCount();
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES_COUNT:
				return getAttackerToolTypesCount();
			case AkbPackage.MODEL__AVAILABLE_ATTACKER_TOOLS_COUNT:
				return getAvailableAttackerToolsCount();
			case AkbPackage.MODEL__AVAILABLE_PROTECTIONS_COUNT:
				return getAvailableProtectionsCount();
			case AkbPackage.MODEL__ATTACK_PATHS_COUNT:
				return getAttackPathsCount();
			case AkbPackage.MODEL__ATTACK_STEPS_COUNT:
				return getAttackStepsCount();
			case AkbPackage.MODEL__ATTACK_STEP_TYPES_COUNT:
				return getAttackStepTypesCount();
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES_COUNT:
				return getProtectionObjectivesCount();
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS_COUNT:
				return getAppliedProtectionInstantiationsCount();
			case AkbPackage.MODEL__PROTECTION_INSTANTIATIONS_COUNT:
				return getProtectionInstantiationsCount();
			case AkbPackage.MODEL__SOLUTIONS_COUNT:
				return getSolutionsCount();
			case AkbPackage.MODEL__KEY_ATTACK_PATHS:
				return getKeyAttackPaths();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case AkbPackage.MODEL__ONTOLOGY:
				setOntology((Ontology)newValue);
				return;
			case AkbPackage.MODEL__APPLICATION_PARTS:
				getApplicationParts().clear();
				getApplicationParts().addAll((Collection<? extends ApplicationPart>)newValue);
				return;
			case AkbPackage.MODEL__APPLICATION_PART_SETS:
				getApplicationPartSets().clear();
				getApplicationPartSets().addAll((Collection<? extends ApplicationPartSet>)newValue);
				return;
			case AkbPackage.MODEL__ATTACK_PATHS:
				getAttackPaths().clear();
				getAttackPaths().addAll((Collection<? extends AttackPath>)newValue);
				return;
			case AkbPackage.MODEL__ATTACK_STEP_TYPES:
				getAttackStepTypes().clear();
				getAttackStepTypes().addAll((Collection<? extends AttackStepType>)newValue);
				return;
			case AkbPackage.MODEL__ATTACK_STEPS:
				getAttackSteps().clear();
				getAttackSteps().addAll((Collection<? extends AttackStep>)newValue);
				return;
			case AkbPackage.MODEL__PROTECTIONS:
				getProtections().clear();
				getProtections().addAll((Collection<? extends Protection>)newValue);
				return;
			case AkbPackage.MODEL__PREFERENCES:
				setPreferences((Preferences)newValue);
				return;
			case AkbPackage.MODEL__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				getProtectionObjectives().addAll((Collection<? extends ProtectionObjective>)newValue);
				return;
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
				getAppliedProtectionInstantiations().addAll((Collection<? extends AppliedProtectionInstantiation>)newValue);
				return;
			case AkbPackage.MODEL__ATTACKER:
				setAttacker((Attacker)newValue);
				return;
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES:
				getAttackerToolTypes().clear();
				getAttackerToolTypes().addAll((Collection<? extends AttackerToolType>)newValue);
				return;
			case AkbPackage.MODEL__ATTACKER_TOOLS:
				getAttackerTools().clear();
				getAttackerTools().addAll((Collection<? extends AttackerTool>)newValue);
				return;
			case AkbPackage.MODEL__VANILLA_SOLUTION:
				setVanillaSolution((Solution)newValue);
				return;
			case AkbPackage.MODEL__SOLUTIONS:
				getSolutions().clear();
				getSolutions().addAll((Collection<? extends Solution>)newValue);
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
			case AkbPackage.MODEL__ONTOLOGY:
				setOntology(ONTOLOGY_EDEFAULT);
				return;
			case AkbPackage.MODEL__APPLICATION_PARTS:
				getApplicationParts().clear();
				return;
			case AkbPackage.MODEL__APPLICATION_PART_SETS:
				getApplicationPartSets().clear();
				return;
			case AkbPackage.MODEL__ATTACK_PATHS:
				getAttackPaths().clear();
				return;
			case AkbPackage.MODEL__ATTACK_STEP_TYPES:
				getAttackStepTypes().clear();
				return;
			case AkbPackage.MODEL__ATTACK_STEPS:
				getAttackSteps().clear();
				return;
			case AkbPackage.MODEL__PROTECTIONS:
				getProtections().clear();
				return;
			case AkbPackage.MODEL__PREFERENCES:
				setPreferences((Preferences)null);
				return;
			case AkbPackage.MODEL__RULES:
				getRules().clear();
				return;
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				return;
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
				return;
			case AkbPackage.MODEL__ATTACKER:
				setAttacker((Attacker)null);
				return;
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES:
				getAttackerToolTypes().clear();
				return;
			case AkbPackage.MODEL__ATTACKER_TOOLS:
				getAttackerTools().clear();
				return;
			case AkbPackage.MODEL__VANILLA_SOLUTION:
				setVanillaSolution((Solution)null);
				return;
			case AkbPackage.MODEL__SOLUTIONS:
				getSolutions().clear();
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
			case AkbPackage.MODEL__ONTOLOGY:
				return ONTOLOGY_EDEFAULT == null ? ontology != null : !ONTOLOGY_EDEFAULT.equals(ontology);
			case AkbPackage.MODEL__APPLICATION_PARTS:
				return applicationParts != null && !applicationParts.isEmpty();
			case AkbPackage.MODEL__APPLICATION_PART_SETS:
				return applicationPartSets != null && !applicationPartSets.isEmpty();
			case AkbPackage.MODEL__ATTACK_PATHS:
				return attackPaths != null && !attackPaths.isEmpty();
			case AkbPackage.MODEL__ATTACK_STEP_TYPES:
				return attackStepTypes != null && !attackStepTypes.isEmpty();
			case AkbPackage.MODEL__ATTACK_STEPS:
				return attackSteps != null && !attackSteps.isEmpty();
			case AkbPackage.MODEL__PROTECTIONS:
				return protections != null && !protections.isEmpty();
			case AkbPackage.MODEL__PREFERENCES:
				return preferences != null;
			case AkbPackage.MODEL__RULES:
				return rules != null && !rules.isEmpty();
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES:
				return protectionObjectives != null && !protectionObjectives.isEmpty();
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS:
				return appliedProtectionInstantiations != null && !appliedProtectionInstantiations.isEmpty();
			case AkbPackage.MODEL__AVAILABLE_PROTECTIONS:
				return !getAvailableProtections().isEmpty();
			case AkbPackage.MODEL__AVAILABLE_SECOND_LEVEL_PROTECTIONS:
				return !getAvailableSecondLevelProtections().isEmpty();
			case AkbPackage.MODEL__ASSETS:
				return !getAssets().isEmpty();
			case AkbPackage.MODEL__ATTACKER:
				return attacker != null;
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES:
				return attackerToolTypes != null && !attackerToolTypes.isEmpty();
			case AkbPackage.MODEL__ATTACKER_TOOLS:
				return attackerTools != null && !attackerTools.isEmpty();
			case AkbPackage.MODEL__VANILLA_SOLUTION:
				return vanillaSolution != null;
			case AkbPackage.MODEL__SOLUTIONS:
				return solutions != null && !solutions.isEmpty();
			case AkbPackage.MODEL__AVAILABLE_TOOLS:
				return !getAvailableTools().isEmpty();
			case AkbPackage.MODEL__APPLICATION_PARTS_COUNT:
				return getApplicationPartsCount() != APPLICATION_PARTS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__ALL_APPLICATION_PARTS:
				return !getAllApplicationParts().isEmpty();
			case AkbPackage.MODEL__ASSETS_COUNT:
				return getAssetsCount() != ASSETS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__DATA_COUNT:
				return getDataCount() != DATA_COUNT_EDEFAULT;
			case AkbPackage.MODEL__CODES_COUNT:
				return getCodesCount() != CODES_COUNT_EDEFAULT;
			case AkbPackage.MODEL__PROTECTIONS_COUNT:
				return getProtectionsCount() != PROTECTIONS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__ATTACKER_TOOLS_COUNT:
				return getAttackerToolsCount() != ATTACKER_TOOLS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__ATTACKER_TOOL_TYPES_COUNT:
				return getAttackerToolTypesCount() != ATTACKER_TOOL_TYPES_COUNT_EDEFAULT;
			case AkbPackage.MODEL__AVAILABLE_ATTACKER_TOOLS_COUNT:
				return getAvailableAttackerToolsCount() != AVAILABLE_ATTACKER_TOOLS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__AVAILABLE_PROTECTIONS_COUNT:
				return getAvailableProtectionsCount() != AVAILABLE_PROTECTIONS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__ATTACK_PATHS_COUNT:
				return getAttackPathsCount() != ATTACK_PATHS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__ATTACK_STEPS_COUNT:
				return getAttackStepsCount() != ATTACK_STEPS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__ATTACK_STEP_TYPES_COUNT:
				return getAttackStepTypesCount() != ATTACK_STEP_TYPES_COUNT_EDEFAULT;
			case AkbPackage.MODEL__PROTECTION_OBJECTIVES_COUNT:
				return getProtectionObjectivesCount() != PROTECTION_OBJECTIVES_COUNT_EDEFAULT;
			case AkbPackage.MODEL__APPLIED_PROTECTION_INSTANTIATIONS_COUNT:
				return getAppliedProtectionInstantiationsCount() != APPLIED_PROTECTION_INSTANTIATIONS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__PROTECTION_INSTANTIATIONS_COUNT:
				return getProtectionInstantiationsCount() != PROTECTION_INSTANTIATIONS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__SOLUTIONS_COUNT:
				return getSolutionsCount() != SOLUTIONS_COUNT_EDEFAULT;
			case AkbPackage.MODEL__KEY_ATTACK_PATHS:
				return !getKeyAttackPaths().isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (ontology: ");
		result.append(ontology);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
