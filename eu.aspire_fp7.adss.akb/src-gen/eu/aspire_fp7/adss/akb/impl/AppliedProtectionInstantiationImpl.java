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

import eu.aspire_fp7.adss.akb.ActionType;
import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartSet;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.akb.SecondLevelMotivation;
import eu.aspire_fp7.adss.akb.SecondLevelMotivationType;

import eu.aspire_fp7.adss.util.Strings;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Applied Protection Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl#getProtectionInstantiation <em>Protection Instantiation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl#getAttackMitigations <em>Attack Mitigations</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AppliedProtectionInstantiationImpl#getSecondLevelMotivation <em>Second Level Motivation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AppliedProtectionInstantiationImpl extends MinimalEObjectImpl.Container implements AppliedProtectionInstantiation
{
	/**
	 * The cached value of the '{@link #getProtectionInstantiation() <em>Protection Instantiation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionInstantiation()
	 * @generated
	 * @ordered
	 */
	protected ProtectionInstantiation protectionInstantiation;

	/**
	 * The cached value of the '{@link #getApplicationPart() <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPart()
	 * @generated
	 * @ordered
	 */
	protected ApplicationPart applicationPart;

	/**
	 * The cached value of the '{@link #getProtectionObjectives() <em>Protection Objectives</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionObjectives()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtectionObjective> protectionObjectives;

	/**
	 * The cached value of the '{@link #getAttackMitigations() <em>Attack Mitigations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackMitigations()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackMitigation> attackMitigations;

	/**
	 * The cached value of the '{@link #getSecondLevelMotivation() <em>Second Level Motivation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelMotivation()
	 * @generated
	 * @ordered
	 */
	protected EList<SecondLevelMotivation> secondLevelMotivation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppliedProtectionInstantiationImpl()
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
		return AkbPackage.Literals.APPLIED_PROTECTION_INSTANTIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectionInstantiation getProtectionInstantiation()
	{
		if (protectionInstantiation != null && protectionInstantiation.eIsProxy())
		{
			InternalEObject oldProtectionInstantiation = (InternalEObject)protectionInstantiation;
			protectionInstantiation = (ProtectionInstantiation)eResolveProxy(oldProtectionInstantiation);
			if (protectionInstantiation != oldProtectionInstantiation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION, oldProtectionInstantiation, protectionInstantiation));
			}
		}
		return protectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectionInstantiation basicGetProtectionInstantiation()
	{
		return protectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectionInstantiation(ProtectionInstantiation newProtectionInstantiation)
	{
		ProtectionInstantiation oldProtectionInstantiation = protectionInstantiation;
		protectionInstantiation = newProtectionInstantiation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION, oldProtectionInstantiation, protectionInstantiation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart getApplicationPart()
	{
		if (applicationPart != null && applicationPart.eIsProxy())
		{
			InternalEObject oldApplicationPart = (InternalEObject)applicationPart;
			applicationPart = (ApplicationPart)eResolveProxy(oldApplicationPart);
			if (applicationPart != oldApplicationPart)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART, oldApplicationPart, applicationPart));
			}
		}
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetApplicationPart()
	{
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationPart(ApplicationPart newApplicationPart)
	{
		ApplicationPart oldApplicationPart = applicationPart;
		applicationPart = newApplicationPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART, oldApplicationPart, applicationPart));
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
			protectionObjectives = new EObjectResolvingEList<ProtectionObjective>(ProtectionObjective.class, this, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES);
		}
		return protectionObjectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackMitigation> getAttackMitigations()
	{
		if (attackMitigations == null)
		{
			attackMitigations = new EObjectResolvingEList<AttackMitigation>(AttackMitigation.class, this, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS);
		}
		return attackMitigations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecondLevelMotivation> getSecondLevelMotivation()
	{
		if (secondLevelMotivation == null)
		{
			secondLevelMotivation = new EObjectResolvingEList<SecondLevelMotivation>(SecondLevelMotivation.class, this, AkbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION);
		}
		return secondLevelMotivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		HashSet<ApplicationPart> locations = new HashSet<ApplicationPart>();
		ApplicationPart _applicationPart = this.getApplicationPart();
		locations.add(_applicationPart);
		ApplicationPart _applicationPart_1 = this.getApplicationPart();
		EList<ApplicationPartSet> _sets = _applicationPart_1.getSets();
		for (final ApplicationPartSet i : _sets)
		{
			ProtectionInstantiation _protectionInstantiation = this.getProtectionInstantiation();
			Protection _protection = _protectionInstantiation.getProtection();
			EList<ActionType> _actions = _protection.getActions();
			ActionType _action = i.getAction();
			boolean _contains = _actions.contains(_action);
			if (_contains)
			{
				EList<ApplicationPart> _applicationParts = i.getApplicationParts();
				locations.addAll(_applicationParts);
			}
		}
		EList<SecondLevelMotivation> _secondLevelMotivation = this.getSecondLevelMotivation();
		int _size = _secondLevelMotivation.size();
		boolean _equals = (_size == 0);
		if (_equals)
		{
			ProtectionInstantiation _protectionInstantiation_1 = this.getProtectionInstantiation();
			String _plus = (_protectionInstantiation_1 + " @ ");
			String _join = Strings.join(locations, ", ");
			return (_plus + _join);
		}
		else
		{
			ProtectionInstantiation _protectionInstantiation_2 = this.getProtectionInstantiation();
			String _plus_1 = (_protectionInstantiation_2 + " @ ");
			String _join_1 = Strings.join(locations, ", ");
			String _plus_2 = (_plus_1 + _join_1);
			String _plus_3 = (_plus_2 + " [");
			EList<SecondLevelMotivation> _secondLevelMotivation_1 = this.getSecondLevelMotivation();
			SecondLevelMotivation _get = _secondLevelMotivation_1.get(0);
			SecondLevelMotivationType _motivationType = _get.getMotivationType();
			String _plus_4 = (_plus_3 + _motivationType);
			return (_plus_4 + "]");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		ProtectionInstantiation _protectionInstantiation = this.getProtectionInstantiation();
		int _hashCode = _protectionInstantiation.hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		ApplicationPart _applicationPart = this.getApplicationPart();
		int _hashCode_1 = _applicationPart.hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
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
			if ((object instanceof AppliedProtectionInstantiation))
			{
				return (EcoreUtil.equals(this.getProtectionInstantiation(), ((AppliedProtectionInstantiation)object).getProtectionInstantiation()) && 
					EcoreUtil.equals(this.getApplicationPart(), ((AppliedProtectionInstantiation)object).getApplicationPart()));
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
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				if (resolve) return getProtectionInstantiation();
				return basicGetProtectionInstantiation();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				if (resolve) return getApplicationPart();
				return basicGetApplicationPart();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				return getProtectionObjectives();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				return getAttackMitigations();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				return getSecondLevelMotivation();
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
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				setProtectionInstantiation((ProtectionInstantiation)newValue);
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				setApplicationPart((ApplicationPart)newValue);
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				getProtectionObjectives().addAll((Collection<? extends ProtectionObjective>)newValue);
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				getAttackMitigations().clear();
				getAttackMitigations().addAll((Collection<? extends AttackMitigation>)newValue);
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				getSecondLevelMotivation().clear();
				getSecondLevelMotivation().addAll((Collection<? extends SecondLevelMotivation>)newValue);
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
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				setProtectionInstantiation((ProtectionInstantiation)null);
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				setApplicationPart((ApplicationPart)null);
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				getAttackMitigations().clear();
				return;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				getSecondLevelMotivation().clear();
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
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				return protectionInstantiation != null;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				return applicationPart != null;
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				return protectionObjectives != null && !protectionObjectives.isEmpty();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				return attackMitigations != null && !attackMitigations.isEmpty();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				return secondLevelMotivation != null && !secondLevelMotivation.isEmpty();
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
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION___TO_STRING:
				return toString();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION___HASH_CODE:
				return hashCode();
			case AkbPackage.APPLIED_PROTECTION_INSTANTIATION___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //AppliedProtectionInstantiationImpl
