package by.it.avramchuk.jd01_05;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {

       step1();

    // level C2
       int[] arrayA = makeArrayA();
       int[] arrayB = makeArrayB(arrayA);
       Arrays.sort(arrayB);
        System.out.println("Массив А:");
       printArray(arrayA, "A");
        System.out.println();
        System.out.println("Массив В:");
       printArray(arrayB, "B");
        System.out.println();
    }

    private static void step1() {
        double start = 5.33;
        double stop = 9.0;
        int n = ((int) (Math.random()*21))+20;
        double step = (stop-start)/(n-1);

        double[] array = new double[n];
        int index =0;
        int counter = 0;
        System.out.println("Массив М:");
        for(double x = start; x<=stop; x= x+step){
            array[index] = Math.cbrt((x*x)+4.5);
            System.out.printf(" M[%2d]=%8.5f", index, array[index]);
            if (array[index]>3.5){
                counter++;
            }
            index++;
            if(index%5==0){
                System.out.println();
            }
        }

        double [] miniArray= new double[counter];
        index = 0;
        for (double element:array){
            if(element>3.5){
                miniArray[index] = element;
                index++;
            }
        }

        double pr = 1.0;
        double average;

        for(double element: miniArray){
            pr = pr*element;
        }
        average = Math.pow(pr, 1.0/miniArray.length);
        System.out.println();
        System.out.println("Average = "+average);

    }

    public static int[] makeArrayA(){

        int [] arrayA = new int[31];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = ((int) (Math.random()*348))+103;

        }
        return arrayA;
    }

    public static int[] makeArrayB(int[] array){
        int counter=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]*0.1>i){
                counter++;
            }
        }
        int[] arrayB = new int[counter];
        counter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]*0.1>i){
                arrayB[counter]= array[i];
                counter++;
            }
        }
        return arrayB;
    }

    public static void printArray(int[] array, String name){
        int rows=0;
        int cols=0;
        int n=5;
        while(n>=2){
            if(array.length%n==0){
                cols=n;
                rows = array.length/n;
                break;
            } else if((array.length+1)%n==0){
                cols= n;
                rows = (array.length+1)/n;
                break;
            }
            n--;
        }
        int rowPoint= 1;
        int colPoint = 0;

        while (colPoint<=cols){
            if(colPoint==0){
                System.out.print("\u2554"+"\u2550".repeat(9));
            }else if(colPoint<cols){
                System.out.print("\u2566"+"\u2550".repeat(9));
            }else{
                System.out.print("\u2557");
            }
            colPoint++;
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            colPoint=0;
            System.out.printf("\u2551%1s[%2d]=%3d",name, i, array[i]);
            if((i+1)%cols==0){
                System.out.println("\u2551");
                if (i!=array.length-1){
                    while (colPoint<=cols){
                        if(colPoint==0){
                            System.out.print("\u2560"+"\u2550".repeat(9));
                        }else if(colPoint<cols){
                            System.out.print("\u256C"+"\u2550".repeat(9));
                        }else{
                            System.out.print("\u2563");
                        }
                        colPoint++;
                    }
                    System.out.println();
                }
            }
            if (i==array.length-1 && array.length<rows*cols){
                System.out.println("\u2551         \u2551");
            }
        }
        colPoint=0;
        while (colPoint<=cols){
            if(colPoint==0){
                System.out.print("\u255A"+"\u2550".repeat(9));
            }else if(colPoint<cols){
                System.out.print("\u2569"+"\u2550".repeat(9));
            }else{
                System.out.print("\u255D");
            }
            colPoint++;
        }
    }
}
