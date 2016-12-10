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
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToDataProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A rule.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.Rule#getAction <em>Action</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Rule#getFunctionDeclarations <em>Function Declarations</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getRule()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#Rule",
	name = "http://www.aspire-fp7.eu/akb#rule",
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.RULE__ACTION, iri = "http://www.aspire-fp7.eu/akb#hasAction"),
		@MapsToObjectProperty(id = AkbPackage.RULE__FUNCTION_DECLARATIONS, iri = "http://www.aspire-fp7.eu/akb#contains")
	}
)
public interface Rule extends EObject
{
	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.ActionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The action.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ActionType
	 * @see #setAction(ActionType)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getRule_Action()
	 * @model unique="false"
	 * @generated
	 */
	ActionType getAction();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Rule#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ActionType
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ActionType value);

	/**
	 * Returns the value of the '<em><b>Function Declarations</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.FunctionDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function declarations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Declarations</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getRule_FunctionDeclarations()
	 * @model
	 * @generated
	 */
	EList<FunctionDeclaration> getFunctionDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.Rule%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getAction(), ((<%eu.aspire_fp7.adss.akb.Rule%>)object).getAction()) && <%com.google.common.base.Objects%>.equal(this.getFunctionDeclarations(), ((<%eu.aspire_fp7.adss.akb.Rule%>)object).getFunctionDeclarations()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%eu.aspire_fp7.adss.akb.ActionType%> _action = this.getAction();\nint _hashCode = _action.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.FunctionDeclaration%>> _functionDeclarations = this.getFunctionDeclarations();\nint _hashCode_1 = _functionDeclarations.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // Rule
