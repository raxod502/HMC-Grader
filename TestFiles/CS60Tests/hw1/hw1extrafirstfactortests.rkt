#lang racket
(include "hw1_extra.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (first-factor 41) 41
    "(first-factor 41)")
    (check-equal? (first-factor 42) 2
    "(first-factor 42)")
  )
)

(rackUnit:run-tests file-tests 'normal)