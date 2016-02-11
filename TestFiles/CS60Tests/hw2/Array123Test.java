import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Array123Test {
  /*
   * Testing array123
   */
  // Source: http://codingbat.com/prob/p136041  
  @Test
  public void testArray123_1() {
    int[] arr = {1, 1, 2, 3, 1};
    assertTrue(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_2() {
    int[] arr = {1, 1, 2, 1, 2, 3};
    assertTrue(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_3() {
    int[] arr = {1, 2, 3, 1, 2, 3};
    assertTrue(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_4() {
    int[] arr = {1, 2, 3};
    assertTrue(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_5() {
    int[] arr = {1, 1, 2, 4, 1};
    assertFalse(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_6() {
    int[] arr = {1, 1, 2, 1, 2, 1};
    assertFalse(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_7() {
    int[] arr = {1, 1, 1};
    assertFalse(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_8() {
    int[] arr = {1, 2};
    assertFalse(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_9() {
    int[] arr = {1};
    assertFalse(ArrayPractice.array123(arr));
  }  
  @Test
  public void testArray123_10() {
    int[] arr = {};
    assertFalse(ArrayPractice.array123(arr));
  }
}
