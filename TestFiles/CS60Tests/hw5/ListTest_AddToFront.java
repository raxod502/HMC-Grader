import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_AddToFront {
  
  /*
   * Test the List constructor by creating a new List and checking for
   * consistency using toString(), isEmpty(), and size()
   */
  @Test
  public void test_Constructor() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    assertEquals("( )", list1.toString());
    assertTrue(list1.isEmpty());
    assertTrue(list1.size() == 0);
    assertTrue(list1.length() == 0);
  }

  /*
   * Test addToFront by adding one element and checking for consistency using
   * toString(), isEmpty(), and size()
   */
  @Test
  public void test_AddToFront_callOnce() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("b");
    assertEquals("( b )", list1.toString());
    assertFalse(list1.isEmpty());
    assertTrue(list1.size() == 1);
  }

  /*
   * Test addToFront by adding two elements and checking for consistency using
   * toString(), isEmpty(), and size()
   */
  @Test
  public void test_AddToFront_callTwice() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("b");
    list1.addToFront("a");
    assertEquals("( a b )", list1.toString());
    assertFalse(list1.isEmpty());
    assertTrue(list1.size() == 2);
  }

  /*
   * Tests for Equals method. You can assume that equals works as intended
   */
  @Test
  public void test_Equals() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    List list2 = new List();
    List list3 = new List();
    assertEquals(list1, list2);
    list1.addToFront("a");
    assertFalse(list1.equals(list2)); // arg empty, this not
    list2.addToFront("a");
    assertEquals(list1, list2);
    assertFalse(list3.equals(list1)); // this empty, arg not
    list2.addToFront("b");
    assertFalse(list1.equals(list2)); // this shorter than arg
    list1.addToFront("b");
    assertEquals(list1, list2);
    list1.addToFront("c");
    assertFalse(list1.equals(list2)); // this longer than arg
    list3.addToFront("a");
    list3.addToFront("a");
    assertFalse(list2.equals(list3)); // same length, different elements
  }
}