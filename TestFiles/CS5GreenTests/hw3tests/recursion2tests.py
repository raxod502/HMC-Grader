import recursion2 as hw

import unittest

class DeepLenTest(unittest.TestCase):
    def testDeepLen1(self):
        self.assertEqual(hw.deepLen([[2],3,4,[3,[[[4,5,6],44,5],3]]]), 10)
    def testDeepLen2(self):
        self.assertEqual(hw.deepLen([1, [2, [3, 4, 5], 6], 7]), 7)

class DeepReverseTest(unittest.TestCase):
    def testDeepReverse1(self):
        self.assertEqual(hw.deepReverse([1, [2, [4, 5], 6], 7]), [7, [6, [5, 4], 2], 1])
    def testDeepReverse2(self):
        self.assertEqual(hw.deepReverse([4,5,[[5,4],[1,2],8],1,8,[1,2]]), [[2, 1], 8, 1, [8, [2, 1], [4, 5]], 5, 4])

class DeepRemoveAllTest(unittest.TestCase):
    def testDeepRemoveAll1(self):
        self.assertEqual(hw.deepRemoveAll(47, [42, 47, [1, 2, [47, 48, 49], 50, 47, 51], 52]), [42, [1, 2, [48, 49], 50, 51], 52] )
    def testDeepRemoveAll2(self):
        self.assertEqual(hw.deepRemoveAll(42, [42, 67, 42, [41, 42, 43], 47]), [67, [41, 43], 47])

if __name__ == '__main__':
    unittest.main()