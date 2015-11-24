import unittest
import hw6pr4 as hw

class PowerTest(unittest.TestCase):
  def testPowerZeroExponent(self):
    self.assertEqual(hw.power(42,0), 1)
  def testPowerZeroBase(self):
    self.assertEqual(hw.power(0,42), 0)
  def testPowerZeroExponentAndBase(self):
    self.assertEqual(hw.power(0,0), 1)
  def testPowerFiveSquared(self):
    self.assertEqual(hw.power(5,2), 25)
  def testPowerTwoToFifth(self):
    self.assertEqual(hw.power(2,5), 32)

class SummedOddsTest(unittest.TestCase):
  def testSummedOdds1(self):
    self.assertEqual(hw.summedOdds([4,5,6]), 5)
  def testSummedOdds2(self):
    self.assertEqual(hw.summedOdds(range(3,10)), 24)

if __name__ == "__main__":
    unittest.main()