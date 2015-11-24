#lang racket
(include "postage.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (make-postage -10 '(1 2 3))             #f
    "(make-postage -10 '(1 2 3))")
    (check-equal? (make-postage 0   '(1 4 6 15 54 25 29)) #t
    "(make-postage 0   '(1 4 6 15 54 25 29))")
    (check-equal? (make-postage 29  '(1 4 6 15 54 25 29)) #t
    "(make-postage 29   '(1 4 6 15 54 25 29))")
    (check-equal? (make-postage 11  '(1 4 6 15 54 25 29)) #t
    "(make-postage 11   '(1 4 6 15 54 25 29))")
    (check-equal? (make-postage 76  '(1 4 6 15 54 25 29)) #t
    "(make-postage 76   '(1 4 6 15 54 25 29))")
    (check-equal? (make-postage 6   '(2 2 2 2 2 2 2 2 2)) #t
    "(make-postage 6   '(2 2 2 2 2 2 2 2 2))")
    (check-equal? (make-postage 9   '(1 4 6 15 54 25 29)) #f
    "(make-postage 9   '(1 4 6 15 54 25 29))")
    (check-equal? (make-postage 77  '(1 4 6 15 54 25 29)) #f
    "(make-postage 77  '(1 4 6 15 54 25 29))")
  )
)

(rackUnit:run-tests file-tests 'normal)

