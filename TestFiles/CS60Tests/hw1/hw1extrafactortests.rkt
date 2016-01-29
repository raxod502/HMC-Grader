#lang racket
(include "hw1_extra.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (factor 41) '(1 41)
    "(factor 41)")
    (check-equal? (factor 42) '(1 2 3 6 7 14 21 42)
    "(factor 42)")
    (check-equal? (factor 3) '(1 3)
    "(factor 3)")
  )
)

(rackUnit:run-tests file-tests 'normal)