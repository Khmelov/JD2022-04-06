package by.it.ragach.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step1() {
        double step = 0.2;
        double start = 0;
        double stop = 2;
        double x = 1;
        double y = 0;


        System.out.println("-".repeat(40));
        System.out.println("|     A     |      Y       |");
        for (double a = start;a<=stop; a+=step) {
            for (x = 1; x <=6 ; x++) {
                double k = pow(7, a) - cos(x);
                y += k;}
                System.out.printf("| %10.2f| %12.6f |%n", a, y);
                System.out.println("-".repeat(40));
            }
        }

    private static void step2() {
        double step = 0.5;
        double start = -6.5;
        double stop = 2;

        for (double x = start; x < stop; x+=step) {
            double b = 0;
            double m = x / 2;
            if (m > -2 && m <= -1) {
                b = sin(x*x);
            }
            else if (m > -1 && m < 0.2) {
                b = cos(x*x);
            }
            else if (m == 0.2) {
                b = 1.0 / tan(x*x);
            } else {
                System.out.println("Вычисления не определены");
            }
            double a = log10(abs(b + 2.74));
            System.out.println("Для x/2"+"="+m+";"+"a"+"="+a);
        }
    }
}













            







