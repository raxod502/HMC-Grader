import static org.junit.Assert.*;
import org.junit.Test;

public class StartHiTest {
  
  /*
   * Testing startHi
   */

  
  @Test
  public void testStartHi0() {
    assertTrue(Hw3pr4.startHi("hi there"));
  }
  
  @Test
  public void testStartHi1() {
    assertTrue(Hw3pr4.startHi("hi"));
  }
  
  @Test
  public void testStartHi2() {
    assertTrue(Hw3pr4.startHi("hi ho"));
  }
  
  @Test
  public void testStartHi3() {
    assertFalse(Hw3pr4.startHi("hello hi"));
  }
  
  @Test
  public void testStartHi4() {
    assertFalse(Hw3pr4.startHi("he"));
  }
  
  @Test
  public void testStartHi5() {
    assertFalse(Hw3pr4.startHi("h"));
  }
  
  @Test
  public void testStartHi6() {
    assertFalse(Hw3pr4.startHi(""));
  }
  
  @Test
  public void testStartHi7() {
    assertFalse(Hw3pr4.startHi("ho hi"));
  }

  
}