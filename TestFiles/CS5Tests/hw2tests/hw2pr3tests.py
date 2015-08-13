import hw2pr3 as hw

import unittest

def testf(x):
    return 2*x

class hw2pr3_Test(unittest.TestCase):
    def test_unitfracs(self):
        self.assertEqual(hw.unitfracs(11),   
                         [ float(i)/11 for i in range(11) ])
    def test_scaledfracs(self):
        self.assertEqual(hw.scaledfracs(5, 105, 10),   
                         range(5, 105, 10))
    def test_sqfracs(self):
        self.assertEqual(hw.sqfracs(1,11,10),   
                         [ x**2 for x in range(1,11) ])
    def test_f_of_fracs(self):
        self.assertEqual(hw.f_of_fracs(testf,0,10,10),   
                         range(0,20,2))
    def test_integrate(self):
        self.assertAlmostEqual(hw.integrate(testf,0,10,100),
                               99.0,
                               places=4) # to 4 decimal places


    """
    def some_test(self):
        self.assertTrue( something )
    """

if __name__ == '__main__':
    unittest.main(verbosity=2)
