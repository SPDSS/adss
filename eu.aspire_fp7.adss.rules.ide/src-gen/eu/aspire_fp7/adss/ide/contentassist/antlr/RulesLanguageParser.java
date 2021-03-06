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
package eu.aspire_fp7.adss.ide.contentassist.antlr;

import com.google.inject.Inject;
import eu.aspire_fp7.adss.ide.contentassist.antlr.internal.InternalRulesLanguageParser;
import eu.aspire_fp7.adss.services.RulesLanguageGrammarAccess;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class RulesLanguageParser extends AbstractContentAssistParser {

	@Inject
	private RulesLanguageGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalRulesLanguageParser createParser() {
		InternalRulesLanguageParser result = new InternalRulesLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getParameterTypeAccess().getAlternatives(), "rule__ParameterType__Alternatives");
					put(grammarAccess.getActionAccess().getAlternatives(), "rule__Action__Alternatives");
					put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
					put(grammarAccess.getRuleAccess().getGroup_0(), "rule__Rule__Group_0__0");
					put(grammarAccess.getRuleAccess().getGroup_3(), "rule__Rule__Group_3__0");
					put(grammarAccess.getFunctionDeclarationAccess().getGroup(), "rule__FunctionDeclaration__Group__0");
					put(grammarAccess.getFunctionDeclarationAccess().getGroup_3(), "rule__FunctionDeclaration__Group_3__0");
					put(grammarAccess.getModelAccess().getRulesAssignment(), "rule__Model__RulesAssignment");
					put(grammarAccess.getRuleAccess().getNameAssignment_0_0(), "rule__Rule__NameAssignment_0_0");
					put(grammarAccess.getRuleAccess().getConditionsAssignment_2(), "rule__Rule__ConditionsAssignment_2");
					put(grammarAccess.getRuleAccess().getConditionsAssignment_3_1(), "rule__Rule__ConditionsAssignment_3_1");
					put(grammarAccess.getRuleAccess().getActionAssignment_5(), "rule__Rule__ActionAssignment_5");
					put(grammarAccess.getFunctionDeclarationAccess().getNameAssignment_0(), "rule__FunctionDeclaration__NameAssignment_0");
					put(grammarAccess.getFunctionDeclarationAccess().getParametersAssignment_2(), "rule__FunctionDeclaration__ParametersAssignment_2");
					put(grammarAccess.getFunctionDeclarationAccess().getParametersAssignment_3_1(), "rule__FunctionDeclaration__ParametersAssignment_3_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalRulesLanguageParser typedParser = (InternalRulesLanguageParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public RulesLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RulesLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
