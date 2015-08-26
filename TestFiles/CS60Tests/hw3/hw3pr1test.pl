%%
%% file: hw3pr1.pl
%%
%% Submission site login:
%%
%% Hw 3, part 1

% some "nice" prolog settings...  see assignment
% description for the details on what these do
% -- but it's not crucial to know the details of these Prolog internals
:- set_prolog_flag( prompt_alternatives_on, groundness ).
:- set_prolog_flag(toplevel_print_options, [quoted(true),
     portray(true), attributes(portray), max_depth(999), priority(699)]).


%% Below you'll find some example predicates that
%% define family relationships, along with lots
%% of prolog-formatted facts about the Simpson family.
%% [Disclaimer: many of these Simpson facts are fiction.]

/*
 * Here are three example rules about families
 * Feel free to use these -- or to create new
 * helper predicates of your own...
 */

%% child(X,Y)
%%
%% X is a child of Y if Y is a parent of X
%
child(X, Y) :- parent(Y, X).

% The following tests can be run by typing:
% run_tests(child)
:- begin_tests(child).
test(childT1, [nondet]) :- child(bart, marge).
test(childT2, [nondet]) :- child(lisa, marge).
test(childT3, [nondet]) :- child(bart, homer).
test(childT4) :-
	setof(OneKid, child(OneKid, marge), AllKids),
	AllKids == [bart, lisa, maggie].
test(childT5) :-
	setof(OnePar, child(marge, OnePar), AllParents),
	AllParents == [jackie, john].
test(childT6) :- \+child(marge, homer).
test(childT7) :- \+child(jackie, _).
% add additional tests below:


:- end_tests(child).

%% mother(X,Y)
%%
%% X is a (the) mother of Y
%% if X is female and X is a parent of Y
%
mother(X, Y) :- female(X), parent(X, Y).

% The following tests can be run by typing:
% run_tests(mother)
:- begin_tests(mother).
test(motherT1, [nondet]) :- mother(marge, bart).
test(motherT2, [nondet]) :- mother(marge, lisa).
test(motherT3, [nondet]) :- mother(jackie, marge).
test(motherT4) :-
	setof(OneKid, mother(marge, OneKid), AllKids),
	AllKids == [bart, lisa, maggie].
test(motherT5) :- \+mother(marge, homer).
test(motherT6) :- \+mother(homer, _).
% add additional tests below:


:- end_tests(mother).



%% anc(X,Y)
%%
%% X is an ancestor of Y
%% if X is the parent of Y
%%    or X is an ancestor of Y's parent
%
anc(X, Y) :- parent(X, Y).
anc(X, Y) :- parent(Z, Y), anc(X, Z).


% The following tests can be run by typing:
% run_tests(anc)
:- begin_tests(anc).
test(ancT1, [nondet]) :- anc(marge,  bart).
test(ancT2, [nondet]) :- anc(jackie, bart).
test(ancT3, [nondet]) :- anc(homer,  bart).
test(ancT4) :-
	setof(OneAnc, anc(OneAnc, bart), AllAnc),
	AllAnc == [helga, homer, homericus, jackie, john,
		   marge, matilda, olf, ug, uggette].
test(ancT5) :- \+anc(marge, homer).

% add additional tests below:


:- end_tests(anc).



%% First are the signatures and placeholders for the
%% rules that this week's assignment asks you to write. For
%% each, replace the "fail." with the rules that define
%% the relationship appropriately.

%% Remember, in Prolog, you're defining what each
%% relationship _means_ more than _how_ to compute it!


/*
 * Here are four rules for you to define (and test!)
 */



%% grandparent(X, Y)
%%
%% this predicate should be true if X is a grandparent of Y
%
grandparent(X, Y) :- X==Y, fail.   % This is just a placeholder - replace it!


% The following tests can be run by typing:
% run_tests(grandparent)
:- begin_tests(grandparent).
test(grandparentT1, [nondet]) :- grandparent(jackie,  bart).
test(grandparentT2, [nondet]) :- grandparent(john,    bart).
test(grandparentT3, [nondet]) :- grandparent(helga,   homer).
test(grandparentT4) :-
	setof(OneGP, grandparent(OneGP, bart), AllGPs),
	AllGPs == [homericus,jackie,john,matilda].
test(grandparentT5) :- \+grandparent(marge, homer).
% add additional tests below:


:- end_tests(grandparent).



%% siblings(X, Y)
%%
%% this predicate should be true if X and Y are
%% siblings (but not the same person)
%
siblings(X, Y) :- X==Y, fail.   % This is just a placeholder - replace it!

