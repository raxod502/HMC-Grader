import count as hw

import unittest

class CountTest(unittest.TestCase):
    def testCount1(self):
        self.assertEqual(hw.count('b', 'biology terms with z'), 1)
    def testCount2(self):
        self.assertEqual(hw.count('z', 'zyzzyva'), 3)
    def testCount3(self):
        self.assertEqual(hw.count('z', 'zyzzyzus'), 4)
    def testCount4(self):
        self.assertEqual(hw.count('h','It has not escaped our notice that the specific pairing we have postulated'), 4)
    def testCount5(self):
        self.assertEqual(hw.count(' ','It has not escaped our notice that the specific pairing we have postulated'), 12)

if __name__ == '__main__':
    unittest.main()
