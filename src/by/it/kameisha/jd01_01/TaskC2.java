package by.it.kameisha.jd01_01;

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
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = num1+num2;
        System.out.println("DEC:"+num1+"+"+num2+"="+sum);
        String convertNum1 = Integer.toBinaryString(num1);
        String convertNum2 = Integer.toBinaryString(num2);
        String convertSum = Integer.toBinaryString(sum);
        System.out.println("BIN:"+convertNum1+"+"+convertNum2+"="+convertSum);
        convertNum1 = Integer.toHexString(num1);
        convertNum2 = Integer.toHexString(num2);
        convertSum = Integer.toHexString(sum);
        System.out.println("HEX:"+convertNum1+"+"+convertNum2+"="+convertSum);
        convertNum1 = Integer.toOctalString(num1);
        convertNum2 = Integer.toOctalString(num2);
        convertSum = Integer.toOctalString(sum);
        System.out.println("OCT:"+convertNum1+"+"+convertNum2+"="+convertSum);
    }

}
