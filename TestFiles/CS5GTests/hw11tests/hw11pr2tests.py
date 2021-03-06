import hw11pr2 as hw

import unittest

def setupBoard( b, s ):
  """ make moves from s into b """
  ox = 'X'
  for c in s:
    col = int(c)
    b.addMove( col, ox )
    if ox == 'X': ox = 'O'
    else: ox = 'X'
  return b

class ConnectFourTests(unittest.TestCase):
  def testOppCh(self):
    b = hw.Board(7,6)
    p = hw.Player( 'X', 'LEFT', 0 )
    p2 = hw.Player( 'O', 'RIGHT', 1 )
    self.assertEqual(p.oppCh(),'O', '** INCORRECT **  p\'s opponent is not \'O\'')
  
  def testScoreBoard1(self):
    b = hw.Board(7,6)
    p = hw.Player( 'X', 'LEFT', 0 )
    p2 = hw.Player( 'O', 'RIGHT', 1 )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    self.assertEqual(p.scoreBoard(b), 50.0,'** INCORRECT **  b should score a 50.0 for X')
  def testScoreBoard2(self):
    b = hw.Board(7,6)
    p = hw.Player( 'X', 'LEFT', 0 )
    p2 = hw.Player( 'O', 'RIGHT', 1 )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    self.assertEqual(p.scoreBoard(b), 100.0,'** INCORRECT **  b should score a 100.0 for X')
  def testScoreBoard3(self):
    b = hw.Board(7,6)
    p = hw.Player( 'X', 'LEFT', 0 )
    p2 = hw.Player( 'O', 'RIGHT', 1 )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    self.assertEqual(p2.scoreBoard(b), 0.0,'** INCORRECT **  b should score 0.0 for O')

  def testTieBreakMove1(self):
    b = hw.Board(7,6)
    p = hw.Player( 'X', 'LEFT', 0 )
    p2 = hw.Player( 'O', 'RIGHT', 1 )
    scores = [ 0,100,0,0,0,100,0 ]
    self.assertEqual(p.tiebreakMove( scores ), 1,'** INCORRECT ** p should tiebreak in column 1')
  def testTieBreakMove2(self):
    b = hw.Board(7,6)
    p = hw.Player( 'X', 'LEFT', 0 )
    p2 = hw.Player( 'O', 'RIGHT', 1 )
    scores = [ 0,100,0,0,0,100,0 ]
    self.assertEqual(p2.tiebreakMove( scores ), 5,'** INCORRECT ** p2 should tiebreak in column 5')

  def testScoresFor1(self):
    b = hw.Board(7,6)
    b = setupBoard( b, '1211244445' )
    answer = hw.Player('X', 'LEFT', 0).scoresFor(b)
    self.assertEqual(answer, [50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0],'** INCORRECT ** 0 ply scoring test')
  def testScoresFor2(self):
    b = hw.Board(7,6)
    b = setupBoard( b, '1211244445' )
    answer = hw.Player('O', 'LEFT', 1).scoresFor(b)
    self.assertEqual(answer, [50.0, 50.0, 50.0, 100.0, 50.0, 50.0, 50.0],'** INCORRECT ** 1 ply scoring test')
  def testScoresFor3(self):
    b = hw.Board(7,6)
    b = setupBoard( b, '1211244445' )
    answer = hw.Player('X', 'LEFT', 2).scoresFor(b)
    self.assertEqual(answer, [0.0, 0.0, 0.0, 50.0, 0.0, 0.0, 0.0],'** INCORRECT ** 2 ply scoring test')
  def testScoresFor4(self):
    b = hw.Board(7,6)
    b = setupBoard( b, '1211244445' )
    answer = hw.Player('X', 'LEFT', 3).scoresFor(b)
    self.assertEqual(answer, [0.0, 0.0, 0.0, 100.0, 0.0, 0.0, 0.0],'** INCORRECT ** 3 ply scoring test')
  def testScoresFor5(self):
    b = hw.Board(7,6)
    b = setupBoard( b, '1211244445' )
    answer = hw.Player('O', 'LEFT', 4).scoresFor(b)
    self.assertEqual(answer, [0.0, 0.0, 0.0, 100.0, 0.0, 0.0, 0.0],'** INCORRECT ** 4 ply scoring test')

# print "Be sure to run the two playGame tests...\n\n"

# print "Here they are for pasting, if you'd like:\n"
# print "b = Board(7,6); b.playGame( Player('X','LEFT',0), Player('O','LEFT',0)) "
# print "b = Board(7,6); b.playGame( Player('X','LEFT',1), Player('O','LEFT',1)) "

if __name__ == '__main__':
    unittest.main()