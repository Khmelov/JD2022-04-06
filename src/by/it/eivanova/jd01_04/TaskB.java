package by.it.eivanova.jd01_04;

import java.io.OptionalDataException;
import java.util.Locale;
import java.util.Scanner;

import static javax.management.Query.or;

public class TaskB {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во сотрудников: ");
        int n = in.nextInt();
        System.out.println("Введите фамилии сотрудников: ");
        String[] people = new String[n + 1];
        for (int i = 0; i < n; i++) {
            people[i] = in.next();
        }
        people[n] = "Итого";
        int[][] money = new int[n + 1][5];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату: " + people[i]);
            for (int k = 0; k < 4; k++) {
                money[i][k] = in.nextInt();
                money[i][4] += money[i][k];
                money[n][k] += money[i][k]; // поквартальная сумма
                money[n][4] += money[i][k];
                sum += money[i][k];
            }
        }
        for (int i = 0; i < people.length; i++) {
            System.out.printf("%-14s: ", people[i]);
            for (int j = 0; j < money[i].length; j++) {
                System.out.printf("%4d  ", money[i][j]);

            }
            System.out.println();
        }
        System.out.println("Итого: " + sum);

        System.out.print("Средняя: ");
        double average = (double) sum/4/n;
        System.out.println(average);
        }
}