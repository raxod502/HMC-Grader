package unicalc.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import unicalc.ast.AST;
import unicalc.ast.Add;
import unicalc.ast.Define;
import unicalc.ast.Divide;
import unicalc.ast.Multiply;
import unicalc.ast.Negate;
import unicalc.ast.Normalize;
import unicalc.ast.Paren;
import unicalc.ast.Unit;
import unicalc.ast.Value;
import unicalc.semantics.HashUnicalcDB;
import unicalc.semantics.MyUnitList;
import unicalc.semantics.Quantity;
import unicalc.semantics.UnicalcDB;
import unicalc.semantics.UnitList;

@RunWith(JUnit4.class)
public class EvaluatorTest {

    private UnicalcDB testDB;

    public EvaluatorTest() {
        testDB = HashUnicalcDB.getSmallDB();
    }

    @Test
    public void int1() {
        AST tree = new Value(42);
        Quantity expected = new Quantity(42);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void double1() {
        AST tree = new Value(42.3);
        Quantity expected = new Quantity(42.3);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testPlus() {
        AST one = new Value(1);
        AST tree = new Add(one, one);
        Quantity expected = new Quantity(2);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testTimes() {
        AST one = new Value(1);
        AST tree = new Multiply(one, one);
        Quantity expected = new Quantity(1);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testDivide() {
        AST one = new Value(1);
        AST tree = new Divide(one, one);
        Quantity expected = new Quantity(1);
        tryToEvaluate(tree, expected);     
    }

    @Test
    public void testNegative() {
        AST one = new Value(1);
        AST tree = new Negate(one);
        Quantity expected = new Quantity(-1);
        tryToEvaluate(tree, expected);
    }

    public void testUncertainty() {
        AST tree = new Value(42, 10);
        Quantity expected = new Quantity(42, 10);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testNumWithUnits() {
        UnitList meter = new MyUnitList("m");
        Unit units = new Unit(meter);
        AST tree = new Value(42, units);
        Quantity expected = new Quantity(42, meter);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testUnitsAndUncertainty() {
        UnitList unitList = new MyUnitList("v", "s", "m");
        Unit units = new Unit(unitList);
        AST tree = new Value(42, units);
        Quantity expected = new Quantity(42, unitList);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testUnitsAndUncertaintyDenominator() {
        UnitList numerator = new MyUnitList("v", "s");
        UnitList denominator = new MyUnitList("m");
        Unit units = new Unit(numerator, denominator);
        AST tree = new Value(42, units);
        Quantity expected = new Quantity(42, numerator, denominator);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testNormalize1() {
        AST ql = new Value(42);
        AST tree = new Normalize(ql);
        Quantity expected = new Quantity(42);
        tryToEvaluate(tree, expected);
    }
    
    @Test
    public void testNormalize2() {
        UnitList hour = new MyUnitList("hour");
        UnitList second = new MyUnitList("second");
        AST ql = new Value(3, new Unit(hour));
        AST tree = new Normalize(ql);
        Quantity expected = new Quantity(10800.0, second);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testParenthetical() {
        AST tree = new Paren(new Value(42));
        Quantity expected = new Quantity(42);
        tryToEvaluate(tree, expected);
    }

    @Test
    public void testMultipleQLs1() {
        UnitList meter = new MyUnitList("m");
        UnitList second = new MyUnitList("s");
        UnitList meterSquared = new MyUnitList("m", "m");
        
        AST left = new Value(3, new Unit(meter));
        AST right = new Value(2, new Unit(meter, second));
        AST tree = new Multiply(left, right);
        Quantity expected = new Quantity(6, meterSquared, second);
        tryToEvaluate(tree, expected);    
    }

    @Test
    public void testMultipleQLs2() {
        UnitList meter = new MyUnitList("m");
        UnitList second = new MyUnitList("s");
        UnitList meterSquared = new MyUnitList("m", "m");
        UnitList secondSquared = new MyUnitList("s", "s");
        
        AST left = new Value(18, new Unit(meter, second));
        AST right = new Value(42, new Unit(meter, second));
        AST tree = new Multiply(left, right);
        Quantity expected = new Quantity(756, meterSquared, secondSquared);
        tryToEvaluate(tree, expected);   
    }

    /**
     * def answer 42 (adds answer -> {42, [], [], 0} to db)
     */
    @Test
    public void definition() {
        AST value = new Value(42);
        AST definition = new Define("answer", value);
        Quantity result = new Quantity(42);
        Assert.assertFalse(testDB.contains("answer"));
        definition.evaluate(testDB);
        Assert.assertEquals(testDB.assoc("answer"), result);
        testDB.remove("answer");
    }

    /**
     * {10 [answer] [s], 0} should be defined if answer is defined
     */
    @Test
    public void use() {
        testDB.put("answer", new Quantity(10));
        UnitList answer = new MyUnitList("answer");
        UnitList second = new MyUnitList("second");
        AST lookup = new Value(10, new Unit(answer, second));
        Quantity expression = new Quantity(10, answer, second);
        tryToEvaluate(lookup, expression);
        testDB.remove("answer");
    }

    /**
     * #(10 [answer] / [s]) = {100, [], [s], 0}
     */
    @Test
    public void normalizeDefined() {
        testDB.put("answer", new Quantity(10));
        UnitList answer = new MyUnitList("answer");
        UnitList second = new MyUnitList("second");
        UnitList none = new MyUnitList();
        AST lookup = new Normalize(new Value(10, new Unit(answer, second)));
        Quantity expression = new Quantity(100, none, second);
        tryToEvaluate(lookup, expression);
        testDB.remove("answer");
    }

    /**
     * (10 [answer] / [s]) + (- (9 [answer] / [s])) = {10, [], [s], 0}
     */
    @Test
    public void subtractDefined() {
        testDB.put("answer", new Quantity(10));
        UnitList answer = new MyUnitList("answer");
        UnitList second = new MyUnitList("second");
        UnitList none = new MyUnitList();
        Unit units =  new Unit(answer, second);
        AST left = new Value(10, units);
        AST right = new Negate(new Value(9, units));
        AST tree = new Add(left, right);
        Quantity expression = new Quantity(10, none, second);
        tryToEvaluate(tree, expression);
        testDB.remove("answer");
    }

    /**
     * x -> 3 m/s
     * 3*(11 [m/s] + x) = 42 [m/s]
     */
    @Test
    public void expressionDefined() {
        // x -> 3 m/s
        UnitList meter = new MyUnitList("meter");
        UnitList second = new MyUnitList("second");
        testDB.put("x", new Quantity(3, meter, second));

        // 11 [m/s] + x
        Unit units =  new Unit(meter, second);
        Unit x = new Unit(new MyUnitList("x"), new MyUnitList());
        AST right = new Add(new Value(11, units), new Value(1, x));

        // 3 * (11 [m/s] + x)
        AST tree = new Multiply(new Value(3), right);

        Quantity result = new Quantity(42, meter, second);
        tryToEvaluate(tree, result);
        testDB.remove("x");
    }

    protected void tryToEvaluate(AST tree, Quantity expected) {
        Quantity result = tree.evaluate(testDB);        
        Assert.assertEquals(expected, result);
    }
}
