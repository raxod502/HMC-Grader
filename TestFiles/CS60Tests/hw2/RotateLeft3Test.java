import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class RotateLeft3Test {
  /*
   * testing rotateLeft3
   */  
  @Test
  public void testRotateLeft3_0() {
    int[] x = { 1, 2, 3 };
    int[] y = { 2, 3, 1 };
    assertTrue(Arrays.equals(ArrayPractice.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_1() {
    int[] x = { 5, 11, 9 };
    int[] y = { 11, 9, 5 };
    assertTrue(Arrays.equals(ArrayPractice.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_2() {
    int[] x = { 7, 0, 0 };
    int[] y = { 0, 0, 7 };
    assertTrue(Arrays.equals(ArrayPractice.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_3() {
    int[] x = { 1, 2, 1 };
    int[] y = { 2, 1, 1 };
    assertTrue(Arrays.equals(ArrayPractice.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_4() {
    int[] x = { 0, 0, 1 };
    int[] y = { 0, 1, 0 };
    assertTrue(Arrays.equals(ArrayPractice.rotateLeft3(x), y));
  }

}