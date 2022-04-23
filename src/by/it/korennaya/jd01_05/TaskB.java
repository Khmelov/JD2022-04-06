package by.it.korennaya.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2){
            double y=0;
            for (double x = 1; x <= 6;x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("При а=%4.2f Сумма y=%e\n", a,y);
        }
    }
    private static void step2() {
        double β = 0;
        for (double x = -5.5; x <= 1.5; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) β = sin(pow(x, 2));
            if (x / 2 > -1 && x / 2 < 0.2) β = cos(pow(x, 2));
            if (x / 2 == 0.2) {
                if (tan(pow(x, 2)) == 0) {
                    System.out.println("При данном значении x невозможно произвести вычисления");
                }
                else {
                    β = 1. / (tan(pow(x, 2)));
                }
            }
            double α = log10(abs(β + 2.74));
            System.out.printf("При β=%e α=%e\n", β,α);
        }
    }
}