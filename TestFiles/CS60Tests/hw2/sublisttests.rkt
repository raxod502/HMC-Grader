#lang racket
(include "prefix_sublist.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (sublist? '()    '(s p a m))   #t
                  "empty list sublist")
    (check-equal? (sublist? '(s)   '(s p a m))   #t
                  "single character at beginning")
    (check-equal? (sublist? '(a)   '(s p a m))   #t
                  "single character in middle")
    (check-equal? (sublist? '(s a) '(s p a m))   #f
                  "characters in list, but not in order: Make sure that the characters are consecutive")
    (check-equal? (sublist? '(s p) '(s p a m))   #t
                  "characters at beginning of list")
    (check-equal? (sublist? '(a m) '(s p a m))   #t
                  "characters at end of list")
    (check-equal? (sublist? '(s m) '(s p a m))   #f
                  "characters in order but not consecutive")
    (check-equal? (sublist? '(p a) '(s p a m))   #t
                  "characters in middle of list")
  )
)

(rackUnit:run-tests file-tests 'normal)                  