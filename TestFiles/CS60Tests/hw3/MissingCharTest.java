import static org.junit.Assert.*;
import org.junit.Test;

public class MissingCharTest {
  /*
   * Testing missingChar
   */
  
  @Test
  public void testMissingChar0() {
    assertTrue(Hw3pr4.missingChar("kitten", 1).equals("ktten"));
  }
  
  @Test
  public void testMissingChar1() {
    assertTrue(Hw3pr4.missingChar("kitten", 0).equals("itten"));
  }
  
  @Test
  public void testMissingChar2() {
    assertTrue(Hw3pr4.missingChar("kitten", 4).equals("kittn"));
  }
  
  @Test
  public void testMissingChar3() {
    assertTrue(Hw3pr4.missingChar("Hi", 0).equals("i"));
  }
  
  @Test
  public void testMissingChar4() {
    assertTrue(Hw3pr4.missingChar("Hi", 1).equals("H"));
  }
  
  @Test
  public void testMissingChar5() {
    assertTrue(Hw3pr4.missingChar("code", 0).equals("ode"));
  }
  
  @Test
  public void testMissingChar6() {
    assertTrue(Hw3pr4.missingChar("code", 1).equals("cde"));
  }
  
  @Test
  public void testMissingChar7() {
    assertTrue(Hw3pr4.missingChar("code", 2).equals("coe"));
  }
  
  @Test
  public void testMissingChar8() {
    assertTrue(Hw3pr4.missingChar("code", 3).equals("cod"));
  }
  
  @Test
  public void testMissingChar9() {
    assertTrue(Hw3pr4.missingChar("chocolate", 8).equals("chocolat"));
  } 
}