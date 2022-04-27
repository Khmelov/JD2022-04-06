package by.it.annazhegulovich.jd01_05;

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
        double step1 = cos(pow((pow(x,2)+PI/6),5));
        double step2 = pow(x*pow(a,3),1.0/2);
        double step3 = log((a-1.12*x)/4);
        double z = step1-step2-step3;
        System.out.println("z="+z);
        z = cos(pow((pow(x,2)+PI/6),5))-pow(x*pow(a,3),1.0/2)- log((a-1.12*x)/4);
        System.out.println("z="+z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a+b,2))-pow(a+1.5,1.0/3)+a*pow(b,5)-b/(log(pow(a,2)));
        System.out.println("y="+y);
    }

    private static void step3() {
       double x = 12.1;
        System.out.println("-".repeat(30));
        System.out.println("|     A     |       F          |");
        System.out.println("-".repeat(30));
       for (double a = -5; a <=12; a+=3.75) {
            double f = pow(E, a*x)-3.45*a;
            System.out.printf("| a=%-8.2f| f=%-15g|\n",a,f);
        }
        System.out.println("-".repeat(30));
    }
}
