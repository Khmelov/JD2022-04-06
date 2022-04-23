package by.it.kudelko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.next();
        }
        int[][] salarysum = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + array[i]);
            for (int j = 0; j < salarysum[0].length; j++) {
                salarysum[k][j] = sc.nextInt();
            }
            k++;
                        }
        int totalFirst = salarysum[0][0] + salarysum[0][1] + salarysum[0][2] + salarysum[0][3];
        int totalSecond = salarysum[1][0] + salarysum[1][1] + salarysum[1][2] + salarysum[1][3];
        int totalThird = salarysum[2][0] + salarysum[2][1] + salarysum[2][2] + salarysum[2][3];
        int totalTab = totalFirst+totalSecond+totalThird;
        double averageTab = (double) totalTab/12;

        String surname = "Фамилия";
        String quarteFirst = "Квартал1";
        String quarterSecond = "Квартал2";
        String quarterThird = "Квартал3";
        String quarterFourth = "Квартал4";
        String total = "Итого";
        String average = "Средняя";

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s", surname, quarteFirst, quarterSecond, quarterThird, quarterFourth, total);
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d", array[0]+":", salarysum[0][0], salarysum[0][1], salarysum[0][2], salarysum[0][3], totalFirst);
        System.out.println();
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d", array[1]+":", salarysum[1][0], salarysum[1][1], salarysum[1][2], salarysum[1][3], totalSecond);
        System.out.println();
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d", array[2]+":", salarysum[2][0], salarysum[2][1], salarysum[2][2], salarysum[2][3], totalThird);
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10d", total, totalTab);
        System.out.println();
        System.out.printf("%-10s%-10.4f", average, averageTab);
    }
}



