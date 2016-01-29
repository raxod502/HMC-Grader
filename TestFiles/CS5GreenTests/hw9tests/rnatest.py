import rna as hw

import unittest

class MfoldTest(unittest.TestCase):
  def testMfold_1(self):
    test1 = 'AAGUUAUUCCAGCAGAAACAGGGCAAGAAACAGCAUACUUUCUCUUAAAACUAGCAGGAAGAUGGCCAGUAAAGACAAUACAUACAGACAAUGGCAGCAAUUUCACCAGCGCUGCACUUA'
    self.assertEqual(hw.mfold(test1, {}), 46)
  def testMfold_2(self):
    test2='AAGAUCUGGCCUUCCUGCAAGGGAAGGCGGAA'
    self.assertEqual(hw.mfold(test2, {}), 12)

class Mfold5Test(unittest.TestCase):
  def testMfold5_1(self):
    test1 = 'AAGUUAUUCCAGCAGAAACAGGGCAAGAAACAGCAUACUUUCUCUUAAAACUAGCAGGAAGAUGGCCAGUAAAGACAAUACAUACAGACAAUGGCAGCAAUUUCACCAGCGCUGCACUUA'
    self.assertEqual(hw.mfold5(test1, {}), 39)
  def testMfold5_2(self):
    test2='AAGAUCUGGCCUUCCUGCAAGGGAAGGCGGAA'
    self.assertEqual(hw.mfold5(test2, {}), 11)

if __name__ == '__main__':
    unittest.main()