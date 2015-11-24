import static org.junit.Assert.*;

import org.junit.Test;

public class SkateboardTest {

  @Test
  public void testGetSpeed() {
    Skateboard board = new Skateboard();
    int speed = board.getSpeed();
    // speed should always start at 10
    assertEquals(10, speed);
  }

  @Test
  public void testGetDiameter() {
    Skateboard board = new Skateboard();
    double diameter = board.getDiameter();
    // Diameter should always start at 3.0 
    // include 0.01 as the margin of error in comparing doubles
    assertEquals(3.0, diameter, 0.01);
  }
  
  @Test
  public void testGetDescription() {
    Skateboard board = new Skateboard();
    String description = board.getDescription();
    // Description should always start as "Awesome skateboard"
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
    board.setSpeed(101);
    int speed = board.getSpeed();
    // if you try to set the speed to be greater than 100,
    // the speed doesn't change.
    assertEquals(originalSpeed, speed);   
  }
  @Test
  public void testSetDiameter(){
    Skateboard board = new Skateboard();
    board.setWheelDiameter(3.14);
    double diameter = board.getDiameter();
    // include 0.01 as the margin of error in comparing doubles
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
    // a Skateboard is fast if the speed is 5 or greater
    assertTrue(board.isFast());
  }
  @Test
  public void testIsFast6(){
    Skateboard board = new Skateboard();
    board.setSpeed(6);
    // a Skateboard is fast if the speed is 5 or greater
    assertTrue(board.isFast());
  }

  @Test
  public void testIsFast5(){
    Skateboard board = new Skateboard();
    board.setSpeed(5);
    // a Skateboard is fast if the speed is 5 or greater
    assertTrue(board.isFast());
  }

  @Test
  public void testIsFast4(){
    Skateboard board = new Skateboard();
    board.setSpeed(4);
    // a Skateboard is fast if the speed is 5 or greater
    assertFalse(board.isFast());
  }
  @Test
  public void testIsFast0(){
    Skateboard board = new Skateboard();
    board.setSpeed(0);
    // a Skateboard is fast if the speed is 5 or greater
    assertFalse(board.isFast());
  }

}