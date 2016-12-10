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
package eu.aspire_fp7.adss.akb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;

import eu.aspire_fp7.adss.util.Eclipse;
import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.exceptions.CorruptionException;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.OntologyCreationException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * The AKB utility class.
 * @author dani
 *
 */
public class AKBUtil
{
	/**
	 * The private constructor.
	 **/
	private AKBUtil()
	{
	}

	/**
	 * Loads the OWL ontology into the EMF model.
	 * @param file
	 *            The ontology file to load.
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
	 *             If an axiom cannot be added.
	 * @throws CoreException
	 *             If the ontology cannot be loaded.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be created.
	 * @throws CorruptionException
	 *             If the ontology is corrupted.
	 **/
	static public Model loadFromOntology(IFile file) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchEntityException, InconsistencyException, ReasoningInterruptedException, ParsingErrorException, IOException,
			OntologyChangeException, OntologyCreationException, CoreException, CorruptionException
	{
		Ontology ontology = new Ontology(file.getContents(), ReasonerType.HERMIT);
		Model model = AkbFactory.eINSTANCE.createModel();
		model.setPreferences(AkbFactory.eINSTANCE.createPreferences());
		model.setOntology(ontology);

		List<ApplicationPart> applicationParts = new ArrayList<>();
		for (Object i : ontology.deserialize(AkbPackage.Literals.APPLICATION_PART, AkbFactory.eINSTANCE))
			applicationParts.add((ApplicationPart) i);
		// Adds only the non included application parts as first level application parts.
		for (ApplicationPart i : applicationParts)
			if (i.eContainer() == null && !i.getName().isEmpty())
				model.getApplicationParts().add(i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.APPLICATION_PART_SET, AkbFactory.eINSTANCE))
			model.getApplicationPartSets().add((ApplicationPartSet) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.ATTACKER, AkbFactory.eINSTANCE))
			model.setAttacker((Attacker) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.ATTACKER_TOOL_TYPE, AkbFactory.eINSTANCE))
			model.getAttackerToolTypes().add((AttackerToolType) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.ATTACKER_TOOL, AkbFactory.eINSTANCE))
			model.getAttackerTools().add((AttackerTool) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.PROTECTION, AkbFactory.eINSTANCE))
			model.getProtections().add((Protection) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.PROTECTION_OBJECTIVE, AkbFactory.eINSTANCE))
			model.getProtectionObjectives().add((ProtectionObjective) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.APPLIED_PROTECTION_INSTANTIATION, AkbFactory.eINSTANCE))
			model.getAppliedProtectionInstantiations().add((AppliedProtectionInstantiation) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.ATTACK_STEP_TYPE, AkbFactory.eINSTANCE))
			model.getAttackStepTypes().add((AttackStepType) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.ATTACK_STEP, AkbFactory.eINSTANCE))
			model.getAttackSteps().add((AttackStep) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.ATTACK_PATH, AkbFactory.eINSTANCE))
			model.getAttackPaths().add((AttackPath) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.PREFERENCES, AkbFactory.eINSTANCE))
			model.setPreferences((Preferences) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.RULE, AkbFactory.eINSTANCE))
			model.getRules().add((Rule) i);
		for (Object i : ontology.deserialize(AkbPackage.Literals.SOLUTION, AkbFactory.eINSTANCE))
			if (((Solution) i).getSolutionSequences().isEmpty())
				model.setVanillaSolution((Solution) i);
			else
				model.getSolutions().add((Solution) i);

		try
		{
			ontology.verifyChecks();
		}
		catch (CorruptionException e)
		{
			System.err.println(e.getMap().size() + " corrupted objects on " + ontology.getEObjects().size());
			for (Entry<EObject, String> i : e.getMap().entrySet())
				System.err.println("Object: " + i.getKey() + "\n\tClass: " + i.getKey().getClass() + "\n\tComputed check: " + i.getValue());

			// throw e;
		}

		return model;
	}

	/**
	 * Stores the EMF model into the OWL ontology.
	 * @param model
	 *            The AKB model.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.new
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws CoreException
	 *             If the ontology cannot be loaded.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be created.
	 **/
	static public void saveIntoOntology(Model model) throws OntologyChangeException, ParsingErrorException, NoSuchEntityException,
			IOException, InconsistencyException, ReasoningInterruptedException, OntologyCreationException, CoreException
	{
		Ontology ontology = model.getOntology();

		// Adds the new objects.
		for (ApplicationPart i : model.getApplicationParts())
			ontology.serialize(i);
		for (ApplicationPartSet i : model.getApplicationPartSets())
			ontology.serialize(i);
		ontology.serialize(model.getAttacker());
		for (AttackerToolType i : model.getAttackerToolTypes())
			ontology.serialize(i);
		for (AttackerTool i : model.getAttackerTools())
			ontology.serialize(i);
		for (Protection i : model.getProtections())
			ontology.serialize(i);
		for (ProtectionObjective i : model.getProtectionObjectives())
			ontology.serialize(i);
		for (AppliedProtectionInstantiation i : model.getAppliedProtectionInstantiations())
			ontology.serialize(i);
		for (AttackStepType i : model.getAttackStepTypes())
			ontology.serialize(i);
		for (AttackStep i : model.getAttackSteps())
			ontology.serialize(i);
		for (AttackPath i : model.getAttackPaths())
			ontology.serialize(i);
		ontology.serialize(model.getPreferences());
		for (Rule i : model.getRules())
			ontology.serialize(i);
		if(model.getVanillaSolution()!=null)
			ontology.serialize(model.getVanillaSolution());
		for (Solution i : model.getSolutions())
			ontology.serialize(i);
		ontology.flush();

		// Removes the orphan objects.
		Collection<EObject> saved = ontology.getEObjects();
		Collection<EObject> actual = getAllObjects(model);
		Collection<EObject> delta = new HashSet<>();
		delta.addAll(saved);
		delta.removeAll(actual);
		for (EObject i : delta)
			ontology.remove(i);
		ontology.flush();

		// Saves the checks.
		ontology.updateChecks();
		ontology.flush();
	}

	/**
	 * Retrieves all the EMF objects contained/referenced to another EMF object.
	 * @param object
	 *            The object.
	 * @return All the referenced/contained EMF objects.
	 **/
	private static Collection<EObject> getAllObjects(EObject object)
	{
		return getAllObjects(object, new HashSet<>());
	}

	/**
	 * Retrieves all the EMF objects contained/referenced to another EMF object.
	 * @param object
	 *            The object.
	 * @param analyzed
	 *            The objects analyzed so far.
	 * @return All the referenced/contained EMF objects.
	 **/
	private static Collection<EObject> getAllObjects(EObject object, Collection<Object> analyzed)
	{
		Collection<EObject> objects = new HashSet<>();

		if (analyzed.contains(object))
			return objects;

		Collection<EObject> internal = new HashSet<>();
		internal.addAll(object.eContents());
		internal.addAll(object.eCrossReferences());
		objects.add(object);
		analyzed.add(object);

		for (EObject i : internal)
			objects.addAll(getAllObjects(i, analyzed));

		return objects;
	}

	/**
	 * Creates a new empty ontology.
	 * @param preferences
	 *            The preferences to set or <code>null</code> to use the default ones.
	 * @return The ontology.
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
	 *             If an axiom cannot be added.
	 * @throws CoreException
	 *             If the ontology cannot be loaded.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be created.
	 **/
	static public Ontology createEmptyOntology(Preferences preferences) throws IOException, OntologyCreationException, CoreException,
			OntologyChangeException, ParsingErrorException, NoSuchEntityException, InconsistencyException, ReasoningInterruptedException
	{
		// First locates all the sub-ontologies.
		Collection<InputStream> streams = new ArrayList<>();

		for (IConfigurationElement i : Eclipse.getExtensions(Activator.ONTOLOGIES_ID))
		{
			String pluginId = i.getDeclaringExtension().getNamespaceIdentifier();
			String owlFile = i.getAttribute("owlFile");
			URL url = new URL("platform:/plugin/" + pluginId + "/" + owlFile);
			streams.add(url.openConnection().getInputStream());
		}

		Ontology ontology = new Ontology("http://www.aspire-fp7.eu/akb/akb.owl", ReasonerType.PELLET, streams);

		// Then sets some default values.
		ontology.serialize(AkbFactory.eINSTANCE.createAttacker());
		if (preferences == null)
			preferences = AkbFactory.eINSTANCE.createPreferences();

		// NAGRA
		FunctionDeclaration f1 = AkbFactory.eINSTANCE.createFunctionDeclaration();
		f1.setName("EVP_DecryptUpdate");
		f1.getParameters().add(ApplicationPartType.IGNORE);
		f1.getParameters().add(ApplicationPartType.PLAINTEXT);
		f1.getParameters().add(ApplicationPartType.IGNORE);
		f1.getParameters().add(ApplicationPartType.CIPHERTEXT);
		f1.getParameters().add(ApplicationPartType.IGNORE);
		FunctionDeclaration f2 = AkbFactory.eINSTANCE.createFunctionDeclaration();
		f2.setName("EVP_DecryptInit_ex");
		f2.getParameters().add(ApplicationPartType.IGNORE);
		f2.getParameters().add(ApplicationPartType.IGNORE);
		f2.getParameters().add(ApplicationPartType.IGNORE);
		f2.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		f2.getParameters().add(ApplicationPartType.INITIALIZATION_VECTOR);
		Rule rule1 = AkbFactory.eINSTANCE.createRule();
		rule1.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule1.getFunctionDeclarations().add(f1);
		rule1.getFunctionDeclarations().add(f2);
		ontology.serialize(rule1);

		FunctionDeclaration f3 = AkbFactory.eINSTANCE.createFunctionDeclaration();
		f3.setName("cryptoKernelDecryptVanilla");
		f3.getParameters().add(ApplicationPartType.PLAINTEXT);
		f3.getParameters().add(ApplicationPartType.IGNORE);
		f3.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		f3.getParameters().add(ApplicationPartType.CIPHERTEXT);
		Rule rule2 = AkbFactory.eINSTANCE.createRule();
		rule2.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule2.getFunctionDeclarations().add(f3);
		ontology.serialize(rule2);

		FunctionDeclaration f4 = AkbFactory.eINSTANCE.createFunctionDeclaration();
		f4.setName("EVP_EncryptInit_ex");
		f4.getParameters().add(ApplicationPartType.IGNORE);
		f4.getParameters().add(ApplicationPartType.IGNORE);
		f4.getParameters().add(ApplicationPartType.IGNORE);
		f4.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		f4.getParameters().add(ApplicationPartType.INITIALIZATION_VECTOR);
		FunctionDeclaration f5 = AkbFactory.eINSTANCE.createFunctionDeclaration();
		f5.setName("EVP_EncryptUpdate");
		f5.getParameters().add(ApplicationPartType.IGNORE);
		f5.getParameters().add(ApplicationPartType.CIPHERTEXT);
		f5.getParameters().add(ApplicationPartType.IGNORE);
		f5.getParameters().add(ApplicationPartType.PLAINTEXT);
		f5.getParameters().add(ApplicationPartType.IGNORE);
		Rule rule3 = AkbFactory.eINSTANCE.createRule();
		rule3.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule3.getFunctionDeclarations().add(f4);
		rule3.getFunctionDeclarations().add(f5);
		ontology.serialize(rule3);

		// SFNT
		FunctionDeclaration f6 = AkbFactory.eINSTANCE.createFunctionDeclaration();
		f6.setName("int_diamante_ecb_decrypt");
		f6.getParameters().add(ApplicationPartType.CIPHERTEXT);
		f6.getParameters().add(ApplicationPartType.PLAINTEXT);
		f6.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		Rule rule4 = AkbFactory.eINSTANCE.createRule();
		rule4.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule4.getFunctionDeclarations().add(f6);
		ontology.serialize(rule4);

		ontology.serialize(preferences);
		ontology.serialize(AkbFactory.eINSTANCE.createSolution());

		return ontology;
	}
}
