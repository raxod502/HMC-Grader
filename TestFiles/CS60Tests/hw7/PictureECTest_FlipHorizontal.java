import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest_FlipHorizontal {

  /*
   * Validate that flip(Picture.HORIZONTAL) works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testFlipHorizontal_Logos()
  {
    Picture pic     = Picture.loadPicture("Logos.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Logos_flipHorizontally.bmp");
    Picture picTest   = pic.flip(Picture.HORIZONTAL);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
  /*
   * Validate that flip(Picture.HORIZONTAL) works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testFlipHorizontal_Maria()
  {
    Picture pic     = Picture.loadPicture("Maria1.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Maria1_flipHorizontally.bmp");
    Picture picTest   = pic.flip(Picture.HORIZONTAL);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }  
}