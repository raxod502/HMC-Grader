#lang racket
(include "superduper.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (superreverse '(  ))
        '(  ) 
        "superreverse empty")
    (check-equal? (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
        '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) 
        "superreverse lists")
    (check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
        '( (3 2 1) (9 (7 8) 6 5 4) ) 
        "superreverse triple nested list")
    (check-equal? (superreverse '( ((a b c)) ))
        '( ((a b c))  ) 
        "superreverse only triple nested list")
    (check-equal? (superreverse '( (1) (2) ))
        '( (1) (2) ) 
        "superreverse sublists")
  )
)

(rackUnit:run-tests file-tests 'normal)               
