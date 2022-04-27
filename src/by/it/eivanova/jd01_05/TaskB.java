package by.it.eivanova.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double step = 0.5;
        double start = -5.5;
        double stop = 1.5;
        //𝛽 вычисляется в зависимости от − 6 < 𝑥 < 2; ∆𝑥 = 0,5

        for (double x = start; x <= stop; x += step) {

            if ((x / 2 > -2) && (x / 2 <= -1)) {
                double b = sin(x * x);
                double c = log10(abs(b + 2.74));
                System.out.println(c);
            }


            else if ((x / 2 > -1) && (x / 2 <= 0.2)) {
                    double b = cos(x * x);
                    double c = log10(abs(b + 2.74));
                    System.out.println(c);
                }


            else if (x / 2 == 0.2) {
                    double b = atan(x * x);
                    double c = log10(abs(b + 2.74));
                    System.out.println(c);
            }

            else {
                System.out.println("вычисления не определены");
            }

        }
    }




    private static void step1() {
        double step = 0.2;
        double start = 0;
        double stop = 2.0;

        for (double a = start; a <= stop; a += step) {
            double y = pow(7, a) * 6;

            for (int x = 1; x <= 6; ++x) {
                y -= cos(x);
                System.out.println(y);
            }
        }
    }

}
