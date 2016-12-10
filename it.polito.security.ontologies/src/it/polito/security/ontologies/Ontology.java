/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxClassExpressionParser;
import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;
import org.coode.owlapi.manchesterowlsyntax.OntologyAxiomPair;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.PelletOptions;
import org.semanticweb.HermiT.Reasoner.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.ParserException;
import org.semanticweb.owlapi.expression.ShortFormEntityChecker;
import org.semanticweb.owlapi.io.FileDocumentSource;
import org.semanticweb.owlapi.io.OWLOntologyDocumentSource;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.io.StreamDocumentSource;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.MissingImportHandlingStrategy;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.SetOntologyID;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredDataPropertyCharacteristicAxiomGenerator;
import org.semanticweb.owlapi.util.InferredDisjointClassesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentClassAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentDataPropertiesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentObjectPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.InferredInverseObjectPropertiesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredObjectPropertyCharacteristicAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;
import org.semanticweb.owlapi.util.InferredSubDataPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.InferredSubObjectPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.OWLEntityRemover;
import org.semanticweb.owlapi.util.OWLEntityRenamer;
import org.semanticweb.owlapi.util.OWLOntologyMerger;
import org.semanticweb.owlapi.util.SimpleIRIMapper;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

import com.clarkparsia.owlapi.explanation.PelletExplanation;
import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.clarkparsia.pellet.rules.builtins.BuiltInRegistry;
import com.clarkparsia.pellet.rules.builtins.NoSuchBuiltIn;

import de.derivo.sparqldlapi.Query;
import de.derivo.sparqldlapi.QueryArgument;
import de.derivo.sparqldlapi.QueryBinding;
import de.derivo.sparqldlapi.QueryEngine;
import de.derivo.sparqldlapi.QueryParser;
import de.derivo.sparqldlapi.QueryResult;
import de.derivo.sparqldlapi.QueryTokenizer;
import de.derivo.sparqldlapi.exceptions.QueryEngineException;
import de.derivo.sparqldlapi.exceptions.QueryParserException;
import de.derivo.sparqldlapi.impl.QueryParserImpl;
import it.polito.security.ontologies.annotations.MapsToDataList;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.exceptions.CorruptionException;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.OntologyCreationException;
import it.polito.security.ontologies.exceptions.OntologySaveException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.QueryExecutionException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;
import it.polito.security.ontologies.exceptions.UnsupportedQueryResultException;
import uk.ac.manchester.cs.factplusplus.owlapiv3.FaCTPlusPlusReasonerFactory;
import uk.ac.manchester.cs.owlapi.dlsyntax.DLSyntaxObjectRenderer;

/**
 * An ontology. This class is a wrapper for several APIs.
 * @author Daniele Canavese, Luca Moretto, Jacopo Silvestro
 **/
public class Ontology
{
	/** The separator string for the automatically generated individuals. **/
	private static final String SEPARATOR = ".";
	/** The separator string for the automatically generated sub-individuals. **/
	private static final String SEPARATOR2 = "-";
	/** The check data property. **/
	private static final String CHECKS_PROPERTY = "http://www.security.polito.it/ontologies#hasCheck";

	/**
	 * Retrieves an ontology related to a knowledge-base.
	 * @param kb
	 *            The knowledge-base.
	 * @return The ontology related to the knowledge-base or <code>null</code> if no such mapping exists.
	 **/
	static Ontology getOntologyMapping(KnowledgeBase kb)
	{
		return knowledgeBases.get(kb);
	}

	/** The mapping between ontologies and the knowledge-bases. **/
	private static Map<KnowledgeBase, Ontology> knowledgeBases = new HashMap<>();

