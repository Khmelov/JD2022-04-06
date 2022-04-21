package by.it.kameisha.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        Random random = new Random();
        int length = random.nextInt(20, 31);
        double[] array = new double[length];
        System.out.println("Массив A[]");
        double randomDouble;
        for (int i = 0; i < array.length; i++) {
            randomDouble = 0;
            while (randomDouble < 5.33 || randomDouble > 9) {
                randomDouble = random.nextDouble(5.33, 9.01);
            }
            array[i] = cbrt(pow(randomDouble, 2) + 4.5);
            printArray('A',i,array);
        }
        System.out.println();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                count++;
            }
        }
        double[] newArray = new double[count];
        count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > 3.5) {
                newArray[count] = array[j];
                count++;
            }
        }
        double temporary = 0;
        double result;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < newArray.length; i++) {
            temporary = temporary + newArray[i];
            printArray('B',i,newArray);
        }
        result = pow(temporary, 1.0 / newArray.length);
        System.out.println(result);
    }
    private static void printArray (char A, int i , double[] array) {
        System.out.printf("%1c[ %-2d] = %8.5f    ", A, i, array[i]);
        if (i + 1 == array.length || (i + 1) % 5 == 0) {
            System.out.println();
        }
    }
}

