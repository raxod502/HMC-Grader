import reverseTranslation as hw

import unittest

class ReverseTest(unittest.TestCase):

  def testReverse1(self):
    temp2 = sorted(hw.reverse({'dude!' : 'hello', 'later' : 'goodbye', 'stoked' : 'happy', 'ciao' : 'goodbye'}).items()); 
    self.assertTrue((temp2 == [('goodbye', 'ciao or later'), ('happy', 'stoked'), ('hello', 'dude!')]) or (temp2 == [('goodbye', 'later or ciao'), ('happy', 'stoked'), ('hello', 'dude!')]), temp2)

  def testReverse2(self):
    self.assertEqual(sorted(hw.reverse({"*":45,"&":13,"-":9}).items()), [(9, '-'), (13, '&'), (45, '*')])

    
if __name__ == '__main__':
    unittest.main()