import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest_ShowEdges {
  /*
   * Validate that showEdges works and does not modify the 
   * original Picture object
   */
  @Test
  public void testShowEdges_Mickey()
  {
    Picture pic         = Picture.loadPicture("mickey.bmp");
    Picture picCopy     = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("mickey_showEdges.bmp");
    Picture picTest     = pic.showEdges(20);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
  /*
   * Validate that showEdges works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testShowEdges_Geese()
  {
    // These are geese painted by Maria Klawe
    Picture pic     = Picture.loadPicture("SnowGeese.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("SnowGeese_ShowEdges20.bmp");
    Picture picTest   = pic.showEdges(20);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
}