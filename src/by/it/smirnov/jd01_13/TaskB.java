package by.it.smirnov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        ArrayList<Double> numberList = new ArrayList<>();

        try {
            numberList = fillByScanner();
        } catch (NumberFormatException | NullPointerException e) {
            print(e);
        }
        Double sum = 0.0;

        try {
            for (Double number : numberList) {
                System.out.println(number);
                sum += number;
                if (Double.isNaN(Math.sqrt(sum))) {
                    throw new ArithmeticException();
                }
                System.out.println(Math.sqrt(sum));
            }
        } catch (ArithmeticException e) {
            print(e);
        }
    }

    private static ArrayList<Double> fillByScanner() {
        ArrayList<Double> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("END")) break;
            numberList.add(Double.parseDouble(line.trim()));
        }
        return numberList;
    }

    static void print(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskB> currentClass = TaskB.class;
        String name = exceptionClass.getName();
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        for (StackTraceElement element : stackTraceElement) {
            String className = element.getClassName();
            if (className.equals(currentClass.getName())) {
                int lineNumb = element.getLineNumber();
                System.out.printf("""
                         name: %s
                        class: %s
                         line: %d
                         """, name, className, lineNumb);
                break;
            }
        }
    }
}
