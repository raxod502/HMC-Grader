import hw2pr3 as hw

import unittest

class isortTest(unittest.TestCase):
    def testISortEmptyList(self):
        self.assertEqual(hw.isort([]), [])
    def testISortSingleElement(self):
        self.assertEqual(hw.isort([0]), [0]) 
    def testISortAlreadySorted(self):
        self.assertEqual(hw.isort([0,1,2,3]), [0,1,2,3])
    def testISortIntList(self):
        self.assertEqual(hw.isort([3,1,7,0,2]), [0,1,2,3,7])
    def testISortFloatList(self):
        self.assertEqual(hw.isort([3.5,3.0,3.75]), [3.0,3.5,3.75])

class ssortTest(unittest.TestCase):
    def testSSortEmptyList(self):
        self.assertEqual(hw.ssort([]), [])
    def testSSortSingleElement(self):
        self.assertEqual(hw.ssort([0]), [0]) 
    def testSSortAlreadySorted(self):
        self.assertEqual(hw.ssort([0,1,2,3]), [0,1,2,3])
    def testSSortIntList(self):
        self.assertEqual(hw.ssort([3,1,7,0,2]), [0,1,2,3,7])
    def testSSortFloatList(self):
        self.assertEqual(hw.ssort([3.5,3.0,3.75]), [3.0,3.5,3.75])

class msortTest(unittest.TestCase):
    def testMSortEmptyList(self):
        self.assertEqual(hw.msort([]), [])
    def testMSortSingleElement(self):
        self.assertEqual(hw.msort([0]), [0]) 
    def testMSortAlreadySorted(self):
        self.assertEqual(hw.msort([0,1,2,3]), [0,1,2,3])
    def testMSortIntList(self):
        self.assertEqual(hw.msort([3,1,7,0,2]), [0,1,2,3,7])
    def testMSortFloatList(self):
        self.assertEqual(hw.msort([3.5,3.0,3.75]), [3.0,3.5,3.75])


if __name__ == '__main__':
    unittest.main()
