package by.it._tasks_.jd01_07;


import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_07 extends HomeWork {

    @Test(timeout = 5000)
    public void testTaskA1_double__Scalar() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double.class);
        System.out.println("Создание переменной типа Scalar на основе числа 0.12345");
        Object scalar=c.newInstance(0.12345);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", "0.12345", scalar.toString());
        System.out.println("выполнено успешно. Scalar="+scalar);
    }

    @Test(timeout = 5000)
    public void testTaskA2_Scalar__Scalar() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double.class);
        Object scalar=c.newInstance(0.12345);
        c=ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Scalar на основе объекта Scalar(0.12345)");
        scalar=c.newInstance(scalar);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", "0.12345", scalar.toString());
        System.out.println("выполнено успешно. Scalar="+scalar);
    }

    @Test(timeout = 5000)
    public void testTaskA3_String__Scalar() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Scalar на основе строки 0.12345");
        Object scalar=c.newInstance("0.12345");
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", "0.12345", scalar.toString());
        System.out.println("выполнено успешно. Scalar="+scalar);
    }



    @Test(timeout = 5000)
    public void testTaskB1_double__Vector() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[].class);
        System.out.println("Создание переменной типа Vector на основе массива {1,2,4}");
        Object vector=c.newInstance(new double[]{1,2,4});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", "{1.0, 2.0, 4.0}", vector.toString());
        System.out.println("выполнено успешно. Vector="+vector);
    }

    @Test(timeout = 5000)
    public void testTaskB2_Vector__Vector() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[].class);
        Object vector=c.newInstance(new double[]{1,2,4});
        c=ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Vector на основе объекта Vector({1,2,4})");
        vector=c.newInstance(vector);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", "{1.0, 2.0, 4.0}", vector.toString());
        System.out.println("выполнено успешно. Vector="+vector);
    }

    @Test(timeout = 5000)
    public void testTaskB3_String__Vector() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Vector на основе строки {1,2,4}");
        Object vector=c.newInstance("{1,2,4}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", "{1.0, 2.0, 4.0}", vector.toString());
        System.out.println("выполнено успешно. Vector="+vector);
    }


    @Test(timeout = 5000)
    public void testTaskC1_double__Matrix() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[][].class);
        System.out.println("Создание переменной типа Matrix на основе массива {{1,2},{3,4}}");
        Object matrix=c.newInstance(new Object[]{new double[][]{{1,2},{3,4}}});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", "{{1.0,2.0},{3.0,4.0}}", matrix.toString().replaceAll(" ",""));
        System.out.println("выполнено успешно. Matrix="+matrix);
    }

    @Test(timeout = 5000)
    public void testTaskC2_Matrix__Matrix() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[][].class);
        Object matrix=c.newInstance(new Object[]{new double[][]{{1,2},{3,4}}});
        c=ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Matrix на основе объекта Matrix({{1,2},{3,4}})");
        matrix=c.newInstance(matrix);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", "{{1.0,2.0},{3.0,4.0}}", matrix.toString().replaceAll(" ",""));
        System.out.println("выполнено успешно. Matrix="+matrix);
    }

    @Test(timeout = 5000)
    public void testTaskC3_String__Matrix() throws Exception {
        HomeWork ok=run("",false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Matrix на основе строки {{1,2},{3,4}}");
        Object matrix=c.newInstance("{{1,2},{3,4}}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", "{{1.0,2.0},{3.0,4.0}}", matrix.toString().replaceAll(" ",""));
        System.out.println("выполнено успешно. Matrix="+matrix);
    }

}
