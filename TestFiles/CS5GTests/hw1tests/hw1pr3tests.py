import hw1pr3 as hw

import unittest

class MultTest(unittest.TestCase):
    def testPositives(self):
        self.assertAlmostEqual(hw.mult(6,7), 42)
    def testFirstNeg(self):
        self.assertAlmostEqual(hw.mult(-3,5), -15, msg="Remember that multiplying a negative by a number is the opposite of multiplying the negative of the negative")
    def testBothNeg(self):
        self.assertAlmostEqual(hw.mult(-3,-5), 15, msg="Remember that multiplying a negative by a number is the opposite of multiplying the negative of the negative")
    def testSecondZero(self):
        self.assertAlmostEqual(hw.mult(4,0), 0, msg="Make sure you have a base case for 0")
    def testFirstZero(self):
        self.assertAlmostEqual(hw.mult(0,4), 0, msg="Make sure you have a base case for 0")

class DotTest(unittest.TestCase):
    def testTwoByTwo(self):
        self.assertAlmostEqual(hw.dot([5,3],[6,4]),42)
    def testTwoByOne(self):
        self.assertAlmostEqual(hw.dot([5,3],[6]),0, msg="Make sure the lengths are the same!")
    def testTwoByThree(self):
        self.assertAlmostEqual(hw.dot([5,3],[6,8,42]),0, msg="Make sure the lengths are the same!")
    def testTwoByTwoToZero(self):
        self.assertAlmostEqual(hw.dot([3,4],[1,0]),3)
    def testZeroByTwo(self):
        self.assertAlmostEqual(hw.dot([],[1,0]),0, msg="Make sure the lengths are the same!")

class IndTest(unittest.TestCase):
    def testInListTwice(self):
        self.assertEqual(hw.ind(1,[0,0,999,-1,1,2,3,1]), 4, "Make sure that you're checking for the first instance of the number")
    def testNotInList(self):
        self.assertEqual(hw.ind(1,[5,2,3,5]), 4, "What happens if the element isn't in the list?")
    def testEmptyList(self):
        self.assertEqual(hw.ind(1,[]), 0, "Make sure you can deal with the empty string")
    def testStrangeTypes(self):
        self.assertEqual(hw.ind(42,['42',[42,42]]), 2, "'42' and 42 are not equal (the first is the string, the second is a number). Also make sure that you're not going down into inner lists")
    def testStrings(self):
        self.assertEqual(hw.ind('i', 'well hi there'), 6, "Make sure ind works for strings as well as lists")

class LetterScoreTest(unittest.TestCase):
    def testNAN(self):
        self.assertEqual(hw.letterScore('4'), 0, "Make sure that nonletters return 0")
    def testK(self):
        self.assertEqual(hw.letterScore('k'), 5)
    def testN(self):
        self.assertEqual(hw.letterScore('n'), 1)
    def testW(self):
        self.assertEqual(hw.letterScore('w'), 4)
    def testC(self):
        self.assertEqual(hw.letterScore('c'), 3)

class ScrabbleScoreTest(unittest.TestCase):
    def testSYZYGY(self):
        self.assertEqual(hw.scrabbleScore('syzygy'), 25)
    def testTWELVE(self):
        self.assertEqual(hw.scrabbleScore('twelve'), 12, "``twelve'' is worth 12 points. Wooooooaaaahhhh")
    def testW2(self):
        self.assertEqual(hw.scrabbleScore('w'), 4)
    def testJONQUIL(self):
        self.assertEqual(hw.scrabbleScore('jonquil'), 23)
    def testEmpty(self):
        self.assertEqual(hw.scrabbleScore(''), 0, "Check your base case!")

class TranscribeTest(unittest.TestCase):
    def testACGT_TGCA(self):
        self.assertEqual(hw.transcribe('ACGT TGCA'), 'UGCAACGU', "How are you dealing with characters that aren't A, C, T, or G?")
    def testGATTACA(self):
        self.assertEqual(hw.transcribe('GATTACA'), 'CUAAUGU')
    def testNonDNA(self):
        self.assertEqual(hw.transcribe('cs5'), '', "How are you dealing with characters that aren't A, C, T, or G?")
    def testGATTACA2(self):
        self.assertEqual(hw.transcribe('GATTACA'), 'CUAAUGU')
    def testNonDNA2(self):
        self.assertEqual(hw.transcribe('cs5'), '', "How are you dealing with characters that aren't A, C, T, or G?")

class PigletLatinTest(unittest.TestCase):
    def testOne(self):
        self.assertEqual(hw.pigletLatin('one'), 'oneway')
    def testBe(self):
        self.assertEqual(hw.pigletLatin('be'), 'ebay')

class PigLatinTest(unittest.TestCase):
    def testString(self):
        self.assertEqual(hw.pigLatin('string'), 'ingstray')
    def testYttrium(self):
        self.assertEqual(hw.pigLatin('yttrium'), 'yttriumway', "Make sure that you deal with words starting with y correctly.")
    def testYoohoo(self):
        self.assertEqual(hw.pigLatin('yoohoo'), 'oohooyay')


if __name__ == '__main__':
    unittest.main()
