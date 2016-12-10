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
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.SolutionSequence;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionSequenceImpl#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionSequenceImpl extends MinimalEObjectImpl.Container implements SolutionSequence
{
	/**
	 * The cached value of the '{@link #getAppliedProtectionInstantiations() <em>Applied Protection Instantiations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedProtectionInstantiations()
	 * @generated
	 * @ordered
	 */
	protected EList<AppliedProtectionInstantiation> appliedProtectionInstantiations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionSequenceImpl()
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
		return AkbPackage.Literals.SOLUTION_SEQUENCE;
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
			appliedProtectionInstantiations = new EObjectResolvingEList<AppliedProtectionInstantiation>(AppliedProtectionInstantiation.class, this, AkbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS)
			{
				@Override
				protected boolean isUnique()
				{
					return false;
				}
			};
		}
		return appliedProtectionInstantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();
		return _appliedProtectionInstantiations.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();
		int _hashCode = _appliedProtectionInstantiations.hashCode();
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
			if ((object instanceof SolutionSequence))
			{
				EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();
				EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations_1 = ((SolutionSequence)object).getAppliedProtectionInstantiations();
				return EcoreUtil.equals(_appliedProtectionInstantiations, _appliedProtectionInstantiations_1);
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
			case AkbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				return getAppliedProtectionInstantiations();
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
			case AkbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
				getAppliedProtectionInstantiations().addAll((Collection<? extends AppliedProtectionInstantiation>)newValue);
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
			case AkbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
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
			case AkbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				return appliedProtectionInstantiations != null && !appliedProtectionInstantiations.isEmpty();
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
			case AkbPackage.SOLUTION_SEQUENCE___TO_STRING:
				return toString();
			case AkbPackage.SOLUTION_SEQUENCE___HASH_CODE:
				return hashCode();
			case AkbPackage.SOLUTION_SEQUENCE___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SolutionSequenceImpl
