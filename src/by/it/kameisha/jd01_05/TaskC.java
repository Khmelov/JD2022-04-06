package by.it.kameisha.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        Random random = new Random();
        int length = random.nextInt(20,31);
        double[] array =  new double[length];
        System.out.println("Массив A[]");
        double randomDouble;
        for (int i = 0; i < array.length ; i++) {
           randomDouble=0;
           while (randomDouble<5.33 || randomDouble>9) {
               randomDouble = random.nextDouble(5.33, 9.01);
           }
           array[i] = cbrt(pow(randomDouble,2)+4.5);
           System.out.printf("%1c[ %-2d] = %8.5f    ",'A',i,array[i]);
           if((i+1)%5==0 || (i+1)==array.length){
               System.out.println();
           }
       }
        System.out.println();
       int count = 0;
       boolean[] elementsDelete = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 3.5){
                elementsDelete[i] = false;
                count++;
            } else {
                elementsDelete[i] = true;
            }
        }
        double[] newArray = new double[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if(elementsDelete[i]==false){
                newArray[count] = array[i];
                count++;
            }
        }
        double temporary = 0;
        double result;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < newArray.length; i++) {
            temporary = temporary + newArray[i];
            System.out.printf("%1c[ %-2d] = %8.5f    ",'B',i,newArray[i]);
            if(i+1== newArray.length || (i+1)%5==0){
                System.out.println();
            }
        }
        result = pow(temporary,1.0/newArray.length);
        System.out.println(result);
    }

}
