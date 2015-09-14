import load as hw

import unittest

class LoadSeqTest(unittest.TestCase):
    def testLoadSeq1(self):
        self.assertEqual(hw.loadSeq("test1.fa"), "AGGTCTGTCAACCGTTTCAGTACAACCTAGCCTACCCTGCTAACTAGA")
    def testLoadSeq2(self):
        self.assertEqual(hw.loadSeq("test2.fa"), "CCGTCCATTCGACGGATA")

if __name__ == '__main__':
    unittest.main()
