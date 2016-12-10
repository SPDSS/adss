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

import com.google.common.collect.Iterables;

import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartSet;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.CodeBlock;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.UseTarget;

import java.lang.reflect.InvocationTargetException;

import java.nio.file.Path;
import java.nio.file.Paths;

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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getId <em>Id</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getSets <em>Sets</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getDeclaringCode <em>Declaring Code</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getDatumSize <em>Datum Size</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#isInSystemFile <em>In System File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getShortLocation <em>Short Location</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getSecurityProperties <em>Security Properties</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#isAsset <em>Asset</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getTargetOf <em>Target Of</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getBody <em>Body</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getApplicationPartsCount <em>Application Parts Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.ApplicationPartImpl#getAssets <em>Assets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationPartImpl extends MinimalEObjectImpl.Container implements ApplicationPart
{
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

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
	 * The cached value of the '{@link #getSets() <em>Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPartSet> sets;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ApplicationPartType TYPE_EDEFAULT = ApplicationPartType.CODE_REGION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ApplicationPartType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

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
	 * The default value of the '{@link #getDatumSize() <em>Datum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumSize()
	 * @generated
	 * @ordered
	 */
	protected static final int DATUM_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDatumSize() <em>Datum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumSize()
	 * @generated
	 * @ordered
	 */
	protected int datumSize = DATUM_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInSystemFile() <em>In System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInSystemFile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_SYSTEM_FILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInSystemFile() <em>In System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInSystemFile()
	 * @generated
	 * @ordered
	 */
	protected boolean inSystemFile = IN_SYSTEM_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGlobal() <em>Global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGlobal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GLOBAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getShortLocation() <em>Short Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_LOCATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected double weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isAsset() <em>Asset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsset()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASSET_EDEFAULT = false;

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
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<UseTarget> uses;

	/**
	 * The cached value of the '{@link #getTargetOf() <em>Target Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOf()
	 * @generated
	 * @ordered
	 */
	protected EList<UseTarget> targetOf;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock body;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationPartImpl()
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
		return AkbPackage.Literals.APPLICATION_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId)
	{
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPartSet> getSets()
	{
		if (sets == null)
		{
			sets = new EObjectWithInverseResolvingEList.ManyInverse<ApplicationPartSet>(ApplicationPartSet.class, this, AkbPackage.APPLICATION_PART__SETS, AkbPackage.APPLICATION_PART_SET__APPLICATION_PARTS);
		}
		return sets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPartType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ApplicationPartType newType)
	{
		ApplicationPartType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex)
	{
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties()
	{
		if (properties == null)
		{
			properties = new EDataTypeEList<Property>(Property.class, this, AkbPackage.APPLICATION_PART__PROPERTIES);
		}
		return properties;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart getDeclaringCode()
	{
		if (eContainerFeatureID() != AkbPackage.APPLICATION_PART__DECLARING_CODE) return null;
		return (ApplicationPart)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetDeclaringCode()
	{
		if (eContainerFeatureID() != AkbPackage.APPLICATION_PART__DECLARING_CODE) return null;
		return (ApplicationPart)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringCode(ApplicationPart newDeclaringCode, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newDeclaringCode, AkbPackage.APPLICATION_PART__DECLARING_CODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringCode(ApplicationPart newDeclaringCode)
	{
		if (newDeclaringCode != eInternalContainer() || (eContainerFeatureID() != AkbPackage.APPLICATION_PART__DECLARING_CODE && newDeclaringCode != null))
		{
			if (EcoreUtil.isAncestor(this, newDeclaringCode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaringCode != null)
				msgs = ((InternalEObject)newDeclaringCode).eInverseAdd(this, AkbPackage.APPLICATION_PART__APPLICATION_PARTS, ApplicationPart.class, msgs);
			msgs = basicSetDeclaringCode(newDeclaringCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__DECLARING_CODE, newDeclaringCode, newDeclaringCode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__START_LINE, oldStartLine, startLine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__END_LINE, oldEndLine, endLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDatumSize()
	{
		return datumSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatumSize(int newDatumSize)
	{
		int oldDatumSize = datumSize;
		datumSize = newDatumSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__DATUM_SIZE, oldDatumSize, datumSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInSystemFile()
	{
		return inSystemFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSystemFile(boolean newInSystemFile)
	{
		boolean oldInSystemFile = inSystemFile;
		inSystemFile = newInSystemFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__IN_SYSTEM_FILE, oldInSystemFile, inSystemFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGlobal()
	{
		ApplicationPart _declaringCode = this.getDeclaringCode();
		return Objects.equal(_declaringCode, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortLocation()
	{
		ApplicationPartType _type = this.getType();
		boolean _equals = Objects.equal(_type, ApplicationPartType.REFERENCE);
		if (_equals)
		{
			return "";
		}
		else
		{
			int _startLine = this.getStartLine();
			int _endLine = this.getEndLine();
			boolean _notEquals = (_startLine != _endLine);
			if (_notEquals)
			{
				String _sourceFilePath = this.getSourceFilePath();
				Path _get = Paths.get(_sourceFilePath);
				Path _fileName = _get.getFileName();
				String _plus = (_fileName + " : ");
				int _startLine_1 = this.getStartLine();
				String _plus_1 = (_plus + Integer.valueOf(_startLine_1));
				String _plus_2 = (_plus_1 + "-");
				int _endLine_1 = this.getEndLine();
				return (_plus_2 + Integer.valueOf(_endLine_1));
			}
			else
			{
				String _sourceFilePath_1 = this.getSourceFilePath();
				Path _get_1 = Paths.get(_sourceFilePath_1);
				Path _fileName_1 = _get_1.getFileName();
				String _plus_3 = (_fileName_1 + " : ");
				int _startLine_2 = this.getStartLine();
				return (_plus_3 + Integer.valueOf(_startLine_2));
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWeight()
	{
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(double newWeight)
	{
		double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getSecurityProperties()
	{
		BasicEList<Property> securities = new BasicEList<Property>();
		EList<Property> _properties = this.getProperties();
		for (final Property i : _properties)
		{
			if ((((Objects.equal(i, Property.CONFIDENTIALITY) || Objects.equal(i, Property.HARDCONFIDENTIALITY)) || Objects.equal(i, Property.INTEGRITY)) || Objects.equal(i, Property.PRIVACY)))
			{
				securities.add(i);
			}
		}
		return securities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getParameters()
	{
		BasicEList<ApplicationPart> parameters = new BasicEList<ApplicationPart>();
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			ApplicationPartType _type = i.getType();
			boolean _equals = Objects.equal(_type, ApplicationPartType.PARAMETER);
			if (_equals)
			{
				parameters.add(i);
			}
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsset()
	{
		EList<Property> _securityProperties = this.getSecurityProperties();
		boolean _isEmpty = _securityProperties.isEmpty();
		return (!_isEmpty);
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
			applicationParts = new EObjectContainmentWithInverseEList<ApplicationPart>(ApplicationPart.class, this, AkbPackage.APPLICATION_PART__APPLICATION_PARTS, AkbPackage.APPLICATION_PART__DECLARING_CODE);
		}
		return applicationParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseTarget> getUses()
	{
		if (uses == null)
		{
			uses = new EObjectContainmentWithInverseEList<UseTarget>(UseTarget.class, this, AkbPackage.APPLICATION_PART__USES, AkbPackage.USE_TARGET__USED_BY);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseTarget> getTargetOf()
	{
		if (targetOf == null)
		{
			targetOf = new EObjectWithInverseResolvingEList<UseTarget>(UseTarget.class, this, AkbPackage.APPLICATION_PART__TARGET_OF, AkbPackage.USE_TARGET__TARGET);
		}
		return targetOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getBody()
	{
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(CodeBlock newBody, NotificationChain msgs)
	{
		CodeBlock oldBody = body;
		body = newBody;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(CodeBlock newBody)
	{
		if (newBody != body)
		{
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AkbPackage.APPLICATION_PART__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AkbPackage.APPLICATION_PART__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.APPLICATION_PART__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getApplicationPartsCount()
	{
		int count = 1;
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			int _applicationPartsCount = i.getApplicationPartsCount();
			int _plus = (count + _applicationPartsCount);
			count = _plus;
		}
		return count;
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
	public boolean contains(final ApplicationPart part)
	{
		boolean _equals = Objects.equal(this, part);
		if (_equals)
		{
			return true;
		}
		else
		{
			EList<ApplicationPart> _applicationParts = this.getApplicationParts();
			for (final ApplicationPart i : _applicationParts)
			{
				boolean _contains = i.contains(part);
				if (_contains)
				{
					return true;
				}
			}
		}
		return false;
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
		boolean _notEquals = (!Objects.equal(_sourceFilePath, null));
		if (_notEquals)
		{
			String _sourceFilePath_1 = this.getSourceFilePath();
			int _hashCode = _sourceFilePath_1.hashCode();
			int _plus = ((31 * result) + _hashCode);
			result = _plus;
		}
		String _name = this.getName();
		int _hashCode_1 = _name.hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
		ApplicationPartType _type = this.getType();
		String _string = _type.toString();
		int _hashCode_2 = _string.hashCode();
		int _plus_2 = ((31 * result) + _hashCode_2);
		result = _plus_2;
		int _startLine = this.getStartLine();
		String _string_1 = Integer.valueOf(_startLine).toString();
		int _hashCode_3 = _string_1.hashCode();
		int _plus_3 = ((31 * result) + _hashCode_3);
		result = _plus_3;
		int _endLine = this.getEndLine();
		String _string_2 = Integer.valueOf(_endLine).toString();
		int _hashCode_4 = _string_2.hashCode();
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
			if ((object instanceof ApplicationPart))
			{
				return ((((Objects.equal(this.getSourceFilePath(), ((ApplicationPart)object).getSourceFilePath()) && Objects.equal(this.getName(), ((ApplicationPart)object).getName())) && Objects.equal(this.getType(), ((ApplicationPart)object).getType())) && (this.getStartLine() == ((ApplicationPart)object).getStartLine())) && 
					(this.getEndLine() == ((ApplicationPart)object).getEndLine()));
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
	public boolean isDatum()
	{
		return ((((((((Objects.equal(this.getType(), ApplicationPartType.CRYPTOGRAPHIC_KEY) || Objects.equal(this.getType(), ApplicationPartType.INTEGER_DATUM)) || 
			Objects.equal(this.getType(), ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM)) || Objects.equal(this.getType(), ApplicationPartType.INTEGER_ARRAY_DATUM)) || 
			Objects.equal(this.getType(), ApplicationPartType.GENERIC_VARIABLE)) || Objects.equal(this.getType(), ApplicationPartType.PARAMETER)) || Objects.equal(this.getType(), ApplicationPartType.INITIALIZATION_VECTOR)) || 
			Objects.equal(this.getType(), ApplicationPartType.PLAINTEXT)) || Objects.equal(this.getType(), ApplicationPartType.CIPHERTEXT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCode()
	{
		return (Objects.equal(this.getType(), ApplicationPartType.CODE_REGION) || Objects.equal(this.getType(), ApplicationPartType.FUNCTION));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containsAsset()
	{
		BasicEList<ApplicationPart> aux = new BasicEList<ApplicationPart>();
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		aux.addAll(_applicationParts);
		while ((!aux.isEmpty()))
		{
			{
				ApplicationPart p = aux.get(0);
				boolean _isAsset = p.isAsset();
				if (_isAsset)
				{
					return true;
				}
				aux.remove(0);
				EList<ApplicationPart> _applicationParts_1 = p.getApplicationParts();
				for (final ApplicationPart j : _applicationParts_1)
				{
					aux.add(0, j);
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case AkbPackage.APPLICATION_PART__SETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSets()).basicAdd(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringCode((ApplicationPart)otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getApplicationParts()).basicAdd(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__USES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUses()).basicAdd(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__TARGET_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetOf()).basicAdd(otherEnd, msgs);
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
			case AkbPackage.APPLICATION_PART__SETS:
				return ((InternalEList<?>)getSets()).basicRemove(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				return basicSetDeclaringCode(null, msgs);
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return ((InternalEList<?>)getApplicationParts()).basicRemove(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__TARGET_OF:
				return ((InternalEList<?>)getTargetOf()).basicRemove(otherEnd, msgs);
			case AkbPackage.APPLICATION_PART__BODY:
				return basicSetBody(null, msgs);
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
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				return eInternalContainer().eInverseRemove(this, AkbPackage.APPLICATION_PART__APPLICATION_PARTS, ApplicationPart.class, msgs);
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
			case AkbPackage.APPLICATION_PART__ID:
				return getId();
			case AkbPackage.APPLICATION_PART__NAME:
				return getName();
			case AkbPackage.APPLICATION_PART__SETS:
				return getSets();
			case AkbPackage.APPLICATION_PART__TYPE:
				return getType();
			case AkbPackage.APPLICATION_PART__INDEX:
				return getIndex();
			case AkbPackage.APPLICATION_PART__PROPERTIES:
				return getProperties();
			case AkbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				return getSourceFilePath();
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				if (resolve) return getDeclaringCode();
				return basicGetDeclaringCode();
			case AkbPackage.APPLICATION_PART__START_LINE:
				return getStartLine();
			case AkbPackage.APPLICATION_PART__END_LINE:
				return getEndLine();
			case AkbPackage.APPLICATION_PART__DATUM_SIZE:
				return getDatumSize();
			case AkbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				return isInSystemFile();
			case AkbPackage.APPLICATION_PART__GLOBAL:
				return isGlobal();
			case AkbPackage.APPLICATION_PART__SHORT_LOCATION:
				return getShortLocation();
			case AkbPackage.APPLICATION_PART__WEIGHT:
				return getWeight();
			case AkbPackage.APPLICATION_PART__SECURITY_PROPERTIES:
				return getSecurityProperties();
			case AkbPackage.APPLICATION_PART__PARAMETERS:
				return getParameters();
			case AkbPackage.APPLICATION_PART__ASSET:
				return isAsset();
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return getApplicationParts();
			case AkbPackage.APPLICATION_PART__USES:
				return getUses();
			case AkbPackage.APPLICATION_PART__TARGET_OF:
				return getTargetOf();
			case AkbPackage.APPLICATION_PART__BODY:
				return getBody();
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS_COUNT:
				return getApplicationPartsCount();
			case AkbPackage.APPLICATION_PART__ASSETS:
				return getAssets();
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
			case AkbPackage.APPLICATION_PART__ID:
				setId((Integer)newValue);
				return;
			case AkbPackage.APPLICATION_PART__NAME:
				setName((String)newValue);
				return;
			case AkbPackage.APPLICATION_PART__SETS:
				getSets().clear();
				getSets().addAll((Collection<? extends ApplicationPartSet>)newValue);
				return;
			case AkbPackage.APPLICATION_PART__TYPE:
				setType((ApplicationPartType)newValue);
				return;
			case AkbPackage.APPLICATION_PART__INDEX:
				setIndex((Integer)newValue);
				return;
			case AkbPackage.APPLICATION_PART__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case AkbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				setSourceFilePath((String)newValue);
				return;
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				setDeclaringCode((ApplicationPart)newValue);
				return;
			case AkbPackage.APPLICATION_PART__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case AkbPackage.APPLICATION_PART__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case AkbPackage.APPLICATION_PART__DATUM_SIZE:
				setDatumSize((Integer)newValue);
				return;
			case AkbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				setInSystemFile((Boolean)newValue);
				return;
			case AkbPackage.APPLICATION_PART__WEIGHT:
				setWeight((Double)newValue);
				return;
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS:
				getApplicationParts().clear();
				getApplicationParts().addAll((Collection<? extends ApplicationPart>)newValue);
				return;
			case AkbPackage.APPLICATION_PART__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends UseTarget>)newValue);
				return;
			case AkbPackage.APPLICATION_PART__TARGET_OF:
				getTargetOf().clear();
				getTargetOf().addAll((Collection<? extends UseTarget>)newValue);
				return;
			case AkbPackage.APPLICATION_PART__BODY:
				setBody((CodeBlock)newValue);
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
			case AkbPackage.APPLICATION_PART__ID:
				setId(ID_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__SETS:
				getSets().clear();
				return;
			case AkbPackage.APPLICATION_PART__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__PROPERTIES:
				getProperties().clear();
				return;
			case AkbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				setDeclaringCode((ApplicationPart)null);
				return;
			case AkbPackage.APPLICATION_PART__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__DATUM_SIZE:
				setDatumSize(DATUM_SIZE_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				setInSystemFile(IN_SYSTEM_FILE_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS:
				getApplicationParts().clear();
				return;
			case AkbPackage.APPLICATION_PART__USES:
				getUses().clear();
				return;
			case AkbPackage.APPLICATION_PART__TARGET_OF:
				getTargetOf().clear();
				return;
			case AkbPackage.APPLICATION_PART__BODY:
				setBody((CodeBlock)null);
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
			case AkbPackage.APPLICATION_PART__ID:
				return id != ID_EDEFAULT;
			case AkbPackage.APPLICATION_PART__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AkbPackage.APPLICATION_PART__SETS:
				return sets != null && !sets.isEmpty();
			case AkbPackage.APPLICATION_PART__TYPE:
				return type != TYPE_EDEFAULT;
			case AkbPackage.APPLICATION_PART__INDEX:
				return index != INDEX_EDEFAULT;
			case AkbPackage.APPLICATION_PART__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case AkbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
			case AkbPackage.APPLICATION_PART__DECLARING_CODE:
				return basicGetDeclaringCode() != null;
			case AkbPackage.APPLICATION_PART__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case AkbPackage.APPLICATION_PART__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case AkbPackage.APPLICATION_PART__DATUM_SIZE:
				return datumSize != DATUM_SIZE_EDEFAULT;
			case AkbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				return inSystemFile != IN_SYSTEM_FILE_EDEFAULT;
			case AkbPackage.APPLICATION_PART__GLOBAL:
				return isGlobal() != GLOBAL_EDEFAULT;
			case AkbPackage.APPLICATION_PART__SHORT_LOCATION:
				return SHORT_LOCATION_EDEFAULT == null ? getShortLocation() != null : !SHORT_LOCATION_EDEFAULT.equals(getShortLocation());
			case AkbPackage.APPLICATION_PART__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case AkbPackage.APPLICATION_PART__SECURITY_PROPERTIES:
				return !getSecurityProperties().isEmpty();
			case AkbPackage.APPLICATION_PART__PARAMETERS:
				return !getParameters().isEmpty();
			case AkbPackage.APPLICATION_PART__ASSET:
				return isAsset() != ASSET_EDEFAULT;
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return applicationParts != null && !applicationParts.isEmpty();
			case AkbPackage.APPLICATION_PART__USES:
				return uses != null && !uses.isEmpty();
			case AkbPackage.APPLICATION_PART__TARGET_OF:
				return targetOf != null && !targetOf.isEmpty();
			case AkbPackage.APPLICATION_PART__BODY:
				return body != null;
			case AkbPackage.APPLICATION_PART__APPLICATION_PARTS_COUNT:
				return getApplicationPartsCount() != APPLICATION_PARTS_COUNT_EDEFAULT;
			case AkbPackage.APPLICATION_PART__ASSETS:
				return !getAssets().isEmpty();
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
			case AkbPackage.APPLICATION_PART___CONTAINS__APPLICATIONPART:
				return contains((ApplicationPart)arguments.get(0));
			case AkbPackage.APPLICATION_PART___HASH_CODE:
				return hashCode();
			case AkbPackage.APPLICATION_PART___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case AkbPackage.APPLICATION_PART___TO_STRING:
				return toString();
			case AkbPackage.APPLICATION_PART___IS_DATUM:
				return isDatum();
			case AkbPackage.APPLICATION_PART___IS_CODE:
				return isCode();
			case AkbPackage.APPLICATION_PART___CONTAINS_ASSET:
				return containsAsset();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ApplicationPartImpl
