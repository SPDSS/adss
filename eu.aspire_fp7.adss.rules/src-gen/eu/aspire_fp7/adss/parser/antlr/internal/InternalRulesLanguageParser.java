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
package eu.aspire_fp7.adss.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import eu.aspire_fp7.adss.services.RulesLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRulesLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'if'", "','", "'then'", "'('", "')'", "'_'", "'cryptographicKey'", "'initializationVector'", "'plaintext'", "'ciphertext'", "'decrypt:AES128-CBC'", "'decrypt:AES128-ECB'", "'encrypt:AES128-CBC'", "'encrypt:AES128-ECB'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalRulesLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRulesLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRulesLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRulesLanguage.g"; }



     	private RulesLanguageGrammarAccess grammarAccess;

        public InternalRulesLanguageParser(TokenStream input, RulesLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected RulesLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalRulesLanguage.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalRulesLanguage.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalRulesLanguage.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalRulesLanguage.g:72:1: ruleModel returns [EObject current=null] : ( (lv_rules_0_0= ruleRule ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_0_0 = null;



        	enterRule();

        try {
            // InternalRulesLanguage.g:78:2: ( ( (lv_rules_0_0= ruleRule ) )* )
            // InternalRulesLanguage.g:79:2: ( (lv_rules_0_0= ruleRule ) )*
            {
            // InternalRulesLanguage.g:79:2: ( (lv_rules_0_0= ruleRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRulesLanguage.g:80:3: (lv_rules_0_0= ruleRule )
            	    {
            	    // InternalRulesLanguage.g:80:3: (lv_rules_0_0= ruleRule )
            	    // InternalRulesLanguage.g:81:4: lv_rules_0_0= ruleRule
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getRulesRuleParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_rules_0_0=ruleRule();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"rules",
            	    					lv_rules_0_0,
            	    					"eu.aspire_fp7.adss.RulesLanguage.Rule");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleRule"
    // InternalRulesLanguage.g:101:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalRulesLanguage.g:101:45: (iv_ruleRule= ruleRule EOF )
            // InternalRulesLanguage.g:102:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalRulesLanguage.g:108:1: ruleRule returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' )? otherlv_2= 'if' ( (lv_conditions_3_0= ruleCondition ) ) (otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) ) )* otherlv_6= 'then' ( (lv_action_7_0= ruleAction ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_conditions_3_0 = null;

        EObject lv_conditions_5_0 = null;

        Enumerator lv_action_7_0 = null;



        	enterRule();

        try {
            // InternalRulesLanguage.g:114:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' )? otherlv_2= 'if' ( (lv_conditions_3_0= ruleCondition ) ) (otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) ) )* otherlv_6= 'then' ( (lv_action_7_0= ruleAction ) ) ) )
            // InternalRulesLanguage.g:115:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' )? otherlv_2= 'if' ( (lv_conditions_3_0= ruleCondition ) ) (otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) ) )* otherlv_6= 'then' ( (lv_action_7_0= ruleAction ) ) )
            {
            // InternalRulesLanguage.g:115:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' )? otherlv_2= 'if' ( (lv_conditions_3_0= ruleCondition ) ) (otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) ) )* otherlv_6= 'then' ( (lv_action_7_0= ruleAction ) ) )
            // InternalRulesLanguage.g:116:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' )? otherlv_2= 'if' ( (lv_conditions_3_0= ruleCondition ) ) (otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) ) )* otherlv_6= 'then' ( (lv_action_7_0= ruleAction ) )
            {
            // InternalRulesLanguage.g:116:3: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRulesLanguage.g:117:4: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':'
                    {
                    // InternalRulesLanguage.g:117:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalRulesLanguage.g:118:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalRulesLanguage.g:118:5: (lv_name_0_0= RULE_ID )
                    // InternalRulesLanguage.g:119:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRuleRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,11,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getColonKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getIfKeyword_1());
            		
            // InternalRulesLanguage.g:144:3: ( (lv_conditions_3_0= ruleCondition ) )
            // InternalRulesLanguage.g:145:4: (lv_conditions_3_0= ruleCondition )
            {
            // InternalRulesLanguage.g:145:4: (lv_conditions_3_0= ruleCondition )
            // InternalRulesLanguage.g:146:5: lv_conditions_3_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getConditionsConditionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_conditions_3_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					add(
            						current,
            						"conditions",
            						lv_conditions_3_0,
            						"eu.aspire_fp7.adss.RulesLanguage.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRulesLanguage.g:163:3: (otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRulesLanguage.g:164:4: otherlv_4= ',' ( (lv_conditions_5_0= ruleCondition ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRulesLanguage.g:168:4: ( (lv_conditions_5_0= ruleCondition ) )
            	    // InternalRulesLanguage.g:169:5: (lv_conditions_5_0= ruleCondition )
            	    {
            	    // InternalRulesLanguage.g:169:5: (lv_conditions_5_0= ruleCondition )
            	    // InternalRulesLanguage.g:170:6: lv_conditions_5_0= ruleCondition
            	    {

            	    						newCompositeNode(grammarAccess.getRuleAccess().getConditionsConditionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_conditions_5_0=ruleCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRuleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conditions",
            	    							lv_conditions_5_0,
            	    							"eu.aspire_fp7.adss.RulesLanguage.Condition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getThenKeyword_4());
            		
            // InternalRulesLanguage.g:192:3: ( (lv_action_7_0= ruleAction ) )
            // InternalRulesLanguage.g:193:4: (lv_action_7_0= ruleAction )
            {
            // InternalRulesLanguage.g:193:4: (lv_action_7_0= ruleAction )
            // InternalRulesLanguage.g:194:5: lv_action_7_0= ruleAction
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getActionActionEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_action_7_0=ruleAction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					set(
            						current,
            						"action",
            						lv_action_7_0,
            						"eu.aspire_fp7.adss.RulesLanguage.Action");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleCondition"
    // InternalRulesLanguage.g:215:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalRulesLanguage.g:215:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalRulesLanguage.g:216:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalRulesLanguage.g:222:1: ruleCondition returns [EObject current=null] : this_FunctionDeclaration_0= ruleFunctionDeclaration ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDeclaration_0 = null;



        	enterRule();

        try {
            // InternalRulesLanguage.g:228:2: (this_FunctionDeclaration_0= ruleFunctionDeclaration )
            // InternalRulesLanguage.g:229:2: this_FunctionDeclaration_0= ruleFunctionDeclaration
            {

            		newCompositeNode(grammarAccess.getConditionAccess().getFunctionDeclarationParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_FunctionDeclaration_0=ruleFunctionDeclaration();

            state._fsp--;


            		current = this_FunctionDeclaration_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleFunctionDeclaration"
    // InternalRulesLanguage.g:240:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // InternalRulesLanguage.g:240:60: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // InternalRulesLanguage.g:241:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;

             current =iv_ruleFunctionDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDeclaration"


    // $ANTLR start "ruleFunctionDeclaration"
    // InternalRulesLanguage.g:247:1: ruleFunctionDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameters_2_0= ruleParameterType ) )? (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_parameters_2_0 = null;

        Enumerator lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalRulesLanguage.g:253:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameters_2_0= ruleParameterType ) )? (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) ) )* otherlv_5= ')' ) )
            // InternalRulesLanguage.g:254:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameters_2_0= ruleParameterType ) )? (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) ) )* otherlv_5= ')' )
            {
            // InternalRulesLanguage.g:254:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameters_2_0= ruleParameterType ) )? (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) ) )* otherlv_5= ')' )
            // InternalRulesLanguage.g:255:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameters_2_0= ruleParameterType ) )? (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) ) )* otherlv_5= ')'
            {
            // InternalRulesLanguage.g:255:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRulesLanguage.g:256:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRulesLanguage.g:256:4: (lv_name_0_0= RULE_ID )
            // InternalRulesLanguage.g:257:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_0_0, grammarAccess.getFunctionDeclarationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionDeclarationAccess().getLeftParenthesisKeyword_1());
            		
            // InternalRulesLanguage.g:277:3: ( (lv_parameters_2_0= ruleParameterType ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=17 && LA4_0<=21)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRulesLanguage.g:278:4: (lv_parameters_2_0= ruleParameterType )
                    {
                    // InternalRulesLanguage.g:278:4: (lv_parameters_2_0= ruleParameterType )
                    // InternalRulesLanguage.g:279:5: lv_parameters_2_0= ruleParameterType
                    {

                    					newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersParameterTypeEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_11);
                    lv_parameters_2_0=ruleParameterType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    					}
                    					add(
                    						current,
                    						"parameters",
                    						lv_parameters_2_0,
                    						"eu.aspire_fp7.adss.RulesLanguage.ParameterType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRulesLanguage.g:296:3: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRulesLanguage.g:297:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameterType ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_12); 

            	    				newLeafNode(otherlv_3, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRulesLanguage.g:301:4: ( (lv_parameters_4_0= ruleParameterType ) )
            	    // InternalRulesLanguage.g:302:5: (lv_parameters_4_0= ruleParameterType )
            	    {
            	    // InternalRulesLanguage.g:302:5: (lv_parameters_4_0= ruleParameterType )
            	    // InternalRulesLanguage.g:303:6: lv_parameters_4_0= ruleParameterType
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersParameterTypeEnumRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_parameters_4_0=ruleParameterType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_4_0,
            	    							"eu.aspire_fp7.adss.RulesLanguage.ParameterType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getFunctionDeclarationAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "ruleParameterType"
    // InternalRulesLanguage.g:329:1: ruleParameterType returns [Enumerator current=null] : ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'cryptographicKey' ) | (enumLiteral_2= 'initializationVector' ) | (enumLiteral_3= 'plaintext' ) | (enumLiteral_4= 'ciphertext' ) ) ;
    public final Enumerator ruleParameterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalRulesLanguage.g:335:2: ( ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'cryptographicKey' ) | (enumLiteral_2= 'initializationVector' ) | (enumLiteral_3= 'plaintext' ) | (enumLiteral_4= 'ciphertext' ) ) )
            // InternalRulesLanguage.g:336:2: ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'cryptographicKey' ) | (enumLiteral_2= 'initializationVector' ) | (enumLiteral_3= 'plaintext' ) | (enumLiteral_4= 'ciphertext' ) )
            {
            // InternalRulesLanguage.g:336:2: ( (enumLiteral_0= '_' ) | (enumLiteral_1= 'cryptographicKey' ) | (enumLiteral_2= 'initializationVector' ) | (enumLiteral_3= 'plaintext' ) | (enumLiteral_4= 'ciphertext' ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt6=1;
                }
                break;
            case 18:
                {
                alt6=2;
                }
                break;
            case 19:
                {
                alt6=3;
                }
                break;
            case 20:
                {
                alt6=4;
                }
                break;
            case 21:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalRulesLanguage.g:337:3: (enumLiteral_0= '_' )
                    {
                    // InternalRulesLanguage.g:337:3: (enumLiteral_0= '_' )
                    // InternalRulesLanguage.g:338:4: enumLiteral_0= '_'
                    {
                    enumLiteral_0=(Token)match(input,17,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getIGNOREEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getParameterTypeAccess().getIGNOREEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRulesLanguage.g:345:3: (enumLiteral_1= 'cryptographicKey' )
                    {
                    // InternalRulesLanguage.g:345:3: (enumLiteral_1= 'cryptographicKey' )
                    // InternalRulesLanguage.g:346:4: enumLiteral_1= 'cryptographicKey'
                    {
                    enumLiteral_1=(Token)match(input,18,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getCRYPTOGRAPHIC_KEYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getParameterTypeAccess().getCRYPTOGRAPHIC_KEYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRulesLanguage.g:353:3: (enumLiteral_2= 'initializationVector' )
                    {
                    // InternalRulesLanguage.g:353:3: (enumLiteral_2= 'initializationVector' )
                    // InternalRulesLanguage.g:354:4: enumLiteral_2= 'initializationVector'
                    {
                    enumLiteral_2=(Token)match(input,19,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getINITIALIZATION_VECTOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getParameterTypeAccess().getINITIALIZATION_VECTOREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRulesLanguage.g:361:3: (enumLiteral_3= 'plaintext' )
                    {
                    // InternalRulesLanguage.g:361:3: (enumLiteral_3= 'plaintext' )
                    // InternalRulesLanguage.g:362:4: enumLiteral_3= 'plaintext'
                    {
                    enumLiteral_3=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getPLAINTEXTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getParameterTypeAccess().getPLAINTEXTEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRulesLanguage.g:369:3: (enumLiteral_4= 'ciphertext' )
                    {
                    // InternalRulesLanguage.g:369:3: (enumLiteral_4= 'ciphertext' )
                    // InternalRulesLanguage.g:370:4: enumLiteral_4= 'ciphertext'
                    {
                    enumLiteral_4=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getCIPHERTEXTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getParameterTypeAccess().getCIPHERTEXTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "ruleAction"
    // InternalRulesLanguage.g:380:1: ruleAction returns [Enumerator current=null] : ( (enumLiteral_0= 'decrypt:AES128-CBC' ) | (enumLiteral_1= 'decrypt:AES128-ECB' ) | (enumLiteral_2= 'encrypt:AES128-CBC' ) | (enumLiteral_3= 'encrypt:AES128-ECB' ) ) ;
    public final Enumerator ruleAction() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRulesLanguage.g:386:2: ( ( (enumLiteral_0= 'decrypt:AES128-CBC' ) | (enumLiteral_1= 'decrypt:AES128-ECB' ) | (enumLiteral_2= 'encrypt:AES128-CBC' ) | (enumLiteral_3= 'encrypt:AES128-ECB' ) ) )
            // InternalRulesLanguage.g:387:2: ( (enumLiteral_0= 'decrypt:AES128-CBC' ) | (enumLiteral_1= 'decrypt:AES128-ECB' ) | (enumLiteral_2= 'encrypt:AES128-CBC' ) | (enumLiteral_3= 'encrypt:AES128-ECB' ) )
            {
            // InternalRulesLanguage.g:387:2: ( (enumLiteral_0= 'decrypt:AES128-CBC' ) | (enumLiteral_1= 'decrypt:AES128-ECB' ) | (enumLiteral_2= 'encrypt:AES128-CBC' ) | (enumLiteral_3= 'encrypt:AES128-ECB' ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt7=1;
                }
                break;
            case 23:
                {
                alt7=2;
                }
                break;
            case 24:
                {
                alt7=3;
                }
                break;
            case 25:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalRulesLanguage.g:388:3: (enumLiteral_0= 'decrypt:AES128-CBC' )
                    {
                    // InternalRulesLanguage.g:388:3: (enumLiteral_0= 'decrypt:AES128-CBC' )
                    // InternalRulesLanguage.g:389:4: enumLiteral_0= 'decrypt:AES128-CBC'
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getDECRYPT_AES128_CBCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getActionAccess().getDECRYPT_AES128_CBCEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRulesLanguage.g:396:3: (enumLiteral_1= 'decrypt:AES128-ECB' )
                    {
                    // InternalRulesLanguage.g:396:3: (enumLiteral_1= 'decrypt:AES128-ECB' )
                    // InternalRulesLanguage.g:397:4: enumLiteral_1= 'decrypt:AES128-ECB'
                    {
                    enumLiteral_1=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getDECRYPT_AES128_ECBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getActionAccess().getDECRYPT_AES128_ECBEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRulesLanguage.g:404:3: (enumLiteral_2= 'encrypt:AES128-CBC' )
                    {
                    // InternalRulesLanguage.g:404:3: (enumLiteral_2= 'encrypt:AES128-CBC' )
                    // InternalRulesLanguage.g:405:4: enumLiteral_2= 'encrypt:AES128-CBC'
                    {
                    enumLiteral_2=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getENCRYPT_AES128_CBCEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getActionAccess().getENCRYPT_AES128_CBCEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRulesLanguage.g:412:3: (enumLiteral_3= 'encrypt:AES128-ECB' )
                    {
                    // InternalRulesLanguage.g:412:3: (enumLiteral_3= 'encrypt:AES128-ECB' )
                    // InternalRulesLanguage.g:413:4: enumLiteral_3= 'encrypt:AES128-ECB'
                    {
                    enumLiteral_3=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getActionAccess().getENCRYPT_AES128_ECBEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getActionAccess().getENCRYPT_AES128_ECBEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000003F2000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000003E0000L});

}