package by.it.ragach.jd02_04;

import by.it.ragach.calc.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository,varCreator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calc() throws CalcException {

        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);


        expression = "B=A*3.5";
        actualVar = parser.calc(expression);
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        delta = 1e-4;
        assertEquals(expected,actual,delta);



        expression = "B1=B+0.11*-5";
        actualVar = parser.calc(expression);
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        delta = 1e-4;
        assertEquals(expected,actual,delta);


        expression = "B2=A/2-1";
        actualVar = parser.calc(expression);
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        delta = 1e-4;
        assertEquals(expected,actual,delta);
    }
}