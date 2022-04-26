package by.it.kudelko.jd01_05;

import java.util.function.DoubleToIntFunction;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double numArr = random() * 20 + 20;
        numArr = round(numArr);
        int number = (int) numArr;
        System.out.println(number);
        int i = 0;
        double[] array = new double[number];
        double step = (9 - 5.33) / (number-1);
        do {
            for (double j = 5.33; j <= 9; j = j + step) {
                double z = cbrt(pow(j, 2) + 4.5);
                array[i] = z;
                i++;
            }
        } while (i != array.length);
        for (int k = 0; k < array.length; k++) {
            System.out.println(k+"    "+array[k]);
        }
    }
}
