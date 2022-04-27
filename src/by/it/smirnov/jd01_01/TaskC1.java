package by.it.smirnov.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);
        int a = keybd.nextInt();
        int b = keybd.nextInt();
        System.out.println("Sum = " + (a + b));
    }




}
