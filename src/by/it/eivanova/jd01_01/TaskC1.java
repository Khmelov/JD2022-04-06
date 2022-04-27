package by.it.eivanova.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
import java.util.Scanner;

import static java.lang.Integer.sum;

class TaskC1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            //int i = scanner.nextInt();
            System.out.println();
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = a + b;
            System.out.println("Sum" + " " + "=" + " " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}