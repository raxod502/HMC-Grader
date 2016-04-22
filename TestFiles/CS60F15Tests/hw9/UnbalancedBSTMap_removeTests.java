import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UnbalancedBSTMap_removeTests {
  /* *************** */
  // remove tests
  /* *************** */
  @Test
  public void test_delete0(){
    // empty tree
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    String value = myMap.remove(new Integer(7));
    assertTrue(value == null); // didn't contain the previous key!
  }
  
  @Test
  public void test_deleteRoot1Node(){
    // Delete root in tree with 1 node
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals(1, myMap.size());
    myMap.remove(new Integer(42));
    assertEquals(null, myMap.get(new Integer(42)));
    assertEquals(0, myMap.size());
  }
  
  @Test
  public void test_deleteRoot2nodesR(){
    // Delete root with only right subtree
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
    assertEquals(2, myMap.size());
    // call remove
    myMap.remove(new Integer(42));
    assertEquals(1, myMap.size());
    assertEquals(null, myMap.get(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsValue("Dodds"));
    assertEquals("Colleen", myMap.get(new Integer(52)));

  }

  @Test
  public void test_deleteRoot2nodesL(){
    // Delete root with only left subtree
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals(2, myMap.size());
    // call remove
    myMap.remove(new Integer(42));
    assertEquals(1, myMap.size());
    assertEquals(null, myMap.get(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsValue("Dodds"));
    assertEquals("Ben", myMap.get(new Integer(26)));
  }
  
  @Test
  public void test_deleteRoot2Children(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
    assertEquals(3, myMap.size());
    // remove root
    myMap.remove(new Integer(42));
    assertEquals(2, myMap.size());
    assertEquals(null, myMap.get(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsValue("Dodds"));
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
  }
  @Test
  public void test_deleteNode2ChildrenL(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18..30..45..60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    myMap.put(new Integer(18), "Beth");
    myMap.put(new Integer(45), "Julie");
    myMap.put(new Integer(30), "Stone");
    assertEquals("Beth", myMap.get(new Integer(18)));
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Stone", myMap.get(new Integer(30)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Julie", myMap.get(new Integer(45)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
    assertEquals("Ran", myMap.get(new Integer(60)));
    assertEquals(7, myMap.size());
    // remove root
    myMap.remove(new Integer(26));
    assertEquals(6, myMap.size());
    assertEquals(null, myMap.get(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsValue("Ben"));
    assertEquals("Beth", myMap.get(new Integer(18)));
    assertEquals("Stone", myMap.get(new Integer(30)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Julie", myMap.get(new Integer(45)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
    assertEquals("Ran", myMap.get(new Integer(60)));
  }
  
  @Test
  public void test_deleteNotPresentNodes(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18..30..45..60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    myMap.put(new Integer(18), "Beth");
    myMap.put(new Integer(45), "Julie");
    myMap.put(new Integer(30), "Stone");
    assertEquals(null, myMap.remove(new Integer(10)));
    assertEquals(null, myMap.remove(new Integer(22)));
    assertEquals(null, myMap.remove(new Integer(27)));
    assertEquals(null, myMap.remove(new Integer(34)));
    assertEquals(null, myMap.remove(new Integer(44)));
    assertEquals(null, myMap.remove(new Integer(47)));
    assertEquals(null, myMap.remove(new Integer(55)));
    assertEquals(null, myMap.remove(new Integer(65)));
  }
}