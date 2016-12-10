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
import eu.aspire_fp7.adss.akb.Attacker;
import eu.aspire_fp7.adss.akb.AttackerTool;
import eu.aspire_fp7.adss.akb.AttackerToolType;
import eu.aspire_fp7.adss.akb.ExpertiseLevel;
import eu.aspire_fp7.adss.akb.Model;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attacker Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerToolImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackerToolImpl extends MinimalEObjectImpl.Container implements AttackerTool
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
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerToolType> types;

	/**
	 * The default value of the '{@link #getExpertise() <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpertise()
	 * @generated
	 * @ordered
	 */
	protected static final ExpertiseLevel EXPERTISE_EDEFAULT = ExpertiseLevel.AMATEUR;

	/**
	 * The cached value of the '{@link #getExpertise() <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpertise()
	 * @generated
	 * @ordered
	 */
	protected ExpertiseLevel expertise = EXPERTISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected static final int COST_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected int cost = COST_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackerToolImpl()
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
		return AkbPackage.Literals.ATTACKER_TOOL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACKER_TOOL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerToolType> getTypes()
	{
		if (types == null)
		{
			types = new EObjectResolvingEList<AttackerToolType>(AttackerToolType.class, this, AkbPackage.ATTACKER_TOOL__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpertiseLevel getExpertise()
	{
		return expertise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpertise(ExpertiseLevel newExpertise)
	{
		ExpertiseLevel oldExpertise = expertise;
		expertise = newExpertise == null ? EXPERTISE_EDEFAULT : newExpertise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACKER_TOOL__EXPERTISE, oldExpertise, expertise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCost()
	{
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCost(int newCost)
	{
		int oldCost = cost;
		cost = newCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACKER_TOOL__COST, oldCost, cost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		EObject _eContainer = this.eContainer();
		Attacker attacker = ((Model) _eContainer).getAttacker();
		if (((!Objects.equal(attacker.getBudgetLimit(), null)) && (this.getCost() > (attacker.getBudgetLimit()).intValue())))
		{
			return false;
		}
		if ((Objects.equal(attacker.getExpertise(), ExpertiseLevel.AMATEUR) && (!Objects.equal(this.getExpertise(), ExpertiseLevel.AMATEUR))))
		{
			return false;
		}
		if (((Objects.equal(attacker.getExpertise(), ExpertiseLevel.GEEK) && (!Objects.equal(this.getExpertise(), ExpertiseLevel.AMATEUR))) && 
			(!Objects.equal(this.getExpertise(), ExpertiseLevel.GEEK))))
		{
			return false;
		}
		if ((((Objects.equal(attacker.getExpertise(), ExpertiseLevel.EXPERT) && (!Objects.equal(this.getExpertise(), ExpertiseLevel.AMATEUR))) && 
			(!Objects.equal(this.getExpertise(), ExpertiseLevel.GEEK))) && (!Objects.equal(this.getExpertise(), ExpertiseLevel.EXPERT))))
		{
			return false;
		}
		return true;
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
			if ((object instanceof AttackerTool))
			{
				String _name = this.getName();
				String _name_1 = ((AttackerTool)object).getName();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case AkbPackage.ATTACKER_TOOL__NAME:
				return getName();
			case AkbPackage.ATTACKER_TOOL__TYPES:
				return getTypes();
			case AkbPackage.ATTACKER_TOOL__EXPERTISE:
				return getExpertise();
			case AkbPackage.ATTACKER_TOOL__COST:
				return getCost();
			case AkbPackage.ATTACKER_TOOL__ENABLED:
				return isEnabled();
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
			case AkbPackage.ATTACKER_TOOL__NAME:
				setName((String)newValue);
				return;
			case AkbPackage.ATTACKER_TOOL__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends AttackerToolType>)newValue);
				return;
			case AkbPackage.ATTACKER_TOOL__EXPERTISE:
				setExpertise((ExpertiseLevel)newValue);
				return;
			case AkbPackage.ATTACKER_TOOL__COST:
				setCost((Integer)newValue);
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
			case AkbPackage.ATTACKER_TOOL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AkbPackage.ATTACKER_TOOL__TYPES:
				getTypes().clear();
				return;
			case AkbPackage.ATTACKER_TOOL__EXPERTISE:
				setExpertise(EXPERTISE_EDEFAULT);
				return;
			case AkbPackage.ATTACKER_TOOL__COST:
				setCost(COST_EDEFAULT);
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
			case AkbPackage.ATTACKER_TOOL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AkbPackage.ATTACKER_TOOL__TYPES:
				return types != null && !types.isEmpty();
			case AkbPackage.ATTACKER_TOOL__EXPERTISE:
				return expertise != EXPERTISE_EDEFAULT;
			case AkbPackage.ATTACKER_TOOL__COST:
				return cost != COST_EDEFAULT;
			case AkbPackage.ATTACKER_TOOL__ENABLED:
				return isEnabled() != ENABLED_EDEFAULT;
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
			case AkbPackage.ATTACKER_TOOL___HASH_CODE:
				return hashCode();
			case AkbPackage.ATTACKER_TOOL___EQUALS__OBJECT:
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
		result.append(", expertise: ");
		result.append(expertise);
		result.append(", cost: ");
		result.append(cost);
		result.append(')');
		return result.toString();
	}

} //AttackerToolImpl
