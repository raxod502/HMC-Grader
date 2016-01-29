import sexChromosomeEvolution as hw

import unittest

testScoresD = {('h4', 'c17'): -158, ('h9', 'c22'): 2374, ('h6', 'c22'): -1149, 
('h4', 'c8'): -134, ('h4', 'c19'): 1140, ('h17', 'c22'): -1305, 
('h7', 'c17'): -614, ('h6', 'c8'): -195, ('h17', 'c17'): -135, 
('h6', 'c19'): -195, ('h9', 'c19'): -1115, ('h9', 'c17'): -1248, 
('h4', 'c22'): -1126, ('h17', 'c19'): -189, ('h7', 'c8'): -666, 
('h7', 'c22'): -573, ('h17', 'c8'): 1343, ('h6', 'c17'): 1043, 
('h7', 'c19'): -558, ('h9', 'c8'): -1287}

class MemoAlignScoreTest(unittest.TestCase):
  def testMemoAlign1(self):
    self.assertEqual(hw.memoAlignScore('','',-9,hw.blosum62,{}), 0)
  def testMemoAlign2(self):
    self.assertEqual(hw.memoAlignScore('','FGTSK',-9,hw.blosum62,{}), -45)
  def testMemoAlign3(self):
    self.assertEqual(hw.memoAlignScore('IVEKGYY','AVEYY',-9,hw.blosum62,{}), 4)
  def testMemoAlign4(self):
    self.assertEqual(hw.memoAlignScore('CIEAFGTSKQKRALNSRRMNAVGNDIVSTAVTKAAADVIDAKGVTALIQDVAQD', 'RDLPIWTSVDWKSLPATEIFNKAFSQGSDEAMYDYMAVYKKSCPQTRR',-9,hw.blosum62,{}), -48)

class AllScoresTest(unittest.TestCase):
  def testAllScores1(self):
    allScoresD = hw.allScores(["h7","h9"],["c22","c7"])
    self.assertEqual(sorted(allScoresD.items()), [(('h7', 'c22'), -573), (('h7', 'c7'), -1179), (('h9', 'c22'), 2374), (('h9', 'c7'), -580)])
  def testAllScores2(self):
    allScoresD = hw.allScores(["h5"],["c1","c3"])
    self.assertEqual(sorted(allScoresD.items()), [(('h5', 'c1'), -661), (('h5', 'c3'), -1581)])
  def testAllScores3(self):
    allScoresD = hw.allScores(["h8"],["c2"])
    self.assertEqual(sorted(allScoresD.items()), [(('h8', 'c2'), -331)])
  def testAllScores4(self):
    allScoresD = hw.allScores(["h4"],["c2","c7"])
    self.assertEqual(sorted(allScoresD.items()), [(('h4', 'c2'), -352), (('h4', 'c7'), -1956)])

class ClosestMatchTest(unittest.TestCase):
  def testClosestMatch1(self):
    self.assertEqual(hw.closestMatch('c22',testScoresD), 'h9')
  def testClosestMatch2(self):
    self.assertEqual(hw.closestMatch('h6',testScoresD), 'c17')
  def testClosestMatch3(self):
    self.assertEqual(hw.closestMatch('c8',testScoresD), 'h17')
  def testClosestMatch4(self):
    self.assertEqual(hw.closestMatch('h9',testScoresD), 'c22')


if __name__ == '__main__':
    unittest.main()