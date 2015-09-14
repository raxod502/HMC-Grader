import unittest

import hw0pr2 as hw

class inverseTests(unittest.TestCase):
    def testinverse1(self):
        #resultList = hw.scoreList(["a", "s", "m", "t", "p", "z"], testDictionary)
        self.assertAlmostEqual(hw.inverse(3.0), 1.0/3.0)
    def testinverse2(self):
        self.assertAlmostEqual(hw.inverse(4.0), 1.0/4.0)
    def testinverse3(self):
        self.assertAlmostEqual(hw.inverse(5.0), 1.0/5.0)
    def testinverse4(self):
        self.assertAlmostEqual(hw.inverse(6.0), 1.0/6.0)
    def testinverse5(self):
        self.assertAlmostEqual(hw.inverse(7.0), 1.0/7.0)


class eTests(unittest.TestCase):
    def teste1(self):
        self.assertAlmostEqual(hw.e(1), 2.0)
    def teste2(self):
        self.assertAlmostEqual(hw.e(2), 2.5)
    def teste3(self):
        self.assertAlmostEqual(hw.e(3), 2.6666666666667)
    def teste4(self):
        self.assertAlmostEqual(hw.e(10), 2.718281801146385)
    def teste5(self):
        self.assertAlmostEqual(hw.e(10), 2.718281801146385)


class errorTests(unittest.TestCase):
    def testerror1(self):
        self.assertAlmostEqual(hw.error(1), 0.7182818284590451)
    def testerror2(self):
        self.assertAlmostEqual(hw.error(2), 0.2182818284590451)
    def testerror3(self):
        self.assertAlmostEqual(hw.error(3), 0.05161516179237813)
    def testerror4(self):
        self.assertAlmostEqual(hw.error(10), 2.7312660133560485e-08)
    def testerror5(self):
        self.assertAlmostEqual(hw.error(10), 2.7312660133560485e-08)

class facTests(unittest.TestCase):
    def testfac1(self):
        self.assertAlmostEqual(hw.factorial(1), 1.0)
    def testfac2(self):
        self.assertAlmostEqual(hw.factorial(2), 2.0)
    def testfac3(self):
        self.assertAlmostEqual(hw.factorial(3), 6.0)
    def testfac4(self):
        self.assertAlmostEqual(hw.factorial(4), 24.0)
    def testfac5(self):
        self.assertAlmostEqual(hw.factorial(5), 120.0)


class meanTests(unittest.TestCase):
    def testmean1(self):
        self.assertAlmostEqual(hw.mean([1, 2, 3]), 2.0)
    def testmean2(self):
        self.assertAlmostEqual(hw.mean([1, 2, 3, 4]), 2.5)
    def testmean3(self):
        self.assertAlmostEqual(hw.mean([1, 2, 3, 4, 5]), 3.0)
    def testmean4(self):
        self.assertAlmostEqual(hw.mean([1, 2, 3, 4, 5, 6]), 3.5)
    def testmean5(self):
        self.assertAlmostEqual(hw.mean([37, 47]), 42.0)



class primeTests(unittest.TestCase):
    def testprime1(self):
        self.assertEqual(hw.prime(17), True)
    def testprime2(self):
        self.assertEqual(hw.prime(27), False)
    def testprime3(self):
        self.assertEqual(hw.prime(37), True)
    def testprime4(self):
        self.assertEqual(hw.prime(117), False)





if __name__ == '__main__':
    unittest.main()

