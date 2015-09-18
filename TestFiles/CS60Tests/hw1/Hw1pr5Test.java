import static org.junit.Assert.*;
import org.junit.Test;

/*
 * You will need to resolve the errors in this file by adding JUnit to the build path. 
 * You can watch the video about this starting from the relevant point here:
 * https://youtu.be/hhuhU2TFyKk?t=1m9s
 */ 
/*
 * You do not need to make any changes to this file and 
 * you do not need to submit the file. 
 * 
 * Test cases below are from CodingBat.com
 */

public class Hw1pr5Test {

	@Test
	public void testSleepIn() {
		assertTrue(Hw1pr5.sleepIn(false, false));
		assertFalse(Hw1pr5.sleepIn(true, false));
		assertTrue(Hw1pr5.sleepIn(false, true));
		assertTrue(Hw1pr5.sleepIn(true, true));
	}

	@Test
	public void testMakes10() {
		assertTrue(Hw1pr5.makes10(9, 10));
		assertTrue(Hw1pr5.makes10(1, 9));
		assertTrue(Hw1pr5.makes10(10, 1));
		assertTrue(Hw1pr5.makes10(10, 10));
		assertTrue(Hw1pr5.makes10(8, 2));
		assertTrue(Hw1pr5.makes10(10, 42));
		assertTrue(Hw1pr5.makes10(12, -2));
		assertFalse(Hw1pr5.makes10(9, 9));
		assertFalse(Hw1pr5.makes10(8, 3));
	}

	@Test
	public void testMonkeyTrouble() {
		assertTrue(Hw1pr5.monkeyTrouble(true, true));
		assertTrue(Hw1pr5.monkeyTrouble(false, false));
		assertFalse(Hw1pr5.monkeyTrouble(true, false));
		assertFalse(Hw1pr5.monkeyTrouble(false, true));
	}

	@Test
	public void testIn1020() {
		assertTrue(Hw1pr5.in1020(12, 99));
		assertTrue(Hw1pr5.in1020(21, 12));
		assertTrue(Hw1pr5.in1020(99, 10));
		assertTrue(Hw1pr5.in1020(20, 20));
		assertFalse(Hw1pr5.in1020(8, 99));
		assertFalse(Hw1pr5.in1020(21, 21));
		assertFalse(Hw1pr5.in1020(9, 9));
	}

	@Test
	public void testIcyHot() {
		assertTrue(Hw1pr5.icyHot(120, -1));
		assertTrue(Hw1pr5.icyHot(-1, 120));
		assertFalse(Hw1pr5.icyHot(2, 120));
		assertFalse(Hw1pr5.icyHot(-1, 100));
		assertFalse(Hw1pr5.icyHot(-2, -2));
		assertFalse(Hw1pr5.icyHot(120, 120));
	}

	@Test
	public void testHasTeen() {
		assertTrue(Hw1pr5.hasTeen(13, 20, 10));
		assertTrue(Hw1pr5.hasTeen(20, 19, 10));
		assertTrue(Hw1pr5.hasTeen(20, 10, 13));
		assertTrue(Hw1pr5.hasTeen(19, 20, 12));
		assertTrue(Hw1pr5.hasTeen(12, 20, 19));
		assertTrue(Hw1pr5.hasTeen(12, 18, 20));
		assertTrue(Hw1pr5.hasTeen(14, 2, 20));
		assertFalse(Hw1pr5.hasTeen(1, 20, 12));
		assertFalse(Hw1pr5.hasTeen(12, 9, 20));
		assertFalse(Hw1pr5.hasTeen(4, 2, 20));
		assertFalse(Hw1pr5.hasTeen(11, 22, 22));
	}

	@Test
	public void testLastDigit() {
		assertTrue(Hw1pr5.lastDigit(7, 17));
		assertTrue(Hw1pr5.lastDigit(3, 113));
		assertTrue(Hw1pr5.lastDigit(114, 4));
		assertTrue(Hw1pr5.lastDigit(10, 0));
		assertFalse(Hw1pr5.lastDigit(114, 113));
		assertFalse(Hw1pr5.lastDigit(6, 17));
		assertFalse(Hw1pr5.lastDigit(11, 0));
	}

	@Test
	public void testPosNeg() {
		assertTrue(Hw1pr5.posNeg(1, -1, false));
		assertTrue(Hw1pr5.posNeg(-1, 1, false));
		assertTrue(Hw1pr5.posNeg(-4, -5, true));
		assertTrue(Hw1pr5.posNeg(-4, 5, false));
		assertTrue(Hw1pr5.posNeg(-1, -1, true));
		assertTrue(Hw1pr5.posNeg(5, -5, false));
		assertTrue(Hw1pr5.posNeg(-6, 6, false));
		assertTrue(Hw1pr5.posNeg(-5, -5, true));
		assertFalse(Hw1pr5.posNeg(-4, -5, false));
		assertFalse(Hw1pr5.posNeg(-4, 5, true));
		assertFalse(Hw1pr5.posNeg(1, 1, false));
		assertFalse(Hw1pr5.posNeg(-1, -1, false));
		assertFalse(Hw1pr5.posNeg(1, -1, true));
		assertFalse(Hw1pr5.posNeg(-1, 1, true));
		assertFalse(Hw1pr5.posNeg(1, 1, true));
		assertFalse(Hw1pr5.posNeg(-5, -6, false));
		assertFalse(Hw1pr5.posNeg(-2, -1, false));
		assertFalse(Hw1pr5.posNeg(1, 2, false));
		assertFalse(Hw1pr5.posNeg(-5, 6, true));
	}

}
