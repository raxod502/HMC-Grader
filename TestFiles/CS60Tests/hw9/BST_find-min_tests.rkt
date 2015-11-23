#lang racket
(include "BST.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (find-min BigBST) 1
    "(find-min BigBST)") 
  )
)

(rackUnit:run-tests file-tests 'normal)