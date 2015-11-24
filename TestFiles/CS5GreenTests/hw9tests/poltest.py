import pol as hw

import unittest

class RnaWinTest(unittest.TestCase):
  def testRnaWin_1(self):
    self.assertEqual(hw.rnaWin('AAGAUCUGGCCUUCCUGCAAGGGAAGGCGGAA',8,4), (1, 0, 'AAGAUCUG'))
  def testRnaWin_2(self):
    self.assertEqual(hw.rnaWin('AAAAUCUGGCCUUCCCACAAGGGGGGGAGGCCAGGGAA',8,4), (2, 24, 'GGGAGGCC'))

class PvalTest(unittest.TestCase):
  def testPval_1(self):
    self.assertEqual(hw.pval(4,[3,4,5,3]), 0.6)
  def testPval_2(self):
    self.assertEqual(hw.pval(5,[3,4,5,3,6]), 0.5)

if __name__ == '__main__':
    unittest.main()