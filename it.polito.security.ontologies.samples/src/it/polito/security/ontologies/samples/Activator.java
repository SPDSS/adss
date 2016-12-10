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
package it.polito.security.ontologies.samples;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator.
 * @author Daniele Canavese
 **/
public class Activator implements BundleActivator
{
	/**
	 * Launch a sample.
	 * @param sample
	 *            The sample object.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@SuppressWarnings("unused")
	private void launch(Sample sample) throws Exception
	{
		System.out.println(">LAUNCHING " + sample.getClass().getSimpleName() + ".");
		sample.run();
		System.out.println("<OK.\n");
		System.exit(0);
	}

	/**
	 * Performs some actions when the plug-in is loaded.
	 * @param context
	 *            The bundle context.
	 **/
	@Override
	public void start(BundleContext context) throws Exception
	{
		// launch(new ComparesClasses());
		// launch(new ComparesThingAndNothing());
		// launch(new DeletesClasses());
		// launch(new GetsIndividuals());
		// launch(new ManagesClassEquivalences());
		// launch(new ManagesClassNames());
		// launch(new ManagesSubClasses());
		// launch(new ManagesSuperClasses());
		//
		// launch(new ComparesDataProperties());
		// launch(new DeletesDataProperties());
		// launch(new HandlesSerialization());
		// launch(new ManagesDataPropertyCharacteristics());
		// launch(new ManagesDataPropertiesEquivalences());
		// launch(new ManagesDataPropertyNames());
		// launch(new ManagesSubDataProperties());
		// launch(new ManagesSuperDataProperties());
		// launch(new RetrievesDataPropertyDomainsAndRanges());
		//
		// launch(new ComparesIndividuals());
		// launch(new DeletesIndividuals());
		// launch(new ManagesContainingClasses());
		// launch(new ManagesDataProperties());
		// launch(new ManagesIndividualEquivalences());
		// launch(new ManagesIndividualNames());
		// launch(new ManagesObjectProperties());
		//
		// launch(new ComparesObjectProperties());
		// launch(new DeletesObjectProperties());
		// launch(new ManagesInverseProperties());
		// launch(new ManagesObjectPropertyCharacteristics());
		// launch(new ManagesObjectPropertyEquivalences());
		// launch(new ManagesObjectPropertyNames());
		// launch(new ManagesPropertyChains());
		// launch(new ManagesSubObjectProperties());
		// launch(new ManagesSuperObjectProperties());
		// launch(new RetrievesObjectPropertyDomainsAndRanges());
		//
		// launch(new AddsEntities());
		// launch(new AddsRules());
		// launch(new ChangesReasoner());
		// launch(new ChecksConsistency());
		// launch(new ChecksExpressivity());
		// launch(new ChecksEntities());
		// launch(new ComparesOntologies());
		// launch(new CreatesEmptyOntologies());
		// launch(new DuplicatesOntologies());
		// launch(new ExecutesQueries());
		// launch(new GetsObviousAxioms());
		// launch(new LoadsOntologies());
		// launch(new ManagesInclusions());
		// launch(new ManagesOntologyIRIs());
		// launch(new MergesOntologies());
		// launch(new PrecomputesInferences());
		// launch(new SavesInferredOntologies());
		// launch(new SavesOntologies());
		// launch(new SearchesEntities());
		// launch(new SerializesOntologies());
		// launch(new TestsSWRLPerformances());
		// launch(new UsesDefaultEntities());
		// launch(new UsingCustomBuiltIns());
		// launch(new UNAUsage());

//		launch(new SerializesObjects());
	}

	/**
	 * Performs some actions when the plug-in is unloaded.
	 * @param context
	 *            The bundle context.
	 **/
	@Override
	public void stop(BundleContext context) throws Exception
	{
	}
}
