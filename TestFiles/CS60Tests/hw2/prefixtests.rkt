#lang racket
(include "hw2pr2_prefix_sublist.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (prefix? '() '(s p a m))      #t
                  "empty list prefix: Check your base case!")
    (check-equal? (prefix? '() '())             #t
                  "empty list prefix of empty: Check your base case!")
    (check-equal? (prefix? '(s p) '(s p a m))   #t
                  "working prefix")
    (check-equal? (prefix? '(s m) '(s p a m))   #f
                  "Nonprefix1")
    (check-equal? (prefix? '(s a) '(s p s a m)) #f
                  "Nonprefix2")
    (check-equal? (prefix? '(p a) '(s p a m))   #f
                  "sublist, but not prefix: You wrote sublist, not prefix! it should only match if the prefix comes at the <emph>beginning</emph>")
  )
)

(rackUnit:run-tests file-tests 'normal)