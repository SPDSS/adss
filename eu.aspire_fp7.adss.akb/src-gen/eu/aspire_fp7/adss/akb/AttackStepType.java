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

import it.polito.security.ontologies.annotations.MapsToObjectProperty;

import it.polito.security.ontologies.annotations.MapsToDataProperty;

import it.polito.security.ontologies.annotations.MapsToIndividual;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack Step Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack step type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStepType#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStepType#getRegex <em>Regex</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackStepType#getAttackerTools <em>Attacker Tools</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStepType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#AttackStepType",
	name = "http://www.aspire-fp7.eu/akb#attackStepType",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.ATTACK_STEP_TYPE__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName"),
		@MapsToDataProperty(id = AkbPackage.ATTACK_STEP_TYPE__REGEX, iri = "http://www.aspire-fp7.eu/akb#hasRegex")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS, iri = "http://www.aspire-fp7.eu/akb#uses")
	}
)
public interface AttackStepType extends EObject
{

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The attack step type name.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStepType_Name()
   * @model unique="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackStepType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Regex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The attack step regex.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Regex</em>' attribute.
   * @see #setRegex(String)
   * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStepType_Regex()
   * @model unique="false"
   * @generated
   */
  String getRegex();

  /**
   * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackStepType#getRegex <em>Regex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regex</em>' attribute.
   * @see #getRegex()
   * @generated
   */
  void setRegex(String value);

  /**
   * Returns the value of the '<em><b>Attacker Tools</b></em>' reference list.
   * The list contents are of type {@link eu.aspire_fp7.adss.akb.AttackerToolType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The tools needed to do the attack step.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attacker Tools</em>' reference list.
   * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackStepType_AttackerTools()
   * @model
   * @generated
   */
  EList<AttackerToolType> getAttackerTools();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Retrieves the object hash code.
   * <!-- end-model-doc -->
   * @model unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%eu.aspire_fp7.adss.akb.AttackStepType%> _this = this;\n<%java.lang.String%> _name = _this.getName();\nreturn _name.hashCode();'"
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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%eu.aspire_fp7.adss.akb.AttackStepType%> _this = this;\nreturn _this.getName();'"
   * @generated
   */
  String toString();
} // AttackStepType
