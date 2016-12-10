# Formulas

This page lists the formulas used in the evaluation process by the ADSS full with the simple evaluators.

## Attack path evaluation

Formulas:

	evaluate(attackPath) = (weight(asset(0)) + ...) * (evaluate(attackStep(0)) +  ...)

	evaluate(attackStep) = attackerExpertise / effort(attackStep)
Notes:

+ `evaluate(attackPath)` returns a non-negative value
+ an attack path contains a list of attack steps and affects a list of assets
+ an attack step has an effort formula, zero if empty
+ the `attackerExpertise` value is a constant depending on the attacker expertise level
