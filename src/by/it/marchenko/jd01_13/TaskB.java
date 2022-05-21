package by.it.marchenko.jd01_13;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static final String END_INPUT_COMMAND = "END";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedList<String> inputData = getInputData(console);
        printValues(inputData);
    }

    private static LinkedList<String> getInputData(Scanner console) {
        LinkedList<String> lineList = new LinkedList<>();

        String line = console.nextLine();
        while (!line.equals(END_INPUT_COMMAND)) {
            lineList.addLast(line);
            line = console.nextLine();
        }
        return lineList;
    }

    private static void printValues(LinkedList<String> data) {
        LinkedList<String> temp = new LinkedList<>(data);
        double sum = 0;
        while (!temp.isEmpty()) {
            try {
                double value = Double.parseDouble(temp.removeFirst());
                sum += value;
                double sumSqrt = Math.sqrt(sum);
                if (Double.isNaN(sumSqrt)) {
                    throw new ArithmeticException();
                }
                System.out.printf(Locale.ENGLISH, "Value: %10.4f, SumSqrt: %10.4f%n", value, sumSqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                TaskA.processException(e);
            }
        }
    }
}
