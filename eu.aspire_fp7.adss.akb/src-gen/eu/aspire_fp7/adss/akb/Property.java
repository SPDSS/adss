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
 * A representation of the literals of the enumeration '<em><b>Property</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The properties.
 * <!-- end-model-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getProperty()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#Property",
	name = "http://www.aspire-fp7.eu/akb#",
	singleton = true
)
public enum Property implements Enumerator
{
  /**
   * The '<em><b>PRIVACY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PRIVACY_VALUE
   * @generated
   * @ordered
   */
  PRIVACY(0, "PRIVACY", "privacy"),

  /**
   * The '<em><b>INTEGRITY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTEGRITY_VALUE
   * @generated
   * @ordered
   */
  INTEGRITY(0, "INTEGRITY", "integrity"),

  /**
   * The '<em><b>CONFIDENTIALITY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONFIDENTIALITY_VALUE
   * @generated
   * @ordered
   */
  CONFIDENTIALITY(0, "CONFIDENTIALITY", "confidentiality"),

  /**
   * The '<em><b>HARDCONFIDENTIALITY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HARDCONFIDENTIALITY_VALUE
   * @generated
   * @ordered
   */
  HARDCONFIDENTIALITY(0, "HARDCONFIDENTIALITY", "hardConfidentiality"), /**
   * The '<em><b>HARDCODED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HARDCODED_VALUE
   * @generated
   * @ordered
   */
  HARDCODED(0, "HARDCODED", "hardcoded");

  /**
   * The '<em><b>PRIVACY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PRIVACY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PRIVACY
   * @model literal="privacy"
   * @generated
   * @ordered
   */
  public static final int PRIVACY_VALUE = 0;

  /**
   * The '<em><b>INTEGRITY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INTEGRITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTEGRITY
   * @model literal="integrity"
   * @generated
   * @ordered
   */
  public static final int INTEGRITY_VALUE = 0;

  /**
   * The '<em><b>CONFIDENTIALITY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONFIDENTIALITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONFIDENTIALITY
   * @model literal="confidentiality"
   * @generated
   * @ordered
   */
  public static final int CONFIDENTIALITY_VALUE = 0;

  /**
   * The '<em><b>HARDCONFIDENTIALITY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HARDCONFIDENTIALITY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HARDCONFIDENTIALITY
   * @model literal="hardConfidentiality"
   * @generated
   * @ordered
   */
  public static final int HARDCONFIDENTIALITY_VALUE = 0;

  /**
   * The '<em><b>HARDCODED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HARDCODED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HARDCODED
   * @model literal="hardcoded"
   * @generated
   * @ordered
   */
  public static final int HARDCODED_VALUE = 0;

  /**
   * An array of all the '<em><b>Property</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Property[] VALUES_ARRAY =
    new Property[]
    {
      PRIVACY,
      INTEGRITY,
      CONFIDENTIALITY,
      HARDCONFIDENTIALITY,
      HARDCODED,
    };

  /**
   * A public read-only list of all the '<em><b>Property</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Property> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Property</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Property get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Property result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Property</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Property getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Property result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Property</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Property get(int value)
  {
    switch (value)
    {
      case PRIVACY_VALUE: return PRIVACY;
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
  private Property(int value, String name, String literal)
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
  
} //Property
