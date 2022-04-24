package by.it.avramchuk.jd01_04;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        int [][] pay = new int[n][4];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + names[i]);
            for (int j = 0; j < 4; j++) {
                pay[i][j] = sc.nextInt();
            }
        }
        String[] cols = {"Фамилия", "Квартал1", "Квартал2", "Квартал 3",
                                                          "Квартал4", "Итого"};
        System.out.println("------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s", cols[0], cols[1],
                       cols[2], cols[3], cols[4], cols[5]);
        System.out.println();
        System.out.println("------------------------------------------------------");
        int total=0;
        double avg=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%9s", names[i]+": ");
            int sum=0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d", pay[i][j]);
                 sum+=pay[i][j];
            }
            System.out.printf("%-5d",sum);
            total+=sum;
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        avg = ((double)total)/(4*n);
        System.out.printf("%-9s%-10d", "Итого", total);
        System.out.println();
        System.out.printf("%-9s%-10.4f", "Средняя", avg);
    }
}
