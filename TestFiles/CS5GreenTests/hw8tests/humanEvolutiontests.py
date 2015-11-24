import humanEvolution as hw

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


class FindClosestPairTest(unittest.TestCase):
  def testFindClosestPairGroodies(self):
    self.assertEqual(sorted(list(hw.findClosestPair(hw.groodiesList, hw.groodiesMatrix))), [('Froody', (), ()), ('Groody', (), ())], "Incorrect closest pair")
  def testFindClosestPairCarnivores(self):
    self.assertEqual(sorted(list(hw.findClosestPair(hw.carnivoresList, hw.carnivoresMatrix))), [('bear', (), ()), ('raccoon', (), ())], "Incorrect closest pair")
  def testFindClosestPairFitch(self):
    self.assertEqual(sorted(list(hw.findClosestPair(hw.fitchList, hw.fitchMatrix))), [('man', (), ()), ('monkey', (), ())], "Incorrect closest pair")
  

class UpdateDistTest(unittest.TestCase):
  def testUpdateDist1(self):
    tl = [('Snoody', (), ())]
    td = {(('Froody', (), ()), ('Snoody', (), ())): 12.0, (('Snoody', (), ()), ('Froody', (), ())): 12.0, (('Froody', (), ()), ('Groody', (), ())): 7.0, (('Snoody', (), ()), ('Groody', (), ())): 12.0, (('Groody', (), ()), ('Froody', (), ())): 7.0, (('Groody', (), ()), ('Snoody', (), ())): 12.0}
    tt = (3.5,('Groody', (), ()), ('Froody', (), ()))
    hw.updateDist( tl, td, tt )
    correct = [(((3.5, ('Groody', (), ()), ('Froody', (), ())), ('Snoody', (), ())), 12.0), ((('Froody', (), ()), ('Groody', (), ())), 7.0), ((('Froody', (), ()), ('Snoody', (), ())), 12.0), ((('Groody', (), ()), ('Froody', (), ())), 7.0), ((('Groody', (), ()), ('Snoody', (), ())), 12.0), ((('Snoody', (), ()), (3.5, ('Groody', (), ()), ('Froody', (), ()))), 12.0), ((('Snoody', (), ()), ('Froody', (), ())), 12.0), ((('Snoody', (), ()), ('Groody', (), ())), 12.0)]
    self.assertEqual(sorted(td.items()), correct, "Distances not updated correctly")
  def testUpdateDist2(self):
    tl = [('dog', (), ()), ('cat', (), ())]
    td = {((13.0, ('bear', (), ()), ('raccoon', (), ())), ('dog', (), ())): 40.0, (('dog', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))): 40.0, ((13.0, ('bear', (), ()), ('raccoon', (), ())), ('seal', (), ())): 36.5, (('seal', (), ()), ('bear', (), ())): 29.0, (('seal', (), ()), ('cat', (), ())): 89.0, (('raccoon', (), ()), ('seal', (), ())): 44.0, (('cat', (), ()), ('bear', (), ())): 84.0, ((13.0, ('bear', (), ()), ('raccoon', (), ())), ('cat', (), ())): 88.0, (('dog', (), ()), ('raccoon', (), ())): 48.0, (('seal', (), ()), ('dog', (), ())): 50.0, (('dog', (), ()), ('seal', (), ())): 50.0, (('raccoon', (), ()), ('dog', (), ())): 48.0, (('cat', (), ()), ('seal', (), ())): 89.0, (('bear', (), ()), ('cat', (), ())): 84.0, (('raccoon', (), ()), ('cat', (), ())): 92.0, (('bear', (), ()), ('dog', (), ())): 32.0, (('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))): 36.5, (('dog', (), ()), ('cat', (), ())): 98.0, (('raccoon', (), ()), ('bear', (), ())): 26.0, (('cat', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))): 88.0, (('dog', (), ()), ('bear', (), ())): 32.0, (('cat', (), ()), ('dog', (), ())): 98.0, (('bear', (), ()), ('raccoon', (), ())): 26.0, (('cat', (), ()), ('raccoon', (), ())): 92.0, (('bear', (), ()), ('seal', (), ())): 29.0, (('seal', (), ()), ('raccoon', (), ())): 44.0}
    tt = (18.25, ('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ())))
    hw.updateDist( tl, td, tt )
    correct = [(((13.0, ('bear', (), ()), ('raccoon', (), ())), ('cat', (), ())), 88.0), (((13.0, ('bear', (), ()), ('raccoon', (), ())), ('dog', (), ())), 40.0), (((13.0, ('bear', (), ()), ('raccoon', (), ())), ('seal', (), ())), 36.5), (((18.25, ('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))), ('cat', (), ())), 88.33333333333333), (((18.25, ('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))), ('dog', (), ())), 43.33333333333333), ((('bear', (), ()), ('cat', (), ())), 84.0), ((('bear', (), ()), ('dog', (), ())), 32.0), ((('bear', (), ()), ('raccoon', (), ())), 26.0), ((('bear', (), ()), ('seal', (), ())), 29.0), ((('cat', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))), 88.0), ((('cat', (), ()), (18.25, ('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ())))), 88.33333333333333), ((('cat', (), ()), ('bear', (), ())), 84.0), ((('cat', (), ()), ('dog', (), ())), 98.0), ((('cat', (), ()), ('raccoon', (), ())), 92.0), ((('cat', (), ()), ('seal', (), ())), 89.0), ((('dog', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))), 40.0), ((('dog', (), ()), (18.25, ('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ())))), 43.33333333333333), ((('dog', (), ()), ('bear', (), ())), 32.0), ((('dog', (), ()), ('cat', (), ())), 98.0), ((('dog', (), ()), ('raccoon', (), ())), 48.0), ((('dog', (), ()), ('seal', (), ())), 50.0), ((('raccoon', (), ()), ('bear', (), ())), 26.0), ((('raccoon', (), ()), ('cat', (), ())), 92.0), ((('raccoon', (), ()), ('dog', (), ())), 48.0), ((('raccoon', (), ()), ('seal', (), ())), 44.0), ((('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ()))), 36.5), ((('seal', (), ()), ('bear', (), ())), 29.0), ((('seal', (), ()), ('cat', (), ())), 89.0), ((('seal', (), ()), ('dog', (), ())), 50.0), ((('seal', (), ()), ('raccoon', (), ())), 44.0)]
    self.assertEqual(sorted(td.items()), correct, "Distances not updated correctly")


class UpgmaTest(unittest.TestCase):
  def testUpgmaGroodies(self):
    groodiesTree = hw.upgma(hw.groodiesList, hw.groodiesMatrix)
    testGroodiesTree = (6.0, ('Snoody', (), ()), (3.5, ('Groody', (), ()), ('Froody', (), ())))
    self.assertTrue(isomorphic(groodiesTree, testGroodiesTree), "Incorrect groodies tree")
  def testUpgmaCarnivores(self):
    carnivoresTree = hw.upgma(hw.carnivoresList, hw.carnivoresMatrix)
    testCarnivoresTree = (45.375, ('cat', (), ()), (21.666666666666664, ('dog', (), ()), (18.25, ('seal', (), ()), (13.0, ('bear', (), ()), ('raccoon', (), ())))))
    self.assertTrue(isomorphic(carnivoresTree, testCarnivoresTree), "Incorrect carnivores tree")
  def testUpgmaFitch(self):
    fitchTree = hw.upgma(hw.fitchList, hw.fitchMatrix)
    testFitchTree = (17.6, ('moth', (), ()), (14.5, ('tuna', (), ()), (9.0, (0.5, ('man', (), ()), ('monkey', (), ())), (4.0, ('turtle', (), ()), ('chicken', (), ())))))
    self.assertTrue(isomorphic(fitchTree, testFitchTree), "Incorrect fitch tree")
  def testUpgmaNeand(self):
    neandTree = hw.upgma(hw.neandList, hw.neandMatrix)
    testNeandTree = (0.0447688, ('Chimpanzee', (), ()), (0.00571225, ('Neanderthal', (), ()), (0.0026615, ('San', (), ()), (0.00110925, ('Yoruba', (), ()), (0.000656, ('Finnish', (), ()), ('Kostenki', (), ()))))))
    self.assertTrue(isomorphic(neandTree, testNeandTree), "Incorrect neand tree")
  def testUpgmaHumans(self):
    humansTree = hw.upgma(hw.humansList, hw.humansMatrix)
    testHumansTree = (0.0026804, ('San', (), ()), (0.0023785, ('Kikuyu', (), ()), (0.0010831666666666665, ('Yoruba', (), ()), (0.0009215, ('Han', (), ()), (0.000656, ('Finnish', (), ()), ('Papuan', (), ()))))))
    self.assertTrue(isomorphic(humansTree, testHumansTree), "Incorrect humans tree")


if __name__ == '__main__':
    unittest.main()