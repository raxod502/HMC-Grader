import hw3pr2 as hw

import unittest

class FastEDTest(unittest.TestCase):
    def testFastED1(self):
        self.assertEqual(hw.fastED("extraordinary", "originality"), 10)
    def testFastED2(self):
        self.assertEqual(hw.fastED("antidisestablishment", "antiquities"), 13)
    def testFastED3(self):
        self.assertEqual(hw.fastED("xylophone", "yellow"), 7)
    def testFastED4(self):
        self.assertEqual(hw.fastED("follow", "yellow"), 2)
    def testFastED5(self):
        self.assertEqual(hw.fastEd("lower", "hover"), 2)

class TopNMatchesTest(unittest.TestCase):
    def testTopNMatchesBaseCase(self):
        self.assertEqual(hw.topNmatches("test", 0, ["spam", "seam", "wow"]), [])
    def testTopNMatchesCorrectSpelling(self):
        self.assertEqual(hw.topNmatches("spam", 1, ["spam", "seam", "wow", "cs5blackrocks", "span", "synecdoche"]), ['spam'])
    def testTopNMatchesSingleResplacement(self):
        self.assertEqual(hw.topNmatches("spam", 3, ["spam", "seam", "wow", "cs5blackrocks", "span", "synecdoche"]), ['seam', 'spam', 'span'])
    def testTopNMatchesReturnsWholeList(self):
        self.assertEqual(hw.topNmatches("a", 3, ["b", "c", "d"]), ['b', 'c', 'd'])
    def testTopNMatchesNGreaterThanListLength(self):
        self.assertEqual(hw.topNmatches("a", 4, ["b", "c", "d"]), ['b', 'c', 'd'])
if __name__ == '__main__':
    unittest.main()
