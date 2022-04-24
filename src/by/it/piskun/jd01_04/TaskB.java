package by.it.piskun.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] names = new String[]{"Иванов", "Петров", "Сидоров"};
        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }
        String line = scanner.nextLine();
        int[][] array = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+names[i]);
            for (int j = 0; j < 4; j++) {
                array[i][j] = scanner.nextInt();
            }

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Цвартал3  Квартал4  Итого");
        for (int i=0; i<n;i++){
                      System.out.println(names[i]+":       "+array[i][0]+"    "+array[i][1]+"    "+array[i][2]+"       "+ array[i][3]+"     "+(array[i][0]+array[i][1]+array[i][2]+array[i][3]));
            System.out.printf("%d",names[i]);
        }
    }
}