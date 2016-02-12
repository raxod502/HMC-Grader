import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class CountEvensTest {
  /*
   * testing countEvens
   */  
  @Test
  public void testCountEvens_0() {
    int[] x = { 2, 1, 2, 3, 4 };
    assertTrue(ArrayPractice.countEvens(x) == 3);
  }
  
  @Test
  public void testCountEvens_1() {
    int[] x = { 2, 2, 0 };
    assertTrue(ArrayPractice.countEvens(x) == 3);
  }
  
  @Test
  public void testCountEvens_2() {
    int[] x = { 1, 3, 5 };
    assertTrue(ArrayPractice.countEvens(x) == 0);
  }
  
  @Test
  public void testCountEvens_3() {
    int[] x = {};
    assertTrue(ArrayPractice.countEvens(x) == 0);
  }
  
  @Test
  public void testCountEvens_4() {
    int[] x = { 11, 9, 0, 1 };
    assertTrue(ArrayPractice.countEvens(x) == 1);
  }
  
  @Test
  public void testCountEvens_5() {
    int[] x = { 2, 11, 9, 0 };
    assertTrue(ArrayPractice.countEvens(x) == 2);
  }
  
  @Test
  public void testCountEvens_6() {
    int[] x = { 2 };
    assertTrue(ArrayPractice.countEvens(x) == 1);
  }
  
  @Test
  public void testCountEvens_7() {
    int[] x = { 2, 5, 12 };
    assertTrue(ArrayPractice.countEvens(x) == 2);
  }

}