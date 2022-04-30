package by.it.edeborg.jd01_01;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

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
    public static void main(String[] args)  {

        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        System.out.print("DEC:");
        System.out.print(i + "+" + j);
        System.out.print("=");
        System.out.println(i+j);
        System.out.print("BIN:");
        System.out.print(Integer.toBinaryString(i) + "+" + Integer.toBinaryString(j));
        System.out.print("=");
        System.out.println(Integer.toBinaryString(i+j));
        System.out.print("HEX:");
        System.out.print(Integer.toHexString(i) + "+" + Integer.toHexString(j));
        System.out.print("=");
        System.out.println(Integer.toHexString(i+j));
        System.out.print("OCT:");
        System.out.print(Integer.toOctalString(i) + "+" + Integer.toOctalString(j));
        System.out.print("=");
        System.out.print(Integer.toOctalString(i+j));




    }


}