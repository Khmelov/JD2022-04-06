package by.it.kameisha.jd02_04;

import by.it.kameisha.calc.Parser;
import by.it.kameisha.calc.Repository;
import by.it.kameisha.calc.VarCreator;
import by.it.kameisha.calc.VarMapRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private Parser parser;
    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void add() {
    }

    @Test
    public void sub() {
    }

    @Test
    public void mul() {
    }

    @Test
    public void div() {
    }
}