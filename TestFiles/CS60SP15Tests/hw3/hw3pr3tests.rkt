#lang racket
(include "hw3pr3.rkt")
(require rackunit)



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Graphs for testing
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; graph w/o edges
(define (TestEdgelessGraph)
  (make-empty-graph))

;; A graph with four edges that do not include a loop (e.g. a->b->c->d)
(define (TestLooplessGraph)
  (add-edge (make-edge 'a 'b 1)
            (add-edge (make-edge 'b 'c 1)
                      (add-edge (make-edge 'c 'd 1)
                                (TestEdgelessGraph)))))

;; A graph with four edges that do include a loop (e.g. a->b->c->d->a)
(define (TestLoopedGraph)
  (add-edge (make-edge 'a 'b 1)
            (add-edge (make-edge 'b 'c 1)
                      (add-edge (make-edge 'c 'd 1)
                                (add-edge (make-edge 'd 'a 1)
                                          (TestEdgelessGraph))))))

;; A graph with four edges where not all nodes are connected (e.g. a->b->a, c->d->c)
(define (TestUnconnectedGraph)
  (add-edge (make-edge 'a 'b 1)
            (add-edge (make-edge 'b 'a 1)
                      (add-edge (make-edge 'c 'd 1)
                                (add-edge (make-edge 'd 'c 1)
                                          (TestEdgelessGraph))))))

;; This graph makes it clearer how graphs are created:
(define (TestTinyGraph)
  (add-edge (make-edge 'a 'b 1)
            (add-edge (make-edge 'b 'a 1)
                      (make-empty-graph))))

(define (TestGraph2)
    (foldr add-edge
         (make-empty-graph)
         (map make-edge
              '(e   a  e  a  a  a  b  b  d  b   c  c)
              '(b   b  a  c  d  e  c  d  e  e   d  e)
              '(100 25 42 7  13 15 10 5  2  100 1  7))))

(define (TestBigGraph)
  (foldr add-edge
         (make-empty-graph)
         (map make-edge
              '(a b c d c e e f x y z)
              '(b c d e f g h x y z b)
              '(1 1 1 1 1 1 1 1 1 1 1))))

;; tests for gchildren

(check-equal? (gchildren 4 'b (TestLoopedGraph)) '(b)
              "gchildren - 4 gens away in Looped Graph")
(check-equal? (gchildren 1 'a (TestTinyGraph)) '(b)
              "gchildren - 1 node away in two node graph")

;; worstCost tests
(check-equal? (min-dist 'd 'd (TestGraph2)) 0
              "min-dist - same node case")
(check-equal? (min-dist 'a 'e (TestGraph2)) 10
              "min-dist - large graph distance")
(check-equal? (min-dist 'f 'a (TestGraph2)) 42000000
              "min-dist - unconnected nodes")
