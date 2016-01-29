import unittest
import hw4pr4 as hw

class TcToNumTest(unittest.TestCase):
  def testTcToNum1(self):
    self.assertEqual(hw.TcToNum("00000001"), 1)
  def testTcToNum2(self):
    self.assertEqual(hw.TcToNum("11111111"), -1)
  def testTcToNum3(self):
    self.assertEqual(hw.TcToNum("10000000"), -128)
  def testTcToNum4(self):
    self.assertEqual(hw.TcToNum("01000000"),  64)

class NumToTcTest(unittest.TestCase):
  def testNumToTc1(self):
    self.assertEqual(hw.NumToTc(1), '00000001')
  def testNumToTc2(self):
    self.assertEqual(hw.NumToTc(-128), '10000000')
  def testNumToTc3(self):
    self.assertEqual(hw.NumToTc(200), 'Error')

if __name__ == "__main__":
    unittest.main()