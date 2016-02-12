package unicalc.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import unicalc.parser.Tokenizer;
import unicalc.parser.UnicalcTokenizeException;
import unicalc.parser.tokens.Literal;
import unicalc.parser.tokens.Keyword;
import unicalc.parser.tokens.Operator;
import unicalc.parser.tokens.Token;
import unicalc.parser.tokens.Variable;

@RunWith(JUnit4.class)
public class TokenizerTest {
    
    @Test
    public void intToken() {
        tryToTokenize("42", new Literal(42));
    }
    
    @Test
    public void doubleToken1() {
        tryToTokenize("42.3", new Literal(42.3));
    }
    
    @Test
    public void doubleToken2() {
        tryToTokenize(".357", new Literal(.357));
    }
    
    @Test
    public void doubleToken3() {
        tryToTokenize("0.357", new Literal(.357));
    }
    
    @Test
    public void testDoubleDigits() {
        tryToTokenize("10", new Literal(10));
    }
    
    @Test
    public void testPlus() {
        Token one = new Literal(1);
        tryToTokenize("1+1", one, Operator.CROSS, one);
    }
    
    @Test
    public void testMinus() {
        Token one = new Literal(1);
        tryToTokenize("1-1", one, Operator.DASH, one);      
    }
    
    @Test
    public void testTimes() {
        Token one = new Literal(1);
        tryToTokenize("1*1", one, Operator.STAR, one);
    }
    
    @Test
    public void testDivide() {
        Token one = new Literal(1);
        tryToTokenize("1/1", one, Operator.FWDSLASH, one);       
    }
    
    @Test
    public void testNegative() {
       tryToTokenize("-1", Operator.DASH, new Literal(1));
    }
    
    public void testTilde() {
        tryToTokenize("42~10", new Literal(42), Operator.TILDE, 
                new Literal(10));        
    }
    
    @Test
    public void testWhitespace() {
        Token one = new Literal(1);
        tryToTokenize("   1   +    1   ", one, Operator.CROSS, one);
    }
    
    @Test(expected=UnicalcTokenizeException.class) 
    public void testBadOperator() {
        tryToTokenize("&");
    }

    @Test
    public void testNumWithUnitsToken() {
        tryToTokenize("42 [m]", new Literal(42), 
                                Operator.LBRACKET,
                                new Variable("m"), 
                                Operator.RBRACKET);
    }
    
    @Test
    public void testUnitsAndUncertaintyToken() {
        tryToTokenize("42~10 [v s m]", new Literal(42), 
                                       Operator.TILDE, 
                                       new Literal(10),
                                       Operator.LBRACKET,
                                       new Variable("v"),
                                       new Variable("s"),
                                       new Variable("m"),
                                       Operator.RBRACKET);
    }
    
    @Test
    public void testUnitsAndUncertaintyDenominatorToken() {
        tryToTokenize("42~10 [v s / m]", new Literal(42), 
                                         Operator.TILDE, 
                                         new Literal(10),
                                         Operator.LBRACKET,
                                         new Variable("v"),
                                         new Variable("s"),
                                         Operator.FWDSLASH,
                                         new Variable("m"),
                                         Operator.RBRACKET);
    }
        
    @Test
    public void testDefToken() {
        tryToTokenize("def answer 42", Keyword.DEF, 
                                       new Variable("answer"),
                                       new Literal(42));
    }
    
    @Test
    public void testNormalizeToken() {
        tryToTokenize("#42", Operator.POUND, new Literal(42));
    }
    
    protected void tryToTokenize(String program, Token...expectedTokens) {
        Tokenizer t = new Tokenizer(new Scanner(program));
        List<Token> actualTokens = t.tokenize();
        Assert.assertArrayEquals(expectedTokens, actualTokens.toArray());
    }

}
