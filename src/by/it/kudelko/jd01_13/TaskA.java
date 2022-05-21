package by.it.kudelko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                //noinspection ConstantConditions
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            showDetails(e);
        }
    }

    static void showDetails(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskA> currentClass = TaskA.class;
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(currentClass.getName())) {
                int numberElement = element.getLineNumber();
                System.out.printf(" name: %s%nclass: %s%n line: %d", exceptionName, className, numberElement);
                break;
            }
        }
    }
}

