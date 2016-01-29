import unittest

import hw1pr3 as hw

class changeTests(unittest.TestCase):
    def testChange1(self):
        self.assertEqual(hw.change(48, [1, 5, 10, 25, 50]), 6)
    def testChange2(self):
        self.assertEqual(hw.change(48, [1, 7, 24, 42]), 2)
    def testChange3(self):
        self.assertEqual(hw.change(35, [1, 3, 16, 30, 50]), 3)
    def testChange4(self):
        self.assertEqual(hw.change(6, [4, 5, 9]), float('inf'))

class giveChangeTests(unittest.TestCase):
    def testGiveChange1(self):
        resultChange = hw.giveChange(48, [1, 5, 10, 25, 50])
        self.assertEqual(resultChange[0], 6)
        self.assertEqual(len(resultChange[1]), 6)
        self.assertTrue(25 in resultChange[1])
        self.assertTrue(10 in resultChange[1])
        self.assertTrue(1 in resultChange[1])
    def testGiveChange2(self):
        resultChange = hw.giveChange(48, [1, 7, 24, 42])
        self.assertEqual(resultChange[0], 2)
        self.assertEqual(len(resultChange[1]), 2)
        self.assertTrue(24 in resultChange[1])
    def testGiveChange3(self):
        resultChange = hw.giveChange(35, [1, 3, 16, 30, 50])
        self.assertEqual(resultChange[0], 3)
        self.assertEqual(len(resultChange[1]), 3)
        self.assertTrue(16 in resultChange[1])
        self.assertTrue(3 in resultChange[1])
    def testGiveChange4(self):
        resultChange = hw.giveChange(6, [4, 5, 9])
        self.assertEqual(resultChange[0], float('inf'))
        self.assertEqual(len(resultChange[1]), 0)


if __name__ == '__main__':
    unittest.main()