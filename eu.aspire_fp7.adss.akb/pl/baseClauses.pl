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
% This file contains some generic but useful clauses.

% An asset can be a code or a datum, and can belong to the attacker copy or to the victim copy.
fact(asset(Asset)) :-
	(code(Asset); datum(Asset)),
	(arg(1,Asset,victim); arg(1,Asset,attacker)).
fact(attackerAsset(Asset)) :-
	(code(Asset); datum(Asset)),
	arg(1,Asset,attacker).

% An asset is hardcoded if is a code or an hardcoded datum, and can belong to the attacker copy or to the victim copy.
fact(hardcodedAsset(Asset)) :-
	(code(Asset); (datum(Asset), hasProperty(Asset, hardcoded))),
	(arg(1,Asset,victim); arg(1,Asset,attacker)).
fact(attackerHardcodedAsset(Asset)) :-
	(code(Asset); (datum(Asset), hasProperty(Asset, hardcoded))),
	arg(1,Asset,attacker).
	
% If a part is hardcoded, or if a code that initializes a part is executed, the part is initialized.
fact(initialized(Part,Premises)) :-
	fact(asset(Part)),
	arg(1,Part,attacker),
	forall((code(Code), arg(1,Code,attacker), initializes(Code, Part)), assertz(fact(premise3(codeExecuted(Code))))),
	findall(Premise,fact(premise3(Premise)),Premises),
	forall(member(PremiseToRetract,Premises),retract(fact(premise3(PremiseToRetract)))).

% If a part is not encrypted, or if a code that decrypts the part is executed, the part is in plaintext.
fact(plaintext(Part,Premises)) :-
	fact(asset(Part)),
	arg(1,Part,attacker),
	forall((code(Code), arg(1,Code,attacker), (receivesFromServerAsCypherText(Code, Part); decrypts(Code,Part))), assertz(fact(premise4(codeExecuted(Code))))),
	findall(Premise,fact(premise4(Premise)),Premises),
	forall(member(PremiseToRetract,Premises),retract(fact(premise4(PremiseToRetract)))).

% To breach the integrity of an asset we must change it.
fact(breached(Asset, integrity)) :-
	hasProperty(Asset, integrity),
	fact(asset(Asset)),
	fact(changed(Asset)).
	
% To breach the confidentiality of an asset we must know its content from the victim.
fact(breached(Asset, confidentiality)) :-
	hasProperty(Asset, confidentiality),
	fact(asset(Asset)),
	fact(contentRetrieved(Asset)).%,
	%arg(1,Asset,victim).
	
% To breach hard confidentiality of a datum, which means knowing the value of a datum everytime, we must breach its confidentiality, and also we must know all the codes that modify its value.  
fact(breached(Asset, hardConfidentiality)) :-
	hasProperty(Asset, hardConfidentiality),
	fact(contentRetrieved(Asset)),
	(hasProperty(Asset,hardcoded); forall((code(Code),arg(1,Code,attacker),accesses(Code,Asset)),(fact(contentRetrieved(Code))))),
	datum(Asset).%,
	%arg(1,Asset,victim).
	
% To breach the privacy of an asset we must know its content from the victim.
fact(breached(Asset, privacy)) :-
	hasProperty(Asset, privacy),
	fact(asset(Asset)),
	fact(contentRetrieved(Asset)).%,
	%arg(1,Asset,victim).

% If a part was statically or dynamically located, well, it was located.
fact(located(Part)) :-
	fact(asset(Part)),
	(fact(staticallyLocated(Part)); fact(dynamicallyLocated(Part))).

% If a part was statically or dynamically changed, well, it was changed.
fact(changed(Part)) :-
	fact(asset(Part)),
	(fact(staticallyChanged(Part)); fact(dynamicallyChanged(Part))).
		
% If a part was statically or dynamically retrieved, well, it was retrieved.
fact(contentRetrieved(Part)):-
	fact(asset(Part)),
	(fact(contentStaticallyRetrieved(Part)); fact(contentDynamicallyRetrieved(Part))).
	
% If I known the dynamic location of a part, and the part has been initialized and if necessary decrypted, I know its content.
fact(contentDynamicallyRetrieved(Part1)) :-
	(
		fact(asset(Part1)),
		fact(datumCorrectlyRead(Part1))
	);
	(
		fact(hardcodedAsset(Part1)),
		fact(hardcodedAsset(Part2)),
		functor(Part1,PartName1,Arity1),
		functor(Part2,PartName2,Arity2),
		PartName1 = PartName2,
		Arity1 = Arity2,
		fact(dynamicallyLocated(Part2))
	);
	(
		datum(Part1),
		fact(received(Part1, attackerServer(stealServer)));fact(sniffed(Part1))
	).

% If I known the static or dynamic location of an hardcoded part I know its content, that is equal on the attacker and on the victim copy.
fact(contentStaticallyRetrieved(Part1)) :-
	(
		fact(hardcodedAsset(Part1)),
		fact(staticallyLocated(Part1))
	);
	(
		fact(hardcodedAsset(Part1)),
		fact(hardcodedAsset(Part2)),
		functor(Part1,PartName1,Arity1),
		functor(Part2,PartName2,Arity2),
		PartName1 = PartName2,
		Arity1 = Arity2,
		fact(staticallyLocated(Part2))
	).
