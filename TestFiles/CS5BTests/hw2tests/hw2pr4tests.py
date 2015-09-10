import hw2pr4 as hw

import unittest

Inf = float("inf")

fiveDists  = {("A","A"): 0, ("A","B"): 1, ("A","C"): 3, ("A","D"): 7 , ("A","E"): Inf,
               ("B","A"): Inf, ("B","B"): 0, ("B","C"): 42, ("B","D"): 6, ("B","E"): 27,
               ("C","A"): Inf, ("C","B"): Inf, ("C","C"): 0, ("C","D"): 2, ("C","E"): 13,
               ("D","A"): Inf, ("D","B"): Inf, ("D","C"): Inf, ("D","D"): 0, ("D","E"): 5,
               ("E","A"): Inf, ("E","B"): Inf, ("E","C"): Inf, ("E","D"): Inf, ("E","E"): 0
             }

fiveCities = ["A", "B", "C", "D", "E"]

class shortestPathTest(unittest.TestCase):
    def testShortestPath(self):
        self.assertEqual(hw.shortestPath(fiveCities, fiveDists), 10)

class findShortestPathTest(unittest.TestCase):
    def testFindShortestPath(self):
        self.assertEqual(hw.findShortestPath(fiveCities, fiveDists), [10, ["A", "C", "D", "E"]])

if __name__ == '__main__':
    unittest.main()
