package by.it.annazhegulovich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            buildOneDimArray(line);
        }

        public static void buildOneDimArray(String line) {
//формирует из строки line массив вещественных чисел,
            String[] strings = line.split(" ");
            double[] array = new double[strings.length];

            for (int i = 0; i < strings.length; i++) {
                array[i] = Double.parseDouble(strings[i]);
            }
            System.out.println();

            double start = array[0];
            double stop = array[array.length - 1];

//выводит в 5 колонок этот массив с названием V и индексами
//например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%s[% -3d]=%-6.3f ", "V", i, array[i]);
                if (array.length - 1 == i || (i + 1) % 5 == 0) {
                    System.out.println();
                }
            }
// сортирует этот массив по возрастанию
            //   mergeSort(array);


            //////////////////////старый
            boolean swap;
            double last = array.length - 1;
            do {
                swap = false;
                for (int i = 0; i < last; i++) {
                    if (array[i] > array[i + 1]) {
                        double buffer = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = buffer;
                        swap = true;
                    }
                }
            } while (swap);

// еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%s[% -3d]=%-6.3f ", "V", i, array[i]);
                if (array.length - 1 == i || (i + 1) % 4 == 0) {
                    System.out.println();
                }
            }

            /// бинарный поиск
            binarySearch(array, start);
            System.out.println("Index of first element=" + Arrays.binarySearch(array, start));
            binarySearch2(array, stop);
            System.out.println("Index of last element=" + Arrays.binarySearch(array, stop));
        }

        //  static void mergeSort(double[ ] array) {}

        static int binarySearch(double[] array, double start) {
            int l=1;
            int r=array.length;
            while (l<=r) {
                int m = (l + r) / 2;
                if (array[m] == start) {
                    return m;
                    } else if (array[m] > start) {
                             r = m - 1;
                            }
                                else l = m + 1;
                                return -1;
            }
            return binarySearch(array,start);
        }
        static int binarySearch2(double[] array, double stop) {
            int l=1;
            int r=array.length;
            while (l<=r) {
                int m = (l + r) / 2;
                if (array[m] == stop) {
                    return m;
                } else if (array[m] > stop) {
                        r = m - 1;
                        }
                            else l = m + 1;
                            return -1;
            }
            return binarySearch2(array,stop);
        }
}





