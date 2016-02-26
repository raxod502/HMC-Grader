import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_Reverse {
  /**********************
   * Tests for reverse
   **********************/
  @Test
  public void test_Reverse_0elements() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();

    List list2 = new List();

    list1.reverse();
    assertTrue(list1.size() == list2.size());
    assertEquals(list2, list1);
  }

  @Test
  public void test_Reverse_1element() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("a");

    List list2 = new List();
    list2.addToFront("a");

    list1.reverse();
    assertTrue(list1.size() == list2.size());
    assertEquals(list2, list1);
  }

  @Test
  public void test_Reverse_4elements() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("d");
    list1.addToFront("c");
    list1.addToFront("b");
    list1.addToFront("a");

    List list2 = new List();
    list2.addToFront("a");
    list2.addToFront("b");
    list2.addToFront("c");
    list2.addToFront("d");

    list1.reverse();
    assertTrue(list1.size() == list2.size());
    assertEquals(list2, list1);
  }
}