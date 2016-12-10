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
package eu.aspire_fp7.adss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import eu.aspire_fp7.adss.akb.AKBUtil;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.Model;
import eu.aspire_fp7.adss.akb.Preferences;
import eu.aspire_fp7.adss.akb.Solution;
import eu.aspire_fp7.adss.attacks.AttackFinder;
import eu.aspire_fp7.adss.connectors.ACTCConnector;
import eu.aspire_fp7.adss.connectors.AnnotationRewriter;
import eu.aspire_fp7.adss.connectors.CDTConnector;
import eu.aspire_fp7.adss.connectors.Runner;
import eu.aspire_fp7.adss.l1p.AttackEvaluator;
import eu.aspire_fp7.adss.l1p.MinimaxSolver;
import eu.aspire_fp7.adss.l1p.PetriNetEvaluator;
import eu.aspire_fp7.adss.l1p.ProtectionEvaluator;
import eu.aspire_fp7.adss.l1p.SimpleAttackEvaluator;
import eu.aspire_fp7.adss.l1p.SimpleProtectionEvaluator;
import eu.aspire_fp7.adss.l1p.SolutionSolver;
import eu.aspire_fp7.adss.l2p.SecondLevelProtectionFinder3;
import eu.aspire_fp7.adss.metrics.MetricsFramework;
import eu.aspire_fp7.adss.protections.ProtectionFinder;
import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.OntologyCreationException;
import it.polito.security.ontologies.exceptions.OntologySaveException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * The mythical ADSS.
 * @author Daniele Canavese, Leonardo Regano
 **/
public class ADSS
{
	/**
	 * Creates a new empty AKB.
	 * @param file
	 *            The AKB file to create.
	 * @throws IOException
	 *             If some file cannot be read or written.
	 **/
	static public void create(IFile file) throws IOException
	{
		create(file, null);
	}

