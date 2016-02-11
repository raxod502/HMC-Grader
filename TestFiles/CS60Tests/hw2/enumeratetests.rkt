#lang racket
(include "enumerate.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (enumerate '(jan feb mar apr)) '((0 jan) (1 feb) (2 mar) (3 apr))
                  "months")
    (check-equal? (enumerate '(0 I II III IV V VI)) '((0 0) (1 I) (2 II) (3 III) (4 IV) (5 V) (6 VI))
                  "roman Numerals")
    (check-equal? (enumerate '(a))  '((0 a))
                  "single character")
    (check-equal? (enumerate '(0))  '((0 0))
                  "single number")
    (check-equal? (enumerate '())   '()
                  "empty list")
  )
)

(rackUnit:run-tests file-tests 'normal)                  