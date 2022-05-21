package by.it.arsenihlaz.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите числа через Enter");
        List<String> stringsOfNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputString = scanner.next();
            if (inputString.equals("END")) {
                break;
            } else {
                stringsOfNumbers.add(inputString);
            }
        }
        double sum = 0;
        for (String stringsOfNumber : stringsOfNumbers) {
            try {
                double numbers = Double.parseDouble(stringsOfNumber);

                sum += numbers;
                System.out.println(numbers);
                double result = Math.sqrt(sum);
                if (Double.isNaN(result)) {
                    throw new ArithmeticException();
                }
                System.out.println(stringsOfNumber);
                System.out.println(result);
            } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                printException(e);
            }
        }

    }

    private static void printException(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskB> currentClass = TaskB.class;
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(currentClass.getName())) {
                int lineNumber = element.getLineNumber();
                System.out.printf("""
                         name: %s
                        class: %s
                         line: %d
                        """, exceptionName, className, lineNumber);
                break;
            }
        }
    }
}
