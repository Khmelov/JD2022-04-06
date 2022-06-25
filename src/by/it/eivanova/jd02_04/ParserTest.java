package by.it.eivanova.jd02_04;

import by.it._classwork_.calc.entity.Var;
import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.interfaces.Repository;
import by.it._classwork_.calc.repository.VarMapRepository;
import by.it._classwork_.calc.service.Parser;
import by.it._classwork_.calc.service.VarCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    public static final double DELTA = 1e-4;
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        Repository repository = new VarMapRepository();
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

    //вектор C
    @Test
    public void calcScalarOperationC() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        Var actualVar = parser.calc("C=B+(A*2)");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=40.15;
        assertEquals(expected,actual, DELTA);
    }

    //вектор D
    @Test
    public void calcVectorOperationD() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        Var actualVar = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual=Double.parseDouble(actualVar.toString());
        double expected=10;
        assertEquals(expected,actual, DELTA);
    }

    //вектор E
    @Test
    public void calcVectorOperationE() throws CalcException {
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("C=B+(A*2)");
        parser.calc("D=((C-0.15)-20)/(7-5)");
        Var actualVar = parser.calc("E={2,3}*(D/2)");
        double actual=Double.parseDouble(actualVar.toString());
        int[] expected= new int[]{10, 15};
        assertEquals(String.valueOf(expected),actual, new double[]{DELTA});
    }




    // матрица
    @Test
    public void calcVectorOperationM() throws CalcException {
//        parser.calc("A=2+5.3");
//        parser.calc("B=A*3.5");
//        parser.calc("C=B+(A*2)");
//        parser.calc("D=((C-0.15)-20)/(7-5)");
//        Var actualVar = parser.calc("E={2,3}*(D/2)");
//        double actual=Double.parseDouble(actualVar.toString());
//        int[] expected= new int[]{10, 15};
//        assertEquals(String.valueOf(expected),actual, new double[]{DELTA});
    }


    @After
    public void tearDown() throws Exception {
    }
}