	/**
	 * Loads an ontology from a file ignoring the missing imports.
	 * @param file
	 *            The file of the ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(final File file, final ReasonerType reasonerType) throws OntologyCreationException, IOException, CoreException
	{
		this(file, reasonerType, null);
	}

	/**
	 * Loads an ontology from a file.
	 * @param file
	 *            The file of the ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @param mappings
	 *            The mapping IRI-file for resolving the imports. If <code>null</code> or empty the missing imports are ignored.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(final File file, final ReasonerType reasonerType, final Map<String, File> mappings)
			throws OntologyCreationException, IOException, CoreException
	{
		try
		{
			this.reasonerType = reasonerType;
			ontologyManager = OWLManager.createOWLOntologyManager();
			OWLOntologyLoaderConfiguration configuration = new OWLOntologyLoaderConfiguration();
			if (mappings == null || mappings.isEmpty())
				configuration = configuration.setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT);
			else
				for (Entry<String, File> mapping : mappings.entrySet())
					ontologyManager.addIRIMapper(new SimpleIRIMapper(IRI.create(mapping.getKey()), IRI.create(mapping.getValue())));
			dataFactory = ontologyManager.getOWLDataFactory();
			OWLOntologyDocumentSource document = new FileDocumentSource(file);
			ontology = ontologyManager.loadOntologyFromOntologyDocument(document, configuration);
			synchronize();
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to load the ontology");
		}
		catch (NullPointerException e)
		{
			throw new OntologyCreationException("Unable to create the reasoner");
		}
	}

	/**
	 * Loads an ontology from an input stream ignoring the missing imports.
	 * @param inputStream
	 *            The input stream containing the ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(final InputStream inputStream, final ReasonerType reasonerType) throws OntologyCreationException, CoreException
	{
		this(inputStream, reasonerType, null);
	}

	/**
	 * Loads an ontology from an input stream.
	 * @param inputStream
	 *            The input stream containing the ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @param mappings
	 *            The mapping IRI-file for resolving the imports. If <code>null</code> or empty the missing imports are ignored.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(final InputStream inputStream, final ReasonerType reasonerType, final Map<String, File> mappings)
			throws OntologyCreationException, CoreException
	{
		try
		{
			this.reasonerType = reasonerType;
			ontologyManager = OWLManager.createOWLOntologyManager();
			OWLOntologyLoaderConfiguration configuration = new OWLOntologyLoaderConfiguration();
			if (mappings == null || mappings.isEmpty())
				configuration = configuration.setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT);
			else
				for (Entry<String, File> mapping : mappings.entrySet())
					ontologyManager.addIRIMapper(new SimpleIRIMapper(IRI.create(mapping.getKey()), IRI.create(mapping.getValue())));
			dataFactory = ontologyManager.getOWLDataFactory();
			OWLOntologyDocumentSource document = new StreamDocumentSource(inputStream);
			ontology = ontologyManager.loadOntologyFromOntologyDocument(document, configuration);
			synchronize();
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to load the ontology");
		}
		catch (NullPointerException e)
		{
			throw new OntologyCreationException("Unable to create the reasoner");
		}
	}

	/**
	 * Duplicates an ontology.
	 * @param ontology
	 *            The ontology to clone.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be cloned.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(final Ontology ontology) throws OntologyCreationException, CoreException
	{
		try
		{
			this.reasonerType = ontology.reasonerType;
			ontologyManager = OWLManager.createOWLOntologyManager();
			dataFactory = ontologyManager.getOWLDataFactory();
			this.ontology = ontologyManager.createOntology(ontology.ontology.getOntologyID().getOntologyIRI(),
					Collections.singleton(ontology.ontology));
			synchronize();
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to clone the ontology");
		}
		catch (NullPointerException e)
		{
			throw new OntologyCreationException("Unable to create the reasoner");
		}
	}

	/**
	 * Creates an empty anonymous ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(final ReasonerType reasonerType) throws OntologyCreationException, CoreException
	{
		try
		{
			this.reasonerType = reasonerType;
			ontologyManager = OWLManager.createOWLOntologyManager();
			dataFactory = ontologyManager.getOWLDataFactory();
			ontology = ontologyManager.createOntology();
			synchronize();
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to load the ontology");
		}
		catch (NullPointerException e)
		{
			throw new OntologyCreationException("Unable to create the reasoner");
		}
	}

	/**
	 * Creates an ontology from a set of files.
	 * @param ontologyIRI
	 *            The ontology IRI.
	 * @param files
	 *            The files of the ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(String ontologyIRI, final Collection<File> files, final ReasonerType reasonerType)
			throws OntologyCreationException, IOException, CoreException
	{
		this(ontologyIRI, files, reasonerType, null);
	}

	/**
	 * Creates an ontology from a set of files.
	 * @param ontologyIRI
	 *            The ontology IRI.
	 * @param files
	 *            The files of the ontology.
	 * @param reasonerType
	 *            The reasoner type.
	 * @param mappings
	 *            The mapping IRI-file for resolving the imports. If <code>null</code> or empty the missing imports are ignored.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(String ontologyIRI, final Collection<File> files, final ReasonerType reasonerType, final Map<String, File> mappings)
			throws OntologyCreationException, IOException, CoreException
	{
		try
		{
			this.reasonerType = reasonerType;
			ontologyManager = OWLManager.createOWLOntologyManager();
			OWLOntologyLoaderConfiguration configuration = new OWLOntologyLoaderConfiguration();
			if (mappings == null || mappings.isEmpty())
				configuration = configuration.setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT);
			else
				for (Entry<String, File> mapping : mappings.entrySet())
					ontologyManager.addIRIMapper(new SimpleIRIMapper(IRI.create(mapping.getKey()), IRI.create(mapping.getValue())));
			dataFactory = ontologyManager.getOWLDataFactory();
			for (File i : files)
				ontology = ontologyManager.loadOntologyFromOntologyDocument(new FileDocumentSource(i), configuration);
			OWLOntologyMerger merger = new OWLOntologyMerger(ontologyManager);
			ontology = merger.createMergedOntology(ontologyManager, IRI.create(ontologyIRI));
			synchronize();
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to load the ontology");
		}
		catch (NullPointerException e)
		{
			throw new OntologyCreationException("Unable to create the reasoner");
		}
	}

	/**
	 * Creates an ontology from a set of files.
	 * @param ontologyIRI
	 *            The ontology IRI.
	 * @param reasonerType
	 *            The reasoner type.
	 * @param streams
	 *            The input streams of the ontology.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public Ontology(String ontologyIRI, final ReasonerType reasonerType, final Collection<InputStream> streams)
			throws OntologyCreationException, IOException, CoreException
	{
		try
		{
			this.reasonerType = reasonerType;
			ontologyManager = OWLManager.createOWLOntologyManager();
			dataFactory = ontologyManager.getOWLDataFactory();
			for (InputStream i : streams)
				ontology = ontologyManager.loadOntologyFromOntologyDocument(i);
			OWLOntologyMerger merger = new OWLOntologyMerger(ontologyManager);
			ontology = merger.createMergedOntology(ontologyManager, IRI.create(ontologyIRI));
			synchronize();
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to load the ontology");
		}
		catch (NullPointerException e)
		{
			throw new OntologyCreationException("Unable to create the reasoner");
		}
	}

	/**
	 * Adds a new class to the ontology.
	 * @param className
	 *            The qualified name of the new class.
	 * @return The new class.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public OntologyClass addClass(final String className) throws OntologyChangeException
	{
		try
		{
			OWLClass concept = dataFactory.getOWLClass(IRI.create(className));
			OWLAxiom axiom = dataFactory.getOWLDeclarationAxiom(concept);
			ontologyManager.addAxiom(ontology, axiom);

			return new OntologyClass(this, concept);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the class axiom for \"" + className + "\"");
		}
	}

	/**
	 * Adds a new data property to the ontology.
	 * @param propertyName
	 *            The qualified name of the new property.
	 * @return The new property.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public OntologyDataProperty addDataProperty(final String propertyName) throws OntologyChangeException
	{
		try
		{
			OWLDataProperty property = dataFactory.getOWLDataProperty(IRI.create(propertyName));
			OWLAxiom axiom = dataFactory.getOWLDeclarationAxiom(property);
			ontologyManager.addAxiom(ontology, axiom);

			return new OntologyDataProperty(this, property);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the data property axiom for \"" + propertyName + "\"");
		}
	}

	/**
	 * Adds a new individual to the ontology.
	 * @param individualName
	 *            The qualified name of the new individual.
	 * @param ontologyClass
	 *            The class containing the individual.
	 * @return The new individual.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public OntologyIndividual addIndividual(final String individualName, final OntologyClass ontologyClass) throws OntologyChangeException
	{
		try
		{
			OWLNamedIndividual individual = dataFactory.getOWLNamedIndividual(IRI.create(individualName));
			OWLAxiom axiom = dataFactory.getOWLClassAssertionAxiom(ontologyClass.instance, individual);
			ontologyManager.addAxiom(ontology, axiom);

			return new OntologyIndividual(this, individual);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the class assertion axiom for \"" + individualName + "\"");
		}
	}

	/**
	 * Adds a new individual to the ontology.
	 * @param individualName
	 *            The qualified name of the new individual.
	 * @param className
	 *            The qualified name of the class containing the individual.
	 * @return The new individual.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public OntologyIndividual addIndividual(final String individualName, final String className)
			throws OntologyChangeException, ParsingErrorException
	{
		return addIndividual(individualName, getClass(className));
	}

	/**
	 * Adds a new object property to the ontology.
	 * @param propertyName
	 *            The qualified name of the new property.
	 * @return The new property.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public OntologyObjectProperty addObjectProperty(final String propertyName) throws OntologyChangeException
	{
		try
		{
			OWLObjectProperty property = dataFactory.getOWLObjectProperty(IRI.create(propertyName));
			OWLAxiom axiom = dataFactory.getOWLDeclarationAxiom(property);
			ontologyManager.addAxiom(ontology, axiom);

			return new OntologyObjectProperty(this, property);
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to add the object property axiom for \"" + propertyName + "\"");
		}
	}

	/**
	 * Add a new SWRL rule.
	 * @param rule
	 *            The SWRL rule to add.
	 **/
	public void addRule(String rule)
	{
		ManchesterOWLSyntaxEditorParser p = new ManchesterOWLSyntaxEditorParser(dataFactory, "Rule: " + rule);
		p.setOWLEntityChecker(entityChecker);
		p.setDefaultOntology(ontology);
		for (OntologyAxiomPair i : p.parseRuleFrame())
			ontologyManager.addAxiom(i.getOntology(), i.getAxiom());
	}

	/**
	 * Remove a SWRL rule.
	 * @param rule
	 *            The SWRL rule to remove.
	 **/
	public void removeRule(String rule)
	{
		ManchesterOWLSyntaxEditorParser p = new ManchesterOWLSyntaxEditorParser(dataFactory, "Rule: " + rule);
		p.setOWLEntityChecker(entityChecker);
		p.setDefaultOntology(ontology);
		for (OntologyAxiomPair i : p.parseRuleFrame())
			ontologyManager.removeAxiom(i.getOntology(), i.getAxiom());
	}

	/**
	 * Checks if a class is present in the ontology.
	 * @param className
	 *            The class to check.
	 * @return <code>true</code> if the class is present, <code>false</code> otherwise.
	 */
	public boolean containsClass(final String className)
	{
		OWLClass concept = dataFactory.getOWLClass(IRI.create(className));
		boolean result;
		if (concept.isBuiltIn())
			result = true;
		else
			result = entityChecker.getOWLClass(className) != null || ontology.containsClassInSignature(IRI.create(className));

		return result;
	}

	/**
	 * Checks if a data property is present in the ontology.
	 * @param propertyName
	 *            The data property to check.
	 * @return <code>true</code> if the data property is present, <code>false</code> otherwise.
	 */
	public boolean containsDataProperty(final String propertyName)
	{
		OWLDataProperty property = dataFactory.getOWLDataProperty(IRI.create(propertyName));
		boolean result;
		if (property.isBuiltIn())
			result = true;
		else
			result = entityChecker.getOWLDataProperty(propertyName) != null
					|| ontology.containsDataPropertyInSignature(IRI.create(propertyName));

		return result;
	}

	/**
	 * Checks if an individual is present in the ontology.
	 * @param individualName
	 *            The individual to check.
	 * @return <code>true</code> if the individual is present, <code>false</code> otherwise.
	 */
	public boolean containsIndividual(final String individualName)
	{
		return entityChecker.getOWLIndividual(individualName) != null || ontology.containsIndividualInSignature(IRI.create(individualName));
	}

