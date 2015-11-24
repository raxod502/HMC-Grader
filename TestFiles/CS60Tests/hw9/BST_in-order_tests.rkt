#lang racket
(include "BST.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (in-order BigBST) '(1 7 8 20 31 41 42 60 100)
    "(in-order BigBST)") 
  )
)

(rackUnit:run-tests file-tests 'normal)