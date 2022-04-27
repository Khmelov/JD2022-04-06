package by.it.eivanova.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {


    private static boolean[] array;

    public static void main(String[] args) {

        step1();
        step2();

    }



    private static void step2() {
        int[] A = new int[31];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.round((Math.random() * 450) - 103);
            System.out.println(A[i]);


            for (int j = 0; j < A.length; j++) {
                int[] B = new int[j];
                if (A[i] * 0.1 > i)
                    Arrays.sort(B);
                String str = Arrays.toString(B);
                System.out.println(B[i]);
            }
        }
    }






    private static void step1() {

        // k - количество элементов массива
        int[] k = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};

        //step - шаг = (9 -5.33)/k = 3.67/k
        double[] step = {3.67 / 20, 3.67 / 21, 3.67 / 22, 3.67 / 23, 3.67 / 24, 3.67 / 25, 3.67 / 26, 3.67 / 27, 3.67 / 28, 3.67 / 29, 3.67 / 30, 3.67 / 31, 3.67 / 32, 3.67 / 33, 3.67 / 34, 3.67 / 35, 3.67 / 36, 3.67 / 37, 3.67 / 38, 3.67 / 39, 3.67 / 40};

        double start = 5.33;
        double stop = 9.0;

        for (double x = start; x <= stop; x += 3.67 / 20) {
            double z = cbrt(x * x + 4.5);
            System.out.println(z);
        }

        //for (int i = 1; i < array.length; i++) {
            // array[i] > 3.5;
          //  System.out.println(array[i]);
        //

       // for (int i = 0; i < array.length; i++) {
         //   double gm;*=array[i];

           // gm = Math.pow(gm, 1.0 / (double) array.length);

            //System.out.println(gm);
        //}
    }
}
