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
package eu.aspire_fp7.adss.connectors;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTInitializerClause;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorStatement;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.IBasicType.Kind;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.dom.ast.IType;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.gnu.c.GCCLanguage;
import org.eclipse.cdt.core.dom.ast.gnu.cpp.GPPLanguage;
import org.eclipse.cdt.core.parser.DefaultLogService;
import org.eclipse.cdt.core.parser.FileContent;
import org.eclipse.cdt.core.parser.IParserLogService;
import org.eclipse.cdt.core.parser.IScannerInfo;
import org.eclipse.cdt.core.parser.IncludeFileContentProvider;
import org.eclipse.cdt.core.parser.ScannerInfo;
import org.eclipse.cdt.internal.core.dom.parser.ASTNode;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTArrayDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTDeclarationStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTDoStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTForStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTFunctionCallExpression;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTFunctionDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTIdExpression;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTIfStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTName;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTSimpleDeclSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTSimpleDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTSwitchStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTWhileStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CArrayType;
import org.eclipse.cdt.internal.core.dom.parser.c.CBasicType;
import org.eclipse.cdt.internal.core.dom.parser.c.CParameter;
import org.eclipse.cdt.internal.core.dom.parser.c.CQualifierType;
import org.eclipse.cdt.internal.core.dom.parser.c.CTypedef;
import org.eclipse.cdt.internal.core.dom.parser.c.CVariable;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTArrayDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDeclarationStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDoStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTForStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionCallExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTIdExpression;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTIfStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTName;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSwitchStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTWhileStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPArrayType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPBasicType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPParameter;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPQualifierType;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPTypedef;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPVariable;
import org.eclipse.cdt.internal.core.parser.SavedFilesProvider;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import com.google.common.io.Files;

import eu.aspire_fp7.adss.ADSS;
import eu.aspire_fp7.adss.akb.ActionType;
import eu.aspire_fp7.adss.akb.Activator;
import eu.aspire_fp7.adss.akb.AkbFactory;
import eu.aspire_fp7.adss.akb.ApplicationPart;
import eu.aspire_fp7.adss.akb.ApplicationPartSet;
import eu.aspire_fp7.adss.akb.ApplicationPartType;
import eu.aspire_fp7.adss.akb.CodeBlock;
import eu.aspire_fp7.adss.akb.CodeBlockType;
import eu.aspire_fp7.adss.akb.FunctionDeclaration;
import eu.aspire_fp7.adss.akb.Property;
import eu.aspire_fp7.adss.akb.Rule;
import eu.aspire_fp7.adss.akb.UseTarget;
import eu.aspire_fp7.adss.akb.UseType;
import eu.aspire_fp7.adss.util.Collections;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The CDT connector.
 * @author Daniele Canavese
 **/
@SuppressWarnings("restriction")
public class CDTConnector
{
	/** The ADSS. **/
	private ADSS adss;

	/**
	 * Creates the connector.
	 * @param adss
	 *            The ADSS.
	 **/
	public CDTConnector(ADSS adss)
	{
		this.adss = adss;
	}

	/**
	 * Parses the security properties in an annotation.
	 * @param annotation
	 *            The annotation.
	 * @return The security properties.
	 **/
	private Collection<Property> parseProperties(String annotation)
	{
		Pattern pattern = Pattern.compile(".*requirement\\s*\\((.*?)\\).*");
		Matcher matcher = pattern.matcher(annotation);

		HashSet<Property> properties = new HashSet<>();

		if (matcher.matches())
		{
			String list = matcher.group(1);
			for (String i : list.split("\\s*,\\s*"))
				properties.add(Property.get(i));
		}

		return properties;
	}

	/**
	 * Parses the weight in an annotation.
	 * @param annotation
	 *            The annotation.
	 * @return The weight.
	 **/
	private Double parseWeight(String annotation)
	{
		Pattern pattern = Pattern.compile(".*weight\\s*\\((.*?)\\).*");
		Matcher matcher = pattern.matcher(annotation);

		double weight = 1;

		if (matcher.matches())
			try
			{
				weight = Double.valueOf(matcher.group(1));
			}
			catch (Exception e)
			{
			}

		return weight;
	}

	/**
	 * Searches an application part with a certain name.
	 * @param parentName
	 *            The parent name or <code>null</code> for no parent.
	 * @param name
	 *            The application part name.
	 * @return The found application part or <code>null</code> if it does not exist.
	 **/
	private ApplicationPart search(String parentName, String name)
	{
		for (ApplicationPart i : adss.getModel().getAllApplicationParts())
			if (i.getDeclaringCode() != null && parentName != null && i.getDeclaringCode().getName().equals(parentName)
					&& i.getName().equals(name))
				return i;
			else if (i.getDeclaringCode() == null && parentName == null && i.getName().equals(name))
				return i;

		return null;
	}

	/**
	 * Searches an application part enclosing a certain code line.
	 * @param container
	 *            The current container or <code>null</code> if no container is known.
	 * @param file
	 *            The source file name of the application part.
	 * @param line
	 *            The line code number.
	 * @return The found application part or <code>null</code> if it does not exist.
	 **/
	private ApplicationPart searchCode(ApplicationPart container, String file, int line)
	{
		ApplicationPart code = null;
		if (container == null)
		{
			for (ApplicationPart i : adss.getModel().getApplicationParts())
				if (i.isCode() && i.getSourceFilePath().equals(file) && line >= i.getStartLine()
						&& (line <= i.getEndLine() || i.getEndLine() < 0))
				{
					code = i;
					break;
				}
		}
		else
		{
			for (ApplicationPart i : container.getApplicationParts())
				if (i.isCode() && i.getSourceFilePath().equals(file) && line >= i.getStartLine()
						&& (line <= i.getEndLine() || i.getEndLine() < 0))
				{
					code = i;
					break;
				}
		}

		if (code != null)
		{
			ApplicationPart c = searchCode(code, file, line);
			if (c != null)
				return c;
		}

		return code;
	}

