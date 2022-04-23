package by.it.korennaya.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        String[] employee = new String[n];
        for (int i = 0; i < employee.length; i++) {
            employee[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Введите зарплату для сотрудника %s%n",employee[i]);
            for (int j=0; j<4;j++){
                salary[i][j]= scanner.nextInt();
            }
        }
        System.out.printf("%-9s%-9s%-9s%-9s%-9s%-5s%n", "Фамилия",  "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("__________________________________________________");
        int totalSalaryAll =0;
        for (int i = 0; i < n; i++) {
            int totalSalaryEmployee =0;

            System.out.printf("%8s:", employee [i]);
            for (int j = 0; j <4 ; j++) {
                System.out.printf("%-9d", salary[i][j]);
                totalSalaryEmployee = totalSalaryEmployee + salary[i][j];
            }
           System.out.printf("%-5d%n", totalSalaryEmployee);
           totalSalaryAll=totalSalaryAll + totalSalaryEmployee;
        }
        System.out.println("__________________________________________________");
        System.out.printf("%-9s%-10d%n", "Итого",totalSalaryAll);
        double averageSalary= (double) totalSalaryAll/(4*n);
        System.out.printf("%-9s%-20.4f%n", "Средняя",averageSalary);
    }
}
