import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class SameFirstLastTest {
  /*
   * testing sameFirstLast
   */  
  @Test
  public void testSameFirstLast_0() {
    int[] x = { 1, 2, 3 };
    assertFalse(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_1() {
    int[] x = {};
    assertFalse(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_2() {
    int[] x = { 1, 2, 3, 4, 5, 13 };
    assertFalse(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_3() {
    int[] x = { 1, 2, 3, 1 };
    assertTrue(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_4() {
    int[] x = { 1, 2, 1 };
    assertTrue(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_5() {
    int[] x = { 7 };
    assertTrue(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_6() {
    int[] x = { 1, 2, 3, 4, 5, 1 };
    assertTrue(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_7() {
    int[] x = { 13, 2, 3, 4, 5, 13 };
    assertTrue(ArrayPractice.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_8() {
    int[] x = { 7, 7 };
    assertTrue(ArrayPractice.sameFirstLast(x));
  }

}