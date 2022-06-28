package by.it.kadulin.jd02_04;

import by.it.kadulin.calc.entity.Var;

import by.it.kadulin.calc.interfaces.Repository;
import by.it.kadulin.calc.repository.VarMapRepository;
import by.it.kadulin.calc.service.Parser;
import by.it.kadulin.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestA {

    public static final double DELTA = 1e-4;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository,varCreator);
    }

    @Test
    public void calcScalarOperationA() {
        Var actualVar = parser.startCalc("A=2+5.3");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=7.3;
        assertEquals(expected,actual, DELTA);
    }

    @Test
    public void calcScalarOperationB() {
        parser.startCalc("A=2+5.3");
        Var actualVar = parser.startCalc("B=A*3.5");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=25.55;
        assertEquals(expected,actual, DELTA);

    }

    @Test
    public void calcScalarOperationB1() {
        parser.startCalc("A=2+5.3");
        parser.startCalc("B=A*3.5");
        Var actualVar = parser.startCalc("B1=B+0.11*-5");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=25;
        assertEquals(expected,actual, DELTA);
    }

    @Test
    public void calcScalarOperationB2() {
        parser.startCalc("A=2+5.3");
        Var actualVar = parser.startCalc("B2=A/2-1");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=2.65;
        assertEquals(expected,actual, DELTA);
    }
    @After
    public void tearDown() {
    }
}