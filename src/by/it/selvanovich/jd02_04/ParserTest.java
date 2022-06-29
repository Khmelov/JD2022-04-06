package by.it.selvanovich.jd02_04;

import by.it.selvanovich.calc.entity.Var;
import by.it.selvanovich.calc.exception.CalcException;
import by.it.selvanovich.calc.interfaces.Repository;
import by.it.selvanovich.calc.repository.VarMapRepository;
import by.it.selvanovich.calc.service.Parser;
import by.it.selvanovich.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    public static final double DELTA = 1e-4;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
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
        Var actualVar = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }


    @Test
    public void calcComplexVectorOperation() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        Var actualVar = parser.calc("E={2,3}*(D/2)");
        String actual = actualVar.toString();
        String expected = "{10.0, 15.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMatrixOperationMulScalar() throws CalcException {
        Var actualVar = parser.calc("{{1,2},{3,4}}*2");
        String actual = actualVar.toString();
        String expected = "{{2.0, 4.0}, {6.0, 8.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMatrixOperationMulVector() throws CalcException {
        Var actualVar = parser.calc("{{2,3},{5,6}}*{3,4}");
        String actual = actualVar.toString();
        String expected = "{18.0, 39.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMatrixOperationMul() throws CalcException {
        Var actualVar = parser.calc("{{2,3},{5,6}}*{{3,4},{6,7}}");
        String actual = actualVar.toString();
        String expected = "{{24.0, 29.0}, {51.0, 62.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMatrixOperationAdd() throws CalcException {
        Var actualVar = parser.calc("{{2,3},{5,6}}+{{3,4},{6,7}}");
        String actual = actualVar.toString();
        String expected = "{{5.0, 7.0}, {11.0, 13.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMatrixOperationSub() throws CalcException {
        Var actualVar = parser.calc("{{9,8},{7,6}}-{{5,4},{3,2}}");
        String actual = actualVar.toString();
        String expected = "{{4.0, 4.0}, {4.0, 4.0}}";
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
    }
}