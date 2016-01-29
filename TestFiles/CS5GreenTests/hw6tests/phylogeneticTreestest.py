import phylogeneticTrees as hw

import unittest

Groodies =  ( "X",
                ("Y",
                    ("W", (), ()),
                    ("Z",
                        ("E", (), ()),
                        ("L", (), ())
                    )
                ),
                ( "C", (), () )
            )

Tree = (4, ('C', (), ()), (3, ('A', (), ()), ('B', (), ())))

Tree2 = (1, (2, ('W', (), ()), (3, ('E', (), ()), ('L', (), ()))), ('C', (), ()))

class SubtreeTest(unittest.TestCase):
  def testSubtreeRootOnly(self):
    self.assertEqual(hw.subtree("W", Groodies), ('W', (), ()))
  def testSubtreeMultiLevel(self):
    self.assertEqual(hw.subtree("Y", Groodies), ('Y', ('W', (), ()), ('Z', ('E', (), ()), ('L', (), ()))))

class DecendantNodesTest(unittest.TestCase):
  def testDescendantNodesY(self):
    self.assertEqual(sorted(hw.descendantNodes("Y", Groodies)), ['E', 'L', 'W', 'Z'])
  def testDescendantNodesZ(self):
    self.assertEqual(sorted(hw.descendantNodes("Z", Groodies)), ['E', 'L'])

class ParentTest(unittest.TestCase):
  def testParentX(self):
    self.assertEqual(hw.parent("X", Groodies), None)
  def testParentY(self):
    self.assertEqual(hw.parent("Y", Groodies), 'X')
  def testParentZ(self):
    self.assertEqual(hw.parent("Z", Groodies), 'Y')

class ScaleTest(unittest.TestCase):
  def testScale1(self):
    self.assertEqual(hw.scale(Tree, 2), (8, ('C', (), ()), (6, ('A', (), ()), ('B', (), ()))))
  def testScale2(self):
    self.assertEqual(hw.scale(Tree2, 3), (3, (6, ('W', (), ()), (9, ('E', (), ()), ('L', (), ()))), ('C', (), ())))
  def testScale3(self):
    self.assertEqual(hw.scale(Tree2, 4), (4, (8, ('W', (), ()), (12, ('E', (), ()), ('L', (), ()))), ('C', (), ())))


if __name__ == '__main__':
    unittest.main()