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
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applied Protection Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An applied protection instantiation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionInstantiation <em>Protection Instantiation</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getAttackMitigations <em>Attack Mitigations</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getSecondLevelMotivation <em>Second Level Motivation</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAppliedProtectionInstantiation()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#AppliedProtectionInstantiation",
	name = "http://www.aspire-fp7.eu/akb#appliedProtectionInstantiation",
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION, iri = "http://www.aspire-fp7.eu/akb#uses"),
		@MapsToObjectProperty(id = AkbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART, iri = "http://www.aspire-fp7.eu/akb#refersTo"),
		@MapsToObjectProperty(id = AkbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES, iri = "http://www.aspire-fp7.eu/akb#hasTarget"),
		@MapsToObjectProperty(id = AkbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION, iri = "http://www.aspire-fp7.eu/akb#hasSecondLevelMotivation"),
		@MapsToObjectProperty(id = AkbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS, iri = "http://www.aspire-fp7.eu/akb#mitigates")
	}
)
public interface AppliedProtectionInstantiation extends EObject
{
	/**
	 * Returns the value of the '<em><b>Protection Instantiation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection instantiation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Instantiation</em>' reference.
	 * @see #setProtectionInstantiation(ProtectionInstantiation)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAppliedProtectionInstantiation_ProtectionInstantiation()
	 * @model
	 * @generated
	 */
	ProtectionInstantiation getProtectionInstantiation();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getProtectionInstantiation <em>Protection Instantiation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protection Instantiation</em>' reference.
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	void setProtectionInstantiation(ProtectionInstantiation value);

	/**
	 * Returns the value of the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part</em>' reference.
	 * @see #setApplicationPart(ApplicationPart)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAppliedProtectionInstantiation_ApplicationPart()
	 * @model
	 * @generated
	 */
	ApplicationPart getApplicationPart();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation#getApplicationPart <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Part</em>' reference.
	 * @see #getApplicationPart()
	 * @generated
	 */
	void setApplicationPart(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Protection Objectives</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ProtectionObjective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Objectives</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAppliedProtectionInstantiation_ProtectionObjectives()
	 * @model
	 * @generated
	 */
	EList<ProtectionObjective> getProtectionObjectives();

	/**
	 * Returns the value of the '<em><b>Attack Mitigations</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.AttackMitigation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack mitigations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Mitigations</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAppliedProtectionInstantiation_AttackMitigations()
	 * @model
	 * @generated
	 */
	EList<AttackMitigation> getAttackMitigations();

	/**
	 * Returns the value of the '<em><b>Second Level Motivation</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.SecondLevelMotivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this applied protection instantiation is part of a second level solution, why has been decided to apply it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level Motivation</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAppliedProtectionInstantiation_SecondLevelMotivation()
	 * @model
	 * @generated
	 */
	EList<SecondLevelMotivation> getSecondLevelMotivation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.util.HashSet%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> locations = new <%java.util.HashSet%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>>();\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nlocations.add(_applicationPart);\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _applicationPart_1 = this.getApplicationPart();\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPartSet%>> _sets = _applicationPart_1.getSets();\nfor (final <%eu.aspire_fp7.adss.akb.ApplicationPartSet%> i : _sets)\n{\n\t<%eu.aspire_fp7.adss.akb.ProtectionInstantiation%> _protectionInstantiation = this.getProtectionInstantiation();\n\t<%eu.aspire_fp7.adss.akb.Protection%> _protection = _protectionInstantiation.getProtection();\n\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ActionType%>> _actions = _protection.getActions();\n\t<%eu.aspire_fp7.adss.akb.ActionType%> _action = i.getAction();\n\tboolean _contains = _actions.contains(_action);\n\tif (_contains)\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.ApplicationPart%>> _applicationParts = i.getApplicationParts();\n\t\tlocations.addAll(_applicationParts);\n\t}\n}\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.SecondLevelMotivation%>> _secondLevelMotivation = this.getSecondLevelMotivation();\nint _size = _secondLevelMotivation.size();\nboolean _equals = (_size == 0);\nif (_equals)\n{\n\t<%eu.aspire_fp7.adss.akb.ProtectionInstantiation%> _protectionInstantiation_1 = this.getProtectionInstantiation();\n\t<%java.lang.String%> _plus = (_protectionInstantiation_1 + \" @ \");\n\t<%java.lang.String%> _join = <%eu.aspire_fp7.adss.util.Strings%>.join(locations, \", \");\n\treturn (_plus + _join);\n}\nelse\n{\n\t<%eu.aspire_fp7.adss.akb.ProtectionInstantiation%> _protectionInstantiation_2 = this.getProtectionInstantiation();\n\t<%java.lang.String%> _plus_1 = (_protectionInstantiation_2 + \" @ \");\n\t<%java.lang.String%> _join_1 = <%eu.aspire_fp7.adss.util.Strings%>.join(locations, \", \");\n\t<%java.lang.String%> _plus_2 = (_plus_1 + _join_1);\n\t<%java.lang.String%> _plus_3 = (_plus_2 + \" [\");\n\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.SecondLevelMotivation%>> _secondLevelMotivation_1 = this.getSecondLevelMotivation();\n\t<%eu.aspire_fp7.adss.akb.SecondLevelMotivation%> _get = _secondLevelMotivation_1.get(0);\n\t<%eu.aspire_fp7.adss.akb.SecondLevelMotivationType%> _motivationType = _get.getMotivationType();\n\t<%java.lang.String%> _plus_4 = (_plus_3 + _motivationType);\n\treturn (_plus_4 + \"]\");\n}'"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%eu.aspire_fp7.adss.akb.ProtectionInstantiation%> _protectionInstantiation = this.getProtectionInstantiation();\nint _hashCode = _protectionInstantiation.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nint _hashCode_1 = _applicationPart.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>))\n\t{\n\t\treturn (<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getProtectionInstantiation(), ((<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>)object).getProtectionInstantiation()) && \n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getApplicationPart(), ((<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>)object).getApplicationPart()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // AppliedProtectionInstantiation
