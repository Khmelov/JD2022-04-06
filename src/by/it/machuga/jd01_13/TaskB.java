package by.it.machuga.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static final String END = "end";
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            String text = scanner.next();
            if (text.equalsIgnoreCase(END)) {
                break;
            }
            try {
                double number = Double.parseDouble(text);
                sum += number;
                Double sqrt = Math.sqrt(sum);
                if (sqrt.equals(Double.NaN)) {
                    throw new ArithmeticException("Cannot calculate sqrt from : " + sum);
                }
                System.out.println(number + " -> " + sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                TaskA.printException(TaskB.class, e);
            }
        }
    }
}
