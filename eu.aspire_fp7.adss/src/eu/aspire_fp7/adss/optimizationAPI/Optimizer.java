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
package eu.aspire_fp7.adss.optimizationAPI;

/**
 * Interface to an external optimization program, must be implemented with the actual API methods of the specific optimization program.
 * @author Leonardo Regano
 *
 */
public interface Optimizer {

	public void exportModel(String lpFile) throws OptimizerException;
	
	/**
	 * Creates the objective function. 
	 * @param isMaximize
	 *               If true, a maximization objective function is created, otherwise a minimization objective function is created.
	 * @return The generated objective function.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object createObjectiveFunction(Boolean isMaximize) throws OptimizerException;
	
	/**
	 * For an integer problem, sets the number of integer solutions to find before stopping the optimization process.
	 * @param solutionLimit
	 *                  The number of integer solutions.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public void setIntegerSolutionLimit(Integer solutionLimit) throws OptimizerException;
	
	/**
	 * Sets a time limit in seconds, which expiration triggers the stopping of the execution of the optimization process.
	 * @param second
	 *           The number of seconds.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public void setTimeLimit(Integer second) throws OptimizerException;
	
	/**
	 * For an integer problem, sets the percentage gap, between the best feasible integer solution and the best possible solution, that must be reached before stopping the execution of the optimization process.
	 * @param gap The percentage gap between the best feasible solution (BFS) and the best possible solution (BPS), calculated as (100*|BPS-BFS|)/(|BFS|).
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public void setGapLimit(Double gap) throws OptimizerException;
	
	/**
	 * Starts the execution of the optimization process.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public void solve() throws OptimizerException;
	
	/**
	 * Generates a generic (real) variable.
	 * @param lowerBound
	 *               The lower bound of the variable.
	 * @param upperBound 
	 *               The upper bound of the variable.
	 * @param name
	 *               The variable name.
	 * @return The generated variable.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object generateVariable(Double lowerBound, Double upperBound, String name) throws OptimizerException;
	
	/**
	 * Generates an integer variable.
	 * @param lowerBound
	 *               The lower bound of the variable.
	 * @param upperBound 
	 *               The upper bound of the variable.
	 * @param name
	 *               The variable name.
	 * @return The generated variable.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object generateIntegerVariable(Integer lowerBound, Integer upperBound, String name) throws OptimizerException;
	
	/**
	 * Generates an empty expression.
	 * @return The generated expression.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object generateExpression() throws OptimizerException;
	
	/**
	 * Generates a boolean variable.
	 * @param name
	 *           The variable name.
	 * @return The generated variable.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object generateBooleanVariable(String name) throws OptimizerException;
	
	/**
	 * Returns the value assumed by the specified variable in the specified solution. 
	 * @param variable
	 *             The variable of which the value must be returned.
	 * @return The variable value.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Double getVariableValue(Object variable) throws OptimizerException; 
	
	/**
	 * Returns the value of the objective function for the specified solution.
	 * @return The objective function value.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Double getObjectiveValue() throws OptimizerException;
	
	/**
	 * Adds an expression to another one; the target expression may be an objective function, or a ranged constraint (in this case the addedExpression is added to expression contained in the constraint).
	 * @param expression The expression to which the addedExpression must added.
	 * @param addedExpression The expression that must be added.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public void addToExpression(Object expression, Object addedExpression) throws OptimizerException;
	
	/**
	 * Adds to the model a less or equal constraint, i.e. expression<=constant. 
	 * @param expression
	 *               The expression.
	 * @param constant
	 *               The constant.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object addLeConstraint(Object expression, Double constant, String name) throws OptimizerException;
	
	/**
	 * Adds to the model a less or equal constraint, i.e. expression1<=expression2. 
	 * @param expression1
	 *               The first expression.
	 * @param expression2
	 *               The second expression.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object addLeConstraint(Object expression1, Object expression2, String name) throws OptimizerException;
	
	/**
	 * Adds to the model a equal constraint, i.e. expression=constant. 
	 * @param expression
	 *               The expression.
	 * @param constant
	 *               The constant.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object addEqConstraint(Object expression, Double constant, String name) throws OptimizerException;
	
	/**
	 * Adds to the model a greater or equal constraint, i.e. expression>=constant. 
	 * @param expression
	 *               The expression.
	 * @param constant
	 *               The constant.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object addGeConstraint(Object expression, Double constant, String name) throws OptimizerException;
	
	/**
	 * Adds to the model a range constraint, such as lowerBound<=expression<=higherBound. 
	 * @param expression
	 *               The expression.
	 * @param lowerBound
	 *               The lower bound of the range.
	 * @param higherBound
	 *               The higher bound of the range.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object addRangeConstraint(Double lowerBound, Object expression, Double upperBound, String name) throws OptimizerException;
	
	/**
	 * Creates (without adding to the model) a less or equal constraint, i.e. expression<=constant. 
	 * @param expression
	 *               The expression.
	 * @param constant
	 *               The constant.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object createLeConstraint(Object expression, Double constant, String name) throws OptimizerException;
	
	/**
	 * Creates (without adding to the model) a less or equal constraint, i.e. expression1<=expression2. 
	 * @param expression1
	 *               The first expression.
	 * @param expression2
	 *               The second expression.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object createLeConstraint(Object expression1, Object expression2, String name) throws OptimizerException;
	
	/**
	 * Creates (without adding to the model) a equal constraint, i.e. expression=constant. 
	 * @param expression
	 *               The expression.
	 * @param constant
	 *               The constant.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object createEqConstraint(Object expression, Double constant, String name) throws OptimizerException;
	
	/**
	 * Creates (without adding to the model) a greater or equal constraint, i.e. expression>=constant. 
	 * @param expression
	 *               The expression.
	 * @param constant
	 *               The constant.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object createGeConstraint(Object expression, Double constant, String name) throws OptimizerException;
	
	/**
	 *Creates (without adding to the model) a range constraint, such as lowerBound<=expression<=higherBound. 
	 * @param expression
	 *               The expression.
	 * @param lowerBound
	 *               The lower bound of the range.
	 * @param higherBound
	 *               The higher bound of the range.
	 * @param name
	 *               The name of the constraint.
	 * @return The generated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object createRangeConstraint(Double lowerBound, Object expression, Double upperBound, String name) throws OptimizerException;
	
	/**
	 * Adds to the model the constraints in the passed vector.
	 * @param objects
	 *            The vector of objects.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public void addConstraints(Object[] constraints) throws OptimizerException;
	
	/**
	 * Returns the sum of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object sum(Object arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the sum of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object sum(Integer arg1, Object arg2) throws OptimizerException;

	/**
	 * Returns the sum of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object sum(Object arg1, Integer arg2) throws OptimizerException;

	/**
	 * Returns the sum of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object sum(Double arg1, Object arg2) throws OptimizerException;

	/**
	 * Returns the sum of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object sum(Object arg1, Double arg2) throws OptimizerException;
	
	/**
	 * Returns the sum of the object in the passed array.
	 * @param array The array containing the object to sum.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object sum(Object[] array) throws OptimizerException;
	
	/**
	 * Returns the product of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the product.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object prod(Object arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the product of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the product.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object prod(Double arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the scalar product of an array of constants and an array of variables.
	 * @param arg1 The array of constants.
	 * @param arg2 The array of variables.
	 * @return The result of the scalar product.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object scalProd(double[] arg1, Object[] arg2) throws OptimizerException;
	
	/**
	 * Returns the scalar product of an array of constants and an array of variables.
	 * @param arg1 The array of constants.
	 * @param arg2 The array of variables.
	 * @return The result of the scalar product.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object scalProd(int[] arg1, Object[] arg2) throws OptimizerException;
	
	/**
	 * Returns the product of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the product.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object prod(Integer arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the difference of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the difference.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object diff(Object arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the difference of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the difference.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object diff(Integer arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the difference of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the difference.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object diff(Object arg1, Integer arg2) throws OptimizerException;
	
	/**
	 * Returns the difference of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the difference.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object diff(Double arg1, Object arg2) throws OptimizerException;
	
	/**
	 * Returns the difference of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the difference.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object diff(Object arg1, Double arg2) throws OptimizerException;
	
	
	/**
	 * Returns a constraint expressing the logic and of the two passed constraints.
	 * @param constr1 The first constraint.
	 * @param constr2 The second constraint.
	 * @param name The name of the resulting constraint.
	 * @return The result of the and.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object and(Object constr1, Object constr2, String name) throws OptimizerException;
	
	/**
	 * Returns a constraint expressing the logic or of the two passed constraints.
	 * @param constr1 The first constraint.
	 * @param constr2 The second constraint.
	 * @param name The name of the resulting constraint.
	 * @return The result of the or.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object or(Object constr1, Object constr2, String name) throws OptimizerException;
	
	/**
	 * Returns a constraint expressing the logic not of two passed constraint.
	 * @param constr The constraint.
	 * @param name The name of the resulting constraint.
	 * @return The negated constraint.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object not(Object constr, String name) throws OptimizerException;
	
	/**
	 * Returns a constraint expressing the logic condition that if constr1 is true, also constr2 must be true (but not necessarily the viceversa).
	 * @param constr1 The if constraint.
	 * @param constr2 The then constraint.
	 * @param name The name of the resulting constraint.
	 * @return The constraint expressing the if-then logic condition.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object ifThen(Object constr1, Object constr2, String name) throws OptimizerException;

	
	/**
	 * Returns the sum of the two passed argument.
	 * @param arg1 The first argument.
	 * @param arg2 The second argument.
	 * @return The result of the sum.
	 * @throws OptimizerException Thrown if an exception is raised by a method of the specific optimization program API; the exception embeds the message of the original exception.
	 */
	public Object addSOS1(Object[] vars, double[] weights, String name) throws OptimizerException;
}
