package by.it.arsenihlaz.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        double y = 0;
        for (double a = 0.0; a <= 2.0; a += 0.2) {
            for (double x = 1; x < 7; x++) {
                y = y + (7 * a - cos(x));
            }
            System.out.println("При а=" + a + " Сумма y = " + y);
        }

        for (double x = -6; x < 2; x += 0.5) {
            if (x / 2.0 > -2 && x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.println("При x/2=" + x/2.0 + " a = " + a);
            } else if (x / 2.0 > -1 && x / 2 < 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.println("При x/2=" + x/2.0 + " a = " + a);
            } else if (x / 2.0 == 0.2) {
                double b = 1/tan(x * x);
                double a = log10(abs(b + 2.74));
                System.out.println("При x/2=" + x/2.0 + " a = " + a);
            } else System.out.println("При x/2=" + x/2.0 + " нет значения b для вычислений");
        }
    }
}
//if (x == 0) {
//        System.out.println("Нельзя делить на ноль");
//        } else