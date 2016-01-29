#lang racket
(include "hw2pr5_tail-fib.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (tail-fib 8) 34 
      "tailfib 8")
    (check-equal? (tail-fib 9) 55 
      "tailfib 9")
  )
)

(rackUnit:run-tests file-tests 'normal)                 