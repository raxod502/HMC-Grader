:- set_test_options([load(never)]).
:- include('sort.pl').
:- set_test_options([load(always)]).

:- begin_tests(selectionSort).
test(selectionSortT1) :- selectionSort([1, 2, 3], [1, 2, 3]), !.
test(selectionSortT2) :- selectionSort([2, 1, 3], [1, 2, 3]), !.
test(selectionSortT3) :- selectionSort([2, 3, 1], [1, 2, 3]), !.
test(selectionSortT4) :- selectionSort([1, 1, 1], [1, 1, 1]), !.
test(selectionSortT5) :- selectionSort([1], [1]), !.
:- end_tests(selectionSort).

:- begin_tests(insertionSort).
test(insertionSortT1) :- insertionSort([1, 2, 3], [1, 2, 3]), !.
test(insertionSortT2) :- insertionSort([2, 1, 3], [1, 2, 3]), !.
test(insertionSortT3) :- insertionSort([2, 3, 1], [1, 2, 3]), !.
test(insertionSortT4) :- insertionSort([1, 1, 1], [1, 1, 1]), !.
test(insertionSortT5) :- insertionSort([1], [1]), !.
:- end_tests(insertionSort).

:- begin_tests(bubble).
test(bubbleT1) :- bubble([1, 2, 3], [1, 2, 3]), !.
test(bubbleT2) :- bubble([2, 1, 3], [1, 2, 3]), !.
test(bubbleT3) :- bubble([2, 3, 1], [2, 1, 3]), !.
test(bubbleT4) :- bubble([1, 1, 1], [1, 1, 1]), !.
test(bubbleT5) :- bubble([5, 4, 3, 2, 1], [4, 3, 2, 1, 5]), !.
test(bubbleT6) :- bubble([1], [1]), !.
:- end_tests(bubble).
