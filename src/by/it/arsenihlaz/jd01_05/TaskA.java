package by.it.arsenihlaz.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow((x * x + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println("z = " + z);

        a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println("y = " + y);

        for (a = -5, x = 12.1; a <= 12; a += 3.75) {
            y = exp(a * x) - 3.45 * a;
            System.out.println("При а=" + a + " Сумма y = " + y);
        }

    }
}
