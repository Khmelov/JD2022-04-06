package by.it.marchenko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        step2(month);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);
    }

    public static void step1 () {
        final int SIZE = 5;
        int counter = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }

    private static void step2(int month) {
        String monthName = switch (month) {
            case 1 -> "январь";
            case 2 -> "февраль";
            case 3 -> "март";
            case 4 -> "апрель";
            case 5 -> "май";
            case 6 -> "июнь";
            case 7 -> "июль";
            case 8 -> "август";
            case 9 -> "сентябрь";
            case 10 -> "октябрь";
            case 11 -> "ноябрь";
            case 12 -> "декабрь";
            default -> "нет такого месяца";
        };
        System.out.println(monthName);
    }

    private static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d < 0) {
            System.out.println("корней нет");
        } else if (d == 0) {
            System.out.println(-b / (2 * a));
        } else {
            System.out.println((-b + Math.sqrt(d))/(2 * a) + " " + (-b - Math.sqrt(d))/(2 * a));
        }
    }
}
