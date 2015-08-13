:- set_test_options([load(never)]).
:- include('logic.pl').
:- set_test_options([load(always)]).

:- begin_tests(subst).
test(substT1, [nondet]) :- subst( 1, t, 1, t ), !.
test(substT2, [nondet]) :- subst( 1, t, 2, 2 ), !.
test(substT3, [nondet]) :- subst( 1, t, [ifthen,f,t], [ifthen,f,t] ), !.
test(substT4, [nondet]) :- subst( 2, t, [not,2], [not,t] ), !.
test(substT5, [nondet]) :- subst( 2, f, [or,[and,1,2],2], [or,[and,1,f],f] ), !.
:- end_tests(subst). 

:- begin_tests(eval).
test(evalT1, [nondet]) :- eval( [ifthen, f, t], t ), !.
test(evalT2, [nondet]) :- eval( [and, f, t], f ), !.
test(evalT3, [nondet]) :- eval( [or, f, t], t ), !.
test(evalT4, [nondet]) :- eval( [not,[not,[not,f]]], t ), !.
test(evalT5, [nondet]) :- \+eval( [ifthen, f, f], f ), !.
:- end_tests(eval). 

:- begin_tests(taut).
test(tautT1, [nondet]) :- taut( [ifthen, f, 1] ), !.
test(tautT2, [nondet]) :- taut( [iff, 2, 2] ), !.
test(tautT3, [nondet]) :- taut( [ifthen, 1, [ifthen, 2, 1]] ), !.
test(tautT4, [nondet]) :- \+taut( [not,1] ), !.
test(tautT5, [nondet]) :- taut( [iff, [ifthen, [and, 1, 2], 3], [ifthen, 1, [ifthen, 2, 3]]] ), !.
:- end_tests(taut).

:- begin_tests(unsat).
test(unsatT1, [nondet]) :- unsat( [not,[ifthen, f, 1]] ), !.
test(unsatT2, [nondet]) :- unsat( [not,[iff, 2, 2]] ), !.
test(unsatT3, [nondet]) :- unsat( [not,[ifthen, 1, [ifthen, 2, 1]]] ), !.
test(unsatT4, [nondet]) :- \+unsat( [not,1] ), !.
test(unsatT5, [nondet]) :- unsat( [not,[iff, [ifthen, [and, 1, 2], 3], [ifthen, 1, [ifthen, 2, 3]]]] ), !.
:- end_tests(unsat).  

:- begin_tests(id).
test(idT1, [nondet]) :- id( [not,[ifthen, f, 1]], knave ), !.
test(idT2, [nondet]) :- id( [ifthen, f, 1], knight ), !.
test(idT3, [nondet]) :- id( [not,[ifthen, 1, [ifthen, 2, 1]]], knave ), !.
test(idT4, [nondet]) :- id( [not,1], human ), !.
test(idT5, [nondet]) :- \+id( [not,1], knight ), !.
test(idT6, [nondet]) :- \+id( [not,1], knave ), !.
:- end_tests(id).
