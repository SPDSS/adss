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

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protection Objective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A protection objective.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionObjective#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionObjective#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionObjective()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#ProtectionObjective",
	name = "http://www.aspire-fp7.eu/akb#protectionObjective",
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.PROTECTION_OBJECTIVE__APPLICATION_PART, iri = "http://www.aspire-fp7.eu/akb#refersTo"),
		@MapsToObjectProperty(id = AkbPackage.PROTECTION_OBJECTIVE__PROPERTY, iri = "http://www.aspire-fp7.eu/akb#hasProperty")
	}
)
public interface ProtectionObjective extends EObject
{
	/**
	 * Returns the value of the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part</em>' reference.
	 * @see #setApplicationPart(ApplicationPart)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionObjective_ApplicationPart()
	 * @model
	 * @generated
	 */
	ApplicationPart getApplicationPart();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#getApplicationPart <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Part</em>' reference.
	 * @see #getApplicationPart()
	 * @generated
	 */
	void setApplicationPart(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.Property
	 * @see #setProperty(Property)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionObjective_Property()
	 * @model unique="false"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionObjective#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.Property
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nint _hashCode = _applicationPart.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%eu.aspire_fp7.adss.akb.Property%> _property = this.getProperty();\nint _hashCode_1 = _property.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.ProtectionObjective%>))\n\t{\n\t\treturn (<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getApplicationPart(), ((<%eu.aspire_fp7.adss.akb.ProtectionObjective%>)object).getApplicationPart()) && <%com.google.common.base.Objects%>.equal(this.getProperty(), ((<%eu.aspire_fp7.adss.akb.ProtectionObjective%>)object).getProperty()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%eu.aspire_fp7.adss.akb.ApplicationPart%> _applicationPart = this.getApplicationPart();\n<%java.lang.String%> _plus = (_applicationPart + \"/\");\n<%eu.aspire_fp7.adss.akb.Property%> _property = this.getProperty();\nreturn (_plus + _property);'"
	 * @generated
	 */
	String toString();

} // ProtectionObjective