	/**
	 * Converts a statement into a code block.
	 * @param statement
	 *            The statement.
	 * @param function
	 *            The function containing the block.
	 * @return The code block
	 **/
	private CodeBlock convert(IASTStatement statement, ApplicationPart function)
	{
		int start = statement.getFileLocation().getStartingLineNumber();
		int end = statement.getFileLocation().getEndingLineNumber();

		if (statement.getChildren().length > 0)
		{
			start = statement.getChildren()[0].getFileLocation().getStartingLineNumber();
			end = statement.getChildren()[statement.getChildren().length - 1].getFileLocation().getEndingLineNumber();
		}

		CodeBlockType type;

		if (statement instanceof CASTIfStatement || statement instanceof CPPASTIfStatement)
			type = CodeBlockType.IF;
		else if (statement instanceof CASTForStatement || statement instanceof CPPASTForStatement)
			type = CodeBlockType.FOR;
		else if (statement instanceof CASTWhileStatement || statement instanceof CPPASTWhileStatement)
			type = CodeBlockType.WHILE;
		else if (statement instanceof CASTDoStatement || statement instanceof CPPASTDoStatement)
			type = CodeBlockType.DO_WHILE;
		else if (statement instanceof CASTSwitchStatement || statement instanceof CPPASTSwitchStatement)
			type = CodeBlockType.SWITCH;
		else
			type = CodeBlockType.OTHER;

		CodeBlock codeBlock = AkbFactory.eINSTANCE.createCodeBlock();
		codeBlock.setStartLine(start);
		codeBlock.setEndLine(end);
		codeBlock.setType(type);
		codeBlock.setSourceFilePath(function.getSourceFilePath());

		if (start != end)
		{
			if (statement instanceof CASTForStatement)
			{
				CASTForStatement forStatement = (CASTForStatement) statement;
				IASTStatement body = (IASTStatement) forStatement.getBody();
				Collections.addUnique(codeBlock.getCodeBlocks(), convert(body, function));
			}
			else if (statement instanceof CPPASTForStatement)
			{
				CPPASTForStatement forStatement = (CPPASTForStatement) statement;
				Collections.addUnique(codeBlock.getCodeBlocks(), convert((IASTStatement) forStatement.getBody(), function));
			}
			else if (statement instanceof CASTIfStatement)
			{
				CASTIfStatement ifStatement = (CASTIfStatement) statement;
				Collections.addUnique(codeBlock.getCodeBlocks(), convert(ifStatement.getThenClause(), function));
				while (ifStatement != null)
				{
					if (ifStatement.getElseClause() == null)
					{
						ifStatement = null;
					}
					else if (ifStatement.getElseClause() instanceof CPPASTIfStatement)
					{
						ifStatement = (CASTIfStatement) ifStatement.getElseClause();
						codeBlock.getCodeBlocks().add(convert(ifStatement.getThenClause(), function));
						Collections.addUnique(codeBlock.getCodeBlocks(), convert(ifStatement.getThenClause(), function));
					}
					else
					{
						codeBlock.getCodeBlocks().add(convert(ifStatement.getElseClause(), function));
						Collections.addUnique(codeBlock.getCodeBlocks(), convert(ifStatement.getElseClause(), function));
						ifStatement = null;
					}
				}
			}
			else if (statement instanceof CPPASTIfStatement)
			{
				CPPASTIfStatement ifStatement = (CPPASTIfStatement) statement;
				Collections.addUnique(codeBlock.getCodeBlocks(), convert(ifStatement.getThenClause(), function));
				while (ifStatement != null)
				{
					if (ifStatement.getElseClause() == null)
					{
						ifStatement = null;
					}
					else if (ifStatement.getElseClause() instanceof CPPASTIfStatement)
					{
						ifStatement = (CPPASTIfStatement) ifStatement.getElseClause();
						Collections.addUnique(codeBlock.getCodeBlocks(), convert(ifStatement.getThenClause(), function));
					}
					else
					{
						Collections.addUnique(codeBlock.getCodeBlocks(), convert(ifStatement.getElseClause(), function));
						ifStatement = null;
					}
				}
			}
			else
				for (IASTNode i : statement.getChildren())
					if (i instanceof IASTStatement && i.getFileLocation().getStartingLineNumber() != start
							&& i.getFileLocation().getEndingLineNumber() != end)
						Collections.addUnique(codeBlock.getCodeBlocks(), convert((IASTStatement) i, function));
		}

		return codeBlock;
	}

	/**
	 * Parses a project.
	 * @throws IOException
	 *             If some I/O error occurs.
	 * @throws CoreException
	 *             If a source file cannot be parsed.
	 */
	public void parse() throws IOException, CoreException
	{
		// We create the empty part, used to indicate a special parameter.
		ApplicationPart emptyPart = AkbFactory.eINSTANCE.createApplicationPart();
		emptyPart.setDeclaringCode(null);
		emptyPart.setName("");
		emptyPart.setType(ApplicationPartType.GENERIC_VARIABLE);
		emptyPart.setDatumSize(0);
		emptyPart.setWeight(0.0);
		emptyPart.setId(-1);
		emptyPart.setSourceFilePath("");
		emptyPart.setStartLine(0);
		emptyPart.setEndLine(0);
		emptyPart.setInSystemFile(false);

		// 1. Downloads all the files at once.
		File directory = Files.createTempDir();
		Set<String> implementationFiles = new HashSet<>();
		Set<String> headerFiles = new HashSet<>();
		Map<String, String> filesMap = new HashMap<>();
		Set<String> standardHeaders = new HashSet<>();
		for (Entry<String, Boolean> i : adss.getACTCConnector().getFiles().entrySet())
		{
			// Create the temporary files.
			String path = i.getKey().substring(FilenameUtils.getPrefix(i.getKey()).length());
			path = FilenameUtils.concat(directory.getAbsolutePath(), FilenameUtils.separatorsToSystem(path));
			File file = new File(path);
			file.getParentFile().mkdirs();
			file.deleteOnExit();
			PrintWriter writer = new PrintWriter(file);
			writer.print(adss.getRunner().readFile(i.getKey()));
			writer.close();
			if (i.getKey().endsWith(".c") || i.getKey().endsWith(".C") || i.getKey().endsWith(".cpp") || i.getKey().endsWith(".CPP")
					|| i.getKey().endsWith(".cc") || i.getKey().endsWith(".cxx"))
			{
				implementationFiles.add(path);
				filesMap.put(path, i.getKey());
			}
			else if (i.getKey().endsWith(".h") || i.getKey().endsWith(".H"))
			{
				headerFiles.add(path);
				filesMap.put(path, i.getKey());
			}
			if (!i.getValue())
				standardHeaders.add(i.getKey());
		}

		// 2. Creates the translation units.
		Collection<String> inclusionDirectories = new HashSet<>();
		for (String i : adss.getACTCConnector().getInclusionDirectories())
			inclusionDirectories.add(directory.getAbsolutePath() + i);

		Map<String, IASTTranslationUnit> unitMap = new HashMap<>();
		for (String i : implementationFiles)
		{
			FileContent fileContent = FileContent.createForExternalFileLocation(i);
			Map<String, String> definedSymbols = new HashMap<>();
			String[] includePaths = inclusionDirectories.toArray(new String[] {});
			IScannerInfo info = new ScannerInfo(definedSymbols, includePaths);
			IncludeFileContentProvider emptyIncludes = new SavedFilesProvider();
			int opts = 8;
			IParserLogService logService = new DefaultLogService();
			IASTTranslationUnit translationUnit = null;
			if (i.endsWith(".c") || i.endsWith(".C"))
				translationUnit = GCCLanguage.getDefault().getASTTranslationUnit(fileContent, info, emptyIncludes, null, opts, logService);
			else if (i.endsWith(".cpp") || i.endsWith(".CPP") || i.endsWith(".cc") || i.endsWith(".cxx"))
				translationUnit = GPPLanguage.getDefault().getASTTranslationUnit(fileContent, info, emptyIncludes, null, opts, logService);
			if (translationUnit != null)
				unitMap.put(i, translationUnit);
		}
		log.info("Sources acquired : " + implementationFiles.size() + " implementation files, " + headerFiles.size() + " headers");

		// 2. Finds all the application parts.
		Set<String> locations = new HashSet<>();
		Map<ASTNode, ApplicationPart> functionMap = new HashMap<>();
		for (Entry<String, IASTTranslationUnit> i : unitMap.entrySet())
			findApplicationParts(i.getKey(), i.getValue(), functionMap, filesMap, standardHeaders, locations);
		log.info("Application parts parsed");

		// 3. Finds the uses.
		for (Entry<ASTNode, ApplicationPart> i : functionMap.entrySet())
			findUsesInFunction(i.getKey(), i.getValue(), emptyPart);
		log.info("Uses parsed");

		// 4. Finds the annotations.
		int counter = 0;
		for (Entry<String, IASTTranslationUnit> i : unitMap.entrySet())
			counter += findAnnotations(filesMap.get(i.getKey()), i.getValue(), counter);
		log.info("Annotations parsed");

		// 5. Finds the code blocks.
		for (Entry<ASTNode, ApplicationPart> i : functionMap.entrySet())
			findCodeBlocks(i.getKey(), i.getValue());
		log.info("Code blocks parsed");

		// 6. Performs the actions.
		int actionCount = 0;
		for (ApplicationPart i : functionMap.values())
			actionCount += performRules(i);
		log.info("Rules executed = " + actionCount);

		// 7. Updates the asset identifiers.
		updateIdentifiers();
	}

