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
% This file contains the clauses regarding some base attacks.

% No si sa mai...
%string_concat('#{A[',CodeName,Formula2),
%string_concat(Formula2,']}',Formula).

% The attacker can execute his code, if the code has no limitations for its execution.
attackStep(executeCode(Code), Premises, [codeExecuted(Code)], '') :-
	code(Code),
	arg(1,Code,attacker),
	fact(noExecutionLimitedOnlyAfterInstall(Code,Premises1)),
	fact(noExecutionLimitedOnlyAfterBeingEnabled(Code,Premises2)),
	append(Premises1, Premises2, Premises),
	functor(Code,_,_).

% A code has been executed if another code that calls it has been executed.
fact(codeExecuted(Code)) :-
	code(Code),
	code(Code2),
	arg(1,Code,attacker),
	arg(1,Code2,attacker),
	calls(Code2,Code),
	fact(codeExecuted(Code2)).
		
fact(noExecutionLimitedOnlyAfterInstall(Code,Premises)):-
	code(Code),
	arg(1,Code,attacker),
	forall((code(LimiterCode),arg(1,LimiterCode,attacker),hasExecutionOnlyAfterInstallEnforcedBy(Code,LimiterCode)),
				(assertz(fact(premise(reinstallApplicationOrChangedCode(LimiterCode)))))),
	findall(Premise,fact(premise(Premise)),Premises),
	forall(member(PremiseToRetract,Premises),retract(fact(premise(PremiseToRetract)))).
	
fact(reinstallApplicationOrChangedCode(Code)) :-
	fact(changed(Code));
	(application(Application),
	contains(Application,Code),
	fact(applicationReinstalled(Application))).
	
attackStep(reinstallApplication(Application), [], [applicationReinstalled(Application)], '') :-
	application(Application),
	arg(1,Application,attacker),
	functor(Application,_,_).
	
fact(noExecutionLimitedOnlyAfterBeingEnabled(Code,Premises)):-
	code(Code),
	arg(1,Code,attacker),
	forall((code(LimiterCode),arg(1,LimiterCode,attacker),isEnabledBy(Code,LimiterCode)),
				(assertz(fact(premise(executedKnowingAllDataOrChangedCode(LimiterCode)))))),
	findall(Premise,fact(premise(Premise)),Premises),
	forall(member(PremiseToRetract,Premises),retract(fact(premise(PremiseToRetract)))).

fact(executedKnowingAllDataOrChangedCode(Code)) :-
	fact(changed(Code));
	(fact(codeExecuted(Code)), forall((datum(Datum),arg(1,Datum,victim),accesses(Code,Datum)),(fact(contentRetrieved(Datum))))).

% The attacker can statically locate a hardcoded part in its code.
attackStep(staticallyLocate(Part), [], [staticallyLocated(Part)], '10:0.1*SCZ') :-
	fact(attackerHardcodedAsset(Part)),
	functor(Part,_,_).
	
% The attacker can statically locate an hardcoded datum used by a code.
attackStep(staticallyLocate(Datum, Code), [contentStaticallyRetrieved(Code)], [staticallyLocated(Datum)], '10:0.1*SCZ') :-
	code(Code),
	datum(Datum),
	arg(1, Code, attacker),
	arg(1, Datum, attacker),
	accesses(Code, Datum),
	hasProperty(Datum, hardcoded),
	functor(Code,_,_),
	functor(Datum,_,_).
	
% The attacker can dynamically locate a part in its code, and therefore in the victim code.
attackStep(dynamicallyLocate(Code), [codeExecuted(Code)], [dynamicallyLocated(Code)], '20:0.5*SCZ+0.7*DCZ') :-
	code(Code),
	arg(1,Code,attacker),
	functor(Code,_,_).
	
% The attacker can dynamically locate a datum used by a code.
attackStep(dynamicallyLocate(Datum, Code), [codeExecuted(Code)], [dynamicallyLocated(Datum)], '20:0.5*SCZ+0.7*DCZ') :-
	code(Code),
	datum(Datum),
	arg(1, Code, attacker),
	arg(1, Datum, attacker),
	accesses(Code, Datum),
	functor(Code,_,_),
	functor(Datum,_,_).
	
% The attacker can statically change an hardcoded part of his copy of the application (code is hardcoded by definition).
attackStep(staticallyChange(Part), [staticallyLocated(Part)], [staticallyChanged(Part)], '5:0.6*SCZ') :-
	fact(attackerHardcodedAsset(Part)),
	functor(Part,_,_).

% The attacker can dinamically change a part of his copy of the application.
attackStep(dynamicallyChange(Part), [dynamicallyLocated(Part)], [dynamicallyChanged(Part)], '10:0.4*SCZ+0.5*DCZ') :-
	fact(attackerAsset(Part)),
	functor(Part,_,_).

attackStep(readDatumAfterInitializazionAndDecryption(Datum), Premises, [datumCorrectlyRead(Datum)], '') :-
	fact(initialized(Datum,Premises1)),
	fact(plaintext(Datum,Premises2)),
	datum(Datum),
	code(Code),
	arg(1,Datum,attacker),
	arg(1,Code,attacker),
	forall((member(Premise,Premises1), not(member(Premise,Premises2))),(assertz(fact(premise5(Premise))))),
	findall(Premise2, fact(premise5(Premise2)), Premises3),
	forall(member(PremiseToRetract,Premises3),retract(fact(premise5(PremiseToRetract)))),
	append(Premises2,Premises3,PremisesTemp),
	append([dynamicallyLocated(Datum)],PremisesTemp,Premises),
	functor(Code,_,_),
	functor(Datum,_,_).
