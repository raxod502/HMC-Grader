import gcwindows as hw

import unittest

class PalindromeTest(unittest.TestCase):
    def testPalindromeTrue(self):
        self.assertEqual(hw.palindrome("radar"), True)
    def testPalindromeFalse(self):
        self.assertEqual(hw.palindrome("spam"), False)

class FancyPalTest(unittest.TestCase):
    def testFancyPalTrue(self):
        self.assertEqual(hw.fancyPal("A man, a plan, a canal, Panama."), True)
    def testFancyPalFlase(self):
        self.assertEqual(hw.fancyPal("Goodness."), False)

if __name__ == '__main__':
    unittest.main()
