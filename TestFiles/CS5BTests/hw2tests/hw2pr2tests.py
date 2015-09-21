import hw2pr2 as hw

import unittest

class fancyLCSTest(unittest.TestCase):
    def testLCSEmptyString(self):
        self.assertEqual(hw.fancyLCS("", "spam"), [0, '', '####'])
    def testLCSSingleChars(self):
        self.assertEqual(hw.fancyLCS("a", "z"), [0, '#', '#'])
    def testLCSNoCommonSeq(self):
        self.assertEqual(hw.fancyLCS("cs", "awesome"), [1, '#s', '###s###'])
    def testLCSSamePosition(self):
        self.assertEqual(hw.fancyLCS("hi", "high"), [2, 'hi', 'hi##'])
    def testLCSDiffPosition(self):
        self.assertEqual(hw.fancyLCS("abracadabra", "bravery"), [4, '#bra#####r#', 'bra##r#'])
   
class alignTest(unittest.TestCase):
    def testAlignEmptyString(self):
        self.assertEqual(hw.align("", "spam"), [0, '----', 'spam'])
    def testAlignSingleChars(self):
        self.assertTrue((hw.align("a", "z") == [0, 'a-', '-z']) or (hw.fancyLCS("a", "z") == [0, '-a', 'z-']))
    def testAlignNoCommonSeq(self):
        self.assertEqual(hw.align("cs", "awesome"), [0, 'cs-------', '--awesome'])
    def testAlignSamePosition(self):
        self.assertEqual(hw.align("hi", "high"), [2, 'hi--', 'high'])
    def testAlignDNA(self):
        self.assertEqual(hw.align("ATTGC", "GATC"), [3, '-ATTGC', 'GAT--C'])

if __name__ == '__main__':
    unittest.main()
