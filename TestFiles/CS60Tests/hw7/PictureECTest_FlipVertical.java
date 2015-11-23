import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest_FlipVertical {
  /*
   * Validate that flip(Picture.VERTICAL) works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testFlipVertical_Logos()
  {
    Picture pic     = Picture.loadPicture("Logos.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Logos_flipVertically.bmp");
    Picture picTest   = pic.flip(Picture.VERTICAL);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
  /*
   * Validate that flip(Picture.VERTICAL) works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testFlipVertical_Maria()
  {
    Picture pic     = Picture.loadPicture("Maria1.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Maria1_flipVertically.bmp");
    Picture picTest   = pic.flip(Picture.VERTICAL);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
}