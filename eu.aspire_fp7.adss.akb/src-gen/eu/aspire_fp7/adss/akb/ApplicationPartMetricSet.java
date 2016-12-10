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

import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Part Metric Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A list of metrics for an application part.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getMetrics <em>Metrics</em>}</li>
 * </ul>
 *
 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPartMetricSet()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://www.aspire-fp7.eu/akb#ApplicationPartMetric",
	name = "http://www.aspire-fp7.eu/akb#applicationPartMetric",
	objectProperties =
	{
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART, iri = "http://www.aspire-fp7.eu/akb#refersTo"),
		@MapsToObjectProperty(id = AkbPackage.APPLICATION_PART_METRIC_SET__METRICS, iri = "http://www.aspire-fp7.eu/akb#contains")
	}
)
public interface ApplicationPartMetricSet extends EObject
{
	/**
	 * Returns the value of the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part</em>' reference.
	 * @see #setApplicationPart(ApplicationPart)
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPartMetricSet_ApplicationPart()
	 * @model
	 * @generated
	 */
	ApplicationPart getApplicationPart();

	/**
	 * Sets the value of the '{@link eu.aspire_fp7.adss.akb.ApplicationPartMetricSet#getApplicationPart <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Part</em>' reference.
	 * @see #getApplicationPart()
	 * @generated
	 */
	void setApplicationPart(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' reference list.
	 * The list contents are of type {@link eu.aspire_fp7.adss.akb.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metrics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics</em>' reference list.
	 * @see eu.aspire_fp7.adss.akb.AkbPackage#getApplicationPartMetricSet_Metrics()
	 * @model
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%eu.aspire_fp7.adss.akb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nint _hashCode = _applicationPart.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%eu.aspire_fp7.adss.akb.Metric%>> _metrics = this.getMetrics();\nint _hashCode_1 = _metrics.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // ApplicationPartMetricSet
