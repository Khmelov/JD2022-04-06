package by.it.smirnov.jd01_04;

import java.util.Arrays;

public class TaskC {

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int indexFirst = binarySearch(array, first);
        int indexLast = binarySearch(array, last);
        System.out.printf("Index of first element=%d%nIndex of last element=%d", indexFirst, indexLast);
    }

    public static void main(String[] args) {
        String line = InOut.scan();
        buildOneDimArray(line);
    }

    static void mergeSort(double[] array) {
        int arrLen = 1;
        while (arrLen < array.length) { //цикл увеличения длин подмассивов
            int startLeft = 0;
            while (true) { //цикл прогона подмассивов по длине массива
                int lengthL = arrLen;
                int lengthR;
                if((array.length - startLeft) > lengthL && (array.length - startLeft) < lengthL * 2) {
                    lengthR = array.length - startLeft - lengthL;
                }
                else if ((array.length - startLeft) <= lengthL) break;
                else {
                    lengthR = lengthL;
                }
                double[] arrLeft = new double[lengthL];
                double[] arrRight = new double[lengthR];
                int startRight = startLeft + arrLeft.length;
                //копирование
                arrLeft = copier(array, arrLeft, startLeft);
                arrRight = copier(array, arrRight, startRight);
                //сортировка
                array = sorter(array, arrLeft, arrRight, startLeft);
                //сдвигаем обработку дальше
                startLeft = startLeft + arrLeft.length + arrRight.length;
            }
            arrLen = arrLen * 2;
        }
    }

    private static double[] sorter(double[] array, double[] arrLeft, double[] arrRight, int startLeft) {
        int i = 0;
        int j = 0;
        int k = startLeft;
        while (i < arrLeft.length && j < arrRight.length) {
            if(arrLeft[i] <= arrRight[j]) {
                array[k] = arrLeft[i];
                i++;
            }
            else {
                array[k] = arrRight[j];
                j++;
            }
            k++;
        }
        while (i < arrLeft.length) {
            array[k] = arrLeft[i];
            i++;
            k++;
        }
        while (j < arrRight.length) {
            array[k] = arrRight[j];
            j++;
            k++;
        }
        return array;
    }

    private static double[] copier(double[] array, double[] subArray, int start) {
        double[] newSub = Arrays.copyOfRange(array, start, start + subArray.length);
        return newSub;
    }

    static int binarySearch(double[] array, double value) {
        int lengthMain = array.length;
        int lengthX = lengthMain;
        int mid = lengthX / 2;
        int start = 0;
        while (array[mid] != value) {
            if (array[mid] == value) return mid;
            else if (array[mid] > value) {
                start = start;
                lengthX = lengthX - (mid - start) - 1;
                mid = start + (lengthX / 2);
            } else {
                start = mid + 1;
                lengthX = lengthMain - start;
                mid = start + (lengthX / 2);
            }
        }
        return mid;
    }
}
