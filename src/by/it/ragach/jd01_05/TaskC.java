package by.it.ragach.jd01_05;

import by.it.ragach.jd01_04.InOut;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();


    }

    private static void step1() {


        double start = 5.33;
        double stop = 9.0;
        int count = (int) (Math.random() * ((40 - 20) + 1) + 20);
        System.out.println(count);
        double step = (stop - start) / (count - 1);


        double[] array = new double[count];
        int i = 0;
        System.out.println("Массив A[]");
        for (double x = start; x <= stop; x = x + step) {
            array[i] = cbrt(pow(x, 2) + 4.5);
            System.out.printf("А[% -3d ]=%-9.4f", i, array[i]);
            i++;
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
}
















































