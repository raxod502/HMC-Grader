#lang racket
(include "hw0pr2.rkt")
(require rackunit)

(check-equal? (erdos 6) 3
              "(erdos 6)")
(check-equal? (erdos 7) 22
              "(erdos 7)")
(check-equal? (erdos 1) 4
              "(erdos 1)")
(check-equal? (erdos 2) 1
              "(erdos 2)")
(check-equal? (erdos 42) 21
              "(erdos 42)")
(check-equal? (erdos 101) 304
              "(erdos 101)")

(check-equal? (erdos-count 1) 0
              "(erdos-count 1)")
(check-equal? (erdos-count 101) 25
              "(erdos-count 101)")
(check-equal? (erdos-count 1111) 31
              "(erdos-count 1111)")
(check-equal? (erdos-count 267) 21
              "(erdos-count 267)")

(check-equal? (count1bits 6) 2
              "(count1bits 6)")
(check-equal? (count1bits 127) 7
              "(count1bits 127)")
(check-equal? (count1bits 1) 1
              "(count1bits 1)")
(check-equal? (count1bits 256) 1
              "(count1bits 256)")

(check-equal? (power 2 0) 1
              "(power 2 0)")
(check-equal? (power 2 5) 32
              "(power 2 5)")
(check-equal? (power 0 0) 1
              "(power 0 0)")
(check-equal? (power 42 1) 42
              "(power 42 1)")


(check-equal? (fast-power 2 0) 1
              "(fast-power 2 0)")
(check-equal? (fast-power 0 0) 1
              "(fast-power 0 0)")
(check-equal? (fast-power 2 5) 32
              "(fast-power 2 5)")
(check-equal? (fast-power 42 1) 42
              "(fast-power 42 1)")
