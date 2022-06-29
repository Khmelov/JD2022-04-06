package by.it._examples_.jd02_04;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcServiceTest {

    @Test
    public void testGetVar() {
        assertEquals("Ошибка в Parser.GetVar", -123, Parser.GetVar("-123"));
    }

    @Test
    public void testGetVar2() {
        assertEquals("Ошибка в Parser.GetVar", 123, Parser.GetVar("123"));
    }
}