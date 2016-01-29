#lang racket
(include "hw1_extra.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (valuesNto1 0) '()
    "(valuesNto1 0)")
    (check-equal? (valuesNto1 1) '(1)
    "(valuesNto1 1)")
    (check-equal? (valuesNto1 4) '(4 3 2 1)
    "(valuesNto1 4)")
  )
)

(rackUnit:run-tests file-tests 'normal)

