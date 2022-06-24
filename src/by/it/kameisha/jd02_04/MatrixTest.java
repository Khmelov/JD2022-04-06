package by.it.kameisha.jd02_04;

import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;
import by.it.kameisha.calc.interfaces.Repository;
import by.it.kameisha.calc.repository.VarMapRepository;
import by.it.kameisha.calc.service.Parser;
import by.it.kameisha.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void add() throws CalcException {
        Var var = parser.calc("{{2,3,1},{10,4,3}}+({{6,3,10},{4,3,2}}+1)");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{{9.0, 7.0, 12.0}, {15.0, 8.0, 6.0}}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void sub() throws CalcException {
        Var var = parser.calc("{{2,3,1},{10,4,3}}-({{6,3,10},{4,3,2}}-1)");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{{-3.0, 1.0, -8.0}, {7.0, 2.0, 2.0}}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void mulScalar() throws CalcException {
        Var var = parser.calc("{{2,3,1},{10,4,3}}*3");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{{6.0, 9.0, 3.0}, {30.0, 12.0, 9.0}}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void mulVector() throws CalcException {
        Var var = parser.calc("{{2,3},{10,4}}*{6,3}");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{21.0, 72.0}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void mulMatrix() throws CalcException {
        Var var = parser.calc("{{2,3},{10,4}}*{{6,3},{10,4}}");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{{42.0, 18.0}, {100.0, 46.0}}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void div() throws CalcException {
        Var var = parser.calc("{{6,2,10},{4,12,2}}/4");
        String actual = var.toString();
        System.out.println("actual   " + actual);
        String expected = "{{1.5, 0.5, 2.5}, {1.0, 3.0, 0.5}}";
        System.out.println("expected " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @After
    public void tearDown() throws Exception {
    }
}