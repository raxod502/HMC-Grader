#lang racket
(include "hw1_extra.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (divisible 10 2) #t
    "(divisible 10 2)")
    (check-equal? (divisible 11 2) #f
    "(divisible 11 2)")
  )
)

(rackUnit:run-tests file-tests 'normal)
