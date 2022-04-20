package by.it._tasks_.jd01_03;

import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_03  extends HomeWork {

    @Test(timeout = 5000)
    public void testTaskA1__InOut() throws Exception {
        HomeWork ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static getArray", String.class);
        double[] expArr = {0.1, 0.2, -0.2, -0.1};
        Method m = ok.aClass.getDeclaredMethod("getArray", String.class);
        System.out.println("Проверка ввода для массива вида:");
        System.out.println("0.1 0.2 -0.2 -0.1");
        double[] arr = (double[]) ok.invoke(m, null, new Object[]{"0.1 0.2 -0.2 -0.1"});
        assertArrayEquals("Неверно работает ввод", expArr, arr, 1e-9);
        System.out.println("Проверка ввода для массива завершена успешно");
    }

    @Test(timeout = 5000)
    public void testTaskA2_printSimple__InOut() throws Exception {
        HomeWork ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class);
        Method m = ok.aClass.getDeclaredMethod("printArray", double[].class);
        System.out.println("Проверка вывода для массива:");
        double[] arr = {1, 2, 3, 4};
        ok.invoke(m, null, new Object[]{arr});
        for (double a : arr) {
            //перевод в Integer т.к. заранее неизвестно с printf или прямо будет сделан вывод
            ok.include(Integer.toString((int) a));
        }
        System.out.println("Проверка вывода для массива завершена успешно");
    }

    @Test(timeout = 5000)
    public void testTaskA3_printWithNameAndCol__InOut() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class, String.class, int.class);
        System.out.println("Проверка вывода для массива:");
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        ok.invoke(m, null, arr, "Massiv", 2);
        System.out.println("\n\nFind out with printf for:");
        for (double a : arr) {
            //перевод в Integer т.к. заранее неизвестно с printf или прямо будет сделан вывод
            String sf = String.format("%.1f", a);
            System.out.print(sf + " | ");
            ok.include(sf);
        }
        System.out.println("\nCheck printf ok");
        ok.include("\n").include("Massiv");
        System.out.println("Проверка вывода для массива завершена успешно");
        //тут можно проверку на число колонок сделать, но это не факт, что будет просто
    }

    @Test(timeout = 5000)
    public void testTaskB1_findMin__Helper() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMin", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("Минимум найден неверно", arr[0], min, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskB2_findMax__Helper() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMax", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("Максимум найден неверно", arr[arr.length - 1], min, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskB3_sort__Helper() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static sort", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double[] sorted = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        System.out.println("Исходный  массив:" + Arrays.toString(arr));
        Arrays.sort(sorted);
        System.out.println("Ожидается массив:" + Arrays.toString(sorted));
        ok.invoke(m, null, arr);
        System.out.println("  Получен массив:" + Arrays.toString(arr));
        assertArrayEquals("Неверно работает сортировка", sorted, arr, 1e-9);
        System.out.println("OK. Массив отсортирован");
    }

    @Test(timeout = 5000)
    public void testTaskC1_mulMatrixAndVector__Helper() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[].class);
        System.out.println("Проверим произведение матрицы и вектора");
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[] vector = {1, 2, 3};
        double[] res = (double[]) ok.invoke(m, null, matrix, vector);
        double[] exp = {
                1 * 1 + 2 * 2 + 3 * 3,
                4 * 1 + 5 * 2 + 6 * 3
        };
        System.out.println("{{1,2,3},{4,5,6}}*{1,2,3}={14,32}");
        System.out.println("Ожидается массив " + Arrays.toString(exp));
        assertArrayEquals("Произведение найдено неверно", exp, res, 1e-10);
        System.out.println("Проверка завершена успешно.");
    }


    @Test(timeout = 5000)
    public void testTaskC2_mulMatrixAndMatrix__Helper() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[][].class);
        System.out.println("Проверим произведение матрицы и матрицы");
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        double[][] res = (double[][]) ok.invoke(m, null, left, right);
        double[][] exp = {
                {22, 28},
                {49, 64}
        };
        System.out.println("{{1,2,3},{4,5,6}}*{{1,2},{3,4},{5,6}}={{22,28},{49,64}}");
        for (int i = 0; i < exp.length; i++) {
            System.out.println("Ожидается:  " + Arrays.toString(exp[i]));
            System.out.println("Рассчитано: " + Arrays.toString(res[i]));
            assertArrayEquals("Произведение найдено неверно", exp[i], res[i], 1e-10);
        }
        System.out.println("\nПроверка завершена успешно.");
    }
}
