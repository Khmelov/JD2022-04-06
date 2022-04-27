package by.it.kudelko.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        double z1 = 0;
        double z2 = 0;
        double x = 0.3;
        double a = 756.13;
        z1 = step1() - step2() - step3();
        z2 = cos(pow((pow(x, 2) + (PI / 6)), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println("Результат с разбивкой: " + z1);
        System.out.println("Результат по полному выражению: " + z2);
        System.out.println("Вычисление A2: " + step4());

        step1();
        step2();
        step3();
        step4();
        step5();
    }


    private static double step1() {
        double x = 0.3;
        double answer1 = cos(pow((pow(x, 2) + (PI / 6)), 5));
        return answer1;
    }

    private static double step2() {
        double x = 0.3;
        double a = 756.13;
        double answer2 = sqrt(x * pow(a, 3));
        return answer2;
    }

    private static double step3() {
        double x = 0.3;
        double a = 756.13;
        double answer3 = log(abs((a - 1.12 * x) / 4));
        return answer3;
    }

    private static double step4() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1d / 3) + a * pow(b, 5) - (b / log(a * a));
        return y;
    }

    private static void step5() {
        double x = 12.1;
        double f = 0;
        System.out.println("-".repeat(30));
        for (double a = -5; a <= 12; a=a+3.75) {
            f= exp(a*x) - 3.45*a;
            System.out.printf("| %10.3f | %13.5g |%n",a,f);
        }
        System.out.println("-".repeat(30));
    }
}
