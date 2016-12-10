#*******************************************************************************
# Copyright (c) 2016 Politecnico di Torino.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     Politecnico di Torino - initial API and implementation
#*******************************************************************************
% This file contains the minimum set of needed clauses.

% Dynamic and multifile clauses.
:- dynamic fact/1.
:- multifile fact/1.
:- multifile attackStep/4.
:- dynamic application/1.
:- dynamic contains/2.                                     
:- dynamic code/1.                                         
:- dynamic datum/1.                                        
:- dynamic accesses/2.                                     
:- dynamic isAccessedBy/2.                                 
:- dynamic decrypts/2.                                     
:- dynamic isDecryptedBy/2.                                
:- dynamic enforcesExecutionOnlyOnceAfterInstall/2.        
:- dynamic hasExecutionOnlyAfterInstallEnforcedBy/2.       
:- dynamic initializes/2.                                  
:- dynamic isInitializedBy/2.                              
:- dynamic receivesFromServerAsCypherText/2.               
:- dynamic receivesFromServerAsPlainText/2.                
:- dynamic enables/2.                                      
:- dynamic isEnabledBy/2.                                  
:- dynamic hasProperty/2.                                  
:- dynamic calls/2.                                        
:- dynamic isCalledBy/2.                                   

% Finds an attack path that can reach a fact.
getAttackPath(Fact, Path) :-
	getAttackPath([Fact], [], Path).

% Finds an attack path that can reach a KB.
getAttackPath([], Acc, Acc).
getAttackPath(KB, Acc, Path) :-
	attackStep(Step, Requirements, Productions, _),
	% At least one production must be in the KB.
	forall(member(Production, Productions), assertz(fact(Production))),
	findall(Production, fact(Production), XProductions),
	intersection(XProductions, KB, Intersection),
	forall(member(Production, Productions), retract(fact(Production))),
	Intersection \== [],
	% Delete the productions.
	subtract(KB, XProductions, KB2),
	% Add the requirements.
	append(KB2, Requirements, KB3),
	% Redo.
	getAttackPath(KB3, [Step|Acc], Path).
