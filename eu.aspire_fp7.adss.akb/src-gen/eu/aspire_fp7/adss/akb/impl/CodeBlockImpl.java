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
import eu.aspire_fp7.adss.akb.CodeBlock;
import eu.aspire_fp7.adss.akb.CodeBlockType;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl#getCodeBlocks <em>Code Blocks</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.CodeBlockImpl#getSourceFilePath <em>Source File Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeBlockImpl extends MinimalEObjectImpl.Container implements CodeBlock
{
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CodeBlockType TYPE_EDEFAULT = CodeBlockType.FOR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CodeBlockType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCodeBlocks() <em>Code Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeBlock> codeBlocks;

	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final int START_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected int startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected int endLine = END_LINE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlockImpl()
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
		return AkbPackage.Literals.CODE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CodeBlockType newType)
	{
		CodeBlockType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.CODE_BLOCK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeBlock> getCodeBlocks()
	{
		if (codeBlocks == null)
		{
			codeBlocks = new EObjectContainmentEList<CodeBlock>(CodeBlock.class, this, AkbPackage.CODE_BLOCK__CODE_BLOCKS);
		}
		return codeBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartLine()
	{
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(int newStartLine)
	{
		int oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.CODE_BLOCK__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndLine()
	{
		return endLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(int newEndLine)
	{
		int oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.CODE_BLOCK__END_LINE, oldEndLine, endLine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.CODE_BLOCK__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		CodeBlockType _type = this.getType();
		String _string = _type.toString();
		int _hashCode = _string.hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		String _sourceFilePath = this.getSourceFilePath();
		int _hashCode_1 = _sourceFilePath.hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
		int _startLine = this.getStartLine();
		String _string_1 = Integer.valueOf(_startLine).toString();
		int _hashCode_2 = _string_1.hashCode();
		int _plus_2 = ((31 * result) + _hashCode_2);
		result = _plus_2;
		int _endLine = this.getEndLine();
		String _string_2 = Integer.valueOf(_endLine).toString();
		int _hashCode_3 = _string_2.hashCode();
		int _plus_3 = ((31 * result) + _hashCode_3);
		result = _plus_3;
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
			if ((object instanceof CodeBlock))
			{
				return (((Objects.equal(this.getType(), ((CodeBlock)object).getType()) && Objects.equal(this.getSourceFilePath(), ((CodeBlock)object).getSourceFilePath())) && (this.getStartLine() == ((CodeBlock)object).getStartLine())) && 
					(this.getEndLine() == ((CodeBlock)object).getEndLine()));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case AkbPackage.CODE_BLOCK__CODE_BLOCKS:
				return ((InternalEList<?>)getCodeBlocks()).basicRemove(otherEnd, msgs);
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
			case AkbPackage.CODE_BLOCK__TYPE:
				return getType();
			case AkbPackage.CODE_BLOCK__CODE_BLOCKS:
				return getCodeBlocks();
			case AkbPackage.CODE_BLOCK__START_LINE:
				return getStartLine();
			case AkbPackage.CODE_BLOCK__END_LINE:
				return getEndLine();
			case AkbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				return getSourceFilePath();
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
			case AkbPackage.CODE_BLOCK__TYPE:
				setType((CodeBlockType)newValue);
				return;
			case AkbPackage.CODE_BLOCK__CODE_BLOCKS:
				getCodeBlocks().clear();
				getCodeBlocks().addAll((Collection<? extends CodeBlock>)newValue);
				return;
			case AkbPackage.CODE_BLOCK__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case AkbPackage.CODE_BLOCK__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case AkbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				setSourceFilePath((String)newValue);
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
			case AkbPackage.CODE_BLOCK__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case AkbPackage.CODE_BLOCK__CODE_BLOCKS:
				getCodeBlocks().clear();
				return;
			case AkbPackage.CODE_BLOCK__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case AkbPackage.CODE_BLOCK__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case AkbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
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
			case AkbPackage.CODE_BLOCK__TYPE:
				return type != TYPE_EDEFAULT;
			case AkbPackage.CODE_BLOCK__CODE_BLOCKS:
				return codeBlocks != null && !codeBlocks.isEmpty();
			case AkbPackage.CODE_BLOCK__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case AkbPackage.CODE_BLOCK__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case AkbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
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
			case AkbPackage.CODE_BLOCK___HASH_CODE:
				return hashCode();
			case AkbPackage.CODE_BLOCK___EQUALS__OBJECT:
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
		result.append(" (type: ");
		result.append(type);
		result.append(", startLine: ");
		result.append(startLine);
		result.append(", endLine: ");
		result.append(endLine);
		result.append(", sourceFilePath: ");
		result.append(sourceFilePath);
		result.append(')');
		return result.toString();
	}

} //CodeBlockImpl
