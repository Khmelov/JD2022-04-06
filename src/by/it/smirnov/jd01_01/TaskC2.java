package by.it.smirnov.jd01_01;

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
        Scanner keybd = new Scanner(System.in);
        int a = keybd.nextInt();
        int b = keybd.nextInt();
        int sum = a + b;
        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        System.out.println("BIN:" + toBinary(a) + "+" + toBinary(b) + "=" + toBinary(sum));
        System.out.println("HEX:" + toHex(a) + "+" + toHex(b) + "=" + toHex(sum));
        System.out.println("OCT:" + toOctal(a) + "+" + toOctal(b) + "=" + toOctal(sum));
    }

    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        while (decimalNumber != 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

    public static int toOctal(int decimalNumber) {
        int octal = 0;
        for (int i = 0; decimalNumber > 0; i++) {
            octal = octal + (decimalNumber % 8) * (int) Math.pow(10.0, (double) i);
            decimalNumber = decimalNumber / 8;
        }
        return octal;
    }

    public static String toHex(int decimalNumber) {
        String HEX = "0123456789abcdef";
        String newhex = "";
        for (int i = 0; decimalNumber > 0; i++) {
            newhex = HEX.charAt(decimalNumber % 16) + newhex;
            decimalNumber = decimalNumber / 16;
        }
        return newhex;
    }
}