import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class MakePiTest {
  /*
   * Testing makePi
   */  
  @Test
  public void testMakePi() {
    int[] x = { 3, 1, 4 };
    int[] studentAnswer = Hw2pr8.makePi();
    assertTrue(Arrays.equals(x, studentAnswer));
  }
  @Test
  public void testMakePiFalse() {
    int[] x = { 1, 2, 3 };
    int[] studentAnswer = Hw2pr8.makePi();
    assertFalse(Arrays.equals(x, studentAnswer));
  }
}