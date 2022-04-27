package by.it.kadulin.jd01_01;

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

    static double getWeight(int x) {
        double m = x / 9.81;
        double p = m * 3.86;
//        int integerM = (int) (m * 100);
//        double p = ((double) (integerM / 100)) * 3.86;
//        double buffer = p * 100;
//        System.out.println(buffer);
//        double weight = (int) buffer;
//        return weight / 100;
//        System.out.println(p);
        double result = ((double) ((int) (p * 100)) / 100);
        if (((int) (p * 1000)) % 10 >= 5) {
//            System.out.println(p % 1000);
            result += 0.01;
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getWeight(scanner.nextInt()));
//        Math.round(getWeight(scanner.nextInt()));
    }

}
