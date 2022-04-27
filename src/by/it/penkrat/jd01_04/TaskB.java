package by.it.penkrat.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] person = new String[n];

        for (int i = 0; i < person.length; i++) {
            person[i] = scanner.next();
        }
        System.out.println(Arrays.toString(person));

        int[][] salary = new int[n][5];
        for (int i = 0; i < person.length; i++) {
            System.out.println("Введите зарплату для " + person[i]);

            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < salary.length; i++) {
            int sum = 0;
            for (int j = 0; j < salary[i].length - 1; j++) {
                sum = sum + salary[i][j];
                salary[i][4] = sum;
            }
        }


        System.out.println(Arrays.deepToString(salary));

        System.out.println("-".repeat(55));
        System.out.printf("%9s%-9s%-9s%-9s%-9s%7s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-".repeat(55));

        for (int i = 0; i < person.length; i++) {
            System.out.printf("%-10s:", person[i]);

            for (int k = 0; k < salary[i].length; k++) {
                System.out.printf("% -10d", salary[i][k]);
            }
            System.out.println();
        }
        System.out.println("-".repeat(55));

        int result = 0;
        double average = 0;
        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length-1; j++)
                result = result + salary[i][j];
                average = (double) result / (4*n);
        }

        System.out.printf("%-9s%-10d\n", "Итого", result);
        System.out.printf("%-9s%-8.6f\n", "Средняя", average);
    }


}