	/**
	 * Checks if an object property is present in the ontology.
	 * @param propertyName
	 *            The object property to check.
	 * @return <code>true</code> if the object property is present, <code>false</code> otherwise.
	 */
	public boolean containsObjectProperty(final String propertyName)
	{
		OWLObjectProperty property = dataFactory.getOWLObjectProperty(IRI.create(propertyName));
		boolean result;
		if (property.isBuiltIn())
			result = true;
		else
			result = entityChecker.getOWLObjectProperty(propertyName) != null
					|| ontology.containsObjectPropertyInSignature(IRI.create(propertyName));

		return result;
	}

	/**
	 * Dispose the ontology.
	 **/
	public void dispose()
	{
		if (reasoner != null)
		{
			if (reasoner instanceof PelletReasoner)
				knowledgeBases.remove(((PelletReasoner) reasoner).getKB());
			reasoner.dispose();
		}
	}

	/**
	 * Compares two ontologies.
	 * @param object
	 *            The second ontology to compare.
	 * @return <code>true</code> if the two ontologies are the same, <code>false</code> otherwise.
	 **/
	@Override
	public boolean equals(final Object object)
	{
		if (object == null)
			return false;
		else if (object instanceof Ontology)
			return ((Ontology) object).ontology.equals(ontology);
		else
			return false;
	}

	/**
	 * Executes a SPARQL-DL ASK query.
	 * @param queryString
	 *            The query string.
	 * @return <code>true</code> if the query holds, <code>false</code> otherwise.
	 * @throws ParsingErrorException
	 *             If the query is invalid.
	 * @throws QueryExecutionException
	 *             If the query cannot be launched.
	 **/
	public boolean executeAskQuery(final String queryString) throws ParsingErrorException, QueryExecutionException
	{
		try
		{
			Query query = queryParser.parse(queryTokenizer.tokenize(queryString));

			if (query.isAsk() == true)
			{
				boolean result = queryEngine.execute(query).ask();
				return result;
			}
			else
				throw new ParsingErrorException("The query \"" + queryString + "\" is not an ASK query");
		}
		catch (QueryParserException e)
		{
			throw new ParsingErrorException("The query \"" + queryString + "\" is invalid");
		}
		catch (QueryEngineException e)
		{
			throw new QueryExecutionException("Unable to execute the query \"" + queryString + "\"");
		}
	}

	/**
	 * Executes a SPARQL-DL SELECT query.
	 * @param queryString
	 *            The query string.
	 * @return The map of variables-objects respecting the query.
	 * @throws ParsingErrorException
	 *             If the query is invalid.
	 * @throws UnsupportedQueryResultException
	 *             If a query result is not supported.
	 * @throws QueryExecutionException
	 *             If the query cannot be launched.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 **/
	public Collection<Map<String, Object>> executeSelectQuery(final String queryString)
			throws ParsingErrorException, UnsupportedQueryResultException, QueryExecutionException, NoSuchEntityException
	{
		try
		{
			Query query = queryParser.parse(queryTokenizer.tokenize(queryString));

			if (query.isSelect() == true || query.isSelectDistinct() == true)
			{
				Collection<Map<String, Object>> result = getSelectQueryResults(query);
				return result;
			}
			else
				throw new ParsingErrorException("The query \"" + queryString + "\" is not an ASK query");
		}
		catch (QueryParserException e)
		{
			throw new ParsingErrorException("The query \"" + queryString + "\" is invalid");
		}
		catch (QueryEngineException e)
		{
			throw new QueryExecutionException("Unable to execute the query \"" + queryString + "\"");
		}
	}

	/**
	 * Flushes any changes stored in the buffer.
	 **/
	public void flush()
	{
		reasoner.flush();
	}

	/**
	 * Detects the ontology axiom count.
	 * @return The ontology axiom count.
	 **/
	public int getAxiomCount()
	{
		return ontology.getAxiomCount();
	}

	/**
	 * Retrieves the bottomDataProperty data property.
	 * @return The bottomDataProperty data property.
	 **/
	public OntologyDataProperty getBottomDataProperty()
	{
		return new OntologyDataProperty(this, dataFactory.getOWLBottomDataProperty());
	}

	/**
	 * Retrieves the bottomObjectProperty object property.
	 * @return The bottomObjectProperty object property.
	 **/
	public OntologyObjectProperty getBottomObjectProperty()
	{
		return new OntologyObjectProperty(this, dataFactory.getOWLBottomObjectProperty());
	}

	/**
	 * Searches a class.
	 * @param className
	 *            The class full or short name or a Manchester syntax expression.
	 * @return The class object.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	public OntologyClass getClass(final String className) throws ParsingErrorException
	{
		return new OntologyClass(this, parse(className));
	}

	/**
	 * Searches a data property.
	 * @param propertyName
	 *            The property full or short name.
	 * @return The property object.
	 * @throws NoSuchEntityException
	 *             If the entity does not exist.
	 **/
	public OntologyDataProperty getDataProperty(final String propertyName) throws NoSuchEntityException
	{
		if (containsDataProperty(propertyName) == false)
			throw new NoSuchEntityException("The data property \"" + propertyName + "\" does not exist");
		OWLDataProperty entity = entityChecker.getOWLDataProperty(propertyName);
		if (entity == null)
			entity = dataFactory.getOWLDataProperty(IRI.create(propertyName));
		return new OntologyDataProperty(this, entity);
	}

	/**
	 * Detects the ontology expressivity.
	 * @return The ontology expressivity.
	 **/
	public String getExpressivity()
	{
		PelletReasoner pelletReasoner;
		if (reasoner instanceof PelletReasoner)
			pelletReasoner = (PelletReasoner) reasoner;
		else
			pelletReasoner = PelletReasonerFactory.getInstance().createReasoner(ontology);

		return pelletReasoner.getKB().getExpressivity().toString();
	}

	/**
	 * Retrieves an explanation for the ontology inconsistency.
	 * @return The clashing axioms.
	 **/
	public Set<Set<String>> getInconsistencyExplanation()
	{
		Set<Set<OWLAxiom>> explanations;
		DLSyntaxObjectRenderer renderer = new DLSyntaxObjectRenderer();

		PelletExplanation pelletExplanation = new PelletExplanation(ontology);
		explanations = pelletExplanation.getInconsistencyExplanations();

		Set<Set<String>> strings = new HashSet<>();
		for (Set<OWLAxiom> axioms : explanations)
		{
			Set<String> set = new HashSet<>();
			strings.add(set);
			for (OWLAxiom axiom : axioms)
				set.add(renderer.render(axiom));
		}

		return strings;
	}

	/**
	 * Searches an individual.
	 * @param individualName
	 *            The individual full or short name.
	 * @return The individual object.
	 * @throws NoSuchEntityException
	 *             If the entity does not exist.
	 **/
	public OntologyIndividual getIndividual(final String individualName) throws NoSuchEntityException
	{
		if (containsIndividual(individualName) == false)
			throw new NoSuchEntityException("The individual \"" + individualName + "\" does not exist");
		OWLNamedIndividual entity = entityChecker.getOWLIndividual(individualName);
		if (entity == null)
			entity = dataFactory.getOWLNamedIndividual(IRI.create(individualName));
		return new OntologyIndividual(this, entity);
	}

	/**
	 * Retrieves the ontology IRI.
	 * @return The ontology IRI or <code>null</code> if the ontology is anonymous.
	 **/
	public String getIRI()
	{
		if (ontology.getOntologyID().isAnonymous())
			return null;
		else
			return ontology.getOntologyID().getOntologyIRI().toString();
	}

	/**
	 * Retrieves the Nothing class.
	 * @return The Nothing class.
	 **/
	public OntologyClass getNothing()
	{
		return new OntologyClass(this, dataFactory.getOWLNothing());
	}

