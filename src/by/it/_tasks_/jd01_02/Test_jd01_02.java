package by.it._tasks_.jd01_02;

import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_02  extends HomeWork {

    @Test(timeout = 5000)
    public void testTaskA() throws Exception {
        System.out.println("\n\nПроверка на минимум и максимум");
        checkMethod("TaskA", "static step1", int[].class);
        run("-1 2 3 4 567 567 4 3 2 -1 4 4").include("-1 567");

        System.out.println("\n\nПроверка на вывод значений меньше среднего");
        checkMethod("TaskA", "static step2", int[].class);
        run("-1 22 33 44 567 567 44 33 22 -1 4 4")
                .include("-1").include("22").include("33").include("44");

        System.out.println("\n\nПроверка на индексы минимума");
        checkMethod("TaskA", "static step3", int[].class);
        run("-1 22 33 44 567 567 44 33 22 -1 4 4").include("9 0");
    }

    @Test(timeout = 5000)
    public void testTaskAstep1_MinMax__TaskA() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step1", int[].class);
        System.out.println("Проверка на массиве -1, 2, 3, 4, 567, 567, 4, 3, 2, -1, 4, 4");
        m.invoke(null, new int[]{-1, 2, 3, 4, 567, 567, 4, 3, 2, -1, 4, 4});
        ok.include("").include("-1 567");
    }

    @Test(timeout = 5000)
    public void testTaskAstep2_Avg__TaskA() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step2", int[].class);
        System.out.println("Проверка на массиве -1, 22, 30+3, 44, 500+67, 500+67, 44, 30+3, 22, -1, 4, 4");
        m.invoke(null, new int[]{-1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4});
        ok.include("").include("-1")
                .include("1").include("2").include("3").include("4")
                .include("22").include("33").include("44").exclude("567");
    }

    @Test(timeout = 5000)
    public void testTaskAstep3_IndexMinMax__TaskA() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step3", int[].class);
        System.out.println("Проверка на массиве -1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4");
        m.invoke(null, new int[]{-1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4});
        ok.include("").include("9 0");
    }

    @Test(timeout = 5000)
    public void testTaskB() throws Exception {
        System.out.println("\n\nПроверка на вывод матрицы 5 x 5");
        checkMethod("TaskB", "step1");
        run("0 1 2 3")
                .include("11 12 13 14 15").include("16 17 18 19 20")
                .include("21 22 23 24 25");
        ;
        System.out.println("\n\nПроверка на ввод номера месяца");
        checkMethod("TaskB", "step2", int.class);
        run("0 2 3 4").include("нет такого месяца");
        run("1 2 3 4").include("январь");
        run("2 2 3 4").include("февраль");
        run("3 2 3 4").include("март");
        run("4 2 3 4").include("апрель");
        run("5 2 3 4").include("май");
        run("6 2 3 4").include("июнь");
        run("7 2 3 4").include("июль");
        run("8 2 3 4").include("август");
        run("9 2 3 4").include("сентябрь");
        run("10 2 3 4").include("октябрь");
        run("11 2 3 4").include("ноябрь");
        run("12 2 3 4").include("декабрь");
        run("13 2 3 4").include("нет такого месяца");

        System.out.println("\n\nПроверка на решение квадратного уравнения");
        checkMethod("TaskB", "step3", double.class, double.class, double.class);
        run("0 2 4 2").include("-1");
        run("0 2 4 0").include("0.0").include("-2.0");
        run("0 2 4 4").include("корней нет");
    }

    @Test(timeout = 5000)
    public void testTaskBstep1_Loop__TaskB() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step1");
        m.invoke(null);
        ok.include("11 12 13 14 15").include("16 17 18 19 20").include("21 22 23 24 25");
    }

    @Test(timeout = 5000)
    public void testTaskBstep2_Switch__TaskB() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step2", int.class);
        m.invoke(null, 0);
        ok.include("нет такого месяца");
        m.invoke(null, 1);
        ok.include("январь");
        m.invoke(null, 2);
        ok.include("февраль");
        m.invoke(null, 3);
        ok.include("март");
        m.invoke(null, 4);
        ok.include("апрель");
        m.invoke(null, 5);
        ok.include("май");
        m.invoke(null, 6);
        ok.include("июнь");
        m.invoke(null, 7);
        ok.include("июль");
        m.invoke(null, 8);
        ok.include("август");
        m.invoke(null, 9);
        ok.include("сентябрь");
        m.invoke(null, 10);
        ok.include("октябрь");
        m.invoke(null, 11);
        ok.include("ноябрь");
        m.invoke(null, 12);
        ok.include("декабрь");
        m.invoke(null, 13);
        ok.include("нет такого месяца");
    }


    @Test(timeout = 5000)
    public void testTaskBstep3_QEquation__TaskB() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step3",
                double.class, double.class, double.class);
        System.out.println("Квадратное уравление:");
        System.out.println("для a=2, для b=4, для c=2, ожидается один корень: минус 1");
        m.invoke(null, 2, 4, 2);
        ok.include("-1");
        System.out.println("для a=1, для b=-1, для c=-2, ожидается два корня: минус один и два ");
        m.invoke(null, 1, -1, -2);
        ok.include("-1").include("2");
        System.out.println("для a=2, для b=4, для c=4, ожидается решение без корней");
        m.invoke(null, 2, 4, 4);
        ok.include("корней нет");
    }

    @Test(timeout = 5000)
    public void testTaskC() throws Exception {
        System.out.println("\n\nПроверка на создание массива TaskC.step1");
        checkMethod("TaskC", "step1", int.class);
        run("3").include("-3").include("3");
        run("4").include("-4").include("4");
        HomeWork ok = run("5").include("-5").include("5");

        System.out.println("\nПроверка на сумму элементов TaskC.step2");
        checkMethod("TaskC", "step2", int[][].class);
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        Method m = ok.aClass.getDeclaredMethod("step2", m4.getClass());
        int sum = (int) ok.invoke(m, null, new Object[]{m4});
        assertEquals("Неверная сумма в step2", -6, sum);

        System.out.println("\nПроверка на удаление максимума TaskC.step3");
        checkMethod("TaskC", "step3", int[][].class);

        m = ok.aClass.getDeclaredMethod("step3", int[][].class);
        int[][] res = (int[][]) ok.invoke(m, null, new Object[]{m4});
        int[][] expectmas = {{-1, 2, -2}, {-2, -2, -6}};
        assertArrayEquals("Не найден ожидаемый массив {{-1,2,-2},{-2,-2,-6}}", expectmas, res);
    }

    @Test(timeout = 5000)
    public void testTaskCstep1_IndexMinMax__TaskC() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step1", int.class);
        int[][] mas = (int[][]) m.invoke(null, 5);
        boolean min = false;
        boolean max = false;
        for (int[] row : mas)
            for (int i : row) {
                if (i == -5) min = true;
                if (i == 5) max = true;
            }
        if (!max || !min) {
            fail("В массиве нет максимума 5 или минимума -5");
        }

    }


    @Test(timeout = 5000)
    public void testTaskCstep2_Sum__TaskC() throws Exception {
        HomeWork ok = run("", false);
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step2", int[][].class);
        int sum = (int) ok.invoke(m, null, new Object[]{m4});
        assertEquals("Неверная сумма в step2", -6, sum);
    }

    @Test(timeout = 5000)
    public void testTaskCstep3_DeleteMax__TaskC() throws Exception {
        HomeWork ok = run("", false);
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step3", int[][].class);
        int[][] actualmas = (int[][]) ok.invoke(m, null, new Object[]{m4});
        int[][] expectmas = {{-1, 2, -2}, {-2, -2, -6}};
        for (int i = 0; i < actualmas.length; i++) {
            System.out.println("Проверка строки " + i);
            System.out.println("         Ожидается: " + Arrays.toString(expectmas[i]));
            System.out.println("Из метода получено: " + Arrays.toString(actualmas[i]));
            assertArrayEquals("Метод работает некорректно", expectmas[i], actualmas[i]);
        }
        System.out.println("Проверка завершена успешно!");
    }
}
