import hw10pr1 as hw

import unittest

class DateTests(unittest.TestCase):
  def testDate1(self):
    self.assertEqual(hw.Date(12, 7, 1941).dow(), 'Sunday')
  def testDate2(self):
    self.assertEqual(hw.Date(10, 28, 1929).dow(), 'Monday')
  def testDate3(self):
    self.assertEqual(hw.Date(10, 19, 1987).dow(), 'Monday')
  def testDate4(self):
    self.assertEqual(hw.Date(1, 1, 2100).dow(), 'Friday')
  def testDate5(self):
    self.assertEqual(hw.Date(11, 11, 2015).diff(hw.Date(1, 1, 1899)), 42682)
  def testDate6(self):
    self.assertEqual(hw.Date(11, 11, 2015).diff(hw.Date(1, 1, 2101)), -31097)
  def testDate7(self):
    self.assertEqual(hw.Date(12,18,2015).diff(hw.Date(11,11,2015)), 37)

if __name__ == '__main__':
    unittest.main()