import unittest

import hw9pr2 as hw

class ThreeInARowTests(unittest.TestCase):
  def testThreeEast1(self):
    A = hw.createA(3, 4, 'XXOXXXOOOOOO')
    self.assertEqual(False, hw.inarow_3east('X',0,0,A))

  def testThreeEast2(self):
    A = hw.createA(3, 4, 'XXOXXXOOOOOO')
    self.assertEqual(True, hw.inarow_3east('O',2,1,A))

  def testThreeEast3(self):
    A = hw.createA(3, 4, 'XXOXXXOOOOOO')
    self.assertEqual(False, hw.inarow_3east('X',2,1,A))

  def testThreeEast4(self):
    A = hw.createA(3, 4, 'XXOXXXOOOOOO')
    self.assertEqual(False, hw.inarow_3east('O',2,2,A))


  def testThreeSouth1(self):
    A = hw.createA(4, 4, 'XXOXXXOXXOO OOOX')
    self.assertEqual(True, hw.inarow_3south('X',0,0,A))

  def testThreeSouth2(self):
    A = hw.createA(4, 4, 'XXOXXXOXXOO OOOX')
    self.assertEqual(False, hw.inarow_3south('O',2,2,A))

  def testThreeSouth3(self):
    A = hw.createA(4, 4, 'XXOXXXOXXOO OOOX')
    self.assertEqual(False, hw.inarow_3south('X',1,3,A))

  def testThreeSouth4(self):
    A = hw.createA(4, 4, 'XXOXXXOXXOO OOOX')
    self.assertEqual(False, hw.inarow_3south('O',42,42,A))


  def testThreeSouthEast1(self):
    A = hw.createA(4, 4, 'XOOXXXOXX XOOOOX')
    self.assertEqual(True, hw.inarow_3southeast('X',1,1,A))

  def testThreeSouthEast2(self):
    A = hw.createA(4, 4, 'XOOXXXOXX XOOOOX')
    self.assertEqual(False, hw.inarow_3southeast('X',1,0,A))

  def testThreeSouthEast3(self):
    A = hw.createA(4, 4, 'XOOXXXOXX XOOOOX')
    self.assertEqual(True, hw.inarow_3southeast('O',0,1,A))

  def testThreeSouthEast4(self):
    A = hw.createA(4, 4, 'XOOXXXOXX XOOOOX')
    self.assertEqual(False, hw.inarow_3southeast('X',2,2,A))


  def testThreeNorthEast1(self):
    A = hw.createA(4, 4, 'XOXXXXOXXOXOOOOX')
    self.assertEqual(True, hw.inarow_3northeast('X',2,0,A))

  def testThreeNorthEast2(self):
    A = hw.createA(4, 4, 'XOXXXXOXXOXOOOOX')
    self.assertEqual(True, hw.inarow_3northeast('O',3,0,A))

  def testThreeNorthEast3(self):
    A = hw.createA(4, 4, 'XOXXXXOXXOXOOOOX')
    self.assertEqual(False, hw.inarow_3northeast('O',3,1,A))

  def testThreeNorthEast4(self):
    A = hw.createA(4, 4, 'XOXXXXOXXOXOOOOX')
    self.assertEqual(False, hw.inarow_3northeast('X',3,3,A))



class NInARowTests(unittest.TestCase):
  def testNEast1(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXX XXXOOOOO')
    self.assertEqual(True, hw.inarow_Neast('O',1,1,A,4))

  def testNEast2(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXX XXXOOOOO')
    self.assertEqual(True, hw.inarow_Neast('O',1,3,A,2))

  def testNEast3(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXX XXXOOOOO')
    self.assertEqual(False, hw.inarow_Neast('X',3,2,A,4))

  def testNEast4(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXX XXXOOOOO')
    self.assertEqual(True, hw.inarow_Neast('O',4,0,A,5))


  def testNSouth1(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXXOXXXOOOXO')
    self.assertEqual(False, hw.inarow_Nsouth('X',0,0,A,5))

  def testNSouth2(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXXOXXXOOOXO')
    self.assertEqual(True, hw.inarow_Nsouth('O',1,1,A,4))

  def testNSouth3(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXXOXXXOOOXO')
    self.assertEqual(False, hw.inarow_Nsouth('O',0,1,A,6))

  def testNSouth4(self):
    A = hw.createA(5, 5, 'XXOXXXOOOOOOXXXXOXXXOOOXO')
    self.assertEqual(True, hw.inarow_Nsouth('X',4,3,A,1))


  def testNSouthEast1(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXXXXOXXXOOOXX')
    self.assertEqual(True, hw.inarow_Nsoutheast('X',1,1,A,4))

  def testNSouthEast2(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXXXXOXXXOOOXX')
    self.assertEqual(False, hw.inarow_Nsoutheast('O',0,1,A,3))

  def testNSouthEast3(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXXXXOXXXOOOXX')
    self.assertEqual(True, hw.inarow_Nsoutheast('O',0,1,A,2))

  def testNSouthEast4(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXXXXOXXXOOOXX')
    self.assertEqual(False, hw.inarow_Nsoutheast('X',3,0,A,2))


  def testNNorthEast1(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXOXXXOXXXOOXX')
    self.assertEqual(True, hw.inarow_Nnortheast('X',4,0,A,5))

  def testNNorthEast2(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXOXXXOXXXOOXX')
    self.assertEqual(True, hw.inarow_Nnortheast('O',4,1,A,4))

  def testNNorthEast3(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXOXXXOXXXOOXX')
    self.assertEqual(False, hw.inarow_Nnortheast('O',2,0,A,2))

  def testNNorthEast4(self):
    A = hw.createA(5, 5, 'XOO XXXOXOOOXOXXXOXXXOOXX')
    self.assertEqual(False, hw.inarow_Nnortheast('X',0,3,A,1))




if __name__ == "__main__":
  unittest.main() #run all tests
