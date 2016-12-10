Solution solver preferences
===========================

The *solution solver* is in charge of finding the golden solution. It uses a minimax approach to achieve this goal.

All the parameters are stored in the eu.aspire_fp7.adss.akb.Preferences class contained both in the ADSS model and in
the AKB.

Pre-pruning
-----------

The pre-pruning is performed before the search is started. This can significantly impact the performances.

<dl>
	<dt>`includedProtectionObjectivesRemoval`: boolean</dt>
	<dd>
		Removes the included protection objectives.<br/>
		A PO is included in another one if there is a containment relationship, they share the same property and the
		including asset has a weight greater than or equal to the included one.<br/>
		Enabling this option can lead to better performances without discarding interesting results.<br/>
		It is *safe* to enable this option.
	</dd>
</dl>

Main search
-----------

These options influences how the basic algorithm (an iterative deepening alpha-beta minimax search variant) works.

The options are:

<dl>
	<dt>`maximumMainSearchDepth`: integer > 0</dt>
	<dd>
		The maximum depth of the main search. This is a *hard* limit.<br/>
		If this value is 1 the attacks simulation is skipped.<br/>
		Higher values lead to better solutions, but they decreases the performances exponentially.
	</dd>
	<dt>`timeout`: integer or null</dt>
	<dd>
		The maximum research timeout in milliseconds.<br/>
		This is a timeout checked only when a new deeper search must be performed. It is *not* an absolute timeout.<br/>
		The `null` value or zero means positive infinity.
	</dd>
	<dt>`solutionsCount`: integer > 0</dt>
	<dd>
		The maximum number of solutions to report.<br/>
		Using very big values can lead to slow-downs and an increased memory overhead.
	</dd>
	<dt>`minimumProfilesPerProtectionObjective`: integer > 0</dt>
	<dd>
		The minimum number of profiles per PO.<br/>
		This is a *soft* limit. If a PO does not have enough profiles, this value is down-graded accordingly.<br/>
		Higher values lead to slightly increased performances but can also discard some potentially interesting
		solutions.
	</dd>
	<dt>`maximumProfilesPerProtectionObjective`: integer > 0 or null</dt>
	<dd>
		The maximum number of profiles per PO.<br/>
		The `null` value means positive infinity.<br/>
		This is a *hard* limit.<br/>
		Lower values lead to seriously increased performances but can also discard a lot of potentially interesting
		solutions.
	</dd>
	<dt>`minimumAttackMitigation`: low, medium or high</dt>
	<dd>
		The minimum allowed mitigation level for a protection to be used.<br/>
		Higher values lead to increased performances but can also discard some potentially interesting solutions.
	</dd>
	<dt>`mainSearchMinimumRisk`: integer or null</dt>
	<dd>
		The minimum risk of an attack to be taken into account.<br/>
		The `null` value means negative infinity.<br/>
		Higher values significantly increase the performances, but can discard a lot of interesting solutions.
	</dd>
</dl>

Aspiration window
------------------

The basic search algorithm is an alpha-beta minimax search, that is a branch-and-bound optimization technique. In short
we use a window to search the tree and at each iteration we update the window, discarding some nodes accordingly. At the
end the window coincide with the golden solution score.

Usually we start with an initial window of \f$(-\infty, +\infty)\f$ but we can also start with a smaller window, an
*aspiration window*, in order to make the things faster. The problem is that if the golden solution score is not inside
the window we must redo another search increasing the window size.

If a research must be done, we increase/decrease only the offending bound by a value that is computed with the formula
\f$\pm \delta \cdot factor^{iteration}\f$.

The options are:

<dl>
	<dt>`initialAlpha`: float or null</dt>
	<dd>
		The initial alpha (lower-bound) for the aspiration window.<br/>
		The `null` value means negative infinity.<br/>
		Putting this value slightly lower than the expected golden solution score leads to massive performance
		improvements, otherwise the search speed will decrease significantly.
	</dd>
	<dt>`initialBeta`: float or null</dt>
	<dd>
		The initial beta (upper-bound) for the aspiration window.<br/>
		The `null` value means positive infinity.<br/>
		Putting this value slightly higher than the expected golden solution score leads to massive performance
		improvements, otherwise the search speed will decrease significantly.
	</dd>
	<dt>`researchDelta`: float > 0</dt>
	<dd>
		The delta value for the research.<br/>
		Using too small values can significantly decrease the performances.
	</dd>
	<dt>`researchFactor`: float > 0</dt>
	<dd>
		The factor value for the research.<br/>
		Using too small values can significantly decrease the performances.
	</dd>
</dl>

Quiescence search
-----------------

The *quiescence search* is performed after the main search. Its job is to reduce the horizon effect and increase the
probability to pick-up the best solution. During this search we perform a very aggressive pruning and we analyze only
the most serious attacks.

Basically we discard all the attacks that does not pose a risk high enough. The risk however is reduced (only during
the quiescence search) by a value \f$fallout \cdot quiescenceDepth\f$.

The options are:

<dl>
	<dt>`maximumQuiescenceSearchDepth`: integer &ge; 0</dt>
	<dd>
		The maximum depth of the quiescence search. This is a *hard* limit.<br/>
		If this value is 0 the quiescence search is skipped.<br/>
		Higher values lead to better solutions, but they decreases the performances exponentially.
	</dd>
	<dt>`quiescenceSearchMinimumRisk`: integer or null</dt>
	<dd>
		The minimum risk of an attack to be taken into account.<br/>
		The `null` value means negative infinity.<br/>
		Higher values increase the performances, but can discard some interesting solutions.
	</dd>
	<dt>`quiescenceSearchFalloutDeltaRisk`: float > 0</dt>
	<dd>
		The fallout value used to decrease the risk.<br/>
		Higher values increase the performances, but can discard some interesting solutions.
	</dd>
</dl>

Transposition table
-------------------

A *transposition table* is a sort of cache for recurring state. Note that using a transposition table can enhance the
performances and can also lead to slightly more accurate results.

The options are:

<dl>
	<dt>`transpositionTableEnabled`: boolean</dt>
	<dd>
		Enables or disables the transposition table.<br/>
		Enabling this option can lead to better performances and slightly better solutions.</br>
		It is *safe* to enable this option.
	</dd>
	<dt>`transpositionTableMaxSize`: integer > 0</dt>
	<dd>
		The transposition table maximum size.<br/>
		Increasing this value can lead to better performances, but increases the memory overhead. 
	</dd>
</dl>

Futility pruning & co.
---------------------

The *futility pruning* is performed at frontier nodes, while the *extended futility pruning* at pre-frontier nodes. They
share the same idea though: discard a node if it seems not very threatening by using a margin value.

The options are:

<dl>
	<dt>`futilityPruningMargin`: float or null</dt>
	<dd>
		The futility pruning margin.<br/>
		The `null` value means negative infinity (disables the pruning).<br/>
		Higher values increase the performances at the cost of discarding potentially interesting solutions.
	</dd>
	<dt>`extendedFutilityPruningMargin`: integer > 0</dt>
	<dd>
		The extended futility pruning margin.<br/>
		The `null` value means negative infinity (disables the pruning).<br/>
		It should be bigger than the futility pruning margin.<br/>
		Higher values increase the performances at the cost of discarding potentially interesting solutions.
	</dd>
</dl>
