package by.it.annazhegulovich.jd01_05;
import static java.lang.Math.*;
public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <=2 ; a+=0.2) {
            double y =0;
            for (int x = 1; x <=6 ; x++) {
                 y = (pow(7,a)-cos(x));
            }
            y+=y;
            System.out.println("a="+a+", y="+y);
        }
    }

    private static void step2() {
        double b = 0;
        for (double x=-5.5 ; x<2; x+=0.5) {
            if (x/2>-2&&x/2<=-1){
                b = sin(pow(x,2));
            } else if (x/2>-1&&x/2<0.2){
                b = cos(pow(x,2));
            } else if (x/2==0.2){
                b=1/tan(pow(x,2));
            } else {
                System.out.println("При x="+x+" вычисления не возможны");
            }
            double a = log10(abs(b+2.74));
            System.out.println("x="+x+" b="+b+" a="+a);
        }
    }
}
