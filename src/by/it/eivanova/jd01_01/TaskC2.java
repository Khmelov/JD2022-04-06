package by.it.eivanova.jd01_01;

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
        Scanner scanner = new Scanner(System.in);
        int i= scanner.nextInt();
        System.out.println();
        int a = 34;
        int b = 26;
        int c = a + b;
        System.out.println("DEC" + ":" + a + "+" + b + "=" + c);


        System.out.print("BIN" + ":" + Integer.toBinaryString((int) a) + "+" );
        System.out.print(Integer.toBinaryString((int) b) + "=" );
        System.out.println(Integer.toBinaryString((int) c) );

        System.out.print("HEX" + ":" + Integer.toHexString((int) a) + "+" );
        System.out.print(Integer.toHexString((int) b) + "=" );
        System.out.println(Integer.toHexString((int) c) );

        System.out.print("OCT" + ":" + Integer.toOctalString((int) a) + "+" );
        System.out.print(Integer.toOctalString((int) b) + "=" );
        System.out.println(Integer.toOctalString((int) c) );
    }
}
