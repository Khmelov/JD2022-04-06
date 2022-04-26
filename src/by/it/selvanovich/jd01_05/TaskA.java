package by.it.selvanovich.jd01_05;

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
        double part1 = cos(pow(pow(x, 2) + PI / 6.0, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println("z = " + z);
    }
    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2))-pow(a + 1.5, 1d / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println("y = " + y);
    }
    private static void step3() {
        double step = 3.75;
        double start = -5;
        double stop = 12.0;
        double x = 12.1;
        System.out.println("-".repeat(30));
        System.out.println("|     A      |       F       |");
        System.out.println("-".repeat(30));
        for (double a = start; a <= stop; a += step) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("| %10.4f | %13.5g |%n", a, f);
        }
        System.out.println("-".repeat(30));
    }
}
