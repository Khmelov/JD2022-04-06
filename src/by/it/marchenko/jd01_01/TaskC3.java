package by.it.marchenko.jd01_01;

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
        Scanner console = new Scanner(System.in);
        int weight = console.nextInt();                         // get mass
        System.out.println(getWeight(weight));                  // calculate and print weight
    }
    // calculate weight on other planet
    public static double getWeight(int weight) {
        final float EARTH_G = 9.81f;                            // g on Earth
        final float MARS_G = 3.86f;                             // g on Mars
        // calculate weight in mN
        int marsWeight_mN = weight * (int)(MARS_G * 100) * 1000 / (int)(EARTH_G * 100);
        // rounding to 0.01
        return marsWeight_mN / 10 / 100.0 + marsWeight_mN % 10 / 5 / 100.0;
    }
}