% The following tests can be run by typing:
% run_tests(siblings)
:- begin_tests(siblings).
test(siblingsT1, [nondet]) :- siblings(bart,  lisa).
test(siblingsT2, [nondet]) :- siblings(lisa,  bart).
test(siblingsT3, [nondet]) :- siblings(gomer, homer).
test(siblingsT4) :-
	setof(OneSib, siblings(OneSib, bart), AllSibs),
	AllSibs == [lisa, maggie].
test(siblingsT5) :- \+siblings(jackie, _).
% add additional tests below:


:- end_tests(siblings).

%% cousins(X, Y)
%%
%% this predicate should be true if X and Y are
%% first cousins, but not siblings (or the same person!)
%
cousins(X, Y) :- X==Y, fail.   % This is just a placeholder - replace it!

% The following tests can be run by typing:
% run_tests(cousins)
:- begin_tests(cousins).
test(cousinsT1, [nondet]) :- cousins(bart,      millhouse).
test(cousinsT2, [nondet]) :- cousins(millhouse, bart).
test(cousinsT3, [nondet]) :- cousins(esmerelda, homer).
test(cousinsT4) :-
	setof(OneCousin, cousins(OneCousin, millhouse), AllCousins),
	AllCousins == [bart, lisa, maggie].
test(cousinsT5) :- \+cousins(jackie, _).
% add additional tests below:


:- end_tests(cousins).

%% hasDaughterAndSon(P)
%%
%% this predicate should be true if P has both a female
%% and a male child
%
hasDaughterAndSon(P) :- P==1, fail.   % This is just a placeholder - replace it!


% The following tests can be run by typing:
% run_tests(hasDaughterAndSon)
:- begin_tests(hasDaughterAndSon).
test(hasDaughterAndSonT1, [nondet]) :- hasDaughterAndSon(homer).
test(hasDaughterAndSonT2, [nondet]) :- hasDaughterAndSon(marge).
test(hasDaughterAndSonT3, [nondet]) :- hasDaughterAndSon(jackie).
test(hasDaughterAndSonT4) :-
	setof(OneParent, hasDaughterAndSon(OneParent), AllParents),
	AllParents == [cher, glum, homer, jackie, john, marge].
test(hasDaughterAndSonT5) :- \+hasDaughterAndSon(bart).
% add additional tests below:


:- end_tests(hasDaughterAndSon).



%% hasOlderSibling(X)
%%
%% this predicate should be true if X has a sibling
%% that is _strictly_ older than X
%
hasOlderSibling(X) :- X==1, fail.  % This is just a plceholder - replace it!

% The following tests can be run by typing:
% run_tests(hasOlderSibling)
:- begin_tests(hasOlderSibling).
test(hasOlderSiblingT1, [nondet]) :- hasOlderSibling(homer).
test(hasOlderSiblingT2, [nondet]) :- hasOlderSibling(marge).
test(hasOlderSiblingT3, [nondet]) :- hasOlderSibling(lisa).
test(hasOlderSiblingT4) :-
	setof(OneSib, hasOlderSibling(OneSib), AllSibs),
	AllSibs == [atropos, glum, homer, homericus,
		    lachesis, lisa, maggie, marge].
test(hasOlderSiblingT5) :- \+hasOlderSibling(bart).
% add additional tests below:


:- end_tests(hasOlderSibling).


%% hasYS(X)
%%
%% this predicate should be true if X has a sister
%% that is _strictly_ younger than X
%
hasYS(X) :- X==1, fail.  % This is just a plceholder - replace it!

% The following tests can be run by typing:
% run_tests(hasYS)
:- begin_tests(hasYS).
test(hasYST1) :- hasYS(bart).
test(hasYST2) :- hasYS(lisa).
test(hasYST3) :- hasYS(patty).
test(hasYST4) :-
	setof(OneSib, hasYS(OneSib), AllSibs),
	AllSibs == [atropos, bart, klotho, lisa,
		    patty, selma].
test(hasYST5) :- \+hasYS(maggie).
% add additional tests below:


:- end_tests(hasYS).


%% hasOlderCousin(X, GP)
%%
%% this predicate should be true if X has a cousin _through GP_
%% (both have GP has a grandparent) such that the cousin is
%% strictly older than X
%
% UPDATED!
hasOlderCousin(X, GP) :-  X==1, fail.  % This is just a plceholder - replace it!

% UPDATED!
% The following tests can be run by typing:
% run_tests(hasOlderCousin)
:- begin_tests(hasOlderCousin).
test(hasOlderCousinT1, [nondet]) :- hasOlderCousin(millhouse, _).
test(hasOlderCousinT2, [nondet]) :- hasOlderCousin(maggie, _).
test(hasOlderCousinT3, [nondet]) :- hasOlderCousin(homer, _).
test(hasOlderCousinT4) :-
	setof( [X,GP], hasOlderCousin(X,GP), Answer ),
	Answer = [[gomer,helga],[gomer,olf],[homer,helga],[homer,olf],[maggie,jackie],[maggie,john],[millhouse,jackie],[millhouse,john],[terpsichore,jackie],[terpsichore,john]] .
