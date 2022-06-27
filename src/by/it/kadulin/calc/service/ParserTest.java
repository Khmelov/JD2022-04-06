package by.it.kadulin.calc.service;

import by.it.kadulin.calc.entity.Var;
import by.it.kadulin.calc.repository.VarMapRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private VarMapRepository repository;
    private VarCreator varCreator;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        repository = new VarMapRepository();
        varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void calcScalarOperation() {
        String expression = "A=2+2*2";
        Var actualVar = parser.calcPart(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 6.0;
        double delta = 1e-4;
        assertEquals(expected, actual, delta);

    }

    @After
    public void tearDown() throws Exception {
    }
}