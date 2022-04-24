package by.it.selvanovich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        System.out.println();
        step2(step1(n));
    }

    private static int[ ][ ] step1(int n){
        int [ ][ ] arr = new int[n][n];
        for (int min = 0; min != -n;) {
            for (int max = 0; max != n;) {
                for (int x = 0; x < arr.length; x++) {
                    for (int y = 0; y < arr.length; y++) {
                        int random = (int) (Math.random() * ((n - (-n)) + 1)) + (-n);
                        arr[x][y] = random;
                        if (min > arr[x][y]) {min = arr[x][y];}
                        if (max < arr[x][y]) {max = arr[x][y];}
                    }
                }
            }
        }
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
        return arr;
    }

    private static int step2(int[ ][ ] arr){
        int sumFin=0;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0, sum = 0; y < arr.length; y++) {
                if (arr[x][y] > 0){
                    for (int z = y+1; z < arr.length; z++){
                        if (arr[x][z] >= 0) break;
                        sum = sum + arr[x][z];
                        if (z > arr.length-1) sum = 0;
                    }
                    sumFin = sumFin + sum;
                    break;
                }
            }
        }
        System.out.println(sumFin);
        return sumFin;
    }
    /*private static int[ ][ ] step3(int[ ][ ] arr){
        int max = 0, indexX = 0, indexY = 0;

        int array[][] = arr;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++) {
                System.out.print(arr[x][y] + " ");
                if (max < array[x][y]) {max = array[x][y];}
            }
            System.out.println();
        }
        System.out.println();
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++) {
                if (max == array[x][y]) {
                    array[x][y] = 0;
                    indexX = x;
                    indexY = y;
                }
                for (int i = 0; i < arr.length; x++) {
                    arr[i][indexY] = 0;
                }
                for (int k = 0; k < arr.length; x++) {
                    arr[indexX][k] = 0;
                }
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }

        return arr;
    }*/
}
