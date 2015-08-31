import allTrees as hw

import unittest

class AllTreesLoopTest(unittest.TestCase):
    def testAllTreesLoop1(self):
        self.assertEqual(len(hw.allTreesLoop(range(6))), 945)
    def testAllTreesLoop2(self):
        self.assertEqual(len(hw.allTreesLoop(range(7))), 10395)
    def testAllTreesLoop3(self):
        self.assertEqual(len(hw.allTreesLoop(['a','b','c','d','e'])), 105)

if __name__ == '__main__':
    unittest.main()
