#lang racket
(include "Graph.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (gchildren 0 'a graph11) '(a)
    "(gchildren 0 'a graph11)")
    (check-equal? (gchildren 1 'a graph11) '(b)
    "(gchildren 1 'a graph11)")
    (check-equal? (gchildren 2 'a graph11) '(c)
    "(gchildren 2 'a graph11)")
    (check-equal? (sortsym (gchildren 1 'c graph11)) '(d f)
    "(sortsym (gchildren 1 'c graph11))")
    (check-equal? (sortsym (gchildren 2 'c graph11)) '(e x)
    "(sortsym (gchildren 2 'c graph11))")
    (check-equal? (sortsym (gchildren 3 'a graph11)) '(d f)
    "(sortsym (gchildren 3 'a graph11))")
    (check-equal? (sortsym (gchildren 3 'c graph11)) '(g h y)
    "(sortsym (gchildren 3 'c graph11))")
  )
)

(rackUnit:run-tests file-tests 'normal)     