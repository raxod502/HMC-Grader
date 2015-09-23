import hw3pr1 as hw

import unittest

class LCTest(unittest.TestCase):
    def testScale(self):
        self.assertEqual(hw.scale( [70, 80, 420], 0.1 ), [7.0, 8.0, 42.0] )
    def testAdd2_1(self):
        self.assertEqual(hw.add_2( [10, 11, 12], [20, 25, 30] ), [30, 36, 42] )
    def testAdd2_2(self):
        self.assertEqual(hw.add_2( [10, 11], [20, 25, 30] ), [30, 36] )
    def testAdd3_1(self):
        self.assertEqual(hw.add_3( [10, 11, 12], [20, 25, 30], [1,2,0] ), [31, 38, 42] )
    def testAdd3_2(self):
        self.assertEqual(hw.add_3( [10, 11], [20, 25, 30], [12] ), [42] )
    def testAddScale2_1(self):
        self.assertEqual(hw.add_scale_2( [10, 20, 30], [7, 8, 9], 0.1, 10 ), [71.0, 82.0, 93.0] )
    def testAddScale2_2(self):
        self.assertEqual(hw.add_scale_2( [10, 20, 30], [7, 8], 0.1, 10 ), [71.0, 82.0] )




if __name__ == '__main__':
    unittest.main()