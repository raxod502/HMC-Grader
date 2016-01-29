import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest_MergeSort {
  
  /********************
   * mergeSort
   ********************/
  @Test
  public void test_MergeSort_1(){
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("a");

    List correct = new List();
    correct.addToFront("a");

    list1.mergeSort();

    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1);
  }

  @Test
  public void test_MergeSort_2ab(){
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

    List correct = new List();
    correct.addToFront("b");
    correct.addToFront("a");

    list1.mergeSort();

    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1);
  }
  
  @Test
  public void test_MergeSort_2ba(){
    // if this test fails try:
    // -- clicking on the test to see how your output wasn't correct
    // -- adding print statements to the broken method
    // -- putting a break-point in the broken method & using the debugger
    // -- running debugging code in the main method of List.java
    // -- adding print statements below and running this test by itself,
    // which you can do by highlighting the test name and then clicking run.
    List list1 = new List();
    list1.addToFront("a");
    list1.addToFront("b");

    List correct = new List();
    correct.addToFront("b");
    correct.addToFront("a");

    list1.mergeSort();

    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1);
  }

  @Test
  public void test_MergeSort_5abcde(){
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

    List correct = new List();
    correct.addToFront("e");
    correct.addToFront("d");
    correct.addToFront("c");
    correct.addToFront("b");
    correct.addToFront("a");

    list1.mergeSort();

    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1);
  }

  @Test
  public void test_MergeSort_5eadbc(){
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
    list1.addToFront("d");
    list1.addToFront("a");
    list1.addToFront("e");

    List correct = new List();
    correct.addToFront("e");
    correct.addToFront("d");
    correct.addToFront("c");
    correct.addToFront("b");
    correct.addToFront("a");

    list1.mergeSort();
    assertTrue(correct.size() == list1.size());
    assertEquals(correct, list1);
  }
}