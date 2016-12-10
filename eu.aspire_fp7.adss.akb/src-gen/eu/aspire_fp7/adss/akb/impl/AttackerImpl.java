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
import eu.aspire_fp7.adss.akb.ExpertiseLevel;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attacker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerImpl#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.AttackerImpl#getBudgetLimit <em>Budget Limit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackerImpl extends MinimalEObjectImpl.Container implements Attacker
{
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
	 * The default value of the '{@link #getBudgetLimit() <em>Budget Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudgetLimit()
	 * @generated
	 * @ordered
	 */
	protected static final Integer BUDGET_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBudgetLimit() <em>Budget Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudgetLimit()
	 * @generated
	 * @ordered
	 */
	protected Integer budgetLimit = BUDGET_LIMIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackerImpl()
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
		return AkbPackage.Literals.ATTACKER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACKER__EXPERTISE, oldExpertise, expertise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getBudgetLimit()
	{
		return budgetLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBudgetLimit(Integer newBudgetLimit)
	{
		Integer oldBudgetLimit = budgetLimit;
		budgetLimit = newBudgetLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.ATTACKER__BUDGET_LIMIT, oldBudgetLimit, budgetLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = "attacker".hashCode();
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
			if ((object instanceof Attacker))
			{
				return (Objects.equal(this.getExpertise(), ((Attacker)object).getExpertise()) && Objects.equal(this.getBudgetLimit(), ((Attacker)object).getBudgetLimit()));
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
			case AkbPackage.ATTACKER__EXPERTISE:
				return getExpertise();
			case AkbPackage.ATTACKER__BUDGET_LIMIT:
				return getBudgetLimit();
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
			case AkbPackage.ATTACKER__EXPERTISE:
				setExpertise((ExpertiseLevel)newValue);
				return;
			case AkbPackage.ATTACKER__BUDGET_LIMIT:
				setBudgetLimit((Integer)newValue);
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
			case AkbPackage.ATTACKER__EXPERTISE:
				setExpertise(EXPERTISE_EDEFAULT);
				return;
			case AkbPackage.ATTACKER__BUDGET_LIMIT:
				setBudgetLimit(BUDGET_LIMIT_EDEFAULT);
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
			case AkbPackage.ATTACKER__EXPERTISE:
				return expertise != EXPERTISE_EDEFAULT;
			case AkbPackage.ATTACKER__BUDGET_LIMIT:
				return BUDGET_LIMIT_EDEFAULT == null ? budgetLimit != null : !BUDGET_LIMIT_EDEFAULT.equals(budgetLimit);
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
			case AkbPackage.ATTACKER___HASH_CODE:
				return hashCode();
			case AkbPackage.ATTACKER___EQUALS__OBJECT:
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
		result.append(" (expertise: ");
		result.append(expertise);
		result.append(", budgetLimit: ");
		result.append(budgetLimit);
		result.append(')');
		return result.toString();
	}

} //AttackerImpl
