package by.it.ragach.jd01_05;

import by.it.ragach.jd01_04.InOut;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();


    }

    private static void step1() {


        double start = 5.33;
        double stop = 9;
        double count = (int) (Math.random() * ((40 - 20) + 1) + 20);
        System.out.println(count);
        double step = (stop - start) / (count - 1);
        System.out.println("Массив A[]");
        double z = 0;
        double [] array = new double[(int) count];


            for (double x = start; x < stop; x += step) {
                z = cbrt(pow(x, 2) + 4.5);
                String name = "А";
                int columcount = 5;
                System.out.println(z);

           }
            
         }
    }



































