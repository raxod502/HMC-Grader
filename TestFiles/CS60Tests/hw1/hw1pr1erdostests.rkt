#lang racket
(include "hw1pr1_erdos.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (erdos 84) 42
    "(erdos 84)")
    (check-equal? (erdos 85) 256
    "(erdos 85)")
    (check-equal? (erdos 1) 4
    "(erdos 1)")
    (check-equal? (erdos 3) 10
    "(erdos 3)")
    (check-equal? (erdos 0) 0
    "(erdos 0)")
    (check-equal? (erdos 2) 1
    "(erdos 2)")
    (check-equal? (erdos 4) 2
    "(erdos 4)")
  )
)

(rackUnit:run-tests file-tests 'normal)
