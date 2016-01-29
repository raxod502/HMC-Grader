import geneFinder as hw

import unittest

class RestOfORFTest(unittest.TestCase):
    def testRestOfORF1(self):
        self.assertEqual(hw.restOfORF("ATGAGATAAG"), "ATGAGA")
    def testRestOfORF2(self):
        self.assertEqual(hw.restOfORF("ATGAAATT"), "ATGAAATT")

class OneFrameTest(unittest.TestCase):
    def testOneFrameTooShort(self):
        self.assertEqual(hw.oneFrame("CCATGTAGAAATGCCC"), [])
    def testOneFrameSuccess(self):
        self.assertEqual(hw.oneFrame("ATGCCCATGGGGAAATTTTGACCC"), ["ATGCCCATGGGGAAATTT"])

class LongestORFTest(unittest.TestCase):
    def testLongestORF(self):
        self.assertEqual(hw.longestORF("ATGCCCATGGGGAAATTTTGACCC"), "ATGCCCATGGGGAAATTT")
    def testLongestORFBothStrands(self):
        self.assertEqual(hw.longestORFBothStrands('TTAGGGGCATGAACACATAG'), "ATGTGTTCATGCCCC")
    def testLongestORFNoncoding(self):
        temp = hw.longestORFNoncoding("ATG"+100*"CCCAAAGGGTTT"+"TAA",50)
        self.assertTrue((0 < temp) and (temp < 1206))

class FindORFsTest(unittest.TestCase):
    def testFindORFs1(self):
        self.assertEqual(hw.findORFs("CCATGATGTAACC"),  ['ATGATG'])
    def testFindORFs2(self):
        self.assertEqual(hw.findORFs("CCATGTTTTGACATATGCCC"), ['ATGTTT', 'ATGCCC'])
    def testFindORFsBothStrands(self):
        self.assertEqual(hw.findORFsBothStrands("TGATGTAACAT"), ['ATG', 'ATGTTACATCA'])

class GeneFinderTest(unittest.TestCase):
    def testGeneFinder1(self):
        self.assertEqual(hw.geneFinder("ATG"+10*"CCCAAAGGGTTT"+"TAA",2), [[0, 123, 'MPKGFPKGFPKGFPKGFPKGFPKGFPKGFPKGFPKGFPKGF']])
    def testGeneFinder2(self):
        self.assertEqual(hw.geneFinder("ATG"+10*"CCCAAAGGGTTT"+"TAA",124), [])

if __name__ == '__main__':
    unittest.main()
