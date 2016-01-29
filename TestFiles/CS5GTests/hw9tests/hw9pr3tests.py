import unittest

import hw9pr3 as hw

class NextTests(unittest.TestCase):
  def testNext_21(self):
    self.assertEqual(hw.next(21), 1211)
  def testNext_2222(self):
    self.assertEqual(hw.next(2222), 42)
  def testNext_312211(self):
    self.assertEqual(hw.next(312211), 13112221)

if __name__ == "__main__":
  unittest.main() #run all tests