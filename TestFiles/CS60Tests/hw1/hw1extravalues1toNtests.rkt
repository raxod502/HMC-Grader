#lang racket
(include "hw1_extra.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (values1toN 0) '()
    "(values1toN 0)")
    (check-equal? (values1toN 1) '(1)
    "(values1toN 1)")
    (check-equal? (values1toN 4) '(1 2 3 4)
    "(values1toN 4)")
  )
)

(rackUnit:run-tests file-tests 'normal)

