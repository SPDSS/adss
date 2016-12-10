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
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A code block.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.CodeBlock#getType <em>Type</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.CodeBlock#getCodeBlocks <em>Code Blocks</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.CodeBlock#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.CodeBlock#getEndLine <em>End Line</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.CodeBlock#getSourceFilePath <em>Source File Path</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getCodeBlock()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#CodeBlock",
	name = "http://www.aspire-fp7.eu/akb#codeBlock",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.CODE_BLOCK__START_LINE, iri = "http://www.aspire-fp7.eu/akb#hasStartLine"),
		@MapsToDataProperty(id = AkbPackage.CODE_BLOCK__END_LINE, iri = "http://www.aspire-fp7.eu/akb#hasEndLine"),
		@MapsToDataProperty(id = AkbPackage.CODE_BLOCK__SOURCE_FILE_PATH, iri = "http://www.aspire-fp7.eu/akb#hasSourceFilePath")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.CODE_BLOCK__TYPE, iri = "http://www.aspire-fp7.eu/akb#isTypeOf"),
		@MapsToObjectProperty(id = AkbPackage.CODE_BLOCK__CODE_BLOCKS, iri = "http://www.aspire-fp7.eu/akb#contains")
	}
)
public interface CodeBlock extends EObject
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aspire_fp7.adss.akb.CodeBlockType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The block type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.CodeBlockType
	 * @see #setType(CodeBlockType)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getCodeBlock_Type()
	 * @model unique="false"
	 * @generated
	 */
	CodeBlockType getType();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.CodeBlock#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.CodeBlockType
	 * @see #getType()
	 * @generated
	 */
	void setType(CodeBlockType value);

	/**
	 * Returns the value of the '<em><b>Code Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.CodeBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained blocks.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code Blocks</em>' containment reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getCodeBlock_CodeBlocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<CodeBlock> getCodeBlocks();

	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file line where this block starts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getCodeBlock_StartLine()
	 * @model unique="false"
	 * @generated
	 */
	int getStartLine();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.CodeBlock#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(int value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file line where this block starts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(int)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getCodeBlock_EndLine()
	 * @model unique="false"
	 * @generated
	 */
	int getEndLine();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.CodeBlock#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(int value);

	/**
	 * Returns the value of the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file in which the uses is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source File Path</em>' attribute.
	 * @see #setSourceFilePath(String)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getCodeBlock_SourceFilePath()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceFilePath();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.CodeBlock#getSourceFilePath <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File Path</em>' attribute.
	 * @see #getSourceFilePath()
	 * @generated
	 */
	void setSourceFilePath(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _sourceFilePath = this.getSourceFilePath();\nint _hashCode = _sourceFilePath.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%eu.aspire_fp7.adss.akb.CodeBlockType%> _type = this.getType();\nint _hashCode_1 = _type.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.CodeBlock%>> _codeBlocks = this.getCodeBlocks();\nint _hashCode_2 = _codeBlocks.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\nint _startLine = this.getStartLine();\nint _hashCode_3 = <%java.lang.Integer%>.valueOf(_startLine).hashCode();\nint _plus_3 = ((31 * result) + _hashCode_3);\nresult = _plus_3;\nint _endLine = this.getEndLine();\nint _hashCode_4 = <%java.lang.Integer%>.valueOf(_endLine).hashCode();\nint _plus_4 = ((31 * result) + _hashCode_4);\nresult = _plus_4;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // CodeBlock
