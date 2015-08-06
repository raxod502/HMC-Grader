
#
# Connect 4 player grading script
#


import sys
import traceback
import hw11pr2; reload(hw11pr2) ; from hw11pr2 import *


def setupBoard( b, s ):
  """ make moves from s into b """
  ox = 'X'
  for c in s:
    col = int(c)
    b.addMove( col, ox )
    if ox == 'X': ox = 'O'
    else: ox = 'X'
  return b


print
print
print ":-)   CS 5 graders rock!"
print
print
    
global TOTAL_SCORE
TOTAL_SCORE = 0


try:
  print "\n\n+++ TEST 1 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  p = Player( 'X', 'LEFT', 0 )
  p2 = Player( 'O', 'RIGHT', 1 )
  # test 1 - does oppCh work?
  print "p is\n", p, "\n"
  if p.oppCh() == 'O':
    print "  ",
    print 'correct... p\'s opponent is \'O\''
    TOTAL_SCORE += 3
  else:
    print '** INCORRECT **  p\'s opponent is not \'O\''
    print
    print "The return value was", p.oppCh()

except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print




try:
  print "\n\n+++ TEST 2 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  p = Player( 'X', 'LEFT', 0 )
  p2 = Player( 'O', 'RIGHT', 1 )
  b.addMove( 0, 'X' )
  b.addMove( 0, 'X' )
  b.addMove( 0, 'X' )
  print "b is\n", b, "\n"
  if p.scoreBoard(b) == 50.0:
    print "  ",
    print 'correct... b scores at 50.0 for X'
    TOTAL_SCORE += 5
  else:
    print '** INCORRECT **  b should score a 50.0 for X'
    print
    print "The return value was", p.scoreBoard(b)

except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print



try:
  print "\n\n+++ TEST 3 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  p = Player( 'X', 'LEFT', 0 )
  p2 = Player( 'O', 'RIGHT', 1 )
  b.addMove( 0, 'X' )
  b.addMove( 0, 'X' )
  b.addMove( 0, 'X' )
  b.addMove( 0, 'X' )
  print "b is\n", b, "\n"
  if p.scoreBoard(b) == 100.0:
      print "  ",
      print 'correct... b scores a 100.0 for X'
      TOTAL_SCORE += 7
  else:
      print '** INCORRECT **  b should score a 100.0 for X'
      print
      print "The return value was", p.scoreBoard(b)
      print
  if p2.scoreBoard(b) == 0.0:
      print "  ",
      print 'correct... b scores a 0.0 for O'
      TOTAL_SCORE += 4
  else:
      print '** INCORRECT **  b should score at 0.0'
      print
      print "The return value was", p2.scoreBoard(b)
      print

except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print






try:
  print "\n\n+++ TEST 4 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  p = Player( 'X', 'LEFT', 0 )
  p2 = Player( 'O', 'RIGHT', 1 )
  #print "b is\n", b
  # does tie breaking work to the left and right... ?
  scores = [ 0,100,0,0,0,100,0 ]
  print "scores are", scores, "\n" 
  if p.tiebreakMove( scores ) == 1:
      print 'correct... p tiebreaks in column 1'
      TOTAL_SCORE += 4
  else:
      print '** INCORRECT **  ... p should tiebreak in column 1'
      print
      print "The return value was", p.tiebreakMove( scores )
      print
  
  
  if p2.tiebreakMove( scores ) == 5:
      print 'correct... p2 tiebreaks in column 5'
      TOTAL_SCORE += 4
  else:
      print '** INCORRECT **  ... p2 should tiebreak in column 5'
      print
      print "The return value was", p2.tiebreakMove( scores )
      print
  
except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print




try:
  print "\n\n+++ TEST 5 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  b = setupBoard( b, '1211244445' )
  answer = Player('X', 'LEFT', 0).scoresFor(b)
  print "board is\n", b, "\n"
  print "Running:  Player('X', 'LEFT', 0).scoresFor(b)\n"
  if answer == [50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0]:
      print 'correct... 0 ply scoring test'
      TOTAL_SCORE += 4
  else:
      print '** INCORRECT **  ... 0 ply scoring test'
      print
      print "The return value was", answer
      print
  
except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print




try:
  print "\n\n+++ TEST 6 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  b = setupBoard( b, '1211244445' )
  answer = Player('X', 'LEFT', 0).scoresFor(b)
  print "board is\n", b, "\n"
  print "Running:  Player('O', 'LEFT', 1).scoresFor(b)\n"
  answer = Player('O', 'LEFT', 1).scoresFor(b)
  if answer == [50.0, 50.0, 50.0, 100.0, 50.0, 50.0, 50.0]:
      print 'correct... 1 ply scoring test'
      TOTAL_SCORE += 4
  else:
      print '** INCORRECT **  ... 1 ply scoring test'
      print
      print "The return value was", answer
      print
  
except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print

  


try:
  print "\n\n+++ TEST 7 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  b = setupBoard( b, '1211244445' )
  answer = Player('X', 'LEFT', 0).scoresFor(b)
  print "board is\n", b, "\n"
  print "Running:  Player('X', 'LEFT', 2).scoresFor(b)\n"
  answer = Player('X', 'LEFT', 2).scoresFor(b)
  if answer == [0.0, 0.0, 0.0, 50.0, 0.0, 0.0, 0.0]:
      print 'correct... 2 ply scoring test'
      TOTAL_SCORE += 6
  else:
      print '** INCORRECT **  ... 2 ply scoring test'
      print
      print "The return value was", answer
      print
  
except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print






try:
  print "\n\n+++ TEST 8 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  b = setupBoard( b, '1211244445' )
  answer = Player('X', 'LEFT', 0).scoresFor(b)
  print "board is\n", b, "\n"
  print "Running:  Player('X', 'LEFT', 3).scoresFor(b)\n"
  answer = Player('X', 'LEFT', 3).scoresFor(b)
  if answer == [0.0, 0.0, 0.0, 100.0, 0.0, 0.0, 0.0]:
      print 'correct... 3 ply scoring test'
      TOTAL_SCORE += 6
  else:
      print '** INCORRECT **  ... 3 ply scoring test'
      print
      print "The return value was", answer
      print
  
except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print



try:
  print "\n\n+++ TEST 9 +++\n"
  b = Board(7,6)
  hw11pr2.b = b
  b = setupBoard( b, '1211244445' )
  answer = Player('X', 'LEFT', 0).scoresFor(b)
  print "board is\n", b, "\n"
  print "Running:  Player('O', 'LEFT', 4).scoresFor(b)\n"
  answer = Player('O', 'LEFT', 4).scoresFor(b)
  if answer == [0.0, 0.0, 0.0, 100.0, 0.0, 0.0, 0.0]:
      print 'correct... 4 ply scoring test'
      TOTAL_SCORE += 8
  else:
      print '** INCORRECT **  ... 4 ply scoring test'
      print
      print "The return value was", answer
      print

except Exception as e:
  print "** INCORRECT **   this test failed with an Exception:\n"
  type_, value_, traceback_ = sys.exc_info()
  tb = traceback.format_exc()
  print tb
  print







# total score
print "\n\nTOTAL POINTS EARNED (out of 55): ", TOTAL_SCORE, "\n\n"

print "Be sure to run the two playGame tests...\n\n"

print "Here they are for pasting, if you'd like:\n"
print "b = Board(7,6); b.playGame( Player('X','LEFT',0), Player('O','LEFT',0)) "
print "b = Board(7,6); b.playGame( Player('X','LEFT',1), Player('O','LEFT',1)) "



print "\n\n"



# let's see if this works...
