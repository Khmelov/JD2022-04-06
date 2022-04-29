package by.it.ragach.jd01_05;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {

        double start = 5.33;
        double stop = 9.0;
        int count = (int) (Math.random()*(40-20)+1) + 20;
        double step = (stop - start) / (count-1);


        double[] array = new double[count];
        int i = 0;
        int rate = 0;
        System.out.println("Массив A[]");
        for (double x = start; x <= stop; x = x + step) {
            array[i] = cbrt(pow(x,2) + 4.5);
            System.out.printf("А[%2d}=%8.5f", i, array[i]);
                if (array[i]>3.5){
                rate++;
                }
                 i++;
                if (i%5 == 0) {
                System.out.println();
            }

        }

        double [] array2 = new double [rate];
        i = 0;
        System.out.println("Массив B[] из элементов > 3.5");
        for (double element : array) {
            if (element>3.5){
                array2[i] = element;
                i++;
                }
            }
            double value = 1.0;
            double average;
            for (double element : array2) {
            value =value* element;
        }
        average = pow(value,1.0/array2.length);
        System.out.println("Среднее геометрическое =" + average);
    }
}






















































