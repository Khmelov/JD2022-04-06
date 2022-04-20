package by.it._examples_.jd01_05;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2.33)); // выведет 2.33
        System.out.println(Math.round(Math.PI)); // выведет 3
        System.out.println(Math.round(9.5)); // выведет 10
        System.out.println(Math.round(9.5 - 0.001)); // выведет 9
        System.out.println(Math.ceil(9.4)); // выведет 10.0

        double c = Math.sqrt(3 * 3 + 4 * 4);

        System.out.println(c); // выведет гипотенузу треугольника с катетами 3 и 4
        double s1 = Math.cos(Math.toRadians(60));

        System.out.println(s1); // выведет косинус угла в 60 градусов
        System.out.println(Math.random()); // вещественное число из [0;1)
        System.out.println(Math.random() + 3); // вещественное число из  [3;4)
        System.out.println(Math.random() * 5); // вещественное число из  [0;5)
        System.out.println((int) (Math.random() * 5)); // целое число из  [0;4]
        System.out.println(Math.random() * 5 + 3); // вещественное число из  [3;8)
        System.out.println((int) (Math.random() * 5 + 3)); // целое число из   [3;7]
        System.out.println((int) (Math.random() * 11) - 5); // целое число из   [—5;5]
    }
}
