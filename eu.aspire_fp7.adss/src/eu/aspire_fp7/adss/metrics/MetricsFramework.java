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
package eu.aspire_fp7.adss.metrics;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.orangepalantir.leastsquares.Fitter;
import org.orangepalantir.leastsquares.Function;
import org.orangepalantir.leastsquares.fitters.LinearFitter;
import org.orangepalantir.leastsquares.fitters.MarquardtFitter;
import org.orangepalantir.leastsquares.fitters.NonLinearSolver;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartMetricSet;
import eu.aspire_fp7.adss.akb.AppliedProtectionInstantiation;
import eu.aspire_fp7.adss.akb.Metric;
import eu.aspire_fp7.adss.akb.Protection;
import eu.aspire_fp7.adss.akb.ProtectionInstantiation;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.akb.SolutionSequence;
import eu.aspire_fp7.adss.util.Strings;

/**
 * The amazing metrics framework.
 * @author Daniele Canavese
 **/
public class MetricsFramework
{
	/** The derivative delta for the Marquardt fitter. **/
	private static final double MARQUARDT_DELTA = 1e-16;
	/** The maximum number of iterations for the non-linear fitter. **/
	private static final int NON_LINEAR_MAX_ITERATIONS = 10000;
	/** The derivative delta for the non-linear fitter. **/
	private static final double NON_LINEAR_DELTA = 1e-16;
	/** The step size for the non-linear fitter. **/
	private static final double NON_LINEAR_STEP_SIZE = 0.01;
	/** The minimum error for the non-linear fitter. **/
	private static final double NON_LINEAR_MIN_ERROR = 1e-16;
	/** The minimum change value for the non-linear fitter. **/
	private static final double NON_LINEAR_MIN_CHANGE = 1e-16;
	/** The maximum number of ACTC build tries. **/
	private static final int MAX_TRIES = 10;
	/** The transformation degree. **/
	final private static int TRANSFORMATION_DEGREE = 4;
	/** The pseudo-inverse matrix computation sensitivity. **/
	final private static double SENSITIVITY = 1e-16;
	/** The list of interesting metrics. **/
	final public static String[] METRICS = new String[] { "nr_ins_static", "nr_indirect_edges_CFIM_static", "nr_edges_static",
			"cyclomatic_complexity_static", "nr_dst_oper_static", "nr_src_oper_static", "halstead_program_size_static",
			"nr_of_mobile_blocks", "nr_of_mobile_bytes", "nr_of_bytes_in_ads", "nr_of_blocks", "nr_of_guarded_bytes" };
	/** The fitter type. **/
	final private static FitterType FITTER_TYPE = FitterType.LINEAR;
	/** The ADSS. **/
	private ADSS adss;
	/** The gamma map. **/
	private Map<ProtectionInstantiation, Map<String, List<Double>>> gammaMap;
	/** The build counter. **/
	private int builds;

	/**
	 * Creates the framework.
	 * @param adss
	 *            The ADSS.
	 */
	public MetricsFramework(ADSS adss)
	{
		this.adss = adss;
		gammaMap = new HashMap<>();
		builds = 0;
	}