test(hasOlderCousinT5) :- \+hasOlderCousin(bart, _).
% add additional tests below:


:- end_tests(hasOlderCousin).



%% hasFirstGC(X)
%%
%% This is a little bit tricky... the predicate hasFirstGC(X)
%% is true if X has a parent Y and one of X's children is Y's OLDEST
%% grandchild, i.e., Y has no grandchildren older than X's oldest child.
%% However, this predicate should be FALSE (fail) if X has no children.
%% Similarly, this predicate should be FALSE (fail) if X has no parents.
%
hasFirstGC(X) :- X==1, fail.

% UPDATED!
% The following tests can be run by typing:
% run_tests(hasFirstGC)
:- begin_tests(hasFirstGC).
test(hasFirstGCT1, [nondet]) :- hasFirstGC(marge).
test(hasFirstGCT2, [nondet]) :- hasFirstGC(homer).
test(hasFirstGCT3, [nondet]) :- hasFirstGC(esmerelda).
test(hasFirstGCT4) :-
	setof( P, hasFirstGC(P), Answer ),
	Answer = [esmerelda, homer, marge, matilda, skug].
test(hasFirstGCT5) :- \+hasFirstGC(bart).
% add additional tests below:


:- end_tests(hasFirstGC).

/*
 * here are the primitive facts on which others are built...
 *
 * You will not need all of these for Hw3, but you
 * can infer a lot about the Simpsons with them!
 *
 * DO NOT MAKE ANY CHANGES BELOW!
 */


/*
 * the parent predicate
 */

parent(olf, skug).
parent(helga, skug).

parent(skug, esmerelda).
parent(skugerina, esmerelda).

parent(esmerelda, klotho).
parent(gemini, klotho).

parent(esmerelda, atropos).
parent(gemini, atropos).

parent(esmerelda, lachesis).
parent(gemini, lachesis).

parent(olf, homericus).
parent(helga, homericus).

parent(ug, matilda).
parent(uggette, matilda).

parent(homericus, homer).
parent(matilda, homer).

parent(homericus, gomer).
parent(matilda, gomer).

parent(homer, bart).
parent(marge, bart).

parent(homer, lisa).
parent(marge, lisa).

parent(homer, maggie).
parent(marge, maggie).

parent(john, marge).
parent(jackie, marge).

parent(john, selma).
parent(jackie, selma).

parent(john, patty).
parent(jackie, patty).

parent(john, glum).
parent(jackie, glum).

parent(glum, millhouse).
parent(cher, millhouse).

parent(glum, terpsichore).
parent(cher, terpsichore).

/*
 * the female predicate
 */

female(helga).
female(esmerelda).
female(skugerina).
female(uggette).
female(matilda).
female(marge).
female(jackie).
female(selma).
female(patty).
female(cher).
female(lisa).
female(maggie).
female(klotho).
female(atropos).
female(lachesis).
female(terpsichore).

/*
 * the male predicate
 */

male(olf).
male(skug).
male(homericus).
male(ug).
male(homer).
male(gomer).
male(gemini).
male(john).
male(glum).
male(bart).
male(millhouse).

/*
 * the age predicate
 */

age(helga, 97).
age(olf, 99).
age(uggette, 93).
age(ug, 92).
age(matilda, 65).
age(homericus, 76).
age(skugerina, 101).
age(skug, 78).
age(esmerelda, 55).
age(gemini, 54).
age(klotho, 20).
age(atropos, 19).
age(lachesis, 18).
age(marge, 35).
age(homer, 38).
age(lisa, 8).
age(maggie, 1).
age(bart, 10).
age(gomer, 41).
age(john, 62).
age(jackie, 59).
age(patty, 38).
age(selma, 38).
age(glum, 27).
age(cher, 44).
age(millhouse, 8).
age(terpsichore, 8).

/*
 * the person predicate
 */

person(helga).
person(olf).
person(uggette).
person(ug).
person(matilda).
person(homericus).
person(skugerina).
person(skug).
person(esmerelda).
person(gemini).
person(klotho).
person(atropos).
person(lachesis).
person(marge).
person(homer).
person(lisa).
person(maggie).
person(bart).
person(gomer).
person(john).
person(jackie).
person(patty).
person(selma).
person(glum).
person(cher).
person(millhouse).
person(terpsichore).


