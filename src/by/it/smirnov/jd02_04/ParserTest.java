package by.it.smirnov.jd02_04;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.entity.Vector;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;
import by.it.smirnov.calc.repository.PersistentRepository;
import by.it.smirnov.calc.service.Parser;
import by.it.smirnov.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;
    private static final double DELTA = 1e-4;

    @Before
    public void setUp() throws Exception {
        Repository repo = new PersistentRepository();
        parser = new Parser(repo, new VarCreator(repo));
    }

    @Test
    public void calcA() throws CalcException {
       Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcB() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcB1() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcB2() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcC() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcD() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        Var actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcE() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        Var actualVar = parser.calc("E={2,3}*(D/2)");
        String actual = actualVar.toString();
        String expected = "{10,15}";
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
    }
}