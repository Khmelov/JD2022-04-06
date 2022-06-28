package by.it.machuga.jd02_04;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.repasitory.Repository;
import by.it.machuga.calc.repasitory.VarMapRepository;
import by.it.machuga.calc.servise.Parser;
import by.it.machuga.calc.servise.VarBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestMatrix {

    private Parser parser;

    @Before
    public void setUp() {
        Repository repository = new VarMapRepository();
        VarBuilder varBuilder = new VarBuilder(repository);
        parser = new Parser(repository, varBuilder);
    }

    @Test
    public void calcAddMatrixScalar() throws CalculatorException {
        Var actualVar = parser.calc("{{12,3},{5,2}}+3");
        String actual = actualVar.toString();
        String expected = "{{15.0, 6.0}, {8.0, 5.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcAddMatrixMatrixPositive() throws CalculatorException {
        Var actualVar = parser.calc("{{12,3},{5,2}}+{{12,3},{5,2}}");
        String actual = actualVar.toString();
        String expected = "{{24.0, 6.0}, {10.0, 4.0}}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcAddMatrixMatrixNegative() throws CalculatorException {
        parser.calc("{{12,3,6},{5,8,2}}+{{12,3},{5,2}}");
    }

    @Test(expected = CalculatorException.class)
    public void calcAddMatrixVectorNegative() throws CalculatorException {
        parser.calc("{{24.0, 6.0}, {10.0, 4.0}}+{3,-3,5}");
    }

    @Test
    public void calcSubMatrixScalar() throws CalculatorException {
        Var actualVar = parser.calc("{{24.0, 6.0}, {10.0, 4.0}}-3");
        String actual = actualVar.toString();
        String expected = "{{21.0, 3.0}, {7.0, 1.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcSubMatrixMatrixPositive() throws CalculatorException {
        Var actualVar = parser.calc("{{12,3},{5,2}}-{{12,3},{5,2}}");
        String actual = actualVar.toString();
        String expected = "{{0.0, 0.0}, {0.0, 0.0}}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcSubMatrixMatrixNegative() throws CalculatorException {
        parser.calc("{{12,3,6},{5,8,2}}-{{12,3},{5,2}}");
    }

    @Test(expected = CalculatorException.class)
    public void calcSubMatrixVectorNegative() throws CalculatorException {
        parser.calc("{{24.0, 6.0}, {10.0, 4.0}}-{3,-3,5}");
    }

    @Test
    public void calcMulMatrixScalar() throws CalculatorException {
        Var actualVar = parser.calc("{{24.0, 6.0}, {10.0, 4.0}}*3");
        String actual = actualVar.toString();
        String expected = "{{72.0, 18.0}, {30.0, 12.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMulMatrixMatrixPositive() throws CalculatorException {
        Var actualVar = parser.calc("{{4,3},{5,2}}*{{2,3},{5,2}}");
        String actual = actualVar.toString();
        String expected = "{{23.0, 18.0}, {20.0, 19.0}}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcMulMatrixMatrixNegative() throws CalculatorException {
        parser.calc("{{12,3,6},{5,8,2}}*{{12,3},{5,2}}");
    }

    @Test
    public void calcMulMatrixVectorPositive() throws CalculatorException {
        Var actualVar = parser.calc("{{24.0, 6.0}, {10.0, 4.0}}*{3,-3}");
        String actual = actualVar.toString();
        String expected = "{54.0, 18.0}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcMulMatrixVectorNegative() throws CalculatorException {
        parser.calc("{{24.0, 6.0}, {10.0, 4.0}}*{3,-3,5}");
    }

    @Test
    public void calcDivMatrixScalar() throws CalculatorException {
        Var actualVar = parser.calc("{{24.0, 6.0}, {9.0, 3.0}}/3");
        String actual = actualVar.toString();
        String expected = "{{8.0, 2.0}, {3.0, 1.0}}";
        assertEquals(expected, actual);
    }

    @Test(expected = CalculatorException.class)
    public void calcDivMatrixScalarZero() throws CalculatorException {
        Var actualVar = parser.calc("{{4,3},{5,2}}/0");
    }

    @Test(expected = CalculatorException.class)
    public void calcDivMatrixMatrixNegative() throws CalculatorException {
        parser.calc("{{12,3,6},{5,8,2}}/{{12,3},{5,2}}");
    }

    @Test(expected = CalculatorException.class)
    public void calcDivMatrixVectorNegative() throws CalculatorException {
        parser.calc("{{24.0, 6.0}, {10.0, 4.0}}/{3,-3,5}");
    }
}