package by.it.kameisha.jd02_04;

import by.it.kameisha.calc.*;
import org.junit.After;
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
        Var var = parser.calc("{2,3,1}+({6,3,10}+1)");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{9.0, 7.0, 12.0}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void sub() throws CalcException {
        Var var = parser.calc("{3,3,6}-{2,3,4}-2");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{-1.0, -2.0, 0.0}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void mul() throws CalcException {
        Var var = parser.calc("{2,3}*({3,3}*5)");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "75.0";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void div() throws CalcException {
        Var var = parser.calc("{9,3}/3");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{3.0, 1.0}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @After
    public void tearDown() throws Exception {
    }
}