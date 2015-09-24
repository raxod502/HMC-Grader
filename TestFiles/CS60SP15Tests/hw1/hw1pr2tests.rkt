;;;Racket - Unit Tests Example

#lang racket
(include "hw1pr2.rkt")
(require rackunit)


(check-equal? (subbag? '() '(s p a m s)) #t 
	"subbag empty")
(check-equal? (subbag? '(s s) '(s p a m s)) #t
	"subbag ends")
(check-equal? (subbag? '(p a) '(s p a m s)) #t
	"subbag middle")
(check-equal? (subbag? '(a m a) '(s p a m s)) #f
	"subbag more letters")
 
(check-equal? (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
'( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) 
	"superreverse lists")
(check-equal? (superreverse '( ))
'( ) 
	"superreverse empty")
(check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
'( (3 2 1) (9 (7 8) 6 5 4) ) 
	"superreverse sublist")
(check-equal? (superreverse '( (1) (2) ))
'( (1) (2) ) 
	"superreverse sublists")


(check-equal? (duperreverse '( (1 2 3) (4 5 6) 42 ("k" "o" "o" "l") ("a" "m") ))
'( ("m" "a") ("l" "o" "o" "k") 42 (6 5 4) (3 2 1) ) 
	"duperreverse basic")
(check-equal? (duperreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
'( (9 (8 7) 6 5 4) (3 2 1) ) 
	"duperreverse sublist")
(check-equal? (duperreverse '( (1) (2) ))
'( (2) (1) ) 
	"duperreverse sublists")
(check-equal? (duperreverse '( ))
'( ) "duperreverse empty")


(check-equal? (tail-fib 8) 34 
	"tailfib 8")
(check-equal? (tail-fib 9) 55 
	"tailfib 9")

(check-equal? (tail-reverse '(6 7 1 2)) '(2 1 7 6) 
	"tailreverse")
(check-equal? (tail-reverse '( )) '( ) 
	"tailreverse empty")

(check-equal? (best-word "academy" '("ace" "ade" "cad" "cay" "day")) '("cay" 8) 
	"scrabble academy")
(check-equal? (best-word "appler" (list "peal" "peel" "ape" "paper")) '("paper" 9) 
	"scrabble appler")
(check-equal? (best-word "paler" (list "peal" "peel" "ape" "paper")) '("peal" 6) 
	"scrabble paler")
(check-equal? (second (best-word "bcademy" '("ace" "ade" "cad" "cay" "bay"))) 8 
	"scabbler bcademy")


