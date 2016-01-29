import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Sum3Test {
  /*
   * testing sum3 
   */  
  @Test
  public void testSum3_0() {
    int[] x = { 1, 2, 3 };
    assertTrue(Hw2pr8.sum3(x) == 6);
  }
  
  @Test
  public void testSum3_1() {
    int[] x = { 5, 11, 2 };
    assertTrue(Hw2pr8.sum3(x) == 18);
  }
  
  @Test
  public void testSum3_2() {
    int[] x = { 7, 0, 0 };
    assertTrue(Hw2pr8.sum3(x) == 7);
  }
  
  @Test
  public void testSum3_3() {
    int[] x = { 1, 2, 1 };
    assertTrue(Hw2pr8.sum3(x) == 4);
  }
  
  @Test
  public void testSum3_4() {
    int[] x = { 1, 1, 1 };
    assertTrue(Hw2pr8.sum3(x) == 3);
  }
  
  @Test
  public void testSum3_5() {
    int[] x = { 2, 7, 2 };
    assertTrue(Hw2pr8.sum3(x) == 11);
  }

}