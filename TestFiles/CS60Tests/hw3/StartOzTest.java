import static org.junit.Assert.*;
import org.junit.Test;

public class StartOzTest {
  /*
   * Testing startOz
   */
  
  @Test
  public void testStartOz0() {
    assertTrue(Hw3pr4.startOz("ozymandias").equals("oz"));
  }
  
  @Test
  public void testStartOz1() {
    assertTrue(Hw3pr4.startOz("bzoo").equals("z"));
  }
  
  @Test
  public void testStartOz2() {
    assertTrue(Hw3pr4.startOz("oxx").equals("o"));
  }
  
  @Test
  public void testStartOz3() {
    assertTrue(Hw3pr4.startOz("oz").equals("oz"));
  }
  
  @Test
  public void testStartOz4() {
    assertTrue(Hw3pr4.startOz("ounce").equals("o"));
  }
  
  @Test
  public void testStartOz5() {
    assertTrue(Hw3pr4.startOz("o").equals("o"));
  }
  
  @Test
  public void testStartOz6() {
    assertTrue(Hw3pr4.startOz("abc").equals(""));
  }
  
  @Test
  public void testStartOz7() {
    assertTrue(Hw3pr4.startOz("").equals(""));
  }
  
  @Test
  public void testStartOz8() {
    assertTrue(Hw3pr4.startOz("zoo").equals(""));
  }
  
  @Test
  public void testStartOz9() {
    assertTrue(Hw3pr4.startOz("aztec").equals("z"));
  }
  
  @Test
  public void testStartOz10() {
    assertTrue(Hw3pr4.startOz("zzzz").equals("z"));
  }
  
  @Test
  public void testStartOz11() {
    assertTrue(Hw3pr4.startOz("oznic").equals("oz"));
  }

  
}