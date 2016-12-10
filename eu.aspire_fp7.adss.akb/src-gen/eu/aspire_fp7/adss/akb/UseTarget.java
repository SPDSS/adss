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
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A use target.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.UseTarget#getTarget <em>Target</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.UseTarget#getUsedBy <em>Used By</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.UseTarget#getLine <em>Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.UseTarget#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.UseTarget#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.UseTarget#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#UseTarget",
	name = "http://www.aspire-fp7.eu/akb#useTarget",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.USE_TARGET__LINE, iri = "http://www.aspire-fp7.eu/akb#hasLine"),
		@MapsToDataProperty(id = AkbPackage.USE_TARGET__SOURCE_FILE_PATH, iri = "http://www.aspire-fp7.eu/akb#hasSourceFilePath")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.USE_TARGET__TARGET, iri = "http://www.aspire-fp7.eu/akb#hasTarget"),
		@MapsToObjectProperty(id = AkbPackage.USE_TARGET__TYPE, iri = "http://www.aspire-fp7.eu/akb#isTypeOf")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = AkbPackage.USE_TARGET__PARAMETERS,
			startIri = "http://www.aspire-fp7.eu/akb#startsWith",
			nextIri = "http://www.aspire-fp7.eu/akb#isFollowedBy",
			elementIri = "http://www.aspire-fp7.eu/akb#CallParameter",
			elementName = "http://www.aspire-fp7.eu/akb#callParameter",
			propertyIri = "http://www.aspire-fp7.eu/akb#refersTo"
		)
	}
)
public interface UseTarget extends EObject
{
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getTargetOf <em>Target Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ApplicationPart)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget_Target()
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getTargetOf
	 * @model opposite="targetOf"
	 * @generated
	 */
	ApplicationPart getTarget();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.UseTarget#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Used By</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.ApplicationPart#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application parts using this target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Used By</em>' container reference.
	 * @see #setUsedBy(ApplicationPart)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget_UsedBy()
	 * @see eu.aspire_fp7.adss.akb.ApplicationPart#getUses
	 * @model opposite="uses" transient="false"
	 * @generated
	 */
	ApplicationPart getUsedBy();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.UseTarget#getUsedBy <em>Used By</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used By</em>' container reference.
	 * @see #getUsedBy()
	 * @generated
	 */
	void setUsedBy(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The line of code where this uses is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget_Line()
	 * @model unique="false"
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.UseTarget#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file in which the uses is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source File Path</em>' attribute.
	 * @see #setSourceFilePath(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget_SourceFilePath()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceFilePath();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.UseTarget#getSourceFilePath <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File Path</em>' attribute.
	 * @see #getSourceFilePath()
	 * @generated
	 */
	void setSourceFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.UseType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The use type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.UseType
	 * @see #setType(UseType)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget_Type()
	 * @model unique="false"
	 * @generated
	 */
	UseType getType();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.UseTarget#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.UseType
	 * @see #getType()
	 * @generated
	 */
	void setType(UseType value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameter list, if this is a call.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseTarget_Parameters()
	 * @model
	 * @generated
	 */
	EList<ApplicationPart> getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _sourceFilePath = this.getSourceFilePath();\nint _hashCode = _sourceFilePath.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nint _line = this.getLine();\nint _hashCode_1 = <%java.lang.Integer%>.valueOf(_line).hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\n<%eu.aspire_fp7.adss.akb.UseType%> _type = this.getType();\n<%java.lang.String%> _string = _type.toString();\nint _hashCode_2 = _string.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _usedBy = this.getUsedBy();\nint _hashCode_3 = _usedBy.hashCode();\nint _plus_3 = ((31 * result) + _hashCode_3);\nresult = _plus_3;\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _target = this.getTarget();\nint _hashCode_4 = _target.hashCode();\nint _plus_4 = ((31 * result) + _hashCode_4);\nresult = _plus_4;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _parameters = this.getParameters();\nint _hashCode_5 = _parameters.hashCode();\nint _plus_5 = ((31 * result) + _hashCode_5);\nresult = _plus_5;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.UseTarget%>))\n\t{\n\t\treturn (((((<%com.google.common.base.Objects%>.equal(this.getSourceFilePath(), ((<%eu.aspire_fp7.adss.akb.UseTarget%>)object).getSourceFilePath()) && (this.getLine() == ((<%eu.aspire_fp7.adss.akb.UseTarget%>)object).getLine())) && <%com.google.common.base.Objects%>.equal(this.getType(), ((<%eu.aspire_fp7.adss.akb.UseTarget%>)object).getType())) && \n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getUsedBy(), ((<%eu.aspire_fp7.adss.akb.UseTarget%>)object).getUsedBy())) && <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getTarget(), ((<%eu.aspire_fp7.adss.akb.UseTarget%>)object).getTarget())) && \n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getParameters(), ((<%eu.aspire_fp7.adss.akb.UseTarget%>)object).getParameters()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // UseTarget
