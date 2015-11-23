import groody as hw

import unittest

class SuperLCSTest(unittest.TestCase):
  def testSuperLCS1(self):
    self.assertEqual(hw.superLCS('spam', ''), [0, 'spam', '----'])
  def testSuperLCS2(self):
    self.assertEqual(hw.superLCS('hi', 'ship'), [2, '-hi-', 'ship'])
  def testSuperLCS3(self):
    studentAnswer = hw.superLCS('x', 'y')
    self.assertTrue((studentAnswer==[0, 'x-', '-y'] or studentAnswer==[0, '-x', 'y-']), studentAnswer)
  def testSuperLCS4(self):
    studentAnswer = hw.superLCS('cat', 'car')
    self.assertTrue((studentAnswer==[2, 'cat-', 'ca-r'] or studentAnswer==[2, 'ca-t', 'car-']), studentAnswer)


if __name__ == '__main__':
    unittest.main()