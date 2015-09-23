import milk as hw
import reads

import unittest

class MapReadTest(unittest.TestCase):
    def testMapRead1(self):
        self.assertEqual(hw.mapRead("CG", "ATCGCG"), [[2, 4], [4, 6]])
    def testMapRead2(self):
        self.assertEqual(hw.mapRead("ACT", "GATTACAACTGGTATACCATACTTAGCCGCTA"), [[7, 10], [20, 23]])
    def testMapRead3(self):
        self.assertEqual(hw.mapRead("CC","ATGG"), [])

class MapReadBothStrandsTest(unittest.TestCase):
    def testMapReadBothStrands1(self):
        self.assertEqual(hw.mapReadBothStrands("AA","CGGGCAAGTTC"), [[5, 7], [8, 10]])
    def testMapReadBothStrands2(self):
        self.assertEqual(hw.mapReadBothStrands("AC","ACGT"), [[0, 2], [2, 4]])
    
class MultiReadsTest(unittest.TestCase):
    def testMultiReads1(self):
        self.assertEqual(hw.multiReads(reads.zach,reads.lacDNA[:2000]), [[218, 256], [277, 313]])
    def testMultiReads2(self):
        self.assertEqual(hw.multiReads(["TTACC","GATAAGGTT"],"AAGGTTGGAATTGAACCGGTATTACGTTACCTGGTA"), [[26, 31]])

class MapSplicedReadTest(unittest.TestCase):
    def testMapSplicedRead1(self):
        self.assertEqual(hw.mapSplicedRead("ATT", "ATAT", 3), 'NOT FOUND')
    def testMapSplicedRead2(self):
        self.assertEqual(hw.mapSplicedRead("AACC", "GGAAGGCC",2), [2, 4, 6, 8])
    def testMapSplicedRead3(self):
        self.assertEqual(hw.mapSplicedRead("CCAA", "GGAAGGCC",2), 'NOT FOUND')
    def testMapSplicedRead4(self):
        self.assertEqual(hw.mapSplicedRead("GTGGCCGGTAAACATAGATGTCTGGGGAACTTACCCTAAC", reads.lacDNA, 15), [417, 437, 9042, 9062] )

class IntronFinder(unittest.TestCase):
    def testIntronFinder1(self):
        self.assertEqual(sorted(hw.intronFinder(['CGGC','GGAATTGG'], 'CCCCGGGGAAAATTTTAAAATTTTGGGGCCCC', 2)), [[5, 27], [10, 22]])
    def testIntronFinder2(self):
        self.assertEqual(sorted(hw.intronFinder(['CGGC','GGAATTGG'], 'CCCCGGGGAAAATTTTAAAATTTTGGGGCCCC', 4)), [[10, 22]])
    def testIntronFinder3(self):
        self.assertEqual(sorted(hw.intronFinder(['ACGTTGAC','GGGAAA'], 'ACGTGGGAAATGAC', 3)), [[4, 10]])

if __name__ == '__main__':
    unittest.main()
