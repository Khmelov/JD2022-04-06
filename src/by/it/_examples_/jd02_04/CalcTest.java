package by.it._examples_.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    @Test
    public void testAdd() {
        int res = Calc.add(1, 2);
        assertEquals(3, res, 0.001);
    }

    @Test
    public void testSub() {
        int res = Calc.sub(1, 2);
        assertEquals(-1, res, 0.001);
    }

    @Test
    public void testMul() {
        int res = Calc.mul(3, 2);
        assertEquals("Ошибка умножения", 6, res);
    }

    @Test
    public void testDiv() {
        assertEquals("Ошибка деления", 2, Calc.div(8, 4));
        assertEquals("Ошибка деления", 2, Calc.div(9, 4));
    }

    @Test
    public void testOst() {
        assertEquals("Ошибка вычисления остатка", 4, Calc.ost(14, 5));
    }
}