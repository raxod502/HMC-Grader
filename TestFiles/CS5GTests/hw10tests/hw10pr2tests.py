import hw10pr2 as hw

import unittest

class ConnectFourTests(unittest.TestCase):
  # test 1 - does addMove work in the last column?
  def testAddMoveLastColumn(self):
    b = hw.Board(7,6)
    b.addMove(6,'X')
    answer1 = [ [' ']*7 for i in range(6) ]
    answer1[5][6] = 'X'
    self.assertEqual(b.data, answer1, '** INCORRECT **  X should be in the lower right')

  # test 2 - does delMove work?
  def testDelMove(self):
    b = hw.Board(7,6)
    b.addMove(6,'X')
    b.delMove(6)
    answer2 = [ [' ']*7 for i in range(6) ]
    self.assertEqual(b.data, answer2,'** INCORRECT **  board should be empty')

  # test 3 - does isFull work?
  def testIsFullTrue(self):
    b = hw.Board(2,2)
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 1, 'X' )
    b.addMove( 1, 'X' )
    self.assertTrue(b.isFull(),'** INCORRECT **  b actually is full')

  # test 4 - another isFull
  def testIsFullFalse(self):
    b = hw.Board(2,2)
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 1, 'X' )
    b.addMove( 1, 'X' )
    b.delMove(1)
    self.assertFalse(b.isFull(),'** INCORRECT **  b actually is not full')

  # test 5 - wins for horizontal
  def testWinsForHorizontalFalse(self):
    b = hw.Board(7,6)
    b.addMove( 0, 'X' )
    b.addMove( 1, 'X' )
    b.addMove( 2, 'X' )
    self.assertFalse(b.winsFor('X'),'** INCORRECT **  b does not win for X')

  def testWinsForHorizontalTrue(self):
    b = hw.Board(7,6)
    b.addMove( 0, 'X' )
    b.addMove( 1, 'X' )
    b.addMove( 2, 'X' )
    b.addMove( 3, 'X' )
    self.assertTrue(b.winsFor('X'),'** INCORRECT **  b does win for X')

  # test 6 - wins for vertical
  def testWinsForVerticalFalse(self):
    b = hw.Board(7,6)
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    self.assertFalse(b.winsFor('X'),'** INCORRECT **  b does not win for X')

  def testWinsForVerticalTrue(self):
    b = hw.Board(7,6)
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    b.addMove( 0, 'X' )
    self.assertTrue(b.winsFor('X'),'** INCORRECT **  b does win for X')

    # test 7 - wins for diagonal (SW)
  def testWinsForDiagonalSWFalse(self):
    b = hw.Board(7,6)
    b.addMove( 0, 'X' )
    b.addMove( 1, 'O' )
    b.addMove( 1, 'X' )
    b.addMove( 2, 'O' )
    b.addMove( 2, 'X' )
    b.addMove( 2, 'X' )
    b.addMove( 3, 'X' )
    b.addMove( 3, 'O' )
    b.addMove( 3, 'X' )
    self.assertFalse(b.winsFor('X'),'** INCORRECT **  b does not win for X')

  def testWinsForDiagonalSWTrue(self):
    b = hw.Board(7,6)
    b.addMove( 0, 'X' )
    b.addMove( 1, 'O' )
    b.addMove( 1, 'X' )
    b.addMove( 2, 'O' )
    b.addMove( 2, 'X' )
    b.addMove( 2, 'X' )
    b.addMove( 3, 'X' )
    b.addMove( 3, 'O' )
    b.addMove( 3, 'X' )
    b.addMove( 3, 'X' )
    self.assertTrue(b.winsFor('X'),'** INCORRECT **  b does win for X')

  # test 8 - wins for diagonal (SE)
  def testWinsForDiagonalSEFalse(self):
    b = hw.Board(7,6)
    b.addMove( 6, 'X' )
    b.addMove( 5, 'O' )
    b.addMove( 5, 'X' )
    b.addMove( 4, 'O' )
    b.addMove( 4, 'X' )
    b.addMove( 4, 'X' )
    b.addMove( 3, 'X' )
    b.addMove( 3, 'O' )
    b.addMove( 3, 'X' )
    self.assertFalse(b.winsFor('X'),'** INCORRECT **  b does not win for X')

  def testWinsForDiagonalSETrue(self):
    print "\n\nTEST 8"
    b = hw.Board(7,6)
    b.addMove( 6, 'X' )
    b.addMove( 5, 'O' )
    b.addMove( 5, 'X' )
    b.addMove( 4, 'O' )
    b.addMove( 4, 'X' )
    b.addMove( 4, 'X' )
    b.addMove( 3, 'X' )
    b.addMove( 3, 'O' )
    b.addMove( 3, 'X' )
    b.addMove( 3, 'X' )
    self.assertTrue(b.winsFor('X'),'** INCORRECT **  b does win for X')

if __name__ == '__main__':
    unittest.main()