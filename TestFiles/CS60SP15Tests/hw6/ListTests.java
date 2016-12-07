import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
/*
 * This file includes JUnit test cases for methods written in List.java
 *
 * Some of the test cases are interdependent. For example, we use
 * toString(), isEmpty(), and size() to evaluate whether other methods have
 * executed successful. Therefore, if there are errors in any of these
 * methods (toString(), isEmpty(), or size()) a test can fail for a reason
 * other than that the method did not execute successfully. This is a common
 * problem in writing tests. To make this easier for you, we have provided
 * the code for toString(), isEmpty(), and size(), which should allow you to
 * focus on writing and testing your other methods.
 */
@RunWith(JUnit4.class)
public class ListTest {
	/**********************************************************
	 * Testing Provided Code
	 **********************************************************/
	/*
	 * Test the List constructor by creating a new List and checking for
	 * consistency using toString(), isEmpty(), and size()
	 */
	@Test
	public void testConstructor() {
		List list1 = new List();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertTrue(list1.size() == 0);
	}

	/*
	 * Test addToFront by adding one element and checking for consistency using
	 * toString(), isEmpty(), and size()
	 */
	@Test
	public void testAddToFront_callOnce() {
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
	public void testAddToFront_callTwice() {
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
	public void testEquals() {
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

	/**********************************************************
	 * Testing add
	 **********************************************************/
	/*
	 * Test add, which adds to the end of a List. Adding a single element to an
	 * empty List and checking for consistency using toString(), isEmpty(), and
	 * size()
	 */
	@Test
	public void testAdd_toEmptyList() {
		List list1 = new List();
		list1.add("z");
		assertEquals("( z )", list1.toString());
		assertFalse(list1.isEmpty());
		assertTrue(list1.size() == 1);
	}

	/*
	 * Test add, which adds to the end of a List. Adding a single element to the
	 * end of a List with 3 elements and checking for consistency using
	 * toString(), isEmpty(), and size()
	 */
	@Test
	public void testAdd_to3elementList() {
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
	 * Test add, which adds to the end of a List. Ensure that a List created
	 * with addToFront can be equal to a List created with add
	 */
	@Test
	public void testAdd_4elements() {
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

		assertEquals(list1, list2);
	}

	/**********************************************************
	 * Test reverse
	 **********************************************************/
	@Test
	public void testReverse_0elements() {
		List list1 = new List();

		List list2 = new List();

		list1.reverse();
		assertEquals(list1, list2);
	}

	@Test
	public void testReverse_1element() {
		List list1 = new List();
		list1.addToFront("a");

		List list2 = new List();
		list2.addToFront("a");

		list1.reverse();
		assertEquals(list1, list2);
	}

	@Test
	public void testReverse_4elements() {
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
		assertEquals(list1, list2);
	}

	/**********************************************************
	 * Test makeFromArray
	 **********************************************************/
	@Test
	public void testMakeFromArray_1element() {
		String[] input = { "a" };
		List list1 = List.makeFromArray(input);

		List list2 = new List();
		list2.addToFront("a");
		assertEquals(list1, list2);
	}

	@Test
	public void testMakeFromArray_2element() {
		String[] input = { "a", "b" };
		List list1 = List.makeFromArray(input);

		List list2 = new List();
		list2.addToFront("b");
		list2.addToFront("a");
		assertEquals(list1, list2);
	}

	@Test
	public void testMakeFromArray_5element() {
		String[] input = { "a", "b", "c", "d", "e" };
		List list1 = List.makeFromArray(input);

		List list2 = new List();
		list2.addToFront("e");
		list2.addToFront("d");
		list2.addToFront("c");
		list2.addToFront("b");
		list2.addToFront("a");
		assertEquals(list1, list2);
	}

	/**********************************************************
	 * makeEquivalentArray
	 **********************************************************/
	@Test
	public void testMakeEquivalentArray_1() {
		List list1 = new List();
		list1.addToFront("a");
		String[] output = list1.makeEquivalentArray();
		String[] correct = { "a" };
		assertEquals(Arrays.toString(correct), Arrays.toString(output));
	}

	@Test
	public void testMakeEquivalentArray_2() {
		List list1 = new List();
		list1.addToFront("b");
		list1.addToFront("a");
		String[] output = list1.makeEquivalentArray();
		String[] correct = { "a", "b" };
		assertEquals(Arrays.toString(correct), Arrays.toString(output));
	}

	@Test
	public void testMakeEquivalentArray_5() {
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

	/**********************************************************
	 * appendInPlace
	 **********************************************************/
	@Test
	public void testAppendInPlace_1_0() {
		List list1 = new List();
		list1.addToFront("a");
		List list2 = new List();

		List list2copy = new List();

		list1.appendInPlace(list2);

		List correct = new List();
		correct.addToFront("a");
		assertEquals(list1, correct); // correct output
		assertEquals(list2, list2copy); // list2 not modified
	}

	@Test
	public void testAppendInPlace_0_1() {
		List list1 = new List();
		List list2 = new List();
		list2.addToFront("a");

		List list2copy = new List();
		list2copy.addToFront("a");

		list1.appendInPlace(list2);

		List correct = new List();
		correct.addToFront("a");
		assertEquals(list1, correct); // correct output
		assertEquals(list2, list2copy); // list2 not modified
	}

	@Test
	public void testAppendInPlace_1_1() {
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
		assertEquals(list1, correct); // correct output
		assertEquals(list2, list2copy); // list2 not modified
	}

	@Test
	public void testAppendInPlace_3_3() {
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
		assertEquals(list1, correct); // correct output
		assertEquals(list2, list2copy); // list2 not modified
	}

	/**********************************************************
	 * split
	 **********************************************************/
	@Test
	public void testSplit_1() {
		List list1 = new List();
		list1.addToFront("a");

		List correctOutput = new List();

		List correct = new List();
		correct.addToFront("a");

		List output = list1.split();
		assertEquals(list1, correct);
		assertEquals(output, correctOutput);
	}

	@Test
	public void testSplit_5() {
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
		assertEquals(list1, correct);
		assertEquals(output, correctOutput);
	}

	@Test
	public void testSplit_6() {
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
		assertEquals(list1, correct);
		assertEquals(output, correctOutput);
	}

	/**********************************************************
	 * removeFirst
	 **********************************************************/
	@Test
	public void testRemoveFirst_1(){
		List list1 = new List();
		list1.addToFront("a");

		List correct = new List();

		list1.removeFirst();

		assertEquals(list1, correct);
	}
	@Test
	public void testRemoveFirst_2(){
		List list1 = new List();
		list1.addToFront("b");
		list1.addToFront("a");

		List correct = new List();
		correct.addToFront("b");

		list1.removeFirst();

		assertEquals(list1, correct);
	}
	@Test
	public void testRemoveFirst_4(){
		List list1 = new List();
		list1.addToFront("d");
		list1.addToFront("c");
		list1.addToFront("b");
		list1.addToFront("a");

		List correct = new List();
		correct.addToFront("d");
		correct.addToFront("c");
		correct.addToFront("b");

		list1.removeFirst();

		assertEquals(list1, correct);
	}
	/**********************************************************
	 * merge
	 **********************************************************/
	@Test
	public void testMerge_list1_firstAndLast() {
		String[] input1 = { "a", "d" };
		String[] input2 = { "b", "c" };
		String[] correct = { "a", "b", "c", "d" };
		List list1 = List.makeFromArray(input1);
		List list2 = List.makeFromArray(input2);
		List list3Correct = List.makeFromArray(correct);
		list1.merge(list2);
		assertEquals(list1, list3Correct);
		assertEquals(list2, new List());
	}

	@Test
	public void testMerge_list2_firstAndLast() {
		String[] input1 = { "b", "c" };
		String[] input2 = { "a", "d" };
		String[] correct = { "a", "b", "c", "d" };
		List list1 = List.makeFromArray(input1);
		List list2 = List.makeFromArray(input2);
		List list3Correct = List.makeFromArray(correct);
		list1.merge(list2);

		assertEquals(list1, list3Correct);
		assertEquals(list2, new List());
	}

	@Test
	public void testMerge_interleave() {
		String[] input1 = { "a", "c", "e", "g", "h", "j" };
		String[] input2 = { "b", "d", "f", "i" };
		String[] correct = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		List list1 = List.makeFromArray(input1);
		List list2 = List.makeFromArray(input2);
		List list3Correct = List.makeFromArray(correct);

		list1.merge(list2);

		assertEquals(list1, list3Correct);
		assertEquals(list2, new List());

	}

	/**********************************************************
	 * mergeSort
	 **********************************************************/
	@Test
	public void testMergeSort_1(){
		List list1 = new List();
		list1.addToFront("a");

		List correct = new List();
		correct.addToFront("a");

		list1.mergeSort();

		assertEquals(list1, correct);
	}

	@Test
	public void testMergeSort_2ab(){
		List list1 = new List();
		list1.addToFront("b");
		list1.addToFront("a");

		List correct = new List();
		correct.addToFront("b");
		correct.addToFront("a");

		list1.mergeSort();

		assertEquals(list1, correct);
	}
	@Test
	public void testMergeSort_2ba(){
		List list1 = new List();
		list1.addToFront("a");
		list1.addToFront("b");

		List correct = new List();
		correct.addToFront("b");
		correct.addToFront("a");

		list1.mergeSort();

		assertEquals(list1, correct);
	}

	@Test
	public void testMergeSort_5abcde(){
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

		assertEquals(list1, correct);
	}

	@Test
	public void testMergeSort_5eadbc(){
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
		assertEquals(list1, correct);
	}
}
