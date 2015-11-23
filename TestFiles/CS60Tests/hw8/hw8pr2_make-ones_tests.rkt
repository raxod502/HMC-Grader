#lang racket
(include "change.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (make-ones 0)  '()
    "(make-ones 0)")
    (check-equal? (make-ones 1)  '(1)
    "(make-ones 1)")
    (check-equal? (make-ones 2)  '(1 1)
    "(make-ones 2)")
    (check-equal? (make-ones 3)  '(1 1 1)
    "(make-ones 3)")
    (check-equal? (make-ones 10) '(1 1 1 1 1 1 1 1 1 1)
    "(make-ones 10)")
  )
)

(rackUnit:run-tests file-tests 'normal)
