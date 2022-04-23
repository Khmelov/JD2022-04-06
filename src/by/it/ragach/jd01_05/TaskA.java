package by.it.ragach.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();



    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(pow(x, 2) + PI / 6.0, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1-part2-part3;
        System.out.println("Result = "+z);

    }


    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = Math.tan(pow((a+b),2))-Math.cbrt(a+1.5)+a*pow(b,5)-b/(log(pow(a,2)));
        System.out.println("Result = "+y);



    }


    private static void step3() {
        double step = 3.75;
        double start = -5;
        double stop  = 12.0;
        double x = 12.1;
        System.out.println("-".repeat(40));
        System.out.println("|     A     |      F       |");
        for (double a=start; a<=stop; a+=step){
            double f = exp(a*x)-3.45*a;
            System.out.printf("| %10.4f| %12.5g |%n", a,f);
            System.out.println("-".repeat(40));
        }
    }
}
