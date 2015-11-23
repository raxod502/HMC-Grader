import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest_Blur {
  /*
   * Validate that blur works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testNoBlur()
  {
    Picture pic     = Picture.loadPicture("Creek.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Creek.bmp");
    Picture picTest   = pic.blur(0);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }

  @Test
  public void testBlur()
  {
    Picture pic     = Picture.loadPicture("Creek.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Creek_blur.bmp");
    Picture picTest   = pic.blur(3);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
}