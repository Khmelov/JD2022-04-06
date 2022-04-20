package by.it.marchenko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(pow(x, 2) + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println("Result = " + z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow((a + b), 2)) - pow(a + 1.5, 1d / 3) + a * pow(b, 5) - b / log(pow(a, 2));
        System.out.println("Result = " + y);
    }

    private static void step3() {
        final int MINUS_AMOUNT = 27;
        double x = 12.1;
        double aStart = -5;
        double aEnd = 12.0;
        double aDelta = 3.75;
        System.out.println("-".repeat(MINUS_AMOUNT));
        System.out.printf("| %10s | %10s |%n", "a", "f");
        System.out.println("-".repeat(MINUS_AMOUNT));
        for (double a = aStart; aEnd >= a; a += aDelta) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("| %10.2f | %10.4g |%n", a, f);
        }
        System.out.println("-".repeat(MINUS_AMOUNT));
    }
}
