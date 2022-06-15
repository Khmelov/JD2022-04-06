package by.it.korennaya.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException exception) {
            showDetails(exception);
        }
    }

    static void showDetails(RuntimeException exception) {
        Class<? extends RuntimeException> exceptionClass = exception.getClass();
        String exceptionClassName = exceptionClass.getName();
        Class<TaskA> currentClass = TaskA.class;
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
