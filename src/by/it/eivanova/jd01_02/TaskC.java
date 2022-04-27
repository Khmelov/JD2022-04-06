package by.it.eivanova.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        Random random = new Random();
        int min = -n;
        int max = n;
        int x = 0;
        int y = 0;
        do {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[1].length; j++) {
                    arr[i][j] = (int) (Math.random() * ((n + 1) - (-(n - 1))) - (n + 1));
                    if (min == arr[i][j]) {
                        x = 1;
                    }
                    if (max == arr[i][j]) {
                        y = 1;
                    }
                }
            }
        } while (x != 1 || y != 1);
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[1].length; l++) {
                System.out.println(arr[k][l] + " ");
            }
            System.out.println();
        }

        return arr;
    }
        
}


        //  ArrayList<Integer> rows = new ArrayList<Integer>();
        //  ArrayList<Integer> column = new ArrayList<Integer>();

        //     for (int i = 0; i < arr.length; i++) {
        // Случайные числа
        //       arr[i] = random.ints(n, -m, m).toArray();
        // Сразу ищем максимальное
        //      for (int j = 0; j < arr.length; j++) {
        //          if(arr[i][j] > max) {
        //             max = arr[i][j];
        //          }
        //           System.out.print(arr[i][j] + " ");
        //      }
        //      System.out.println();
        // }
        // Поиск колонок и столбцов, которые надо удалить
        //    for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //          if(max == arr[i][j]) {
        //             if(rows.indexOf(j) == -1)
        //                 rows.add(j);
        //             if(column.indexOf(i) == -1)
        //                 column.add(i);
        //        }
        //    }
        // }

        //    System.out.println("\nMax: " + max);

        //  int[][] newArr = new int[n - rows.size()][n - column.size()];
        //    System.out.println("Size: " + (n - rows.size()) + "x" + (n - column.size()));

        // int newArrI = 0;
        // int newArrJ = 0;
        // СЗаполняем новый массив без столбцов и строк с мах числом
        //   for (int i = 0; i < n; i++) {
        //  if(rows.indexOf(i) == -1) {
        //    newArrJ = 0;
        //  for (int j = 0; j < n; j++) {
        //   if(column.indexOf(j) == -1) {
        //      newArr[newArrI][newArrJ]
        //               = arr[j][i];
        //        newArrJ++;
        //     }
        // }
        //    newArrI++;
        //    }
        //  }

        // Печать результатата
        //   for (int i = 0; i < newArr.length; i++) {
        //  for (int j = 0; j < newArr[i].length; j++) {
        //       System.out.println();
        //       System.out.print(newArr[i][j] + " ");
        // }
        //