import looping as hw

import unittest

class CountLengthTest(unittest.TestCase):
    def testCountLengthMatch(self):
        self.assertEqual(hw.countLength(["ATA", "ATCG", "TTT", "A"], 3), 2)
    def testCountLengthNoMatch(self):
        self.assertEqual(hw.countLength(["AACC", "A", "T"], 2), 0)

class GetLengthTest(unittest.TestCase):
    def testGetLengthMatch(self):
        self.assertEqual(hw.getLength(["ATA", "ATCG", "TTT", "A"], 3), ['ATA', 'TTT'])
    def testGetLengthNoMatch(self):
        self.assertEqual(hw.getLength(["AACC", "A", "T"], 2), [])
    def testGetLengthEmptyString(self):
        self.assertEqual(hw.getLength(['','A','AGCTA'], 5), ['AGCTA'])


if __name__ == '__main__':
    unittest.main()
