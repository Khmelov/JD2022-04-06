package by.it.ragach.jd02_04;

import by.it.ragach.calc.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestBrackets {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void calcOperationC() throws Exception{
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        String expression = "C=B+(A*2)";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);

    }

    @Test
    public void calcOperationD() throws Exception{
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        String expression = "D=((C-0.15)-20)/(7-5)";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 10;
        double delta = 1e-4;
        assertEquals(expected,actual,delta);


    }
    @Test
    public void calcOperationE()throws Exception{
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        String expression = "E={2,3}*(D/2)";
        Var actualVec = parser.calc(expression);
        String actual = actualVec.toString();
        String expected = "{10.0, 15.0}";
        assertEquals(expected,actual);

    }
}