#lang racket
(include "hw1pr3_power.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (fast-power 2 5) 32
    "(fast-power 2 5)")
    (check-equal? (fast-power 5 2) 25
    "(fast-power 5 2)")
    (check-equal? (fast-power 42 1) 42
    "(fast-power 42 1)")
  )
)

(rackUnit:run-tests file-tests 'normal)