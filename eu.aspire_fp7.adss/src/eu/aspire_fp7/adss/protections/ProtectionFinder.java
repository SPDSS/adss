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
package eu.aspire_fp7.adss.protections;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackPath;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.AttackStepType;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionFlag;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.util.Collections;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * Finds the protections and their relative data.
 * @author Daniele Canavese
 **/
public class ProtectionFinder
{
	/** The ADSS. **/
	private final ADSS adss;

	/**
	 * Creates the finder.
	 * @param adss
	 *            The ADSS.
	 **/
	public ProtectionFinder(ADSS adss)
	{
		this.adss = adss;
	}

	/**
	 * Runs the protection deduction phase and computes all the relevant data.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 **/
	public void run() throws InstantiationException, IllegalAccessException, ClassNotFoundException, OntologyChangeException,
			ParsingErrorException, NoSuchEntityException, IOException, InconsistencyException, ReasoningInterruptedException
	{
		log.info("Inferring the protections...");

		long start = System.currentTimeMillis();
		inferDirectMitigations();
		inferIndirectMitigations();
		inferAppliedProtectionInstantiations();
		long stop = System.currentTimeMillis();

		log.info(String.format("Protections inferred = %d protections, %d PIs, %d applied PIs, %.3f s",
				adss.getModel().getProtectionsCount(), adss.getModel().getProtectionInstantiationsCount(),
				adss.getModel().getAppliedProtectionInstantiationsCount(), (stop - start) / 1000.0f));
	}

	/**
	 * Infers the applied protection instantiations.
	 **/
	private void inferAppliedProtectionInstantiations()
	{
		Set<ApplicationPart> parts = new HashSet<>();

		for (ProtectionObjective i : adss.getModel().getProtectionObjectives())
			parts.add(i.getApplicationPart());

		Level minimumLevel = adss.getModel().getPreferences().getProtectionsMinimumAttackMitigation();
		Level mitigationLevel = Level.HIGH;
		while (mitigationLevel != null)
		{
			for (Protection i : adss.getModel().getAvailableProtections())
				if (i.isAutomaticallyDeployable())
					for (ProtectionInstantiation j : i.getInstantiations())
						for (ApplicationPart k : parts)
							addAppliedProtectionInstantiation(j, k, mitigationLevel);

			if (mitigationLevel == minimumLevel)
				break;
			else if (mitigationLevel == Level.HIGH)
				mitigationLevel = Level.MEDIUM;
			else if (mitigationLevel == Level.MEDIUM)
				mitigationLevel = Level.LOW;
			else
				mitigationLevel = null;
		}

		HashSet<ProtectionObjective> pos = new HashSet<>();
		pos.addAll(adss.getModel().getProtectionObjectives());
		for (AppliedProtectionInstantiation i : adss.getModel().getAppliedProtectionInstantiations())
			pos.removeAll(i.getProtectionObjectives());

		if (!pos.isEmpty())
			log.severe("Unprotectable POs = " + pos);
	}

	/**
	 * Adds an applied protection instantiation, if needed.
	 * @param pi
	 *            The protection instantiation.
	 * @param part
	 *            The application part.
	 * @param mitigationLevel
	 *            The required mitigation level.
	 **/
	private void addAppliedProtectionInstantiation(ProtectionInstantiation pi, ApplicationPart part, Level mitigationLevel)
	{
		// Skips if the application part type is incompatible.
		if (!pi.getProtection().getApplicationPartTypes().contains(part.getType()))
			return;
		// Skips if some special requirements are not met.
		if (!checkRequirements(pi, part))
			return;

		AppliedProtectionInstantiation appliedProtectionInstantiation = getAppliedPI(pi, part);

		for (AttackMitigation i : pi.getProtection().getMitigations())
			if (i.getLevel() == mitigationLevel)
				for (AttackPath k : i.getAttackPaths())
					for (ProtectionObjective l : k.getProtectionObjectives())
						if (part.equals(l.getApplicationPart())
								&& pi.getProtection().getEnforcedSecurityRequirements().contains(l.getProperty()))
						{
							Collections.addUnique(appliedProtectionInstantiation.getAttackMitigations(), i);
							Collections.addUnique(appliedProtectionInstantiation.getProtectionObjectives(), l);
							Collections.addUnique(k.getAppliedProtectionInstantiations(), appliedProtectionInstantiation);
						}

		if (!appliedProtectionInstantiation.getProtectionObjectives().isEmpty())
			Collections.addUnique(adss.getModel().getAppliedProtectionInstantiations(), appliedProtectionInstantiation);
	}

	/**
	 * Finds an already existing applied protection instantiation or create a new one if it does not exist.
	 * @param pi
	 *            The protection instantiation.
	 * @param part
	 *            The application part.
	 * @return The applied protection instantiation.
	 **/
	AppliedProtectionInstantiation getAppliedPI(ProtectionInstantiation pi, ApplicationPart part)
	{
		for (AppliedProtectionInstantiation i : adss.getModel().getAppliedProtectionInstantiations())
			if (i.getProtectionInstantiation().equals(pi) && i.getApplicationPart().equals(part))
				return i;

		AppliedProtectionInstantiation appliedProtectionInstantiation;
		appliedProtectionInstantiation = AkbFactory.eINSTANCE.createAppliedProtectionInstantiation();
		appliedProtectionInstantiation.setProtectionInstantiation(pi);
		appliedProtectionInstantiation.setApplicationPart(part);

		return appliedProtectionInstantiation;
	}

	/**
	 * Performs some additional checks for a potential applied protection instantiation.
	 * @param pi
	 *            The protection instantiation to check.
	 * @param part
	 *            The application part where the PI should be deployed.
	 * @return <code>true</code> if the applied PI is applicable, <code>false</code> otherwise.
	 **/
	private boolean checkRequirements(ProtectionInstantiation pi, ApplicationPart part)
	{
		if (pi.getProtection().getFlags().contains(ProtectionFlag.WHOLE_FUNCTION))
		{
			ApplicationPart function = part.getDeclaringCode();
			while (function.getType() != ApplicationPartType.FUNCTION)
				function = function.getDeclaringCode();
			if (part.getStartLine() > function.getBody().getStartLine() || part.getEndLine() < function.getBody().getEndLine())
				return false;
		}

		return true;
	}

	/**
	 * Infers the direct mitigations applied to the assets.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 **/
	private void inferDirectMitigations() throws OntologyChangeException, ParsingErrorException, NoSuchEntityException, IOException,
			InconsistencyException, ReasoningInterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Map<AttackStepType, Set<AttackPath>> map = new HashMap<>();

		for (AttackPath i : adss.getModel().getAttackPaths())
			for (AttackStep j : i.getAttackSteps())
			{
				Set<AttackPath> set;
				if (map.containsKey(j.getType()))
					set = map.get(j.getType());
				else
				{
					set = new HashSet<>();
					map.put(j.getType(), set);
				}
				set.add(i);
			}

		for (Protection i : adss.getModel().getAvailableProtections())
			if (!i.getInstantiations().isEmpty())
				for (AttackMitigation j : i.getMitigations())
					if (map.containsKey(j.getType()))
						for (AttackPath k : map.get(j.getType()))
							for (ProtectionObjective l : k.getProtectionObjectives())
								if (i.getApplicationPartTypes().contains(l.getApplicationPart().getType()))
								{
									j.getAttackPaths().add(k);
									break;
								}
	}

	/**
	 * Infers the indirect mitigations applied to the non-assets.
	 **/
	private void inferIndirectMitigations()
	{
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(ProtectionFinder.class.getName());
}
