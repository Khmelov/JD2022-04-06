package by.it.penkrat.jd01_01;

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

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("DEC:"+x+"+"+y+"="+ (x+y));
        System.out.println("BIN:"+ Integer.toBinaryString(x) + "+" + Integer.toBinaryString(y)+"="+ Integer.toBinaryString(x+y));
        System.out.println("HEX:"+ Integer.toHexString(x) + "+" + Integer.toHexString(y)+"="+ Integer.toHexString(x+y));
        System.out.println("OCT:"+ Integer.toOctalString(x) + "+" + Integer.toOctalString(y)+"="+ Integer.toOctalString(x+y));



    }


}
