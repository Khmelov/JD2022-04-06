package by.it.ragach.jd02_04;

import by.it.ragach.calc.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestMatrix {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calcAddMatrixScalar() throws CalcException {
        Var actualVar = parser.calc("{{8,8},{4,5}}+3");
        String actual = actualVar.toString();
        String expected = "{{11.0, 11.0}, {7.0, 8.0}}";
        assertEquals(expected, actual);

    }

    @Test
    public void calcAddMatrixMatrix()throws CalcException{
        Var actualVar = parser.calc("{{1,2,3},{1,2,3}}+{{1,2,3},{1,2,3}}");
        String actual = actualVar.toString();
        String expected = "{{2.0, 4.0}, {2.0, 4.0}}";
        assertEquals(expected, actual);

    }

    @Test

    public void calcSubMatrixScalar()throws CalcException{
        Var actualVar = parser.calc("{{24,10},{15,11}}-3");
        String actual = actualVar.toString();
        String expected = "{{21.0, 7.0}, {12.0, 8.0}}";
        assertEquals(expected, actual);

    }
    @Test
    public void calcSubMatrixMatrix()throws CalcException{
        Var actualVar = parser.calc("{{24,10},{15,11}}-{{13,10},{12,9}}");
        String actual = actualVar.toString();
        String expected = "{{11.0, 0.0}, {3.0, 2.0}}";
        assertEquals(expected, actual);

    }

    @Test
    public void calcMulMatrixScalar()throws CalcException{
        Var actualVar = parser.calc("{{24,10},{15,11}}*4");
        String actual = actualVar.toString();
        String expected = "{{96.0, 40.0}, {60.0, 44.0}}";
        assertEquals(expected, actual);

    }

    @Test
    public void calcMulMatrixMatrix()throws CalcException{
        Var actualVar = parser.calc("{{9,6},{5,5}}*{{1,3},{9,7}}");
        String actual = actualVar.toString();
        String expected = "{{63.0, 69.0}, {50.0, 50.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcMulMatrixVector()throws CalcException{
        Var actualVar = parser.calc("{{9,6},{5,5}}*{2,1}");
        String actual = actualVar.toString();
        String expected = "{24.0, 15.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void calcDivMatrixScalar()throws CalcException{
        Var actualVar = parser.calc("{{16,8},{20,4}}/4");
        String actual = actualVar.toString();
        String expected = "{{4.0, 2.0}, {5.0, 1.0}}";
        assertEquals(expected, actual);
    }



}