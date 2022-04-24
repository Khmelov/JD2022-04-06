package by.it.marchenko.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int sum = a + b;
        System.out.printf("DEC:%d+%d=%d\n", a, b, sum);
        System.out.printf("BIN:%s+%s=%s\n", Integer.toBinaryString(a), Integer.toBinaryString(b), Integer.toBinaryString(sum));
        System.out.printf("HEX:%h+%h=%h\n", a, b, sum);
        System.out.printf("OCT:%o+%o=%o\n", a, b, sum);
    }
}
