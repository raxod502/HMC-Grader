import static org.junit.Assert.*;
import org.junit.Test;

public class NotStringTest {
  /*
   * Testing notString
   */
  
  @Test
  public void testNotString0() {
    assertTrue(Hw3pr4.notString("candy").equals("not candy"));
  }
  
  @Test
  public void testNotString1() {
    assertTrue(Hw3pr4.notString("x").equals("not x"));
  }
  
  @Test
  public void testNotString2() {
    assertTrue(Hw3pr4.notString("not bad").equals("not bad"));
  }
  
  @Test
  public void testNotString3() {
    assertTrue(Hw3pr4.notString("bad").equals("not bad"));
  }
  
  @Test
  public void testNotString4() {
    assertTrue(Hw3pr4.notString("not").equals("not"));
  }
  
  @Test
  public void testNotString5() {
    assertTrue(Hw3pr4.notString("is not").equals("not is not"));
  }
  
  @Test
  public void testNotString6() {
    assertTrue(Hw3pr4.notString("no").equals("not no"));
  }


  
}