;;;Racket - Unit Tests Example

#lang racket
(include "hw3pr4.rkt")
(require rackunit)

;; cancel 4 tests
(check-equal? (cancel '(m m s) '(kg m s s)) '(m)
              "cancel1")
(check-equal? (cancel '(m s) '(kg m s s)) '()
              "cancel everything")
(check-equal? (cancel '(m s s s) '(kg m s s)) '(s)
              "cancel duplicates")
(check-equal? (cancel '(kg m s s) '(m m s)) '(kg s)
              "cancel2")

;; simplify 2 tests
(check-true (equal-QLs? (make-QL 1.0 '(m) '(s) 0.0)
                          (simplify '(1.0 (m m s) (m s s) 0.0)))
            "simplify1")

(check-true (equal-QLs? (make-QL 1.0 '(m) '(kg) 0.0)
                          (simplify '(1.0 (kg m m s) (kg kg m s) 0.0)))
            "simplify2")

;; multiple 2 tests
(check-true (equal-QLs? (make-QL 1764.0 '(m) '(s) 59.39696962) (multiply (make-QL 42.0 '(kg m m) '(s s) 1.0)
                                    (make-QL 42.0 '(s) '(kg m) 1.0)))
            "multiply1")

(check-true (equal-QLs? (make-QL 1.0 '(kg meter x) '(amp s w) 0.02061553) (multiply (make-QL 2.0 '(meter) '(amp w)   0.01)
                                    (make-QL 0.5 '(kg x)  '(s)  0.01)))
            "multiply2")

;; power 3 tests
(check-true (equal-QLs? (make-QL 1.0 '() '() 0.0)
                          (power (make-QL 200.0 '(euro) '() 1.0) 0))
            "0th power")

(check-true (equal-QLs? (make-QL 0.005 '() '(euro) 2.5e-005)
                          (power (make-QL 200.0 '(euro) '() 1.0) -1))
            "negative power")

(check-true (equal-QLs? (make-QL 8000000.0 '(euro euro euro) '() 120000.0)
                          (power (make-QL 200.0 '(euro) '() 1.0) 3))
            "positive power")

;; divide 2 tests
(check-true (equal-QLs? (make-QL 1.0 '(m) '(s) 0.03367175) (divide (make-QL 42.0 '(kg m m) '(s s) 1.0)
                                  (make-QL 42.0 '(kg m) '(s) 1.0)))
            "divide1")

(check-true (equal-QLs? (make-QL 4.0 '(meter s) '(amp kg w x) 0.08246211) (divide (make-QL 2.0 '(meter) '(amp w)   0.01)
                                  (make-QL 0.5 '(kg x)  '(s)  0.01)))
            "divide2")

;; norm-unit 1 test
(check-true (equal-QLs? (make-QL 1.0 '(ampere) '() 0.0)
                          (norm-unit 'ampere))
            "norm base unit")
;; norm QL - 2 tests
(check-true (equal-QLs? (make-QL 4.3890407 '(meter) '() 0.09143834)
                          (norm-QL (make-QL 14.4 '(foot) '() 0.3)))
            "norm-QL1")

(check-true (equal-QLs? (make-QL 0.010159816 '(meter) '(second) 0.0005079908)
                          (norm-QL (make-QL 2.0 '(foot) '(minute) 0.1)))
            "norm-QL2")
;; add 2 tests
(check-true (equal-QLs? (make-QL 2.13356145 '(meter) '() 0.03592037) (add (make-QL 42.0 '(inch) '() 1.0)
                               (make-QL 42.0 '(inch) '() 1.0)))
            "add identical QLs")

(check-equal? (add (make-QL 42.0 '(inch) '() 1.0) (make-QL 42.0 '(s) '() 1.0)) (list 'error 'add (make-QL 42.0 '(inch) '() 1.0)
                            (make-QL 42.0 '(s) '() 1.0))
              "add error")


(check-true (equal-QLs? (make-QL 23.7 '(meter) '() 0.360555127) (add (norm-QL (make-QL 14.4 '(meter) '() 0.3)) 
                    (norm-QL (make-QL 9.3 '(meter) '() 0.2))))
            "add norm'd units")

;; subtract 2 tests
(check-true (equal-QLs? (make-QL 0.0 '(meter) '() 0.03592037) (subtract (make-QL 42.0 '(inch) '() 1.0)
                                    (make-QL 42.0 '(inch) '() 1.0)))
            "subtract identical QLs")

(check-true (equal? (subtract (make-QL 42.0 '(inch) '() 1.0) (make-QL 42.0 '(s) '() 1.0)) (list 'error 'subtract (make-QL 42.0 '(inch) '() 1.0)
                            (make-QL 42.0 '(s) '() 1.0)))
            "subtract error")

(check-true (equal-QLs? (make-QL 5.1 '(meter) '() 0.360555127) (subtract (norm-QL (make-QL 14.4 '(meter) '() 0.3)) 
                         (norm-QL (make-QL 9.3 '(meter) '() 0.2))))
            "subtract norm'd units")


;; Other tests
(check-true (equal-QLs? (make-QL 0.38735983 '(second) '() 0.030581039) (divide (norm-QL (make-QL 3.8 '(m) '(s) 0.3))
                                  (norm-QL (make-QL 9.81 '(m) '(s s) 0.0))))
            "divide norm'd units")


(check-true (equal-QLs? (norm-QL (make-QL 0.48 '(cm) '() 0.6327716)) (let* ((w (make-QL 4.52 '(cm) '() 0.02)) (x (make-QL 2.0 '(cm) '() 0.2)) (y (make-QL 3.0 '(cm) '() 0.6)))
                            (subtract (add (norm-QL x) (norm-QL y)) (norm-QL w))))
            "add then subtract norm'd units")


(check-true (equal-QLs? (norm-QL (make-QL 18.04 '(cm cm) '() 3.7119827)) (let* ((w (make-QL 4.52 '(cm) '() 0.02)) (x (make-QL 2.0 '(cm) '() 0.2)) (y (make-QL 3.0 '(cm) '() 0.6)))
                            (norm-QL (add (multiply w x) (power y 2)))))
            "add a multiplication and power norm'd units")
