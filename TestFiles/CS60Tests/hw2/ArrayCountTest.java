import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayCountTest {

  /*
   * Testing arrayCount9
   */
  // Source: http://codingbat.com/prob/p184031  
  @Test
  public void testArrayCount9_1() {
    int[] arr = {1, 2, 9};
    assertTrue(ArrayPractice.arrayCount9(arr)== 1);  
  }  
  @Test
  public void testArrayCount9_2() {
    int[] arr = {1, 9, 9};
    assertTrue(ArrayPractice.arrayCount9(arr)== 2);  
  }  
  @Test
  public void testArrayCount9_3() {
    int[] arr = {1, 9, 9, 3, 9};
    assertTrue(ArrayPractice.arrayCount9(arr)== 3);  
  }  
  @Test
  public void testArrayCount9_4() {
    int[] arr = {1, 2, 3};
    assertTrue(ArrayPractice.arrayCount9(arr)== 0);  
  }  
  @Test
  public void testArrayCount9_5() {
    int[] arr = {};
    assertTrue(ArrayPractice.arrayCount9(arr)== 0);  
  }  
  @Test
  public void testArrayCount9_6() {
    int[] arr = {4, 2, 4, 3, 1};
    assertTrue(ArrayPractice.arrayCount9(arr)== 0);  
  }  
  @Test
  public void testArrayCount9_7() {
    int[] arr = {9, 2, 4, 3, 1};
    assertTrue(ArrayPractice.arrayCount9(arr)== 1);  
  }
  
}
