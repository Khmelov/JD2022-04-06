package by.it.arsenihlaz.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(getWeight(i));
    }
    static double getWeight(int weight){
        int y = 0;
        double j = (weight / 9.81 * 3.86*100) % 1;
        if (j >= 0.5){
            y = (int) ((weight / 9.81) * 3.86 * 100) + 1;
        } else {
            y = (int) ((weight / 9.81) * 3.86 * 100);
        }
        double x = (double) y / 100;
        return x;
       // double x = Math.pow(10,2);
       // return Math.round((weight / 9.81) * 3.86 * x) / x;
    }
}
