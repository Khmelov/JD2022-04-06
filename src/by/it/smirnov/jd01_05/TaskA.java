package by.it.smirnov.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        taskA1steps();
        taskA1full();
        taskA2();
        taskA3();
    }

    private static void taskA1steps() {
        double a = 756.13, x = 0.3;
        double z1 = cos(pow((pow(x, 2) + PI / 6), 5));
        double z2 = sqrt(x * pow(a, 3));
        double z3 = log((a - 1.12 * x) / 4);
        double z = z1 - z2 - z3;
        System.out.println(z);
    }

    private static void taskA1full() {
        double a = 756.13, x = 0.3;
        double z = cos(pow((pow(x, 2) + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log((a - 1.12 * x) / 4);
        System.out.println(z);
    }

    private static void taskA2() {
        double a = 1.21, b = 0.371;
        double y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a*pow(b, 5) - (b / log(pow(a, 2)));
        System.out.println(y);
    }

    private static void taskA3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("При a=%6.2f f=%g%n", a, f);
        }
    }

}
