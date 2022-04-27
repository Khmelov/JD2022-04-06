package by.it.selvanovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
        step1();
        Scanner scanner=new Scanner(System.in);
        int i = scanner.nextInt();
        step2(i);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        step3(a, b, c);

    }
    private static void step1(){
        for (int i = 1; i <= 25; i++){
            System.out.print(i+" ");
                if (i % 5 == 0) System.out.println();
        }
    }
    private static void step2(int month){
        String monthName;
        switch (month){
            case 1: monthName = "январь";
            break;
            case 2: monthName = "февраль";
            break;
            case 3: monthName = "март";
            break;
            case 4: monthName = "апрель";
            break;
            case 5: monthName = "май";
            break;
            case 6: monthName = "июнь";
            break;
            case 7: monthName = "июль";
            break;
            case 8: monthName = "август";
            break;
            case 9: monthName = "сентябрь";
            break;
            case 10: monthName = "октябрь";
            break;
            case 11: monthName = "ноябрь";
            break;
            case 12: monthName = "декабрь";
            break;
            default: monthName = "нет такого месяца";
            break;
        }
        System.out.println(monthName);
    }
    private static void step3(double a, double b, double c){
        double d = b*b-4*a*c;
        double sqrtd = Math.sqrt(d);
        if (sqrtd > 0) {
            double xa = ((-b)+sqrtd)/(2*a);
            double xb = ((-b)-sqrtd)/(2*a);
            System.out.println(xa+" "+xb);
        }
        else if (sqrtd == 0) {
            double xa = -(b/(2*a));
            System.out.println(xa);
        }
        else {
            System.out.println("корней нет");
        }
    }
}
