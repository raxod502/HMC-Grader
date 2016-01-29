import static org.junit.Assert.*;
import org.junit.Test;

public class Front22Test {
  /*
   * Testing front22
   */
  
  @Test
  public void testfront22_0() {
    assertTrue(Hw3pr4.front22("kitten").equals("kikittenki"));
  }
  
  @Test
  public void testfront22_1() {
    assertTrue(Hw3pr4.front22("Ha").equals("HaHaHa"));
  }
  
  @Test
  public void testfront22_2() {
    assertTrue(Hw3pr4.front22("abc").equals("ababcab"));
  }
  
  @Test
  public void testfront22_3() {
    assertTrue(Hw3pr4.front22("ab").equals("ababab"));
  }
  
  @Test
  public void testfront22_4() {
    assertTrue(Hw3pr4.front22("a").equals("aaa"));
  }
  
  @Test
  public void testfront22_5() {
    assertTrue(Hw3pr4.front22("").equals(""));
  }
  
  @Test
  public void testfront22_6() {
    assertTrue(Hw3pr4.front22("Logic").equals("LoLogicLo"));
  }

  
}