package by.it.marchenko.jd02_04;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.interfaces.Repository;
import by.it.marchenko.calc.repository.VarRepositoryMap;
import by.it.marchenko.calc.services.Assignment;
import by.it.marchenko.calc.services.Operands;
import by.it.marchenko.calc.services.Parser;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class TestTaskA {
    public static final double DELTA = 1e-5;
    public static final int DEFAULT_TIMEOUT = 5000;

    Repository repository;
    private Parser parser;

    @Before
    public void setUp() {
        Scanner console = new Scanner(System.in);
        repository = new VarRepositoryMap();
        Operands operands = new Operands(repository);
        Assignment assignment = new Assignment(repository);
        repository.clearRepository();
        parser = new Parser(repository, operands, assignment);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testA() throws CalcException {
        Var result = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(result.toString());
        double expected = 7.3d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testB() throws CalcException {
        parser.calc("A=2+5.3");
        Var result = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(result.toString());
        double expected = 25.55d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testB1() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var result = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(result.toString());
        double expected = 25d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testB2() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var result = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(result.toString());
        double expected = 2.65d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testAdd() throws CalcException {
        Var result = parser.calc("-2+-5.3");
        double actual = Double.parseDouble(result.toString());
        double expected = -7.3d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMul() throws CalcException {
        Var result = parser.calc("-2*-5.3");
        double actual = Double.parseDouble(result.toString());
        double expected = 10.6d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testSub() throws CalcException {
        Var result = parser.calc("2--5.3");
        double actual = Double.parseDouble(result.toString());
        double expected = 7.3d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testDiv() throws CalcException {
        Var result = parser.calc("2.2/-0.5");
        double actual = Double.parseDouble(result.toString());
        double expected = -4.4d;
        assertEquals(actual, expected, DELTA);
    }
}