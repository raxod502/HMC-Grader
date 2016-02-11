#lang racket
(include "scrabble.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (best-word "academy" '("ace" "ade" "cad" "cay" "day")) '("cay" 8) 
      "scrabble academy")
    (check-equal? (best-word "appler" (list "peal" "peel" "ape" "paper")) '("paper" 9) 
      "scrabble appler")
    (check-equal? (best-word "paler" (list "peal" "peel" "ape" "paper")) '("peal" 6) 
      "scrabble paler")
    (check-equal? (best-word "kwyjibo" '("ace" "ade" "cad" "cay" "day"))  '("" 0)
      "scrabler kwyjibo")
    (check-equal? (second (best-word "bcademy" '("ace" "ade" "cad" "cay" "bay"))) 8 
      "scabbler bcademy")
  )
)

(rackUnit:run-tests file-tests 'normal)        