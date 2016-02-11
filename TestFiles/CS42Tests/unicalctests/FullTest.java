package unicalc.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import unicalc.ast.AST;
import unicalc.parser.RightAssociativeParser;
import unicalc.parser.Tokenizer;
import unicalc.parser.UnicalcParser;
import unicalc.parser.tokens.Token;
import unicalc.semantics.HashUnicalcDB;
import unicalc.semantics.MyUnitList;
import unicalc.semantics.Quantity;
import unicalc.semantics.UnicalcDB;
import unicalc.semantics.UnitList;

@RunWith(JUnit4.class)
public class FullTest {

    private UnicalcDB testDB;

    public FullTest() {
        testDB = HashUnicalcDB.getSmallDB();
    }

    @After
    public void setUp() {
        testDB = HashUnicalcDB.getSmallDB();  // reset Test DB
    }

    /**
     * def answer 43
     * def x      3 [m/s]
     * def answer 7*(x+x)
     *  
     * answer should be: {42 [m] [s] 0}
     */
    @Test
    public void overwrite() {
        UnitList meter = new MyUnitList("m");
        UnitList second = new MyUnitList("s");

        String def1 = "def answer 43";
        Quantity expected = new Quantity(43);
        Quantity actual = getResult(def1);
        Assert.assertEquals(expected, actual);

        String def2 = "def x 3 [m/s]";
        expected = new Quantity(3, meter, second);
        actual = getResult(def2);
        Assert.assertEquals(expected, actual);

        String def3 = "def answer 7*(x+x)";
        expected = new Quantity(42, meter, second);
        actual = getResult(def3);
        Assert.assertEquals(expected, actual);
    }
    
    /**
     * def x      3 [m/s]
     * def answer 7*(x+x)
     * def hz     1 / 1 [s]
     * 
     * answer + 18 m hz = {60 [m] [s] 0}
     *  
     * answer should be: {1 [] [s] 0}
     */
    @Test
    public void defineVar() {
        UnitList none = new MyUnitList();
        UnitList meter = new MyUnitList("m");
        UnitList second = new MyUnitList("s");

        String def1 = "def hz 1 / 1 [s]";
        Quantity expected = new Quantity(1, none, second);
        Quantity actual = getResult(def1);
        Assert.assertEquals(expected, actual);
        
        String def2 = "def x 3 [m/s]";
        expected = new Quantity(3, meter, second);
        actual = getResult(def2);
        Assert.assertEquals(expected, actual);

        String def3 = "def answer 7*(x+x)";
        expected = new Quantity(42, meter, second);
        actual = getResult(def3);
        Assert.assertEquals(expected, actual);
        
        String expr = "answer + 18 [m hz]";
        expected = new Quantity(60, meter, second);
        actual = getResult(expr);
        Assert.assertEquals(expected, actual);
    }
    
    /**
     * def hz 1 / 1 [s]
     * def x      3 [m/s]
     * def answer 7*(x+x)
     *  
     * answer should be: {42 [m] [s] 0}
     */
    @Test
    public void multiVar() {
        UnitList meter = new MyUnitList("m");
        UnitList second = new MyUnitList("s");

        String def1 = "def answer 43";
        Quantity expected = new Quantity(43);
        Quantity actual = getResult(def1);
        Assert.assertEquals(expected, actual);

        String def2 = "def x 3 [m/s]";
        expected = new Quantity(3, meter, second);
        actual = getResult(def2);
        Assert.assertEquals(expected, actual);

        String def3 = "def answer 7*(x+x)";
        expected = new Quantity(42, meter, second);
        actual = getResult(def3);
        Assert.assertEquals(expected, actual);
    }

    protected Quantity getResult(String program) {
        // tokenize
        Tokenizer t = new Tokenizer(new Scanner(program));
        List<Token> tokens = t.tokenize();

        // parse
        UnicalcParser parser = new RightAssociativeParser();
        AST tree = parser.parse(tokens);

        // evaluate
        return tree.evaluate(testDB);        
    }
}
