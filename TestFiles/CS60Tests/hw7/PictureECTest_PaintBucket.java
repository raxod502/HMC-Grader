import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest_PaintBucket {
  /*
   * Validate that paintBucket works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testPaintBucket()
  {
    Picture pic     = Picture.loadPicture("Maria1.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Maria_paintBucket.bmp");
    Picture picTest   = pic.paintBucket(118, 54, 30, new Color(0, 255, 0));
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }

}