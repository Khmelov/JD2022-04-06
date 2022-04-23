package by.it.kameisha.jd01_05;

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
       double part1 = cos(pow(pow(x,2)+ PI/6,5));
       double part2 = sqrt(x*pow(a,3));
       double part3 = log(abs((a-1.12*x)/4));
       double z = part1-part2-part3;
        System.out.println("Результат z = "+z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a+b,2))-cbrt(a+1.5)+a*pow(b,5)-b/log(pow(a,2));
        System.out.println("Результат y = "+y);
    }

    private static void step3() {
        double x = 12.1;
        double function;
        System.out.println("-".repeat(32));
        System.out.println("|      A       |       F       |");
        System.out.println("-".repeat(32));
        for (double i = -5; i >=-5 && i<=12 ; i+=3.75) {
            function = pow(E,i*x)-3.45*i;
            System.out.printf("| При a =%6.2f %1c = %-6.4e |%n",i,'f',function);
        }
        System.out.println("-".repeat(32));
    }
}
