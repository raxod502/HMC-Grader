import knapsack as hw

import unittest


class KnapsackTest(unittest.TestCase):
  def testKnapsack1(self):
    self.assertEqual(hw.knapsack(40, [[13,50],[2,3],[25,13],[12,20]]), 73)
  def testKnapsack2(self):
    self.assertEqual(hw.knapsack(16, [[13,2],[2,6],[4,10]]), 16)
  def testKnapsack3(self):
    self.assertEqual(hw.knapsack(5, [ [160, 4], [3, 25], [2, 1] ]), 26)
  #def testKnapsack4(self): 
  #  self.assertEqual(hw.knapsack(7, [[3,10],[1,1],[4,10]]), 20)


if __name__ == '__main__':
    unittest.main()
