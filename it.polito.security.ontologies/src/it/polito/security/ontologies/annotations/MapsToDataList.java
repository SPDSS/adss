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
package it.polito.security.ontologies.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Signals a Java method to an ontology list mapping of data.
 * @author Daniele Canavese
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface MapsToDataList
{
	/** The ID of the feature. **/
	int id();
	/** The IRI of the start ontology object property. **/
	String startIri();
	/** The IRI of the element ontology class. **/
	String elementIri();
	/** The IRI of the element name. **/
	String elementName();
	/** The IRI of the next ontology object property. **/
	String nextIri();
	/** The IRI of the ontology data property. **/
	String propertyIri();
}
