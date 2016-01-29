import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_Merge {
  
  /******************
   * merge
   ******************/
  @Test
  public void test_Merge_list1_firstAndLast() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    String[] input1 = { "a", "d" };
    String[] input2 = { "b", "c" };
    String[] correct = { "a", "b", "c", "d" };
    List list1 = List.makeFromArray(input1);
    List list2 = List.makeFromArray(input2);
    List list3Correct = List.makeFromArray(correct);
    list1.merge(list2);
    assertTrue(list3Correct.size() == list1.size());
    assertEquals(list3Correct, list1);
    assertTrue(list2.size() == 0);
    assertEquals(new List(), list2);
  }

  @Test
  public void test_Merge_list2_firstAndLast() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    String[] input1 = { "b", "c" };
    String[] input2 = { "a", "d" };
    String[] correct = { "a", "b", "c", "d" };
    List list1 = List.makeFromArray(input1);
    List list2 = List.makeFromArray(input2);
    List list3Correct = List.makeFromArray(correct);
    list1.merge(list2);
    assertTrue(list3Correct.size() == list1.size());
    assertEquals(list3Correct, list1);
    assertTrue(list2.size() == 0);
    assertEquals(new List(), list2);
  }

  @Test
  public void test_Merge_interleave() {
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    String[] input1 = { "a", "c", "e", "g", "h", "j" };
    String[] input2 = { "b", "d", "f", "i" };
    String[] correct = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    List list1 = List.makeFromArray(input1);
    List list2 = List.makeFromArray(input2);
    List list3Correct = List.makeFromArray(correct);

    list1.merge(list2);
    assertTrue(list3Correct.size() == list1.size());
    assertEquals(list3Correct, list1);
    assertTrue(list2.size() == 0);
    assertEquals(new List(), list2);
  }
}