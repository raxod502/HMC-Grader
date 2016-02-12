import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class FirstLast6Test {
  /*
   * Testing firstLast6
   */  
  @Test
  public void testFirstLast6_0() {
    int x[] = { 1, 2, 6 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_1() {
    int x[] = { 6, 1, 2, 3 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_2() {
    int x[] = { 13, 6, 1, 2, 6 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_3() {
    int x[] = { 3, 6 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_4() {
    int x[] = { 6 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_5() {
    int x[] = { 5, 6 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_6() {
    int x[] = { 1, 2, 3, 4, 6 };
    assertTrue(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_7() {
    int x[] = { 13, 6, 1, 2, 3 };
    assertFalse(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_8() {
    int x[] = { 3, 2, 1 };
    assertFalse(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_9() {
    int x[] = { 3, 6, 1 };
    assertFalse(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_10() {
    int x[] = { 3 };
    assertFalse(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_11() {
    int x[] = { 5, 5 };
    assertFalse(ArrayPractice.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_12() {
    int x[] = { 1, 2, 3, 4 };
    assertFalse(ArrayPractice.firstLast6(x));
  }

}