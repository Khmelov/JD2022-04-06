package by.it.eivanova.jd01_13;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;


    //  Нужно написать в TaskC программу, которая будет вводить вещественные числа с консоли,
    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        //while (true) {
            readData();
        }

        //  после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в обратном порядке.
    //Код по чтению чисел с клавиатуры должен быть в методе static void readData().
    // Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
    //  исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
    // Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
    // После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.


    static void readData() throws InterruptedException {
        List<Double> numbers = new ArrayList<>();
        int counter = 5;
        while (counter < 6) {
            String inputString = scanner.next();
            try {
                double number = Double.parseDouble(inputString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                counter--;
                Thread.sleep(100);
                for (int i = numbers.size() - 1; i >= 0; i--) {
                    System.out.print(numbers.get(i) + " ");
                }
            }
            if (counter == 0) {
                throw new NumberFormatException();
            }
        }
    }
}
