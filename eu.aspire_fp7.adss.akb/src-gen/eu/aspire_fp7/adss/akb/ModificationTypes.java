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

import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Modification Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The types of modifications that a protection can enforce on the protected code.
 * <!-- end-model-doc -->
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getModificationTypes()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#CodeRegions",
	name = "http://www.aspire-fp7.eu/akb#coderegions",
	singleton=true
)
public enum ModificationTypes implements Enumerator
{
  /**
   * The '<em><b>MODIFICATED AREA</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODIFICATED_AREA_VALUE
   * @generated
   * @ordered
   */
  MODIFICATED_AREA(0, "MODIFICATED_AREA", "modificatedArea"),

  /**
   * The '<em><b>MODIFICATED AREA AND ENTIRE FUNCTION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODIFICATED_AREA_AND_ENTIRE_FUNCTION_VALUE
   * @generated
   * @ordered
   */
  MODIFICATED_AREA_AND_ENTIRE_FUNCTION(0, "MODIFICATED_AREA_AND_ENTIRE_FUNCTION", "modificatedAreaAndEntireFunction"),

  /**
   * The '<em><b>ADDED SOURCE CODE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADDED_SOURCE_CODE_VALUE
   * @generated
   * @ordered
   */
  ADDED_SOURCE_CODE(0, "ADDED_SOURCE_CODE", "addedSourceCode"),

  /**
   * The '<em><b>ADDED BINARY CODE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADDED_BINARY_CODE_VALUE
   * @generated
   * @ordered
   */
  ADDED_BINARY_CODE(0, "ADDED_BINARY_CODE", "addedBinaryCode"),

  /**
   * The '<em><b>ALL CALLS TO FUNCTIONS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALL_CALLS_TO_FUNCTIONS_VALUE
   * @generated
   * @ordered
   */
  ALL_CALLS_TO_FUNCTIONS(0, "ALL_CALLS_TO_FUNCTIONS", "allCallsToFunctions");

  /**
   * The '<em><b>MODIFICATED AREA</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MODIFICATED AREA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODIFICATED_AREA
   * @model literal="modificatedArea"
   * @generated
   * @ordered
   */
  public static final int MODIFICATED_AREA_VALUE = 0;

  /**
   * The '<em><b>MODIFICATED AREA AND ENTIRE FUNCTION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MODIFICATED AREA AND ENTIRE FUNCTION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODIFICATED_AREA_AND_ENTIRE_FUNCTION
   * @model literal="modificatedAreaAndEntireFunction"
   * @generated
   * @ordered
   */
  public static final int MODIFICATED_AREA_AND_ENTIRE_FUNCTION_VALUE = 0;

  /**
   * The '<em><b>ADDED SOURCE CODE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADDED SOURCE CODE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADDED_SOURCE_CODE
   * @model literal="addedSourceCode"
   * @generated
   * @ordered
   */
  public static final int ADDED_SOURCE_CODE_VALUE = 0;

  /**
   * The '<em><b>ADDED BINARY CODE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADDED BINARY CODE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADDED_BINARY_CODE
   * @model literal="addedBinaryCode"
   * @generated
   * @ordered
   */
  public static final int ADDED_BINARY_CODE_VALUE = 0;

  /**
   * The '<em><b>ALL CALLS TO FUNCTIONS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ALL CALLS TO FUNCTIONS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALL_CALLS_TO_FUNCTIONS
   * @model literal="allCallsToFunctions"
   * @generated
   * @ordered
   */
  public static final int ALL_CALLS_TO_FUNCTIONS_VALUE = 0;

  /**
   * An array of all the '<em><b>Modification Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ModificationTypes[] VALUES_ARRAY =
    new ModificationTypes[]
    {
      MODIFICATED_AREA,
      MODIFICATED_AREA_AND_ENTIRE_FUNCTION,
      ADDED_SOURCE_CODE,
      ADDED_BINARY_CODE,
      ALL_CALLS_TO_FUNCTIONS,
    };

  /**
   * A public read-only list of all the '<em><b>Modification Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ModificationTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Modification Types</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModificationTypes get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ModificationTypes result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Modification Types</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModificationTypes getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ModificationTypes result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Modification Types</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModificationTypes get(int value)
  {
    switch (value)
    {
      case MODIFICATED_AREA_VALUE: return MODIFICATED_AREA;
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
  private ModificationTypes(int value, String name, String literal)
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
  
} //ModificationTypes
