import unittest
import hw4pr3 as hw

class Compress(unittest.TestCase):

    def testCompress1(self):
        self.assertEqual(hw.compress('1'*63 + '0'),'1011111100000001', "Failed to properly compress. Input: '1'*63+'0'")

    def testCompress2(self):
        self.assertEqual(hw.compress(('1'*17 + '0'*15)*2),'10010001000011111001000100001111', "Failed to properly compress. Input: ('1'*17 + '0'*15)*2")

class Uncompress(unittest.TestCase):

  def testUncompress(self):
    self.assertEqual(hw.uncompress('10010001000011111001000100001111'), '1111111111111111100000000000000011111111111111111000000000000000', "Failed to properly uncompress. Input: 10010001000011111001000100001111")


if __name__ == "__main__":
    unittest.main()
