package by.it.smirnov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        int n = keybd.nextInt();
        String[] lastNames = new String[n];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = keybd.next();
        }
        int[][] salary = new int[n][5];
        for (int i = 0; i < lastNames.length; i++) {
            System.out.printf("Введите зарплату для %s%n", lastNames[i]);
            //String salaryPerson = keybd.next();
            //System.out.println(salaryPerson);
            //Scanner line = new Scanner(salaryPerson);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = keybd.nextInt();
            }
            salary[i][4] = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
        }
        int total = total(salary);
        double average = (1.0*total) / (4*n);
        print(salary, lastNames, total, average);
    }

    static int total(int[][] lastColmn) {
        int total = 0;
        for (int[] ints : lastColmn) {
            total = ints[lastColmn[0].length - 1] + total;
        }
        return total;
    }

    static void print(int[][] array, String[] vector, int total, double ave) {
        System.out.println("-".repeat(53));
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("-".repeat(53));
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%7s: %-10d%-10d%-10d%-10d%-5d%n", vector[i], array[i][0], array[i][1], array[i][2], array[i][3], array[i][4]);
        }
        System.out.println("-".repeat(53));
        System.out.printf("Итого    %-9d%nСредняя  %-9.4f", total, ave);
    }
}
