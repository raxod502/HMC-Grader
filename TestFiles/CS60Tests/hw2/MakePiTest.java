import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class MakePiTest {
  /*
   * Testing makePi
   */  
  @Test
  public void testMakePi() {
    int x[] = { 3, 1, 4 };
    assertTrue(Arrays.equals(x, Hw2pr8.makePi()));
  }
}