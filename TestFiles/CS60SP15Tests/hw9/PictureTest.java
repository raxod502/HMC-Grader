import org.junit.Test;
import static org.junit.Assert.*;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureTest {
	/*
	 * Validate that grayscale works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testGrayscale_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroGray.bmp");
		Picture picTest		= pic.grayscale();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testShowSeam_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroShowSeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroCarve.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve2_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroCarve2.bmp");
		Picture picTest		= pic.carveMany(2);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that luminosity() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testLuminosity_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroLum.bmp");
		Picture picTest		= pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that energy() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testEnergy_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroEnergy.bmp");
		Picture picTest		= pic.energy();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that grayscale works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testGrayscale()
	{
		Picture pic 		= Picture.loadPicture("Creek.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Creek_grayscale.bmp");
		Picture picTest		= pic.grayscale();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that negate works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testNegateCreek()
	{
		Picture pic 		= Picture.loadPicture("Creek.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Creek_negate.bmp");
		Picture picTest		= pic.negate();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that negate works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testNegateMaria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_negate.bmp");
		Picture picTest		= pic.negate();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that rotate(1) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate1_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_rotateRight_once.bmp");
		Picture picTest		= pic.rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that rotate(1) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate1_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_rotateRight_once.bmp");
		Picture picTest		= pic.rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that rotate(2) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate2_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_rotateRight_twice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that rotate(2) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate2_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_rotateRight_twice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that rotate(3) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate3_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_rotateRight_thrice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that rotate(3) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate3_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_rotateRight_thrice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}


	/*
	 * Tests the color changing a solid color:
	 * darken
	 */
	@Test
	public void testColorTranslationsDarker()
	{
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture darker = Picture.loadPicture("Gray_darker.bmp");
		assertTrue(darker.equals(pic.darken(30)));
			
	}
	/*
	 * Tests the color changing a solid color:
	 * lighten
	 */
	@Test
	public void testColorTranslationsLighter()
	{
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture lighter = Picture.loadPicture("Gray_lighter.bmp");
		assertTrue(lighter.equals(pic.lighten(30)));
			
	}
	/*
	 * Tests the color changing a solid color:
	 * addGreen
	 */
	@Test
	public void testColorTranslationsGreener()
	{
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture greener	= Picture.loadPicture("Gray_more_green.bmp");
		assertTrue(greener.equals(pic.addGreen(30)));
			
	}
	/*
	 * Tests the color changing a solid color:
	 * addBlue
	 */
	@Test
	public void testColorTranslationsBluer()
	{
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture bluer = Picture.loadPicture("Gray_more_blue.bmp");
		assertTrue(bluer.equals(pic.addBlue(30)));
			
	}
	/*
	 * Tests the color changing a solid color:
	 * addRed
	 */
	@Test
	public void testColorTranslationsReder()
	{
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture reder = Picture.loadPicture("Gray_more_red.bmp");
		assertTrue(reder.equals(pic.addRed(30)));	
			
	}

	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testShowSeam_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinySeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testShowSeam_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinySeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testShowSeam_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaSeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testShowSeam_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelSeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinyCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testCarve_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinyCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve5_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinyCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testCarve5_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinyCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve5_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve5_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}


	/*
	 * Validate that luminosity() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testLuminosity_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinyLuminosity.bmp");
		Picture picTest		= pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that luminosity() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testLuminosity_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinyLuminosity.bmp");
		Picture picTest		= pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that luminosity() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testLuminosity_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaLuminosity.bmp");
		Picture picTest		= pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that luminosity() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testLuminosity_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelLuminosity.bmp");
		Picture picTest		= pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	

	/*
	 * Validate that energy() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testEnergy_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinyEnergy.bmp");
		Picture picTest		= pic.energy();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that energy() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testEnergy_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinyEnergy.bmp");
		Picture picTest		= pic.energy();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that energy() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testEnergy_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaEnergy.bmp");
		Picture picTest		= pic.energy();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that energy() works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testEnergy_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelEnergy.bmp");
		Picture picTest		= pic.energy();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
}
