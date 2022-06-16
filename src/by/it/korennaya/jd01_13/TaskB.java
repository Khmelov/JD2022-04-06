package by.it.korennaya.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        double sum = 0;
        try {
            while (true) {
                String inputLine = scanner.next();
                if (inputLine.equals("END")) {
                    break;
                } else {
                    list.add(inputLine);
                }
            }

            for (String element : list) {
                double number = Double.parseDouble(element);
                sum += number;
                if (sum < 0) {
                    throw new ArithmeticException();
                } else {
                    System.out.println(number + "  " + Math.sqrt(sum));
                }
            }
        } catch (ArithmeticException | NullPointerException | NumberFormatException e) {
            TaskB.showDetails(e);
        }
    }

    static void showDetails(RuntimeException exception) {
        Class<? extends RuntimeException> exceptionClass = exception.getClass();
        String exceptionClassName = exceptionClass.getName();
        Class<TaskB> currentClass = TaskB.class;
        System.out.printf(" name: %s\n", exceptionClassName);

        StackTraceElement[] exceptionStackTrace = exception.getStackTrace();

        for (StackTraceElement element : exceptionStackTrace) {
            String elementClassName = element.getClassName();
            if (elementClassName.equals(currentClass.getName())) {
                int lineNumber = element.getLineNumber();
                System.out.printf("class: %s\n", currentClass.getName());
                System.out.printf(" line: %d\n", lineNumber);
                break;
            }
        }
    }
}
