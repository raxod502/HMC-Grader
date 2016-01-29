import static org.junit.Assert.*;
import org.junit.Test;

public class BackAroundTest {
  /*
   * Testing backAround
   */
  
  @Test
  public void testBackAround0() {
    assertTrue(Hw3pr4.backAround("cat").equals("tcatt"));
  }
  
  @Test
  public void testBackAround1() {
    assertTrue(Hw3pr4.backAround("Hello").equals("oHelloo"));
  }
  
  @Test
  public void testBackAround2() {
    assertTrue(Hw3pr4.backAround("a").equals("aaa"));
  }
  
  @Test
  public void testBackAround3() {
    assertTrue(Hw3pr4.backAround("abc").equals("cabcc"));
  }
  
  @Test
  public void testBackAround4() {
    assertTrue(Hw3pr4.backAround("read").equals("dreadd"));
  }
  
  @Test
  public void testBackAround5() {
    assertTrue(Hw3pr4.backAround("boo").equals("obooo"));
  }

  
}