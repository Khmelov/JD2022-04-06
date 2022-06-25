package by.it.arsenihlaz.calculator.tests;

import by.it.arsenihlaz.calculator.entity.Var;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Repository;
import by.it.arsenihlaz.calculator.repository.VarMapRepository;
import by.it.arsenihlaz.calculator.services.Parser;
import by.it.arsenihlaz.calculator.services.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calcScalarOperation() throws CalcException {
        String expression = "A=2+5*4";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 22.0;
        assertEquals(expected,actual,1e-4);
    }
}