import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Hw4pr3Test {
	/*
	 * Testing firstLast6
	 */
	public void testFirstLast6_0() {
		int x[] = { 1, 2, 6 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_1() {
		int x[] = { 6, 1, 2, 3 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_2() {
		int x[] = { 13, 6, 1, 2, 6 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_3() {
		int x[] = { 3, 6 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_4() {
		int x[] = { 6 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_5() {
		int x[] = { 5, 6 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_6() {
		int x[] = { 1, 2, 3, 4, 6 };
		assertTrue(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_7() {
		int x[] = { 13, 6, 1, 2, 3 };
		assertFalse(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_8() {
		int x[] = { 3, 2, 1 };
		assertFalse(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_9() {
		int x[] = { 3, 6, 1 };
		assertFalse(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_10() {
		int x[] = { 3 };
		assertFalse(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_11() {
		int x[] = { 5, 5 };
		assertFalse(Hw4pr3.firstLast6(x));
	}

	@Test
	public void testFirstLast6_12() {
		int x[] = { 1, 2, 3, 4 };
		assertFalse(Hw4pr3.firstLast6(x));
	}

	/*
	 * testing sameFirstLast
	 */
	public void testSameFirstLast_0() {
		int[] x = { 1, 2, 3 };
		assertFalse(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_1() {
		int[] x = {};
		assertFalse(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_2() {
		int[] x = { 1, 2, 3, 4, 5, 13 };
		assertFalse(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_3() {
		int[] x = { 1, 2, 3, 1 };
		assertTrue(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_4() {
		int[] x = { 1, 2, 1 };
		assertTrue(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_5() {
		int[] x = { 7 };
		assertTrue(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_6() {
		int[] x = { 1, 2, 3, 4, 5, 1 };
		assertTrue(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_7() {
		int[] x = { 13, 2, 3, 4, 5, 13 };
		assertTrue(Hw4pr3.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_8() {
		int[] x = { 7, 7 };
		assertTrue(Hw4pr3.sameFirstLast(x));
	}

        /*
	 * Testing makePi
	 */
	public void testMakePi() {
		int x[] = { 3, 1, 4 };
		assertTrue(Arrays.equals(x, Hw4pr3.makePi()));
	}

	/*
	 * testing commonEnd 
	 */
	public void testCommonEnd_0() {
		int[] x = { 1, 2, 3 };
		int[] y = { 7, 3 };
		assertTrue(Hw4pr3.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_1() {
		int[] x = { 1, 2, 3 };
		int[] y = { 1, 3 };
		assertTrue(Hw4pr3.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_2() {
		int[] x = { 1, 2, 3 };
		int[] y = { 1 };
		assertTrue(Hw4pr3.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_3() {
		int[] x = { 1, 2, 3 };
		int[] y = { 7, 3, 2 };
		assertFalse(Hw4pr3.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_4() {
		int[] x = { 1, 2, 3 };
		int[] y = { 2 };
		assertFalse(Hw4pr3.commonEnd(x, y));
	}

	/*
	 * testing sum3 
	 */
	public void testSum3_0() {
		int[] x = { 1, 2, 3 };
		assertTrue(Hw4pr3.sum3(x) == 6);
	}

	@Test
	public void testSum3_1() {
		int[] x = { 5, 11, 2 };
		assertTrue(Hw4pr3.sum3(x) == 18);
	}

	@Test
	public void testSum3_2() {
		int[] x = { 7, 0, 0 };
		assertTrue(Hw4pr3.sum3(x) == 7);
	}

	@Test
	public void testSum3_3() {
		int[] x = { 1, 2, 1 };
		assertTrue(Hw4pr3.sum3(x) == 4);
	}

	@Test
	public void testSum3_4() {
		int[] x = { 1, 1, 1 };
		assertTrue(Hw4pr3.sum3(x) == 3);
	}

	@Test
	public void testSum3_5() {
		int[] x = { 2, 7, 2 };
		assertTrue(Hw4pr3.sum3(x) == 11);
	}

	/*
	 * testing rotateLeft3
	 */
	public void testRotateLeft3_0() {
		int[] x = { 1, 2, 3 };
		int[] y = { 2, 3, 1 };
		assertTrue(Arrays.equals(Hw4pr3.rotateLeft3(x), y));
	}

	@Test
	public void testRotateLeft3_1() {
		int[] x = { 5, 11, 9 };
		int[] y = { 11, 9, 5 };
		assertTrue(Arrays.equals(Hw4pr3.rotateLeft3(x), y));
	}

	@Test
	public void testRotateLeft3_2() {
		int[] x = { 7, 0, 0 };
		int[] y = { 0, 0, 7 };
		assertTrue(Arrays.equals(Hw4pr3.rotateLeft3(x), y));
	}

	@Test
	public void testRotateLeft3_3() {
		int[] x = { 1, 2, 1 };
		int[] y = { 2, 1, 1 };
		assertTrue(Arrays.equals(Hw4pr3.rotateLeft3(x), y));
	}

	@Test
	public void testRotateLeft3_4() {
		int[] x = { 0, 0, 1 };
		int[] y = { 0, 1, 0 };
		assertTrue(Arrays.equals(Hw4pr3.rotateLeft3(x), y));
	}

	/*
	 * testing countEvens
	 */
	public void testCountEvens_0() {
		int[] x = { 2, 1, 2, 3, 4 };
		assertTrue(Hw4pr3.countEvens(x) == 3);
	}

	@Test
	public void testCountEvens_1() {
		int[] x = { 2, 2, 0 };
		assertTrue(Hw4pr3.countEvens(x) == 3);
	}

	@Test
	public void testCountEvens_2() {
		int[] x = { 1, 3, 5 };
		assertTrue(Hw4pr3.countEvens(x) == 0);
	}

	@Test
	public void testCountEvens_3() {
		int[] x = {};
		assertTrue(Hw4pr3.countEvens(x) == 0);
	}

	@Test
	public void testCountEvens_4() {
		int[] x = { 11, 9, 0, 1 };
		assertTrue(Hw4pr3.countEvens(x) == 1);
	}

	@Test
	public void testCountEvens_5() {
		int[] x = { 2, 11, 9, 0 };
		assertTrue(Hw4pr3.countEvens(x) == 2);
	}

	@Test
	public void testCountEvens_6() {
		int[] x = { 2 };
		assertTrue(Hw4pr3.countEvens(x) == 1);
	}

	@Test
	public void testCountEvens_7() {
		int[] x = { 2, 5, 12 };
		assertTrue(Hw4pr3.countEvens(x) == 2);
	}

	/*
	 * Test bigDiff
	 */
	public void testBigDiff_0() {
		int[] x = { 10, 3, 5, 6 };
		assertTrue(Hw4pr3.bigDiff(x) == 7);
	}

	@Test
	public void testBigDiff_1() {
		int[] x = { 7, 2, 10, 9 };
		assertTrue(Hw4pr3.bigDiff(x) == 8);
	}

	@Test
	public void testBigDiff_2() {
		int[] x = { 2, 10, 7, 2 };
		assertTrue(Hw4pr3.bigDiff(x) == 8);
	}

	@Test
	public void testBigDiff_3() {
		int[] x = { 2, 10 };
		assertTrue(Hw4pr3.bigDiff(x) == 8);
	}

	@Test
	public void testBigDiff_4() {
		int[] x = { 10, 2 };
		assertTrue(Hw4pr3.bigDiff(x) == 8);
	}

	@Test
	public void testBigDiff_5() {
		int[] x = { 10, 0 };
		assertTrue(Hw4pr3.bigDiff(x) == 10);
	}

	@Test
	public void testBigDiff_6() {
		int[] x = { 2, 3 };
		assertTrue(Hw4pr3.bigDiff(x) == 1);
	}

	@Test
	public void testBigDiff_7() {
		int[] x = { 7, 7, 6, 8, 5, 5, 6 };
		assertTrue(Hw4pr3.bigDiff(x) == 3);
	}

	@Test
	public void testBigDiff_8() {
		int[] x = { 2, 2 };
		assertTrue(Hw4pr3.bigDiff(x) == 0);
	}

	@Test
	public void testBigDiff_9() {
		int[] x = { 5, 1, 6, 1, 9, 9 };
		assertTrue(Hw4pr3.bigDiff(x) == 8);
	}

	@Test
	public void testBigDiff_10() {
		int[] x = { 7, 6, 8, 5 };
		assertTrue(Hw4pr3.bigDiff(x) == 3);
	}

	/*
	 * Testing centerdAverage
	 */
	public void testCenteredAverage_0() {
		int[] x = { -10, -4, -2, -4, -2, 0 };
		assertTrue(Hw4pr3.centeredAverage(x) == -3);
	}

	@Test
	public void testCenteredAverage_1() {
		int[] x = { 1, 1, 5, 5, 10, 8, 7 };
		assertTrue(Hw4pr3.centeredAverage(x) == 5);
	}

	@Test
	public void testCenteredAverage_2() {
		int[] x = { 5, 3, 4, 6, 2 };
		assertTrue(Hw4pr3.centeredAverage(x) == 4);
	}

	@Test
	public void testCenteredAverage_3() {
		int[] x = { 5, 3, 4, 0, 100 };
		assertTrue(Hw4pr3.centeredAverage(x) == 4);
	}

	@Test
	public void testCenteredAverage_4() {
		int[] x = { 100, 0, 5, 3, 4 };
		assertTrue(Hw4pr3.centeredAverage(x) == 4);
	}

	@Test
	public void testCenteredAverage_5() {
		int[] x = { 4, 0, 100 };
		assertTrue(Hw4pr3.centeredAverage(x) == 4);
	}

	@Test
	public void testCenteredAverage_6() {
		int[] x = { 0, 2, 3, 4, 100 };
		assertTrue(Hw4pr3.centeredAverage(x) == 3);
	}

	@Test
	public void testCenteredAverage_7() {
		int[] x = { 1, 1, 100 };
		assertTrue(Hw4pr3.centeredAverage(x) == 1);
	}

	@Test
	public void testCenteredAverage_8() {
		int[] x = { 7, 7, 7 };
		assertTrue(Hw4pr3.centeredAverage(x) == 7);
	}

	@Test
	public void testCenteredAverage_9() {
		int[] x = { 1, 7, 8 };
		assertTrue(Hw4pr3.centeredAverage(x) == 7);
	}

	@Test
	public void testCenteredAverage_10() {
		int[] x = { 1, 1, 99, 99 };
		assertTrue(Hw4pr3.centeredAverage(x) == 50);
	}

	@Test
	public void testCenteredAverage_11() {
		int[] x = { 1000, 0, 1, 99 };
		assertTrue(Hw4pr3.centeredAverage(x) == 50);
	}

	@Test
	public void testCenteredAverage_12() {
		int[] x = { 4, 4, 4, 4, 5 };
		assertTrue(Hw4pr3.centeredAverage(x) == 4);
	}

	@Test
	public void testCenteredAverage_13() {
		int[] x = { 4, 4, 4, 1, 5 };
		assertTrue(Hw4pr3.centeredAverage(x) == 4);
	}

	@Test
	public void testCenteredAverage_14() {
		int[] x = { 6, 4, 8, 12, 3 };
		assertTrue(Hw4pr3.centeredAverage(x) == 6);
	}

	@Test
	public void testCenteredAverage_15() {
		int[] x = { 1, 2, 3, 4, 100 };
		assertTrue(Hw4pr3.centeredAverage(x) == 3);
	}


}
