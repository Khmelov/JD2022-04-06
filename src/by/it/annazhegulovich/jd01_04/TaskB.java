package by.it.annazhegulovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        String [] fio = new String[n];

        for (int i = 0; i < fio.length; i++) {
            fio [i]= sc.next();
        }

        int [][] salary=new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + fio[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j]= sc.nextInt();
            }
        }

        int [] year= new int[n];
        for (int i = 0; i < salary.length; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum=sum+salary[i][j];
            }
        year [i]= sum;
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < fio.length; i++) {
            System.out.printf("%-9s", fio[i]);

            for (int k = i; k < salary.length; k++) {
                for (int j = 0; j < 4; j++) {
                    System.out.printf("%-10s", salary[k][j]);
                }
                for (int c = i; c < year.length; c++) {
                        System.out.printf("%-5s%n", year[c]);
                break;
                }
                break;
            }
            System.out.println("-----------------------------------------------------");
        }

        int sumoll = 0;
        for (int i = 0; i < year.length; i++) {
            sumoll=sumoll+year[i];
        }
        System.out.printf("%-9s%-10s%n", "Итого", sumoll);

        double sumoll2= sumoll;
        double average= sumoll2/(salary.length*salary[0].length);
        System.out.printf("%-9s%-10.6f", "Средняя", average);
    }
}

