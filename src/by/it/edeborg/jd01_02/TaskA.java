package by.it.edeborg.jd01_02;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int [] arr = new int [10];
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<10; i++){
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);

    }
    static void step1 (int [] array) {
        int min = array[0];
        int max = array[0];
        for (int element: array){
            if (element > max){
                max = element;
            }
            if (element < min){
                min = element;
            }
        }
        System.out.print(min +" "+max);
        System.out.println();
    }

    static void step2(int[] array){
        int sum = 0;
        for (int element: array){
            sum = sum + element;
        }
        double avg =(double) sum / array.length;
        for (int element: array){
            if (element < avg) {
                System.out.print(element+" ");
            }
        }
        System.out.println();
    }

    static void step3(int[] array){
        int min = 0;
        for ( int element: array){
            if (element<min){
                min = element;
            }
        }
        for (int i = 9; i>=0; i--){
            if (array[i]==min){
                System.out.print(i+ " ");
            }
        }
        System.out.println();
    }
}

