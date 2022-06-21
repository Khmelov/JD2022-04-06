package by.it.arsenihlaz.jd02_04;

import by.it.arsenihlaz.Calculator.entity.Var;
import by.it.arsenihlaz.Calculator.exception.CalcException;
import by.it.arsenihlaz.Calculator.interfaces.Repository;
import by.it.arsenihlaz.Calculator.repository.VarMapRepository;
import by.it.arsenihlaz.Calculator.services.Parser;
import by.it.arsenihlaz.Calculator.services.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestA {

    private Repository repository;
    private VarCreator varCreator;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        repository = new VarMapRepository();
        varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void TestScalar_A1() throws CalcException {
        String expression = "A=2+5.3";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected,actual,1e-4);
    }

    @Test
    public void TestScalar_A2() throws CalcException {
        parser.calc("A=2+5.3");
        String expression = "B=A*3.5";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        assertEquals(expected,actual,1e-4);
    }

    @Test
    public void TestScalar_A3() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        String expression = "B1=B+0.11*-5";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        assertEquals(expected,actual,1e-4);
    }

    @Test
    public void TestScalar_A4() throws CalcException {
        parser.calc("A=2+5.3");
        String expression = "B2=A/2-1";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        assertEquals(expected,actual,1e-4);
    }

    @After
    public void tearDown() throws Exception {
    }
}