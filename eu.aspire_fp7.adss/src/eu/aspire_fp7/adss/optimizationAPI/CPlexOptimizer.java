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

import ilog.concert.IloAddable;
import ilog.concert.IloConstraint;
import ilog.concert.IloException;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloObjective;
import ilog.concert.IloRange;
import ilog.cplex.IloCplex;

public class CPlexOptimizer implements Optimizer {

	IloCplex cplex;
	
	public void exportModel(String lpFile) throws OptimizerException{
		try {
			cplex.exportModel(lpFile);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	
	public CPlexOptimizer() throws OptimizerException {
		try {
			this.cplex = new IloCplex();
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	
	@Override
	public Object createObjectiveFunction(Boolean isMaximize) throws OptimizerException {
		if(isMaximize)
			try {
				return cplex.addMaximize();
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else
			try {
				return cplex.addMinimize();
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
	}

	@Override
	public void setIntegerSolutionLimit(Integer solutionLimit) throws OptimizerException {
		try {
			cplex.setParam(IloCplex.IntParam.IntSolLim, solutionLimit);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public void setTimeLimit(Integer second) throws OptimizerException {
		try {
			cplex.setParam(IloCplex.IntParam.TimeLimit, second);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public void setGapLimit(Double gap) throws OptimizerException {
		try {
			cplex.setParam(IloCplex.DoubleParam.EpGap, gap);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public void solve() throws OptimizerException {
		try {
			cplex.solve();
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object generateVariable(Double lowerBound, Double upperBound, String name) throws OptimizerException {
		try {
			return cplex.numVar(lowerBound, upperBound, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object generateIntegerVariable(Integer lowerBound, Integer upperBound, String name)
			throws OptimizerException {
		try {
			return cplex.intVar(lowerBound, upperBound, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object generateExpression() throws OptimizerException {
		try {
			return cplex.numExpr();
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object generateBooleanVariable(String name) throws OptimizerException {
		try {
			return cplex.boolVar(name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	@Override
	public Double getVariableValue(Object variable) throws OptimizerException {
		if(variable instanceof IloNumVar)
			try {
				return cplex.getValue((IloNumVar) variable);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The variable "+variable+" passed is not an instance of IloNumVar");
	}

	@Override
	public Double getObjectiveValue() throws OptimizerException {
		try {
			return cplex.getBestObjValue();
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public void addToExpression(Object expression, Object addedExpression) throws OptimizerException {
		try {
			if(expression instanceof IloRange)
				cplex.addToExpr((IloRange) expression, (IloNumExpr)addedExpression);
			else if(expression instanceof IloObjective)
				cplex.addToExpr((IloObjective) expression, (IloNumExpr)addedExpression);
			else throw new OptimizerException("The target expression is neither an objective function nor a ranged constraint");
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object addLeConstraint(Object expression, Double constant, String name) throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.addLe((IloNumExpr) expression, constant, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public Object addLeConstraint(Object expression1, Object expression2, String name) throws OptimizerException{
		if(!(expression1 instanceof IloNumExpr))
			throw new OptimizerException("The expression "+expression1+" passed is not an instance of IloNumExpr");
		if(!(expression2 instanceof IloNumExpr))
			throw new OptimizerException("The expression "+expression2+" passed is not an instance of IloNumExpr");
		try {
			return cplex.addLe((IloNumExpr) expression1, (IloNumExpr) expression2, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	
	@Override
	public Object addEqConstraint(Object expression, Double constant, String name) throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.addEq((IloNumExpr) expression, constant, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public Object addGeConstraint(Object expression, Double constant, String name) throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.addGe((IloNumExpr) expression, constant, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public Object addRangeConstraint(Double lowerBound, Object expression, Double upperBound, String name)
			throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.addRange(lowerBound, (IloNumExpr) expression, upperBound, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public Object createLeConstraint(Object expression, Double constant, String name) throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.le((IloNumExpr) expression, constant, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}
	
	@Override
	public Object createLeConstraint(Object expression1, Object expression2, String name) throws OptimizerException {
		if(!(expression1 instanceof IloNumExpr))
			throw new OptimizerException("The expression "+expression1+" passed is not an instance of IloNumExpr");
		if(!(expression2 instanceof IloNumExpr))
			throw new OptimizerException("The expression "+expression2+" passed is not an instance of IloNumExpr");
		try {
			return cplex.le((IloNumExpr)expression1, (IloNumExpr)expression2, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object createEqConstraint(Object expression, Double constant, String name) throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.eq((IloNumExpr) expression, constant, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public Object createGeConstraint(Object expression, Double constant, String name) throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.ge((IloNumExpr) expression, constant, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public Object createRangeConstraint(Double lowerBound, Object expression, Double upperBound, String name)
			throws OptimizerException {
		if(expression instanceof IloNumExpr)
			try {
				return cplex.range(lowerBound, (IloNumExpr) expression, upperBound, name);
			} catch (IloException e) {
				throw new OptimizerException(e.getMessage());
			}
		else throw new OptimizerException("The expression "+expression+" passed is not an instance of IloNumExpr");
	}

	@Override
	public void addConstraints(Object[] constraints) throws OptimizerException {
		IloAddable[] addables = new IloAddable[constraints.length];
		for(int i = 0; i<constraints.length; i++)
		{
			if(!(constraints[i] instanceof IloAddable))
				throw new OptimizerException("One of the objects "+constraints[i]+" in the passed vector is not an instance of IloAddable");
			else addables[i]=(IloAddable) constraints[i];
		}
		try {
			cplex.add(addables);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object sum(Object arg1, Object arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.sum((IloNumExpr)arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object sum(Integer arg1, Object arg2) throws OptimizerException {
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.sum(arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object sum(Object arg1, Integer arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.sum((IloNumExpr)arg1,arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object sum(Double arg1, Object arg2) throws OptimizerException {
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.sum(arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object sum(Object arg1, Double arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.sum((IloNumExpr)arg1,arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object sum(Object[] array) throws OptimizerException {
		try {
			IloNumExpr[] expr = new IloNumExpr[array.length];
			for(int i = 0; i<array.length; i++)
			{
				if(!(array[i] instanceof IloNumExpr))
					throw new OptimizerException("One of the objects "+array[i]+" in the passed vector is not an instance of IloNumExpr");
				else expr[i]=(IloNumExpr) array[i];
			}
			return cplex.sum(expr);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	
	@Override
	public Object prod(Object arg1, Object arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.prod((IloNumExpr)arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object prod(Double arg1, Object arg2) throws OptimizerException {
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.prod(arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object prod(Integer arg1, Object arg2) throws OptimizerException {
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.prod(arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	
	@Override
	public Object scalProd(double[] arg1, Object[] arg2) throws OptimizerException {
		try {
			IloNumVar[] vars = new IloNumVar[arg2.length];
			for(int i = 0; i<arg2.length; i++)
			{
				if(!(vars[i] instanceof IloNumVar))
					throw new OptimizerException("One of the objects "+vars[i]+" in the first array is not an instance of IloConstraint");
				else vars[i]=(IloNumVar) arg2[i];
			}
			return cplex.scalProd(arg1, vars);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object scalProd(int[] arg1, Object[] arg2) throws OptimizerException {
		try {
			IloNumVar[] vars = new IloNumVar[arg2.length];
			for(int i = 0; i<arg2.length; i++)
			{
				if(!(arg2[i] instanceof IloNumVar))
					throw new OptimizerException("One of the objects "+vars[i]+" in the first array is not an instance of IloNumVar or CpxNumVar");
				else vars[i]=(IloNumVar) arg2[i];
			}
			return cplex.scalProd(arg1, vars);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}
	
	@Override
	public Object diff(Object arg1, Object arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.diff((IloNumExpr)arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object diff(Integer arg1, Object arg2) throws OptimizerException {
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.diff(arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object diff(Object arg1, Integer arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.diff((IloNumExpr)arg1,arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object diff(Double arg1, Object arg2) throws OptimizerException {
		if(!(arg2 instanceof IloNumExpr))
			throw new OptimizerException("The second argument "+arg2+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.diff(arg1,(IloNumExpr)arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object diff(Object arg1, Double arg2) throws OptimizerException {
		if(!(arg1 instanceof IloNumExpr))
			throw new OptimizerException("The first argument "+arg1+" passed is not an instance of IloNumExpr");	
		try {
			return cplex.diff((IloNumExpr)arg1,arg2);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object and(Object constr1, Object constr2, String name) throws OptimizerException {
		try {
			if(!(constr1 instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr1+" passed is not an instance of IloConstraint");
			if(!(constr2 instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr2+" passed is not an instance of IloConstraint");
			return cplex.and((IloConstraint)constr1, (IloConstraint)constr2, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object or(Object constr1, Object constr2, String name) throws OptimizerException {
		try {
			if(!(constr1 instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr1+" passed is not an instance of IloConstraint");
			if(!(constr2 instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr2+" passed is not an instance of IloConstraint");
			return cplex.or((IloConstraint)constr1, (IloConstraint)constr2, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object not(Object constr, String name) throws OptimizerException {
		try {
			if(!(constr instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr+" passed is not an instance of IloConstraint");
			return cplex.not((IloConstraint)constr, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object ifThen(Object constr1, Object constr2, String name) throws OptimizerException {
		try {
			if(!(constr1 instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr1+" passed is not an instance of IloConstraint");
			if(!(constr2 instanceof IloConstraint))
				throw new OptimizerException("The first argument "+constr2+" passed is not an instance of IloConstraint");
			return cplex.ifThen((IloConstraint)constr1, (IloConstraint)constr2, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

	@Override
	public Object addSOS1(Object[] vars, double[] weights, String name) throws OptimizerException {
		try {
			IloNumVar[] vars2 = new IloNumVar[vars.length];
			for(int i = 0; i<vars.length; i++)
			{
				if(!(vars[i] instanceof IloNumVar))
					throw new OptimizerException("One of the objects "+vars[i]+" in the first array is not an instance of IloConstraint");
				else vars2[i]=(IloNumVar) vars[i];
			}
			return cplex.SOS1(vars2, weights, name);
		} catch (IloException e) {
			throw new OptimizerException(e.getMessage());
		}
	}

}
