import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UnbalancedBSTMap_baseTests {

  @Test
  // We can create UnbalancedBSTMaps with different key and value types! 
  public void testConstruction() {
    // Only checking if this compiles!
    // Please ignore warnings that these variables are not used
    Map<String, String> mapStrStr = new UnbalancedBSTMap<String, String>();
    Map<Integer, Object> mapIntOb = new UnbalancedBSTMap<Integer, Object>();
    Map<Date, int[]> mapDateIntAr = new UnbalancedBSTMap<Date, int[]>();
  }
  
  // //////////////////////////////////////////////////////////////////
  // *** Queries about the tree ***
  // Methods: isEmpty, size, containsKey, containsValue, get
  // //////////////////////////////////////////////////////////////////

  /* *************** */
  // isEmpty tests
  /* *************** */
  @Test
  public void test_isEmpty(){
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertTrue(myMap.isEmpty());
  }

  /* *************** */
  // size tests
  /* *************** */
  @Test
  public void test_size0(){
    // empty tree
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertEquals(0, myMap.size());
  }
  @Test
  public void test_size1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals(1, myMap.size());
  }
  @Test
  public void test_size2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(2, myMap.size());
  }
  @Test
  public void test_size2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    assertEquals(2, myMap.size());
  }
  @Test
  public void test_size3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(3, myMap.size());
  }
  @Test
  public void test_size4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(10), "Beth");
    assertEquals(4, myMap.size());
  }
  @Test
  public void test_size4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertEquals(4, myMap.size());
  }
  @Test
  public void test_size4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");
    assertEquals(4, myMap.size());
  }
  @Test
  public void test_size4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    assertEquals(4, myMap.size());
  }
  @Test
  public void test_size7(){
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
    assertEquals(7, myMap.size());
  }

  /* *************** */
  // containsKey tests
  /* *************** */
  @Test
  public void test_containsKey0(){
    // empty tree
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertFalse(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertFalse(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertFalse(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));

  }
  @Test
  public void test_containsKey1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    
    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertFalse(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertFalse(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));
  }
  @Test
  public void test_containsKey2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    
    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertFalse(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));

  }
  @Test
  public void test_containsKey2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");

    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertFalse(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));
  }
  @Test
  public void test_containsKey3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    
    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));

  }
  @Test
  public void test_containsKey4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    assertFalse(myMap.containsKey(new Integer(10)));
    assertTrue(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));

  }
  @Test
  public void test_containsKey4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertTrue(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));

  }
  @Test
  public void test_containsKey4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");

    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertTrue(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertFalse(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));
  }
  @Test
  public void test_containsKey4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    
    assertFalse(myMap.containsKey(new Integer(10)));
    assertFalse(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertFalse(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertFalse(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertTrue(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));

  }
  @Test
  public void test_containsKey7(){
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

    assertFalse(myMap.containsKey(new Integer(10)));
    assertTrue(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertTrue(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertTrue(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertTrue(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));
  }

  /* *************** */
  // containsValue tests
  /* *************** */
  @Test
  public void test_containsValue0(){
    // empty tree
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertFalse(myMap.containsValue("Dodds"));
    assertFalse(myMap.containsValue("Ben"));
    assertFalse(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));
    
  }
  @Test
  public void test_containsValue1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertFalse(myMap.containsValue("Ben"));
    assertFalse(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertFalse(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");

    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertFalse(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertTrue(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertTrue(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertFalse(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertTrue(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));

  }
  @Test
  public void test_containsValue4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    
    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertTrue(myMap.containsValue("Ran"));
    assertFalse(myMap.containsValue("Beth"));
    assertFalse(myMap.containsValue("Julie"));
    assertFalse(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));
    
  }
  @Test
  public void test_containsValue7(){
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

    assertTrue(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
    assertTrue(myMap.containsValue("Ran"));
    assertTrue(myMap.containsValue("Beth"));
    assertTrue(myMap.containsValue("Julie"));
    assertTrue(myMap.containsValue("Stone"));
    assertFalse(myMap.containsValue("Geoff"));
    assertFalse(myMap.containsValue("Melissa"));
  }

  /* *************** */
  // get tests
  /* *************** */

  @Test
  public void test_get0(){
    // empty tree
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertEquals(null, myMap.get(new Integer(42)));
  }
  @Test
  public void test_get1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    
    assertEquals("Dodds", myMap.get(new Integer(42)));
  }
  @Test
  public void test_get2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Colleen", myMap.get(new Integer(52)));

  }
  @Test
  public void test_get2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");

    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
  }
  @Test
  public void test_get3(){
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

  }
  @Test
  public void test_get4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    assertEquals("Beth", myMap.get(new Integer(18)));
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Colleen", myMap.get(new Integer(52)));

  }
  @Test
  public void test_get4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Stone", myMap.get(new Integer(30)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Colleen", myMap.get(new Integer(52)));

  }
  @Test
  public void test_get4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");

    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Julie", myMap.get(new Integer(45)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
  }
  @Test
  public void test_get4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    
    assertEquals("Ben", myMap.get(new Integer(26)));
    assertEquals("Dodds", myMap.get(new Integer(42)));
    assertEquals("Colleen", myMap.get(new Integer(52)));
    assertEquals("Ran", myMap.get(new Integer(60)));

  }
  @Test
  public void test_get7(){
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
  }

  // //////////////////////////////////////////////////////////////////
  // *** Modifications to the tree ***
  // Methods: clear, put, putAll
  // //////////////////////////////////////////////////////////////////

  /* *************** */
  // clear tests
  /* *************** */
  @Test
  public void test_clear0(){
    // empty tree
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertEquals(0, myMap.size());
    myMap.clear();
    assertEquals(0, myMap.size());
  }
  @Test
  public void test_clear1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals(1, myMap.size());
    myMap.clear();
    assertEquals(0, myMap.size());
  }
  @Test
  public void test_clear2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(2, myMap.size());
    myMap.clear();
    assertEquals(0, myMap.size());
  }
  
  /* *************** */
  // put tests
  /* *************** */
  
  public void test_put_checkReturn(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18..30..45..60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    String value = myMap.put(new Integer(42), "Dodds");
    assertEquals("Dodds", value);
    value = myMap.put(new Integer(26), "Ben");
    assertEquals("Ben", value);
    value = myMap.put(new Integer(52), "Colleen");
    assertEquals("Colleen", value);
    value = myMap.put(new Integer(60), "Ran");
    assertEquals("Ran", value);
    value = myMap.put(new Integer(18), "Beth");
    assertEquals("Beth", value);
    value = myMap.put(new Integer(45), "Julie");
    assertEquals("Julie", value);
    value = myMap.put(new Integer(30), "Stone");
    assertEquals("Stone", value);
  }
  // Test put's replacement (i.e. adding a key that is already in the tree)
  // Additionally, most tests rely on put
  @Test
  public void test_put_replacement1(){
    // Test tree:
    // ......42......
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals("Dodds", myMap.get(new Integer(42)));
    myMap.put(new Integer(42), "Beth");
    // Replace "Dodds" with "Beth" as the value for 42
    assertEquals("Beth", myMap.get(new Integer(42)));
    assertFalse(myMap.containsValue("Dodds"));
    assertTrue(myMap.containsValue("Beth"));
  }
  
  @Test
  public void test_put_replacement2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals("Colleen", myMap.get(new Integer(52)));
    myMap.put(new Integer(52), "Julie");
    // Replace "Colleen" with "Julie" as the value for 52
    assertEquals("Julie", myMap.get(new Integer(52)));
    assertFalse(myMap.containsValue("Colleen"));
    assertTrue(myMap.containsValue("Julie"));
  }
  @Test
  public void test_put_replacement2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    assertEquals("Ben", myMap.get(new Integer(26)));
    myMap.put(new Integer(26), "Colleen");
    // Replace "Ben" with "Colleen" as the value for 26
    assertEquals("Colleen", myMap.get(new Integer(26)));
    assertFalse(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
  }
  @Test
  public void test_put_replacement3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Beth");
    assertEquals("Ben", myMap.get(new Integer(26)));
    myMap.put(new Integer(26), "Colleen");
    // Replace "Ben" with "Colleen" as the value for 26
    assertEquals("Colleen", myMap.get(new Integer(26)));
    assertFalse(myMap.containsValue("Ben"));
    assertTrue(myMap.containsValue("Colleen"));
  }
  
  @Test
  public void test_put_replacement4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    assertEquals("Beth", myMap.get(new Integer(18)));
    myMap.put(new Integer(18), "Julie");
    // Replace "Beth" with "Julie" as the value for 18
    assertEquals("Julie", myMap.get(new Integer(18)));
    assertFalse(myMap.containsValue("Beth"));
    assertTrue(myMap.containsValue("Julie"));

  }
  @Test
  public void test_put_replacement4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertEquals("Stone", myMap.get(new Integer(30)));
    myMap.put(new Integer(30), "Beth");
    // Replace "Stone" with "Beth" as the value for 30
    assertEquals("Beth", myMap.get(new Integer(30)));
    assertFalse(myMap.containsValue("Stone"));
    assertTrue(myMap.containsValue("Beth"));
  }
  @Test
  public void test_put_replacement4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");
    assertEquals("Colleen", myMap.get(new Integer(52)));
    myMap.put(new Integer(52), "Julie");
    // Replace "Colleen" with "Julie" as the value for 52
    assertEquals("Julie", myMap.get(new Integer(52)));
    assertFalse(myMap.containsValue("Colleen"));
    assertTrue(myMap.containsValue("Julie"));
  }
  
  /* *************** */
  // putAll tests
  /* *************** */
  @Test
  public void test_putAll7(){
    // Test tree:
    // contains: 18, 26, 30, 42, 45, 52, 60
    // We don't have a guarantee of the structure when using putAll
    Map<Integer, String> inputMap = new HashMap<Integer, String>();
    inputMap.put(new Integer(42), "Dodds");
    inputMap.put(new Integer(26), "Ben");
    inputMap.put(new Integer(52), "Colleen");
    inputMap.put(new Integer(60), "Ran");
    inputMap.put(new Integer(18), "Beth");
    inputMap.put(new Integer(45), "Julie");
    inputMap.put(new Integer(30), "Stone");

    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.putAll(inputMap);
    assertFalse(myMap.containsKey(new Integer(10)));
    assertTrue(myMap.containsKey(new Integer(18)));
    assertTrue(myMap.containsKey(new Integer(26)));
    assertTrue(myMap.containsKey(new Integer(30)));
    assertTrue(myMap.containsKey(new Integer(42)));
    assertTrue(myMap.containsKey(new Integer(45)));
    assertTrue(myMap.containsKey(new Integer(52)));
    assertTrue(myMap.containsKey(new Integer(60)));
    assertFalse(myMap.containsKey(new Integer(90)));
  }
}