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
/*
 * generated by Xtext 2.10.0
 */
package eu.aspire_fp7.adss.serializer;

import com.google.inject.Inject;
import eu.aspire_fp7.adss.rulesLanguage.FunctionDeclaration;
import eu.aspire_fp7.adss.rulesLanguage.Model;
import eu.aspire_fp7.adss.rulesLanguage.Rule;
import eu.aspire_fp7.adss.rulesLanguage.RulesLanguagePackage;
import eu.aspire_fp7.adss.services.RulesLanguageGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public class RulesLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RulesLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == RulesLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RulesLanguagePackage.FUNCTION_DECLARATION:
				sequence_FunctionDeclaration(context, (FunctionDeclaration) semanticObject); 
				return; 
			case RulesLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case RulesLanguagePackage.RULE:
				sequence_Rule(context, (Rule) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Condition returns FunctionDeclaration
	 *     FunctionDeclaration returns FunctionDeclaration
	 *
	 * Constraint:
	 *     (name=ID parameters+=ParameterType? parameters+=ParameterType*)
	 */
	protected void sequence_FunctionDeclaration(ISerializationContext context, FunctionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     rules+=Rule+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Rule returns Rule
	 *
	 * Constraint:
	 *     (name=ID? conditions+=Condition conditions+=Condition* action=Action)
	 */
	protected void sequence_Rule(ISerializationContext context, Rule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
