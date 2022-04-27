package by.it.penkrat.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        step2(month);

        double sqrt1 = sc.nextDouble();
        double sqrt2 = sc.nextDouble();
        double sqrt3 = sc.nextDouble();
        step3(sqrt1, sqrt2, sqrt3);

        step1();
    }

    static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i + " ");
            if(i%5==0){
                System.out.println("\n");
            }

        }

    }

    static void step2(int month) {
        switch (month) {
            case 1 -> System.out.println("январь");
            case 2 -> System.out.println("февраль");
            case 3 -> System.out.println("март");
            case 4 -> System.out.println("апрель");
            case 5 -> System.out.println("май");
            case 6 -> System.out.println("июнь");
            case 7 -> System.out.println("июль");
            case 8 -> System.out.println("август");
            case 9 -> System.out.println("сентябрь");
            case 10 -> System.out.println("октябрь");
            case 11 -> System.out.println("ноябрь");
            case 12 -> System.out.println("декабрь");
            default -> System.out.println("нет такого месяца");
        }
    }

    static void step3(double a, double b, double c) {
        double d = (b * b) - (4 * a * c);
        if (d < 0) {
            System.out.println("корней нет");
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}

