package by.it.kameisha.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        double[] array = getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length-1];
        printArray(array,"V",5);
        sortArray(array);
        printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if(array[i]==firstElement){
                System.out.println("Index of first element="+i);
                break;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]==lastElement) {
                System.out.println("Index of last element="+i);
                break;
            }
        }
    }

    private static double[] getArray(String line) {
        String trimLine = line.trim();
        String[] strings = trimLine.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    private static void printArray(double[] array,String name, int columnCount) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%s[% -3d]=%-10.3f",name, i, array[i]);
            if (i == array.length - 1 || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    private static void sortArray(double[]array){
        for (int i = 0; i < array.length; i++) {
           double minElement = array[i];
           int minElementIndex = i;
            for (int j = i; j < array.length; j++) {
                if (minElement>array[j]){
                    minElement= array[j];
                    minElementIndex = j;
                }
            }
            if(i!=minElementIndex){
                double temporary = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temporary;
            }
        }
    }
}
