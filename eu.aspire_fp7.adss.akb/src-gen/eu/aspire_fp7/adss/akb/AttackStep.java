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
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack step.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStep#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStep#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStep#getFormula <em>Formula</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStep#getTransition <em>Transition</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStep()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#AttackStep",
	name = "http://www.aspire-fp7.eu/akb#attackStep",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.ATTACK_STEP__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName"),
		@MapsToDataProperty(id = AkbPackage.ATTACK_STEP__FORMULA, iri = "http://www.aspire-fp7.eu/akb#hasFormula"),
		@MapsToDataProperty(id = AkbPackage.ATTACK_STEP__TRANSITION, iri = "http://www.aspire-fp7.eu/akb#hasTransition")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.ATTACK_STEP__TYPE, iri = "http://www.aspire-fp7.eu/akb#isTypeOf")
	}
)
public interface AttackStep extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStep_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackStep#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(AttackStepType)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStep_Type()
	 * @model unique="false" dataType="eu.aspire_fp7.adss.akb.AttackStepTypeWithNull"
	 * @generated
	 */
	AttackStepType getType();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackStep#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(AttackStepType value);

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formula used to evaluate the effort needed by the attacker to complete this attack step.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Formula</em>' attribute.
	 * @see #setFormula(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStep_Formula()
	 * @model unique="false"
	 * @generated
	 */
	String getFormula();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackStep#getFormula <em>Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' attribute.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(String value);

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Petri nets transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transition</em>' attribute.
	 * @see #setTransition(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStep_Transition()
	 * @model unique="false"
	 * @generated
	 */
	String getTransition();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackStep#getTransition <em>Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' attribute.
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _name = this.getName();\nreturn _name.hashCode();'"
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

} // AttackStep
