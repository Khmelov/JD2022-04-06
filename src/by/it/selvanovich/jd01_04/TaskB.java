package by.it.selvanovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] surnames = new String[n];
        int sum = 0;
        int totalSum = 0;
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = scanner.next();
        }
        int[][] array = new int[4][n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < array.length; j++) {
                array[j][i] = scanner.nextInt();
            }
        }
        System.out.println(" Фамилия Квартал1 Квартал2 Квартал3 Квартал4 Итого");
        System.out.println("-".repeat(50));
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s:",surnames[i]);
            for (int j = 0; j < array.length; j++) {
                System.out.printf("% -9d", array[j][i]);
                sum = sum + array[j][i];
            }
            System.out.printf("% -7d%n", sum);
            totalSum = totalSum + sum;
            sum = 0;
        }
        System.out.println("-".repeat(50));
        double average = Double.valueOf(totalSum) / Double.valueOf((array.length*n));
        System.out.printf("%-9s%-9d%n", "Итого", totalSum);
        System.out.printf("%-9s%-9.4f%n", "Средняя", average);

    }
}
