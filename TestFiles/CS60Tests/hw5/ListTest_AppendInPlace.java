import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_AppendInPlace {
  
  /********************
   * appendInPlace
   ********************/
  @Test
  public void test_AppendInPlace_1_0() {
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

    List list2copy = new List();

    list1.appendInPlace(list2);

    List correct = new List();
    correct.addToFront("a");
    
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(list2copy.size() == list2.size());
    assertEquals(list2copy, list2); // list2 not modified
  }

  @Test
  public void test_AppendInPlace_0_1() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    List list2 = new List();
    list2.addToFront("a");

    List list2copy = new List();
    list2copy.addToFront("a");

    list1.appendInPlace(list2);

    List correct = new List();
    correct.addToFront("a");
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(list2copy.size() == list2.size());
    assertEquals(list2copy, list2); // list2 not modified
  }

  @Test
  public void test_AppendInPlace_1_1() {
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
    list2.addToFront("b");

    List list2copy = new List();
    list2copy.addToFront("b");

    list1.appendInPlace(list2);

    List correct = new List();
    correct.addToFront("b");
    correct.addToFront("a");
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(list2copy.size() == list2.size());
    assertEquals(list2copy, list2); // list2 not modified
  }

  @Test
  public void test_AppendInPlace_3_3() {
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
    List list2 = new List();
    list2.addToFront("f");
    list2.addToFront("e");
    list2.addToFront("d");

    List list2copy = new List();
    list2copy.addToFront("f");
    list2copy.addToFront("e");
    list2copy.addToFront("d");

    list1.appendInPlace(list2);

    List correct = new List();
    correct.addToFront("f");
    correct.addToFront("e");
    correct.addToFront("d");
    correct.addToFront("c");
    correct.addToFront("b");
    correct.addToFront("a");
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(list2copy.size() == list2.size());
    assertEquals(list2copy, list2); // list2 not modified
  }
}
