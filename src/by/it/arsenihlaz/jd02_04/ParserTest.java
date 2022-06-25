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

public class ParserTest {

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

    @Test
    public void TestScalar_B1() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        String expression = "C=B+(A*2)";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual,1e-4);
    }

    @Test
    public void TestScalar_B2() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        String expression = "D=((C-0.15)-20)/(7-5)";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 10.0;
        assertEquals(expected,actual,1e-4);
    }

    @Test
    public void TestScalar_B3() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        String expression = "{2,3}*(D/2)";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{10.0, 15.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C1() throws CalcException {
        String expression = "{2,2}+5";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{7.0, 7.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C2() throws CalcException {
        String expression = "{12,7}-7";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{5.0, 0.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C3() throws CalcException {
        String expression = "{2,2} * 2";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{4.0, 4.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C4() throws CalcException {
        String expression = "{{2,2}, {2,2}} + {{6, 6}, {6, 6}}";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{{8.0, 8.0}, {8.0, 8.0}}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C5() throws CalcException {
        String expression = "{{2,2},{2,2}}*{2,2}";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{8.0, 8.0}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C6() throws CalcException {
        String expression = "{{2,2}, {2,2}} * {{6, 6}, {6, 6}}";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{{24.0, 24.0}, {24.0, 24.0}}";
        assertEquals(expected,actual);
    }

    @Test
    public void TestScalar_C7() throws CalcException {
        String expression = "{{2, 2, 2}, {2,2,2}} * {{6,6}, {6,6}, {6,6}}";
        Var actualVar = parser.calc(expression);
        String actual = actualVar.toString();
        String expected = "{{36.0, 36.0}, {36.0, 36.0}}";
        assertEquals(expected,actual);
    }

    @After
    public void tearDown() throws Exception {
    }
}