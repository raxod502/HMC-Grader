import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_MakeEquivalentArray {
  
  /**************************
   * makeEquivalentArray
   **************************/
  @Test
  public void test_MakeEquivalentArray_1() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("a");
    String[] output = list1.makeEquivalentArray();
    String[] correct = { "a" };
    assertEquals(Arrays.toString(correct), Arrays.toString(output));
  }

  @Test
  public void test_MakeEquivalentArray_2() {
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
    String[] output = list1.makeEquivalentArray();
    String[] correct = { "a", "b" };
    assertEquals(Arrays.toString(correct), Arrays.toString(output));
  }

  @Test
  public void test_MakeEquivalentArray_5() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("e");
    list1.addToFront("d");
    list1.addToFront("c");
    list1.addToFront("b");
    list1.addToFront("a");
    String[] output = list1.makeEquivalentArray();
    String[] correct = { "a", "b", "c", "d", "e" };
    assertEquals(Arrays.toString(correct), Arrays.toString(output));
  }
}
