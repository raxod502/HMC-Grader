import memoizedSubset as hw

import unittest


class MemoizedSubsetTest(unittest.TestCase):
  def testSubsetFailure(self):
    self.assertFalse(hw.memoizedSubset(1234567, tuple(range(2, 100, 2)), {} ))
  def testSubsetSuccess(self):
    self.assertTrue(hw.memoizedSubset(123, tuple(range(5, 40, 3)), {} ))

if __name__ == '__main__':
    unittest.main()