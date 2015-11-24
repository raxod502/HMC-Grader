#lang racket
(include "BST.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (height BigBST) 3
    "(height BigBST)") 
    (check-equal? (height (make-empty-BST)) -1
    "(height (make-empty-BST))")
    (check-equal? (height (make-BST-leaf 42)) 0
    "(height (make-BST-leaf 42))")
  )
)

(rackUnit:run-tests file-tests 'normal)