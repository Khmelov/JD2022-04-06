package by.it.machuga.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        task4();
        task5();

    }

    private static void task5() {
        double step = 0.5;
        double start = -6;
        double stop = 2;
        System.out.printf("%3s%15s%20s%n", "x", "\u03b2", "\u03b1");
        for (double x = start + step; x < stop; x += step) {
            double b;
            if (x / 2 > -2 && x / 2 <= -1) {
                b = Math.sin(Math.pow(x, 2));
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = Math.cos(Math.pow(x, 2));
            } else if (x / 2 == 0.2) {
                b = Math.cos(Math.pow(x, 2)) / Math.sin(Math.pow(x, 2));
            } else {
                System.out.printf("%4.1f   \u03b2 can't be calculated   \u03b1 can't be calculated%n", x);
                continue;
            }
            double a = Math.log10(b + 2.74);
            System.out.printf("%4.1f  %8.4f %28e%n", x, b, a);
        }
    }

    private static void task4() {
        for (double i = 0; i <= 2; i += 0.2) {
            double sum = 0;
            for (double j = 1; j <= 6; j++) {
                double y = 7 * i - Math.cos(j);
                sum += y;
            }
            System.out.println(sum);
        }
    }
}
