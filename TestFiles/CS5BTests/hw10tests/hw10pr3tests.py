
import hw10pr3 as hw

import unittest

class MarkovTests(unittest.TestCase):
  def testMM1(self):
    text = "A B C. A B B C B. A B C C C D B B. B B C C D D B C."
    MM1 = hw.markov_model(text, 1)
    correctMM1 = {('C',): ['B.', 'C', 'C', 'D', 'C', 'D'], 
                  ('$',): ['A', 'A', 'A', 'B'],    # things that are first or follow a period
                  ('A',): ['B', 'B', 'B'], 
                  ('B',): ['C.', 'B', 'C', 'C', 'B.', 'B', 'C', 'C.'], 
                  ('D',): ['B', 'D', 'B']}
    self.assertEqual(MM1, correctMM1, msg=MM1)

  def testMM2(self):
    text = "A B C. A B B C B. A B C C C D B B. B B C C D D B C."
    MM2 = hw.markov_model(text, 2)
    correctMM2 = {('B', 'C'): ['B.', 'C', 'C'], 
                  ('$', '$'): ['A', 'A', 'A', 'B'], 
                  ('D', 'D'): ['B'], 
                  ('$', 'A'): ['B', 'B', 'B'], 
                  ('C', 'C'): ['C', 'D', 'D'], 
                  ('$', 'B'): ['B'], 
                  ('A', 'B'): ['C.', 'B', 'C'], 
                  ('D', 'B'): ['B.', 'C.'], 
                  ('C', 'D'): ['B', 'D'], 
                  ('B', 'B'): ['C', 'C']}
    self.assertEqual(MM2, correctMM2, msg=MM2)

  def testMM3(self):
    text = "A B C. A B B C B. A B C C C D B B. B B C C D D B C."
    MM3 = hw.markov_model(text, 3)
    correctMM3 = {('$', '$', 'B'): ['B'], 
                  ('A', 'B', 'B'): ['C'], 
                  ('C', 'C', 'D'): ['B', 'D'], 
                  ('B', 'B', 'C'): ['B.', 'C'], 
                  ('C', 'D', 'D'): ['B'], 
                  ('$', 'B', 'B'): ['C'], 
                  ('$', '$', '$'): ['A', 'A', 'A', 'B'], 
                  ('C', 'C', 'C'): ['D'], 
                  ('B', 'C', 'C'): ['C', 'D'], 
                  ('$', 'A', 'B'): ['C.', 'B', 'C'], 
                  ('C', 'D', 'B'): ['B.'], 
                  ('$', '$', 'A'): ['B', 'B', 'B'], 
                  ('A', 'B', 'C'): ['C'], 
                  ('D', 'D', 'B'): ['C.']}
    self.assertEqual(MM3, correctMM3, msg=MM3)


if __name__ == '__main__':
    unittest.main()