	/**
	 * Perform all the rules on a function.
	 * @param function
	 *            The function to analyze using the rules.
	 * @return The number of executed rules.
	 **/
	private int performRules(ApplicationPart function)
	{
		int count = 0;
		int generatedRegions = 0;

		for (Rule i : adss.getModel().getRules())
		{
			int matches = 0;
			for (FunctionDeclaration j : i.getFunctionDeclarations())
				for (UseTarget k : function.getUses())
					if (k.getTarget().getName().equals(j.getName()))
						++matches;

			if (matches == i.getFunctionDeclarations().size())
			{
				Collection<ApplicationPart> applicationParts = new ArrayList<>();
				if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB
						|| i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
					for (FunctionDeclaration j : i.getFunctionDeclarations())
						for (UseTarget k : function.getUses())
							if (k.getType() == UseType.CALLS && k.getTarget().getName().equals(j.getName())
									&& k.getParameters().size() == j.getParameters().size())
								for (int l = 0; l < k.getParameters().size(); ++l)
								{
									ApplicationPartType type = j.getParameters().get(l);
									if (type != ApplicationPartType.IGNORE)
										searchAndTag(k.getParameters().get(l), type, applicationParts);
								}
				if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB
						|| i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
				{
					ApplicationPart commonCode = searchCommonCode(function, applicationParts);
					if (commonCode != null)
					{
						if (commonCode.getType() == ApplicationPartType.FUNCTION)
						{
							ApplicationPart applicationPart = AkbFactory.eINSTANCE.createApplicationPart();
							applicationPart.setName(commonCode.getName() + ".R" + generatedRegions++);
							applicationPart.setType(ApplicationPartType.CODE_REGION);
							applicationPart.setDatumSize(0);
							applicationPart.setWeight(commonCode.getWeight());
							applicationPart.setIndex(-1);
							applicationPart.setSourceFilePath(commonCode.getSourceFilePath());
							applicationPart.setStartLine(commonCode.getBody().getStartLine());
							applicationPart.setEndLine(commonCode.getBody().getEndLine());
							applicationPart.getApplicationParts().addAll(commonCode.getApplicationParts());
							applicationPart.setDeclaringCode(commonCode);
							commonCode = applicationPart;
						}
						applicationParts.add(commonCode);
					}
				}
				// Creates the set.
				ApplicationPartSet set = AkbFactory.eINSTANCE.createApplicationPartSet();
				set.getApplicationParts().addAll(applicationParts);
				set.setAction(i.getAction());
				adss.getModel().getApplicationPartSets().add(set);
				++count;
			}
		}

		return count;
	}

	/**
	 * Searches the least common code that can access some variables.
	 * @param function
	 *            The function to check.
	 * @param applicationParts
	 *            The variables to check and the list that will be updated with the code.
	 * @return The common code or <code>null</code> if no such code exists.
	 **/
	private ApplicationPart searchCommonCode(ApplicationPart function, Collection<ApplicationPart> applicationParts)
	{
		List<ApplicationPart> functions = new ArrayList<>();
		functions.add(function);

		while (!functions.isEmpty())
		{
			ApplicationPart f = functions.get(0);
			functions.remove(0);

			boolean valid = true;
			for (ApplicationPart i : applicationParts)
				if (i.isDatum())
					if (search(f, i.getName()) == null)
						valid = false;
			if (valid)
				return f;
			else
				for (UseTarget i : f.getTargetOf())
					if (i.getType() == UseType.CALLS)
						functions.add(i.getUsedBy());
		}

		return null;
	}

	/**
	 * Searches a suitable variable for been tagged with a new type.
	 * @param applicationPart
	 *            The part where to start searching.
	 * @param type
	 *            The new type.
	 * @param applicationParts
	 *            The collection where the tagged application part will be added.
	 **/
	private void searchAndTag(ApplicationPart applicationPart, ApplicationPartType type, Collection<ApplicationPart> applicationParts)
	{
		if (applicationPart.getType() == ApplicationPartType.PARAMETER)
		{
			if (applicationPart.eContainer() != null && applicationPart.eContainer() instanceof ApplicationPart)
			{
				ApplicationPart function = (ApplicationPart) applicationPart.eContainer();
				for (UseTarget i : function.getTargetOf())
					if (i.getType() == UseType.CALLS && i.getParameters().size() > applicationPart.getIndex())
					{
						ApplicationPart target = i.getParameters().get(applicationPart.getIndex());
						searchAndTag(target, type, applicationParts);
					}
			}
		}
		else
		{
			applicationPart.setType(type);
			applicationParts.add(applicationPart);
		}
	}

