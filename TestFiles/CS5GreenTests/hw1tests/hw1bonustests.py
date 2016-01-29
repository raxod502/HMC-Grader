import hw1bonus as hw

import unittest

class FancyPalTest(unittest.TestCase):
    def testFancyPalTrue(self):
        self.assertEqual(hw.fancyPal("A man, a plan, a canal, Panama."), True)
    def testFancyPalFlase(self):
        self.assertEqual(hw.fancyPal("Goodness."), False)

if __name__ == '__main__':
    unittest.main()
