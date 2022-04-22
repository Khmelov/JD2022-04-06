package by.it.varabyeu.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        String[] lastName = new String[n];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < lastName.length; i++) {
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int[] total = new int[n];
        for (int i = 0; i < salary.length; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum = sum + salary[i][j];
            }
            total[i] = sum;
        }

        System.out.println("-".repeat(50));
        System.out.printf("%-9s%-9s%-9s%-9s%-9s%-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-".repeat(50));

        for (int i = 0; i < lastName.length; i++) {
            System.out.printf("%-10s", lastName[i]+" :");

            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10s", salary[i][j]);
            }

            for (int k = 0; k < total.length; k++) {
                System.out.printf("%-10s", total[i]);
                break;
            }
            System.out.println();
        }
        System.out.println("-".repeat(50));

        int sum = 0;
        double average = 0;
        for (int i = 0; i < total.length; i++) {
            sum += total[i];
            average = (double) sum/(4*n);
        }
        System.out.printf("%-9s%-8d\n", "Итого", sum);
        System.out.printf("%-9s%-8.4f\n", "Средняя", average);
    }
}
