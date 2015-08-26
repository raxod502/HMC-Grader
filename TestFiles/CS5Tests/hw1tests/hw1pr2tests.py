import unittest

import hw1pr2 as hw

class sqTests(unittest.TestCase):
    def testZeroSq(self):
        self.assertEqual(hw.sq(0), 0)
    def testOneSq(self):
        self.assertEqual(hw.sq(1), 1)
    def testNegOneSq(self):
        self.assertEqual(hw.sq(-1), 1)
    def testFourSq(self):
        self.assertEqual(hw.sq(4), 16)
    def testNegfourSq(self):
        self.assertEqual(hw.sq(-4), 16)

class interpTests(unittest.TestCase):
    def testInterpSameHighAndLow(self):
        self.assertEqual(0.0, hw.interp(0.0, 0.0, 0.1))
    def testInterpFracOverOne(self):
        self.assertEqual(5.0, hw.interp(1.0, 3.0, 2.0))
    def testInterpNegFraction(self):
        self.assertEqual(0.5, hw.interp(1.0, 3.0, -0.25))
    def testInterpZeroFraction(self):
        self.assertEqual(10.0, hw.interp(10.0, 100, 0))

class checkendsTests(unittest.TestCase):
    def testCheckendsNoMatch(self):
        self.assertEqual(False, hw.checkends('hello world'))
    def testCheckendsDiffCase(self):
        self.assertEqual(False, hw.checkends('aaaaAAAA'))
    def testCheckendsNonLettters(self):
        self.assertEqual(True, hw.checkends('123 321'))
    def testCheckendsMatching(self):
        self.assertEqual(True, hw.checkends('racecar'))
    def testCheckendsSingleChar(self):
        self.assertEqual(True, hw.checkends('z'))
    def testCheckendsBlankString(self):
        self.assertEqual(True, hw.checkends(' '))

class flipsideTests(unittest.TestCase):
    def testFlipsideEvenLength(self):
        self.assertEqual('cattom', hw.flipside('tomcat'))
    def testFlipsideOddLength(self):
        self.assertEqual('homefun', hw.flipside('funhome'))
    def testFlipsideSingleChar(self):
        self.assertEqual('z', hw.flipside('z'))
    def testFlipsideBlankString(self):
        self.assertEqual(' ', hw.flipside(' '))

class convertFromSecondsTests(unittest.TestCase):
    def testConvertFromSecondsOnlySecs(self):
        self.assertEqual([0,0,0,30], hw.convertFromSeconds(30))
    def testConvertFromSecondsSecsAndMins(self):
        self.assertEqual([0,0,11,40], hw.convertFromSeconds(700))
    def testConvertFromSecondsSecsMinsHrs(self):
        self.assertEqual([0,1,12,1], hw.convertFromSeconds(4321))      
    def testConvertFromSecondsSecsMinsHrsDay(self):
        self.assertEqual([1,23,13,20], hw.convertFromSeconds(1700000))


if __name__ == '__main__':
    unittest.main()