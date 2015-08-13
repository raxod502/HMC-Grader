import static org.junit.Assert.*;

import org.junit.Test;


/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BSTNodeTest {

  // use the constructor -- this should work!
  @Test
  public void testConstructor_a(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    assertEquals("[(a,a-val)[][]]",
        tree1.toString());
  }
  
  // test remove_min - nonstatic
  @Test
  public void testRemoveMin_ab() {
    BSTNode tree1 = new BSTNode( "a", "a-val", 
                      BSTNode.emptyNode,
                      new BSTNode( "b", "b-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    BSTNode trimmedtree = tree1.remove_min();
    assertEquals("[(b,b-val)[][]]",
        trimmedtree.toString());
  }
  
  // static version of left
  @Test
  public void test_static_left(){
    BSTNode tree1 = new BSTNode( "b", "b-val", 
                new BSTNode( "a", "a-val", BSTNode.emptyNode, BSTNode.emptyNode ),
                new BSTNode( "c", "c-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    BSTNode L = BSTNode.left(tree1);
    assertEquals("[(a,a-val)[][]]",
        L.toString());
  }
  
  // nonstatic version of right
  @Test
  public void test_nonstatic_right(){
    BSTNode tree1 = new BSTNode( "b", "b-val", 
                new BSTNode( "a", "a-val", BSTNode.emptyNode, BSTNode.emptyNode ),
                new BSTNode( "c", "c-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    BSTNode R = tree1.right();
    assertEquals("[(c,c-val)[][]]",
        R.toString());
  }
  
  // static version of min
  @Test
  public void test_static_min(){
    BSTNode tree1 = new BSTNode( "b", "b-val", 
                new BSTNode( "a", "a-val", BSTNode.emptyNode, BSTNode.emptyNode ),
                new BSTNode( "c", "c-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    String minstr = BSTNode.min(tree1); 
    assertEquals("a",
        minstr);
  }
  
  // nonstatic version of find
  @Test
  public void test_nonstatic_find(){
    BSTNode tree1 = new BSTNode( "b", "b-val", 
                new BSTNode( "a", "a-val", BSTNode.emptyNode, BSTNode.emptyNode ),
                new BSTNode( "c", "c-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    Object c_val = tree1.find("c");
    assertEquals("c-val",
        c_val);
  }
  
  // static version of remove_min
  @Test
  public void test_static_remove_min(){
    BSTNode tree1 = new BSTNode( "b", "b-val", 
                new BSTNode( "a", "a-val", BSTNode.emptyNode, BSTNode.emptyNode ),
                new BSTNode( "c", "c-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    BSTNode tree2 = new BSTNode( "b", "b-val", 
                BSTNode.emptyNode ,
                new BSTNode( "c", "c-val", BSTNode.emptyNode, BSTNode.emptyNode ) );
    BSTNode smaller = tree1.remove_min();
    assertEquals(tree2, // expected
        smaller);   // actual
  }
  
  // insert a node as a right branch from the root
  @Test
  public void testInsert_ab(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    BSTNode tree1_orig = new BSTNode("a", "a-val");
    BSTNode tree2 = tree1.insert("b", "b-val");
    assertEquals("[(a,a-val)[][(b,b-val)[][]]]",
        tree2.toString());
    assertEquals(tree1_orig,
        tree1);
  }
  
  // insert a node as a right branch from the root - nonstatic
  @Test
  public void testInsert_ab_nonstatic(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    BSTNode tree1_orig = new BSTNode("a", "a-val");
    BSTNode tree2 = BSTNode.insert("b", "b-val",tree1);
    assertEquals("[(a,a-val)[][(b,b-val)[][]]]",
        tree2.toString());
    assertEquals(tree1_orig,
        tree1);
  }
  
  
  // insert a node as a right branch from a node that is not the root
  @Test
  public void testInsert_abc(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("c", "c-val");
    assertEquals("[(a,a-val)[][(b,b-val)[][(c,c-val)[][]]]]",
        tree1.toString());
  }
  // insert a node as a left branch from the root
  @Test
  public void testInsert_cb(){
    BSTNode tree1 = new BSTNode("c", "c-val");
    tree1 = tree1.insert("b", "b-val");
    assertEquals("[(c,c-val)[(b,b-val)[][]][]]",
        tree1.toString());
  }
  // insert a node as a left branch from a node that is not the root
  @Test
  public void testInsert_cba(){
    BSTNode tree1 = new BSTNode("c", "c-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    assertEquals("[(c,c-val)[(b,b-val)[(a,a-val)[][]][]][]]",
        tree1.toString());
  }
  // insert a node on both sides of the root
  @Test
  public void testInsert_bac(){
    BSTNode tree1 = new BSTNode("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    tree1 = tree1.insert("c", "c-val");
    assertEquals("[(b,b-val)[(a,a-val)[][]][(c,c-val)[][]]]",
        tree1.toString());
  }
  // delete the root, which has one right child
  @Test
  public void testDelete_abc_a(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("c", "c-val");
    tree1 = tree1.delete("a");
    assertEquals("[(b,b-val)[][(c,c-val)[][]]]",
        tree1.toString());
  }
  // delete a node not at the root with one right child
  @Test
  public void testDelete_abc_b(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("c", "c-val");
    tree1 = tree1.delete("b");
    assertEquals("[(a,a-val)[][(c,c-val)[][]]]",
        tree1.toString());
  }
  // delete a right branch leaf
  @Test
  public void testDelete_abc_c(){
    BSTNode tree1 = new BSTNode("a", "a-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("c", "c-val");
    tree1 = tree1.delete("c");
    assertEquals("[(a,a-val)[][(b,b-val)[][]]]",
        tree1.toString());
  }
  
  // delete a left branch leaf
  @Test
  public void testDelete_cba_a(){
    BSTNode tree1 = new BSTNode("c", "c-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    tree1 = tree1.delete("a");
    assertEquals("[(c,c-val)[(b,b-val)[][]][]]",
        tree1.toString());
  }
  
  // delete a node not at the root with one left child = static version
  @Test
  public void testDelete_cba_b_static(){
    BSTNode tree1 = new BSTNode("c", "c-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    tree1 = BSTNode.delete("b",tree1);
    assertEquals("[(c,c-val)[(a,a-val)[][]][]]",
        tree1.toString());
  }
  
  // delete the root, which has one left child
  @Test
  public void testDelete_cba_c(){
    BSTNode tree1 = new BSTNode("c", "c-val");
    tree1 = tree1.insert("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    tree1 = tree1.delete("c");
    assertEquals("[(b,b-val)[(a,a-val)[][]][]]",
        tree1.toString());
  }
  // delete a root with two children
  @Test
  public void testDelete_bac_b(){
    BSTNode tree1 = new BSTNode("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    tree1 = tree1.insert("c", "c-val");
    tree1 = tree1.delete("b");
    assertEquals("[(c,c-val)[(a,a-val)[][]][]]",
        tree1.toString());
  }
  // delete a root with two children and the replacement node is not a leaf
  @Test
  public void testDelete_bafcd_b(){
    BSTNode tree1 = new BSTNode("b", "b-val");
    tree1 = tree1.insert("a", "a-val");
    tree1 = tree1.insert("f", "f-val");
    tree1 = tree1.insert("c", "c-val");
    tree1 = tree1.insert("d", "d-val");
    tree1 = tree1.delete("b");
    assertEquals("[(c,c-val)[(a,a-val)[][]][(f,f-val)[(d,d-val)[][]][]]]",
        tree1.toString());
  }

}

