import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class BigDiffTest {
  /*
   * Test bigDiff
   */  
  @Test
  public void testBigDiff_0() {
    int[] x = { 10, 3, 5, 6 };
    assertTrue(ArrayPractice.bigDiff(x) == 7);
  }
  
  @Test
  public void testBigDiff_1() {
    int[] x = { 7, 2, 10, 9 };
    assertTrue(ArrayPractice.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_2() {
    int[] x = { 2, 10, 7, 2 };
    assertTrue(ArrayPractice.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_3() {
    int[] x = { 2, 10 };
    assertTrue(ArrayPractice.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_4() {
    int[] x = { 10, 2 };
    assertTrue(ArrayPractice.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_5() {
    int[] x = { 10, 0 };
    assertTrue(ArrayPractice.bigDiff(x) == 10);
  }
  
  @Test
  public void testBigDiff_6() {
    int[] x = { 2, 3 };
    assertTrue(ArrayPractice.bigDiff(x) == 1);
  }
  
  @Test
  public void testBigDiff_7() {
    int[] x = { 7, 7, 6, 8, 5, 5, 6 };
    assertTrue(ArrayPractice.bigDiff(x) == 3);
  }
  
  @Test
  public void testBigDiff_8() {
    int[] x = { 2, 2 };
    assertTrue(ArrayPractice.bigDiff(x) == 0);
  }
  
  @Test
  public void testBigDiff_9() {
    int[] x = { 5, 1, 6, 1, 9, 9 };
    assertTrue(ArrayPractice.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_10() {
    int[] x = { 7, 6, 8, 5 };
    assertTrue(ArrayPractice.bigDiff(x) == 3);
  }

}