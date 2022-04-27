package by.it._classwork_.jd01_01;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.*;


//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_01 {


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
        run("7\n3\n").include("Sum = 10");
    }

    @Test(timeout = 1500)
    public void testTaskC2() {
        run("34\n26\n")
                .include("DEC:34+26=60")
                .include("BIN:100010+11010=111100")
                .include("HEX:22+1a=3c")
                .include("OCT:42+32=74");
    }

    @Test(timeout = 1500)

    public void testTaskC3() throws Exception {
        run("75\n").include("29.51");
        Test_jd01_01 t = run("100\n").include("39.35");
        Method m = checkMethod(t.aClass.getSimpleName(), "getWeight", int.class);
        assertEquals((Double) m.invoke(null, 100), 39.35, 1e-100);
        assertEquals((Double) m.invoke(null, 75), 29.51, 1e-100);
    }
/*
===========================================================================================================
НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
Но изучить как он работает - можно, это всегда будет полезно.
===========================================================================================================
 */

    //-------------------------------  методы ----------------------------------------------------------
    private Class<?> findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nERROR:Тест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    protected Method checkMethod(String className, String methodName, Class<?>... parameters) {
        Class<?> aClass = this.findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            assert aClass != null;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = aClass.getDeclaredMethod(methodName, parameters);
                if (Modifier.isStatic(m.getModifiers())) {
                    fail("\nERROR:Метод " + m.getName() + " должен быть статическим");
                }
            } else {
                m = aClass.getDeclaredMethod(methodName, parameters);
            }
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.println("\nERROR:Не найден метод " + methodName + " либо у него неверная сигнатура");
            System.err.println("ERROR:Ожидаемый класс: " + className);
            System.err.println("ERROR:Ожидаемый метод: " + methodName);
            throw new RuntimeException(e);
        }
    }

    private Method findMethod(Class<?> cl, String name, Class<?>... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nERROR:Тест не пройден. Метод " + cl.getName() + "." + name + " не найден\n");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            method.setAccessible(true);
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nERROR:Не удалось вызвать метод " + method.getName() + "\n");
        }
        return null;
    }


    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    protected Test_jd01_01 run(String in) {
        return run(in, true);
    }

    private Test_jd01_01 run(String in, boolean runMain) {
        StackTraceElement element = Stream.of(new Throwable().getStackTrace())
                .filter(e -> e.getMethodName().startsWith("test"))
                .findFirst()
                .orElse(null);
        assert element != null;
        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = clName.replaceFirst(".+__", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName);
        if (!in.isEmpty()) System.out.println("input:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_01(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_01() {
    }

    //переменные теста
    public Class<?> aClass; //тестируемый класс
    private final PrintStream oldOut = System.out; //исходный поток вывода
    private final PrintStream newOut; //поле для перехвата потока вывода
    private final StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_01(String className, String in, boolean runMain) {
        aClass = null;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("ERROR:Не найден класс " + className + "\n");
        }
        InputStream reader = new ByteArrayInputStream(in.getBytes());
        System.setIn(reader);   //перехват стандартного ввода
        System.setOut(newOut);  //перехват стандартного вывода

        if (runMain) //если нужно запускать, то запустим, иначе оставим только вывод
            try {
                Class<?>[] argTypes = new Class[]{String[].class};
                Method main = aClass.getDeclaredMethod("main", argTypes);
                main.invoke(null, (Object) new String[]{});
                System.setOut(oldOut); //возврат вывода, нужен, только если был запуск
            } catch (NoSuchMethodException e) {
                fail("ERROR:В классе " + aClass.getSimpleName() + " нет метода \"public static void main\"");
            } catch (IllegalAccessException | InvocationTargetException e) {
                fail("ERROR:В классе " + aClass.getSimpleName() + "не удалось выполнить метод \"public static void main\"");
            }
    }


    //проверка вывода
    private Test_jd01_01 is(String str) {
        assertEquals("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString(),
                str);
        return this;
    }

    public Test_jd01_01 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n",
                strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_01 exclude(String str) {
        assertFalse("ERROR:Лишние данные в выводе: " + str + "\n",
                strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_01 matches(String regexp) {
        assertTrue("ERROR:вывод не соответствует паттерну: " + regexp + "\n",
                strOut.toString().matches(regexp));
        return this;
    }

    private Test_jd01_01 find(String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(strOut.toString());
        assertFalse("ERROR:вывод не содержит паттерн: " + regexp + "\n",
                matcher.find());
        return this;
    }


    //логический блок перехвата вывода
    {
        newOut = new PrintStream(new OutputStream() {
            private byte[] bytes = new byte[1];
            private int pos = 0;

            @Override
            public void write(int b) {
                if (pos == 0 && b == '\r') //пропуск \r (чтобы win mac и linux одинаково работали
                    return;
                if (pos == 0) { //определим кодировку https://ru.wikipedia.org/wiki/UTF-8
                    if ((b & 0b11110000) == 0b11110000) bytes = new byte[4];
                    else if ((b & 0b11100000) == 0b11100000) bytes = new byte[3];
                    else if ((b & 0b11000000) == 0b11000000) bytes = new byte[2];
                    else bytes = new byte[1];
                }
                bytes[pos++] = (byte) b;
                if (pos == bytes.length) { //символ готов
                    String s = new String(bytes); //соберем весь символ
                    strOut.append(s); //запомним вывод для теста
                    oldOut.append(s); //копию в обычный вывод
                    pos = 0; //готовим новый символ
                }

            }
        });
    }
}
