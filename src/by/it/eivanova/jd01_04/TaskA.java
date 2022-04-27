package by.it.eivanova.jd01_04;

import by.it.eivanova.jd01_03.Helper;
import by.it.eivanova.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    private static InOut inOut;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
       printMulTable();
       String line = scanner.nextLine();
       buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
            System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
                    }
        System.out.println();
    }
    }


    private static void buildOneDimArray (String line){
       double [] array =inOut.getArray(line);
       inOut.printArray(array, "V", 5);
       double first = array[0];
       double last = array[array.length-1];
       Helper.sort(array);
       inOut.printArray(array, "V", 4);

      // int indexFirst = Arrays.binarySearch(array.first);
      // System.out.printf("Index of first element=%d%n", indexFirst);


       for (int i = 0; i < array.length; i++) {
            if (array [i] == first){
                System.out.printf("Index of first element=%d%n", i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array [i] == last){
                System.out.printf("Index of last element=%d%n", i);
                break;
            }
        }
    }


}
