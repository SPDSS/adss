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
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A solution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.Solution#getSolutionSequences <em>Solution Sequences</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Solution#getApplicationMetrics <em>Application Metrics</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Solution#getApplicationPartMetricSets <em>Application Part Metric Sets</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Solution#getFirstLevelSolution <em>First Level Solution</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Solution#getScore <em>Score</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.Solution#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#Solution",
	name = "http://www.aspire-fp7.eu/akb#solution",
	dataProperties =
	{
		@MapsToDataProperty(id = AkbPackage.SOLUTION__SCORE, iri = "http://www.aspire-fp7.eu/akb#hasScore")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.SOLUTION__SOLUTION_SEQUENCES, iri = "http://www.aspire-fp7.eu/akb#contains"),
		@MapsToObjectProperty(id = AkbPackage.SOLUTION__APPLICATION_METRICS, iri = "http://www.aspire-fp7.eu/akb#hasApplicationMetrics"),
		@MapsToObjectProperty(id = AkbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS, iri = "http://www.aspire-fp7.eu/akb#hasApplicationPartMetrics"),
		@MapsToObjectProperty(id = AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION, iri = "http://www.aspire-fp7.eu/akb#refersTo")
	}
)
public interface Solution extends EObject
{
	/**
	 * Returns the value of the '<em><b>Solution Sequences</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.SolutionSequence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The solution sequences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Solution Sequences</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution_SolutionSequences()
	 * @model
	 * @generated
	 */
	EList<SolutionSequence> getSolutionSequences();

	/**
	 * Returns the value of the '<em><b>Application Metrics</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application metrics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Metrics</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution_ApplicationMetrics()
	 * @model
	 * @generated
	 */
	EList<Metric> getApplicationMetrics();

	/**
	 * Returns the value of the '<em><b>Application Part Metric Sets</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part metrics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part Metric Sets</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution_ApplicationPartMetricSets()
	 * @model
	 * @generated
	 */
	EList<ApplicationPartMetricSet> getApplicationPartMetricSets();

	/**
	 * Returns the value of the '<em><b>First Level Solution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this solution is a second level one, the first level solution on which this is built.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Level Solution</em>' reference.
	 * @see #setFirstLevelSolution(Solution)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution_FirstLevelSolution()
	 * @model
	 * @generated
	 */
	Solution getFirstLevelSolution();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Solution#getFirstLevelSolution <em>First Level Solution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Level Solution</em>' reference.
	 * @see #getFirstLevelSolution()
	 * @generated
	 */
	void setFirstLevelSolution(Solution value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The score.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see #setScore(double)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution_Score()
	 * @model unique="false"
	 * @generated
	 */
	double getScore();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.Solution#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' attribute.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(double value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The object id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getSolution_Id()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='long h = ((long) <%java.lang.Integer%>.MIN_VALUE);\n<%eu.aspire_fp7.adss.akb.Solution%> _firstLevelSolution = this.getFirstLevelSolution();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_firstLevelSolution, null);\nif (_equals)\n{\n\treturn <%java.lang.Long%>.valueOf(h).toString();\n}\nelse\n{\n\t<%java.lang.String%> _string = <%java.lang.Long%>.valueOf(h).toString();\n\t<%java.lang.String%> _plus = (_string + \" (\");\n\t<%eu.aspire_fp7.adss.akb.Solution%> _firstLevelSolution_1 = this.getFirstLevelSolution();\n\t<%java.lang.String%> _id = _firstLevelSolution_1.getId();\n\t<%java.lang.String%> _string_1 = _id.toString();\n\t<%java.lang.String%> _plus_1 = (_plus + _string_1);\n\treturn (_plus_1 + \")\");\n}'"
	 * @generated
	 */
	String getId();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.SolutionSequence%>> _solutionSequences = this.getSolutionSequences();\nreturn _solutionSequences.toString();'"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.SolutionSequence%>> _solutionSequences = this.getSolutionSequences();\nint _hashCode = _solutionSequences.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%eu.aspire_fp7.adss.akb.Solution%>))\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.SolutionSequence%>> _solutionSequences = this.getSolutionSequences();\n\t\t<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.SolutionSequence%>> _solutionSequences_1 = ((<%eu.aspire_fp7.adss.akb.Solution%>)object).getSolutionSequences();\n\t\treturn <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(_solutionSequences, _solutionSequences_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // Solution
