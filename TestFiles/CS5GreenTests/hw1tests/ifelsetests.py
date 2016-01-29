import ifelse as hw

import unittest

class AbsoluteTest(unittest.TestCase):
    def testAbsoluteNeg(self):
        self.assertEqual(hw.absolute(-5), 5)
    def testAbsolutePos(self):
        self.assertAlmostEqual(hw.absolute(15), 15)

class ORFadvisorTest(unittest.TestCase):
    def testORFadviser1(self):
        self.assertEqual(hw.ORFadviser("CCC"), 'The first three bases are not ATG.')
    def testORFadviser2(self):
        self.assertEqual(hw.ORFadviser("ATGGGG"), 'The last three bases are not a stop codon.')
    def testORFadviser3(self):
        self.assertEqual(hw.ORFadviser("ATGCCCTAC"), 'The last three bases are not a stop codon.')
    def testORFadviser4(self):
        self.assertEqual(hw.ORFadviser("ATGCTAA"), 'The string is not of the correct length.')
    def testORFadviser5(self):
        self.assertEqual(hw.ORFadviser("ATGCCCGGTAA"), 'The string is not of the correct length.')
    def testORFadviser6(self):
        self.assertEqual(hw.ORFadviser("ATGCCCGGGTAA"), 'This is an ORF.')

class FriendlyTest(unittest.TestCase):
    def testFriendly1(self):
        self.assertEqual(type(hw.friendly("Hello")), type(""))
    def testFriendly2(self):
        self.assertEqual(type(hw.friendly("How are you?")), type(""))
    def testFriendly3(self):
        self.assertEqual(hw.friendly("How are you?"), 'Good question!')
    def testFriendly4(self):
        self.assertEqual(hw.friendly("Huh?"), 'Good question!')


if __name__ == '__main__':
    unittest.main()
