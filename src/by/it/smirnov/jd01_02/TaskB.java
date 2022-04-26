package by.it.smirnov.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        step1();
        int month = scanner.nextInt();
        step2(month);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);
    }

    static void step1() {
        int[][] array = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = j + 1 + i * 5;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void step2(int month) {
        String[] year = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        switch (month) {
            case (1) -> System.out.println(year[0]);
            case (2) -> System.out.println(year[1]);
            case (3) -> System.out.println(year[2]);
            case (4) -> System.out.println(year[3]);
            case (5) -> System.out.println(year[4]);
            case (6) -> System.out.println(year[5]);
            case (7) -> System.out.println(year[6]);
            case (8) -> System.out.println(year[7]);
            case (9) -> System.out.println(year[8]);
            case (10) -> System.out.println(year[9]);
            case (11) -> System.out.println(year[10]);
            case (12) -> System.out.println(year[11]);
            default -> System.out.println("нет такого месяца");
        }

    }

    static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        double x;
        double y;
        if (d > 0) {
            x = (-b + Math.sqrt(d)) / (2 * a);
            y = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x + " " + y);
        } else if (d == 0) {
            x = -(b / (2 * a));
            System.out.println(x);
        } else {
            System.out.println("корней нет");
        }


    }
}
