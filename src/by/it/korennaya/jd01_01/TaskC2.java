package by.it.korennaya.jd01_01;

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
import java.util.Scanner;
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int s=a+b;
        String a1=Integer.toBinaryString(a);
        String b1=Integer.toBinaryString(b);
        String s1=Integer.toBinaryString(s);

        String a2=Integer.toHexString(a);
        String b2=Integer.toHexString(b);
        String s2=Integer.toHexString(s);

        String a3=Integer.toOctalString(a);
        String b3=Integer.toOctalString(b);
        String s3=Integer.toOctalString(s);

        System.out.println("DEC:"+a+"+"+b+ "="+s);
        System.out.println("BIN:"+a1+"+"+b1+ "="+s1);
        System.out.println("HEX:"+a2+"+"+b2+ "="+s2);
        System.out.println("OCT:"+a3+"+"+b3+ "="+s3);

    }
}

