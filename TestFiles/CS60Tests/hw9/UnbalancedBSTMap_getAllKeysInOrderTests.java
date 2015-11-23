import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UnbalancedBSTMap_getAllKeysInOrderTests {
  /* *************** */
  // toString tests (tests getAllKeysInOrder)
  /* *************** */
  @Test
  public void test_toString1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals("[42]", myMap.toString());

  }
  @Test
  public void test_toString2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals("[42, 52]", myMap.toString());

  }
  @Test
  public void test_toString2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    assertEquals("[26, 42]", myMap.toString());

  }
  @Test
  public void test_toString3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    assertEquals("[26, 42, 52]", myMap.toString());
    
  }
  @Test
  public void test_toString4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    assertEquals("[18, 26, 42, 52]", myMap.toString());

  }
  @Test
  public void test_toString4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertEquals("[26, 30, 42, 52]", myMap.toString());

  }
  @Test
  public void test_toString4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");
    assertEquals("[26, 42, 45, 52]", myMap.toString());

  }
  @Test
  public void test_toString4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    assertEquals("[26, 42, 52, 60]", myMap.toString());
  }
  @Test
  public void test_toString7(){
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
    assertEquals("[18, 26, 30, 42, 45, 52, 60]", myMap.toString());
  }
}