	/**
	 * Parses the code blocks and update the AKB.
	 * @param function
	 *            The function definition.
	 * @param applicationPart
	 *            The application part to modify.
	 * @throws CoreException
	 *             If the source file cannot be parsed.
	 * @throws IOException
	 *             If the temporary file cannot be created.
	 **/
	private void findCodeBlocks(ASTNode function, ApplicationPart applicationPart) throws CoreException, IOException
	{
		if (function instanceof CPPASTFunctionDefinition)
			applicationPart.setBody(convert(((CPPASTFunctionDefinition) function).getBody(), applicationPart));
		else if (function instanceof CASTFunctionDefinition)
			applicationPart.setBody(convert(((CASTFunctionDefinition) function).getBody(), applicationPart));
	}

	/**
	 * Parses the annotations and update the AKB.
	 * @param sourceFile
	 *            The source file containing the declaration.
	 * @param translationUnit
	 *            The translation unit to use.
	 * @param baseCounter
	 *            The number of regions created so far.
	 * @return The number of regions created so far.
	 * @throws CoreException
	 *             If the source file cannot be parsed.
	 * @throws IOException
	 *             If the temporary file cannot be created.
	 **/
	private int findAnnotations(String sourceFile, IASTTranslationUnit translationUnit, int baseCounter) throws CoreException, IOException
	{
		int counter = 0;

		// Finds the annotations.
		IASTPreprocessorStatement[] preprocessorStatements = translationUnit.getAllPreprocessorStatements();

		Stack<ApplicationPart> stack = new Stack<>();

		for (IASTPreprocessorStatement j : preprocessorStatements)
			if (j.getRawSignature().startsWith("_Pragma"))
			{
				int p1 = j.getRawSignature().indexOf("(") + 1;
				int p2 = j.getRawSignature().lastIndexOf(")");
				String string = j.getRawSignature().substring(p1, p2).trim();
				string = string.substring(1, string.length() - 1).trim();
				if (string.trim().matches("ASPIRE\\s+begin.*"))
				{
					ApplicationPart container = searchCode(null, sourceFile, j.getFileLocation().getStartingLineNumber());
					if (container != null)
					{
						ApplicationPart asset = AkbFactory.eINSTANCE.createApplicationPart();
						asset.setSourceFilePath(sourceFile);
						asset.setStartLine(j.getFileLocation().getStartingLineNumber());
						asset.setEndLine(-1);
						asset.getProperties().addAll(parseProperties(string));
						asset.setWeight(parseWeight(string));
						asset.setId(-1);
						asset.setType(ApplicationPartType.CODE_REGION);
						asset.setName(container.getName() + ".r" + (baseCounter + counter++));
						container.getApplicationParts().add(asset);
						stack.push(asset);
					}
				}
				else if (string.trim().matches("ASPIRE\\s+end.*"))
				{
					ApplicationPart asset = stack.pop();
					asset.setEndLine(j.getFileLocation().getStartingLineNumber());
				}
			}

		ASTVisitor visitor = new ASTVisitor()
		{
			@Override
			public int visit(IASTDeclaration declaration)
			{
				if (declaration instanceof IASTSimpleDeclaration)
				{
					IASTSimpleDeclaration ast = (IASTSimpleDeclaration) declaration;
					for (IASTDeclarator j : ast.getDeclarators())
					{
						Pattern pattern = Pattern.compile(
								".+__attribute__\\s*\\(\\s*\\(\\s*ASPIRE\\s*\\(\\s*\"(.*)?\\s*\"\\s*\\)\\s*\\)\\s*\\).+", Pattern.DOTALL);
						Matcher matcher = pattern.matcher(j.getRawSignature());
						if (!matcher.matches())
							matcher = pattern.matcher(declaration.getRawSignature());
						if (matcher.matches())
						{
							String parent = null;
							for (IASTNode i = declaration.getParent(); i != null; i = i.getParent())
								if (i instanceof CASTFunctionDefinition)
								{
									parent = ((CASTFunctionDefinition) i).getDeclarator().getName().toString();
									break;
								}
								else if (i instanceof CPPASTFunctionDefinition)
								{
									parent = ((CPPASTFunctionDefinition) i).getDeclarator().getName().toString();
									break;
								}

							ApplicationPart asset = search(parent, j.getName().toString());
							if (asset != null)
							{
								asset.getProperties().addAll(parseProperties(matcher.group(1)));
								asset.setWeight(parseWeight(matcher.group(1)));
								asset.setId(-1);
							}
						}
					}
				}

				return super.visit(declaration);
			}
		};
		visitor.shouldVisitDeclarations = true;
		translationUnit.accept(visitor);

		return counter;
	}

	/**
	 * Parses a function to find its uses.
	 * @param definition
	 *            The function definition.
	 * @param function
	 *            The function application part.
	 * @param functionMap
	 *            The part map to use.
	 * @param emptyPart
	 *            The empty part.
	 **/
	private void findUsesInFunction(ASTNode definition, ApplicationPart function, ApplicationPart emptyPart)
	{
		for (IASTNode i : definition.getChildren())
			findUses(i, function, emptyPart);
	}

