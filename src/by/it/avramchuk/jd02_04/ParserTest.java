package by.it.avramchuk.jd02_04;

import by.it.avramchuk.calc.entity.Matrix;
import by.it.avramchuk.calc.entity.Scalar;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.entity.Vector;
import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.interfaces.Repository;
import by.it.avramchuk.calc.repository.VarMapRepository;
import by.it.avramchuk.calc.service.Parser;
import by.it.avramchuk.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    public static final double DELTA = 1e-4;
    private Parser parser;


    @Before
    public void setUp(){
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void calcScalarOperation() throws CalcException {
        Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B1=B+0.11*-5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B2=A/2-1");
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calcComplexExpression() throws CalcException {
        Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("C=B+(A*2)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 40.15;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10.0;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("E={2,3}*(D/2)");
        String actualVec = actualVar.toString();
        String expectedVec = "{10.0, 15.0}";
        assertEquals(expectedVec, actualVec);
    }
    @Test
    public void calcVectorOperation() throws CalcException{
        Var actualVar = parser.calc("{2,3}*4");
        String actual = actualVar.toString();
        String expected = "{8.0, 12.0}";
        assertEquals(expected, actual);

        actualVar = parser.calc("{2,3}+{4,5}");
        actual = actualVar.toString();
        expected = "{6.0, 8.0}";
        assertEquals(expected, actual);

        actualVar = parser.calc("{2,3}*{4,5}");
        actual = actualVar.toString();
        expected = "23.0";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMatrixOperation() throws CalcException{
        Var actualVar = parser.calc("{{1,2},{3,4}}*2");
        String actual = actualVar.toString();
        String expected = "{{2.0, 4.0}, {6.0, 8.0}}";
        assertEquals(expected, actual);

        actualVar = parser.calc("{{2,3},{5,6}}*{3,4}");
        actual = actualVar.toString();
        expected = "{18.0, 39.0}";
        assertEquals(expected, actual);

        actualVar = parser.calc("{{2,3},{5,6}}*{{3,4},{6,7}}");
        actual = actualVar.toString();
        expected = "{{24.0, 29.0}, {51.0, 62.0}}";
        assertEquals(expected, actual);

        actualVar = parser.calc("{{2,3},{5,6}}+{{3,4},{6,7}}");
        actual = actualVar.toString();
        expected = "{{5.0, 7.0}, {11.0, 13.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void constructVarOfValue() throws CalcException{
        double forScalar = 4.0;
        Scalar scalar = new Scalar(forScalar);
        String actual = scalar.toString();
        String expected = "4.0";
        assertEquals(expected, actual);

        double[] forVector = new double[] {2.0, 5.0, 7.0};
        Vector vector = new Vector(forVector);
        actual = vector.toString();
        expected = "{2.0, 5.0, 7.0}";
        assertEquals(expected, actual);

        double[][] forMatrix = new double[][] {{2.0, 5.0, 7.0},{3.0, 4.0, 1d}};
        Matrix matrix = new Matrix(forMatrix);
        actual = matrix.toString();
        expected = "{{2.0, 5.0, 7.0}, {3.0, 4.0, 1.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void constructVarOfString() throws CalcException{
        String forScalar = "4.0";
        Scalar scalar = new Scalar(forScalar);
        String actual = scalar.toString();
        String expected = "4.0";
        assertEquals(expected, actual);

        String forVector = "{2.0, 5.0, 7.0}";
        Vector vector = new Vector(forVector);
        actual = vector.toString();
        expected = "{2.0, 5.0, 7.0}";
        assertEquals(expected, actual);

        String forMatrix = "{{2.0, 5.0, 7.0},{3.0, 4.0, 1d}}";
        Matrix matrix = new Matrix(forMatrix);
        actual = matrix.toString();
        expected = "{{2.0, 5.0, 7.0}, {3.0, 4.0, 1.0}}";
        assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
    }
}