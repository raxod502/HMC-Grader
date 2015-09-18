#lang racket
(include "hw1_extra.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (keepDivisibleValues 4 '(1 2 3 4)) '(1 2 4)
    "(keepDivisibleValues 4 '(1 2 3 4))")
    (check-equal? (keepDivisibleValues 41 '(1 2 3 4 5 6 7 8 9)) '(1)
    "(keepDivisibleValues 41 '(1 2 3 4 5 6 7 8 9))")
  )
)

(rackUnit:run-tests file-tests 'normal)
