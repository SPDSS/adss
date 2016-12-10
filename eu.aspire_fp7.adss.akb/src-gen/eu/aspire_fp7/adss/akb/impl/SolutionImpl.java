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
/**
 */
package eu.aspire_fp7.adss.akb.impl;

import com.google.common.base.Objects;

import eu.aspire_fp7.adss.akb.AkbPackage;
import eu.aspire_fp7.adss.akb.ApplicationPartMetricSet;
import eu.aspire_fp7.adss.akb.Metric;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl#getSolutionSequences <em>Solution Sequences</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl#getApplicationMetrics <em>Application Metrics</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl#getApplicationPartMetricSets <em>Application Part Metric Sets</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl#getFirstLevelSolution <em>First Level Solution</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl#getScore <em>Score</em>}</li>
 *   <li>{@link eu.aspire_fp7.adss.akb.impl.SolutionImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends MinimalEObjectImpl.Container implements Solution
{
	/**
	 * The cached value of the '{@link #getSolutionSequences() <em>Solution Sequences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolutionSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<SolutionSequence> solutionSequences;

	/**
	 * The cached value of the '{@link #getApplicationMetrics() <em>Application Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> applicationMetrics;

	/**
	 * The cached value of the '{@link #getApplicationPartMetricSets() <em>Application Part Metric Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPartMetricSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPartMetricSet> applicationPartMetricSets;

	/**
	 * The cached value of the '{@link #getFirstLevelSolution() <em>First Level Solution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstLevelSolution()
	 * @generated
	 * @ordered
	 */
	protected Solution firstLevelSolution;

	/**
	 * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected static final double SCORE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected double score = SCORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return AkbPackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SolutionSequence> getSolutionSequences()
	{
		if (solutionSequences == null)
		{
			solutionSequences = new EObjectResolvingEList<SolutionSequence>(SolutionSequence.class, this, AkbPackage.SOLUTION__SOLUTION_SEQUENCES);
		}
		return solutionSequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getApplicationMetrics()
	{
		if (applicationMetrics == null)
		{
			applicationMetrics = new EObjectResolvingEList<Metric>(Metric.class, this, AkbPackage.SOLUTION__APPLICATION_METRICS);
		}
		return applicationMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPartMetricSet> getApplicationPartMetricSets()
	{
		if (applicationPartMetricSets == null)
		{
			applicationPartMetricSets = new EObjectResolvingEList<ApplicationPartMetricSet>(ApplicationPartMetricSet.class, this, AkbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS);
		}
		return applicationPartMetricSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution getFirstLevelSolution()
	{
		if (firstLevelSolution != null && firstLevelSolution.eIsProxy())
		{
			InternalEObject oldFirstLevelSolution = (InternalEObject)firstLevelSolution;
			firstLevelSolution = (Solution)eResolveProxy(oldFirstLevelSolution);
			if (firstLevelSolution != oldFirstLevelSolution)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION, oldFirstLevelSolution, firstLevelSolution));
			}
		}
		return firstLevelSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution basicGetFirstLevelSolution()
	{
		return firstLevelSolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstLevelSolution(Solution newFirstLevelSolution)
	{
		Solution oldFirstLevelSolution = firstLevelSolution;
		firstLevelSolution = newFirstLevelSolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION, oldFirstLevelSolution, firstLevelSolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getScore()
	{
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(double newScore)
	{
		double oldScore = score;
		score = newScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AkbPackage.SOLUTION__SCORE, oldScore, score));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		int _hashCode = this.hashCode();
		long h = (((long) _hashCode) + (-((long) Integer.MIN_VALUE)));
		Solution _firstLevelSolution = this.getFirstLevelSolution();
		boolean _equals = Objects.equal(_firstLevelSolution, null);
		if (_equals)
		{
			return Long.valueOf(h).toString();
		}
		else
		{
			String _string = Long.valueOf(h).toString();
			String _plus = (_string + " (");
			Solution _firstLevelSolution_1 = this.getFirstLevelSolution();
			String _id = _firstLevelSolution_1.getId();
			String _string_1 = _id.toString();
			String _plus_1 = (_plus + _string_1);
			return (_plus_1 + ")");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		EList<SolutionSequence> _solutionSequences = this.getSolutionSequences();
		return _solutionSequences.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int r = 0;
		EList<SolutionSequence> _solutionSequences = this.getSolutionSequences();
		for (final SolutionSequence i : _solutionSequences)
		{
			int _r = r;
			int _hashCode = i.hashCode();
			r = (_r + _hashCode);
		}
		result = ((31 * result) + r);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equals(final Object object)
	{
		boolean _equals = Objects.equal(object, null);
		if (_equals)
		{
			return false;
		}
		else
		{
			if ((object instanceof Solution))
			{
				EList<SolutionSequence> _solutionSequences = this.getSolutionSequences();
				EList<SolutionSequence> _solutionSequences_1 = ((Solution)object).getSolutionSequences();
				return EcoreUtil.equals(_solutionSequences, _solutionSequences_1);
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case AkbPackage.SOLUTION__SOLUTION_SEQUENCES:
				return getSolutionSequences();
			case AkbPackage.SOLUTION__APPLICATION_METRICS:
				return getApplicationMetrics();
			case AkbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				return getApplicationPartMetricSets();
			case AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				if (resolve) return getFirstLevelSolution();
				return basicGetFirstLevelSolution();
			case AkbPackage.SOLUTION__SCORE:
				return getScore();
			case AkbPackage.SOLUTION__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case AkbPackage.SOLUTION__SOLUTION_SEQUENCES:
				getSolutionSequences().clear();
				getSolutionSequences().addAll((Collection<? extends SolutionSequence>)newValue);
				return;
			case AkbPackage.SOLUTION__APPLICATION_METRICS:
				getApplicationMetrics().clear();
				getApplicationMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case AkbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				getApplicationPartMetricSets().clear();
				getApplicationPartMetricSets().addAll((Collection<? extends ApplicationPartMetricSet>)newValue);
				return;
			case AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				setFirstLevelSolution((Solution)newValue);
				return;
			case AkbPackage.SOLUTION__SCORE:
				setScore((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case AkbPackage.SOLUTION__SOLUTION_SEQUENCES:
				getSolutionSequences().clear();
				return;
			case AkbPackage.SOLUTION__APPLICATION_METRICS:
				getApplicationMetrics().clear();
				return;
			case AkbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				getApplicationPartMetricSets().clear();
				return;
			case AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				setFirstLevelSolution((Solution)null);
				return;
			case AkbPackage.SOLUTION__SCORE:
				setScore(SCORE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case AkbPackage.SOLUTION__SOLUTION_SEQUENCES:
				return solutionSequences != null && !solutionSequences.isEmpty();
			case AkbPackage.SOLUTION__APPLICATION_METRICS:
				return applicationMetrics != null && !applicationMetrics.isEmpty();
			case AkbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS:
				return applicationPartMetricSets != null && !applicationPartMetricSets.isEmpty();
			case AkbPackage.SOLUTION__FIRST_LEVEL_SOLUTION:
				return firstLevelSolution != null;
			case AkbPackage.SOLUTION__SCORE:
				return score != SCORE_EDEFAULT;
			case AkbPackage.SOLUTION__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case AkbPackage.SOLUTION___TO_STRING:
				return toString();
			case AkbPackage.SOLUTION___HASH_CODE:
				return hashCode();
			case AkbPackage.SOLUTION___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SolutionImpl
