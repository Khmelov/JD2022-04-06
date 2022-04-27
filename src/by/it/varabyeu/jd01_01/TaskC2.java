package by.it.varabyeu.jd01_01;

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

        Scanner number = new Scanner(System.in);
        int first = number.nextInt();
        int second = number.nextInt();
        System.out.println("DEC:" + first + "+" + second + "=" + (first + second));

        System.out.println("BIN:" + Integer.toBinaryString(first) + "+" + Integer.toBinaryString(second)
                + "=" + Integer.toBinaryString(first + second));

        System.out.println("HEX:" + Integer.toHexString(first) + "+" + Integer.toHexString(second)
                + "=" + Integer.toHexString(first + second));

        System.out.println("OCT:" + Integer.toOctalString(first) + "+" + Integer.toOctalString(second)
                + "=" + Integer.toOctalString(first + second));
    }
}
