package by.it.kadulin.jd01_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TaskC {
    public static void main(String[] args) {
//        step1();
        step2();
    }

    private static void step1() {
        int countOfSteps = 20 + (int) (Math.random() * (20 + 1));
        double step = (9 - 5.33) / countOfSteps;
        ArrayList<Double> list = new ArrayList<>();
        for (double x = 5.33; x <= 9; x += step) {
            double z = Math.pow(Math.pow(x, 2) + 4.5, 1.0/3);
            list.add(z);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s[%4d]=%-10.5f", "A", i, list.get(i));
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
    }

    private static void step2() {
        int[] arrayA = new int[31];
        ArrayList<Integer> arrayB = new ArrayList<>();
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = rnd();
            if (arrayA[i] / 10 > i) {
                arrayB.add(arrayA[i]);
            }
        }
        arrayB.sort((Integer::compareTo));
        String firstA  = "╔===========╦===========╦===========╦===========╦===========╗";
        String middleA = "╠===========╬===========╬===========╬===========╬===========╣";
        String lastA   = "╚===========╩===========╩===========╩===========╩===========╝";
        String firstB  = "╔===========╦===========╗";
        String middleB = "╠===========╬===========╣";
        String lastB   = "╚===========╩===========╝";

        for (int i = 1; i <= arrayA.length; i++) {
            if (i == 1) {
                System.out.println(firstA);
            }
            System.out.printf("║ %s[%2d]=%3d ", "A", i - 1, arrayA[i - 1]); // 1 + 1 + 9 + 1 + 1
            if (i % 5 == 0) {
                System.out.println("║");
                System.out.println(middleA);
            }
            if (i == arrayA.length) {
                System.out.println("║           ║           ║           ║           ║");
                System.out.println(lastA);
            }
        }
        System.out.println();
//        System.out.println(arrayB.size());
//        System.out.println(arrayB.toString());
        int countFullRows = arrayB.size() / 5;
        int j = 0;
        int remain = arrayB.size() % 5;
        for (int i = 0; i < countFullRows; i++) {
            if (i == 0) {
                System.out.println(firstA);
            }
            System.out.printf("║ %s[%2d]=%3d ║ %s[%2d]=%3d ║ %s[%2d]=%3d ║ %s[%2d]=%3d ║ %s[%2d]=%3d ║%n",
                    "B", j, arrayB.get(j), "B", j + 1, arrayB.get(j + 1), "B", j + 2, arrayB.get(j + 2), "B", j + 3,
                    arrayB.get(j + 3), "B", j + 4, arrayB.get(j + 4));
            if (i != countFullRows - 1) {
                System.out.println(middleA);
            }

            j = j + 5;
        }
        if (remain == 0) {
            System.out.println(lastA);
        }
        else {
            System.out.println(middleA);
            for (int i = countFullRows * 5; i < arrayB.size(); i++) {
                System.out.printf("║ %s[%2d]=%3d ", "B", i, arrayB.get(i));
            }
            for (int i = 0; i < 5 - remain; i++) {
                System.out.printf("║           ");
            }
            System.out.print("║\n");
            System.out.println(lastA);
        }



    }

    private static int rnd() {
        return 103 + (int) (Math.random() * (347 + 1));
    }
}
/*
╔===========╦
║ A[ 1]=333 ║
╠===========╬
 */
