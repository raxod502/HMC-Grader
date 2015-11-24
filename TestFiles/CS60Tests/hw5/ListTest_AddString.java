import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_AddString {
  /**********************************************************
   * Testing add(String s)
   **********************************************************/
  /*
   * Test add(String s), which adds to the end of a List. Adding a single
   * element to an empty List and checking for consistency using toString(),
   * isEmpty(), and size()
   */
  @Test
  public void test_Add_toEmptyList() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.add("z");
    assertEquals("( z )", list1.toString());
    assertFalse(list1.isEmpty());
    assertTrue(list1.size() == 1);
  }

  /*
   * Test add(String s), which adds to the end of a List. Adding a single
   * element to the end of a List with 3 elements and checking for consistency
   * using toString(), isEmpty(), and size()
   */
  @Test
  public void test_Add_to3elementList() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("c");
    list1.addToFront("b");
    list1.addToFront("a");
    list1.add("d");
    assertEquals("( a b c d )", list1.toString());
    assertFalse(list1.isEmpty());
    assertTrue(list1.size() == 4);
  }

  /*
   * Test add(String s), which adds to the end of a List. Ensure that a List
   * created with addToFront can be equal to a List created with add
   */
  @Test
  public void test_Add_4elements() {
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
    list2.add("a");
    list2.add("b");
    list2.add("c");
    list2.add("d");
    assertTrue(list1.size() == list2.size());
    assertEquals(list1, list2);
  }
}