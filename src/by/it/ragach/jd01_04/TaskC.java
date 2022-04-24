package by.it.ragach.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);


    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        mergeSort(array);
    }

    static void mergeSort(double[] array) {
        int n = array.length;
        if (n < 2) return;
        int mid = n / 2;
        double[] l = new double[mid];
        double[] r = new double[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
            for (i = mid; i < n; i++) {
                r[i - mid] = array[i];
            }

        }
        mergeSort(l);
        mergeSort(r);
        merge(array, l, r);


    }

    private static void merge(double[] array, double[] l, double[] r) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<r.length&&j<r.length){
            if (l[i]<r[j]){
                array[k]=l[i];
                i++;

            }

            else {
            array[k]=r[j];
            j++;
            }
            k++;}

        for (int ll = i; ll < l.length ; ll++) {
            array[k++]=l[ll];

            for (int rr = j; rr <r.length ; rr++) {
                array[k++]=r[rr];
            }
            
        }

        }

   }
   


