#lang racket
(include "remove-all.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (remove-all "i" '("a" "l" "i" "i" "i" "e" "n")) '("a" "l" "e" "n")
                  "remove-all middle")
    (check-equal? (remove-all "i" '( ("a" "l" "i") "i" "i" "e" "n")) '(("a" "l" "i") "e" "n")
                  "remove-all sublist: Don't go into sublists")
    (check-equal? (remove-all 0 '(1 0 1 0 1 0))  '(1 1 1)
                  "remove-all given")
    (check-equal? (remove-all 0 '())  '()
                  "remove-all from empty")
  )
)

(rackUnit:run-tests file-tests 'normal)