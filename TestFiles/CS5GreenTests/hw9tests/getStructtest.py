import getStruct as hw

import unittest

class GetStructTest(unittest.TestCase):
  def testGetStruct_HIV(self):
    HIV = "AUAGGUACAGUAUUAGUAGGACCUACACCUGUCAACAUAAUUGGAAGAAAUAUGUUGACUCAGAUUGGUUGCACUUUAAAUUUUCCAAUUAGUCCUAUUGAAACUGUACCAGU"
    out1 = hw.getStruct(HIV,{})
    ans1 =(44, [(0, 112), (1, 111), (3, 109), (4, 108), (5, 107), (6, 106), (7, 105), (8, 104), (9, 103), (10, 102), (12, 101), (13, 100), (14, 98), (15, 97), (16, 96), (17, 95), (18, 94), (19, 93), (20, 92), (21, 91), (22, 67), (23, 66), (24, 65), (26, 64), (27, 62), (29, 61), (30, 60), (31, 57), (32, 56), (33, 55), (34, 54), (35, 53), (36, 52), (37, 51), (38, 50), (40, 49), (41, 48), (68, 90), (69, 77), (70, 76), (78, 89), (79, 88), (80, 87), (81, 86)])
    self.assertEqual((out1[0],sorted(out1[1])), ans1)
  def testGetStruct_MNV1(self):
    MNV1 = "UGCGCCCUCUGUGCGCAACACAGAGAAACGCA"
    out2 = hw.getStruct(MNV1,{})
    ans2 =(11, [(0, 31), (1, 30), (2, 29), (3, 28), (4, 24), (7, 23), (8, 22), (9, 21), (10, 20), (11, 19), (12, 18)])
    self.assertEqual((out2[0],sorted(out2[1])), ans2)
  def testGetStruct_Mutant(self):
    mutant = "UGCUGAGCGUUCCUGCGGGUCUCAGCA"
    out3 = hw.getStruct(mutant,{})
    ans3 =(11, [(0, 26), (1, 25), (2, 24), (3, 23), (4, 22), (5, 21), (6, 20), (8, 19), (9, 18), (10, 17), (11, 16)])
    self.assertEqual((out3[0],sorted(out3[1])), ans3)

if __name__ == '__main__':
    unittest.main()