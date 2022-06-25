package by.it.marchenko.jd02_04;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.interfaces.Repository;
import by.it.marchenko.calc.repository.VarRepositoryMap;
import by.it.marchenko.calc.services.Assignment;
import by.it.marchenko.calc.services.Operands;
import by.it.marchenko.calc.services.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTaskC {

    public static final int DEFAULT_TIMEOUT = 5000;

    public static final String MATRIX_A = "A={{-1,-2},{3,-4}}";
    public static final String MATRIX_B = "B={{-5,-6},{7,8}}";

    Repository repository;
    private Operands operands;
    private Parser parser;

    @Before
    public void setUp() {
        repository = new VarRepositoryMap();
        repository.clearRepository();
        operands = new Operands(repository);
        Assignment assignment = new Assignment(repository);
        parser = new Parser(repository, operands, assignment);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixAddScalar() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=A+1");
        String actual = result.toString();
        String expected = operands.createVar("{{0,-1},{4,-3}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarAddMatrix() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=  1 +   A");
        String actual = result.toString();
        String expected = operands.createVar("{{0,-1},{4,-3}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixAddMatrix() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        parser.calc(MATRIX_B);  //"B={{-5,-6},{7, 8}}"
        Var result = parser.calc("  C = A +   B");
        String actual = result.toString();
        String expected = operands.createVar("{{-6,-8},{10,4}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixSubScalar() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=A-1");
        String actual = result.toString();
        String expected = operands.createVar("{{-2,-3},{2,-5}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarSubMatrix() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=1-A");
        String actual = result.toString();
        String expected = operands.createVar("{{2,3},{-2,5}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixSubMatrix() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        parser.calc(MATRIX_B);  //"B={{-5,-6},{7, 8}}"
        Var result = parser.calc("C = A - B");
        String actual = result.toString();
        String expected = operands.createVar("{{4,4},{-4,-12}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixMulScalar() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=A*2");
        String actual = result.toString();
        String expected = operands.createVar("{{-2,-4},{6,-8}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarMulMatrix() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=  2 * A ");
        String actual = result.toString();
        String expected = operands.createVar("{{-2,-4},{6,-8}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixMulMatrix() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        parser.calc(MATRIX_B);  //"B={{-5,-6},{7, 8}}"
        Var result = parser.calc("  C = A * B");
        String actual = result.toString();
        String expected = operands.createVar("{{-9,-10},{-43,-50}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)

    public void testMatrixMulVector() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        parser.calc("B={-5,6}");  //"B={-5,6}"
        Var result = parser.calc("  C = A * B");
        String actual = result.toString();
        String expected = operands.createVar("{-7,-39}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixDivScalar() throws Exception {
        parser.calc(MATRIX_A);  //"A={{-1,-2},{3,-4}}"
        Var result = parser.calc("B=A/2");
        String actual = result.toString();
        String expected = operands.createVar("{{-0.5,-1},{1.5,-2}}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarToString() throws Exception {
        String inputString = "-10.456";
        Var result = operands.createVar(inputString);
        String actual = result.toString();
        String expected = "-10.456";
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorToString() throws Exception {
        String inputString = "{-1.2, 34.567}";
        Var result = operands.createVar(inputString);
        String actual = result.toString();
        String expected = "{-1.2, 34.567}";
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testMatrixToString() throws Exception {
        String inputString = "{{-1,-2},{3,-4.456}}";
        Var result = operands.createVar(inputString);
        String actual = result.toString();
        String expected = "{{-1.0, -2.0}, {3.0, -4.456}}";
        assertEquals(actual, expected);
    }
}