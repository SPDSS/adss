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
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToDataProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A function declaration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getFunctionDeclaration()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#FunctionDeclaration",
	name = "http://www.aspire-fp7.eu/akb#functionDeclaration",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.FUNCTION_DECLARATION__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = AkbPackage.FUNCTION_DECLARATION__PARAMETERS,
			startIri = "http://www.aspire-fp7.eu/akb#startsWith",
			nextIri = "http://www.aspire-fp7.eu/akb#isFollowedBy",
			elementIri = "http://www.aspire-fp7.eu/akb#FunctionParameter",
			elementName = "http://www.aspire-fp7.eu/akb#functionParameter",
			propertyIri = "http://www.aspire-fp7.eu/akb#refersTo"
		)
	}
)
public interface FunctionDeclaration extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getFunctionDeclaration_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.FunctionDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPartType}.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.ApplicationPartType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see eu.aspire_fp7.adss.akb.ApplicationPartType
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getFunctionDeclaration_Parameters()
	 * @model unique="false"
	 * @generated
	 */
	EList<ApplicationPartType> getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.FunctionDeclaration%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getName(), ((<%eu.aspire_fp7.adss.akb.FunctionDeclaration%>)object).getName()) && <%com.google.common.base.Objects%>.equal(this.getParameters(), ((<%eu.aspire_fp7.adss.akb.FunctionDeclaration%>)object).getParameters()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _name = this.getName();\nint _hashCode = _name.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPartType%>> _parameters = this.getParameters();\nint _hashCode_1 = _parameters.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // FunctionDeclaration
