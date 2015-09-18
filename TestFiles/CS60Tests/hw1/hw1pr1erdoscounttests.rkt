#lang racket
(include "hw1pr1_erdos.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (erdos-count 26) 10
    "(erdos-count 26)")
    (check-equal? (erdos-count 27) 111
    "(erdos-count 27)")
    (check-equal? (erdos-count 1) 0
    "(erdos-count 1)")
    (check-equal? (erdos-count 2) 1
    "(erdos-count 2)")
    (check-equal? (erdos-count 4) 2
    "(erdos-count 4)")
    (check-equal? (erdos-count 5) 5
    "(erdos-count 5)")
  )
)

(rackUnit:run-tests file-tests 'normal)