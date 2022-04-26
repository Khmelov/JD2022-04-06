package by.it.marchenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double aStart = 0;
        double aEnd = 2;
        double aDelta = 0.2;
        int xStart = 1;
        int xEnd = 6;

        for (double a = aStart; a <= aEnd; a += aDelta) {
            double y = 0;
            for (int x = xStart; x <= xEnd; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При а=%4.2f Сумма y = %e%n", a, y);
        }
    }

    private static void step5() {
        double xStart = -6;
        double xEnd = 2;
        double xDelta = 0.5;
        for (double x = xStart; xEnd > x; x += xDelta) {
            if (xStart == x) {
                continue;
            }
            double beta;
            if ((-2 < x / 2) && (-1 >= x / 2)) {
                beta = sin(pow(x, 2));
            } else if (-1 < x / 2 && 0.2 > x / 2) {
                beta = cos(pow(x, 2));
            } else if (x / 2 == 0.2) {
                beta = 1 / tan(pow(x, 2));
            } else {
                beta = Double.NaN;
            }
            if (!Double.isNaN(beta)) {
                double alpha = log10(abs(beta + 2.74));
                System.out.printf("При x/2 = %.2f \u0251 = %e%n", x / 2, alpha); //greek alpha
            } else {
                System.out.printf("При x/2 = %4.2f значение \u0251 не опеределено%n", x / 2); //greek alpha
            }


        }
    }
}
