package by.it.selvanovich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    private static final ArrayList<Double> values = new ArrayList();

    public static void main(String[] args) {
        inputConsole();
    }

    public static void inputConsole() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals("END")) {
                outputConsole(value);
            } else {
                values.clear();
                break;
            }
        }
    }

    public static void outputConsole(String value) {
        try {
            int sum = 0;
            values.add(Double.parseDouble(value));
            for (Double element : values) {
                sum += element;
            }
            double result = Math.sqrt(sum);
            System.out.println(result + " " + value);
            if (Double.isNaN(result)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException | NumberFormatException e) {
            Class<TaskB> taskBClass = TaskB.class;
            printExceptionInformation(e, taskBClass);
        }
    }

    public static void printExceptionInformation(RuntimeException e, Class<TaskB> taskClass) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().equals(taskClass.getName())) {
                int lineNumber = element.getLineNumber();
                System.out.printf(" name: %s%n", exceptionName);
                System.out.printf("class: %s%n", taskClass);
                System.out.printf(" line: %d%n", lineNumber);
                break;
            }
        }
    }
}
