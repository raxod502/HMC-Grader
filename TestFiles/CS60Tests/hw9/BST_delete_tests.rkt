#lang racket
(include "BST.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (delete 20 BigBST) BigBST_without20
    "(delete 20 BigBST)")
    (check-equal? (delete 42 BigBST) BigBST_without42
    "(delete 42 BigBST)")
  )
)

(rackUnit:run-tests file-tests 'normal)
