package unicalc.test;

import org.junit.Assert;

import org.junit.Test;

import unicalc.semantics.HashUnicalcDB;
import unicalc.semantics.MyUnitList;
import unicalc.semantics.Quantity;
import unicalc.semantics.UnicalcDB;
import unicalc.semantics.UnitList;

public class HashUnicalcDBTest {
    
    private UnicalcDB testDB;
    
    public HashUnicalcDBTest() {
        testDB = HashUnicalcDB.getSmallDB();
    }
    
    // already simplified
    @Test
    public void normalize1() {
        UnitList kg = new MyUnitList("kg");
        UnitList none = new MyUnitList();
        Quantity expected = new Quantity(1, kg, none);
        Assert.assertEquals(expected, testDB.normalize("kg"));
    }
    
    // requires one lookup
    @Test
    public void normalize2() {
        UnitList meter = new MyUnitList("meter");
        UnitList none = new MyUnitList();
        Quantity expected = new Quantity(.01, meter, none);
        Assert.assertEquals(expected, testDB.normalize("cm"));
    }
    
    // requires multiple lookups
    @Test
    public void normalize3() {
        UnitList kgMetersSquared = new MyUnitList("kg", "meter", "meter");
        UnitList secondsCubed = new MyUnitList("second", "second", "second");
        Quantity expected = new Quantity(1, kgMetersSquared, secondsCubed);
        Assert.assertEquals(expected, testDB.normalize("watt"));
    }
    
    /**
     * {2, [foot], [minute], .1} -> {0.010159816, [meter], [second], 0.0005079908}
     */
    @Test
    public void normalizeQ1() {
        UnitList foot = new MyUnitList("foot");
        UnitList minute = new MyUnitList("minute");
        UnitList meter = new MyUnitList("meter");
        UnitList second = new MyUnitList("second");
        
        Quantity unnormalized = new Quantity(2, foot, minute, .1);
        Quantity expected = new Quantity(.010159816, meter, second, .0005079908);
        Assert.assertEquals(expected, testDB.normalize(unnormalized));        
    }
    
    /**
     * {14.4, [foot], [], .3} -> {4.3890407, [meter], [], 0.09143834}
     */
    @Test
    public void normalizeQ2() {
        UnitList foot = new MyUnitList("foot");
        UnitList meter = new MyUnitList("meter");
        UnitList none = new MyUnitList();
        
        Quantity unnormalized = new Quantity(14.4, foot, none, .3);
        Quantity expected = new Quantity(4.3890407, meter, none, 0.09143834);
        Assert.assertEquals(expected, testDB.normalize(unnormalized));        
    }
    
    /**
     * {1, [joule], [minute], .1} -> {.7, [kg meter meter], [second second second], 0.0016666666666666668}
     */
    @Test
    public void normalizeQ3() {
        UnitList joule = new MyUnitList("joule");
        UnitList minute = new MyUnitList("minute");
        UnitList kgMetersSquared = new MyUnitList("kg", "meter", "meter");
        UnitList secondsCubed = new MyUnitList("second", "second", "second");
        
        Quantity unnormalized = new Quantity(42, joule, minute, .1);
        Quantity expected = new Quantity(.7, kgMetersSquared, secondsCubed, 0.0016666666666666668);
        Assert.assertEquals(expected, testDB.normalize(unnormalized));        
    }
}