	/**
	 * Searches an object property.
	 * @param propertyName
	 *            The property full or short name.
	 * @return The property object.
	 * @throws NoSuchEntityException
	 *             If the entity does not exist.
	 **/
	public OntologyObjectProperty getObjectProperty(final String propertyName) throws NoSuchEntityException
	{
		if (containsObjectProperty(propertyName) == false)
			throw new NoSuchEntityException("The object property \"" + propertyName + "\" does not exist");
		OWLObjectProperty entity = entityChecker.getOWLObjectProperty(propertyName);
		if (entity == null)
			entity = dataFactory.getOWLObjectProperty(IRI.create(propertyName));
		return new OntologyObjectProperty(this, entity);
	}

	/**
	 * Effectively executes a SPARQL-DL SELECT query.
	 * @param query
	 *            The query to launch.
	 * @return The map of variables-objects respecting the query.
	 * @throws UnsupportedQueryResultException
	 *             If a query result is not supported.
	 * @throws QueryEngineException
	 *             If the query cannot be executed.
	 * @throws NoSuchEntityException
	 *             If an involved entity does not exist.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	private Collection<Map<String, Object>> getSelectQueryResults(final Query query)
			throws QueryEngineException, UnsupportedQueryResultException, NoSuchEntityException, ParsingErrorException
	{
		Collection<Map<String, Object>> result = new ArrayList<>();

		QueryResult queryResult = queryEngine.execute(query);

		Set<QueryArgument> variables = query.getResultVars();
		Iterator<QueryBinding> iterator = queryResult.iterator();
		while (iterator.hasNext())
		{
			HashMap<String, Object> map = new HashMap<>();
			result.add(map);
			QueryBinding queryBinding = iterator.next();

			for (QueryArgument variable : variables)
				if (variable.isVar() == true && queryBinding.isBound(variable) == true)
				{
					QueryArgument value = queryBinding.get(variable);
					if (value.isLiteral() == true)
						map.put(variable.getValue(), value.getValue());
					else if (value.isURI() == true)
					{
						if (containsIndividual(value.getValue()) == true)
							map.put(variable.getValue(), getIndividual(value.getValue()));
						else if (containsClass(value.getValue()) == true)
							map.put(variable.getValue(), getClass(value.getValue()));
						else if (containsObjectProperty(value.getValue()) == true)
							map.put(variable.getValue(), getObjectProperty(value.getValue()));
						else if (containsDataProperty(value.getValue()) == true)
							map.put(variable.getValue(), getDataProperty(value.getValue()));
						else
							throw new UnsupportedQueryResultException("Unsupported query result type");
					}
					else
						throw new UnsupportedQueryResultException("Unsupported query result type");
				}
		}

		return result;
	}

	/**
	 * Retrieves the Thing class.
	 * @return The Thing class.
	 **/
	public OntologyClass getThing()
	{
		return new OntologyClass(this, dataFactory.getOWLThing());
	}

	/**
	 * Retrieves the topDataProperty data property.
	 * @return The topDataProperty data property.
	 **/
	public OntologyDataProperty getTopDataProperty()
	{
		return new OntologyDataProperty(this, dataFactory.getOWLTopDataProperty());
	}

	/**
	 * Retrieves the topObjectProperty object property.
	 * @return The topObjectProperty object property.
	 **/
	public OntologyObjectProperty getTopObjectProperty()
	{
		return new OntologyObjectProperty(this, dataFactory.getOWLTopObjectProperty());
	}

	/**
	 * Gets the UNA (unique name assumption) usage value.
	 * @return The UNA usage value.
	 **/
	public boolean getUNA()
	{
		return PelletOptions.USE_UNIQUE_NAME_ASSUMPTION;
	}

	/**
	 * Retrieves an ontology hash code.
	 * @return The ontology hash code.
	 **/
	@Override
	public int hashCode()
	{
		return ontology.hashCode();
	}

	/**
	 * Checks if the ontology is consistent.
	 * @return <code>true</code> if the ontology is consistent, <code>false</code> otherwise.
	 **/
	public boolean isConsistent()
	{
		boolean result = reasoner.isConsistent();
		return result;
	}

	/**
	 * Detects if the ontology is EL.
	 * @return <code>true</code> if the ontology is EL, <code>false</code> otherwise.
	 **/
	public boolean isEL()
	{
		PelletReasoner pelletReasoner;
		if (reasoner instanceof PelletReasoner)
			pelletReasoner = (PelletReasoner) reasoner;
		else
			pelletReasoner = PelletReasonerFactory.getInstance().createReasoner(ontology);

		return pelletReasoner.getKB().getExpressivity().isEL();
	}

	/**
	 * Parses a class expression.
	 * @param expression
	 *            The expression to parse.
	 * @return The OWL class expression.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 **/
	OWLClassExpression parse(String expression) throws ParsingErrorException
	{
		try
		{
			OWLClassExpression classExpression;
			if (containsClass(expression) == true)
			{
				classExpression = entityChecker.getOWLClass(expression);
				if (classExpression == null)
					classExpression = dataFactory.getOWLClass(IRI.create(expression));
			}
			else
				classExpression = classParser.parse(expression);
			return classExpression;
		}
		catch (ParserException e)
		{
			throw new ParsingErrorException(e.getMessage());
		}
	}

	/**
	 * Asks the reasoner to precompute all the inferences.
	 **/
	public void precomputeInferences()
	{
		for (InferenceType i : InferenceType.values())
			reasoner.precomputeInferences(i);
	}

	/**
	 * Saves the ontology in a file in RDF/XML format.
	 * @param file
	 *            The file where to save the ontology.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 **/
	public void save(File file) throws OntologySaveException
	{
		try
		{
			ontologyManager.saveOntology(ontology, new RDFXMLOntologyFormat(), IRI.create(file));
		}
		catch (OWLOntologyStorageException e)
		{
			throw new OntologySaveException("Unable to save the ontology in \"" + file + "\"");
		}
	}

	/**
	 * Saves the ontology in a file in RDF/XML format.
	 * @param outputStream
	 *            The stream where to save the ontology.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 **/
	public void save(OutputStream outputStream) throws OntologySaveException
	{
		try
		{
			ontologyManager.saveOntology(ontology, new RDFXMLOntologyFormat(), outputStream);
		}
		catch (OWLOntologyStorageException e)
		{
			throw new OntologySaveException("Unable to save the ontology in \"" + outputStream.toString() + "\"");
		}
	}

	/**
	 * Saves the ontology in a file in RDF/XML format.
	 * @param fileName
	 *            The ontology file name.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 **/
	public void save(String fileName) throws OntologySaveException
	{
		save(new File(fileName));
	}

	/**
	 * Saves the fully reasoned ontology in a file in RDF/XML format.
	 * @param file
	 *            The file where to save the ontology.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 * @throws OntologyCreationException
	 *             If the temporary ontology cannot be created.
	 **/
	public void saveFull(File file) throws OntologySaveException, OntologyCreationException
	{
		try
		{
			precomputeInferences();
			List<InferredAxiomGenerator<? extends OWLAxiom>> generators = new ArrayList<>();
			generators.add(new InferredEquivalentClassAxiomGenerator());
			generators.add(new InferredSubClassAxiomGenerator());
			generators.add(new InferredDisjointClassesAxiomGenerator());
			generators.add(new InferredEquivalentDataPropertiesAxiomGenerator());
			generators.add(new InferredSubDataPropertyAxiomGenerator());
			generators.add(new InferredDataPropertyCharacteristicAxiomGenerator());
			generators.add(new InferredEquivalentObjectPropertyAxiomGenerator());
			generators.add(new InferredSubObjectPropertyAxiomGenerator());
			generators.add(new InferredObjectPropertyCharacteristicAxiomGenerator());
			generators.add(new InferredInverseObjectPropertiesAxiomGenerator());
			generators.add(new InferredClassAssertionAxiomGenerator());
			generators.add(new InferredPropertyAssertionGenerator());
			OWLOntology inferredOntology = ontologyManager.createOntology();
			InferredOntologyGenerator generator = new InferredOntologyGenerator(reasoner, generators);
			generator.fillOntology(ontologyManager, inferredOntology);
			ontologyManager.saveOntology(inferredOntology, new RDFXMLOntologyFormat(), IRI.create(file));
			ontologyManager.removeOntology(inferredOntology);
		}
		catch (OWLOntologyStorageException e)
		{
			throw new OntologySaveException("Unable to save the ontology in \"" + file + "\"");
		}
		catch (OWLOntologyCreationException e)
		{
			throw new OntologyCreationException("Unable to create the temporary ontology");
		}
	}

