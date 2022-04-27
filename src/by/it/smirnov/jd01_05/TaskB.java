package by.it.smirnov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        taskB1();
        taskB2();
    }

    private static void taskB1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("При a=%4.2f Сумма y=%g\n", a, y);
        }
    }

    private static void taskB2() {
        for (double x = -5.5; x < 2; x = x + 0.5) {
            System.out.printf("При x/2=%f ", x/2);
            if(x/2 > -2 && x/2 <= -1) {
                double b = sin(pow(x, 2));
                double a = log10(b + 2.74);
                System.out.printf("a = %g%n", a);
            }
            else if(x/2 > -1 && x/2 < 0.2) {
                double b = cos(pow(x, 2));
                double a = log10(b + 2.74);
                System.out.printf("a = %g%n", a);
            }
            else if(x == 0.2) {
                double b = 1 / tan(pow(x, 2));
                double a = log10(b + 2.74);
                System.out.printf("a = %g%n", a);
            }
            else System.out.printf("вычисление невозможно!%n");
        }
    }
}
