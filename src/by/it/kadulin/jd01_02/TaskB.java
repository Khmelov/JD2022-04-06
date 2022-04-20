package by.it.kadulin.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        step2(sc.nextInt());
        step3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }

    static void step1() {
        int n = 5;
        int[][] array = new int[n][n];
        int counter = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter;
                System.out.print(array[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }

    static void step2(int x) {
        switch (x) {
             case 1: {
                System.out.println("январь");
                break;
            }
             case 2: {
                System.out.println("февраль");
                break;
            }
             case 3: {
                System.out.println("март");
                break;
            }
             case 4: {
                System.out.println("апрель");
                break;
            }
             case 5: {
                System.out.println("май");
                break;
            }
             case 6: {
                System.out.println("июнь");
                break;
            }
             case 7: {
                System.out.println("июль");
                break;
            }
             case 8: {
                System.out.println("август");
                break;
            }
             case 9: {
                System.out.println("сентябрь");
                break;
            }
             case 10: {
                System.out.println("октябрь");
                break;
            }
             case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }
        }
    }

    static void step3(double a, double b, double c) {
        if (c == 0 && b != 0) {
            double d = b * b;
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
        else if (b == 0 && c != 0) {
            if (c > 0) {
                double sqrt = Math.sqrt(c / a);
                System.out.println(sqrt + " " + -sqrt);
            }
            else if (c < 0) {
                System.out.println("корней нет");
            }
        }
        else if (b != 0 && c != 0) {
            double d = (b * b) - (4 * a * c);
//            System.out.println(d);
            if (d > 0) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                System.out.println(x1 + " " + x2);
            }
            else if (d < 0) {
                System.out.println("корней нет");
            }
            else if (d == 0) {
                double x = (-b) / (2 * a);
                System.out.println(x);
            }
        }
    }
}
