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
 * A representation of the literals of the enumeration '<em><b>Application Part Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The application part types.
 * <!-- end-model-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPartType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#ApplicationPartType",
	name = "http://www.aspire-fp7.eu/akb#",
	singleton = true
)
public enum ApplicationPartType implements Enumerator
{
	/**
	 * The '<em><b>CODE REGION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CODE_REGION_VALUE
	 * @generated
	 * @ordered
	 */
	CODE_REGION(0, "CODE_REGION", "codeRegion"),

	/**
	 * The '<em><b>FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTION(0, "FUNCTION", "function"),

	/**
	 * The '<em><b>CRYPTOGRAPHIC KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRYPTOGRAPHIC_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	CRYPTOGRAPHIC_KEY(0, "CRYPTOGRAPHIC_KEY", "cryptographicKey"),

	/**
	 * The '<em><b>INITIALIZATION VECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIALIZATION_VECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	INITIALIZATION_VECTOR(0, "INITIALIZATION_VECTOR", "initializationVector"),

	/**
	 * The '<em><b>PLAINTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAINTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	PLAINTEXT(0, "PLAINTEXT", "plaintext"),

	/**
	 * The '<em><b>CIPHERTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIPHERTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	CIPHERTEXT(0, "CIPHERTEXT", "ciphertext"),

	/**
	 * The '<em><b>GENERIC VARIABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERIC_VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	GENERIC_VARIABLE(0, "GENERIC_VARIABLE", "genericVariable"),

	/**
	 * The '<em><b>INTEGER DATUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_DATUM_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER_DATUM(0, "INTEGER_DATUM", "integerDatum"),

	/**
	 * The '<em><b>INTEGER ARRAY DATUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_ARRAY_DATUM_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER_ARRAY_DATUM(0, "INTEGER_ARRAY_DATUM", "integerArrayDatum"),

	/**
	 * The '<em><b>STATIC INTEGER ARRAY DATUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATIC_INTEGER_ARRAY_DATUM_VALUE
	 * @generated
	 * @ordered
	 */
	STATIC_INTEGER_ARRAY_DATUM(0, "STATIC_INTEGER_ARRAY_DATUM", "staticIntegerArrayDatum"),

	/**
	 * The '<em><b>PARAMETER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	PARAMETER(0, "PARAMETER", "parameter"),

	/**
	 * The '<em><b>REFERENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE(0, "REFERENCE", "reference"),

	/**
	 * The '<em><b>IGNORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE(0, "IGNORE", "ignore");

	/**
	 * The '<em><b>CODE REGION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CODE REGION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CODE_REGION
	 * @model literal="codeRegion"
	 * @generated
	 * @ordered
	 */
	public static final int CODE_REGION_VALUE = 0;

	/**
	 * The '<em><b>FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUNCTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNCTION
	 * @model literal="function"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_VALUE = 0;

	/**
	 * The '<em><b>CRYPTOGRAPHIC KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CRYPTOGRAPHIC KEY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CRYPTOGRAPHIC_KEY
	 * @model literal="cryptographicKey"
	 * @generated
	 * @ordered
	 */
	public static final int CRYPTOGRAPHIC_KEY_VALUE = 0;

	/**
	 * The '<em><b>INITIALIZATION VECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INITIALIZATION VECTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INITIALIZATION_VECTOR
	 * @model literal="initializationVector"
	 * @generated
	 * @ordered
	 */
	public static final int INITIALIZATION_VECTOR_VALUE = 0;

	/**
	 * The '<em><b>PLAINTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAINTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAINTEXT
	 * @model literal="plaintext"
	 * @generated
	 * @ordered
	 */
	public static final int PLAINTEXT_VALUE = 0;

	/**
	 * The '<em><b>CIPHERTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CIPHERTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIPHERTEXT
	 * @model literal="ciphertext"
	 * @generated
	 * @ordered
	 */
	public static final int CIPHERTEXT_VALUE = 0;

	/**
	 * The '<em><b>GENERIC VARIABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERIC VARIABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERIC_VARIABLE
	 * @model literal="genericVariable"
	 * @generated
	 * @ordered
	 */
	public static final int GENERIC_VARIABLE_VALUE = 0;

	/**
	 * The '<em><b>INTEGER DATUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTEGER DATUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGER_DATUM
	 * @model literal="integerDatum"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_DATUM_VALUE = 0;

	/**
	 * The '<em><b>INTEGER ARRAY DATUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTEGER ARRAY DATUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGER_ARRAY_DATUM
	 * @model literal="integerArrayDatum"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_ARRAY_DATUM_VALUE = 0;

	/**
	 * The '<em><b>STATIC INTEGER ARRAY DATUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATIC INTEGER ARRAY DATUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATIC_INTEGER_ARRAY_DATUM
	 * @model literal="staticIntegerArrayDatum"
	 * @generated
	 * @ordered
	 */
	public static final int STATIC_INTEGER_ARRAY_DATUM_VALUE = 0;

	/**
	 * The '<em><b>PARAMETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARAMETER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARAMETER
	 * @model literal="parameter"
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETER_VALUE = 0;

	/**
	 * The '<em><b>REFERENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFERENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCE
	 * @model literal="reference"
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_VALUE = 0;

	/**
	 * The '<em><b>IGNORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IGNORE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IGNORE
	 * @model literal="ignore"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Application Part Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ApplicationPartType[] VALUES_ARRAY =
		new ApplicationPartType[]
		{
			CODE_REGION,
			FUNCTION,
			CRYPTOGRAPHIC_KEY,
			INITIALIZATION_VECTOR,
			PLAINTEXT,
			CIPHERTEXT,
			GENERIC_VARIABLE,
			INTEGER_DATUM,
			INTEGER_ARRAY_DATUM,
			STATIC_INTEGER_ARRAY_DATUM,
			PARAMETER,
			REFERENCE,
			IGNORE,
		};

	/**
	 * A public read-only list of all the '<em><b>Application Part Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ApplicationPartType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Application Part Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ApplicationPartType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ApplicationPartType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Application Part Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ApplicationPartType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ApplicationPartType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Application Part Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ApplicationPartType get(int value)
	{
		switch (value)
		{
			case CODE_REGION_VALUE: return CODE_REGION;
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
	private ApplicationPartType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //ApplicationPartType
