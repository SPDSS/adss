/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies.samples.ontologies;

import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.OntologyClass;
import it.polito.security.ontologies.OntologyDataProperty;
import it.polito.security.ontologies.OntologyIndividual;
import it.polito.security.ontologies.OntologyObjectProperty;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.samples.Sample;

/**
 * This example shows how to get the obvious axioms, that are the non-inferred axioms.
 * @author Daniele Canavese
 **/
public class GetsObviousAxioms extends Sample
{
	/** The namespace of the ontology. **/
	static final String NAMESPACE = "http://security.polito.it/ontologies/samples/test.owl#";

	/**
	 * Launch the sample.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void run() throws Exception
	{
		// Create an empty ontology.
		Ontology ontology = new Ontology(ReasonerType.HERMIT);

		// Add some classes.
		OntologyClass class1 = ontology.addClass(NAMESPACE + "Class1");
		OntologyClass class2 = ontology.addClass(NAMESPACE + "Class2");
		OntologyClass class3 = ontology.addClass(NAMESPACE + "Class3");
		class1.addEquivalence(class2);
		class2.addSubClass(class3);

		// Add some object properties.
		OntologyObjectProperty objectProperty1 = ontology.addObjectProperty(NAMESPACE + "objectProperty1");
		OntologyObjectProperty objectProperty2 = ontology.addObjectProperty(NAMESPACE + "objectProperty2");
		OntologyObjectProperty objectProperty3 = ontology.addObjectProperty(NAMESPACE + "objectProperty3");
		OntologyObjectProperty objectProperty4 = ontology.addObjectProperty(NAMESPACE + "objectProperty4");
		objectProperty1.addEquivalence(objectProperty2);
		objectProperty2.addSubProperty(objectProperty3);
		objectProperty3.addInverseProperty(objectProperty4);

		// Add some data properties.
		OntologyDataProperty dataProperty1 = ontology.addDataProperty(NAMESPACE + "dataProperty1");
		OntologyDataProperty dataProperty2 = ontology.addDataProperty(NAMESPACE + "dataProperty2");
		OntologyDataProperty dataProperty3 = ontology.addDataProperty(NAMESPACE + "dataProperty3");
		dataProperty1.addEquivalence(dataProperty2);
		dataProperty2.addSubProperty(dataProperty3);

		// Add some individuals.
		OntologyIndividual individual1 = ontology.addIndividual(NAMESPACE + "individual1", class1);
		OntologyIndividual individual2 = ontology.addIndividual(NAMESPACE + "individual2", class1);
		individual1.addEquivalence(individual2);
		individual1.addDataPropertyValue(dataProperty1, "value1");
		individual1.addObjectPropertyValue(objectProperty1, individual2);

		// Commit the results.
		ontology.flush();

		// Print some obvious class axioms.
		for (OntologyClass i : class1.getObviousEquivalentClasses())
			System.out.println(i);
		for (OntologyClass i : class2.getObviousSubClasses())
			System.out.println(i);
		for (OntologyClass i : class3.getObviousSuperClasses())
			System.out.println(i);
		for (OntologyIndividual i : class1.getObviousIndividuals())
			System.out.println(i);

		// Print some obvious object property axioms.
		for (OntologyObjectProperty i : objectProperty1.getObviousEquivalentProperties())
			System.out.println(i);
		for (OntologyObjectProperty i : objectProperty2.getObviousSubProperties())
			System.out.println(i);
		for (OntologyObjectProperty i : objectProperty3.getObviousSuperProperties())
			System.out.println(i);
		for (OntologyObjectProperty i : objectProperty3.getObviousInverseProperties())
			System.out.println(i);

		// Print some obvious data property axioms.
		for (OntologyDataProperty i : dataProperty1.getObviousEquivalentProperties())
			System.out.println(i);
		for (OntologyDataProperty i : dataProperty2.getObviousSubProperties())
			System.out.println(i);
		for (OntologyDataProperty i : dataProperty3.getObviousSuperProperties())
			System.out.println(i);

		// Print some obvious individual axioms.
		for (OntologyClass i : individual1.getObviousContainingClasses())
			System.out.println(i);
		for (String i : individual1.getObviousDataPropertyValues(dataProperty1, String.class))
			System.out.println(i);
		for (OntologyIndividual i : individual1.getObviousEquivalentIndividuals())
			System.out.println(i);
		for (OntologyIndividual i : individual1.getObviousObjectPropertyValues(objectProperty1))
			System.out.println(i);
	}
}
