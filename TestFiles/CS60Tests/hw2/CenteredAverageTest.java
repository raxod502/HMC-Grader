import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class CenteredAverageTest {
  /*
   * Testing centerdAverage
   */  
  @Test
  public void testCenteredAverage_0() {
    int[] x = { -10, -4, -2, -4, -2, 0 };
    assertTrue(ArrayPractice.centeredAverage(x) == -3);
  }
  
  @Test
  public void testCenteredAverage_1() {
    int[] x = { 1, 1, 5, 5, 10, 8, 7 };
    assertTrue(ArrayPractice.centeredAverage(x) == 5);
  }
  
  @Test
  public void testCenteredAverage_2() {
    int[] x = { 5, 3, 4, 6, 2 };
    assertTrue(ArrayPractice.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_3() {
    int[] x = { 5, 3, 4, 0, 100 };
    assertTrue(ArrayPractice.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_4() {
    int[] x = { 100, 0, 5, 3, 4 };
    assertTrue(ArrayPractice.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_5() {
    int[] x = { 4, 0, 100 };
    assertTrue(ArrayPractice.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_6() {
    int[] x = { 0, 2, 3, 4, 100 };
    assertTrue(ArrayPractice.centeredAverage(x) == 3);
  }
  
  @Test
  public void testCenteredAverage_7() {
    int[] x = { 1, 1, 100 };
    assertTrue(ArrayPractice.centeredAverage(x) == 1);
  }
  
  @Test
  public void testCenteredAverage_8() {
    int[] x = { 7, 7, 7 };
    assertTrue(ArrayPractice.centeredAverage(x) == 7);
  }
  
  @Test
  public void testCenteredAverage_9() {
    int[] x = { 1, 7, 8 };
    assertTrue(ArrayPractice.centeredAverage(x) == 7);
  }
  
  @Test
  public void testCenteredAverage_10() {
    int[] x = { 1, 1, 99, 99 };
    assertTrue(ArrayPractice.centeredAverage(x) == 50);
  }
  
  @Test
  public void testCenteredAverage_11() {
    int[] x = { 1000, 0, 1, 99 };
    assertTrue(ArrayPractice.centeredAverage(x) == 50);
  }
  
  @Test
  public void testCenteredAverage_12() {
    int[] x = { 4, 4, 4, 4, 5 };
    assertTrue(ArrayPractice.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_13() {
    int[] x = { 4, 4, 4, 1, 5 };
    assertTrue(ArrayPractice.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_14() {
    int[] x = { 6, 4, 8, 12, 3 };
    assertTrue(ArrayPractice.centeredAverage(x) == 6);
  }
  
  @Test
  public void testCenteredAverage_15() {
    int[] x = { 1, 2, 3, 4, 100 };
    assertTrue(ArrayPractice.centeredAverage(x) == 3);
  }
}
