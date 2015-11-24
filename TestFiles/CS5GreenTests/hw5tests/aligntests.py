import align as hw

import unittest

dnamat = {('A', 'A'): 5, ('A', 'T'): -4, ('A', 'G'): -1, ('A', 'C'): -4,
          ('T', 'A'): -4, ('T', 'T'): 5, ('T', 'G'): -4, ('T', 'C'): -1, 
          ('G', 'A'): -1, ('G', 'T'): -4, ('G', 'G'): 5, ('G', 'C'): -4,
          ('C', 'A'): -4, ('C', 'T'): -1, ('C', 'G'): -4, ('C', 'C'): 5}

class AlignTest(unittest.TestCase):
  def testAlign1(self):
    self.assertEqual(hw.align("GCGGAA","GCAA",-3,dnamat), [14, 'GCggAA', 'GC--AA'])
  def testAlign2(self):
    self.assertEqual(hw.align("GATC","AT",-9,dnamat), [-8, 'gATc', '-AT-'])
  def testAlign3(self):
    self.assertEqual(hw.align("CCAA","AT",-5,dnamat), [-9, 'ccAa', '--At'])
  def testAlign4(self):
    self.assertEqual(hw.align("ATAACAGA","GAACGAA",-9,dnamat), [8, 'atAACagA', 'g-AACgaA'])
  def testAlign5(self):
    self.assertEqual(hw.align("CAGA","CGAA",-4,dnamat), [8, 'CagA', 'CgaA'])

if __name__ == '__main__':
    unittest.main()