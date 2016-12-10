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
 * A representation of the model object '<em><b>Attacker Tool Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The attacker tool types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackerToolType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerToolType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#AttackerToolType",
	name = "http://www.aspire-fp7.eu/akb#attackerToolType",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.ATTACKER_TOOL_TYPE__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName")
	}
)
public interface AttackerToolType extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The name.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerToolType_Name()
   * @model unique="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackerToolType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Retrieves the object hash code.
   * <!-- end-model-doc -->
   * @model unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%eu.aspire_fp7.adss.akb.AttackerToolType%> _this = this;\n<%java.lang.String%> _name = _this.getName();\nreturn _name.hashCode();'"
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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%eu.aspire_fp7.adss.akb.AttackerToolType%> _this = this;\nreturn _this.getName();'"
   * @generated
   */
  String toString();

} // AttackerToolType
