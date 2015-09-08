import countpattern as hw

import unittest

class CountPatternTest(unittest.TestCase):
    def testCountPattern1(self):
        self.assertEqual(hw.countPattern("aha", "haha!aha."), 2)
    def testCountPattern2(self):
        self.assertEqual(hw.countPattern("zzz", "hi there!"), 0)
    def testCountPattern3(self):
        self.assertEqual(hw.countPattern("aa", "aaabaaa"), 4)
    def testCountPattern4(self):
        self.assertEqual(hw.countPattern("ag","ksjdfajfagiec, kaierag"), 2)
    def testCountPattern5(self):
        self.assertEqual(hw.countPattern("sj","ksjdSJ"), 1)

if __name__ == '__main__':
    unittest.main()
