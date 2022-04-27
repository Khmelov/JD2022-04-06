package by.it.ragach.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();


        step1();
        step2(month);
        step3(a, b, c);


    }

    private static void step1() {
        int[][] mat = new int[5][5];

        for (int i = 0; i < mat.length; i++) {
            for (int i1 = 0; i1 < mat[i].length; i1++) {
                mat[i][i1] = (i * 5) + 1 + i1;


                System.out.print(mat[i][i1] + " ");
            }
            System.out.println();
        }

    }

    private static void step2(int month) {

        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {

        double d = b * b - 4 * a * c;

        if (d < 0)
            System.out.println("корней нет");
        else if (d==0) {
            double i = -b / (2 * a);
            System.out.println(i);
        }
        else {
            double i1 = (-b+Math.sqrt(d))/(2*a);
            double i2 = (-b-Math.sqrt(d))/(2*a);
                System.out.println(i1+" "+i2);


        }

    }


}

