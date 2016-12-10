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
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attacker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The attacker.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.Attacker#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Attacker#getBudgetLimit <em>Budget Limit</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttacker()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#Attacker",
	name = "http://www.aspire-fp7.eu/akb#attacker",
	singleton = true,
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.ATTACKER__BUDGET_LIMIT, iri = "http://www.aspire-fp7.eu/akb#hasBudgetLimit")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.ATTACKER__EXPERTISE, iri = "http://www.aspire-fp7.eu/akb#hasExpertise")
	}
)
public interface Attacker extends EObject
{
	/**
	 * Returns the value of the '<em><b>Expertise</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.ExpertiseLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expertise.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expertise</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
	 * @see #setExpertise(ExpertiseLevel)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttacker_Expertise()
	 * @model unique="false"
	 * @generated
	 */
	ExpertiseLevel getExpertise();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Attacker#getExpertise <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expertise</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
	 * @see #getExpertise()
	 * @generated
	 */
	void setExpertise(ExpertiseLevel value);

	/**
	 * Returns the value of the '<em><b>Budget Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker budget limit or a negative value if unlimited.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Budget Limit</em>' attribute.
	 * @see #setBudgetLimit(Integer)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttacker_BudgetLimit()
	 * @model unique="false" dataType="eu.aspire_fp7.adss.akb.Integer"
	 * @generated
	 */
	Integer getBudgetLimit();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Attacker#getBudgetLimit <em>Budget Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget Limit</em>' attribute.
	 * @see #getBudgetLimit()
	 * @generated
	 */
	void setBudgetLimit(Integer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\nint _hashCode = \"attacker\".hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.Attacker%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getExpertise(), ((<%eu.aspire_fp7.adss.akb.Attacker%>)object).getExpertise()) && <%com.google.common.base.Objects%>.equal(this.getBudgetLimit(), ((<%eu.aspire_fp7.adss.akb.Attacker%>)object).getBudgetLimit()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // Attacker
