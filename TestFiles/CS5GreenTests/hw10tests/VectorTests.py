import Vector as hw

import unittest

class MfoldTest(unittest.TestCase):
  def testVector1(self):
    v = hw.Vector(1, 1)
    y = hw.Vector(2, 3)
    self.assertTrue(v.x==1 and v.y==1)
  def testVector2(self):
    v = hw.Vector(1, 1)
    y = hw.Vector(2, 3)
    self.assertTrue((v-y).x == -1 and (v-y).y == -2)
  def testVector3(self):
    v = hw.Vector(1, 1)
    y = hw.Vector(2, 3)
    self.assertTrue(round(v.magnitude(),4) == 1.4142)
  def testVector4(self):
    v = hw.Vector(1, 1)
    y = hw.Vector(2, 3)
    v.normalize()
    self.assertTrue(round(v.x,4)==0.7071 and round(v.y,4)==0.7071)
  def testVector5(self):
    v = hw.Vector(1, 1)
    y = hw.Vector(2, 3)
    self.assertTrue('2' in str(y) and '3' in str(y))

if __name__ == '__main__':
    unittest.main()