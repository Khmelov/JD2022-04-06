package by.it.machuga.calc;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.Repository;
import by.it.machuga.calc.repasitory.VarMapRepository;
import by.it.machuga.calc.servise.Parser;
import by.it.machuga.calc.servise.VarBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestScalar {

    private Parser parser;

    @Before
    public void setUp() {
        Repository repository = new VarMapRepository();
        VarBuilder varBuilder = new VarBuilder(repository);
        parser = new Parser(repository, varBuilder);
    }

    @Test
    public void calcScalarOperationSum() throws CalculatorException {
        Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarOperationMul() throws CalculatorException {
        parser.calc("A=2+5.3");

        Var actualVar = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarOperationSub() throws CalculatorException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");

        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarOperationDiv() throws CalculatorException {
        parser.calc("A=2+5.3");

        Var actualVar = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test(expected = CalculatorException.class)
    public void calcScalarOperationDivByZero() throws CalculatorException {
        parser.calc("A=2+5.3");
        parser.calc("B2=A/0-1");
    }
}