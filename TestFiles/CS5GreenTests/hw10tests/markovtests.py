
import markov as hw

import unittest

class MarkovTests(unittest.TestCase):
  def testDictionaryABC(self):
    d = hw.createDictionary( 'abc.txt' )
    d_abc = d
    correctd = {'A': ['B', 'B', 'C.'], 
                'C': ['C', 'C.'], 
                'B': ['A.', 'C.', 'A'], 
                '$': ['A', 'A', 'B', 'C'] }
    self.assertEqual(d, correctd, 'dictionary for abc.txt was incorrect')

  def testDictionaryPoptarts1(self):
    d = hw.createDictionary( 'poptarts.txt' )
    d_pop = d
    list_for_and = ['42', 'spam.', 'poptarts']
    self.assertEqual(sorted(list_for_and), sorted(d['and']), 'd[and] was incorrect')

  def testDictionaryPoptarts2(self):
    d = hw.createDictionary( 'poptarts.txt' )
    d_pop = d
    list_for_dollar = ['I', 'Will', 'I']
    self.assertEqual(sorted(list_for_dollar), sorted(d['$']), 'd[$] was incorrect')


if __name__ == '__main__':
    unittest.main()