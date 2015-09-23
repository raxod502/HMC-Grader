;;;Racket - Unit Tests Example

#lang racket
(include "change.rkt")
(require rackunit)

(check-equal? (min-change 1 '(1 5 10 25 50)) '(1)
	"one-cent")
(check-equal? (min-change 42 '(1 5 10 25 50)) '(1 1 5 10 25)
	"42-cents us coins")
(check-equal? (min-change 42 '(1 5 21 35)) '(21 21)
	"42-cents weird coins")
(check-equal? (min-change 0 '(1 5 21 35)) '()
	"no change")