	/**
	 * Saves the fully reasoned ontology in a file in RDF/XML format.
	 * @param file
	 *            The file where to save the ontology.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 * @throws OntologyCreationException
	 *             If the temporary ontology cannot be created.
	 **/
	public void saveFull(String file) throws OntologySaveException, OntologyCreationException
	{
		saveFull(new File(file));
	}

	/**
	 * Serializes this ontology into a String in RDF/XML format.
	 * @return a String containing the serialized ontology
	 */
	public String serialize()
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try
		{
			ontologyManager.saveOntology(ontology, new RDFXMLOntologyFormat(), out);
		}
		catch (OWLOntologyStorageException e)
		{
			e.printStackTrace();
			return null;
		}

		return out.toString();
	}

	/**
	 * Sets the ontology IRI.
	 * @param ontologyIRI
	 *            The new ontology IRI
	 * @throws OntologyChangeException
	 *             If the new IRI cannot be set or changed
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 */
	public void setIRI(String ontologyIRI) throws OntologyChangeException, NullPointerException, CoreException
	{
		try
		{
			OWLOntologyID newId = new OWLOntologyID(IRI.create(ontologyIRI));
			SetOntologyID idChange = new SetOntologyID(this.ontology, newId);
			ontologyManager.applyChange(idChange);
			synchronize();
		}
		catch (OWLOntologyChangeException e)
		{
			throw new OntologyChangeException("Unable to change the ontology iri to \"" + ontologyIRI + "\"");
		}
	}

	/**
	 * Changes the current reasoner.
	 * @param reasonerType
	 *            The new reasoner to set.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	public void setReasoner(ReasonerType reasonerType) throws NullPointerException, CoreException
	{
		if (reasonerType != this.reasonerType)
		{
			this.reasonerType = reasonerType;
			synchronize();
		}
	}

	/**
	 * Sets the UNA (unique name assumption) usage.
	 * @param value
	 *            The UNA value.
	 **/
	public void setUNA(boolean value)
	{
		PelletOptions.USE_UNIQUE_NAME_ASSUMPTION = value;
	}

	/**
	 * Synchronizes the reasoner and the query engine. This method must be invoked every time the ontology is reloaded or merged.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
	 **/
	private void synchronize() throws NullPointerException, CoreException
	{
		IExtensionPoint extension = Platform.getExtensionRegistry().getExtensionPoint("it.polito.security.ontologies.builtins");
		for (IConfigurationElement i : extension.getConfigurationElements())
		{
			String name = i.getAttribute("name");
			Object object = i.createExecutableExtension("class");
			if (name != null && name.isEmpty() == false && object instanceof SWRLBuiltIn)
			{
				SWRLBuiltIn builtin = (SWRLBuiltIn) object;
				if (BuiltInRegistry.instance.getBuiltIn(name).equals(NoSuchBuiltIn.instance))
					BuiltInRegistry.instance.registerBuiltIn(name, new SWRLBuiltInRunner(builtin));
			}
		}

		dispose();

		if (reasonerType == ReasonerType.FACTPLUSPLUS)
			reasonerFactory = new FaCTPlusPlusReasonerFactory();
		else if (reasonerType == ReasonerType.HERMIT)
			reasonerFactory = new ReasonerFactory();
		else if (reasonerType == ReasonerType.PELLET)
			reasonerFactory = PelletReasonerFactory.getInstance();
		reasoner = reasonerFactory.createReasoner(ontology);

		queryEngine = QueryEngine.create(ontologyManager, reasoner);
		BidirectionalShortFormProviderAdapter adapter = new BidirectionalShortFormProviderAdapter(ontologyManager,
				Collections.singleton(ontology), new SimpleShortFormProvider());
		entityChecker = new ShortFormEntityChecker(adapter);
		classParser = new ManchesterOWLSyntaxClassExpressionParser(dataFactory, entityChecker);
		queryTokenizer = new CustomQueryTokenizer();
		queryParser = new QueryParserImpl();
		remover = new OWLEntityRemover(ontologyManager, Collections.singleton(ontology));
		renamer = new OWLEntityRenamer(ontologyManager, Collections.singleton(ontology));
		serializedObjects = new HashMap<>();
		deserializedObjects = new HashMap<>();
		prefixCounters = new HashMap<>();

		if (reasonerType == ReasonerType.PELLET)
			knowledgeBases.put(((PelletReasoner) reasoner).getKB(), this);
	}

	/**
	 * Converts this ontology to a string (its qualified name).
	 * @return The qualified name of the ontology.
	 **/
	@Override
	public String toString()
	{
		return getIRI();
	}

	/**
	 * Serializes a Java object in the ontology. The java object must be a bean and must have been annotated with the right annotations.
	 * This method is recursive and will try to put also all the referred objects into the ontology. This method will also check for
	 * duplicates, that is the same object cannot be added twice to the ontology.
	 * @param object
	 *            The Java object to serialize.
	 * @return The relative ontology individual.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 **/
	public OntologyIndividual serialize(Object object) throws OntologyChangeException, ParsingErrorException, NoSuchEntityException,
			IOException, InconsistencyException, ReasoningInterruptedException
	{
		return serialize(object, new HashSet<>());
	}

	/**
	 * Serializes a Java object in the ontology. The java object must be a bean and must have been annotated with the right annotations.
	 * This method is recursive and will try to put also all the referred objects into the ontology. This method will also check for
	 * duplicates, that is the same object cannot be added twice to the ontology.
	 * @param object
	 *            The Java object to serialize.
	 * @param serialized
	 *            The set of serialized objects so far.
	 * @return The relative ontology individual.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 **/
	public OntologyIndividual serialize(Object object, Collection<Object> serialized) throws OntologyChangeException, ParsingErrorException,
			NoSuchEntityException, IOException, InconsistencyException, ReasoningInterruptedException
	{
		Class<?> clazz;
		if (object instanceof Map.Entry)
			clazz = object.getClass();
		else if (object instanceof EObject)
			clazz = ((EObject) object).eClass().getInstanceClass();
		else
			clazz = object.getClass();
		MapsToIndividual toIndividual = clazz.getAnnotation(MapsToIndividual.class);

		if (toIndividual != null)
		{
			if (object instanceof EObject)
			{
				String name;
				if (serializedObjects.containsKey(object))
					name = serializedObjects.get(object);
				else if (toIndividual.singleton())
					name = toIndividual.name();
				else
					name = getName(toIndividual.name());
				serializedObjects.put(object, name);

				OntologyIndividual individual = addIndividual(name, toIndividual.iri());

				if (!serialized.contains(object))
				{
					serialized.add(object);
					for (MapsToDataProperty i : toIndividual.dataProperties())
						serializeProperty((EObject) object, individual, i, name, serialized);
					for (MapsToObjectProperty i : toIndividual.objectProperties())
						serializeProperty((EObject) object, individual, i, name, serialized);
					for (MapsToDataList i : toIndividual.dataLists())
						serializeProperty((EObject) object, individual, i, name, serialized);
					for (MapsToObjectList i : toIndividual.objectLists())
						serializeProperty((EObject) object, individual, i, name, serialized);
				}

				return individual;
			}
			else if (object instanceof Enumerator)
				return addIndividual(toIndividual.name() + ((Enumerator) object).getLiteral(), toIndividual.iri());
			else
				throw new NoSuchEntityException("Unable to serialize the object");
		}
		else
			throw new NoSuchEntityException("Unable to serialize the object");
	}

	/**
	 * Retrieves a (hopefully) unique name for a prefix.
	 * @param prefix
	 *            The prefix.
	 * @return A unique name starting with the given prefix.
	 **/
	private String getName(String prefix)
	{
		long index;
		if (prefixCounters.containsKey(prefix))
			index = prefixCounters.get(prefix) + 1;
		else
			index = 0;
		prefixCounters.put(prefix, index);

		return prefix + SEPARATOR + index;
	}

	/**
	 * Retrieves a (hopefully) unique name for an individual related to another one.
	 * @param prefix
	 *            The prefix.
	 * @param reference
	 *            The name of the referenced individual.
	 * @param index
	 *            The index of the individual.
	 * @return A unique name starting with the given prefix.
	 **/
	private String getName(String prefix, String reference, int index)
	{
		String name = reference;
		if (name.contains("#"))
			name = name.substring(name.lastIndexOf("#") + 1);

		return prefix + SEPARATOR2 + name + SEPARATOR + index;
	}

	/**
	 * Updates the prefix counter taking into account a new individual.
	 * @param individual
	 *            The new individual used to update the counter.
	 **/
	private void updateCounters(OntologyIndividual individual)
	{
		for (String i : prefixCounters.keySet())
			if (individual.getIRI().startsWith(i))
				try
				{
					String index = individual.getIRI().substring(i.length() + SEPARATOR.length());
					long value = Long.valueOf(index);
					if (prefixCounters.containsKey(i))
						value = Math.max(value, prefixCounters.get(i));
					prefixCounters.put(index, value);
					break;
				}
				catch (NumberFormatException e)
				{
				}
	}

	/**
	 * Serializes a property value for a Java object.
	 * @param object
	 *            The Java object.
	 * @param individual
	 *            The individual related to the Java object.
	 * @param annotation
	 *            The annotation to analyze.
	 * @param name
	 *            The base name of the object in the ontology.
	 * @param serialized
	 *            The set of serialized objects so far.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 **/
	private void serializeProperty(EObject object, OntologyIndividual individual, Annotation annotation, String name,
			Collection<Object> serialized) throws OntologyChangeException, NoSuchEntityException, IOException, ParsingErrorException,
			InconsistencyException, ReasoningInterruptedException
	{
		int id = 0;
		String iri = null;
		String startIri = null;
		String nextIri = null;
		String propertyIri = null;
		String elementIri = null;
		String elementName = null;
		EStructuralFeature feature = null;
		Object value = null;

		if (annotation instanceof MapsToDataProperty)
		{
			id = ((MapsToDataProperty) annotation).id();
			iri = ((MapsToDataProperty) annotation).iri();
		}
		else if (annotation instanceof MapsToObjectProperty)
		{
			id = ((MapsToObjectProperty) annotation).id();
			iri = ((MapsToObjectProperty) annotation).iri();
		}
		else if (annotation instanceof MapsToDataList)
		{
			id = ((MapsToDataList) annotation).id();
			startIri = ((MapsToDataList) annotation).startIri();
			nextIri = ((MapsToDataList) annotation).nextIri();
			propertyIri = ((MapsToDataList) annotation).propertyIri();
			elementIri = ((MapsToDataList) annotation).elementIri();
			elementName = ((MapsToDataList) annotation).elementName();
		}
		else if (annotation instanceof MapsToObjectList)
		{
			id = ((MapsToObjectList) annotation).id();
			startIri = ((MapsToObjectList) annotation).startIri();
			nextIri = ((MapsToObjectList) annotation).nextIri();
			propertyIri = ((MapsToObjectList) annotation).propertyIri();
			elementIri = ((MapsToObjectList) annotation).elementIri();
			elementName = ((MapsToObjectList) annotation).elementName();
		}
		feature = object.eClass().getEStructuralFeature(id);
		value = object.eGet(feature);
		OntologyIndividual first = null;
		OntologyIndividual previous = null;

		if (annotation instanceof MapsToDataProperty)
			individual.removeDataPropertyValues(iri);
		else if (annotation instanceof MapsToObjectProperty)
			individual.removeObjectPropertyValues(iri);
		else if (annotation instanceof MapsToDataList || annotation instanceof MapsToObjectList)
		{
			OntologyIndividual j = individual.getObjectPropertyValue(startIri);

			while (j != null)
			{
				OntologyIndividual next = j.getObjectPropertyValue(nextIri);
				j.remove();
				j = next;
			}

			individual.removeObjectPropertyValues(propertyIri);
			individual.removeObjectPropertyValues(startIri);
		}

		if (feature.isMany())
		{
			int count = 0;
			for (Object j : (Collection<?>) value)
			{
				if (annotation instanceof MapsToDataProperty)
					individual.addDataPropertyValue(iri, j);
				else if (annotation instanceof MapsToObjectProperty)
					individual.addObjectPropertyValue(iri, serialize(j, serialized));
				else if (annotation instanceof MapsToDataList)
				{
					String name2 = getName(elementName, name, count);
					OntologyIndividual element = addIndividual(name2, elementIri);
					element.addDataPropertyValue(propertyIri, j);
					if (previous != null)
						previous.addObjectPropertyValue(nextIri, element);
					if (first == null)
						first = element;
					previous = element;
				}
				else if (annotation instanceof MapsToObjectList)
				{
					String name2 = getName(elementName, name, count);
					OntologyIndividual element = addIndividual(name2, elementIri);
					element.addObjectPropertyValue(propertyIri, serialize(j, serialized));
					if (previous != null)
						previous.addObjectPropertyValue(nextIri, element);
					if (first == null)
						first = element;
					previous = element;
				}
				++count;
			}
			if (first != null)
				individual.addObjectPropertyValue(startIri, first);
		}
		else
		{
			if (annotation instanceof MapsToDataProperty)
			{
				if (value != null)
					individual.addDataPropertyValue(iri, value);
			}
			else if (annotation instanceof MapsToObjectProperty)
			{
				if (value != null)
					individual.addObjectPropertyValue(iri, serialize(value, serialized));
			}
			else if (annotation instanceof MapsToDataList)
			{
				OntologyIndividual element = addIndividual(elementName + object.hashCode() + ".0", elementIri);
				element.addDataPropertyValue(propertyIri, value);
				individual.addObjectPropertyValue(startIri, element);
			}
			else if (annotation instanceof MapsToObjectList)
			{
				OntologyIndividual element = addIndividual(elementName + object.hashCode() + ".0", elementIri);
				element.addObjectPropertyValue(propertyIri, serialize(value, serialized));
				individual.addObjectPropertyValue(startIri, element);
			}
		}
	}

	/**
	 * Deserializes a set of Java objects from the ontology. The java classes must have been annotated with the right annotations. This
	 * method is recursive and will try to pull out also all the referred objects from the ontology. This method will also check for
	 * duplicates, that is the same object cannot be extracted twice from the ontology.
	 * @param eClassifier
	 *            The Java class whose objects must be deserialized.
	 * @param eFactory
	 *            The EFactory to use.
	 * @return The extracted objects.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public Collection<Object> deserialize(EClassifier eClassifier, EFactory eFactory)
			throws NoSuchEntityException, InstantiationException, IllegalAccessException, InconsistencyException,
			ReasoningInterruptedException, ParsingErrorException, ClassNotFoundException, IOException, OntologyChangeException
	{
		MapsToIndividual toIndividual = eClassifier.getInstanceClass().getAnnotation(MapsToIndividual.class);

		if (toIndividual != null)
		{
			Collection<Object> r = new BasicEList<>();
			for (OntologyIndividual i : getClass(toIndividual.iri()).getIndividuals(false))
				r.add(deserialize(eClassifier, eFactory, i));

			return r;
		}
		else
			throw new NoSuchEntityException("Unable to deserialize the object");
	}

	/**
	 * Deserializes a Java object from the ontology. The java classes must have been annotated with the right annotations. This method is
	 * recursive and will try to pull out also all the referred objects from the ontology. This method will also check for duplicates, that
	 * is the same object cannot be extracted twice from the ontology.
	 * @param eClassifier
	 *            The Java class whose objects must be deserialized.
	 * @param individual
	 *            The individual to deserialize.
	 * @param eFactory
	 *            The EFactory to use or <code>null</code> if no EFactory should be used.
	 * @return The extracted objects.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	private Object deserialize(EClassifier eClassifier, EFactory eFactory, OntologyIndividual individual)
			throws NoSuchEntityException, InstantiationException, IllegalAccessException, InconsistencyException,
			ReasoningInterruptedException, ParsingErrorException, ClassNotFoundException, IOException, OntologyChangeException
	{
		Class<?> clazz = eClassifier.getInstanceClass();
		MapsToIndividual toIndividual = clazz.getAnnotation(MapsToIndividual.class);

		if (toIndividual != null)
		{
			if (deserializedObjects.containsKey(individual))
				return deserializedObjects.get(individual);

			if (eClassifier instanceof EClass)
			{
				EObject object = eFactory.create((EClass) eClassifier);
				EClass eClass = (EClass) eClassifier;
				deserializedObjects.put(individual, object);

				for (MapsToDataProperty i : toIndividual.dataProperties())
					deserializeProperty(eClass, eFactory, individual, object, i);
				for (MapsToObjectProperty i : toIndividual.objectProperties())
					deserializeProperty(eClass, eFactory, individual, object, i);
				for (MapsToDataList i : toIndividual.dataLists())
					deserializeProperty(eClass, eFactory, individual, object, i);
				for (MapsToObjectList i : toIndividual.objectLists())
					deserializeProperty(eClass, eFactory, individual, object, i);

				serializedObjects.put(object, individual.getIRI());
				updateCounters(individual);

				return object;
			}
			else if (eClassifier instanceof EEnum)
			{
				Enumerator object = ((EEnum) eClassifier)
						.getEEnumLiteralByLiteral(individual.getIRI().substring(toIndividual.name().length())).getInstance();
				deserializedObjects.put(individual, object);
				serializedObjects.put(object, individual.getIRI());
				updateCounters(individual);

				return object;
			}
			else
				throw new NoSuchEntityException("Unable to deserialize the object");
		}
		else
			throw new NoSuchEntityException("Unable to deserialize the object");
	}

	/**
	 * Deserializes a property value for an ontology individual.
	 * @param eClass
	 *            The Java class whose objects must be deserialized.
	 * @param individual
	 *            The individual to deserialize.
	 * @param eFactory
	 *            The EFactory to use or <code>null</code> if no EFactory should be used.
	 * @param object
	 *            The object to fill
	 * @param feature
	 *            The feature to analyze.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	public void deserializeProperty(EClass eClass, EFactory eFactory, OntologyIndividual individual, EObject object, int feature)
			throws InconsistencyException, NoSuchEntityException, ReasoningInterruptedException, ClassNotFoundException, IOException,
			InstantiationException, IllegalAccessException, ParsingErrorException, OntologyChangeException
	{
		Class<?> clazz = eClass.getInstanceClass();
		MapsToIndividual toIndividual = clazz.getAnnotation(MapsToIndividual.class);

		if (toIndividual != null)
		{
			deserializedObjects.put(individual, object);

			for (MapsToDataProperty i : toIndividual.dataProperties())
				if (i.id() == feature)
				{
					deserializeProperty(eClass, eFactory, individual, object, i);
					return;
				}
			for (MapsToObjectProperty i : toIndividual.objectProperties())
				if (i.id() == feature)
				{
					deserializeProperty(eClass, eFactory, individual, object, i);
					return;
				}
			for (MapsToDataList i : toIndividual.dataLists())
				if (i.id() == feature)
				{
					deserializeProperty(eClass, eFactory, individual, object, i);
					return;
				}
			for (MapsToObjectList i : toIndividual.objectLists())
				if (i.id() == feature)
				{
					deserializeProperty(eClass, eFactory, individual, object, i);
					return;
				}

			serializedObjects.put(object, individual.getIRI());
		}
		else
			throw new NoSuchEntityException("Unable to deserialize the object");
	}

	/**
	 * Deserializes a property value for an ontology individual.
	 * @param eClass
	 *            The Java class whose objects must be deserialized.
	 * @param individual
	 *            The individual to deserialize.
	 * @param eFactory
	 *            The EFactory to use or <code>null</code> if no EFactory should be used.
	 * @param object
	 *            The object to fill
	 * @param annotation
	 *            The annotation to analyze.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 **/
	@SuppressWarnings("unchecked")
	private void deserializeProperty(EClass eClass, EFactory eFactory, OntologyIndividual individual, EObject object, Annotation annotation)
			throws InconsistencyException, NoSuchEntityException, ReasoningInterruptedException, ClassNotFoundException, IOException,
			InstantiationException, IllegalAccessException, ParsingErrorException, OntologyChangeException
	{
		int id = 0;
		String iri = null;
		String startIri = null;
		String nextIri = null;
		String propertyIri = null;
		if (annotation instanceof MapsToDataProperty)
		{
			id = ((MapsToDataProperty) annotation).id();
			iri = ((MapsToDataProperty) annotation).iri();
		}
		else if (annotation instanceof MapsToObjectProperty)
		{
			id = ((MapsToObjectProperty) annotation).id();
			iri = ((MapsToObjectProperty) annotation).iri();
		}
		else if (annotation instanceof MapsToDataList)
		{
			id = ((MapsToDataList) annotation).id();
			startIri = ((MapsToDataList) annotation).startIri();
			nextIri = ((MapsToDataList) annotation).nextIri();
			propertyIri = ((MapsToDataList) annotation).propertyIri();
		}
		else if (annotation instanceof MapsToObjectList)
		{
			id = ((MapsToObjectList) annotation).id();
			startIri = ((MapsToObjectList) annotation).startIri();
			nextIri = ((MapsToObjectList) annotation).nextIri();
			propertyIri = ((MapsToObjectList) annotation).propertyIri();
		}

		EStructuralFeature feature = eClass.getEStructuralFeature(id);
		Class<?> type = feature.getEType().getInstanceClass();

		if (feature.isMany())
		{
			EList<Object> collection = (EList<Object>) object.eGet(feature);

			if (annotation instanceof MapsToDataProperty)
				for (Object j : individual.getDataPropertyValues(iri, type))
					collection.add(j);
			else if (annotation instanceof MapsToObjectProperty)
				for (OntologyIndividual j : individual.getObjectPropertyValues(iri))
					collection.add(deserialize(getDeserializationClass(eFactory, j), eFactory, j));
			else if (annotation instanceof MapsToDataList)
				for (OntologyIndividual j = individual.getObjectPropertyValue(startIri); j != null; j = j.getObjectPropertyValue(nextIri))
					collection.add(j.getDataPropertyValue(propertyIri, type));
			else if (annotation instanceof MapsToObjectList)
				for (OntologyIndividual j = individual.getObjectPropertyValue(startIri); j != null; j = j.getObjectPropertyValue(nextIri))
				{
					OntologyIndividual t = j.getObjectPropertyValue(propertyIri);
					Object v = deserialize(getDeserializationClass(eFactory, t), eFactory, t);
					collection.add(v);
				}
		}
		else
		{
			if (annotation instanceof MapsToDataProperty)
				for (Object j : individual.getDataPropertyValues(iri, type))
					object.eSet(feature, j);
			else if (annotation instanceof MapsToObjectProperty)
				for (OntologyIndividual j : individual.getObjectPropertyValues(iri))
					object.eSet(feature, deserialize(getDeserializationClass(eFactory, j), eFactory, j));
			else if (annotation instanceof MapsToDataList)
			{
				OntologyIndividual first = individual.getObjectPropertyValue(startIri);
				object.eSet(feature, first.getDataPropertyValue(propertyIri, type));
			}
			else if (annotation instanceof MapsToObjectList)
			{
				OntologyIndividual first = individual.getObjectPropertyValue(startIri);
				OntologyIndividual t = first.getObjectPropertyValue(propertyIri);
				Object v = deserialize(getDeserializationClass(eFactory, t), eFactory, t);
				object.eSet(feature, v);
			}
		}

	}

	/**
	 * Finds the right Java class to deserialize an ontology individual.
	 * @param eFactory
	 *            The EFactory to use or <code>null</code> if no EFactory should be used.
	 * @param individual
	 *            The ontology individual to deserialize.
	 * @return The right Java class for the individual.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 **/
	private EClassifier getDeserializationClass(EFactory eFactory, OntologyIndividual individual)
			throws ParsingErrorException, NoSuchEntityException
	{
		for (EClassifier i : eFactory.getEPackage().getEClassifiers())
		{
			MapsToIndividual toIndividual = i.getInstanceClass().getAnnotation(MapsToIndividual.class);
			if (toIndividual != null && individual.isContainedInClass(toIndividual.iri()))
				return i;
		}

		throw new NoSuchEntityException("Unable to deserialize the object " + individual);
	}

	/**
	 * Retrieves the list of EMF objects in the ontology.
	 * @return The list of EMF objects in the ontology.
	 **/
	public Collection<EObject> getEObjects()
	{
		Collection<EObject> objects = new HashSet<>();

		for (Object i : serializedObjects.keySet())
			if (i instanceof EObject)
				objects.add((EObject) i);
		for (Object i : deserializedObjects.values())
			if (i instanceof EObject)
				objects.add((EObject) i);

		return objects;
	}

	/**
	 * Removes (non-recursively) a Java object in the ontology. The java object must be a bean and must have been annotated with the right
	 * annotations. This method works only for already serialized objects. If the object cannot be found, it silently fails.
	 * @param object
	 *            The Java object to remove.
	 **/
	public void remove(Object object)
	{
		OntologyIndividual individual = null;
		for (Entry<OntologyIndividual, Object> i : deserializedObjects.entrySet())
			if (i.getValue() == object)
			{
				individual = i.getKey();
				break;
			}

		if (individual != null)
		{
			individual.remove();
			serializedObjects.remove(object);
			deserializedObjects.remove(individual);
		}
	}

	/**
	 * Computes the check values for all the serialized objects in the ontology.
	 * @return The check map.
	 **/
	private Map<EObject, String> computeChecks()
	{
		Map<EObject, String> checks = new HashMap<>();

		for (EObject i : getEObjects())
		{
			MapsToIndividual annotation = null;
			for (Class<?> j : i.getClass().getInterfaces())
			{
				annotation = j.getAnnotation(MapsToIndividual.class);
				if (annotation != null)
					break;
			}
			if (annotation != null)
			{
				String value = String.valueOf(getHashCode(i));
				for (MapsToDataProperty j : annotation.dataProperties())
					value += ";" + computeChecks(i, j.id(), false);
				for (MapsToDataList j : annotation.dataLists())
					value += ";" + computeChecks(i, j.id(), true);
				for (MapsToObjectProperty j : annotation.objectProperties())
					value += ";" + computeChecks(i, j.id(), false);
				for (MapsToObjectList j : annotation.objectLists())
					value += ";" + computeChecks(i, j.id(), true);
				checks.put(i, value);
			}
		}

		return checks;
	}

	/**
	 * Computes the checks of a feature.
	 * @param object
	 *            The object.
	 * @param featureId
	 *            The feature ID.
	 * @param ordered
	 *            A value stating if the order matters or not.
	 * @return The check string.
	 **/
	private String computeChecks(EObject object, int featureId, boolean ordered)
	{
		String value = "";

		Object f = object.eGet(object.eClass().getEStructuralFeature(featureId));
		if (f == null)
			value = "<null>";
		else if (f instanceof Collection<?>)
		{
			List<Integer> hashes = new ArrayList<>();
			for (Object i : (Collection<?>) f)
				hashes.add(getHashCode(i));
			if (!ordered)
				Collections.sort(hashes);

			boolean first = true;
			for (Integer i : hashes)
				if (first)
				{
					first = false;
					value += i;
				}
				else
					value += "," + i;
		}
		else
			value = String.valueOf(getHashCode(f));

		return value;
	}

	/**
	 * Retrieves a static hash code of an object, even for the enumerations.
	 * @param object
	 *            The object.
	 * @return The static hash code of an object.
	 **/
	private int getHashCode(Object object)
	{
		if (object instanceof Enum<?> || object instanceof Integer || object instanceof Long)
			return object.toString().hashCode();
		else
			return object.hashCode();
	}

	/**
	 * Parses the check values saved in the ontology.
	 * @return The check map.
	 * @throws NoSuchEntityException
	 *             If some entity cannot be found.
	 * @throws IOException
	 *             If a property value cannot be read.
	 * @throws ReasoningInterruptedException
	 *             If the reasoner was interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ClassNotFoundException
	 *             If a class is not found.
	 **/
	private Map<EObject, String> parseChecks()
			throws NoSuchEntityException, ClassNotFoundException, InconsistencyException, ReasoningInterruptedException, IOException
	{
		Map<EObject, String> checks = new HashMap<>();

		OntologyDataProperty property;
		if (!containsDataProperty(CHECKS_PROPERTY))
			return checks;
		property = getDataProperty(CHECKS_PROPERTY);

		for (EObject i : getEObjects())
			if (serializedObjects.containsKey(i))
			{
				OntologyIndividual individual = getIndividual(serializedObjects.get(i));
				String check = individual.getDataPropertyValue(property, String.class);
				if (check != null)
					checks.put(i, check);
			}

		return checks;
	}

	/**
	 * Updates the checks in the ontology.
	 * @throws NoSuchEntityException
	 *             If the ontology individual cannot be found or created.
	 * @throws OntologyChangeException
	 *             If the ontology cannot be changed.
	 * @throws IOException
	 *             If a property statement cannot be added.
	 **/
	public void updateChecks() throws NoSuchEntityException, OntologyChangeException, IOException
	{
		OntologyDataProperty property;
		if (containsDataProperty(CHECKS_PROPERTY))
			property = getDataProperty(CHECKS_PROPERTY);
		else
			property = addDataProperty(CHECKS_PROPERTY);

		Map<EObject, String> checks = computeChecks();
		for (Entry<EObject, String> i : checks.entrySet())
			if (serializedObjects.containsKey(i.getKey()))
			{
				OntologyIndividual individual = getIndividual(serializedObjects.get(i.getKey()));
				individual.removeDataPropertyValues(property);
				individual.addDataPropertyValue(property, i.getValue());
			}
	}

	/**
	 * Verifies the the check values of the ontology.
	 * @throws NoSuchEntityException
	 *             If some entity cannot be found.
	 * @throws IOException
	 *             If a property value cannot be read.
	 * @throws ReasoningInterruptedException
	 *             If the reasoner was interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ClassNotFoundException
	 *             If a class is not found.
	 * @throws CorruptionException
	 *             If the ontology is corrupted.
	 **/
	public void verifyChecks() throws ClassNotFoundException, NoSuchEntityException, InconsistencyException, ReasoningInterruptedException,
			IOException, CorruptionException
	{
		Map<EObject, String> map = new HashMap<>();
		Map<EObject, String> parsedChecks = parseChecks();
		Map<EObject, String> modelChecks = computeChecks();

		for (Entry<EObject, String> i : parsedChecks.entrySet())
			if (modelChecks.containsKey(i.getKey()))
			{
				String parsedCheck = i.getValue();
				String modelCheck = modelChecks.get(i.getKey());
				if (!parsedCheck.equals(modelCheck))
					map.put(i.getKey(), modelCheck);
			}

		if (!map.isEmpty())
			throw new CorruptionException("The ontology is corrupted", map);
	}

	/** The Manchester syntax class parser. **/
	ManchesterOWLSyntaxClassExpressionParser classParser;
	/** The ontology data factory. **/
	protected OWLDataFactory dataFactory;
	/** The entity checker. **/
	protected OWLEntityChecker entityChecker;
	/** The ontology itself. **/
	protected OWLOntology ontology;
	/** The ontology manager. **/
	protected OWLOntologyManager ontologyManager;
	/** The SPARQL-DL query engine. */
	private QueryEngine queryEngine;
	/** The SPARQL-DL query parser. **/
	private QueryParser queryParser;
	/** The query tokenizer. **/
	private QueryTokenizer queryTokenizer;
	/** The ontology reasoner. **/
	protected OWLReasoner reasoner = null;
	/** The reasoner factory. **/
	private OWLReasonerFactory reasonerFactory;
	/** The reasoner type. **/
	protected ReasonerType reasonerType;
	/** The entity remover. **/
	protected OWLEntityRemover remover;
	/** The entity renamer. **/
	protected OWLEntityRenamer renamer;
	/** The serialized objects map. **/
	private Map<Object, String> serializedObjects;
	/** The deserialized objects map. **/
	private Map<OntologyIndividual, Object> deserializedObjects;
	/** The prefix counters map. **/
	private Map<String, Long> prefixCounters;
}
