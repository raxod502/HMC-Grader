import static org.junit.Assert.*;
import org.junit.Test;

public class Hw1pr3test {

	@Test
	public void test_sleepin() {
		assertTrue(Hw1pr3.sleepIn(false, false));
		assertTrue(Hw1pr3.sleepIn(false, true));
		assertFalse(Hw1pr3.sleepIn(true, false));
		assertTrue(Hw1pr3.sleepIn(true, true));
	}

	@Test
	public void test_makes10() {
		assertTrue(Hw1pr3.makes10(5,5));
		assertTrue(Hw1pr3.makes10(10,2));
		assertTrue(Hw1pr3.makes10(3,10));
		assertFalse(Hw1pr3.makes10(3,9));
	}

	@Test
	public void test_monkeyTrouble() {
		assertFalse(Hw1pr3.monkeyTrouble(true, false));
		assertFalse(Hw1pr3.monkeyTrouble(false, true));
		assertTrue(Hw1pr3.monkeyTrouble(true, true));
		assertTrue(Hw1pr3.monkeyTrouble(false, false));
	}

	@Test
	public void test_in1020() {
		assertTrue(Hw1pr3.in1020(10, 10));
		assertFalse(Hw1pr3.in1020(4, 25));
		assertTrue(Hw1pr3.in1020(23, 10));
		assertTrue(Hw1pr3.in1020(10, 23));
		assertFalse(Hw1pr3.in1020(25, 4));
	}

	@Test
	public void test_icyHot() {
		assertTrue(Hw1pr3.icyHot(-1, 101));
		assertTrue(Hw1pr3.icyHot(101, -1));
		assertFalse(Hw1pr3.icyHot(0, 100));
		assertFalse(Hw1pr3.icyHot(12, 141));
		assertFalse(Hw1pr3.icyHot(124, 14));
	}

	@Test
	public void test_hasTeen(){
		assertTrue(Hw1pr3.hasTeen(13,1,1));
		assertTrue(Hw1pr3.hasTeen(1,13,1));
		assertTrue(Hw1pr3.hasTeen(1,1,13));
		assertFalse(Hw1pr3.hasTeen(1,1,1));
	}

	@Test
	public void test_lastDigit(){
		assertTrue(Hw1pr3.lastDigit(10, 50));
		assertTrue(Hw1pr3.lastDigit(10818819, 5077859));
		assertFalse(Hw1pr3.lastDigit(12341223, 68534529));
		assertFalse(Hw1pr3.lastDigit(12, 68));
	}

	@Test
	public void test_posNeg(){
		assertTrue(Hw1pr3.posNeg(-3, 4, false));
		assertTrue(Hw1pr3.posNeg(3, -4, false));
		assertFalse(Hw1pr3.posNeg(-3, -4, false));
		assertFalse(Hw1pr3.posNeg(-3, 4, true));
		assertFalse(Hw1pr3.posNeg(3, 4, true));
		assertFalse(Hw1pr3.posNeg(3, 4, false));
	}
}
