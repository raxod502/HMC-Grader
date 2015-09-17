import hw3pr2 as hw

import unittest


class EncipherTest(unittest.TestCase):
    def testEncipherEmpty(self):
        self.assertEqual(hw.encipher('',19), '')
    def testEncipherRot0(self):
        self.assertEqual(hw.encipher('a A!', 0), 'a A!')
    def testEncipherStr1(self):
        self.assertEqual(hw.encipher('abcdefghijklmnopqrstuvwxyz ABCZ!', 1), 'bcdefghijklmnopqrstuvwxyza BCDA!')
    def testEncipherStr2(self):
        self.assertEqual(hw.encipher('youre joking Mr. Feynman!', 10), 'iyebo tyusxq Wb. Poixwkx!')
    def testEncipherStr3(self):
        self.assertEqual(hw.encipher('An education is what is left after you forget everything you learned.', 5), 'Fs jizhfynts nx bmfy nx qjky fkyjw dtz ktwljy jajwdymnsl dtz qjfwsji.')


class DecipherTest(unittest.TestCase):
    def testDecipherEmpty(self):
        self.assertEqual(hw.decipher(''), '')
    def testDecipherStr1(self):
        self.assertEqual(hw.decipher( 'Bzdrzq bhogdq? H oqdedq Bzdrzq rzkzc.' ), 'Caesar cipher? I prefer Caesar salad.')
    def testDecipherStr2(self):
        self.assertEqual(hw.decipher( 'Fs jizhfynts nx bmfy nx qjky fkyjw dtz ktwljy jajwdymnsl dtz qjfwsji.' ), 'An education is what is left after you forget everything you learned.')
    def testDecipherStr3(self):
        self.assertEqual(hw.decipher('Ftdqq efmfuefuoumze sa agf tgzfuzs fasqftqd. Mrfqd m ituxq ftqk ebaf m eaxufmdk dmnnuf. Ftq rudef efmfuefuoumz fmwqe muy mzp ahqdetaafe. Ftq eqoazp muye mzp gzpqdetaafe. Ftq ftudp etagfe agf, Iq saf tuy!') , 'Three statisticians go out hunting together. After a while they spot a solitary rabbit. The first statistician takes aim and overshoots. The second aims and undershoots. The third shouts out, We got him!' )
    def testDecipherStr4(self):
        self.assertEqual(hw.decipher( 'Gurl jbex vg bhg jvgu n crapvy!' ), 'They work it out with a pencil!')


class GenSortTest(unittest.TestCase):
    def testGenSortPositives(self):
        self.assertEqual(hw.gensort([10,6,0,8,2,4]), [0,2,4,6,8,10])
    def testGenSortBackwardsPositives(self):
        self.assertEqual(hw.gensort(range(20,0,-1)), [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20])
    def testGenSortTwoElements(self):
        self.assertEqual(hw.gensort([1,0]), [0,1])
    def testGenSortOneElement(self):
        self.assertEqual(hw.gensort([42]), [42])
    def testGenSortEmpty(self):
        self.assertEqual(hw.gensort([]), [])

class JScoreTest(unittest.TestCase):
    def testJScoreEs(self):
        self.assertEqual(hw.jscore('geese','eeeek'), 3)
    def testJScoreOneEmpty(self):
        self.assertEqual(hw.jscore('','donut'), 0)
    def testJScoreBothEmpty(self):
        self.assertEqual(hw.jscore('',''), 0)
    def testJScoreBackward(self):
        self.assertEqual(hw.jscore('abcdefg','gfedcbb'), 6)
    def testJScore0Score(self):
        self.assertEqual(hw.jscore('abcdefg','hijklmnopqrs'), 0)

class BLSortTest(unittest.TestCase):
    def testBLSortRandom(self):
        self.assertEqual(hw.blsort([0,1,1,0,1,1]), [0,0,1,1,1,1])
    def testBLSortZerosSurroundedByOnes(self):
        self.assertEqual(hw.blsort([1]+[0]*10+[1]), [0,0,0,0,0,0,0,0,0,0,1,1])
    def testBLSortTwoElementsBackward(self):
        self.assertEqual(hw.blsort([1,0]), [0,1])
    def testBLSortOneOne(self):
        self.assertEqual(hw.blsort([1]), [1])
    def testBLSortEmpty(self):
        self.assertEqual(hw.blsort([]), [])

class LCSTest(unittest.TestCase):
    def testLCSMonkeys(self):
        self.assertEqual(hw.LCS('human', 'chimp'), 'hm')
    def testLCSDNA(self):
        self.assertEqual(hw.LCS('gattaca', 'tacgaacta'), 'gaaca')
    def testLCSOnomatopoeia(self):
        self.assertEqual(hw.LCS('wow','whew'), 'ww')
    def testLCSLetters(self):
        self.assertEqual(hw.LCS('abcdefgh','efgabcd'), 'abcd')
    def testLCSPronouns(self):
        self.assertEqual(hw.LCS('this','that'), 'th')

class ExactChangeTest(unittest.TestCase):
    def testExactChangeSuccess1(self):
        self.assertEqual(hw.exact_change( 42, [25, 1, 25, 10, 5, 1] ), True)
    def testExactChangeFail1(self):
        self.assertEqual(hw.exact_change( 42, [25, 1, 25, 10, 5] ), False)
    def testExactChangeFail2(self):
        self.assertEqual(hw.exact_change( 42, [23, 1, 23, 100] ), False)
    def testExactChangeSuccess2(self):
        self.assertEqual(hw.exact_change( 42, [23, 17, 2, 100] ), True)
    def testExactChangeZero(self):
        self.assertEqual(hw.exact_change( 0, [4, 5, 6] ), True)

class Make_ChangeTest(unittest.TestCase):
    def testZeroEmpty_MC(self):
        self.assertEqual(hw.make_change(0,[]), [])
    def testMakeFortyTwo1_MC(self):
        self.assertEqual(sorted(hw.make_change( 42, [25, 1, 25, 10, 5, 1] )), [1, 1, 5, 10, 25] )
    def testNoWay_MC(self):
        self.assertEqual(hw.make_change( 42, [25, 1, 25, 10, 5] ), False)
    def testZeroNonempty_MC(self):
        self.assertEqual(hw.make_change( 0, [4, 5, 6] ), [])
    def testMakeFortyTwo2_MC(self):
        self.assertEqual(sorted(hw.make_change( 42, [23, 17, 2, 100] )), [2, 17, 23])

if __name__ == '__main__':
    unittest.main()
