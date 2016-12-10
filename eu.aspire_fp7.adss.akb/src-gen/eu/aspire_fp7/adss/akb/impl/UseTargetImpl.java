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
import eu.aspire_fp7.adss.akb.UseTarget;
import eu.aspire_fp7.adss.akb.UseType;

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
 * An implementation of the model object '<em><b>Use Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl#getUsedBy <em>Used By</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl#getLine <em>Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.UseTargetImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UseTargetImpl extends MinimalEObjectImpl.Container implements UseTarget
{
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ApplicationPart target;

	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected int line = LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFilePath()
	 * @generated
	 * @ordered
	 */
	protected String sourceFilePath = SOURCE_FILE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final UseType TYPE_EDEFAULT = UseType.ACCESSES;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected UseType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPart> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseTargetImpl()
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
		return AkbPackage.Literals.USE_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart getTarget()
	{
		if (target != null && target.eIsProxy())
		{
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ApplicationPart)eResolveProxy(oldTarget);
			if (target != oldTarget)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AkbPackage.USE_TARGET__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetTarget()
	{
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ApplicationPart newTarget, NotificationChain msgs)
	{
		ApplicationPart oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AkbPackage.USE_TARGET__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ApplicationPart newTarget)
	{
		if (newTarget != target)
		{
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, AkbPackage.APPLICATION_PART__TARGET_OF, ApplicationPart.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, AkbPackage.APPLICATION_PART__TARGET_OF, ApplicationPart.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.USE_TARGET__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart getUsedBy()
	{
		if (eContainerFeatureID() != AkbPackage.USE_TARGET__USED_BY) return null;
		return (ApplicationPart)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetUsedBy()
	{
		if (eContainerFeatureID() != AkbPackage.USE_TARGET__USED_BY) return null;
		return (ApplicationPart)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsedBy(ApplicationPart newUsedBy, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newUsedBy, AkbPackage.USE_TARGET__USED_BY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedBy(ApplicationPart newUsedBy)
	{
		if (newUsedBy != eInternalContainer() || (eContainerFeatureID() != AkbPackage.USE_TARGET__USED_BY && newUsedBy != null))
		{
			if (EcoreUtil.isAncestor(this, newUsedBy))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUsedBy != null)
				msgs = ((InternalEObject)newUsedBy).eInverseAdd(this, AkbPackage.APPLICATION_PART__USES, ApplicationPart.class, msgs);
			msgs = basicSetUsedBy(newUsedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.USE_TARGET__USED_BY, newUsedBy, newUsedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLine()
	{
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(int newLine)
	{
		int oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.USE_TARGET__LINE, oldLine, line));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFilePath()
	{
		return sourceFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFilePath(String newSourceFilePath)
	{
		String oldSourceFilePath = sourceFilePath;
		sourceFilePath = newSourceFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.USE_TARGET__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(UseType newType)
	{
		UseType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.USE_TARGET__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getParameters()
	{
		if (parameters == null)
		{
			parameters = new EObjectResolvingEList<ApplicationPart>(ApplicationPart.class, this, AkbPackage.USE_TARGET__PARAMETERS)
			{
				@Override
				protected boolean isUnique()
				{
					return false;
				}
			};
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		String _sourceFilePath = this.getSourceFilePath();
		int _hashCode = _sourceFilePath.hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		int _line = this.getLine();
		String _string = Integer.valueOf(_line).toString();
		int _hashCode_1 = _string.hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
		UseType _type = this.getType();
		String _string_1 = _type.toString();
		int _hashCode_2 = _string_1.hashCode();
		int _plus_2 = ((31 * result) + _hashCode_2);
		result = _plus_2;
		ApplicationPart _target = this.getTarget();
		int _hashCode_3 = _target.hashCode();
		int _plus_3 = ((31 * result) + _hashCode_3);
		result = _plus_3;
		EList<ApplicationPart> _parameters = this.getParameters();
		int _hashCode_4 = _parameters.hashCode();
		int _plus_4 = ((31 * result) + _hashCode_4);
		result = _plus_4;
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
			if ((object instanceof UseTarget))
			{
				return ((((Objects.equal(this.getSourceFilePath(), ((UseTarget)object).getSourceFilePath()) && (this.getLine() == ((UseTarget)object).getLine())) && Objects.equal(this.getType(), ((UseTarget)object).getType())) && 
					EcoreUtil.equals(this.getTarget(), ((UseTarget)object).getTarget())) && EcoreUtil.equals(this.getParameters(), ((UseTarget)object).getParameters()));
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
			case AkbPackage.USE_TARGET__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, AkbPackage.APPLICATION_PART__TARGET_OF, ApplicationPart.class, msgs);
				return basicSetTarget((ApplicationPart)otherEnd, msgs);
			case AkbPackage.USE_TARGET__USED_BY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUsedBy((ApplicationPart)otherEnd, msgs);
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
			case AkbPackage.USE_TARGET__TARGET:
				return basicSetTarget(null, msgs);
			case AkbPackage.USE_TARGET__USED_BY:
				return basicSetUsedBy(null, msgs);
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
			case AkbPackage.USE_TARGET__USED_BY:
				return eInternalContainer().eInverseRemove(this, AkbPackage.APPLICATION_PART__USES, ApplicationPart.class, msgs);
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
			case AkbPackage.USE_TARGET__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case AkbPackage.USE_TARGET__USED_BY:
				if (resolve) return getUsedBy();
				return basicGetUsedBy();
			case AkbPackage.USE_TARGET__LINE:
				return getLine();
			case AkbPackage.USE_TARGET__SOURCE_FILE_PATH:
				return getSourceFilePath();
			case AkbPackage.USE_TARGET__TYPE:
				return getType();
			case AkbPackage.USE_TARGET__PARAMETERS:
				return getParameters();
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
			case AkbPackage.USE_TARGET__TARGET:
				setTarget((ApplicationPart)newValue);
				return;
			case AkbPackage.USE_TARGET__USED_BY:
				setUsedBy((ApplicationPart)newValue);
				return;
			case AkbPackage.USE_TARGET__LINE:
				setLine((Integer)newValue);
				return;
			case AkbPackage.USE_TARGET__SOURCE_FILE_PATH:
				setSourceFilePath((String)newValue);
				return;
			case AkbPackage.USE_TARGET__TYPE:
				setType((UseType)newValue);
				return;
			case AkbPackage.USE_TARGET__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ApplicationPart>)newValue);
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
			case AkbPackage.USE_TARGET__TARGET:
				setTarget((ApplicationPart)null);
				return;
			case AkbPackage.USE_TARGET__USED_BY:
				setUsedBy((ApplicationPart)null);
				return;
			case AkbPackage.USE_TARGET__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case AkbPackage.USE_TARGET__SOURCE_FILE_PATH:
				setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
				return;
			case AkbPackage.USE_TARGET__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case AkbPackage.USE_TARGET__PARAMETERS:
				getParameters().clear();
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
			case AkbPackage.USE_TARGET__TARGET:
				return target != null;
			case AkbPackage.USE_TARGET__USED_BY:
				return basicGetUsedBy() != null;
			case AkbPackage.USE_TARGET__LINE:
				return line != LINE_EDEFAULT;
			case AkbPackage.USE_TARGET__SOURCE_FILE_PATH:
				return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
			case AkbPackage.USE_TARGET__TYPE:
				return type != TYPE_EDEFAULT;
			case AkbPackage.USE_TARGET__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
			case AkbPackage.USE_TARGET___HASH_CODE:
				return hashCode();
			case AkbPackage.USE_TARGET___EQUALS__OBJECT:
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
		result.append(" (line: ");
		result.append(line);
		result.append(", sourceFilePath: ");
		result.append(sourceFilePath);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //UseTargetImpl
