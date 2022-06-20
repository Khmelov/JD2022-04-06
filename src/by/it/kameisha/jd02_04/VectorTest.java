package by.it.kameisha.jd02_04;

import by.it.kameisha.calc.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    private Parser parser;
    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }
    @Test
    public void add() throws CalcException {
        Var var = parser.calc("{2,3}+{3,3}");
        String actual = var.toString();
        String expected = "{5.0, 6.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void sub() throws CalcException {
        Var var = parser.calc("{3,3}-{2,3}");
        String actual = var.toString();
        String expected = "{1.0, 0.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void mul() throws CalcException {
        Var var = parser.calc("{2,3}*{3,3}");
        String actual = var.toString();
        String expected = "15.0";
        assertEquals(expected,actual);
    }

    @Test
    public void div() throws CalcException {
        Var var = parser.calc("{9,3}/3");
        String actual = var.toString();
        String expected = "{3.0, 1.0}";
        assertEquals(expected,actual);
    }
}