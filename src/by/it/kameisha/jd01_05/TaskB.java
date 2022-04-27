package by.it.kameisha.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double result = 0;
        double temporary;
        for (double i = 0; i>=0&&i<=2 ; i+=0.2) {
            for (int j = 1; j <=6; j++) {
                temporary = pow(7,i) - cos(j);
                result = result + temporary;
            }
            System.out.printf("При a =%-3.2f Сумма y = %5.5e%n",i,result);
        }
    }

    private static void step2() {
        double result = 0;
        double temporary;
        for (double i = -5.5; i >-6 && i<2 ; i+=0.5) {
            if(i/2>-2 && i/2<= -1){
                temporary = sin(pow(i,2));
                printAlpha(i/2.0,getAlpha(temporary));
            } else if (i/2>-1 && i/2<0.2) {
                temporary = cos(pow(i,2));
                printAlpha(i/2.0,getAlpha(temporary));
            } else if (i/2==0.2) {
                temporary = 1/tan(pow(i,2));
                printAlpha(i/2.0,getAlpha(temporary));
            } else {
                System.out.printf("При x/2=%-4.2f вычисление невозможно%n",i/2.0);
            }
        }
    }
    private static double getAlpha (double beta){
        double alpha = log10(abs(beta+2.74));
        return alpha;
    }
    private static void printAlpha (double x, double alpha){
        System.out.printf("При x/2=%-4.2f a = %7.6e%n",x,alpha);
    }
}
