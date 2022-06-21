package by.it.smirnov.jd02_04;

import by.it.smirnov.calc.entity.Matrix;
import by.it.smirnov.calc.entity.Scalar;
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

public class CalcTest {

    private Parser parser;
    private static final double DELTA = 1e-4;

    @Before
    public void setUp() throws Exception {
        Repository repo = new PersistentRepository();
        parser = new Parser(repo, new VarCreator(repo));
    }

    @Test(timeout = 100)
    public void calcA() throws CalcException {
       Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 100)
    public void calcB() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 100)
    public void calcB1() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 100)
    public void calcB2() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 100)
    public void calcC() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 100)
    public void calcD() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        Var actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 10;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 100)
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

    @Test(timeout = 100)
    public void calcMatrixScalar() throws CalcException {
        Var actualVar1 = parser.calc("{{1.0,2.0},{3.0,4.0}}+8.6");
        String actual1 = actualVar1.toString();
        String expected1 = "{{9.6,10.6},{11.6,12.6}}";
        assertEquals(expected1, actual1);

        Var actualVar2 = parser.calc("{{100.0,1.0},{200.0,200.0}}-70.5");
        String actual2 = actualVar2.toString();
        String expected2 = "{{29.5,-69.5},{129.5,129.5}}";
        assertEquals(expected2, actual2);

        Var actualVar3 = parser.calc("{{1,2},{3,4}}*18.0");
        String actual3 = actualVar3.toString();
        String expected3 = "{{18,36},{54,72}}";
        assertEquals(expected3, actual3);
    }

    @Test(timeout = 100)
    public void calcMatrixMatrix() throws CalcException {
        Var actualVar1 = parser.calc("{{1.0,2.0},{3.0,4.0}}+{{4.0,3.0},{2.0,1.0}}");
        String actual1 = actualVar1.toString();
        String expected1 = "{{5,5},{5,5}}";
        assertEquals(expected1, actual1);

        Var actualVar2 = parser.calc("{{1.0,2.0},{3.0,4.0}}-{{4.0,3.0},{2.0,1.0}}");
        String actual2 = actualVar2.toString();
        String expected2 = "{{-3,-1},{1,3}}";
        assertEquals(expected2, actual2);

        Var actualVar3 = parser.calc("{{1.0,2.0},{3.0,4.0}}*{{4.0,3.0},{2.0,1.0}}");
        String actual3 = actualVar3.toString();
        String expected3 = "{{8,5},{20,13}}";
        assertEquals(expected3, actual3);
    }

    @Test(timeout = 100)
    public void operandInputToString() throws CalcException {
        String inputScalar1 = "58";
        String inputScalar2 = "58.0";
        String inputVector = "{1, 2.0, 3.6}";
        String inputMatrix = "{{1.0, 2.0},{3, 4}, {5.0,10}}";

        Scalar scalar1 = new Scalar(inputScalar1);
        Scalar scalar2 = new Scalar(inputScalar2);
        Vector vector = new Vector(inputVector);
        Matrix matrix = new Matrix(inputMatrix);

        assertEquals(Double.parseDouble(inputScalar1), Double.parseDouble(scalar1.toString()), DELTA);
        assertEquals(Double.parseDouble(inputScalar2), Double.parseDouble(scalar2.toString()), DELTA);
        assertEquals("{1,2,3.6}", vector.toString());
        assertEquals("{{1,2},{3,4},{5,10}}", matrix.toString());
    }

    @After
    public void tearDown() throws Exception {
    }
}