import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UnbalancedBSTMap_getMinKeyTests {
  /* *************** */
  // getMinKey tests
  /* *************** */
  
  @Test
  public void test_getMinKey1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals(new Integer(42), myMap.getMinKey());
  }
  @Test
  public void test_getMinKey2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(new Integer(42), myMap.getMinKey());


  }
  @Test
  public void test_getMinKey2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    assertEquals(new Integer(26), myMap.getMinKey());


  }
  @Test
  public void test_getMinKey3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(new Integer(26), myMap.getMinKey());

    
  }
  @Test
  public void test_getMinKey4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    assertEquals(new Integer(18), myMap.getMinKey());


  }
  @Test
  public void test_getMinKey4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertEquals(new Integer(26), myMap.getMinKey());


  }
  @Test
  public void test_getMinKey4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");
    assertEquals(new Integer(26), myMap.getMinKey());


  }
  @Test
  public void test_getMinKey4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    assertEquals(new Integer(26), myMap.getMinKey());
  }
  @Test
  public void test_getMinKey7(){
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
    assertEquals(new Integer(18), myMap.getMinKey());
  }
}