package by.it.avramchuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0;  a <=2 ; a = a+0.2) {
            double y=0;
            for(double x = 1; x<=6; x++){
                y = y + (pow(7,a)-cos(x));
            }
            System.out.printf("При a=%3.1f y=%g\n", a,y);
        }
    }

    private static void step2() {
        for(double x = -5.5; x<2; x = x+0.5){
            double a=0;
            double b=0;
            boolean flag=false;
            if (x/2> -2 && x/2<=-1){
                b=sin(x*x);
            } else if(x/2>-1&&x/2<0.2){
                b=cos(x*x);
            } else if (x/2==0.2){
                b = 1/tan(x*x);
            } else {
                System.out.printf("При x=%4.1f вычисления не определены\n", x);
                flag = true;
            }
            if (!flag){
                a = log10(abs(b+2.74));
                System.out.printf("При x=%4.1f  \u03B1=%9.6f \u03B2=%g\n", x, a, b);

            }
        }
    }
}
