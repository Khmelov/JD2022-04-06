package by.it.machuga.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step3() {
        String line = "-".repeat(29);
        String nameVariable = "|" + " ".repeat(6) + "I" + " ".repeat(5) + "|" + " ".repeat(7) + "F" + " ".repeat(6) + "|";
        double x = 12.1;
        double step = 3.75;
        double start = -5;
        double stop = 12.1;
        System.out.println(line);
        System.out.println(nameVariable);
        System.out.println(line);
        for (double i = start; i < stop; i += step) {
            double f = Math.exp(i * x) - 3.45 * i;
            System.out.printf("|%11.4f |%13.5g |%n", i, f);

        }
        System.out.println(line);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = Math.tan(Math.pow(a + b, 2)) - Math.cbrt(a + 1.5) + a * Math.pow(b, 5) - b / Math.log(a * a);
        System.out.println(y);
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = Math.cos(Math.pow(Math.pow(x, 2) + Math.PI / 6.0, 5));
        double part2 = Math.sqrt(x * Math.pow(a, 3));
        double part3 = Math.log(Math.abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.println(z);
    }
}
