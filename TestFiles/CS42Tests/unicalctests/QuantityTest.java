package unicalc.test;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import unicalc.semantics.HashUnicalcDB;
import unicalc.semantics.MyUnitList;
import unicalc.semantics.Quantity;
import unicalc.semantics.UnicalcDB;
import unicalc.semantics.UnicalcException;
import unicalc.semantics.UnitList;

@RunWith(JUnit4.class)
public class QuantityTest {
    private UnicalcDB testDB;

    public QuantityTest() {
        testDB = HashUnicalcDB.getSmallDB();
    }

    /**
     * {6 [] [] 0} * {7 [] [] 0} = {42 [] [] 0}
     */
    @Test
    public void simpleMultiply() {
        Quantity left = new Quantity(6);
        Quantity right = new Quantity(7);
        Quantity result = new Quantity(42);
        Assert.assertEquals(result, left.multiply(right));
    }

    /**
     * {42 [] [] 1} * 42 [] [] 1} = {1764.0 [] [] 59.39696962}
     */
    @Test
    public void uncertainMultiply() {
        Quantity left = new Quantity(42, 1);
        Quantity right = new Quantity(42, 1);
        Quantity result = new Quantity(1764.0, 59.39696962);
        Assert.assertEquals(result, left.multiply(right));
    }

    /**
     * {6 [m] [] 0} * {7 [m] [] 0} = {42 [m m] [] 0}
     */
    @Test
    public void multiplyWithNumerator() {
        UnitList meters = new MyUnitList("m");
        UnitList metersSquared = new MyUnitList("m", "m");
        UnitList none = new MyUnitList();
        Quantity left = new Quantity(6, meters, none, 0);
        Quantity right = new Quantity(7, meters, none, 0);
        Quantity result = new Quantity(42, metersSquared, none, 0);
        Assert.assertEquals(result, left.multiply(right));
    }

    /**
     * {42 [kg m m] [s s] 1} * {42 [s] [kg m] 1} = {1764.0 [m] [s] 59.39696962}
     */
    @Test
    public void multiply1() {
        UnitList leftNum = new MyUnitList("kg", "m", "m");
        UnitList leftDen = new MyUnitList("s", "s");
        Quantity left = new Quantity(42, leftNum, leftDen, 1);


        UnitList rightNum = new MyUnitList("s");
        UnitList rightDen = new MyUnitList("kg", "m");
        Quantity right = new Quantity(42, rightNum, rightDen, 1);

        UnitList resultNum = new MyUnitList("m");
        UnitList resultDen = new MyUnitList("s");
        Quantity result = new Quantity(1764.0, resultNum, resultDen, 59.39696962);

        Assert.assertEquals(result, left.multiply(right));
    }

    /**
     * {2 [m] [amp w] .01} * {.5 [kg x] [s] .01} = {1 [kg m x] [amp s w] 0.02061553}
     */
    @Test
    public void multiply2() {
        UnitList leftNum = new MyUnitList("m");
        UnitList leftDen = new MyUnitList("amp", "w");
        Quantity left = new Quantity(2, leftNum, leftDen, .01);


        UnitList rightNum = new MyUnitList("kg", "x");
        UnitList rightDen = new MyUnitList("s");
        Quantity right = new Quantity(.5, rightNum, rightDen, .01);

        UnitList resultNum = new MyUnitList("kg", "m", "x");
        UnitList resultDen = new MyUnitList("amp", "s", "w");
        Quantity result = new Quantity(1, resultNum, resultDen, 0.02061553);

        Assert.assertEquals(result, left.multiply(right));
    }

    /**
     * {42 [kg m m] [s s] 1} / {42 [kg m] [s] 1} = {1 [m] [s] 0.03367175}
     */
    @Test
    public void divide1() {
        UnitList leftNum = new MyUnitList("kg", "m", "m");
        UnitList leftDen = new MyUnitList("s", "s");
        Quantity left = new Quantity(42, leftNum, leftDen, 1);


        UnitList rightNum = new MyUnitList("kg", "m");
        UnitList rightDen = new MyUnitList("s");
        Quantity right = new Quantity(42, rightNum, rightDen, 1);

        UnitList resultNum = new MyUnitList("m");
        UnitList resultDen = new MyUnitList("s");
        Quantity result = new Quantity(1, resultNum, resultDen, 0.03367175);

        Assert.assertEquals(result, left.divide(right));
    }

