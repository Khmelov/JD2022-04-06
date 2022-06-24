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

public class TestTaskB {
    public static final double DELTA = 1e-5;
    public static final int DEFAULT_TIMEOUT = 5000;

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
    public void testC() throws Exception {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var result = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(result.toString());
        double expected = 40.15d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testD() throws Exception {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        Var result = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(result.toString());
        double expected = 10d;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testE() throws Exception {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        Var result = parser.calc("E={2,3}*(D/2)");
        String actual = result.toString();
        String expected = operands.createVar("{10,15}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorAddScalar() throws Exception {
        parser.calc("A={-1,2}");
        Var result = parser.calc("B=A+1");
        String actual = result.toString();
        String expected = operands.createVar("{0,3}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarAddVector() throws Exception {
        parser.calc("A={-1,2}");
        Var result = parser.calc("B=1+A");
        String actual = result.toString();
        String expected = operands.createVar("{0,3}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarMulVector() throws Exception {
        parser.calc("A={-1,2}");
        Var result = parser.calc("B=2*A");
        String actual = result.toString();
        String expected = operands.createVar("{-2,4}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorMulScalar() throws Exception {
        parser.calc("A={-1,2}");
        Var result = parser.calc("B=A*2");
        String actual = result.toString();
        String expected = operands.createVar("{-2,4}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorAddVector() throws Exception {
        parser.calc("A={-1,2}");
        parser.calc("B={1,2}");
        Var result = parser.calc("C=A+B");
        String actual = result.toString();
        String expected = operands.createVar("{0,4}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorMulVector() throws Exception {
        parser.calc("A={-1,2}");
        parser.calc("B={1,2}");
        Var result = parser.calc("C=A*B");
        String actual = result.toString();
        String expected = operands.createVar("3").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testScalarSubVector() throws Exception {
        parser.calc("A={-1,2}");
        Var result = parser.calc("B=1-A");
        String actual = result.toString();
        String expected = operands.createVar("{2,-1}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorSubScalar() throws Exception {
        parser.calc("A={-1,2}");
        Var result = parser.calc("B=A-1");
        String actual = result.toString();
        String expected = operands.createVar("{-2,1}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorSubVector() throws Exception {
        parser.calc("A={-1,2}");
        parser.calc("B={1,2}");
        Var result = parser.calc("C=A-B");
        String actual = result.toString();
        String expected = operands.createVar("{-2,0}").toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testVectorDivScalar() throws Exception {
        parser.calc("A={-1,2}");
        parser.calc("B=2");
        Var result = parser.calc("C=A/B");
        String actual = result.toString();
        String expected = operands.createVar("{-0.5,1}").toString();
        assertEquals(actual, expected);
    }
}