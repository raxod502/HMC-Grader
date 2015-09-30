import static org.junit.Assert.*;
import org.junit.Test;

public class Front3Test {
  /*
   * Testing front3
   */
  
  @Test
  public void testfront3_0() {
    assertTrue(Hw3pr4.front3("Java").equals("JavJavJav"));
  }
  
  @Test
  public void testfront3_1() {
    assertTrue(Hw3pr4.front3("Chocolate").equals("ChoChoCho"));
  }
  
  @Test
  public void testfront3_2() {
    assertTrue(Hw3pr4.front3("abc").equals("abcabcabc"));
  }
  
  @Test
  public void testfront3_3() {
    assertTrue(Hw3pr4.front3("abcXYZ").equals("abcabcabc"));
  }
  
  @Test
  public void testfront3_4() {
    assertTrue(Hw3pr4.front3("ab").equals("ababab"));
  }
  
  @Test
  public void testfront3_5() {
    assertTrue(Hw3pr4.front3("a").equals("aaa"));
  }
  
  @Test
  public void testfront3_6() {
    assertTrue(Hw3pr4.front3("").equals(""));
  }

  
}