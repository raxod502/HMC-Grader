import static org.junit.Assert.*;
import org.junit.Test;
 	
public class TollboothTest {

	@Test
	public void testTruck() {
		Truck t1 = new Truck("Ford", 3, 20000.0);
		assertTrue(t1.getModel() == "Ford");
		assertTrue(t1.getAxles() == 3);
		assertTrue(t1.getWeight() == 20000);
	}
	
	@Test
	public void testTollbooth() {
		Tollbooth tb = new Tollbooth();
		assertTrue(tb.sumTolls() == 0.0);
		assertTrue(tb.countTrucks() == 0);
		
		Truck t1 = new Truck("Ford", 3, 20000.0);
		double toll1 = tb.calculateToll(t1);
		assertTrue(toll1 == 130.0);
		assertTrue(tb.sumTolls() == 130.0);
		assertTrue(tb.countTrucks() == 1);
		
		Truck t2 = new Truck("Mac", 4, 50000.0);
		double toll2 = tb.calculateToll(t2);
		assertTrue(toll2 == 290.0);
		assertTrue(tb.sumTolls() == 420.0);
		assertTrue(tb.countTrucks() == 2);
	}
}
