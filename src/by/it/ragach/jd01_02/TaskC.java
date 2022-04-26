package by.it.ragach.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];


        step1(n);
        step2(array);
        step3(array);




    }

    private static int[][] step1(int n) {
        int min = n;
        int max = -n;
        int y = 0;
        int v = 0;
        int[][] array = new int[n][n];
        do{
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * ((n + 1) - (-(n + 1))) - (n + 1));

                if (min == array[i][j]) {
                    y = 1;
                }
                if (max == array[i][j]) {
                    v = 1;
                }
            }
        }
        } while (v!=1||y!=1);
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                System.out.print(array[k][l] + " ");

            }System.out.println();

        }
        return array;
    }


    private static int step2(int [][] array) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    count++;
                }
            }
            if (count >= 2) ;
            count = 0;
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] > 0) {
                    count++;
                }

                if (count == 1 && array[i][j + 1] < 0) {
                    sum += array[i][j + 1];

                }

            }
        }
        System.out.println(sum);

        return sum;
    }




    private static int[ ][ ] step3(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }


        boolean [] delRows = new boolean[array.length];
        boolean [] delCols =new boolean[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max == array[i][j]){
                    delRows[i]=true;
                    delCols[j]=true;

                }

                
            }
            
        }

        int rows = 0;
        for (boolean delRow : delRows) {
            if (!delRow){
                rows++;
            }
            
        }

        int cols = 0;
        for (boolean delСol : delCols) {
            if (!delСol){
                cols++;
            }


        }
        int [][]result = new int[rows][cols];
        for (int i = 0,iResult=0; i < array.length; i++) {
            if (delRows[i]==false) {
                for (int j = 0, jResult = 0; j < array[i].length; j++) {
                    if (!delCols[j]) {
                        result[iResult][jResult++] = array[i][j];

                    }
                }
                iResult++;
            }
        }
        return result;
    }
}












































