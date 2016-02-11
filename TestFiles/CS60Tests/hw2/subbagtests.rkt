#lang racket
(include "scrabble.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (subbag? '() '(s p a m s)) #t 
      "subbag empty")
    (check-equal? (subbag? '(s s) '(s p a m s)) #t
      "subbag ends")
    (check-equal? (subbag? '(s m) '(s p a m s)) #t
      "subbag middle1")
    (check-equal? (subbag? '(p a) '(s p a m s)) #t
      "subbag middle2")
    (check-equal? (subbag? '(a m a) '(s p a m s)) #f
      "subbag more letters")
    (check-equal? (subbag? '(a s) '(s a)) #t
      "subbag whole list")
  )
)

(rackUnit:run-tests file-tests 'normal)        