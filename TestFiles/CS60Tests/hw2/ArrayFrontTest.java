import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayFrontTest {
  /*
   * Testing arrayFront9
   */
  // Source: http://codingbat.com/prob/p186031  
  @Test
  public void testArrayFront9_1() {
    int[] arr = {1, 2, 9, 3, 4};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_2() {
    int[] arr = {9, 2, 3};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_3() {
    int[] arr = {1, 9, 9};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_4() {
    int[] arr = {1, 9};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_5() {
    int[] arr = {9};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_6() {
    int[] arr = {3, 9, 2, 3, 3};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }   
  @Test
  public void testArrayFront9_7() {
    int[] arr = {5, 5};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_8() {
    int[] arr = {2};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_9() {
    int[] arr = {1, 2, 3, 4, 9};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_10() {
    int[] arr = {1, 2, 3, 4, 5};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_11() {
    int[] arr = {1, 2, 3};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_12() {
    int[] arr = {};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }
}
