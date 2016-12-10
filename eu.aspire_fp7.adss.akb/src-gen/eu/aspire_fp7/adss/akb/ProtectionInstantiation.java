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
import it.polito.security.ontologies.annotations.MapsToDataProperty;;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protection Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A protection instantiation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getProtection <em>Protection</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVariableAnnotation <em>Variable Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getCodeAnnotation <em>Code Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVerifierAnnotation <em>Verifier Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getAttestatorAnnotation <em>Attestator Annotation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getNetworkOverhead <em>Network Overhead</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#ProtectionInstantiation",
	name = "http://www.aspire-fp7.eu/akb#protectionInstantiation",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION, iri = "http://www.aspire-fp7.eu/akb#hasVariableAnnotation"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__CODE_ANNOTATION, iri = "http://www.aspire-fp7.eu/akb#hasCodeAnnotation"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION, iri = "http://www.aspire-fp7.eu/akb#hasVerifierAnnotation"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION, iri = "http://www.aspire-fp7.eu/akb#hasAttestatorAnnotation"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__CLIENT_TIME_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasClientTimeOverhead"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__SERVER_TIME_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasServerTimeOverhead"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__CLIENT_MEMORY_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasClientMemoryOverhead"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__SERVER_MEMORY_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasServerMemoryOverhead"),
		@MapsToDataProperty(id = AkbPackage.PROTECTION_INSTANTIATION__NETWORK_OVERHEAD, iri = "http://www.aspire-fp7.eu/akb#hasNetworkOverhead")
	}
)
public interface ProtectionInstantiation extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection instantiation name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Protection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.aspire_fp7.adss.akb.Protection#getInstantiations <em>Instantiations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection</em>' container reference.
	 * @see #setProtection(Protection)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_Protection()
	 * @see eu.aspire_fp7.adss.akb.Protection#getInstantiations
	 * @model opposite="instantiations" transient="false"
	 * @generated
	 */
	Protection getProtection();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getProtection <em>Protection</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protection</em>' container reference.
	 * @see #getProtection()
	 * @generated
	 */
	void setProtection(Protection value);

	/**
	 * Returns the value of the '<em><b>Variable Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Annotation</em>' attribute.
	 * @see #setVariableAnnotation(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_VariableAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getVariableAnnotation();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVariableAnnotation <em>Variable Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Annotation</em>' attribute.
	 * @see #getVariableAnnotation()
	 * @generated
	 */
	void setVariableAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Code Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The code annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code Annotation</em>' attribute.
	 * @see #setCodeAnnotation(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_CodeAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getCodeAnnotation();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getCodeAnnotation <em>Code Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Annotation</em>' attribute.
	 * @see #getCodeAnnotation()
	 * @generated
	 */
	void setCodeAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Verifier Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The verifier annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Verifier Annotation</em>' attribute.
	 * @see #setVerifierAnnotation(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_VerifierAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getVerifierAnnotation();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getVerifierAnnotation <em>Verifier Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verifier Annotation</em>' attribute.
	 * @see #getVerifierAnnotation()
	 * @generated
	 */
	void setVerifierAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Attestator Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attestator annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attestator Annotation</em>' attribute.
	 * @see #setAttestatorAnnotation(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_AttestatorAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getAttestatorAnnotation();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getAttestatorAnnotation <em>Attestator Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attestator Annotation</em>' attribute.
	 * @see #getAttestatorAnnotation()
	 * @generated
	 */
	void setAttestatorAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Client Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client time overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #setClientTimeOverhead(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_ClientTimeOverhead()
	 * @model unique="false"
	 * @generated
	 */
	String getClientTimeOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientTimeOverhead <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #getClientTimeOverhead()
	 * @generated
	 */
	void setClientTimeOverhead(String value);

	/**
	 * Returns the value of the '<em><b>Server Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server time overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #setServerTimeOverhead(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_ServerTimeOverhead()
	 * @model unique="false"
	 * @generated
	 */
	String getServerTimeOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerTimeOverhead <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #getServerTimeOverhead()
	 * @generated
	 */
	void setServerTimeOverhead(String value);

	/**
	 * Returns the value of the '<em><b>Client Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client memory overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #setClientMemoryOverhead(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_ClientMemoryOverhead()
	 * @model unique="false"
	 * @generated
	 */
	String getClientMemoryOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getClientMemoryOverhead <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #getClientMemoryOverhead()
	 * @generated
	 */
	void setClientMemoryOverhead(String value);

	/**
	 * Returns the value of the '<em><b>Server Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server memory overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #setServerMemoryOverhead(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_ServerMemoryOverhead()
	 * @model unique="false"
	 * @generated
	 */
	String getServerMemoryOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getServerMemoryOverhead <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #getServerMemoryOverhead()
	 * @generated
	 */
	void setServerMemoryOverhead(String value);

	/**
	 * Returns the value of the '<em><b>Network Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The network overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Network Overhead</em>' attribute.
	 * @see #setNetworkOverhead(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProtectionInstantiation_NetworkOverhead()
	 * @model unique="false"
	 * @generated
	 */
	String getNetworkOverhead();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ProtectionInstantiation#getNetworkOverhead <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network Overhead</em>' attribute.
	 * @see #getNetworkOverhead()
	 * @generated
	 */
	void setNetworkOverhead(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.ProtectionInstantiation%>))\n\t{\n\t\t<%java.lang.String%> _name = this.getName();\n\t\t<%java.lang.String%> _name_1 = ((<%eu.aspire_fp7.adss.akb.ProtectionInstantiation%>)object).getName();\n\t\treturn _name.equals(_name_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _variableAnnotation = this.getVariableAnnotation();\nint _hashCode = _variableAnnotation.hashCode();\n<%java.lang.String%> _codeAnnotation = this.getCodeAnnotation();\nint _hashCode_1 = _codeAnnotation.hashCode();\nint _plus = (_hashCode + _hashCode_1);\n<%java.lang.String%> _verifierAnnotation = this.getVerifierAnnotation();\nint _hashCode_2 = _verifierAnnotation.hashCode();\nint _plus_1 = (_plus + _hashCode_2);\n<%java.lang.String%> _attestatorAnnotation = this.getAttestatorAnnotation();\nint _hashCode_3 = _attestatorAnnotation.hashCode();\nreturn (_plus_1 + _hashCode_3);'"
	 * @generated
	 */
	int hashCode();

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

} // ProtectionInstantiation
