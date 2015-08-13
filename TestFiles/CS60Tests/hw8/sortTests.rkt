;;;Racket - Unit Tests Example

#lang racket
(include "sort.rkt")
(require rackunit)

;;Test cases for min
(check-equal? (min `(2 5 17 92)) 2
		"min-sorted")

(check-equal? (min `(92 87 5 46 31 17 45 11 2 1)) 1
		"min-unsorted")

(check-equal? (min `(585 46 24 99 99 99 24 2 15 7 2 11 2)) 2
		"min-duplicates")

;;Test cases for remove
(check-equal? (remove 1 '(1 45 90)) '(45 90)
		"remove-sorted")

(check-equal? (remove 1 '(90 45 1)) '(90 45)
		"remove-unsorted")

(check-equal? (remove 1 '(75 82 11 2 1 1 1 1 91 1 92 1 93 1)) '(75 82 11 2 1 1 1 91 1 92 1 93 1)
		"remove-duplicates")

(check-equal? (remove 1 '(1)) '()
		"remove-empty")

;;Test cases for insert
(check-equal? (insert 1 '(2 3 4)) '(1 2 3 4)
		"insert-first")

(check-equal? (insert 90 '(5 11 24 87)) '(5 11 24 87 90)
		"insert-last")

(check-equal? (insert 42 '(2 3 4 11 15 22 31 49 75 80)) '(2 3 4 11 15 22 31 42 49 75 80)
		"insert-middle")

(check-equal? (insert 42 '()) '(42)
		"insert-empty")
