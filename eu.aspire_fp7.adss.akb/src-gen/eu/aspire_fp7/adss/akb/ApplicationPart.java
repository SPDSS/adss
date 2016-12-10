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
package eu.aspire_fp7.adss.akb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An application part.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getId <em>Id</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSets <em>Sets</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getIndex <em>Index</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getProperties <em>Properties</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDeclaringCode <em>Declaring Code</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getEndLine <em>End Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDatumSize <em>Datum Size</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#isInSystemFile <em>In System File</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#isGlobal <em>Global</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getShortLocation <em>Short Location</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getWeight <em>Weight</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSecurityProperties <em>Security Properties</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getParameters <em>Parameters</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#isAsset <em>Asset</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getUses <em>Uses</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getTargetOf <em>Target Of</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getBody <em>Body</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationPartsCount <em>Application Parts Count</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPart#getAssets <em>Assets</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#ApplicationPart",
	name = "http://www.aspire-fp7.eu/akb#applicationPart",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__ID, iri = "http://www.aspire-fp7.eu/akb#hasId"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__SOURCE_FILE_PATH, iri = "http://www.aspire-fp7.eu/akb#hasSourceFilePath"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__WEIGHT, iri = "http://www.aspire-fp7.eu/akb#hasWeight"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__START_LINE, iri = "http://www.aspire-fp7.eu/akb#hasStartLine"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__END_LINE, iri = "http://www.aspire-fp7.eu/akb#hasEndLine"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__DATUM_SIZE, iri = "http://www.aspire-fp7.eu/akb#hasDatumSize"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__INDEX, iri = "http://www.aspire-fp7.eu/akb#hasIndex"),
		@MapsToDataProperty(id = AkbPackage.APPLICATION_PART__IN_SYSTEM_FILE, iri = "http://www.aspire-fp7.eu/akb#isInSystemFile")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART__TYPE, iri = "http://www.aspire-fp7.eu/akb#isTypeOf"),
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART__PROPERTIES, iri = "http://www.aspire-fp7.eu/akb#hasProperty"),
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART__APPLICATION_PARTS, iri = "http://www.aspire-fp7.eu/akb#contains"),
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART__USES, iri = "http://www.aspire-fp7.eu/akb#uses"),
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART__BODY, iri = "http://www.aspire-fp7.eu/akb#hasBody")
	}
)
public interface ApplicationPart extends EObject
{
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Id()
	 * @model unique="false"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sets</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPartSet}.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.ApplicationPartSet#getApplicationParts <em>Application Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part sets containing this part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sets</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Sets()
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartSet#getApplicationParts
	 * @model opposite="applicationParts"
	 * @generated
	 */
	EList<ApplicationPartSet> getSets();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.ApplicationPartType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartType
	 * @see #setType(ApplicationPartType)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Type()
	 * @model unique="false"
	 * @generated
	 */
	ApplicationPartType getType();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartType
	 * @see #getType()
	 * @generated
	 */
	void setType(ApplicationPartType value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameter index.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Index()
	 * @model unique="false"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.Property}.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' attribute list.
	 * @see eu.aspire_fp7.adss.akb.Property
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Properties()
	 * @model unique="false"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file in which the application part is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source File Path</em>' attribute.
	 * @see #setSourceFilePath(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_SourceFilePath()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceFilePath();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getSourceFilePath <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File Path</em>' attribute.
	 * @see #getSourceFilePath()
	 * @generated
	 */
	void setSourceFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Declaring Code</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationParts <em>Application Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The code where the datum is declared, null if the datum is global
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declaring Code</em>' container reference.
	 * @see #setDeclaringCode(ApplicationPart)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_DeclaringCode()
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getApplicationParts
	 * @model opposite="applicationParts" transient="false"
	 * @generated
	 */
	ApplicationPart getDeclaringCode();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDeclaringCode <em>Declaring Code</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Code</em>' container reference.
	 * @see #getDeclaringCode()
	 * @generated
	 */
	void setDeclaringCode(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file line where this application part starts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_StartLine()
	 * @model unique="false"
	 * @generated
	 */
	int getStartLine();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(int value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file line where this application part starts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_EndLine()
	 * @model unique="false"
	 * @generated
	 */
	int getEndLine();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(int value);

	/**
	 * Returns the value of the '<em><b>Datum Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The datum size in memory.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Datum Size</em>' attribute.
	 * @see #setDatumSize(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_DatumSize()
	 * @model unique="false"
	 * @generated
	 */
	int getDatumSize();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDatumSize <em>Datum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datum Size</em>' attribute.
	 * @see #getDatumSize()
	 * @generated
	 */
	void setDatumSize(int value);

	/**
	 * Returns the value of the '<em><b>In System File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates if this part is in a system file or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In System File</em>' attribute.
	 * @see #setInSystemFile(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_InSystemFile()
	 * @model unique="false"
	 * @generated
	 */
	boolean isInSystemFile();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#isInSystemFile <em>In System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In System File</em>' attribute.
	 * @see #isInSystemFile()
	 * @generated
	 */
	void setInSystemFile(boolean value);

	/**
	 * Returns the value of the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the part is global (otherwise is local).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Global</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Global()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%eu.aspire_fp7.adss.akb.ApplicationPart%> _declaringCode = this.getDeclaringCode();\nreturn <%com.google.common.base.Objects%>.equal(_declaringCode, null);'"
	 * @generated
	 */
	boolean isGlobal();

	/**
	 * Returns the value of the '<em><b>Short Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The short location of the application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Short Location</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_ShortLocation()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%eu.aspire_fp7.adss.akb.ApplicationPartType%> _type = this.getType();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_type, <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.REFERENCE);\nif (_equals)\n{\n\treturn \"\";\n}\nelse\n{\n\tint _startLine = this.getStartLine();\n\tint _endLine = this.getEndLine();\n\tboolean _notEquals = (_startLine != _endLine);\n\tif (_notEquals)\n\t{\n\t\t<%java.lang.String%> _sourceFilePath = this.getSourceFilePath();\n\t\t<%java.nio.file.Path%> _get = <%java.nio.file.Paths%>.get(_sourceFilePath);\n\t\t<%java.nio.file.Path%> _fileName = _get.getFileName();\n\t\t<%java.lang.String%> _plus = (_fileName + \" : \");\n\t\tint _startLine_1 = this.getStartLine();\n\t\t<%java.lang.String%> _plus_1 = (_plus + <%java.lang.Integer%>.valueOf(_startLine_1));\n\t\t<%java.lang.String%> _plus_2 = (_plus_1 + \"-\");\n\t\tint _endLine_1 = this.getEndLine();\n\t\treturn (_plus_2 + <%java.lang.Integer%>.valueOf(_endLine_1));\n\t}\n\telse\n\t{\n\t\t<%java.lang.String%> _sourceFilePath_1 = this.getSourceFilePath();\n\t\t<%java.nio.file.Path%> _get_1 = <%java.nio.file.Paths%>.get(_sourceFilePath_1);\n\t\t<%java.nio.file.Path%> _fileName_1 = _get_1.getFileName();\n\t\t<%java.lang.String%> _plus_3 = (_fileName_1 + \" : \");\n\t\tint _startLine_2 = this.getStartLine();\n\t\treturn (_plus_3 + <%java.lang.Integer%>.valueOf(_startLine_2));\n\t}\n}'"
	 * @generated
	 */
	String getShortLocation();

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The weight, meaningful only for the assets.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Weight()
	 * @model unique="false"
	 * @generated
	 */
	double getWeight();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(double value);

	/**
	 * Returns the value of the '<em><b>Security Properties</b></em>' attribute list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.Property}.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The security properties.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Security Properties</em>' attribute list.
	 * @see eu.aspire_fp7.adss.akb.Property
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_SecurityProperties()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.Property%>> securities = new <%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.Property%>>();\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.Property%>> _properties = this.getProperties();\nfor (final <%eu.aspire_fp7.adss.akb.Property%> i : _properties)\n{\n\tif ((((<%com.google.common.base.Objects%>.equal(i, <%eu.aspire_fp7.adss.akb.Property%>.CONFIDENTIALITY) || <%com.google.common.base.Objects%>.equal(i, <%eu.aspire_fp7.adss.akb.Property%>.HARDCONFIDENTIALITY)) || <%com.google.common.base.Objects%>.equal(i, <%eu.aspire_fp7.adss.akb.Property%>.INTEGRITY)) || <%com.google.common.base.Objects%>.equal(i, <%eu.aspire_fp7.adss.akb.Property%>.PRIVACY)))\n\t{\n\t\tsecurities.add(i);\n\t}\n}\nreturn securities;'"
	 * @generated
	 */
	EList<Property> getSecurityProperties();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Parameters()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> parameters = new <%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>>();\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\nfor (final <%eu.aspire_fp7.adss.akb.ApplicationPart%> i : _applicationParts)\n{\n\t<%eu.aspire_fp7.adss.akb.ApplicationPartType%> _type = i.getType();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_type, <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.PARAMETER);\n\tif (_equals)\n\t{\n\t\tparameters.add(i);\n\t}\n}\nreturn parameters;'"
	 * @generated
	 */
	EList<ApplicationPart> getParameters();

	/**
	 * Returns the value of the '<em><b>Asset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks if the application part is an asset.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Asset</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Asset()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.Property%>> _securityProperties = this.getSecurityProperties();\nboolean _isEmpty = _securityProperties.isEmpty();\nreturn (!_isEmpty);'"
	 * @generated
	 */
	boolean isAsset();

	/**
	 * Returns the value of the '<em><b>Application Parts</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPart}.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getDeclaringCode <em>Declaring Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Parts</em>' containment reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_ApplicationParts()
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getDeclaringCode
	 * @model opposite="declaringCode" containment="true"
	 * @generated
	 */
	EList<ApplicationPart> getApplicationParts();

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.UseTarget}.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.UseTarget#getUsedBy <em>Used By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The uses.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uses</em>' containment reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Uses()
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getUsedBy
	 * @model opposite="usedBy" containment="true"
	 * @generated
	 */
	EList<UseTarget> getUses();

	/**
	 * Returns the value of the '<em><b>Target Of</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.UseTarget}.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.UseTarget#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target of the uses.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Of</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_TargetOf()
	 * @see eu.aspire_fp7.adss.akb.UseTarget#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<UseTarget> getTargetOf();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The body.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(CodeBlock)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Body()
	 * @model containment="true"
	 * @generated
	 */
	CodeBlock getBody();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Application Parts Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The recursive application part count.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Parts Count</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_ApplicationPartsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int count = 1;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\nfor (final <%eu.aspire_fp7.adss.akb.ApplicationPart%> i : _applicationParts)\n{\n\tint _applicationPartsCount = i.getApplicationPartsCount();\n\tint _plus = (count + _applicationPartsCount);\n\tcount = _plus;\n}\nreturn count;'"
	 * @generated
	 */
	int getApplicationPartsCount();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assets.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assets</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPart_Assets()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> assets = new <%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>>();\n<%java.util.Stack%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> parts = new <%java.util.Stack%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>>();\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\n<%com.google.common.collect.Iterables%>.<<%eu.aspire_fp7.adss.akb.ApplicationPart%>>addAll(parts, _applicationParts);\nwhile ((!parts.isEmpty()))\n{\n\t{\n\t\t<%eu.aspire_fp7.adss.akb.ApplicationPart%> i = parts.pop();\n\t\tboolean _isAsset = i.isAsset();\n\t\tif (_isAsset)\n\t\t{\n\t\t\tassets.add(i);\n\t\t}\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts_1 = i.getApplicationParts();\n\t\t<%com.google.common.collect.Iterables%>.<<%eu.aspire_fp7.adss.akb.ApplicationPart%>>addAll(parts, _applicationParts_1);\n\t}\n}\nreturn assets;'"
	 * @generated
	 */
	EList<ApplicationPart> getAssets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks if the application part contains recursively another application part.
	 * <!-- end-model-doc -->
	 * @model unique="false" partUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(this, part);\nif (_equals)\n{\n\treturn true;\n}\nelse\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\n\tfor (final <%eu.aspire_fp7.adss.akb.ApplicationPart%> i : _applicationParts)\n\t{\n\t\tboolean _contains = i.contains(part);\n\t\tif (_contains)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean contains(ApplicationPart part);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _sourceFilePath = this.getSourceFilePath();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_sourceFilePath, null));\nif (_notEquals)\n{\n\t<%java.lang.String%> _sourceFilePath_1 = this.getSourceFilePath();\n\tint _hashCode = _sourceFilePath_1.hashCode();\n\tint _plus = ((31 * result) + _hashCode);\n\tresult = _plus;\n}\n<%java.lang.String%> _name = this.getName();\nint _hashCode_1 = _name.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\n<%eu.aspire_fp7.adss.akb.ApplicationPartType%> _type = this.getType();\n<%java.lang.String%> _string = _type.toString();\nint _hashCode_2 = _string.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\nint _startLine = this.getStartLine();\nint _hashCode_3 = <%java.lang.Integer%>.valueOf(_startLine).hashCode();\nint _plus_3 = ((31 * result) + _hashCode_3);\nresult = _plus_3;\nint _endLine = this.getEndLine();\nint _hashCode_4 = <%java.lang.Integer%>.valueOf(_endLine).hashCode();\nint _plus_4 = ((31 * result) + _hashCode_4);\nresult = _plus_4;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.ApplicationPart%>))\n\t{\n\t\treturn ((((<%com.google.common.base.Objects%>.equal(this.getSourceFilePath(), ((<%eu.aspire_fp7.adss.akb.ApplicationPart%>)object).getSourceFilePath()) && <%com.google.common.base.Objects%>.equal(this.getName(), ((<%eu.aspire_fp7.adss.akb.ApplicationPart%>)object).getName())) && <%com.google.common.base.Objects%>.equal(this.getType(), ((<%eu.aspire_fp7.adss.akb.ApplicationPart%>)object).getType())) && (this.getStartLine() == ((<%eu.aspire_fp7.adss.akb.ApplicationPart%>)object).getStartLine())) && \n\t\t\t(this.getEndLine() == ((<%eu.aspire_fp7.adss.akb.ApplicationPart%>)object).getEndLine()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getName();'"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks if the application part is a datum.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((((((((<%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.CRYPTOGRAPHIC_KEY) || <%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.INTEGER_DATUM)) || \n\t<%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.STATIC_INTEGER_ARRAY_DATUM)) || <%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.INTEGER_ARRAY_DATUM)) || \n\t<%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.GENERIC_VARIABLE)) || <%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.PARAMETER)) || <%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.INITIALIZATION_VECTOR)) || \n\t<%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.PLAINTEXT)) || <%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.CIPHERTEXT));'"
	 * @generated
	 */
	boolean isDatum();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks if the application part is a code region.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (<%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.CODE_REGION) || <%com.google.common.base.Objects%>.equal(this.getType(), <%eu.aspire_fp7.adss.akb.ApplicationPartType%>.FUNCTION));'"
	 * @generated
	 */
	boolean isCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks if the application part contains an asset
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> aux = new <%org.eclipse.emf.common.util.BasicEList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>>();\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\naux.addAll(_applicationParts);\nwhile ((!aux.isEmpty()))\n{\n\t{\n\t\t<%eu.aspire_fp7.adss.akb.ApplicationPart%> p = aux.get(0);\n\t\tboolean _isAsset = p.isAsset();\n\t\tif (_isAsset)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t\taux.remove(0);\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts_1 = p.getApplicationParts();\n\t\tfor (final <%eu.aspire_fp7.adss.akb.ApplicationPart%> j : _applicationParts_1)\n\t\t{\n\t\t\taux.add(0, j);\n\t\t}\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean containsAsset();

} // ApplicationPart
