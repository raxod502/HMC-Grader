import googleSecret as hw

import unittest

class InverseTest(unittest.TestCase):
    def testInverse35(self):
        self.assertEqual(round(hw.inverse(35),4), 0.0286)
    def testInverse50(self):
        self.assertEqual(round(hw.inverse(50),4), 0.02)

class ETest(unittest.TestCase):
    def testE10(self):
        self.assertEqual(round(hw.e(10),2), 2.72)
    def testE100(self):
        self.assertEqual(round(hw.e(100),4), 2.7183)

class ErrorTest(unittest.TestCase):
    def testError5(self):
        self.assertEqual(round(hw.error(5),6), 0.001615)

class FactorialTest(unittest.TestCase):
    def testFactorial8(self):
        self.assertEqual(hw.factorial(8), 40320)

class GeoMeanTest(unittest.TestCase):
    def testGeoMeanFloatAns(self):
        self.assertEqual(round(hw.geoMean([1, 3, 3, 7]),4), 2.8173)
    def testGeoMeanIntAns(self):
        self.assertEqual(round(hw.geoMean([1, 3, 3, 9]),4), 3.0)

class PrimeTest(unittest.TestCase):
    def testPrimeFalse(self):
        self.assertEqual(hw.prime(13449), False)
    def testPrimeTrue(self):
        self.assertEqual(hw.prime(13441), True)

if __name__ == '__main__':
    unittest.main()
