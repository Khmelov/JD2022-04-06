package by.it.smirnov.jd02_04;

import by.it.smirnov.calc.entity.Matrix;
import by.it.smirnov.calc.entity.Scalar;
import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.entity.Vector;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;
import by.it.smirnov.calc.repository.PersistentRepository;
import by.it.smirnov.calc.service.Parser;
import by.it.smirnov.calc.service.VarCreator;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalcJUnit5Test {
    private Parser parser;
    private static final double DELTA = 1e-4;
    private static final String EXPR_A = "A=2+5.3";
    private static final String EXPR_B = "B=A*3.5";
    private static final String EXPR_C = "C=B+(A*2)";

    @BeforeEach
    public void setUp() {
        Repository repo = new PersistentRepository();
        parser = new Parser(repo, new VarCreator(repo));
    }

    @Test
    @Order(1)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcA() throws CalcException {
        Var actualVar = parser.calc(EXPR_A);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @Order(2)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcB() throws CalcException {
        parser.calc(EXPR_A);
        Var actualVar = parser.calc(EXPR_B);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @Order(3)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcB1() throws CalcException {
        parser.calc(EXPR_A);
        parser.calc(EXPR_B);
        Var actualVar = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @Order(4)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcB2() throws CalcException {
        parser.calc(EXPR_A);
        Var actualVar = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @Order(5)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcC() throws CalcException {
        parser.calc(EXPR_A);
        parser.calc(EXPR_B);
        Var actualVar = parser.calc(EXPR_C);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @Order(6)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcD() throws CalcException {
        parser.calc(EXPR_A);
        parser.calc(EXPR_B);
        parser.calc(EXPR_C);
        Var actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 10;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @Order(7)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcE() throws CalcException {
        parser.calc(EXPR_A);
        parser.calc(EXPR_B);
        parser.calc(EXPR_C);
        parser.calc("D=((C-0.15)-20)/(7-5)");
        Var actualVar = parser.calc("E={2,3}*(D/2)");
        String actual = actualVar.toString();
        String expected = "{10,15}";
        assertEquals(expected, actual);
    }

    @Test
    @Order(8)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcMatrixScalar() throws CalcException {
        Var actualVar1 = parser.calc("{{1.0,2.0},{3.0,4.0}}+8.6");
        String actual1 = actualVar1.toString();
        String expected1 = "{{9.6,10.6},{11.6,12.6}}";

        Var actualVar2 = parser.calc("{{100.0,1.0},{200.0,200.0}}-70.5");
        String actual2 = actualVar2.toString();
        String expected2 = "{{29.5,-69.5},{129.5,129.5}}";

        Var actualVar3 = parser.calc("{{1,2},{3,4}}*18.0");
        String actual3 = actualVar3.toString();
        String expected3 = "{{18,36},{54,72}}";

        assertAll("Проверка операций матрицы со скалярами",
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2),
                () -> assertEquals(expected3, actual3)
        );
    }

    @Test
    @Order(9)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void calcMatrixMatrix() throws CalcException {
        Var actualVar1 = parser.calc("{{1.0,2.0},{3.0,4.0}}+{{4.0,3.0},{2.0,1.0}}");
        String actual1 = actualVar1.toString();
        String expected1 = "{{5,5},{5,5}}";

        Var actualVar2 = parser.calc("{{1.0,2.0},{3.0,4.0}}-{{4.0,3.0},{2.0,1.0}}");
        String actual2 = actualVar2.toString();
        String expected2 = "{{-3,-1},{1,3}}";

        Var actualVar3 = parser.calc("{{1.0,2.0},{3.0,4.0}}*{{4.0,3.0},{2.0,1.0}}");
        String actual3 = actualVar3.toString();
        String expected3 = "{{8,5},{20,13}}";

        assertAll("Проверка операций матрицы с матрицами",
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2),
                () -> assertEquals(expected3, actual3)
        );
    }

    @Test
    @Order(10)
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void operandInputToString() {
        String inputScalar1 = "58";
        String inputScalar2 = "58.0";
        String inputVector = "{1, 2.0, 3.6}";
        String inputMatrix = "{{1.0, 2.0},{3, 4}, {5.0,10}}";

        Scalar scalar1 = new Scalar(inputScalar1);
        Scalar scalar2 = new Scalar(inputScalar2);
        Vector vector = new Vector(inputVector);
        Matrix matrix = new Matrix(inputMatrix);

        assertAll("Сравнение случаев создания и вывода различных переменных",
                () -> assertEquals(Double.parseDouble(inputScalar1), Double.parseDouble(scalar1.toString()), DELTA),
                () -> assertEquals(Double.parseDouble(inputScalar2), Double.parseDouble(scalar2.toString()), DELTA),
                () -> assertEquals("{1,2,3.6}", vector.toString()),
                () -> assertEquals("{{1,2},{3,4},{5,10}}", matrix.toString())
        );
    }

    @AfterAll
    static void tearDown() {
        out.println("Test accomplished");
    }
}