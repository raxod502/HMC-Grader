;;;Racket - Unit Tests Example

#lang racket
(include "hw1pr2.rkt")
(require rackunit)

(define TestGraph1 '( (a b) (b c) (c d) (d e) (e c) ))
(check-equal? (reachable? 'a 'a TestGraph1) #t
	"reachable identity")
(check-equal? (reachable? 'z 'z TestGraph1) #t
	"reachable  non-existant")
(check-equal? (reachable? 'a 'b TestGraph1) #t
	"reachable adjacent")
(check-equal? (reachable? 'a 'e TestGraph1) #t
	"reachable path")
(check-equal? (reachable? 'e 'd TestGraph1) #t
	"reachable back-adjacent")
(check-equal? (reachable? 'e 'a TestGraph1) #f
	"reachable no path")
