:- set_test_options([load(never)]).
:- include('simpson.pl').
:- set_test_options([load(always)]).

:- begin_tests(child).
test(childT1, [nondet]) :- child(bart, marge).
test(childT2, [nondet]) :- child(lisa, marge).
test(childT3, [nondet]) :- child(bart, homer).
test(childT4) :- setof(OneKid, child(OneKid, marge), AllKids), AllKids == [bart, lisa, maggie].
test(childT5) :- setof(OnePar, child(marge, OnePar), AllParents), AllParents == [jackie, john].
test(childT6) :- \+child(marge, homer).
test(childT7) :- \+child(jackie, _).
:- end_tests(child).

:- begin_tests(anc).
test(ancT1, [nondet]) :- anc(marge,  bart).
test(ancT2, [nondet]) :- anc(jackie, bart).
test(ancT3, [nondet]) :- anc(homer,  bart).
test(ancT4) :- setof(OneAnc, anc(OneAnc, bart), AllAnc), AllAnc == [helga, homer, homericus, jackie, john, marge, matilda, olf, ug, uggette].
test(ancT5) :- \+anc(marge, homer).
:- end_tests(anc).

:- begin_tests(grandparent).
test(grandparentT1, [nondet]) :- grandparent(jackie,  bart).
test(grandparentT2, [nondet]) :- grandparent(john,    bart).
test(grandparentT3, [nondet]) :- grandparent(helga,   homer).
test(grandparentT4) :- setof(OneGP, grandparent(OneGP, bart), AllGPs), AllGPs == [homericus,jackie,john,matilda].
test(grandparentT5) :- \+grandparent(marge, homer).
:- end_tests(grandparent).

:- begin_tests(siblings).
test(siblingsT1, [nondet]) :- siblings(bart,  lisa).
test(siblingsT2, [nondet]) :- siblings(lisa,  bart).
test(siblingsT3, [nondet]) :- siblings(gomer, homer).
test(siblingsT4) :- setof(OneSib, siblings(OneSib, bart), AllSibs), AllSibs == [lisa, maggie].
test(siblingsT5) :- \+siblings(jackie, _).
:- end_tests(siblings).

:- begin_tests(cousins).
test(cousinsT1, [nondet]) :- cousins(bart,      millhouse).
test(cousinsT2, [nondet]) :- cousins(millhouse, bart).
test(cousinsT3, [nondet]) :- cousins(esmerelda, homer).
test(cousinsT4) :- setof(OneCousin, cousins(OneCousin, millhouse), AllCousins), AllCousins == [bart, lisa, maggie].
test(cousinsT5) :- \+cousins(jackie, _).
:- end_tests(cousins).

:- begin_tests(hasOlderSibling).
test(hasOlderSiblingT1, [nondet]) :- hasOlderSibling(homer).
test(hasOlderSiblingT2, [nondet]) :- hasOlderSibling(marge).
test(hasOlderSiblingT3, [nondet]) :- hasOlderSibling(lisa).
test(hasOlderSiblingT4) :- setof(OneSib, hasOlderSibling(OneSib), AllSibs), AllSibs == [atropos, glum, homer, homericus, lachesis, lisa, maggie, marge].
test(hasOlderSiblingT5) :- \+hasOlderSibling(bart).
:- end_tests(hasOlderSibling).

:- begin_tests(hasYS).
test(hasYST1) :- hasYS(bart), !.
test(hasYST2) :- hasYS(lisa), !.
test(hasYST3) :- hasYS(patty), !.
test(hasYST4) :- setof(OneSib, hasYS(OneSib), AllSibs), AllSibs == [atropos, bart, gomer, klotho, lisa, marge, patty, selma, skug].
test(hasYST5) :- \+hasYS(maggie).
:- end_tests(hasYS).

:- begin_tests(hasOlderCousin).
test(hasOlderCousinT1, [nondet]) :- hasOlderCousin(millhouse, _).
test(hasOlderCousinT2, [nondet]) :- hasOlderCousin(maggie, _).
test(hasOlderCousinT3, [nondet]) :- hasOlderCousin(homer, _).
test(hasOlderCousinT4) :- setof( [X,GP], hasOlderCousin(X,GP), Answer ), Answer = [[gomer,helga],[gomer,olf],[homer,helga],[homer,olf],[maggie,jackie],[maggie,john],[millhouse,jackie],[millhouse,john],[terpsichore,jackie],[terpsichore,john]] .
test(hasOlderCousinT5) :- \+hasOlderCousin(bart, _).
:- end_tests(hasOlderCousin).

:- begin_tests(hasFirstGC).
test(hasFirstGCT1, [nondet]) :- hasFirstGC(marge).
test(hasFirstGCT2, [nondet]) :- hasFirstGC(homer).
test(hasFirstGCT3, [nondet]) :- hasFirstGC(esmerelda).
test(hasFirstGCT4) :- setof( P, hasFirstGC(P), Answer ), Answer = [esmerelda, homer, marge, matilda, skug].
test(hasFirstGCT5) :- \+hasFirstGC(bart).
:- end_tests(hasFirstGC).