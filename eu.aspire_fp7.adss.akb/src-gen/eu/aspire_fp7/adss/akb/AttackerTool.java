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
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attacker Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attacker tool.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackerTool#getName <em>Name</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackerTool#getTypes <em>Types</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackerTool#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackerTool#getCost <em>Cost</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackerTool#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerTool()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#AttackerTool",
	name = "http://www.aspire-fp7.eu/akb#attackerTool",
	singleton = true,
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.ATTACKER_TOOL__NAME, iri = "http://www.aspire-fp7.eu/akb#hasName"),
		@MapsToDataProperty(id = AkbPackage.ATTACKER_TOOL__COST, iri = "http://www.aspire-fp7.eu/akb#hasCost")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.ATTACKER_TOOL__EXPERTISE, iri = "http://www.aspire-fp7.eu/akb#hasExpertise"),
		@MapsToObjectProperty(id = AkbPackage.ATTACKER_TOOL__TYPES, iri = "http://www.aspire-fp7.eu/akb#isTypeOf")
	}
)
public interface AttackerTool extends EObject
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
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerTool_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackerTool#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerTool_Types()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getTypes();

	/**
	 * Returns the value of the '<em><b>Expertise</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.ExpertiseLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum expertise required.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expertise</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
	 * @see #setExpertise(ExpertiseLevel)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerTool_Expertise()
	 * @model unique="false"
	 * @generated
	 */
	ExpertiseLevel getExpertise();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackerTool#getExpertise <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expertise</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.ExpertiseLevel
	 * @see #getExpertise()
	 * @generated
	 */
	void setExpertise(ExpertiseLevel value);

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The monetary cost.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerTool_Cost()
	 * @model unique="false"
	 * @generated
	 */
	int getCost();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackerTool#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(int value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enabled state of the tool.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackerTool_Enabled()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\n<%eu.aspire_fp7.adss.akb.Attacker%> attacker = ((<%eu.aspire_fp7.adss.akb.Model%>) _eContainer).getAttacker();\nif (((!<%com.google.common.base.Objects%>.equal(attacker.getBudgetLimit(), null)) && (this.getCost() > (attacker.getBudgetLimit()).intValue())))\n{\n\treturn false;\n}\nif ((<%com.google.common.base.Objects%>.equal(attacker.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.AMATEUR) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.AMATEUR))))\n{\n\treturn false;\n}\nif (((<%com.google.common.base.Objects%>.equal(attacker.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.GEEK) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.AMATEUR))) && \n\t(!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.GEEK))))\n{\n\treturn false;\n}\nif ((((<%com.google.common.base.Objects%>.equal(attacker.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.EXPERT) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.AMATEUR))) && \n\t(!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.GEEK))) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%eu.aspire_fp7.adss.akb.ExpertiseLevel%>.EXPERT))))\n{\n\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _name = this.getName();\nint _hashCode = _name.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.AttackerTool%>))\n\t{\n\t\t<%java.lang.String%> _name = this.getName();\n\t\t<%java.lang.String%> _name_1 = ((<%eu.aspire_fp7.adss.akb.AttackerTool%>)object).getName();\n\t\treturn <%com.google.common.base.Objects%>.equal(_name, _name_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // AttackerTool
