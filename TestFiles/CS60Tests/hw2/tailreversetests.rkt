#lang racket
(include "tail-reverse.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (tail-reverse '(6 7 1 2)) '(2 1 7 6) 
      "tailreverse basic")
    (check-equal? (tail-reverse '( )) '( ) 
      "tailreverse empty")
  )
)

(rackUnit:run-tests file-tests 'normal)                 