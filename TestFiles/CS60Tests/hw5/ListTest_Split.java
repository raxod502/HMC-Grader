import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_Split {
  
  /**************
   * split
   **************/
  @Test
  public void test_Split_1() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("a");

    List correctOutput = new List();
 
    List correct = new List();
    correct.addToFront("a");

    List output = list1.split();
    
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(correctOutput.size() == output.size());
    assertEquals(correctOutput, output); // list2 not modified
  }

  @Test
  public void test_Split_5() {
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

    List correctOutput = new List();
    correctOutput.addToFront("e");
    correctOutput.addToFront("d");

    List correct = new List();
    correct.addToFront("c");
    correct.addToFront("b");
    correct.addToFront("a");
    List output = list1.split();
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(correctOutput.size() == output.size());
    assertEquals(correctOutput, output); // list2 not modified
  }

  @Test
  public void test_Split_6() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("f");
    list1.addToFront("e");
    list1.addToFront("d");
    list1.addToFront("c");
    list1.addToFront("b");
    list1.addToFront("a");

    List correctOutput = new List();
    correctOutput.addToFront("f");
    correctOutput.addToFront("e");
    correctOutput.addToFront("d");

    List correct = new List();
    correct.addToFront("c");
    correct.addToFront("b");
    correct.addToFront("a");

    List output = list1.split();
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1); // correct output
    assertTrue(correctOutput.size() == output.size());
    assertEquals(correctOutput, output); // list2 not modified
  }
}
