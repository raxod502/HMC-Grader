import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class Hw3pr2Test {

	/*
	 * Testing arrayCount9
	 */
	// Source: http://codingbat.com/prob/p184031
	@Test
	public void testArrayCount9_1() {
		int[] arr = {1, 2, 9};
		assertTrue(Hw3pr2.arrayCount9(arr)== 1);
	}
	@Test
	public void testArrayCount9_2() {
		int[] arr = {1, 9, 9};
		assertTrue(Hw3pr2.arrayCount9(arr)== 2);
	}
	@Test
	public void testArrayCount9_3() {
		int[] arr = {1, 9, 9, 3, 9};
		assertTrue(Hw3pr2.arrayCount9(arr)== 3);
	}
	@Test
	public void testArrayCount9_4() {
		int[] arr = {1, 2, 3};
		assertTrue(Hw3pr2.arrayCount9(arr)== 0);
	}
	@Test
	public void testArrayCount9_5() {
		int[] arr = {};
		assertTrue(Hw3pr2.arrayCount9(arr)== 0);
	}
	@Test
	public void testArrayCount9_6() {
		int[] arr = {4, 2, 4, 3, 1};
		assertTrue(Hw3pr2.arrayCount9(arr)== 0);
	}
	@Test
	public void testArrayCount9_7() {
		int[] arr = {9, 2, 4, 3, 1};
		assertTrue(Hw3pr2.arrayCount9(arr)== 1);
	}
	/*
	 * Testing arrayFront9
	 */
	// Source: http://codingbat.com/prob/p186031
	@Test
	public void testArrayFront9_1() {
		int[] arr = {1, 2, 9, 3, 4};
		assertTrue(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_2() {
		int[] arr = {9, 2, 3};
		assertTrue(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_3() {
		int[] arr = {1, 9, 9};
		assertTrue(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_4() {
		int[] arr = {1, 9};
		assertTrue(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_5() {
		int[] arr = {9};
		assertTrue(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_6() {
		int[] arr = {3, 9, 2, 3, 3};
		assertTrue(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_7() {
		int[] arr = {5, 5};
		assertFalse(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_8() {
		int[] arr = {2};
		assertFalse(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_9() {
		int[] arr = {1, 2, 3, 4, 9};
		assertFalse(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_10() {
		int[] arr = {1, 2, 3, 4, 5};
		assertFalse(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_11() {
		int[] arr = {1, 2, 3};
		assertFalse(Hw3pr2.arrayFront9(arr));
	}
	@Test
	public void testArrayFront9_12() {
		int[] arr = {};
		assertFalse(Hw3pr2.arrayFront9(arr));
	}
	/*
	 * Testing array123
	 */
	// Source: http://codingbat.com/prob/p136041
	@Test
	public void testArray123_1() {
		int[] arr = {1, 1, 2, 3, 1};
		assertTrue(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_2() {
		int[] arr = {1, 1, 2, 1, 2, 3};
		assertTrue(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_3() {
		int[] arr = {1, 2, 3, 1, 2, 3};
		assertTrue(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_4() {
		int[] arr = {1, 2, 3};
		assertTrue(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_5() {
		int[] arr = {1, 1, 2, 4, 1};
		assertFalse(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_6() {
		int[] arr = {1, 1, 2, 1, 2, 1};
		assertFalse(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_7() {
		int[] arr = {1, 1, 1};
		assertFalse(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_8() {
		int[] arr = {1, 2};
		assertFalse(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_9() {
		int[] arr = {1};
		assertFalse(Hw3pr2.array123(arr));
	}
	@Test
	public void testArray123_10() {
		int[] arr = {};
		assertFalse(Hw3pr2.array123(arr));
	}

	/*
	 * Testing array667
	 */
	// Source: http://codingbat.com/prob/p110019
	@Test
	public void testArray667_1() {
		int[] arr = {1, 6, 3};
		assertTrue(Hw3pr2.array667(arr)== 0);
	}
	@Test
	public void testArray667_2() {
		int[] arr = {6, 1};
		assertTrue(Hw3pr2.array667(arr)== 0);
	}
	@Test
	public void testArray667_3() {
		int[] arr = {};
		assertTrue(Hw3pr2.array667(arr)== 0);
	}
	@Test
	public void testArray667_4() {
		int[] arr = {1, 2, 3, 5, 6};
		assertTrue(Hw3pr2.array667(arr)== 0);
	}
	@Test
	public void testArray667_5() {
		int[] arr = {6, 6, 2};
		assertTrue(Hw3pr2.array667(arr)== 1);
	}
	@Test
	public void testArray667_6() {
		int[] arr = {6, 6, 2, 6};
		assertTrue(Hw3pr2.array667(arr)== 1);
	}
	@Test
	public void testArray667_7() {
		int[] arr = {6, 7, 2, 6};
		assertTrue(Hw3pr2.array667(arr)== 1);
	}
	@Test
	public void testArray667_8() {
		int[] arr = {3, 6, 7, 6};
		assertTrue(Hw3pr2.array667(arr)== 1);
	}
	@Test
	public void testArray667_9() {
		int[] arr = {6, 3, 6, 6};
		assertTrue(Hw3pr2.array667(arr)== 1);
	}
	@Test
	public void testArray667_10() {
		int[] arr = {1, 2, 3, 6, 6};
		assertTrue(Hw3pr2.array667(arr)== 1);
	}
	@Test
	public void testArray667_11() {
		int[] arr = {6, 6, 2, 6, 7};
		assertTrue(Hw3pr2.array667(arr)== 2);
	}
	@Test
	public void testArray667_12() {
		int[] arr = {3, 6, 6, 7};
		assertTrue(Hw3pr2.array667(arr)== 2);
	}
	@Test
	public void testArray667_13() {
		int[] arr = {6, 7, 6, 6};
		assertTrue(Hw3pr2.array667(arr)== 2);
	}
	/*
	 * Testing noTriples
	 */
	// Source: http://codingbat.com/prob/p170221
	@Test
	public void testNoTriples_1() {
		int[] arr = {1, 1, 2, 2, 1};
		assertTrue(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_2() {
		int[] arr = {1, 1, 2, 2, 1, 2, 1};
		assertTrue(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_3() {
		int[] arr = {1, 2, 1};
		assertTrue(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_4() {
		int[] arr = {1, 1};
		assertTrue(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_5() {
		int[] arr = {1};
		assertTrue(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_6() {
		int[] arr = {};
		assertTrue(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_7() {
		int[] arr = {1, 1, 2, 2, 2, 1};
		assertFalse(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_8() {
		int[] arr = {1, 1, 1, 2, 2, 2, 1};
		assertFalse(Hw3pr2.noTriples(arr));
	}
	@Test
	public void testNoTriples_9() {
		int[] arr = {1, 1, 1};
		assertFalse(Hw3pr2.noTriples(arr));
	}
	/*
	 * Testing has271
	 */
	// Source: http://codingbat.com/prob/p167430
	@Test
	public void testHas271_1() {
		int[] arr = {1, 2, 7, 1};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_2() {
		int[] arr = {2, 7, 1};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_3() {
		int[] arr = {3, 8, 2};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_4() {
		int[] arr = {2, 7, 3};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_5() {
		int[] arr = {2, 7, -1};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_6() {
		int[] arr = {4, 5, 3, 8, 0};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_7() {
		int[] arr = {2, 7, 5, 10, 4};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_8() {
		int[] arr = {2, 7, -2, 4, 9, 3};
		assertTrue(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_9() {
		int[] arr = {1, 2, 8, 1};
		assertFalse(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_10() {
		int[] arr = {2, 7, 4};
		assertFalse(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_11() {
		int[] arr = {2, 7, -2};
		assertFalse(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_12() {
		int[] arr = {2, 7, 5, 10, 1};
		assertFalse(Hw3pr2.has271(arr));
	}
	@Test
	public void testHas271_13() {
		int[] arr = {2, 7, -2, 4, 10, 2};
		assertFalse(Hw3pr2.has271(arr));
	}

}
