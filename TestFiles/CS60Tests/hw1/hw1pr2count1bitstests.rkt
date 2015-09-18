#lang racket
(include "hw1pr2_count1bits.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (count1bits 0) 0
    "(count1bits 0)")
    (check-equal? (count1bits 1) 1
    "(count1bits 1)")
    (check-equal? (count1bits 2) 1
    "(count1bits 2)")
    (check-equal? (count1bits 3) 2
    "(count1bits 3)")
    (check-equal? (count1bits 6) 2
    "(count1bits 6)")
    (check-equal? (count1bits 7) 3
    "(count1bits 7)")
    (check-equal? (count1bits 42) 3
    "(count1bits 42)")
  )
)

(rackUnit:run-tests file-tests 'normal)

