#lang racket
(include "pokedex.rkt")
(require rackunit)
(require (prefix-in rackUnit: rackunit/text-ui))

(define file-tests
  (test-suite
   "tests"
    (check-equal? (in-order? "Colleen" "Bulbasaur")    #f
    "(in-order? 'Colleen' 'Bulbasaur')")
    (check-equal? (in-order? "Bulbasaur" "Colleen")    #t
    "(in-order? 'Bulbasaur' 'Colleen')")
    (check-equal? (in-order? "Bulbasaur" "Charmander") #f
    "(in-order? 'Bulbasaur' 'Charmander')")
    (check-equal? (in-order? "Bulbasaur" "Squirtle")   #t
    "(in-order? 'Bulbasaur' 'Squirtle')")
    (check-equal? (in-order? "Bulbasaur" "Bulbasaur")  #t
    "(in-order? 'Bulbasaur' 'Bulbasaur')")
    (check-equal? (in-order? "Charmander" "Squirtle")  #t
    "(in-order? 'Charmander' 'Squirtle')")
    (check-equal? (in-order? "Squirtle" "Charmander")  #f
    "(in-order? 'Squirtle' 'Charmander')")
    (check-equal? (in-order? "Pidgeot" "Rattata")      #t
    "(in-order? 'Pidgeot' 'Rattata')")
    (check-equal? (in-order? "Rattata" "Pidgeot")      #f
    "(in-order? 'Rattata' 'Pidgeot')")
  )
)

(rackUnit:run-tests file-tests 'normal)