    /**
     * {2 [m] [amp w] .01} / {.5 [kg x] [s] .01} = {4 [m s] [amp kg w x] 0.08246211}
     */
    @Test
    public void divide2() {
        UnitList leftNum = new MyUnitList("m");
        UnitList leftDen = new MyUnitList("amp", "w");
        Quantity left = new Quantity(2, leftNum, leftDen, .01);


        UnitList rightNum = new MyUnitList("kg", "x");
        UnitList rightDen = new MyUnitList("s");
        Quantity right = new Quantity(.5, rightNum, rightDen, .01);

        UnitList resultNum = new MyUnitList("kg", "m", "x");
        UnitList resultDen = new MyUnitList("amp", "s", "w");
        Quantity result = new Quantity(1, resultNum, resultDen, 0.02061553);

        Assert.assertEquals(result, left.multiply(right));
    }

    /**
     * {200, [euro], [], 1}^0 = {1, [], [], 0}
     */
    @Test
    public void power1() {
        UnitList euros = new MyUnitList("euro");
        UnitList none = new MyUnitList();
        Quantity operand = new Quantity(200, euros, none, 1); 
        Quantity result = new Quantity(1, none, none, 0);
        Assert.assertEquals(result, operand.power(0));
    }

    /**
     * {200, [euro], [], 1}^(-1) = {.005, [], [euro], 2.5e-5}
     */
    @Test
    public void power2() {
        UnitList euros = new MyUnitList("euro");
        UnitList none = new MyUnitList();
        Quantity operand = new Quantity(200, euros, none, 1); 
        Quantity result = new Quantity(0.005, none, euros, 2.5e-5);
        Assert.assertEquals(result, operand.power(-1));
    }

    /**
     * {200, [euro], [], 1}^3 = {8000000, [euro euro euro], [], 120000}
     */
    @Test
    public void power3() {
        UnitList euros = new MyUnitList("euro");
        UnitList none = new MyUnitList();
        UnitList eurosCubed = new MyUnitList("euro", "euro", "euro");
        Quantity operand = new Quantity(200, euros, none, 1); 
        Quantity result = new Quantity(8000000, eurosCubed, none, 120000);
        Assert.assertEquals(result, operand.power(3));
    }

    /**
     * {42, [inch], [], 1} + {42 [inch] [] 1} = {2.13356145, [meter], [], 0.03592037}
     */
    @Test
    public void add1() {
        UnitList inch = new MyUnitList("inch");
        UnitList meter = new MyUnitList("meter");
        UnitList none = new MyUnitList();
        Quantity operand = new Quantity(42, inch, none, 1); 
        Quantity result = new Quantity(2.13356145, meter, none, 0.03592037);
        Assert.assertEquals(result, operand.add(operand, testDB));
    }

    /**
     * {42, [inch], [], 1} + {42 [second] [] 1} = ERROR
     */
    @Test(expected=UnicalcException.class)
    public void add2() {
        UnitList inch = new MyUnitList("inch");
        UnitList second = new MyUnitList("second");
        UnitList none = new MyUnitList();
        Quantity left = new Quantity(42, inch, none, 1); 
        Quantity right = new Quantity(42, second, none, 1); 
        left.add(right, testDB);
    }

    /**
     * {42, [inch], [], 1} - {42 [inch] [] 1} = {0, [meter], [], 0.03592037}
     */
    @Test
    public void subtract1() {
        UnitList inch = new MyUnitList("inch");
        UnitList meter = new MyUnitList("meter");
        UnitList none = new MyUnitList();
        Quantity operand = new Quantity(42, inch, none, 1); 
        Quantity result = new Quantity(0, meter, none, 0.03592037);
        Assert.assertEquals(result, operand.subtract(operand, testDB));
    }

    /**
     * {60, [meter], [], 0} + (-{18 [meter] [] 0}) = {42, [meter], [], 0}
     */
    @Test
    public void addWithNegation() {
        UnitList meter = new MyUnitList("meter");
        Quantity left = new Quantity(60, meter); 
        Quantity right = new Quantity(18, meter).negate(); 
        Quantity result = new Quantity(42, meter);
        Assert.assertEquals(result, left.add(right, testDB));
    }

    /**
     * {42, [inch], [], 1} - {42 [second] [] 1} = ERROR
     */
    @Test(expected=UnicalcException.class)
    public void subtract2() {
        UnitList inch = new MyUnitList("inch");
        UnitList second = new MyUnitList("second");
        UnitList none = new MyUnitList();
        Quantity left = new Quantity(42, inch, none, 1); 
        Quantity right = new Quantity(42, second, none, 1); 
        left.subtract(right, testDB);
    }

    /**
     * {3, [meter], [second], 0} ^ 2 = {9, [meter meter], [second second], 0}
     */
    @Test
    public void exponentiation() {
        UnitList meter = new MyUnitList("meter");
        UnitList second = new MyUnitList("second");
        UnitList meterSquared = new MyUnitList("meter", "meter");
        UnitList secondSquared = new MyUnitList("second", "second");
        Quantity operand = new Quantity(3, meter, second, 0); 
        Quantity result = new Quantity(9, meterSquared, secondSquared, 0);
        Assert.assertEquals(result, operand.power(2));
    }
}
