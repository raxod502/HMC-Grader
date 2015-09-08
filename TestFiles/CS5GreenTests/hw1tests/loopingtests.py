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

class FactorialTest(unittest.TestCase):
    def testFactorial1(self):
        self.assertEqual(hw.factorial(1), 1)
    def testFactorial4(self):
        self.assertEqual(hw.factorial(4), 24)
    def testFactorial6(self):
        self.assertEqual(hw.factorial(6), 720)

if __name__ == '__main__':
    unittest.main()
