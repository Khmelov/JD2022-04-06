package by.it._examples_.jd01_04;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo {
    public static void main(String[] args) {
        Integer[] array = {1, 8, 3, 6, 5, 4, 7, 2, 9, 0};
        Arrays.sort(array); //сортировка объектов
        System.out.printf(">>>: %s\n", Arrays.toString(array));
        Arrays.sort(array, Comparator.reverseOrder()); //обратная сортировка
        System.out.printf("<<<: %s\n", Arrays.toString(array));

        int[] array2 = {10, 80, 30, 60, 50, 40, 70, 20, 90, 0};
        Arrays.sort(array2); //сортировка примитивов
        System.out.printf("int: %s\n", Arrays.toString(array2));
        int key = 30;
        int index = Arrays.binarySearch(array2, key); //двоичный поиск
        System.out.printf("index of (%d) = %d\n", key, index);

        int[][] m2d = {{1, 2, 3, 4}, {5, 6, 7}};
        System.out.printf("2D: %s\n", Arrays.deepToString(m2d));
    }
}
