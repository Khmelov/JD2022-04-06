package by.it._tasks_.jd01_01;

import by.it.HomeWork;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_01 extends HomeWork {


    @Test(timeout = 1500)
    public void testTaskA1() {
        run("").include("Hello world!");
    }

    @Test(timeout = 1500)
    public void testTaskA2() {
        run("").include(
                "Я начинаю изучать Java!\n" +
                        "Я начинаю изучать Java!\n" +
                        "Я начинаю изучать Java!\n" +
                        "Я начинаю изучать Java!\n" +
                        "Я начинаю изучать Java!\n"
        );
    }

    @Test(timeout = 1500)
    public void testTaskA3() {
        run("").include("3*3+4*4=25");
    }

    @Test(timeout = 1500)
    public void testTaskB1() {
        run("7").include("49");
    }

    @Test(timeout = 1500)
    public void testTaskB2() {
        run("").include("20");
    }

    @Test(timeout = 1500)
    public void testTaskB3() {
        run("").include("C началом курса");
    }

    @Test(timeout = 1500)
    public void testTaskC1() {
        run("7\n3\n").include("Sum = 10\n");
    }

    @Test(timeout = 1500)
    public void testTaskC2() {
        run("34\n26\n").include(
                "DEC:34+26=60\n" +
                        "BIN:100010+11010=111100\n" +
                        "HEX:22+1a=3c\n" +
                        "OCT:42+32=74\n");
    }

    @Test(timeout = 1500)

    public void testTaskC3() throws Exception {
        run("75\n").include("29.51\n");
        HomeWork t = run("100\n").include("39.35\n");
        Method m = checkMethod(t.aClass.getSimpleName(), "getWeight", int.class);
        assertEquals((Double) m.invoke(null, 100), 39.35, 1e-100);
        assertEquals((Double) m.invoke(null, 75), 29.51, 1e-100);
    }
}
