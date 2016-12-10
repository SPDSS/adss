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
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStepType;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Protection;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack Mitigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackMitigationImpl#getProtection <em>Protection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackMitigationImpl extends MinimalEObjectImpl.Container implements AttackMitigation
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Level LEVEL_EDEFAULT = Level.HIGH;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected Level level = LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AttackStepType type;

	/**
	 * The cached value of the '{@link #getAttackPaths() <em>Attack Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackPath> attackPaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackMitigationImpl()
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
		return AkbPackage.Literals.ATTACK_MITIGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACK_MITIGATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getLevel()
	{
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(Level newLevel)
	{
		Level oldLevel = level;
		level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACK_MITIGATION__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType getType()
	{
		if (type != null && type.eIsProxy())
		{
			InternalEObject oldType = (InternalEObject)type;
			type = (AttackStepType)eResolveProxy(oldType);
			if (type != oldType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AkbPackage.ATTACK_MITIGATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType basicGetType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AttackStepType newType)
	{
		AttackStepType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACK_MITIGATION__TYPE, oldType, type));
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
			attackPaths = new EObjectResolvingEList<AttackPath>(AttackPath.class, this, AkbPackage.ATTACK_MITIGATION__ATTACK_PATHS);
		}
		return attackPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection getProtection()
	{
		if (eContainerFeatureID() != AkbPackage.ATTACK_MITIGATION__PROTECTION) return null;
		return (Protection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection basicGetProtection()
	{
		if (eContainerFeatureID() != AkbPackage.ATTACK_MITIGATION__PROTECTION) return null;
		return (Protection)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProtection(Protection newProtection, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newProtection, AkbPackage.ATTACK_MITIGATION__PROTECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtection(Protection newProtection)
	{
		if (newProtection != eInternalContainer() || (eContainerFeatureID() != AkbPackage.ATTACK_MITIGATION__PROTECTION && newProtection != null))
		{
			if (EcoreUtil.isAncestor(this, newProtection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProtection != null)
				msgs = ((InternalEObject)newProtection).eInverseAdd(this, AkbPackage.PROTECTION__MITIGATIONS, Protection.class, msgs);
			msgs = basicSetProtection(newProtection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACK_MITIGATION__PROTECTION, newProtection, newProtection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		String _name = this.getName();
		int _hashCode = _name.hashCode();
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
			if ((object instanceof AttackMitigation))
			{
				String _name = this.getName();
				String _name_1 = ((AttackMitigation)object).getName();
				return Objects.equal(_name, _name_1);
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProtection((Protection)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				return basicSetProtection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				return eInternalContainer().eInverseRemove(this, AkbPackage.PROTECTION__MITIGATIONS, Protection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case AkbPackage.ATTACK_MITIGATION__NAME:
				return getName();
			case AkbPackage.ATTACK_MITIGATION__LEVEL:
				return getLevel();
			case AkbPackage.ATTACK_MITIGATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case AkbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				return getAttackPaths();
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				if (resolve) return getProtection();
				return basicGetProtection();
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
			case AkbPackage.ATTACK_MITIGATION__NAME:
				setName((String)newValue);
				return;
			case AkbPackage.ATTACK_MITIGATION__LEVEL:
				setLevel((Level)newValue);
				return;
			case AkbPackage.ATTACK_MITIGATION__TYPE:
				setType((AttackStepType)newValue);
				return;
			case AkbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				getAttackPaths().clear();
				getAttackPaths().addAll((Collection<? extends AttackPath>)newValue);
				return;
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				setProtection((Protection)newValue);
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
			case AkbPackage.ATTACK_MITIGATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AkbPackage.ATTACK_MITIGATION__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case AkbPackage.ATTACK_MITIGATION__TYPE:
				setType((AttackStepType)null);
				return;
			case AkbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				getAttackPaths().clear();
				return;
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				setProtection((Protection)null);
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
			case AkbPackage.ATTACK_MITIGATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AkbPackage.ATTACK_MITIGATION__LEVEL:
				return level != LEVEL_EDEFAULT;
			case AkbPackage.ATTACK_MITIGATION__TYPE:
				return type != null;
			case AkbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				return attackPaths != null && !attackPaths.isEmpty();
			case AkbPackage.ATTACK_MITIGATION__PROTECTION:
				return basicGetProtection() != null;
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
			case AkbPackage.ATTACK_MITIGATION___HASH_CODE:
				return hashCode();
			case AkbPackage.ATTACK_MITIGATION___EQUALS__OBJECT:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", level: ");
		result.append(level);
		result.append(')');
		return result.toString();
	}

} //AttackMitigationImpl
