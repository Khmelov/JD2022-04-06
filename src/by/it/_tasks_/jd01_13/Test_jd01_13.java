package by.it._tasks_.jd01_13;

import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_13 extends HomeWork {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        StringBuilder sb = new StringBuilder("\n--- all starts ---\n");
        for (int i = 0; i < 15; i++) {
            sb.append("run ").append(i).append(": ")
                    .append(run("")
                            .include("java.lang.")
                            .include("Exception")
                            .include("line:")
                            .include(".TaskA")
                            .strOut.toString());
        }
        assertTrue("В выводе нет NumberFormatException", sb.toString().contains("NumberFormatException"));
        assertTrue("В выводе нет NullPointerException", sb.toString().contains("NullPointerException"));
        System.out.println(sb);
    }


    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        run("2\n3\n4\n55\nEND\n")
                .include("1.41")
                .include("2.23")
                .include("8.0")
                .exclude("Exception")
        ;
        run("foo\nEND\n")
                .include("NumberFormatException")
                .exclude("ArithmeticException")
                .include("line:")
                .include(".jd01_13.TaskB")
        ;
        run("-2.0\n6.0\nEND\n")
                .include("ArithmeticException")
                .include("line:")
                .include(".jd01_13.TaskB")
                .exclude("NumberFormatException")
        ;
    }


    @Test(timeout = 6000, expected = Exception.class)
    public void testTaskC() throws Exception {

        long t = System.currentTimeMillis();
        HomeWork instance = run("1\n2\nerr1\n3\n4\nerr2\nerr3\nerr4\nerr5\n5.0\nerr6");
        instance.include("4.0 3.0 2.0 1.0").exclude("5.0");
        t = System.currentTimeMillis() - t;
        System.out.println(t);
        assertTrue("Таймаут работает неверно. Ошибка диапазона (400 ms <= your t:" + t + " <= 2000 ms)", (t > 400 && t < 2000));
        Method method = instance.findMethod(instance.aClass, "readData");
        method.setAccessible(true);
        method.invoke(null); //читаем 5.0 - ок
        method.invoke(null); //читаем err6 - тут ждем любую ошибку
        fail("метод readData не генерирует никаких исключений после 5 ошибок");
    }


}
