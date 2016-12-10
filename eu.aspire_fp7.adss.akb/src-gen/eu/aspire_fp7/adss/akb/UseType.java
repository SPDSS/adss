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
 * A representation of the literals of the enumeration '<em><b>Use Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The use types.
 * <!-- end-model-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getUseType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#UseType",
	name = "http://www.aspire-fp7.eu/akb#",
	singleton = true
)
public enum UseType implements Enumerator
{
	/**
	 * The '<em><b>ACCESSES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESSES_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESSES(0, "ACCESSES", "accesses"),

	/**
	 * The '<em><b>CALLS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALLS_VALUE
	 * @generated
	 * @ordered
	 */
	CALLS(0, "CALLS", "calls"),

	/**
	 * The '<em><b>INITIALIZES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIALIZES_VALUE
	 * @generated
	 * @ordered
	 */
	INITIALIZES(0, "INITIALIZES", "initializes"),

	/**
	 * The '<em><b>DECRYPTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECRYPTS_VALUE
	 * @generated
	 * @ordered
	 */
	DECRYPTS(0, "DECRYPTS", "decrypts"),

	/**
	 * The '<em><b>ENCRYPTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPTS_VALUE
	 * @generated
	 * @ordered
	 */
	ENCRYPTS(0, "ENCRYPTS", "encrypts"),

	/**
	 * The '<em><b>RECEIVES AS CIPHERTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECEIVES_AS_CIPHERTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	RECEIVES_AS_CIPHERTEXT(0, "RECEIVES_AS_CIPHERTEXT", "receivesAsCiphertext"),

	/**
	 * The '<em><b>RECEIVES AS PLAINTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECEIVES_AS_PLAINTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	RECEIVES_AS_PLAINTEXT(0, "RECEIVES_AS_PLAINTEXT", "receivesAsPlaintext"),

	/**
	 * The '<em><b>ENFORCES EXECUTION ONCE AFTER INSTALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENFORCES_EXECUTION_ONCE_AFTER_INSTALL_VALUE
	 * @generated
	 * @ordered
	 */
	ENFORCES_EXECUTION_ONCE_AFTER_INSTALL(0, "ENFORCES_EXECUTION_ONCE_AFTER_INSTALL", "enforcesExecutionOnceAfterInstall"),

	/**
	 * The '<em><b>ENABLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENABLES_VALUE
	 * @generated
	 * @ordered
	 */
	ENABLES(0, "ENABLES", "enables");

	/**
	 * The '<em><b>ACCESSES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCESSES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCESSES
	 * @model literal="accesses"
	 * @generated
	 * @ordered
	 */
	public static final int ACCESSES_VALUE = 0;

	/**
	 * The '<em><b>CALLS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CALLS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALLS
	 * @model literal="calls"
	 * @generated
	 * @ordered
	 */
	public static final int CALLS_VALUE = 0;

	/**
	 * The '<em><b>INITIALIZES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INITIALIZES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INITIALIZES
	 * @model literal="initializes"
	 * @generated
	 * @ordered
	 */
	public static final int INITIALIZES_VALUE = 0;

	/**
	 * The '<em><b>DECRYPTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECRYPTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECRYPTS
	 * @model literal="decrypts"
	 * @generated
	 * @ordered
	 */
	public static final int DECRYPTS_VALUE = 0;

	/**
	 * The '<em><b>ENCRYPTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENCRYPTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENCRYPTS
	 * @model literal="encrypts"
	 * @generated
	 * @ordered
	 */
	public static final int ENCRYPTS_VALUE = 0;

	/**
	 * The '<em><b>RECEIVES AS CIPHERTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECEIVES AS CIPHERTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECEIVES_AS_CIPHERTEXT
	 * @model literal="receivesAsCiphertext"
	 * @generated
	 * @ordered
	 */
	public static final int RECEIVES_AS_CIPHERTEXT_VALUE = 0;

	/**
	 * The '<em><b>RECEIVES AS PLAINTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECEIVES AS PLAINTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECEIVES_AS_PLAINTEXT
	 * @model literal="receivesAsPlaintext"
	 * @generated
	 * @ordered
	 */
	public static final int RECEIVES_AS_PLAINTEXT_VALUE = 0;

	/**
	 * The '<em><b>ENFORCES EXECUTION ONCE AFTER INSTALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENFORCES EXECUTION ONCE AFTER INSTALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENFORCES_EXECUTION_ONCE_AFTER_INSTALL
	 * @model literal="enforcesExecutionOnceAfterInstall"
	 * @generated
	 * @ordered
	 */
	public static final int ENFORCES_EXECUTION_ONCE_AFTER_INSTALL_VALUE = 0;

	/**
	 * The '<em><b>ENABLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENABLES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENABLES
	 * @model literal="enables"
	 * @generated
	 * @ordered
	 */
	public static final int ENABLES_VALUE = 0;

	/**
	 * An array of all the '<em><b>Use Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UseType[] VALUES_ARRAY =
		new UseType[]
		{
			ACCESSES,
			CALLS,
			INITIALIZES,
			DECRYPTS,
			ENCRYPTS,
			RECEIVES_AS_CIPHERTEXT,
			RECEIVES_AS_PLAINTEXT,
			ENFORCES_EXECUTION_ONCE_AFTER_INSTALL,
			ENABLES,
		};

	/**
	 * A public read-only list of all the '<em><b>Use Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UseType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Use Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static UseType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			UseType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Use Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static UseType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			UseType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Use Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static UseType get(int value)
	{
		switch (value)
		{
			case ACCESSES_VALUE: return ACCESSES;
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
	private UseType(int value, String name, String literal)
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
	
} //UseType
