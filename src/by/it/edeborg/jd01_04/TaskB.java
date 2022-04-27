package by.it.edeborg.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        final int QUARTER = 4;
        int sum0 = 0;
        int sum1 = 0;
        int sum2 = 0;
        System.out.println("Введите число сотрудников:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Введите фамилии сотрудников через Enter");
        String[] array = new String[number];
        for (int i = 0; i < number; i++) {
            array[i] = scanner.next();
        }
        int[][] arraySalary = new int[number][QUARTER];
        for (int i = 0; i < number; i++) {
            System.out.println("Введите зарплату для " + array[i]);
            for (int j = 0; j < QUARTER; j++) {
                arraySalary[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-".repeat(60));
        System.out.println("Фамилия   Квартал1   Квартал2   Квартал3   Квартал4   Итого");
        System.out.println("-".repeat(60));
        System.out.printf("%-8s: ", array[0]);
        for (int j = 0; j < QUARTER; j++) {
            sum0 += arraySalary[0][j];
            System.out.printf("%-9d  ", arraySalary[0][j]);
        }
        System.out.printf("%-5d%n", sum0);

        System.out.printf("%-8s: ", array[1]);
        for (int j = 0; j < QUARTER; j++) {
            sum1 += arraySalary[1][j];
            System.out.printf("%-9d  ", arraySalary[1][j]);
        }
        System.out.printf("%-5d%n", sum1);

        System.out.printf("%-8s: ", array[2]);
        for (int j = 0; j < QUARTER; j++) {
            sum2 += arraySalary[2][j];
            System.out.printf("%-9d  ", arraySalary[2][j]);
        }
        System.out.printf("%-5d%n", sum2);

        int total = sum0 + sum1 + sum2;
        double average = (double) total / (number * QUARTER);

        System.out.println("-".repeat(60));
        System.out.printf("%-8s %-6d%n", "Итого", total);
        System.out.printf("%-8s %-10.5f%n", "Средняя", average);
    }
}
