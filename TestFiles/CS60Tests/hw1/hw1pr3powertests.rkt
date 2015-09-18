#lang racket
(include "hw1pr3_power.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (power 2 5) 32
    "(power 2 5)")
    (check-equal? (power 5 2) 25
    "(power 5 2)")
    (check-equal? (power 42 1) 42
    "(power 42 1)")
  )
)

(rackUnit:run-tests file-tests 'normal)
