;;;Racket - Unit Tests Example

#lang racket
(include "hw1pr2.rkt")
(require rackunit)

(check-equal? (hard-scrabble "iazby_q" '("biz" "jazz" "qi" "quiz"))
'("quiz" 21) "iazby_q") 
(check-equal? (hard-scrabble "iazzjaq" '("biz" "jazz" "qi" "quiz"))
'("no cheating!" 0) "iazzjaq")
(check-equal? (hard-scrabble "iajby__" '("biz" "jazz" "qi" "quiz"))
'("jazz" 9) "iajby__") ; 
(check-equal? (hard-scrabble "_______" '("biz" "jazz" "qi" "quiz"))
'("no cheating!" 0) "all blank")
