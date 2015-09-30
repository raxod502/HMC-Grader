#lang racket
(include "hw3pr3_lotto-winner.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (lotto-winner '( (alice 2 4 16 33 42)  (bob 3 4 5 6 7) (cdrthecat 3 15 16 41 42) ) '(2 4 15 33 42)) '(alice 4)
                  "alicewins")
    (check-equal? (lotto-winner '( (alice 2 4 16 33 42)  (bob 3 4 5 6 7) (cdrthecat 3 15 16 41 42) ) '(2 3 15 32 42)) '(cdrthecat 3)
                  "cdr wins")
    (check-equal? (lotto-winner '( (alice 2 4 16 33 42)  (bob 3 4 5 6 7) (cdrthecat 3 15 16 41 42) ) '(7 8 9 10 11))'(bob 1)
                  "bob wins")
  )
)

(rackUnit:run-tests file-tests 'normal)