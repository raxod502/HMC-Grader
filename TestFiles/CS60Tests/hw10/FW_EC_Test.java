import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class FW_EC_Test {

  public static int INF = -1;  // this is a particularly small infinity...

  /**
   * graph0 or map0
   */
  public static int[][] graph0 =   // graph0 or map0
    { {0,     1, INF},
          {INF,   0,   1},
          {  1, INF,   0}  };

  @Test
  public void test_map0_0_to_2() {
    int[][] input_graph = FW_EC_Test.graph0;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(0, 2);
    int md1_exp = 2;
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map0_0_to_2_path() {
    int[][] input_graph = FW_EC_Test.graph0;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(0, 2);
    int[] md1_exp = {0, 1, 2};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map0_2_to_1() {
    int[][] input_graph = FW_EC_Test.graph0;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(2, 1);
    int md1_exp = 2;
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map0_2_to_1_path() {
    int[][] input_graph = FW_EC_Test.graph0;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(2, 1);
    int[] md1_exp = {2, 0, 1};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  /**
   * graph1 or map1
   */
  public static int[][] graph1 =   // graph1 or map1
    { {   0,   4,   2, INF },
      { INF,   0,   1, INF },
      { INF, INF,   0,   8 },
      {  16, INF, INF,   0 } };

  @Test
  public void test_map1_0_to_3() {
    int[][] input_graph = FW_EC_Test.graph1;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(0, 3);
    int md1_exp = 10;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map1_0_to_3_path() {
    int[][] input_graph = FW_EC_Test.graph1;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(0, 3);
    int[] md1_exp = {0, 2, 3};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map1_1_to_0() {
    int[][] input_graph = FW_EC_Test.graph1;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(1, 0);
    int md1_exp = 25;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map1_1_to_0_path() {
    int[][] input_graph = FW_EC_Test.graph1;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(1, 0);
    int[] md1_exp = {1, 2, 3, 0};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map1_2_to_1() {
    int[][] input_graph = FW_EC_Test.graph1;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(2, 1);
    int md1_exp = 28;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map1_2_to_1_path() {
    int[][] input_graph = FW_EC_Test.graph1;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(2, 1);
    int[] md1_exp = {2, 3, 0, 1};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  /**
   * graph2 or map2
   */
  public static int[][] graph2 =   // graph1 or map1
    { {   0,  14, INF, INF },
      { INF,   0,  14,  50 },
      { INF, INF,   0,  14 },
      {  10, INF, INF,   0 } };

  @Test
  public void test_map2_0_to_3() {
    int[][] input_graph = FW_EC_Test.graph2;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(0, 3);
    int md1_exp = 42;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map2_0_to_3_path() {
    int[][] input_graph = FW_EC_Test.graph2;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(0, 3);
    int[] md1_exp = {0, 1, 2, 3};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map2_2_to_1() {
    int[][] input_graph = FW_EC_Test.graph2;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(2, 1);
    int md1_exp = 38;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map2_2_to_1_path() {
    int[][] input_graph = FW_EC_Test.graph2;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(2, 1);
    int[] md1_exp = {2, 3, 0, 1};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map2_2_to_0() {
    int[][] input_graph = FW_EC_Test.graph2;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(2, 0);
    int md1_exp = 24;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map2_2_to_0_path() {
    int[][] input_graph = FW_EC_Test.graph2;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(2, 0);
    int[] md1_exp = {2, 3, 0};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  /**
   * graph3 or map3
   */
  public static int[][] graph3 = // graph3 or map3
    {{   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1},
     {   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0}};


  @Test
  public void test_map3_3_to_1() {
    int[][] input_graph = FW_EC_Test.graph3;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(3, 1);
    int md1_exp = 28;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map3_3_to_1_path() {
    int[][] input_graph = FW_EC_Test.graph3;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(3, 1);
    int[] md1_exp = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 0, 1 };
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map3_1_to_3() {
    int[][] input_graph = FW_EC_Test.graph3;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(1, 3);
    int md1_exp = 2;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map3_1_to_3_path() {
    int[][] input_graph = FW_EC_Test.graph3;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(1, 3);
    int[] md1_exp = {1, 2, 3};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map3_10_to_20() {
    int[][] input_graph = FW_EC_Test.graph3;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(10, 20);
    int md1_exp = 10;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map3_10_to_20_path() {
    int[][] input_graph = FW_EC_Test.graph3;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(10, 20);
    int[] md1_exp = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }



  /**
   * graph4 or map4
   */
  public static int[][] graph4 = // graph4 or map4
    {{   0,  12, INF,  16, INF, INF, INF, INF, INF, INF, INF, 100, INF, 119, INF, INF, INF, INF, INF, INF,  42, INF, INF, INF, INF, INF,  51, INF, INF, INF},
     { INF,   0,   1, INF, INF, INF, INF, INF, INF, INF,  99, INF, 201, INF, INF, INF, INF, INF, INF, INF,  41, INF, INF, INF, INF, INF, INF,  16, INF, 119},
     {  51, INF,   0,   1, INF,   9, INF, INF,  25, INF, INF,  76, INF, INF, INF,  45, INF, INF,  38,  31, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF,  26,   0,   1, INF,  26, INF, INF, INF,  29, INF, INF,  30, INF,  87, INF, INF, INF, INF, INF, INF, INF,  41, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {  30, INF,  17, INF, INF,   0,   1, INF, INF,  42, INF, INF,  42, INF, INF,  41, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF,  31, INF,  33, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF,  41, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF,  28, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF,  26, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF,  17, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF,  39, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF,  54, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF,  23, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF,  19, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF,  17, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1, INF},
     { INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0,   1},
     {   1, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF,   0}};


  @Test
  public void test_map4_15_to_6() {
    int[][] input_graph = FW_EC_Test.graph4;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(15, 6);
    int md1_exp = 23;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map4_15_to_6_path() {
    int[][] input_graph = FW_EC_Test.graph4;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(15, 6);
    int[] md1_exp = {15, 16, 17, 18, 5, 6};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }


  @Test
  public void test_map4_16_to_4() {
    int[][] input_graph = FW_EC_Test.graph4;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(16, 4);
    int md1_exp = 24;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

  @Test
  public void test_map4_16_to_4_path() {
    int[][] input_graph = FW_EC_Test.graph4;
    FW_EC fw = new FW_EC(input_graph);
    int[] md1_act = fw.path(16, 4);
    int[] md1_exp = {16, 3, 4};
    //System.out.println( "Exp: " + Arrays.toString( md1_exp ) );
    //System.out.println( "Act: " + Arrays.toString( md1_act ) );
    assertTrue( Arrays.equals(md1_exp, md1_act) );
  }

  @Test
  public void test_map4_17_to_4() {
    int[][] input_graph = FW_EC_Test.graph4;
    FW_EC fw = new FW_EC(input_graph);
    int md1_act = fw.minDistance(17, 4);
    int md1_exp = 28;
    //System.out.println( "Exp: " + md1_exp );
    //System.out.println( "Act: " + md1_act );
    assertEquals(md1_exp,md1_act);
  }

}
