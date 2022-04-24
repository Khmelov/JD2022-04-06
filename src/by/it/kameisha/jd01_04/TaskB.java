package by.it.kameisha.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество людей");
        int  numberPeople = scanner.nextInt();
        String[] peopleLastName = new String[numberPeople];
        for (int i = 0; i < numberPeople; i++) {
            System.out.println("Введите фамилию");
            peopleLastName[i] = scanner.next();
        }
        int columnCount = 4;
        int[][] salary = new int[numberPeople][columnCount];
        for (int i = 0; i < salary.length ; i++) {
            System.out.println("Введитель зарплату для "+peopleLastName[i]);
            for (int j = 0; j < columnCount; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.println("-".repeat(55));
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-5s","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println();
        System.out.println("-".repeat(55));
        int sum = 0;
        int totalSum = 0;
        int count = 0;
        double averageSum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum = 0;
            System.out.printf("%8s  ",(peopleLastName[i]+":"));
            for (int j = 0; j < salary[i].length; j++) {
                sum = sum + salary[i][j];
                count++;
                System.out.printf("%-10d",salary[i][j]);
            }
            totalSum = totalSum + sum;
            System.out.printf("%-5d",sum);
            System.out.println();
        }
        System.out.println("-".repeat(55));
        System.out.printf("%-10s%-10d","Итого",totalSum);
        System.out.println();
        averageSum = (double) totalSum/count;
        System.out.printf("%-10s%-10.4f","Средняя",averageSum);
        System.out.println();
    }
}
