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
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.ProtectionObjective;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protection Objective</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionObjectiveImpl#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionObjectiveImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtectionObjectiveImpl extends MinimalEObjectImpl.Container implements ProtectionObjective
{
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
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final Property PROPERTY_EDEFAULT = Property.PRIVACY;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property = PROPERTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtectionObjectiveImpl()
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
		return AkbPackage.Literals.PROTECTION_OBJECTIVE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART, oldApplicationPart, applicationPart));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART, oldApplicationPart, applicationPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty()
	{
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty)
	{
		Property oldProperty = property;
		property = newProperty == null ? PROPERTY_EDEFAULT : newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_OBJECTIVE__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		ApplicationPart _applicationPart = this.getApplicationPart();
		int _hashCode = _applicationPart.hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		Property _property = this.getProperty();
		String _string = _property.toString();
		int _hashCode_1 = _string.hashCode();
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
			if ((object instanceof ProtectionObjective))
			{
				return (EcoreUtil.equals(this.getApplicationPart(), ((ProtectionObjective)object).getApplicationPart()) && Objects.equal(this.getProperty(), ((ProtectionObjective)object).getProperty()));
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
	public String toString()
	{
		ApplicationPart _applicationPart = this.getApplicationPart();
		String _plus = (_applicationPart + "/");
		Property _property = this.getProperty();
		return (_plus + _property);
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
			case AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART:
				if (resolve) return getApplicationPart();
				return basicGetApplicationPart();
			case AkbPackage.PROTECTION_OBJECTIVE__PROPERTY:
				return getProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART:
				setApplicationPart((ApplicationPart)newValue);
				return;
			case AkbPackage.PROTECTION_OBJECTIVE__PROPERTY:
				setProperty((Property)newValue);
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
			case AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART:
				setApplicationPart((ApplicationPart)null);
				return;
			case AkbPackage.PROTECTION_OBJECTIVE__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
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
			case AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART:
				return applicationPart != null;
			case AkbPackage.PROTECTION_OBJECTIVE__PROPERTY:
				return property != PROPERTY_EDEFAULT;
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
			case AkbPackage.PROTECTION_OBJECTIVE___HASH_CODE:
				return hashCode();
			case AkbPackage.PROTECTION_OBJECTIVE___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case AkbPackage.PROTECTION_OBJECTIVE___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ProtectionObjectiveImpl
