;;;Racket - Unit Tests Example

#lang racket
(include "hw1pr1.rkt")
(require rackunit)

; 5 points for remove-all
(check-equal? (remove-all "i" '("a" "l" "i" "i" "i" "e" "n")) '("a" "l" "e" "n")
              "remove-all middle")
(check-equal? (remove-all "i" '( ("a" "l" "i") "i" "i" "e" "n")) '(("a" "l" "i") "e" "n")
              "remove-all sublist: Don't go into sublists")
(check-equal? (remove-all 0 '(1 0 1 0 1 0))  '(1 1 1)
              "remove-all given")
(check-equal? (remove-all 0 '())  '()
              "remove-all from empty")

; 5 points for prefix?
(check-equal? (prefix? '() '(s p a m))      #t
              "empty list prefix: Check your base case!")
(check-equal? (prefix? '() '())             #t
              "empty list prefix of empty: Check your base case!")
(check-equal? (prefix? '(s p) '(s p a m))   #t
              "working prefix")
(check-equal? (prefix? '(s m) '(s p a m))   #f
              "Nonprefix")
(check-equal? (prefix? '(p a) '(s p a m))   #f
              "sublist, but not prefix: You wrote sublist, not prefix! it should only match if the prefix comes at the <emph>beginning</emph>")

; 7 points for sublist?
(check-equal? (sublist? '()    '(s p a m))   #t
              "empty list sublist")
(check-equal? (sublist? '(s)   '(s p a m))   #t
              "single character at beginning")
(check-equal? (sublist? '(a)   '(s p a m))   #t
              "single character in middle")
(check-equal? (sublist? '(s a) '(s p a m))   #f
              "characters in list, but not in order: Make sure that the characters are consecutive")
(check-equal? (sublist? '(a m) '(s p a m))   #t
              "characters at end of list")
(check-equal? (sublist? '(s m) '(s p a m))   #f
              "characters in order but not consecutive")
(check-equal? (sublist? '(p a) '(s p a m))   #t
              "characters in middle of list")

; 7 points for enumerate
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
