import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

/**
 * A JUnit test case class. Every method starting with the word "test" will be
 * called when running the test with JUnit.
 */
public class ChangeTest {

  @Test
  public void test_MinCoins_1_5_10_27() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(27);
    int expected_num_coins = 5;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_10_10() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(10);
    int expected_num_coins = 1;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_10_142() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(142);
    int expected_num_coins = 16;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_10_0() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(0);
    int expected_num_coins = 0;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_9_10_12_18() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(18);
    int expected_num_coins = 2;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_9_10_12_19() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(19);
    int expected_num_coins = 2;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_9_10_12_20() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(20);
    int expected_num_coins = 2;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinCoins_1_5_9_10_12_23() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(23);
    int expected_num_coins = 3;
    assertEquals(expected_num_coins, num_coins);
  }

  @Test
  public void test_MinChange_1_5_10_27() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(27);
    int expected_num_coins = 5;
    int[] coins = ch.makeChange(27);
    int[] expected_coins = { 1, 1, 5, 10, 10 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_10_10() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(10);
    int expected_num_coins = 1;
    int[] coins = ch.makeChange(10);
    int[] expected_coins = { 10 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_10_142() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(142);
    int expected_num_coins = 16;
    int[] coins = ch.makeChange(142);
    int[] expected_coins = { 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
        10, 10, 10, 10 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_10_0() {
    int[] coinTypes = { 1, 5, 10 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(0);
    int expected_num_coins = 0;
    int[] coins = ch.makeChange(0);
    int[] expected_coins = {}; // zero-element array!
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_9_10_12_18() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(18);
    int expected_num_coins = 2;
    int[] coins = ch.makeChange(18);
    int[] expected_coins = { 9, 9 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_9_10_12_19() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(19);
    int expected_num_coins = 2;
    int[] coins = ch.makeChange(19);
    int[] expected_coins = { 9, 10 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_9_10_12_20() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(20);
    int expected_num_coins = 2;
    int[] coins = ch.makeChange(20);
    int[] expected_coins = { 10, 10 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

  @Test
  public void test_MinChange_1_5_9_10_12_23() {
    int[] coinTypes = { 1, 5, 9, 10, 12 };
    Change ch = new Change(coinTypes);
    int num_coins = ch.minCoins(23);
    int expected_num_coins = 3;
    int[] coins = ch.makeChange(23);
    int[] expected_coins = { 1, 10, 12 };
    assertEquals(expected_num_coins, num_coins);
    // System.out.println( "Exp: " + Arrays.toString( expected_coins ) );
    // System.out.println( "Act: " + Arrays.toString( coins ) );
    assertTrue(Arrays.equals(expected_coins, coins));
  }

}