package by.it.piskun.jd01_01;

import java.sql.SQLOutput;
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a+b;
        int n ;
        int count=1;
        int summ=0;
                      //Десятичная
        System.out.println("DEC:"+a+"+"+b+"="+c);
        //БинарОчка 3:20 на выполнение Т_Т
        System.out.print("BIN:");
        for (int i = a; i > 0; i=(i/2) ) {
            if ((i%2)!=0){
            n=1;
            }else{
            n=0;
            }
            summ=summ+count*n;
            count=10*count;
            }
        System.out.print(summ+"+");
        summ=0;
        count=1;
        for (int i = b; i > 0; i=(i/2) ) {
            if ((i%2)!=0){
                n=1;
            }else{
                n=0;
            }
            summ=summ+count*n;
            count=10*count;
        }
        System.out.print(summ+"=");
        summ=0;
        count=1;
        for (int i = c; i > 0; i=(i/2) ) {
            if ((i%2)!=0){
                n=1;
            }else{
                n=0;
            }
            summ=summ+count*n;
            count=10*count;
        }
        System.out.print(summ);
    }

}