	/**
	 * Creates a new empty AKB.
	 * @param file
	 *            The AKB file to create.
	 * @param preferences
	 *            The preferences to set or <code>null</code> to use the default ones.
	 * @throws IOException
	 *             If some file cannot be read or written.
	 **/
	static public void create(IFile file, Preferences preferences) throws IOException
	{
		try
		{
			Ontology ontology = AKBUtil.createEmptyOntology(preferences);
			ByteArrayOutputStream array = new ByteArrayOutputStream();
			ontology.save(array);
			if (!file.exists())
				file.create(new ByteArrayInputStream(array.toByteArray()), true, null);

			log.info("AKB initialized in " + file);
		}
		catch (Exception e)
		{
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * Closes the ADSS connections, if pending.
	 **/
	public void close()
	{
		runner.close();
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(ADSS.class.getName());
	/** The model. **/
	private Model model;
	/** The attack finder. **/
	private AttackFinder attackFinder;
	/** The protection finder. **/
	private ProtectionFinder protectionFinder;
	/** The ACTC connector. **/
	private ACTCConnector actcConnector;
	/** The CDT connector. **/
	private CDTConnector cdtConnector;
	/** The annotation rewriter. **/
	private AnnotationRewriter annotationRewriter;
	/** The metrucs framework. **/
	private MetricsFramework metricsFramework;

	/**
	 * Creates an ADSS instance from an existing AKB.
	 * @param file
	 *            The AKB file to load.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be loaded.
	 * @throws NullPointerException
	 *             If the reasoner cannot be created.
	 * @throws CoreException
	 *             If a custom built-in cannot be registered.
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
	 * @throws JAXBException
	 * @throws URISyntaxException
	 * @throws OntologySaveException
	 * @throws InterruptedException
	 **/
	public ADSS(IFile file, Model model) throws OntologyCreationException, CoreException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchEntityException, InconsistencyException, ReasoningInterruptedException, ParsingErrorException,
			IOException, OntologyChangeException, JAXBException, URISyntaxException, OntologySaveException, InterruptedException
	{
		this.file = file;
		attackFinder = new AttackFinder(this);
		protectionFinder = new ProtectionFinder(this);
		this.model = model;
		actcConnector = new ACTCConnector(this);
		cdtConnector = new CDTConnector(this);
		annotationRewriter = new AnnotationRewriter(this);
		runner = new Runner(this);
		metricsFramework = new MetricsFramework(this);

		log.info(String.format("AKB loaded = %s, %d objects", file.toString(), model.getOntology().getEObjects().size()));
	}

	/**
	 * Analyzes the source code.
	 * @throws IOException
	 *             If an external command cannot be executed.
	 * @throws URISyntaxException
	 *             If a local script file cannot be found.
	 * @throws CoreException
	 *             If a component cannot be instantiated.
	 **/
	public void analyzeSourceCode() throws IOException, URISyntaxException, CoreException
	{
		// Uses CDT to do the heavy lifting...
		cdtConnector.parse();

		// Cleans everything.
		actcConnector.clean();

		// Build the project via the ACTC and extract the metrics.
		actcConnector.build("actc-vanilla.log");
		actcConnector.parseMetrics(model.getVanillaSolution());

		// We are nice and clean up our mess when we have finished.
		actcConnector.clean();
	}

	/**
	 * Retrieves the runner.
	 * @return The runner.
	 */
	public Runner getRunner()
	{
		return runner;
	}

	/**
	 * Retrieves the model.
	 * @return The model
	 **/
	public Model getModel()
	{
		return model;
	}

	/**
	 * Step 1: finds the attacks and the relevant data.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public void findAttacks() throws Exception
	{
		attackFinder.run();
		log.info("Attack paths inferred for " + file);
	}

	/**
	 * Step 2: finds the protections and the relevant data.
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
	 * @throws URISyntaxException
	 * @throws JAXBException
	 **/
	public void findProtections()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, OntologyChangeException, ParsingErrorException,
			NoSuchEntityException, IOException, InconsistencyException, ReasoningInterruptedException, JAXBException, URISyntaxException
	{
		actcConnector.collectProtections();

		protectionFinder.run();
	}

	/**
	 * Finds the first level protections.
	 * @param solverObserver
	 *            An optional solver observer to use.
	 * @throws IOException
	 *             If some file cannot be created.
	 * @throws CoreException
	 *             If a log file cannot be created.
	 **/
	public void findFirstLevelProtections() throws IOException, CoreException
	{
		if (!model.getPreferences().getMetricsFile().isEmpty())
		{
			IFile gammaFile = file.getProject().getFile(model.getPreferences().getMetricsFile());
			if (gammaFile.exists())
				metricsFramework.loadCoefficients(gammaFile);
		}

		ProtectionEvaluator protectionEvaluator = new SimpleProtectionEvaluator(this);
		AttackEvaluator attackEvaluator = new SimpleAttackEvaluator(this);
		SolutionSolver solver = new MinimaxSolver(this, attackEvaluator, protectionEvaluator);

		solver.run();
		model.getSolutions().addAll(solver.getSolutions());

		actcConnector.clean();
		annotationRewriter.deployPatch();
		for (Solution i : model.getSolutions())
		{
			annotationRewriter.deployJSON(i);
			actcConnector.build(null);
			actcConnector.parseMetrics(i);
			double best = Double.POSITIVE_INFINITY;
			double worst = Double.NEGATIVE_INFINITY;
			double average = 0.0;
			int count = 0;
			for (ApplicationPart j : model.getAssets())
				for (String k : MetricsFramework.METRICS)
				{
					double e = metricsFramework.getEstimatedMetric(i, j, k);
					double r = metricsFramework.getRealMetric(i, j, k);

					double gap = (e - r) / r * 100.0;
					System.out.println(String.format("%-20s  %-40s  %7.1f  %7.1f  %5.0f", j.getName(), k, r, e, gap));
					if (!Double.isNaN(gap) && !Double.isInfinite(gap))
					{
						best = Math.min(best, Math.abs(gap));
						worst = Math.max(worst, Math.abs(gap));
						average += Math.abs(gap);
						++count;
					}
				}
			average /= count;
			System.out.println("Best: " + best + ", worst: " + worst + ", average: " + average);
		}

		if (model.getPreferences().isL1pPetriNetsPass())
		{
			PetriNetEvaluator petriNetEvaluator = new PetriNetEvaluator(this);
			petriNetEvaluator.evaluate();
		}
	}

	/**
	 * Finds the second level protections.
	 * @throws Exception
	 **/
	public void findSecondLevelProtections(Solution solution) throws Exception
	{
		log.fine("Inferring second level protection linear programming model");
		long start = System.currentTimeMillis();
		SecondLevelProtectionFinder3 secondFinder = new SecondLevelProtectionFinder3(this, solution);
		secondFinder.findSecondLevelProtectionWithCompleteModel();
		long stop = System.currentTimeMillis();
		log.fine("Time = " + (stop - start) + " ms");
	}

	/**
	 * Deploys a solution.
	 * @param solution
	 *            The solution to deploy.
	 * @throws IOException
	 *             If a source file cannot be read.
	 * @throws CoreException
	 *             If a log file cannot be created.
	 **/
	public void deploySolution(Solution solution) throws IOException, CoreException
	{
		actcConnector.clean();
		annotationRewriter.deployPatch();
		annotationRewriter.deployJSON(solution);
		// actcConnector.build("actc-deployed.log");
		log.info("Solution deployed");
	}

	/**
	 * Saves the ADSS state to file.
	 * @throws OntologySaveException
	 *             If the ontology cannot be saved.
	 * @throws CoreException
	 *             If the file cannot be refreshed.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be serialized or the output file cannot be created.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws OntologyCreationException
	 **/
	public void save() throws OntologySaveException, CoreException, OntologyChangeException, ParsingErrorException, NoSuchEntityException,
			IOException, InconsistencyException, ReasoningInterruptedException, OntologyCreationException
	{
		// Saves a backup first.
		getOntology().save(file.getLocation().toFile() + ".old");

		AKBUtil.saveIntoOntology(model);
		getOntology().save(file.getLocation().toFile());
		file.refreshLocal(0, null);

		file.getProject().refreshLocal(IProject.DEPTH_INFINITE, null);

		log.info(String.format("AKB saved = %s, %d objects", file.toString(), model.getOntology().getEObjects().size()));
	}

	/**
	 * Returns the AKB file.
	 * @return The AKB file.
	 **/
	public IFile getAKBFile()
	{
		return file;
	}

	/**
	 * Retrieves the ontology.
	 * @return The ontology
	 **/
	public Ontology getOntology()
	{
		return model.getOntology();
	}

	/**
	 * Retrieves the ACTC connector.
	 * @return The ACTC connector.
	 **/
	public ACTCConnector getACTCConnector()
	{
		return actcConnector;
	}

	/**
	 * Retrieves the metrics framework.
	 * @return The metrics framework.
	 **/
	public MetricsFramework getMetricsFramework()
	{
		return metricsFramework;
	}

	/**
	 * Retrieves the annotation rewriter.
	 * @return The annotaiton rewriter.
	 **/
	public AnnotationRewriter getAnnotationRewriter()
	{
		return annotationRewriter;
	}

	/**
	 * Updates the assets. This method <b>must</b> be called if the assets are changed somehow.
	 **/
	public void updateAssets()
	{
		cdtConnector.updateIdentifiers();
	}

	/**
	 * Computes all the metrics and saves them in a file.
	 * @param file
	 *            The file where the metrics will be saved.
	 * @param monitor
	 *            The progress monitor.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If a file cannot be created.
	 **/
	public void computeMetrics(IFile file, IProgressMonitor monitor) throws IOException, CoreException
	{
		metricsFramework.computeMetrics(file, monitor);
	}

	/**
	 * Computes all the metric coefficients.
	 * @param files
	 *            The files containing the metrics to analyze
	 * @param file
	 *            The file that will contain the results.
	 * @param monitor
	 *            The progress monitor.
	 **/
	public void computeMetricCoefficients(Collection<IFile> files, IFile file, IProgressMonitor monitor) throws IOException, CoreException
	{
		metricsFramework.computeCoefficients(files, file, monitor);
	}

	/** The AKB file. **/
	private IFile file;
	/** The runner. **/
	private Runner runner;

	Map<String, Map<Integer, List<Entry<String, ApplicationPart>>>> uses;
}
