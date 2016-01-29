import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Array667Test {
  /*
   * Testing array667
   */
  // Source: http://codingbat.com/prob/p110019  
  @Test
  public void testArray667_1() {
    int[] arr = {1, 6, 3};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_2() {
    int[] arr = {6, 1};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_3() {
    int[] arr = {};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_4() {
    int[] arr = {1, 2, 3, 5, 6};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_5() {
    int[] arr = {6, 6, 2};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_6() {
    int[] arr = {6, 6, 2, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_7() {
    int[] arr = {6, 7, 2, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_8() {
    int[] arr = {3, 6, 7, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_9() {
    int[] arr = {6, 3, 6, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_10() {
    int[] arr = {1, 2, 3, 6, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_11() {
    int[] arr = {6, 6, 2, 6, 7};
    assertTrue(Hw2pr8.array667(arr)== 2);
  }   
  @Test
  public void testArray667_12() {
    int[] arr = {3, 6, 6, 7};
    assertTrue(Hw2pr8.array667(arr)== 2);
  }   
  @Test
  public void testArray667_13() {
    int[] arr = {6, 7, 6, 6};
    assertTrue(Hw2pr8.array667(arr)== 2);
  } 
}