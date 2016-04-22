import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UnbalancedBSTMap_getHeightTests {
  /* *************** */
  // getHeight
  /* *************** */
  @Test
  public void test_height0(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    assertEquals(-1, myMap.getHeight());
  }

  @Test
  public void test_height1(){
    // ..... 42 .....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    assertEquals(0, myMap.getHeight());
  }
  @Test
  public void test_height2right(){
    // Test tree:
    // ....42....
    // ........52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(1, myMap.getHeight());

  }
  @Test
  public void test_height2left(){
    // Test tree:
    // ....42....
    // 26........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    assertEquals(1, myMap.getHeight());

  }
  @Test
  public void test_height3(){
    // Test tree:
    // ....42....
    // 26......52
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    assertEquals(1, myMap.getHeight());
  
  }
  @Test
  public void test_height4a(){
    // Test tree:
    // ......42......
    // ..26......52..
    // 18............
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(18), "Beth");
    assertEquals(2, myMap.getHeight());

  }
  @Test
  public void test_height4b(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ....30........
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(30), "Stone");
    assertEquals(2, myMap.getHeight());

  }
  @Test
  public void test_height4c(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ........45....
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(45), "Julie");
    assertEquals(2, myMap.getHeight());

  }
  @Test
  public void test_height4d(){
    // Test tree:
    // ......42......
    // ..26......52..
    // ............60
    UnbalancedBSTMap<Integer, String> myMap = new UnbalancedBSTMap<Integer, String>();
    myMap.put(new Integer(42), "Dodds");
    myMap.put(new Integer(26), "Ben");
    myMap.put(new Integer(52), "Colleen");
    myMap.put(new Integer(60), "Ran");
    assertEquals(2, myMap.getHeight());
  }
  @Test
  public void test_height7(){
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
    assertEquals(2, myMap.getHeight());
  }
}