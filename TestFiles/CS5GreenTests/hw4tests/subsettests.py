import subset as hw

import unittest

class SubsetRepeatTest(unittest.TestCase):
  def testSubsetRepeat1(self):
    self.assertEqual(hw.subsetRepeat(5, [1, 2]), True)
  def testSubsetRepeat2(self):
    self.assertEqual(hw.subsetRepeat(11, [6, 2, 7]), True)
  def testSubsetRepeat3(self):
    self.assertEqual(hw.subsetRepeat(11, [2, 4, 6]), False)
  def testSubsetRepeat4(self):
    self.assertEqual(hw.subsetRepeat(23, [41, 3,]), False)


if __name__ == '__main__':
    unittest.main()