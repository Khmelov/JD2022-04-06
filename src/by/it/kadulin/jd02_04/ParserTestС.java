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

public class ParserTestС {

    public static final double DELTA = 1e-4;
    private Parser parser;

    @Before
    public void setUp() {
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        parser = new Parser(repository, varCreator);
    }

    @Test
    public void calcMatrixAddOperation() {
        Var actualVar = parser.startCalc("1 + {{4.0, 4.0}, {4.0, 4.0}}");
        String actual = actualVar.toString();
        String expected = "{{5.0, 5.0}, {5.0, 5.0}}";
        assertEquals(expected, actual);

        Var actualVar1 = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}+{{4.0, 4.0}, {4.0, 4.0}}");
        String actual1 = actualVar1.toString();
        String expected1 = "{{8.0, 8.0}, {8.0, 8.0}}";
        assertEquals(expected1, actual1);
    }

    @Test
    public void calcMatrixSubOperation() {
        Var actualVar = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}-1");
        String actual = actualVar.toString();
        String expected = "{{3.0, 3.0}, {3.0, 3.0}}";
        assertEquals(expected, actual);

        Var actualVar1 = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}-{{4.0, 4.0}, {4.0, 4.0}}");
        String actual1 = actualVar1.toString();
        String expected1 = "{{0.0, 0.0}, {0.0, 0.0}}";
        assertEquals(expected1, actual1);
    }

    @Test
    public void calcMatrixMulOperation() {
        Var actualVar = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}*2");
        String actual = actualVar.toString();
        String expected = "{{8.0, 8.0}, {8.0, 8.0}}";
        assertEquals(expected, actual);

        Var actualVar1 = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}*{2.0, 2.0}");
        String actual1 = actualVar1.toString();
        String expected1 = "{16.0, 16.0}";
        assertEquals(expected1, actual1);

        Var actualVar2 = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}*{{4.0, 4.0}, {4.0, 4.0}}");
        String actual2 = actualVar1.toString();
        String expected2 = "{{32.0, 32.0}, {32.0, 32.0}}";
        assertEquals(expected2, actual2);
    }

    @Test
    public void calcMatrixDivOperation() {
        Var actualVar = parser.startCalc("{{4.0, 4.0}, {4.0, 4.0}}/2");
        String actual = actualVar.toString();
        String expected = "{{2.0, 2.0}, {2.0, 2.0}}";
        assertEquals(expected, actual);

    }


    @After
    public void tearDown() {
    }
}