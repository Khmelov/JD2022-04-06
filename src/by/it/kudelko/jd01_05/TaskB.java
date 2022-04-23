package by.it.kudelko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        exercise1();
        exercise2();
    }


    private static void exercise1() {
        double y = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (double x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("%10.4g%10g%n", a, y);
        }
    }

    private static void exercise2() {
        double l = 0;
        for (double x = -3 + 0.25; x < 1; x = x + 0.25) {
            if (x > -3 && x <= -2) {
                System.out.println(x + "        Вычисления невозможны");
            }
            if (x > -2 && x <= -1) {
                double b = sin(pow(2*x, 2));
                l = log10(abs(b + 2.74));
                System.out.printf("%10.3f%10f%n", x, l);
                l = 0;
                b = 0;
            } else {
                if (x > -1 && x < 0.2) {
                    double b = cos(pow(2*x, 2));
                    l = log10(abs(b + 2.74));
                    System.out.printf("%10.3f%10f%n", x, l);
                    l = 0;
                    b = 0;
                } else {
                    if (x == 0.2) {
                        double b = 1 / tan(pow(2*x, 2));
                        l = log10(abs(b + 2.74));
                        System.out.printf("%10.3f%10f%n", x, l);
                        l = 0;
                        b = 0;
                    } else {
                        if (x > 0.2) {
                            System.out.println(x + "        Вычисления невозможны");
                        }
                    }
                }
            }
        }
    }
}
