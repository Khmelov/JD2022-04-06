package by.it.eivanova.jd02_04;

import by.it.eivanova.calc.Parser;
import by.it.eivanova.calc.VarCreator;
import by.it.eivanova.calc.VarMapRepository;
import by.it.eivanova.calc.Var;
import by.it.eivanova.calc.CalcException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestA {

    public static final double DELTA = 1e-4;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
       VarMapRepository repository = new VarMapRepository();
       VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository,varCreator);
    }

    //скаляр А
    @Test
    public void calcScalarOperationA() throws CalcException {
        Var actualVar = parser.calc("A=2+5.3");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=7.3;
        assertEquals(expected,actual, DELTA);
    }

    //скаляр B
    @Test
    public void calcScalarOperationB() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B=A*3.5");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=25.55;
        assertEquals(expected,actual, DELTA);

    }

    //скаляр B1
    @Test
    public void calcScalarOperationB1() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=25;
        assertEquals(expected,actual, DELTA);
    }

    //скаляр B2
    @Test
    public void calcScalarOperationB2() throws CalcException {
        parser.calc("A=2+5.3");
        Var actualVar = parser.calc("B2=A/2-1");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=2.65;
        assertEquals(expected,actual, DELTA);
    }

    @After
    public void tearDown() throws Exception {
    }




























}