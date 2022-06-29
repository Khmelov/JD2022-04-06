package by.it.machuga.calc;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.Repository;
import by.it.machuga.calc.repasitory.VarMapRepository;
import by.it.machuga.calc.servise.Parser;
import by.it.machuga.calc.servise.VarBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestBraces {

    private Parser parser;

    @Before
    public void setUp() {
        Repository repository = new VarMapRepository();
        VarBuilder varBuilder = new VarBuilder(repository);
        parser = new Parser(repository, varBuilder);
    }

    @Test
    public void calcScalarOneBrace() throws CalculatorException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");

        Var actualVar = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarMultiBrace() throws CalculatorException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");

        Var actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 10;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void calcScalarBraceAndVector() throws CalculatorException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");

        Var actualVar = parser.calc("E={2,3}*(D/2)");
        String actual = actualVar.toString();
        String expected = "{10.0, 15.0}";
        assertEquals(expected, actual);
    }
}