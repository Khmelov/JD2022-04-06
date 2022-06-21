package by.it.kameisha.jd02_04;

import by.it.kameisha.calc.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VarCreatorTest {
    VarCreator varCreator;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        varCreator = new VarCreator(repository);
    }

    @Test
    public void createScalar() throws CalcException {
        Var var = varCreator.createVar("100.65");
        System.out.println("actual   " + var.toString());
        String expected = "100.65";
        System.out.println("expected " + expected);
        assertEquals(expected,var.toString());
    }

    @Test
    public void createVector() throws CalcException {
        Var var = varCreator.createVar("{100.65,5.14, 4}");
        System.out.println("actual   " + var.toString());
        String expected = "{100.65, 5.14, 4.0}";
        System.out.println("expected " + expected);
        assertEquals(expected,var.toString());
    }

    @Test
    public void createMatrix() throws CalcException {
        Var var = varCreator.createVar("{{100.65,5.14, 4},{59.4,4,12},{5.14,5,7}}");
        System.out.println("actual   " + var.toString());
        String expected = "{{100.65, 5.14, 4.0}, {59.4, 4.0, 12.0}, {5.14, 5.0, 7.0}}";
        System.out.println("expected " + expected);
        assertEquals(expected,var.toString());
    }

    @After
    public void tearDown() throws Exception {
    }
}