	/**
	 * Parses an AST node to find its uses.
	 * @param node
	 *            The node to analyze.
	 * @param function
	 *            The function application part.
	 * @param emptyPart
	 *            The empty part.
	 * @param functionMap
	 *            The part map to use.
	 **/
	private void findUses(IASTNode node, ApplicationPart function, ApplicationPart emptyPart)
	{
		for (IASTNode i : node.getChildren())
			findUses(i, function, emptyPart);

		if (node.getChildren().length == 0)
		{
			if (node instanceof CPPASTName)
			{
				CPPASTName name = (CPPASTName) node;
				IBinding binding = name.resolveBinding();
				ApplicationPart target = search(function, name.toString());
				if (name.isReference())
				{
					if (target != null && (binding instanceof CPPVariable || binding instanceof CPPParameter))
					{
						UseTarget useTarget = AkbFactory.eINSTANCE.createUseTarget();
						useTarget.setLine(node.getFileLocation().getStartingLineNumber());
						useTarget.setSourceFilePath(function.getSourceFilePath());
						useTarget.setTarget(target);
						useTarget.setType(UseType.ACCESSES);
						if (!Collections.addUnique(function.getUses(), useTarget))
							useTarget.setTarget(null);
					}
					else if (node.getParent() != null && node.getParent().getParent() instanceof CPPASTFunctionCallExpression)
					{
						CPPASTFunctionCallExpression call = (CPPASTFunctionCallExpression) node.getParent().getParent();
						List<ApplicationPart> parameters = new ArrayList<>();
						for (IASTInitializerClause i : call.getArguments())
							if (i instanceof CPPASTIdExpression)
							{
								CPPASTIdExpression expression = (CPPASTIdExpression) i;
								ApplicationPart parameter = search(function, expression.toString());
								if (parameter == null)
								{
									parameters.add(emptyPart);
									log.warning("Unable to locate the application part named " + expression.getRawSignature() + " in "
											+ call.getRawSignature());
								}
								else
									parameters.add(parameter);
							}
							else
								parameters.add(emptyPart);

						UseTarget useTarget = AkbFactory.eINSTANCE.createUseTarget();
						useTarget.setLine(node.getFileLocation().getStartingLineNumber());
						useTarget.setSourceFilePath(function.getSourceFilePath());
						if (target == null)
						{
							target = AkbFactory.eINSTANCE.createApplicationPart();
							target.setDeclaringCode(null);
							target.setName(name.toString());
							target.setType(ApplicationPartType.REFERENCE);
							target.setDatumSize(0);
							target.setWeight(0);
							target.setId(-1);
							target.setSourceFilePath("");
							target.setStartLine(0);
							target.setEndLine(0);
							target.setInSystemFile(true);
							adss.getModel().getApplicationParts().add(target);
						}
						useTarget.setTarget(target);
						useTarget.setType(UseType.CALLS);
						useTarget.getParameters().addAll(parameters);
						if (!Collections.addUnique(function.getUses(), useTarget))
							useTarget.setTarget(null);
					}
				}
			}
			else if (node instanceof CASTName)
			{
				CASTName name = (CASTName) node;
				IBinding binding = name.resolveBinding();
				ApplicationPart target = search(function, name.toString());
				if (name.isReference())
				{
					if (target != null && (binding instanceof CVariable || binding instanceof CParameter))
					{
						UseTarget useTarget = AkbFactory.eINSTANCE.createUseTarget();
						useTarget.setLine(node.getFileLocation().getStartingLineNumber());
						useTarget.setSourceFilePath(function.getSourceFilePath());
						useTarget.setTarget(target);
						useTarget.setType(UseType.ACCESSES);
						if (!Collections.addUnique(function.getUses(), useTarget))
							useTarget.setTarget(null);
					}
					else if (node.getParent() != null && node.getParent().getParent() instanceof CASTFunctionCallExpression)
					{
						CASTFunctionCallExpression call = (CASTFunctionCallExpression) node.getParent().getParent();
						List<ApplicationPart> parameters = new ArrayList<>();
						for (IASTInitializerClause i : call.getArguments())
							if (i instanceof CASTIdExpression)
							{
								CASTIdExpression expression = (CASTIdExpression) i;
								ApplicationPart parameter = search(function, expression.getName().toString());
								if (parameter == null)
									parameters.add(emptyPart);
								else
									parameters.add(parameter);
							}
							else
								parameters.add(emptyPart);

						UseTarget useTarget = AkbFactory.eINSTANCE.createUseTarget();
						useTarget.setLine(node.getFileLocation().getStartingLineNumber());
						useTarget.setSourceFilePath(function.getSourceFilePath());
						if (target == null)
						{
							target = AkbFactory.eINSTANCE.createApplicationPart();
							target.setDeclaringCode(null);
							target.setName(name.toString());
							target.setType(ApplicationPartType.REFERENCE);
							target.setDatumSize(0);
							target.setWeight(0);
							target.setId(-1);
							target.setSourceFilePath("");
							target.setStartLine(0);
							target.setEndLine(0);
							target.setInSystemFile(true);
							adss.getModel().getApplicationParts().add(target);
						}
						useTarget.setTarget(target);
						useTarget.setType(UseType.CALLS);
						useTarget.getParameters().addAll(parameters);
						if (!Collections.addUnique(function.getUses(), useTarget))
							useTarget.setTarget(null);
					}
				}
			}
		}
	}

	/**
	 * Searches a suitable application part with a certain name in a scope.
	 * @param function
	 *            The function scope or <code>null</code> for the global scope.
	 * @param string
	 *            The application part name to search for.
	 * @return The suitable application part or <code>null</code> if no such part exists.
	 **/
	private ApplicationPart search(ApplicationPart function, String string)
	{
		if (function != null)
			for (ApplicationPart i : function.getApplicationParts())
				if (i.getName().equals(string))
					return i;

		for (ApplicationPart i : adss.getModel().getApplicationParts())
			if (i.getName().equals(string))
				return i;

		return null;
	}

	/**
	 * Finds all the application parts in a file and updates the AKB.
	 * @param sourceFile
	 *            The source file containing the declaration.
	 * @param translationUnit
	 *            The translation unit to use.
	 * @param functionMap
	 *            The function map to fill.
	 * @param filesMap
	 *            The files map.
	 * @param standardHeaders
	 *            The standard headers.
	 * @param locations
	 *            The locations analyzed so far.
	 * @throws CoreException
	 *             If the source file cannot be parsed.
	 * @throws IOException
	 *             If the temporary file cannot be created.
	 **/
	private void findApplicationParts(String sourceFile, IASTTranslationUnit translationUnit, Map<ASTNode, ApplicationPart> functionMap,
			Map<String, String> filesMap, Set<String> standardHeaders, Set<String> locations) throws CoreException, IOException
	{
		for (IASTDeclaration i : translationUnit.getDeclarations())
		{
			String location = i.getRawSignature() + " @ " + i.getFileLocation().getFileName() + " : "
					+ i.getFileLocation().getStartingLineNumber() + "-" + i.getFileLocation().getEndingLineNumber();
			if (!locations.contains(location))
			{
				if (i instanceof CPPASTFunctionDefinition)
					addFunction((CPPASTFunctionDefinition) i, filesMap, functionMap, standardHeaders);
				else if (i instanceof CASTFunctionDefinition)
					addFunction((CASTFunctionDefinition) i, filesMap, functionMap, standardHeaders);
				else if (i instanceof CPPASTSimpleDeclaration)
					addDatum(null, (CPPASTSimpleDeclaration) i, filesMap, standardHeaders);
				else if (i instanceof CASTSimpleDeclaration)
					addDatum(null, (CASTSimpleDeclaration) i, filesMap, standardHeaders);
				locations.add(location);
			}
		}
	}