	/**
	 * Computes all the metrics and saves them into a file.
	 * @param file
	 *            The file where the metrics will be saved.
	 * @param monitor
	 *            The progress monitor.
	 * @throws CoreException
	 *             If the metrics file cannot be created.
	 **/
	public void computeMetrics(IFile file, IProgressMonitor monitor) throws CoreException
	{
		monitor.beginTask("Building...", adss.getModel().getAppliedProtectionInstantiationsCount());
		builds = 0;

		StringBuilder sb = new StringBuilder();

		// Computes the metrics on the vanilla application.
		sb.append(getMetrics(adss.getModel().getVanillaSolution()));

		// Computes the metrics on all the other solutions with only an applied PI.
		int count = 0;
		for (AppliedProtectionInstantiation i : adss.getModel().getAppliedProtectionInstantiations())
			try
			{
				sb.append(getMetrics(build(i, ++count)));
				monitor.worked(1);
			}
			catch (Exception e)
			{
				log.severe("Unable to build the solution");
			}

		// Saves everything to a file.
		if (!file.exists())
			file.create(new ByteArrayInputStream(sb.toString().getBytes()), true, null);
		else
			file.setContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);
		monitor.done();
	}

	/**
	 * Creates a text version of a solution metrics.
	 * @param solution
	 *            The solution.
	 * @return A text version of the solution metrics.
	 **/
	private String getMetrics(Solution solution)
	{
		StringBuilder sb = new StringBuilder();

		// Creates the table where the columns are:
		// + the PI name or * if there is no PI
		// + the application part hashcode
		// + the metric id
		// + the metric value
		for (ApplicationPartMetricSet i : solution.getApplicationPartMetricSets())
			for (Metric j : i.getMetrics())
			{
				if (solution.equals(adss.getModel().getVanillaSolution()))
					sb.append("*;");
				else
					sb.append(solution.getSolutionSequences().get(0).getAppliedProtectionInstantiations().get(0)
							.getProtectionInstantiation().getName() + ";");
				sb.append(i.getApplicationPart().hashCode() + ";");
				sb.append(j.getName() + ";");
				sb.append(j.getValue() + "\n");
			}

		return sb.toString();
	}

	/**
	 * Computes the metrics estimation coefficients by reading the metrics from a set of files.
	 * @param files
	 *            The metric files.
	 * @param file
	 *            The file where the results are saved.
	 * @param monitor
	 *            The progress monitor.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws CoreException
	 *             If a file cannot be read.
	 **/
	public void computeCoefficients(Collection<IFile> files, IFile file, IProgressMonitor monitor) throws IOException, CoreException
	{
		Map<ProtectionInstantiation, Map<String, Set<Sample>>> map = new HashMap<>();
		for (IFile i : files)
			loadMetrics(i, map);
		int size = map.size() * METRICS.length;

		monitor.beginTask("Building...", size);

		gammaMap.clear();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (Entry<ProtectionInstantiation, Map<String, Set<Sample>>> i : map.entrySet())
			for (Entry<String, Set<Sample>> j : i.getValue().entrySet())
			{
				List<Double> list = computeGammas(j.getValue());
				sb.append(i.getKey().getName() + ";");
				sb.append(j.getKey() + ";");
				sb.append(Strings.join(list, ",") + "\n");
				Map<String, List<Double>> m;
				if (gammaMap.containsKey(i.getKey()))
					m = gammaMap.get(i.getKey());
				else
				{
					m = new HashMap<>();
					gammaMap.put(i.getKey(), m);
				}
				m.put(j.getKey(), list);
				log.fine("Computed " + ++count + "/" + size + " gammas");
				monitor.worked(1);
			}

		if (!file.exists())
			file.create(new ByteArrayInputStream(sb.toString().getBytes()), true, null);
		else
			file.setContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);

		monitor.done();
	}

	/**
	 * Computes the gamma coefficients from a list of samples.
	 * @param samples
	 *            The samples.
	 * @return The gamma coefficients
	 **/
	private List<Double> computeGammas(final Set<Sample> samples)
	{
		List<Double> list = new ArrayList<>();
		final int n = samples.size();

		if (n > 1)
		{
			final int size = samples.iterator().next().getX().size();
			final int degree = Math.min(n, TRANSFORMATION_DEGREE + 1);

			double[][] x = new double[n][];
			double[] y = new double[n];
			double[] g = new double[(degree - 1) * size + 1];
			int count = 0;
			for (Sample i : samples)
			{
				x[count] = new double[size];
				for (int j = 0; j < size; ++j)
					x[count][j] = i.getX().get(j);
				y[count] = i.getY();
				++count;
			}
			for (int i = 0; i < (degree - 1) * size + 1; ++i)
				g[i] = 0.0;

			Function function = new Function()
			{
				@Override
				public double evaluate(double[] values, double[] parameters)
				{
					double r = parameters[0];

					for (int i = 0; i < size; ++i)
						for (int j = 0; j < degree - 1; ++j)
							r += parameters[i * (degree - 1) + j + 1] * Math.pow(values[i], j + 1);

					return r;
				}

				@Override
				public int getNInputs()
				{
					return size;
				}

				@Override
				public int getNParameters()
				{
					return (degree - 1) * size + 1;
				}
			};

			Fitter fitter;
			if (FITTER_TYPE == FitterType.LINEAR)
				fitter = new LinearFitter(function);
			else if (FITTER_TYPE == FitterType.NON_LINEAR)
			{
				NonLinearSolver f = new NonLinearSolver(function);
				f.setDelta(NON_LINEAR_DELTA);
				f.setMaxIterations(NON_LINEAR_MAX_ITERATIONS);
				f.setMinChange(NON_LINEAR_MIN_CHANGE);
				f.setMinError(NON_LINEAR_MIN_ERROR);
				f.setStepSize(NON_LINEAR_STEP_SIZE);
				fitter = f;
			}
			else
			{
				MarquardtFitter f = new MarquardtFitter(function);
				f.setDelta(MARQUARDT_DELTA);
				fitter = f;
			}
			fitter.setData(x, y);
			fitter.setParameters(g);

			fitter.fitData(SENSITIVITY);
			for (double i : fitter.getParameters())
				list.add(i);
			for (int i = 0; i < TRANSFORMATION_DEGREE + 1 - list.size(); ++i)
				list.add(0.0);
		}

		return list;
	}

	/**
	 * Loads the gamma coefficients from a file.
	 * @param file
	 *            The file to load.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws CoreException
	 *             If a file cannot be read.
	 **/
	public void loadCoefficients(IFile file) throws IOException, CoreException
	{
		gammaMap.clear();

		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] tokens = line.split(";");

			String piName = tokens[0];
			ProtectionInstantiation pi = null;
			for (Protection i : adss.getModel().getProtections())
				for (ProtectionInstantiation j : i.getInstantiations())
					if (j.getName().equals(piName))
						pi = j;
			String metricName = tokens[1];
			List<Double> values = new ArrayList<>();
			for (String i : tokens[2].split(","))
				values.add(Double.valueOf(i));

			if (pi != null)
			{
				Map<String, List<Double>> map;
				if (gammaMap.containsKey(pi))
					map = gammaMap.get(pi);
				else
				{
					map = new HashMap<>();
					gammaMap.put(pi, map);
				}

				map.put(metricName, values);
			}
		}
	}

	/**
	 * Loads the metrics from a file.
	 * @param file
	 *            The file.
	 * @param map
	 *            The map that will contain the metrics.
	 * @throws IOException
	 *             If the file cannot be opened.
	 * @throws CoreException
	 *             If a file cannot be read.
	 */
	private void loadMetrics(IFile file, Map<ProtectionInstantiation, Map<String, Set<Sample>>> map) throws IOException, CoreException
	{
		Map<Integer, Map<String, Double>> vanillaMap = new HashMap<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] tokens = line.split(";");
			if (tokens.length == 4)
				try
				{
					String piName = tokens[0];
					ProtectionInstantiation pi = null;
					for (Protection i : adss.getModel().getProtections())
						for (ProtectionInstantiation j : i.getInstantiations())
							if (j.getName().equals(piName))
								pi = j;
					int partHash = Integer.valueOf(tokens[1]);
					String metricName = tokens[2];
					double metricValue = Double.valueOf(tokens[3]);

					// Skips uninteresting metrics.
					if (!Arrays.asList(METRICS).contains(metricName))
						continue;

					if (pi == null && piName.equals("*"))
					{
						Map<String, Double> partMap;
						if (vanillaMap.containsKey(partHash))
							partMap = vanillaMap.get(partHash);
						else
						{
							partMap = new LinkedHashMap<>();
							vanillaMap.put(partHash, partMap);
						}

						partMap.put(metricName, metricValue);
					}
					else if (pi != null)
					{
						Map<String, Set<Sample>> metricMap;
						if (map.containsKey(pi))
							metricMap = map.get(pi);
						else
						{
							metricMap = new HashMap<>();
							map.put(pi, metricMap);
						}

						Set<Sample> samples;
						if (metricMap.containsKey(metricName))
							samples = metricMap.get(metricName);
						else
						{
							samples = new HashSet<>();
							metricMap.put(metricName, samples);
						}

						samples.add(new Sample(vanillaMap.get(partHash), metricValue));
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
		}
	}

	/**
	 * Deploys a solution with one applied PI, builds the project and extract all of its metrics.
	 * @param appliedProtectionInstantiation
	 *            The applied protection instantiation.
	 * @param number
	 *            The solution number.
	 * @return The solution.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	private Solution build(AppliedProtectionInstantiation appliedProtectionInstantiation, Integer number) throws IOException, CoreException
	{
		Solution solution = AkbFactory.eINSTANCE.createSolution();
		SolutionSequence sequence = AkbFactory.eINSTANCE.createSolutionSequence();
		solution.getSolutionSequences().add(sequence);
		sequence.getAppliedProtectionInstantiations().add(appliedProtectionInstantiation);

		log.info("Building solution " + number + "/" + adss.getModel().getAppliedProtectionInstantiationsCount() + " for "
				+ appliedProtectionInstantiation);
		build(solution);

		return solution;
	}

	/**
	 * Builds a solution.
	 * @param solution
	 *            The solution to build.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 */
	private void build(Solution solution) throws IOException, CoreException
	{
		for (int i = 0; i < MAX_TRIES; ++i)
			try
			{
				adss.getACTCConnector().clean();
				adss.getAnnotationRewriter().deployPatch();
				adss.getAnnotationRewriter().deployJSON(solution);
				adss.getACTCConnector().build("actc-metrics" + builds++ + ".log");
				adss.getACTCConnector().parseMetrics(solution);

				return;
			}
			catch (Exception e)
			{
				if (i == MAX_TRIES - 1)
					throw e;
			}
	}

	/**
	 * Retrieves an estimated metric value of an application part.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part .
	 * @param metricName
	 *            The metric name.
	 * @return The metric value.
	 **/
	public double getEstimatedMetric(Solution solution, ApplicationPart applicationPart, String metricName)
	{
		// 1. Retrieves the metric values in the vanilla solution.
		Map<String, Double> m = new HashMap<>();
		for (ApplicationPartMetricSet i : adss.getModel().getVanillaSolution().getApplicationPartMetricSets())
			if (i.getApplicationPart() == applicationPart)
				for (Metric j : i.getMetrics())
					m.put(j.getName(), j.getValue());

		// 2. Finds all the applied PIs on the application part.
		List<AppliedProtectionInstantiation> pis = new ArrayList<>();
		for (SolutionSequence i : solution.getSolutionSequences())
			for (AppliedProtectionInstantiation j : i.getAppliedProtectionInstantiations())
				if (j.getApplicationPart() == applicationPart)
					pis.add(j);

		// 3. Updates the metric values via the formulas.
		for (AppliedProtectionInstantiation i : pis)
		{
			Map<String, Double> n = new HashMap<>();
			if (!gammaMap.containsKey(i.getProtectionInstantiation()))
				continue;

			Map<String, List<Double>> map = gammaMap.get(i.getProtectionInstantiation());
			for (Entry<String, List<Double>> j : map.entrySet())
			{
				double value = m.get(j.getKey());
				int degree = (j.getValue().size() - 1) / METRICS.length;

				for (int k = 0; k < j.getValue().size(); ++k)
					if (k == 0)
						value += j.getValue().get(k);
					else
					{
						double v = 0.0;
						if (m.containsKey(METRICS[(k - 1) / degree]))
							v = m.get(METRICS[(k - 1) / degree]);
						value += j.getValue().get(k) * Math.pow(v, (k - 1) % degree + 1);
					}
				n.put(j.getKey(), value);
			}
			m = n;
		}

		if (m.containsKey(metricName))
			return m.get(metricName);
		else
			return 0.0;
	}

	/**
	 * Retrieves a real metric value of an application part.
	 * @param solution
	 *            The solution to use.
	 * @param applicationPart
	 *            The application part .
	 * @param metricName
	 *            The metric name.
	 * @return The metric value.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	public double getRealMetric(Solution solution, ApplicationPart applicationPart, String metricName) throws IOException, CoreException
	{
		build(solution);

		for (ApplicationPartMetricSet i : solution.getApplicationPartMetricSets())
			if (i.getApplicationPart() == applicationPart)
				for (Metric j : i.getMetrics())
					if (j.getName().equals(metricName))
						return j.getValue();

		return 0.0;
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(MetricsFramework.class.getName());
}
