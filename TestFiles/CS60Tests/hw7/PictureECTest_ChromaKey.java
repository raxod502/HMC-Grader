import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest_ChromaKey {
  /*
   * Validate that chromaKey works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testChromaKey_Logos()
  {
    Picture pic     = Picture.loadPicture("Logos.bmp");
    Picture bg      = Picture.loadPicture("Creek.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Logos_chromaKeyCreek.bmp");
    Picture picTest   = pic.chromaKey(118, 54, bg, 30);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
  /*
   * Validate that chromaKey works and does not modify the 
   * original Picture object.
   */
  @Test
  public void testChromaKey_Maria()
  {
    Picture pic     = Picture.loadPicture("Maria1.bmp");
    Picture bg      = Picture.loadPicture("HMC.bmp");
    Picture picCopy   = new Picture(pic);
    Picture picCorrect  = Picture.loadPicture("Maria1_ChromaKeyHMC.bmp");
    Picture picTest   = pic.chromaKey(118, 54, bg, 30);
    assertTrue(pic.equals(picCopy));
    assertTrue(picCorrect.equals(picTest));
  }
}