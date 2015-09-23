import recursion as hw

import unittest

class DotTest(unittest.TestCase):
    def testDotTwoItems(self):
        self.assertEqual(hw.dot([5,3], [6,4]), 42)
    def testDotThreeItems(self):
        self.assertEqual(hw.dot([3,6,44],[23,1,4]), 251)

class GCcountTest(unittest.TestCase):
    def testGCcount1(self):
        self.assertEqual(hw.GCcount('TGTCG'), 3)
    def testGCcount2(self):
        self.assertEqual(hw.GCcount('ATATAT'), 0)

class CountStartsTest(unittest.TestCase):
    def testCountStarts1(self):
        self.assertEqual(hw.countStarts('ATGCATGT'), 2)
    def testCountStarts2(self):
        self.assertEqual(hw.countStarts('TTATG'), 1)

class ExplodeTest(unittest.TestCase):
    def testExplodeBaseCase(self):
        self.assertEqual(hw.explode(''), [])
    def testExplodeSpam(self):
        self.assertEqual(hw.explode('spam'), ['s', 'p', 'a', 'm'])

class IndTest(unittest.TestCase):
    def testIndItemInList(self):
        self.assertEqual(hw.ind(42, [ 55, 77, 42, 12, 42, 100 ]), 2)
    def testIndItemNotInList(self):
        self.assertEqual(hw.ind('i', 'team'), 4)

class RemoveAllTest(unittest.TestCase):
    def testRemoveAll1(self):
        self.assertEqual(hw.removeAll(42, [ 55, 77, 42, 11, 42, 88 ]), [ 55, 77, 11, 88 ])
    def testRemoveAll2(self):
        self.assertEqual(hw.removeAll(3,[4,3,77,3] ), [4, 77])

if __name__ == '__main__':
    unittest.main()
