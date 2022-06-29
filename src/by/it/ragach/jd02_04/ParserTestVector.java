package by.it.ragach.jd02_04;

import by.it.ragach.calc.entity.Var;
import by.it.ragach.calc.exception.CalcException;
import by.it.ragach.calc.interfaces.Repository;
import by.it.ragach.calc.repository.VarMapRepository;
import by.it.ragach.calc.service.Parser;
import by.it.ragach.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestVector {

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
    public void calcAddVectorScalar() throws CalcException {
        Var actualVar = parser.calc("{11,5}+8");
        String actual = actualVar.toString();
        String expected = "{19.0, 13.0}";
        assertEquals(expected, actual);

    }

    @Test
    public void calcAddVectorVector() throws CalcException {
        Var actualVar = parser.calc("{8,8}+{4,5}");
        String actual = actualVar.toString();
        String expected = "{12.0, 13.0}";
        assertEquals(expected, actual);

    }

    @Test

    public void calcSubVectorScalar() throws Exception {
        Var actualVar = parser.calc("{18,6}-4");
        String actual = actualVar.toString();
        String expected = "{14.0, 2.0}";
        assertEquals(expected, actual);
    }


    @Test
    public void calcSubVectorVector() throws Exception {
        Var actualVar = parser.calc("{18,6}-{3,2}");
        String actual = actualVar.toString();
        String expected = "{15.0, 4.0}";
        assertEquals(expected, actual);
    }


    @Test
    public void calcMulVectorVector() throws Exception {
        Var actualVar = parser.calc("{10,4}*{3,5}");
        String actual = actualVar.toString();
        String expected = "50.0";
        assertEquals(expected, actual);
    }


    @Test
    public void calcMulVectorScalar() throws Exception {
        Var actualVar = parser.calc("{10,4}*6");
        String actual = actualVar.toString();
        String expected = "{60.0, 24.0}";
        assertEquals(expected, actual);
    }


    @Test
    public void calcDivVectorScalar()throws Exception{
        Var actualVar = parser.calc("{10,4}/2");
        String actual = actualVar.toString();
        String expected = "{5.0, 2.0}";
        assertEquals(expected, actual);

    }


}


