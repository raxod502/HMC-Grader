import static org.junit.Assert.*;

import org.junit.Test;

public class SkateboardTest {

  @Test
  public void testGetters() {
    Skateboard board = new Skateboard(10, 3.0, "Awesome skateboard");

    // test speed
    int speed = board.getSpeed();
    assertEquals(10, speed);

    // test diameter
    double diameter = board.getDiameter();
    assertEquals(3.0, diameter, 0.01);

    // test description
    String description = board.getDescription();
    assertEquals("Awesome skateboard", description);        
  }

  @Test
  public void testSetSpeed20(){
    Skateboard board = new Skateboard();
    board.setSpeed(20);
    int speed = board.getSpeed();
    assertEquals(20, speed);    
  }

  @Test
  public void testSetSpeed100(){
    Skateboard board = new Skateboard();
    board.setSpeed(100);
    int speed = board.getSpeed();
    assertEquals(100, speed);   
  }

  @Test
  public void testSetSpeed101(){
    Skateboard board = new Skateboard();
    int originalSpeed = 10;
    board.setSpeed(Skateboard.MAX_SPEED + 1);
    int speed = board.getSpeed();
    // if you try to set the speed to be greater than MAX_SPEED,
    // the speed doesn't change.
    assertEquals(originalSpeed, speed);   
  }

  @Test
  public void testSetDiameter(){
    Skateboard board = new Skateboard();
    board.setDiameter(3.14);
    double diameter = board.getDiameter();
    assertEquals(3.14, diameter, 0.01);
  }

  @Test
  public void testSetDescription(){
    Skateboard board = new Skateboard();
    board.setDescription("CS60-themed board");
    String description = board.getDescription();
    assertEquals("CS60-themed board", description);
  }

  @Test
  public void testIsFast10(){
    Skateboard board = new Skateboard();
    // a Skateboard is fast if the speed is at least FAST_SPEED
    assertTrue(board.isFast());
  }

  @Test
  public void testIsFast6(){
    Skateboard board = new Skateboard();
    board.setSpeed(2 * Skateboard.FAST_SPEED);
    // a Skateboard is fast if the speed is at least FAST_SPEED
    assertTrue(board.isFast());
  }

  @Test
  public void testIsFast5(){
    Skateboard board = new Skateboard();
    board.setSpeed(Skateboard.FAST_SPEED);
    // a Skateboard is fast if the speed is at least FAST_SPEED
    assertTrue(board.isFast());
  }

  @Test
  public void testIsFast4(){
    Skateboard board = new Skateboard();
    board.setSpeed(Skateboard.FAST_SPEED - 1);
    // a Skateboard is fast if the speed is at least FAST_SPEED
    assertFalse(board.isFast());
  }

  @Test
  public void testIsFast0(){
    Skateboard board = new Skateboard();
    board.setSpeed(0);
    // a Skateboard is fast if the speed is at least FAST_SPEED
    assertFalse(board.isFast());
  }
}