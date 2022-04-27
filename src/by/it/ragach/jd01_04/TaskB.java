package by.it.ragach.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите число людей");
        int n = scanner.nextInt();
        String[] person = new String[n];// одномерный массив фамилий
        System.out.println("Введите фамилии");
        for (int i = 0; i < person.length; i++) {
            person[i] = scanner.next();

        }
        int[][] salary = new int[n][5];

        for (int i = 0; i < person.length; i++) {
            System.out.println("Введите зарплату для" + " " + person[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
                int sum = 0;

            }

        }
        int[] result = new int[n];
        for (int i = 0; i < person.length; i++) {
            for (int j = 0; j < 4; j++) {
                result[i] = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];

            }
        }

        System.out.println("-".repeat(53));
        System.out.println("Фамилия"+"  "+"Квартал1"+"  "+"Квартал2"+"  "+"Квартал3"+"  "+"Квартал4"+"  "+"Итого");
        System.out.println("-".repeat(53));
        for (int i = 0; i < person.length; i++) {
            System.out.printf("%7s: %-10d%-10d%-10d%-10d%-9d%n", person[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], result[i]);
        }

            System.out.println("-".repeat(53));


            int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < 4; j++) {
                sum=sum+salary[i][j];

            }

        }

        System.out.println("Итого"+"    "+sum);
        double average = (double)sum/4/n;
        System.out.printf("Cредняя  %-9.4f%n",average);


        }


    }



