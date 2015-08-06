import unittest
import hw4pr2 as hw


class NumToBase(unittest.TestCase):

    def testN42B2(self):
        self.assertEquals(hw.numToBaseB(42,2), '101010',"Failed to properly convert 42 to base 2")

    def testN42B3(self):
        self.assertEquals(hw.numToBaseB(42,3), '1120',"Failed to properly convert 42 to base 3")

    def testN42B7(self):
        self.assertEquals(hw.numToBaseB(42,7), '60', "Failed to properly convert 42 to base 7")

    def testN42B10(self):
        self.assertEquals(hw.numToBaseB(42,10), '42', "Failed to properly convert 42 to base 10")

class BaseToNum(unittest.TestCase):

    def testN101010B2(self):
        self.assertEquals(hw.baseBToNum('101010',2), 42, "Failed to convert 101010 (base 2) into decimal")

    def testN1120B3(self):
        self.assertEquals(hw.baseBToNum('1120',3), 42, "Failed to convert 1120 (base 3) into decimal")

    def testN60B7(self):
        self.assertEquals(hw.baseBToNum('60',7), 42, "Failed to convert 60 (base 7) into decimal")

    def testN42B10(self):
        self.assertEquals(hw.baseBToNum('42',10),42, "Failed to convert 42 (base 10) to decimal")

class BaseToBaseTests(unittest.TestCase):

    def testBase2Base10(self):
        self.assertEquals(hw.baseToBase(2,10,'10111010101011'), '11947', "Failed to convert 10111010101011 (base 2) to base 10")

    def testBase9Base4(self): 
        self.assertEquals(hw.baseToBase(9,4,'1234324'), '2210022103', "Failed to convert 2210022103 (base 9) to base 4")

    def testBase5Base8(self): 
        self.assertEquals(hw.baseToBase(5,8,'1234324'), '57423', "Failed to convert 57423 (base 5) to base 8")

class Add(unittest.TestCase):

    def testAdd1_0(self):
        self.assertEquals(hw.add('1','1'),'10', "Failed to properly add 1 and 1 in base 2.")

    def testAdd011_100(self):
        self.assertEquals(hw.add('011','100'),'111', "Failed to properly add 11 and 100 in base 2.")

    def testAdd110101010_11111111(self):
        self.assertEquals(hw.add('110101010','11111111'), '1010101001', "Failed to properly add 110101010 and 11111111 in base 2.")

class AddB(unittest.TestCase):

    def testAddB11_1(self):
        self.assertEquals(hw.add('11','1'), '100', "Failed to properly add 11 and 1 in base 2 without conversion.")

    def testAddB110_11(self):
        self.assertEquals(hw.add('110','11'),'1001', "Failed to properly add 110 and 11 in base 2 without conversion.")

    def testAddB11_100(self):
        self.assertEquals(hw.add('11','100'),'111', "Failed to properly add 11 and 100 in base 2 without conversion.")

    def testAddB110101010_11111111(self):
        self.assertEquals(hw.addB('110101010','11111111'),'1010101001', "Failed to properly add 110101010 and 11111111 without conversion.")

    def testAddB1_1(self):
        self.assertEquals(hw.addB('1','1'),'10', "Failed to properly add 1 and 1 without conversion.")

class Compress(unittest.TestCase):

    def testCompress1(self):
        self.assertEquals(hw.compress('1'*63 + '0'),'1011111100000001', "Failed to properly compress. Input: '1'*63+'0'")

    def testCompress2(self):
        self.assertEquals(hw.compress(('1'*17 + '0'*15)*2),'10010001000011111001000100001111', "Failed to properly compress. Input: ('1'*17 + '0'*15)*2")

class Uncompress(unittest.TestCase):

    def testUncompress(self):
	self.assertEquals(hw.uncompress('10010001000011111001000100001111'), '1111111111111111100000000000000011111111111111111000000000000000', "Failed to properly uncompress. Input: 10010001000011111001000100001111")

if __name__ == "__main__":
    unittest.main()
