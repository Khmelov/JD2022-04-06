package by.it.piskun.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        String line =scanner.nextLine();
        buildOneDimArray(line);

            }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for(int j =2; j<10; j++){
                System.out.print(i+"*"+j+"="+(i*j)+" ");
                if ((i*j)<10){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }
    public static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first=array[0];
        double last = array[array.length-1];
        Helper.sort(array);
        InOut.printArray(array,"V",4);
int indexFirst = Arrays.binarySearch(array, first);
        System.out.printf("Index of first element=%d%n",indexFirst);

                    for (int i = 0; i < array.length; i++) {
            if (array[i]==last) {
                System.out.printf("Index of last element=%d%n",i);
                break;

            }
            }

        }

    }
