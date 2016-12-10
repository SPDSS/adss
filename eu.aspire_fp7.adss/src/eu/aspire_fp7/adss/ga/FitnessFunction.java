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
package eu.aspire_fp7.adss.ga;

import java.util.List;

/**
 * The fitness function for a genetic algorithm.<br/>
 * As a rule of thumb, the higher the fitness value the better a chromosome is.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public interface FitnessFunction<T>
{
	/**
	 * Retrieves the fitness of a chrommosome.
	 * @param chromosome
	 *            The chromosome to evaluate.
	 * @return The fitness of the chromosome.
	 **/
	public double evaluate(List<List<T>> chromosome);
}
