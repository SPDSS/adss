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
 * A representation of the model object '<em><b>Solution Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A solution sequence.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.SolutionSequence#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolutionSequence()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#SolutionSequence",
	name = "http://www.aspire-fp7.eu/akb#solutionSequence",
	objectLists =
	{
		@MapsToObjectList
		(
			id = AkbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS,
			startIri = "http://www.aspire-fp7.eu/akb#startsWith",
			nextIri = "http://www.aspire-fp7.eu/akb#isFollowedBy",
			elementIri = "http://www.aspire-fp7.eu/akb#AppliedProtectionInstantiationInSequence",
			elementName = "http://www.aspire-fp7.eu/akb#appliedProtectionInstantiationInSequence",
			propertyIri = "http://www.aspire-fp7.eu/akb#refersTo"
		)
	}
)
public interface SolutionSequence extends EObject
{
	/**
	 * Returns the value of the '<em><b>Applied Protection Instantiations</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The applied instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Protection Instantiations</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolutionSequence_AppliedProtectionInstantiations()
	 * @model
	 * @generated
	 */
	EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nreturn _appliedProtectionInstantiations.toString();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nint _hashCode = _appliedProtectionInstantiations.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.SolutionSequence%>))\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations_1 = ((<%eu.aspire_fp7.adss.akb.SolutionSequence%>)object).getAppliedProtectionInstantiations();\n\t\treturn <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(_appliedProtectionInstantiations, _appliedProtectionInstantiations_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // SolutionSequence
