package by.it.ragach.jd02_04;

import by.it.ragach.calc.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestScalar {

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
    public void calcOperationA() throws CalcException {

        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);


    }

    @Test

    public void calcOperationB() throws Exception{
        parser.calc("A=2+5.3");
        String expression = "B=A*3.5";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);

    }

    @Test

    public void calcOperationB1() throws Exception{
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        String expression = "B1=B+0.11*-5";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);


    }

    @Test
    public void calcOperationB2()throws Exception{
        parser.calc("A=2+5.3");
        String expression = "B2=A/2-1";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);

    }

}