#lang racket
(include "change.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (make-ones-tail 0)  '()
    "(make-ones-tail 0)")
    (check-equal? (make-ones-tail 1)  '(1)
    "(make-ones-tail 1)")
    (check-equal? (make-ones-tail 2)  '(1 1)
    "(make-ones-tail 2)")
    (check-equal? (make-ones-tail 3)  '(1 1 1)
    "(make-ones-tail 3)")
    (check-equal? (make-ones-tail 10) '(1 1 1 1 1 1 1 1 1 1)
    "(make-ones-tail 10)")
  )
)

(rackUnit:run-tests file-tests 'normal)