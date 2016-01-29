import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Has271Test {
  /*
   * Testing has271
   */
  // Source: http://codingbat.com/prob/p167430  
  @Test
  public void testHas271_1() {
    int[] arr = {1, 2, 7, 1};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_2() {
    int[] arr = {2, 7, 1};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_3() {
    int[] arr = {3, 8, 2};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_4() {
    int[] arr = {2, 7, 3};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_5() {
    int[] arr = {2, 7, -1};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_6() {
    int[] arr = {4, 5, 3, 8, 0};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_7() {
    int[] arr = {2, 7, 5, 10, 4};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_8() {
    int[] arr = {2, 7, -2, 4, 9, 3};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_9() {
    int[] arr = {1, 2, 8, 1};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_10() {
    int[] arr = {2, 7, 4};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_11() {
    int[] arr = {2, 7, -2};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_12() {
    int[] arr = {2, 7, 5, 10, 1};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_13() {
    int[] arr = {2, 7, -2, 4, 10, 2};
    assertFalse(Hw2pr8.has271(arr));  
  }
}