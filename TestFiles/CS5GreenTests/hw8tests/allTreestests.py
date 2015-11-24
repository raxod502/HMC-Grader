import allTrees as hw

import unittest

def isomorphic(Tree1, Tree2):
    if Tree1 == Tree2: return True
    elif Tree1[1] == () or Tree2[2] == (): return False
    elif Tree1[0] != Tree2[0]: return False
    else:
        if isomorphic(Tree1[1],Tree2[1]) and isomorphic(Tree1[2],Tree2[2]):
            return True
        elif isomorphic(Tree1[1],Tree2[2]) and isomorphic(Tree1[2],Tree2[1]):
            return True
        else: return False

def oneIsIsomorphic(Tree,TreeL):
    for t in TreeL:
        if isomorphic(t,Tree): return True
    return False

def treeListCompare(TreeL1,TreeL2):
    for t in TreeL1:
        if not oneIsIsomorphic(t,TreeL2): return False
    return True

class AllTreesTest(unittest.TestCase):
  def testAllTreeCompareList(self):
    trees4L=[('Anc', (0, (), ()), ('Anc', (1, (), ()), ('Anc', (2, (), ()), (3, (), ())))), ('Anc', ('Anc', (0, (), ()), (1, (), ())), ('Anc', (2, (), ()), (3, (), ()))), ('Anc', (1, (), ()), ('Anc', (0, (), ()), ('Anc', (2, (), ()), (3, (), ())))), ('Anc', (1, (), ()), ('Anc', ('Anc', (0, (), ()), (2, (), ())), (3, (), ()))), ('Anc', (1, (), ()), ('Anc', (2, (), ()), ('Anc', (0, (), ()), (3, (), ())))), ('Anc', (0, (), ()), ('Anc', ('Anc', (1, (), ()), (2, (), ())), (3, (), ()))), ('Anc', ('Anc', (0, (), ()), ('Anc', (1, (), ()), (2, (), ()))), (3, (), ())), ('Anc', ('Anc', ('Anc', (0, (), ()), (1, (), ())), (2, (), ())), (3, (), ())), ('Anc', ('Anc', (1, (), ()), ('Anc', (0, (), ()), (2, (), ()))), (3, (), ())), ('Anc', ('Anc', (1, (), ()), (2, (), ())), ('Anc', (0, (), ()), (3, (), ()))), ('Anc', (0, (), ()), ('Anc', (2, (), ()), ('Anc', (1, (), ()), (3, (), ())))), ('Anc', ('Anc', (0, (), ()), (2, (), ())), ('Anc', (1, (), ()), (3, (), ()))), ('Anc', (2, (), ()), ('Anc', (0, (), ()), ('Anc', (1, (), ()), (3, (), ())))), ('Anc', (2, (), ()), ('Anc', ('Anc', (0, (), ()), (1, (), ())), (3, (), ()))), ('Anc', (2, (), ()), ('Anc', (1, (), ()), ('Anc', (0, (), ()), (3, (), ()))))]
    self.assertTrue(treeListCompare(trees4L, hw.allTrees(range(4))), "Lists of possible trees differ")
  def testAllTreeLength(self):
    self.assertEqual(len(hw.allTrees(range(7))), 10395, "Incorrect number of possible trees")

if __name__ == '__main__':
    unittest.main()