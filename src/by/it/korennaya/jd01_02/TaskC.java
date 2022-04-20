package by.it.korennaya.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = step1(n);
    }
    private static int[][] step1 (int n){
        boolean pos = false;
        boolean neg = false;
        int arr[][] = new int[n][n];
        do{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = -n + (int) (Math.random() * 3 * n);
                }
            }
            pos = false;
            neg = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == n) pos = true;
                    if (arr[i][j] == -n) neg = true;
                }
            }
        } while (pos==false || neg==false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr;
    }
}