	/**
	 * Adds a C++ function to the model and all its stuff.
	 * @param declaration
	 *            The function declaration.
	 * @param filesMap
	 *            The files map.
	 * @param functionMap
	 *            The function map to fill.
	 * @param standardHeaders
	 *            The standard headers.
	 **/
	private void addFunction(CPPASTFunctionDefinition declaration, Map<String, String> filesMap, Map<ASTNode, ApplicationPart> functionMap,
			Set<String> standardHeaders)
	{
		String fileName = filesMap.get(declaration.getFileLocation().getFileName());
		if (adss.getModel().getPreferences().isParserSystemFilesIgnoration() && standardHeaders.contains(fileName))
			return;

		ApplicationPart applicationPart = AkbFactory.eINSTANCE.createApplicationPart();
		applicationPart.setDeclaringCode(null);
		applicationPart.setName(declaration.getDeclarator().getName().toString());
		applicationPart.setType(ApplicationPartType.FUNCTION);
		applicationPart.setDatumSize(computeSize(declaration.getDeclarator()));
		applicationPart.setWeight(1);
		applicationPart.setIndex(-1);
		applicationPart.setSourceFilePath(fileName);
		applicationPart.setStartLine(declaration.getFileLocation().getStartingLineNumber());
		applicationPart.setEndLine(declaration.getFileLocation().getEndingLineNumber());
		applicationPart.setInSystemFile(standardHeaders.contains(fileName));
		adss.getModel().getApplicationParts().add(applicationPart);
		functionMap.put(declaration, applicationPart);

		CPPASTFunctionDeclarator declarator = (CPPASTFunctionDeclarator) declaration.getDeclarator();
		int index = 0;
		for (ICPPASTParameterDeclaration i : declarator.getParameters())
			if (!i.getDeclarator().getName().toString().isEmpty())
			{
				ApplicationPart parameter = AkbFactory.eINSTANCE.createApplicationPart();
				parameter.setDeclaringCode(applicationPart);
				parameter.setName(i.getDeclarator().getName().toString());
				parameter.setType(ApplicationPartType.PARAMETER);
				applicationPart.setDatumSize(computeSize(i.getDeclarator()));
				parameter.setWeight(1);
				parameter.setIndex(index++);
				parameter.setSourceFilePath(applicationPart.getSourceFilePath());
				parameter.setStartLine(i.getFileLocation().getStartingLineNumber());
				parameter.setEndLine(i.getFileLocation().getEndingLineNumber());
				parameter.setInSystemFile(applicationPart.isInSystemFile());
				applicationPart.getApplicationParts().add(parameter);
			}
		findApplicationParts(applicationPart, declaration.getBody(), filesMap, functionMap, standardHeaders);
		log.finest("New C++ function = " + applicationPart.getName());
	}

	/**
	 * Adds a C function to the model and all its stuff.
	 * @param declaration
	 *            The function declaration.
	 * @param filesMap
	 *            The files map.
	 * @param functionMap
	 *            The function map to fill.
	 * @param standardHeaders
	 *            The standard headers.
	 **/
	private void addFunction(CASTFunctionDefinition declaration, Map<String, String> filesMap, Map<ASTNode, ApplicationPart> functionMap,
			Set<String> standardHeaders)
	{
		String fileName = filesMap.get(declaration.getFileLocation().getFileName());
		if (adss.getModel().getPreferences().isParserSystemFilesIgnoration() && standardHeaders.contains(fileName))
			return;

		ApplicationPart applicationPart = AkbFactory.eINSTANCE.createApplicationPart();
		applicationPart.setDeclaringCode(null);
		applicationPart.setName(declaration.getDeclarator().getName().toString());
		applicationPart.setType(ApplicationPartType.FUNCTION);
		applicationPart.setDatumSize(computeSize(declaration.getDeclarator()));
		applicationPart.setWeight(1);
		applicationPart.setIndex(-1);
		applicationPart.setSourceFilePath(fileName);
		applicationPart.setStartLine(declaration.getFileLocation().getStartingLineNumber());
		applicationPart.setEndLine(declaration.getFileLocation().getEndingLineNumber());
		applicationPart.setInSystemFile(standardHeaders.contains(fileName));
		adss.getModel().getApplicationParts().add(applicationPart);
		functionMap.put(declaration, applicationPart);

		CASTFunctionDeclarator declarator = (CASTFunctionDeclarator) declaration.getDeclarator();
		int index = 0;
		for (IASTParameterDeclaration i : declarator.getParameters())
			if (!i.getDeclarator().getName().toString().isEmpty())
			{
				ApplicationPart parameter = AkbFactory.eINSTANCE.createApplicationPart();
				parameter.setDeclaringCode(applicationPart);
				parameter.setName(i.getDeclarator().getName().toString());
				parameter.setType(ApplicationPartType.PARAMETER);
				applicationPart.setDatumSize(computeSize(i.getDeclarator()));
				parameter.setWeight(1);
				parameter.setIndex(index++);
				parameter.setSourceFilePath(fileName);
				parameter.setStartLine(i.getFileLocation().getStartingLineNumber());
				parameter.setEndLine(i.getFileLocation().getEndingLineNumber());
				parameter.setInSystemFile(applicationPart.isInSystemFile());
				applicationPart.getApplicationParts().add(parameter);
			}
		findApplicationParts(applicationPart, declaration.getBody(), filesMap, functionMap, standardHeaders);
		log.finest("New C function = " + applicationPart.getName());
	}

	/**
	 * Finds the application parts in a node.
	 * @param code
	 *            The code declaring the node or <code>null</code> if the statement is global.
	 * @param node
	 *            The node to analyze.
	 * @param filesMap
	 *            The files map.
	 * @param functionMap
	 *            The function map to fill.
	 * @param standardHeaders
	 *            The standard headers.
	 **/
	private void findApplicationParts(ApplicationPart code, IASTNode node, Map<String, String> filesMap,
			Map<ASTNode, ApplicationPart> functionMap, Set<String> standardHeaders)
	{
		if (node instanceof CPPASTDeclarationStatement)
		{
			CPPASTDeclarationStatement declaration = (CPPASTDeclarationStatement) node;
			if (declaration.getDeclaration() instanceof CPPASTSimpleDeclaration)
				addDatum(code, (CPPASTSimpleDeclaration) declaration.getDeclaration(), filesMap, standardHeaders);
		}
		else if (node instanceof CASTDeclarationStatement)
		{
			CASTDeclarationStatement declaration = (CASTDeclarationStatement) node;
			if (declaration.getDeclaration() instanceof CASTSimpleDeclaration)
				addDatum(code, (CASTSimpleDeclaration) declaration.getDeclaration(), filesMap, standardHeaders);
		}

		for (IASTNode i : node.getChildren())
			findApplicationParts(code, i, filesMap, functionMap, standardHeaders);
	}

