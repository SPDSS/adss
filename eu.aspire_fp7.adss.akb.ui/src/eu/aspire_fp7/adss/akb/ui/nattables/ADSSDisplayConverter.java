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
package eu.aspire_fp7.adss.akb.ui.nattables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDisplayConverter;

import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.AttackMitigation;
import eu.aspire_fp7.adss.akb.AttackStep;
import eu.aspire_fp7.adss.akb.AttackerToolType;
import eu.aspire_fp7.adss.akb.Level;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionObjective;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.util.Strings;

/**
 * The display converter for the ADSS.
 * @author Daniele Canavese
 **/
public class ADSSDisplayConverter extends DefaultDisplayConverter
{
	/**
	 * Converts an object into a suitable string for visualization.
	 * @param sourceValue
	 *            The object to convert.
	 * @return The string.
	 **/
	@Override
	public Object canonicalToDisplayValue(Object sourceValue)
	{
		if (sourceValue == null)
			return "";
		else if (sourceValue instanceof String)
			return sourceValue;
		else if (sourceValue instanceof Double)
			return String.format("%.3f", (Double) sourceValue);
		else if (sourceValue instanceof Collection)
		{
			@SuppressWarnings("unchecked")
			Collection<Object> collection = (Collection<Object>) sourceValue;
			Collection<String> strings = new ArrayList<>();
			Map<Protection, Level> protections = new HashMap<>();
			String separator = ", ";

			for (Object i : collection)
				if (i instanceof Property)
				{
					Property property = (Property) i;
					strings.add(getName(property));
				}
				else if (i instanceof AttackerToolType)
				{
					AttackerToolType type = (AttackerToolType) i;
					strings.add(type.getName());
				}
				else if (i instanceof ProtectionObjective)
				{
					ProtectionObjective po = (ProtectionObjective) i;
					strings.add(po.toString());
					separator = "\n";
				}
				else if (i instanceof AttackStep)
				{
					AttackStep step = (AttackStep) i;
					strings.add(step.getName());
					separator = "\n";
				}
				else if (i instanceof AttackMitigation)
				{
					AttackMitigation mitigation = (AttackMitigation) i;
					Protection protection = (Protection) mitigation.eContainer();
					Level level;
					if (protections.containsKey(protection))
					{
						level = protections.get(protection);
						if (level == Level.LOW)
							level = mitigation.getLevel();
						else if (level == Level.MEDIUM && mitigation.getLevel() == Level.HIGH)
							level = Level.HIGH;
					}
					else
						level = mitigation.getLevel();
					protections.put(protection, level);
					separator = "\n";
				}
				else if (i instanceof SolutionSequence)
				{
					SolutionSequence sequence = (SolutionSequence) i;
					strings.add(Strings.join(sequence.getAppliedProtectionInstantiations(), "\n"));
					separator = "\n\n";
				}

			for (Entry<Protection, Level> i : protections.entrySet())
				strings.add(i.getKey().getName() + " <" + i.getValue().toString() + "/>");

			return Strings.join(strings, separator);
		}
		else if (sourceValue instanceof ApplicationPartType)
		{
			ApplicationPartType type = (ApplicationPartType) sourceValue;
			if (type == ApplicationPartType.CODE_REGION)
				return "code region";
			else if (type == ApplicationPartType.FUNCTION)
				return "function";
			else if (type == ApplicationPartType.CRYPTOGRAPHIC_KEY)
				return "cryptographic key";
			else if (type == ApplicationPartType.INITIALIZATION_VECTOR)
				return "initialization vector";
			else if (type == ApplicationPartType.PLAINTEXT)
				return "plaintext";
			else if (type == ApplicationPartType.CIPHERTEXT)
				return "ciphertext";
			else if (type == ApplicationPartType.INTEGER_ARRAY_DATUM)
				return "integer array";
			else if (type == ApplicationPartType.INTEGER_DATUM)
				return "integer";
			else if (type == ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM)
				return "static integer array";
			else if (type == ApplicationPartType.PARAMETER)
				return "parameter";
			else if (type == ApplicationPartType.REFERENCE)
				return "reference";
			else if (type == ApplicationPartType.GENERIC_VARIABLE)
				return "generic variable";
			else
				return "unknown";
		}
		else if (sourceValue instanceof Level)
		{
			Level level = (Level) sourceValue;
			if (level == Level.HIGH)
				return "high";
			else if (level == Level.MEDIUM)
				return "medium";
			else if (level == Level.LOW)
				return "low";
			else
				return "unblockable";
		}
		else
			return sourceValue.toString();
	}

	/**
	 * Retrieves the name of a property.
	 * @param property
	 *            The property.
	 * @return The property name.
	 **/
	private String getName(Property property)
	{
		if (property == Property.CONFIDENTIALITY)
			return "confidentiality";
		else if (property == Property.HARDCONFIDENTIALITY)
			return "hard confidentiality";
		else if (property == Property.HARDCODED)
			return "hardcoded";
		else if (property == Property.INTEGRITY)
			return "integrity";
		else
			return "privacy";
	}
}
