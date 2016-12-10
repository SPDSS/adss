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
package eu.aspire_fp7.adss.l2p;

import ilog.concert.IloAddable;
import ilog.concert.IloException;
import ilog.concert.IloLPMatrix;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloLinearNumExprIterator;
import ilog.concert.IloNumVar;
import ilog.concert.IloObjective;
import ilog.concert.IloQuadNumExpr;
import ilog.concert.IloQuadNumExprIterator;
import ilog.concert.IloRange;
import ilog.concert.IloSOS1;
import ilog.concert.IloSOS2;
import ilog.cplex.IloCplex;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

/**
 * VariableLister provides a static method to scan a CPLEX model and extract
 * a list of variables it contains.
 * 
 * Usage: 
 *   IloNumVar[] vars = VariableLister.parse(model);
 * (where "model" is an instance of IloCplex).
 * 
 * This code is provided under the Eclipse Public License
 * (http://www.eclipse.org/legal/epl-v10.html).
 * 
 * @author Paul A. Rubin <rubin@msu.edu>
 * 
 */
public class VariableLister {
  private static final String prefix = "#Var";
    // This is the prefix used to create variable names when no name
    // already exists. It can be changed to any string.
  
  /**
   * A function to parse CPLEX models (instances of IloCplex) and return
   * a vector of all variables contained in the model. The vector is 
   * sorted alphabetically by the names of the variables. If the variable
   * has no name, one is assigned to it (prefix + counter). The prefix is
   * a static field of the class, and can be changed at will.
   * 
   * @param model the model to parse
   * @return a vector of variables discovered
   * @throws IloException if CPLEX has trouble iterating over the model
   * @throws cplex.variables.VariableLister.VariableListerException 
   *         if an entity is encountered whose type cannot be deciphered
   */
  public static IloNumVar[] parse(IloCplex model) 
                throws IloException, VariableListerException {
    long counter = 0;  // used to create variable names
    HashSet<IloNumVar> vars = new HashSet<IloNumVar>();
    Iterator it = model.iterator();
    IloLinearNumExpr lExpr;
    IloQuadNumExpr qExpr;
    IloLinearNumExprIterator lit;
    IloQuadNumExprIterator qit;
    while (it.hasNext()) {
      IloAddable thing = (IloAddable) it.next();
      System.out.print("Scanning " + thing.getName() + " (type ");
      if (thing instanceof IloRange || thing instanceof IloObjective) {
        Object o;
        if (thing instanceof IloRange) {
          System.out.println("IloRange)");
          o = ((IloRange) thing).getExpr();
        } else {
          System.out.println("IloObjective)");
          o = ((IloObjective) thing).getExpr();
        }
        lExpr = (IloLinearNumExpr) o;
        qExpr = (IloQuadNumExpr) o;
        lit = lExpr.linearIterator();
        qit = qExpr.quadIterator();
        while (lit.hasNext()) {
          vars.add(lit.nextNumVar());
        }
        while (qit.hasNext()) {
          qit.next();
          vars.add(qit.getNumVar1());
          vars.add(qit.getNumVar2());
        }
      } else if (thing instanceof IloSOS1) {
        System.out.println("IloSOS1)");
        vars.addAll(Arrays.asList(((IloSOS1) thing).getNumVars()));
      } else if (thing instanceof IloSOS2) {
        System.out.println("IloSOS2)");
        vars.addAll(Arrays.asList(((IloSOS2) thing).getNumVars()));
      } else if (thing instanceof IloLPMatrix) {
        System.out.println("IloLPMatrix)");
        vars.addAll(Arrays.asList(((IloLPMatrix) thing).getNumVars()));
      } else if (thing instanceof IloNumVar) {
        System.out.println("IloNumVar)");
        vars.add((IloNumVar) thing);
      } else {
        throw new VariableListerException("An object of unrecognized type was "
                                          + "encountered while parsing the "
                                          + "model.");
      }
    }
    // assign names to any variables lacking a name
    for (IloNumVar v : vars) {
      if (v.getName() == null || v.getName().isEmpty()) {
        v.setName(prefix + (counter++));
      }
    }
    IloNumVar[] varray = vars.toArray(new IloNumVar[1]);
    // sort the variables into alphabetic order of their names
    Arrays.sort(varray, new VariableComparator());
    return varray;    
  }
  
  /**
   * Custom exception class to deal with unknown model object types.
   */
  public static class VariableListerException extends Exception {    
    /**
     * Constructor.
     * @param msg message string to include in the exception
     */
    public VariableListerException(String msg) {
      super(msg);
    }
  }
  
  /**
   * Custom comparator used to sort variables based on their names.
   */
  private static class VariableComparator implements Comparator<IloNumVar> {

    @Override
    public int compare(IloNumVar o1, IloNumVar o2) {
      return o1.getName().compareTo(o2.getName());
    }

  }
}
