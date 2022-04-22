package by.it.kadulin.jd01_05;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        int countOfSteps = 20 + (int) (Math.random() * (20 + 1));
        double step = (9 - 5.33) / countOfSteps;
        ArrayList<Double> list = new ArrayList<>();
//        double[] array = new double[countOfSteps];
//        int countArray = 0;
        for (double x = 5.33; x <= 9; x += step) {
            double z = Math.pow(Math.pow(x, 2) + 4.5, 1.0/3);
            list.add(z);
//            array[countArray] = z;
//            countArray++;
        }
//        System.out.println(list.size());
//        System.out.println(countOfSteps);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s[%4d]=%-10.3f", "A", i, list.get(i));
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        double mlt = 1;
        int countNumbers = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 3.5) {
                System.out.printf("%s[%4d]=%-10.5f", "B", countNumbers, list.get(i));
                if ((countNumbers + 1) % 5 == 0) {
                    System.out.println();
                }
                mlt *= list.get(i);
                countNumbers++;
            }


        }
        System.out.printf("%nСреднее геометрическое чисел = %.5f", Math.pow(mlt, 1.0 / countNumbers));

//        for (int i = 0; i < countOfSteps; i++) {
//            System.out.printf("%s[%4d]=%-10.3f", "A", i, array[i]);
//            if ((i + 1) % 5 == 0) {
//                System.out.println();
//            }
//        }
    }
}
