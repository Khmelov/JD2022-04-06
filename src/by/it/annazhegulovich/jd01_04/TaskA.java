package by.it.annazhegulovich.jd01_04;

import java.util.Scanner;

public class TaskA {
    private static String line;
    private static double[] array;

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }
    static void printMulTable(){
        for (int i = 2; i <=9 ; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
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
        double stop = array[array.length-1];

//выводит в 5 колонок этот массив с названием V и индексами
//например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-6.3f ","V",i,array[i]);
            if (array.length-1==i || (i+1)%5==0){
                System.out.println();
            }
        }
// сортирует этот массив по возрастанию
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
            System.out.printf("%s[% -3d]=%-6.3f ","V",i,array[i]);
            if (array.length-1==i || (i+1)%4==0){
                System.out.println();
            }
        }

// выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
//исходного массива и печатает их в виде:
//Index of first element=2
//Index of last element=7
        for (int i = 0; i < array.length; i++) {
            if (array[i]==start){
                System.out.println("Index of first element="+i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==stop){
                System.out.println("Index of last element="+i);
            break;
            }
        }
    }
    
}

