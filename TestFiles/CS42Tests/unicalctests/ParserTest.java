package unicalc.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import unicalc.ast.AST;
import unicalc.ast.Add;
import unicalc.ast.Define;
import unicalc.ast.Divide;
import unicalc.ast.Exponent;
import unicalc.ast.Multiply;
import unicalc.ast.Negate;
import unicalc.ast.Normalize;
import unicalc.ast.Paren;
import unicalc.ast.Unit;
import unicalc.ast.Value;
import unicalc.parser.RightAssociativeParser;
import unicalc.parser.Tokenizer;
import unicalc.parser.UnicalcParser;
import unicalc.parser.tokens.Token;
import unicalc.semantics.MyUnitList;

@RunWith(JUnit4.class)
public class ParserTest {
    
    @Test
    public void int1() {
        tryToParse("42", new Value(42));
    }
    
    @Test
    public void double1() {
        tryToParse("42.3", new Value(42.3));
    }
    
    @Test
    public void double2() {
        tryToParse(".357", new Value(.357));
    }
    
    @Test
    public void double3() {
        tryToParse("0.357", new Value(.357));
    }
    
    @Test
    public void testDoubleDigits() {
        tryToParse("10", new Value(10));
    }
    
    @Test
    public void testPlus() {
        AST ql = new Value(1);
        tryToParse("1+1", new Add(ql, ql));
    }
    
    @Test
    public void testTimes() {
        AST ql = new Value(1);
        tryToParse("1*1", new Multiply(ql, ql)); 
    }
    
    @Test
    public void testDivide() {
        AST ql = new Value(1);
        tryToParse("1/1", new Divide(ql, ql));        
    }
    
    @Test
    public void testNegative() {
       AST ql = new Value(1);
       tryToParse("(-1)", new Negate(ql));
    }
    
    public void testTilde() {
        AST ql = new Value(42, 10);
        tryToParse("42~10", ql);        
    }
    
    @Test
    public void testNumWithUnits() {
        Unit units = new Unit(new MyUnitList("m"));
        AST ql = new Value(42, units);
        tryToParse("42 [m]", ql);
    }
    
    @Test
    public void testUnitsAndUncertainty() {
        Unit units = new Unit(new MyUnitList("v", "s", "m"));
        AST ql = new Value(42, 10, units);
        tryToParse("42~10 [v s m]", ql);
    }
    
    @Test
    public void testUnitsAndUncertaintyDenominator() {
        Unit units = new Unit(new MyUnitList("v", "s"), new MyUnitList("m"));
        AST ql = new Value(42, 10, units);
        tryToParse("42~10 [v s / m]", ql);
    }
        
    @Test
    public void testDef() {
        AST ql = new Value(42);
        AST result = new Define("answer", ql);
        tryToParse("def answer 42", result);
    }
    
    @Test
    public void testNormalize() {
        AST ql = new Value(42);
        AST result = new Normalize(ql);
        tryToParse("#42", result);
    }
    
    @Test
    public void testRightAssociativity() {
        // note: This parser is gives the grammar right associativity
        // 5+6+7 parses as (5 + (6 + 7))
        String program = "5+6+7";
        AST ql5 = new Value(5);
        AST ql6 = new Value(6);
        AST ql7 = new Value(7);
        AST result = new Add(ql5, new Add(ql6, ql7));
        tryToParse(program, result);
    }
    
    @Test
    public void testPrecedence1() {
        // 5*6+7 parses as ((5 * 6) + 7)
        String program = "5*6+7";
        AST ql5 = new Value(5);
        AST ql6 = new Value(6);
        AST ql7 = new Value(7);
        AST result = new Add(new Multiply(ql5, ql6), ql7);
        tryToParse(program, result);
    }
    
    @Test
    public void testPrecedence2() {
        // 5+6*7 parses as (5 + (6 * 7))
        String program = "5+6*7";
        AST ql5 = new Value(5);
        AST ql6 = new Value(6);
        AST ql7 = new Value(7);
        AST result = new Add(ql5, new Multiply(ql6, ql7));
        tryToParse(program, result);
    }
    
    @Test
    public void testPrecedence3() {
        // 5^6*7 parses as ((5 ^ 6) * 7)
        String program = "5^6*7";
        AST ql5 = new Value(5);
        AST ql7 = new Value(7);
        AST result = new Multiply(new Exponent(ql5, 6), ql7);
        tryToParse(program, result);
    }
    
    @Test
    public void testPrecedence4() {
        // 5+6*7 parses as (5 * (6 ^ 7))
        String program = "5*6^7";
        AST ql5 = new Value(5);
        AST ql6 = new Value(6);
        AST result = new Multiply(ql5, new Exponent(ql6, 7));
        tryToParse(program, result);
    }
    
    @Test
    public void testParenthetical() {
        // (5+6)+7 parses as ((5+6)+7)
        String program = "(5+6)+7";
        AST ql5 = new Value(5);
        AST ql6 = new Value(6);
        AST ql7 = new Value(7);
        AST result = new Add(new Paren(new Add(ql5, ql6)), ql7);
        tryToParse(program, result);
    }
    
    @Test
    public void testMultipleQLs1() {
        String program = "3 [m] * 2 [m/s]";
        Unit units1 = new Unit(new MyUnitList("m"));
        Unit units2 = new Unit(new MyUnitList("m"), new MyUnitList("s"));
        AST ql1 = new Value(3, units1);
        AST ql2 = new Value(2, units2);
        AST result = new Multiply(ql1, ql2);
        tryToParse(program, result);
    }
    
    @Test
    public void testMultipleQLs2() {
        String program = "18 [m/s] * 42 [m/s]";
        Unit units = new Unit(new MyUnitList("m"), new MyUnitList("s"));
        AST ql1 = new Value(18, units);
        AST ql2 = new Value(42, units);
        AST result = new Multiply(ql1, ql2);
        tryToParse(program, result);
    }
    
    @Test
    public void testExponentiation() {
        String program = "(3 [m/s])^2";
        Unit units = new Unit(new MyUnitList("m"), new MyUnitList("s"));
        AST ql = new Value(3, units);
        AST result = new Exponent(new Paren(ql), 2);
        tryToParse(program, result);
    }
    
    protected void tryToParse(String s, AST expected) {
        Tokenizer t = new Tokenizer(new Scanner(s));
        List<Token> tokens = t.tokenize();
        
        UnicalcParser parser = new RightAssociativeParser();
        AST result = parser.parse(tokens);
        
        Assert.assertEquals(expected, result);
    }

}
