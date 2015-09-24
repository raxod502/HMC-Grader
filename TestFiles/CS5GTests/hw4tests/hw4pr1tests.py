import unittest
import hw4pr1 as hw

class IsOddTest(unittest.TestCase):
  def testIsOddZero(self):
    self.assertEqual(hw.isOdd(0), False)
  def testIsOddOne(self):
    self.assertEqual(hw.isOdd(1), True)
  def testIsOddFortyTwo(self):
    self.assertEqual(hw.isOdd(42), False)
  def testIsOddFortyThree(self):
    self.assertEqual(hw.isOdd(43), True)

class NumToBinaryTest(unittest.TestCase):
  def testNumToBinaryZero(self):
    self.assertEqual(hw.numToBinary(0), '')
  def testNumToBinaryOne(self):
    self.assertEqual(hw.numToBinary(1), '1')
  def testNumToBinaryTwo(self):
    self.assertEqual(hw.numToBinary(2), '10')
  def testNumToBinaryFortyTwo(self):
    self.assertEqual(hw.numToBinary(42), '101010')

class BinaryToNumTest(unittest.TestCase):
  def testBinaryToNumEmptyString(self):
    self.assertEqual(hw.binaryToNum(''), 0)
  def testBinaryToNumZero(self):
    self.assertEqual(hw.binaryToNum('0'), 0)
  def testBinaryToNumOne(self):
    self.assertEqual(hw.binaryToNum('1'), 1)
  def testBinaryToNumFortyTwo(self):
    self.assertEqual(hw.binaryToNum('101010'), 42)

class IncrementTest(unittest.TestCase):
  def testIncrementZero(self):
    self.assertEqual(hw.increment('00000000'),'00000001')
  def testIncrementOne(self):
    self.assertEqual(hw.increment('00000001'),'00000010')
  def testIncrementSeven(self):
    self.assertEqual(hw.increment('00000111'),'00001000')
  def testIncrementWrapping(self):
    self.assertEqual(hw.increment('11111111'),'00000000')

class NumToTernaryTest(unittest.TestCase):
  def testNumToTernaryFortyTwo(self):
    self.assertEqual(hw.numToTernary(42), '1120')
  def testNumToTernary4242(self):
    self.assertEqual(hw.numToTernary(4242), '12211010')

class TernaryToNumTest(unittest.TestCase):
  def testTernaryToNumFortyTwo(self):
    self.assertEqual(hw.ternaryToNum('1120'), 42)
  def testTernaryToNum4242(self):
    self.assertEqual(hw.ternaryToNum('12211010'), 4242)

class BalancedTernaryToNumTest(unittest.TestCase):
  def testBalancedTernaryToNum42(self):
    self.assertEqual(hw.balancedTernaryToNum('+---0'), 42)
  def testBalancedTernaryToNum100(self):
    self.assertEqual(hw.balancedTernaryToNum('++-0+'), 100)

class NumToBalancedTernaryTest(unittest.TestCase):
  def testNumToBalancedTernary42(self):
    self.assertEqual(hw.numToBalancedTernary(42), '+---0')
  def testNumToBalancedTernary100(self):
    self.assertEqual(hw.numToBalancedTernary(100), '++-0+')


if __name__ == "__main__":
    unittest.main()