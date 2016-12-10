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
 * A representation of the model object '<em><b>Attack Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack path.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getAttackSteps <em>Attack Steps</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getAttackerToolTypes <em>Attacker Tool Types</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getCost <em>Cost</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#isKey <em>Key</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getId <em>Id</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getMitigations <em>Mitigations</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.AttackPath#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#AttackPath",
	name = "http://www.aspire-fp7.eu/akb#attackPath",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.ATTACK_PATH__COST, iri = "http://www.aspire-fp7.eu/akb#hasCost"),
		@MapsToDataProperty(id = AkbPackage.ATTACK_PATH__KEY, iri = "http://www.aspire-fp7.eu/akb#isKey")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES, iri = "http://www.aspire-fp7.eu/akb#hasTarget"),
		@MapsToObjectProperty(id = AkbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES, iri = "http://www.aspire-fp7.eu/akb#uses"),
		@MapsToObjectProperty(id = AkbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS, iri = "http://www.aspire-fp7.eu/akb#isMitigatedBy")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = AkbPackage.ATTACK_PATH__ATTACK_STEPS,
			startIri = "http://www.aspire-fp7.eu/akb#startsWith",
			nextIri = "http://www.aspire-fp7.eu/akb#isFollowedBy",
			elementIri = "http://www.aspire-fp7.eu/akb#AttackStepInAttackPath",
			elementName = "http://www.aspire-fp7.eu/akb#attackStepInAttackPath",
			propertyIri = "http://www.aspire-fp7.eu/akb#refersTo"
		)
	}
)
public interface AttackPath extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attack Steps</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.AttackStep}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack steps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Steps</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_AttackSteps()
	 * @model
	 * @generated
	 */
	EList<AttackStep> getAttackSteps();

	/**
	 * Returns the value of the '<em><b>Protection Objectives</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ProtectionObjective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Objectives</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_ProtectionObjectives()
	 * @model
	 * @generated
	 */
	EList<ProtectionObjective> getProtectionObjectives();

	/**
	 * Returns the value of the '<em><b>Attacker Tool Types</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker tool types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tool Types</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_AttackerToolTypes()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getAttackerToolTypes();

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The cost.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_Cost()
	 * @model unique="false"
	 * @generated
	 */
	double getCost();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackPath#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(double value);

	/**
	 * Returns the value of the '<em><b>Applied Protection Instantiations</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The applied protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Protection Instantiations</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_AppliedProtectionInstantiations()
	 * @model
	 * @generated
	 */
	EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations();

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates if this attack path is a key attack or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(boolean)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_Key()
	 * @model unique="false"
	 * @generated
	 */
	boolean isKey();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.AttackPath#isKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #isKey()
	 * @generated
	 */
	void setKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The object id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_Id()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int _hashCode = this.hashCode();\nreturn (((long) _hashCode) + (-((long) <%java.lang.Integer%>.MIN_VALUE)));'"
	 * @generated
	 */
	long getId();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mitigations</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_Mitigations()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.lang.String%> text = \"\";\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nfor (final <%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%> i : _appliedProtectionInstantiations)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AttackMitigation%>> _attackMitigations = i.getAttackMitigations();\n\tfor (final <%eu.aspire_fp7.adss.akb.AttackMitigation%> j : _attackMitigations)\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AttackPath%>> _attackPaths = j.getAttackPaths();\n\t\tboolean _contains = _attackPaths.contains(this);\n\t\tif (_contains)\n\t\t{\n\t\t\t<%java.lang.String%> _plus = (i + \" (\");\n\t\t\t<%eu.aspire_fp7.adss.akb.Level%> _level = j.getLevel();\n\t\t\t<%java.lang.String%> _plus_1 = (_plus + _level);\n\t\t\t<%java.lang.String%> _plus_2 = (_plus_1 + \")\\n\");\n\t\t\ttext = _plus_2;\n\t\t}\n\t}\n}\nreturn text;'"
	 * @generated
	 */
	String getMitigations();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigation level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.Level
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getAttackPath_Level()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%eu.aspire_fp7.adss.akb.Level%> level = <%eu.aspire_fp7.adss.akb.Level%>.NONE;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nfor (final <%eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation%> i : _appliedProtectionInstantiations)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AttackMitigation%>> _attackMitigations = i.getAttackMitigations();\n\tfor (final <%eu.aspire_fp7.adss.akb.AttackMitigation%> j : _attackMitigations)\n\t{\n\t\tif ((<%com.google.common.base.Objects%>.equal(level, <%eu.aspire_fp7.adss.akb.Level%>.NONE) || <%com.google.common.base.Objects%>.equal(level, <%eu.aspire_fp7.adss.akb.Level%>.LOW)))\n\t\t{\n\t\t\t<%eu.aspire_fp7.adss.akb.Level%> _level = j.getLevel();\n\t\t\tlevel = _level;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif ((<%com.google.common.base.Objects%>.equal(level, <%eu.aspire_fp7.adss.akb.Level%>.MEDIUM) && <%com.google.common.base.Objects%>.equal(j.getLevel(), <%eu.aspire_fp7.adss.akb.Level%>.HIGH)))\n\t\t\t{\n\t\t\t\t<%eu.aspire_fp7.adss.akb.Level%> _level_1 = j.getLevel();\n\t\t\t\tlevel = _level_1;\n\t\t\t}\n\t\t}\n\t}\n}\nreturn level;'"
	 * @generated
	 */
	Level getLevel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.AttackStep%>> _attackSteps = this.getAttackSteps();\nreturn _attackSteps.hashCode();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _hashCode = this.hashCode();\nreturn (\"attack path \" + <%java.lang.Integer%>.valueOf(_hashCode));'"
	 * @generated
	 */
	String toString();

} // AttackPath
