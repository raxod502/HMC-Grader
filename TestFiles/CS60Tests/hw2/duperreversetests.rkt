#lang racket
(include "superduper.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (duperreverse '(  ))
        '(  ) 
        "duperreverse empty")
    (check-equal? (duperreverse '( (1 2 3) (4 5 6) 42 ("k" "o" "o" "l") ("a" "m") ))
        '( ("m" "a") ("l" "o" "o" "k") 42 (6 5 4) (3 2 1) ) 
        "duperreverse basic")
    (check-equal? (duperreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
        '( (9 (8 7) 6 5 4) (3 2 1) )  
        "duperreverse sublist")
    (check-equal? (duperreverse '( (1) (2) ))
        '( (2) (1) ) 
        "duperreverse sublists")
    (check-equal? (duperreverse '( ((a b c)) ))
        '( ((c b a))  ) 
        "duperreverse only triple nested list")
  )
)

(rackUnit:run-tests file-tests 'normal)               
