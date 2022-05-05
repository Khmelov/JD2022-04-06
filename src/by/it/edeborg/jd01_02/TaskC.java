package by.it.edeborg.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    int[][] arr = step1(sc.nextInt());
    System.out.println(step2(arr));

        System.out.println();
    }
    static int[][] step1(int x) throws InterruptedException {
        int[][] arrays = new int[x][x];
        int counterForMin = 0;
        int counterForMax = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                int temp = fillMatrix(x);
                if (temp == x) {
                    counterForMax++;
                }
                if (temp == -x) {
                    counterForMin++;
                }
                arrays[i][j] = temp;
                if (i == arrays.length - 1 && j == arrays[i].length - 1 && (counterForMax == 0 || counterForMin == 0)) {
                    i = 0;
                    j = 0;
                    counterForMin = 0;
                    counterForMax = 0;
                }
            }
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }

        return arrays;
    }

    static int fillMatrix(int x) throws InterruptedException {
        int rnd = - x + (int) (Math.random() * (x * 2 + 1));
//        System.out.println(rnd);
//        Thread.sleep(1000);
        return rnd;
    }

    static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    counter++;
                }
                if (arr[i][j] < 0 && counter == 1) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
}
