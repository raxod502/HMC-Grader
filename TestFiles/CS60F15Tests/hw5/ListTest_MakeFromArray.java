import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_MakeFromArray {
  
  /************************
   * Test makeFromArray
   ************************/
  @Test
  public void test_MakeFromArray_1element() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    String[] input = { "a" };
    List list1 = List.makeFromArray(input);

    List list2 = new List();
    list2.addToFront("a");
    assertTrue(list1.size() == list2.size());
    assertEquals(list2, list1);
  }

  @Test
  public void test_MakeFromArray_2element() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    String[] input = { "a", "b" };
    List list1 = List.makeFromArray(input);

    List list2 = new List();
    list2.addToFront("b");
    list2.addToFront("a");
    assertTrue(list1.size() == list2.size());
    assertEquals(list2, list1);
  }

  @Test
  public void test_MakeFromArray_5element() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    String[] input = { "a", "b", "c", "d", "e" };
    List list1 = List.makeFromArray(input);

    List list2 = new List();
    list2.addToFront("e");
    list2.addToFront("d");
    list2.addToFront("c");
    list2.addToFront("b");
    list2.addToFront("a");
    assertEquals(list2, list1);
  }
}
