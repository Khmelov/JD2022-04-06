package by.it._tasks_.jd01_08;


import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_08 extends HomeWork {

    @Test(timeout = 5000)
    public void testTaskA0_constructors__Scalar() throws Exception {
        HomeWork ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        System.out.println("Создание переменной типа Scalar на основе числа 0.12345");
        Object scalar = c.newInstance(0.12345);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345"
                , "0.12345", scalar.toString());
        System.out.println("выполнено успешно. Scalar=" + scalar);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        c = ok.aClass.getDeclaredConstructor(double.class);
        scalar = c.newInstance(0.12345);
        c = ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Scalar на основе объекта Scalar(0.12345)");
        scalar = c.newInstance(scalar);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345"
                , "0.12345", scalar.toString());
        System.out.println("выполнено успешно. Scalar=" + scalar);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        c = ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Scalar на основе строки 0.12345");
        scalar = c.newInstance("0.12345");
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345"
                , "0.12345", scalar.toString());
        System.out.println("выполнено успешно. Scalar=" + scalar);
    }


    @Test(timeout = 5000)
    public void testTaskA1_add__Scalar() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "add";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 + 4.56 работает некорректно"
                , 5.79, res, 1e-10);
    }


    @Test(timeout = 5000)
    public void testTaskA2_sub__Scalar() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "sub";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 - 4.56 работает некорректно"
                , -3.33, res, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskA3_mul__Scalar() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "mul";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 * 4.56 работает некорректно"
                , 5.6088, res, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskA4_div__Scalar() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "div";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 / 4.56 работает некорректно"
                , 0.269736842105263, res, 1e-10);
    }


    @Test(timeout = 5000)
    public void testTaskB0_constructors__Vector() throws Exception {
        HomeWork ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        System.out.println("Создание переменной типа Vector на основе массива {1,2,4}");
        Object vector = c.newInstance(new double[]{1, 2, 4});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}"
                , "{1.0, 2.0, 4.0}", vector.toString());
        System.out.println("выполнено успешно. Vector=" + vector);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        c = ok.aClass.getDeclaredConstructor(double[].class);
        vector = c.newInstance(new double[]{1, 2, 4});
        c = ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Vector на основе объекта Vector({1,2,4})");
        vector = c.newInstance(vector);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}"
                , "{1.0, 2.0, 4.0}", vector.toString());
        System.out.println("выполнено успешно. Vector=" + vector);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        c = ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Vector на основе строки {1,2,4}");
        vector = c.newInstance("{1,2,4}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}"
                , "{1.0, 2.0, 4.0}", vector.toString());
        System.out.println("выполнено успешно. Vector=" + vector);
    }


    @Test(timeout = 5000)
    public void testTaskB1_add__Vector() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "add";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {1,2,3} + {4,5,6} работает некорректно"
                , "{5.0, 7.0, 9.0}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} + 1.0 работает некорректно"
                , "{2.0, 3.0, 4.0}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskB2_sub__Vector() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "sub";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {1,2,3} - {4,5,6} работает некорректно"
                , "{-3.0, -3.0, -3.0}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} - 1.0 работает некорректно"
                , "{0.0, 1.0, 2.0}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskB3_mul__Vector() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "mul";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Скалярное произведение векторов {1,2,3} * {4,5,6} работает некорректно"
                , "32.0", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(2.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} * 2.0 работает некорректно"
                , "{2.0, 4.0, 6.0}", v3.toString());

    }

    @Test(timeout = 5000, expected = Exception.class)
    public void testTaskB4_div__Vector() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "div";
        Method m = findMethod(ok.aClass, op, var);

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        Object v4 = c.newInstance(2.0);
        Object v3 = invoke(m, v1, v4);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} / 2.0 работает некорректно"
                , "{0.5, 1.0, 1.5}", v3.toString());


        v3 = invoke(m, v1, v2);
        if (v3 != null)
            fail("Деление векторов должно возвращать null или генерировать какую-то ошибку");
        else
            throw new NullPointerException("Ок. Получен null при делении векторов");
    }


    @Test(timeout = 5000)
    public void testTaskC0_constructors__Matrix() throws Exception {
        HomeWork ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        Constructor c = ok.aClass.getDeclaredConstructor(double[][].class);
        System.out.println("Создание переменной типа Matrix на основе массива {{1,2},{3,4}}");
        Object matrix = c.newInstance(new Object[]{new double[][]{{1, 2}, {3, 4}}});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}"
                , "{{1.0,2.0},{3.0,4.0}}", matrix.toString().replaceAll(" ", ""));
        System.out.println("выполнено успешно. Matrix=" + matrix);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        c = ok.aClass.getDeclaredConstructor(double[][].class);
        matrix = c.newInstance(new Object[]{new double[][]{{1, 2}, {3, 4}}});
        c = ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Matrix на основе объекта Matrix({{1,2},{3,4}})");
        matrix = c.newInstance(matrix);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}"
                , "{{1.0,2.0},{3.0,4.0}}", matrix.toString().replaceAll(" ", ""));
        System.out.println("выполнено успешно. Matrix=" + matrix);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        c = ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Matrix на основе строки {{1,2},{3,4}}");
        matrix = c.newInstance("{{1,2},{3,4}}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}"
                , "{{1.0,2.0},{3.0,4.0}}", matrix.toString().replaceAll(" ", ""));
        System.out.println("выполнено успешно. Matrix=" + matrix);
    }

    @Test(timeout = 5000)
    public void testTaskС1_add__Matrix() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(String.class);
        Object v1 = c.newInstance("{{1, 2}, {3, 4}}");
        Object v2 = c.newInstance("{{4, 5}, {7, 8}}");
        Class<?> var = v2.getClass().getSuperclass();
        String op = "add";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {{1, 2}, {3, 4}} + {{4, 5}, {7, 8}} работает некорректно"
                , "{{5.0, 7.0}, {10.0, 12.0}}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {{1, 2}, {3, 4}} + 1.0 работает некорректно"
                , "{{2.0, 3.0}, {4.0, 5.0}}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskС2_sub__Matrix() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(String.class);
        Object v1 = c.newInstance("{{1, 2}, {3, 4}}");
        Object v2 = c.newInstance("{{4, 5}, {7, 8}}");
        Class<?> var = v2.getClass().getSuperclass();
        String op = "sub";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {{1, 2}, {3, 4}} - {{4, 5}, {7, 8}} работает некорректно",
                "{{-3.0, -3.0}, {-4.0, -4.0}}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {{1, 2}, {3, 4}} - 1.0 работает некорректно",
                "{{0.0, 1.0}, {2.0, 3.0}}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskС3_mul__Matrix() throws Exception {
        HomeWork ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(String.class);
        Object v1 = c.newInstance("{{1, 2}, {3, 4}}");
        Object v2 = c.newInstance("{{4, 5}, {7, 8}}");
        Class<?> var = v2.getClass().getSuperclass();
        String op = "mul";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {{1, 2}, {3, 4}} * {{4, 5}, {7, 8}} работает некорректно",
                "{{18.0, 21.0}, {40.0, 47.0}}", v3.toString());

        ///проверка операции с вектором
        c = findClass("Vector").getDeclaredConstructor(double[].class);
        v2 = c.newInstance(new double[]{5, 6});
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "с вектором вернул null");
        assertEquals("Операция с вектором {{1, 2}, {3, 4}} * {5, 6} работает некорректно",
                "{17.0, 39.0}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(2.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {{1, 2}, {3, 4}} * 2.0 работает некорректно",
                "{{2.0, 4.0}, {6.0, 8.0}}", v3.toString());
    }

}
