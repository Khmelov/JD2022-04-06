package by.it.edeborg.jd01_05;

import java.util.Random;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {public static void main(String[] args) {
    step1();
}

    private static void step1() {
        Random randomX = new Random();
        int length = randomX.nextInt(20, 41);
        double[] array = new double[length];
        System.out.println("Массив A[]");
        int count = 0;
        for (double i = 5.33; i <= 9.0; i += (9 - 5.33) / (length - 1)) {
            array[count] = cbrt(pow(i, 2) + 4.5);
            printArray('A', count, array);
            count++;
        }
        System.out.println();
        count = 0;
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
        double result = 0;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < newArray.length; i++) {
            result = result + newArray[i];
            printArray('B', i, newArray);
        }
        result = pow(result, 1.0 / newArray.length);
        System.out.printf("Среднее геометрическое массива B = %-8.5f%n", result);
    }

    private static void printArray(char A, int i, double[] array) {
        System.out.printf("%1c[ %-2d] =%8.5f    ", A, i, array[i]);
        if (i + 1 == array.length || (i + 1) % 5 == 0) {
            System.out.println();
        }
    }
}
