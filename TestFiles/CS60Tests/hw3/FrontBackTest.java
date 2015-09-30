import static org.junit.Assert.*;
import org.junit.Test;

public class FrontBackTest {
  /*
   * Testing FrontBack
   */
  
  @Test
  public void testfrontBack0() {
    assertTrue(Hw3pr4.frontBack("code").equals("eodc"));
  }
  
  @Test
  public void testfrontBack1() {
    assertTrue(Hw3pr4.frontBack("a").equals("a"));
  }
  
  @Test
  public void testfrontBack2() {
    assertTrue(Hw3pr4.frontBack("ab").equals("ba"));
  }
  
  @Test
  public void testfrontBack3() {
    assertTrue(Hw3pr4.frontBack("abc").equals("cba"));
  }
  
  @Test
  public void testfrontBack4() {
    assertTrue(Hw3pr4.frontBack("").equals(""));
  }
  
  @Test
  public void testfrontBack5() {
    assertTrue(Hw3pr4.frontBack("Chocolate").equals("ehocolatC"));
  }
  
  @Test
  public void testfrontBack6() {
    assertTrue(Hw3pr4.frontBack("aavJ").equals("Java"));
  }
  
  @Test
  public void testfrontBack7() {
    assertTrue(Hw3pr4.frontBack("hello").equals("oellh"));
  }
}