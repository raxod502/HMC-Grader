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
    def testInterpT1(self):
        self.assertEqual(3.0, hw.interp(1.0, 9.0, 0.25))
    def testInterpT2(self):
        self.assertEqual(31.5, hw.interp(1.0, 3.0, 0.25))
    def testInterpT3(self):
        self.assertEqual(4.2, hw.interp(2, 12, 0.22))
    def testInterpT4(self):
        self.assertEqual(24.0, hw.interp(24, 42, 0))
    def testInterpT5(self):
        self.assertEqual(42.0, hw.interp(102, 117, -4.0))

class checkendsTests(unittest.TestCase):
    def testCheckendsT1(self):
        self.assertEqual(False, hw.checkends('no match'))
    def testCheckendsT2(self):
        self.assertEqual(True, hw.checkends('hah! a match'))
    def testCheckendsT3(self):
        self.assertEqual(True, hw.checkends('q'))
    def testCheckendsT4(self):
        self.assertEqual(True, hw.checkends(' '))

class flipsideTests(unittest.TestCase):
    def testFlipsideT1(self):
        self.assertEqual('workhome', hw.flipside('homework'))
    def testFlipsideT2(self):
        self.assertEqual('petscar', hw.flipside('carpets'))
    def testFlipsideT3(self):
        self.assertEqual('q', hw.flipside('q'))
    def testFlipsideT4(self):
        self.assertEqual(' ', hw.flipside(' '))

class convertFromSecondsTests(unittest.TestCase):
    def testConvertFromSecondsT1(self):
        self.assertEqual([0,0,10,10], hw.convertFromSeconds(610))
    def testConvertFromSecondsT2(self):
        self.assertEqual([1,3,46,40], hw.convertFromSeconds(100000))


if __name__ == '__main__':
    unittest.main()