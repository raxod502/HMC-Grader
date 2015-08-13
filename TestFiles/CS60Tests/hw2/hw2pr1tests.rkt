;;;Racket - Unit Tests Example

#lang racket
(include "hw2pr1.rkt")
(require rackunit)

(check-equal? (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
    '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) 
    "varied types")
(check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
    '( (3 2 1) (9 (7 8) 6 5 4) ) 
    "triple nested list")
(check-equal? (superreverse '(  ))
    '(  ) 
    "empty")
(check-equal? (superreverse '( ((a b c)) ))
    '( ((a b c))  ) 
    "only triple nested list")

(check-equal? (indivisible 3 '( 2 3 4 5 6 7 8 9 10 )) '(2 4 5 7 8 10)
              "some divisible1")
(check-equal? (indivisible 4 '( 2 3 4 5 6 7 8 9 10 )) '(2 3 5 6 7 9 10)
              "some divisible2")
(check-equal? (indivisible 42 '( 2 3 4 5 6 7 8 9 10 )) '(2 3 4 5 6 7 8 9 10)
              "none divisible")
(check-equal? (indivisible 1 '( 2 3 4 5 6 7 8 9 10 )) '()
              "all divisible")

(check-equal? (lotto-winner '( (alice 2 4 16 33 42)  (bob 3 4 5 6 7) (cdrthecat 3 15 16 41 42) ) '(2 4 15 33 42)) '(alice 4)
              "alicewins")
(check-equal? (lotto-winner '( (alice 2 4 16 33 42)  (bob 3 4 5 6 7) (cdrthecat 3 15 16 41 42) ) '(2 3 15 32 42)) '(cdrthecat 3)
              "cdr wins")
(check-equal? (lotto-winner '( (alice 2 4 16 33 42)  (bob 3 4 5 6 7) (cdrthecat 3 15 16 41 42) ) '(7 8 9 10 11))'(bob 1)
              "bob wins")

(define BTTESTS '( 42 
               (20 (7 (1 () ()) (8 () ())) (31 () (41 () ()))) 
               (100 (60 () ()) ()) )  )
(define BigBST2
  (make-BST 42
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST 100 
                      (make-BST-leaf 60)
                      (make-empty-BST))))

(check-equal? (height BigBST2) 3 ;; using the tree defined above
              "big height")
(check-equal? (height (make-empty-BST)) -1
              "empty height")
(check-equal? (height (make-BST 42 (make-empty-BST) (make-empty-BST))) 0
              "only root height")

(check-equal? (find-min BTTESTS) 1 ;; using the tree defined above
              "min of big")
(check-equal? (find-min (third BTTESTS)) 60
              "min of smaller")

(check-equal? (in-order BTTESTS) '(1 7 8 20 31 41 42 60 100)
              "in-order big BST")
(check-equal? (in-order  (second BTTESTS)) '(1 7 8 20 31 41)
              "in-order smaller BST")
(check-equal? (in-order (third BTTESTS)) '(60 100)
              "in-order smallest BST")
(check-equal? (in-order '()) '()
              "in-order empty")

(check-equal? (tree-map (lambda (x) (+ x 2)) BigBST2) 
              '(44 (22 (9 (3 () ()) (10 () ())) (33 () (43 () ()))) (102 (62 () ()) ()))
              "map +2 on big")

(check-equal? (delete 20 BTTESTS) 
    '(42 (31 (7 (1 () ()) (8 () ())) (41 () ())) (100 (60 () ()) ()))
    "delete child of root")
(check-equal? (delete 42 BTTESTS) 
    '(60 (20 (7 (1 () ()) (8 () ())) (31 () (41 () ()))) (100 () ()))
    "delete root")
(check-equal? (delete 20 '()) 
    '()
    "delete from empty")
(check-equal? (delete 7 (delete 42 BTTESTS)) 
    '(60 (20 (8 (1 () ()) ()) (31 () (41 () ()))) (100 () ()))
    "delete twice")

(check-equal? (make-postage 0 '(1 4 6 15 25 29 54)) #t
            "make 0")
(check-equal? (make-postage 29 '(1 4 6 15 25 29 54)) #t
            "make with one coin")
(check-equal? (make-postage 11 '(1 4 6 15 25 29 54)) #t
            "make with three coins")
(check-equal? (make-postage 76 '(1 4 6 15 25 29 54)) #t
            "make with lots of coins")
(check-equal? (make-postage 9 '(1 4 6 15 25 29 54)) #f
             "can't make1")
(check-equal? (make-postage 77 '(1 4 6 15 25 29 54)) #f
             "can't make2")
