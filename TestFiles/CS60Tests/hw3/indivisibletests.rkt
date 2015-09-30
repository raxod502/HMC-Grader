#lang racket
(include "hw3pr2_indivisible.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (indivisible 3 '( 2 3 4 5 6 7 8 9 10 )) '(2 4 5 7 8 10)
                  "some divisible1")
    (check-equal? (indivisible 4 '( 2 3 4 5 6 7 8 9 10 )) '(2 3 5 6 7 9 10)
                  "some divisible2")
    (check-equal? (indivisible 42 '( 2 3 4 5 6 7 8 9 10 )) '(2 3 4 5 6 7 8 9 10)
                  "none divisible")
    (check-equal? (indivisible 1 '( 2 3 4 5 6 7 8 9 10 )) '()
                  "all divisible")
  )
)

(rackUnit:run-tests file-tests 'normal)                  