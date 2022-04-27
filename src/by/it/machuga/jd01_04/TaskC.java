package by.it.machuga.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String stringLine=scanner.nextLine();
        buildOneDimArray(stringLine);

    }

    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first=array[0];
        double last= array[array.length-1];
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        int indexFirst = binarySearch(array, first);
        System.out.printf("Index of first element=%d%n",indexFirst);
        int indexLast = binarySearch(array, last);
        System.out.printf("Index of last element=%d%n",indexLast);


    }

    private static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value < array[mid]) {
                right = mid - 1;
            } else if (value > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
