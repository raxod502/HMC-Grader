import gcContent as hw

import unittest

class GcContentTest(unittest.TestCase):
    def testGcContent1(self):
        self.assertEqual(hw.gcContent("ACCGC"), 0.8)
    def testGcContent2(self):
        self.assertEqual(hw.gcContent("ATACTAAA"), 0.125)
    def testGcContent3(self):
        self.assertEqual(hw.gcContent("GGCCGATAAGTGCCGC"), 0.6875)
    def testGcContent4(self):
        self.assertEqual(hw.gcContent("GGCCGC"), 1.0)
    def testGcContent5(self):
        self.assertEqual(hw.gcContent("ATAATAAT"), 0.0)

if __name__ == '__main__':
    unittest.main()
