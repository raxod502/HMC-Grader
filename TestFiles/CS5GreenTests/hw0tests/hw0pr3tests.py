import first as hw

import unittest

class PowerTest(unittest.TestCase):
    def testPowerFour(self):
        self.assertEqual(hw.power(4), 256)
    def testPowerZero(self):
        self.assertEqual(hw.power(0), 1)

class StringMultiplyTest(unittest.TestCase):
    def testStringMultiplySpam(self):
        self.assertEqual(hw.stringMultiply("spam",4), "spamspamspamspam")

class ListMakerTest(unittest.TestCase):
    def testListMakerMaps(self):
        self.assertEqual(hw.listMaker("maps",7), ['maps', 'maps', 'maps', 'maps', 'maps', 'maps', 'maps'])

class PalindromeMakerTest(unittest.TestCase):
    def testPalindromeShort(self):
        self.assertEqual(hw.palindromeMaker('ab'), 'abba')
    def testPalindromeLong(self):
        self.assertEqual(hw.palindromeMaker('a man a plan a canal panama'), 'a man a plan a canal panamaamanap lanac a nalp a nam a')

if __name__ == '__main__':
    unittest.main()
