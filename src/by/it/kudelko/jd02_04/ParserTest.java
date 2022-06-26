package by.it.kudelko.jd02_04;

import by.it.kudelko.calc.entity.Var;
import by.it.kudelko.calc.exception.CalcException;
import by.it.kudelko.calc.interfaces.Repository;
import by.it.kudelko.calc.repository.VarMapRepository;
import by.it.kudelko.calc.service.Parser;
import by.it.kudelko.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void calcScalarOpearationA() throws CalcException {
        String expression = "A=2+5.3";
        Parser parser = this.parser;
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        double delta = 1e-10;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void calcScalarOpearationB() throws CalcException {
        parser.calc("A=2+5.3");
        Parser parser = this.parser;
        Var actualVar = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        double delta = 1e-10;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarOpearationB1() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Parser parser = this.parser;
        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        double delta = 1e-10;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarOpearationB2() throws CalcException {
        parser.calc("A=2+5.3");
        Parser parser = this.parser;
        Var actualVar = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        double delta = 1e-10;
        assertEquals(expected, actual, delta);
    }

    @After
    public void tearDown() throws Exception {
    }
}