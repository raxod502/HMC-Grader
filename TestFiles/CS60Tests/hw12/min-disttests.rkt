#lang racket
(include "Graph.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (min-dist 'a 'e graph5) 10
    "(min-dist 'a 'e graph5)")
    (check-equal? (min-dist 'e 'b graph5) 67
    "(min-dist 'e 'b graph5)")
    (check-equal? (min-dist 'd 'd graph5) 0
    "(min-dist 'd 'd graph5)")
    (check-equal? (min-dist 'f 'a graph5) 42000000
    "(min-dist 'f 'a graph5)")
  )
)

(rackUnit:run-tests file-tests 'normal)     