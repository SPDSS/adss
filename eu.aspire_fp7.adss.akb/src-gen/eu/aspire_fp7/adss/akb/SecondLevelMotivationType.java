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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import it.polito.security.ontologies.annotations.MapsToIndividual;
/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Second Level Motivation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The second level motivation types.
 * <!-- end-model-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSecondLevelMotivationType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#SecondLevelMotivationType",
	name = "http://www.aspire-fp7.eu/akb#",
	singleton = true
)
public enum SecondLevelMotivationType implements Enumerator {
	/**
	 * The '<em><b>KEPT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEPT_VALUE
	 * @generated
	 * @ordered
	 */
	KEPT(0, "KEPT", "kept"),

	/**
	 * The '<em><b>ENLARGED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENLARGED_VALUE
	 * @generated
	 * @ordered
	 */
	ENLARGED(0, "ENLARGED", "enlarged"),

	/**
	 * The '<em><b>CALL GRAPH ENLARGED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALL_GRAPH_ENLARGED_VALUE
	 * @generated
	 * @ordered
	 */
	CALL_GRAPH_ENLARGED(0, "CALL_GRAPH_ENLARGED", "callGraphEnlarged"),

	/**
	 * The '<em><b>REPEATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPEATED_VALUE
	 * @generated
	 * @ordered
	 */
	REPEATED(0, "REPEATED", "repeated");

	/**
	 * The '<em><b>KEPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KEPT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KEPT
	 * @model literal="kept"
	 * @generated
	 * @ordered
	 */
	public static final int KEPT_VALUE = 0;

	/**
	 * The '<em><b>ENLARGED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENLARGED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENLARGED
	 * @model literal="enlarged"
	 * @generated
	 * @ordered
	 */
	public static final int ENLARGED_VALUE = 0;

	/**
	 * The '<em><b>CALL GRAPH ENLARGED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CALL GRAPH ENLARGED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALL_GRAPH_ENLARGED
	 * @model literal="callGraphEnlarged"
	 * @generated
	 * @ordered
	 */
	public static final int CALL_GRAPH_ENLARGED_VALUE = 0;

	/**
	 * The '<em><b>REPEATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REPEATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPEATED
	 * @model literal="repeated"
	 * @generated
	 * @ordered
	 */
	public static final int REPEATED_VALUE = 0;

	/**
	 * An array of all the '<em><b>Second Level Motivation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SecondLevelMotivationType[] VALUES_ARRAY =
		new SecondLevelMotivationType[] {
			KEPT,
			ENLARGED,
			CALL_GRAPH_ENLARGED,
			REPEATED,
		};

	/**
	 * A public read-only list of all the '<em><b>Second Level Motivation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SecondLevelMotivationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Second Level Motivation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SecondLevelMotivationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SecondLevelMotivationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Second Level Motivation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SecondLevelMotivationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SecondLevelMotivationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Second Level Motivation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SecondLevelMotivationType get(int value) {
		switch (value) {
			case KEPT_VALUE: return KEPT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SecondLevelMotivationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SecondLevelMotivationType
