import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class CommonEndTest {
  /*
   * testing commonEnd 
   */  
  @Test
  public void testCommonEnd_0() {
    int[] x = { 1, 2, 3 };
    int[] y = { 7, 3 };
    assertTrue(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_1() {
    int[] x = { 1, 2, 3 };
    int[] y = { 1, 3 };
    assertTrue(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_2() {
    int[] x = { 1, 2, 3 };
    int[] y = { 1 };
    assertTrue(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_3() {
    int[] x = { 1, 2, 3 };
    int[] y = { 7, 3, 2 };
    assertFalse(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_4() {
    int[] x = { 1, 2, 3 };
    int[] y = { 2 };
    assertFalse(Hw2pr8.commonEnd(x, y));
  }


}