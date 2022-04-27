package by.it.kadulin.jd01_02;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                Arrays.fill(arr[i], i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        int[][] res = arr;
        int[][] res2 = res;
        for (int i = 0; i < res2.length; i++) {
            for (int j = 0; j < res2[i].length; j++) {
                System.out.print(res2[i][j]);
            }
            System.out.println();
        }
    }
}
