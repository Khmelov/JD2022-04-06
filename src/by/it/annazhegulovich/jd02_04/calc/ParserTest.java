package by.it.annazhegulovich.jd02_04.calc;

import by.it.annazhegulovich.jd02_04.calc.entity.Var;
import by.it.annazhegulovich.jd02_04.calc.exception.CalcException;
import by.it.annazhegulovich.jd02_04.calc.interfaces.Repository;
import by.it.annazhegulovich.jd02_04.calc.repository.VarMapRepository;
import by.it.annazhegulovich.jd02_04.calc.service.Parser;
import by.it.annazhegulovich.jd02_04.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {


    public static final double DELTA=1e-10;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository varMapRepository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(varMapRepository);
        parser = new Parser(varMapRepository, varCreator);
    }


    @Test
    public void calcScalarOperationA() throws CalcException {

        Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calcScalarOperationB() throws CalcException {

        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calcScalarOperationB1() throws CalcException {

        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calcScalarOperationB2() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar =parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void calcMatrixAddMatrix() throws CalcException {

        Var actualVar = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}");
        String actual = actualVar.toString();
        String expected = "{{2.0, 4.0}, {16.0, 6.0}}";
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
    }
}