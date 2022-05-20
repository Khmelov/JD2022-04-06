package by.it.kadulin.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String consoleInput = "";
        double sum = 0;
        while (true) {
            try {
                consoleInput = sc.next();
                if (consoleInput.equals("END")) {
                    break;
                }
                Double input = Double.parseDouble(consoleInput);
                System.out.println(input);
                sum = sum + input;
                double sqrt = Math.sqrt(sum);
                System.out.println(sqrt);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();
                }
            } catch (NumberFormatException e) {
                exceptionProcessing(e);
                break;
            } catch (ArithmeticException e) {
                exceptionProcessing(e);
                break;
            }
        }
    }

    static void exceptionProcessing(RuntimeException e)  {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskB> currentClass = TaskB.class;
        StackTraceElement[] stackTrace = e.getStackTrace();
        String name = exceptionClass.getName();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String exceptionName = stackTraceElement.getClassName();
            if (exceptionName.equals(currentClass.getName())) {
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("""
                         name: %s
                        class: %s
                         line: %s
                        """,
                        name,
                        exceptionName,
                        lineNumber);
                break;
            }
        }
    }
}
