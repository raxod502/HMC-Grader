import dna as hw

import unittest

class CompBaseTest(unittest.TestCase):
    def testCompBaseA(self):
        self.assertEqual(hw.compBase("A"), "T")
    def testCompBaseG(self):
        self.assertEqual(hw.compBase("G"), "C")

class ReverseTest(unittest.TestCase):
    def testReverseChar(self):
        self.assertEqual(hw.reverse("h"), "h")
    def testReverseStr(self):
        self.assertEqual(hw.reverse("spam"), "maps")

class AminoTest(unittest.TestCase):
    def testAminoF(self):
        self.assertEqual(hw.amino("TTT"), "F")
    def testAminoM(self):
        self.assertEqual(hw.amino('ATG'), "M")

class ReverseComplementTest(unittest.TestCase):
    def testReverseComplement1(self):
        self.assertEqual(hw.reverseComplement("GATTACA"), "TGTAATC")
    def testReverseComplement2(self):
        self.assertEqual(hw.reverseComplement("CCCGGG"), "CCCGGG")

class CodingStrTest(unittest.TestCase):
    def testPIL(self):
        self.assertEqual(hw.codingStrandToAA("CCCATATTG"), "PIL")
    def testCHAI(self):
        self.assertEqual(hw.codingStrandToAA("TGTCACGCGATA"), "CHAI")

if __name__ == '__main__':
    unittest.main()
