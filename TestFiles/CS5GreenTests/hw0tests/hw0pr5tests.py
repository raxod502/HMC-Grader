import googleSecret as hw

import unittest

class InverseTest(unittest.TestCase):
    def testInverse50(self):
        self.assertEqual(hw.inverse(50), 0.02)
    def testInverse35(self):
        self.assertAlmostEqual(hw.inverse(35), 0.02857142857142857)

class ETest(unittest.TestCase):
    def testE100(self):
        self.assertAlmostEqual(hw.e(100), 2.7182818284590455)

class ErrorTest(unittest.TestCase):
    def testError5(self):
        self.assertAlmostEqual(hw.error(5), 0.0016151617923783057)

class FactorialTest(unittest.TestCase):
    def testFactorial8(self):
        self.assertEqual(hw.factorial(8), 40320)

class GeoMeanTest(unittest.TestCase):
    def testGeoMeanFloatAns(self):
        self.assertAlmostEqual(hw.geoMean([1, 3, 3, 7]), 2.8173132472612576)
    def testGeoMeanIntAns(self):
        self.assertEqual(hw.geoMean([1, 3, 3, 9]), 3.0)

class PrimeTest(unittest.TestCase):
    def testPrimeFalse(self):
        self.assertEqual(hw.prime(13449), False)
    def testPrimeTrue(self):
        self.assertEqual(hw.prime(13441), True)

if __name__ == '__main__':
    unittest.main()
