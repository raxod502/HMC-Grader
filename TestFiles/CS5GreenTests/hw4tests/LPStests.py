import LPS as hw

import unittest

class LPSTest(unittest.TestCase):
  def testLPS1(self):
    self.assertEqual(hw.LPS("amanaplanacanalpanama"), 21)
  def testLPS2(self):
    self.assertEqual(hw.LPS('dksakdkdakda'), 9)
  def testLPS3(self):
    self.assertEqual(hw.LPS('asdf'), 1)
  def testLPS4(self):
    self.assertEqual(hw.LPS('asdfd'), 3)
  def testLPS5(self):
    self.assertEqual(hw.LPS('asddf'), 2)
  def testLPS6(self):
    self.assertEqual(hw.LPS('a'), 1)
  def testLPS7(self):
    self.assertEqual(hw.LPS(''), 0)
  def testLPS8(self):
    self.assertEqual(hw.LPS('yyss'), 2)
  def testLPS9(self):
    self.assertEqual(hw.LPS('yssy'), 4)
  def testLPS10(self):
    self.assertEqual(hw.LPS('yssys'), 4)


if __name__ == '__main__':
    unittest.main()