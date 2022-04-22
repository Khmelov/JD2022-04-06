package by.it.kadulin.jd01_05;

public class TaskB {
    public static void main(String[] args) {
//        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 0; x < 7; x++) {
                y += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("При a=%3.2f y=%.5g%n", a, y);
        }
    }

    private static void step2() {
        for (double x = -6 + 0.5; x < 2; x += 0.5) {
            double b = 0;
            String str = "Недопустимое значение";
            double temp = x / 2;
            if (temp > -2 && temp <= -1) {
//                b = Math.pow(Math.sin(x), 2);
                b = Math.sin(x * x);
            }
            else if (temp > -1 && temp <= 0.2) {
//                b = Math.pow(Math.cos(x), 2);
                b = Math.cos(x * x);
            }
            else if (temp == 0.2) {
//                b = 1 / Math.pow(Math.tan(x), 2);
                b = 1 / Math.tan(x * x);
            }
            else {
                System.out.printf("При x/2=%.2f %s%n", temp, str);
                continue;
            }
            double a = Math.log10(Math.abs(b + 2.74));
            System.out.printf("При x/2=%.2f a=%5.5g%n", temp, a);

        }
    }
}
