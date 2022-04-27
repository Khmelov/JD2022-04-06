package by.it.kadulin.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = Math.cos(Math.pow(Math.pow(x, 2) + Math.PI / 6, 5));
        double part2 = Math.sqrt(x * Math.pow(a, 3));
        double part3 = Math.log(Math.abs((a - 1.12 * x) / 4));
        double z1 = part1 - part2 - part3;
        double z2 = Math.cos(Math.pow(Math.pow(x, 2) + Math.PI / 6, 5)) - Math.sqrt(x * Math.pow(a, 3)) - Math.log(Math.abs((a - 1.12 * x) / 4));
        System.out.println(z2);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double part1 = Math.tan(Math.pow(a + b, 2));
        double part2 = Math.pow(a + 1.5, 1.0 / 3);
        double part3 = a * Math.pow(b, 5);
        double part4 = b / Math.log(Math.pow(a, 2));
        double y = part1 - part2 + part3 - part4;
        System.out.println(y);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = Math.exp(a * x) - 3.45 * a;
            System.out.printf("При a=%-3.5f f= %-5.5g", a, f);
            System.out.println();
        }
    }
}
