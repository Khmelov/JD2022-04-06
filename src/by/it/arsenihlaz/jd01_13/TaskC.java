package by.it.arsenihlaz.jd01_13;


import java.util.*;

public class TaskC {
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }

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
