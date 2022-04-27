package by.it.varabyeu.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        step4();
        step5();
    }

    private static void step4() {

        double step = 0.2;
        double start = 0;
        double stop = 2.0;
        double y = 0;

        for (int x = 1; x < 7; x++) {
            double result = 0;
            for (double j = start; j <= stop; j += step) {
                double a = pow(7, start);
                double b = cos(x);
                result = a - b;
            }
            y += result;
        }
        System.out.println(y);
    }

    private static void step5() {

        double step = 0.5;
        double start = -5.5;
        double stop = 1.5;
        double betta;
        double alpha;

        for (double x = start; x <= stop; x += step) {

            if ((x / 2) > -2 && (x / 2) <= -1) {
                betta = sin((pow(x, 2)));
                alpha = log10(abs(betta + 2.74));
                System.out.println("When x/2=" + x / 2 + " alpha = " + alpha);
            } else if ((x / 2) > -1 && (x / 2) < 0.2) {
                betta = cos((pow(x, 2)));
                alpha = log10(abs(betta + 2.74));
                System.out.println("When x/2=" + x / 2 + " alpha = " + alpha);
            } else if ((x / 2) == 0.2) {
                betta = (cos((pow(x, 2))) / (sin((pow(x, 2)))));
                alpha = log10(abs(betta + 2.74));
                System.out.println("When x/2=" + x + " alpha = " + alpha);
            } else {
                System.out.println("When x equal " + x / 2 + " not possible to calculate");
            }
        }
    }
}
