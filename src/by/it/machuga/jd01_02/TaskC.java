package by.it.machuga.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] array=step1(n);
        int sum=step2(array);
        System.out.println(sum);
        int[][] newArray=step3(array);
        System.out.println(newArray+" \n");
    }

    private static int[][] step3(int[][] array) {
        int max=max(array);
       int[] row=new int[array.length];
       int[] column=new int[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]==max){
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        int[][] result=new int[count(row)][count(column)];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

            }
        }
        return result;
    }

    private static int count(int[] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return arr.length-sum;
    }

    private static int max(int[][] array) {
        int max=array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max<array[i][j]){
                    max=array[i][j];
                }
            }
        }
        return max;
    }

    private static int step2(int[][] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            int sumRow=0;
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]>=0){
                    count++;
                }
                if (count == 2) {
                    break;
                }
                if(count==1&&arr[i][j]<0){
                    sumRow+=arr[i][j];
                }
            }
            if (count == 2) {
                sum+=sumRow;
            }
        }


        return sum;
    }

    private static int[][] step1(int n) {
        int[][] arr=new int[n][n];
        do {
            fillArray(n, arr);
        }while (!checkArray(arr,n));
        printArray(arr);
        return arr;

    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static boolean checkArray(int[][] arr, int n) {
        boolean hasPositive=false;
        boolean hasNegative=false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]==n){
                    hasPositive=true;
                }
                if (arr[i][j]==-n){
                    hasNegative=true;
                }
            }
        }
        return hasPositive&&hasNegative;
    }

    private static void fillArray(int n, int[][] arr) {
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=random.nextInt(-n, n +1);
            }
        }
    }
}
