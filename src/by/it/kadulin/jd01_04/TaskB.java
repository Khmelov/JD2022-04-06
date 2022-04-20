package by.it.kadulin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countPeople = sc.nextInt();
        String[] peoples = new String[countPeople];
        for (int i = 0; i < countPeople; i++) {
            peoples[i] = sc.next();
        }
        int[][] array = new int[countPeople][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        printDelimiter(90);
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        printDelimiter(90);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%15s%-15d%-15d%-15d%-15d%-15d", peoples[i] + ":", array[i][0], array[i][1], array[i][2], array[i][3],
                    summary(array, i));
            if (!(i == args.length - 1)) {
                System.out.println();
            }

        }
        printDelimiter(90);
        int allPays = 0;
        for (int i = 0; i < array.length; i++) {
            allPays += summary(array, i);
        }
        System.out.printf("%-15s%-15d\n", "Итого", allPays);
        double averagePays = (double) allPays / (4 * countPeople);
        System.out.printf("%-15s%-15.4f", "Средняя", averagePays);

    }

    static void printDelimiter(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static int summary(int[][] array, int index) {
        return array[index][0]+ array[index][1] + array[index][2] + array[index][3];
    }
}
