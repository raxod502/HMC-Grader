import unittest
import hw8pr4 as hw

# for use with the eval_pointspoly tests
POINTS = hw.distributeSecret(5, 3, 42)

class EvalPolyTests(unittest.TestCase):
  def testEvalPoly1(self):
    POLY = hw.create_random_poly(2, 42)
    self.assertEqual(hw.eval_poly(POLY, 0), 42)
  def testEvalPoly2(self):
    self.assertEqual(hw.eval_poly(hw.create_random_poly(3, 9001), 0), 9001)

class EvalPointsPolyTests(unittest.TestCase):
  def testEvalPointsPoly1(self):
    self.assertTrue(abs( hw.eval_pointspoly(POINTS[0:3], 0) - 42.0 ) < .5)
  def testEvalPointsPoly2(self):
    self.assertTrue(abs( hw.eval_pointspoly(POINTS[0:2], 0) - 42.0 ) > .5)
  def testEvalPointsPoly3(self):
    self.assertTrue(abs( hw.eval_pointspoly(POINTS[1:3], 0) - 42.0 ) > .5)
  def testEvalPointsPoly4(self):
    self.assertTrue(abs( hw.eval_pointspoly(POINTS[1:4], 0) - 42.0 ) < .5)


if __name__ == "__main__":
  unittest.main()