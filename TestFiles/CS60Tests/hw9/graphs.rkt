#lang racket
(provide make-edge src dst weight make-empty-graph add-edge emptyGraph? edge-list remove-edge worstCost)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Weighted Edge interface
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; make-edge: creates a weighted edge from a source and destination 
;;            node and a weight
;;   inputs: a source node and a desintation node
;;   output: a weighted edge edge
(define (make-edge s d w)
  (list s d w))

;; src: gets the source of an edge
;;   inputs: a weighted edge
;;   output: the source node of the edge
(define (src edge)
  (first edge))

;; dest: gets the destination of an edge
;;   inputs: a weighted edge
;;   output: the destination node of the edge
(define (dst edge)
  (second edge))

;; weight: gets the weight of an edge
;;   inputs: a weighted edge
;;   output: the edge's weight
(define (weight edge)
  (third edge))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Graph interface
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; make-empty-graph: 
;;   inputs: none
;;   output: an empty graph
(define (make-empty-graph) 
  '())

;; add-edge: adds an edge to a graph (does not check for duplicates)
;;   inputs: an edge and a graph
;;   output: a new graph that includes the given edge
(define (add-edge e G) 
  (cons e G))

;; emptyGraph?:
;;   inputs: a graph
;;   output: #t if the graph is empty; #f otherwise
(define (emptyGraph? G)
  (empty? G))

;; edge-list: gets a list of edges in the graph
;;   inputs: a graph
;;   output: a list of edges in the graph
(define (edge-list G)
  G)

;; remove-edge: removes an edge from a graph
;;   inputs: an edge and a graph
;;   output: a new graph that excludes the given edge
(define (remove-edge e G)
  (remove e G)) 

;; worstCost: the highest cost that an edge incurs
(define worstCost +inf.0)