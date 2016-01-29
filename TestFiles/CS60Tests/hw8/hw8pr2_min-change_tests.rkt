#lang racket
(include "change.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (min-change 42 '(1 5 10 25 50)) '(1 1 5 10 25)
    "(min-change 42 '(1 5 10 25 50))")
    (check-equal? (min-change 42 '(1 5 21 35))    '(21 21)
    "(min-change 42 '(1 5 21 35))")
    (check-equal? (min-change 1 '(1 5 21 35))     '(1)
    "(min-change 1 '(1 5 21 35))")
    (check-equal? (min-change 0 '(1 5 21 35))     '()
    "(min-change 0 '(1 5 21 35))")
    (check-equal? (min-change 6 '(5 10))          '(1 5)
    "(min-change 6 '(5 10))")
    (check-equal? (min-change 3 '(8 9))           '(1 1 1)
    "(min-change 3 '(8 9))  ")
  )
)

(rackUnit:run-tests file-tests 'normal)

    