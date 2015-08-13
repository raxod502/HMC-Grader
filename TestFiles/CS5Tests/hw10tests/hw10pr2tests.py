#
# Connect 4 board grading script
#


from hw10pr2 import *

# test 1 - does addMove work in the last column?
print "\n\nTEST 1"
b = Board(7,6)
b.addMove(6,'X')
print b
answer1 = [ [' ']*7 for i in range(6) ]
answer1[5][6] = 'X'
if b.data == answer1:
    print 'correct... X should be in the lower right'
else:
    print '** INCORRECT **  X should be in the lower right'


# test 2 - does delMove work?
print "\n\nTEST 2"
b.delMove(6)
print b
answer2 = [ [' ']*7 for i in range(6) ]
if b.data == answer2:
    print 'correct... board should be empty'
else:
    print '** INCORRECT **  board should be empty'



# test 3 - does isFull work?
print "\n\nTEST 3"
b = Board(2,2)
b.addMove( 0, 'X' )
b.addMove( 0, 'X' )
b.addMove( 1, 'X' )
b.addMove( 1, 'X' )
print b
if b.isFull():
    print 'correct... b is full.'
else:
    print '** INCORRECT **  b actually is full'




# test 4 - another isFull
print "\n\nTEST 4"
b.delMove(1)
print b
if b.isFull():
    print '** INCORRECT **  b actually is not full'
else:
    print 'correct... b is not full.'



# test 5 - wins for horizontal
print "\n\nTEST 5"
b = Board(7,6)
b.addMove( 0, 'X' )
b.addMove( 1, 'X' )
b.addMove( 2, 'X' )
print b
if b.winsFor('X'):
    print '** INCORRECT **  b does not win for X'
else:
    print 'correct... b does not win for X'


b.addMove( 3, 'X' )
print b
if b.winsFor('X'):
    print 'correct... b does win for X'
else:
    print '** INCORRECT **  b does win for X'



# test 6 - wins for vertical
print "\n\nTEST 6"
b = Board(7,6)
b.addMove( 0, 'X' )
b.addMove( 0, 'X' )
b.addMove( 0, 'X' )
print b
if b.winsFor('X'):
    print '** INCORRECT **  b does not win for X'
else:
    print 'correct... b does not win for X'


b.addMove( 0, 'X' )
print b
if b.winsFor('X'):
    print 'correct... b does win for X'
else:
    print '** INCORRECT **  b does win for X'



# test 7 - wins for diagonal (SW)
print "\n\nTEST 7"
b = Board(7,6)
b.addMove( 0, 'X' )
b.addMove( 1, 'O' )
b.addMove( 1, 'X' )
b.addMove( 2, 'O' )
b.addMove( 2, 'X' )
b.addMove( 2, 'X' )
b.addMove( 3, 'X' )
b.addMove( 3, 'O' )
b.addMove( 3, 'X' )
print b
if b.winsFor('X'):
    print '** INCORRECT **  b does not win for X'
else:
    print 'correct... b does not win for X'


b.addMove( 3, 'X' )
print b
if b.winsFor('X'):
    print 'correct... b does win for X'
else:
    print '** INCORRECT **  b does win for X'



# test 8 - wins for diagonal (SE)
print "\n\nTEST 8"
b = Board(7,6)
b.addMove( 6, 'X' )
b.addMove( 5, 'O' )
b.addMove( 5, 'X' )
b.addMove( 4, 'O' )
b.addMove( 4, 'X' )
b.addMove( 4, 'X' )
b.addMove( 3, 'X' )
b.addMove( 3, 'O' )
b.addMove( 3, 'X' )
print b
if b.winsFor('X'):
    print '** INCORRECT **  b does not win for X'
else:
    print 'correct... b does not win for X'


b.addMove( 3, 'X' )
print b
if b.winsFor('X'):
    print 'correct... b does win for X'
else:
    print '** INCORRECT **  b does win for X'


