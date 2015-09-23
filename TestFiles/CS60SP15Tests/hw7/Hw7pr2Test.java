import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Testing file for methods written in Hw7pr2.java
 *
 * You will not turn in this file.
 *
 * Each test case is described in the comment above it.
 *
 * Each test case includes print statements that may be helpful to you when
 * debugging. If a particular test case fails, try removing the comments in
 * front of the print statements and re-run the tests. These print statements
 * will print text in your "Console." DISCLAIMER: These print statements have
 * not been tested and there may be typos, which you should fix when you're
 * using them to test.
 */
public class Hw7pr2Test {
	/*************************************************************
	 * Testing makeArrayOfSameSize
	 *************************************************************/
	// test that the method outputs the right size array for an input of length
	// 1
	@Test
	public void testMakeArrayOfSameSize_size1() {
		int[] input = { 42 };
		int[] output = Hw7pr2.makeArrayOfSameSize(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayOfSameSize_size1 ***");
		// System.out.println("input1 length: " + input1.length);
		// System.out.println("input2 length: " + input2.length);
		assertTrue(output.length == input.length);

	}

	// test that the method outputs the right size array for an input of length
	// 2
	@Test
	public void testMakeArrayOfSameSize_size2() {
		int[] input = { 42, 42 };
		int[] output = Hw7pr2.makeArrayOfSameSize(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayOfSameSize_size2 ***");
		// System.out.println("input1 length: " + input1.length);
		// System.out.println("input2 length: " + input2.length);
		assertTrue(output.length == input.length);
	}

	// test that the method outputs the right size array for an input of length
	// 5
	@Test
	public void testMakeArrayOfSameSize_size5() {
		int[] input = { 42, 42, 42, 42, 42 };
		int[] output = Hw7pr2.makeArrayOfSameSize(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayOfSameSize_size5 ***");
		// System.out.println("input1 length: " + input1.length);
		// System.out.println("input2 length: " + input2.length);
		assertTrue(output.length == input.length);
	}

	/*************************************************************
	 * Testing makeArrayWithSameContents
	 *************************************************************/
	// test that the method outputs the right size array for an input of length
	// 1
	@Test
	public void testMakeArrayWithSameContents_length_size1() {
		int[] input = { 42 };
		int[] output = Hw7pr2.makeArrayWithSameContents(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayWithSameContents_length_size1 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == input.length);
	}

	// test that the method outputs the right size array for an input of length
	// 2
	@Test
	public void testMakeArrayWithSameContents_length_size2() {
		int[] input = { 42, 42 };
		int[] output = Hw7pr2.makeArrayWithSameContents(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayWithSameContents_length_size2 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == input.length);
	}

	// test that the method outputs the right size array for an input of length
	// 5
	@Test
	public void testMakeArrayWithSameContents_length_size5() {
		int[] input = { 42, 42, 42, 42, 42 };
		int[] output = Hw7pr2.makeArrayWithSameContents(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayWithSameContents_length_size5 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == input.length);
	}

	// test that the output array contains the same contents for an input of
	// length 1
	@Test
	public void testMakeArrayWithSameContents_size1() {
		int[] input = { 42 };
		int[] output = Hw7pr2.makeArrayWithSameContents(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayWithSameContents_size1 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(input, output));
	}

	// test that the output array contains the same contents for an input of
	// length 2
	@Test
	public void testMakeArrayWithSameContents_size2() {
		int[] input = { 10, 20 };
		int[] output = Hw7pr2.makeArrayWithSameContents(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayWithSameContents_size2 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(input, output));
	}

	// test that the output array contains the same contents for an input of
	// length 5
	@Test
	public void testMakeArrayWithSameContents_size5() {
		int[] input = { 10, 20, 30, 40, 50 };
		int[] output = Hw7pr2.makeArrayWithSameContents(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMakeArrayWithSameContents_size5 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(input, output));
	}

	/*************************************************************
	 * Testing rest
	 *************************************************************/
	// test that the method outputs the right size array for an input of length
	// 2
	@Test
	public void testRest_length_size2() {
		int[] input = { 10, 20 };
		int[] output = Hw7pr2.rest(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testRest_length_size2 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 1);
	}

	// test that the method outputs the right size array for an input of length
	// 5
	@Test
	public void testRest_length_size5() {
		int[] input = { 10, 20, 30, 40, 50 };
		int[] output = Hw7pr2.rest(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testRest_length_size5 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 4);
	}

	// test that the method outputs the right size array for an input of length
	// 10
	@Test
	public void testRest_length_size10() {
		int[] input = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int[] output = Hw7pr2.rest(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testRest_length_size10 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 9);
	}

	// test that the output array contains the right contents for an input of
	// length 2
	@Test
	public void testRest_size2() {
		int[] input = { 10, 20 };
		int[] correct = { 20 };
		int[] output = Hw7pr2.rest(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testRest_size2 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	// test that the output array contains the right contents for an input of
	// length 5
	@Test
	public void testRest_size5() {
		int[] input = { 10, 20, 30, 40, 50 };
		int[] correct = { 20, 30, 40, 50 };
		int[] output = Hw7pr2.rest(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testRest_size5 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	// test that the output array contains the right contents for an input of
	// length 10
	@Test
	public void testRest_size10() {
		int[] input = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int[] correct = { 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int[] output = Hw7pr2.rest(input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testRest_size10 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	/*************************************************************
	 * Testing cons
	 *************************************************************/
	// test that the method outputs the right size array for an input of length
	// 1
	@Test
	public void testCons_length_size1() {
		int[] input = { 20 };
		int[] output = Hw7pr2.cons(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testCons_length_size1 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 2);
	}

	// test that the method outputs the right size array for an input of length
	// 2
	@Test
	public void testCons_length_size2() {
		int[] input = { 20, 30 };
		int[] output = Hw7pr2.cons(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testCons_length_size2 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 3);
	}

	// test that the method outputs the right size array for an input of length
	// 5
	@Test
	public void testCons_length_size5() {
		int[] input = { 20, 30, 40, 50 };
		int[] output = Hw7pr2.cons(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testCons_length_size5 ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 5);
	}

	// test that the output array contains the new element followed by the
	// elements from the initial array with a length of 1
	@Test
	public void testCons_size1() {
		int[] input = { 20 };
		int[] correct = { 10, 20 };
		int[] output = Hw7pr2.cons(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testCons_size1 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	// test that the output array contains the new element followed by the
	// elements from the initial array with a length of 2
	@Test
	public void testCons_size2() {
		int[] input = { 20, 30 };
		int[] correct = { 10, 20, 30 };
		int[] output = Hw7pr2.cons(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testCons_size2 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	// test that the output array contains the new element followed by the
	// elements from the initial array with a length of 5
	@Test
	public void testCons_size5() {
		int[] input = { 20, 30, 40, 50 };
		int[] correct = { 10, 20, 30, 40, 50 };
		int[] output = Hw7pr2.cons(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testCons_size5 ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	/*************************************************************
	 * Testing append
	 *************************************************************/
	// tests the length of the output array given two arrays of length 3
	@Test
	public void testAppend_3_3_length() {
		int[] input1 = { 10, 20, 30 };
		int[] input2 = { 40, 50, 60 };
		int[] output = Hw7pr2.append(input1, input2);
		assertTrue(output.length == 6);
	}

	// tests the length of the output array given (first) an array of length 1
	// and (second) an array of length 3.
	@Test
	public void testAppend_1_3_length() {
		int[] input1 = { 10 };
		int[] input2 = { 20, 30, 40 };
		int[] output = Hw7pr2.append(input1, input2);
		assertTrue(output.length == 4);
	}

	// tests the length of the output array given (first) an array of length 3
	// and (second) an array of length 1.
	@Test
	public void testAppend_3_1_length() {
		int[] input1 = { 10, 20, 30 };
		int[] input2 = { 40 };
		int[] output = Hw7pr2.append(input1, input2);
		assertTrue(output.length == 4);
	}

	// tests the contents of the output array given (first) an array of length 3
	// and (second) an array of length 3.
	@Test
	public void testAppend_3_3() {
		int[] input1 = { 10, 20, 30 };
		int[] input2 = { 40, 50, 60 };
		int[] correct = { 10, 20, 30, 40, 50, 60 };
		int[] output = Hw7pr2.append(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testAppend_3_3 ***");
		// System.out.println("input1: " + Arrays.toString(input1));
		// System.out.println("input2: " + Arrays.toString(input2));
		// System.out.println("correct:" + Arrays.toString(correct));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(output, correct));
	}

	// tests the contents of the output array given (first) an array of length 1
	// and (second) an array of length 3.
	@Test
	public void testAppend_1_3() {
		int[] input1 = { 10 };
		int[] input2 = { 20, 30, 40 };
		int[] correct = { 10, 20, 30, 40 };
		int[] output = Hw7pr2.append(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testAppend_1_3 ***");
		// System.out.println("input1: " + Arrays.toString(input1));
		// System.out.println("input2: " + Arrays.toString(input2));
		// System.out.println("correct:" + Arrays.toString(correct));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(output, correct));
	}

	// tests the contents of the output array given (first) an array of length 3
	// and (second) an array of length 1.
	@Test
	public void testAppend_3_1() {
		int[] input1 = { 10, 20, 30 };
		int[] input2 = { 40 };
		int[] correct = { 10, 20, 30, 40 };
		int[] output = Hw7pr2.append(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testAppend_3_1 ***");
		// System.out.println("input1: " + Arrays.toString(input1));
		// System.out.println("input2: " + Arrays.toString(input2));
		// System.out.println("correct:" + Arrays.toString(correct));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(output, correct));
	}

	/*************************************************************
	 * Testing merge
	 *************************************************************/
	// tests the length of the output array given two arrays of length 3
	@Test
	public void testMerge_3_3_length() {
		int[] input1 = { 10, 20, 30 };
		int[] input2 = { 40, 50, 60 };
		int[] output = Hw7pr2.merge(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMerge_3_3_length ***");
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 6);
	}

	// tests the length of the output array given (first) an array of length 1
	// and (second) an array of length 3.
	@Test
	public void testMerge_1_3_length() {
		int[] input1 = { 10 };
		int[] input2 = { 20, 30, 40 };
		int[] output = Hw7pr2.merge(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMerge_1_3_length ***");
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 4);
	}

	// tests the length of the output array given (first) an array of length 3
	// and (second) an array of length 1.
	@Test
	public void testMerge_3_1_length() {
		int[] input1 = { 10, 20, 30 };
		int[] input2 = { 40 };
		int[] output = Hw7pr2.merge(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMerge_3_1_length ***");
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 4);
	}

	// test when an element from arr1 is both the first element in the output
	// and the last element in the output. Tests adding two elements in a row
	// from arr2.
	@Test
	public void testMerge_arr1_firstAndLast() {
		int[] input1 = { 10, 40 };
		int[] input2 = { 20, 30 };
		int[] correct = { 10, 20, 30, 40 };
		int[] output = Hw7pr2.merge(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMerge_arr1_firstAndLast ***");
		// System.out.println("input1: " + Arrays.toString(input1));
		// System.out.println("input2: " + Arrays.toString(input2));
		// System.out.println("correct:" + Arrays.toString(correct));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(output, correct));
	}

	// test when an element from arr2 is both the first element in the output
	// and the last element in the output. Tests adding two elements in a row
	// from arr1.
	@Test
	public void testMerge_arr2_firstAndLast() {
		int[] input1 = { 20, 30 };
		int[] input2 = { 10, 40 };
		int[] correct = { 10, 20, 30, 40 };
		int[] output = Hw7pr2.merge(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMerge_arr2_firstAndLast ***");
		// System.out.println("input1: " + Arrays.toString(input1));
		// System.out.println("input2: " + Arrays.toString(input2));
		// System.out.println("correct:" + Arrays.toString(correct));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(output, correct));
	}

	// test when elements in the input are interleaved
	@Test
	public void testMerge_arr2_interleave() {
		int[] input1 = { 10, 30, 50, 70, 80, 100 };
		int[] input2 = { 20, 40, 60, 90 };
		int[] correct = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int[] output = Hw7pr2.merge(input1, input2);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testMerge_arr2_interleave ***");
		// System.out.println("input1: " + Arrays.toString(input1));
		// System.out.println("input2: " + Arrays.toString(input2));
		// System.out.println("correct:" + Arrays.toString(correct));
		// System.out.println("output: " + Arrays.toString(output));
		assertTrue(Arrays.equals(output, correct));
	}

	/*************************************************************
	 * Testing insert
	 *************************************************************/
	// test that the method outputs the right size array for an input of length
	// 1
	@Test
	public void testInsert_length_first() {
		int[] input = { 20, 30, 40, 50 };
		int[] output = Hw7pr2.insert(10, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testInsert_length_first ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 5);
	}

	// test that the method outputs the right size array for an input of length
	// 2
	@Test
	public void testInsert_length_middle() {
		int[] input = { 10, 20, 40, 50 };
		int[] output = Hw7pr2.insert(30, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testInsert_length_middle ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 5);
	}

	// test that the method outputs the right size array for an input of length
	// 5
	@Test
	public void testInsert_length_end() {
		int[] input = { 10, 20, 30, 40, 50 };
		int[] output = Hw7pr2.insert(60, input);
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testInsert_length_end ***");
		// System.out.println("input  length: " + input.length);
		// System.out.println("output length: " + output.length);
		assertTrue(output.length == 6);
	}

	// test that the output array contains the new element followed by the
	// elements from the initial array with a length of 1
	@Test
	public void testInsert_first() {
		int[] input = { 20, 30, 40, 50 };
		int[] output = Hw7pr2.insert(10, input);
		int[] correct = { 10, 20, 30, 40, 50 };
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testInsert_first ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	// test that the output array contains the new element followed by the
	// elements from the initial array with a length of 2
	@Test
	public void testInsert_middle() {
		int[] input = { 10, 20, 40, 50 };
		int[] output = Hw7pr2.insert(30, input);
		int[] correct = { 10, 20, 30, 40, 50 };
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testInsert_middle ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

	// test that the output array contains the new element followed by the
	// elements from the initial array with a length of 5
	@Test
	public void testInsert_end() {
		int[] input = { 10, 20, 30, 40, 50 };
		int[] output = Hw7pr2.insert(60, input);
		int[] correct = { 10, 20, 30, 40, 50, 60 };
		// Remove comment for debugging (and double check variables being
		// printed)
		// System.out.println("*** testInsert_end ***");
		// System.out.println("input:  " + Arrays.toString(input));
		// System.out.println("output: " + Arrays.toString(output));
		// System.out.println("correct:" + Arrays.toString(correct));
		assertTrue(Arrays.equals(output, correct));
	}

}
