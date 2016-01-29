import first as hw

import unittest

class PowerTest(unittest.TestCase):
    def testPowerFour(self):
        self.assertEqual(hw.power(4), 256)

class StringMultiplyTest(unittest.TestCase):
    def testStringMultiplySpam(self):
        self.assertEqual(hw.stringMultiply("spam",4), "spamspamspamspam")
    def testStringMultiplyAB(self):
        self.assertEqual(hw.stringMultiply("ab",2), "abab")

class ListMakerTest(unittest.TestCase):
    def testListMakerMaps(self):
        self.assertEqual(hw.listMaker("maps",7), ['maps', 'maps', 'maps', 'maps', 'maps', 'maps', 'maps'])
    def testListMakerCharA(self):
        self.assertEqual(hw.listMaker('a',3), ['a', 'a', 'a'])

if __name__ == '__main__':
    unittest.main()
