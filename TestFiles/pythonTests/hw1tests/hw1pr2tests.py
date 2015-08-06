import unittest

import hw1pr2 as hw

class sqTests(unittest.TestCase):
  def zeroSq(self):
   assert 0 == hw.sq(0)

  def oneSq(self):
    assert 1 == hw.sq(1)

  def negOneSq(self):
    assert 1 == hw.sq(-1)

  def fourSq(self):
    assert 16 == hw.sq(4)

  def negfourSq(self):
    assert 16 == hw.sq(-4)


class interpTests(unittest.TestCase):
  def interpT1(self):
    assert 3.0 == hw.interp(1.0, 9.0, 0.25)

  def interpT2(self):
    assert 31.5 == hw.interp(1.0, 3.0, 0.25)

  def interpT3(self):
    assert 4.2 == hw.interp(2, 12, 0.22)

  def interpT4(self):
    assert 24.0 == hw.interp(24, 42, 0)

  def interpT5(self):
    assert 42.0 == hw.interp(102, 117, -4.0)


class checkendsTests(unittest.TestCase):
  def checkendsT1(self):
    assert False == hw.checkends('no match')

  def checkendsT2(self):
    assert True == hw.checkends('hah! a match')

  def checkendsT3(self):
    assert True == hw.checkends('q')

  def checkendsT4(self):
    assert True == hw.checkends(' ')


class flipsideTests(unittest.TestCase):
  def flipsideT1(self):
    assert 'workhome' == hw.flipside('homework')

  def flipsideT2(self):
    assert 'petscar' == hw.flipside('carpets')

  def flipsideT3(self):
    assert 'q' == hw.flipside('q')

  def flipsideT4(self):
    assert ' ' == hw.flipside(' ')


if __name__ == '__main__':
  unittest.main()