import unittest

import hw1pr2 as hw

testDictionary = ["a", "am", "at", "apple", "bat", "bar", "babble", 
                  "can", "foo", "jazz", "spam", "spammy", "zzyzva"] 

class scoreListTests(unittest.TestCase):
    def testScoreList1(self):
        resultList = hw.scoreList(["a", "s", "m", "t", "p", "z"], testDictionary)
        self.assertEqual(len(resultList), 4)
        self.assertTrue(['a', 1] in resultList)
        self.assertTrue(['am', 4] in resultList)
        self.assertTrue(['at', 2] in resultList)
        self.assertTrue(['spam', 8] in resultList)
    def testScoreList2(self):
        resultList = hw.scoreList(["a", "s", "m", "o", "f", "o"], testDictionary)
        self.assertEqual(len(resultList), 3)
        self.assertTrue(['a', 1] in resultList)
        self.assertTrue(['am', 4] in resultList)
        self.assertTrue(['foo', 6] in resultList)
    def testScoreList3(self):
        resultList = hw.scoreList(["a", "j", "m", "z", "z"], testDictionary)
        self.assertEqual(len(resultList), 3)
        self.assertTrue(['a', 1] in resultList)
        self.assertTrue(['am', 4] in resultList)
        self.assertTrue(['jazz', 29] in resultList)
    def testScoreList4(self):
        resultList = hw.scoreList(["a", "s", "m", "m", "p", "y"], testDictionary)
        self.assertEqual(len(resultList), 4)
        self.assertTrue(['a', 1] in resultList)
        self.assertTrue(['am', 4] in resultList)
        self.assertTrue(['spam', 8] in resultList)
        self.assertTrue(['spammy', 15] in resultList)

class bestWordTests(unittest.TestCase):
    def testBestWord1(self):
        self.assertEqual(hw.bestWord(["a", "s", "m", "m", "p", "y"], testDictionary), ['spammy', 15])
    def testBestWord2(self):
        self.assertEqual(hw.bestWord(["a", "s", "m", "o", "f", "o"], testDictionary), ['foo', 6])
    def testBestWord3(self):
        self.assertEqual(hw.bestWord(["a", "j", "m", "z", "z"], testDictionary), ['jazz', 29])

if __name__ == '__main__':
    unittest.main()