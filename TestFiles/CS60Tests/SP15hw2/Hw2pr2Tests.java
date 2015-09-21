import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Hw2pr2Test {

	/*
	 * Testing notString
	 */
        @Test 
	public void testNotString0() {
		assertTrue("notString failed! expected 'not candy', got "+Hw2pr2.notString("candy"),Hw2pr2.notString("candy").equals("not candy"));
	}
      
        @Test 
	public void testNotString1() {
		assertTrue("notString failed! expected 'not x', got "+Hw2pr2.notString("x"),Hw2pr2.notString("x").equals("not x"));
	}
        @Test 
	public void testNotString2() {
		assertTrue("notString failed! expected 'not bad', got "+Hw2pr2.notString("not bad"),Hw2pr2.notString("not bad").equals("not bad"));
	}
        @Test 
	public void testNotString3() {
		assertTrue("notString failed! expected 'not bad', got "+Hw2pr2.notString("bad"),Hw2pr2.notString("bad").equals("not bad"));
	}
        @Test 
	public void testNotString4() {
		assertTrue("notString failed! expected 'not', got "+Hw2pr2.notString("not"),Hw2pr2.notString("not").equals("not"));
	}
        @Test 
	public void testNotString5() {
		assertTrue("notString failed! expected 'not is not', got "+Hw2pr2.notString("is not"),Hw2pr2.notString("is not").equals("not is not"));
	}
        @Test 
	public void testNotString6() {
		assertTrue("notString failed! expected 'not no', got "+Hw2pr2.notString("no"),Hw2pr2.notString("no").equals("not no"));
	}

	/*
	 * Testing missingChar
	 */
        @Test 
	public void testMissingChar0() {
		assertTrue(Hw2pr2.missingChar("kitten", 1).equals("ktten"));
	}
        @Test 
	public void testMissingChar1() {
		assertTrue(Hw2pr2.missingChar("kitten", 0).equals("itten"));
	}
        @Test 
	public void testMissingChar2() {
		assertTrue(Hw2pr2.missingChar("kitten", 4).equals("kittn"));
	}
        @Test 
	public void testMissingChar3() {
		assertTrue(Hw2pr2.missingChar("Hi", 0).equals("i"));
	}
        @Test 
	public void testMissingChar4() {
		assertTrue(Hw2pr2.missingChar("Hi", 1).equals("H"));
	}
        @Test 
	public void testMissingChar5() {
		assertTrue(Hw2pr2.missingChar("code", 0).equals("ode"));
	}
        @Test 
	public void testMissingChar6() {
		assertTrue(Hw2pr2.missingChar("code", 1).equals("cde"));
	}
        @Test 
	public void testMissingChar7() {
		assertTrue(Hw2pr2.missingChar("code", 2).equals("coe"));
	}
        @Test 
	public void testMissingChar8() {
		assertTrue(Hw2pr2.missingChar("code", 3).equals("cod"));
	}
        @Test 
	public void testMissingChar9() {
		assertTrue(Hw2pr2.missingChar("chocolate", 8).equals("chocolat"));
	}
	/*
	 * Testing FrontBack
	 */
        @Test 
	public void testfrontBack0() {
		assertTrue(Hw2pr2.frontBack("code").equals("eodc"));
	}
        @Test 
	public void testfrontBack1() {
		assertTrue(Hw2pr2.frontBack("a").equals("a"));
	}
        @Test 
	public void testfrontBack2() {
		assertTrue(Hw2pr2.frontBack("ab").equals("ba"));
	}
        @Test 
	public void testfrontBack3() {
		assertTrue(Hw2pr2.frontBack("abc").equals("cba"));
	}
        @Test 
	public void testfrontBack4() {
		assertTrue(Hw2pr2.frontBack("").equals(""));
	}
        @Test 
	public void testfrontBack5() {
		assertTrue(Hw2pr2.frontBack("Chocolate").equals("ehocolatC"));
	}
        @Test 
	public void testfrontBack6() {
		assertTrue(Hw2pr2.frontBack("aavJ").equals("Java"));
	}
        @Test 
	public void testfrontBack7() {
		assertTrue(Hw2pr2.frontBack("hello").equals("oellh"));
	}

	/*
	 * Testing front3
	 */
        @Test 
	public void testfront3_0() {
		assertTrue(Hw2pr2.front3("Java").equals("JavJavJav"));
	}
        @Test 
	public void testfront3_1() {
		assertTrue(Hw2pr2.front3("Chocolate").equals("ChoChoCho"));
	}
        @Test 
	public void testfront3_2() {
		assertTrue(Hw2pr2.front3("abc").equals("abcabcabc"));
	}
        @Test 
	public void testfront3_3() {
		assertTrue(Hw2pr2.front3("abcXYZ").equals("abcabcabc"));
	}
        @Test 
	public void testfront3_4() {
		assertTrue(Hw2pr2.front3("ab").equals("ababab"));
	}
        @Test 
	public void testfront3_5() {
		assertTrue(Hw2pr2.front3("a").equals("aaa"));
	}
        @Test 
	public void testfront3_6() {
		assertTrue(Hw2pr2.front3("").equals(""));
	}
	
	/*
	 * Testing backAround
	 */
        @Test 
	public void testBackAround0() {
		assertTrue(Hw2pr2.backAround("cat").equals("tcatt"));
	}
        @Test 
	public void testBackAround1() {
		assertTrue(Hw2pr2.backAround("Hello").equals("oHelloo"));
	}
        @Test 
	public void testBackAround2() {
		assertTrue(Hw2pr2.backAround("a").equals("aaa"));
	}
        @Test 
	public void testBackAround3() {
		assertTrue(Hw2pr2.backAround("abc").equals("cabcc"));
	}
        @Test 
	public void testBackAround4() {
		assertTrue(Hw2pr2.backAround("read").equals("dreadd"));
	}
        @Test 
	public void testBackAround5() {
		assertTrue(Hw2pr2.backAround("boo").equals("obooo"));
	}
	/*
	 * Testing front22
	 */
        @Test 
	public void testfront22_0() {
		assertTrue(Hw2pr2.front22("kitten").equals("kikittenki"));
	}
        @Test 
	public void testfront22_1() {
		assertTrue(Hw2pr2.front22("Ha").equals("HaHaHa"));
	}
        @Test 
	public void testfront22_2() {
		assertTrue(Hw2pr2.front22("abc").equals("ababcab"));
	}
        @Test 
	public void testfront22_3() {
		assertTrue(Hw2pr2.front22("ab").equals("ababab"));
	}
        @Test 
	public void testfront22_4() {
		assertTrue(Hw2pr2.front22("a").equals("aaa"));
	}
        @Test 
	public void testfront22_5() {
		assertTrue(Hw2pr2.front22("").equals(""));
	}
        @Test 
	public void testfront22_6() {
		assertTrue(Hw2pr2.front22("Logic").equals("LoLogicLo"));
	}
	
	/*
	 * Testing startHi
	 */

        @Test 
	public void testStartHi0() {
		assertTrue(Hw2pr2.startHi("hi there"));
	}
        @Test 
	public void testStartHi1() {
		assertTrue(Hw2pr2.startHi("hi"));
	}
        @Test 
	public void testStartHi2() {
		assertTrue(Hw2pr2.startHi("hi ho"));
	}
        @Test 
	public void testStartHi3() {
		assertFalse(Hw2pr2.startHi("hello hi"));
	}
        @Test 
	public void testStartHi4() {
		assertFalse(Hw2pr2.startHi("he"));
	}
        @Test 
	public void testStartHi5() {
		assertFalse(Hw2pr2.startHi("h"));
	}
        @Test 
	public void testStartHi6() {
		assertFalse(Hw2pr2.startHi(""));
	}
        @Test 
	public void testStartHi7() {
		assertFalse(Hw2pr2.startHi("ho hi"));
	}
	
	/*
	 * Testing startOz
	 */
        @Test 
	public void testStartOz0() {
		assertTrue(Hw2pr2.startOz("ozymandias").equals("oz"));
	}
        @Test 
	public void testStartOz1() {
		assertTrue(Hw2pr2.startOz("bzoo").equals("z"));
	}
        @Test 
	public void testStartOz2() {
		assertTrue(Hw2pr2.startOz("oxx").equals("o"));
	}
        @Test 
	public void testStartOz3() {
		assertTrue(Hw2pr2.startOz("oz").equals("oz"));
	}
        @Test 
	public void testStartOz4() {
		assertTrue(Hw2pr2.startOz("ounce").equals("o"));
	}
        @Test 
	public void testStartOz5() {
		assertTrue(Hw2pr2.startOz("o").equals("o"));
	}
        @Test 
	public void testStartOz6() {
		assertTrue(Hw2pr2.startOz("abc").equals(""));
	}
        @Test 
	public void testStartOz7() {
		assertTrue(Hw2pr2.startOz("").equals(""));
	}
        @Test 
	public void testStartOz8() {
		assertTrue(Hw2pr2.startOz("zoo").equals(""));
	}
        @Test 
	public void testStartOz9() {
		assertTrue(Hw2pr2.startOz("aztec").equals("z"));
	}
        @Test 
	public void testStartOz10() {
		assertTrue(Hw2pr2.startOz("zzzz").equals("z"));
	}
        @Test 
	public void testStartOz11() {
		assertTrue(Hw2pr2.startOz("oznic").equals("oz"));
	}
	
}
