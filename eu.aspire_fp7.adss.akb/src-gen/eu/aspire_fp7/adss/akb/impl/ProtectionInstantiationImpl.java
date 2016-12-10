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
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protection Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getProtection <em>Protection</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getVariableAnnotation <em>Variable Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getCodeAnnotation <em>Code Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getVerifierAnnotation <em>Verifier Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getAttestatorAnnotation <em>Attestator Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ProtectionInstantiationImpl#getNetworkOverhead <em>Network Overhead</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtectionInstantiationImpl extends MinimalEObjectImpl.Container implements ProtectionInstantiation
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
	 * The default value of the '{@link #getVariableAnnotation() <em>Variable Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableAnnotation() <em>Variable Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String variableAnnotation = VARIABLE_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodeAnnotation() <em>Code Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodeAnnotation() <em>Code Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String codeAnnotation = CODE_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerifierAnnotation() <em>Verifier Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifierAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String VERIFIER_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerifierAnnotation() <em>Verifier Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifierAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String verifierAnnotation = VERIFIER_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttestatorAnnotation() <em>Attestator Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttestatorAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTESTATOR_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttestatorAnnotation() <em>Attestator Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttestatorAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String attestatorAnnotation = ATTESTATOR_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_TIME_OVERHEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientTimeOverhead() <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected String clientTimeOverhead = CLIENT_TIME_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerTimeOverhead() <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_TIME_OVERHEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerTimeOverhead() <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerTimeOverhead()
	 * @generated
	 * @ordered
	 */
	protected String serverTimeOverhead = SERVER_TIME_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_MEMORY_OVERHEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientMemoryOverhead() <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected String clientMemoryOverhead = CLIENT_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_MEMORY_OVERHEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerMemoryOverhead() <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerMemoryOverhead()
	 * @generated
	 * @ordered
	 */
	protected String serverMemoryOverhead = SERVER_MEMORY_OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final String NETWORK_OVERHEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNetworkOverhead() <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkOverhead()
	 * @generated
	 * @ordered
	 */
	protected String networkOverhead = NETWORK_OVERHEAD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtectionInstantiationImpl()
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
		return AkbPackage.Literals.PROTECTION_INSTANTIATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection getProtection()
	{
		if (eContainerFeatureID() != AkbPackage.PROTECTION_INSTANTIATION__PROTECTION) return null;
		return (Protection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection basicGetProtection()
	{
		if (eContainerFeatureID() != AkbPackage.PROTECTION_INSTANTIATION__PROTECTION) return null;
		return (Protection)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProtection(Protection newProtection, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newProtection, AkbPackage.PROTECTION_INSTANTIATION__PROTECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtection(Protection newProtection)
	{
		if (newProtection != eInternalContainer() || (eContainerFeatureID() != AkbPackage.PROTECTION_INSTANTIATION__PROTECTION && newProtection != null))
		{
			if (EcoreUtil.isAncestor(this, newProtection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProtection != null)
				msgs = ((InternalEObject)newProtection).eInverseAdd(this, AkbPackage.PROTECTION__INSTANTIATIONS, Protection.class, msgs);
			msgs = basicSetProtection(newProtection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__PROTECTION, newProtection, newProtection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableAnnotation()
	{
		return variableAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableAnnotation(String newVariableAnnotation)
	{
		String oldVariableAnnotation = variableAnnotation;
		variableAnnotation = newVariableAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION, oldVariableAnnotation, variableAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodeAnnotation()
	{
		return codeAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeAnnotation(String newCodeAnnotation)
	{
		String oldCodeAnnotation = codeAnnotation;
		codeAnnotation = newCodeAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__CODE_ANNOTATION, oldCodeAnnotation, codeAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVerifierAnnotation()
	{
		return verifierAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerifierAnnotation(String newVerifierAnnotation)
	{
		String oldVerifierAnnotation = verifierAnnotation;
		verifierAnnotation = newVerifierAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION, oldVerifierAnnotation, verifierAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttestatorAnnotation()
	{
		return attestatorAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttestatorAnnotation(String newAttestatorAnnotation)
	{
		String oldAttestatorAnnotation = attestatorAnnotation;
		attestatorAnnotation = newAttestatorAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION, oldAttestatorAnnotation, attestatorAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientTimeOverhead()
	{
		return clientTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientTimeOverhead(String newClientTimeOverhead)
	{
		String oldClientTimeOverhead = clientTimeOverhead;
		clientTimeOverhead = newClientTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD, oldClientTimeOverhead, clientTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerTimeOverhead()
	{
		return serverTimeOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerTimeOverhead(String newServerTimeOverhead)
	{
		String oldServerTimeOverhead = serverTimeOverhead;
		serverTimeOverhead = newServerTimeOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD, oldServerTimeOverhead, serverTimeOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientMemoryOverhead()
	{
		return clientMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientMemoryOverhead(String newClientMemoryOverhead)
	{
		String oldClientMemoryOverhead = clientMemoryOverhead;
		clientMemoryOverhead = newClientMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD, oldClientMemoryOverhead, clientMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerMemoryOverhead()
	{
		return serverMemoryOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerMemoryOverhead(String newServerMemoryOverhead)
	{
		String oldServerMemoryOverhead = serverMemoryOverhead;
		serverMemoryOverhead = newServerMemoryOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD, oldServerMemoryOverhead, serverMemoryOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNetworkOverhead()
	{
		return networkOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetworkOverhead(String newNetworkOverhead)
	{
		String oldNetworkOverhead = networkOverhead;
		networkOverhead = newNetworkOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.PROTECTION_INSTANTIATION__NETWORK_OVERHEAD, oldNetworkOverhead, networkOverhead));
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
			if ((object instanceof ProtectionInstantiation))
			{
				String _name = this.getName();
				String _name_1 = ((ProtectionInstantiation)object).getName();
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
	public String toString()
	{
		return this.getName();
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
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
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
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
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
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
				return eInternalContainer().eInverseRemove(this, AkbPackage.PROTECTION__INSTANTIATIONS, Protection.class, msgs);
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
			case AkbPackage.PROTECTION_INSTANTIATION__NAME:
				return getName();
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
				if (resolve) return getProtection();
				return basicGetProtection();
			case AkbPackage.PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				return getVariableAnnotation();
			case AkbPackage.PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				return getCodeAnnotation();
			case AkbPackage.PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				return getVerifierAnnotation();
			case AkbPackage.PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				return getAttestatorAnnotation();
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD:
				return getClientTimeOverhead();
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD:
				return getServerTimeOverhead();
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD:
				return getClientMemoryOverhead();
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD:
				return getServerMemoryOverhead();
			case AkbPackage.PROTECTION_INSTANTIATION__NETWORK_OVERHEAD:
				return getNetworkOverhead();
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
			case AkbPackage.PROTECTION_INSTANTIATION__NAME:
				setName((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
				setProtection((Protection)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				setVariableAnnotation((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				setCodeAnnotation((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				setVerifierAnnotation((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				setAttestatorAnnotation((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead((String)newValue);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__NETWORK_OVERHEAD:
				setNetworkOverhead((String)newValue);
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
			case AkbPackage.PROTECTION_INSTANTIATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
				setProtection((Protection)null);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				setVariableAnnotation(VARIABLE_ANNOTATION_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				setCodeAnnotation(CODE_ANNOTATION_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				setVerifierAnnotation(VERIFIER_ANNOTATION_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				setAttestatorAnnotation(ATTESTATOR_ANNOTATION_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD:
				setClientTimeOverhead(CLIENT_TIME_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD:
				setServerTimeOverhead(SERVER_TIME_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD:
				setClientMemoryOverhead(CLIENT_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD:
				setServerMemoryOverhead(SERVER_MEMORY_OVERHEAD_EDEFAULT);
				return;
			case AkbPackage.PROTECTION_INSTANTIATION__NETWORK_OVERHEAD:
				setNetworkOverhead(NETWORK_OVERHEAD_EDEFAULT);
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
			case AkbPackage.PROTECTION_INSTANTIATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AkbPackage.PROTECTION_INSTANTIATION__PROTECTION:
				return basicGetProtection() != null;
			case AkbPackage.PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				return VARIABLE_ANNOTATION_EDEFAULT == null ? variableAnnotation != null : !VARIABLE_ANNOTATION_EDEFAULT.equals(variableAnnotation);
			case AkbPackage.PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				return CODE_ANNOTATION_EDEFAULT == null ? codeAnnotation != null : !CODE_ANNOTATION_EDEFAULT.equals(codeAnnotation);
			case AkbPackage.PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				return VERIFIER_ANNOTATION_EDEFAULT == null ? verifierAnnotation != null : !VERIFIER_ANNOTATION_EDEFAULT.equals(verifierAnnotation);
			case AkbPackage.PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				return ATTESTATOR_ANNOTATION_EDEFAULT == null ? attestatorAnnotation != null : !ATTESTATOR_ANNOTATION_EDEFAULT.equals(attestatorAnnotation);
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD:
				return CLIENT_TIME_OVERHEAD_EDEFAULT == null ? clientTimeOverhead != null : !CLIENT_TIME_OVERHEAD_EDEFAULT.equals(clientTimeOverhead);
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD:
				return SERVER_TIME_OVERHEAD_EDEFAULT == null ? serverTimeOverhead != null : !SERVER_TIME_OVERHEAD_EDEFAULT.equals(serverTimeOverhead);
			case AkbPackage.PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD:
				return CLIENT_MEMORY_OVERHEAD_EDEFAULT == null ? clientMemoryOverhead != null : !CLIENT_MEMORY_OVERHEAD_EDEFAULT.equals(clientMemoryOverhead);
			case AkbPackage.PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD:
				return SERVER_MEMORY_OVERHEAD_EDEFAULT == null ? serverMemoryOverhead != null : !SERVER_MEMORY_OVERHEAD_EDEFAULT.equals(serverMemoryOverhead);
			case AkbPackage.PROTECTION_INSTANTIATION__NETWORK_OVERHEAD:
				return NETWORK_OVERHEAD_EDEFAULT == null ? networkOverhead != null : !NETWORK_OVERHEAD_EDEFAULT.equals(networkOverhead);
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
			case AkbPackage.PROTECTION_INSTANTIATION___HASH_CODE:
				return hashCode();
			case AkbPackage.PROTECTION_INSTANTIATION___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case AkbPackage.PROTECTION_INSTANTIATION___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ProtectionInstantiationImpl
