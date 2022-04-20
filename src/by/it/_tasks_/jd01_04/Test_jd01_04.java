package by.it._tasks_.jd01_04;


import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_04 extends HomeWork {

    @Test(timeout = 5000)
    public void testTaskA1_printMulTable__TaskA() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static printMulTable");
        m.setAccessible(true);
        m.invoke(null);
        ok
                .include("2*2=4  2*3=6  2*4=8  2*5=10 2*6=12 2*7=14 2*8=16 2*9=18")
                .include("3*2=6  3*3=9  3*4=12 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27")
                .include("4*2=8  4*3=12 4*4=16 4*5=20 4*6=24 4*7=28 4*8=32 4*9=36")
                .include("5*2=10 5*3=15 5*4=20 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45")
                .include("6*2=12 6*3=18 6*4=24 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54")
                .include("7*2=14 7*3=21 7*4=28 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63")
                .include("8*2=16 8*3=24 8*4=32 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72")
                .include("9*2=18 9*3=27 9*4=36 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81");

        System.out.println("Проверка таблицы умножения завершена");
    }

    @Test(timeout = 5000)
    public void testTaskA2_buildOneDimArray__TaskA() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static buildOneDimArray", String.class);
        m.invoke(null, "123 99 88 77 66 5 4 3 1 0 2");
        ok.include("V[").include("]=0").include("]=123");
        ok.include("first element=10");
        ok.include("last element=2");
        System.out.println("Проверка обработки массива завершена");
    }

    @Test(timeout = 5000)
    public void testTaskA3_run_main__TaskA() throws Exception {
        HomeWork ok = run("123 99 88 77 66 5 4 3 1 0 2");
        ok
                .include("2*2=4  2*3=6  2*4=8  2*5=10 2*6=12 2*7=14 2*8=16 2*9=18")
                .include("3*2=6  3*3=9  3*4=12 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27")
                .include("4*2=8  4*3=12 4*4=16 4*5=20 4*6=24 4*7=28 4*8=32 4*9=36")
                .include("5*2=10 5*3=15 5*4=20 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45")
                .include("6*2=12 6*3=18 6*4=24 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54")
                .include("7*2=14 7*3=21 7*4=28 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63")
                .include("8*2=16 8*3=24 8*4=32 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72")
                .include("9*2=18 9*3=27 9*4=36 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81");
        ok.include("V[").include("]=0").include("]=123");
        ok.include("first element=10");
        ok.include("last element=2");
        System.out.println("Проверка метода main завершена");
    }

    @Test(timeout = 5000)
    public void testTaskB1_inputSalary__TaskB() throws Exception {
        run("3\n" +
                "Ivanov\n" +
                "Petrov\n" +
                "Sidorov\n" +
                "11 11 13 15\n" +
                "15 16 17 18 \n" +
                "19 20 11 12 \n")
                .include("Ivanov").include("Petrov").include("Sidorov")
                .include("11").include("13").include("13").include("13")
                .include("15").include("16").include("17").include("18")
                .include("19").include("20").include("11").include("12")
        ;
    }

    @Test(timeout = 5000)
    public void testTaskB2_sumAndAvg__TaskB() throws Exception {
        run("3\n" +
                "Ivanov\n" +
                "Petrov\n" +
                "Sidorov\n" +
                "11 11 13 15\n" +
                "15 16 17 18 \n" +
                "19 20 11 12 \n")
                .include("178")
                .include("14").include("833")
        ;
    }

    @Test(timeout = 5000)
    public void testTaskC1_mergeSort__TaskC() throws Exception {
        HomeWork ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mergeSort", double[].class);
        double[] act = new double[15];
        double[] exp = new double[15];
        for (int i = 0; i < act.length; i++) {
            act[i] = Math.random() * 31 - 15;
            exp[i] = act[i];
        }
        m.invoke(null, act);  //тестируемая сортировка
        Arrays.sort(exp);        //ожидаемая сортировка
        System.out.println("   Yours array:" + Arrays.toString(act));
        System.out.println("Expected array:" + Arrays.toString(exp));
        assertArrayEquals("Сортировка работает неверно", exp, act, 1e-10);
        System.out.println("Проверка сортировки завершена");
    }

    @Test(timeout = 5000)
    public void testTaskC2_binarySearch__TaskC() throws Exception {
        HomeWork ok = run("", false);

        Method m = checkMethod(ok.aClass.getSimpleName(), "static binarySearch", double[].class, double.class);
        double[] d = new double[15];
        for (int i = 0; i < d.length; i++) {
            d[i] = Math.random() * 31 - 15;
        }
        Arrays.sort(d);
        System.out.println("Test massiv:" + Arrays.toString(d));
        for (int i = 0; i < d.length; i++) {

            int expected = Arrays.binarySearch(d, d[i]);
            int actual = (int) m.invoke(null, d, d[i]);
            assertEquals("Поиск работает неверно", expected, actual);

        }
        System.out.println("Проверка бинарного поиска завершена");

        m = checkMethod(ok.aClass.getSimpleName(), "static buildOneDimArray", String.class);
        m.invoke(null, "123 99 88 77 66 5 4 3 1 0 2");
        ok.include("V[").include("]=0").include("]=123");
        ok.include("first element=10");
        ok.include("last element=2");
        System.out.println("Проверка buildOneDimArray завершена");

    }

}