	/**
	 * Adds a C++ datum to the model and all its stuff.
	 * @param code
	 *            The code declaring the datum or <code>null</code> if the datum is global.
	 * @param declaration
	 *            The datum declaration.
	 * @param filesMap
	 *            The files map.
	 * @param standardHeaders
	 *            The standard headers.
	 **/
	private void addDatum(ApplicationPart code, CPPASTSimpleDeclaration declaration, Map<String, String> filesMap,
			Set<String> standardHeaders)
	{
		String fileName = filesMap.get(declaration.getFileLocation().getFileName());
		if (adss.getModel().getPreferences().isParserSystemFilesIgnoration() && standardHeaders.contains(fileName))
			return;

		if (!declaration.getRawSignature().matches("\\s*extern\\s+.+"))
			for (IASTDeclarator j : declaration.getDeclarators())
				if (!(j instanceof CPPASTFunctionDeclarator))
				{
					ApplicationPart applicationPart = AkbFactory.eINSTANCE.createApplicationPart();
					applicationPart.setDeclaringCode(code);
					applicationPart.setName(j.getName().toString());
					applicationPart.setType(ApplicationPartType.GENERIC_VARIABLE);
					if (j instanceof CPPASTArrayDeclarator || j.getPointerOperators().length > 0)
					{
						if (declaration.getDeclSpecifier() instanceof CPPASTSimpleDeclSpecifier)
						{
							int type = ((CPPASTSimpleDeclSpecifier) declaration.getDeclSpecifier()).getType();
							if (type == CPPASTSimpleDeclSpecifier.t_char || type == CPPASTSimpleDeclSpecifier.t_wchar_t
									|| type == CPPASTSimpleDeclSpecifier.t_char16_t || type == CPPASTSimpleDeclSpecifier.t_char32_t
									|| type == CPPASTSimpleDeclSpecifier.t_int || type == CPPASTSimpleDeclSpecifier.t_int128)
							{
								if (declaration.getRawSignature().matches("\\s*static\\s+.+"))
									applicationPart.setType(ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM);
								else
									applicationPart.setType(ApplicationPartType.INTEGER_ARRAY_DATUM);
							}
						}
					}
					else
					{
						if (declaration.getDeclSpecifier() instanceof CPPASTSimpleDeclSpecifier)
						{
							int type = ((CPPASTSimpleDeclSpecifier) declaration.getDeclSpecifier()).getType();
							if (type == CPPASTSimpleDeclSpecifier.t_char || type == CPPASTSimpleDeclSpecifier.t_wchar_t
									|| type == CPPASTSimpleDeclSpecifier.t_char16_t || type == CPPASTSimpleDeclSpecifier.t_char32_t
									|| type == CPPASTSimpleDeclSpecifier.t_int || type == CPPASTSimpleDeclSpecifier.t_int128)
								applicationPart.setType(ApplicationPartType.INTEGER_DATUM);
						}
					}
					applicationPart.setWeight(1);
					applicationPart.setIndex(-1);
					applicationPart.setSourceFilePath(fileName);
					applicationPart.setStartLine(j.getFileLocation().getStartingLineNumber());
					applicationPart.setEndLine(j.getFileLocation().getEndingLineNumber());
					applicationPart.setDatumSize(computeSize(j));
					applicationPart.setInSystemFile(standardHeaders.contains(fileName));
					if (declaration.getDeclSpecifier().isConst())
						applicationPart.getProperties().add(Property.HARDCODED);
					if (code == null)
						adss.getModel().getApplicationParts().add(applicationPart);
					log.finest("New C datum = " + applicationPart.getName());
				}
	}

	/**
	 * Adds a C datum to the model and all its stuff.
	 * @param code
	 *            The code declaring the datum or <code>null</code> if the datum is global.
	 * @param declaration
	 *            The datum declaration.
	 * @param filesMap
	 *            The files map.
	 * @param standardHeaders
	 *            The standard headers.
	 **/
	private void addDatum(ApplicationPart code, CASTSimpleDeclaration declaration, Map<String, String> filesMap,
			Set<String> standardHeaders)
	{
		String fileName = filesMap.get(declaration.getFileLocation().getFileName());
		if (adss.getModel().getPreferences().isParserSystemFilesIgnoration() && standardHeaders.contains(fileName))
			return;

		if (!declaration.getRawSignature().matches("\\s*extern\\s+.+"))
			for (IASTDeclarator j : declaration.getDeclarators())
				if (!(j instanceof CASTFunctionDeclarator))
				{
					ApplicationPart applicationPart = AkbFactory.eINSTANCE.createApplicationPart();
					applicationPart.setDeclaringCode(code);
					applicationPart.setName(j.getName().toString());
					applicationPart.setType(ApplicationPartType.GENERIC_VARIABLE);
					if (j instanceof CASTArrayDeclarator || j.getPointerOperators().length > 0)
					{
						if (declaration.getDeclSpecifier() instanceof CASTSimpleDeclSpecifier)
						{
							int type = ((CASTSimpleDeclSpecifier) declaration.getDeclSpecifier()).getType();
							if (type == CASTSimpleDeclSpecifier.t_char || type == CASTSimpleDeclSpecifier.t_wchar_t
									|| type == CASTSimpleDeclSpecifier.t_char16_t || type == CASTSimpleDeclSpecifier.t_char32_t
									|| type == CASTSimpleDeclSpecifier.t_int || type == CASTSimpleDeclSpecifier.t_int128)
							{
								if (declaration.getRawSignature().matches("\\s*static\\s+.+"))
									applicationPart.setType(ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM);
								else
									applicationPart.setType(ApplicationPartType.INTEGER_ARRAY_DATUM);
							}
						}
					}
					else
					{
						if (declaration.getDeclSpecifier() instanceof CASTSimpleDeclSpecifier)
						{
							int type = ((CASTSimpleDeclSpecifier) declaration.getDeclSpecifier()).getType();
							if (type == CASTSimpleDeclSpecifier.t_char || type == CASTSimpleDeclSpecifier.t_wchar_t
									|| type == CASTSimpleDeclSpecifier.t_char16_t || type == CASTSimpleDeclSpecifier.t_char32_t
									|| type == CASTSimpleDeclSpecifier.t_int || type == CASTSimpleDeclSpecifier.t_int128)
								applicationPart.setType(ApplicationPartType.INTEGER_DATUM);
						}
					}
					applicationPart.setWeight(1);
					applicationPart.setIndex(-1);
					applicationPart.setSourceFilePath(fileName);
					applicationPart.setStartLine(j.getFileLocation().getStartingLineNumber());
					applicationPart.setEndLine(j.getFileLocation().getEndingLineNumber());
					applicationPart.setDatumSize(computeSize(j));
					applicationPart.setInSystemFile(standardHeaders.contains(fileName));
					if (declaration.getDeclSpecifier().isConst())
						applicationPart.getProperties().add(Property.HARDCODED);
					if (code == null)
						adss.getModel().getApplicationParts().add(applicationPart);
					log.finest("New C datum = " + applicationPart.getName());
				}
	}

