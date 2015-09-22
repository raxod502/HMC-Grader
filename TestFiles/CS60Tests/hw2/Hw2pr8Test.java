import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Hw2pr8Test {

  /*
   * Testing arrayCount9
   */
  // Source: http://codingbat.com/prob/p184031  
  @Test
  public void testArrayCount9_1() {
    int[] arr = {1, 2, 9};
    assertTrue(Hw2pr8.arrayCount9(arr)== 1);  
  }  
  @Test
  public void testArrayCount9_2() {
    int[] arr = {1, 9, 9};
    assertTrue(Hw2pr8.arrayCount9(arr)== 2);  
  }  
  @Test
  public void testArrayCount9_3() {
    int[] arr = {1, 9, 9, 3, 9};
    assertTrue(Hw2pr8.arrayCount9(arr)== 3);  
  }  
  @Test
  public void testArrayCount9_4() {
    int[] arr = {1, 2, 3};
    assertTrue(Hw2pr8.arrayCount9(arr)== 0);  
  }  
  @Test
  public void testArrayCount9_5() {
    int[] arr = {};
    assertTrue(Hw2pr8.arrayCount9(arr)== 0);  
  }  
  @Test
  public void testArrayCount9_6() {
    int[] arr = {4, 2, 4, 3, 1};
    assertTrue(Hw2pr8.arrayCount9(arr)== 0);  
  }  
  @Test
  public void testArrayCount9_7() {
    int[] arr = {9, 2, 4, 3, 1};
    assertTrue(Hw2pr8.arrayCount9(arr)== 1);  
  }
  /*
   * Testing arrayFront9
   */
  // Source: http://codingbat.com/prob/p186031  
  @Test
  public void testArrayFront9_1() {
    int[] arr = {1, 2, 9, 3, 4};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_2() {
    int[] arr = {9, 2, 3};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_3() {
    int[] arr = {1, 9, 9};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_4() {
    int[] arr = {1, 9};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_5() {
    int[] arr = {9};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }  
  @Test
  public void testArrayFront9_6() {
    int[] arr = {3, 9, 2, 3, 3};
    assertTrue(Hw2pr8.arrayFront9(arr));      
  }   
  @Test
  public void testArrayFront9_7() {
    int[] arr = {5, 5};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_8() {
    int[] arr = {2};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_9() {
    int[] arr = {1, 2, 3, 4, 9};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_10() {
    int[] arr = {1, 2, 3, 4, 5};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_11() {
    int[] arr = {1, 2, 3};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }  
  @Test
  public void testArrayFront9_12() {
    int[] arr = {};
    assertFalse(Hw2pr8.arrayFront9(arr));     
  }
  /*
   * Testing array123
   */
  // Source: http://codingbat.com/prob/p136041  
  @Test
  public void testArray123_1() {
    int[] arr = {1, 1, 2, 3, 1};
    assertTrue(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_2() {
    int[] arr = {1, 1, 2, 1, 2, 3};
    assertTrue(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_3() {
    int[] arr = {1, 2, 3, 1, 2, 3};
    assertTrue(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_4() {
    int[] arr = {1, 2, 3};
    assertTrue(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_5() {
    int[] arr = {1, 1, 2, 4, 1};
    assertFalse(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_6() {
    int[] arr = {1, 1, 2, 1, 2, 1};
    assertFalse(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_7() {
    int[] arr = {1, 1, 1};
    assertFalse(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_8() {
    int[] arr = {1, 2};
    assertFalse(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_9() {
    int[] arr = {1};
    assertFalse(Hw2pr8.array123(arr));
  }  
  @Test
  public void testArray123_10() {
    int[] arr = {};
    assertFalse(Hw2pr8.array123(arr));
  }

  /*
   * Testing array667
   */
  // Source: http://codingbat.com/prob/p110019  
  @Test
  public void testArray667_1() {
    int[] arr = {1, 6, 3};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_2() {
    int[] arr = {6, 1};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_3() {
    int[] arr = {};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_4() {
    int[] arr = {1, 2, 3, 5, 6};
    assertTrue(Hw2pr8.array667(arr)== 0);
  }   
  @Test
  public void testArray667_5() {
    int[] arr = {6, 6, 2};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_6() {
    int[] arr = {6, 6, 2, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_7() {
    int[] arr = {6, 7, 2, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_8() {
    int[] arr = {3, 6, 7, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_9() {
    int[] arr = {6, 3, 6, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_10() {
    int[] arr = {1, 2, 3, 6, 6};
    assertTrue(Hw2pr8.array667(arr)== 1);
  }   
  @Test
  public void testArray667_11() {
    int[] arr = {6, 6, 2, 6, 7};
    assertTrue(Hw2pr8.array667(arr)== 2);
  }   
  @Test
  public void testArray667_12() {
    int[] arr = {3, 6, 6, 7};
    assertTrue(Hw2pr8.array667(arr)== 2);
  }   
  @Test
  public void testArray667_13() {
    int[] arr = {6, 7, 6, 6};
    assertTrue(Hw2pr8.array667(arr)== 2);
  } 
  /*
   * Testing noTriples
   */
  // Source: http://codingbat.com/prob/p170221  
  @Test
  public void testNoTriples_1() {
    int[] arr = {1, 1, 2, 2, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_2() {
    int[] arr = {1, 1, 2, 2, 1, 2, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_3() {
    int[] arr = {1, 2, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_4() {
    int[] arr = {1, 1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_5() {
    int[] arr = {1};
    assertTrue(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_6() {
    int[] arr = {};
    assertTrue(Hw2pr8.noTriples(arr));
  }   
  @Test
  public void testNoTriples_7() {
    int[] arr = {1, 1, 2, 2, 2, 1};
    assertFalse(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_8() {
    int[] arr = {1, 1, 1, 2, 2, 2, 1};
    assertFalse(Hw2pr8.noTriples(arr));
  }  
  @Test
  public void testNoTriples_9() {
    int[] arr = {1, 1, 1};
    assertFalse(Hw2pr8.noTriples(arr));
  }
  /*
   * Testing has271
   */
  // Source: http://codingbat.com/prob/p167430  
  @Test
  public void testHas271_1() {
    int[] arr = {1, 2, 7, 1};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_2() {
    int[] arr = {2, 7, 1};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_3() {
    int[] arr = {3, 8, 2};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_4() {
    int[] arr = {2, 7, 3};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_5() {
    int[] arr = {2, 7, -1};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_6() {
    int[] arr = {4, 5, 3, 8, 0};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_7() {
    int[] arr = {2, 7, 5, 10, 4};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_8() {
    int[] arr = {2, 7, -2, 4, 9, 3};
    assertTrue(Hw2pr8.has271(arr)); 
  }  
  @Test
  public void testHas271_9() {
    int[] arr = {1, 2, 8, 1};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_10() {
    int[] arr = {2, 7, 4};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_11() {
    int[] arr = {2, 7, -2};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_12() {
    int[] arr = {2, 7, 5, 10, 1};
    assertFalse(Hw2pr8.has271(arr));  
  }  
  @Test
  public void testHas271_13() {
    int[] arr = {2, 7, -2, 4, 10, 2};
    assertFalse(Hw2pr8.has271(arr));  
  }
  /*
   * Testing firstLast6
   */  
  @Test
  public void testFirstLast6_0() {
    int x[] = { 1, 2, 6 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_1() {
    int x[] = { 6, 1, 2, 3 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_2() {
    int x[] = { 13, 6, 1, 2, 6 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_3() {
    int x[] = { 3, 6 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_4() {
    int x[] = { 6 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_5() {
    int x[] = { 5, 6 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_6() {
    int x[] = { 1, 2, 3, 4, 6 };
    assertTrue(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_7() {
    int x[] = { 13, 6, 1, 2, 3 };
    assertFalse(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_8() {
    int x[] = { 3, 2, 1 };
    assertFalse(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_9() {
    int x[] = { 3, 6, 1 };
    assertFalse(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_10() {
    int x[] = { 3 };
    assertFalse(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_11() {
    int x[] = { 5, 5 };
    assertFalse(Hw2pr8.firstLast6(x));
  }
  
  @Test
  public void testFirstLast6_12() {
    int x[] = { 1, 2, 3, 4 };
    assertFalse(Hw2pr8.firstLast6(x));
  }

  /*
   * testing sameFirstLast
   */  
  @Test
  public void testSameFirstLast_0() {
    int[] x = { 1, 2, 3 };
    assertFalse(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_1() {
    int[] x = {};
    assertFalse(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_2() {
    int[] x = { 1, 2, 3, 4, 5, 13 };
    assertFalse(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_3() {
    int[] x = { 1, 2, 3, 1 };
    assertTrue(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_4() {
    int[] x = { 1, 2, 1 };
    assertTrue(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_5() {
    int[] x = { 7 };
    assertTrue(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_6() {
    int[] x = { 1, 2, 3, 4, 5, 1 };
    assertTrue(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_7() {
    int[] x = { 13, 2, 3, 4, 5, 13 };
    assertTrue(Hw2pr8.sameFirstLast(x));
  }
  
  @Test
  public void testSameFirstLast_8() {
    int[] x = { 7, 7 };
    assertTrue(Hw2pr8.sameFirstLast(x));
  }
  /*
   * Testing makePi
   */  
  @Test
  public void testMakePi() {
    int x[] = { 3, 1, 4 };
    assertTrue(Arrays.equals(x, Hw2pr8.makePi()));
  }

  /*
   * testing commonEnd 
   */  
  @Test
  public void testCommonEnd_0() {
    int[] x = { 1, 2, 3 };
    int[] y = { 7, 3 };
    assertTrue(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_1() {
    int[] x = { 1, 2, 3 };
    int[] y = { 1, 3 };
    assertTrue(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_2() {
    int[] x = { 1, 2, 3 };
    int[] y = { 1 };
    assertTrue(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_3() {
    int[] x = { 1, 2, 3 };
    int[] y = { 7, 3, 2 };
    assertFalse(Hw2pr8.commonEnd(x, y));
  }
  
  @Test
  public void testCommonEnd_4() {
    int[] x = { 1, 2, 3 };
    int[] y = { 2 };
    assertFalse(Hw2pr8.commonEnd(x, y));
  }

  /*
   * testing sum3 
   */  
  @Test
  public void testSum3_0() {
    int[] x = { 1, 2, 3 };
    assertTrue(Hw2pr8.sum3(x) == 6);
  }
  
  @Test
  public void testSum3_1() {
    int[] x = { 5, 11, 2 };
    assertTrue(Hw2pr8.sum3(x) == 18);
  }
  
  @Test
  public void testSum3_2() {
    int[] x = { 7, 0, 0 };
    assertTrue(Hw2pr8.sum3(x) == 7);
  }
  
  @Test
  public void testSum3_3() {
    int[] x = { 1, 2, 1 };
    assertTrue(Hw2pr8.sum3(x) == 4);
  }
  
  @Test
  public void testSum3_4() {
    int[] x = { 1, 1, 1 };
    assertTrue(Hw2pr8.sum3(x) == 3);
  }
  
  @Test
  public void testSum3_5() {
    int[] x = { 2, 7, 2 };
    assertTrue(Hw2pr8.sum3(x) == 11);
  }

  /*
   * testing rotateLeft3
   */  
  @Test
  public void testRotateLeft3_0() {
    int[] x = { 1, 2, 3 };
    int[] y = { 2, 3, 1 };
    assertTrue(Arrays.equals(Hw2pr8.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_1() {
    int[] x = { 5, 11, 9 };
    int[] y = { 11, 9, 5 };
    assertTrue(Arrays.equals(Hw2pr8.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_2() {
    int[] x = { 7, 0, 0 };
    int[] y = { 0, 0, 7 };
    assertTrue(Arrays.equals(Hw2pr8.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_3() {
    int[] x = { 1, 2, 1 };
    int[] y = { 2, 1, 1 };
    assertTrue(Arrays.equals(Hw2pr8.rotateLeft3(x), y));
  }
  
  @Test
  public void testRotateLeft3_4() {
    int[] x = { 0, 0, 1 };
    int[] y = { 0, 1, 0 };
    assertTrue(Arrays.equals(Hw2pr8.rotateLeft3(x), y));
  }

  /*
   * testing countEvens
   */  
  @Test
  public void testCountEvens_0() {
    int[] x = { 2, 1, 2, 3, 4 };
    assertTrue(Hw2pr8.countEvens(x) == 3);
  }
  
  @Test
  public void testCountEvens_1() {
    int[] x = { 2, 2, 0 };
    assertTrue(Hw2pr8.countEvens(x) == 3);
  }
  
  @Test
  public void testCountEvens_2() {
    int[] x = { 1, 3, 5 };
    assertTrue(Hw2pr8.countEvens(x) == 0);
  }
  
  @Test
  public void testCountEvens_3() {
    int[] x = {};
    assertTrue(Hw2pr8.countEvens(x) == 0);
  }
  
  @Test
  public void testCountEvens_4() {
    int[] x = { 11, 9, 0, 1 };
    assertTrue(Hw2pr8.countEvens(x) == 1);
  }
  
  @Test
  public void testCountEvens_5() {
    int[] x = { 2, 11, 9, 0 };
    assertTrue(Hw2pr8.countEvens(x) == 2);
  }
  
  @Test
  public void testCountEvens_6() {
    int[] x = { 2 };
    assertTrue(Hw2pr8.countEvens(x) == 1);
  }
  
  @Test
  public void testCountEvens_7() {
    int[] x = { 2, 5, 12 };
    assertTrue(Hw2pr8.countEvens(x) == 2);
  }

  /*
   * Test bigDiff
   */  
  @Test
  public void testBigDiff_0() {
    int[] x = { 10, 3, 5, 6 };
    assertTrue(Hw2pr8.bigDiff(x) == 7);
  }
  
  @Test
  public void testBigDiff_1() {
    int[] x = { 7, 2, 10, 9 };
    assertTrue(Hw2pr8.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_2() {
    int[] x = { 2, 10, 7, 2 };
    assertTrue(Hw2pr8.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_3() {
    int[] x = { 2, 10 };
    assertTrue(Hw2pr8.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_4() {
    int[] x = { 10, 2 };
    assertTrue(Hw2pr8.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_5() {
    int[] x = { 10, 0 };
    assertTrue(Hw2pr8.bigDiff(x) == 10);
  }
  
  @Test
  public void testBigDiff_6() {
    int[] x = { 2, 3 };
    assertTrue(Hw2pr8.bigDiff(x) == 1);
  }
  
  @Test
  public void testBigDiff_7() {
    int[] x = { 7, 7, 6, 8, 5, 5, 6 };
    assertTrue(Hw2pr8.bigDiff(x) == 3);
  }
  
  @Test
  public void testBigDiff_8() {
    int[] x = { 2, 2 };
    assertTrue(Hw2pr8.bigDiff(x) == 0);
  }
  
  @Test
  public void testBigDiff_9() {
    int[] x = { 5, 1, 6, 1, 9, 9 };
    assertTrue(Hw2pr8.bigDiff(x) == 8);
  }
  
  @Test
  public void testBigDiff_10() {
    int[] x = { 7, 6, 8, 5 };
    assertTrue(Hw2pr8.bigDiff(x) == 3);
  }

  /*
   * Testing centerdAverage
   */  
  @Test
  public void testCenteredAverage_0() {
    int[] x = { -10, -4, -2, -4, -2, 0 };
    assertTrue(Hw2pr8.centeredAverage(x) == -3);
  }
  
  @Test
  public void testCenteredAverage_1() {
    int[] x = { 1, 1, 5, 5, 10, 8, 7 };
    assertTrue(Hw2pr8.centeredAverage(x) == 5);
  }
  
  @Test
  public void testCenteredAverage_2() {
    int[] x = { 5, 3, 4, 6, 2 };
    assertTrue(Hw2pr8.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_3() {
    int[] x = { 5, 3, 4, 0, 100 };
    assertTrue(Hw2pr8.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_4() {
    int[] x = { 100, 0, 5, 3, 4 };
    assertTrue(Hw2pr8.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_5() {
    int[] x = { 4, 0, 100 };
    assertTrue(Hw2pr8.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_6() {
    int[] x = { 0, 2, 3, 4, 100 };
    assertTrue(Hw2pr8.centeredAverage(x) == 3);
  }
  
  @Test
  public void testCenteredAverage_7() {
    int[] x = { 1, 1, 100 };
    assertTrue(Hw2pr8.centeredAverage(x) == 1);
  }
  
  @Test
  public void testCenteredAverage_8() {
    int[] x = { 7, 7, 7 };
    assertTrue(Hw2pr8.centeredAverage(x) == 7);
  }
  
  @Test
  public void testCenteredAverage_9() {
    int[] x = { 1, 7, 8 };
    assertTrue(Hw2pr8.centeredAverage(x) == 7);
  }
  
  @Test
  public void testCenteredAverage_10() {
    int[] x = { 1, 1, 99, 99 };
    assertTrue(Hw2pr8.centeredAverage(x) == 50);
  }
  
  @Test
  public void testCenteredAverage_11() {
    int[] x = { 1000, 0, 1, 99 };
    assertTrue(Hw2pr8.centeredAverage(x) == 50);
  }
  
  @Test
  public void testCenteredAverage_12() {
    int[] x = { 4, 4, 4, 4, 5 };
    assertTrue(Hw2pr8.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_13() {
    int[] x = { 4, 4, 4, 1, 5 };
    assertTrue(Hw2pr8.centeredAverage(x) == 4);
  }
  
  @Test
  public void testCenteredAverage_14() {
    int[] x = { 6, 4, 8, 12, 3 };
    assertTrue(Hw2pr8.centeredAverage(x) == 6);
  }
  
  @Test
  public void testCenteredAverage_15() {
    int[] x = { 1, 2, 3, 4, 100 };
    assertTrue(Hw2pr8.centeredAverage(x) == 3);
  }
}
