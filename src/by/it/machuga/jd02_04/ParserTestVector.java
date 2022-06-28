package by.it.machuga.jd02_04;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.Repository;
import by.it.machuga.calc.repasitory.VarMapRepository;
import by.it.machuga.calc.servise.Parser;
import by.it.machuga.calc.servise.VarCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestVector {

    private Parser parser;

    @Before
    public void setUp() {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void calcAddVectorScalar() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}+3");
        String actual = actualVar.toString();
        String expected = "{15.0, 6.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcAddVectorVectorPositive() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}+{3,-3}");
        String actual = actualVar.toString();
        String expected = "{15.0, 0.0}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcAddVectorVectorNegative() throws CalculatorException {
        parser.calc("{12,3}+{3,-3,5}");
    }

    @Test
    public void calcSubVectorScalar() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}-3");
        String actual = actualVar.toString();
        String expected = "{9.0, 0.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcSubVectorVectorPositive() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}-{3,-3}");
        String actual = actualVar.toString();
        String expected = "{9.0, 6.0}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcSubVectorVectorNegative() throws CalculatorException {
        parser.calc("{12,3}-{3,-3,5}");
    }

    @Test
    public void calcMulVectorScalar() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}*3");
        String actual = actualVar.toString();
        String expected = "{36.0, 9.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMulVectorVectorPositive() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}*{3,-3}");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 27;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);
    }

    @Test(expected = CalculatorException.class)
    public void calcMulVectorVectorNegative() throws CalculatorException {
        parser.calc("{12,3}*{3,-3,5}");
    }

    @Test
    public void calcDivVectorScalar() throws CalculatorException {
        Var actualVar = parser.calc("{12,3}/3");
        String actual = actualVar.toString();
        String expected = "{4.0, 1.0}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcDivVectorVectorNegative() throws CalculatorException {
        parser.calc("{12,3,3}/{3,-5}");
    }

    @Test(expected = CalculatorException.class)
    public void calcDivVectorScalarNegative() throws CalculatorException {
        parser.calc("{12,3,3}/0");
    }
}