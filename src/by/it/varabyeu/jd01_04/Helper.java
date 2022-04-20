package by.it.varabyeu.jd01_04;

import java.util.Arrays;

public class Helper {
    static void sort(double[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j + 1] < array[i]) {
                    double temp = array[i];
                    array[i] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}