package by.it.ragach.calc;

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
}