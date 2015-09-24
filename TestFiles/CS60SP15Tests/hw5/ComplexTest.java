import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
@RunWith(JUnit4.class)
public class ComplexTest {
  
  /**
   * test zero-input constructor
   */
  @Test
  public void test_complex_constructors() {
    Complex expected = new Complex(0.0,0.0);
    Complex actual = new Complex();
    assertEquals("test_complex_constructors", 
                 /* expected */ expected,                       
                 /* actual */ actual );
  }
  
  
  /**
   * test of add
   */
  @Test
  public void test_add() 
  {
    Complex solution = new Complex(42.0,60.0); // 42 + 60i
    Complex c2 = new Complex(20.0,20.0); 
    Complex c3 = new Complex(22.0,40.0); 
    assertEquals("test_add", 
                 /* expected */ solution,                       
                 /* actual */ c2.add(c3) );
  }
  
  /**
   * test of negate
   */
  @Test
  public void test_negate() 
  {
    Complex solution = new Complex(42.0,60.0); // 42 + 60i
    Complex c2 = new Complex(-42.0,-60.0);  
    assertEquals("test_negate", 
                 /* expected */ solution,                       
                 /* actual */ c2.negate() );
  }
  
  /**
   * test of conjugate
   */
  @Test
  public void test_conjugate() 
  {
    Complex solution = new Complex(42.0,60.0); // 42 + 60i
    Complex c2 = new Complex(42.0,-60.0);  
    assertEquals("test_negate", 
                 /* expected */ solution,                       
                 /* actual */ c2.conjugate() );
  }
  
  /**
   * test of multiply
   */
  @Test
  public void test_multiply() 
  {
    Complex c1 = new Complex(2.0,3.0); 
    Complex c2 = new Complex(4.0,-5.0); 
    Complex solution = new Complex(23.0,2.0); 
    assertEquals("test_multiply", 
                 /* expected */ solution,                       
                 /* actual */ c1.multiply(c2) );
  } 
  
  /**
   * test of divide
   */
  @Test
  public void test_divide() 
  {
    Complex c1 = new Complex(5.0,-200.0); 
    Complex c2 = new Complex(1.0,2.0); 
    Complex solution = new Complex(-79.0,-42.0); 
    assertEquals("test_multiply", 
                 /* expected */ solution,                       
                 /* actual */ c1.divide(c2) );
  } 
  
}
