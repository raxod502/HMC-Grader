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

if __name__ == '__main__':
    unittest.main()