	/**
	 * Computes the size of a variable.
	 * @param declarator
	 *            The variable declarator.
	 * @return The size of the variable in bytes or zero if the computation cannot be done.
	 **/
	private int computeSize(IASTDeclarator declarator)
	{
		if (declarator.getPointerOperators().length == 0)
			return computeSize(declarator.getName().resolveBinding());
		else
			return 0;
	}

	/**
	 * Computes the size of a binding.
	 * @param binding
	 *            The binding.
	 * @return The size of the binding in bytes or zero if the computation cannot be done.
	 */
	private int computeSize(IBinding binding)
	{
		if (binding == null)
			return 0;
		else if (binding instanceof CVariable)
			return computeSize(((CVariable) binding).getType());
		else if (binding instanceof CPPVariable)
			return computeSize(((CPPVariable) binding).getType());
		else if (binding instanceof CTypedef)
			return computeSize(((CTypedef) binding).getType());
		else
			return 0;
	}

	/**
	 * Computes the size of a type.
	 * @param bindingtype
	 *            The type.
	 * @return The size of the type in bytes or zero if the computation cannot be done.
	 */
	private int computeSize(IType type)
	{
		if (type instanceof CBasicType)
		{
			CBasicType t = (CBasicType) type;
			return computeSize(t.getKind(), t.isShort(), t.isLong(), t.isLongLong());
		}
		else if (type instanceof CPPBasicType)
		{
			CPPBasicType t = (CPPBasicType) type;
			return computeSize(t.getKind(), t.isShort(), t.isLong(), t.isLongLong());
		}
		else if (type instanceof CTypedef)
		{
			CTypedef t = (CTypedef) type;
			return computeSize(t.getType());
		}
		else if (type instanceof CPPTypedef)
		{
			CPPTypedef t = (CPPTypedef) type;
			return computeSize(t.getType());
		}
		else if (type instanceof CArrayType)
		{
			CArrayType t = (CArrayType) type;
			if (t.getSize() != null && t.getSize().numericalValue() != null)
				return (int) (t.getSize().numericalValue() * computeSize(t.getType()));
		}
		else if (type instanceof CPPArrayType)
		{
			CPPArrayType t = (CPPArrayType) type;
			if (t.getSize() != null && t.getSize().numericalValue() != null)
				return (int) (t.getSize().numericalValue() * computeSize(t.getType()));
		}
		else if (type instanceof CQualifierType)
		{
			CQualifierType t = (CQualifierType) type;
			return computeSize(t.getType());
		}
		else if (type instanceof CPPQualifierType)
		{
			CPPQualifierType t = (CPPQualifierType) type;
			return computeSize(t.getType());
		}

		return 0;
	}

	/**
	 * Computes the size of a basic type.
	 * @param type
	 *            The type.
	 * @param isShort
	 *            Indicates if the type is marked as short.
	 * @param isLong
	 *            Indicates if the type is marked as long.
	 * @param isLongLong
	 *            Indicates if the type is marked as long long.
	 * @return The size of the type in bytes or zero if the computation cannot be done.
	 */
	private int computeSize(Kind type, boolean isShort, boolean isLong, boolean isLongLong)
	{
		for (IConfigurationElement i : Eclipse.getExtensions(Activator.ARCHITECTURES_ID))
			if (adss.getModel().getPreferences().getArchitecture().equals(i.getAttribute("name")))
			{
				if (type == Kind.eBoolean)
					return 1;
				else if (type == Kind.eChar)
					return 1;
				else if (type == Kind.eChar16)
					return 2;
				else if (type == Kind.eChar32)
					return 2;
				else if (type == Kind.eDecimal128)
					return 16;
				else if (type == Kind.eDecimal32)
					return 4;
				else if (type == Kind.eDecimal64)
					return 8;
				else if (type == Kind.eDouble)
				{
					if (isLong)
						return Integer.valueOf(i.getAttribute("sizeOfLongDouble"));
					else
						return Integer.valueOf(i.getAttribute("sizeOfDouble"));
				}
				else if (type == Kind.eFloat)
					return Integer.valueOf(i.getAttribute("sizeOfFloat"));
				else if (type == Kind.eInt)
				{
					if (isShort)
						return Integer.valueOf(i.getAttribute("sizeOfShortInt"));
					else if (isLong)
						return Integer.valueOf(i.getAttribute("sizeOfLongInt"));
					else if (isLongLong)
						return Integer.valueOf(i.getAttribute("sizeOfLongLongInt"));
					else
						return Integer.valueOf(i.getAttribute("sizeOfInt"));
				}
				else if (type == Kind.eInt128)
					return 16;
			}

		return 0;
	}

	/**
	 * Updates the asset identifiers. This method <b>must</b> be called if an asset is added or removed.
	 * @param solution
	 *            A solution containing some additional parts to update or <code>null</code> if no solution must be used.
	 **/
	public void updateIdentifiers()
	{
		for (ApplicationPart i : adss.getModel().getAllApplicationParts())
			i.setId(-1);

		List<ApplicationPart> chosenParts = new ArrayList<>();
		// Adds the assets, all the code regions and the application parts in their sets.
		for (ApplicationPart i : adss.getModel().getAllApplicationParts())
			if (i.isAsset() || i.getType() == ApplicationPartType.CODE_REGION)
			{
				chosenParts.add(i);
				for (ApplicationPartSet j : i.getSets())
					chosenParts.addAll(j.getApplicationParts());
			}

		chosenParts.sort(new Comparator<ApplicationPart>()
		{
			@Override
			public int compare(ApplicationPart p1, ApplicationPart p2)
			{
				int c1 = p1.getSourceFilePath().compareTo(p2.getSourceFilePath());
				int c2 = p1.getStartLine() - p2.getStartLine();

				if (c1 != 0)
					return c1;
				else
					return c2;
			}
		});

		for (int i = 0; i < chosenParts.size(); ++i)
			chosenParts.get(i).setId(i);
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(CDTConnector.class.getName());
}
