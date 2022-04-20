package by.it.avramchuk.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        buildOneDimArray(sc.nextLine());
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println();

        int indexFirst = binarySearch(array, first);
        int indexLast = binarySearch(array, last);

        System.out.println("Index of first element="+indexFirst);
        System.out.println("Index of last element="+indexLast);

    }

    private static void mergeSort(double[] array) {
        if(array.length>1){
            int left = 0;
            int right = array.length-1;
            int middle = right/2;
            double [] part1 = getPart(array, left, middle);
            double [] part2 = getPart(array, middle+1, right);
            mergeSort(part1);
            mergeSort(part2);
            System.arraycopy(merge(part1, part2), 0, array, 0, array.length);
        }
    }

    private static double[] getPart(double[] array, int left, int right) {
        double[] part = new double[(right-left)+1];
        for (int i = 0; i < part.length; i++) {
            part[i] = array[left];
            left++;
        }
        return part;
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] union = new double[part1.length+ part2.length];
        int pointer1 = 0;
        int pointer2 = 0;
        for (int i = 0; i < union.length; i++) {
            if (pointer2>= part2.length) {
                union[i]=part1[pointer1];
                pointer1++;
            } else if (pointer1<part1.length && part1[pointer1]< part2[pointer2]){
                union[i]= part1[pointer1];
                pointer1++;
            } else {
                union[i] = part2[pointer2];
                pointer2++;
            }
        }
        return union;
    }

    static int binarySearch(double[ ] array, double value){
        int result = -1;
        int left = 0;
        int right = array.length-1;
        int middle = (left+right)/2;
        if (value<=array[right] && value >= array[left]){
            while(right>left){
                if (array[right]==value){
                    result = right;
                    break;
                }
                if (array[left]==value){
                    result = left;
                    break;
                }
                if (array[middle]==value){
                    result = middle;
                    break;
                }
                if (value>array[middle]){
                    left = middle+1;
                    right--;
                }else {
                    right=middle-1;
                    left++;
                }
            }
        }


        return result;
    }
}
