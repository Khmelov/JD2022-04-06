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

public class ParserTestB {

    public static final double DELTA = 1e-4;
    private Parser parser;

    @Before
    public void setUp() {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void calcVectorAddOperation() {
        Var actualVar = parser.startCalc("1 + {4.0, 4.0}");
        String actual = actualVar.toString();
        String expected = "{5.0, 5.0}";
        assertEquals(expected, actual);

        Var actualVar1 = parser.startCalc("{2.0, 3.0} + {4.0, 4.0}");
        String actual1 = actualVar1.toString();
        String expected1 = "{6.0, 7.0}";
        assertEquals(expected1, actual1);
    }

    @Test
    public void calcVectorSubOperation() {
        Var actualVar = parser.startCalc("{4.0,4.0}-1");
        String actual = actualVar.toString();
        String expected = "{3.0, 3.0}";
        assertEquals(expected, actual);

        Var actualVar1 = parser.startCalc("{2.0, 3.0}-{4.0, 4.0}");
        String actual1 = actualVar1.toString();
        String expected1 = "{-2.0, -1.0}";
        assertEquals(expected1, actual1);
    }

    @Test
    public void calcVectorMulOperation() {
        Var actualVar = parser.startCalc("2*{4.0,4.0}");
        String actual = actualVar.toString();
        String expected = "{8.0, 8.0}";
        assertEquals(expected, actual);

        Var actualVar1 = parser.startCalc("{2.0, 3.0}*{4.0, 4.0}");
        double actual1 = Double.parseDouble(actualVar1.toString());
        double expected1 = 20.;
        assertEquals(expected1, actual1, DELTA);
    }

    @Test
    public void calcVectorDivOperation() {
        Var actualVar = parser.startCalc("{4.0,4.0}/2");
        String actual = actualVar.toString();
        String expected = "{2.0, 2.0}";
        assertEquals(expected, actual);

    }

    @After
    public void tearDown() {
    }
}