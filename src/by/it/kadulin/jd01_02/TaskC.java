package by.it.kadulin.jd01_02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int[][] arr = step1(sc.nextInt());
        System.out.println(step2(arr));
        int[][] resOfStep3 = step3(arr);
        for (int i = 0; i < resOfStep3.length; i++) {
            for (int j = 0; j < resOfStep3[i].length; j++) {
                System.out.print(resOfStep3[i][j] + " ");
            }
            System.out.println();
        }
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

    static int[][] step3(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        boolean[] colmn = new boolean[arr.length];
        Arrays.fill(colmn, true);
        boolean[] rows = new boolean[arr.length];
        Arrays.fill(rows, true);
//        boolean[][] arrayOfBool = new boolean[arr.length][arr.length];
//        for (int i = 0; i < arrayOfBool.length; i++) {
//            for (int j = 0; j < arrayOfBool[i].length; j++) {
//                arrayOfBool[i][j] = true;
//            }
//        }
        System.out.println("check rows and col");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    colmn[j] = false;
                    rows[i] = false;
//                    for (int k = 0; k < arrayOfBool.length; k++) {
//                        arrayOfBool[k][j] = false;
//                    }
//                    for (int k = 0; k < arrayOfBool.length; k++) {
//                        arrayOfBool[i][k] = false;
//                    }
                }
            }
        }
//        for (int i = 0; i < arrayOfBool.length; i++) {
//            for (int j = 0; j < arrayOfBool[i].length; j++) {
//                if (arrayOfBool[i][j]) {
//                    System.out.print("1 ");
//                }
//                if (!arrayOfBool[i][j]) {
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println();
//        }
        int colmnCount = 0;
        int rowsCount = 0;
        for (int i = 0; i < rows.length; i++) {
            System.out.print(rows[i] + " ");
            if (!rows[i]) {
                rowsCount++;
            }
        }
        for (int i = 0; i < colmn.length; i++) {
            if (!colmn[i]) {
                colmnCount++;
            }
            System.out.print(colmn[i] + " ");
        }
        System.out.println();
        System.out.println("!rows " + rowsCount);
        System.out.println("!columns " + colmnCount);

        int[][] resMatrix = new int[arr.length - rowsCount][arr[0].length - colmnCount];
        System.out.println(resMatrix.length);
        System.out.println(resMatrix[0].length);

        int countRowsInLoop = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!rows[i]) {
                continue;
            }
            int countColInLoop = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (!colmn[j]) {
                    continue;
                }
                resMatrix[countRowsInLoop][countColInLoop] = arr[i][j];
                countColInLoop++;
            }
            countRowsInLoop++;
        }
        return resMatrix;
//        ArrayList<Integer> listOfColumns = new ArrayList<>();
//        ArrayList<Integer> listOfRows = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (max == arr[i][j]) {
//                    if (!listOfColumns.contains(j)) {
//                        listOfColumns.add(j);
//                    }
//                    if (!listOfRows.contains(i)) {
//                        listOfRows.add(i);
//                    }
//                }
//            }
//        }
//        System.out.println("col" + listOfColumns.size());
//        System.out.println("rows" + listOfRows.size());
//        int[][] resultMatrix = new int[arr.length - listOfRows.size()][arr[0].length - listOfColumns.size()];
//        int count1 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (listOfRows.contains(i)) {
//                continue;
//            }
//            int count2 = 0;
//            for (int j = 0; j < arr[i].length; j++) {
//                if (listOfColumns.contains(j)) {
//                    continue;
//                }
//                resultMatrix[count1][count2] = arr[i][j];
//                count2++;
//            }
//            count1++;
//        }
//        return resultMatrix;
    }




}
