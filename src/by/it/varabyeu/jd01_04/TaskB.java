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
    }
}
