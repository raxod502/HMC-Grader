import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class NoTriplesTest {
  /*
   * Testing noTriples
   */
  // Source: http://codingbat.com/prob/p170221  
  @Test
  public void testNoTriples_1() {
    int[] arr = {1, 1, 2, 2, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_2() {
    int[] arr = {1, 1, 2, 2, 1, 2, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_3() {
    int[] arr = {1, 2, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_4() {
    int[] arr = {1, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_5() {
    int[] arr = {1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_6() {
    int[] arr = {};
    assertTrue(Hw2pr8.noTriples(arr));
  }   
  @Test
  public void testNoTriples_7() {
    int[] arr = {1, 1, 2, 2, 2, 1};
    assertFalse(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_8() {
    int[] arr = {1, 1, 1, 2, 2, 2, 1};
    assertFalse(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_9() {
    int[] arr = {1, 1, 1};
    assertFalse(Hw2pr8.noTriples(arr));
  }
}