import static org.junit.Assert.*;
import org.junit.Test;
 
public class RectangleTest {


	
	@Test
	public void testCorneredRectangle1() {
		Rectangle cr = new CorneredRectangle(2,3,6,7);
		testGeometry(cr,2,3,6,7);
	}

	@Test
	public void testCorneredRectangle2() {
		Rectangle cr = new CorneredRectangle(2,3,6,7);
		testMove(cr);
	}

	@Test
	public void testCorneredRectangle3() {
		Rectangle cr = new CorneredRectangle(2,3,6,7);
		testInterior(cr);
	}

	@Test
	public void testCorneredRectangle4() {
		Rectangle cr1 = new CorneredRectangle(0,0,2,2);
		testOverlaps0022(cr1);
	}
	
	@Test
	public void testCorneredRectangle5() {
		Rectangle cr1 = new CorneredRectangle(0,0,2,2);
		Rectangle cr2 = new CorneredRectangle(-1,0.5,4,1.5);
		assertTrue(cr1.overlaps(cr2));
	}
	
	@Test
	public void testSizedRectangle1() {
		SizedRectangle sr = new SizedRectangle(2,4,4,8);
		testGeometry(sr,0,0,4,8);
	}
	
	@Test
	public void testSizedRectangle2() {
		SizedRectangle sr = new SizedRectangle(1,2,3,4);
		testMove(sr);
	}
		
	@Test
	public void testSizedRectangle3() {
		SizedRectangle sr = new SizedRectangle(1,2,3,4);
		testInterior(sr);
	}

	@Test
	public void testSizedRectangle4() {
		SizedRectangle sr = new SizedRectangle(1,1,2,2);
		testOverlaps0022(sr);
	}
	
	@Test
	public void testSizedRectangle5() {
		SizedRectangle sr1 = new SizedRectangle(1,1,2,2);
		SizedRectangle sr2 = new SizedRectangle(5,1,20,1);
		assertTrue(sr1.overlaps(sr2));
	}
	
	// Helper function for any rectangle.
	// Expects the lower left coordinates (llx,lly)
	//   and upper-right coordinates (urx, ury), 
	//   even if that's not how the rectangle is
	//   internally represented.
	private static void testGeometry(Rectangle r, 
			                         double llx, double lly,
			                         double urx, double ury) {
		// Sanity-check the inputs
		assertTrue(llx <= urx);
		assertTrue(lly <= ury);
		
		// Check the corners
		assertTrue(r.lowerLeft().getX() == llx);
		assertTrue(r.lowerLeft().getY() == lly);
		assertTrue(r.upperRight().getX() == urx);
		assertTrue(r.upperRight().getY() == ury);
		assertTrue(r.lowerRight().getX() == urx);
		assertTrue(r.lowerRight().getY() == lly);
		assertTrue(r.upperLeft().getX() == llx);
		assertTrue(r.upperLeft().getY() == ury);
		
		// Check the center
		assertTrue(r.center().getX() == (llx+urx)/2.0);
		assertTrue(r.center().getY() == (lly+ury)/2.0);
		
		// Check the width
		assertTrue(r.width() == (urx - llx));
		assertTrue(r.height() == (ury - lly));
	}
	
	// Helper function to test any rectangle
	private static void testMove(Rectangle r) {
		Point ll = r.lowerLeft();
		Point ur = r.upperRight();
		Point c  = r.center();
		double wd = r.width();
		double ht = r.height();
		
		r.move(0., 0.);  // Nothing should change
		assertTrue(r.lowerLeft().equals(ll));
		assertTrue(r.upperRight().equals(ur));
		assertTrue(r.center().equals(c));
		assertTrue(r.width() == wd);
		assertTrue(r.height() == ht);
		
		double dx = 10.0;  // how much to move.
		double dy = -10.0;
		r.move(dx, dy);  
		Point newll = new Point(ll.getX() + dx, ll.getY() + dy);
		Point newur = new Point(ur.getX() + dx, ur.getY() + dy);
		Point newc  = new Point(c.getX() + dx, c.getY() + dy);
		assertTrue(r.lowerLeft().equals(newll));
		assertTrue(r.upperRight().equals(newur));
		assertTrue(r.center().equals(newc));
		assertTrue(r.width() == wd);  // no change in size
		assertTrue(r.height() == ht);
	}
	
	// Helper function to test any non-empty rectangle
	private static void testInterior(Rectangle r) {
		assertTrue(r.interior(r.center()));
		assertFalse(r.interior(r.lowerRight()));
		assertFalse(r.interior(r.upperLeft()));
		assertFalse(r.interior(r.upperLeft().offset(0,1)));
		assertFalse(r.interior(r.lowerLeft().offset(0,-1)));
		assertFalse(r.interior(r.upperRight().offset(1, 0)));
		assertFalse(r.interior(r.lowerRight().offset(1, 1)));
		assertTrue(r.interior(r.lowerLeft().offset(r.width()/4, r.height()/10)));
	}
	
	// Helper function to test any rectangle covering (0,0) to (2,2)
	private static void testOverlaps0022(Rectangle r0022) {
		Rectangle r3 = new CorneredRectangle(0,2,4,4);
	    Rectangle r4 = new CorneredRectangle(-1,1,4,4);
	    Rectangle r5 = new CorneredRectangle(0,1,3,3);
	    
	    assertFalse(r0022.overlaps(r3));
	    assertFalse(r3.overlaps(r0022));
	    assertTrue(r0022.overlaps(r4));
	    assertTrue(r4.overlaps(r0022));
	    assertTrue(r0022.overlaps(r5));
	    assertTrue(r5.overlaps(r0022));    
	}
}
